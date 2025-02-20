package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChainedMethodInvokeExpression extends Expression {
    private final String target;
    private final List<Argument> argumentList;
    private final List<IdentifierExpression> chains;

    public ChainedMethodInvokeExpression(String target, List<Argument> argumentList, List<IdentifierExpression> chains) {
        this.target = target;
        this.argumentList = argumentList;
        this.chains = chains;
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

    public List<IdentifierExpression> getChains() {
        return chains;
    }
}
