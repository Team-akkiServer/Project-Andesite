package akki697222.andesite.ir.nodes.statements;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImportPackage extends Statement {
    private final String source;
    private final List<ImportedPackageIdentifier> imports;

    public ImportPackage(String sourceName, List<ImportedPackageIdentifier> imports) {
        this.source = sourceName;
        this.imports = imports;
    }

    public String getSourceName() {
        return source;
    }

    public List<ImportedPackageIdentifier> getImports() {
        return imports;
    }

    @Override
    public String toString() {
        return "ImportPackage{" +
                "source='" + source + '\'' +
                ", imports=" + imports +
                '}';
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
