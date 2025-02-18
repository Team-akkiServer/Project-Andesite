package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

public class ArrayAssignmentExpression extends Expression {
    private final IdentifierExpression assignmentTarget;
    private final IntegerLiteral assignmentTargetIndex;
    private final Expression assignments;

    public ArrayAssignmentExpression(IdentifierExpression assignmentTarget, IntegerLiteral assignmentTargetIndex, Expression assignments) {
        this.assignmentTarget = assignmentTarget;
        this.assignmentTargetIndex = assignmentTargetIndex;
        this.assignments = assignments;
    }

    public IdentifierExpression getAssignmentTarget() {
        return assignmentTarget;
    }

    public Expression getAssignments() {
        return assignments;
    }

    public IntegerLiteral getAssignmentTargetIndex() {
        return assignmentTargetIndex;
    }

    @Override
    public String toString() {
        return assignmentTarget + "[" + assignmentTargetIndex + "] = " + assignments;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
