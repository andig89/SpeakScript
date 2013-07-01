// Generated from jfkgrammar.g4 by ANTLR 4.0

package jfk;
import jfk.Compiler;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface jfkgrammarListener extends ParseTreeListener {
	void enterExpression(jfkgrammarParser.ExpressionContext ctx);
	void exitExpression(jfkgrammarParser.ExpressionContext ctx);

	void enterStatement(jfkgrammarParser.StatementContext ctx);
	void exitStatement(jfkgrammarParser.StatementContext ctx);

	void enterInnaKlasa(jfkgrammarParser.InnaKlasaContext ctx);
	void exitInnaKlasa(jfkgrammarParser.InnaKlasaContext ctx);

	void enterProgram(jfkgrammarParser.ProgramContext ctx);
	void exitProgram(jfkgrammarParser.ProgramContext ctx);

	void enterInvocation(jfkgrammarParser.InvocationContext ctx);
	void exitInvocation(jfkgrammarParser.InvocationContext ctx);

	void enterImports(jfkgrammarParser.ImportsContext ctx);
	void exitImports(jfkgrammarParser.ImportsContext ctx);
}