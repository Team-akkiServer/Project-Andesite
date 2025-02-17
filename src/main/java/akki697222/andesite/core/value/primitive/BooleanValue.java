package akki697222.andesite.core.value.primitive;

import akki697222.andesite.core.type.primitive.BooleanType;
import akki697222.andesite.core.type.primitive.IntegerType;
import akki697222.andesite.exceptions.PrimitiveConvertException;
import akki697222.andesite.ir.nodes.expression.BooleanLiteral;

public class BooleanValue extends PrimitiveValue<BooleanType, Boolean> {
    private final Boolean value;

    public BooleanValue(Boolean value) {
        super(new BooleanType(), value);

        this.value = value;
    }

    public static BooleanValue valueOf(Object value) {
        String s = value.toString();
        if (s.equals("true")) {
            return new BooleanValue(true);
        } else if (s.equals("false")) {
            return new BooleanValue(false);
        } else {
            throw new PrimitiveConvertException("Failed to convert value '" + s + "' to boolean.");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
