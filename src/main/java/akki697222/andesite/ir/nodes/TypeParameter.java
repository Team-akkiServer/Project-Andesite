package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;

public class TypeParameter extends Node {
    private final String parameterName;
    private final TypeParameterBound typeParameterBound;

    public TypeParameter(String parameterName, TypeParameterBound typeParameterBound) {
        this.parameterName = parameterName;
        this.typeParameterBound = typeParameterBound;
    }

    public TypeParameterBound getTypeParameterBound() {
        return typeParameterBound;
    }

    public String getParameterName() {
        return parameterName;
    }
}
