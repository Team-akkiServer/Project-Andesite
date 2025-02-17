package akki697222.andesite.core.value.objective;

import akki697222.andesite.core.base.Function;
import akki697222.andesite.core.type.FunctionType;
import akki697222.andesite.core.value.Value;

public class FunctionValue implements Value<FunctionType, Function> {
    private final Function function;

    public FunctionValue(Function function) {
        this.function = function;
    }

    @Override
    public Function getValue() {
        return function;
    }

    @Override
    public void setValue(Function value) {
        throw new IllegalStateException("Cannot set value. Function is immutable.");
    }

    @Override
    public FunctionType getType() {
        return new FunctionType();
    }
}
