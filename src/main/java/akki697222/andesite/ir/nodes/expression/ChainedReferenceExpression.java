package akki697222.andesite.ir.nodes.expression;

import java.util.List;

public class ChainedReferenceExpression extends Expression {
    private final List<IdentifierExpression> chains;

    public ChainedReferenceExpression(List<IdentifierExpression> chains) {
        this.chains = chains;
    }

    public List<IdentifierExpression> getChains() {
        return chains;
    }
}
