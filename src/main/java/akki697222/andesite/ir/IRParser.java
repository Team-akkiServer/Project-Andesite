package akki697222.andesite.ir;

import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.compiler.AndesiteParserBaseListener;
import akki697222.andesite.exceptions.CompileException;
import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import akki697222.andesite.ir.nodes.statements.*;
import akki697222.andesite.ir.nodes.type.Program;
import akki697222.andesite.ir.nodes.type.Type;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class IRParser extends AndesiteParserBaseListener {
    private final Program program;
    private final AndesiteParser parser;
    private final ErrorListener errorListener;

    public IRParser(AndesiteParser parser, ErrorListener errorListener) {
        this.program = new Program();
        this.parser = parser;
        this.errorListener = errorListener;
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
    }

    @Override
    public void enterProgram(AndesiteParser.ProgramContext ctx) {
        boolean hasError = false;
        for (AndesiteParser.StatementsContext statement : ctx.statements()) {
            if (statement.expression() != null) {
                AndesiteParser.ExpressionContext expressionContext = statement.expression();
                if (expressionContext instanceof AndesiteParser.PrimaryExpressionContext primaryExpressionContext) {
                    AndesiteParser.PrimaryContext primaryContext = primaryExpressionContext.primary();
                    if (primaryContext instanceof AndesiteParser.ReferenceExpressionContext referenceExpressionContext) {
                        AndesiteParser.ReferenceContext finalReference = referenceExpressionContext.chainReference().reference().getLast();
                        if (finalReference.identifier() != null || finalReference.arrayAccess() != null) {
                            System.err.println(ErrorListener.formatError(
                                    parser.getSourceName(),
                                    primaryContext.getStart().getLine(),
                                    primaryContext.getStart().getCharPositionInLine(),
                                    "SemanticError",
                                    "'" + primaryContext.getText() + "' is a not statement.",
                                    primaryContext.getText(),
                                    primaryContext.getText().length()
                            ));
                            hasError = true;
                        }
                    } else if (!(primaryContext instanceof AndesiteParser.InstantiateExpressionContext)) {
                        System.err.println(ErrorListener.formatError(
                                parser.getSourceName(),
                                primaryContext.getStart().getLine(),
                                primaryContext.getStart().getCharPositionInLine(),
                                "SemanticError",
                                "'" + primaryContext.getText() + "' is a not statement.",
                                primaryContext.getText(),
                                primaryContext.getText().length()
                        ));
                        hasError = true;
                    }
                } else {
                    System.err.println(ErrorListener.formatError(
                            parser.getSourceName(),
                            expressionContext.getStart().getLine(),
                            expressionContext.getStart().getCharPositionInLine(),
                            "SemanticError",
                            "'" + expressionContext.getText() + "' is a not statement.",
                            expressionContext.getText(),
                            expressionContext.getText().length()
                    ));
                    hasError = true;
                }
            }
            program.addChild(toNode(statement));
        }
        if (hasError || errorListener.isHasError()) {
            throw new CompileException("Failed to compile");
        }
    }

    public Block toBlock(List<AndesiteParser.StatementsContext> statementsContexts) {
        List<Node> nodes = new ArrayList<>();

        for (AndesiteParser.StatementsContext statementsContext : statementsContexts) {
            nodes.add(toNode(statementsContext));
        }

        return new Block(nodes);
    }

    public ClassBlock toClassBlock(List<AndesiteParser.VariableDeclarationContext> fields, List<AndesiteParser.FunctionDeclarationContext> methods, List<AndesiteParser.ClassDeclarationContext> classes, List<AndesiteParser.InterfacesDeclarationContext> interfaces, List<AndesiteParser.NativeFunctionDeclarationContext> nativeMethods) {
        return new ClassBlock(
                fields.stream().map(variableDeclarationContext -> (VariableDeclaration) ruleContextToObjective((variableDeclarationContext))).toList(),
                methods.stream().map(functionDeclarationContext -> (FunctionDeclaration) ruleContextToObjective((functionDeclarationContext))).toList(),
                classes.stream().map(classDeclarationContext -> (ClassDeclaration) ruleContextToObjective((classDeclarationContext))).toList(),
                interfaces.stream().map(interfacesDeclarationContext -> (InterfacesDeclaration) ruleContextToObjective(interfacesDeclarationContext)).toList(),
                nativeMethods.stream().map(nativeFunctionDeclarationContext -> (NativeFunctionDeclaration) ruleContextToObjective(nativeFunctionDeclarationContext)).toList());
    }

    public Node toNode(AndesiteParser.StatementsContext statementsContext) {
        if (asObjective(statementsContext) != null) return asObjective(statementsContext);
        if (asStatement(statementsContext) != null) {
            Statement statement = asStatement(statementsContext);
            statement.setSourceLine(statementsContext.getStart().getLine());
            return statement;
        }
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
                    toFunctionModifier(functionDeclarationContext.functionModifier())
            );
        } else if (ruleContext instanceof AndesiteParser.NativeFunctionDeclarationContext nativeFunctionDeclarationContext) {
            List<FunctionParameter> parameters = new ArrayList<>();
            if (nativeFunctionDeclarationContext.parameterList() != null) {
                nativeFunctionDeclarationContext.parameterList().parameter().forEach(parameterContext -> {
                    parameters.add(new FunctionParameter(parameterContext.identifier().getText(), Type.of(parameterContext.types().getText())));
                });
            }
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            if (nativeFunctionDeclarationContext.accessModifier() != null) {
                accessModifier = AccessModifier.valueOf(nativeFunctionDeclarationContext.accessModifier().getText().toUpperCase());
            }
            return new NativeFunctionDeclaration(
                    accessModifier,
                    nativeFunctionDeclarationContext.identifier().getText(),
                    new FunctionParameters(parameters),
                    Type.of(nativeFunctionDeclarationContext.types().getText())
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
                    accessModifier,
                    toModifier(variableDeclarationContext.modifier())
            );
        } else if (ruleContext instanceof AndesiteParser.ClassDeclarationContext classDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            ClassBlock block = null;
            if (classDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(classDeclarationContext.accessModifier().getText().toUpperCase());
            }
            Type classExtends = null;
            List<Type> classImplements = new ArrayList<>();
            if (classDeclarationContext.objectiveExtends() != null) {
                classExtends = Type.of(classDeclarationContext.objectiveExtends().types().getText());
            }
            if (classDeclarationContext.objectiveImplements() != null) {
                for (AndesiteParser.TypesContext type : classDeclarationContext.objectiveImplements().types()) {
                    classImplements.add(Type.of(type.getText()));
                }
            }
            if (classDeclarationContext.classBlock() != null) {
                AndesiteParser.ClassBlockContext classBlockContext = classDeclarationContext.classBlock();
                block = toClassBlock(
                        classBlockContext.variableDeclaration(),
                        classBlockContext.functionDeclaration(),
                        classBlockContext.classDeclaration(),
                        classBlockContext.interfacesDeclaration(),
                        classBlockContext.nativeFunctionDeclaration()
                        );
            }
            ClassConstructor constructor = null;
            if (block != null && classDeclarationContext.classBlock().constructorDeclaration() != null) {
                for (AndesiteParser.ConstructorDeclarationContext constructorDeclarationContext : classDeclarationContext.classBlock().constructorDeclaration()) {
                    List<FunctionParameter> parameters = new ArrayList<>();
                    if (constructorDeclarationContext.parameterList() != null) {
                        constructorDeclarationContext.parameterList().parameter().forEach(parameterContext -> {
                            parameters.add(new FunctionParameter(parameterContext.identifier().getText(), Type.of(parameterContext.types().getText())));
                        });
                    }
                    constructor = new ClassConstructor(new FunctionParameters(parameters), toBlock(constructorDeclarationContext.block().statements()));
                }
            }
            return new ClassDeclaration(
                    block,
                    classDeclarationContext.identifier().getText(),
                    toModifier(classDeclarationContext.modifier()),
                    classExtends,
                    classImplements,
                    accessModifier,
                    constructor
            );
        } else if (ruleContext instanceof AndesiteParser.InterfacesDeclarationContext interfacesDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            ClassBlock block = null;
            List<Type> interfaceExtends = new ArrayList<>();
            if (interfacesDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(interfacesDeclarationContext.accessModifier().getText().toUpperCase());
            }
            if (interfacesDeclarationContext.interfaceExtends() != null) {
                for (AndesiteParser.TypesContext type : interfacesDeclarationContext.interfaceExtends().types()) {
                    interfaceExtends.add(Type.of(type.getText()));
                }
            }
            if (interfacesDeclarationContext.classBlock() != null) {
                AndesiteParser.ClassBlockContext classBlockContext = interfacesDeclarationContext.classBlock();
                block = toClassBlock(
                        classBlockContext.variableDeclaration(),
                        classBlockContext.functionDeclaration(),
                        classBlockContext.classDeclaration(),
                        classBlockContext.interfacesDeclaration(),
                        classBlockContext.nativeFunctionDeclaration()
                );
            }
            return new InterfacesDeclaration(
                    accessModifier,
                    interfacesDeclarationContext.identifier().getText(),
                    interfaceExtends,
                    block
            );
        } else if (ruleContext instanceof AndesiteParser.ConstantDeclarationContext constantDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            if (constantDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(constantDeclarationContext.accessModifier().getText().toUpperCase());
            }
            return new ConstantDeclaration(
                    constantDeclarationContext.identifier().getText(),
                    Type.of(constantDeclarationContext.types().getText()),
                    toExpression(constantDeclarationContext.expression()),
                    accessModifier
            );
        } else if (ruleContext instanceof AndesiteParser.RepeatStatementContext repeatStatementContext) {
            return new RepeatStatement(
                    toExpression(repeatStatementContext.expression()),
                    toBlock(repeatStatementContext.block().statements())
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
            case AndesiteParser.ImportPackageContext ctx -> {
                List<ImportedPackageIdentifier> imports = new ArrayList<>();
                int index = 0;
                List<AndesiteParser.IdentifierContext> importFrom = ctx.importFrom().identifier();
                List<AndesiteParser.IdentifierContext> importAs = ctx.importAs() != null ? ctx.importAs().identifier() : new ArrayList<>();
                for (AndesiteParser.IdentifierContext identifierContext : importFrom) {
                    if (importAs.size() > index) {
                        imports.add(new ImportedPackageIdentifier(new IdentifierExpression(identifierContext.getText()), new IdentifierExpression(importAs.get(index).getText())));
                    } else {
                        imports.add(new ImportedPackageIdentifier(new IdentifierExpression(identifierContext.getText())));
                    }
                    index++;
                }

                return new ImportPackage(ctx.string().getText().substring(1, ctx.string().getText().length() - 1), imports);
            }
            default -> {
                return null;
            }
        }
    }

    public Expression toExpression(AndesiteParser.ExpressionContext expressionContext) {
        Expression expression = switch (expressionContext) {
            case AndesiteParser.PrimaryExpressionContext ctx -> fromPrimaryExpression(ctx.primary());
            case AndesiteParser.PostfixExpressionContext ctx -> {
                if (ctx.op.getText().equals("--")) {
                    yield new DeclementExpression((ReferenceExpression) toExpression(ctx.expression()));
                } else {
                    yield new InclementExpression((ReferenceExpression) toExpression(ctx.expression()));
                }
            }
            case AndesiteParser.PrefixExpressionContext ctx -> {
                if (ctx.op.getText().equals("--")) {
                    yield new DeclementExpression((ReferenceExpression) toExpression(ctx.expression()));
                } else {
                    yield new InclementExpression((ReferenceExpression) toExpression(ctx.expression()));
                }
            }
            case AndesiteParser.NegationExpressionContext ctx ->
                    NumberLiteral.negate((NumberLiteral<?>) toExpression(ctx.expression()));
            case AndesiteParser.LogicalNegationExpressionContext ctx ->
                    new BooleanLiteral(!((BooleanLiteral) toExpression(ctx.expression())).getValue());
            case AndesiteParser.MultiplicativeExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.AdditiveExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.BitwiseShiftExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.RelationalExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.EqualityExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.BitwiseAndExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.BitwiseXorExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.BitwiseOrExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.LogicalAndExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.LogicalOrExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.LogicalXorExpressionContext ctx ->
                    createBinaryOperationExpression(ctx.expression(), ctx.rightExpression().expression(), Operation.get(ctx.op.getText()));
            case AndesiteParser.AssignmentExpressionContext ctx ->
                    new AssignmentExpression(toReference(ctx.chainReference()), toExpression(ctx.expression()));
            case AndesiteParser.SelfReferenceExpressionContext ctx ->
                    new SelfReferenceExpression(toReference(ctx.chainReference()));
            case AndesiteParser.SelfAssignmentExpressionContext ctx ->
                    new SelfAssignmentExpression(new AssignmentExpression(toReference(ctx.chainReference()), toExpression(ctx.expression())));
            case AndesiteParser.ArrayInitializerExpressionContext ctx ->
                    new ArrayInitializerExpression(ctx.arrayInitializer().arrayItems() != null ? ctx.arrayInitializer().arrayItems().expression().stream().map(this::toExpression).toList() : new ArrayList<>());
            case null, default -> null;
        };
        if (expression != null) {
            expression.setSourceLine(expressionContext.getStart().getLine());
        }
        return expression;
    }

    public MethodInvokeExpression toMethodInvoke(AndesiteParser.MethodInvokeContext ctx) {
        List<Argument> argumentList = new ArrayList<>();
        if (ctx.argumentList() != null) {
            argumentList = ctx.argumentList().argument().stream().map(argumentContext -> new Argument(toExpression(argumentContext.expression()))).toList();
        }
        return new MethodInvokeExpression(new IdentifierExpression(ctx.identifier().getText()), new ArgumentList(argumentList));
    }

    public Expression fromPrimaryExpression(AndesiteParser.PrimaryContext ctx) {
        if (ctx instanceof AndesiteParser.LiteralExpressionContext ctx_) {
            return LiteralExpression.valueOf(ctx_.getRuleContext().getText());
        } else if (ctx instanceof AndesiteParser.ReferenceExpressionContext ctx_) {
            return toReference(ctx_.chainReference());
        } else if (ctx instanceof AndesiteParser.InstantiateExpressionContext ctx_) {
            List<Argument> argumentList = new ArrayList<>();
            if (ctx_.instantiate().argumentList() != null) {
                argumentList = ctx_.instantiate().argumentList().argument().stream().map(argumentContext -> new Argument(toExpression(argumentContext.expression()))).toList();
            }
            return new InstantiateExpression(new IdentifierExpression(ctx_.instantiate().identifier().getText()), new ArgumentList(argumentList));
        } else if (ctx instanceof AndesiteParser.InstanceReferenceExpressionContext ctx_) {
            List<Argument> argumentList = new ArrayList<>();
            if (ctx_.instantiate().argumentList() != null) {
                argumentList = ctx_.instantiate().argumentList().argument().stream().map(argumentContext -> new Argument(toExpression(argumentContext.expression()))).toList();
            }
            return new InstanceReferenceExpression(new InstantiateExpression(new IdentifierExpression(ctx_.instantiate().identifier().getText()), new ArgumentList(argumentList)), toReference(ctx_.chainReference()));
        } else if (ctx instanceof AndesiteParser.ParenthesizedExpressionContext ctx_) {
            return new ParenthesizedExpression(toExpression(ctx_.expression()));
        }
        return null;
    }

    public ChainedReferenceExpression toReference(AndesiteParser.ChainReferenceContext chainReferenceContext) {
        List<AndesiteParser.ReferenceContext> referenceContexts = chainReferenceContext.reference();
        List<ReferenceExpression> referenceExpressions = new ArrayList<>();
        for (AndesiteParser.ReferenceContext referenceContext : referenceContexts) {
            if (referenceContext.identifier() != null) {
                referenceExpressions.add(new ReferenceExpression(ReferenceType.IDENTIFIER, new IdentifierExpression(referenceContext.identifier().getText())));
            } else if (referenceContext.methodInvoke() != null) {
                referenceExpressions.add(new ReferenceExpression(ReferenceType.INVOKE, toMethodInvoke(referenceContext.methodInvoke())));
            } else if (referenceContext.arrayAccess() != null) {
                referenceExpressions.add(new ReferenceExpression(ReferenceType.ARRAY, new ArrayReferenceExpression(toExpression(referenceContext.arrayAccess().expression()), new IdentifierExpression(referenceContext.arrayAccess().identifier().getText()))));
            }
        }
        return new ChainedReferenceExpression(referenceExpressions);
    }

    public FunctionModifier toFunctionModifier(List<AndesiteParser.FunctionModifierContext> modifierContext) {
        boolean isOverride = modifierContext.stream().anyMatch(functionModifierContext -> functionModifierContext.OVERRIDE() != null);
        boolean isFinal = false;
        boolean isStatic = false;
        boolean isAbstract = false;
        for (AndesiteParser.FunctionModifierContext context : modifierContext) {
            if (context.modifier() != null) {
                if (!isFinal) {
                    isFinal = context.modifier().FINAL() != null;
                }
                if (!isStatic) {
                    isStatic = context.modifier().STATIC() != null;
                }
                if (!isAbstract) {
                    isAbstract = context.modifier().ABSTRACT() != null;
                }
            }
        }
        return new FunctionModifier(isFinal, isStatic, isAbstract, isOverride);
    }

    public Modifier toModifier(List<AndesiteParser.ModifierContext> modifierContext) {
        boolean isFinal = false;
        boolean isStatic = false;
        boolean isAbstract = false;
        for (AndesiteParser.ModifierContext context : modifierContext) {
            if (!isFinal) {
                isFinal = context.FINAL() != null;
            }
            if (!isStatic) {
                isStatic = context.STATIC() != null;
            }
            if (!isAbstract) {
                isAbstract = context.ABSTRACT() != null;
            }
        }
        return new Modifier(isFinal, isStatic, isAbstract);
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
