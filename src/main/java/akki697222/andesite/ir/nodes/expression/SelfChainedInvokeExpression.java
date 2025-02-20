package akki697222.andesite.ir.nodes.expression;

public class SelfChainedInvokeExpression extends Expression {
    private final ChainedMethodInvokeExpression chainedMethodInvokeExpression;

    public SelfChainedInvokeExpression(ChainedMethodInvokeExpression chainedMethodInvokeExpression) {
        this.chainedMethodInvokeExpression = chainedMethodInvokeExpression;
    }

    public ChainedMethodInvokeExpression getMethodChainExpression() {
        return chainedMethodInvokeExpression;
    }
}
