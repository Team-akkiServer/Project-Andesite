package akki697222.andesite.core.base;

import akki697222.andesite.core.type.Type;
import akki697222.andesite.core.value.Value;

public class Variable implements BaseObject {
    protected Value<?, ?> value;
    protected final Type type;
    protected String name;

    public Variable(String name, Type type, Value<?, ?> value) {
        this.type = type;
        this.value = value;
        this.name = name;
    }

    public void setValue(Value<?, ?> value) {
        this.value = value;
    }

    public Value<?, ?> getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Value<?, ?> eval() {
        return value;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "value=" + (value != null ? value.getValue().toString() : "undefined") +
                ", type=" + type.name() +
                ", name=" + name +
                '}';
    }
}
