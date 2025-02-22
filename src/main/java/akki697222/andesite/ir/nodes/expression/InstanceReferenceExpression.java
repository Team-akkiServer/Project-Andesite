package akki697222.andesite.ir.nodes.expression;

public class InstanceReferenceExpression extends Expression {
    private final InstantiateExpression instantiateExpression;
    private final ChainedReferenceExpression chainedReferenceExpression;

    public InstanceReferenceExpression(InstantiateExpression instantiateExpression, ChainedReferenceExpression chainedReferenceExpression) {
        this.instantiateExpression = instantiateExpression;
        this.chainedReferenceExpression = chainedReferenceExpression;
    }

    public ChainedReferenceExpression getChainedReferenceExpression() {
        return chainedReferenceExpression;
    }

    public InstantiateExpression getInstantiateExpression() {
        return instantiateExpression;
    }

    @Override
    public String toString() {
        return "InstanceReferenceExpression{" +
                "instantiateExpression=" + instantiateExpression +
                ", chainedReferenceExpression=" + chainedReferenceExpression +
                '}';
    }
}
