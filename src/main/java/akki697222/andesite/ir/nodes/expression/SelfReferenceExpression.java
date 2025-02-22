package akki697222.andesite.ir.nodes.expression;

public class SelfReferenceExpression extends Expression {
    private final ChainedReferenceExpression chainedReferenceExpression;

    public SelfReferenceExpression(ChainedReferenceExpression chainedReferenceExpression) {
        this.chainedReferenceExpression = chainedReferenceExpression;
    }

    public ChainedReferenceExpression getChainedReferenceExpression() {
        return chainedReferenceExpression;
    }

    @Override
    public String toString() {
        return "SelfReferenceExpression{" +
                "chainedReferenceExpression=" + chainedReferenceExpression +
                '}';
    }
}
