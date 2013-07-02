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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, COMMENT=15, INT=16, ID=17, 
		WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'poczatek klasy'", "','", "'+'", "'*'", "'-'", "'('", 
		"'='", "'ustaw'", "'koniec klasy'", "'/'", "'wczytaj wartosc z klawiatury do zmiennej'", 
		"'importuj plik'", "'zwroc'", "COMMENT", "INT", "ID", "WS"
	};
	public static final int
		RULE_program = 0, RULE_imports = 1, RULE_innaKlasa = 2, RULE_statement = 3, 
		RULE_invocation = 4, RULE_atom = 5, RULE_multExpr = 6, RULE_addExpr = 7, 
		RULE_expression = 8;
	public static final String[] ruleNames = {
		"program", "imports", "innaKlasa", "statement", "invocation", "atom", 
		"multExpr", "addExpr", "expression"
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
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 9) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << ID))) != 0)) {
				{
				setState(28);
				switch (_input.LA(1)) {
				case 9:
				case 12:
				case 14:
				case ID:
					{
					setState(19); ((ProgramContext)_localctx).s = statement();
					 _localctx.ret.add(((ProgramContext)_localctx).s.ret); 
					}
					break;
				case 13:
					{
					setState(22); ((ProgramContext)_localctx).i = imports();
					_localctx.ret.add(((ProgramContext)_localctx).i.ret);
					}
					break;
				case 2:
					{
					setState(25); ((ProgramContext)_localctx).k = innaKlasa();
					_localctx.ret.add(((ProgramContext)_localctx).k.ret);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(32);
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
			setState(33); match(13);
			setState(34); ((ImportsContext)_localctx).e = expression();
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
			setState(37); match(2);
			setState(38); ((InnaKlasaContext)_localctx).e = expression();
			 ((InnaKlasaContext)_localctx).ret =  new Compiler.innaKlasaPoczatek(((InnaKlasaContext)_localctx).e.ret); 
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40); statement();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << ID))) != 0) );
			setState(45); match(10);
			setState(46); ((InnaKlasaContext)_localctx).e = expression();
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
		public AddExprContext ar;
		public AddExprContext addExpr;
		public InvocationContext invocation;
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public TerminalNode ID() { return getToken(jfkgrammarParser.ID, 0); }
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
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
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); match(9);
				setState(50); ((StatementContext)_localctx).a = match(ID);
				 ((StatementContext)_localctx).ret =  new Compiler.VariableDeclaration((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null));
				setState(60);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(52); match(8);
					setState(53); ((StatementContext)_localctx).e = expression();

					        //objekt, który przechowuje parametry: nazwa funkcji, która ma być wywołana, oraz jej prametry
					        ArrayList<Object[]> list = new ArrayList<Object[]>();
					        list.add(new Object[]{new String("VariableDeclaration"), new String((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null))});
					        list.add(new Object[]{new String("Assignment"), new String((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null)), ((StatementContext)_localctx).e.ret}); 
					        ((StatementContext)_localctx).ret =  new Compiler.CallClass(list);
					    
					}
					break;

				case 2:
					{
					setState(56); match(8);
					setState(57); ((StatementContext)_localctx).ar = ((StatementContext)_localctx).addExpr = addExpr();

					        //objekt, który przechowuje parametry: nazwa funkcji, która ma być wywołana, oraz jej prametry
					        ArrayList<Object[]> list = new ArrayList<Object[]>();
					        list.add(new Object[]{new String("VariableDeclaration"), new String((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null))});
					        list.add(new Object[]{new String("AssignmentVariable"), new String((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null)), new Integer(((StatementContext)_localctx).addExpr.value)}); 
					        ((StatementContext)_localctx).ret =  new Compiler.CallClass(list);
					    
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); ((StatementContext)_localctx).a = match(ID);
				setState(63); match(8);
				setState(64); ((StatementContext)_localctx).e = expression();
				 ((StatementContext)_localctx).ret =  new Compiler.Assignment((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null), ((StatementContext)_localctx).e.ret); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67); match(12);
				setState(68); ((StatementContext)_localctx).a = match(ID);
				((StatementContext)_localctx).ret =  new Compiler.Scanf((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null));
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70); match(14);
				setState(71); ((StatementContext)_localctx).e = expression();
				 ((StatementContext)_localctx).ret =  new Compiler.Return(((StatementContext)_localctx).e.ret); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74); ((StatementContext)_localctx).invocation = invocation();
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
			setState(79); ((InvocationContext)_localctx).ID = match(ID);
			 ((InvocationContext)_localctx).ret =  new Compiler.Invocation((((InvocationContext)_localctx).ID!=null?((InvocationContext)_localctx).ID.getText():null)); 
			setState(81); match(7);
			setState(93);
			_la = _input.LA(1);
			if (_la==INT || _la==ID) {
				{
				setState(82); ((InvocationContext)_localctx).a = expression();
				 _localctx.ret.add(((InvocationContext)_localctx).a.ret); 
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(84); match(3);
					setState(85); ((InvocationContext)_localctx).a = expression();
					 _localctx.ret.add(((InvocationContext)_localctx).a.ret); 
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(95); match(1);
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

	public static class AtomContext extends ParserRuleContext {
		public int value;
		public Token INT;
		public AddExprContext addExpr;
		public TerminalNode INT() { return getToken(jfkgrammarParser.INT, 0); }
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(104);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); ((AtomContext)_localctx).INT = match(INT);
				((AtomContext)_localctx).value =  Integer.parseInt((((AtomContext)_localctx).INT!=null?((AtomContext)_localctx).INT.getText():null));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); match(7);
				setState(100); ((AtomContext)_localctx).addExpr = addExpr();
				setState(101); match(1);
				((AtomContext)_localctx).value =  ((AtomContext)_localctx).addExpr.value;
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

	public static class MultExprContext extends ParserRuleContext {
		public int value;
		public AtomContext a;
		public AtomContext b;
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitMultExpr(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); ((MultExprContext)_localctx).a = atom();
			((MultExprContext)_localctx).value =  ((MultExprContext)_localctx).a.value;
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==11) {
				{
				setState(116);
				switch (_input.LA(1)) {
				case 5:
					{
					setState(108); match(5);
					setState(109); ((MultExprContext)_localctx).b = atom();
					_localctx.value*=((MultExprContext)_localctx).b.value;
					}
					break;
				case 11:
					{
					setState(112); match(11);
					setState(113); ((MultExprContext)_localctx).b = atom();
					_localctx.value/=((MultExprContext)_localctx).b.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(120);
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

	public static class AddExprContext extends ParserRuleContext {
		public int value;
		public MultExprContext a;
		public MultExprContext b;
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); ((AddExprContext)_localctx).a = multExpr();
			((AddExprContext)_localctx).value =  ((AddExprContext)_localctx).a.value;
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==6) {
				{
				setState(131);
				switch (_input.LA(1)) {
				case 4:
					{
					setState(123); match(4);
					setState(124); ((AddExprContext)_localctx).b = multExpr();
					_localctx.value+=((AddExprContext)_localctx).b.value;
					}
					break;
				case 6:
					{
					setState(127); match(6);
					setState(128); ((AddExprContext)_localctx).b = multExpr();
					_localctx.value-=((AddExprContext)_localctx).b.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(135);
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
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(140);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(136); ((ExpressionContext)_localctx).INT = match(INT);
				 ((ExpressionContext)_localctx).ret =  new Compiler.IntExpression((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); ((ExpressionContext)_localctx).ID = match(ID);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\24\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\6\4,\n\4\r\4\16\4-\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\5\6`\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7k\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bw\n\b\f"+
		"\b\16\bz\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0086\n\t\f"+
		"\t\16\t\u0089\13\t\3\n\3\n\3\n\3\n\5\n\u008f\n\n\3\n\2\13\2\4\6\b\n\f"+
		"\16\20\22\2\2\u0099\2\24\3\2\2\2\4#\3\2\2\2\6\'\3\2\2\2\bO\3\2\2\2\nQ"+
		"\3\2\2\2\fj\3\2\2\2\16l\3\2\2\2\20{\3\2\2\2\22\u008e\3\2\2\2\24 \b\2\1"+
		"\2\25\26\5\b\5\2\26\27\b\2\1\2\27\37\3\2\2\2\30\31\5\4\3\2\31\32\b\2\1"+
		"\2\32\37\3\2\2\2\33\34\5\6\4\2\34\35\b\2\1\2\35\37\3\2\2\2\36\25\3\2\2"+
		"\2\36\30\3\2\2\2\36\33\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\3\3"+
		"\2\2\2\" \3\2\2\2#$\7\17\2\2$%\5\22\n\2%&\b\3\1\2&\5\3\2\2\2\'(\7\4\2"+
		"\2()\5\22\n\2)+\b\4\1\2*,\5\b\5\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2"+
		"\2\2./\3\2\2\2/\60\7\f\2\2\60\61\5\22\n\2\61\62\b\4\1\2\62\7\3\2\2\2\63"+
		"\64\7\13\2\2\64\65\7\23\2\2\65>\b\5\1\2\66\67\7\n\2\2\678\5\22\n\289\b"+
		"\5\1\29?\3\2\2\2:;\7\n\2\2;<\5\20\t\2<=\b\5\1\2=?\3\2\2\2>\66\3\2\2\2"+
		">:\3\2\2\2>?\3\2\2\2?P\3\2\2\2@A\7\23\2\2AB\7\n\2\2BC\5\22\n\2CD\b\5\1"+
		"\2DP\3\2\2\2EF\7\16\2\2FG\7\23\2\2GP\b\5\1\2HI\7\20\2\2IJ\5\22\n\2JK\b"+
		"\5\1\2KP\3\2\2\2LM\5\n\6\2MN\b\5\1\2NP\3\2\2\2O\63\3\2\2\2O@\3\2\2\2O"+
		"E\3\2\2\2OH\3\2\2\2OL\3\2\2\2P\t\3\2\2\2QR\7\23\2\2RS\b\6\1\2S_\7\t\2"+
		"\2TU\5\22\n\2U\\\b\6\1\2VW\7\5\2\2WX\5\22\n\2XY\b\6\1\2Y[\3\2\2\2ZV\3"+
		"\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]`\3\2\2\2^\\\3\2\2\2_T\3\2\2\2"+
		"_`\3\2\2\2`a\3\2\2\2ab\7\3\2\2b\13\3\2\2\2cd\7\22\2\2dk\b\7\1\2ef\7\t"+
		"\2\2fg\5\20\t\2gh\7\3\2\2hi\b\7\1\2ik\3\2\2\2jc\3\2\2\2je\3\2\2\2k\r\3"+
		"\2\2\2lm\5\f\7\2mx\b\b\1\2no\7\7\2\2op\5\f\7\2pq\b\b\1\2qw\3\2\2\2rs\7"+
		"\r\2\2st\5\f\7\2tu\b\b\1\2uw\3\2\2\2vn\3\2\2\2vr\3\2\2\2wz\3\2\2\2xv\3"+
		"\2\2\2xy\3\2\2\2y\17\3\2\2\2zx\3\2\2\2{|\5\16\b\2|\u0087\b\t\1\2}~\7\6"+
		"\2\2~\177\5\16\b\2\177\u0080\b\t\1\2\u0080\u0086\3\2\2\2\u0081\u0082\7"+
		"\b\2\2\u0082\u0083\5\16\b\2\u0083\u0084\b\t\1\2\u0084\u0086\3\2\2\2\u0085"+
		"}\3\2\2\2\u0085\u0081\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\21\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b"+
		"\7\22\2\2\u008b\u008f\b\n\1\2\u008c\u008d\7\23\2\2\u008d\u008f\b\n\1\2"+
		"\u008e\u008a\3\2\2\2\u008e\u008c\3\2\2\2\u008f\23\3\2\2\2\17\36 ->O\\"+
		"_jvx\u0085\u0087\u008e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}