package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;

import java.util.List;

public class ChainedReference extends Node {
    private final List<Reference> references;

    public ChainedReference(List<Reference> references) {
        this.references = references;
    }

    public List<Reference> getReferences() {
        return references;
    }

    @Override
    public String toString() {
        return "ChainedReference{" +
                "references=" + references +
                '}';
    }
}
