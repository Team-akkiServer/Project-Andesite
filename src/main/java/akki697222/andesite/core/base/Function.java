package akki697222.andesite.core.base;

import akki697222.andesite.core.type.Type;
import akki697222.andesite.core.value.Value;
import akki697222.andesite.core.value.primitive.PrimitiveValue;
import akki697222.andesite.exceptions.AndesiteExecutionException;
import akki697222.andesite.interpreter.AndesiteInterpreter;
import akki697222.andesite.ir.AccessModifier;
import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static akki697222.andesite.interpreter.AndesiteInterpreter.invoke;
import static akki697222.andesite.interpreter.AndesiteInterpreter.logger;

public class Function implements BaseObject {
    private final FunctionDeclaration declarationData;
    private final List<Variable> fields = new ArrayList<>();

    public Function(@NotNull FunctionDeclaration declarationData) {
        this.declarationData = declarationData;
    }

    public List<Variable> getFields() {
        return fields;
    }

    public void addField(Variable variable) {
        fields.add(variable);
    }

    public FunctionDeclaration getData() {
        return declarationData;
    }

    public Value<?, ?> eval(@NotNull List<Argument> args) {
        fields.clear();
        List<FunctionParameter> parameters = declarationData.getParameters().getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            switch (args.get(i).getExpression()) {
                case LiteralExpression<?> literalExpression -> {
                    fields.add(new Variable(parameters.get(i).getName(), parameters.get(i).getType(), AndesiteInterpreter.convertLiteralExpressionToValue(literalExpression)));
                }
                case IdentifierExpression identifierExpression -> {
                    Variable var = AndesiteInterpreter.getSpecifiedVariable(identifierExpression.getIdentifier());
                    if (var != null) {
                        fields.add(new Variable(parameters.get(i).getName(), parameters.get(i).getType(), var.getValue()));
                    } else {
                        throw new AndesiteExecutionException("Attempt to call undefined variable '" + identifierExpression.getIdentifier() + "'");
                    }
                }
                case MethodInvokeExpression methodInvokeExpression ->
                        fields.add(new Variable(parameters.get(i).getName(), parameters.get(i).getType(), AndesiteInterpreter.instance.invokeMethod(methodInvokeExpression)));
                case null, default ->
                        fields.add(new Variable(parameters.get(i).getName(), parameters.get(i).getType(), AndesiteInterpreter.convertExpressionToValue(args.get(i).getExpression())));
            }
        }
        return AndesiteInterpreter.invoke(this, fields);
    }

    private Variable getFieldFromList(String name, List<Variable> fields) {
        for (Variable field : fields) {
            if (field.getName().equals(name)) {
                return field;
            }
        }
        return null;
    }

    @Override
    public Value<?, ?> eval() {
        return null;
    }

    @Override
    public String toString() {
        return "Function{" +
                "declarationData=" + declarationData +
                ", fields=" + fields +
                '}';
    }
}
