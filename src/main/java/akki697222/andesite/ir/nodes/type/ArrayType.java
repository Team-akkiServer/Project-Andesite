package akki697222.andesite.ir.nodes.type;

public class ArrayType extends Type {
    private final Type arrayType;

    protected ArrayType(Type arrayType) {
        super(arrayType.getName() + "[]");
        this.arrayType = arrayType;
    }

    public Type getArrayType() {
        return arrayType;
    }
}
