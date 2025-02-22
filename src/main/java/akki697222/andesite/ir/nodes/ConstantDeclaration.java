package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.Expression;
import akki697222.andesite.ir.nodes.type.Type;

public class ConstantDeclaration extends Node {
    private final String name;
    private final Type type;
    private final Expression value;
    private final AccessModifier accessModifier;

    public ConstantDeclaration(String name, Type type, Expression value, AccessModifier accessModifier) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.accessModifier = accessModifier;
    }

    public String getName() {
        return name;
    }

    public Expression getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "ConstantDeclaration{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", accessModifier=" + accessModifier +
                '}';
    }
}
