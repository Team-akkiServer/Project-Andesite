package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.type.Type;
import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public class VariableDeclaration extends Node {
    private final String name;
    private final Type type;
    private final VariableInitializer initializer;
    private final AccessModifier accessModifier;

    public VariableDeclaration(String name, Type type, VariableInitializer initializer, AccessModifier accessModifier) {
        this.name = name;
        this.type = type;
        this.initializer = initializer;
        this.accessModifier = accessModifier;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public VariableInitializer getInitializer() {
        return initializer;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "VariableDeclaration{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", initializer='" + initializer + '\'' +
                ", accessModifier=" + accessModifier +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
