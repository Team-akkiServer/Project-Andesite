package akki697222.andesite.ir.type;

import akki697222.andesite.ir.type.primitive.PrimitiveType;

public interface Type {
    String STRING = "string";
    String INTEGER = "int";
    String LONG = "long";
    String DOUBLE = "double";
    String FLOAT = "float";
    String BOOLEAN = "bool";
    String VOID = "void";
    String OBJECT = "object";

    String name();
    boolean isPrimitive();

    static Type of(String name) {
        return PrimitiveType.valueOf(name) != null ? PrimitiveType.valueOf(name) : ArrayType.valueOf(name) != null ? ArrayType.valueOf(name) : new ClassType(name);
    }
}
