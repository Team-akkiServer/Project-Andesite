package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.statements.Statement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MethodInvokeExpression extends Expression {
    private final String target;
    private final List<Argument> argumentList;

    public MethodInvokeExpression(String target, List<Argument> argumentList) {
        this.target = target;
        this.argumentList = argumentList;
    }

    public String getTarget() {
        return target;
    }

    public List<Argument> getArgumentList() {
        return argumentList;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "INVOKE@" + target + (!argumentList.isEmpty() ? "#" + argumentList : "");
    }
}
