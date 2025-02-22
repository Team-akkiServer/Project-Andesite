package akki697222.andesite.ir.nodes.expression;

public enum ReferenceType {
    INVOKE(MethodInvokeExpression.class),
    IDENTIFIER(IdentifierExpression.class),
    ARRAY(ArrayReferenceExpression.class);

    private final Class<? extends Expression> clazz;

    ReferenceType(Class<? extends Expression> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Expression> geExpressionClass() {
        return clazz;
    }

    @Override
    public String toString() {
        return "ReferenceType{" +
                "class=" + clazz.getSimpleName() +
                '}';
    }
}
