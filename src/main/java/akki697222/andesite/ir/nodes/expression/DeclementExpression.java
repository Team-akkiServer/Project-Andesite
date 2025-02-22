package akki697222.andesite.ir.nodes.expression;

public class DeclementExpression extends Expression {
    private final ReferenceExpression target;

    public DeclementExpression(ReferenceExpression target) {
        this.target = target;
    }

    public ReferenceExpression getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "--" + target;
    }
}
