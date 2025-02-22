package akki697222.andesite.ir.nodes.type;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public class Program extends Node {
    @Override
    public Node getParent() {
        return null;
    }

    @Override
    public void setParent(Node parent) {
        throw new RuntimeException("Cannot set parent to root node");
    }

    @Override
    public String toString() {
        return getChildren().toString();
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        for (Node child : children) {
            child.accept(visitor);
        }
    }
}
