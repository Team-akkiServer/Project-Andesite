package akki697222.andesite.ir;

import akki697222.andesite.ir.nodes.*;
import akki697222.andesite.ir.nodes.expression.*;
import akki697222.andesite.ir.nodes.statements.*;
import akki697222.andesite.ir.nodes.type.Program;

public interface Visitor {
    void visit(Node node);
    //Declarations
    void visit(FunctionDeclaration functionDeclaration);
    void visit(NativeFunctionDeclaration nativeFunctionDeclaration);
    void visit(VariableDeclaration variableDeclaration);
    void visit(ClassDeclaration classDeclaration);
    void visit(InterfacesDeclaration interfacesDeclaration);
    //Statements
    void visit(IfStatement ifStatement);
    void visit(ForStatement forStatement);
    void visit(WhileStatement whileStatement);
    void visit(RepeatStatement repeatStatement);
    void visit(ReturnStatement returnStatement);
    void visit(ImportPackage importPackage);
    //Others
    void visit(ChainedReferenceExpression chainedReferenceExpression);
    void visit(Program program);
}
