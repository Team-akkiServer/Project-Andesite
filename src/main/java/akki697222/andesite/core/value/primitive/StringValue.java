package akki697222.andesite.core.value.primitive;

import akki697222.andesite.core.type.primitive.StringType;

public class StringValue extends PrimitiveValue<StringType, String> {
    private final String value;

    public StringValue(String value) {
        super(new StringType(), value);

        this.value = value;
    }

    public static StringValue valueOf(Object value) {
        return new StringValue(value.toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
