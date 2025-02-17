package akki697222.andesite.core.value.primitive;

import akki697222.andesite.exceptions.PrimitiveConvertException;
import akki697222.andesite.core.type.primitive.IntegerType;

public class IntegerValue extends PrimitiveValue<IntegerType, Integer> {
    private final Integer value;

    public IntegerValue(Integer value) {
        super(new IntegerType(), value);

        this.value = value;
    }

    public static IntegerValue valueOf(Object value) {
        String s = value.toString();
        try {
            int i = Integer.parseInt(s);
            return new IntegerValue(i);
        } catch (NumberFormatException e) {
            throw new PrimitiveConvertException("Failed to convert value '" + s + "' to Integer");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
