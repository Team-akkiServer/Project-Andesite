package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;

import java.util.List;

public class ClassDeclaration extends Node {
    private final ClassBlock classBlock;
    private final String name;
    private final boolean isAbstract;
    private final IdentifierExpression classExtends;
    private final List<IdentifierExpression> interfacesImplements;
    private final AccessModifier accessModifier;

    public ClassDeclaration(ClassBlock classBlock, String name, boolean isAbstract, IdentifierExpression classExtends, List<IdentifierExpression> interfacesImplements, AccessModifier accessModifier) {
        this.classBlock = classBlock;
        this.name = name;
        this.isAbstract = isAbstract;
        this.classExtends = classExtends;
        this.interfacesImplements = interfacesImplements;
        this.accessModifier = accessModifier;
    }

    public List<IdentifierExpression> getInterfacesImplements() {
        return interfacesImplements;
    }

    public IdentifierExpression getClassExtends() {
        return classExtends;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public String getName() {
        return name;
    }

    public ClassBlock getClassBlock() {
        return classBlock;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "ClassDeclaration{" +
                "classBlock=" + classBlock +
                ", name='" + name + '\'' +
                ", isAbstract=" + isAbstract +
                ", classExtends=" + classExtends +
                ", interfacesImplements=" + interfacesImplements +
                ", accessModifier=" + accessModifier +
                '}';
    }
}
