package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.type.Type;

import java.util.List;

public class TypeBound extends Node {
    private final List<Type> bounds;

    public TypeBound(List<Type> bounds) {
        this.bounds = bounds;
    }

    public List<Type> getBounds() {
        return bounds;
    }
}
