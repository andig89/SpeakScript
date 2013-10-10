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
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, COMMENT=19, INT=20, DOUBLE=21, ID=22, WS=23;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "','", "'+'", "'*'", "'-'", "'('", "'deklaruj'", "'='", 
		"'drukuj'", "'poczatek funkcji'", "'zwroc \"'", "'/'", "'wywolaj funkcje'", 
		"'koniec funkcji'", "'\"'", "'wczytaj wartosc z klawiatury do zmiennej'", 
		"'importuj plik'", "'zwroc'", "COMMENT", "INT", "DOUBLE", "ID", "WS"
	};
	public static final int
		RULE_program = 0, RULE_imports = 1, RULE_innaKlasa = 2, RULE_returnFunction = 3, 
		RULE_statements = 4, RULE_statement = 5, RULE_invocation = 6, RULE_atom = 7, 
		RULE_multExpr = 8, RULE_addExpr = 9, RULE_expression = 10;
	public static final String[] ruleNames = {
		"program", "imports", "innaKlasa", "returnFunction", "statements", "statement", 
		"invocation", "atom", "multExpr", "addExpr", "expression"
	};

	@Override
	public String getGrammarFileName() { return "jfkgrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	    
	    enum typeValue {
	        NUMER, LITERA
	    };
		enum typeReturn {
	        TEXT, ANOTHER
	    };
	public jfkgrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Compiler.Program ret;
		public InnaKlasaContext k;
		public StatementContext s;
		public ImportsContext i;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public InnaKlasaContext innaKlasa(int i) {
			return getRuleContext(InnaKlasaContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<InnaKlasaContext> innaKlasa() {
			return getRuleContexts(InnaKlasaContext.class);
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
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10) {
				{
				{
				setState(23); ((ProgramContext)_localctx).k = innaKlasa();
				_localctx.ret.add(((ProgramContext)_localctx).k.ret);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 13) | (1L << 16) | (1L << 17) | (1L << ID))) != 0)) {
				{
				setState(37);
				switch (_input.LA(1)) {
				case 7:
				case 9:
				case 13:
				case 16:
				case ID:
					{
					setState(31); ((ProgramContext)_localctx).s = statement();
					 _localctx.ret.add(((ProgramContext)_localctx).s.ret); 
					}
					break;
				case 17:
					{
					setState(34); ((ProgramContext)_localctx).i = imports();
					_localctx.ret.add(((ProgramContext)_localctx).i.ret);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(41);
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
		public ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>();
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
			setState(42); match(17);
			setState(43); ((ImportsContext)_localctx).e = expression();
			 _localctx.ret.add(new Compiler.ImportFile(((ImportsContext)_localctx).e.ret)); 
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
		public ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>();
		public ExpressionContext e;
		public StatementsContext s;
		public ReturnFunctionContext rt;
		public ExpressionContext k;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ReturnFunctionContext returnFunction() {
			return getRuleContext(ReturnFunctionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
			setState(46); match(10);
			setState(47); ((InnaKlasaContext)_localctx).e = expression();
			setState(48); ((InnaKlasaContext)_localctx).s = statements();
			setState(50);
			_la = _input.LA(1);
			if (_la==11 || _la==18) {
				{
				setState(49); ((InnaKlasaContext)_localctx).rt = returnFunction();
				}
			}

			setState(52); match(14);
			setState(53); ((InnaKlasaContext)_localctx).k = expression();

			        _localctx.ret.add(new Compiler.InnaFunkcjaPoczatek((((InnaKlasaContext)_localctx).e!=null?_input.getText(((InnaKlasaContext)_localctx).e.start,((InnaKlasaContext)_localctx).e.stop):null), (((InnaKlasaContext)_localctx).k!=null?_input.getText(((InnaKlasaContext)_localctx).k.start,((InnaKlasaContext)_localctx).k.stop):null)));
					for (int i = 0; i < ((InnaKlasaContext)_localctx).s.ret.size(); i++){
						ArrayList<Compiler.Statement> statement = ((InnaKlasaContext)_localctx).s.ret.get(i);
						for (int j = 0; j < statement.size(); j++){
							_localctx.ret.add(statement.get(j));
						}
					}
			        _localctx.ret.add(new Compiler.Return(((InnaKlasaContext)_localctx).rt.ret));
			        _localctx.ret.add(new Compiler.InnaFunkcjaKoniec((((InnaKlasaContext)_localctx).e!=null?_input.getText(((InnaKlasaContext)_localctx).e.start,((InnaKlasaContext)_localctx).e.stop):null), ((InnaKlasaContext)_localctx).rt.ret));
			    
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

	public static class ReturnFunctionContext extends ParserRuleContext {
		public Object[] ret=new Object[]{};
		public ExpressionContext z;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterReturnFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitReturnFunction(this);
		}
	}

	public final ReturnFunctionContext returnFunction() throws RecognitionException {
		ReturnFunctionContext _localctx = new ReturnFunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_returnFunction);
		try {
			setState(65);
			switch (_input.LA(1)) {
			case 18:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); match(18);
				setState(57); ((ReturnFunctionContext)_localctx).z = expression();
				((ReturnFunctionContext)_localctx).ret = new Object[]{(((ReturnFunctionContext)_localctx).z!=null?_input.getText(((ReturnFunctionContext)_localctx).z.start,((ReturnFunctionContext)_localctx).z.stop):null),typeReturn.ANOTHER};
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 2);
				{
				setState(60); match(11);
				setState(61); ((ReturnFunctionContext)_localctx).z = expression();
				setState(62); match(15);
				((ReturnFunctionContext)_localctx).ret = new Object[]{(((ReturnFunctionContext)_localctx).z!=null?_input.getText(((ReturnFunctionContext)_localctx).z.start,((ReturnFunctionContext)_localctx).z.stop):null),typeReturn.TEXT};
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

	public static class StatementsContext extends ParserRuleContext {
		public ArrayList<ArrayList<Compiler.Statement>> ret = new ArrayList<ArrayList<Compiler.Statement>>();
		public StatementContext s;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jfkgrammarListener ) ((jfkgrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67); ((StatementsContext)_localctx).s = statement();

				                _localctx.ret.add(((StatementsContext)_localctx).s.ret);
				        
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 13) | (1L << 16) | (1L << ID))) != 0) );
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
		public ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>();
		public Token a;
		public AddExprContext ar;
		public ExpressionContext e;
		public InvocationContext invocation;
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(jfkgrammarParser.ID); }
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(jfkgrammarParser.ID, i);
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
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(7);
				setState(75); ((StatementContext)_localctx).a = match(ID);

				            _localctx.ret.add(new Compiler.VariableDeclaration((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null),new Object[]{0.0,typeValue.NUMER}));
				        
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(77); match(2);
						setState(78); ((StatementContext)_localctx).a = match(ID);

						            _localctx.ret.add(new Compiler.VariableDeclaration((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null),new Object[]{0.0,typeValue.NUMER}));
						        
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(89);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(85); match(8);
					setState(86); ((StatementContext)_localctx).ar = addExpr();

					            _localctx.ret.add(new Compiler.AssignmentVariable((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null),new Object[]{((StatementContext)_localctx).ar.value,typeValue.NUMER}));
					        
					}
				}

				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(94); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(91); match(2);
							setState(92); ((StatementContext)_localctx).a = match(ID);

							                _localctx.ret.add(new Compiler.VariableDeclaration((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null),new Object[]{0.0,typeValue.NUMER}));
							            
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(96); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					} while ( _alt!=2 && _alt!=-1 );
					setState(102);
					_la = _input.LA(1);
					if (_la==8) {
						{
						setState(98); match(8);
						setState(99); ((StatementContext)_localctx).ar = addExpr();

						                _localctx.ret.add(new Compiler.AssignmentVariable((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null),new Object[]{((StatementContext)_localctx).ar.value,typeValue.NUMER}));
						            
						}
					}

					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109); ((StatementContext)_localctx).a = match(ID);
				setState(114);
				_la = _input.LA(1);
				if (_la==8) {
					{
					setState(110); match(8);
					setState(111); ((StatementContext)_localctx).ar = addExpr();

					        _localctx.ret.add(new Compiler.AssignmentVariable((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null),new Object[]{((StatementContext)_localctx).ar.value,typeValue.NUMER}));
					    
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(116); ((StatementContext)_localctx).a = match(ID);
					setState(117); match(8);
					}
				}

				setState(120); match(13);
				setState(121); ((StatementContext)_localctx).e = expression();
				_localctx.ret.add(new Compiler.CallFunction((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null), (((StatementContext)_localctx).e!=null?_input.getText(((StatementContext)_localctx).e.start,((StatementContext)_localctx).e.stop):null)));
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(124); match(16);
				setState(125); ((StatementContext)_localctx).a = match(ID);
				_localctx.ret.add(new Compiler.Scanf((((StatementContext)_localctx).a!=null?((StatementContext)_localctx).a.getText():null)));
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127); ((StatementContext)_localctx).invocation = invocation();
				 _localctx.ret.add(((StatementContext)_localctx).invocation.ret); 
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
		public ExpressionContext a;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
		enterRule(_localctx, 12, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(9);
			 ((InvocationContext)_localctx).ret =  new Compiler.Invocation(); 
			setState(134); match(6);
			setState(146);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << ID))) != 0)) {
				{
				setState(135); ((InvocationContext)_localctx).a = expression();
				 _localctx.ret.add(((InvocationContext)_localctx).a.ret); 
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(137); match(2);
					setState(138); ((InvocationContext)_localctx).a = expression();
					 _localctx.ret.add(((InvocationContext)_localctx).a.ret); 
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(148); match(1);
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
		public double value;
		public Token INT;
		public Token DOUBLE;
		public AddExprContext addExpr;
		public TerminalNode INT() { return getToken(jfkgrammarParser.INT, 0); }
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(jfkgrammarParser.DOUBLE, 0); }
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
		enterRule(_localctx, 14, RULE_atom);
		try {
			setState(159);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(150); ((AtomContext)_localctx).INT = match(INT);
				((AtomContext)_localctx).value =  Integer.parseInt((((AtomContext)_localctx).INT!=null?((AtomContext)_localctx).INT.getText():null));
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(152); ((AtomContext)_localctx).DOUBLE = match(DOUBLE);
				((AtomContext)_localctx).value =  Double.parseDouble((((AtomContext)_localctx).DOUBLE!=null?((AtomContext)_localctx).DOUBLE.getText():null));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 3);
				{
				setState(154); match(6);
				setState(155); ((AtomContext)_localctx).addExpr = addExpr();
				setState(156); match(1);
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
		public double value;
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
		enterRule(_localctx, 16, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); ((MultExprContext)_localctx).a = atom();
			((MultExprContext)_localctx).value =  ((MultExprContext)_localctx).a.value;
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==12) {
				{
				setState(171);
				switch (_input.LA(1)) {
				case 4:
					{
					setState(163); match(4);
					setState(164); ((MultExprContext)_localctx).b = atom();
					_localctx.value*=((MultExprContext)_localctx).b.value;
					}
					break;
				case 12:
					{
					setState(167); match(12);
					setState(168); ((MultExprContext)_localctx).b = atom();
					_localctx.value/=((MultExprContext)_localctx).b.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(175);
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
		public double value;
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
		enterRule(_localctx, 18, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); ((AddExprContext)_localctx).a = multExpr();
			((AddExprContext)_localctx).value =  ((AddExprContext)_localctx).a.value;
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==5) {
				{
				setState(186);
				switch (_input.LA(1)) {
				case 3:
					{
					setState(178); match(3);
					setState(179); ((AddExprContext)_localctx).b = multExpr();
					_localctx.value+=((AddExprContext)_localctx).b.value;
					}
					break;
				case 5:
					{
					setState(182); match(5);
					setState(183); ((AddExprContext)_localctx).b = multExpr();
					_localctx.value-=((AddExprContext)_localctx).b.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(190);
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
		public Token DOUBLE;
		public Token ID;
		public TerminalNode INT() { return getToken(jfkgrammarParser.INT, 0); }
		public TerminalNode ID() { return getToken(jfkgrammarParser.ID, 0); }
		public TerminalNode DOUBLE() { return getToken(jfkgrammarParser.DOUBLE, 0); }
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
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(191); ((ExpressionContext)_localctx).INT = match(INT);
				 ((ExpressionContext)_localctx).ret =  new Compiler.IntExpression((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); ((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);
				 ((ExpressionContext)_localctx).ret =  new Compiler.DoubleExpression((((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null)); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(195); ((ExpressionContext)_localctx).ID = match(ID);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\31\u00ca\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4"+
		"\65\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D\n\5\3"+
		"\6\3\6\3\6\6\6I\n\6\r\6\16\6J\3\7\3\7\3\7\3\7\3\7\3\7\7\7S\n\7\f\7\16"+
		"\7V\13\7\3\7\3\7\3\7\3\7\5\7\\\n\7\3\7\3\7\3\7\6\7a\n\7\r\7\16\7b\3\7"+
		"\3\7\3\7\3\7\5\7i\n\7\7\7k\n\7\f\7\16\7n\13\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"u\n\7\3\7\3\7\5\7y\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0085"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0090\n\b\f\b\16\b\u0093"+
		"\13\b\5\b\u0095\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a2"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ae\n\n\f\n\16\n\u00b1"+
		"\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00bd\n\13"+
		"\f\13\16\13\u00c0\13\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c8\n\f\3\f\2\r"+
		"\2\4\6\b\n\f\16\20\22\24\26\2\2\u00d9\2\30\3\2\2\2\4,\3\2\2\2\6\60\3\2"+
		"\2\2\bC\3\2\2\2\nH\3\2\2\2\f\u0084\3\2\2\2\16\u0086\3\2\2\2\20\u00a1\3"+
		"\2\2\2\22\u00a3\3\2\2\2\24\u00b2\3\2\2\2\26\u00c7\3\2\2\2\30\36\b\2\1"+
		"\2\31\32\5\6\4\2\32\33\b\2\1\2\33\35\3\2\2\2\34\31\3\2\2\2\35 \3\2\2\2"+
		"\36\34\3\2\2\2\36\37\3\2\2\2\37)\3\2\2\2 \36\3\2\2\2!\"\5\f\7\2\"#\b\2"+
		"\1\2#(\3\2\2\2$%\5\4\3\2%&\b\2\1\2&(\3\2\2\2\'!\3\2\2\2\'$\3\2\2\2(+\3"+
		"\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3\2\2\2,-\7\23\2\2-.\5\26\f\2"+
		"./\b\3\1\2/\5\3\2\2\2\60\61\7\f\2\2\61\62\5\26\f\2\62\64\5\n\6\2\63\65"+
		"\5\b\5\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\20\2\2\678"+
		"\5\26\f\289\b\4\1\29\7\3\2\2\2:;\7\24\2\2;<\5\26\f\2<=\b\5\1\2=D\3\2\2"+
		"\2>?\7\r\2\2?@\5\26\f\2@A\7\21\2\2AB\b\5\1\2BD\3\2\2\2C:\3\2\2\2C>\3\2"+
		"\2\2D\t\3\2\2\2EF\5\f\7\2FG\b\6\1\2GI\3\2\2\2HE\3\2\2\2IJ\3\2\2\2JH\3"+
		"\2\2\2JK\3\2\2\2K\13\3\2\2\2LM\7\t\2\2MN\7\30\2\2NT\b\7\1\2OP\7\4\2\2"+
		"PQ\7\30\2\2QS\b\7\1\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U[\3\2\2"+
		"\2VT\3\2\2\2WX\7\n\2\2XY\5\24\13\2YZ\b\7\1\2Z\\\3\2\2\2[W\3\2\2\2[\\\3"+
		"\2\2\2\\l\3\2\2\2]^\7\4\2\2^_\7\30\2\2_a\b\7\1\2`]\3\2\2\2ab\3\2\2\2b"+
		"`\3\2\2\2bc\3\2\2\2ch\3\2\2\2de\7\n\2\2ef\5\24\13\2fg\b\7\1\2gi\3\2\2"+
		"\2hd\3\2\2\2hi\3\2\2\2ik\3\2\2\2j`\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2"+
		"\2m\u0085\3\2\2\2nl\3\2\2\2ot\7\30\2\2pq\7\n\2\2qr\5\24\13\2rs\b\7\1\2"+
		"su\3\2\2\2tp\3\2\2\2tu\3\2\2\2u\u0085\3\2\2\2vw\7\30\2\2wy\7\n\2\2xv\3"+
		"\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\17\2\2{|\5\26\f\2|}\b\7\1\2}\u0085\3\2"+
		"\2\2~\177\7\22\2\2\177\u0080\7\30\2\2\u0080\u0085\b\7\1\2\u0081\u0082"+
		"\5\16\b\2\u0082\u0083\b\7\1\2\u0083\u0085\3\2\2\2\u0084L\3\2\2\2\u0084"+
		"o\3\2\2\2\u0084x\3\2\2\2\u0084~\3\2\2\2\u0084\u0081\3\2\2\2\u0085\r\3"+
		"\2\2\2\u0086\u0087\7\13\2\2\u0087\u0088\b\b\1\2\u0088\u0094\7\b\2\2\u0089"+
		"\u008a\5\26\f\2\u008a\u0091\b\b\1\2\u008b\u008c\7\4\2\2\u008c\u008d\5"+
		"\26\f\2\u008d\u008e\b\b\1\2\u008e\u0090\3\2\2\2\u008f\u008b\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0095\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0089\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\7\3\2\2\u0097\17\3\2\2\2\u0098\u0099\7\26\2"+
		"\2\u0099\u00a2\b\t\1\2\u009a\u009b\7\27\2\2\u009b\u00a2\b\t\1\2\u009c"+
		"\u009d\7\b\2\2\u009d\u009e\5\24\13\2\u009e\u009f\7\3\2\2\u009f\u00a0\b"+
		"\t\1\2\u00a0\u00a2\3\2\2\2\u00a1\u0098\3\2\2\2\u00a1\u009a\3\2\2\2\u00a1"+
		"\u009c\3\2\2\2\u00a2\21\3\2\2\2\u00a3\u00a4\5\20\t\2\u00a4\u00af\b\n\1"+
		"\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\5\20\t\2\u00a7\u00a8\b\n\1\2\u00a8"+
		"\u00ae\3\2\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\5\20\t\2\u00ab\u00ac\b"+
		"\n\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\23\3\2\2"+
		"\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\5\22\n\2\u00b3\u00be\b\13\1\2\u00b4"+
		"\u00b5\7\5\2\2\u00b5\u00b6\5\22\n\2\u00b6\u00b7\b\13\1\2\u00b7\u00bd\3"+
		"\2\2\2\u00b8\u00b9\7\7\2\2\u00b9\u00ba\5\22\n\2\u00ba\u00bb\b\13\1\2\u00bb"+
		"\u00bd\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\25\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c2\7\26\2\2\u00c2\u00c8\b\f\1\2\u00c3\u00c4\7\27\2\2"+
		"\u00c4\u00c8\b\f\1\2\u00c5\u00c6\7\30\2\2\u00c6\u00c8\b\f\1\2\u00c7\u00c1"+
		"\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\27\3\2\2\2\30\36"+
		"\')\64CJT[bhltx\u0084\u0091\u0094\u00a1\u00ad\u00af\u00bc\u00be\u00c7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}