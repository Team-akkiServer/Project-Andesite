package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Node;

public class Argument extends Expression {
    private final Expression expression;

    public Argument(Expression expression) {
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
