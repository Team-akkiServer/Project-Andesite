package akki697222.andesite.ir.type;

public record ClassType(String name) implements Type {
    @Override
    public boolean isPrimitive() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
