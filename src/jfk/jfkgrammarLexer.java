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
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, COMMENT=11, INT=12, ID=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'ustaw'", "'poczatek klasy'", "')'", "'koniec klasy'", "','", "'('", 
		"'='", "'importuj plik'", "'wczytaj wartosc z klawiatury do zmiennej'", 
		"'zwroc'", "COMMENT", "INT", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "COMMENT", "INT", "ID", "WS"
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
		case 10: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 13: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\20\u00b0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u008b\n"+
		"\f\f\f\16\f\u008e\13\f\3\f\5\f\u0091\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u0098"+
		"\n\f\f\f\16\f\u009b\13\f\3\f\3\f\5\f\u009f\n\f\3\f\3\f\3\r\6\r\u00a4\n"+
		"\r\r\r\16\r\u00a5\3\16\6\16\u00a9\n\16\r\16\16\16\u00aa\3\17\3\17\3\17"+
		"\3\17\3\u0099\20\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\2\31\16\1\33\17\1\35\20\3\3\2\4\4\2\f\f\17\17\5\2\f"+
		"\f\17\17\"\"\u00b5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5"+
		"%\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\13C\3\2\2\2\rE\3\2\2\2\17G\3\2\2\2"+
		"\21I\3\2\2\2\23W\3\2\2\2\25\u0080\3\2\2\2\27\u009e\3\2\2\2\31\u00a3\3"+
		"\2\2\2\33\u00a8\3\2\2\2\35\u00ac\3\2\2\2\37 \7w\2\2 !\7u\2\2!\"\7v\2\2"+
		"\"#\7c\2\2#$\7y\2\2$\4\3\2\2\2%&\7r\2\2&\'\7q\2\2\'(\7e\2\2()\7|\2\2)"+
		"*\7c\2\2*+\7v\2\2+,\7g\2\2,-\7m\2\2-.\7\"\2\2./\7m\2\2/\60\7n\2\2\60\61"+
		"\7c\2\2\61\62\7u\2\2\62\63\7{\2\2\63\6\3\2\2\2\64\65\7+\2\2\65\b\3\2\2"+
		"\2\66\67\7m\2\2\678\7q\2\289\7p\2\29:\7k\2\2:;\7g\2\2;<\7e\2\2<=\7\"\2"+
		"\2=>\7m\2\2>?\7n\2\2?@\7c\2\2@A\7u\2\2AB\7{\2\2B\n\3\2\2\2CD\7.\2\2D\f"+
		"\3\2\2\2EF\7*\2\2F\16\3\2\2\2GH\7?\2\2H\20\3\2\2\2IJ\7k\2\2JK\7o\2\2K"+
		"L\7r\2\2LM\7q\2\2MN\7t\2\2NO\7v\2\2OP\7w\2\2PQ\7l\2\2QR\7\"\2\2RS\7r\2"+
		"\2ST\7n\2\2TU\7k\2\2UV\7m\2\2V\22\3\2\2\2WX\7y\2\2XY\7e\2\2YZ\7|\2\2Z"+
		"[\7{\2\2[\\\7v\2\2\\]\7c\2\2]^\7l\2\2^_\7\"\2\2_`\7y\2\2`a\7c\2\2ab\7"+
		"t\2\2bc\7v\2\2cd\7q\2\2de\7u\2\2ef\7e\2\2fg\7\"\2\2gh\7|\2\2hi\7\"\2\2"+
		"ij\7m\2\2jk\7n\2\2kl\7c\2\2lm\7y\2\2mn\7k\2\2no\7c\2\2op\7v\2\2pq\7w\2"+
		"\2qr\7t\2\2rs\7{\2\2st\7\"\2\2tu\7f\2\2uv\7q\2\2vw\7\"\2\2wx\7|\2\2xy"+
		"\7o\2\2yz\7k\2\2z{\7g\2\2{|\7p\2\2|}\7p\2\2}~\7g\2\2~\177\7l\2\2\177\24"+
		"\3\2\2\2\u0080\u0081\7|\2\2\u0081\u0082\7y\2\2\u0082\u0083\7t\2\2\u0083"+
		"\u0084\7q\2\2\u0084\u0085\7e\2\2\u0085\26\3\2\2\2\u0086\u0087\7\61\2\2"+
		"\u0087\u0088\7\61\2\2\u0088\u008c\3\2\2\2\u0089\u008b\n\2\2\2\u008a\u0089"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0091\7\17\2\2\u0090\u008f\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009f\7\f\2\2\u0093"+
		"\u0094\7\61\2\2\u0094\u0095\7,\2\2\u0095\u0099\3\2\2\2\u0096\u0098\13"+
		"\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7,"+
		"\2\2\u009d\u009f\7\61\2\2\u009e\u0086\3\2\2\2\u009e\u0093\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\b\f\2\2\u00a1\30\3\2\2\2\u00a2\u00a4\4\62;"+
		"\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\32\3\2\2\2\u00a7\u00a9\4c|\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\34\3\2\2"+
		"\2\u00ac\u00ad\t\3\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\17\3\2\u00af"+
		"\36\3\2\2\2\t\2\u008c\u0090\u0099\u009e\u00a5\u00aa";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}