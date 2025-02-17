package akki697222.andesite.core.value.primitive;

import akki697222.andesite.core.type.primitive.NullType;

public class NullValue extends PrimitiveValue<NullType, Object> {
    public NullValue() {
        super(new NullType(), null);
    }
}
