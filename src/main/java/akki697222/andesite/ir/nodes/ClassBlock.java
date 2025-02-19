package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ClassBlock extends Node {
    private final List<VariableDeclaration> fields;
    private final List<FunctionDeclaration> methods;
    private final List<ClassDeclaration> classes;
    private final List<InterfacesDeclaration> interfaces;

    public ClassBlock(List<VariableDeclaration> fields, List<FunctionDeclaration> methods, List<ClassDeclaration> classes, List<InterfacesDeclaration> interfaces) {
        this.fields = fields;
        this.methods = methods;
        this.classes = classes;
        this.interfaces = interfaces;
        fields.forEach(field -> field.setParent(this));
        methods.forEach(method -> method.setParent(this));
    }

    public List<FunctionDeclaration> getMethods() {
        return methods;
    }

    public List<VariableDeclaration> getFields() {
        return fields;
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        for (VariableDeclaration variableDeclaration : fields) {
            variableDeclaration.accept(visitor);
        }
        for (FunctionDeclaration functionDeclaration : methods) {
            functionDeclaration.accept(visitor);
        }
    }

    public List<ClassDeclaration> getClasses() {
        return classes;
    }

    public List<InterfacesDeclaration> getInterfaces() {
        return interfaces;
    }

    @Override
    public String toString() {
        return "ClassBlock{" +
                "fields=" + fields +
                ", methods=" + methods +
                ", classes=" + classes +
                ", interfaces=" + interfaces +
                '}';
    }
}
