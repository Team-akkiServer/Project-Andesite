package akki697222.andesite.ir.nodes.expression;

public class SelfInvokeExpression extends Expression {
    private final MethodInvokeExpression methodInvokeExpression;

    public SelfInvokeExpression(MethodInvokeExpression methodInvokeExpression) {
        this.methodInvokeExpression = methodInvokeExpression;
    }

    public MethodInvokeExpression getMethodInvokeExpression() {
        return methodInvokeExpression;
    }
}
