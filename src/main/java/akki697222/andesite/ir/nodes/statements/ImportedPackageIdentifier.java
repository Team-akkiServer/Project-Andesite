package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;

public class ImportedPackageIdentifier extends Node {
    private final IdentifierExpression from;
    private final IdentifierExpression as;

    public ImportedPackageIdentifier(IdentifierExpression from, IdentifierExpression as) {
        this.from = from;
        this.as = as;
    }

    public ImportedPackageIdentifier(IdentifierExpression from) {
        this.from = from;
        this.as = from;
    }

    public IdentifierExpression getFrom() {
        return from;
    }

    public IdentifierExpression getAs() {
        return as;
    }

    @Override
    public String toString() {
        return "ImportedPackageIdentifier{" +
                "from=" + from +
                ", as=" + as +
                '}';
    }
}
