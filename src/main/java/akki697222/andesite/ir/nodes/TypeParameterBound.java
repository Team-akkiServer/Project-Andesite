package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.type.Type;

public class TypeParameterBound extends Node {
    private final TypeParameterBoundType boundType;
    private final Type type;

    public TypeParameterBound(TypeParameterBoundType boundType, Type type) {
        this.boundType = boundType;
        this.type = type;
    }

    public TypeParameterBoundType getBoundType() {
        return boundType;
    }

    public Type getType() {
        return type;
    }

    public enum TypeParameterBoundType {
        EXTENDS,
        SUPER
    }
}
