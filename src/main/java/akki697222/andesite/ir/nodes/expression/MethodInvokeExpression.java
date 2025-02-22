package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.statements.Statement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MethodInvokeExpression extends Expression {
    private final IdentifierExpression target;
    private final ArgumentList argumentList;

    public MethodInvokeExpression(IdentifierExpression target, ArgumentList argumentList) {
        this.target = target;
        this.argumentList = argumentList;
    }

    public IdentifierExpression getTarget() {
        return target;
    }

    public ArgumentList getArgumentList() {
        return argumentList;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "MethodInvokeExpression{" +
                "target='" + target + '\'' +
                ", argumentList=" + argumentList +
                '}';
    }
}
