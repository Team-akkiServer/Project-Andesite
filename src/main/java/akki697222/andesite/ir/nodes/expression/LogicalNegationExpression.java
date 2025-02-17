package akki697222.andesite.ir.nodes.expression;

public class LogicalNegationExpression extends Expression {
    private final Expression value;

    public LogicalNegationExpression(Expression value) {
        this.value = value;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
