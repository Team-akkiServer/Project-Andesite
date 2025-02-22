package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.ir.nodes.FunctionParameters;

public class InstantiateExpression extends Expression {
    private final IdentifierExpression targetClass;
    private final ArgumentList argumentList;

    public InstantiateExpression(IdentifierExpression targetClass, ArgumentList argumentList) {
        this.targetClass = targetClass;
        this.argumentList = argumentList;
    }

    public ArgumentList getArgumentList() {
        return argumentList;
    }

    public IdentifierExpression getTargetClass() {
        return targetClass;
    }

    @Override
    public String toString() {
        return "InstantiateExpression{" +
                "targetClass=" + targetClass +
                ", argumentList=" + argumentList +
                '}';
    }
}
