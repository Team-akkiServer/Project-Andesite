package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.expression.Expression;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;
import org.jetbrains.annotations.NotNull;

public class WhileStatement extends Statement {
    private final Expression expression;
    private final Block block;

    public WhileStatement(Expression expression, Block block) {
        this.expression = expression;
        this.block = block;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public Block getBlock() {
        return block;
    }
}
