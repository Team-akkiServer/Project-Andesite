package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.expression.Expression;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;
import org.jetbrains.annotations.NotNull;

public class ForStatement extends Statement {
    private final IdentifierExpression identifier;
    private final ForInitializer initializer;
    private final Block block;

    public ForStatement(IdentifierExpression identifier, ForInitializer initializer, Block block) {
        this.identifier = identifier;
        this.initializer = initializer;
        this.block = block;
    }

    public IdentifierExpression getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    public ForInitializer getInitializer() {
        return initializer;
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "ForStatement{" +
                "identifier=" + identifier +
                ", initializer=" + initializer +
                ", block=" + block +
                '}';
    }
}
