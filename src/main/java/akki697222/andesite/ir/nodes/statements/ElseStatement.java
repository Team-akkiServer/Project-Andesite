package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.expression.Expression;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ElseStatement extends Statement {
    public final Block ifBlock;

    public ElseStatement(Block ifBlock) {
        this.ifBlock = ifBlock;
    }

    public Block getIfBlock() {
        return ifBlock;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
