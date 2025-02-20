package akki697222.andesite.ir.nodes.expression;

public class SelfChainedReferenceExpression extends Expression {
    private final ChainedReferenceExpression chainedReferenceExpression;;

    public SelfChainedReferenceExpression(ChainedReferenceExpression chainedReferenceExpression) {
        this.chainedReferenceExpression = chainedReferenceExpression;
    }

    public ChainedReferenceExpression getChainedReferenceExpression() {
        return chainedReferenceExpression;
    }
}
