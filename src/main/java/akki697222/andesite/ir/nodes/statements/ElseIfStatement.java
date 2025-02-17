package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.expression.Expression;
import org.jetbrains.annotations.NotNull;

public class ElseIfStatement extends Statement {
    public final Expression expression;
    public final Block ifBlock;

    public ElseIfStatement(Expression expression, Block ifBlock) {
        this.expression = expression;
        this.ifBlock = ifBlock;
    }

    public Expression getExpression() {
        return expression;
    }

    public Block getIfBlock() {
        return ifBlock;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
