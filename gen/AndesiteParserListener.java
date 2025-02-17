// Generated from D:/Projects/Andesite/src/main/antlr4/akki697222/andesite/compiler/AndesiteParser.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link AndesiteParser#functionalStatements}.
	 * @param ctx the parse tree
	 */
	void enterFunctionalStatements(AndesiteParser.FunctionalStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#functionalStatements}.
	 * @param ctx the parse tree
	 */
	void exitFunctionalStatements(AndesiteParser.FunctionalStatementsContext ctx);
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
	 * Enter a parse tree produced by {@link AndesiteParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void enterMethodBlock(AndesiteParser.MethodBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void exitMethodBlock(AndesiteParser.MethodBlockContext ctx);
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
	 * Enter a parse tree produced by {@link AndesiteParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(AndesiteParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(AndesiteParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(AndesiteParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(AndesiteParser.TypesContext ctx);
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
	 * Enter a parse tree produced by {@link AndesiteParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(AndesiteParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link AndesiteParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(AndesiteParser.ArrayContext ctx);
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