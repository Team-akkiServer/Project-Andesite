package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;

import java.util.List;

public class InterfacesDeclaration extends Node {
    private final AccessModifier accessModifier;
    private final String name;
    private final IdentifierExpression interfacesExtends;
    private final ClassBlock classBlock;

    public InterfacesDeclaration(AccessModifier accessModifier, String name, IdentifierExpression interfacesExtends, ClassBlock classBlock) {
        this.accessModifier = accessModifier;
        this.name = name;
        this.interfacesExtends = interfacesExtends;
        this.classBlock = classBlock;
    }

    public IdentifierExpression getInterfacesExtends() {
        return interfacesExtends;
    }

    public ClassBlock getClassBlock() {
        return classBlock;
    }

    public String getName() {
        return name;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "InterfacesDeclaration{" +
                "accessModifier=" + accessModifier +
                ", name='" + name + '\'' +
                ", interfacesExtends=" + interfacesExtends +
                ", classBlock=" + classBlock +
                '}';
    }
}
