package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.nodes.expression.ChainedReferenceExpression;

public class SelfAssignmentExpression extends Expression {
    private final AssignmentExpression assignmentExpression;

    public SelfAssignmentExpression(AssignmentExpression assignmentExpression) {
        this.assignmentExpression = assignmentExpression;
    }

    public AssignmentExpression getAssignmentExpression() {
        return assignmentExpression;
    }

    @Override
    public String toString() {
        return "SelfAssignmentExpression{" +
                "assignmentExpression=" + assignmentExpression +
                '}';
    }
}
