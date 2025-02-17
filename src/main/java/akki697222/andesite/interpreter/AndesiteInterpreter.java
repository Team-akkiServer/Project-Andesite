package akki697222.andesite.interpreter;

import akki697222.andesite.compiler.AndesiteLexer;
import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.core.base.Function;
import akki697222.andesite.core.base.Variable;
import akki697222.andesite.core.type.primitive.IntegerType;
import akki697222.andesite.core.type.primitive.StringType;
import akki697222.andesite.core.type.primitive.VoidType;
import akki697222.andesite.core.value.Value;
import akki697222.andesite.core.value.primitive.*;
import akki697222.andesite.exceptions.AndesiteExecutionException;
import akki697222.andesite.exceptions.ArithmeticError;
import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import akki697222.andesite.ir.nodes.statements.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AndesiteInterpreter implements Visitor {
    public static Logger logger = LoggerFactory.getLogger("Interpreter");
    private final Program program;
    private final List<Variable> variables = new ArrayList<>();
    private final List<Function> functions = new ArrayList<>();
    public static AndesiteInterpreter instance;
    private Function currentProcessing = null;
    private static AndesiteInterpreter parent = null;
    private Value<?, ?> returns;
    private static AndesiteDebugger debuggerWindow;
    private boolean isLocalScopeMode = false;

    public AndesiteInterpreter(String code) {
        AndesiteLexer lexer = new AndesiteLexer(CharStreams.fromString(code));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        AndesiteParser parser = new AndesiteParser(tokenStream);

        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        AndesiteIRParser irParser = new AndesiteIRParser();

        walker.walk(irParser, tree);
        this.program = irParser.getProgram();
        instance = this;
        debuggerWindow = new AndesiteDebugger();
    }

    public AndesiteInterpreter(Function function, List<Node> nodes) {
        this.program = new Program();
        nodes.forEach(program::addChild);
        currentProcessing = function;
        variables.addAll(instance.getVariables());
        functions.add(function);
        instance = this;
    }

    public AndesiteInterpreter(Block block) {
        this.program = new Program();
        block.getNodes().forEach(program::addChild);
        variables.addAll(instance.getVariables());
        instance = this;
        isLocalScopeMode = true;
    }

    public Value<?, ?> run() {
        functions.add(new Function(new FunctionDeclaration(
                "printDebug",
                AccessModifier.PUBLIC,
                new VoidType(),
                new FunctionParameters(List.of(new FunctionParameter("message", new StringType()))),
                new Block(List.of(new PrintStatement(new IdentifierExpression("message"))))
        )));
        if (isLocalScopeMode) {
            program.accept(this);
            return null;
        } else if (currentProcessing == null) {
            program.accept(this);
            logger.debug("Program: {}", program.getChildren());
            logger.debug("Variables: {}", variables);
            logger.debug("Functions: {}", functions);
            return null;
        } else {
            program.accept(this);
            return returns;
        }
    }

    @Override
    public void visit(Node node) {
        String text = "Variables: " + variables + "\n" +
                "Functions: " + functions + "\n";
        debuggerWindow.update(text);
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
    }

    @Override
    public void visit(Program node) {

    }

    @Override
    public void visit(FunctionDeclaration node) {
        functions.add(new Function(node));
    }

    @Override
    public void visit(VariableDeclaration node) {
        logger.debug("Declarating Variable with name: {}", node.getName());
        if (node.getInitializer() != null) {
            logger.debug("Initalizer is: {}", node.getInitializer().getExpression());
            if (node.getInitializer().getExpression() instanceof LiteralExpression<?> literalExpression) {
                variables.add(new Variable(node.getName(), node.getType(), convertLiteralExpressionToValue(literalExpression)));
            } else {
                variables.add(new Variable(node.getName(), node.getType(), convertExpressionToValue(node.getInitializer().getExpression())));
            }
        } else {
            variables.add(new Variable(node.getName(), node.getType(), null));
        }
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        if (currentProcessing != null) {
            returns = convertExpressionToValue(returnStatement.getExpression());
        } else {
            throw new AndesiteExecutionException("Cannot use return without function block");
        }
    }

    @Override
    public void visit(AssignmentExpression assignmentExpression) {
        Variable var = getSpecifiedVariable(assignmentExpression.getAssignmentTarget().getIdentifier());
        if (var != null) {
            var.setValue(convertExpressionToValue(assignmentExpression.getAssignments()));
        }
    }

    @Override
    public void visit(MethodInvokeExpression methodInvokeExpression) {
        invokeMethod(methodInvokeExpression);
    }

    public Value<?, ?> invokeMethod(MethodInvokeExpression methodInvokeExpression) {
        //logger.debug("Attempting Invoking Method '{}' with arguments {}", methodInvokeExpression.getTarget(), methodInvokeExpression.getArgumentList());
        Function function = getSpecifiedFunction(methodInvokeExpression.getTarget());
        if (function != null) {
            Value<?, ?> result = function.eval(methodInvokeExpression.getArgumentList());
            instance = this;
            return result;
        } else {
            throw new AndesiteExecutionException("Attempt to call undefined function: '" + methodInvokeExpression.getTarget() + "'");
        }
    }

    @Override
    public void visit(PrintStatement printStatement) {
        System.out.println(AndesiteInterpreter.convertExpressionToValue(printStatement.expression));
    }

    @Override
    public void visit(IfStatement ifStatement) {
        if (ifStatement.getExpression() instanceof BinaryOperationExpression binaryOperationExpression) {
            if (evaluate(binaryOperationExpression) instanceof BooleanValue booleanValue && booleanValue.getValue()) {
                ifStatement.getIfBlock().accept(this);
            }
        } else if (ifStatement.getExpression() instanceof BooleanLiteral booleanLiteral) {
            if (booleanLiteral.getValue()) {
                ifStatement.getIfBlock().accept(this);
            }
        } else if (ifStatement.getExpression() instanceof LogicalNegationExpression logicalNegation) {
            if (getVariableAndConvertToPrimitive(logicalNegation.getValue()) instanceof BooleanLiteral booleanLiteral) {
                if (!booleanLiteral.getValue()) {
                    ifStatement.getIfBlock().accept(this);
                }
            } else {
                throw new AndesiteExecutionException("Logical negation cannot be applied to non-Boolean values.");
            }
        }
    }

    @Override
    public void visit(ForStatement forStatement) {
        ForInitializer initializer = forStatement.getInitializer();
        if (initializer.getIterator() instanceof IntegerLiteral integerLiteral) {
            Variable forVar = new Variable(forStatement.getIdentifier().getIdentifier(), new IntegerType(), IntegerValue.valueOf(integerLiteral.getValue()));
            if (initializer.getUntil() != null && getVariableAndConvertToPrimitive(initializer.getUntil()) instanceof IntegerLiteral until) {
                variables.add(forVar);

                for (int i = integerLiteral.getValue(); i < until.getValue(); i++) {
                    forVar.setValue(IntegerValue.valueOf(i));
                    callWithLocalScope(forStatement.getBlock());
                }

                variables.remove(forVar);
            } else if (initializer.getUntil() != null && initializer.getUntil() instanceof BinaryOperationExpression until) {
                variables.add(forVar);

                int i = integerLiteral.getValue();
                while (evaluate(until) instanceof BooleanValue value && value.getValue()) {
                    forVar.setValue(IntegerValue.valueOf(i));
                    callWithLocalScope(forStatement.getBlock());
                    i++;
                }

                variables.remove(forVar);
            }
        }
    }

    @Override
    public void visit(WhileStatement whileStatement) {
        if (whileStatement.getExpression() instanceof BinaryOperationExpression binaryOperationExpression) {
            while (evaluate(binaryOperationExpression) instanceof BooleanLiteral booleanLiteral && booleanLiteral.getValue()) {
                callWithLocalScope(whileStatement.getBlock());
            }
        } else if (whileStatement.getExpression() instanceof BooleanLiteral booleanLiteral) {
            while (booleanLiteral.getValue()) {
                callWithLocalScope(whileStatement.getBlock());
            }
        }
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public static Variable getSpecifiedVariable(String name) {
        for (Variable variable : instance.getVariables()) {
            if (variable.getName().equals(name)) {
                return variable;
            }
        }
        return null;
    }

    public static Function getSpecifiedFunction(String name) {
        for (Function function : instance.getFunctions()) {
            if (function.getData().getName().equals(name)) {
                return function;
            }
        }
        return null;
    }

    public static Value<?, ?> convertLiteralExpressionToValue(LiteralExpression<?> expression) {
        if (expression instanceof IntegerLiteral literal) {
            return new IntegerValue(literal.getValue());
        } else if (expression instanceof StringLiteral literal) {
            return new StringValue(literal.getValue());
        } else if (expression instanceof BooleanLiteral literal) {
            return new BooleanValue(literal.getValue());
        }
        return null;
    }

    public static AndesiteInterpreter getParent() {
        return parent;
    }

    public static Value<?, ?> convertExpressionToValue(Expression expression) {
        if (expression instanceof LiteralExpression<?> literalExpression) return convertLiteralExpressionToValue(literalExpression);
        if (expression instanceof BinaryOperationExpression binaryOperationExpression) {
            Expression right = getVariableAndConvertToPrimitive(binaryOperationExpression.getRight());
            Expression left = getVariableAndConvertToPrimitive(binaryOperationExpression.getLeft());
            BinaryOperationExpression binaryOperationExpression_ = new BinaryOperationExpression(left, right, binaryOperationExpression.getOp());
            if (evaluate(binaryOperationExpression_) != null) return new IntegerValue(evaluate(binaryOperationExpression_) instanceof IntegerValue ? ((IntegerValue) evaluate(binaryOperationExpression_)).getValue() : 0);
            throw new ArithmeticError(String.format(
                    "Incompatible types for operator '%s': %s and %s",
                    binaryOperationExpression.getOp().getOp(),
                    binaryOperationExpression.getLeft().toString(),
                    binaryOperationExpression.getRight().toString()
            ));
        }
        if (expression instanceof MethodInvokeExpression methodInvokeExpression) return instance.invokeMethod(methodInvokeExpression);
        if (expression instanceof IdentifierExpression identifierExpression) {
            Variable var = getSpecifiedVariable(identifierExpression.getIdentifier());
            if (var != null) {
                return var.getValue();
            }
        }
        return null;
    }

    public static Function getInstanceProcessing() {
        return instance.currentProcessing;
    }

    public Function getCurrentProcessing() {
        return currentProcessing;
    }

    public static Expression getVariableAndConvertToPrimitive(Expression expression) {
        if (expression instanceof IdentifierExpression identifierExpression) {
            Variable var = getSpecifiedVariable(identifierExpression.getIdentifier());
            if (var != null) {
                if (var.getValue() instanceof IntegerValue integerValue) {
                    return new IntegerLiteral(integerValue.getValue());
                } else if (var.getValue() instanceof StringValue stringValue) {
                    return new StringLiteral(stringValue.getValue());
                } else if (var.getValue() instanceof BooleanValue booleanValue) {
                    return new BooleanLiteral(booleanValue.getValue());
                }
            }
        } else if (expression instanceof MethodInvokeExpression invokeExpression) {
            Value<?, ?> value = instance.invokeMethod(invokeExpression);
            if (value != null) {
                switch (value) {
                    case IntegerValue integerValue -> {
                        return new IntegerLiteral(integerValue.getValue());
                    }
                    case StringValue stringValue -> {
                        return new StringLiteral(stringValue.getValue());
                    }
                    case BooleanValue booleanValue -> {
                        return new BooleanLiteral(booleanValue.getValue());
                    }
                    default -> {
                    }
                }
            }
        }
        return expression;
    }

    public static Value<?, ?> evaluate(BinaryOperationExpression binaryOperation) {
        Expression processedLeft = getVariableAndConvertToPrimitive(binaryOperation.getLeft());
        Expression processedRight = getVariableAndConvertToPrimitive(binaryOperation.getRight());

        if (!processedLeft.getClass().equals(processedRight.getClass())) {
            throw new RuntimeException("Type mismatch: Cannot compare " +
                    processedLeft.getClass().getSimpleName() + " with " +
                    processedRight.getClass().getSimpleName());
        }

        if (processedLeft instanceof StringLiteral) {
            return evaluateStringComparison((StringLiteral) processedLeft,
                    (StringLiteral) processedRight,
                    binaryOperation.getOp()) ? BooleanValue.valueOf(true) : BooleanValue.valueOf(false);
        }

        if (processedLeft instanceof IntegerLiteral) {
            return evaluateNumberComparison((IntegerLiteral) processedLeft,
                    (IntegerLiteral) processedRight,
                    binaryOperation.getOp());
        }

        throw new RuntimeException("Unsupported type for comparison: " + processedLeft.getClass().getSimpleName());
    }

    private static Boolean evaluateStringComparison(StringLiteral left, StringLiteral right, Operation op) {
        int comparison = left.getValue().compareTo(right.getValue());

        return switch (op) {
            case EQ -> comparison == 0;
            case NE -> comparison != 0;
            case LT -> comparison < 0;
            case GT -> comparison > 0;
            case LTE -> comparison <= 0;
            case GTE -> comparison >= 0;
            default -> throw new RuntimeException("Unsupported operation for strings: " + op);
        };
    }

    private static Value<?, ?> evaluateNumberComparison(IntegerLiteral left, IntegerLiteral right, Operation op) {
        Integer leftValue = left.getValue();
        Integer rightValue = right.getValue();

        return switch (op) {
            case EQ -> BooleanValue.valueOf(leftValue.equals(rightValue));
            case NE -> BooleanValue.valueOf(!leftValue.equals(rightValue));
            case LT -> BooleanValue.valueOf(leftValue < rightValue);
            case GT -> BooleanValue.valueOf(leftValue > rightValue);
            case LTE -> BooleanValue.valueOf(leftValue <= rightValue);
            case GTE -> BooleanValue.valueOf(leftValue >= rightValue);
            case ADD -> IntegerValue.valueOf(leftValue + rightValue);
            case SUB -> IntegerValue.valueOf(leftValue - rightValue);
            case MUL -> IntegerValue.valueOf(leftValue * rightValue);
            case DIV -> IntegerValue.valueOf(leftValue / rightValue);
            case MOD -> IntegerValue.valueOf(leftValue % rightValue);
            default -> throw new RuntimeException("Unsupported operation for numbers: " + op);
        };
    }

    public static Value<?, ?> invoke(Function function, List<Variable> fields) {
        AndesiteInterpreter interpreter = new AndesiteInterpreter(function, function.getData().getMethodBlock().getNodes());
        instance.variables.addAll(fields);
        return interpreter.run();
    }

    public void callWithLocalScope(Block block) {
        new AndesiteInterpreter(block).run();
        //logger.debug(instance.variables.toString());
        instance = this;
    }
}
