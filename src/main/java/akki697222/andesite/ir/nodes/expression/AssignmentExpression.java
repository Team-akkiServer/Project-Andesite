package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public class AssignmentExpression extends Expression {
    private final IdentifierExpression assignmentTarget;
    private final Expression assignments;

    public AssignmentExpression(IdentifierExpression assignmentTarget, Expression assignments) {
        this.assignmentTarget = assignmentTarget;
        this.assignments = assignments;
    }

    public IdentifierExpression getAssignmentTarget() {
        return assignmentTarget;
    }

    public Expression getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        return "'" + assignmentTarget + "' = " + assignments;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
