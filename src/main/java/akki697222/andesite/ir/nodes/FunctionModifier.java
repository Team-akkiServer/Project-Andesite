package akki697222.andesite.ir.nodes;

public class FunctionModifier extends Modifier {
    private final boolean isOverride;
    private final boolean isStatic;
    private final boolean isAbstract;
    private final boolean isFinal;

    public FunctionModifier(boolean isFinal, boolean isStatic, boolean isAbstract, boolean isOverrided) {
        super(isFinal, isStatic, isAbstract);
        this.isOverride = isOverrided;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
    }

    public boolean isOverride() {
        return isOverride;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public String toString() {
        return "FunctionModifier{" +
                "isOverride=" + isOverride +
                ", isStatic=" + isStatic +
                ", isAbstract=" + isAbstract +
                ", isFinal=" + isFinal +
                '}';
    }
}
