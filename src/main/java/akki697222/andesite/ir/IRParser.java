package akki697222.andesite.ir;

import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.compiler.AndesiteParserBaseListener;
import akki697222.andesite.ir.type.Type;
import akki697222.andesite.exceptions.CompileException;
import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import akki697222.andesite.ir.nodes.statements.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IRParser extends AndesiteParserBaseListener {
    private final Program program;

    public IRParser() {
        this.program = new Program();
    }

    @Override
    public void enterProgram(AndesiteParser.ProgramContext ctx) {
        for (AndesiteParser.StatementsContext statement : ctx.statements()) {
            program.addChild(toNode(statement));
        }
    }

    public Block toBlock(List<AndesiteParser.StatementsContext> statementsContexts) {
        List<Node> nodes = new ArrayList<>();

        for (AndesiteParser.StatementsContext statementsContext : statementsContexts) {
            nodes.add(toNode(statementsContext));
        }

        return new Block(nodes);
    }

    public ClassBlock toClassBlock(List<AndesiteParser.VariableDeclarationContext> fields, List<AndesiteParser.FunctionDeclarationContext> methods, List<AndesiteParser.ClassDeclarationContext> classes, List<AndesiteParser.InterfacesDeclarationContext> interfaces) {
        return new ClassBlock(
                fields.stream().map(variableDeclarationContext -> (VariableDeclaration) ruleContextToObjective((variableDeclarationContext))).toList(),
                methods.stream().map(functionDeclarationContext -> (FunctionDeclaration) ruleContextToObjective((functionDeclarationContext))).toList(),
                classes.stream().map(classDeclarationContext -> (ClassDeclaration) ruleContextToObjective((classDeclarationContext))).toList(),
                interfaces.stream().map(interfacesDeclarationContext -> (InterfacesDeclaration) ruleContextToObjective(interfacesDeclarationContext)).toList());
    }

    public Node toNode(AndesiteParser.StatementsContext statementsContext) {
        if (asObjective(statementsContext) != null) return asObjective(statementsContext);
        if (asStatement(statementsContext) != null) return asStatement(statementsContext);
        if (toExpression(statementsContext.expression()) != null) return toExpression(statementsContext.expression());

        throw new RuntimeException("Failed to convert statement '" + statementsContext.getChild(0).getClass().getSimpleName() + "' to node");
    }

    public Node asObjective(AndesiteParser.StatementsContext statementsContext) {
        return ruleContextToObjective(statementsContext.getChild(0));
    }

    private Node ruleContextToObjective(ParseTree ruleContext) {
        if (ruleContext instanceof AndesiteParser.FunctionDeclarationContext functionDeclarationContext) {
            List<FunctionParameter> parameters = new ArrayList<>();
            if (functionDeclarationContext.parameterList() != null) {
                functionDeclarationContext.parameterList().parameter().forEach(parameterContext -> {
                    parameters.add(new FunctionParameter(parameterContext.identifier().getText(), Type.of(parameterContext.types().getText())));
                });
            }
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            if (functionDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(functionDeclarationContext.accessModifier().getText().toUpperCase());
            }
            return new FunctionDeclaration(
                    functionDeclarationContext.identifier().getText(),
                    accessModifier,
                    Type.of(functionDeclarationContext.types().getText()),
                    new FunctionParameters(parameters),
                    toBlock(functionDeclarationContext.block() != null ? functionDeclarationContext.block().statements() : new ArrayList<>()),
                    functionDeclarationContext.functionModifier() != null && functionDeclarationContext.functionModifier().ABSTRACT() != null,
                    functionDeclarationContext.functionModifier() != null && functionDeclarationContext.functionModifier().STATIC() != null
            );
        } else if (ruleContext instanceof AndesiteParser.VariableDeclarationContext variableDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            VariableInitializer initializeWith = null;
            if (variableDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(variableDeclarationContext.accessModifier().getText().toUpperCase());
            }
            if (variableDeclarationContext.variableInitializer() != null) {
                AndesiteParser.ExpressionContext expressionContext = variableDeclarationContext.variableInitializer().expression();
                if (expressionContext != null) {
                    initializeWith = new VariableInitializer(toExpression(expressionContext));
                    if (initializeWith.getExpression() == null) {
                        initializeWith = new VariableInitializer(toExpression(variableDeclarationContext.variableInitializer().expression()));
                    }
                }
            } else {
                initializeWith = VariableInitializer.EMPTY;
            }
            return new VariableDeclaration(
                    variableDeclarationContext.identifier().getText(),
                    Type.of(variableDeclarationContext.types().getText()),
                    initializeWith,
                    accessModifier
            );
        } else if (ruleContext instanceof AndesiteParser.ClassDeclarationContext classDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            ClassBlock block = null;
            if (classDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(classDeclarationContext.accessModifier().getText().toUpperCase());
            }
            IdentifierExpression classExtends = null;
            List<IdentifierExpression> classImplements = new ArrayList<>();
            if (classDeclarationContext.objectiveExtends() != null) {
                classExtends = new IdentifierExpression(classDeclarationContext.objectiveExtends().identifier().getText());
            }
            if (classDeclarationContext.objectiveImplements() != null) {
                classImplements = classDeclarationContext.objectiveImplements().identifier().stream().map(identifierContext -> new IdentifierExpression(identifierContext.getText())).toList();
            }
            if (classDeclarationContext.classBlock() != null) {
                AndesiteParser.ClassBlockContext classBlockContext = classDeclarationContext.classBlock();
                block = toClassBlock(
                        classBlockContext.variableDeclaration(),
                        classBlockContext.functionDeclaration(),
                        classBlockContext.classDeclaration(),
                        classBlockContext.interfacesDeclaration()
                        );
            }
            return new ClassDeclaration(
                    block,
                    classDeclarationContext.identifier().getText(),
                    classDeclarationContext.ABSTRACT() != null,
                    classExtends,
                    classImplements,
                    accessModifier
            );
        } else if (ruleContext instanceof AndesiteParser.InterfacesDeclarationContext interfacesDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            ClassBlock block = null;
            IdentifierExpression classExtends = null;
            if (interfacesDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(interfacesDeclarationContext.accessModifier().getText().toUpperCase());
            }
            if (interfacesDeclarationContext.objectiveExtends() != null) {
                classExtends = new IdentifierExpression(interfacesDeclarationContext.objectiveExtends().identifier().getText());
            }
            if (interfacesDeclarationContext.classBlock() != null) {
                AndesiteParser.ClassBlockContext classBlockContext = interfacesDeclarationContext.classBlock();
                block = toClassBlock(
                        classBlockContext.variableDeclaration(),
                        classBlockContext.functionDeclaration(),
                        classBlockContext.classDeclaration(),
                        classBlockContext.interfacesDeclaration()
                );
            }
            return new InterfacesDeclaration(
                    accessModifier,
                    interfacesDeclarationContext.identifier().getText(),
                    classExtends,
                    block
            );
        }
        return null;
    }

    public Statement asStatement(AndesiteParser.StatementsContext statementsContext) {
        switch (statementsContext.getChild(0)) {
            case AndesiteParser.ReturnStatementContext returnStatementContext -> {
                return new ReturnStatement(toExpression(returnStatementContext.expression()));
            }
            case AndesiteParser.IfStatementContext ifStatementContext -> {
                ElseStatement elseStatement = ifStatementContext.elseStatement() != null ? new ElseStatement(toBlock(ifStatementContext.elseStatement().block().statements())) : null;
                if (ifStatementContext.elseIfStatement() != null) {
                    List<ElseIfStatement> elseIfStatements = ifStatementContext.elseIfStatement().stream().map(elseIfStatementContext -> new ElseIfStatement(toExpression(elseIfStatementContext.expression()), toBlock(elseIfStatementContext.block().statements()))).toList();
                    return new IfStatement(toExpression(ifStatementContext.expression()), toBlock(ifStatementContext.block().statements()), elseIfStatements, elseStatement);
                } else {
                    return new IfStatement(toExpression(ifStatementContext.expression()), toBlock(ifStatementContext.block().statements()), elseStatement);
                }
            }
            case AndesiteParser.ForStatementContext forStatementContext -> {
                Expression expression = toExpression(forStatementContext.forInitializer().forUntil() != null ? forStatementContext.forInitializer().forUntil().expression() : null);
                ForInitializer forInitializer = new ForInitializer(toExpression(forStatementContext.forInitializer().expression()), expression);
                return new ForStatement(new IdentifierExpression(forStatementContext.identifier().getText()), forInitializer, toBlock(forStatementContext.block().statements()));
            }
            case AndesiteParser.WhileStatementContext whileStatementContext -> {
                Expression expression = toExpression(whileStatementContext.expression());
                return new WhileStatement(expression, toBlock(whileStatementContext.block().statements()));
            }
            default -> {
                return null;
            }
        }
    }

    public Expression toExpression(AndesiteParser.ExpressionContext expressionContext) {
        switch (expressionContext) {
            case AndesiteParser.PrimaryExpressionContext ctx -> {
                if (ctx.primary() instanceof AndesiteParser.LiteralExpressionContext ctx_) {
                    return LiteralExpression.valueOf(ctx_.getRuleContext().getText());
                } else if (ctx.primary() instanceof AndesiteParser.IdentifierExpressionContext ctx_) {
                    return new IdentifierExpression(ctx_.identifier().getText());
                } else if (ctx.primary() instanceof AndesiteParser.MethodInvokeExpressionContext ctx_) {
                    List<Argument> argumentList = new ArrayList<>();
                    if (ctx_.methodInvoke().argumentList() != null) {
                        argumentList = ctx_.methodInvoke().argumentList().argument().stream().map(argumentContext -> new Argument(toExpression(argumentContext.expression()))).toList();
                    }
                    return new MethodInvokeExpression(ctx_.methodInvoke().identifier().getText(), argumentList);
                } else if (ctx.primary() instanceof AndesiteParser.ParenthesizedExpressionContext ctx_) {
                    return new ParenthesizedExpression(toExpression(ctx_.expression()));
                } else if (ctx.primary() instanceof AndesiteParser.MethodChainInvokeExpressionContext ctx_) {
                    List<Argument> argumentList = new ArrayList<>();
                    if (ctx_.methodChain().methodInvoke().argumentList() != null) {
                        argumentList = ctx_.methodChain().methodInvoke().argumentList().argument().stream().map(argumentContext -> new Argument(toExpression(argumentContext.expression()))).toList();
                    }
                    List<IdentifierExpression> chains = ctx_.methodChain().identifierChain().identifier().stream().map(identifierContext -> new IdentifierExpression(identifierContext.getText())).toList();
                    return new MethodChainExpression(ctx_.methodChain().methodInvoke().identifier().getText(), argumentList, chains);
                }
            }
            case AndesiteParser.LogicalNegationExpressionContext ctx -> {
                return new LogicalNegationExpression(toExpression(ctx.expression()));
            }
            case AndesiteParser.MultiplicativeExpressionContext ctx -> {
                return createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            }
            case AndesiteParser.AdditiveExpressionContext ctx -> {
                return createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            }
            case AndesiteParser.RelationalExpressionContext ctx -> {
                return createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            }
            case AndesiteParser.EqualityExpressionContext ctx -> {
                return createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            }
            case AndesiteParser.AssignmentExpressionContext ctx -> {
                return new AssignmentExpression(new IdentifierExpression(ctx.identifier().getText()), toExpression(ctx.expression()));
            }
            case AndesiteParser.ArrayInitializerExpressionContext ctx -> {
                return new ArrayInitializerExpression(ctx.arrayInitializer().arrayItems() != null ? ctx.arrayInitializer().arrayItems().expression().stream().map(this::toExpression).toList() : new ArrayList<>());
            }
            case AndesiteParser.ArrayAssignmentExpressionContext ctx -> {
                AndesiteParser.ArrayAccessContext arrayAccess = ctx.arrayAccess();
                return new ArrayAssignmentExpression(new IdentifierExpression(arrayAccess.identifier().getText()), IntegerLiteral.convert(arrayAccess.expression().getText()), toExpression(ctx.expression()));
            }
            case AndesiteParser.ArrayAccessExpressionContext ctx -> {
                return new ArrayAccessExpression(toExpression(ctx.arrayAccess().expression()), new IdentifierExpression(ctx.arrayAccess().identifier().getText()));
            }
            case null, default -> {
            }
        }
        return null;
    }



    private Expression createBinaryOperationExpression(AndesiteParser.ExpressionContext leftContext, AndesiteParser.ExpressionContext rightContext, Operation operation) {
        Expression left = toExpression(leftContext);
        Expression right = toExpression(rightContext);
        return new BinaryOperationExpression(left, right, operation);
    }

    public Program getProgram() {
        return program;
    }
}
