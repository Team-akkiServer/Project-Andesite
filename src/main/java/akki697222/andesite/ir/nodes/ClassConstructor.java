package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.type.Type;
import org.jetbrains.annotations.NotNull;

public class ClassConstructor extends Node {
    private final FunctionParameters parameters;
    private final Block block;

    public ClassConstructor(@NotNull FunctionParameters parameters, @NotNull Block block) {
        this.parameters = parameters;
        this.block = block;
        parameters.setParent(this);
    }

    public @NotNull FunctionParameters getParameters() {
        return parameters;
    }

    public Block getInitializerBlock() {
        return block;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ClassConstructor{" +
                "parameters=" + parameters +
                ", block=" + block +
                '}';
    }
}
