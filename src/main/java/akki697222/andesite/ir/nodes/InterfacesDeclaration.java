package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;
import akki697222.andesite.ir.nodes.type.Type;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class InterfacesDeclaration extends Node {
    private final AccessModifier accessModifier;
    private final String name;
    private final List<Type> interfacesExtends;
    private final ClassBlock classBlock;

    public InterfacesDeclaration(AccessModifier accessModifier, String name, List<Type> interfacesExtends, ClassBlock classBlock) {
        this.accessModifier = accessModifier;
        this.name = name;
        this.interfacesExtends = interfacesExtends;
        this.classBlock = classBlock;
    }

    public List<Type> getInterfaceExtends() {
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

    @Override
    public void accept(@NotNull Visitor visitor) {
        visitor.visit(this);
    }
}
