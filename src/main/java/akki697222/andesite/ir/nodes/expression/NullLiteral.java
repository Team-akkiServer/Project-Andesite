package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.core.type.primitive.NullType;

public class NullLiteral extends LiteralExpression<NullType> {
    public NullLiteral() {
        super(new NullType());
    }

    public static NullLiteral convert(String s) {
        if (s.equals("null") || s.equals("undefined")) {
            return new NullLiteral();
        }
        return null;
    }
}
