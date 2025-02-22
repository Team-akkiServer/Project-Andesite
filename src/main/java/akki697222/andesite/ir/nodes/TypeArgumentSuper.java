package akki697222.andesite.ir.nodes;

public class TypeArgumentSuper extends TypeArgument {
    private final TypeBound typeBound;

    public TypeArgumentSuper(TypeBound typeBound) {
        this.typeBound = typeBound;
    }

    public TypeBound getTypeBound() {
        return typeBound;
    }
}
