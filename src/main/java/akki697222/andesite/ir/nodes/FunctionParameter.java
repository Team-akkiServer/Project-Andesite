package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.nodes.type.Type;
import akki697222.andesite.ir.Node;

public class FunctionParameter extends Node {
    private final String name;
    private final Type type;

    public FunctionParameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FunctionParameter{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
