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
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, COMMENT=19, INT=20, DOUBLE=21, ID=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'+'", "'*'", "'-'", "'('", "'deklaruj'", "'='", "'drukuj'", 
		"'poczatek funkcji'", "'zwroc \"'", "'/'", "'wywolaj funkcje'", "'koniec funkcji'", 
		"'\"'", "'wczytaj wartosc z klawiatury do zmiennej'", "'importuj plik'", 
		"'zwroc'", "COMMENT", "INT", "DOUBLE", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "COMMENT", "INT", "DOUBLE", "ID", "WS"
	};

	    
	    enum typeValue {
	        NUMER, LITERA
	    };
		enum typeReturn {
	        TEXT, ANOTHER
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
		case 18: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 22: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\31\u00fd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00cd\n\24\f\24\16\24\u00d0\13\24"+
		"\3\24\5\24\u00d3\n\24\3\24\3\24\3\24\3\24\3\24\7\24\u00da\n\24\f\24\16"+
		"\24\u00dd\13\24\3\24\3\24\5\24\u00e1\n\24\3\24\3\24\3\25\6\25\u00e6\n"+
		"\25\r\25\16\25\u00e7\3\26\6\26\u00eb\n\26\r\26\16\26\u00ec\3\26\3\26\6"+
		"\26\u00f1\n\26\r\26\16\26\u00f2\3\27\6\27\u00f6\n\27\r\27\16\27\u00f7"+
		"\3\30\3\30\3\30\3\30\3\u00db\31\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22"+
		"\1#\23\1%\24\1\'\25\2)\26\1+\27\1-\30\1/\31\3\3\2\4\4\2\f\f\17\17\5\2"+
		"\f\f\17\17\"\"\u0104\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2"+
		"\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21F\3\2\2\2\23H\3\2\2\2\25O\3"+
		"\2\2\2\27`\3\2\2\2\31h\3\2\2\2\33j\3\2\2\2\35z\3\2\2\2\37\u0089\3\2\2"+
		"\2!\u008b\3\2\2\2#\u00b4\3\2\2\2%\u00c2\3\2\2\2\'\u00e0\3\2\2\2)\u00e5"+
		"\3\2\2\2+\u00ea\3\2\2\2-\u00f5\3\2\2\2/\u00f9\3\2\2\2\61\62\7+\2\2\62"+
		"\4\3\2\2\2\63\64\7.\2\2\64\6\3\2\2\2\65\66\7-\2\2\66\b\3\2\2\2\678\7,"+
		"\2\28\n\3\2\2\29:\7/\2\2:\f\3\2\2\2;<\7*\2\2<\16\3\2\2\2=>\7f\2\2>?\7"+
		"g\2\2?@\7m\2\2@A\7n\2\2AB\7c\2\2BC\7t\2\2CD\7w\2\2DE\7l\2\2E\20\3\2\2"+
		"\2FG\7?\2\2G\22\3\2\2\2HI\7f\2\2IJ\7t\2\2JK\7w\2\2KL\7m\2\2LM\7w\2\2M"+
		"N\7l\2\2N\24\3\2\2\2OP\7r\2\2PQ\7q\2\2QR\7e\2\2RS\7|\2\2ST\7c\2\2TU\7"+
		"v\2\2UV\7g\2\2VW\7m\2\2WX\7\"\2\2XY\7h\2\2YZ\7w\2\2Z[\7p\2\2[\\\7m\2\2"+
		"\\]\7e\2\2]^\7l\2\2^_\7k\2\2_\26\3\2\2\2`a\7|\2\2ab\7y\2\2bc\7t\2\2cd"+
		"\7q\2\2de\7e\2\2ef\7\"\2\2fg\7$\2\2g\30\3\2\2\2hi\7\61\2\2i\32\3\2\2\2"+
		"jk\7y\2\2kl\7{\2\2lm\7y\2\2mn\7q\2\2no\7n\2\2op\7c\2\2pq\7l\2\2qr\7\""+
		"\2\2rs\7h\2\2st\7w\2\2tu\7p\2\2uv\7m\2\2vw\7e\2\2wx\7l\2\2xy\7g\2\2y\34"+
		"\3\2\2\2z{\7m\2\2{|\7q\2\2|}\7p\2\2}~\7k\2\2~\177\7g\2\2\177\u0080\7e"+
		"\2\2\u0080\u0081\7\"\2\2\u0081\u0082\7h\2\2\u0082\u0083\7w\2\2\u0083\u0084"+
		"\7p\2\2\u0084\u0085\7m\2\2\u0085\u0086\7e\2\2\u0086\u0087\7l\2\2\u0087"+
		"\u0088\7k\2\2\u0088\36\3\2\2\2\u0089\u008a\7$\2\2\u008a \3\2\2\2\u008b"+
		"\u008c\7y\2\2\u008c\u008d\7e\2\2\u008d\u008e\7|\2\2\u008e\u008f\7{\2\2"+
		"\u008f\u0090\7v\2\2\u0090\u0091\7c\2\2\u0091\u0092\7l\2\2\u0092\u0093"+
		"\7\"\2\2\u0093\u0094\7y\2\2\u0094\u0095\7c\2\2\u0095\u0096\7t\2\2\u0096"+
		"\u0097\7v\2\2\u0097\u0098\7q\2\2\u0098\u0099\7u\2\2\u0099\u009a\7e\2\2"+
		"\u009a\u009b\7\"\2\2\u009b\u009c\7|\2\2\u009c\u009d\7\"\2\2\u009d\u009e"+
		"\7m\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7y\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7w\2\2"+
		"\u00a5\u00a6\7t\2\2\u00a6\u00a7\7{\2\2\u00a7\u00a8\7\"\2\2\u00a8\u00a9"+
		"\7f\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7\"\2\2\u00ab\u00ac\7|\2\2\u00ac"+
		"\u00ad\7o\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2"+
		"\u00b0\u00b1\7p\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7l\2\2\u00b3\"\3\2"+
		"\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7o\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8"+
		"\7q\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7w\2\2\u00bb"+
		"\u00bc\7l\2\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\7r\2\2\u00be\u00bf\7n\2"+
		"\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7m\2\2\u00c1$\3\2\2\2\u00c2\u00c3\7"+
		"|\2\2\u00c3\u00c4\7y\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7"+
		"\7e\2\2\u00c7&\3\2\2\2\u00c8\u00c9\7\61\2\2\u00c9\u00ca\7\61\2\2\u00ca"+
		"\u00ce\3\2\2\2\u00cb\u00cd\n\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2"+
		"\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d3\7\17\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00e1\7\f\2\2\u00d5\u00d6\7\61\2\2\u00d6"+
		"\u00d7\7,\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8\3\2"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7,\2\2\u00df\u00e1\7\61"+
		"\2\2\u00e0\u00c8\3\2\2\2\u00e0\u00d5\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\b\24\2\2\u00e3(\3\2\2\2\u00e4\u00e6\4\62;\2\u00e5\u00e4\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8*\3"+
		"\2\2\2\u00e9\u00eb\4\62;\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\7\60"+
		"\2\2\u00ef\u00f1\4\62;\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3,\3\2\2\2\u00f4\u00f6\4c|\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8.\3\2\2\2\u00f9\u00fa\t\3\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc"+
		"\b\30\3\2\u00fc\60\3\2\2\2\13\2\u00ce\u00d2\u00db\u00e0\u00e7\u00ec\u00f2"+
		"\u00f7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}