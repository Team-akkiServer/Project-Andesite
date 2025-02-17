package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public abstract class Statement extends Node {
    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
