// $ANTLR 3.5.2 PythonPartial.g 2020-08-11 14:04:16

package org.jpp.astnodes;


import org.antlr.runtime.*;

/** Python 3.5.1 Grammar
 *
 *  Terence Parr and Loring Craymer
 *  February 2004
 *
 *  Converted to ANTLR v3 November 2005 by Terence Parr.
 *
 *  This grammar was derived automatically from the Python 2.3.3
 *  parser grammar to get a syntactically correct ANTLR grammar
 *  for Python.  Then Terence hand tweaked it to be semantically
 *  correct; i.e., removed lookahead issues etc...  It is LL(1)
 *  except for the (sometimes optional) trailing commas and semi-colons.
 *  It needs two symbols of lookahead in this case.
 *
 *  Starting with Loring's preliminary lexer for Python, I modified it
 *  to do my version of the whole nasty INDENT/DEDENT issue just so I
 *  could understand the problem better.  This grammar requires
 *  PythonTokenStream.java to work.  Also I used some rules from the
 *  semi-formal grammar on the web for Python (automatically
 *  translated to ANTLR format by an ANTLR grammar, naturally <grin>).
 *  The lexical rules for python are particularly nasty and it took me
 *  a long time to get it 'right'; i.e., think about it in the proper
 *  way.  Resist changing the lexer unless you've used ANTLR a lot. ;)
 *
 *  I (Terence) tested this by running it on the jython-2.1/Lib
 *  directory of 40k lines of Python.
 *
 *  REQUIRES ANTLR v3
 *
 *  Updated to Python 2.5 by Frank Wierzbicki.
 *
 */
