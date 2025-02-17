package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.expression.Expression;
import org.jetbrains.annotations.NotNull;

public class ReturnStatement extends Statement {
    public final Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "ReturnStatement{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
