package akki697222.andesite.ir.nodes.type;

public class CustomType extends Type {
    private final String name;

    public CustomType(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
