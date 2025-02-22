package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.nodes.type.Type;
import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public class FunctionDeclaration extends Node {
    private final String name;
    private final AccessModifier accessModifier;
    private final Type returnType;
    private final FunctionParameters parameters;
    private final Block block;
    private final FunctionModifier functionModifier;

    public FunctionDeclaration(@NotNull String name, @NotNull AccessModifier accessModifier, @NotNull Type returnType, @NotNull FunctionParameters parameters, @NotNull Block block, FunctionModifier functionModifier) {
        this.name = name;
        this.accessModifier = accessModifier;
        this.returnType = returnType;
        this.parameters = parameters;
        this.block = block;
        this.functionModifier = functionModifier;
        parameters.setParent(this);
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull FunctionParameters getParameters() {
        return parameters;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Block getMethodBlock() {
        return block;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return "FunctionDeclaration{" +
                "name='" + name + '\'' +
                ", accessModifier=" + accessModifier +
                ", returnType=" + returnType +
                ", parameters=" + parameters +
                ", block=" + block +
                ", functionModifier=" + functionModifier +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    public FunctionModifier getFunctionModifier() {
        return functionModifier;
    }
}