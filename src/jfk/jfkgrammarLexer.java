// Generated from jfkgrammar.g4 by ANTLR 4.1

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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, COMMENT=16, INT=17, 
		DOUBLE=18, ID=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'poczatek klasy'", "','", "'+'", "'*'", "'-'", "'('", "'='", "'drukuj'", 
		"'ustaw'", "'koniec klasy'", "'/'", "'wczytaj wartosc z klawiatury do zmiennej'", 
		"'importuj plik'", "'zwroc'", "COMMENT", "INT", "DOUBLE", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "COMMENT", "INT", "DOUBLE", 
		"ID", "WS"
	};

	    
	    enum typeValue {
	        NUMBER, LITERA
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
		case 15: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 19: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\26\u00d6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00a6\n\21\f\21\16\21\u00a9\13"+
		"\21\3\21\5\21\u00ac\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u00b3\n\21\f\21"+
		"\16\21\u00b6\13\21\3\21\3\21\5\21\u00ba\n\21\3\21\3\21\3\22\6\22\u00bf"+
		"\n\22\r\22\16\22\u00c0\3\23\6\23\u00c4\n\23\r\23\16\23\u00c5\3\23\3\23"+
		"\6\23\u00ca\n\23\r\23\16\23\u00cb\3\24\6\24\u00cf\n\24\r\24\16\24\u00d0"+
		"\3\25\3\25\3\25\3\25\3\u00b4\26\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22"+
		"\2#\23\1%\24\1\'\25\1)\26\3\3\2\4\4\2\f\f\17\17\5\2\f\f\17\17\"\"\u00dd"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7<\3\2\2"+
		"\2\t>\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23H\3\2\2"+
		"\2\25O\3\2\2\2\27U\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35\u008d\3\2\2\2\37"+
		"\u009b\3\2\2\2!\u00b9\3\2\2\2#\u00be\3\2\2\2%\u00c3\3\2\2\2\'\u00ce\3"+
		"\2\2\2)\u00d2\3\2\2\2+,\7+\2\2,\4\3\2\2\2-.\7r\2\2./\7q\2\2/\60\7e\2\2"+
		"\60\61\7|\2\2\61\62\7c\2\2\62\63\7v\2\2\63\64\7g\2\2\64\65\7m\2\2\65\66"+
		"\7\"\2\2\66\67\7m\2\2\678\7n\2\289\7c\2\29:\7u\2\2:;\7{\2\2;\6\3\2\2\2"+
		"<=\7.\2\2=\b\3\2\2\2>?\7-\2\2?\n\3\2\2\2@A\7,\2\2A\f\3\2\2\2BC\7/\2\2"+
		"C\16\3\2\2\2DE\7*\2\2E\20\3\2\2\2FG\7?\2\2G\22\3\2\2\2HI\7f\2\2IJ\7t\2"+
		"\2JK\7w\2\2KL\7m\2\2LM\7w\2\2MN\7l\2\2N\24\3\2\2\2OP\7w\2\2PQ\7u\2\2Q"+
		"R\7v\2\2RS\7c\2\2ST\7y\2\2T\26\3\2\2\2UV\7m\2\2VW\7q\2\2WX\7p\2\2XY\7"+
		"k\2\2YZ\7g\2\2Z[\7e\2\2[\\\7\"\2\2\\]\7m\2\2]^\7n\2\2^_\7c\2\2_`\7u\2"+
		"\2`a\7{\2\2a\30\3\2\2\2bc\7\61\2\2c\32\3\2\2\2de\7y\2\2ef\7e\2\2fg\7|"+
		"\2\2gh\7{\2\2hi\7v\2\2ij\7c\2\2jk\7l\2\2kl\7\"\2\2lm\7y\2\2mn\7c\2\2n"+
		"o\7t\2\2op\7v\2\2pq\7q\2\2qr\7u\2\2rs\7e\2\2st\7\"\2\2tu\7|\2\2uv\7\""+
		"\2\2vw\7m\2\2wx\7n\2\2xy\7c\2\2yz\7y\2\2z{\7k\2\2{|\7c\2\2|}\7v\2\2}~"+
		"\7w\2\2~\177\7t\2\2\177\u0080\7{\2\2\u0080\u0081\7\"\2\2\u0081\u0082\7"+
		"f\2\2\u0082\u0083\7q\2\2\u0083\u0084\7\"\2\2\u0084\u0085\7|\2\2\u0085"+
		"\u0086\7o\2\2\u0086\u0087\7k\2\2\u0087\u0088\7g\2\2\u0088\u0089\7p\2\2"+
		"\u0089\u008a\7p\2\2\u008a\u008b\7g\2\2\u008b\u008c\7l\2\2\u008c\34\3\2"+
		"\2\2\u008d\u008e\7k\2\2\u008e\u008f\7o\2\2\u008f\u0090\7r\2\2\u0090\u0091"+
		"\7q\2\2\u0091\u0092\7t\2\2\u0092\u0093\7v\2\2\u0093\u0094\7w\2\2\u0094"+
		"\u0095\7l\2\2\u0095\u0096\7\"\2\2\u0096\u0097\7r\2\2\u0097\u0098\7n\2"+
		"\2\u0098\u0099\7k\2\2\u0099\u009a\7m\2\2\u009a\36\3\2\2\2\u009b\u009c"+
		"\7|\2\2\u009c\u009d\7y\2\2\u009d\u009e\7t\2\2\u009e\u009f\7q\2\2\u009f"+
		"\u00a0\7e\2\2\u00a0 \3\2\2\2\u00a1\u00a2\7\61\2\2\u00a2\u00a3\7\61\2\2"+
		"\u00a3\u00a7\3\2\2\2\u00a4\u00a6\n\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00aa\u00ac\7\17\2\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ba\7\f\2\2\u00ae\u00af\7\61\2\2\u00af"+
		"\u00b0\7,\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b3\13\2\2\2\u00b2\u00b1\3\2"+
		"\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7,\2\2\u00b8\u00ba\7\61"+
		"\2\2\u00b9\u00a1\3\2\2\2\u00b9\u00ae\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bc\b\21\2\2\u00bc\"\3\2\2\2\u00bd\u00bf\4\62;\2\u00be\u00bd\3\2\2"+
		"\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1$"+
		"\3\2\2\2\u00c2\u00c4\4\62;\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\7\60"+
		"\2\2\u00c8\u00ca\4\62;\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc&\3\2\2\2\u00cd\u00cf\4c|\2\u00ce"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1(\3\2\2\2\u00d2\u00d3\t\3\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5"+
		"\b\25\3\2\u00d5*\3\2\2\2\13\2\u00a7\u00ab\u00b4\u00b9\u00c0\u00c5\u00cb"+
		"\u00d0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}