package akki697222.andesite.ir.nodes.expression;

public class SelfChainedAssignmentExpression extends Expression {
    private final ChainedAssignmentExpression chainedAssignmentExpression;

    public SelfChainedAssignmentExpression(ChainedAssignmentExpression chainedAssignmentExpression) {
        this.chainedAssignmentExpression = chainedAssignmentExpression;
    }

    public ChainedAssignmentExpression getChainedAssignmentExpression() {
        return chainedAssignmentExpression;
    }
}
