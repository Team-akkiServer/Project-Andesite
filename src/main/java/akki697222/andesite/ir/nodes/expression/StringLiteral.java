package akki697222.andesite.ir.nodes.expression;

public class StringLiteral extends LiteralExpression<String> {
    public StringLiteral(String value) {
        super(value);
    }

    public static StringLiteral convert(String value) {
        if (value != null && value.startsWith("\"") && value.endsWith("\"")) {
            String strippedValue = value.substring(1, value.length() - 1);
            return new StringLiteral(strippedValue);
        }
        return null;
    }
}
