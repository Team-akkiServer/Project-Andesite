package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.nodes.type.Type;

public class TypeArgumentSingle extends TypeArgument {
    private final Type type;

    public TypeArgumentSingle(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
