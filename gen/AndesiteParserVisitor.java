// Generated from D:/Projects/Andesite/src/main/antlr4/akki697222/andesite/compiler/AndesiteParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AndesiteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AndesiteParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AndesiteParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(AndesiteParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#functionalStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionalStatements(AndesiteParser.FunctionalStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(AndesiteParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#methodBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBlock(AndesiteParser.MethodBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(AndesiteParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(AndesiteParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#methodInvoke}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvoke(AndesiteParser.MethodInvokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(AndesiteParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(AndesiteParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(AndesiteParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(AndesiteParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#baseTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypes(AndesiteParser.BaseTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(AndesiteParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(AndesiteParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(AndesiteParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(AndesiteParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link AndesiteParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(AndesiteParser.NumberContext ctx);
}