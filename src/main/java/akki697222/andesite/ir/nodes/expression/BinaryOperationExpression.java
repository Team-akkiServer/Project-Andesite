package akki697222.andesite.ir.nodes.expression;

public class BinaryOperationExpression extends Expression {
    protected final Expression left;
    protected final Expression right;
    protected final Operation op;

    public BinaryOperationExpression(Expression left, Expression right, Operation op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Operation getOp() {
        return op;
    }

    @Override
    public String toString() {
        return left.toString() + op.getOp() + right.toString();
    }
}
