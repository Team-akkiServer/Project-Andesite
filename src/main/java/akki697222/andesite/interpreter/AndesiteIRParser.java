package akki697222.andesite.interpreter;

import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.compiler.AndesiteParserBaseListener;
import akki697222.andesite.core.type.Type;
import akki697222.andesite.exceptions.AndesiteCompileException;
import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import akki697222.andesite.ir.nodes.statements.*;

import java.util.ArrayList;
import java.util.List;

public class AndesiteIRParser extends AndesiteParserBaseListener {
    private final Program program;

    public AndesiteIRParser() {
        this.program = new Program();
    }

    @Override
    public void enterProgram(AndesiteParser.ProgramContext ctx) {
        for (AndesiteParser.StatementsContext statement : ctx.statements()) {
            program.addChild(toNode(statement));
        }
    }

    public Block toBlock(List<AndesiteParser.StatementsContext> ruleContexts) {
        List<Node> nodes = new ArrayList<>();

        for (AndesiteParser.StatementsContext ruleContext : ruleContexts) {
            nodes.add(toNode(ruleContext));
        }

        return new Block(nodes);
    }

    public Node toNode(AndesiteParser.StatementsContext statementsContext) {
        if (asFunction(statementsContext) != null) return asFunction(statementsContext);
        if (asVariable(statementsContext) != null) return asVariable(statementsContext);
        if (asStatement(statementsContext) != null) return asStatement(statementsContext);
        if (toExpression(statementsContext.expression()) != null) return toExpression(statementsContext.expression());

        throw new AndesiteCompileException("Failed to convert statement '" + statementsContext.getChild(0).getClass().getSimpleName() + "' to node");
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

                }
            }
            case AndesiteParser.LogicalNegationExpressionContext ctx -> {
                return new LogicalNegationExpression(toExpression(ctx.expression()));
            }
            case AndesiteParser.MultiplicativeExpressionContext ctx -> {
                Expression left = toExpression(ctx.expression());
                Expression right = toExpression(ctx.rightExpression().expression());
                Operation op = Operation.get(ctx.op.getText());
                return new BinaryOperationExpression(left, right, op);
            }
            case AndesiteParser.AdditiveExpressionContext ctx -> {
                Expression left = toExpression(ctx.expression());
                Expression right = toExpression(ctx.rightExpression().expression());
                Operation op = Operation.get(ctx.op.getText());
                return new BinaryOperationExpression(left, right, op);
            }
            case AndesiteParser.RelationalExpressionContext ctx -> {
                Expression left = toExpression(ctx.expression());
                Expression right = toExpression(ctx.rightExpression().expression());
                Operation op = Operation.get(ctx.op.getText());
                return new BinaryOperationExpression(left, right, op);
            }
            case AndesiteParser.EqualityExpressionContext ctx -> {
                Expression left = toExpression(ctx.expression());
                Expression right = toExpression(ctx.rightExpression().expression());
                Operation op = Operation.get(ctx.op.getText());
                return new BinaryOperationExpression(left, right, op);
            }
            case AndesiteParser.AssignmentExpressionContext ctx -> {
                return new AssignmentExpression(new IdentifierExpression(ctx.identifier().getText()), toExpression(ctx.expression()));
            }
            case null, default -> {
            }
        }
        return null;
    }

    public FunctionDeclaration asFunction(AndesiteParser.StatementsContext statementsContext) {
        if (statementsContext.getChild(0) instanceof AndesiteParser.FunctionDeclarationContext functionDeclarationContext) {
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
                    toBlock(functionDeclarationContext.block().statements())
            );
        }
        return null;
    }

    public VariableDeclaration asVariable(AndesiteParser.StatementsContext statementsContext) {
        if (statementsContext.getChild(0) instanceof AndesiteParser.VariableDeclarationContext variableDeclarationContext) {
            AccessModifier accessModifier = AccessModifier.PRIVATE;
            VariableInitializer initializeWith;
            if (variableDeclarationContext.accessModifier() != null) {
                AccessModifier.valueOf(variableDeclarationContext.accessModifier().getText().toUpperCase());
            }
            if (variableDeclarationContext.variableInitializer() != null) {
                initializeWith = new VariableInitializer(LiteralExpression.valueOf(variableDeclarationContext.variableInitializer().expression().getText()));
                if (initializeWith.getExpression() == null) {
                    initializeWith = new VariableInitializer(toExpression(variableDeclarationContext.variableInitializer().expression()));
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
        }
        return null;
    }

    public Program getProgram() {
        return program;
    }
}
