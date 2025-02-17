package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.core.type.primitive.NullType;

public class NullLiteral extends LiteralExpression<NullType> {
    public NullLiteral() {
        super(new NullType());
    }
}
