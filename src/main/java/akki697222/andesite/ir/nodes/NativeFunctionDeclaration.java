package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.type.Type;
import org.jetbrains.annotations.NotNull;

public class NativeFunctionDeclaration extends Node {
    private final AccessModifier accessModifier;
    private final String name;
    private final FunctionParameters functionParameters;
    private final Type type;

    public NativeFunctionDeclaration(AccessModifier accessModifier, String name, FunctionParameters functionParameters, Type type) {
        this.accessModifier = accessModifier;
        this.name = name;
        this.functionParameters = functionParameters;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public FunctionParameters getFunctionParameters() {
        return functionParameters;
    }

    public String getName() {
        return name;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "NativeFunctionDeclaration{" +
                "accessModifier=" + accessModifier +
                ", name='" + name + '\'' +
                ", functionParameters=" + functionParameters +
                ", type=" + type +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
