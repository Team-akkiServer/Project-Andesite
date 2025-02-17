package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.nodes.expression.Expression;

public class ForInitializer extends Statement {
    private final Expression iterator;
    private final Expression until;

    public ForInitializer(Expression iterator, Expression until) {
        this.iterator = iterator;
        this.until = until;
    }

    public Expression getIterator() {
        return iterator;
    }

    public Expression getUntil() {
        return until;
    }

    @Override
    public String toString() {
        return "ForInitializer{" +
                "iterator=" + iterator +
                ", until=" + until +
                '}';
    }
}
