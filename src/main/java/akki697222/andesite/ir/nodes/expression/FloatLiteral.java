package akki697222.andesite.ir.nodes.expression;

public class FloatLiteral extends NumberLiteral<Float> {
    public FloatLiteral(Float value) {
        super(value);
    }

    public static FloatLiteral convert(String value) {
        try {
            return new FloatLiteral(Float.parseFloat(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
