package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;

public class TypeParameter extends Node {
    private final String name;

    public TypeParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}