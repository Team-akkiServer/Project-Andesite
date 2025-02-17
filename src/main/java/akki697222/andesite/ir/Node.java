package akki697222.andesite.ir;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements INode {
    protected Node parent;
    protected List<Node> children = new ArrayList<>();

    @Override
    public @NotNull List<? extends Node> getChildren() {
        return children;
    }

    @Override
    public Node getChild(int index) {
        return children.get(index);
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(@NotNull Node child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
        for (Node child : children) {
            child.accept(visitor);
        }
    }
}