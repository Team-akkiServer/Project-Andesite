package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.nodes.expression.IdentifierExpression;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClassDeclaration extends Node {
    private final ClassBlock classBlock;
    private final String name;
    private final Modifier modifier;
    private final IdentifierExpression classExtends;
    private final List<IdentifierExpression> interfacesImplements;
    private final AccessModifier accessModifier;
    private final @Nullable ClassConstructor constructor;

    public ClassDeclaration(ClassBlock classBlock, String name, Modifier modifier, IdentifierExpression classExtends, List<IdentifierExpression> interfacesImplements, AccessModifier accessModifier, @Nullable ClassConstructor constructor) {
        this.classBlock = classBlock;
        this.name = name;
        this.modifier = modifier;
        this.classExtends = classExtends;
        this.interfacesImplements = interfacesImplements;
        this.accessModifier = accessModifier;
        this.constructor = constructor;
    }

    public List<IdentifierExpression> getInterfacesImplements() {
        return interfacesImplements;
    }

    public IdentifierExpression getClassExtends() {
        return classExtends;
    }

    public Modifier getModifier() {
        return modifier;
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
                ", modifier=" + modifier +
                ", classExtends=" + classExtends +
                ", interfacesImplements=" + interfacesImplements +
                ", accessModifier=" + accessModifier +
                ", constructor=" + constructor +
                '}';
    }

    public @Nullable ClassConstructor getConstructor() {
        return constructor;
    }
}
