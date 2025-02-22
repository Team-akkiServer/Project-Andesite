package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;

import java.util.List;

public class TypeArguments extends Node {
    private final List<TypeArgument> typeArguments;

    public TypeArguments(List<TypeArgument> typeArguments) {
        this.typeArguments = typeArguments;
    }

    public List<TypeArgument> getTypeArguments() {
        return typeArguments;
    }
}
