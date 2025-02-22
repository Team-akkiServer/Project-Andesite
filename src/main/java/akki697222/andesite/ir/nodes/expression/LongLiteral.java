package akki697222.andesite.ir.nodes.expression;

public class LongLiteral extends NumberLiteral<Long> {
    public LongLiteral(Long value) {
        super(value);
    }

    public static LongLiteral convert(String value) {
        try {
            return new LongLiteral(Long.parseLong(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
