package akki697222.andesite.core.internal;

public enum BinaryOperation {
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
    L_XOR("^^"),
    ;

    private final String op;

    BinaryOperation(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    public static BinaryOperation get(String op) {
        for (BinaryOperation value : BinaryOperation.values()) {
            if (value.getOp().equals(op)) {
                return value;
            }
        }
        return null;
    }
}
