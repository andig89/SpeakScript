// Generated from jfkgrammar.g4 by ANTLR 4.1

package jfk;
import jfk.Compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class jfkgrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		COMMENT=10, INT=11, ID=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'ustaw'", "'poczatek klasy'", "')'", "'koniec klasy'", "','", 
		"'('", "'='", "'importuj plik'", "'zwroc'", "COMMENT", "INT", "ID", "WS"
	};
	public static final int
		RULE_program = 0, RULE_imports = 1, RULE_innaKlasa = 2, RULE_statement = 3, 
		RULE_invocation = 4, RULE_expression = 5;
	public static final String[] ruleNames = {
		"program", "imports", "innaKlasa", "statement", "invocation", "expression"
	};

	@Override
	public String getGrammarFileName() { return "jfkgrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public jfkgrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Compiler.Program ret;
		public StatementContext s;
		public ImportsContext i;
		public InnaKlasaContext k;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public InnaKlasaContext innaKlasa(int i) {
			return getRuleContext(InnaKlasaContext.class,i);
		}
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public List<InnaKlasaContext> innaKlasa() {
			return getRuleContexts(InnaKlasaContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ImportsContext imports(int i) {
			return getRuleContext(ImportsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).ret =  new Compiler.Program(); 
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 8) | (1L << 9) | (1L << ID))) != 0)) {
				{
				setState(22);
				switch (_input.LA(1)) {
				case 1:
				case 9:
				case ID:
					{
					setState(13); ((ProgramContext)_localctx).s = statement();
					 _localctx.ret.add(((ProgramContext)_localctx).s.ret); 
					}
					break;
				case 8:
					{
					setState(16); ((ProgramContext)_localctx).i = imports();
					_localctx.ret.add(((ProgramContext)_localctx).i.ret);
					}
					break;
				case 2:
					{
					setState(19); ((ProgramContext)_localctx).k = innaKlasa();
					_localctx.ret.add(((ProgramContext)_localctx).k.ret);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportsContext extends ParserRuleContext {
		public Compiler.Statement ret;
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitImports(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(8);
			setState(28); ((ImportsContext)_localctx).e = expression();
			 ((ImportsContext)_localctx).ret =  new Compiler.ImportFile(((ImportsContext)_localctx).e.ret); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnaKlasaContext extends ParserRuleContext {
		public Compiler.Statement ret;
		public ExpressionContext e;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public InnaKlasaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innaKlasa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterInnaKlasa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitInnaKlasa(this);
		}
	}

	public final InnaKlasaContext innaKlasa() throws RecognitionException {
		InnaKlasaContext _localctx = new InnaKlasaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_innaKlasa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(2);
			setState(32); ((InnaKlasaContext)_localctx).e = expression();
			 ((InnaKlasaContext)_localctx).ret =  new Compiler.innaKlasaPoczatek(((InnaKlasaContext)_localctx).e.ret); 
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34); statement();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 9) | (1L << ID))) != 0) );
			setState(39); match(4);
			setState(40); ((InnaKlasaContext)_localctx).e = expression();
			 ((InnaKlasaContext)_localctx).ret =  new Compiler.innaKlasaKoniec(((InnaKlasaContext)_localctx).e.ret); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Compiler.Statement ret;
		public Token a;
		public ExpressionContext e;
		public InvocationContext invocation;
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public TerminalNode ID() { return getToken(jfkgrammarParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(64);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); match(1);
				setState(44); ((StatementContext)_localctx).a = match(ID);
				 ((StatementContext)_localctx).ret =  new Compiler.VariableDeclaration((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null));
				setState(50);
				_la = _input.LA(1);
				if (_la==7) {
					{
					setState(46); match(7);
					setState(47); ((StatementContext)_localctx).e = expression();

					        //objekt, który przechowuje parametry: nazwa funkcji, która ma być wywołana, oraz jej prametry
					        ArrayList<Object[]> list = new ArrayList<Object[]>();
					        list.add(new Object[]{new String("VariableDeclaration"), new String((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null))});
					        list.add(new Object[]{new String("Assignment"), new String((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null)), ((StatementContext)_localctx).e.ret}); 
					        ((StatementContext)_localctx).ret =  new Compiler.CallClass(list);
					    
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52); ((StatementContext)_localctx).a = match(ID);
				setState(53); match(7);
				setState(54); ((StatementContext)_localctx).e = expression();
				 ((StatementContext)_localctx).ret =  new Compiler.Assignment((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null), ((StatementContext)_localctx).e.ret); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57); match(9);
				setState(58); ((StatementContext)_localctx).e = expression();
				 ((StatementContext)_localctx).ret =  new Compiler.Return(((StatementContext)_localctx).e.ret); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61); ((StatementContext)_localctx).invocation = invocation();
				 ((StatementContext)_localctx).ret =  ((StatementContext)_localctx).invocation.ret; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvocationContext extends ParserRuleContext {
		public Compiler.Invocation ret;
		public Token ID;
		public ExpressionContext a;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(jfkgrammarParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitInvocation(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); ((InvocationContext)_localctx).ID = match(ID);
			 ((InvocationContext)_localctx).ret =  new Compiler.Invocation((((InvocationContext)_localctx).ID!=null?((InvocationContext)_localctx).ID.getText():null)); 
			setState(68); match(6);
			setState(80);
			_la = _input.LA(1);
			if (_la==INT || _la==ID) {
				{
				setState(69); ((InvocationContext)_localctx).a = expression();
				 _localctx.ret.add(((InvocationContext)_localctx).a.ret); 
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5) {
					{
					{
					setState(71); match(5);
					setState(72); ((InvocationContext)_localctx).a = expression();
					 _localctx.ret.add(((InvocationContext)_localctx).a.ret); 
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(82); match(3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Compiler.Expression ret;
		public Token INT;
		public Token ID;
		public TerminalNode INT() { return getToken(jfkgrammarParser.INT, 0); }
		public TerminalNode ID() { return getToken(jfkgrammarParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); ((ExpressionContext)_localctx).INT = match(INT);
				 ((ExpressionContext)_localctx).ret =  new Compiler.IntExpression((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); ((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ret =  new Compiler.RefExpression((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\17]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\6\4&"+
		"\n\4\r\4\16\4\'\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\65\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\5\6S\n\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\5\7[\n\7\3\7\2\b\2\4\6\b\n\f\2\2a\2\16\3\2\2\2\4\35\3\2\2"+
		"\2\6!\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\fZ\3\2\2\2\16\32\b\2\1\2\17\20\5\b"+
		"\5\2\20\21\b\2\1\2\21\31\3\2\2\2\22\23\5\4\3\2\23\24\b\2\1\2\24\31\3\2"+
		"\2\2\25\26\5\6\4\2\26\27\b\2\1\2\27\31\3\2\2\2\30\17\3\2\2\2\30\22\3\2"+
		"\2\2\30\25\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3\2"+
		"\2\2\34\32\3\2\2\2\35\36\7\n\2\2\36\37\5\f\7\2\37 \b\3\1\2 \5\3\2\2\2"+
		"!\"\7\4\2\2\"#\5\f\7\2#%\b\4\1\2$&\5\b\5\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2"+
		"\2\2\'(\3\2\2\2()\3\2\2\2)*\7\6\2\2*+\5\f\7\2+,\b\4\1\2,\7\3\2\2\2-.\7"+
		"\3\2\2./\7\16\2\2/\64\b\5\1\2\60\61\7\t\2\2\61\62\5\f\7\2\62\63\b\5\1"+
		"\2\63\65\3\2\2\2\64\60\3\2\2\2\64\65\3\2\2\2\65C\3\2\2\2\66\67\7\16\2"+
		"\2\678\7\t\2\289\5\f\7\29:\b\5\1\2:C\3\2\2\2;<\7\13\2\2<=\5\f\7\2=>\b"+
		"\5\1\2>C\3\2\2\2?@\5\n\6\2@A\b\5\1\2AC\3\2\2\2B-\3\2\2\2B\66\3\2\2\2B"+
		";\3\2\2\2B?\3\2\2\2C\t\3\2\2\2DE\7\16\2\2EF\b\6\1\2FR\7\b\2\2GH\5\f\7"+
		"\2HO\b\6\1\2IJ\7\7\2\2JK\5\f\7\2KL\b\6\1\2LN\3\2\2\2MI\3\2\2\2NQ\3\2\2"+
		"\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RG\3\2\2\2RS\3\2\2\2ST\3\2\2"+
		"\2TU\7\5\2\2U\13\3\2\2\2VW\7\r\2\2W[\b\7\1\2XY\7\16\2\2Y[\b\7\1\2ZV\3"+
		"\2\2\2ZX\3\2\2\2[\r\3\2\2\2\n\30\32\'\64BORZ";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}