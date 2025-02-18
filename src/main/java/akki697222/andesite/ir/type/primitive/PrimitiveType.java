package akki697222.andesite.ir.type.primitive;

import akki697222.andesite.ir.type.Type;
import org.jetbrains.annotations.Nullable;

public abstract class PrimitiveType implements Type {
    @Override
    public boolean isPrimitive() {
        return true;
    }

    public static @Nullable PrimitiveType valueOf(String primitiveName) {
        return switch (primitiveName) {
            case INTEGER -> new IntegerType();
            case STRING -> new StringType();
            case VOID -> new VoidType();
            case OBJECT -> new ObjectType();
            case BOOLEAN -> new BooleanType();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return name();
    }
}