package akki697222.andesite.interpreter;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import akki697222.andesite.ir.nodes.Block;
import akki697222.andesite.ir.nodes.FunctionDeclaration;
import akki697222.andesite.ir.nodes.Program;
import akki697222.andesite.ir.nodes.VariableDeclaration;
import akki697222.andesite.ir.nodes.expression.ArrayAssignmentExpression;
import akki697222.andesite.ir.nodes.expression.AssignmentExpression;
import akki697222.andesite.ir.nodes.expression.MethodInvokeExpression;
import akki697222.andesite.ir.nodes.statements.*;

public class AndesiteInterpreter implements Visitor {
    public AndesiteInterpreter(String code) {

    }

    public void run() {

    }

    @Override
    public void visit(Node node) {

    }

    @Override
    public void visit(Program program) {

    }

    @Override
    public void visit(FunctionDeclaration functionDeclaration) {

    }

    @Override
    public void visit(VariableDeclaration variableDeclaration) {

    }

    @Override
    public void visit(ReturnStatement returnStatement) {

    }

    @Override
    public void visit(AssignmentExpression assignmentExpression) {

    }

    @Override
    public void visit(MethodInvokeExpression methodInvokeExpression) {

    }

    @Override
    public void visit(PrintStatement printStatement) {

    }

    @Override
    public void visit(IfStatement ifStatement) {

    }

    @Override
    public void visit(ForStatement forStatement) {

    }

    @Override
    public void visit(WhileStatement whileStatement) {

    }

    @Override
    public void visit(ArrayAssignmentExpression arrayAssignmentExpression) {

    }

    public void executeWithLocalScope(Block block) {

    }
}
