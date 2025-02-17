package akki697222.andesite.ir.nodes.expression;

public abstract class LiteralExpression<T> extends Expression {
    private final T value;

    public LiteralExpression(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static LiteralExpression<?> valueOf(String s) {
        if (s == null) return null;
        if (IntegerLiteral.convert(s) != null) return IntegerLiteral.convert(s);
        if (StringLiteral.convert(s) != null) return StringLiteral.convert(s);
        if (BooleanLiteral.convert(s) != null) return BooleanLiteral.convert(s);
        return null;
    }
}
