package akki697222.andesite.ir.nodes;

public class TypeArgumentExtends extends TypeArgument {
    private final TypeBound typeBound;

    public TypeArgumentExtends(TypeBound typeBound) {
        this.typeBound = typeBound;
    }

    public TypeBound getTypeBound() {
        return typeBound;
    }
}
