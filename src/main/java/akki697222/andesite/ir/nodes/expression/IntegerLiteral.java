package akki697222.andesite.ir.nodes.expression;

public class IntegerLiteral extends LiteralExpression<Integer> {
    public IntegerLiteral(Integer value) {
        super(value);
    }

    public static IntegerLiteral convert(String value) {
        try {
            return new IntegerLiteral(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
