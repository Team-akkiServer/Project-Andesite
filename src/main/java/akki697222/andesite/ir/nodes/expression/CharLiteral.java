package akki697222.andesite.ir.nodes.expression;

public class CharLiteral extends LiteralExpression<Character> {
    private final char value;

    public CharLiteral(char value) {
        super(value);
        this.value = value;
    }

    public static CharLiteral convert(String value) {
        if (value != null && value.startsWith("'") && value.endsWith("'") && value.length() == 3) {
            return new CharLiteral(value.substring(1, value.length() - 1).charAt(0));
        }
        return null;
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }
}
