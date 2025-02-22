package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public abstract class Statement extends Node {
    private int sourceLine;

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    public int getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(int sourceLine) {
        this.sourceLine = sourceLine;
    }
}
