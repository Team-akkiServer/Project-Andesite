package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;

public class Modifier extends Node {
    private final boolean isFinal;
    private final boolean isStatic;
    private final boolean isAbstract;

    public Modifier(boolean isFinal, boolean isStatic, boolean isAbstract) {
        this.isFinal = isFinal;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public String toString() {
        return "Modifier{" +
                "isFinal=" + isFinal +
                ", isStatic=" + isStatic +
                ", isAbstract=" + isAbstract +
                '}';
    }
}
