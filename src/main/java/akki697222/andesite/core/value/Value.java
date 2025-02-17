package akki697222.andesite.core.value;

import akki697222.andesite.core.type.Type;
import akki697222.andesite.core.value.primitive.PrimitiveValue;
import akki697222.andesite.core.value.primitive.StringValue;
import akki697222.andesite.ir.nodes.expression.Expression;

public interface Value<T extends Type, V> {
    V getValue();
    void setValue(V value);
    T getType();
}
