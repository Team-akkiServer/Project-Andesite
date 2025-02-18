package akki697222.andesite.ir.type;

import akki697222.andesite.ir.type.primitive.PrimitiveType;

import java.util.Objects;

public class ArrayType implements Type {
    private final Type type;

    public ArrayType(Type type) {
        this.type = type;
    }

    @Override
    public String name() {
        return type.name() + "[]";
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }

    public static ArrayType valueOf(String name) {
        if (name.endsWith("[]")) {
            String baseType = name.substring(0, name.length() - 2);
            PrimitiveType type_ = PrimitiveType.valueOf(baseType);

            return new ArrayType(Objects.requireNonNullElseGet(type_, () -> new ClassType(baseType)));
        }
        return null;
    }

    @Override
    public String toString() {
        return name();
    }

    public Type getValue() {
        return type;
    }
}
