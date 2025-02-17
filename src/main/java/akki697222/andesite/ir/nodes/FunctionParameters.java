package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FunctionParameters extends Node {
    private final List<FunctionParameter> parameters;

    public FunctionParameters(List<FunctionParameter> parameters) {
        this.parameters = parameters;
        parameters.forEach(functionParameter -> functionParameter.setParent(this));
    }

    public List<FunctionParameter> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return parameters.toString();
    }
}
