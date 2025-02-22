package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChainedReferenceExpression extends Expression {
    private final List<ReferenceExpression> referenceExpressions;

    public ChainedReferenceExpression(List<ReferenceExpression> referenceExpressions) {
        this.referenceExpressions = referenceExpressions;
    }

    public List<ReferenceExpression> getReferences() {
        return referenceExpressions;
    }

    @Override
    public String toString() {
        return "ChainedReferenceExpression{" +
                "references=" + referenceExpressions +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
