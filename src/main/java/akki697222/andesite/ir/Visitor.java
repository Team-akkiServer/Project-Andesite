package akki697222.andesite.ir;

import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import akki697222.andesite.ir.nodes.statements.*;

public interface Visitor {
    void visit(Node node);
    void visit(Program program);
    void visit(FunctionDeclaration functionDeclaration);
    void visit(VariableDeclaration variableDeclaration);
    void visit(ReturnStatement returnStatement);
    void visit(AssignmentExpression assignmentExpression);
    void visit(MethodInvokeExpression methodInvokeExpression);
    void visit(PrintStatement printStatement);
    void visit(IfStatement ifStatement);
    void visit(ForStatement forStatement);
    void visit(WhileStatement whileStatement);
    void visit(ArrayAssignmentExpression arrayAssignmentExpression);
}
