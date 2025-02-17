package akki697222.andesite.ir.nodes.expression;

public class BooleanLiteral extends LiteralExpression<Boolean> {
    public BooleanLiteral(Boolean value) {
        super(value);
    }

    public static BooleanLiteral convert(String value) {
        if (value.equals("true")) {
            return new BooleanLiteral(true);
        } else if (value.equals("false")) {
            return new BooleanLiteral(false);
        } else {
            return null;
        }
    }
}
