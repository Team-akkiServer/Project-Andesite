package akki697222.andesite.ir.nodes;

public class TypeParameterExtends extends TypeParameter {
    private final TypeBound typeBound;

    public TypeParameterExtends(String name, TypeBound typeBound) {
        super(name);
        this.typeBound = typeBound;
    }

    public TypeBound getTypeBound() {
        return typeBound;
    }
}
