// Generated from jfkgrammar.g4 by ANTLR 4.1

package jfk;
import jfk.Compiler;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link jfkgrammarParser}.
 */
public interface jfkgrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull jfkgrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull jfkgrammarParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(@NotNull jfkgrammarParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(@NotNull jfkgrammarParser.MultExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull jfkgrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull jfkgrammarParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull jfkgrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull jfkgrammarParser.AtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#innaKlasa}.
	 * @param ctx the parse tree
	 */
	void enterInnaKlasa(@NotNull jfkgrammarParser.InnaKlasaContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#innaKlasa}.
	 * @param ctx the parse tree
	 */
	void exitInnaKlasa(@NotNull jfkgrammarParser.InnaKlasaContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull jfkgrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull jfkgrammarParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull jfkgrammarParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull jfkgrammarParser.AddExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(@NotNull jfkgrammarParser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(@NotNull jfkgrammarParser.InvocationContext ctx);

	/**
	 * Enter a parse tree produced by {@link jfkgrammarParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(@NotNull jfkgrammarParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link jfkgrammarParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(@NotNull jfkgrammarParser.ImportsContext ctx);
}