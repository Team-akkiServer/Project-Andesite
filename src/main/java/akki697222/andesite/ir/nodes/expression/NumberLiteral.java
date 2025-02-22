package akki697222.andesite.ir.nodes.expression;

import akki697222.andesite.exceptions.CompileException;

public class NumberLiteral<T extends Number> extends LiteralExpression<T> {
    public NumberLiteral(T value) {
        super(value);
    }

    public static NumberLiteral<?> of(Number number) {
        return switch (number) {
            case Integer i ->
                    new IntegerLiteral(i);
            case Long l ->
                    new LongLiteral(l);
            case Float f ->
                    new FloatLiteral(f);
            case Double d ->
                    new DoubleLiteral(d);
            default -> throw new CompileException("Failed to negate number literal.");
        };
    }

    public static NumberLiteral<?> negate(NumberLiteral<?> numberLiteral) {
        return switch (numberLiteral.getValue()) {
            case Integer i ->
                    new IntegerLiteral(-i);
            case Long l ->
                    new LongLiteral(-l);
            case Float f ->
                    new FloatLiteral(-f);
            case Double d ->
                    new DoubleLiteral(-d);
            default -> throw new CompileException("Failed to negate number literal.");
        };
    }
}
