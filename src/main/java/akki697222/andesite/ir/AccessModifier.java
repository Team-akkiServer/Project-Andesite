package akki697222.andesite.ir;

public enum AccessModifier {
    PUBLIC,
    PRIVATE,
    PROTECTED;

    public AccessModifier get(String s) {
        return AccessModifier.valueOf(s.toUpperCase());
    }
}
