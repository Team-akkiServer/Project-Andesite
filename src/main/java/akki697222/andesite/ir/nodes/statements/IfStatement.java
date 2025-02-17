package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.expression.Expression;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class IfStatement extends Statement {
    public final Expression expression;
    public final List<ElseIfStatement> elseIfStatements;
    public final Block ifBlock;
    public final ElseStatement elseStatement;

    public IfStatement(Expression expression, Block ifBlock, List<ElseIfStatement> elseIfStatements, ElseStatement elseStatement) {
        this.expression = expression;
        this.ifBlock = ifBlock;
        this.elseIfStatements = elseIfStatements;
        this.elseStatement = elseStatement;
    }

    public IfStatement(Expression expression, Block ifBlock, ElseStatement elseStatement) {
        this.expression = expression;
        this.ifBlock = ifBlock;
        this.elseStatement = elseStatement;
        this.elseIfStatements = new ArrayList<>();
    }

    public IfStatement(Expression expression, Block ifBlock) {
        this.expression = expression;
        this.ifBlock = ifBlock;
        this.elseStatement = null;
        this.elseIfStatements = new ArrayList<>();
    }

    public Expression getExpression() {
        return expression;
    }

    public Block getIfBlock() {
        return ifBlock;
    }

    public List<ElseIfStatement> getElseIfStatements() {
        return elseIfStatements;
    }

    public ElseStatement getElseStatement() {
        return elseStatement;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "IfStatement{" +
                "expression=" + expression +
                ", elseIfStatements=" + elseIfStatements +
                ", ifBlock=" + ifBlock +
                ", elseStatement=" + elseStatement +
                '}';
    }
}
