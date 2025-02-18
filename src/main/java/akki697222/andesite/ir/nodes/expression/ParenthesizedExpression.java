package akki697222.andesite.ir.nodes.expression;

public class ParenthesizedExpression extends Expression {
    private final Expression expression;

    public ParenthesizedExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
