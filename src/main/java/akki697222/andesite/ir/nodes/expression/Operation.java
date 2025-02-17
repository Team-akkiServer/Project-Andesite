package akki697222.andesite.ir.nodes.expression;

import java.util.Arrays;

public enum Operation {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    B_AND("&"),
    B_OR("|"),
    B_XOR("^"),
    B_NOT("~"),
    B_LSHIFT("<<"),
    B_RSHIFT(">>"),
    EQ("=="),
    NE("!="),
    GT(">"),
    LT("<"),
    GTE(">="),
    LTE("<="),
    L_AND("&&"),
    L_OR("||"),
    L_NOT("!"),
    L_XOR("^^"),
    ;

    private final String op;

    Operation(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    public static Operation get(String op) {
        for (Operation value : Operation.values()) {
            if (value.getOp().equals(op)) {
                return value;
            }
        }
        return null;
    }
}
