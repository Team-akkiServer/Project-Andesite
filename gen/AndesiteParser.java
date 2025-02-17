// Generated from D:/Projects/Andesite/src/main/antlr4/akki697222/andesite/compiler/AndesiteParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AndesiteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, SUB=2, MUL=3, DIV=4, MOD=5, L_AND=6, L_OR=7, L_NOT=8, L_XOR=9, 
		EQ=10, NE=11, GT=12, LT=13, GTE=14, LTE=15, B_AND=16, B_OR=17, B_XOR=18, 
		B_NOT=19, B_LSHIFT=20, B_RSHIFT=21, INCL=22, DECL=23, IF=24, ELSE=25, 
		FOR=26, IN=27, IS=28, NOT=29, RETURN=30, WHILE=31, REPEAT=32, UNTIL=33, 
		TRY=34, CATCH=35, FINALLY=36, BREAK=37, SWITCH=38, CASE=39, DEFAULT=40, 
		CAST=41, CLASS=42, INTERFACE=43, ABSTRACT=44, IMPLEMENTS=45, EXTENDS=46, 
		FINAL=47, CONST=48, VAR=49, FUNCTION=50, SKIPS=51, NEW=52, STATIC=53, 
		ASSIGN=54, ADD_ASSIGN=55, SUB_ASSIGN=56, MUL_ASSIGN=57, DIV_ASSIGN=58, 
		MOD_ASSIGN=59, PUBLIC=60, PRIVATE=61, PROTECTED=62, STRING=63, INTEGER=64, 
		LONG=65, FLOAT=66, DOUBLE=67, CHAR=68, VOID=69, BOOLEAN=70, NULL=71, LBRACKET=72, 
		RBRACKET=73, LBRACE=74, RBRACE=75, LPAREN=76, RPAREN=77, DOT=78, COMMA=79, 
		SEMI=80, COLON=81, VARARGS=82, LAMBDA=83, QUESTION=84, INT=85, FLOATS=86, 
		HEX=87, BIN=88, IDENTIFIER=89, STRINGS=90, CHARS=91, WS=92, COMMENT=93, 
		COMMENT_LONG=94, BOOLEAN_VALUE=95;
	public static final int
		RULE_program = 0, RULE_statements = 1, RULE_functionalStatements = 2, 
		RULE_functionDeclaration = 3, RULE_methodBlock = 4, RULE_parameterList = 5, 
		RULE_parameter = 6, RULE_methodInvoke = 7, RULE_argumentList = 8, RULE_argument = 9, 
		RULE_value = 10, RULE_types = 11, RULE_baseTypes = 12, RULE_array = 13, 
		RULE_primitive = 14, RULE_identifier = 15, RULE_string = 16, RULE_number = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statements", "functionalStatements", "functionDeclaration", 
			"methodBlock", "parameterList", "parameter", "methodInvoke", "argumentList", 
			"argument", "value", "types", "baseTypes", "array", "primitive", "identifier", 
			"string", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'^^'", 
			"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'&'", "'|'", "'^'", "'~'", 
			"'<<'", "'>>'", "'++'", "'--'", "'if'", "'else'", "'for'", "'in'", "'is'", 
			"'not'", "'return'", "'while'", "'repeat'", "'until'", "'try'", "'catch'", 
			"'finally'", "'break'", "'switch'", "'case'", "'default'", "'cast'", 
			"'class'", "'interface'", "'abstract'", "'impl'", "'extend'", "'final'", 
			"'const'", "'var'", "'fn'", "'skip'", "'new'", "'static'", "'='", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'public'", "'private'", "'protected'", 
			"'string'", "'int'", "'long'", "'float'", "'double'", "'char'", "'void'", 
			"'bool'", null, "'['", "']'", "'{'", "'}'", "'('", "')'", "'.'", "','", 
			"';'", "':'", "'...'", "'=>'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "SUB", "MUL", "DIV", "MOD", "L_AND", "L_OR", "L_NOT", "L_XOR", 
			"EQ", "NE", "GT", "LT", "GTE", "LTE", "B_AND", "B_OR", "B_XOR", "B_NOT", 
			"B_LSHIFT", "B_RSHIFT", "INCL", "DECL", "IF", "ELSE", "FOR", "IN", "IS", 
			"NOT", "RETURN", "WHILE", "REPEAT", "UNTIL", "TRY", "CATCH", "FINALLY", 
			"BREAK", "SWITCH", "CASE", "DEFAULT", "CAST", "CLASS", "INTERFACE", "ABSTRACT", 
			"IMPLEMENTS", "EXTENDS", "FINAL", "CONST", "VAR", "FUNCTION", "SKIPS", 
			"NEW", "STATIC", "ASSIGN", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
			"DIV_ASSIGN", "MOD_ASSIGN", "PUBLIC", "PRIVATE", "PROTECTED", "STRING", 
			"INTEGER", "LONG", "FLOAT", "DOUBLE", "CHAR", "VOID", "BOOLEAN", "NULL", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "DOT", 
			"COMMA", "SEMI", "COLON", "VARARGS", "LAMBDA", "QUESTION", "INT", "FLOATS", 
			"HEX", "BIN", "IDENTIFIER", "STRINGS", "CHARS", "WS", "COMMENT", "COMMENT_LONG", 
			"BOOLEAN_VALUE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AndesiteParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AndesiteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==IDENTIFIER) {
				{
				{
				setState(36);
				statements();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public MethodInvokeContext methodInvoke() {
			return getRuleContext(MethodInvokeContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				methodInvoke();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				functionDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionalStatementsContext extends ParserRuleContext {
		public MethodInvokeContext methodInvoke() {
			return getRuleContext(MethodInvokeContext.class,0);
		}
		public FunctionalStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionalStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterFunctionalStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitFunctionalStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitFunctionalStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionalStatementsContext functionalStatements() throws RecognitionException {
		FunctionalStatementsContext _localctx = new FunctionalStatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionalStatements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			methodInvoke();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(AndesiteParser.FUNCTION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(AndesiteParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AndesiteParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(AndesiteParser.COLON, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public MethodBlockContext methodBlock() {
			return getRuleContext(MethodBlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(FUNCTION);
			setState(49);
			identifier();
			setState(50);
			match(LPAREN);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(51);
				parameterList();
				}
			}

			setState(54);
			match(RPAREN);
			setState(55);
			match(COLON);
			setState(56);
			types();
			setState(57);
			methodBlock();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(AndesiteParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AndesiteParser.RBRACE, 0); }
		public List<FunctionalStatementsContext> functionalStatements() {
			return getRuleContexts(FunctionalStatementsContext.class);
		}
		public FunctionalStatementsContext functionalStatements(int i) {
			return getRuleContext(FunctionalStatementsContext.class,i);
		}
		public MethodBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterMethodBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitMethodBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitMethodBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBlockContext methodBlock() throws RecognitionException {
		MethodBlockContext _localctx = new MethodBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(LBRACE);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(60);
				functionalStatements();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AndesiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AndesiteParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			parameter();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(69);
				match(COMMA);
				setState(70);
				parameter();
				}
				}
				setState(75);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(AndesiteParser.COLON, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			identifier();
			setState(77);
			match(COLON);
			setState(78);
			types();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodInvokeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(AndesiteParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AndesiteParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvokeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvoke; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterMethodInvoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitMethodInvoke(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitMethodInvoke(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvokeContext methodInvoke() throws RecognitionException {
		MethodInvokeContext _localctx = new MethodInvokeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodInvoke);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			identifier();
			setState(81);
			match(LPAREN);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 127L) != 0)) {
				{
				setState(82);
				argumentList();
				}
			}

			setState(85);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AndesiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AndesiteParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			argument();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(88);
				match(COMMA);
				setState(89);
				argument();
				}
				}
				setState(94);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				identifier();
				}
				break;
			case STRINGS:
			case CHARS:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				string();
				}
				break;
			case INT:
			case FLOATS:
			case HEX:
			case BIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				number();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypesContext extends ParserRuleContext {
		public BaseTypesContext baseTypes() {
			return getRuleContext(BaseTypesContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_types);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				baseTypes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				array();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BaseTypesContext extends ParserRuleContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BaseTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterBaseTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitBaseTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitBaseTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypesContext baseTypes() throws RecognitionException {
		BaseTypesContext _localctx = new BaseTypesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_baseTypes);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case INTEGER:
			case LONG:
			case FLOAT:
			case DOUBLE:
			case CHAR:
			case VOID:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				primitive();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public BaseTypesContext baseTypes() {
			return getRuleContext(BaseTypesContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(AndesiteParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(AndesiteParser.RBRACKET, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			baseTypes();
			setState(111);
			match(LBRACKET);
			setState(112);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AndesiteParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(AndesiteParser.INTEGER, 0); }
		public TerminalNode LONG() { return getToken(AndesiteParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(AndesiteParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(AndesiteParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(AndesiteParser.CHAR, 0); }
		public TerminalNode VOID() { return getToken(AndesiteParser.VOID, 0); }
		public TerminalNode BOOLEAN() { return getToken(AndesiteParser.BOOLEAN, 0); }
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primitive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 255L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AndesiteParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRINGS() { return getToken(AndesiteParser.STRINGS, 0); }
		public TerminalNode CHARS() { return getToken(AndesiteParser.CHARS, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==STRINGS || _la==CHARS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AndesiteParser.INT, 0); }
		public TerminalNode HEX() { return getToken(AndesiteParser.HEX, 0); }
		public TerminalNode FLOATS() { return getToken(AndesiteParser.FLOATS, 0); }
		public TerminalNode BIN() { return getToken(AndesiteParser.BIN, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AndesiteParserListener ) ((AndesiteParserListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AndesiteParserVisitor ) return ((AndesiteParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001_{\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002"+
		"\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000&\b"+
		"\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001-\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00035\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004>\b\u0004\n\u0004"+
		"\f\u0004A\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005H\b\u0005\n\u0005\f\u0005K\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007T\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005"+
		"\b[\b\b\n\b\f\b^\t\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\ne"+
		"\b\n\u0001\u000b\u0001\u000b\u0003\u000bi\b\u000b\u0001\f\u0001\f\u0003"+
		"\fm\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0003\u0001\u0000?F\u0001"+
		"\u0000Z[\u0001\u0000UXs\u0000\'\u0001\u0000\u0000\u0000\u0002,\u0001\u0000"+
		"\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00060\u0001\u0000\u0000\u0000"+
		"\b;\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000\fL\u0001\u0000"+
		"\u0000\u0000\u000eP\u0001\u0000\u0000\u0000\u0010W\u0001\u0000\u0000\u0000"+
		"\u0012_\u0001\u0000\u0000\u0000\u0014d\u0001\u0000\u0000\u0000\u0016h"+
		"\u0001\u0000\u0000\u0000\u0018l\u0001\u0000\u0000\u0000\u001an\u0001\u0000"+
		"\u0000\u0000\u001cr\u0001\u0000\u0000\u0000\u001et\u0001\u0000\u0000\u0000"+
		" v\u0001\u0000\u0000\u0000\"x\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001"+
		"\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000(\u0001\u0001\u0000\u0000\u0000"+
		")\'\u0001\u0000\u0000\u0000*-\u0003\u000e\u0007\u0000+-\u0003\u0006\u0003"+
		"\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0003\u0001"+
		"\u0000\u0000\u0000./\u0003\u000e\u0007\u0000/\u0005\u0001\u0000\u0000"+
		"\u000001\u00052\u0000\u000012\u0003\u001e\u000f\u000024\u0005L\u0000\u0000"+
		"35\u0003\n\u0005\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000067\u0005M\u0000\u000078\u0005Q\u0000\u00008"+
		"9\u0003\u0016\u000b\u00009:\u0003\b\u0004\u0000:\u0007\u0001\u0000\u0000"+
		"\u0000;?\u0005J\u0000\u0000<>\u0003\u0004\u0002\u0000=<\u0001\u0000\u0000"+
		"\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005"+
		"K\u0000\u0000C\t\u0001\u0000\u0000\u0000DI\u0003\f\u0006\u0000EF\u0005"+
		"O\u0000\u0000FH\u0003\f\u0006\u0000GE\u0001\u0000\u0000\u0000HK\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"J\u000b\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0003\u001e"+
		"\u000f\u0000MN\u0005Q\u0000\u0000NO\u0003\u0016\u000b\u0000O\r\u0001\u0000"+
		"\u0000\u0000PQ\u0003\u001e\u000f\u0000QS\u0005L\u0000\u0000RT\u0003\u0010"+
		"\b\u0000SR\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UV\u0005M\u0000\u0000V\u000f\u0001\u0000\u0000\u0000W\\\u0003"+
		"\u0012\t\u0000XY\u0005O\u0000\u0000Y[\u0003\u0012\t\u0000ZX\u0001\u0000"+
		"\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\u0011\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000_`\u0003\u0014\n\u0000`\u0013\u0001\u0000\u0000\u0000ae\u0003\u001e"+
		"\u000f\u0000be\u0003 \u0010\u0000ce\u0003\"\u0011\u0000da\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000e\u0015"+
		"\u0001\u0000\u0000\u0000fi\u0003\u0018\f\u0000gi\u0003\u001a\r\u0000h"+
		"f\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\u0017\u0001\u0000"+
		"\u0000\u0000jm\u0003\u001c\u000e\u0000km\u0003\u001e\u000f\u0000lj\u0001"+
		"\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000m\u0019\u0001\u0000\u0000"+
		"\u0000no\u0003\u0018\f\u0000op\u0005H\u0000\u0000pq\u0005I\u0000\u0000"+
		"q\u001b\u0001\u0000\u0000\u0000rs\u0007\u0000\u0000\u0000s\u001d\u0001"+
		"\u0000\u0000\u0000tu\u0005Y\u0000\u0000u\u001f\u0001\u0000\u0000\u0000"+
		"vw\u0007\u0001\u0000\u0000w!\u0001\u0000\u0000\u0000xy\u0007\u0002\u0000"+
		"\u0000y#\u0001\u0000\u0000\u0000\n\',4?IS\\dhl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}