package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public class AssignmentExpression extends Expression {
    private final ChainedReferenceExpression assignmentTarget;
    private final Expression assignments;

    public AssignmentExpression(ChainedReferenceExpression assignmentTarget, Expression assignments) {
        this.assignmentTarget = assignmentTarget;
        this.assignments = assignments;
    }

    public ChainedReferenceExpression getAssignmentTarget() {
        return assignmentTarget;
    }

    public Expression getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        return assignmentTarget + " = " + assignments;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
