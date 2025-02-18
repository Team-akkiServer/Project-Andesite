package akki697222.andesite.ir.type;

public class FunctionType implements Type {
    @Override
    public String name() {
        return "function";
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }
}
