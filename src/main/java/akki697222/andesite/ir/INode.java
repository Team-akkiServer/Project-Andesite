package akki697222.andesite.ir;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface INode {
    @NotNull List<? extends Node> getChildren();
    @Nullable Node getChild(int index);
    @Nullable Node getParent();
    void addChild(@NotNull Node child);
    void setParent(Node parent);
    void accept(@NotNull Visitor visitor);
}

