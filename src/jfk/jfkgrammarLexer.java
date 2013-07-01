// Generated from jfkgrammar.g4 by ANTLR 4.0

package jfk;
import jfk.Compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class jfkgrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		COMMENT=10, INT=11, ID=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'ustaw'", "'poczatek klasy'", "')'", "'koniec klasy'", "','", "'('", 
		"'='", "'importuj plik'", "'zwroc'", "COMMENT", "INT", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"COMMENT", "INT", "ID", "WS"
	};


	public jfkgrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "jfkgrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 9: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 12: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\17\u0085\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13`\n\13\f\13\16\13c\13"+
		"\13\3\13\5\13f\n\13\3\13\3\13\3\13\3\13\3\13\7\13m\n\13\f\13\16\13p\13"+
		"\13\3\13\3\13\5\13t\n\13\3\13\3\13\3\f\6\fy\n\f\r\f\16\fz\3\r\6\r~\n\r"+
		"\r\r\16\r\177\3\16\3\16\3\16\3\16\3n\17\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1"+
		"\r\b\1\17\t\1\21\n\1\23\13\1\25\f\2\27\r\1\31\16\1\33\17\3\3\2\4\4\f\f"+
		"\17\17\5\f\f\17\17\"\"\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5#\3"+
		"\2\2\2\7\62\3\2\2\2\t\64\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21"+
		"G\3\2\2\2\23U\3\2\2\2\25s\3\2\2\2\27x\3\2\2\2\31}\3\2\2\2\33\u0081\3\2"+
		"\2\2\35\36\7w\2\2\36\37\7u\2\2\37 \7v\2\2 !\7c\2\2!\"\7y\2\2\"\4\3\2\2"+
		"\2#$\7r\2\2$%\7q\2\2%&\7e\2\2&\'\7|\2\2\'(\7c\2\2()\7v\2\2)*\7g\2\2*+"+
		"\7m\2\2+,\7\"\2\2,-\7m\2\2-.\7n\2\2./\7c\2\2/\60\7u\2\2\60\61\7{\2\2\61"+
		"\6\3\2\2\2\62\63\7+\2\2\63\b\3\2\2\2\64\65\7m\2\2\65\66\7q\2\2\66\67\7"+
		"p\2\2\678\7k\2\289\7g\2\29:\7e\2\2:;\7\"\2\2;<\7m\2\2<=\7n\2\2=>\7c\2"+
		"\2>?\7u\2\2?@\7{\2\2@\n\3\2\2\2AB\7.\2\2B\f\3\2\2\2CD\7*\2\2D\16\3\2\2"+
		"\2EF\7?\2\2F\20\3\2\2\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2JK\7q\2\2KL\7t\2\2L"+
		"M\7v\2\2MN\7w\2\2NO\7l\2\2OP\7\"\2\2PQ\7r\2\2QR\7n\2\2RS\7k\2\2ST\7m\2"+
		"\2T\22\3\2\2\2UV\7|\2\2VW\7y\2\2WX\7t\2\2XY\7q\2\2YZ\7e\2\2Z\24\3\2\2"+
		"\2[\\\7\61\2\2\\]\7\61\2\2]a\3\2\2\2^`\n\2\2\2_^\3\2\2\2`c\3\2\2\2a_\3"+
		"\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2df\7\17\2\2ed\3\2\2\2ef\3\2\2\2fg"+
		"\3\2\2\2gt\7\f\2\2hi\7\61\2\2ij\7,\2\2jn\3\2\2\2km\13\2\2\2lk\3\2\2\2"+
		"mp\3\2\2\2no\3\2\2\2nl\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7,\2\2rt\7\61\2\2"+
		"s[\3\2\2\2sh\3\2\2\2tu\3\2\2\2uv\b\13\2\2v\26\3\2\2\2wy\4\62;\2xw\3\2"+
		"\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\30\3\2\2\2|~\4c|\2}|\3\2\2\2~\177"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\32\3\2\2\2\u0081\u0082\t"+
		"\3\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\16\3\2\u0084\34\3\2\2\2\t\2a"+
		"ensz\177";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}