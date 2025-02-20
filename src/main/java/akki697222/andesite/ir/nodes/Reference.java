package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.*;

public class Reference extends Node {
    private final ReferenceType type;
    private final Expression expression;

    public Reference(ReferenceType type, Expression expression) {
        this.type = type;
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public ReferenceType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "type=" + type +
                ", expression=" + expression +
                '}';
    }
}
