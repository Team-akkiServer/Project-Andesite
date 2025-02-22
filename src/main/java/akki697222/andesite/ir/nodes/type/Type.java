package akki697222.andesite.ir.nodes.type;

import akki697222.andesite.ir.Node;

public abstract class Type extends Node {
    private final String name;

    protected Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Type of(String name) {
        return switch (name) {
            case "string" -> new StringType();
            case "int" -> new IntegerType();
            case "long" -> new LongType();
            case "float" -> new FloatType();
            case "double" -> new DoubleType();
            case "char" -> new CharType();
            case "void" -> new VoidType();
            case "bool" -> new BooleanType();
            case "object" -> new ObjectType();
            default -> {
                if (name.endsWith("[]")) {
                    yield new ArrayType(of(name.substring(0, name.length() - 2)));
                } else {
                    yield new CustomType(name);
                }
            }
        };
    }
}
