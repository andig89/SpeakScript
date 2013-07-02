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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, COMMENT=15, INT=16, ID=17, 
		WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'poczatek klasy'", "','", "'+'", "'*'", "'-'", "'('", "'='", "'ustaw'", 
		"'koniec klasy'", "'/'", "'wczytaj wartosc z klawiatury do zmiennej'", 
		"'importuj plik'", "'zwroc'", "COMMENT", "INT", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "COMMENT", "INT", "ID", "WS"
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
		case 14: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 17: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\24\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\7\20\u009b\n\20\f\20\16\20\u009e\13\20\3\20\5"+
		"\20\u00a1\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u00a8\n\20\f\20\16\20\u00ab"+
		"\13\20\3\20\3\20\5\20\u00af\n\20\3\20\3\20\3\21\6\21\u00b4\n\21\r\21\16"+
		"\21\u00b5\3\22\6\22\u00b9\n\22\r\22\16\22\u00ba\3\23\3\23\3\23\3\23\3"+
		"\u00a9\24\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25"+
		"\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\2!\22\1#\23\1%\24\3\3\2\4\4"+
		"\2\f\f\17\17\5\2\f\f\17\17\"\"\u00c5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2"+
		"\2\2\78\3\2\2\2\t:\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2"+
		"\2\2\23D\3\2\2\2\25J\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33\u0082\3\2\2\2"+
		"\35\u0090\3\2\2\2\37\u00ae\3\2\2\2!\u00b3\3\2\2\2#\u00b8\3\2\2\2%\u00bc"+
		"\3\2\2\2\'(\7+\2\2(\4\3\2\2\2)*\7r\2\2*+\7q\2\2+,\7e\2\2,-\7|\2\2-.\7"+
		"c\2\2./\7v\2\2/\60\7g\2\2\60\61\7m\2\2\61\62\7\"\2\2\62\63\7m\2\2\63\64"+
		"\7n\2\2\64\65\7c\2\2\65\66\7u\2\2\66\67\7{\2\2\67\6\3\2\2\289\7.\2\29"+
		"\b\3\2\2\2:;\7-\2\2;\n\3\2\2\2<=\7,\2\2=\f\3\2\2\2>?\7/\2\2?\16\3\2\2"+
		"\2@A\7*\2\2A\20\3\2\2\2BC\7?\2\2C\22\3\2\2\2DE\7w\2\2EF\7u\2\2FG\7v\2"+
		"\2GH\7c\2\2HI\7y\2\2I\24\3\2\2\2JK\7m\2\2KL\7q\2\2LM\7p\2\2MN\7k\2\2N"+
		"O\7g\2\2OP\7e\2\2PQ\7\"\2\2QR\7m\2\2RS\7n\2\2ST\7c\2\2TU\7u\2\2UV\7{\2"+
		"\2V\26\3\2\2\2WX\7\61\2\2X\30\3\2\2\2YZ\7y\2\2Z[\7e\2\2[\\\7|\2\2\\]\7"+
		"{\2\2]^\7v\2\2^_\7c\2\2_`\7l\2\2`a\7\"\2\2ab\7y\2\2bc\7c\2\2cd\7t\2\2"+
		"de\7v\2\2ef\7q\2\2fg\7u\2\2gh\7e\2\2hi\7\"\2\2ij\7|\2\2jk\7\"\2\2kl\7"+
		"m\2\2lm\7n\2\2mn\7c\2\2no\7y\2\2op\7k\2\2pq\7c\2\2qr\7v\2\2rs\7w\2\2s"+
		"t\7t\2\2tu\7{\2\2uv\7\"\2\2vw\7f\2\2wx\7q\2\2xy\7\"\2\2yz\7|\2\2z{\7o"+
		"\2\2{|\7k\2\2|}\7g\2\2}~\7p\2\2~\177\7p\2\2\177\u0080\7g\2\2\u0080\u0081"+
		"\7l\2\2\u0081\32\3\2\2\2\u0082\u0083\7k\2\2\u0083\u0084\7o\2\2\u0084\u0085"+
		"\7r\2\2\u0085\u0086\7q\2\2\u0086\u0087\7t\2\2\u0087\u0088\7v\2\2\u0088"+
		"\u0089\7w\2\2\u0089\u008a\7l\2\2\u008a\u008b\7\"\2\2\u008b\u008c\7r\2"+
		"\2\u008c\u008d\7n\2\2\u008d\u008e\7k\2\2\u008e\u008f\7m\2\2\u008f\34\3"+
		"\2\2\2\u0090\u0091\7|\2\2\u0091\u0092\7y\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7e\2\2\u0095\36\3\2\2\2\u0096\u0097\7\61\2\2"+
		"\u0097\u0098\7\61\2\2\u0098\u009c\3\2\2\2\u0099\u009b\n\2\2\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7\17\2\2\u00a0\u009f\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00af\7\f\2\2\u00a3"+
		"\u00a4\7\61\2\2\u00a4\u00a5\7,\2\2\u00a5\u00a9\3\2\2\2\u00a6\u00a8\13"+
		"\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00aa\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7,"+
		"\2\2\u00ad\u00af\7\61\2\2\u00ae\u0096\3\2\2\2\u00ae\u00a3\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\b\20\2\2\u00b1 \3\2\2\2\u00b2\u00b4\4\62;\2"+
		"\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\"\3\2\2\2\u00b7\u00b9\4c|\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb$\3\2\2\2\u00bc"+
		"\u00bd\t\3\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\23\3\2\u00bf&\3\2\2\2"+
		"\t\2\u009c\u00a0\u00a9\u00ae\u00b5\u00ba";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}