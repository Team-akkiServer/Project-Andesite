package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.type.Type;

public class NativeFunctionDeclaration extends Node {
    private final AccessModifier accessModifier;
    private final Modifier modifier;
    private final String name;
    private final FunctionParameters functionParameters;
    private final Type type;

    public NativeFunctionDeclaration(AccessModifier accessModifier, Modifier modifier, String name, FunctionParameters functionParameters, Type type) {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
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

    public Modifier getModifier() {
        return modifier;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "NativeFunctionDeclaration{" +
                "accessModifier=" + accessModifier +
                ", modifier=" + modifier +
                ", name='" + name + '\'' +
                ", functionParameters=" + functionParameters +
                ", type=" + type +
                '}';
    }
}
