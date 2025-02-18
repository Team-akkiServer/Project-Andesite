package akki697222.andesite.ir.nodes.expression;

import java.util.ArrayList;
import java.util.List;

public class ArrayInitializerExpression extends Expression {
    private final List<Expression> initialValue;

    public ArrayInitializerExpression(List<Expression> initialValue) {
        this.initialValue = initialValue;
    }

    public ArrayInitializerExpression() {
        this.initialValue = new ArrayList<>();
    }

    public List<Expression> getInitialValue() {
        return initialValue;
    }

    @Override
    public String toString() {
        return initialValue.toString();
    }
}
