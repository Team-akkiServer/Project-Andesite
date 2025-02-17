package akki697222.andesite.core.value.primitive;

import akki697222.andesite.exceptions.AndesiteCompileException;
import akki697222.andesite.core.type.Type;
import akki697222.andesite.core.type.primitive.IntegerType;
import akki697222.andesite.core.type.primitive.PrimitiveType;
import akki697222.andesite.core.type.primitive.StringType;
import akki697222.andesite.core.value.Value;

public class PrimitiveValue<T extends Type, V> implements Value<T, V> {
    private final T type;
    private V value;

    public PrimitiveValue(T type, V value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public T getType() {
        return type;
    }

    public static <T extends Type, V> PrimitiveValue valueOf(T type, V value) {
        if (type instanceof IntegerType) return IntegerValue.valueOf(value);
        if (type instanceof StringType) return StringValue.valueOf(value);
        throw new AndesiteCompileException("Failed to convert primitive type '" + type.name() + "'");
    }
}