package akki697222.andesite.ir.nodes.expression;

public class DoubleLiteral extends NumberLiteral<Double> {
    public DoubleLiteral(Double value) {
        super(value);
    }

    public static DoubleLiteral convert(String value) {
        try {
            return new DoubleLiteral(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
