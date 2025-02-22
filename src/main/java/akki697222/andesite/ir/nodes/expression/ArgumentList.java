package akki697222.andesite.ir.nodes.expression;

import java.util.List;

public class ArgumentList extends Expression {
    private final List<Argument> argumentList;

    public ArgumentList(List<Argument> argumentList) {
        this.argumentList = argumentList;
    }

    public List<Argument> getArgumentList() {
        return argumentList;
    }

    @Override
    public String toString() {
        return "ArgumentList{" +
                "argumentList=" + argumentList +
                '}';
    }
}
