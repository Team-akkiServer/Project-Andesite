// Generated from akki697222/andesite/compiler/AndesiteParser.g4 by ANTLR 4.13.2
package akki697222.andesite.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AndesiteParser}.
 */
public interface AndesiteParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AndesiteParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AndesiteParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AndesiteParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AndesiteParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(AndesiteParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(AndesiteParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(AndesiteParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(AndesiteParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(AndesiteParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(AndesiteParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(AndesiteParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(AndesiteParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(AndesiteParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(AndesiteParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(AndesiteParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(AndesiteParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(AndesiteParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(AndesiteParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#forInitializer}.
	 * @param ctx the parse tree
	 */
	void enterForInitializer(AndesiteParser.ForInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#forInitializer}.
	 * @param ctx the parse tree
	 */
	void exitForInitializer(AndesiteParser.ForInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#forUntil}.
	 * @param ctx the parse tree
	 */
	void enterForUntil(AndesiteParser.ForUntilContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#forUntil}.
	 * @param ctx the parse tree
	 */
	void exitForUntil(AndesiteParser.ForUntilContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(AndesiteParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(AndesiteParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(AndesiteParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(AndesiteParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AndesiteParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AndesiteParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(AndesiteParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(AndesiteParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(AndesiteParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(AndesiteParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(AndesiteParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(AndesiteParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(AndesiteParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(AndesiteParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(AndesiteParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(AndesiteParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(AndesiteParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(AndesiteParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#rightExpression}.
	 * @param ctx the parse tree
	 */
	void enterRightExpression(AndesiteParser.RightExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#rightExpression}.
	 * @param ctx the parse tree
	 */
	void exitRightExpression(AndesiteParser.RightExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(AndesiteParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(AndesiteParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(AndesiteParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(AndesiteParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(AndesiteParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(AndesiteParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(AndesiteParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(AndesiteParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseXorExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseXorExpression(AndesiteParser.BitwiseXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseXorExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseXorExpression(AndesiteParser.BitwiseXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(AndesiteParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(AndesiteParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseShiftExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseShiftExpression(AndesiteParser.BitwiseShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseShiftExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseShiftExpression(AndesiteParser.BitwiseShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAssignmentExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignmentExpression(AndesiteParser.ArrayAssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAssignmentExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignmentExpression(AndesiteParser.ArrayAssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalNegationExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNegationExpression(AndesiteParser.LogicalNegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalNegationExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNegationExpression(AndesiteParser.LogicalNegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayInitializerExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializerExpression(AndesiteParser.ArrayInitializerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayInitializerExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializerExpression(AndesiteParser.ArrayInitializerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(AndesiteParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(AndesiteParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(AndesiteParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(AndesiteParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundAssignmentExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignmentExpression(AndesiteParser.CompoundAssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundAssignmentExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignmentExpression(AndesiteParser.CompoundAssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(AndesiteParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(AndesiteParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalXorExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalXorExpression(AndesiteParser.LogicalXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalXorExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalXorExpression(AndesiteParser.LogicalXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(AndesiteParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(AndesiteParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(AndesiteParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(AndesiteParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpression(AndesiteParser.NegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpression(AndesiteParser.NegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccessExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(AndesiteParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccessExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(AndesiteParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(AndesiteParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(AndesiteParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(AndesiteParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AndesiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(AndesiteParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(AndesiteParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(AndesiteParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#arrayItems}.
	 * @param ctx the parse tree
	 */
	void enterArrayItems(AndesiteParser.ArrayItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#arrayItems}.
	 * @param ctx the parse tree
	 */
	void exitArrayItems(AndesiteParser.ArrayItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(AndesiteParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(AndesiteParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(AndesiteParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(AndesiteParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(AndesiteParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(AndesiteParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodInvokeExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvokeExpression(AndesiteParser.MethodInvokeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodInvokeExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvokeExpression(AndesiteParser.MethodInvokeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(AndesiteParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link AndesiteParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(AndesiteParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#methodInvoke}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvoke(AndesiteParser.MethodInvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#methodInvoke}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvoke(AndesiteParser.MethodInvokeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalType}
	 * labeled alternative in {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 */
	void enterNormalType(AndesiteParser.NormalTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalType}
	 * labeled alternative in {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 */
	void exitNormalType(AndesiteParser.NormalTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(AndesiteParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(AndesiteParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#baseTypes}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypes(AndesiteParser.BaseTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#baseTypes}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypes(AndesiteParser.BaseTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(AndesiteParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(AndesiteParser.PrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(AndesiteParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(AndesiteParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(AndesiteParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(AndesiteParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(AndesiteParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(AndesiteParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(AndesiteParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(AndesiteParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(AndesiteParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link AndesiteParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(AndesiteParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(AndesiteParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(AndesiteParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(AndesiteParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(AndesiteParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(AndesiteParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(AndesiteParser.NumberContext ctx);
}