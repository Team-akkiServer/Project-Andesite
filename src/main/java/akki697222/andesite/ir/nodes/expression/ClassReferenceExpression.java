package akki697222.andesite.ir.nodes.expression;

public class ClassReferenceExpression extends Expression {
    private final IdentifierExpression identifierExpression;

    public ClassReferenceExpression(IdentifierExpression identifierExpression) {
        this.identifierExpression = identifierExpression;
    }

    public IdentifierExpression getIdentifierExpression() {
        return identifierExpression;
    }
}
