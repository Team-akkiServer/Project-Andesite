package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.expression.Expression;
import org.jetbrains.annotations.NotNull;

public class RepeatStatement extends Statement {
    private final Expression expression;
    private final Block block;

    public RepeatStatement(Expression expression, Block block) {
        this.expression = expression;
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "RepeatStatement{" +
                "expression=" + expression +
                ", block=" + block +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
