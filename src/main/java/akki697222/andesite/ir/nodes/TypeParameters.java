package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;

import java.util.List;

public class TypeParameters extends Node {
    private final List<TypeParameter> typeParameters;

    public TypeParameters(List<TypeParameter> typeParameters) {
        this.typeParameters = typeParameters;
    }

    public List<TypeParameter> getTypeParameters() {
        return typeParameters;
    }
}
