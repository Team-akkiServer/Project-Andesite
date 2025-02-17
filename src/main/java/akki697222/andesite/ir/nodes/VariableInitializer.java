package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.Expression;
import akki697222.andesite.ir.nodes.expression.NullLiteral;

public class VariableInitializer extends Node {
    private final Expression expression;
    public static final VariableInitializer EMPTY = new VariableInitializer(new NullLiteral());

    public VariableInitializer(Expression assignWith) {
        this.expression = assignWith;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
