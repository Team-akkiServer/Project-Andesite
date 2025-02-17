package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.expression.Expression;
import akki697222.andesite.ir.nodes.expression.StringLiteral;
import org.jetbrains.annotations.NotNull;

public class PrintStatement extends Statement {
    public final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getStringLiteral() {
        return expression;
    }

    @Override
    public String toString() {
        return "PrintStatement{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