@SuppressWarnings("all")
public class PythonPartialParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALT_NOTEQUAL", "AMPER", "AMPEREQUAL", 
		"AND", "ARROW", "AS", "ASSERT", "ASSIGN", "ASYNC", "AT", "ATEQUAL", "AWAIT", 
		"BACKQUOTE", "BREAK", "CIRCUMFLEX", "CIRCUMFLEXEQUAL", "CLASS", "COLON", 
		"COMMA", "COMMENT", "COMPLEX", "CONTINUE", "CONTINUED_LINE", "DEDENT", 
		"DEF", "DELETE", "DIGITS", "DOT", "DOUBLESLASH", "DOUBLESLASHEQUAL", "DOUBLESTAR", 
		"DOUBLESTAREQUAL", "ELIF", "EQUAL", "ESC", "EXCEPT", "EXEC", "Exponent", 
		"FINALLY", "FLOAT", "FOR", "FROM", "GLOBAL", "GREATER", "GREATEREQUAL", 
		"IF", "IMPORT", "IN", "INDENT", "INT", "IS", "LAMBDA", "LBRACK", "LCURLY", 
		"LEADING_WS", "LEFTSHIFT", "LEFTSHIFTEQUAL", "LESS", "LESSEQUAL", "LETTER", 
		"LONGINT", "LPAREN", "MINUS", "MINUSEQUAL", "NAME", "NEWLINE", "NONLOCAL", 
		"NOT", "NOTEQUAL", "OR", "ORELSE", "PASS", "PERCENT", "PERCENTEQUAL", 
		"PLUS", "PLUSEQUAL", "RAISE", "RBRACK", "RCURLY", "RETURN", "RIGHTSHIFT", 
		"RIGHTSHIFTEQUAL", "RPAREN", "SEMI", "SLASH", "SLASHEQUAL", "STAR", "STAREQUAL", 
		"STRING", "TILDE", "TRAILBACKSLASH", "TRIAPOS", "TRIQUOTE", "TRY", "VBAR", 
		"VBAREQUAL", "WHILE", "WITH", "WS", "YIELD", "PRINT", "STRINGPART", "TRISTRINGPART"
	};
	public static final int EOF=-1;
	public static final int ALT_NOTEQUAL=4;
	public static final int AMPER=5;
	public static final int AMPEREQUAL=6;
	public static final int AND=7;
	public static final int ARROW=8;
	public static final int AS=9;
	public static final int ASSERT=10;
	public static final int ASSIGN=11;
	public static final int ASYNC=12;
	public static final int AT=13;
	public static final int ATEQUAL=14;
	public static final int AWAIT=15;
	public static final int BACKQUOTE=16;
	public static final int BREAK=17;
	public static final int CIRCUMFLEX=18;
	public static final int CIRCUMFLEXEQUAL=19;
	public static final int CLASS=20;
	public static final int COLON=21;
	public static final int COMMA=22;
	public static final int COMMENT=23;
	public static final int COMPLEX=24;
	public static final int CONTINUE=25;
	public static final int CONTINUED_LINE=26;
	public static final int DEDENT=27;
	public static final int DEF=28;
	public static final int DELETE=29;
	public static final int DIGITS=30;
	public static final int DOT=31;
	public static final int DOUBLESLASH=32;
	public static final int DOUBLESLASHEQUAL=33;
	public static final int DOUBLESTAR=34;
	public static final int DOUBLESTAREQUAL=35;
	public static final int ELIF=36;
	public static final int EQUAL=37;
	public static final int ESC=38;
	public static final int EXCEPT=39;
	public static final int EXEC=40;
	public static final int Exponent=41;
	public static final int FINALLY=42;
	public static final int FLOAT=43;
	public static final int FOR=44;
	public static final int FROM=45;
	public static final int GLOBAL=46;
	public static final int GREATER=47;
	public static final int GREATEREQUAL=48;
	public static final int IF=49;
	public static final int IMPORT=50;
	public static final int IN=51;
	public static final int INDENT=52;
	public static final int INT=53;
	public static final int IS=54;
	public static final int LAMBDA=55;
	public static final int LBRACK=56;
	public static final int LCURLY=57;
	public static final int LEADING_WS=58;
	public static final int LEFTSHIFT=59;
	public static final int LEFTSHIFTEQUAL=60;
	public static final int LESS=61;
	public static final int LESSEQUAL=62;
	public static final int LETTER=63;
	public static final int LONGINT=64;
	public static final int LPAREN=65;
	public static final int MINUS=66;
	public static final int MINUSEQUAL=67;
	public static final int NAME=68;
	public static final int NEWLINE=69;
	public static final int NONLOCAL=70;
	public static final int NOT=71;
	public static final int NOTEQUAL=72;
	public static final int OR=73;
	public static final int ORELSE=74;
	public static final int PASS=75;
	public static final int PERCENT=76;
	public static final int PERCENTEQUAL=77;
	public static final int PLUS=78;
	public static final int PLUSEQUAL=79;
	public static final int RAISE=80;
	public static final int RBRACK=81;
	public static final int RCURLY=82;
	public static final int RETURN=83;
	public static final int RIGHTSHIFT=84;
	public static final int RIGHTSHIFTEQUAL=85;
	public static final int RPAREN=86;
	public static final int SEMI=87;
	public static final int SLASH=88;
	public static final int SLASHEQUAL=89;
	public static final int STAR=90;
	public static final int STAREQUAL=91;
	public static final int STRING=92;
	public static final int TILDE=93;
	public static final int TRAILBACKSLASH=94;
	public static final int TRIAPOS=95;
	public static final int TRIQUOTE=96;
	public static final int TRY=97;
	public static final int VBAR=98;
	public static final int VBAREQUAL=99;
	public static final int WHILE=100;
	public static final int WITH=101;
	public static final int WS=102;
	public static final int YIELD=103;
	public static final int PRINT=104;
	public static final int STRINGPART=105;
	public static final int TRISTRINGPART=106;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PythonPartialParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PythonPartialParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return PythonPartialParser.tokenNames; }
	@Override public String getGrammarFileName() { return "PythonPartial.g"; }


	    private ErrorHandler errorHandler = new FailFastHandler();

	    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
	        throws RecognitionException {

	        Object o = errorHandler.recoverFromMismatchedToken(this, input, ttype, follow);
	        if (o != null) {
	            return o;
	        }
	        return super.recoverFromMismatchedToken(input, ttype, follow);
	    }




	// $ANTLR start "single_input"
	// PythonPartial.g:176:1: single_input : ( NEWLINE | simple_stmt | compound_stmt ( NEWLINE )? EOF );
	public final void single_input() throws RecognitionException {
		try {
			// PythonPartial.g:178:5: ( NEWLINE | simple_stmt | compound_stmt ( NEWLINE )? EOF )
			int alt2=3;
			switch ( input.LA(1) ) {
			case NEWLINE:
				{
				alt2=1;
				}
				break;
			case ASSERT:
			case AWAIT:
			case BACKQUOTE:
			case BREAK:
			case COMPLEX:
			case CONTINUE:
			case DELETE:
			case DOT:
			case EXEC:
			case FLOAT:
			case FROM:
			case GLOBAL:
			case IMPORT:
			case INT:
			case LAMBDA:
			case LBRACK:
			case LCURLY:
			case LONGINT:
			case LPAREN:
			case MINUS:
			case NAME:
			case NOT:
			case PASS:
			case PLUS:
			case RAISE:
			case RETURN:
			case STRING:
			case TILDE:
			case TRAILBACKSLASH:
			case YIELD:
			case PRINT:
			case STRINGPART:
			case TRISTRINGPART:
				{
				alt2=2;
				}
				break;
			case ASYNC:
			case AT:
			case CLASS:
			case DEF:
			case FOR:
			case IF:
			case TRY:
			case WHILE:
			case WITH:
				{
				alt2=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// PythonPartial.g:178:7: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input72); if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:179:7: simple_stmt
					{
					pushFollow(FOLLOW_simple_stmt_in_single_input80);
					simple_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:180:7: compound_stmt ( NEWLINE )? EOF
					{
					pushFollow(FOLLOW_compound_stmt_in_single_input88);
					compound_stmt();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:180:21: ( NEWLINE )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==NEWLINE) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// PythonPartial.g:180:21: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input90); if (state.failed) return;
							}
							break;

					}

					match(input,EOF,FOLLOW_EOF_in_single_input93); if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "single_input"



	// $ANTLR start "eval_input"
	// PythonPartial.g:184:1: eval_input : ( LEADING_WS )? ( NEWLINE )* ( testlist )? ( NEWLINE )* EOF ;
	public final void eval_input() throws RecognitionException {
		try {
			// PythonPartial.g:185:5: ( ( LEADING_WS )? ( NEWLINE )* ( testlist )? ( NEWLINE )* EOF )
			// PythonPartial.g:185:7: ( LEADING_WS )? ( NEWLINE )* ( testlist )? ( NEWLINE )* EOF
			{
			// PythonPartial.g:185:7: ( LEADING_WS )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==LEADING_WS) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// PythonPartial.g:185:7: LEADING_WS
					{
					match(input,LEADING_WS,FOLLOW_LEADING_WS_in_eval_input111); if (state.failed) return;
					}
					break;

			}

			// PythonPartial.g:185:19: ( NEWLINE )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==NEWLINE) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// PythonPartial.g:185:20: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_eval_input115); if (state.failed) return;
					}
					break;

				default :
					break loop4;
				}
			}

			// PythonPartial.g:185:30: ( testlist )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= AWAIT && LA5_0 <= BACKQUOTE)||LA5_0==COMPLEX||LA5_0==DOT||LA5_0==FLOAT||LA5_0==INT||(LA5_0 >= LAMBDA && LA5_0 <= LCURLY)||(LA5_0 >= LONGINT && LA5_0 <= MINUS)||LA5_0==NAME||LA5_0==NOT||LA5_0==PLUS||(LA5_0 >= STRING && LA5_0 <= TRAILBACKSLASH)||(LA5_0 >= STRINGPART && LA5_0 <= TRISTRINGPART)) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// PythonPartial.g:185:30: testlist
					{
					pushFollow(FOLLOW_testlist_in_eval_input119);
					testlist();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// PythonPartial.g:185:40: ( NEWLINE )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==NEWLINE) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// PythonPartial.g:185:41: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_eval_input123); if (state.failed) return;
					}
					break;

				default :
					break loop6;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_eval_input127); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "eval_input"



	// $ANTLR start "dotted_attr"
	// PythonPartial.g:189:1: dotted_attr : NAME ( ( DOT NAME )+ |) ;
	public final void dotted_attr() throws RecognitionException {
		try {
			// PythonPartial.g:190:5: ( NAME ( ( DOT NAME )+ |) )
			// PythonPartial.g:190:7: NAME ( ( DOT NAME )+ |)
			{
			match(input,NAME,FOLLOW_NAME_in_dotted_attr145); if (state.failed) return;
			// PythonPartial.g:191:7: ( ( DOT NAME )+ |)
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==DOT) ) {
				alt8=1;
			}
			else if ( (LA8_0==LPAREN||LA8_0==NEWLINE) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// PythonPartial.g:191:9: ( DOT NAME )+
					{
					// PythonPartial.g:191:9: ( DOT NAME )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==DOT) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// PythonPartial.g:191:10: DOT NAME
							{
							match(input,DOT,FOLLOW_DOT_in_dotted_attr156); if (state.failed) return;
							match(input,NAME,FOLLOW_NAME_in_dotted_attr158); if (state.failed) return;
							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:193:7: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dotted_attr"



	// $ANTLR start "attr"
	// PythonPartial.g:211:1: attr : ( NAME | AND | AS | ASSERT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NOT | OR | ORELSE | PASS | PRINT | RAISE | RETURN | TRY | WHILE | WITH | YIELD );
	public final void attr() throws RecognitionException {
		try {
			// PythonPartial.g:212:5: ( NAME | AND | AS | ASSERT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NOT | OR | ORELSE | PASS | PRINT | RAISE | RETURN | TRY | WHILE | WITH | YIELD )
			// PythonPartial.g:
			{
			if ( input.LA(1)==AND||(input.LA(1) >= AS && input.LA(1) <= ASSERT)||input.LA(1)==BREAK||input.LA(1)==CLASS||input.LA(1)==CONTINUE||(input.LA(1) >= DEF && input.LA(1) <= DELETE)||input.LA(1)==ELIF||(input.LA(1) >= EXCEPT && input.LA(1) <= EXEC)||input.LA(1)==FINALLY||(input.LA(1) >= FOR && input.LA(1) <= GLOBAL)||(input.LA(1) >= IF && input.LA(1) <= IN)||(input.LA(1) >= IS && input.LA(1) <= LAMBDA)||input.LA(1)==NAME||input.LA(1)==NOT||(input.LA(1) >= OR && input.LA(1) <= PASS)||input.LA(1)==RAISE||input.LA(1)==RETURN||input.LA(1)==TRY||(input.LA(1) >= WHILE && input.LA(1) <= WITH)||(input.LA(1) >= YIELD && input.LA(1) <= PRINT) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "attr"



	// $ANTLR start "decorator"
	// PythonPartial.g:247:1: decorator : AT dotted_attr ( LPAREN ( arglist |) RPAREN |) NEWLINE ;
	public final void decorator() throws RecognitionException {
		try {
			// PythonPartial.g:248:5: ( AT dotted_attr ( LPAREN ( arglist |) RPAREN |) NEWLINE )
			// PythonPartial.g:248:7: AT dotted_attr ( LPAREN ( arglist |) RPAREN |) NEWLINE
			{
			match(input,AT,FOLLOW_AT_in_decorator464); if (state.failed) return;
			pushFollow(FOLLOW_dotted_attr_in_decorator466);
			dotted_attr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:249:5: ( LPAREN ( arglist |) RPAREN |)
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==LPAREN) ) {
				alt10=1;
			}
			else if ( (LA10_0==NEWLINE) ) {
				alt10=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// PythonPartial.g:249:7: LPAREN ( arglist |) RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_decorator474); if (state.failed) return;
					// PythonPartial.g:250:7: ( arglist |)
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( ((LA9_0 >= AWAIT && LA9_0 <= BACKQUOTE)||LA9_0==COMPLEX||LA9_0==DOT||LA9_0==FLOAT||LA9_0==INT||(LA9_0 >= LAMBDA && LA9_0 <= LCURLY)||(LA9_0 >= LONGINT && LA9_0 <= MINUS)||LA9_0==NAME||LA9_0==NOT||LA9_0==PLUS||LA9_0==STAR||(LA9_0 >= STRING && LA9_0 <= TRAILBACKSLASH)||(LA9_0 >= STRINGPART && LA9_0 <= TRISTRINGPART)) ) {
						alt9=1;
					}
					else if ( (LA9_0==RPAREN) ) {
						alt9=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}

					switch (alt9) {
						case 1 :
							// PythonPartial.g:250:9: arglist
							{
							pushFollow(FOLLOW_arglist_in_decorator484);
							arglist();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:252:7: 
							{
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_decorator508); if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:255:5: 
					{
					}
					break;

			}

			match(input,NEWLINE,FOLLOW_NEWLINE_in_decorator522); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decorator"



	// $ANTLR start "decorators"
	// PythonPartial.g:259:1: decorators : ( decorator )+ ;
	public final void decorators() throws RecognitionException {
		try {
			// PythonPartial.g:260:5: ( ( decorator )+ )
			// PythonPartial.g:260:7: ( decorator )+
			{
			// PythonPartial.g:260:7: ( decorator )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==AT) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// PythonPartial.g:260:7: decorator
					{
					pushFollow(FOLLOW_decorator_in_decorators540);
					decorator();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decorators"



	// $ANTLR start "decorated"
	// PythonPartial.g:264:1: decorated : decorators ( classdef | funcdef | async_funcdef ) ;
	public final void decorated() throws RecognitionException {
		try {
			// PythonPartial.g:265:5: ( decorators ( classdef | funcdef | async_funcdef ) )
			// PythonPartial.g:265:7: decorators ( classdef | funcdef | async_funcdef )
			{
			pushFollow(FOLLOW_decorators_in_decorated559);
			decorators();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:265:18: ( classdef | funcdef | async_funcdef )
			int alt12=3;
			switch ( input.LA(1) ) {
			case CLASS:
				{
				alt12=1;
				}
				break;
			case DEF:
				{
				alt12=2;
				}
				break;
			case ASYNC:
				{
				alt12=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// PythonPartial.g:265:19: classdef
					{
					pushFollow(FOLLOW_classdef_in_decorated562);
					classdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:265:30: funcdef
					{
					pushFollow(FOLLOW_funcdef_in_decorated566);
					funcdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:265:40: async_funcdef
					{
					pushFollow(FOLLOW_async_funcdef_in_decorated570);
					async_funcdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decorated"



	// $ANTLR start "async_funcdef"
	// PythonPartial.g:269:1: async_funcdef : ASYNC funcdef ;
	public final void async_funcdef() throws RecognitionException {
		try {
			// PythonPartial.g:270:5: ( ASYNC funcdef )
			// PythonPartial.g:270:7: ASYNC funcdef
			{
			match(input,ASYNC,FOLLOW_ASYNC_in_async_funcdef589); if (state.failed) return;
			pushFollow(FOLLOW_funcdef_in_async_funcdef591);
			funcdef();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "async_funcdef"



	// $ANTLR start "funcdef"
	// PythonPartial.g:274:1: funcdef : DEF NAME parameters ( ARROW test )? COLON suite ;
	public final void funcdef() throws RecognitionException {
		try {
			// PythonPartial.g:275:5: ( DEF NAME parameters ( ARROW test )? COLON suite )
			// PythonPartial.g:275:7: DEF NAME parameters ( ARROW test )? COLON suite
			{
			match(input,DEF,FOLLOW_DEF_in_funcdef609); if (state.failed) return;
			match(input,NAME,FOLLOW_NAME_in_funcdef611); if (state.failed) return;
			pushFollow(FOLLOW_parameters_in_funcdef613);
			parameters();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:275:27: ( ARROW test )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==ARROW) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// PythonPartial.g:275:28: ARROW test
					{
					match(input,ARROW,FOLLOW_ARROW_in_funcdef616); if (state.failed) return;
					pushFollow(FOLLOW_test_in_funcdef618);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,COLON,FOLLOW_COLON_in_funcdef622); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_funcdef624);
			suite();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "funcdef"



	// $ANTLR start "parameters"
	// PythonPartial.g:279:1: parameters : LPAREN ( typedargslist |) RPAREN ;
	public final void parameters() throws RecognitionException {
		try {
			// PythonPartial.g:280:5: ( LPAREN ( typedargslist |) RPAREN )
			// PythonPartial.g:280:7: LPAREN ( typedargslist |) RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_parameters642); if (state.failed) return;
			// PythonPartial.g:281:7: ( typedargslist |)
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==DOUBLESTAR||LA14_0==NAME||LA14_0==STAR) ) {
				alt14=1;
			}
			else if ( (LA14_0==RPAREN) ) {
				alt14=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// PythonPartial.g:281:8: typedargslist
					{
					pushFollow(FOLLOW_typedargslist_in_parameters651);
					typedargslist();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:283:7: 
					{
					}
					break;

			}

			match(input,RPAREN,FOLLOW_RPAREN_in_parameters675); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parameters"



	// $ANTLR start "typedargslist"
	// PythonPartial.g:292:1: typedargslist : ( tfpdef ( ASSIGN test )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )? )? | STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? ) ;
	public final void typedargslist() throws RecognitionException {
		try {
			// PythonPartial.g:293:5: ( ( tfpdef ( ASSIGN test )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )? )? | STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? ) )
			// PythonPartial.g:293:8: ( tfpdef ( ASSIGN test )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )? )? | STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )
			{
			// PythonPartial.g:293:8: ( tfpdef ( ASSIGN test )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )? )? | STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )
			int alt34=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt34=1;
				}
				break;
			case STAR:
				{
				alt34=2;
				}
				break;
			case DOUBLESTAR:
				{
				alt34=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}
			switch (alt34) {
				case 1 :
					// PythonPartial.g:293:9: tfpdef ( ASSIGN test )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )? )?
					{
					pushFollow(FOLLOW_tfpdef_in_typedargslist699);
					tfpdef();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:293:16: ( ASSIGN test )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==ASSIGN) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// PythonPartial.g:293:17: ASSIGN test
							{
							match(input,ASSIGN,FOLLOW_ASSIGN_in_typedargslist702); if (state.failed) return;
							pushFollow(FOLLOW_test_in_typedargslist704);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:293:31: ( COMMA tfpdef ( ASSIGN test )? )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==COMMA) ) {
							int LA17_1 = input.LA(2);
							if ( (LA17_1==NAME) ) {
								alt17=1;
							}

						}

						switch (alt17) {
						case 1 :
							// PythonPartial.g:293:32: COMMA tfpdef ( ASSIGN test )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_typedargslist709); if (state.failed) return;
							pushFollow(FOLLOW_tfpdef_in_typedargslist711);
							tfpdef();
							state._fsp--;
							if (state.failed) return;
							// PythonPartial.g:293:45: ( ASSIGN test )?
							int alt16=2;
							int LA16_0 = input.LA(1);
							if ( (LA16_0==ASSIGN) ) {
								alt16=1;
							}
							switch (alt16) {
								case 1 :
									// PythonPartial.g:293:46: ASSIGN test
									{
									match(input,ASSIGN,FOLLOW_ASSIGN_in_typedargslist714); if (state.failed) return;
									pushFollow(FOLLOW_test_in_typedargslist716);
									test();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

						default :
							break loop17;
						}
					}

					// PythonPartial.g:294:8: ( COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )? )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==COMMA) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// PythonPartial.g:294:10: COMMA ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_typedargslist731); if (state.failed) return;
							// PythonPartial.g:294:16: ( STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )? | DOUBLESTAR tfpdef ( COMMA )? )?
							int alt25=3;
							int LA25_0 = input.LA(1);
							if ( (LA25_0==STAR) ) {
								alt25=1;
							}
							else if ( (LA25_0==DOUBLESTAR) ) {
								alt25=2;
							}
							switch (alt25) {
								case 1 :
									// PythonPartial.g:294:18: STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )?
									{
									match(input,STAR,FOLLOW_STAR_in_typedargslist735); if (state.failed) return;
									// PythonPartial.g:294:23: ( tfpdef )?
									int alt18=2;
									int LA18_0 = input.LA(1);
									if ( (LA18_0==NAME) ) {
										alt18=1;
									}
									switch (alt18) {
										case 1 :
											// PythonPartial.g:294:23: tfpdef
											{
											pushFollow(FOLLOW_tfpdef_in_typedargslist737);
											tfpdef();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									// PythonPartial.g:294:31: ( COMMA tfpdef ( ASSIGN test )? )*
									loop20:
									while (true) {
										int alt20=2;
										int LA20_0 = input.LA(1);
										if ( (LA20_0==COMMA) ) {
											int LA20_1 = input.LA(2);
											if ( (LA20_1==NAME) ) {
												alt20=1;
											}

										}

										switch (alt20) {
										case 1 :
											// PythonPartial.g:294:32: COMMA tfpdef ( ASSIGN test )?
											{
											match(input,COMMA,FOLLOW_COMMA_in_typedargslist741); if (state.failed) return;
											pushFollow(FOLLOW_tfpdef_in_typedargslist743);
											tfpdef();
											state._fsp--;
											if (state.failed) return;
											// PythonPartial.g:294:45: ( ASSIGN test )?
											int alt19=2;
											int LA19_0 = input.LA(1);
											if ( (LA19_0==ASSIGN) ) {
												alt19=1;
											}
											switch (alt19) {
												case 1 :
													// PythonPartial.g:294:46: ASSIGN test
													{
													match(input,ASSIGN,FOLLOW_ASSIGN_in_typedargslist746); if (state.failed) return;
													pushFollow(FOLLOW_test_in_typedargslist748);
													test();
													state._fsp--;
													if (state.failed) return;
													}
													break;

											}

											}
											break;

										default :
											break loop20;
										}
									}

									// PythonPartial.g:294:62: ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )?
									int alt23=2;
									int LA23_0 = input.LA(1);
									if ( (LA23_0==COMMA) ) {
										alt23=1;
									}
									switch (alt23) {
										case 1 :
											// PythonPartial.g:294:63: COMMA ( DOUBLESTAR tfpdef ( COMMA )? )?
											{
											match(input,COMMA,FOLLOW_COMMA_in_typedargslist755); if (state.failed) return;
											// PythonPartial.g:294:69: ( DOUBLESTAR tfpdef ( COMMA )? )?
											int alt22=2;
											int LA22_0 = input.LA(1);
											if ( (LA22_0==DOUBLESTAR) ) {
												alt22=1;
											}
											switch (alt22) {
												case 1 :
													// PythonPartial.g:294:70: DOUBLESTAR tfpdef ( COMMA )?
													{
													match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist758); if (state.failed) return;
													pushFollow(FOLLOW_tfpdef_in_typedargslist760);
													tfpdef();
													state._fsp--;
													if (state.failed) return;
													// PythonPartial.g:294:88: ( COMMA )?
													int alt21=2;
													int LA21_0 = input.LA(1);
													if ( (LA21_0==COMMA) ) {
														alt21=1;
													}
													switch (alt21) {
														case 1 :
															// PythonPartial.g:294:88: COMMA
															{
															match(input,COMMA,FOLLOW_COMMA_in_typedargslist762); if (state.failed) return;
															}
															break;

													}

													}
													break;

											}

											}
											break;

									}

									}
									break;
								case 2 :
									// PythonPartial.g:295:18: DOUBLESTAR tfpdef ( COMMA )?
									{
									match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist786); if (state.failed) return;
									pushFollow(FOLLOW_tfpdef_in_typedargslist788);
									tfpdef();
									state._fsp--;
									if (state.failed) return;
									// PythonPartial.g:295:36: ( COMMA )?
									int alt24=2;
									int LA24_0 = input.LA(1);
									if ( (LA24_0==COMMA) ) {
										alt24=1;
									}
									switch (alt24) {
										case 1 :
											// PythonPartial.g:295:36: COMMA
											{
											match(input,COMMA,FOLLOW_COMMA_in_typedargslist790); if (state.failed) return;
											}
											break;

									}

									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:296:10: STAR ( tfpdef )? ( COMMA tfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )?
					{
					match(input,STAR,FOLLOW_STAR_in_typedargslist806); if (state.failed) return;
					// PythonPartial.g:296:15: ( tfpdef )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==NAME) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// PythonPartial.g:296:15: tfpdef
							{
							pushFollow(FOLLOW_tfpdef_in_typedargslist808);
							tfpdef();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:296:23: ( COMMA tfpdef ( ASSIGN test )? )*
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							int LA29_1 = input.LA(2);
							if ( (LA29_1==NAME) ) {
								alt29=1;
							}

						}

						switch (alt29) {
						case 1 :
							// PythonPartial.g:296:24: COMMA tfpdef ( ASSIGN test )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_typedargslist812); if (state.failed) return;
							pushFollow(FOLLOW_tfpdef_in_typedargslist814);
							tfpdef();
							state._fsp--;
							if (state.failed) return;
							// PythonPartial.g:296:37: ( ASSIGN test )?
							int alt28=2;
							int LA28_0 = input.LA(1);
							if ( (LA28_0==ASSIGN) ) {
								alt28=1;
							}
							switch (alt28) {
								case 1 :
									// PythonPartial.g:296:38: ASSIGN test
									{
									match(input,ASSIGN,FOLLOW_ASSIGN_in_typedargslist817); if (state.failed) return;
									pushFollow(FOLLOW_test_in_typedargslist819);
									test();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

						default :
							break loop29;
						}
					}

					// PythonPartial.g:296:54: ( COMMA ( DOUBLESTAR tfpdef ( COMMA )? )? )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==COMMA) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// PythonPartial.g:296:55: COMMA ( DOUBLESTAR tfpdef ( COMMA )? )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_typedargslist826); if (state.failed) return;
							// PythonPartial.g:296:61: ( DOUBLESTAR tfpdef ( COMMA )? )?
							int alt31=2;
							int LA31_0 = input.LA(1);
							if ( (LA31_0==DOUBLESTAR) ) {
								alt31=1;
							}
							switch (alt31) {
								case 1 :
									// PythonPartial.g:296:62: DOUBLESTAR tfpdef ( COMMA )?
									{
									match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist829); if (state.failed) return;
									pushFollow(FOLLOW_tfpdef_in_typedargslist831);
									tfpdef();
									state._fsp--;
									if (state.failed) return;
									// PythonPartial.g:296:80: ( COMMA )?
									int alt30=2;
									int LA30_0 = input.LA(1);
									if ( (LA30_0==COMMA) ) {
										alt30=1;
									}
									switch (alt30) {
										case 1 :
											// PythonPartial.g:296:80: COMMA
											{
											match(input,COMMA,FOLLOW_COMMA_in_typedargslist833); if (state.failed) return;
											}
											break;

									}

									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 3 :
					// PythonPartial.g:297:10: DOUBLESTAR tfpdef ( COMMA )?
					{
					match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist849); if (state.failed) return;
					pushFollow(FOLLOW_tfpdef_in_typedargslist851);
					tfpdef();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:297:28: ( COMMA )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==COMMA) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// PythonPartial.g:297:28: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_typedargslist853); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "typedargslist"



	// $ANTLR start "tfpdef"
	// PythonPartial.g:301:1: tfpdef : NAME ( COLON test )? ;
	public final void tfpdef() throws RecognitionException {
		try {
			// PythonPartial.g:302:5: ( NAME ( COLON test )? )
			// PythonPartial.g:302:7: NAME ( COLON test )?
			{
			match(input,NAME,FOLLOW_NAME_in_tfpdef873); if (state.failed) return;
			// PythonPartial.g:302:12: ( COLON test )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==COLON) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// PythonPartial.g:302:13: COLON test
					{
					match(input,COLON,FOLLOW_COLON_in_tfpdef876); if (state.failed) return;
					pushFollow(FOLLOW_test_in_tfpdef878);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tfpdef"



	// $ANTLR start "varargslist"
	// PythonPartial.g:310:1: varargslist : ( vfpdef ( ASSIGN test )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )? )? | STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? ) ;
	public final void varargslist() throws RecognitionException {
		try {
			// PythonPartial.g:311:5: ( ( vfpdef ( ASSIGN test )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )? )? | STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? ) )
			// PythonPartial.g:311:8: ( vfpdef ( ASSIGN test )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )? )? | STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )
			{
			// PythonPartial.g:311:8: ( vfpdef ( ASSIGN test )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )? )? | STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )
			int alt55=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt55=1;
				}
				break;
			case STAR:
				{
				alt55=2;
				}
				break;
			case DOUBLESTAR:
				{
				alt55=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}
			switch (alt55) {
				case 1 :
					// PythonPartial.g:311:9: vfpdef ( ASSIGN test )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )? )?
					{
					pushFollow(FOLLOW_vfpdef_in_varargslist901);
					vfpdef();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:311:16: ( ASSIGN test )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==ASSIGN) ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// PythonPartial.g:311:17: ASSIGN test
							{
							match(input,ASSIGN,FOLLOW_ASSIGN_in_varargslist904); if (state.failed) return;
							pushFollow(FOLLOW_test_in_varargslist906);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:311:31: ( COMMA vfpdef ( ASSIGN test )? )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==COMMA) ) {
							int LA38_1 = input.LA(2);
							if ( (LA38_1==NAME) ) {
								alt38=1;
							}

						}

						switch (alt38) {
						case 1 :
							// PythonPartial.g:311:32: COMMA vfpdef ( ASSIGN test )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_varargslist911); if (state.failed) return;
							pushFollow(FOLLOW_vfpdef_in_varargslist913);
							vfpdef();
							state._fsp--;
							if (state.failed) return;
							// PythonPartial.g:311:45: ( ASSIGN test )?
							int alt37=2;
							int LA37_0 = input.LA(1);
							if ( (LA37_0==ASSIGN) ) {
								alt37=1;
							}
							switch (alt37) {
								case 1 :
									// PythonPartial.g:311:46: ASSIGN test
									{
									match(input,ASSIGN,FOLLOW_ASSIGN_in_varargslist916); if (state.failed) return;
									pushFollow(FOLLOW_test_in_varargslist918);
									test();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

						default :
							break loop38;
						}
					}

					// PythonPartial.g:312:8: ( COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )? )?
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==COMMA) ) {
						alt47=1;
					}
					switch (alt47) {
						case 1 :
							// PythonPartial.g:312:10: COMMA ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_varargslist933); if (state.failed) return;
							// PythonPartial.g:312:16: ( STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )? | DOUBLESTAR vfpdef ( COMMA )? )?
							int alt46=3;
							int LA46_0 = input.LA(1);
							if ( (LA46_0==STAR) ) {
								alt46=1;
							}
							else if ( (LA46_0==DOUBLESTAR) ) {
								alt46=2;
							}
							switch (alt46) {
								case 1 :
									// PythonPartial.g:312:18: STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )?
									{
									match(input,STAR,FOLLOW_STAR_in_varargslist937); if (state.failed) return;
									// PythonPartial.g:312:23: ( vfpdef )?
									int alt39=2;
									int LA39_0 = input.LA(1);
									if ( (LA39_0==NAME) ) {
										alt39=1;
									}
									switch (alt39) {
										case 1 :
											// PythonPartial.g:312:23: vfpdef
											{
											pushFollow(FOLLOW_vfpdef_in_varargslist939);
											vfpdef();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									// PythonPartial.g:312:31: ( COMMA vfpdef ( ASSIGN test )? )*
									loop41:
									while (true) {
										int alt41=2;
										int LA41_0 = input.LA(1);
										if ( (LA41_0==COMMA) ) {
											int LA41_1 = input.LA(2);
											if ( (LA41_1==NAME) ) {
												alt41=1;
											}

										}

										switch (alt41) {
										case 1 :
											// PythonPartial.g:312:32: COMMA vfpdef ( ASSIGN test )?
											{
											match(input,COMMA,FOLLOW_COMMA_in_varargslist943); if (state.failed) return;
											pushFollow(FOLLOW_vfpdef_in_varargslist945);
											vfpdef();
											state._fsp--;
											if (state.failed) return;
											// PythonPartial.g:312:45: ( ASSIGN test )?
											int alt40=2;
											int LA40_0 = input.LA(1);
											if ( (LA40_0==ASSIGN) ) {
												alt40=1;
											}
											switch (alt40) {
												case 1 :
													// PythonPartial.g:312:46: ASSIGN test
													{
													match(input,ASSIGN,FOLLOW_ASSIGN_in_varargslist948); if (state.failed) return;
													pushFollow(FOLLOW_test_in_varargslist950);
													test();
													state._fsp--;
													if (state.failed) return;
													}
													break;

											}

											}
											break;

										default :
											break loop41;
										}
									}

									// PythonPartial.g:312:62: ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )?
									int alt44=2;
									int LA44_0 = input.LA(1);
									if ( (LA44_0==COMMA) ) {
										alt44=1;
									}
									switch (alt44) {
										case 1 :
											// PythonPartial.g:312:63: COMMA ( DOUBLESTAR vfpdef ( COMMA )? )?
											{
											match(input,COMMA,FOLLOW_COMMA_in_varargslist957); if (state.failed) return;
											// PythonPartial.g:312:69: ( DOUBLESTAR vfpdef ( COMMA )? )?
											int alt43=2;
											int LA43_0 = input.LA(1);
											if ( (LA43_0==DOUBLESTAR) ) {
												alt43=1;
											}
											switch (alt43) {
												case 1 :
													// PythonPartial.g:312:70: DOUBLESTAR vfpdef ( COMMA )?
													{
													match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist960); if (state.failed) return;
													pushFollow(FOLLOW_vfpdef_in_varargslist962);
													vfpdef();
													state._fsp--;
													if (state.failed) return;
													// PythonPartial.g:312:88: ( COMMA )?
													int alt42=2;
													int LA42_0 = input.LA(1);
													if ( (LA42_0==COMMA) ) {
														alt42=1;
													}
													switch (alt42) {
														case 1 :
															// PythonPartial.g:312:88: COMMA
															{
															match(input,COMMA,FOLLOW_COMMA_in_varargslist964); if (state.failed) return;
															}
															break;

													}

													}
													break;

											}

											}
											break;

									}

									}
									break;
								case 2 :
									// PythonPartial.g:313:18: DOUBLESTAR vfpdef ( COMMA )?
									{
									match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist988); if (state.failed) return;
									pushFollow(FOLLOW_vfpdef_in_varargslist990);
									vfpdef();
									state._fsp--;
									if (state.failed) return;
									// PythonPartial.g:313:36: ( COMMA )?
									int alt45=2;
									int LA45_0 = input.LA(1);
									if ( (LA45_0==COMMA) ) {
										alt45=1;
									}
									switch (alt45) {
										case 1 :
											// PythonPartial.g:313:36: COMMA
											{
											match(input,COMMA,FOLLOW_COMMA_in_varargslist992); if (state.failed) return;
											}
											break;

									}

									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:314:10: STAR ( vfpdef )? ( COMMA vfpdef ( ASSIGN test )? )* ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )?
					{
					match(input,STAR,FOLLOW_STAR_in_varargslist1008); if (state.failed) return;
					// PythonPartial.g:314:15: ( vfpdef )?
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==NAME) ) {
						alt48=1;
					}
					switch (alt48) {
						case 1 :
							// PythonPartial.g:314:15: vfpdef
							{
							pushFollow(FOLLOW_vfpdef_in_varargslist1010);
							vfpdef();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:314:23: ( COMMA vfpdef ( ASSIGN test )? )*
					loop50:
					while (true) {
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( (LA50_0==COMMA) ) {
							int LA50_1 = input.LA(2);
							if ( (LA50_1==NAME) ) {
								alt50=1;
							}

						}

						switch (alt50) {
						case 1 :
							// PythonPartial.g:314:24: COMMA vfpdef ( ASSIGN test )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_varargslist1014); if (state.failed) return;
							pushFollow(FOLLOW_vfpdef_in_varargslist1016);
							vfpdef();
							state._fsp--;
							if (state.failed) return;
							// PythonPartial.g:314:37: ( ASSIGN test )?
							int alt49=2;
							int LA49_0 = input.LA(1);
							if ( (LA49_0==ASSIGN) ) {
								alt49=1;
							}
							switch (alt49) {
								case 1 :
									// PythonPartial.g:314:38: ASSIGN test
									{
									match(input,ASSIGN,FOLLOW_ASSIGN_in_varargslist1019); if (state.failed) return;
									pushFollow(FOLLOW_test_in_varargslist1021);
									test();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

						default :
							break loop50;
						}
					}

					// PythonPartial.g:314:54: ( COMMA ( DOUBLESTAR vfpdef ( COMMA )? )? )?
					int alt53=2;
					int LA53_0 = input.LA(1);
					if ( (LA53_0==COMMA) ) {
						alt53=1;
					}
					switch (alt53) {
						case 1 :
							// PythonPartial.g:314:55: COMMA ( DOUBLESTAR vfpdef ( COMMA )? )?
							{
							match(input,COMMA,FOLLOW_COMMA_in_varargslist1028); if (state.failed) return;
							// PythonPartial.g:314:61: ( DOUBLESTAR vfpdef ( COMMA )? )?
							int alt52=2;
							int LA52_0 = input.LA(1);
							if ( (LA52_0==DOUBLESTAR) ) {
								alt52=1;
							}
							switch (alt52) {
								case 1 :
									// PythonPartial.g:314:62: DOUBLESTAR vfpdef ( COMMA )?
									{
									match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1031); if (state.failed) return;
									pushFollow(FOLLOW_vfpdef_in_varargslist1033);
									vfpdef();
									state._fsp--;
									if (state.failed) return;
									// PythonPartial.g:314:80: ( COMMA )?
									int alt51=2;
									int LA51_0 = input.LA(1);
									if ( (LA51_0==COMMA) ) {
										alt51=1;
									}
									switch (alt51) {
										case 1 :
											// PythonPartial.g:314:80: COMMA
											{
											match(input,COMMA,FOLLOW_COMMA_in_varargslist1035); if (state.failed) return;
											}
											break;

									}

									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 3 :
					// PythonPartial.g:315:10: DOUBLESTAR vfpdef ( COMMA )?
					{
					match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1051); if (state.failed) return;
					pushFollow(FOLLOW_vfpdef_in_varargslist1053);
					vfpdef();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:315:28: ( COMMA )?
					int alt54=2;
					int LA54_0 = input.LA(1);
					if ( (LA54_0==COMMA) ) {
						alt54=1;
					}
					switch (alt54) {
						case 1 :
							// PythonPartial.g:315:28: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_varargslist1055); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "varargslist"



	// $ANTLR start "vfpdef"
	// PythonPartial.g:319:1: vfpdef : NAME ;
	public final void vfpdef() throws RecognitionException {
		try {
			// PythonPartial.g:320:5: ( NAME )
			// PythonPartial.g:320:7: NAME
			{
			match(input,NAME,FOLLOW_NAME_in_vfpdef1075); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vfpdef"



	// $ANTLR start "stmt"
	// PythonPartial.g:323:1: stmt : ( simple_stmt | compound_stmt );
	public final void stmt() throws RecognitionException {
		try {
			// PythonPartial.g:324:5: ( simple_stmt | compound_stmt )
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==ASSERT||(LA56_0 >= AWAIT && LA56_0 <= BREAK)||(LA56_0 >= COMPLEX && LA56_0 <= CONTINUE)||LA56_0==DELETE||LA56_0==DOT||LA56_0==EXEC||LA56_0==FLOAT||(LA56_0 >= FROM && LA56_0 <= GLOBAL)||LA56_0==IMPORT||LA56_0==INT||(LA56_0 >= LAMBDA && LA56_0 <= LCURLY)||(LA56_0 >= LONGINT && LA56_0 <= MINUS)||LA56_0==NAME||LA56_0==NOT||LA56_0==PASS||LA56_0==PLUS||LA56_0==RAISE||LA56_0==RETURN||(LA56_0 >= STRING && LA56_0 <= TRAILBACKSLASH)||(LA56_0 >= YIELD && LA56_0 <= TRISTRINGPART)) ) {
				alt56=1;
			}
			else if ( ((LA56_0 >= ASYNC && LA56_0 <= AT)||LA56_0==CLASS||LA56_0==DEF||LA56_0==FOR||LA56_0==IF||LA56_0==TRY||(LA56_0 >= WHILE && LA56_0 <= WITH)) ) {
				alt56=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}

			switch (alt56) {
				case 1 :
					// PythonPartial.g:324:7: simple_stmt
					{
					pushFollow(FOLLOW_simple_stmt_in_stmt1089);
					simple_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:325:7: compound_stmt
					{
					pushFollow(FOLLOW_compound_stmt_in_stmt1097);
					compound_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stmt"



	// $ANTLR start "simple_stmt"
	// PythonPartial.g:329:1: simple_stmt : small_stmt ( options {greedy=true; } : SEMI small_stmt )* ( SEMI )? ( NEWLINE | EOF ) ;
	public final void simple_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:330:5: ( small_stmt ( options {greedy=true; } : SEMI small_stmt )* ( SEMI )? ( NEWLINE | EOF ) )
			// PythonPartial.g:330:7: small_stmt ( options {greedy=true; } : SEMI small_stmt )* ( SEMI )? ( NEWLINE | EOF )
			{
			pushFollow(FOLLOW_small_stmt_in_simple_stmt1115);
			small_stmt();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:330:18: ( options {greedy=true; } : SEMI small_stmt )*
			loop57:
			while (true) {
				int alt57=2;
				int LA57_0 = input.LA(1);
				if ( (LA57_0==SEMI) ) {
					int LA57_1 = input.LA(2);
					if ( (LA57_1==ASSERT||(LA57_1 >= AWAIT && LA57_1 <= BREAK)||(LA57_1 >= COMPLEX && LA57_1 <= CONTINUE)||LA57_1==DELETE||LA57_1==DOT||LA57_1==EXEC||LA57_1==FLOAT||(LA57_1 >= FROM && LA57_1 <= GLOBAL)||LA57_1==IMPORT||LA57_1==INT||(LA57_1 >= LAMBDA && LA57_1 <= LCURLY)||(LA57_1 >= LONGINT && LA57_1 <= MINUS)||LA57_1==NAME||LA57_1==NOT||LA57_1==PASS||LA57_1==PLUS||LA57_1==RAISE||LA57_1==RETURN||(LA57_1 >= STRING && LA57_1 <= TRAILBACKSLASH)||(LA57_1 >= YIELD && LA57_1 <= TRISTRINGPART)) ) {
						alt57=1;
					}

				}

				switch (alt57) {
				case 1 :
					// PythonPartial.g:330:42: SEMI small_stmt
					{
					match(input,SEMI,FOLLOW_SEMI_in_simple_stmt1125); if (state.failed) return;
					pushFollow(FOLLOW_small_stmt_in_simple_stmt1127);
					small_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop57;
				}
			}

			// PythonPartial.g:330:60: ( SEMI )?
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==SEMI) ) {
				alt58=1;
			}
			switch (alt58) {
				case 1 :
					// PythonPartial.g:330:61: SEMI
					{
					match(input,SEMI,FOLLOW_SEMI_in_simple_stmt1132); if (state.failed) return;
					}
					break;

			}

			if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "simple_stmt"



	// $ANTLR start "small_stmt"
	// PythonPartial.g:335:1: small_stmt : ( expr_stmt | print_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | exec_stmt | assert_stmt );
	public final void small_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:335:12: ( expr_stmt | print_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | exec_stmt | assert_stmt )
			int alt59=9;
			switch ( input.LA(1) ) {
			case AWAIT:
			case BACKQUOTE:
			case COMPLEX:
			case DOT:
			case FLOAT:
			case INT:
			case LAMBDA:
			case LBRACK:
			case LCURLY:
			case LONGINT:
			case LPAREN:
			case MINUS:
			case NAME:
			case NOT:
			case PLUS:
			case STRING:
			case TILDE:
			case TRAILBACKSLASH:
			case STRINGPART:
			case TRISTRINGPART:
				{
				alt59=1;
				}
				break;
			case PRINT:
				{
				alt59=2;
				}
				break;
			case DELETE:
				{
				alt59=3;
				}
				break;
			case PASS:
				{
				alt59=4;
				}
				break;
			case BREAK:
			case CONTINUE:
			case RAISE:
			case RETURN:
			case YIELD:
				{
				alt59=5;
				}
				break;
			case FROM:
			case IMPORT:
				{
				alt59=6;
				}
				break;
			case GLOBAL:
				{
				alt59=7;
				}
				break;
			case EXEC:
				{
				alt59=8;
				}
				break;
			case ASSERT:
				{
				alt59=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}
			switch (alt59) {
				case 1 :
					// PythonPartial.g:335:14: expr_stmt
					{
					pushFollow(FOLLOW_expr_stmt_in_small_stmt1155);
					expr_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:336:14: print_stmt
					{
					pushFollow(FOLLOW_print_stmt_in_small_stmt1170);
					print_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:337:14: del_stmt
					{
					pushFollow(FOLLOW_del_stmt_in_small_stmt1185);
					del_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// PythonPartial.g:338:14: pass_stmt
					{
					pushFollow(FOLLOW_pass_stmt_in_small_stmt1200);
					pass_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// PythonPartial.g:339:14: flow_stmt
					{
					pushFollow(FOLLOW_flow_stmt_in_small_stmt1215);
					flow_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 6 :
					// PythonPartial.g:340:14: import_stmt
					{
					pushFollow(FOLLOW_import_stmt_in_small_stmt1230);
					import_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 7 :
					// PythonPartial.g:341:14: global_stmt
					{
					pushFollow(FOLLOW_global_stmt_in_small_stmt1245);
					global_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 8 :
					// PythonPartial.g:342:14: exec_stmt
					{
					pushFollow(FOLLOW_exec_stmt_in_small_stmt1260);
					exec_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 9 :
					// PythonPartial.g:343:14: assert_stmt
					{
					pushFollow(FOLLOW_assert_stmt_in_small_stmt1275);
					assert_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "small_stmt"



	// $ANTLR start "star_expr"
	// PythonPartial.g:347:1: star_expr : STAR expr ;
	public final void star_expr() throws RecognitionException {
		try {
			// PythonPartial.g:347:11: ( STAR expr )
			// PythonPartial.g:347:13: STAR expr
			{
			match(input,STAR,FOLLOW_STAR_in_star_expr1296); if (state.failed) return;
			pushFollow(FOLLOW_expr_in_star_expr1298);
			expr();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "star_expr"



	// $ANTLR start "expr_stmt"
	// PythonPartial.g:352:1: expr_stmt : ( ( testlist augassign )=> testlist ( ( augassign yield_expr ) | ( augassign testlist ) ) | ( testlist ASSIGN )=> testlist (| ( ( ASSIGN testlist )+ ) | ( ( ASSIGN yield_expr )+ ) ) | testlist ) ;
	public final void expr_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:353:5: ( ( ( testlist augassign )=> testlist ( ( augassign yield_expr ) | ( augassign testlist ) ) | ( testlist ASSIGN )=> testlist (| ( ( ASSIGN testlist )+ ) | ( ( ASSIGN yield_expr )+ ) ) | testlist ) )
			// PythonPartial.g:353:7: ( ( testlist augassign )=> testlist ( ( augassign yield_expr ) | ( augassign testlist ) ) | ( testlist ASSIGN )=> testlist (| ( ( ASSIGN testlist )+ ) | ( ( ASSIGN yield_expr )+ ) ) | testlist )
			{
			// PythonPartial.g:353:7: ( ( testlist augassign )=> testlist ( ( augassign yield_expr ) | ( augassign testlist ) ) | ( testlist ASSIGN )=> testlist (| ( ( ASSIGN testlist )+ ) | ( ( ASSIGN yield_expr )+ ) ) | testlist )
			int alt64=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA64_1 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case PLUS:
				{
				int LA64_2 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case MINUS:
				{
				int LA64_3 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case TILDE:
				{
				int LA64_4 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case AWAIT:
				{
				int LA64_5 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case LPAREN:
				{
				int LA64_6 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case LBRACK:
				{
				int LA64_7 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case LCURLY:
				{
				int LA64_8 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case BACKQUOTE:
				{
				int LA64_9 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case NAME:
				{
				int LA64_10 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case INT:
				{
				int LA64_11 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case LONGINT:
				{
				int LA64_12 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case FLOAT:
				{
				int LA64_13 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case COMPLEX:
				{
				int LA64_14 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case DOT:
				{
				int LA64_15 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case STRING:
				{
				int LA64_16 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case TRISTRINGPART:
				{
				int LA64_17 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case STRINGPART:
				{
				int LA64_18 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case TRAILBACKSLASH:
				{
				int LA64_19 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case LAMBDA:
				{
				int LA64_20 = input.LA(2);
				if ( (synpred1_PythonPartial()) ) {
					alt64=1;
				}
				else if ( (synpred2_PythonPartial()) ) {
					alt64=2;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}
			switch (alt64) {
				case 1 :
					// PythonPartial.g:353:8: ( testlist augassign )=> testlist ( ( augassign yield_expr ) | ( augassign testlist ) )
					{
					pushFollow(FOLLOW_testlist_in_expr_stmt1323);
					testlist();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:354:9: ( ( augassign yield_expr ) | ( augassign testlist ) )
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==AMPEREQUAL||LA60_0==CIRCUMFLEXEQUAL||LA60_0==DOUBLESLASHEQUAL||LA60_0==DOUBLESTAREQUAL||LA60_0==LEFTSHIFTEQUAL||LA60_0==MINUSEQUAL||LA60_0==PERCENTEQUAL||LA60_0==PLUSEQUAL||LA60_0==RIGHTSHIFTEQUAL||LA60_0==SLASHEQUAL||LA60_0==STAREQUAL||LA60_0==VBAREQUAL) ) {
						int LA60_1 = input.LA(2);
						if ( (LA60_1==YIELD) ) {
							alt60=1;
						}
						else if ( ((LA60_1 >= AWAIT && LA60_1 <= BACKQUOTE)||LA60_1==COMPLEX||LA60_1==DOT||LA60_1==FLOAT||LA60_1==INT||(LA60_1 >= LAMBDA && LA60_1 <= LCURLY)||(LA60_1 >= LONGINT && LA60_1 <= MINUS)||LA60_1==NAME||LA60_1==NOT||LA60_1==PLUS||(LA60_1 >= STRING && LA60_1 <= TRAILBACKSLASH)||(LA60_1 >= STRINGPART && LA60_1 <= TRISTRINGPART)) ) {
							alt60=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 60, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 60, 0, input);
						throw nvae;
					}

					switch (alt60) {
						case 1 :
							// PythonPartial.g:354:11: ( augassign yield_expr )
							{
							// PythonPartial.g:354:11: ( augassign yield_expr )
							// PythonPartial.g:354:12: augassign yield_expr
							{
							pushFollow(FOLLOW_augassign_in_expr_stmt1336);
							augassign();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_yield_expr_in_expr_stmt1338);
							yield_expr();
							state._fsp--;
							if (state.failed) return;
							}

							}
							break;
						case 2 :
							// PythonPartial.g:356:11: ( augassign testlist )
							{
							// PythonPartial.g:356:11: ( augassign testlist )
							// PythonPartial.g:356:12: augassign testlist
							{
							pushFollow(FOLLOW_augassign_in_expr_stmt1363);
							augassign();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_testlist_in_expr_stmt1365);
							testlist();
							state._fsp--;
							if (state.failed) return;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:359:7: ( testlist ASSIGN )=> testlist (| ( ( ASSIGN testlist )+ ) | ( ( ASSIGN yield_expr )+ ) )
					{
					pushFollow(FOLLOW_testlist_in_expr_stmt1403);
					testlist();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:360:9: (| ( ( ASSIGN testlist )+ ) | ( ( ASSIGN yield_expr )+ ) )
					int alt63=3;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==EOF||LA63_0==NEWLINE||LA63_0==SEMI) ) {
						alt63=1;
					}
					else if ( (LA63_0==ASSIGN) ) {
						int LA63_2 = input.LA(2);
						if ( ((LA63_2 >= AWAIT && LA63_2 <= BACKQUOTE)||LA63_2==COMPLEX||LA63_2==DOT||LA63_2==FLOAT||LA63_2==INT||(LA63_2 >= LAMBDA && LA63_2 <= LCURLY)||(LA63_2 >= LONGINT && LA63_2 <= MINUS)||LA63_2==NAME||LA63_2==NOT||LA63_2==PLUS||(LA63_2 >= STRING && LA63_2 <= TRAILBACKSLASH)||(LA63_2 >= STRINGPART && LA63_2 <= TRISTRINGPART)) ) {
							alt63=2;
						}
						else if ( (LA63_2==YIELD) ) {
							alt63=3;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 63, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 63, 0, input);
						throw nvae;
					}

					switch (alt63) {
						case 1 :
							// PythonPartial.g:361:9: 
							{
							}
							break;
						case 2 :
							// PythonPartial.g:361:11: ( ( ASSIGN testlist )+ )
							{
							// PythonPartial.g:361:11: ( ( ASSIGN testlist )+ )
							// PythonPartial.g:361:12: ( ASSIGN testlist )+
							{
							// PythonPartial.g:361:12: ( ASSIGN testlist )+
							int cnt61=0;
							loop61:
							while (true) {
								int alt61=2;
								int LA61_0 = input.LA(1);
								if ( (LA61_0==ASSIGN) ) {
									alt61=1;
								}

								switch (alt61) {
								case 1 :
									// PythonPartial.g:361:13: ASSIGN testlist
									{
									match(input,ASSIGN,FOLLOW_ASSIGN_in_expr_stmt1427); if (state.failed) return;
									pushFollow(FOLLOW_testlist_in_expr_stmt1429);
									testlist();
									state._fsp--;
									if (state.failed) return;
									}
									break;

								default :
									if ( cnt61 >= 1 ) break loop61;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(61, input);
									throw eee;
								}
								cnt61++;
							}

							}

							}
							break;
						case 3 :
							// PythonPartial.g:363:11: ( ( ASSIGN yield_expr )+ )
							{
							// PythonPartial.g:363:11: ( ( ASSIGN yield_expr )+ )
							// PythonPartial.g:363:12: ( ASSIGN yield_expr )+
							{
							// PythonPartial.g:363:12: ( ASSIGN yield_expr )+
							int cnt62=0;
							loop62:
							while (true) {
								int alt62=2;
								int LA62_0 = input.LA(1);
								if ( (LA62_0==ASSIGN) ) {
									alt62=1;
								}

								switch (alt62) {
								case 1 :
									// PythonPartial.g:363:13: ASSIGN yield_expr
									{
									match(input,ASSIGN,FOLLOW_ASSIGN_in_expr_stmt1457); if (state.failed) return;
									pushFollow(FOLLOW_yield_expr_in_expr_stmt1459);
									yield_expr();
									state._fsp--;
									if (state.failed) return;
									}
									break;

								default :
									if ( cnt62 >= 1 ) break loop62;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(62, input);
									throw eee;
								}
								cnt62++;
							}

							}

							}
							break;

					}

					}
					break;
				case 3 :
					// PythonPartial.g:366:7: testlist
					{
					pushFollow(FOLLOW_testlist_in_expr_stmt1491);
					testlist();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr_stmt"



	// $ANTLR start "augassign"
	// PythonPartial.g:372:1: augassign : ( PLUSEQUAL | MINUSEQUAL | STAREQUAL | SLASHEQUAL | PERCENTEQUAL | AMPEREQUAL | VBAREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL );
	public final void augassign() throws RecognitionException {
		try {
			// PythonPartial.g:373:5: ( PLUSEQUAL | MINUSEQUAL | STAREQUAL | SLASHEQUAL | PERCENTEQUAL | AMPEREQUAL | VBAREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL )
			// PythonPartial.g:
			{
			if ( input.LA(1)==AMPEREQUAL||input.LA(1)==CIRCUMFLEXEQUAL||input.LA(1)==DOUBLESLASHEQUAL||input.LA(1)==DOUBLESTAREQUAL||input.LA(1)==LEFTSHIFTEQUAL||input.LA(1)==MINUSEQUAL||input.LA(1)==PERCENTEQUAL||input.LA(1)==PLUSEQUAL||input.LA(1)==RIGHTSHIFTEQUAL||input.LA(1)==SLASHEQUAL||input.LA(1)==STAREQUAL||input.LA(1)==VBAREQUAL ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "augassign"



	// $ANTLR start "print_stmt"
	// PythonPartial.g:389:1: print_stmt : PRINT ( printlist | RIGHTSHIFT printlist |) ;
	public final void print_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:390:5: ( PRINT ( printlist | RIGHTSHIFT printlist |) )
			// PythonPartial.g:390:7: PRINT ( printlist | RIGHTSHIFT printlist |)
			{
			match(input,PRINT,FOLLOW_PRINT_in_print_stmt1623); if (state.failed) return;
			// PythonPartial.g:391:7: ( printlist | RIGHTSHIFT printlist |)
			int alt65=3;
			switch ( input.LA(1) ) {
			case AWAIT:
			case BACKQUOTE:
			case COMPLEX:
			case DOT:
			case FLOAT:
			case INT:
			case LAMBDA:
			case LBRACK:
			case LCURLY:
			case LONGINT:
			case LPAREN:
			case MINUS:
			case NAME:
			case NOT:
			case PLUS:
			case STRING:
			case TILDE:
			case TRAILBACKSLASH:
			case STRINGPART:
			case TRISTRINGPART:
				{
				alt65=1;
				}
				break;
			case RIGHTSHIFT:
				{
				alt65=2;
				}
				break;
			case EOF:
			case NEWLINE:
			case SEMI:
				{
				alt65=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}
			switch (alt65) {
				case 1 :
					// PythonPartial.g:391:8: printlist
					{
					pushFollow(FOLLOW_printlist_in_print_stmt1632);
					printlist();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:392:9: RIGHTSHIFT printlist
					{
					match(input,RIGHTSHIFT,FOLLOW_RIGHTSHIFT_in_print_stmt1642); if (state.failed) return;
					pushFollow(FOLLOW_printlist_in_print_stmt1644);
					printlist();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:394:7: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "print_stmt"



	// $ANTLR start "printlist"
	// PythonPartial.g:398:1: printlist : ( ( test COMMA )=> test ( options {k=2; } : COMMA test )* ( COMMA )? | test );
	public final void printlist() throws RecognitionException {
		try {
			// PythonPartial.g:399:5: ( ( test COMMA )=> test ( options {k=2; } : COMMA test )* ( COMMA )? | test )
			int alt68=2;
			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA68_1 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case PLUS:
				{
				int LA68_2 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case MINUS:
				{
				int LA68_3 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case TILDE:
				{
				int LA68_4 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case AWAIT:
				{
				int LA68_5 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA68_6 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case LBRACK:
				{
				int LA68_7 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case LCURLY:
				{
				int LA68_8 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case BACKQUOTE:
				{
				int LA68_9 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case NAME:
				{
				int LA68_10 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case INT:
				{
				int LA68_11 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case LONGINT:
				{
				int LA68_12 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA68_13 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case COMPLEX:
				{
				int LA68_14 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case DOT:
				{
				int LA68_15 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case STRING:
				{
				int LA68_16 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case TRISTRINGPART:
				{
				int LA68_17 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case STRINGPART:
				{
				int LA68_18 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case TRAILBACKSLASH:
				{
				int LA68_19 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			case LAMBDA:
				{
				int LA68_20 = input.LA(2);
				if ( (synpred3_PythonPartial()) ) {
					alt68=1;
				}
				else if ( (true) ) {
					alt68=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}
			switch (alt68) {
				case 1 :
					// PythonPartial.g:399:7: ( test COMMA )=> test ( options {k=2; } : COMMA test )* ( COMMA )?
					{
					pushFollow(FOLLOW_test_in_printlist1695);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:400:13: ( options {k=2; } : COMMA test )*
					loop66:
					while (true) {
						int alt66=2;
						int LA66_0 = input.LA(1);
						if ( (LA66_0==COMMA) ) {
							int LA66_1 = input.LA(2);
							if ( ((LA66_1 >= AWAIT && LA66_1 <= BACKQUOTE)||LA66_1==COMPLEX||LA66_1==DOT||LA66_1==FLOAT||LA66_1==INT||(LA66_1 >= LAMBDA && LA66_1 <= LCURLY)||(LA66_1 >= LONGINT && LA66_1 <= MINUS)||LA66_1==NAME||LA66_1==NOT||LA66_1==PLUS||(LA66_1 >= STRING && LA66_1 <= TRAILBACKSLASH)||(LA66_1 >= STRINGPART && LA66_1 <= TRISTRINGPART)) ) {
								alt66=1;
							}

						}

						switch (alt66) {
						case 1 :
							// PythonPartial.g:400:30: COMMA test
							{
							match(input,COMMA,FOLLOW_COMMA_in_printlist1706); if (state.failed) return;
							pushFollow(FOLLOW_test_in_printlist1708);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop66;
						}
					}

					// PythonPartial.g:401:10: ( COMMA )?
					int alt67=2;
					int LA67_0 = input.LA(1);
					if ( (LA67_0==COMMA) ) {
						alt67=1;
					}
					switch (alt67) {
						case 1 :
							// PythonPartial.g:401:11: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_printlist1722); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:402:7: test
					{
					pushFollow(FOLLOW_test_in_printlist1732);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "printlist"



	// $ANTLR start "del_stmt"
	// PythonPartial.g:406:1: del_stmt : DELETE exprlist ;
	public final void del_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:407:5: ( DELETE exprlist )
			// PythonPartial.g:407:7: DELETE exprlist
			{
			match(input,DELETE,FOLLOW_DELETE_in_del_stmt1750); if (state.failed) return;
			pushFollow(FOLLOW_exprlist_in_del_stmt1752);
			exprlist();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "del_stmt"



	// $ANTLR start "pass_stmt"
	// PythonPartial.g:411:1: pass_stmt : PASS ;
	public final void pass_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:412:5: ( PASS )
			// PythonPartial.g:412:7: PASS
			{
			match(input,PASS,FOLLOW_PASS_in_pass_stmt1770); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pass_stmt"



	// $ANTLR start "flow_stmt"
	// PythonPartial.g:416:1: flow_stmt : ( break_stmt | continue_stmt | return_stmt | raise_stmt | yield_stmt );
	public final void flow_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:417:5: ( break_stmt | continue_stmt | return_stmt | raise_stmt | yield_stmt )
			int alt69=5;
			switch ( input.LA(1) ) {
			case BREAK:
				{
				alt69=1;
				}
				break;
			case CONTINUE:
				{
				alt69=2;
				}
				break;
			case RETURN:
				{
				alt69=3;
				}
				break;
			case RAISE:
				{
				alt69=4;
				}
				break;
			case YIELD:
				{
				alt69=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}
			switch (alt69) {
				case 1 :
					// PythonPartial.g:417:7: break_stmt
					{
					pushFollow(FOLLOW_break_stmt_in_flow_stmt1788);
					break_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:418:7: continue_stmt
					{
					pushFollow(FOLLOW_continue_stmt_in_flow_stmt1796);
					continue_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:419:7: return_stmt
					{
					pushFollow(FOLLOW_return_stmt_in_flow_stmt1804);
					return_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// PythonPartial.g:420:7: raise_stmt
					{
					pushFollow(FOLLOW_raise_stmt_in_flow_stmt1812);
					raise_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// PythonPartial.g:421:7: yield_stmt
					{
					pushFollow(FOLLOW_yield_stmt_in_flow_stmt1820);
					yield_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "flow_stmt"



	// $ANTLR start "break_stmt"
	// PythonPartial.g:425:1: break_stmt : BREAK ;
	public final void break_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:426:5: ( BREAK )
			// PythonPartial.g:426:7: BREAK
			{
			match(input,BREAK,FOLLOW_BREAK_in_break_stmt1838); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "break_stmt"



	// $ANTLR start "continue_stmt"
	// PythonPartial.g:430:1: continue_stmt : CONTINUE ;
	public final void continue_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:431:5: ( CONTINUE )
			// PythonPartial.g:431:7: CONTINUE
			{
			match(input,CONTINUE,FOLLOW_CONTINUE_in_continue_stmt1856); if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "continue_stmt"



	// $ANTLR start "return_stmt"
	// PythonPartial.g:435:1: return_stmt : RETURN ( testlist |) ;
	public final void return_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:436:5: ( RETURN ( testlist |) )
			// PythonPartial.g:436:7: RETURN ( testlist |)
			{
			match(input,RETURN,FOLLOW_RETURN_in_return_stmt1874); if (state.failed) return;
			// PythonPartial.g:437:7: ( testlist |)
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( ((LA70_0 >= AWAIT && LA70_0 <= BACKQUOTE)||LA70_0==COMPLEX||LA70_0==DOT||LA70_0==FLOAT||LA70_0==INT||(LA70_0 >= LAMBDA && LA70_0 <= LCURLY)||(LA70_0 >= LONGINT && LA70_0 <= MINUS)||LA70_0==NAME||LA70_0==NOT||LA70_0==PLUS||(LA70_0 >= STRING && LA70_0 <= TRAILBACKSLASH)||(LA70_0 >= STRINGPART && LA70_0 <= TRISTRINGPART)) ) {
				alt70=1;
			}
			else if ( (LA70_0==EOF||LA70_0==NEWLINE||LA70_0==SEMI) ) {
				alt70=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 70, 0, input);
				throw nvae;
			}

			switch (alt70) {
				case 1 :
					// PythonPartial.g:437:8: testlist
					{
					pushFollow(FOLLOW_testlist_in_return_stmt1883);
					testlist();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:439:7: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "return_stmt"



	// $ANTLR start "yield_stmt"
	// PythonPartial.g:443:1: yield_stmt : yield_expr ;
	public final void yield_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:444:5: ( yield_expr )
			// PythonPartial.g:444:7: yield_expr
			{
			pushFollow(FOLLOW_yield_expr_in_yield_stmt1917);
			yield_expr();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "yield_stmt"



	// $ANTLR start "raise_stmt"
	// PythonPartial.g:448:1: raise_stmt : RAISE ( test ( FROM test )? )? ;
	public final void raise_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:449:5: ( RAISE ( test ( FROM test )? )? )
			// PythonPartial.g:449:7: RAISE ( test ( FROM test )? )?
			{
			match(input,RAISE,FOLLOW_RAISE_in_raise_stmt1935); if (state.failed) return;
			// PythonPartial.g:449:13: ( test ( FROM test )? )?
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( ((LA72_0 >= AWAIT && LA72_0 <= BACKQUOTE)||LA72_0==COMPLEX||LA72_0==DOT||LA72_0==FLOAT||LA72_0==INT||(LA72_0 >= LAMBDA && LA72_0 <= LCURLY)||(LA72_0 >= LONGINT && LA72_0 <= MINUS)||LA72_0==NAME||LA72_0==NOT||LA72_0==PLUS||(LA72_0 >= STRING && LA72_0 <= TRAILBACKSLASH)||(LA72_0 >= STRINGPART && LA72_0 <= TRISTRINGPART)) ) {
				alt72=1;
			}
			switch (alt72) {
				case 1 :
					// PythonPartial.g:449:14: test ( FROM test )?
					{
					pushFollow(FOLLOW_test_in_raise_stmt1938);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:449:19: ( FROM test )?
					int alt71=2;
					int LA71_0 = input.LA(1);
					if ( (LA71_0==FROM) ) {
						alt71=1;
					}
					switch (alt71) {
						case 1 :
							// PythonPartial.g:449:20: FROM test
							{
							match(input,FROM,FOLLOW_FROM_in_raise_stmt1941); if (state.failed) return;
							pushFollow(FOLLOW_test_in_raise_stmt1943);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "raise_stmt"



	// $ANTLR start "import_stmt"
	// PythonPartial.g:453:1: import_stmt : ( import_name | import_from );
	public final void import_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:454:5: ( import_name | import_from )
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==IMPORT) ) {
				alt73=1;
			}
			else if ( (LA73_0==FROM) ) {
				alt73=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}

			switch (alt73) {
				case 1 :
					// PythonPartial.g:454:7: import_name
					{
					pushFollow(FOLLOW_import_name_in_import_stmt1965);
					import_name();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:455:7: import_from
					{
					pushFollow(FOLLOW_import_from_in_import_stmt1973);
					import_from();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "import_stmt"



	// $ANTLR start "import_name"
	// PythonPartial.g:459:1: import_name : IMPORT dotted_as_names ;
	public final void import_name() throws RecognitionException {
		try {
			// PythonPartial.g:460:5: ( IMPORT dotted_as_names )
			// PythonPartial.g:460:7: IMPORT dotted_as_names
			{
			match(input,IMPORT,FOLLOW_IMPORT_in_import_name1991); if (state.failed) return;
			pushFollow(FOLLOW_dotted_as_names_in_import_name1993);
			dotted_as_names();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "import_name"



	// $ANTLR start "import_from"
	// PythonPartial.g:465:1: import_from : FROM ( ( DOT )* dotted_name | ( DOT )+ ) IMPORT ( STAR | import_as_names | LPAREN import_as_names ( COMMA )? RPAREN ) ;
	public final void import_from() throws RecognitionException {
		try {
			// PythonPartial.g:466:5: ( FROM ( ( DOT )* dotted_name | ( DOT )+ ) IMPORT ( STAR | import_as_names | LPAREN import_as_names ( COMMA )? RPAREN ) )
			// PythonPartial.g:466:7: FROM ( ( DOT )* dotted_name | ( DOT )+ ) IMPORT ( STAR | import_as_names | LPAREN import_as_names ( COMMA )? RPAREN )
			{
			match(input,FROM,FOLLOW_FROM_in_import_from2012); if (state.failed) return;
			// PythonPartial.g:466:12: ( ( DOT )* dotted_name | ( DOT )+ )
			int alt76=2;
			alt76 = dfa76.predict(input);
			switch (alt76) {
				case 1 :
					// PythonPartial.g:466:13: ( DOT )* dotted_name
					{
					// PythonPartial.g:466:13: ( DOT )*
					loop74:
					while (true) {
						int alt74=2;
						int LA74_0 = input.LA(1);
						if ( (LA74_0==DOT) ) {
							alt74=1;
						}

						switch (alt74) {
						case 1 :
							// PythonPartial.g:466:13: DOT
							{
							match(input,DOT,FOLLOW_DOT_in_import_from2015); if (state.failed) return;
							}
							break;

						default :
							break loop74;
						}
					}

					pushFollow(FOLLOW_dotted_name_in_import_from2018);
					dotted_name();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:466:32: ( DOT )+
					{
					// PythonPartial.g:466:32: ( DOT )+
					int cnt75=0;
					loop75:
					while (true) {
						int alt75=2;
						int LA75_0 = input.LA(1);
						if ( (LA75_0==DOT) ) {
							alt75=1;
						}

						switch (alt75) {
						case 1 :
							// PythonPartial.g:466:32: DOT
							{
							match(input,DOT,FOLLOW_DOT_in_import_from2022); if (state.failed) return;
							}
							break;

						default :
							if ( cnt75 >= 1 ) break loop75;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(75, input);
							throw eee;
						}
						cnt75++;
					}

					}
					break;

			}

			match(input,IMPORT,FOLLOW_IMPORT_in_import_from2026); if (state.failed) return;
			// PythonPartial.g:467:9: ( STAR | import_as_names | LPAREN import_as_names ( COMMA )? RPAREN )
			int alt78=3;
			switch ( input.LA(1) ) {
			case STAR:
				{
				alt78=1;
				}
				break;
			case NAME:
				{
				alt78=2;
				}
				break;
			case LPAREN:
				{
				alt78=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}
			switch (alt78) {
				case 1 :
					// PythonPartial.g:467:10: STAR
					{
					match(input,STAR,FOLLOW_STAR_in_import_from2037); if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:468:11: import_as_names
					{
					pushFollow(FOLLOW_import_as_names_in_import_from2049);
					import_as_names();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:469:11: LPAREN import_as_names ( COMMA )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_import_from2061); if (state.failed) return;
					pushFollow(FOLLOW_import_as_names_in_import_from2063);
					import_as_names();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:469:34: ( COMMA )?
					int alt77=2;
					int LA77_0 = input.LA(1);
					if ( (LA77_0==COMMA) ) {
						alt77=1;
					}
					switch (alt77) {
						case 1 :
							// PythonPartial.g:469:34: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_import_from2065); if (state.failed) return;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_import_from2068); if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "import_from"



	// $ANTLR start "import_as_names"
	// PythonPartial.g:474:1: import_as_names : import_as_name ( COMMA import_as_name )* ;
	public final void import_as_names() throws RecognitionException {
		try {
			// PythonPartial.g:475:5: ( import_as_name ( COMMA import_as_name )* )
			// PythonPartial.g:475:7: import_as_name ( COMMA import_as_name )*
			{
			pushFollow(FOLLOW_import_as_name_in_import_as_names2096);
			import_as_name();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:475:22: ( COMMA import_as_name )*
			loop79:
			while (true) {
				int alt79=2;
				int LA79_0 = input.LA(1);
				if ( (LA79_0==COMMA) ) {
					int LA79_2 = input.LA(2);
					if ( (LA79_2==NAME) ) {
						alt79=1;
					}

				}

				switch (alt79) {
				case 1 :
					// PythonPartial.g:475:23: COMMA import_as_name
					{
					match(input,COMMA,FOLLOW_COMMA_in_import_as_names2099); if (state.failed) return;
					pushFollow(FOLLOW_import_as_name_in_import_as_names2101);
					import_as_name();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop79;
				}
			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "import_as_names"



	// $ANTLR start "import_as_name"
	// PythonPartial.g:479:1: import_as_name : NAME ( AS NAME )? ;
	public final void import_as_name() throws RecognitionException {
		try {
			// PythonPartial.g:480:5: ( NAME ( AS NAME )? )
			// PythonPartial.g:480:7: NAME ( AS NAME )?
			{
			match(input,NAME,FOLLOW_NAME_in_import_as_name2121); if (state.failed) return;
			// PythonPartial.g:480:12: ( AS NAME )?
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==AS) ) {
				alt80=1;
			}
			switch (alt80) {
				case 1 :
					// PythonPartial.g:480:13: AS NAME
					{
					match(input,AS,FOLLOW_AS_in_import_as_name2124); if (state.failed) return;
					match(input,NAME,FOLLOW_NAME_in_import_as_name2126); if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "import_as_name"



	// $ANTLR start "dotted_as_name"
	// PythonPartial.g:485:1: dotted_as_name : dotted_name ( AS NAME )? ;
	public final void dotted_as_name() throws RecognitionException {
		try {
			// PythonPartial.g:486:5: ( dotted_name ( AS NAME )? )
			// PythonPartial.g:486:7: dotted_name ( AS NAME )?
			{
			pushFollow(FOLLOW_dotted_name_in_dotted_as_name2147);
			dotted_name();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:486:19: ( AS NAME )?
			int alt81=2;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==AS) ) {
				alt81=1;
			}
			switch (alt81) {
				case 1 :
					// PythonPartial.g:486:20: AS NAME
					{
					match(input,AS,FOLLOW_AS_in_dotted_as_name2150); if (state.failed) return;
					match(input,NAME,FOLLOW_NAME_in_dotted_as_name2152); if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dotted_as_name"



	// $ANTLR start "dotted_as_names"
	// PythonPartial.g:490:1: dotted_as_names : dotted_as_name ( COMMA dotted_as_name )* ;
	public final void dotted_as_names() throws RecognitionException {
		try {
			// PythonPartial.g:491:5: ( dotted_as_name ( COMMA dotted_as_name )* )
			// PythonPartial.g:491:7: dotted_as_name ( COMMA dotted_as_name )*
			{
			pushFollow(FOLLOW_dotted_as_name_in_dotted_as_names2172);
			dotted_as_name();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:491:22: ( COMMA dotted_as_name )*
			loop82:
			while (true) {
				int alt82=2;
				int LA82_0 = input.LA(1);
				if ( (LA82_0==COMMA) ) {
					alt82=1;
				}

				switch (alt82) {
				case 1 :
					// PythonPartial.g:491:23: COMMA dotted_as_name
					{
					match(input,COMMA,FOLLOW_COMMA_in_dotted_as_names2175); if (state.failed) return;
					pushFollow(FOLLOW_dotted_as_name_in_dotted_as_names2177);
					dotted_as_name();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop82;
				}
			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dotted_as_names"



	// $ANTLR start "dotted_name"
	// PythonPartial.g:495:1: dotted_name : NAME ( DOT attr )* ;
	public final void dotted_name() throws RecognitionException {
		try {
			// PythonPartial.g:496:5: ( NAME ( DOT attr )* )
			// PythonPartial.g:496:7: NAME ( DOT attr )*
			{
			match(input,NAME,FOLLOW_NAME_in_dotted_name2197); if (state.failed) return;
			// PythonPartial.g:496:12: ( DOT attr )*
			loop83:
			while (true) {
				int alt83=2;
				int LA83_0 = input.LA(1);
				if ( (LA83_0==DOT) ) {
					alt83=1;
				}

				switch (alt83) {
				case 1 :
					// PythonPartial.g:496:13: DOT attr
					{
					match(input,DOT,FOLLOW_DOT_in_dotted_name2200); if (state.failed) return;
					pushFollow(FOLLOW_attr_in_dotted_name2202);
					attr();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop83;
				}
			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dotted_name"



	// $ANTLR start "global_stmt"
	// PythonPartial.g:500:1: global_stmt : GLOBAL NAME ( COMMA NAME )* ;
	public final void global_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:501:5: ( GLOBAL NAME ( COMMA NAME )* )
			// PythonPartial.g:501:7: GLOBAL NAME ( COMMA NAME )*
			{
			match(input,GLOBAL,FOLLOW_GLOBAL_in_global_stmt2222); if (state.failed) return;
			match(input,NAME,FOLLOW_NAME_in_global_stmt2224); if (state.failed) return;
			// PythonPartial.g:501:19: ( COMMA NAME )*
			loop84:
			while (true) {
				int alt84=2;
				int LA84_0 = input.LA(1);
				if ( (LA84_0==COMMA) ) {
					alt84=1;
				}

				switch (alt84) {
				case 1 :
					// PythonPartial.g:501:20: COMMA NAME
					{
					match(input,COMMA,FOLLOW_COMMA_in_global_stmt2227); if (state.failed) return;
					match(input,NAME,FOLLOW_NAME_in_global_stmt2229); if (state.failed) return;
					}
					break;

				default :
					break loop84;
				}
			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "global_stmt"



	// $ANTLR start "exec_stmt"
	// PythonPartial.g:505:1: exec_stmt : EXEC expr ( IN test ( COMMA test )? )? ;
	public final void exec_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:506:5: ( EXEC expr ( IN test ( COMMA test )? )? )
			// PythonPartial.g:506:7: EXEC expr ( IN test ( COMMA test )? )?
			{
			match(input,EXEC,FOLLOW_EXEC_in_exec_stmt2249); if (state.failed) return;
			pushFollow(FOLLOW_expr_in_exec_stmt2251);
			expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:506:17: ( IN test ( COMMA test )? )?
			int alt86=2;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==IN) ) {
				alt86=1;
			}
			switch (alt86) {
				case 1 :
					// PythonPartial.g:506:18: IN test ( COMMA test )?
					{
					match(input,IN,FOLLOW_IN_in_exec_stmt2254); if (state.failed) return;
					pushFollow(FOLLOW_test_in_exec_stmt2256);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:506:26: ( COMMA test )?
					int alt85=2;
					int LA85_0 = input.LA(1);
					if ( (LA85_0==COMMA) ) {
						alt85=1;
					}
					switch (alt85) {
						case 1 :
							// PythonPartial.g:506:27: COMMA test
							{
							match(input,COMMA,FOLLOW_COMMA_in_exec_stmt2259); if (state.failed) return;
							pushFollow(FOLLOW_test_in_exec_stmt2261);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exec_stmt"



	// $ANTLR start "assert_stmt"
	// PythonPartial.g:510:1: assert_stmt : ASSERT test ( COMMA test )? ;
	public final void assert_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:511:5: ( ASSERT test ( COMMA test )? )
			// PythonPartial.g:511:7: ASSERT test ( COMMA test )?
			{
			match(input,ASSERT,FOLLOW_ASSERT_in_assert_stmt2283); if (state.failed) return;
			pushFollow(FOLLOW_test_in_assert_stmt2285);
			test();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:511:19: ( COMMA test )?
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==COMMA) ) {
				alt87=1;
			}
			switch (alt87) {
				case 1 :
					// PythonPartial.g:511:20: COMMA test
					{
					match(input,COMMA,FOLLOW_COMMA_in_assert_stmt2288); if (state.failed) return;
					pushFollow(FOLLOW_test_in_assert_stmt2290);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assert_stmt"



	// $ANTLR start "compound_stmt"
	// PythonPartial.g:515:1: compound_stmt : ( if_stmt | while_stmt | for_stmt | try_stmt | with_stmt | funcdef | classdef | decorated | async_stmt );
	public final void compound_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:516:5: ( if_stmt | while_stmt | for_stmt | try_stmt | with_stmt | funcdef | classdef | decorated | async_stmt )
			int alt88=9;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt88=1;
				}
				break;
			case WHILE:
				{
				alt88=2;
				}
				break;
			case FOR:
				{
				alt88=3;
				}
				break;
			case TRY:
				{
				alt88=4;
				}
				break;
			case WITH:
				{
				alt88=5;
				}
				break;
			case DEF:
				{
				alt88=6;
				}
				break;
			case CLASS:
				{
				alt88=7;
				}
				break;
			case AT:
				{
				alt88=8;
				}
				break;
			case ASYNC:
				{
				alt88=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 88, 0, input);
				throw nvae;
			}
			switch (alt88) {
				case 1 :
					// PythonPartial.g:516:7: if_stmt
					{
					pushFollow(FOLLOW_if_stmt_in_compound_stmt2310);
					if_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:517:7: while_stmt
					{
					pushFollow(FOLLOW_while_stmt_in_compound_stmt2318);
					while_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:518:7: for_stmt
					{
					pushFollow(FOLLOW_for_stmt_in_compound_stmt2326);
					for_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// PythonPartial.g:519:7: try_stmt
					{
					pushFollow(FOLLOW_try_stmt_in_compound_stmt2334);
					try_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// PythonPartial.g:520:7: with_stmt
					{
					pushFollow(FOLLOW_with_stmt_in_compound_stmt2342);
					with_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 6 :
					// PythonPartial.g:521:7: funcdef
					{
					pushFollow(FOLLOW_funcdef_in_compound_stmt2350);
					funcdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 7 :
					// PythonPartial.g:522:7: classdef
					{
					pushFollow(FOLLOW_classdef_in_compound_stmt2358);
					classdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 8 :
					// PythonPartial.g:523:7: decorated
					{
					pushFollow(FOLLOW_decorated_in_compound_stmt2366);
					decorated();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 9 :
					// PythonPartial.g:524:7: async_stmt
					{
					pushFollow(FOLLOW_async_stmt_in_compound_stmt2374);
					async_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "compound_stmt"



	// $ANTLR start "async_stmt"
	// PythonPartial.g:528:1: async_stmt : ASYNC ( funcdef | with_stmt | for_stmt ) ;
	public final void async_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:529:5: ( ASYNC ( funcdef | with_stmt | for_stmt ) )
			// PythonPartial.g:529:7: ASYNC ( funcdef | with_stmt | for_stmt )
			{
			match(input,ASYNC,FOLLOW_ASYNC_in_async_stmt2392); if (state.failed) return;
			// PythonPartial.g:529:13: ( funcdef | with_stmt | for_stmt )
			int alt89=3;
			switch ( input.LA(1) ) {
			case DEF:
				{
				alt89=1;
				}
				break;
			case WITH:
				{
				alt89=2;
				}
				break;
			case FOR:
				{
				alt89=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 89, 0, input);
				throw nvae;
			}
			switch (alt89) {
				case 1 :
					// PythonPartial.g:529:14: funcdef
					{
					pushFollow(FOLLOW_funcdef_in_async_stmt2395);
					funcdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:529:24: with_stmt
					{
					pushFollow(FOLLOW_with_stmt_in_async_stmt2399);
					with_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:529:36: for_stmt
					{
					pushFollow(FOLLOW_for_stmt_in_async_stmt2403);
					for_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "async_stmt"



	// $ANTLR start "if_stmt"
	// PythonPartial.g:533:1: if_stmt : IF test COLON suite ( elif_clause )? ;
	public final void if_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:534:5: ( IF test COLON suite ( elif_clause )? )
			// PythonPartial.g:534:7: IF test COLON suite ( elif_clause )?
			{
			match(input,IF,FOLLOW_IF_in_if_stmt2422); if (state.failed) return;
			pushFollow(FOLLOW_test_in_if_stmt2424);
			test();
			state._fsp--;
			if (state.failed) return;
			match(input,COLON,FOLLOW_COLON_in_if_stmt2426); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_if_stmt2428);
			suite();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:534:27: ( elif_clause )?
			int alt90=2;
			int LA90_0 = input.LA(1);
			if ( (LA90_0==ELIF||LA90_0==ORELSE) ) {
				alt90=1;
			}
			switch (alt90) {
				case 1 :
					// PythonPartial.g:534:27: elif_clause
					{
					pushFollow(FOLLOW_elif_clause_in_if_stmt2430);
					elif_clause();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_stmt"



	// $ANTLR start "elif_clause"
	// PythonPartial.g:538:1: elif_clause : ( else_clause | ELIF test COLON suite ( elif_clause |) );
	public final void elif_clause() throws RecognitionException {
		try {
			// PythonPartial.g:539:5: ( else_clause | ELIF test COLON suite ( elif_clause |) )
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( (LA92_0==ORELSE) ) {
				alt92=1;
			}
			else if ( (LA92_0==ELIF) ) {
				alt92=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 92, 0, input);
				throw nvae;
			}

			switch (alt92) {
				case 1 :
					// PythonPartial.g:539:7: else_clause
					{
					pushFollow(FOLLOW_else_clause_in_elif_clause2449);
					else_clause();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:540:7: ELIF test COLON suite ( elif_clause |)
					{
					match(input,ELIF,FOLLOW_ELIF_in_elif_clause2457); if (state.failed) return;
					pushFollow(FOLLOW_test_in_elif_clause2459);
					test();
					state._fsp--;
					if (state.failed) return;
					match(input,COLON,FOLLOW_COLON_in_elif_clause2461); if (state.failed) return;
					pushFollow(FOLLOW_suite_in_elif_clause2463);
					suite();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:541:9: ( elif_clause |)
					int alt91=2;
					int LA91_0 = input.LA(1);
					if ( (LA91_0==ELIF||LA91_0==ORELSE) ) {
						alt91=1;
					}
					else if ( (LA91_0==EOF||LA91_0==ASSERT||(LA91_0 >= ASYNC && LA91_0 <= AT)||(LA91_0 >= AWAIT && LA91_0 <= BREAK)||LA91_0==CLASS||(LA91_0 >= COMPLEX && LA91_0 <= CONTINUE)||(LA91_0 >= DEDENT && LA91_0 <= DELETE)||LA91_0==DOT||LA91_0==EXEC||(LA91_0 >= FLOAT && LA91_0 <= GLOBAL)||(LA91_0 >= IF && LA91_0 <= IMPORT)||LA91_0==INT||(LA91_0 >= LAMBDA && LA91_0 <= LCURLY)||(LA91_0 >= LONGINT && LA91_0 <= MINUS)||(LA91_0 >= NAME && LA91_0 <= NEWLINE)||LA91_0==NOT||LA91_0==PASS||LA91_0==PLUS||LA91_0==RAISE||LA91_0==RETURN||(LA91_0 >= STRING && LA91_0 <= TRAILBACKSLASH)||LA91_0==TRY||(LA91_0 >= WHILE && LA91_0 <= WITH)||(LA91_0 >= YIELD && LA91_0 <= TRISTRINGPART)) ) {
						alt91=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 91, 0, input);
						throw nvae;
					}

					switch (alt91) {
						case 1 :
							// PythonPartial.g:541:10: elif_clause
							{
							pushFollow(FOLLOW_elif_clause_in_elif_clause2474);
							elif_clause();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:543:9: 
							{
							}
							break;

					}

					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "elif_clause"



	// $ANTLR start "else_clause"
	// PythonPartial.g:547:1: else_clause : ORELSE COLON suite ;
	public final void else_clause() throws RecognitionException {
		try {
			// PythonPartial.g:548:5: ( ORELSE COLON suite )
			// PythonPartial.g:548:7: ORELSE COLON suite
			{
			match(input,ORELSE,FOLLOW_ORELSE_in_else_clause2512); if (state.failed) return;
			match(input,COLON,FOLLOW_COLON_in_else_clause2514); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_else_clause2516);
			suite();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "else_clause"



	// $ANTLR start "while_stmt"
	// PythonPartial.g:552:1: while_stmt : WHILE test COLON suite ( ORELSE COLON suite )? ;
	public final void while_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:553:5: ( WHILE test COLON suite ( ORELSE COLON suite )? )
			// PythonPartial.g:553:7: WHILE test COLON suite ( ORELSE COLON suite )?
			{
			match(input,WHILE,FOLLOW_WHILE_in_while_stmt2534); if (state.failed) return;
			pushFollow(FOLLOW_test_in_while_stmt2536);
			test();
			state._fsp--;
			if (state.failed) return;
			match(input,COLON,FOLLOW_COLON_in_while_stmt2538); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_while_stmt2540);
			suite();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:553:30: ( ORELSE COLON suite )?
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( (LA93_0==ORELSE) ) {
				alt93=1;
			}
			switch (alt93) {
				case 1 :
					// PythonPartial.g:553:31: ORELSE COLON suite
					{
					match(input,ORELSE,FOLLOW_ORELSE_in_while_stmt2543); if (state.failed) return;
					match(input,COLON,FOLLOW_COLON_in_while_stmt2545); if (state.failed) return;
					pushFollow(FOLLOW_suite_in_while_stmt2547);
					suite();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_stmt"



	// $ANTLR start "for_stmt"
	// PythonPartial.g:557:1: for_stmt : FOR exprlist IN testlist COLON suite ( ORELSE COLON suite )? ;
	public final void for_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:558:5: ( FOR exprlist IN testlist COLON suite ( ORELSE COLON suite )? )
			// PythonPartial.g:558:7: FOR exprlist IN testlist COLON suite ( ORELSE COLON suite )?
			{
			match(input,FOR,FOLLOW_FOR_in_for_stmt2567); if (state.failed) return;
			pushFollow(FOLLOW_exprlist_in_for_stmt2569);
			exprlist();
			state._fsp--;
			if (state.failed) return;
			match(input,IN,FOLLOW_IN_in_for_stmt2571); if (state.failed) return;
			pushFollow(FOLLOW_testlist_in_for_stmt2573);
			testlist();
			state._fsp--;
			if (state.failed) return;
			match(input,COLON,FOLLOW_COLON_in_for_stmt2575); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_for_stmt2577);
			suite();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:559:9: ( ORELSE COLON suite )?
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==ORELSE) ) {
				alt94=1;
			}
			switch (alt94) {
				case 1 :
					// PythonPartial.g:559:10: ORELSE COLON suite
					{
					match(input,ORELSE,FOLLOW_ORELSE_in_for_stmt2588); if (state.failed) return;
					match(input,COLON,FOLLOW_COLON_in_for_stmt2590); if (state.failed) return;
					pushFollow(FOLLOW_suite_in_for_stmt2592);
					suite();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_stmt"



	// $ANTLR start "try_stmt"
	// PythonPartial.g:567:1: try_stmt : TRY COLON suite ( ( except_clause COLON suite )+ ( ORELSE COLON suite )? ( FINALLY COLON suite )? | FINALLY COLON suite )? ;
	public final void try_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:568:5: ( TRY COLON suite ( ( except_clause COLON suite )+ ( ORELSE COLON suite )? ( FINALLY COLON suite )? | FINALLY COLON suite )? )
			// PythonPartial.g:568:7: TRY COLON suite ( ( except_clause COLON suite )+ ( ORELSE COLON suite )? ( FINALLY COLON suite )? | FINALLY COLON suite )?
			{
			match(input,TRY,FOLLOW_TRY_in_try_stmt2616); if (state.failed) return;
			match(input,COLON,FOLLOW_COLON_in_try_stmt2618); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_try_stmt2620);
			suite();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:569:7: ( ( except_clause COLON suite )+ ( ORELSE COLON suite )? ( FINALLY COLON suite )? | FINALLY COLON suite )?
			int alt98=3;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==EXCEPT) ) {
				alt98=1;
			}
			else if ( (LA98_0==FINALLY) ) {
				alt98=2;
			}
			switch (alt98) {
				case 1 :
					// PythonPartial.g:569:9: ( except_clause COLON suite )+ ( ORELSE COLON suite )? ( FINALLY COLON suite )?
					{
					// PythonPartial.g:569:9: ( except_clause COLON suite )+
					int cnt95=0;
					loop95:
					while (true) {
						int alt95=2;
						int LA95_0 = input.LA(1);
						if ( (LA95_0==EXCEPT) ) {
							alt95=1;
						}

						switch (alt95) {
						case 1 :
							// PythonPartial.g:569:10: except_clause COLON suite
							{
							pushFollow(FOLLOW_except_clause_in_try_stmt2631);
							except_clause();
							state._fsp--;
							if (state.failed) return;
							match(input,COLON,FOLLOW_COLON_in_try_stmt2633); if (state.failed) return;
							pushFollow(FOLLOW_suite_in_try_stmt2635);
							suite();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt95 >= 1 ) break loop95;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(95, input);
							throw eee;
						}
						cnt95++;
					}

					// PythonPartial.g:569:38: ( ORELSE COLON suite )?
					int alt96=2;
					int LA96_0 = input.LA(1);
					if ( (LA96_0==ORELSE) ) {
						alt96=1;
					}
					switch (alt96) {
						case 1 :
							// PythonPartial.g:569:39: ORELSE COLON suite
							{
							match(input,ORELSE,FOLLOW_ORELSE_in_try_stmt2640); if (state.failed) return;
							match(input,COLON,FOLLOW_COLON_in_try_stmt2642); if (state.failed) return;
							pushFollow(FOLLOW_suite_in_try_stmt2644);
							suite();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:569:60: ( FINALLY COLON suite )?
					int alt97=2;
					int LA97_0 = input.LA(1);
					if ( (LA97_0==FINALLY) ) {
						alt97=1;
					}
					switch (alt97) {
						case 1 :
							// PythonPartial.g:569:61: FINALLY COLON suite
							{
							match(input,FINALLY,FOLLOW_FINALLY_in_try_stmt2649); if (state.failed) return;
							match(input,COLON,FOLLOW_COLON_in_try_stmt2651); if (state.failed) return;
							pushFollow(FOLLOW_suite_in_try_stmt2653);
							suite();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:570:9: FINALLY COLON suite
					{
					match(input,FINALLY,FOLLOW_FINALLY_in_try_stmt2665); if (state.failed) return;
					match(input,COLON,FOLLOW_COLON_in_try_stmt2667); if (state.failed) return;
					pushFollow(FOLLOW_suite_in_try_stmt2669);
					suite();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "try_stmt"



	// $ANTLR start "with_stmt"
	// PythonPartial.g:575:1: with_stmt : WITH with_item ( options {greedy=true; } : COMMA with_item )* COLON suite ;
	public final void with_stmt() throws RecognitionException {
		try {
			// PythonPartial.g:576:5: ( WITH with_item ( options {greedy=true; } : COMMA with_item )* COLON suite )
			// PythonPartial.g:576:7: WITH with_item ( options {greedy=true; } : COMMA with_item )* COLON suite
			{
			match(input,WITH,FOLLOW_WITH_in_with_stmt2698); if (state.failed) return;
			pushFollow(FOLLOW_with_item_in_with_stmt2700);
			with_item();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:576:22: ( options {greedy=true; } : COMMA with_item )*
			loop99:
			while (true) {
				int alt99=2;
				int LA99_0 = input.LA(1);
				if ( (LA99_0==COMMA) ) {
					alt99=1;
				}

				switch (alt99) {
				case 1 :
					// PythonPartial.g:576:46: COMMA with_item
					{
					match(input,COMMA,FOLLOW_COMMA_in_with_stmt2710); if (state.failed) return;
					pushFollow(FOLLOW_with_item_in_with_stmt2712);
					with_item();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop99;
				}
			}

			match(input,COLON,FOLLOW_COLON_in_with_stmt2716); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_with_stmt2718);
			suite();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "with_stmt"



	// $ANTLR start "with_item"
	// PythonPartial.g:580:1: with_item : test ( AS expr )? ;
	public final void with_item() throws RecognitionException {
		try {
			// PythonPartial.g:581:5: ( test ( AS expr )? )
			// PythonPartial.g:581:7: test ( AS expr )?
			{
			pushFollow(FOLLOW_test_in_with_item2736);
			test();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:581:12: ( AS expr )?
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( (LA100_0==AS) ) {
				alt100=1;
			}
			switch (alt100) {
				case 1 :
					// PythonPartial.g:581:13: AS expr
					{
					match(input,AS,FOLLOW_AS_in_with_item2739); if (state.failed) return;
					pushFollow(FOLLOW_expr_in_with_item2741);
					expr();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "with_item"



	// $ANTLR start "except_clause"
	// PythonPartial.g:585:1: except_clause : EXCEPT ( test ( COMMA NAME )? )? ;
	public final void except_clause() throws RecognitionException {
		try {
			// PythonPartial.g:586:5: ( EXCEPT ( test ( COMMA NAME )? )? )
			// PythonPartial.g:586:7: EXCEPT ( test ( COMMA NAME )? )?
			{
			match(input,EXCEPT,FOLLOW_EXCEPT_in_except_clause2761); if (state.failed) return;
			// PythonPartial.g:586:14: ( test ( COMMA NAME )? )?
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( ((LA102_0 >= AWAIT && LA102_0 <= BACKQUOTE)||LA102_0==COMPLEX||LA102_0==DOT||LA102_0==FLOAT||LA102_0==INT||(LA102_0 >= LAMBDA && LA102_0 <= LCURLY)||(LA102_0 >= LONGINT && LA102_0 <= MINUS)||LA102_0==NAME||LA102_0==NOT||LA102_0==PLUS||(LA102_0 >= STRING && LA102_0 <= TRAILBACKSLASH)||(LA102_0 >= STRINGPART && LA102_0 <= TRISTRINGPART)) ) {
				alt102=1;
			}
			switch (alt102) {
				case 1 :
					// PythonPartial.g:586:15: test ( COMMA NAME )?
					{
					pushFollow(FOLLOW_test_in_except_clause2764);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:586:20: ( COMMA NAME )?
					int alt101=2;
					int LA101_0 = input.LA(1);
					if ( (LA101_0==COMMA) ) {
						alt101=1;
					}
					switch (alt101) {
						case 1 :
							// PythonPartial.g:586:21: COMMA NAME
							{
							match(input,COMMA,FOLLOW_COMMA_in_except_clause2767); if (state.failed) return;
							match(input,NAME,FOLLOW_NAME_in_except_clause2769); if (state.failed) return;
							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "except_clause"



	// $ANTLR start "suite"
	// PythonPartial.g:590:1: suite : ( simple_stmt | NEWLINE ( EOF | ( DEDENT )+ EOF | INDENT ( stmt )+ ( DEDENT | EOF ) ) );
	public final void suite() throws RecognitionException {
		try {
			// PythonPartial.g:591:5: ( simple_stmt | NEWLINE ( EOF | ( DEDENT )+ EOF | INDENT ( stmt )+ ( DEDENT | EOF ) ) )
			int alt106=2;
			int LA106_0 = input.LA(1);
			if ( (LA106_0==ASSERT||(LA106_0 >= AWAIT && LA106_0 <= BREAK)||(LA106_0 >= COMPLEX && LA106_0 <= CONTINUE)||LA106_0==DELETE||LA106_0==DOT||LA106_0==EXEC||LA106_0==FLOAT||(LA106_0 >= FROM && LA106_0 <= GLOBAL)||LA106_0==IMPORT||LA106_0==INT||(LA106_0 >= LAMBDA && LA106_0 <= LCURLY)||(LA106_0 >= LONGINT && LA106_0 <= MINUS)||LA106_0==NAME||LA106_0==NOT||LA106_0==PASS||LA106_0==PLUS||LA106_0==RAISE||LA106_0==RETURN||(LA106_0 >= STRING && LA106_0 <= TRAILBACKSLASH)||(LA106_0 >= YIELD && LA106_0 <= TRISTRINGPART)) ) {
				alt106=1;
			}
			else if ( (LA106_0==NEWLINE) ) {
				alt106=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 106, 0, input);
				throw nvae;
			}

			switch (alt106) {
				case 1 :
					// PythonPartial.g:591:7: simple_stmt
					{
					pushFollow(FOLLOW_simple_stmt_in_suite2791);
					simple_stmt();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:592:7: NEWLINE ( EOF | ( DEDENT )+ EOF | INDENT ( stmt )+ ( DEDENT | EOF ) )
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_suite2799); if (state.failed) return;
					// PythonPartial.g:592:15: ( EOF | ( DEDENT )+ EOF | INDENT ( stmt )+ ( DEDENT | EOF ) )
					int alt105=3;
					switch ( input.LA(1) ) {
					case EOF:
						{
						alt105=1;
						}
						break;
					case DEDENT:
						{
						alt105=2;
						}
						break;
					case INDENT:
						{
						alt105=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 105, 0, input);
						throw nvae;
					}
					switch (alt105) {
						case 1 :
							// PythonPartial.g:592:16: EOF
							{
							match(input,EOF,FOLLOW_EOF_in_suite2802); if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:593:17: ( DEDENT )+ EOF
							{
							// PythonPartial.g:593:17: ( DEDENT )+
							int cnt103=0;
							loop103:
							while (true) {
								int alt103=2;
								int LA103_0 = input.LA(1);
								if ( (LA103_0==DEDENT) ) {
									alt103=1;
								}

								switch (alt103) {
								case 1 :
									// PythonPartial.g:593:18: DEDENT
									{
									match(input,DEDENT,FOLLOW_DEDENT_in_suite2821); if (state.failed) return;
									}
									break;

								default :
									if ( cnt103 >= 1 ) break loop103;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(103, input);
									throw eee;
								}
								cnt103++;
							}

							match(input,EOF,FOLLOW_EOF_in_suite2825); if (state.failed) return;
							}
							break;
						case 3 :
							// PythonPartial.g:594:17: INDENT ( stmt )+ ( DEDENT | EOF )
							{
							match(input,INDENT,FOLLOW_INDENT_in_suite2843); if (state.failed) return;
							// PythonPartial.g:594:24: ( stmt )+
							int cnt104=0;
							loop104:
							while (true) {
								int alt104=2;
								int LA104_0 = input.LA(1);
								if ( (LA104_0==ASSERT||(LA104_0 >= ASYNC && LA104_0 <= AT)||(LA104_0 >= AWAIT && LA104_0 <= BREAK)||LA104_0==CLASS||(LA104_0 >= COMPLEX && LA104_0 <= CONTINUE)||(LA104_0 >= DEF && LA104_0 <= DELETE)||LA104_0==DOT||LA104_0==EXEC||(LA104_0 >= FLOAT && LA104_0 <= GLOBAL)||(LA104_0 >= IF && LA104_0 <= IMPORT)||LA104_0==INT||(LA104_0 >= LAMBDA && LA104_0 <= LCURLY)||(LA104_0 >= LONGINT && LA104_0 <= MINUS)||LA104_0==NAME||LA104_0==NOT||LA104_0==PASS||LA104_0==PLUS||LA104_0==RAISE||LA104_0==RETURN||(LA104_0 >= STRING && LA104_0 <= TRAILBACKSLASH)||LA104_0==TRY||(LA104_0 >= WHILE && LA104_0 <= WITH)||(LA104_0 >= YIELD && LA104_0 <= TRISTRINGPART)) ) {
									alt104=1;
								}

								switch (alt104) {
								case 1 :
									// PythonPartial.g:594:25: stmt
									{
									pushFollow(FOLLOW_stmt_in_suite2846);
									stmt();
									state._fsp--;
									if (state.failed) return;
									}
									break;

								default :
									if ( cnt104 >= 1 ) break loop104;
									if (state.backtracking>0) {state.failed=true; return;}
									EarlyExitException eee = new EarlyExitException(104, input);
									throw eee;
								}
								cnt104++;
							}

							if ( input.LA(1)==EOF||input.LA(1)==DEDENT ) {
								input.consume();
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "suite"



	// $ANTLR start "test"
	// PythonPartial.g:601:1: test : ( or_test ( ( IF or_test ORELSE )=> IF or_test ORELSE test |) | lambdef );
	public final void test() throws RecognitionException {
		try {
			// PythonPartial.g:602:5: ( or_test ( ( IF or_test ORELSE )=> IF or_test ORELSE test |) | lambdef )
			int alt108=2;
			int LA108_0 = input.LA(1);
			if ( ((LA108_0 >= AWAIT && LA108_0 <= BACKQUOTE)||LA108_0==COMPLEX||LA108_0==DOT||LA108_0==FLOAT||LA108_0==INT||(LA108_0 >= LBRACK && LA108_0 <= LCURLY)||(LA108_0 >= LONGINT && LA108_0 <= MINUS)||LA108_0==NAME||LA108_0==NOT||LA108_0==PLUS||(LA108_0 >= STRING && LA108_0 <= TRAILBACKSLASH)||(LA108_0 >= STRINGPART && LA108_0 <= TRISTRINGPART)) ) {
				alt108=1;
			}
			else if ( (LA108_0==LAMBDA) ) {
				alt108=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 108, 0, input);
				throw nvae;
			}

			switch (alt108) {
				case 1 :
					// PythonPartial.g:602:6: or_test ( ( IF or_test ORELSE )=> IF or_test ORELSE test |)
					{
					pushFollow(FOLLOW_or_test_in_test2951);
					or_test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:603:7: ( ( IF or_test ORELSE )=> IF or_test ORELSE test |)
					int alt107=2;
					int LA107_0 = input.LA(1);
					if ( (LA107_0==IF) ) {
						int LA107_1 = input.LA(2);
						if ( (synpred4_PythonPartial()) ) {
							alt107=1;
						}
						else if ( (true) ) {
							alt107=2;
						}

					}
					else if ( (LA107_0==EOF||LA107_0==AMPEREQUAL||LA107_0==AS||LA107_0==ASSIGN||LA107_0==BACKQUOTE||LA107_0==CIRCUMFLEXEQUAL||(LA107_0 >= COLON && LA107_0 <= COMMA)||LA107_0==DOUBLESLASHEQUAL||LA107_0==DOUBLESTAREQUAL||(LA107_0 >= FOR && LA107_0 <= FROM)||LA107_0==LEFTSHIFTEQUAL||LA107_0==MINUSEQUAL||LA107_0==NEWLINE||LA107_0==PERCENTEQUAL||LA107_0==PLUSEQUAL||(LA107_0 >= RBRACK && LA107_0 <= RCURLY)||(LA107_0 >= RIGHTSHIFTEQUAL && LA107_0 <= SEMI)||LA107_0==SLASHEQUAL||LA107_0==STAREQUAL||LA107_0==VBAREQUAL) ) {
						alt107=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 107, 0, input);
						throw nvae;
					}

					switch (alt107) {
						case 1 :
							// PythonPartial.g:603:9: ( IF or_test ORELSE )=> IF or_test ORELSE test
							{
							match(input,IF,FOLLOW_IF_in_test2971); if (state.failed) return;
							pushFollow(FOLLOW_or_test_in_test2973);
							or_test();
							state._fsp--;
							if (state.failed) return;
							match(input,ORELSE,FOLLOW_ORELSE_in_test2975); if (state.failed) return;
							pushFollow(FOLLOW_test_in_test2977);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:605:7: 
							{
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:606:7: lambdef
					{
					pushFollow(FOLLOW_lambdef_in_test3001);
					lambdef();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "test"



	// $ANTLR start "or_test"
	// PythonPartial.g:610:1: or_test : and_test ( ( OR and_test )+ |) ;
	public final void or_test() throws RecognitionException {
		try {
			// PythonPartial.g:611:5: ( and_test ( ( OR and_test )+ |) )
			// PythonPartial.g:611:7: and_test ( ( OR and_test )+ |)
			{
			pushFollow(FOLLOW_and_test_in_or_test3019);
			and_test();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:612:9: ( ( OR and_test )+ |)
			int alt110=2;
			int LA110_0 = input.LA(1);
			if ( (LA110_0==OR) ) {
				alt110=1;
			}
			else if ( (LA110_0==EOF||LA110_0==AMPEREQUAL||LA110_0==AS||LA110_0==ASSIGN||LA110_0==BACKQUOTE||LA110_0==CIRCUMFLEXEQUAL||(LA110_0 >= COLON && LA110_0 <= COMMA)||LA110_0==DOUBLESLASHEQUAL||LA110_0==DOUBLESTAREQUAL||(LA110_0 >= FOR && LA110_0 <= FROM)||LA110_0==IF||LA110_0==LEFTSHIFTEQUAL||LA110_0==MINUSEQUAL||LA110_0==NEWLINE||LA110_0==ORELSE||LA110_0==PERCENTEQUAL||LA110_0==PLUSEQUAL||(LA110_0 >= RBRACK && LA110_0 <= RCURLY)||(LA110_0 >= RIGHTSHIFTEQUAL && LA110_0 <= SEMI)||LA110_0==SLASHEQUAL||LA110_0==STAREQUAL||LA110_0==VBAREQUAL) ) {
				alt110=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 110, 0, input);
				throw nvae;
			}

			switch (alt110) {
				case 1 :
					// PythonPartial.g:612:11: ( OR and_test )+
					{
					// PythonPartial.g:612:11: ( OR and_test )+
					int cnt109=0;
					loop109:
					while (true) {
						int alt109=2;
						int LA109_0 = input.LA(1);
						if ( (LA109_0==OR) ) {
							alt109=1;
						}

						switch (alt109) {
						case 1 :
							// PythonPartial.g:612:12: OR and_test
							{
							match(input,OR,FOLLOW_OR_in_or_test3032); if (state.failed) return;
							pushFollow(FOLLOW_and_test_in_or_test3034);
							and_test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt109 >= 1 ) break loop109;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(109, input);
							throw eee;
						}
						cnt109++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:615:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "or_test"



	// $ANTLR start "and_test"
	// PythonPartial.g:619:1: and_test : not_test ( ( AND not_test )+ |) ;
	public final void and_test() throws RecognitionException {
		try {
			// PythonPartial.g:620:5: ( not_test ( ( AND not_test )+ |) )
			// PythonPartial.g:620:7: not_test ( ( AND not_test )+ |)
			{
			pushFollow(FOLLOW_not_test_in_and_test3085);
			not_test();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:621:9: ( ( AND not_test )+ |)
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==AND) ) {
				alt112=1;
			}
			else if ( (LA112_0==EOF||LA112_0==AMPEREQUAL||LA112_0==AS||LA112_0==ASSIGN||LA112_0==BACKQUOTE||LA112_0==CIRCUMFLEXEQUAL||(LA112_0 >= COLON && LA112_0 <= COMMA)||LA112_0==DOUBLESLASHEQUAL||LA112_0==DOUBLESTAREQUAL||(LA112_0 >= FOR && LA112_0 <= FROM)||LA112_0==IF||LA112_0==LEFTSHIFTEQUAL||LA112_0==MINUSEQUAL||LA112_0==NEWLINE||(LA112_0 >= OR && LA112_0 <= ORELSE)||LA112_0==PERCENTEQUAL||LA112_0==PLUSEQUAL||(LA112_0 >= RBRACK && LA112_0 <= RCURLY)||(LA112_0 >= RIGHTSHIFTEQUAL && LA112_0 <= SEMI)||LA112_0==SLASHEQUAL||LA112_0==STAREQUAL||LA112_0==VBAREQUAL) ) {
				alt112=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 112, 0, input);
				throw nvae;
			}

			switch (alt112) {
				case 1 :
					// PythonPartial.g:621:11: ( AND not_test )+
					{
					// PythonPartial.g:621:11: ( AND not_test )+
					int cnt111=0;
					loop111:
					while (true) {
						int alt111=2;
						int LA111_0 = input.LA(1);
						if ( (LA111_0==AND) ) {
							alt111=1;
						}

						switch (alt111) {
						case 1 :
							// PythonPartial.g:621:12: AND not_test
							{
							match(input,AND,FOLLOW_AND_in_and_test3098); if (state.failed) return;
							pushFollow(FOLLOW_not_test_in_and_test3100);
							not_test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt111 >= 1 ) break loop111;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(111, input);
							throw eee;
						}
						cnt111++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:624:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "and_test"



	// $ANTLR start "not_test"
	// PythonPartial.g:628:1: not_test : ( NOT not_test | comparison );
	public final void not_test() throws RecognitionException {
		try {
			// PythonPartial.g:629:5: ( NOT not_test | comparison )
			int alt113=2;
			int LA113_0 = input.LA(1);
			if ( (LA113_0==NOT) ) {
				alt113=1;
			}
			else if ( ((LA113_0 >= AWAIT && LA113_0 <= BACKQUOTE)||LA113_0==COMPLEX||LA113_0==DOT||LA113_0==FLOAT||LA113_0==INT||(LA113_0 >= LBRACK && LA113_0 <= LCURLY)||(LA113_0 >= LONGINT && LA113_0 <= MINUS)||LA113_0==NAME||LA113_0==PLUS||(LA113_0 >= STRING && LA113_0 <= TRAILBACKSLASH)||(LA113_0 >= STRINGPART && LA113_0 <= TRISTRINGPART)) ) {
				alt113=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 113, 0, input);
				throw nvae;
			}

			switch (alt113) {
				case 1 :
					// PythonPartial.g:629:7: NOT not_test
					{
					match(input,NOT,FOLLOW_NOT_in_not_test3151); if (state.failed) return;
					pushFollow(FOLLOW_not_test_in_not_test3153);
					not_test();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:630:7: comparison
					{
					pushFollow(FOLLOW_comparison_in_not_test3161);
					comparison();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "not_test"



	// $ANTLR start "comparison"
	// PythonPartial.g:634:1: comparison : expr ( ( comp_op expr )+ |) ;
	public final void comparison() throws RecognitionException {
		try {
			// PythonPartial.g:635:5: ( expr ( ( comp_op expr )+ |) )
			// PythonPartial.g:635:7: expr ( ( comp_op expr )+ |)
			{
			pushFollow(FOLLOW_expr_in_comparison3179);
			expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:636:8: ( ( comp_op expr )+ |)
			int alt115=2;
			int LA115_0 = input.LA(1);
			if ( (LA115_0==ALT_NOTEQUAL||LA115_0==EQUAL||(LA115_0 >= GREATER && LA115_0 <= GREATEREQUAL)||LA115_0==IN||LA115_0==IS||(LA115_0 >= LESS && LA115_0 <= LESSEQUAL)||(LA115_0 >= NOT && LA115_0 <= NOTEQUAL)) ) {
				alt115=1;
			}
			else if ( (LA115_0==EOF||(LA115_0 >= AMPEREQUAL && LA115_0 <= AND)||LA115_0==AS||LA115_0==ASSIGN||LA115_0==BACKQUOTE||LA115_0==CIRCUMFLEXEQUAL||(LA115_0 >= COLON && LA115_0 <= COMMA)||LA115_0==DOUBLESLASHEQUAL||LA115_0==DOUBLESTAREQUAL||(LA115_0 >= FOR && LA115_0 <= FROM)||LA115_0==IF||LA115_0==LEFTSHIFTEQUAL||LA115_0==MINUSEQUAL||LA115_0==NEWLINE||(LA115_0 >= OR && LA115_0 <= ORELSE)||LA115_0==PERCENTEQUAL||LA115_0==PLUSEQUAL||(LA115_0 >= RBRACK && LA115_0 <= RCURLY)||(LA115_0 >= RIGHTSHIFTEQUAL && LA115_0 <= SEMI)||LA115_0==SLASHEQUAL||LA115_0==STAREQUAL||LA115_0==VBAREQUAL) ) {
				alt115=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 115, 0, input);
				throw nvae;
			}

			switch (alt115) {
				case 1 :
					// PythonPartial.g:636:10: ( comp_op expr )+
					{
					// PythonPartial.g:636:10: ( comp_op expr )+
					int cnt114=0;
					loop114:
					while (true) {
						int alt114=2;
						int LA114_0 = input.LA(1);
						if ( (LA114_0==ALT_NOTEQUAL||LA114_0==EQUAL||(LA114_0 >= GREATER && LA114_0 <= GREATEREQUAL)||LA114_0==IN||LA114_0==IS||(LA114_0 >= LESS && LA114_0 <= LESSEQUAL)||(LA114_0 >= NOT && LA114_0 <= NOTEQUAL)) ) {
							alt114=1;
						}

						switch (alt114) {
						case 1 :
							// PythonPartial.g:636:12: comp_op expr
							{
							pushFollow(FOLLOW_comp_op_in_comparison3192);
							comp_op();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_expr_in_comparison3194);
							expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt114 >= 1 ) break loop114;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(114, input);
							throw eee;
						}
						cnt114++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:639:8: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comparison"



	// $ANTLR start "comp_op"
	// PythonPartial.g:643:1: comp_op : ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT );
	public final void comp_op() throws RecognitionException {
		try {
			// PythonPartial.g:644:5: ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT )
			int alt116=11;
			switch ( input.LA(1) ) {
			case LESS:
				{
				alt116=1;
				}
				break;
			case GREATER:
				{
				alt116=2;
				}
				break;
			case EQUAL:
				{
				alt116=3;
				}
				break;
			case GREATEREQUAL:
				{
				alt116=4;
				}
				break;
			case LESSEQUAL:
				{
				alt116=5;
				}
				break;
			case ALT_NOTEQUAL:
				{
				alt116=6;
				}
				break;
			case NOTEQUAL:
				{
				alt116=7;
				}
				break;
			case IN:
				{
				alt116=8;
				}
				break;
			case NOT:
				{
				alt116=9;
				}
				break;
			case IS:
				{
				int LA116_10 = input.LA(2);
				if ( (LA116_10==NOT) ) {
					alt116=11;
				}
				else if ( ((LA116_10 >= AWAIT && LA116_10 <= BACKQUOTE)||LA116_10==COMPLEX||LA116_10==DOT||LA116_10==FLOAT||LA116_10==INT||(LA116_10 >= LBRACK && LA116_10 <= LCURLY)||(LA116_10 >= LONGINT && LA116_10 <= MINUS)||LA116_10==NAME||LA116_10==PLUS||(LA116_10 >= STRING && LA116_10 <= TRAILBACKSLASH)||(LA116_10 >= STRINGPART && LA116_10 <= TRISTRINGPART)) ) {
					alt116=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 116, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 116, 0, input);
				throw nvae;
			}
			switch (alt116) {
				case 1 :
					// PythonPartial.g:644:7: LESS
					{
					match(input,LESS,FOLLOW_LESS_in_comp_op3242); if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:645:7: GREATER
					{
					match(input,GREATER,FOLLOW_GREATER_in_comp_op3250); if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:646:7: EQUAL
					{
					match(input,EQUAL,FOLLOW_EQUAL_in_comp_op3258); if (state.failed) return;
					}
					break;
				case 4 :
					// PythonPartial.g:647:7: GREATEREQUAL
					{
					match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_comp_op3266); if (state.failed) return;
					}
					break;
				case 5 :
					// PythonPartial.g:648:7: LESSEQUAL
					{
					match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_comp_op3274); if (state.failed) return;
					}
					break;
				case 6 :
					// PythonPartial.g:649:7: ALT_NOTEQUAL
					{
					match(input,ALT_NOTEQUAL,FOLLOW_ALT_NOTEQUAL_in_comp_op3282); if (state.failed) return;
					}
					break;
				case 7 :
					// PythonPartial.g:650:7: NOTEQUAL
					{
					match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_comp_op3290); if (state.failed) return;
					}
					break;
				case 8 :
					// PythonPartial.g:651:7: IN
					{
					match(input,IN,FOLLOW_IN_in_comp_op3298); if (state.failed) return;
					}
					break;
				case 9 :
					// PythonPartial.g:652:7: NOT IN
					{
					match(input,NOT,FOLLOW_NOT_in_comp_op3306); if (state.failed) return;
					match(input,IN,FOLLOW_IN_in_comp_op3308); if (state.failed) return;
					}
					break;
				case 10 :
					// PythonPartial.g:653:7: IS
					{
					match(input,IS,FOLLOW_IS_in_comp_op3316); if (state.failed) return;
					}
					break;
				case 11 :
					// PythonPartial.g:654:7: IS NOT
					{
					match(input,IS,FOLLOW_IS_in_comp_op3324); if (state.failed) return;
					match(input,NOT,FOLLOW_NOT_in_comp_op3326); if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comp_op"



	// $ANTLR start "expr"
	// PythonPartial.g:658:1: expr : xor_expr ( ( VBAR xor_expr )+ |) ;
	public final void expr() throws RecognitionException {
		try {
			// PythonPartial.g:659:5: ( xor_expr ( ( VBAR xor_expr )+ |) )
			// PythonPartial.g:659:7: xor_expr ( ( VBAR xor_expr )+ |)
			{
			pushFollow(FOLLOW_xor_expr_in_expr3344);
			xor_expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:660:9: ( ( VBAR xor_expr )+ |)
			int alt118=2;
			int LA118_0 = input.LA(1);
			if ( (LA118_0==VBAR) ) {
				alt118=1;
			}
			else if ( (LA118_0==EOF||LA118_0==ALT_NOTEQUAL||(LA118_0 >= AMPEREQUAL && LA118_0 <= AND)||LA118_0==AS||LA118_0==ASSIGN||LA118_0==BACKQUOTE||LA118_0==CIRCUMFLEXEQUAL||(LA118_0 >= COLON && LA118_0 <= COMMA)||LA118_0==DOUBLESLASHEQUAL||LA118_0==DOUBLESTAREQUAL||LA118_0==EQUAL||(LA118_0 >= FOR && LA118_0 <= FROM)||(LA118_0 >= GREATER && LA118_0 <= IF)||LA118_0==IN||LA118_0==IS||(LA118_0 >= LEFTSHIFTEQUAL && LA118_0 <= LESSEQUAL)||LA118_0==MINUSEQUAL||LA118_0==NEWLINE||(LA118_0 >= NOT && LA118_0 <= ORELSE)||LA118_0==PERCENTEQUAL||LA118_0==PLUSEQUAL||(LA118_0 >= RBRACK && LA118_0 <= RCURLY)||(LA118_0 >= RIGHTSHIFTEQUAL && LA118_0 <= SEMI)||LA118_0==SLASHEQUAL||LA118_0==STAREQUAL||LA118_0==VBAREQUAL) ) {
				alt118=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 118, 0, input);
				throw nvae;
			}

			switch (alt118) {
				case 1 :
					// PythonPartial.g:660:11: ( VBAR xor_expr )+
					{
					// PythonPartial.g:660:11: ( VBAR xor_expr )+
					int cnt117=0;
					loop117:
					while (true) {
						int alt117=2;
						int LA117_0 = input.LA(1);
						if ( (LA117_0==VBAR) ) {
							alt117=1;
						}

						switch (alt117) {
						case 1 :
							// PythonPartial.g:660:12: VBAR xor_expr
							{
							match(input,VBAR,FOLLOW_VBAR_in_expr3357); if (state.failed) return;
							pushFollow(FOLLOW_xor_expr_in_expr3359);
							xor_expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt117 >= 1 ) break loop117;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(117, input);
							throw eee;
						}
						cnt117++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:663:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "xor_expr"
	// PythonPartial.g:667:1: xor_expr : and_expr ( ( CIRCUMFLEX and_expr )+ |) ;
	public final void xor_expr() throws RecognitionException {
		try {
			// PythonPartial.g:668:5: ( and_expr ( ( CIRCUMFLEX and_expr )+ |) )
			// PythonPartial.g:668:7: and_expr ( ( CIRCUMFLEX and_expr )+ |)
			{
			pushFollow(FOLLOW_and_expr_in_xor_expr3410);
			and_expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:669:9: ( ( CIRCUMFLEX and_expr )+ |)
			int alt120=2;
			int LA120_0 = input.LA(1);
			if ( (LA120_0==CIRCUMFLEX) ) {
				alt120=1;
			}
			else if ( (LA120_0==EOF||LA120_0==ALT_NOTEQUAL||(LA120_0 >= AMPEREQUAL && LA120_0 <= AND)||LA120_0==AS||LA120_0==ASSIGN||LA120_0==BACKQUOTE||LA120_0==CIRCUMFLEXEQUAL||(LA120_0 >= COLON && LA120_0 <= COMMA)||LA120_0==DOUBLESLASHEQUAL||LA120_0==DOUBLESTAREQUAL||LA120_0==EQUAL||(LA120_0 >= FOR && LA120_0 <= FROM)||(LA120_0 >= GREATER && LA120_0 <= IF)||LA120_0==IN||LA120_0==IS||(LA120_0 >= LEFTSHIFTEQUAL && LA120_0 <= LESSEQUAL)||LA120_0==MINUSEQUAL||LA120_0==NEWLINE||(LA120_0 >= NOT && LA120_0 <= ORELSE)||LA120_0==PERCENTEQUAL||LA120_0==PLUSEQUAL||(LA120_0 >= RBRACK && LA120_0 <= RCURLY)||(LA120_0 >= RIGHTSHIFTEQUAL && LA120_0 <= SEMI)||LA120_0==SLASHEQUAL||LA120_0==STAREQUAL||(LA120_0 >= VBAR && LA120_0 <= VBAREQUAL)) ) {
				alt120=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 120, 0, input);
				throw nvae;
			}

			switch (alt120) {
				case 1 :
					// PythonPartial.g:669:11: ( CIRCUMFLEX and_expr )+
					{
					// PythonPartial.g:669:11: ( CIRCUMFLEX and_expr )+
					int cnt119=0;
					loop119:
					while (true) {
						int alt119=2;
						int LA119_0 = input.LA(1);
						if ( (LA119_0==CIRCUMFLEX) ) {
							alt119=1;
						}

						switch (alt119) {
						case 1 :
							// PythonPartial.g:669:12: CIRCUMFLEX and_expr
							{
							match(input,CIRCUMFLEX,FOLLOW_CIRCUMFLEX_in_xor_expr3423); if (state.failed) return;
							pushFollow(FOLLOW_and_expr_in_xor_expr3425);
							and_expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt119 >= 1 ) break loop119;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(119, input);
							throw eee;
						}
						cnt119++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:672:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "xor_expr"



	// $ANTLR start "and_expr"
	// PythonPartial.g:676:1: and_expr : shift_expr ( ( AMPER shift_expr )+ |) ;
	public final void and_expr() throws RecognitionException {
		try {
			// PythonPartial.g:677:5: ( shift_expr ( ( AMPER shift_expr )+ |) )
			// PythonPartial.g:677:7: shift_expr ( ( AMPER shift_expr )+ |)
			{
			pushFollow(FOLLOW_shift_expr_in_and_expr3476);
			shift_expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:678:9: ( ( AMPER shift_expr )+ |)
			int alt122=2;
			int LA122_0 = input.LA(1);
			if ( (LA122_0==AMPER) ) {
				alt122=1;
			}
			else if ( (LA122_0==EOF||LA122_0==ALT_NOTEQUAL||(LA122_0 >= AMPEREQUAL && LA122_0 <= AND)||LA122_0==AS||LA122_0==ASSIGN||LA122_0==BACKQUOTE||(LA122_0 >= CIRCUMFLEX && LA122_0 <= CIRCUMFLEXEQUAL)||(LA122_0 >= COLON && LA122_0 <= COMMA)||LA122_0==DOUBLESLASHEQUAL||LA122_0==DOUBLESTAREQUAL||LA122_0==EQUAL||(LA122_0 >= FOR && LA122_0 <= FROM)||(LA122_0 >= GREATER && LA122_0 <= IF)||LA122_0==IN||LA122_0==IS||(LA122_0 >= LEFTSHIFTEQUAL && LA122_0 <= LESSEQUAL)||LA122_0==MINUSEQUAL||LA122_0==NEWLINE||(LA122_0 >= NOT && LA122_0 <= ORELSE)||LA122_0==PERCENTEQUAL||LA122_0==PLUSEQUAL||(LA122_0 >= RBRACK && LA122_0 <= RCURLY)||(LA122_0 >= RIGHTSHIFTEQUAL && LA122_0 <= SEMI)||LA122_0==SLASHEQUAL||LA122_0==STAREQUAL||(LA122_0 >= VBAR && LA122_0 <= VBAREQUAL)) ) {
				alt122=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 122, 0, input);
				throw nvae;
			}

			switch (alt122) {
				case 1 :
					// PythonPartial.g:678:11: ( AMPER shift_expr )+
					{
					// PythonPartial.g:678:11: ( AMPER shift_expr )+
					int cnt121=0;
					loop121:
					while (true) {
						int alt121=2;
						int LA121_0 = input.LA(1);
						if ( (LA121_0==AMPER) ) {
							alt121=1;
						}

						switch (alt121) {
						case 1 :
							// PythonPartial.g:678:12: AMPER shift_expr
							{
							match(input,AMPER,FOLLOW_AMPER_in_and_expr3489); if (state.failed) return;
							pushFollow(FOLLOW_shift_expr_in_and_expr3491);
							shift_expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt121 >= 1 ) break loop121;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(121, input);
							throw eee;
						}
						cnt121++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:681:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "and_expr"



	// $ANTLR start "shift_expr"
	// PythonPartial.g:685:1: shift_expr : arith_expr ( ( shift_op arith_expr )+ |) ;
	public final void shift_expr() throws RecognitionException {
		try {
			// PythonPartial.g:686:5: ( arith_expr ( ( shift_op arith_expr )+ |) )
			// PythonPartial.g:686:7: arith_expr ( ( shift_op arith_expr )+ |)
			{
			pushFollow(FOLLOW_arith_expr_in_shift_expr3542);
			arith_expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:687:9: ( ( shift_op arith_expr )+ |)
			int alt124=2;
			int LA124_0 = input.LA(1);
			if ( (LA124_0==LEFTSHIFT||LA124_0==RIGHTSHIFT) ) {
				alt124=1;
			}
			else if ( (LA124_0==EOF||(LA124_0 >= ALT_NOTEQUAL && LA124_0 <= AND)||LA124_0==AS||LA124_0==ASSIGN||LA124_0==BACKQUOTE||(LA124_0 >= CIRCUMFLEX && LA124_0 <= CIRCUMFLEXEQUAL)||(LA124_0 >= COLON && LA124_0 <= COMMA)||LA124_0==DOUBLESLASHEQUAL||LA124_0==DOUBLESTAREQUAL||LA124_0==EQUAL||(LA124_0 >= FOR && LA124_0 <= FROM)||(LA124_0 >= GREATER && LA124_0 <= IF)||LA124_0==IN||LA124_0==IS||(LA124_0 >= LEFTSHIFTEQUAL && LA124_0 <= LESSEQUAL)||LA124_0==MINUSEQUAL||LA124_0==NEWLINE||(LA124_0 >= NOT && LA124_0 <= ORELSE)||LA124_0==PERCENTEQUAL||LA124_0==PLUSEQUAL||(LA124_0 >= RBRACK && LA124_0 <= RCURLY)||(LA124_0 >= RIGHTSHIFTEQUAL && LA124_0 <= SEMI)||LA124_0==SLASHEQUAL||LA124_0==STAREQUAL||(LA124_0 >= VBAR && LA124_0 <= VBAREQUAL)) ) {
				alt124=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 124, 0, input);
				throw nvae;
			}

			switch (alt124) {
				case 1 :
					// PythonPartial.g:687:11: ( shift_op arith_expr )+
					{
					// PythonPartial.g:687:11: ( shift_op arith_expr )+
					int cnt123=0;
					loop123:
					while (true) {
						int alt123=2;
						int LA123_0 = input.LA(1);
						if ( (LA123_0==LEFTSHIFT||LA123_0==RIGHTSHIFT) ) {
							alt123=1;
						}

						switch (alt123) {
						case 1 :
							// PythonPartial.g:687:13: shift_op arith_expr
							{
							pushFollow(FOLLOW_shift_op_in_shift_expr3556);
							shift_op();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_arith_expr_in_shift_expr3558);
							arith_expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt123 >= 1 ) break loop123;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(123, input);
							throw eee;
						}
						cnt123++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:690:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "shift_expr"



	// $ANTLR start "shift_op"
	// PythonPartial.g:693:1: shift_op : ( LEFTSHIFT | RIGHTSHIFT );
	public final void shift_op() throws RecognitionException {
		try {
			// PythonPartial.g:694:5: ( LEFTSHIFT | RIGHTSHIFT )
			// PythonPartial.g:
			{
			if ( input.LA(1)==LEFTSHIFT||input.LA(1)==RIGHTSHIFT ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "shift_op"



	// $ANTLR start "arith_expr"
	// PythonPartial.g:699:1: arith_expr : term ( ( arith_op term )+ |) ;
	public final void arith_expr() throws RecognitionException {
		try {
			// PythonPartial.g:700:5: ( term ( ( arith_op term )+ |) )
			// PythonPartial.g:700:7: term ( ( arith_op term )+ |)
			{
			pushFollow(FOLLOW_term_in_arith_expr3634);
			term();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:701:9: ( ( arith_op term )+ |)
			int alt126=2;
			int LA126_0 = input.LA(1);
			if ( (LA126_0==MINUS||LA126_0==PLUS) ) {
				alt126=1;
			}
			else if ( (LA126_0==EOF||(LA126_0 >= ALT_NOTEQUAL && LA126_0 <= AND)||LA126_0==AS||LA126_0==ASSIGN||LA126_0==BACKQUOTE||(LA126_0 >= CIRCUMFLEX && LA126_0 <= CIRCUMFLEXEQUAL)||(LA126_0 >= COLON && LA126_0 <= COMMA)||LA126_0==DOUBLESLASHEQUAL||LA126_0==DOUBLESTAREQUAL||LA126_0==EQUAL||(LA126_0 >= FOR && LA126_0 <= FROM)||(LA126_0 >= GREATER && LA126_0 <= IF)||LA126_0==IN||LA126_0==IS||(LA126_0 >= LEFTSHIFT && LA126_0 <= LESSEQUAL)||LA126_0==MINUSEQUAL||LA126_0==NEWLINE||(LA126_0 >= NOT && LA126_0 <= ORELSE)||LA126_0==PERCENTEQUAL||LA126_0==PLUSEQUAL||(LA126_0 >= RBRACK && LA126_0 <= RCURLY)||(LA126_0 >= RIGHTSHIFT && LA126_0 <= SEMI)||LA126_0==SLASHEQUAL||LA126_0==STAREQUAL||(LA126_0 >= VBAR && LA126_0 <= VBAREQUAL)) ) {
				alt126=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 126, 0, input);
				throw nvae;
			}

			switch (alt126) {
				case 1 :
					// PythonPartial.g:701:11: ( arith_op term )+
					{
					// PythonPartial.g:701:11: ( arith_op term )+
					int cnt125=0;
					loop125:
					while (true) {
						int alt125=2;
						int LA125_0 = input.LA(1);
						if ( (LA125_0==MINUS||LA125_0==PLUS) ) {
							alt125=1;
						}

						switch (alt125) {
						case 1 :
							// PythonPartial.g:701:12: arith_op term
							{
							pushFollow(FOLLOW_arith_op_in_arith_expr3647);
							arith_op();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_term_in_arith_expr3649);
							term();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt125 >= 1 ) break loop125;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(125, input);
							throw eee;
						}
						cnt125++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:704:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arith_expr"



	// $ANTLR start "arith_op"
	// PythonPartial.g:707:1: arith_op : ( PLUS | MINUS );
	public final void arith_op() throws RecognitionException {
		try {
			// PythonPartial.g:708:5: ( PLUS | MINUS )
			// PythonPartial.g:
			{
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arith_op"



	// $ANTLR start "term"
	// PythonPartial.g:713:1: term : factor ( ( term_op factor )+ |) ;
	public final void term() throws RecognitionException {
		try {
			// PythonPartial.g:714:5: ( factor ( ( term_op factor )+ |) )
			// PythonPartial.g:714:7: factor ( ( term_op factor )+ |)
			{
			pushFollow(FOLLOW_factor_in_term3725);
			factor();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:715:9: ( ( term_op factor )+ |)
			int alt128=2;
			int LA128_0 = input.LA(1);
			if ( (LA128_0==DOUBLESLASH||LA128_0==PERCENT||LA128_0==SLASH||LA128_0==STAR) ) {
				alt128=1;
			}
			else if ( (LA128_0==EOF||(LA128_0 >= ALT_NOTEQUAL && LA128_0 <= AND)||LA128_0==AS||LA128_0==ASSIGN||LA128_0==BACKQUOTE||(LA128_0 >= CIRCUMFLEX && LA128_0 <= CIRCUMFLEXEQUAL)||(LA128_0 >= COLON && LA128_0 <= COMMA)||LA128_0==DOUBLESLASHEQUAL||LA128_0==DOUBLESTAREQUAL||LA128_0==EQUAL||(LA128_0 >= FOR && LA128_0 <= FROM)||(LA128_0 >= GREATER && LA128_0 <= IF)||LA128_0==IN||LA128_0==IS||(LA128_0 >= LEFTSHIFT && LA128_0 <= LESSEQUAL)||(LA128_0 >= MINUS && LA128_0 <= MINUSEQUAL)||LA128_0==NEWLINE||(LA128_0 >= NOT && LA128_0 <= ORELSE)||(LA128_0 >= PERCENTEQUAL && LA128_0 <= PLUSEQUAL)||(LA128_0 >= RBRACK && LA128_0 <= RCURLY)||(LA128_0 >= RIGHTSHIFT && LA128_0 <= SEMI)||LA128_0==SLASHEQUAL||LA128_0==STAREQUAL||(LA128_0 >= VBAR && LA128_0 <= VBAREQUAL)) ) {
				alt128=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 128, 0, input);
				throw nvae;
			}

			switch (alt128) {
				case 1 :
					// PythonPartial.g:715:11: ( term_op factor )+
					{
					// PythonPartial.g:715:11: ( term_op factor )+
					int cnt127=0;
					loop127:
					while (true) {
						int alt127=2;
						int LA127_0 = input.LA(1);
						if ( (LA127_0==DOUBLESLASH||LA127_0==PERCENT||LA127_0==SLASH||LA127_0==STAR) ) {
							alt127=1;
						}

						switch (alt127) {
						case 1 :
							// PythonPartial.g:715:12: term_op factor
							{
							pushFollow(FOLLOW_term_op_in_term3738);
							term_op();
							state._fsp--;
							if (state.failed) return;
							pushFollow(FOLLOW_factor_in_term3740);
							factor();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt127 >= 1 ) break loop127;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(127, input);
							throw eee;
						}
						cnt127++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:718:9: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term"



	// $ANTLR start "term_op"
	// PythonPartial.g:721:1: term_op : ( STAR | SLASH | PERCENT | DOUBLESLASH );
	public final void term_op() throws RecognitionException {
		try {
			// PythonPartial.g:722:5: ( STAR | SLASH | PERCENT | DOUBLESLASH )
			// PythonPartial.g:
			{
			if ( input.LA(1)==DOUBLESLASH||input.LA(1)==PERCENT||input.LA(1)==SLASH||input.LA(1)==STAR ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term_op"



	// $ANTLR start "factor"
	// PythonPartial.g:729:1: factor : ( PLUS factor | MINUS factor | TILDE factor | power | TRAILBACKSLASH );
	public final void factor() throws RecognitionException {
		try {
			// PythonPartial.g:730:5: ( PLUS factor | MINUS factor | TILDE factor | power | TRAILBACKSLASH )
			int alt129=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt129=1;
				}
				break;
			case MINUS:
				{
				alt129=2;
				}
				break;
			case TILDE:
				{
				alt129=3;
				}
				break;
			case AWAIT:
			case BACKQUOTE:
			case COMPLEX:
			case DOT:
			case FLOAT:
			case INT:
			case LBRACK:
			case LCURLY:
			case LONGINT:
			case LPAREN:
			case NAME:
			case STRING:
			case STRINGPART:
			case TRISTRINGPART:
				{
				alt129=4;
				}
				break;
			case TRAILBACKSLASH:
				{
				alt129=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 129, 0, input);
				throw nvae;
			}
			switch (alt129) {
				case 1 :
					// PythonPartial.g:730:7: PLUS factor
					{
					match(input,PLUS,FOLLOW_PLUS_in_factor3828); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_factor3830);
					factor();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:731:7: MINUS factor
					{
					match(input,MINUS,FOLLOW_MINUS_in_factor3838); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_factor3840);
					factor();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:732:7: TILDE factor
					{
					match(input,TILDE,FOLLOW_TILDE_in_factor3848); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_factor3850);
					factor();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// PythonPartial.g:733:7: power
					{
					pushFollow(FOLLOW_power_in_factor3858);
					power();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// PythonPartial.g:734:7: TRAILBACKSLASH
					{
					match(input,TRAILBACKSLASH,FOLLOW_TRAILBACKSLASH_in_factor3866); if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "factor"



	// $ANTLR start "power"
	// PythonPartial.g:738:1: power : atom_expr ( options {greedy=true; } : DOUBLESTAR factor )? ;
	public final void power() throws RecognitionException {
		try {
			// PythonPartial.g:739:5: ( atom_expr ( options {greedy=true; } : DOUBLESTAR factor )? )
			// PythonPartial.g:739:7: atom_expr ( options {greedy=true; } : DOUBLESTAR factor )?
			{
			pushFollow(FOLLOW_atom_expr_in_power3884);
			atom_expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:739:17: ( options {greedy=true; } : DOUBLESTAR factor )?
			int alt130=2;
			int LA130_0 = input.LA(1);
			if ( (LA130_0==DOUBLESTAR) ) {
				alt130=1;
			}
			switch (alt130) {
				case 1 :
					// PythonPartial.g:739:41: DOUBLESTAR factor
					{
					match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_power3894); if (state.failed) return;
					pushFollow(FOLLOW_factor_in_power3896);
					factor();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "power"



	// $ANTLR start "atom_expr"
	// PythonPartial.g:743:1: atom_expr : ( AWAIT )? atom ( trailer )* ;
	public final void atom_expr() throws RecognitionException {
		try {
			// PythonPartial.g:744:5: ( ( AWAIT )? atom ( trailer )* )
			// PythonPartial.g:744:7: ( AWAIT )? atom ( trailer )*
			{
			// PythonPartial.g:744:7: ( AWAIT )?
			int alt131=2;
			int LA131_0 = input.LA(1);
			if ( (LA131_0==AWAIT) ) {
				alt131=1;
			}
			switch (alt131) {
				case 1 :
					// PythonPartial.g:744:7: AWAIT
					{
					match(input,AWAIT,FOLLOW_AWAIT_in_atom_expr3916); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_atom_in_atom_expr3919);
			atom();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:744:19: ( trailer )*
			loop132:
			while (true) {
				int alt132=2;
				int LA132_0 = input.LA(1);
				if ( (LA132_0==DOT||LA132_0==LBRACK||LA132_0==LPAREN) ) {
					alt132=1;
				}

				switch (alt132) {
				case 1 :
					// PythonPartial.g:744:19: trailer
					{
					pushFollow(FOLLOW_trailer_in_atom_expr3921);
					trailer();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop132;
				}
			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atom_expr"



	// $ANTLR start "atom"
	// PythonPartial.g:752:1: atom : ( LPAREN ( yield_expr | testlist_comp |) RPAREN | LBRACK ( testlist_comp |) RBRACK | LCURLY ( dictorsetmaker |) RCURLY | BACKQUOTE testlist BACKQUOTE | NAME | INT | LONGINT | FLOAT | COMPLEX | DOT DOT DOT | ( STRING )+ | TRISTRINGPART | STRINGPART TRAILBACKSLASH );
	public final void atom() throws RecognitionException {
		try {
			// PythonPartial.g:753:5: ( LPAREN ( yield_expr | testlist_comp |) RPAREN | LBRACK ( testlist_comp |) RBRACK | LCURLY ( dictorsetmaker |) RCURLY | BACKQUOTE testlist BACKQUOTE | NAME | INT | LONGINT | FLOAT | COMPLEX | DOT DOT DOT | ( STRING )+ | TRISTRINGPART | STRINGPART TRAILBACKSLASH )
			int alt137=13;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt137=1;
				}
				break;
			case LBRACK:
				{
				alt137=2;
				}
				break;
			case LCURLY:
				{
				alt137=3;
				}
				break;
			case BACKQUOTE:
				{
				alt137=4;
				}
				break;
			case NAME:
				{
				alt137=5;
				}
				break;
			case INT:
				{
				alt137=6;
				}
				break;
			case LONGINT:
				{
				alt137=7;
				}
				break;
			case FLOAT:
				{
				alt137=8;
				}
				break;
			case COMPLEX:
				{
				alt137=9;
				}
				break;
			case DOT:
				{
				alt137=10;
				}
				break;
			case STRING:
				{
				alt137=11;
				}
				break;
			case TRISTRINGPART:
				{
				alt137=12;
				}
				break;
			case STRINGPART:
				{
				alt137=13;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 137, 0, input);
				throw nvae;
			}
			switch (alt137) {
				case 1 :
					// PythonPartial.g:753:7: LPAREN ( yield_expr | testlist_comp |) RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_atom3944); if (state.failed) return;
					// PythonPartial.g:754:7: ( yield_expr | testlist_comp |)
					int alt133=3;
					switch ( input.LA(1) ) {
					case YIELD:
						{
						alt133=1;
						}
						break;
					case AWAIT:
					case BACKQUOTE:
					case COMPLEX:
					case DOT:
					case FLOAT:
					case INT:
					case LAMBDA:
					case LBRACK:
					case LCURLY:
					case LONGINT:
					case LPAREN:
					case MINUS:
					case NAME:
					case NOT:
					case PLUS:
					case STAR:
					case STRING:
					case TILDE:
					case TRAILBACKSLASH:
					case STRINGPART:
					case TRISTRINGPART:
						{
						alt133=2;
						}
						break;
					case RPAREN:
						{
						alt133=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 133, 0, input);
						throw nvae;
					}
					switch (alt133) {
						case 1 :
							// PythonPartial.g:754:9: yield_expr
							{
							pushFollow(FOLLOW_yield_expr_in_atom3954);
							yield_expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:755:9: testlist_comp
							{
							pushFollow(FOLLOW_testlist_comp_in_atom3964);
							testlist_comp();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 3 :
							// PythonPartial.g:757:7: 
							{
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_atom3988); if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:759:7: LBRACK ( testlist_comp |) RBRACK
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_atom3996); if (state.failed) return;
					// PythonPartial.g:760:7: ( testlist_comp |)
					int alt134=2;
					int LA134_0 = input.LA(1);
					if ( ((LA134_0 >= AWAIT && LA134_0 <= BACKQUOTE)||LA134_0==COMPLEX||LA134_0==DOT||LA134_0==FLOAT||LA134_0==INT||(LA134_0 >= LAMBDA && LA134_0 <= LCURLY)||(LA134_0 >= LONGINT && LA134_0 <= MINUS)||LA134_0==NAME||LA134_0==NOT||LA134_0==PLUS||LA134_0==STAR||(LA134_0 >= STRING && LA134_0 <= TRAILBACKSLASH)||(LA134_0 >= STRINGPART && LA134_0 <= TRISTRINGPART)) ) {
						alt134=1;
					}
					else if ( (LA134_0==RBRACK) ) {
						alt134=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 134, 0, input);
						throw nvae;
					}

					switch (alt134) {
						case 1 :
							// PythonPartial.g:760:8: testlist_comp
							{
							pushFollow(FOLLOW_testlist_comp_in_atom4005);
							testlist_comp();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:762:7: 
							{
							}
							break;

					}

					match(input,RBRACK,FOLLOW_RBRACK_in_atom4029); if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:764:7: LCURLY ( dictorsetmaker |) RCURLY
					{
					match(input,LCURLY,FOLLOW_LCURLY_in_atom4037); if (state.failed) return;
					// PythonPartial.g:765:8: ( dictorsetmaker |)
					int alt135=2;
					int LA135_0 = input.LA(1);
					if ( ((LA135_0 >= AWAIT && LA135_0 <= BACKQUOTE)||LA135_0==COMPLEX||LA135_0==DOT||LA135_0==DOUBLESTAR||LA135_0==FLOAT||LA135_0==INT||(LA135_0 >= LAMBDA && LA135_0 <= LCURLY)||(LA135_0 >= LONGINT && LA135_0 <= MINUS)||LA135_0==NAME||LA135_0==NOT||LA135_0==PLUS||LA135_0==STAR||(LA135_0 >= STRING && LA135_0 <= TRAILBACKSLASH)||(LA135_0 >= STRINGPART && LA135_0 <= TRISTRINGPART)) ) {
						alt135=1;
					}
					else if ( (LA135_0==RCURLY) ) {
						alt135=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 135, 0, input);
						throw nvae;
					}

					switch (alt135) {
						case 1 :
							// PythonPartial.g:765:9: dictorsetmaker
							{
							pushFollow(FOLLOW_dictorsetmaker_in_atom4047);
							dictorsetmaker();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:767:8: 
							{
							}
							break;

					}

					match(input,RCURLY,FOLLOW_RCURLY_in_atom4074); if (state.failed) return;
					}
					break;
				case 4 :
					// PythonPartial.g:769:8: BACKQUOTE testlist BACKQUOTE
					{
					match(input,BACKQUOTE,FOLLOW_BACKQUOTE_in_atom4083); if (state.failed) return;
					pushFollow(FOLLOW_testlist_in_atom4085);
					testlist();
					state._fsp--;
					if (state.failed) return;
					match(input,BACKQUOTE,FOLLOW_BACKQUOTE_in_atom4087); if (state.failed) return;
					}
					break;
				case 5 :
					// PythonPartial.g:770:8: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_atom4096); if (state.failed) return;
					}
					break;
				case 6 :
					// PythonPartial.g:771:8: INT
					{
					match(input,INT,FOLLOW_INT_in_atom4105); if (state.failed) return;
					}
					break;
				case 7 :
					// PythonPartial.g:772:8: LONGINT
					{
					match(input,LONGINT,FOLLOW_LONGINT_in_atom4114); if (state.failed) return;
					}
					break;
				case 8 :
					// PythonPartial.g:773:8: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_atom4123); if (state.failed) return;
					}
					break;
				case 9 :
					// PythonPartial.g:774:8: COMPLEX
					{
					match(input,COMPLEX,FOLLOW_COMPLEX_in_atom4132); if (state.failed) return;
					}
					break;
				case 10 :
					// PythonPartial.g:775:8: DOT DOT DOT
					{
					match(input,DOT,FOLLOW_DOT_in_atom4141); if (state.failed) return;
					match(input,DOT,FOLLOW_DOT_in_atom4143); if (state.failed) return;
					match(input,DOT,FOLLOW_DOT_in_atom4145); if (state.failed) return;
					}
					break;
				case 11 :
					// PythonPartial.g:776:8: ( STRING )+
					{
					// PythonPartial.g:776:8: ( STRING )+
					int cnt136=0;
					loop136:
					while (true) {
						int alt136=2;
						int LA136_0 = input.LA(1);
						if ( (LA136_0==STRING) ) {
							alt136=1;
						}

						switch (alt136) {
						case 1 :
							// PythonPartial.g:776:9: STRING
							{
							match(input,STRING,FOLLOW_STRING_in_atom4155); if (state.failed) return;
							}
							break;

						default :
							if ( cnt136 >= 1 ) break loop136;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(136, input);
							throw eee;
						}
						cnt136++;
					}

					}
					break;
				case 12 :
					// PythonPartial.g:777:8: TRISTRINGPART
					{
					match(input,TRISTRINGPART,FOLLOW_TRISTRINGPART_in_atom4166); if (state.failed) return;
					}
					break;
				case 13 :
					// PythonPartial.g:778:8: STRINGPART TRAILBACKSLASH
					{
					match(input,STRINGPART,FOLLOW_STRINGPART_in_atom4175); if (state.failed) return;
					match(input,TRAILBACKSLASH,FOLLOW_TRAILBACKSLASH_in_atom4177); if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atom"



	// $ANTLR start "testlist_comp"
	// PythonPartial.g:782:1: testlist_comp : ( test ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for ) | star_expr ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for ) );
	public final void testlist_comp() throws RecognitionException {
		try {
			// PythonPartial.g:783:5: ( test ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for ) | star_expr ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for ) )
			int alt146=2;
			int LA146_0 = input.LA(1);
			if ( ((LA146_0 >= AWAIT && LA146_0 <= BACKQUOTE)||LA146_0==COMPLEX||LA146_0==DOT||LA146_0==FLOAT||LA146_0==INT||(LA146_0 >= LAMBDA && LA146_0 <= LCURLY)||(LA146_0 >= LONGINT && LA146_0 <= MINUS)||LA146_0==NAME||LA146_0==NOT||LA146_0==PLUS||(LA146_0 >= STRING && LA146_0 <= TRAILBACKSLASH)||(LA146_0 >= STRINGPART && LA146_0 <= TRISTRINGPART)) ) {
				alt146=1;
			}
			else if ( (LA146_0==STAR) ) {
				alt146=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 146, 0, input);
				throw nvae;
			}

			switch (alt146) {
				case 1 :
					// PythonPartial.g:783:7: test ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for )
					{
					pushFollow(FOLLOW_test_in_testlist_comp4196);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:784:9: ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for )
					int alt141=2;
					int LA141_0 = input.LA(1);
					if ( (LA141_0==COMMA||LA141_0==RBRACK||LA141_0==RPAREN) ) {
						alt141=1;
					}
					else if ( (LA141_0==FOR) ) {
						alt141=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 141, 0, input);
						throw nvae;
					}

					switch (alt141) {
						case 1 :
							// PythonPartial.g:784:11: ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )?
							{
							// PythonPartial.g:784:11: ( options {k=2; } : COMMA ( test | star_expr ) )*
							loop139:
							while (true) {
								int alt139=2;
								int LA139_0 = input.LA(1);
								if ( (LA139_0==COMMA) ) {
									int LA139_1 = input.LA(2);
									if ( ((LA139_1 >= AWAIT && LA139_1 <= BACKQUOTE)||LA139_1==COMPLEX||LA139_1==DOT||LA139_1==FLOAT||LA139_1==INT||(LA139_1 >= LAMBDA && LA139_1 <= LCURLY)||(LA139_1 >= LONGINT && LA139_1 <= MINUS)||LA139_1==NAME||LA139_1==NOT||LA139_1==PLUS||LA139_1==STAR||(LA139_1 >= STRING && LA139_1 <= TRAILBACKSLASH)||(LA139_1 >= STRINGPART && LA139_1 <= TRISTRINGPART)) ) {
										alt139=1;
									}

								}

								switch (alt139) {
								case 1 :
									// PythonPartial.g:784:28: COMMA ( test | star_expr )
									{
									match(input,COMMA,FOLLOW_COMMA_in_testlist_comp4217); if (state.failed) return;
									// PythonPartial.g:784:34: ( test | star_expr )
									int alt138=2;
									int LA138_0 = input.LA(1);
									if ( ((LA138_0 >= AWAIT && LA138_0 <= BACKQUOTE)||LA138_0==COMPLEX||LA138_0==DOT||LA138_0==FLOAT||LA138_0==INT||(LA138_0 >= LAMBDA && LA138_0 <= LCURLY)||(LA138_0 >= LONGINT && LA138_0 <= MINUS)||LA138_0==NAME||LA138_0==NOT||LA138_0==PLUS||(LA138_0 >= STRING && LA138_0 <= TRAILBACKSLASH)||(LA138_0 >= STRINGPART && LA138_0 <= TRISTRINGPART)) ) {
										alt138=1;
									}
									else if ( (LA138_0==STAR) ) {
										alt138=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return;}
										NoViableAltException nvae =
											new NoViableAltException("", 138, 0, input);
										throw nvae;
									}

									switch (alt138) {
										case 1 :
											// PythonPartial.g:784:35: test
											{
											pushFollow(FOLLOW_test_in_testlist_comp4220);
											test();
											state._fsp--;
											if (state.failed) return;
											}
											break;
										case 2 :
											// PythonPartial.g:784:42: star_expr
											{
											pushFollow(FOLLOW_star_expr_in_testlist_comp4224);
											star_expr();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									}
									break;

								default :
									break loop139;
								}
							}

							// PythonPartial.g:784:55: ( COMMA )?
							int alt140=2;
							int LA140_0 = input.LA(1);
							if ( (LA140_0==COMMA) ) {
								alt140=1;
							}
							switch (alt140) {
								case 1 :
									// PythonPartial.g:784:55: COMMA
									{
									match(input,COMMA,FOLLOW_COMMA_in_testlist_comp4229); if (state.failed) return;
									}
									break;

							}

							}
							break;
						case 2 :
							// PythonPartial.g:785:11: comp_for
							{
							pushFollow(FOLLOW_comp_for_in_testlist_comp4242);
							comp_for();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:787:7: star_expr ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for )
					{
					pushFollow(FOLLOW_star_expr_in_testlist_comp4260);
					star_expr();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:788:9: ( ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )? | comp_for )
					int alt145=2;
					int LA145_0 = input.LA(1);
					if ( (LA145_0==COMMA||LA145_0==RBRACK||LA145_0==RPAREN) ) {
						alt145=1;
					}
					else if ( (LA145_0==FOR) ) {
						alt145=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 145, 0, input);
						throw nvae;
					}

					switch (alt145) {
						case 1 :
							// PythonPartial.g:788:11: ( options {k=2; } : COMMA ( test | star_expr ) )* ( COMMA )?
							{
							// PythonPartial.g:788:11: ( options {k=2; } : COMMA ( test | star_expr ) )*
							loop143:
							while (true) {
								int alt143=2;
								int LA143_0 = input.LA(1);
								if ( (LA143_0==COMMA) ) {
									int LA143_1 = input.LA(2);
									if ( ((LA143_1 >= AWAIT && LA143_1 <= BACKQUOTE)||LA143_1==COMPLEX||LA143_1==DOT||LA143_1==FLOAT||LA143_1==INT||(LA143_1 >= LAMBDA && LA143_1 <= LCURLY)||(LA143_1 >= LONGINT && LA143_1 <= MINUS)||LA143_1==NAME||LA143_1==NOT||LA143_1==PLUS||LA143_1==STAR||(LA143_1 >= STRING && LA143_1 <= TRAILBACKSLASH)||(LA143_1 >= STRINGPART && LA143_1 <= TRISTRINGPART)) ) {
										alt143=1;
									}

								}

								switch (alt143) {
								case 1 :
									// PythonPartial.g:788:28: COMMA ( test | star_expr )
									{
									match(input,COMMA,FOLLOW_COMMA_in_testlist_comp4281); if (state.failed) return;
									// PythonPartial.g:788:34: ( test | star_expr )
									int alt142=2;
									int LA142_0 = input.LA(1);
									if ( ((LA142_0 >= AWAIT && LA142_0 <= BACKQUOTE)||LA142_0==COMPLEX||LA142_0==DOT||LA142_0==FLOAT||LA142_0==INT||(LA142_0 >= LAMBDA && LA142_0 <= LCURLY)||(LA142_0 >= LONGINT && LA142_0 <= MINUS)||LA142_0==NAME||LA142_0==NOT||LA142_0==PLUS||(LA142_0 >= STRING && LA142_0 <= TRAILBACKSLASH)||(LA142_0 >= STRINGPART && LA142_0 <= TRISTRINGPART)) ) {
										alt142=1;
									}
									else if ( (LA142_0==STAR) ) {
										alt142=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return;}
										NoViableAltException nvae =
											new NoViableAltException("", 142, 0, input);
										throw nvae;
									}

									switch (alt142) {
										case 1 :
											// PythonPartial.g:788:35: test
											{
											pushFollow(FOLLOW_test_in_testlist_comp4284);
											test();
											state._fsp--;
											if (state.failed) return;
											}
											break;
										case 2 :
											// PythonPartial.g:788:42: star_expr
											{
											pushFollow(FOLLOW_star_expr_in_testlist_comp4288);
											star_expr();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									}
									break;

								default :
									break loop143;
								}
							}

							// PythonPartial.g:788:55: ( COMMA )?
							int alt144=2;
							int LA144_0 = input.LA(1);
							if ( (LA144_0==COMMA) ) {
								alt144=1;
							}
							switch (alt144) {
								case 1 :
									// PythonPartial.g:788:55: COMMA
									{
									match(input,COMMA,FOLLOW_COMMA_in_testlist_comp4293); if (state.failed) return;
									}
									break;

							}

							}
							break;
						case 2 :
							// PythonPartial.g:789:11: comp_for
							{
							pushFollow(FOLLOW_comp_for_in_testlist_comp4306);
							comp_for();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "testlist_comp"



	// $ANTLR start "lambdef"
	// PythonPartial.g:794:1: lambdef : LAMBDA ( varargslist )? COLON test ;
	public final void lambdef() throws RecognitionException {
		try {
			// PythonPartial.g:795:5: ( LAMBDA ( varargslist )? COLON test )
			// PythonPartial.g:795:7: LAMBDA ( varargslist )? COLON test
			{
			match(input,LAMBDA,FOLLOW_LAMBDA_in_lambdef4334); if (state.failed) return;
			// PythonPartial.g:795:14: ( varargslist )?
			int alt147=2;
			int LA147_0 = input.LA(1);
			if ( (LA147_0==DOUBLESTAR||LA147_0==NAME||LA147_0==STAR) ) {
				alt147=1;
			}
			switch (alt147) {
				case 1 :
					// PythonPartial.g:795:15: varargslist
					{
					pushFollow(FOLLOW_varargslist_in_lambdef4337);
					varargslist();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			match(input,COLON,FOLLOW_COLON_in_lambdef4341); if (state.failed) return;
			pushFollow(FOLLOW_test_in_lambdef4343);
			test();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lambdef"



	// $ANTLR start "trailer"
	// PythonPartial.g:799:1: trailer : ( LPAREN ( arglist |) RPAREN | LBRACK subscriptlist RBRACK | DOT attr );
	public final void trailer() throws RecognitionException {
		try {
			// PythonPartial.g:800:5: ( LPAREN ( arglist |) RPAREN | LBRACK subscriptlist RBRACK | DOT attr )
			int alt149=3;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt149=1;
				}
				break;
			case LBRACK:
				{
				alt149=2;
				}
				break;
			case DOT:
				{
				alt149=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 149, 0, input);
				throw nvae;
			}
			switch (alt149) {
				case 1 :
					// PythonPartial.g:800:7: LPAREN ( arglist |) RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_trailer4361); if (state.failed) return;
					// PythonPartial.g:801:9: ( arglist |)
					int alt148=2;
					int LA148_0 = input.LA(1);
					if ( ((LA148_0 >= AWAIT && LA148_0 <= BACKQUOTE)||LA148_0==COMPLEX||LA148_0==DOT||LA148_0==FLOAT||LA148_0==INT||(LA148_0 >= LAMBDA && LA148_0 <= LCURLY)||(LA148_0 >= LONGINT && LA148_0 <= MINUS)||LA148_0==NAME||LA148_0==NOT||LA148_0==PLUS||LA148_0==STAR||(LA148_0 >= STRING && LA148_0 <= TRAILBACKSLASH)||(LA148_0 >= STRINGPART && LA148_0 <= TRISTRINGPART)) ) {
						alt148=1;
					}
					else if ( (LA148_0==RPAREN) ) {
						alt148=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 148, 0, input);
						throw nvae;
					}

					switch (alt148) {
						case 1 :
							// PythonPartial.g:801:10: arglist
							{
							pushFollow(FOLLOW_arglist_in_trailer4372);
							arglist();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:803:9: 
							{
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_trailer4400); if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:805:7: LBRACK subscriptlist RBRACK
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_trailer4408); if (state.failed) return;
					pushFollow(FOLLOW_subscriptlist_in_trailer4410);
					subscriptlist();
					state._fsp--;
					if (state.failed) return;
					match(input,RBRACK,FOLLOW_RBRACK_in_trailer4412); if (state.failed) return;
					}
					break;
				case 3 :
					// PythonPartial.g:806:7: DOT attr
					{
					match(input,DOT,FOLLOW_DOT_in_trailer4420); if (state.failed) return;
					pushFollow(FOLLOW_attr_in_trailer4422);
					attr();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "trailer"



	// $ANTLR start "subscriptlist"
	// PythonPartial.g:810:1: subscriptlist : subscript ( options {greedy=true; } : COMMA subscript )* ( COMMA )? ;
	public final void subscriptlist() throws RecognitionException {
		try {
			// PythonPartial.g:811:5: ( subscript ( options {greedy=true; } : COMMA subscript )* ( COMMA )? )
			// PythonPartial.g:811:7: subscript ( options {greedy=true; } : COMMA subscript )* ( COMMA )?
			{
			pushFollow(FOLLOW_subscript_in_subscriptlist4440);
			subscript();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:811:17: ( options {greedy=true; } : COMMA subscript )*
			loop150:
			while (true) {
				int alt150=2;
				int LA150_0 = input.LA(1);
				if ( (LA150_0==COMMA) ) {
					int LA150_1 = input.LA(2);
					if ( ((LA150_1 >= AWAIT && LA150_1 <= BACKQUOTE)||LA150_1==COLON||LA150_1==COMPLEX||LA150_1==DOT||LA150_1==FLOAT||LA150_1==INT||(LA150_1 >= LAMBDA && LA150_1 <= LCURLY)||(LA150_1 >= LONGINT && LA150_1 <= MINUS)||LA150_1==NAME||LA150_1==NOT||LA150_1==PLUS||(LA150_1 >= STRING && LA150_1 <= TRAILBACKSLASH)||(LA150_1 >= STRINGPART && LA150_1 <= TRISTRINGPART)) ) {
						alt150=1;
					}

				}

				switch (alt150) {
				case 1 :
					// PythonPartial.g:811:41: COMMA subscript
					{
					match(input,COMMA,FOLLOW_COMMA_in_subscriptlist4450); if (state.failed) return;
					pushFollow(FOLLOW_subscript_in_subscriptlist4452);
					subscript();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop150;
				}
			}

			// PythonPartial.g:811:59: ( COMMA )?
			int alt151=2;
			int LA151_0 = input.LA(1);
			if ( (LA151_0==COMMA) ) {
				alt151=1;
			}
			switch (alt151) {
				case 1 :
					// PythonPartial.g:811:60: COMMA
					{
					match(input,COMMA,FOLLOW_COMMA_in_subscriptlist4457); if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "subscriptlist"



	// $ANTLR start "subscript"
	// PythonPartial.g:815:1: subscript : ( ( test COLON )=> test ( COLON ( test )? ( sliceop )? )? | ( COLON )=> COLON ( test )? ( sliceop )? | test );
	public final void subscript() throws RecognitionException {
		try {
			// PythonPartial.g:816:5: ( ( test COLON )=> test ( COLON ( test )? ( sliceop )? )? | ( COLON )=> COLON ( test )? ( sliceop )? | test )
			int alt157=3;
			int LA157_0 = input.LA(1);
			if ( (LA157_0==NOT) ) {
				int LA157_1 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==PLUS) ) {
				int LA157_2 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==MINUS) ) {
				int LA157_3 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==TILDE) ) {
				int LA157_4 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==AWAIT) ) {
				int LA157_5 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==LPAREN) ) {
				int LA157_6 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==LBRACK) ) {
				int LA157_7 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==LCURLY) ) {
				int LA157_8 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==BACKQUOTE) ) {
				int LA157_9 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==NAME) ) {
				int LA157_10 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==INT) ) {
				int LA157_11 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==LONGINT) ) {
				int LA157_12 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==FLOAT) ) {
				int LA157_13 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==COMPLEX) ) {
				int LA157_14 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==DOT) ) {
				int LA157_15 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==STRING) ) {
				int LA157_16 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==TRISTRINGPART) ) {
				int LA157_17 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==STRINGPART) ) {
				int LA157_18 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==TRAILBACKSLASH) ) {
				int LA157_19 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==LAMBDA) ) {
				int LA157_20 = input.LA(2);
				if ( (synpred5_PythonPartial()) ) {
					alt157=1;
				}
				else if ( (true) ) {
					alt157=3;
				}

			}
			else if ( (LA157_0==COLON) && (synpred6_PythonPartial())) {
				alt157=2;
			}

			switch (alt157) {
				case 1 :
					// PythonPartial.g:816:7: ( test COLON )=> test ( COLON ( test )? ( sliceop )? )?
					{
					pushFollow(FOLLOW_test_in_subscript4488);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:817:12: ( COLON ( test )? ( sliceop )? )?
					int alt154=2;
					int LA154_0 = input.LA(1);
					if ( (LA154_0==COLON) ) {
						alt154=1;
					}
					switch (alt154) {
						case 1 :
							// PythonPartial.g:817:13: COLON ( test )? ( sliceop )?
							{
							match(input,COLON,FOLLOW_COLON_in_subscript4491); if (state.failed) return;
							// PythonPartial.g:817:19: ( test )?
							int alt152=2;
							int LA152_0 = input.LA(1);
							if ( ((LA152_0 >= AWAIT && LA152_0 <= BACKQUOTE)||LA152_0==COMPLEX||LA152_0==DOT||LA152_0==FLOAT||LA152_0==INT||(LA152_0 >= LAMBDA && LA152_0 <= LCURLY)||(LA152_0 >= LONGINT && LA152_0 <= MINUS)||LA152_0==NAME||LA152_0==NOT||LA152_0==PLUS||(LA152_0 >= STRING && LA152_0 <= TRAILBACKSLASH)||(LA152_0 >= STRINGPART && LA152_0 <= TRISTRINGPART)) ) {
								alt152=1;
							}
							switch (alt152) {
								case 1 :
									// PythonPartial.g:817:20: test
									{
									pushFollow(FOLLOW_test_in_subscript4494);
									test();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							// PythonPartial.g:817:27: ( sliceop )?
							int alt153=2;
							int LA153_0 = input.LA(1);
							if ( (LA153_0==COLON) ) {
								alt153=1;
							}
							switch (alt153) {
								case 1 :
									// PythonPartial.g:817:28: sliceop
									{
									pushFollow(FOLLOW_sliceop_in_subscript4499);
									sliceop();
									state._fsp--;
									if (state.failed) return;
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:818:7: ( COLON )=> COLON ( test )? ( sliceop )?
					{
					match(input,COLON,FOLLOW_COLON_in_subscript4520); if (state.failed) return;
					// PythonPartial.g:819:13: ( test )?
					int alt155=2;
					int LA155_0 = input.LA(1);
					if ( ((LA155_0 >= AWAIT && LA155_0 <= BACKQUOTE)||LA155_0==COMPLEX||LA155_0==DOT||LA155_0==FLOAT||LA155_0==INT||(LA155_0 >= LAMBDA && LA155_0 <= LCURLY)||(LA155_0 >= LONGINT && LA155_0 <= MINUS)||LA155_0==NAME||LA155_0==NOT||LA155_0==PLUS||(LA155_0 >= STRING && LA155_0 <= TRAILBACKSLASH)||(LA155_0 >= STRINGPART && LA155_0 <= TRISTRINGPART)) ) {
						alt155=1;
					}
					switch (alt155) {
						case 1 :
							// PythonPartial.g:819:14: test
							{
							pushFollow(FOLLOW_test_in_subscript4523);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:819:21: ( sliceop )?
					int alt156=2;
					int LA156_0 = input.LA(1);
					if ( (LA156_0==COLON) ) {
						alt156=1;
					}
					switch (alt156) {
						case 1 :
							// PythonPartial.g:819:22: sliceop
							{
							pushFollow(FOLLOW_sliceop_in_subscript4528);
							sliceop();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 3 :
					// PythonPartial.g:820:7: test
					{
					pushFollow(FOLLOW_test_in_subscript4538);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "subscript"



	// $ANTLR start "sliceop"
	// PythonPartial.g:824:1: sliceop : COLON ( test |) ;
	public final void sliceop() throws RecognitionException {
		try {
			// PythonPartial.g:825:5: ( COLON ( test |) )
			// PythonPartial.g:825:7: COLON ( test |)
			{
			match(input,COLON,FOLLOW_COLON_in_sliceop4556); if (state.failed) return;
			// PythonPartial.g:826:6: ( test |)
			int alt158=2;
			int LA158_0 = input.LA(1);
			if ( ((LA158_0 >= AWAIT && LA158_0 <= BACKQUOTE)||LA158_0==COMPLEX||LA158_0==DOT||LA158_0==FLOAT||LA158_0==INT||(LA158_0 >= LAMBDA && LA158_0 <= LCURLY)||(LA158_0 >= LONGINT && LA158_0 <= MINUS)||LA158_0==NAME||LA158_0==NOT||LA158_0==PLUS||(LA158_0 >= STRING && LA158_0 <= TRAILBACKSLASH)||(LA158_0 >= STRINGPART && LA158_0 <= TRISTRINGPART)) ) {
				alt158=1;
			}
			else if ( (LA158_0==COMMA||LA158_0==RBRACK) ) {
				alt158=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 158, 0, input);
				throw nvae;
			}

			switch (alt158) {
				case 1 :
					// PythonPartial.g:826:7: test
					{
					pushFollow(FOLLOW_test_in_sliceop4564);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:828:6: 
					{
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sliceop"



	// $ANTLR start "exprlist"
	// PythonPartial.g:832:1: exprlist : ( ( expr COMMA )=> expr ( options {k=2; } : COMMA expr )* ( COMMA )? | expr );
	public final void exprlist() throws RecognitionException {
		try {
			// PythonPartial.g:833:5: ( ( expr COMMA )=> expr ( options {k=2; } : COMMA expr )* ( COMMA )? | expr )
			int alt161=2;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				int LA161_1 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case MINUS:
				{
				int LA161_2 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case TILDE:
				{
				int LA161_3 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case AWAIT:
				{
				int LA161_4 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA161_5 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case LBRACK:
				{
				int LA161_6 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case LCURLY:
				{
				int LA161_7 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case BACKQUOTE:
				{
				int LA161_8 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case NAME:
				{
				int LA161_9 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case INT:
				{
				int LA161_10 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case LONGINT:
				{
				int LA161_11 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA161_12 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case COMPLEX:
				{
				int LA161_13 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case DOT:
				{
				int LA161_14 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case STRING:
				{
				int LA161_15 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case TRISTRINGPART:
				{
				int LA161_16 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case STRINGPART:
				{
				int LA161_17 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			case TRAILBACKSLASH:
				{
				int LA161_18 = input.LA(2);
				if ( (synpred7_PythonPartial()) ) {
					alt161=1;
				}
				else if ( (true) ) {
					alt161=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 161, 0, input);
				throw nvae;
			}
			switch (alt161) {
				case 1 :
					// PythonPartial.g:833:7: ( expr COMMA )=> expr ( options {k=2; } : COMMA expr )* ( COMMA )?
					{
					pushFollow(FOLLOW_expr_in_exprlist4604);
					expr();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:833:28: ( options {k=2; } : COMMA expr )*
					loop159:
					while (true) {
						int alt159=2;
						int LA159_0 = input.LA(1);
						if ( (LA159_0==COMMA) ) {
							int LA159_1 = input.LA(2);
							if ( ((LA159_1 >= AWAIT && LA159_1 <= BACKQUOTE)||LA159_1==COMPLEX||LA159_1==DOT||LA159_1==FLOAT||LA159_1==INT||(LA159_1 >= LBRACK && LA159_1 <= LCURLY)||(LA159_1 >= LONGINT && LA159_1 <= MINUS)||LA159_1==NAME||LA159_1==PLUS||(LA159_1 >= STRING && LA159_1 <= TRAILBACKSLASH)||(LA159_1 >= STRINGPART && LA159_1 <= TRISTRINGPART)) ) {
								alt159=1;
							}

						}

						switch (alt159) {
						case 1 :
							// PythonPartial.g:833:45: COMMA expr
							{
							match(input,COMMA,FOLLOW_COMMA_in_exprlist4615); if (state.failed) return;
							pushFollow(FOLLOW_expr_in_exprlist4617);
							expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop159;
						}
					}

					// PythonPartial.g:833:58: ( COMMA )?
					int alt160=2;
					int LA160_0 = input.LA(1);
					if ( (LA160_0==COMMA) ) {
						alt160=1;
					}
					switch (alt160) {
						case 1 :
							// PythonPartial.g:833:59: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_exprlist4622); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:834:7: expr
					{
					pushFollow(FOLLOW_expr_in_exprlist4632);
					expr();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exprlist"



	// $ANTLR start "del_list"
	// PythonPartial.g:839:1: del_list : expr ( options {k=2; } : COMMA expr )* ( COMMA )? ;
	public final void del_list() throws RecognitionException {
		try {
			// PythonPartial.g:840:5: ( expr ( options {k=2; } : COMMA expr )* ( COMMA )? )
			// PythonPartial.g:840:7: expr ( options {k=2; } : COMMA expr )* ( COMMA )?
			{
			pushFollow(FOLLOW_expr_in_del_list4651);
			expr();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:840:12: ( options {k=2; } : COMMA expr )*
			loop162:
			while (true) {
				int alt162=2;
				int LA162_0 = input.LA(1);
				if ( (LA162_0==COMMA) ) {
					int LA162_1 = input.LA(2);
					if ( ((LA162_1 >= AWAIT && LA162_1 <= BACKQUOTE)||LA162_1==COMPLEX||LA162_1==DOT||LA162_1==FLOAT||LA162_1==INT||(LA162_1 >= LBRACK && LA162_1 <= LCURLY)||(LA162_1 >= LONGINT && LA162_1 <= MINUS)||LA162_1==NAME||LA162_1==PLUS||(LA162_1 >= STRING && LA162_1 <= TRAILBACKSLASH)||(LA162_1 >= STRINGPART && LA162_1 <= TRISTRINGPART)) ) {
						alt162=1;
					}

				}

				switch (alt162) {
				case 1 :
					// PythonPartial.g:840:29: COMMA expr
					{
					match(input,COMMA,FOLLOW_COMMA_in_del_list4662); if (state.failed) return;
					pushFollow(FOLLOW_expr_in_del_list4664);
					expr();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop162;
				}
			}

			// PythonPartial.g:840:42: ( COMMA )?
			int alt163=2;
			int LA163_0 = input.LA(1);
			if ( (LA163_0==COMMA) ) {
				alt163=1;
			}
			switch (alt163) {
				case 1 :
					// PythonPartial.g:840:43: COMMA
					{
					match(input,COMMA,FOLLOW_COMMA_in_del_list4669); if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "del_list"



	// $ANTLR start "testlist"
	// PythonPartial.g:844:1: testlist : ( ( test COMMA )=> test ( options {k=2; } : COMMA test )* ( COMMA )? | test );
	public final void testlist() throws RecognitionException {
		try {
			// PythonPartial.g:845:5: ( ( test COMMA )=> test ( options {k=2; } : COMMA test )* ( COMMA )? | test )
			int alt166=2;
			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA166_1 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case PLUS:
				{
				int LA166_2 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case MINUS:
				{
				int LA166_3 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case TILDE:
				{
				int LA166_4 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case AWAIT:
				{
				int LA166_5 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA166_6 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case LBRACK:
				{
				int LA166_7 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case LCURLY:
				{
				int LA166_8 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case BACKQUOTE:
				{
				int LA166_9 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case NAME:
				{
				int LA166_10 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case INT:
				{
				int LA166_11 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case LONGINT:
				{
				int LA166_12 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA166_13 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case COMPLEX:
				{
				int LA166_14 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case DOT:
				{
				int LA166_15 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case STRING:
				{
				int LA166_16 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case TRISTRINGPART:
				{
				int LA166_17 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case STRINGPART:
				{
				int LA166_18 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case TRAILBACKSLASH:
				{
				int LA166_19 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			case LAMBDA:
				{
				int LA166_20 = input.LA(2);
				if ( (synpred8_PythonPartial()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 166, 0, input);
				throw nvae;
			}
			switch (alt166) {
				case 1 :
					// PythonPartial.g:845:7: ( test COMMA )=> test ( options {k=2; } : COMMA test )* ( COMMA )?
					{
					pushFollow(FOLLOW_test_in_testlist4700);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:846:12: ( options {k=2; } : COMMA test )*
					loop164:
					while (true) {
						int alt164=2;
						int LA164_0 = input.LA(1);
						if ( (LA164_0==COMMA) ) {
							int LA164_1 = input.LA(2);
							if ( (LA164_1==BACKQUOTE) ) {
								alt164=1;
							}
							else if ( (LA164_1==AWAIT||LA164_1==COMPLEX||LA164_1==DOT||LA164_1==FLOAT||LA164_1==INT||(LA164_1 >= LAMBDA && LA164_1 <= LCURLY)||(LA164_1 >= LONGINT && LA164_1 <= MINUS)||LA164_1==NAME||LA164_1==NOT||LA164_1==PLUS||(LA164_1 >= STRING && LA164_1 <= TRAILBACKSLASH)||(LA164_1 >= STRINGPART && LA164_1 <= TRISTRINGPART)) ) {
								alt164=1;
							}

						}

						switch (alt164) {
						case 1 :
							// PythonPartial.g:846:29: COMMA test
							{
							match(input,COMMA,FOLLOW_COMMA_in_testlist4711); if (state.failed) return;
							pushFollow(FOLLOW_test_in_testlist4713);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop164;
						}
					}

					// PythonPartial.g:846:42: ( COMMA )?
					int alt165=2;
					int LA165_0 = input.LA(1);
					if ( (LA165_0==COMMA) ) {
						alt165=1;
					}
					switch (alt165) {
						case 1 :
							// PythonPartial.g:846:43: COMMA
							{
							match(input,COMMA,FOLLOW_COMMA_in_testlist4718); if (state.failed) return;
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:847:7: test
					{
					pushFollow(FOLLOW_test_in_testlist4728);
					test();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "testlist"



	// $ANTLR start "dictorsetmaker"
	// PythonPartial.g:854:1: dictorsetmaker : ( ( test COLON | DOUBLESTAR )=> ( test COLON test | DOUBLESTAR expr ) ( comp_for | ( COMMA ( test COLON test | DOUBLESTAR expr ) )* ( COMMA )? ) | ( test | star_expr ) ( comp_for | ( COMMA ( test | star_expr ) )* ( COMMA )? ) );
	public final void dictorsetmaker() throws RecognitionException {
		try {
			// PythonPartial.g:855:5: ( ( test COLON | DOUBLESTAR )=> ( test COLON test | DOUBLESTAR expr ) ( comp_for | ( COMMA ( test COLON test | DOUBLESTAR expr ) )* ( COMMA )? ) | ( test | star_expr ) ( comp_for | ( COMMA ( test | star_expr ) )* ( COMMA )? ) )
			int alt177=2;
			int LA177_0 = input.LA(1);
			if ( (LA177_0==NOT) ) {
				int LA177_1 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==PLUS) ) {
				int LA177_2 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==MINUS) ) {
				int LA177_3 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==TILDE) ) {
				int LA177_4 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==AWAIT) ) {
				int LA177_5 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==LPAREN) ) {
				int LA177_6 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==LBRACK) ) {
				int LA177_7 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==LCURLY) ) {
				int LA177_8 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==BACKQUOTE) ) {
				int LA177_9 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==NAME) ) {
				int LA177_10 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==INT) ) {
				int LA177_11 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==LONGINT) ) {
				int LA177_12 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==FLOAT) ) {
				int LA177_13 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==COMPLEX) ) {
				int LA177_14 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==DOT) ) {
				int LA177_15 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==STRING) ) {
				int LA177_16 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==TRISTRINGPART) ) {
				int LA177_17 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==STRINGPART) ) {
				int LA177_18 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==TRAILBACKSLASH) ) {
				int LA177_19 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==LAMBDA) ) {
				int LA177_20 = input.LA(2);
				if ( (synpred9_PythonPartial()) ) {
					alt177=1;
				}
				else if ( (true) ) {
					alt177=2;
				}

			}
			else if ( (LA177_0==DOUBLESTAR) && (synpred9_PythonPartial())) {
				alt177=1;
			}
			else if ( (LA177_0==STAR) ) {
				alt177=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 177, 0, input);
				throw nvae;
			}

			switch (alt177) {
				case 1 :
					// PythonPartial.g:855:7: ( test COLON | DOUBLESTAR )=> ( test COLON test | DOUBLESTAR expr ) ( comp_for | ( COMMA ( test COLON test | DOUBLESTAR expr ) )* ( COMMA )? )
					{
					// PythonPartial.g:855:36: ( test COLON test | DOUBLESTAR expr )
					int alt167=2;
					int LA167_0 = input.LA(1);
					if ( ((LA167_0 >= AWAIT && LA167_0 <= BACKQUOTE)||LA167_0==COMPLEX||LA167_0==DOT||LA167_0==FLOAT||LA167_0==INT||(LA167_0 >= LAMBDA && LA167_0 <= LCURLY)||(LA167_0 >= LONGINT && LA167_0 <= MINUS)||LA167_0==NAME||LA167_0==NOT||LA167_0==PLUS||(LA167_0 >= STRING && LA167_0 <= TRAILBACKSLASH)||(LA167_0 >= STRINGPART && LA167_0 <= TRISTRINGPART)) ) {
						alt167=1;
					}
					else if ( (LA167_0==DOUBLESTAR) ) {
						alt167=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 167, 0, input);
						throw nvae;
					}

					switch (alt167) {
						case 1 :
							// PythonPartial.g:855:37: test COLON test
							{
							pushFollow(FOLLOW_test_in_dictorsetmaker4762);
							test();
							state._fsp--;
							if (state.failed) return;
							match(input,COLON,FOLLOW_COLON_in_dictorsetmaker4764); if (state.failed) return;
							pushFollow(FOLLOW_test_in_dictorsetmaker4766);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:855:55: DOUBLESTAR expr
							{
							match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_dictorsetmaker4770); if (state.failed) return;
							pushFollow(FOLLOW_expr_in_dictorsetmaker4772);
							expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:856:10: ( comp_for | ( COMMA ( test COLON test | DOUBLESTAR expr ) )* ( COMMA )? )
					int alt171=2;
					int LA171_0 = input.LA(1);
					if ( (LA171_0==FOR) ) {
						alt171=1;
					}
					else if ( (LA171_0==COMMA||LA171_0==RCURLY) ) {
						alt171=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 171, 0, input);
						throw nvae;
					}

					switch (alt171) {
						case 1 :
							// PythonPartial.g:856:11: comp_for
							{
							pushFollow(FOLLOW_comp_for_in_dictorsetmaker4785);
							comp_for();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:857:12: ( COMMA ( test COLON test | DOUBLESTAR expr ) )* ( COMMA )?
							{
							// PythonPartial.g:857:12: ( COMMA ( test COLON test | DOUBLESTAR expr ) )*
							loop169:
							while (true) {
								int alt169=2;
								int LA169_0 = input.LA(1);
								if ( (LA169_0==COMMA) ) {
									int LA169_1 = input.LA(2);
									if ( ((LA169_1 >= AWAIT && LA169_1 <= BACKQUOTE)||LA169_1==COMPLEX||LA169_1==DOT||LA169_1==DOUBLESTAR||LA169_1==FLOAT||LA169_1==INT||(LA169_1 >= LAMBDA && LA169_1 <= LCURLY)||(LA169_1 >= LONGINT && LA169_1 <= MINUS)||LA169_1==NAME||LA169_1==NOT||LA169_1==PLUS||(LA169_1 >= STRING && LA169_1 <= TRAILBACKSLASH)||(LA169_1 >= STRINGPART && LA169_1 <= TRISTRINGPART)) ) {
										alt169=1;
									}

								}

								switch (alt169) {
								case 1 :
									// PythonPartial.g:857:13: COMMA ( test COLON test | DOUBLESTAR expr )
									{
									match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker4799); if (state.failed) return;
									// PythonPartial.g:857:19: ( test COLON test | DOUBLESTAR expr )
									int alt168=2;
									int LA168_0 = input.LA(1);
									if ( ((LA168_0 >= AWAIT && LA168_0 <= BACKQUOTE)||LA168_0==COMPLEX||LA168_0==DOT||LA168_0==FLOAT||LA168_0==INT||(LA168_0 >= LAMBDA && LA168_0 <= LCURLY)||(LA168_0 >= LONGINT && LA168_0 <= MINUS)||LA168_0==NAME||LA168_0==NOT||LA168_0==PLUS||(LA168_0 >= STRING && LA168_0 <= TRAILBACKSLASH)||(LA168_0 >= STRINGPART && LA168_0 <= TRISTRINGPART)) ) {
										alt168=1;
									}
									else if ( (LA168_0==DOUBLESTAR) ) {
										alt168=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return;}
										NoViableAltException nvae =
											new NoViableAltException("", 168, 0, input);
										throw nvae;
									}

									switch (alt168) {
										case 1 :
											// PythonPartial.g:857:20: test COLON test
											{
											pushFollow(FOLLOW_test_in_dictorsetmaker4802);
											test();
											state._fsp--;
											if (state.failed) return;
											match(input,COLON,FOLLOW_COLON_in_dictorsetmaker4804); if (state.failed) return;
											pushFollow(FOLLOW_test_in_dictorsetmaker4806);
											test();
											state._fsp--;
											if (state.failed) return;
											}
											break;
										case 2 :
											// PythonPartial.g:857:38: DOUBLESTAR expr
											{
											match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_dictorsetmaker4810); if (state.failed) return;
											pushFollow(FOLLOW_expr_in_dictorsetmaker4812);
											expr();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									}
									break;

								default :
									break loop169;
								}
							}

							// PythonPartial.g:857:57: ( COMMA )?
							int alt170=2;
							int LA170_0 = input.LA(1);
							if ( (LA170_0==COMMA) ) {
								alt170=1;
							}
							switch (alt170) {
								case 1 :
									// PythonPartial.g:857:58: COMMA
									{
									match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker4818); if (state.failed) return;
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:858:7: ( test | star_expr ) ( comp_for | ( COMMA ( test | star_expr ) )* ( COMMA )? )
					{
					// PythonPartial.g:858:7: ( test | star_expr )
					int alt172=2;
					int LA172_0 = input.LA(1);
					if ( ((LA172_0 >= AWAIT && LA172_0 <= BACKQUOTE)||LA172_0==COMPLEX||LA172_0==DOT||LA172_0==FLOAT||LA172_0==INT||(LA172_0 >= LAMBDA && LA172_0 <= LCURLY)||(LA172_0 >= LONGINT && LA172_0 <= MINUS)||LA172_0==NAME||LA172_0==NOT||LA172_0==PLUS||(LA172_0 >= STRING && LA172_0 <= TRAILBACKSLASH)||(LA172_0 >= STRINGPART && LA172_0 <= TRISTRINGPART)) ) {
						alt172=1;
					}
					else if ( (LA172_0==STAR) ) {
						alt172=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 172, 0, input);
						throw nvae;
					}

					switch (alt172) {
						case 1 :
							// PythonPartial.g:858:8: test
							{
							pushFollow(FOLLOW_test_in_dictorsetmaker4830);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:858:15: star_expr
							{
							pushFollow(FOLLOW_star_expr_in_dictorsetmaker4834);
							star_expr();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					// PythonPartial.g:859:10: ( comp_for | ( COMMA ( test | star_expr ) )* ( COMMA )? )
					int alt176=2;
					int LA176_0 = input.LA(1);
					if ( (LA176_0==FOR) ) {
						alt176=1;
					}
					else if ( (LA176_0==COMMA||LA176_0==RCURLY) ) {
						alt176=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 176, 0, input);
						throw nvae;
					}

					switch (alt176) {
						case 1 :
							// PythonPartial.g:859:11: comp_for
							{
							pushFollow(FOLLOW_comp_for_in_dictorsetmaker4847);
							comp_for();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:860:12: ( COMMA ( test | star_expr ) )* ( COMMA )?
							{
							// PythonPartial.g:860:12: ( COMMA ( test | star_expr ) )*
							loop174:
							while (true) {
								int alt174=2;
								int LA174_0 = input.LA(1);
								if ( (LA174_0==COMMA) ) {
									int LA174_1 = input.LA(2);
									if ( ((LA174_1 >= AWAIT && LA174_1 <= BACKQUOTE)||LA174_1==COMPLEX||LA174_1==DOT||LA174_1==FLOAT||LA174_1==INT||(LA174_1 >= LAMBDA && LA174_1 <= LCURLY)||(LA174_1 >= LONGINT && LA174_1 <= MINUS)||LA174_1==NAME||LA174_1==NOT||LA174_1==PLUS||LA174_1==STAR||(LA174_1 >= STRING && LA174_1 <= TRAILBACKSLASH)||(LA174_1 >= STRINGPART && LA174_1 <= TRISTRINGPART)) ) {
										alt174=1;
									}

								}

								switch (alt174) {
								case 1 :
									// PythonPartial.g:860:13: COMMA ( test | star_expr )
									{
									match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker4861); if (state.failed) return;
									// PythonPartial.g:860:19: ( test | star_expr )
									int alt173=2;
									int LA173_0 = input.LA(1);
									if ( ((LA173_0 >= AWAIT && LA173_0 <= BACKQUOTE)||LA173_0==COMPLEX||LA173_0==DOT||LA173_0==FLOAT||LA173_0==INT||(LA173_0 >= LAMBDA && LA173_0 <= LCURLY)||(LA173_0 >= LONGINT && LA173_0 <= MINUS)||LA173_0==NAME||LA173_0==NOT||LA173_0==PLUS||(LA173_0 >= STRING && LA173_0 <= TRAILBACKSLASH)||(LA173_0 >= STRINGPART && LA173_0 <= TRISTRINGPART)) ) {
										alt173=1;
									}
									else if ( (LA173_0==STAR) ) {
										alt173=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return;}
										NoViableAltException nvae =
											new NoViableAltException("", 173, 0, input);
										throw nvae;
									}

									switch (alt173) {
										case 1 :
											// PythonPartial.g:860:20: test
											{
											pushFollow(FOLLOW_test_in_dictorsetmaker4864);
											test();
											state._fsp--;
											if (state.failed) return;
											}
											break;
										case 2 :
											// PythonPartial.g:860:27: star_expr
											{
											pushFollow(FOLLOW_star_expr_in_dictorsetmaker4868);
											star_expr();
											state._fsp--;
											if (state.failed) return;
											}
											break;

									}

									}
									break;

								default :
									break loop174;
								}
							}

							// PythonPartial.g:860:40: ( COMMA )?
							int alt175=2;
							int LA175_0 = input.LA(1);
							if ( (LA175_0==COMMA) ) {
								alt175=1;
							}
							switch (alt175) {
								case 1 :
									// PythonPartial.g:860:41: COMMA
									{
									match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker4874); if (state.failed) return;
									}
									break;

							}

							}
							break;

					}

					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dictorsetmaker"



	// $ANTLR start "classdef"
	// PythonPartial.g:864:1: classdef : CLASS NAME ( LPAREN ( arglist )? RPAREN )? COLON suite ;
	public final void classdef() throws RecognitionException {
		try {
			// PythonPartial.g:865:5: ( CLASS NAME ( LPAREN ( arglist )? RPAREN )? COLON suite )
			// PythonPartial.g:865:7: CLASS NAME ( LPAREN ( arglist )? RPAREN )? COLON suite
			{
			match(input,CLASS,FOLLOW_CLASS_in_classdef4895); if (state.failed) return;
			match(input,NAME,FOLLOW_NAME_in_classdef4897); if (state.failed) return;
			// PythonPartial.g:865:18: ( LPAREN ( arglist )? RPAREN )?
			int alt179=2;
			int LA179_0 = input.LA(1);
			if ( (LA179_0==LPAREN) ) {
				alt179=1;
			}
			switch (alt179) {
				case 1 :
					// PythonPartial.g:865:19: LPAREN ( arglist )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_classdef4900); if (state.failed) return;
					// PythonPartial.g:865:26: ( arglist )?
					int alt178=2;
					int LA178_0 = input.LA(1);
					if ( ((LA178_0 >= AWAIT && LA178_0 <= BACKQUOTE)||LA178_0==COMPLEX||LA178_0==DOT||LA178_0==FLOAT||LA178_0==INT||(LA178_0 >= LAMBDA && LA178_0 <= LCURLY)||(LA178_0 >= LONGINT && LA178_0 <= MINUS)||LA178_0==NAME||LA178_0==NOT||LA178_0==PLUS||LA178_0==STAR||(LA178_0 >= STRING && LA178_0 <= TRAILBACKSLASH)||(LA178_0 >= STRINGPART && LA178_0 <= TRISTRINGPART)) ) {
						alt178=1;
					}
					switch (alt178) {
						case 1 :
							// PythonPartial.g:865:26: arglist
							{
							pushFollow(FOLLOW_arglist_in_classdef4902);
							arglist();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_classdef4905); if (state.failed) return;
					}
					break;

			}

			match(input,COLON,FOLLOW_COLON_in_classdef4909); if (state.failed) return;
			pushFollow(FOLLOW_suite_in_classdef4911);
			suite();
			state._fsp--;
			if (state.failed) return;
			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "classdef"



	// $ANTLR start "arglist"
	// PythonPartial.g:869:1: arglist : argument ( COMMA argument )* ( COMMA )? ;
	public final void arglist() throws RecognitionException {
		try {
			// PythonPartial.g:869:9: ( argument ( COMMA argument )* ( COMMA )? )
			// PythonPartial.g:869:11: argument ( COMMA argument )* ( COMMA )?
			{
			pushFollow(FOLLOW_argument_in_arglist4925);
			argument();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:869:20: ( COMMA argument )*
			loop180:
			while (true) {
				int alt180=2;
				int LA180_0 = input.LA(1);
				if ( (LA180_0==COMMA) ) {
					int LA180_1 = input.LA(2);
					if ( ((LA180_1 >= AWAIT && LA180_1 <= BACKQUOTE)||LA180_1==COMPLEX||LA180_1==DOT||LA180_1==FLOAT||LA180_1==INT||(LA180_1 >= LAMBDA && LA180_1 <= LCURLY)||(LA180_1 >= LONGINT && LA180_1 <= MINUS)||LA180_1==NAME||LA180_1==NOT||LA180_1==PLUS||LA180_1==STAR||(LA180_1 >= STRING && LA180_1 <= TRAILBACKSLASH)||(LA180_1 >= STRINGPART && LA180_1 <= TRISTRINGPART)) ) {
						alt180=1;
					}

				}

				switch (alt180) {
				case 1 :
					// PythonPartial.g:869:21: COMMA argument
					{
					match(input,COMMA,FOLLOW_COMMA_in_arglist4928); if (state.failed) return;
					pushFollow(FOLLOW_argument_in_arglist4930);
					argument();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop180;
				}
			}

			// PythonPartial.g:869:38: ( COMMA )?
			int alt181=2;
			int LA181_0 = input.LA(1);
			if ( (LA181_0==COMMA) ) {
				alt181=1;
			}
			switch (alt181) {
				case 1 :
					// PythonPartial.g:869:38: COMMA
					{
					match(input,COMMA,FOLLOW_COMMA_in_arglist4934); if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arglist"



	// $ANTLR start "argument"
	// PythonPartial.g:875:1: argument : ( test ( comp_for | ASSIGN test |) | STAR ( STAR test | test ) );
	public final void argument() throws RecognitionException {
		try {
			// PythonPartial.g:876:5: ( test ( comp_for | ASSIGN test |) | STAR ( STAR test | test ) )
			int alt184=2;
			int LA184_0 = input.LA(1);
			if ( ((LA184_0 >= AWAIT && LA184_0 <= BACKQUOTE)||LA184_0==COMPLEX||LA184_0==DOT||LA184_0==FLOAT||LA184_0==INT||(LA184_0 >= LAMBDA && LA184_0 <= LCURLY)||(LA184_0 >= LONGINT && LA184_0 <= MINUS)||LA184_0==NAME||LA184_0==NOT||LA184_0==PLUS||(LA184_0 >= STRING && LA184_0 <= TRAILBACKSLASH)||(LA184_0 >= STRINGPART && LA184_0 <= TRISTRINGPART)) ) {
				alt184=1;
			}
			else if ( (LA184_0==STAR) ) {
				alt184=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 184, 0, input);
				throw nvae;
			}

			switch (alt184) {
				case 1 :
					// PythonPartial.g:876:7: test ( comp_for | ASSIGN test |)
					{
					pushFollow(FOLLOW_test_in_argument4952);
					test();
					state._fsp--;
					if (state.failed) return;
					// PythonPartial.g:877:7: ( comp_for | ASSIGN test |)
					int alt182=3;
					switch ( input.LA(1) ) {
					case FOR:
						{
						alt182=1;
						}
						break;
					case ASSIGN:
						{
						alt182=2;
						}
						break;
					case COMMA:
					case RPAREN:
						{
						alt182=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 182, 0, input);
						throw nvae;
					}
					switch (alt182) {
						case 1 :
							// PythonPartial.g:877:8: comp_for
							{
							pushFollow(FOLLOW_comp_for_in_argument4961);
							comp_for();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:878:8: ASSIGN test
							{
							match(input,ASSIGN,FOLLOW_ASSIGN_in_argument4970); if (state.failed) return;
							pushFollow(FOLLOW_test_in_argument4972);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 3 :
							// PythonPartial.g:880:7: 
							{
							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:881:7: STAR ( STAR test | test )
					{
					match(input,STAR,FOLLOW_STAR_in_argument4996); if (state.failed) return;
					// PythonPartial.g:882:7: ( STAR test | test )
					int alt183=2;
					int LA183_0 = input.LA(1);
					if ( (LA183_0==STAR) ) {
						alt183=1;
					}
					else if ( ((LA183_0 >= AWAIT && LA183_0 <= BACKQUOTE)||LA183_0==COMPLEX||LA183_0==DOT||LA183_0==FLOAT||LA183_0==INT||(LA183_0 >= LAMBDA && LA183_0 <= LCURLY)||(LA183_0 >= LONGINT && LA183_0 <= MINUS)||LA183_0==NAME||LA183_0==NOT||LA183_0==PLUS||(LA183_0 >= STRING && LA183_0 <= TRAILBACKSLASH)||(LA183_0 >= STRINGPART && LA183_0 <= TRISTRINGPART)) ) {
						alt183=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 183, 0, input);
						throw nvae;
					}

					switch (alt183) {
						case 1 :
							// PythonPartial.g:882:9: STAR test
							{
							match(input,STAR,FOLLOW_STAR_in_argument5006); if (state.failed) return;
							pushFollow(FOLLOW_test_in_argument5008);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							// PythonPartial.g:883:9: test
							{
							pushFollow(FOLLOW_test_in_argument5018);
							test();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "argument"



	// $ANTLR start "comp_iter"
	// PythonPartial.g:887:1: comp_iter : ( comp_for | comp_if );
	public final void comp_iter() throws RecognitionException {
		try {
			// PythonPartial.g:888:5: ( comp_for | comp_if )
			int alt185=2;
			int LA185_0 = input.LA(1);
			if ( (LA185_0==FOR) ) {
				alt185=1;
			}
			else if ( (LA185_0==IF) ) {
				alt185=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 185, 0, input);
				throw nvae;
			}

			switch (alt185) {
				case 1 :
					// PythonPartial.g:888:7: comp_for
					{
					pushFollow(FOLLOW_comp_for_in_comp_iter5037);
					comp_for();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// PythonPartial.g:889:7: comp_if
					{
					pushFollow(FOLLOW_comp_if_in_comp_iter5045);
					comp_if();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comp_iter"



	// $ANTLR start "comp_for"
	// PythonPartial.g:893:1: comp_for : FOR exprlist IN or_test ( comp_iter )? ;
	public final void comp_for() throws RecognitionException {
		try {
			// PythonPartial.g:894:5: ( FOR exprlist IN or_test ( comp_iter )? )
			// PythonPartial.g:894:7: FOR exprlist IN or_test ( comp_iter )?
			{
			match(input,FOR,FOLLOW_FOR_in_comp_for5063); if (state.failed) return;
			pushFollow(FOLLOW_exprlist_in_comp_for5065);
			exprlist();
			state._fsp--;
			if (state.failed) return;
			match(input,IN,FOLLOW_IN_in_comp_for5067); if (state.failed) return;
			pushFollow(FOLLOW_or_test_in_comp_for5069);
			or_test();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:894:31: ( comp_iter )?
			int alt186=2;
			int LA186_0 = input.LA(1);
			if ( (LA186_0==FOR||LA186_0==IF) ) {
				alt186=1;
			}
			switch (alt186) {
				case 1 :
					// PythonPartial.g:894:31: comp_iter
					{
					pushFollow(FOLLOW_comp_iter_in_comp_for5071);
					comp_iter();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comp_for"



	// $ANTLR start "comp_if"
	// PythonPartial.g:898:1: comp_if : IF test ( comp_iter )? ;
	public final void comp_if() throws RecognitionException {
		try {
			// PythonPartial.g:899:5: ( IF test ( comp_iter )? )
			// PythonPartial.g:899:7: IF test ( comp_iter )?
			{
			match(input,IF,FOLLOW_IF_in_comp_if5090); if (state.failed) return;
			pushFollow(FOLLOW_test_in_comp_if5092);
			test();
			state._fsp--;
			if (state.failed) return;
			// PythonPartial.g:899:15: ( comp_iter )?
			int alt187=2;
			int LA187_0 = input.LA(1);
			if ( (LA187_0==FOR||LA187_0==IF) ) {
				alt187=1;
			}
			switch (alt187) {
				case 1 :
					// PythonPartial.g:899:15: comp_iter
					{
					pushFollow(FOLLOW_comp_iter_in_comp_if5094);
					comp_iter();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comp_if"



	// $ANTLR start "yield_expr"
	// PythonPartial.g:903:1: yield_expr : YIELD ( testlist )? ;
	public final void yield_expr() throws RecognitionException {
		try {
			// PythonPartial.g:904:5: ( YIELD ( testlist )? )
			// PythonPartial.g:904:7: YIELD ( testlist )?
			{
			match(input,YIELD,FOLLOW_YIELD_in_yield_expr5113); if (state.failed) return;
			// PythonPartial.g:904:13: ( testlist )?
			int alt188=2;
			int LA188_0 = input.LA(1);
			if ( ((LA188_0 >= AWAIT && LA188_0 <= BACKQUOTE)||LA188_0==COMPLEX||LA188_0==DOT||LA188_0==FLOAT||LA188_0==INT||(LA188_0 >= LAMBDA && LA188_0 <= LCURLY)||(LA188_0 >= LONGINT && LA188_0 <= MINUS)||LA188_0==NAME||LA188_0==NOT||LA188_0==PLUS||(LA188_0 >= STRING && LA188_0 <= TRAILBACKSLASH)||(LA188_0 >= STRINGPART && LA188_0 <= TRISTRINGPART)) ) {
				alt188=1;
			}
			switch (alt188) {
				case 1 :
					// PythonPartial.g:904:13: testlist
					{
					pushFollow(FOLLOW_testlist_in_yield_expr5115);
					testlist();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {
		    throw e;
		}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "yield_expr"

	// $ANTLR start synpred1_PythonPartial
	public final void synpred1_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:353:8: ( testlist augassign )
		// PythonPartial.g:353:9: testlist augassign
		{
		pushFollow(FOLLOW_testlist_in_synpred1_PythonPartial1316);
		testlist();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_augassign_in_synpred1_PythonPartial1318);
		augassign();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_PythonPartial

	// $ANTLR start synpred2_PythonPartial
	public final void synpred2_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:359:7: ( testlist ASSIGN )
		// PythonPartial.g:359:8: testlist ASSIGN
		{
		pushFollow(FOLLOW_testlist_in_synpred2_PythonPartial1396);
		testlist();
		state._fsp--;
		if (state.failed) return;
		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred2_PythonPartial1398); if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_PythonPartial

	// $ANTLR start synpred3_PythonPartial
	public final void synpred3_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:399:7: ( test COMMA )
		// PythonPartial.g:399:8: test COMMA
		{
		pushFollow(FOLLOW_test_in_synpred3_PythonPartial1681);
		test();
		state._fsp--;
		if (state.failed) return;
		match(input,COMMA,FOLLOW_COMMA_in_synpred3_PythonPartial1683); if (state.failed) return;
		}

	}
	// $ANTLR end synpred3_PythonPartial

	// $ANTLR start synpred4_PythonPartial
	public final void synpred4_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:603:9: ( IF or_test ORELSE )
		// PythonPartial.g:603:10: IF or_test ORELSE
		{
		match(input,IF,FOLLOW_IF_in_synpred4_PythonPartial2962); if (state.failed) return;
		pushFollow(FOLLOW_or_test_in_synpred4_PythonPartial2964);
		or_test();
		state._fsp--;
		if (state.failed) return;
		match(input,ORELSE,FOLLOW_ORELSE_in_synpred4_PythonPartial2966); if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_PythonPartial

	// $ANTLR start synpred5_PythonPartial
	public final void synpred5_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:816:7: ( test COLON )
		// PythonPartial.g:816:8: test COLON
		{
		pushFollow(FOLLOW_test_in_synpred5_PythonPartial4478);
		test();
		state._fsp--;
		if (state.failed) return;
		match(input,COLON,FOLLOW_COLON_in_synpred5_PythonPartial4480); if (state.failed) return;
		}

	}
	// $ANTLR end synpred5_PythonPartial

	// $ANTLR start synpred6_PythonPartial
	public final void synpred6_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:818:7: ( COLON )
		// PythonPartial.g:818:8: COLON
		{
		match(input,COLON,FOLLOW_COLON_in_synpred6_PythonPartial4512); if (state.failed) return;
		}

	}
	// $ANTLR end synpred6_PythonPartial

	// $ANTLR start synpred7_PythonPartial
	public final void synpred7_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:833:7: ( expr COMMA )
		// PythonPartial.g:833:8: expr COMMA
		{
		pushFollow(FOLLOW_expr_in_synpred7_PythonPartial4597);
		expr();
		state._fsp--;
		if (state.failed) return;
		match(input,COMMA,FOLLOW_COMMA_in_synpred7_PythonPartial4599); if (state.failed) return;
		}

	}
	// $ANTLR end synpred7_PythonPartial

	// $ANTLR start synpred8_PythonPartial
	public final void synpred8_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:845:7: ( test COMMA )
		// PythonPartial.g:845:8: test COMMA
		{
		pushFollow(FOLLOW_test_in_synpred8_PythonPartial4690);
		test();
		state._fsp--;
		if (state.failed) return;
		match(input,COMMA,FOLLOW_COMMA_in_synpred8_PythonPartial4692); if (state.failed) return;
		}

	}
	// $ANTLR end synpred8_PythonPartial

	// $ANTLR start synpred9_PythonPartial
	public final void synpred9_PythonPartial_fragment() throws RecognitionException {
		// PythonPartial.g:855:7: ( test COLON | DOUBLESTAR )
		int alt189=2;
		int LA189_0 = input.LA(1);
		if ( ((LA189_0 >= AWAIT && LA189_0 <= BACKQUOTE)||LA189_0==COMPLEX||LA189_0==DOT||LA189_0==FLOAT||LA189_0==INT||(LA189_0 >= LAMBDA && LA189_0 <= LCURLY)||(LA189_0 >= LONGINT && LA189_0 <= MINUS)||LA189_0==NAME||LA189_0==NOT||LA189_0==PLUS||(LA189_0 >= STRING && LA189_0 <= TRAILBACKSLASH)||(LA189_0 >= STRINGPART && LA189_0 <= TRISTRINGPART)) ) {
			alt189=1;
		}
		else if ( (LA189_0==DOUBLESTAR) ) {
			alt189=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 189, 0, input);
			throw nvae;
		}

		switch (alt189) {
			case 1 :
				// PythonPartial.g:855:8: test COLON
				{
				pushFollow(FOLLOW_test_in_synpred9_PythonPartial4750);
				test();
				state._fsp--;
				if (state.failed) return;
				match(input,COLON,FOLLOW_COLON_in_synpred9_PythonPartial4752); if (state.failed) return;
				}
				break;
			case 2 :
				// PythonPartial.g:855:21: DOUBLESTAR
				{
				match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_synpred9_PythonPartial4756); if (state.failed) return;
				}
				break;

		}
	}
	// $ANTLR end synpred9_PythonPartial

	// Delegated rules

	public final boolean synpred3_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_PythonPartial() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_PythonPartial_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA76 dfa76 = new DFA76(this);
	static final String DFA76_eotS =
		"\4\uffff";
	static final String DFA76_eofS =
		"\4\uffff";
	static final String DFA76_minS =
		"\2\37\2\uffff";
	static final String DFA76_maxS =
		"\2\104\2\uffff";
	static final String DFA76_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA76_specialS =
		"\4\uffff}>";
	static final String[] DFA76_transitionS = {
			"\1\1\44\uffff\1\2",
			"\1\1\22\uffff\1\3\21\uffff\1\2",
			"",
			""
	};

	static final short[] DFA76_eot = DFA.unpackEncodedString(DFA76_eotS);
	static final short[] DFA76_eof = DFA.unpackEncodedString(DFA76_eofS);
	static final char[] DFA76_min = DFA.unpackEncodedStringToUnsignedChars(DFA76_minS);
	static final char[] DFA76_max = DFA.unpackEncodedStringToUnsignedChars(DFA76_maxS);
	static final short[] DFA76_accept = DFA.unpackEncodedString(DFA76_acceptS);
	static final short[] DFA76_special = DFA.unpackEncodedString(DFA76_specialS);
	static final short[][] DFA76_transition;

	static {
		int numStates = DFA76_transitionS.length;
		DFA76_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA76_transition[i] = DFA.unpackEncodedString(DFA76_transitionS[i]);
		}
	}

	protected class DFA76 extends DFA {

		public DFA76(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 76;
			this.eot = DFA76_eot;
			this.eof = DFA76_eof;
			this.min = DFA76_min;
			this.max = DFA76_max;
			this.accept = DFA76_accept;
			this.special = DFA76_special;
			this.transition = DFA76_transition;
		}
		@Override
		public String getDescription() {
			return "466:12: ( ( DOT )* dotted_name | ( DOT )+ )";
		}
	}

	public static final BitSet FOLLOW_NEWLINE_in_single_input72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_stmt_in_single_input80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_stmt_in_single_input88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_single_input90 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_single_input93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEADING_WS_in_eval_input111 = new BitSet(new long[]{0x03A0080081018000L,0x00000600700040B7L});
	public static final BitSet FOLLOW_NEWLINE_in_eval_input115 = new BitSet(new long[]{0x03A0080081018000L,0x00000600700040B7L});
	public static final BitSet FOLLOW_testlist_in_eval_input119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_eval_input123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_EOF_in_eval_input127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_dotted_attr145 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_DOT_in_dotted_attr156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_dotted_attr158 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_AT_in_decorator464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_attr_in_decorator466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_LPAREN_in_decorator474 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074404097L});
	public static final BitSet FOLLOW_arglist_in_decorator484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_decorator508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_decorator522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decorator_in_decorators540 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_decorators_in_decorated559 = new BitSet(new long[]{0x0000000010101000L});
	public static final BitSet FOLLOW_classdef_in_decorated562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcdef_in_decorated566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_async_funcdef_in_decorated570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASYNC_in_async_funcdef589 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_funcdef_in_async_funcdef591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEF_in_funcdef609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_funcdef611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_parameters_in_funcdef613 = new BitSet(new long[]{0x0000000000200100L});
	public static final BitSet FOLLOW_ARROW_in_funcdef616 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_funcdef618 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_funcdef622 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_funcdef624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_parameters642 = new BitSet(new long[]{0x0000000400000000L,0x0000000004400010L});
	public static final BitSet FOLLOW_typedargslist_in_parameters651 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_parameters675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist699 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_typedargslist702 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_typedargslist704 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist711 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_typedargslist714 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_typedargslist716 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist731 = new BitSet(new long[]{0x0000000400000002L,0x0000000004000000L});
	public static final BitSet FOLLOW_STAR_in_typedargslist735 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist737 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist743 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_typedargslist746 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_typedargslist748 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist755 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist760 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist786 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist788 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_typedargslist806 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist808 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist814 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_typedargslist817 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_typedargslist819 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist826 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist829 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist831 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist851 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_tfpdef873 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_COLON_in_tfpdef876 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_tfpdef878 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist901 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_varargslist904 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_varargslist906 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist911 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist913 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_varargslist916 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_varargslist918 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist933 = new BitSet(new long[]{0x0000000400000002L,0x0000000004000000L});
	public static final BitSet FOLLOW_STAR_in_varargslist937 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist939 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist945 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_varargslist948 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_varargslist950 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist957 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist960 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist962 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist988 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist990 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_varargslist1008 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1010 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1014 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1016 = new BitSet(new long[]{0x0000000000400802L});
	public static final BitSet FOLLOW_ASSIGN_in_varargslist1019 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_varargslist1021 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1028 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1033 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1053 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_vfpdef1075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_stmt_in_stmt1089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_stmt_in_stmt1097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_small_stmt_in_simple_stmt1115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800020L});
	public static final BitSet FOLLOW_SEMI_in_simple_stmt1125 = new BitSet(new long[]{0x03A46900A3038400L,0x0000078070094897L});
	public static final BitSet FOLLOW_small_stmt_in_simple_stmt1127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800020L});
	public static final BitSet FOLLOW_SEMI_in_simple_stmt1132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_set_in_simple_stmt1136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_stmt_in_small_stmt1155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_stmt_in_small_stmt1170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_del_stmt_in_small_stmt1185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pass_stmt_in_small_stmt1200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_flow_stmt_in_small_stmt1215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_stmt_in_small_stmt1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_global_stmt_in_small_stmt1245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exec_stmt_in_small_stmt1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assert_stmt_in_small_stmt1275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_star_expr1296 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_star_expr1298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_in_expr_stmt1323 = new BitSet(new long[]{0x1000000A00080040L,0x000000080A20A008L});
	public static final BitSet FOLLOW_augassign_in_expr_stmt1336 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_yield_expr_in_expr_stmt1338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_augassign_in_expr_stmt1363 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_testlist_in_expr_stmt1365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_in_expr_stmt1403 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASSIGN_in_expr_stmt1427 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_testlist_in_expr_stmt1429 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASSIGN_in_expr_stmt1457 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_yield_expr_in_expr_stmt1459 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_testlist_in_expr_stmt1491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_print_stmt1623 = new BitSet(new long[]{0x03A0080081018002L,0x0000060070104097L});
	public static final BitSet FOLLOW_printlist_in_print_stmt1632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHTSHIFT_in_print_stmt1642 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_printlist_in_print_stmt1644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_printlist1695 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_printlist1706 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_printlist1708 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_printlist1722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_printlist1732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_del_stmt1750 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_exprlist_in_del_stmt1752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PASS_in_pass_stmt1770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_break_stmt_in_flow_stmt1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_continue_stmt_in_flow_stmt1796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_return_stmt_in_flow_stmt1804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_raise_stmt_in_flow_stmt1812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_yield_stmt_in_flow_stmt1820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_break_stmt1838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONTINUE_in_continue_stmt1856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_return_stmt1874 = new BitSet(new long[]{0x03A0080081018002L,0x0000060070004097L});
	public static final BitSet FOLLOW_testlist_in_return_stmt1883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_yield_expr_in_yield_stmt1917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RAISE_in_raise_stmt1935 = new BitSet(new long[]{0x03A0080081018002L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_raise_stmt1938 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_FROM_in_raise_stmt1941 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_raise_stmt1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_name_in_import_stmt1965 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_from_in_import_stmt1973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_import_name1991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_as_names_in_import_name1993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_import_from2012 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_DOT_in_import_from2015 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_name_in_import_from2018 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_import_from2022 = new BitSet(new long[]{0x0004000080000000L});
	public static final BitSet FOLLOW_IMPORT_in_import_from2026 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000012L});
	public static final BitSet FOLLOW_STAR_in_import_from2037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_as_names_in_import_from2049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_import_from2061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_import_as_names_in_import_from2063 = new BitSet(new long[]{0x0000000000400000L,0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_import_from2065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_import_from2068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_as_name_in_import_as_names2096 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_import_as_names2099 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_import_as_name_in_import_as_names2101 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_NAME_in_import_as_name2121 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AS_in_import_as_name2124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_import_as_name2126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dotted_name_in_dotted_as_name2147 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AS_in_dotted_as_name2150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_dotted_as_name2152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dotted_as_name_in_dotted_as_names2172 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_dotted_as_names2175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_as_name_in_dotted_as_names2177 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_NAME_in_dotted_name2197 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_DOT_in_dotted_name2200 = new BitSet(new long[]{0x00CE759032120680L,0x000001B200090E90L});
	public static final BitSet FOLLOW_attr_in_dotted_name2202 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_GLOBAL_in_global_stmt2222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_global_stmt2224 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_global_stmt2227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_global_stmt2229 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_EXEC_in_exec_stmt2249 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_exec_stmt2251 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_IN_in_exec_stmt2254 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_exec_stmt2256 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_exec_stmt2259 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_exec_stmt2261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSERT_in_assert_stmt2283 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_assert_stmt2285 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_assert_stmt2288 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_assert_stmt2290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stmt_in_compound_stmt2310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stmt_in_compound_stmt2318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stmt_in_compound_stmt2326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_try_stmt_in_compound_stmt2334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_with_stmt_in_compound_stmt2342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcdef_in_compound_stmt2350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classdef_in_compound_stmt2358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decorated_in_compound_stmt2366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_async_stmt_in_compound_stmt2374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASYNC_in_async_stmt2392 = new BitSet(new long[]{0x0000100010000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_funcdef_in_async_stmt2395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_with_stmt_in_async_stmt2399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stmt_in_async_stmt2403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_stmt2422 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_if_stmt2424 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_if_stmt2426 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_if_stmt2428 = new BitSet(new long[]{0x0000001000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_elif_clause_in_if_stmt2430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_else_clause_in_elif_clause2449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELIF_in_elif_clause2457 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_elif_clause2459 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_elif_clause2461 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_elif_clause2463 = new BitSet(new long[]{0x0000001000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_elif_clause_in_elif_clause2474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORELSE_in_else_clause2512 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_else_clause2514 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_else_clause2516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_stmt2534 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_while_stmt2536 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_while_stmt2538 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_while_stmt2540 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_while_stmt2543 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_while_stmt2545 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_while_stmt2547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_stmt2567 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_exprlist_in_for_stmt2569 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_IN_in_for_stmt2571 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_testlist_in_for_stmt2573 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_for_stmt2575 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_for_stmt2577 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_for_stmt2588 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_for_stmt2590 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_for_stmt2592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRY_in_try_stmt2616 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt2618 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_try_stmt2620 = new BitSet(new long[]{0x0000048000000002L});
	public static final BitSet FOLLOW_except_clause_in_try_stmt2631 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt2633 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_try_stmt2635 = new BitSet(new long[]{0x0000048000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_try_stmt2640 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt2642 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_try_stmt2644 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_FINALLY_in_try_stmt2649 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt2651 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_try_stmt2653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FINALLY_in_try_stmt2665 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt2667 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_try_stmt2669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WITH_in_with_stmt2698 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_with_item_in_with_stmt2700 = new BitSet(new long[]{0x0000000000600000L});
	public static final BitSet FOLLOW_COMMA_in_with_stmt2710 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_with_item_in_with_stmt2712 = new BitSet(new long[]{0x0000000000600000L});
	public static final BitSet FOLLOW_COLON_in_with_stmt2716 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_with_stmt2718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_with_item2736 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AS_in_with_item2739 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_with_item2741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEPT_in_except_clause2761 = new BitSet(new long[]{0x03A0080081018002L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_except_clause2764 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_except_clause2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_except_clause2769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_stmt_in_suite2791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_suite2799 = new BitSet(new long[]{0x0010000008000000L});
	public static final BitSet FOLLOW_EOF_in_suite2802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEDENT_in_suite2821 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_EOF_in_suite2825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INDENT_in_suite2843 = new BitSet(new long[]{0x03A67900B313B400L,0x000007B270094897L});
	public static final BitSet FOLLOW_stmt_in_suite2846 = new BitSet(new long[]{0x03A67900BB13B400L,0x000007B270094897L});
	public static final BitSet FOLLOW_set_in_suite2850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_test_in_test2951 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_IF_in_test2971 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_or_test_in_test2973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_test2975 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_test2977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lambdef_in_test3001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_test_in_or_test3019 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_OR_in_or_test3032 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_and_test_in_or_test3034 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_not_test_in_and_test3085 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_AND_in_and_test3098 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_not_test_in_and_test3100 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_NOT_in_not_test3151 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_not_test_in_not_test3153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comparison_in_not_test3161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_comparison3179 = new BitSet(new long[]{0x6049802000000012L,0x0000000000000180L});
	public static final BitSet FOLLOW_comp_op_in_comparison3192 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_comparison3194 = new BitSet(new long[]{0x6049802000000012L,0x0000000000000180L});
	public static final BitSet FOLLOW_LESS_in_comp_op3242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_comp_op3250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUAL_in_comp_op3258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQUAL_in_comp_op3266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEQUAL_in_comp_op3274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALT_NOTEQUAL_in_comp_op3282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTEQUAL_in_comp_op3290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IN_in_comp_op3298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_comp_op3306 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_IN_in_comp_op3308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_comp_op3316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_comp_op3324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_NOT_in_comp_op3326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_xor_expr_in_expr3344 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_VBAR_in_expr3357 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_xor_expr_in_expr3359 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_and_expr_in_xor_expr3410 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_CIRCUMFLEX_in_xor_expr3423 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_and_expr_in_xor_expr3425 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_shift_expr_in_and_expr3476 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_AMPER_in_and_expr3489 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_shift_expr_in_and_expr3491 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_arith_expr_in_shift_expr3542 = new BitSet(new long[]{0x0800000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_shift_op_in_shift_expr3556 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_arith_expr_in_shift_expr3558 = new BitSet(new long[]{0x0800000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_term_in_arith_expr3634 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004004L});
	public static final BitSet FOLLOW_arith_op_in_arith_expr3647 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_term_in_arith_expr3649 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004004L});
	public static final BitSet FOLLOW_factor_in_term3725 = new BitSet(new long[]{0x0000000100000002L,0x0000000005001000L});
	public static final BitSet FOLLOW_term_op_in_term3738 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_factor_in_term3740 = new BitSet(new long[]{0x0000000100000002L,0x0000000005001000L});
	public static final BitSet FOLLOW_PLUS_in_factor3828 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_factor_in_factor3830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_factor3838 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_factor_in_factor3840 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TILDE_in_factor3848 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_factor_in_factor3850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_power_in_factor3858 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRAILBACKSLASH_in_factor3866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_expr_in_power3884 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_power3894 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_factor_in_power3896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AWAIT_in_atom_expr3916 = new BitSet(new long[]{0x0320080081010000L,0x0000060010000013L});
	public static final BitSet FOLLOW_atom_in_atom_expr3919 = new BitSet(new long[]{0x0100000080000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_trailer_in_atom_expr3921 = new BitSet(new long[]{0x0100000080000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_atom3944 = new BitSet(new long[]{0x03A0080081018000L,0x0000068074404097L});
	public static final BitSet FOLLOW_yield_expr_in_atom3954 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_testlist_comp_in_atom3964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_atom3988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_atom3996 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074024097L});
	public static final BitSet FOLLOW_testlist_comp_in_atom4005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_atom4029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LCURLY_in_atom4037 = new BitSet(new long[]{0x03A0080481018000L,0x0000060074044097L});
	public static final BitSet FOLLOW_dictorsetmaker_in_atom4047 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_RCURLY_in_atom4074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BACKQUOTE_in_atom4083 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_testlist_in_atom4085 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_BACKQUOTE_in_atom4087 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_atom4096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom4105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONGINT_in_atom4114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_atom4123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMPLEX_in_atom4132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_atom4141 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_DOT_in_atom4143 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_DOT_in_atom4145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_atom4155 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
	public static final BitSet FOLLOW_TRISTRINGPART_in_atom4166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRINGPART_in_atom4175 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_TRAILBACKSLASH_in_atom4177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_testlist_comp4196 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_comp4217 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074004097L});
	public static final BitSet FOLLOW_test_in_testlist_comp4220 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_star_expr_in_testlist_comp4224 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_comp4229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_for_in_testlist_comp4242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_star_expr_in_testlist_comp4260 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_comp4281 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074004097L});
	public static final BitSet FOLLOW_test_in_testlist_comp4284 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_star_expr_in_testlist_comp4288 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_comp4293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_for_in_testlist_comp4306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LAMBDA_in_lambdef4334 = new BitSet(new long[]{0x0000000400200000L,0x0000000004000010L});
	public static final BitSet FOLLOW_varargslist_in_lambdef4337 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_lambdef4341 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_lambdef4343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_trailer4361 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074404097L});
	public static final BitSet FOLLOW_arglist_in_trailer4372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_trailer4400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_trailer4408 = new BitSet(new long[]{0x03A0080081218000L,0x0000060070004097L});
	public static final BitSet FOLLOW_subscriptlist_in_trailer4410 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_trailer4412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_trailer4420 = new BitSet(new long[]{0x00CE759032120680L,0x000001B200090E90L});
	public static final BitSet FOLLOW_attr_in_trailer4422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subscript_in_subscriptlist4440 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_subscriptlist4450 = new BitSet(new long[]{0x03A0080081218000L,0x0000060070004097L});
	public static final BitSet FOLLOW_subscript_in_subscriptlist4452 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_subscriptlist4457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_subscript4488 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_COLON_in_subscript4491 = new BitSet(new long[]{0x03A0080081218002L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_subscript4494 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_sliceop_in_subscript4499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_subscript4520 = new BitSet(new long[]{0x03A0080081218002L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_subscript4523 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_sliceop_in_subscript4528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_subscript4538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_sliceop4556 = new BitSet(new long[]{0x03A0080081018002L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_sliceop4564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_exprlist4604 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_exprlist4615 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_exprlist4617 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_exprlist4622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_exprlist4632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_del_list4651 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_del_list4662 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_del_list4664 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_del_list4669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_testlist4700 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist4711 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_testlist4713 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist4718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_testlist4728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker4762 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_dictorsetmaker4764 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker4766 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_dictorsetmaker4770 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_dictorsetmaker4772 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_comp_for_in_dictorsetmaker4785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker4799 = new BitSet(new long[]{0x03A0080481018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker4802 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_dictorsetmaker4804 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker4806 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_dictorsetmaker4810 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_expr_in_dictorsetmaker4812 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker4818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker4830 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_star_expr_in_dictorsetmaker4834 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_comp_for_in_dictorsetmaker4847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker4861 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker4864 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_star_expr_in_dictorsetmaker4868 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker4874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_classdef4895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_classdef4897 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_classdef4900 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074404097L});
	public static final BitSet FOLLOW_arglist_in_classdef4902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_classdef4905 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_classdef4909 = new BitSet(new long[]{0x03A46900A3038400L,0x00000780700948B7L});
	public static final BitSet FOLLOW_suite_in_classdef4911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argument_in_arglist4925 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_arglist4928 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074004097L});
	public static final BitSet FOLLOW_argument_in_arglist4930 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_arglist4934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_argument4952 = new BitSet(new long[]{0x0000100000000802L});
	public static final BitSet FOLLOW_comp_for_in_argument4961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_argument4970 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_argument4972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_argument4996 = new BitSet(new long[]{0x03A0080081018000L,0x0000060074004097L});
	public static final BitSet FOLLOW_STAR_in_argument5006 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_argument5008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_argument5018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_for_in_comp_iter5037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_if_in_comp_iter5045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_comp_for5063 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004017L});
	public static final BitSet FOLLOW_exprlist_in_comp_for5065 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_IN_in_comp_for5067 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_or_test_in_comp_for5069 = new BitSet(new long[]{0x0002100000000002L});
	public static final BitSet FOLLOW_comp_iter_in_comp_for5071 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_comp_if5090 = new BitSet(new long[]{0x03A0080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_test_in_comp_if5092 = new BitSet(new long[]{0x0002100000000002L});
	public static final BitSet FOLLOW_comp_iter_in_comp_if5094 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YIELD_in_yield_expr5113 = new BitSet(new long[]{0x03A0080081018002L,0x0000060070004097L});
	public static final BitSet FOLLOW_testlist_in_yield_expr5115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_in_synpred1_PythonPartial1316 = new BitSet(new long[]{0x1000000A00080040L,0x000000080A20A008L});
	public static final BitSet FOLLOW_augassign_in_synpred1_PythonPartial1318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_in_synpred2_PythonPartial1396 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred2_PythonPartial1398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred3_PythonPartial1681 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_synpred3_PythonPartial1683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred4_PythonPartial2962 = new BitSet(new long[]{0x0320080081018000L,0x0000060070004097L});
	public static final BitSet FOLLOW_or_test_in_synpred4_PythonPartial2964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_synpred4_PythonPartial2966 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred5_PythonPartial4478 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_synpred5_PythonPartial4480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_synpred6_PythonPartial4512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_synpred7_PythonPartial4597 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_synpred7_PythonPartial4599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred8_PythonPartial4690 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_synpred8_PythonPartial4692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred9_PythonPartial4750 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_synpred9_PythonPartial4752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_synpred9_PythonPartial4756 = new BitSet(new long[]{0x0000000000000002L});
}
