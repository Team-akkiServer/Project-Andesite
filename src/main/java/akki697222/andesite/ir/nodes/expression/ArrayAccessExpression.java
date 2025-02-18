package akki697222.andesite.ir.nodes.expression;

public class ArrayAccessExpression extends Expression {
    private final Expression access;
    private final IdentifierExpression target;

    public ArrayAccessExpression(Expression access, IdentifierExpression target) {
        this.access = access;
        this.target = target;
    }

    public Expression getAccess() {
        return access;
    }

    public IdentifierExpression getTarget() {
        return target;
    }
}
