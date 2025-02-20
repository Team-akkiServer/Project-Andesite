package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.nodes.expression.ArrayReferenceExpression;
import akki697222.andesite.ir.nodes.expression.Expression;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;
import akki697222.andesite.ir.nodes.expression.MethodInvokeExpression;

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
