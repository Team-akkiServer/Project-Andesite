package akki697222.andesite.ir.nodes;

public class TypeParameterSuper extends TypeParameter {
    private final TypeBound typeBound;

    public TypeParameterSuper(String name, TypeBound typeBound) {
        super(name);
        this.typeBound = typeBound;
    }

    public TypeBound getTypeBound() {
        return typeBound;
    }
}
