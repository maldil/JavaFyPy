// $ANTLR 3.5.2 Python.g 2020-08-11 10:31:54

package org.jpp.astnodes;


import org.antlr.runtime.*;

@SuppressWarnings("all")
public class PythonLexer extends Lexer {
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

	/** Handles context-sensitive lexing of implicit line joining such as
	 *  the case where newline is ignored in cases like this:
	 *  a = [3,
	 *       4]
	 */
	int implicitLineJoiningLevel = 0;
	int startPos=-1;

	//For use in partial parsing.
	public boolean eofWhileNested = false;
	public boolean partial = false;
	public boolean single = false;

	//If you want to use another error recovery mechanism change this
	//and the same one in the parser.
	private ErrorHandler errorHandler;

	    public void setErrorHandler(ErrorHandler eh) {
	        this.errorHandler = eh;
	    }

	    /**
	     *  Taken directly from org.antlr's Lexer.java -- needs to be re-integrated every time
	     *  we upgrade from Antlr (need to consider a Lexer subclass, though the issue would
	     *  remain).
	     */
	    public Token nextToken() {
	        startPos = getCharPositionInLine();
	        while (true) {
	            state.token = null;
	            state.channel = Token.DEFAULT_CHANNEL;
	            state.tokenStartCharIndex = input.index();
	            state.tokenStartCharPositionInLine = input.getCharPositionInLine();
	            state.tokenStartLine = input.getLine();
	            state.text = null;
	            if ( input.LA(1)==CharStream.EOF ) {
	                if (implicitLineJoiningLevel > 0) {
	                    eofWhileNested = true;
	                }
	                return getEOFToken();
	            }
	            try {
	                mTokens();
	                if ( state.token==null ) {
	                    emit();
	                }
	                else if ( state.token==Token.SKIP_TOKEN ) {
	                    continue;
	                }
	                return state.token;
	            } catch (NoViableAltException nva) {
	                reportError(nva);
	                errorHandler.recover(this, nva); // throw out current char and try again
	            } catch (FailedPredicateException fp) {
	                //XXX: added this for failed STRINGPART -- the FailedPredicateException
	                //     hides a NoViableAltException.  This should be the only
	                //     FailedPredicateException that gets thrown by the lexer.
	                reportError(fp);
	                errorHandler.recover(this, fp); // throw out current char and try again
	            } catch (RecognitionException re) {
	                reportError(re);
	                // match() routine has already called recover()
	            }
	        }
	    }

	    public Token getEOFToken() {
	        Token eof = new CommonToken(input,Token.EOF,
	            Token.DEFAULT_CHANNEL,
	            input.index(),input.index());
	        eof.setLine(getLine());
	        eof.setCharPositionInLine(getCharPositionInLine());
	        return eof;
	    }

	    @Override
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	        //Do nothing. We will handle error display elsewhere.
	    }



	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PythonLexer() {} 
	public PythonLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PythonLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Python.g"; }

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2394:11: ( 'as' )
			// Python.g:2394:13: 'as'
			{
			match("as"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "ASSERT"
	public final void mASSERT() throws RecognitionException {
		try {
			int _type = ASSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2395:11: ( 'assert' )
			// Python.g:2395:13: 'assert'
			{
			match("assert"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSERT"

	// $ANTLR start "ASYNC"
	public final void mASYNC() throws RecognitionException {
		try {
			int _type = ASYNC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2396:11: ( 'async' )
			// Python.g:2396:13: 'async'
			{
			match("async"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASYNC"

	// $ANTLR start "AWAIT"
	public final void mAWAIT() throws RecognitionException {
		try {
			int _type = AWAIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2397:11: ( 'await' )
			// Python.g:2397:13: 'await'
			{
			match("await"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AWAIT"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2398:11: ( 'break' )
			// Python.g:2398:13: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK"

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2399:11: ( 'class' )
			// Python.g:2399:13: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2400:11: ( 'continue' )
			// Python.g:2400:13: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "DEF"
	public final void mDEF() throws RecognitionException {
		try {
			int _type = DEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2401:11: ( 'def' )
			// Python.g:2401:13: 'def'
			{
			match("def"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEF"

	// $ANTLR start "DELETE"
	public final void mDELETE() throws RecognitionException {
		try {
			int _type = DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2402:11: ( 'del' )
			// Python.g:2402:13: 'del'
			{
			match("del"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DELETE"

	// $ANTLR start "ELIF"
	public final void mELIF() throws RecognitionException {
		try {
			int _type = ELIF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2403:11: ( 'elif' )
			// Python.g:2403:13: 'elif'
			{
			match("elif"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELIF"

	// $ANTLR start "EXCEPT"
	public final void mEXCEPT() throws RecognitionException {
		try {
			int _type = EXCEPT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2404:11: ( 'except' )
			// Python.g:2404:13: 'except'
			{
			match("except"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCEPT"

	// $ANTLR start "EXEC"
	public final void mEXEC() throws RecognitionException {
		try {
			int _type = EXEC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2405:11: ( 'exec1' )
			// Python.g:2405:13: 'exec1'
			{
			match("exec1"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXEC"

	// $ANTLR start "FINALLY"
	public final void mFINALLY() throws RecognitionException {
		try {
			int _type = FINALLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2406:11: ( 'finally' )
			// Python.g:2406:13: 'finally'
			{
			match("finally"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FINALLY"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2407:11: ( 'from' )
			// Python.g:2407:13: 'from'
			{
			match("from"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2408:11: ( 'for' )
			// Python.g:2408:13: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "GLOBAL"
	public final void mGLOBAL() throws RecognitionException {
		try {
			int _type = GLOBAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2409:11: ( 'global' )
			// Python.g:2409:13: 'global'
			{
			match("global"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GLOBAL"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2410:11: ( 'if' )
			// Python.g:2410:13: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2411:11: ( 'import' )
			// Python.g:2411:13: 'import'
			{
			match("import"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2412:11: ( 'in' )
			// Python.g:2412:13: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2413:11: ( 'is' )
			// Python.g:2413:13: 'is'
			{
			match("is"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "LAMBDA"
	public final void mLAMBDA() throws RecognitionException {
		try {
			int _type = LAMBDA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2414:11: ( 'lambda' )
			// Python.g:2414:13: 'lambda'
			{
			match("lambda"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LAMBDA"

	// $ANTLR start "NONLOCAL"
	public final void mNONLOCAL() throws RecognitionException {
		try {
			int _type = NONLOCAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2415:11: ( 'nonlocal' )
			// Python.g:2415:13: 'nonlocal'
			{
			match("nonlocal"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NONLOCAL"

	// $ANTLR start "ORELSE"
	public final void mORELSE() throws RecognitionException {
		try {
			int _type = ORELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2416:11: ( 'else' )
			// Python.g:2416:13: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORELSE"

	// $ANTLR start "PASS"
	public final void mPASS() throws RecognitionException {
		try {
			int _type = PASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2417:11: ( 'pass' )
			// Python.g:2417:13: 'pass'
			{
			match("pass"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PASS"

	// $ANTLR start "RAISE"
	public final void mRAISE() throws RecognitionException {
		try {
			int _type = RAISE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2418:11: ( 'raise' )
			// Python.g:2418:13: 'raise'
			{
			match("raise"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RAISE"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2419:11: ( 'return' )
			// Python.g:2419:13: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "TRY"
	public final void mTRY() throws RecognitionException {
		try {
			int _type = TRY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2420:11: ( 'try' )
			// Python.g:2420:13: 'try'
			{
			match("try"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRY"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2421:11: ( 'while' )
			// Python.g:2421:13: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "WITH"
	public final void mWITH() throws RecognitionException {
		try {
			int _type = WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2422:11: ( 'with' )
			// Python.g:2422:13: 'with'
			{
			match("with"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WITH"

	// $ANTLR start "YIELD"
	public final void mYIELD() throws RecognitionException {
		try {
			int _type = YIELD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2423:11: ( 'yield' )
			// Python.g:2423:13: 'yield'
			{
			match("yield"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "YIELD"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2425:11: ( '(' )
			// Python.g:2425:13: '('
			{
			match('('); 
			implicitLineJoiningLevel++;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2427:11: ( ')' )
			// Python.g:2427:13: ')'
			{
			match(')'); 
			implicitLineJoiningLevel--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2429:11: ( '[' )
			// Python.g:2429:13: '['
			{
			match('['); 
			implicitLineJoiningLevel++;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2431:11: ( ']' )
			// Python.g:2431:13: ']'
			{
			match(']'); 
			implicitLineJoiningLevel--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2433:11: ( ':' )
			// Python.g:2433:13: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2435:10: ( ',' )
			// Python.g:2435:12: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2437:9: ( ';' )
			// Python.g:2437:11: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2439:9: ( '+' )
			// Python.g:2439:11: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2441:10: ( '-' )
			// Python.g:2441:12: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2443:9: ( '*' )
			// Python.g:2443:11: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "SLASH"
	public final void mSLASH() throws RecognitionException {
		try {
			int _type = SLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2445:10: ( '/' )
			// Python.g:2445:12: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLASH"

	// $ANTLR start "VBAR"
	public final void mVBAR() throws RecognitionException {
		try {
			int _type = VBAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2447:9: ( '|' )
			// Python.g:2447:11: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VBAR"

	// $ANTLR start "AMPER"
	public final void mAMPER() throws RecognitionException {
		try {
			int _type = AMPER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2449:10: ( '&' )
			// Python.g:2449:12: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AMPER"

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2451:9: ( '<' )
			// Python.g:2451:11: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS"

	// $ANTLR start "GREATER"
	public final void mGREATER() throws RecognitionException {
		try {
			int _type = GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2453:12: ( '>' )
			// Python.g:2453:14: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2455:11: ( '=' )
			// Python.g:2455:13: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2457:12: ( '%' )
			// Python.g:2457:14: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENT"

	// $ANTLR start "BACKQUOTE"
	public final void mBACKQUOTE() throws RecognitionException {
		try {
			int _type = BACKQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2459:14: ( '`' )
			// Python.g:2459:16: '`'
			{
			match('`'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BACKQUOTE"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		try {
			int _type = LCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2461:11: ( '{' )
			// Python.g:2461:13: '{'
			{
			match('{'); 
			implicitLineJoiningLevel++;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2463:11: ( '}' )
			// Python.g:2463:13: '}'
			{
			match('}'); 
			implicitLineJoiningLevel--;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "CIRCUMFLEX"
	public final void mCIRCUMFLEX() throws RecognitionException {
		try {
			int _type = CIRCUMFLEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2465:15: ( '^' )
			// Python.g:2465:17: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CIRCUMFLEX"

	// $ANTLR start "TILDE"
	public final void mTILDE() throws RecognitionException {
		try {
			int _type = TILDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2467:10: ( '~' )
			// Python.g:2467:12: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TILDE"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2469:10: ( '==' )
			// Python.g:2469:12: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "NOTEQUAL"
	public final void mNOTEQUAL() throws RecognitionException {
		try {
			int _type = NOTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2471:13: ( '!=' )
			// Python.g:2471:15: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTEQUAL"

	// $ANTLR start "ALT_NOTEQUAL"
	public final void mALT_NOTEQUAL() throws RecognitionException {
		try {
			int _type = ALT_NOTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2473:13: ( '<>' )
			// Python.g:2473:15: '<>'
			{
			match("<>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALT_NOTEQUAL"

	// $ANTLR start "LESSEQUAL"
	public final void mLESSEQUAL() throws RecognitionException {
		try {
			int _type = LESSEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2475:14: ( '<=' )
			// Python.g:2475:16: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSEQUAL"

	// $ANTLR start "LEFTSHIFT"
	public final void mLEFTSHIFT() throws RecognitionException {
		try {
			int _type = LEFTSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2477:14: ( '<<' )
			// Python.g:2477:16: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTSHIFT"

	// $ANTLR start "GREATEREQUAL"
	public final void mGREATEREQUAL() throws RecognitionException {
		try {
			int _type = GREATEREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2479:17: ( '>=' )
			// Python.g:2479:19: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATEREQUAL"

	// $ANTLR start "RIGHTSHIFT"
	public final void mRIGHTSHIFT() throws RecognitionException {
		try {
			int _type = RIGHTSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2481:15: ( '>>' )
			// Python.g:2481:17: '>>'
			{
			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTSHIFT"

	// $ANTLR start "PLUSEQUAL"
	public final void mPLUSEQUAL() throws RecognitionException {
		try {
			int _type = PLUSEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2483:14: ( '+=' )
			// Python.g:2483:16: '+='
			{
			match("+="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUSEQUAL"

	// $ANTLR start "MINUSEQUAL"
	public final void mMINUSEQUAL() throws RecognitionException {
		try {
			int _type = MINUSEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2485:15: ( '-=' )
			// Python.g:2485:17: '-='
			{
			match("-="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUSEQUAL"

	// $ANTLR start "DOUBLESTAR"
	public final void mDOUBLESTAR() throws RecognitionException {
		try {
			int _type = DOUBLESTAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2487:15: ( '**' )
			// Python.g:2487:17: '**'
			{
			match("**"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLESTAR"

	// $ANTLR start "STAREQUAL"
	public final void mSTAREQUAL() throws RecognitionException {
		try {
			int _type = STAREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2489:14: ( '*=' )
			// Python.g:2489:16: '*='
			{
			match("*="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAREQUAL"

	// $ANTLR start "ATEQUAL"
	public final void mATEQUAL() throws RecognitionException {
		try {
			int _type = ATEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2491:13: ( '@=' )
			// Python.g:2491:15: '@='
			{
			match("@="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ATEQUAL"

	// $ANTLR start "DOUBLESLASH"
	public final void mDOUBLESLASH() throws RecognitionException {
		try {
			int _type = DOUBLESLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2493:16: ( '//' )
			// Python.g:2493:18: '//'
			{
			match("//"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLESLASH"

	// $ANTLR start "SLASHEQUAL"
	public final void mSLASHEQUAL() throws RecognitionException {
		try {
			int _type = SLASHEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2495:15: ( '/=' )
			// Python.g:2495:17: '/='
			{
			match("/="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLASHEQUAL"

	// $ANTLR start "VBAREQUAL"
	public final void mVBAREQUAL() throws RecognitionException {
		try {
			int _type = VBAREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2497:14: ( '|=' )
			// Python.g:2497:16: '|='
			{
			match("|="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VBAREQUAL"

	// $ANTLR start "PERCENTEQUAL"
	public final void mPERCENTEQUAL() throws RecognitionException {
		try {
			int _type = PERCENTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2499:17: ( '%=' )
			// Python.g:2499:19: '%='
			{
			match("%="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENTEQUAL"

	// $ANTLR start "AMPEREQUAL"
	public final void mAMPEREQUAL() throws RecognitionException {
		try {
			int _type = AMPEREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2501:15: ( '&=' )
			// Python.g:2501:17: '&='
			{
			match("&="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AMPEREQUAL"

	// $ANTLR start "CIRCUMFLEXEQUAL"
	public final void mCIRCUMFLEXEQUAL() throws RecognitionException {
		try {
			int _type = CIRCUMFLEXEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2503:20: ( '^=' )
			// Python.g:2503:22: '^='
			{
			match("^="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CIRCUMFLEXEQUAL"

	// $ANTLR start "LEFTSHIFTEQUAL"
	public final void mLEFTSHIFTEQUAL() throws RecognitionException {
		try {
			int _type = LEFTSHIFTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2505:19: ( '<<=' )
			// Python.g:2505:21: '<<='
			{
			match("<<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTSHIFTEQUAL"

	// $ANTLR start "RIGHTSHIFTEQUAL"
	public final void mRIGHTSHIFTEQUAL() throws RecognitionException {
		try {
			int _type = RIGHTSHIFTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2507:20: ( '>>=' )
			// Python.g:2507:22: '>>='
			{
			match(">>="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTSHIFTEQUAL"

	// $ANTLR start "DOUBLESTAREQUAL"
	public final void mDOUBLESTAREQUAL() throws RecognitionException {
		try {
			int _type = DOUBLESTAREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2509:20: ( '**=' )
			// Python.g:2509:22: '**='
			{
			match("**="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLESTAREQUAL"

	// $ANTLR start "DOUBLESLASHEQUAL"
	public final void mDOUBLESLASHEQUAL() throws RecognitionException {
		try {
			int _type = DOUBLESLASHEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2511:21: ( '//=' )
			// Python.g:2511:23: '//='
			{
			match("//="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLESLASHEQUAL"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2513:7: ( '->' )
			// Python.g:2513:9: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2515:5: ( '.' )
			// Python.g:2515:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			int _type = AT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2517:4: ( '@' )
			// Python.g:2517:6: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2519:5: ( 'and' )
			// Python.g:2519:7: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2521:4: ( 'or' )
			// Python.g:2521:6: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2523:5: ( 'not' )
			// Python.g:2523:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2526:5: ( '.' DIGITS ( Exponent )? | DIGITS '.' Exponent | DIGITS ( '.' ( DIGITS ( Exponent )? )? | Exponent ) )
			int alt5=3;
			alt5 = dfa5.predict(input);
			switch (alt5) {
				case 1 :
					// Python.g:2526:9: '.' DIGITS ( Exponent )?
					{
					match('.'); 
					mDIGITS(); 

					// Python.g:2526:20: ( Exponent )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0=='E'||LA1_0=='e') ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// Python.g:2526:21: Exponent
							{
							mExponent(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// Python.g:2527:9: DIGITS '.' Exponent
					{
					mDIGITS(); 

					match('.'); 
					mExponent(); 

					}
					break;
				case 3 :
					// Python.g:2528:9: DIGITS ( '.' ( DIGITS ( Exponent )? )? | Exponent )
					{
					mDIGITS(); 

					// Python.g:2528:16: ( '.' ( DIGITS ( Exponent )? )? | Exponent )
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0=='.') ) {
						alt4=1;
					}
					else if ( (LA4_0=='E'||LA4_0=='e') ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// Python.g:2528:17: '.' ( DIGITS ( Exponent )? )?
							{
							match('.'); 
							// Python.g:2528:21: ( DIGITS ( Exponent )? )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// Python.g:2528:22: DIGITS ( Exponent )?
									{
									mDIGITS(); 

									// Python.g:2528:29: ( Exponent )?
									int alt2=2;
									int LA2_0 = input.LA(1);
									if ( (LA2_0=='E'||LA2_0=='e') ) {
										alt2=1;
									}
									switch (alt2) {
										case 1 :
											// Python.g:2528:30: Exponent
											{
											mExponent(); 

											}
											break;

									}

									}
									break;

							}

							}
							break;
						case 2 :
							// Python.g:2528:45: Exponent
							{
							mExponent(); 

							}
							break;

					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "LONGINT"
	public final void mLONGINT() throws RecognitionException {
		try {
			int _type = LONGINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2532:5: ( INT ( 'l' | 'L' ) )
			// Python.g:2532:9: INT ( 'l' | 'L' )
			{
			mINT(); 

			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LONGINT"

	// $ANTLR start "Exponent"
	public final void mExponent() throws RecognitionException {
		try {
			// Python.g:2538:5: ( ( 'e' | 'E' ) ( '+' | '-' )? DIGITS )
			// Python.g:2538:10: ( 'e' | 'E' ) ( '+' | '-' )? DIGITS
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Python.g:2538:22: ( '+' | '-' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='+'||LA6_0=='-') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// Python.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			mDIGITS(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Exponent"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2540:5: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ | '0' ( 'o' | 'O' ) ( '0' .. '7' )* | '0' ( '0' .. '7' )* | '0' ( 'b' | 'B' ) ( '0' .. '1' )* | '1' .. '9' ( DIGITS )* )
			int alt12=5;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='0') ) {
				switch ( input.LA(2) ) {
				case 'X':
				case 'x':
					{
					alt12=1;
					}
					break;
				case 'O':
				case 'o':
					{
					alt12=2;
					}
					break;
				case 'B':
				case 'b':
					{
					alt12=4;
					}
					break;
				default:
					alt12=3;
				}
			}
			else if ( ((LA12_0 >= '1' && LA12_0 <= '9')) ) {
				alt12=5;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// Python.g:2541:9: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
					{
					match('0'); 
					if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// Python.g:2541:25: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'F')||(LA7_0 >= 'a' && LA7_0 <= 'f')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// Python.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					}
					break;
				case 2 :
					// Python.g:2543:9: '0' ( 'o' | 'O' ) ( '0' .. '7' )*
					{
					match('0'); 
					if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// Python.g:2543:25: ( '0' .. '7' )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '7')) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// Python.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop8;
						}
					}

					}
					break;
				case 3 :
					// Python.g:2544:9: '0' ( '0' .. '7' )*
					{
					match('0'); 
					// Python.g:2544:14: ( '0' .. '7' )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= '0' && LA9_0 <= '7')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// Python.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop9;
						}
					}

					}
					break;
				case 4 :
					// Python.g:2546:9: '0' ( 'b' | 'B' ) ( '0' .. '1' )*
					{
					match('0'); 
					if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// Python.g:2546:25: ( '0' .. '1' )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '0' && LA10_0 <= '1')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// Python.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop10;
						}
					}

					}
					break;
				case 5 :
					// Python.g:2548:9: '1' .. '9' ( DIGITS )*
					{
					matchRange('1','9'); 
					// Python.g:2548:18: ( DIGITS )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// Python.g:2548:18: DIGITS
							{
							mDIGITS(); 

							}
							break;

						default :
							break loop11;
						}
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "COMPLEX"
	public final void mCOMPLEX() throws RecognitionException {
		try {
			int _type = COMPLEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2552:5: ( ( DIGITS )+ ( 'j' | 'J' ) | FLOAT ( 'j' | 'J' ) )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// Python.g:2552:9: ( DIGITS )+ ( 'j' | 'J' )
					{
					// Python.g:2552:9: ( DIGITS )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// Python.g:2552:9: DIGITS
							{
							mDIGITS(); 

							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
					}

					if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// Python.g:2553:9: FLOAT ( 'j' | 'J' )
					{
					mFLOAT(); 

					if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMPLEX"

	// $ANTLR start "DIGITS"
	public final void mDIGITS() throws RecognitionException {
		try {
			// Python.g:2558:8: ( ( '0' .. '9' )+ )
			// Python.g:2558:10: ( '0' .. '9' )+
			{
			// Python.g:2558:10: ( '0' .. '9' )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// Python.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGITS"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// Python.g:2561:8: ( 'a' .. 'z' | 'A' .. 'Z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' | '\\u0100' .. '\\uFFFE' | '_' )
			// Python.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\uFFFE') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2563:6: ( LETTER ( LETTER | DIGITS )* )
			// Python.g:2563:8: LETTER ( LETTER | DIGITS )*
			{
			mLETTER(); 

			// Python.g:2563:15: ( LETTER | DIGITS )*
			loop16:
			while (true) {
				int alt16=3;
				int LA16_0 = input.LA(1);
				if ( ((LA16_0 >= 'A' && LA16_0 <= 'Z')||LA16_0=='_'||(LA16_0 >= 'a' && LA16_0 <= 'z')||(LA16_0 >= '\u00C0' && LA16_0 <= '\u00D6')||(LA16_0 >= '\u00D8' && LA16_0 <= '\u00F6')||(LA16_0 >= '\u00F8' && LA16_0 <= '\uFFFE')) ) {
					alt16=1;
				}
				else if ( ((LA16_0 >= '0' && LA16_0 <= '9')) ) {
					alt16=2;
				}

				switch (alt16) {
				case 1 :
					// Python.g:2563:17: LETTER
					{
					mLETTER(); 

					}
					break;
				case 2 :
					// Python.g:2563:26: DIGITS
					{
					mDIGITS(); 

					}
					break;

				default :
					break loop16;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2573:5: ( ( 'r' | 'u' | 'b' | 'ur' | 'br' | 'R' | 'U' | 'B' | 'UR' | 'BR' | 'uR' | 'Ur' | 'Br' | 'bR' | 'rb' | 'rB' | 'Rb' | 'RB' )? ( '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"' | '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"' | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\'' ) )
			// Python.g:2573:9: ( 'r' | 'u' | 'b' | 'ur' | 'br' | 'R' | 'U' | 'B' | 'UR' | 'BR' | 'uR' | 'Ur' | 'Br' | 'bR' | 'rb' | 'rB' | 'Rb' | 'RB' )? ( '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"' | '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"' | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\'' )
			{
			// Python.g:2573:9: ( 'r' | 'u' | 'b' | 'ur' | 'br' | 'R' | 'U' | 'B' | 'UR' | 'BR' | 'uR' | 'Ur' | 'Br' | 'bR' | 'rb' | 'rB' | 'Rb' | 'RB' )?
			int alt17=19;
			switch ( input.LA(1) ) {
				case 'r':
					{
					switch ( input.LA(2) ) {
						case 'b':
							{
							alt17=15;
							}
							break;
						case 'B':
							{
							alt17=16;
							}
							break;
						case '\"':
						case '\'':
							{
							alt17=1;
							}
							break;
					}
					}
					break;
				case 'u':
					{
					switch ( input.LA(2) ) {
						case 'r':
							{
							alt17=4;
							}
							break;
						case 'R':
							{
							alt17=11;
							}
							break;
						case '\"':
						case '\'':
							{
							alt17=2;
							}
							break;
					}
					}
					break;
				case 'b':
					{
					switch ( input.LA(2) ) {
						case 'r':
							{
							alt17=5;
							}
							break;
						case 'R':
							{
							alt17=14;
							}
							break;
						case '\"':
						case '\'':
							{
							alt17=3;
							}
							break;
					}
					}
					break;
				case 'R':
					{
					switch ( input.LA(2) ) {
						case 'b':
							{
							alt17=17;
							}
							break;
						case 'B':
							{
							alt17=18;
							}
							break;
						case '\"':
						case '\'':
							{
							alt17=6;
							}
							break;
					}
					}
					break;
				case 'U':
					{
					switch ( input.LA(2) ) {
						case 'R':
							{
							alt17=9;
							}
							break;
						case 'r':
							{
							alt17=12;
							}
							break;
						case '\"':
						case '\'':
							{
							alt17=7;
							}
							break;
					}
					}
					break;
				case 'B':
					{
					switch ( input.LA(2) ) {
						case 'R':
							{
							alt17=10;
							}
							break;
						case 'r':
							{
							alt17=13;
							}
							break;
						case '\"':
						case '\'':
							{
							alt17=8;
							}
							break;
					}
					}
					break;
			}
			switch (alt17) {
				case 1 :
					// Python.g:2573:10: 'r'
					{
					match('r'); 
					}
					break;
				case 2 :
					// Python.g:2573:14: 'u'
					{
					match('u'); 
					}
					break;
				case 3 :
					// Python.g:2573:18: 'b'
					{
					match('b'); 
					}
					break;
				case 4 :
					// Python.g:2573:22: 'ur'
					{
					match("ur"); 

					}
					break;
				case 5 :
					// Python.g:2573:27: 'br'
					{
					match("br"); 

					}
					break;
				case 6 :
					// Python.g:2573:32: 'R'
					{
					match('R'); 
					}
					break;
				case 7 :
					// Python.g:2573:36: 'U'
					{
					match('U'); 
					}
					break;
				case 8 :
					// Python.g:2573:40: 'B'
					{
					match('B'); 
					}
					break;
				case 9 :
					// Python.g:2573:44: 'UR'
					{
					match("UR"); 

					}
					break;
				case 10 :
					// Python.g:2573:49: 'BR'
					{
					match("BR"); 

					}
					break;
				case 11 :
					// Python.g:2573:54: 'uR'
					{
					match("uR"); 

					}
					break;
				case 12 :
					// Python.g:2573:59: 'Ur'
					{
					match("Ur"); 

					}
					break;
				case 13 :
					// Python.g:2573:64: 'Br'
					{
					match("Br"); 

					}
					break;
				case 14 :
					// Python.g:2573:69: 'bR'
					{
					match("bR"); 

					}
					break;
				case 15 :
					// Python.g:2573:74: 'rb'
					{
					match("rb"); 

					}
					break;
				case 16 :
					// Python.g:2573:79: 'rB'
					{
					match("rB"); 

					}
					break;
				case 17 :
					// Python.g:2573:84: 'Rb'
					{
					match("Rb"); 

					}
					break;
				case 18 :
					// Python.g:2573:89: 'RB'
					{
					match("RB"); 

					}
					break;

			}

			// Python.g:2574:9: ( '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"' | '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"' | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\'' )
			int alt22=4;
			int LA22_0 = input.LA(1);
			if ( (LA22_0=='\'') ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1=='\'') ) {
					int LA22_3 = input.LA(3);
					if ( (LA22_3=='\'') ) {
						alt22=1;
					}

					else {
						alt22=4;
					}

				}
				else if ( ((LA22_1 >= '\u0000' && LA22_1 <= '\t')||(LA22_1 >= '\u000B' && LA22_1 <= '&')||(LA22_1 >= '(' && LA22_1 <= '\uFFFF')) ) {
					alt22=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA22_0=='\"') ) {
				int LA22_2 = input.LA(2);
				if ( (LA22_2=='\"') ) {
					int LA22_5 = input.LA(3);
					if ( (LA22_5=='\"') ) {
						alt22=2;
					}

					else {
						alt22=3;
					}

				}
				else if ( ((LA22_2 >= '\u0000' && LA22_2 <= '\t')||(LA22_2 >= '\u000B' && LA22_2 <= '!')||(LA22_2 >= '#' && LA22_2 <= '\uFFFF')) ) {
					alt22=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// Python.g:2574:13: '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\''
					{
					match("'''"); 

					// Python.g:2574:22: ( options {greedy=false; } : TRIAPOS )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0=='\'') ) {
							int LA18_1 = input.LA(2);
							if ( (LA18_1=='\'') ) {
								int LA18_3 = input.LA(3);
								if ( (LA18_3=='\'') ) {
									alt18=2;
								}
								else if ( ((LA18_3 >= '\u0000' && LA18_3 <= '&')||(LA18_3 >= '(' && LA18_3 <= '\uFFFF')) ) {
									alt18=1;
								}

							}
							else if ( ((LA18_1 >= '\u0000' && LA18_1 <= '&')||(LA18_1 >= '(' && LA18_1 <= '\uFFFF')) ) {
								alt18=1;
							}

						}
						else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '&')||(LA18_0 >= '(' && LA18_0 <= '\uFFFF')) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// Python.g:2574:47: TRIAPOS
							{
							mTRIAPOS(); 

							}
							break;

						default :
							break loop18;
						}
					}

					match("'''"); 

					}
					break;
				case 2 :
					// Python.g:2575:13: '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"'
					{
					match("\"\"\""); 

					// Python.g:2575:19: ( options {greedy=false; } : TRIQUOTE )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0=='\"') ) {
							int LA19_1 = input.LA(2);
							if ( (LA19_1=='\"') ) {
								int LA19_3 = input.LA(3);
								if ( (LA19_3=='\"') ) {
									alt19=2;
								}
								else if ( ((LA19_3 >= '\u0000' && LA19_3 <= '!')||(LA19_3 >= '#' && LA19_3 <= '\uFFFF')) ) {
									alt19=1;
								}

							}
							else if ( ((LA19_1 >= '\u0000' && LA19_1 <= '!')||(LA19_1 >= '#' && LA19_1 <= '\uFFFF')) ) {
								alt19=1;
							}

						}
						else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '!')||(LA19_0 >= '#' && LA19_0 <= '\uFFFF')) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// Python.g:2575:44: TRIQUOTE
							{
							mTRIQUOTE(); 

							}
							break;

						default :
							break loop19;
						}
					}

					match("\"\"\""); 

					}
					break;
				case 3 :
					// Python.g:2576:13: '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"'
					{
					match('\"'); 
					// Python.g:2576:17: ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )*
					loop20:
					while (true) {
						int alt20=3;
						int LA20_0 = input.LA(1);
						if ( (LA20_0=='\\') ) {
							alt20=1;
						}
						else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '\t')||(LA20_0 >= '\u000B' && LA20_0 <= '!')||(LA20_0 >= '#' && LA20_0 <= '[')||(LA20_0 >= ']' && LA20_0 <= '\uFFFF')) ) {
							alt20=2;
						}

						switch (alt20) {
						case 1 :
							// Python.g:2576:18: ESC
							{
							mESC(); 

							}
							break;
						case 2 :
							// Python.g:2576:22: ~ ( '\\\\' | '\\n' | '\"' )
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop20;
						}
					}

					match('\"'); 
					}
					break;
				case 4 :
					// Python.g:2577:13: '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\''
					{
					match('\''); 
					// Python.g:2577:18: ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )*
					loop21:
					while (true) {
						int alt21=3;
						int LA21_0 = input.LA(1);
						if ( (LA21_0=='\\') ) {
							alt21=1;
						}
						else if ( ((LA21_0 >= '\u0000' && LA21_0 <= '\t')||(LA21_0 >= '\u000B' && LA21_0 <= '&')||(LA21_0 >= '(' && LA21_0 <= '[')||(LA21_0 >= ']' && LA21_0 <= '\uFFFF')) ) {
							alt21=2;
						}

						switch (alt21) {
						case 1 :
							// Python.g:2577:19: ESC
							{
							mESC(); 

							}
							break;
						case 2 :
							// Python.g:2577:23: ~ ( '\\\\' | '\\n' | '\\'' )
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop21;
						}
					}

					match('\''); 
					}
					break;

			}


			           if (state.tokenStartLine != input.getLine()) {
			               state.tokenStartLine = input.getLine();
			               state.tokenStartCharPositionInLine = -2;
			           }
			        
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "TRIQUOTE"
	public final void mTRIQUOTE() throws RecognitionException {
		try {
			// Python.g:2588:5: ( ( '\"' )? ( '\"' )? ( ESC |~ ( '\\\\' | '\"' ) )+ )
			// Python.g:2588:7: ( '\"' )? ( '\"' )? ( ESC |~ ( '\\\\' | '\"' ) )+
			{
			// Python.g:2588:7: ( '\"' )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0=='\"') ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// Python.g:2588:7: '\"'
					{
					match('\"'); 
					}
					break;

			}

			// Python.g:2588:12: ( '\"' )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0=='\"') ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// Python.g:2588:12: '\"'
					{
					match('\"'); 
					}
					break;

			}

			// Python.g:2588:17: ( ESC |~ ( '\\\\' | '\"' ) )+
			int cnt25=0;
			loop25:
			while (true) {
				int alt25=3;
				int LA25_0 = input.LA(1);
				if ( (LA25_0=='\\') ) {
					alt25=1;
				}
				else if ( ((LA25_0 >= '\u0000' && LA25_0 <= '!')||(LA25_0 >= '#' && LA25_0 <= '[')||(LA25_0 >= ']' && LA25_0 <= '\uFFFF')) ) {
					alt25=2;
				}

				switch (alt25) {
				case 1 :
					// Python.g:2588:18: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// Python.g:2588:22: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt25 >= 1 ) break loop25;
					EarlyExitException eee = new EarlyExitException(25, input);
					throw eee;
				}
				cnt25++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRIQUOTE"

	// $ANTLR start "TRIAPOS"
	public final void mTRIAPOS() throws RecognitionException {
		try {
			// Python.g:2594:5: ( ( '\\'' )? ( '\\'' )? ( ESC |~ ( '\\\\' | '\\'' ) )+ )
			// Python.g:2594:7: ( '\\'' )? ( '\\'' )? ( ESC |~ ( '\\\\' | '\\'' ) )+
			{
			// Python.g:2594:7: ( '\\'' )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0=='\'') ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// Python.g:2594:7: '\\''
					{
					match('\''); 
					}
					break;

			}

			// Python.g:2594:13: ( '\\'' )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0=='\'') ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// Python.g:2594:13: '\\''
					{
					match('\''); 
					}
					break;

			}

			// Python.g:2594:19: ( ESC |~ ( '\\\\' | '\\'' ) )+
			int cnt28=0;
			loop28:
			while (true) {
				int alt28=3;
				int LA28_0 = input.LA(1);
				if ( (LA28_0=='\\') ) {
					alt28=1;
				}
				else if ( ((LA28_0 >= '\u0000' && LA28_0 <= '&')||(LA28_0 >= '(' && LA28_0 <= '[')||(LA28_0 >= ']' && LA28_0 <= '\uFFFF')) ) {
					alt28=2;
				}

				switch (alt28) {
				case 1 :
					// Python.g:2594:20: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// Python.g:2594:24: ~ ( '\\\\' | '\\'' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt28 >= 1 ) break loop28;
					EarlyExitException eee = new EarlyExitException(28, input);
					throw eee;
				}
				cnt28++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRIAPOS"

	// $ANTLR start "ESC"
	public final void mESC() throws RecognitionException {
		try {
			// Python.g:2598:5: ( '\\\\' . )
			// Python.g:2598:10: '\\\\' .
			{
			match('\\'); 
			matchAny(); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC"

	// $ANTLR start "CONTINUED_LINE"
	public final void mCONTINUED_LINE() throws RecognitionException {
		try {
			int _type = CONTINUED_LINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken nl=null;

			// Python.g:2609:5: ( '\\\\' ( '\\r' )? '\\n' ( ' ' | '\\t' )* ( COMMENT |nl= NEWLINE |) )
			// Python.g:2609:10: '\\\\' ( '\\r' )? '\\n' ( ' ' | '\\t' )* ( COMMENT |nl= NEWLINE |)
			{
			match('\\'); 
			// Python.g:2609:15: ( '\\r' )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0=='\r') ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// Python.g:2609:16: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			// Python.g:2609:28: ( ' ' | '\\t' )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0=='\t'||LA30_0==' ') ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// Python.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop30;
				}
			}

			 _channel=HIDDEN; 
			// Python.g:2610:10: ( COMMENT |nl= NEWLINE |)
			int alt31=3;
			int LA31_0 = input.LA(1);
			if ( (LA31_0=='\t'||LA31_0==' ') && ((startPos==0))) {
				alt31=1;
			}
			else if ( (LA31_0=='#') ) {
				alt31=1;
			}
			else if ( (LA31_0=='\n'||(LA31_0 >= '\f' && LA31_0 <= '\r')) ) {
				alt31=2;
			}

			else {
				alt31=3;
			}

			switch (alt31) {
				case 1 :
					// Python.g:2610:12: COMMENT
					{
					mCOMMENT(); 

					}
					break;
				case 2 :
					// Python.g:2611:12: nl= NEWLINE
					{
					int nlStart1700 = getCharIndex();
					int nlStartLine1700 = getLine();
					int nlStartCharPos1700 = getCharPositionInLine();
					mNEWLINE(); 
					nl = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, nlStart1700, getCharIndex()-1);
					nl.setLine(nlStartLine1700);
					nl.setCharPositionInLine(nlStartCharPos1700);


					               emit(new CommonToken(NEWLINE,nl.getText()));
					           
					}
					break;
				case 3 :
					// Python.g:2616:10: 
					{
					}
					break;

			}


			               if (input.LA(1) == -1) {
			                   throw new ParseException("unexpected character after line continuation character");
			               }
			           
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUED_LINE"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			    int newlines = 0;

			// Python.g:2635:5: ( ( ( '\\u000C' )? ( '\\r' )? '\\n' )+ )
			// Python.g:2635:9: ( ( '\\u000C' )? ( '\\r' )? '\\n' )+
			{
			// Python.g:2635:9: ( ( '\\u000C' )? ( '\\r' )? '\\n' )+
			int cnt34=0;
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0=='\n'||(LA34_0 >= '\f' && LA34_0 <= '\r')) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// Python.g:2635:10: ( '\\u000C' )? ( '\\r' )? '\\n'
					{
					// Python.g:2635:10: ( '\\u000C' )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0=='\f') ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// Python.g:2635:11: '\\u000C'
							{
							match('\f'); 
							}
							break;

					}

					// Python.g:2635:21: ( '\\r' )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0=='\r') ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// Python.g:2635:22: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					newlines++; 
					}
					break;

				default :
					if ( cnt34 >= 1 ) break loop34;
					EarlyExitException eee = new EarlyExitException(34, input);
					throw eee;
				}
				cnt34++;
			}


			         if ( startPos==0 || implicitLineJoiningLevel>0 )
			            _channel=HIDDEN;
			        
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Python.g:2635:5: ({...}? => ( ' ' | '\\t' | '\\u000C' )+ )
			// Python.g:2635:10: {...}? => ( ' ' | '\\t' | '\\u000C' )+
			{
			if ( !((startPos>0)) ) {
				throw new FailedPredicateException(input, "WS", "startPos>0");
			}
			// Python.g:2635:26: ( ' ' | '\\t' | '\\u000C' )+
			int cnt35=0;
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0=='\t'||LA35_0=='\f'||LA35_0==' ') ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// Python.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt35 >= 1 ) break loop35;
					EarlyExitException eee = new EarlyExitException(35, input);
					throw eee;
				}
				cnt35++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "LEADING_WS"
	public final void mLEADING_WS() throws RecognitionException {
		try {
			int _type = LEADING_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			    int spaces = 0;
			    int newlines = 0;

			// Python.g:2655:5: ({...}? => ({...}? ( ' ' | '\\t' )+ | ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* ) )
			// Python.g:2655:9: {...}? => ({...}? ( ' ' | '\\t' )+ | ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* )
			{
			if ( !((startPos==0)) ) {
				throw new FailedPredicateException(input, "LEADING_WS", "startPos==0");
			}
			// Python.g:2656:9: ({...}? ( ' ' | '\\t' )+ | ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==' ') ) {
				int LA40_1 = input.LA(2);
				if ( ((implicitLineJoiningLevel>0)) ) {
					alt40=1;
				}
				else if ( (true) ) {
					alt40=2;
				}

			}
			else if ( (LA40_0=='\t') ) {
				int LA40_2 = input.LA(2);
				if ( ((implicitLineJoiningLevel>0)) ) {
					alt40=1;
				}
				else if ( (true) ) {
					alt40=2;
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// Python.g:2656:13: {...}? ( ' ' | '\\t' )+
					{
					if ( !((implicitLineJoiningLevel>0)) ) {
						throw new FailedPredicateException(input, "LEADING_WS", "implicitLineJoiningLevel>0");
					}
					// Python.g:2656:43: ( ' ' | '\\t' )+
					int cnt36=0;
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0=='\t'||LA36_0==' ') ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// Python.g:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt36 >= 1 ) break loop36;
							EarlyExitException eee = new EarlyExitException(36, input);
							throw eee;
						}
						cnt36++;
					}

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// Python.g:2657:14: ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )*
					{
					// Python.g:2657:14: ( ' ' | '\\t' )+
					int cnt37=0;
					loop37:
					while (true) {
						int alt37=3;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==' ') ) {
							alt37=1;
						}
						else if ( (LA37_0=='\t') ) {
							alt37=2;
						}

						switch (alt37) {
						case 1 :
							// Python.g:2657:20: ' '
							{
							match(' '); 
							 spaces++; 
							}
							break;
						case 2 :
							// Python.g:2658:19: '\\t'
							{
							match('\t'); 
							 spaces += 8; spaces -= (spaces % 8); 
							}
							break;

						default :
							if ( cnt37 >= 1 ) break loop37;
							EarlyExitException eee = new EarlyExitException(37, input);
							throw eee;
						}
						cnt37++;
					}

					// Python.g:2660:14: ( ( '\\r' )? '\\n' )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0=='\n'||LA39_0=='\r') ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// Python.g:2660:16: ( '\\r' )? '\\n'
							{
							// Python.g:2660:16: ( '\\r' )?
							int alt38=2;
							int LA38_0 = input.LA(1);
							if ( (LA38_0=='\r') ) {
								alt38=1;
							}
							switch (alt38) {
								case 1 :
									// Python.g:2660:17: '\\r'
									{
									match('\r'); 
									}
									break;

							}

							match('\n'); 
							newlines++; 
							}
							break;

						default :
							break loop39;
						}
					}


					                   if (input.LA(1) != -1 || newlines == 0) {
					                       // make a string of n spaces where n is column number - 1
					                       char[] indentation = new char[spaces];
					                       for (int i=0; i<spaces; i++) {
					                           indentation[i] = ' ';
					                       }
					                       CommonToken c = new CommonToken(LEADING_WS,new String(indentation));
					                       c.setLine(input.getLine());
					                       c.setCharPositionInLine(input.getCharPositionInLine());
					                       c.setStartIndex(input.index() - 1);
					                       c.setStopIndex(input.index() - 1);
					                       emit(c);
					                       // kill trailing newline if present and then ignore
					                       if (newlines != 0) {
					                           if (state.token!=null) {
					                               state.token.setChannel(HIDDEN);
					                           } else {
					                               _channel=HIDDEN;
					                           }
					                       }
					                   } else if (this.single && newlines == 1) {
					                       // This is here for this case in interactive mode:
					                       //
					                       // def foo():
					                       //   print 1
					                       //   <spaces but no code>
					                       //
					                       // The above would complete in interactive mode instead
					                       // of giving ... to wait for more input.
					                       //
					                       throw new ParseException("Trailing space in single mode.");
					                   } else {
					                       // make a string of n newlines
					                       char[] nls = new char[newlines];
					                       for (int i=0; i<newlines; i++) {
					                           nls[i] = '\n';
					                       }
					                       CommonToken c = new CommonToken(NEWLINE,new String(nls));
					                       c.setLine(input.getLine());
					                       c.setCharPositionInLine(input.getCharPositionInLine());
					                       c.setStartIndex(input.index() - 1);
					                       c.setStopIndex(input.index() - 1);
					                       emit(c);
					                   }
					                
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEADING_WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			    _channel=HIDDEN;

			// Python.g:2742:5: ({...}? => ( ' ' | '\\t' )* '#' (~ '\\n' )* ( '\\n' )+ | '#' (~ '\\n' )* )
			int alt45=2;
			alt45 = dfa45.predict(input);
			switch (alt45) {
				case 1 :
					// Python.g:2742:10: {...}? => ( ' ' | '\\t' )* '#' (~ '\\n' )* ( '\\n' )+
					{
					if ( !((startPos==0)) ) {
						throw new FailedPredicateException(input, "COMMENT", "startPos==0");
					}
					// Python.g:2742:27: ( ' ' | '\\t' )*
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0=='\t'||LA41_0==' ') ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// Python.g:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop41;
						}
					}

					match('#'); 
					// Python.g:2742:43: (~ '\\n' )*
					loop42:
					while (true) {
						int alt42=2;
						int LA42_0 = input.LA(1);
						if ( ((LA42_0 >= '\u0000' && LA42_0 <= '\t')||(LA42_0 >= '\u000B' && LA42_0 <= '\uFFFF')) ) {
							alt42=1;
						}

						switch (alt42) {
						case 1 :
							// Python.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop42;
						}
					}

					// Python.g:2742:52: ( '\\n' )+
					int cnt43=0;
					loop43:
					while (true) {
						int alt43=2;
						int LA43_0 = input.LA(1);
						if ( (LA43_0=='\n') ) {
							alt43=1;
						}

						switch (alt43) {
						case 1 :
							// Python.g:2742:52: '\\n'
							{
							match('\n'); 
							}
							break;

						default :
							if ( cnt43 >= 1 ) break loop43;
							EarlyExitException eee = new EarlyExitException(43, input);
							throw eee;
						}
						cnt43++;
					}

					}
					break;
				case 2 :
					// Python.g:2743:10: '#' (~ '\\n' )*
					{
					match('#'); 
					// Python.g:2743:14: (~ '\\n' )*
					loop44:
					while (true) {
						int alt44=2;
						int LA44_0 = input.LA(1);
						if ( ((LA44_0 >= '\u0000' && LA44_0 <= '\t')||(LA44_0 >= '\u000B' && LA44_0 <= '\uFFFF')) ) {
							alt44=1;
						}

						switch (alt44) {
						case 1 :
							// Python.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop44;
						}
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// Python.g:1:8: ( AS | ASSERT | ASYNC | AWAIT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NONLOCAL | ORELSE | PASS | RAISE | RETURN | TRY | WHILE | WITH | YIELD | LPAREN | RPAREN | LBRACK | RBRACK | COLON | COMMA | SEMI | PLUS | MINUS | STAR | SLASH | VBAR | AMPER | LESS | GREATER | ASSIGN | PERCENT | BACKQUOTE | LCURLY | RCURLY | CIRCUMFLEX | TILDE | EQUAL | NOTEQUAL | ALT_NOTEQUAL | LESSEQUAL | LEFTSHIFT | GREATEREQUAL | RIGHTSHIFT | PLUSEQUAL | MINUSEQUAL | DOUBLESTAR | STAREQUAL | ATEQUAL | DOUBLESLASH | SLASHEQUAL | VBAREQUAL | PERCENTEQUAL | AMPEREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL | ARROW | DOT | AT | AND | OR | NOT | FLOAT | LONGINT | INT | COMPLEX | NAME | STRING | CONTINUED_LINE | NEWLINE | WS | LEADING_WS | COMMENT )
		int alt46=91;
		alt46 = dfa46.predict(input);
		switch (alt46) {
			case 1 :
				// Python.g:1:10: AS
				{
				mAS(); 

				}
				break;
			case 2 :
				// Python.g:1:13: ASSERT
				{
				mASSERT(); 

				}
				break;
			case 3 :
				// Python.g:1:20: ASYNC
				{
				mASYNC(); 

				}
				break;
			case 4 :
				// Python.g:1:26: AWAIT
				{
				mAWAIT(); 

				}
				break;
			case 5 :
				// Python.g:1:32: BREAK
				{
				mBREAK(); 

				}
				break;
			case 6 :
				// Python.g:1:38: CLASS
				{
				mCLASS(); 

				}
				break;
			case 7 :
				// Python.g:1:44: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 8 :
				// Python.g:1:53: DEF
				{
				mDEF(); 

				}
				break;
			case 9 :
				// Python.g:1:57: DELETE
				{
				mDELETE(); 

				}
				break;
			case 10 :
				// Python.g:1:64: ELIF
				{
				mELIF(); 

				}
				break;
			case 11 :
				// Python.g:1:69: EXCEPT
				{
				mEXCEPT(); 

				}
				break;
			case 12 :
				// Python.g:1:76: EXEC
				{
				mEXEC(); 

				}
				break;
			case 13 :
				// Python.g:1:81: FINALLY
				{
				mFINALLY(); 

				}
				break;
			case 14 :
				// Python.g:1:89: FROM
				{
				mFROM(); 

				}
				break;
			case 15 :
				// Python.g:1:94: FOR
				{
				mFOR(); 

				}
				break;
			case 16 :
				// Python.g:1:98: GLOBAL
				{
				mGLOBAL(); 

				}
				break;
			case 17 :
				// Python.g:1:105: IF
				{
				mIF(); 

				}
				break;
			case 18 :
				// Python.g:1:108: IMPORT
				{
				mIMPORT(); 

				}
				break;
			case 19 :
				// Python.g:1:115: IN
				{
				mIN(); 

				}
				break;
			case 20 :
				// Python.g:1:118: IS
				{
				mIS(); 

				}
				break;
			case 21 :
				// Python.g:1:121: LAMBDA
				{
				mLAMBDA(); 

				}
				break;
			case 22 :
				// Python.g:1:128: NONLOCAL
				{
				mNONLOCAL(); 

				}
				break;
			case 23 :
				// Python.g:1:137: ORELSE
				{
				mORELSE(); 

				}
				break;
			case 24 :
				// Python.g:1:144: PASS
				{
				mPASS(); 

				}
				break;
			case 25 :
				// Python.g:1:149: RAISE
				{
				mRAISE(); 

				}
				break;
			case 26 :
				// Python.g:1:155: RETURN
				{
				mRETURN(); 

				}
				break;
			case 27 :
				// Python.g:1:162: TRY
				{
				mTRY(); 

				}
				break;
			case 28 :
				// Python.g:1:166: WHILE
				{
				mWHILE(); 

				}
				break;
			case 29 :
				// Python.g:1:172: WITH
				{
				mWITH(); 

				}
				break;
			case 30 :
				// Python.g:1:177: YIELD
				{
				mYIELD(); 

				}
				break;
			case 31 :
				// Python.g:1:183: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 32 :
				// Python.g:1:190: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 33 :
				// Python.g:1:197: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 34 :
				// Python.g:1:204: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 35 :
				// Python.g:1:211: COLON
				{
				mCOLON(); 

				}
				break;
			case 36 :
				// Python.g:1:217: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 37 :
				// Python.g:1:223: SEMI
				{
				mSEMI(); 

				}
				break;
			case 38 :
				// Python.g:1:228: PLUS
				{
				mPLUS(); 

				}
				break;
			case 39 :
				// Python.g:1:233: MINUS
				{
				mMINUS(); 

				}
				break;
			case 40 :
				// Python.g:1:239: STAR
				{
				mSTAR(); 

				}
				break;
			case 41 :
				// Python.g:1:244: SLASH
				{
				mSLASH(); 

				}
				break;
			case 42 :
				// Python.g:1:250: VBAR
				{
				mVBAR(); 

				}
				break;
			case 43 :
				// Python.g:1:255: AMPER
				{
				mAMPER(); 

				}
				break;
			case 44 :
				// Python.g:1:261: LESS
				{
				mLESS(); 

				}
				break;
			case 45 :
				// Python.g:1:266: GREATER
				{
				mGREATER(); 

				}
				break;
			case 46 :
				// Python.g:1:274: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 47 :
				// Python.g:1:281: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 48 :
				// Python.g:1:289: BACKQUOTE
				{
				mBACKQUOTE(); 

				}
				break;
			case 49 :
				// Python.g:1:299: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 50 :
				// Python.g:1:306: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 51 :
				// Python.g:1:313: CIRCUMFLEX
				{
				mCIRCUMFLEX(); 

				}
				break;
			case 52 :
				// Python.g:1:324: TILDE
				{
				mTILDE(); 

				}
				break;
			case 53 :
				// Python.g:1:330: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 54 :
				// Python.g:1:336: NOTEQUAL
				{
				mNOTEQUAL(); 

				}
				break;
			case 55 :
				// Python.g:1:345: ALT_NOTEQUAL
				{
				mALT_NOTEQUAL(); 

				}
				break;
			case 56 :
				// Python.g:1:358: LESSEQUAL
				{
				mLESSEQUAL(); 

				}
				break;
			case 57 :
				// Python.g:1:368: LEFTSHIFT
				{
				mLEFTSHIFT(); 

				}
				break;
			case 58 :
				// Python.g:1:378: GREATEREQUAL
				{
				mGREATEREQUAL(); 

				}
				break;
			case 59 :
				// Python.g:1:391: RIGHTSHIFT
				{
				mRIGHTSHIFT(); 

				}
				break;
			case 60 :
				// Python.g:1:402: PLUSEQUAL
				{
				mPLUSEQUAL(); 

				}
				break;
			case 61 :
				// Python.g:1:412: MINUSEQUAL
				{
				mMINUSEQUAL(); 

				}
				break;
			case 62 :
				// Python.g:1:423: DOUBLESTAR
				{
				mDOUBLESTAR(); 

				}
				break;
			case 63 :
				// Python.g:1:434: STAREQUAL
				{
				mSTAREQUAL(); 

				}
				break;
			case 64 :
				// Python.g:1:444: ATEQUAL
				{
				mATEQUAL(); 

				}
				break;
			case 65 :
				// Python.g:1:452: DOUBLESLASH
				{
				mDOUBLESLASH(); 

				}
				break;
			case 66 :
				// Python.g:1:464: SLASHEQUAL
				{
				mSLASHEQUAL(); 

				}
				break;
			case 67 :
				// Python.g:1:475: VBAREQUAL
				{
				mVBAREQUAL(); 

				}
				break;
			case 68 :
				// Python.g:1:485: PERCENTEQUAL
				{
				mPERCENTEQUAL(); 

				}
				break;
			case 69 :
				// Python.g:1:498: AMPEREQUAL
				{
				mAMPEREQUAL(); 

				}
				break;
			case 70 :
				// Python.g:1:509: CIRCUMFLEXEQUAL
				{
				mCIRCUMFLEXEQUAL(); 

				}
				break;
			case 71 :
				// Python.g:1:525: LEFTSHIFTEQUAL
				{
				mLEFTSHIFTEQUAL(); 

				}
				break;
			case 72 :
				// Python.g:1:540: RIGHTSHIFTEQUAL
				{
				mRIGHTSHIFTEQUAL(); 

				}
				break;
			case 73 :
				// Python.g:1:556: DOUBLESTAREQUAL
				{
				mDOUBLESTAREQUAL(); 

				}
				break;
			case 74 :
				// Python.g:1:572: DOUBLESLASHEQUAL
				{
				mDOUBLESLASHEQUAL(); 

				}
				break;
			case 75 :
				// Python.g:1:589: ARROW
				{
				mARROW(); 

				}
				break;
			case 76 :
				// Python.g:1:595: DOT
				{
				mDOT(); 

				}
				break;
			case 77 :
				// Python.g:1:599: AT
				{
				mAT(); 

				}
				break;
			case 78 :
				// Python.g:1:602: AND
				{
				mAND(); 

				}
				break;
			case 79 :
				// Python.g:1:606: OR
				{
				mOR(); 

				}
				break;
			case 80 :
				// Python.g:1:609: NOT
				{
				mNOT(); 

				}
				break;
			case 81 :
				// Python.g:1:613: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 82 :
				// Python.g:1:619: LONGINT
				{
				mLONGINT(); 

				}
				break;
			case 83 :
				// Python.g:1:627: INT
				{
				mINT(); 

				}
				break;
			case 84 :
				// Python.g:1:631: COMPLEX
				{
				mCOMPLEX(); 

				}
				break;
			case 85 :
				// Python.g:1:639: NAME
				{
				mNAME(); 

				}
				break;
			case 86 :
				// Python.g:1:644: STRING
				{
				mSTRING(); 

				}
				break;
			case 87 :
				// Python.g:1:651: CONTINUED_LINE
				{
				mCONTINUED_LINE(); 

				}
				break;
			case 88 :
				// Python.g:1:666: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 89 :
				// Python.g:1:674: WS
				{
				mWS(); 

				}
				break;
			case 90 :
				// Python.g:1:677: LEADING_WS
				{
				mLEADING_WS(); 

				}
				break;
			case 91 :
				// Python.g:1:688: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	protected DFA14 dfa14 = new DFA14(this);
	protected DFA45 dfa45 = new DFA45(this);
	protected DFA46 dfa46 = new DFA46(this);
	static final String DFA5_eotS =
		"\3\uffff\1\4\2\uffff";
	static final String DFA5_eofS =
		"\6\uffff";
	static final String DFA5_minS =
		"\1\56\1\uffff\1\56\1\105\2\uffff";
	static final String DFA5_maxS =
		"\1\71\1\uffff\2\145\2\uffff";
	static final String DFA5_acceptS =
		"\1\uffff\1\1\2\uffff\1\3\1\2";
	static final String DFA5_specialS =
		"\6\uffff}>";
	static final String[] DFA5_transitionS = {
			"\1\1\1\uffff\12\2",
			"",
			"\1\3\1\uffff\12\2\13\uffff\1\4\37\uffff\1\4",
			"\1\5\37\uffff\1\5",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "2525:1: FLOAT : ( '.' DIGITS ( Exponent )? | DIGITS '.' Exponent | DIGITS ( '.' ( DIGITS ( Exponent )? )? | Exponent ) );";
		}
	}

	static final String DFA14_eotS =
		"\4\uffff";
	static final String DFA14_eofS =
		"\4\uffff";
	static final String DFA14_minS =
		"\2\56\2\uffff";
	static final String DFA14_maxS =
		"\1\71\1\152\2\uffff";
	static final String DFA14_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA14_specialS =
		"\4\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\2\1\uffff\12\1\13\uffff\1\2\4\uffff\1\3\32\uffff\1\2\4\uffff\1\3",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "2551:1: COMPLEX : ( ( DIGITS )+ ( 'j' | 'J' ) | FLOAT ( 'j' | 'J' ) );";
		}
	}

	static final String DFA45_eotS =
		"\2\uffff\2\4\1\uffff";
	static final String DFA45_eofS =
		"\5\uffff";
	static final String DFA45_minS =
		"\1\11\1\uffff\2\0\1\uffff";
	static final String DFA45_maxS =
		"\1\43\1\uffff\2\uffff\1\uffff";
	static final String DFA45_acceptS =
		"\1\uffff\1\1\2\uffff\1\2";
	static final String DFA45_specialS =
		"\1\1\1\uffff\1\0\1\2\1\uffff}>";
	static final String[] DFA45_transitionS = {
			"\1\1\26\uffff\1\1\2\uffff\1\2",
			"",
			"\12\3\1\1\ufff5\3",
			"\12\3\1\1\ufff5\3",
			""
	};

	static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
	static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
	static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
	static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
	static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
	static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
	static final short[][] DFA45_transition;

	static {
		int numStates = DFA45_transitionS.length;
		DFA45_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
		}
	}

	protected class DFA45 extends DFA {

		public DFA45(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 45;
			this.eot = DFA45_eot;
			this.eof = DFA45_eof;
			this.min = DFA45_min;
			this.max = DFA45_max;
			this.accept = DFA45_accept;
			this.special = DFA45_special;
			this.transition = DFA45_transition;
		}
		@Override
		public String getDescription() {
			return "2738:1: COMMENT : ({...}? => ( ' ' | '\\t' )* '#' (~ '\\n' )* ( '\\n' )+ | '#' (~ '\\n' )* );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA45_2 = input.LA(1);
						 
						int index45_2 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA45_2 >= '\u0000' && LA45_2 <= '\t')||(LA45_2 >= '\u000B' && LA45_2 <= '\uFFFF')) ) {s = 3;}
						else if ( (LA45_2=='\n') && ((startPos==0))) {s = 1;}
						else s = 4;
						 
						input.seek(index45_2);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA45_0 = input.LA(1);
						 
						int index45_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA45_0=='\t'||LA45_0==' ') && ((startPos==0))) {s = 1;}
						else if ( (LA45_0=='#') ) {s = 2;}
						 
						input.seek(index45_0);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA45_3 = input.LA(1);
						 
						int index45_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA45_3=='\n') && ((startPos==0))) {s = 1;}
						else if ( ((LA45_3 >= '\u0000' && LA45_3 <= '\t')||(LA45_3 >= '\u000B' && LA45_3 <= '\uFFFF')) ) {s = 3;}
						else s = 4;
						 
						input.seek(index45_3);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 45, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA46_eotS =
		"\1\uffff\17\60\7\uffff\1\126\1\131\1\134\1\137\1\141\1\143\1\147\1\152"+
		"\1\154\1\156\3\uffff\1\160\2\uffff\1\162\1\163\1\60\2\171\4\60\3\uffff"+
		"\1\u0089\1\uffff\2\u008a\1\uffff\1\u008f\15\60\1\u009f\1\60\1\u00a1\1"+
		"\u00a2\13\60\5\uffff\1\u00ae\2\uffff\1\u00b0\10\uffff\1\u00b2\2\uffff"+
		"\1\u00b4\12\uffff\1\u00b5\1\u00b7\1\uffff\2\171\1\uffff\1\u00b5\1\171"+
		"\4\uffff\1\171\10\60\4\uffff\2\60\1\uffff\1\60\1\u00c2\3\60\1\u00c6\1"+
		"\u00c7\6\60\1\u00ce\1\60\1\uffff\1\60\2\uffff\2\60\1\u00d3\3\60\1\u00d7"+
		"\3\60\13\uffff\3\171\1\uffff\1\u00b5\1\uffff\1\u00b5\3\60\1\uffff\3\60"+
		"\2\uffff\1\u00e6\1\u00e7\3\60\1\u00eb\1\uffff\4\60\1\uffff\1\u00f0\2\60"+
		"\1\uffff\1\60\1\u00f4\1\60\1\uffff\1\u00b5\1\uffff\1\u00b5\1\uffff\1\60"+
		"\1\u00f9\1\u00fa\1\u00fb\1\u00fc\1\60\2\uffff\1\60\1\u00ff\1\60\1\uffff"+
		"\4\60\1\uffff\1\u0105\1\60\1\u0107\1\uffff\1\u0108\1\uffff\1\u00b5\1\u0109"+
		"\4\uffff\1\60\1\u010b\1\uffff\1\60\1\u010d\1\u010e\1\u010f\1\60\1\uffff"+
		"\1\u0111\3\uffff\1\60\1\uffff\1\u0113\3\uffff\1\60\1\uffff\1\u0115\1\uffff"+
		"\1\u0116\2\uffff";
	static final String DFA46_eofS =
		"\u0117\uffff";
	static final String DFA46_minS =
		"\1\11\1\156\1\42\1\154\1\145\1\154\1\151\1\154\1\146\1\141\1\157\1\141"+
		"\1\42\1\162\1\150\1\151\7\uffff\2\75\1\52\1\57\2\75\1\74\3\75\3\uffff"+
		"\1\75\2\uffff\1\75\1\60\1\162\2\56\4\42\3\uffff\1\12\1\uffff\2\11\1\uffff"+
		"\1\60\1\141\1\144\2\42\1\141\1\156\1\146\1\151\1\143\1\156\1\157\1\162"+
		"\1\157\1\60\1\160\2\60\1\155\1\156\1\163\1\151\1\164\2\42\1\171\1\151"+
		"\1\164\1\145\5\uffff\1\75\2\uffff\1\75\10\uffff\1\75\2\uffff\1\75\12\uffff"+
		"\5\60\1\uffff\1\60\1\56\1\53\1\56\2\uffff\1\56\10\42\1\uffff\1\0\2\uffff"+
		"\1\145\1\156\1\uffff\1\151\1\60\1\141\1\163\1\164\2\60\1\146\2\145\1\143"+
		"\1\141\1\155\1\60\1\142\1\uffff\1\157\2\uffff\1\142\1\154\1\60\2\163\1"+
		"\165\1\60\1\154\1\150\1\154\11\uffff\1\53\1\uffff\3\60\1\53\3\60\1\162"+
		"\1\143\1\164\1\uffff\1\153\1\163\1\151\2\uffff\2\60\1\160\1\61\1\154\1"+
		"\60\1\uffff\1\141\1\162\1\144\1\157\1\uffff\1\60\1\145\1\162\1\uffff\1"+
		"\145\1\60\1\144\4\60\1\53\1\164\4\60\1\156\2\uffff\1\164\1\60\1\154\1"+
		"\uffff\1\154\1\164\1\141\1\143\1\uffff\1\60\1\156\1\60\1\uffff\4\60\4"+
		"\uffff\1\165\1\60\1\uffff\1\171\3\60\1\141\1\uffff\1\60\3\uffff\1\145"+
		"\1\uffff\1\60\3\uffff\1\154\1\uffff\1\60\1\uffff\1\60\2\uffff";
	static final String DFA46_maxS =
		"\1\ufffe\1\167\1\162\1\157\1\145\1\170\1\162\1\154\1\163\1\141\1\157\1"+
		"\141\1\145\1\162\2\151\7\uffff\1\75\1\76\4\75\2\76\2\75\3\uffff\1\75\2"+
		"\uffff\1\75\1\71\1\162\1\170\1\154\1\162\1\142\2\162\3\uffff\1\15\1\uffff"+
		"\2\43\1\uffff\1\ufffe\1\141\1\144\1\145\1\47\1\141\1\156\1\154\1\163\1"+
		"\145\1\156\1\157\1\162\1\157\1\ufffe\1\160\2\ufffe\1\155\1\164\1\163\1"+
		"\151\1\164\2\47\1\171\1\151\1\164\1\145\5\uffff\1\75\2\uffff\1\75\10\uffff"+
		"\1\75\2\uffff\1\75\12\uffff\1\152\1\ufffe\1\146\2\154\1\uffff\1\152\1"+
		"\154\1\71\1\152\2\uffff\1\154\10\47\1\uffff\1\0\2\uffff\1\145\1\156\1"+
		"\uffff\1\151\1\ufffe\1\141\1\163\1\164\2\ufffe\1\146\2\145\1\143\1\141"+
		"\1\155\1\ufffe\1\142\1\uffff\1\157\2\uffff\1\142\1\154\1\ufffe\2\163\1"+
		"\165\1\ufffe\1\154\1\150\1\154\11\uffff\1\71\1\uffff\3\154\1\71\1\152"+
		"\1\71\1\152\1\162\1\143\1\164\1\uffff\1\153\1\163\1\151\2\uffff\2\ufffe"+
		"\1\160\1\61\1\154\1\ufffe\1\uffff\1\141\1\162\1\144\1\157\1\uffff\1\ufffe"+
		"\1\145\1\162\1\uffff\1\145\1\ufffe\1\144\1\71\1\152\1\71\1\152\1\71\1"+
		"\164\4\ufffe\1\156\2\uffff\1\164\1\ufffe\1\154\1\uffff\1\154\1\164\1\141"+
		"\1\143\1\uffff\1\ufffe\1\156\1\ufffe\1\uffff\1\ufffe\1\71\1\152\1\ufffe"+
		"\4\uffff\1\165\1\ufffe\1\uffff\1\171\3\ufffe\1\141\1\uffff\1\ufffe\3\uffff"+
		"\1\145\1\uffff\1\ufffe\3\uffff\1\154\1\uffff\1\ufffe\1\uffff\1\ufffe\2"+
		"\uffff";
	static final String DFA46_acceptS =
		"\20\uffff\1\37\1\40\1\41\1\42\1\43\1\44\1\45\12\uffff\1\60\1\61\1\62\1"+
		"\uffff\1\64\1\66\11\uffff\1\125\1\126\1\127\1\uffff\1\130\2\uffff\1\133"+
		"\35\uffff\1\74\1\46\1\75\1\113\1\47\1\uffff\1\77\1\50\1\uffff\1\102\1"+
		"\51\1\103\1\52\1\105\1\53\1\67\1\70\1\uffff\1\54\1\72\1\uffff\1\55\1\65"+
		"\1\56\1\104\1\57\1\106\1\63\1\100\1\115\1\114\5\uffff\1\123\4\uffff\1"+
		"\122\1\124\11\uffff\1\131\1\uffff\1\132\1\133\2\uffff\1\1\17\uffff\1\21"+
		"\1\uffff\1\23\1\24\12\uffff\1\111\1\76\1\112\1\101\1\107\1\71\1\110\1"+
		"\73\1\121\1\uffff\1\117\12\uffff\1\116\3\uffff\1\10\1\11\6\uffff\1\17"+
		"\4\uffff\1\120\3\uffff\1\33\16\uffff\1\12\1\27\3\uffff\1\16\4\uffff\1"+
		"\30\3\uffff\1\35\4\uffff\1\3\1\4\1\5\1\6\2\uffff\1\14\5\uffff\1\31\1\uffff"+
		"\1\34\1\36\1\2\1\uffff\1\13\1\uffff\1\20\1\22\1\25\1\uffff\1\32\1\uffff"+
		"\1\15\1\uffff\1\7\1\26";
	static final String DFA46_specialS =
		"\1\1\62\uffff\1\0\1\uffff\1\2\1\3\123\uffff\1\4\u008c\uffff}>";
	static final String[] DFA46_transitionS = {
			"\1\66\1\64\1\uffff\1\63\1\64\22\uffff\1\65\1\46\1\61\1\67\1\uffff\1\40"+
			"\1\34\1\61\1\20\1\21\1\31\1\27\1\25\1\30\1\50\1\32\1\52\11\53\1\24\1"+
			"\26\1\35\1\37\1\36\1\uffff\1\47\1\60\1\57\17\60\1\55\2\60\1\56\5\60\1"+
			"\22\1\62\1\23\1\44\1\60\1\41\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\60\1\10\2"+
			"\60\1\11\1\60\1\12\1\51\1\13\1\60\1\14\1\60\1\15\1\54\1\60\1\16\1\60"+
			"\1\17\1\60\1\42\1\33\1\43\1\45\101\uffff\27\60\1\uffff\37\60\1\uffff"+
			"\uff07\60",
			"\1\72\4\uffff\1\70\3\uffff\1\71",
			"\1\61\4\uffff\1\61\52\uffff\1\74\37\uffff\1\73",
			"\1\75\2\uffff\1\76",
			"\1\77",
			"\1\100\13\uffff\1\101",
			"\1\102\5\uffff\1\104\2\uffff\1\103",
			"\1\105",
			"\1\106\6\uffff\1\107\1\110\4\uffff\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\61\4\uffff\1\61\32\uffff\1\120\36\uffff\1\115\1\117\2\uffff\1\116",
			"\1\121",
			"\1\122\1\123",
			"\1\124",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\125",
			"\1\127\1\130",
			"\1\132\22\uffff\1\133",
			"\1\135\15\uffff\1\136",
			"\1\140",
			"\1\142",
			"\1\146\1\145\1\144",
			"\1\150\1\151",
			"\1\153",
			"\1\155",
			"",
			"",
			"",
			"\1\157",
			"",
			"",
			"\1\161",
			"\12\164",
			"\1\165",
			"\1\172\1\uffff\10\173\2\175\10\uffff\1\170\2\uffff\1\174\4\uffff\1\177"+
			"\1\uffff\1\176\2\uffff\1\167\10\uffff\1\166\11\uffff\1\170\2\uffff\1"+
			"\174\4\uffff\1\177\1\uffff\1\176\2\uffff\1\167\10\uffff\1\166",
			"\1\172\1\uffff\12\u0080\13\uffff\1\174\4\uffff\1\177\1\uffff\1\176\30"+
			"\uffff\1\174\4\uffff\1\177\1\uffff\1\176",
			"\1\61\4\uffff\1\61\52\uffff\1\u0082\37\uffff\1\u0081",
			"\1\61\4\uffff\1\61\32\uffff\1\u0084\37\uffff\1\u0083",
			"\1\61\4\uffff\1\61\52\uffff\1\u0085\37\uffff\1\u0086",
			"\1\61\4\uffff\1\61\52\uffff\1\u0087\37\uffff\1\u0088",
			"",
			"",
			"",
			"\1\64\2\uffff\1\64",
			"",
			"\1\66\1\u008b\1\uffff\1\u0089\1\u008b\22\uffff\1\65\2\uffff\1\u008c",
			"\1\66\1\u008b\1\uffff\1\u0089\1\u008b\22\uffff\1\65\2\uffff\1\u008c",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\22\60\1\u008d\5\60\1\u008e"+
			"\1\60\105\uffff\27\60\1\uffff\37\60\1\uffff\uff07\60",
			"\1\u0090",
			"\1\u0091",
			"\1\61\4\uffff\1\61\75\uffff\1\u0092",
			"\1\61\4\uffff\1\61",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095\5\uffff\1\u0096",
			"\1\u0097\11\uffff\1\u0098",
			"\1\u0099\1\uffff\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00a0",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00a3",
			"\1\u00a4\5\uffff\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"",
			"",
			"",
			"",
			"",
			"\1\u00ad",
			"",
			"",
			"\1\u00af",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00b1",
			"",
			"",
			"\1\u00b3",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\164\13\uffff\1\u00b6\4\uffff\1\177\32\uffff\1\u00b6\4\uffff\1\177",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\u00b8\7\uffff\6\u00b8\32\uffff\6\u00b8",
			"\10\u00b9\24\uffff\1\176\37\uffff\1\176",
			"\2\u00ba\32\uffff\1\176\37\uffff\1\176",
			"",
			"\12\u00bc\13\uffff\1\u00bb\4\uffff\1\177\32\uffff\1\u00bb\4\uffff\1"+
			"\177",
			"\1\172\1\uffff\10\173\2\175\13\uffff\1\174\4\uffff\1\177\1\uffff\1\176"+
			"\30\uffff\1\174\4\uffff\1\177\1\uffff\1\176",
			"\1\u00bd\1\uffff\1\u00bd\2\uffff\12\u00be",
			"\1\172\1\uffff\12\175\13\uffff\1\174\4\uffff\1\177\32\uffff\1\174\4"+
			"\uffff\1\177",
			"",
			"",
			"\1\172\1\uffff\12\u0080\13\uffff\1\174\4\uffff\1\177\1\uffff\1\176\30"+
			"\uffff\1\174\4\uffff\1\177\1\uffff\1\176",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"\1\61\4\uffff\1\61",
			"",
			"\1\uffff",
			"",
			"",
			"\1\u00bf",
			"\1\u00c0",
			"",
			"\1\u00c1",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00cd",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00cf",
			"",
			"\1\u00d0",
			"",
			"",
			"\1\u00d1",
			"\1\u00d2",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00d8",
			"\1\u00d9",
			"\1\u00da",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00db\1\uffff\1\u00db\2\uffff\12\u00dc",
			"",
			"\12\u00b8\7\uffff\6\u00b8\5\uffff\1\176\24\uffff\6\u00b8\5\uffff\1\176",
			"\10\u00b9\24\uffff\1\176\37\uffff\1\176",
			"\2\u00ba\32\uffff\1\176\37\uffff\1\176",
			"\1\u00dd\1\uffff\1\u00dd\2\uffff\12\u00de",
			"\12\u00bc\13\uffff\1\u00df\4\uffff\1\177\32\uffff\1\u00df\4\uffff\1"+
			"\177",
			"\12\u00be",
			"\12\u00be\20\uffff\1\177\37\uffff\1\177",
			"\1\u00e0",
			"\1\u00e1",
			"\1\u00e2",
			"",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"\1\u00ec",
			"\1\u00ed",
			"\1\u00ee",
			"\1\u00ef",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00f1",
			"\1\u00f2",
			"",
			"\1\u00f3",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00f5",
			"\12\u00dc",
			"\12\u00dc\20\uffff\1\177\37\uffff\1\177",
			"\12\u00de",
			"\12\u00de\20\uffff\1\177\37\uffff\1\177",
			"\1\u00f6\1\uffff\1\u00f6\2\uffff\12\u00f7",
			"\1\u00f8",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u00fd",
			"",
			"",
			"\1\u00fe",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u0100",
			"",
			"\1\u0101",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u0106",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\u00f7",
			"\12\u00f7\20\uffff\1\177\37\uffff\1\177",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"",
			"",
			"",
			"\1\u010a",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"\1\u010c",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"\1\u0110",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"",
			"",
			"\1\u0112",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"",
			"",
			"\1\u0114",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			"\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60\105\uffff\27\60\1\uffff"+
			"\37\60\1\uffff\uff07\60",
			"",
			""
	};

	static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
	static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
	static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
	static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
	static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
	static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
	static final short[][] DFA46_transition;

	static {
		int numStates = DFA46_transitionS.length;
		DFA46_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
		}
	}

	protected class DFA46 extends DFA {

		public DFA46(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 46;
			this.eot = DFA46_eot;
			this.eof = DFA46_eof;
			this.min = DFA46_min;
			this.max = DFA46_max;
			this.accept = DFA46_accept;
			this.special = DFA46_special;
			this.transition = DFA46_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AS | ASSERT | ASYNC | AWAIT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NONLOCAL | ORELSE | PASS | RAISE | RETURN | TRY | WHILE | WITH | YIELD | LPAREN | RPAREN | LBRACK | RBRACK | COLON | COMMA | SEMI | PLUS | MINUS | STAR | SLASH | VBAR | AMPER | LESS | GREATER | ASSIGN | PERCENT | BACKQUOTE | LCURLY | RCURLY | CIRCUMFLEX | TILDE | EQUAL | NOTEQUAL | ALT_NOTEQUAL | LESSEQUAL | LEFTSHIFT | GREATEREQUAL | RIGHTSHIFT | PLUSEQUAL | MINUSEQUAL | DOUBLESTAR | STAREQUAL | ATEQUAL | DOUBLESLASH | SLASHEQUAL | VBAREQUAL | PERCENTEQUAL | AMPEREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL | ARROW | DOT | AT | AND | OR | NOT | FLOAT | LONGINT | INT | COMPLEX | NAME | STRING | CONTINUED_LINE | NEWLINE | WS | LEADING_WS | COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA46_51 = input.LA(1);
						 
						int index46_51 = input.index();
						input.rewind();
						s = -1;
						if ( (LA46_51=='\n'||LA46_51=='\r') ) {s = 52;}
						else s = 137;
						 
						input.seek(index46_51);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA46_0 = input.LA(1);
						 
						int index46_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA46_0=='a') ) {s = 1;}
						else if ( (LA46_0=='b') ) {s = 2;}
						else if ( (LA46_0=='c') ) {s = 3;}
						else if ( (LA46_0=='d') ) {s = 4;}
						else if ( (LA46_0=='e') ) {s = 5;}
						else if ( (LA46_0=='f') ) {s = 6;}
						else if ( (LA46_0=='g') ) {s = 7;}
						else if ( (LA46_0=='i') ) {s = 8;}
						else if ( (LA46_0=='l') ) {s = 9;}
						else if ( (LA46_0=='n') ) {s = 10;}
						else if ( (LA46_0=='p') ) {s = 11;}
						else if ( (LA46_0=='r') ) {s = 12;}
						else if ( (LA46_0=='t') ) {s = 13;}
						else if ( (LA46_0=='w') ) {s = 14;}
						else if ( (LA46_0=='y') ) {s = 15;}
						else if ( (LA46_0=='(') ) {s = 16;}
						else if ( (LA46_0==')') ) {s = 17;}
						else if ( (LA46_0=='[') ) {s = 18;}
						else if ( (LA46_0==']') ) {s = 19;}
						else if ( (LA46_0==':') ) {s = 20;}
						else if ( (LA46_0==',') ) {s = 21;}
						else if ( (LA46_0==';') ) {s = 22;}
						else if ( (LA46_0=='+') ) {s = 23;}
						else if ( (LA46_0=='-') ) {s = 24;}
						else if ( (LA46_0=='*') ) {s = 25;}
						else if ( (LA46_0=='/') ) {s = 26;}
						else if ( (LA46_0=='|') ) {s = 27;}
						else if ( (LA46_0=='&') ) {s = 28;}
						else if ( (LA46_0=='<') ) {s = 29;}
						else if ( (LA46_0=='>') ) {s = 30;}
						else if ( (LA46_0=='=') ) {s = 31;}
						else if ( (LA46_0=='%') ) {s = 32;}
						else if ( (LA46_0=='`') ) {s = 33;}
						else if ( (LA46_0=='{') ) {s = 34;}
						else if ( (LA46_0=='}') ) {s = 35;}
						else if ( (LA46_0=='^') ) {s = 36;}
						else if ( (LA46_0=='~') ) {s = 37;}
						else if ( (LA46_0=='!') ) {s = 38;}
						else if ( (LA46_0=='@') ) {s = 39;}
						else if ( (LA46_0=='.') ) {s = 40;}
						else if ( (LA46_0=='o') ) {s = 41;}
						else if ( (LA46_0=='0') ) {s = 42;}
						else if ( ((LA46_0 >= '1' && LA46_0 <= '9')) ) {s = 43;}
						else if ( (LA46_0=='u') ) {s = 44;}
						else if ( (LA46_0=='R') ) {s = 45;}
						else if ( (LA46_0=='U') ) {s = 46;}
						else if ( (LA46_0=='B') ) {s = 47;}
						else if ( (LA46_0=='A'||(LA46_0 >= 'C' && LA46_0 <= 'Q')||(LA46_0 >= 'S' && LA46_0 <= 'T')||(LA46_0 >= 'V' && LA46_0 <= 'Z')||LA46_0=='_'||LA46_0=='h'||(LA46_0 >= 'j' && LA46_0 <= 'k')||LA46_0=='m'||LA46_0=='q'||LA46_0=='s'||LA46_0=='v'||LA46_0=='x'||LA46_0=='z'||(LA46_0 >= '\u00C0' && LA46_0 <= '\u00D6')||(LA46_0 >= '\u00D8' && LA46_0 <= '\u00F6')||(LA46_0 >= '\u00F8' && LA46_0 <= '\uFFFE')) ) {s = 48;}
						else if ( (LA46_0=='\"'||LA46_0=='\'') ) {s = 49;}
						else if ( (LA46_0=='\\') ) {s = 50;}
						else if ( (LA46_0=='\f') ) {s = 51;}
						else if ( (LA46_0=='\n'||LA46_0=='\r') ) {s = 52;}
						else if ( (LA46_0==' ') && (((startPos==0)||(startPos>0)))) {s = 53;}
						else if ( (LA46_0=='\t') && (((startPos==0)||(startPos>0)))) {s = 54;}
						else if ( (LA46_0=='#') ) {s = 55;}
						 
						input.seek(index46_0);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA46_53 = input.LA(1);
						 
						int index46_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA46_53==' ') && (((startPos==0)||(startPos>0)))) {s = 53;}
						else if ( (LA46_53=='\f') && ((startPos>0))) {s = 137;}
						else if ( (LA46_53=='\n'||LA46_53=='\r') && ((startPos==0))) {s = 139;}
						else if ( (LA46_53=='\t') && (((startPos==0)||(startPos>0)))) {s = 54;}
						else if ( (LA46_53=='#') && ((startPos==0))) {s = 140;}
						else s = 138;
						 
						input.seek(index46_53);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA46_54 = input.LA(1);
						 
						int index46_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA46_54==' ') && (((startPos==0)||(startPos>0)))) {s = 53;}
						else if ( (LA46_54=='\f') && ((startPos>0))) {s = 137;}
						else if ( (LA46_54=='\n'||LA46_54=='\r') && ((startPos==0))) {s = 139;}
						else if ( (LA46_54=='\t') && (((startPos==0)||(startPos>0)))) {s = 54;}
						else if ( (LA46_54=='#') && ((startPos==0))) {s = 140;}
						else s = 138;
						 
						input.seek(index46_54);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA46_138 = input.LA(1);
						 
						int index46_138 = input.index();
						input.rewind();
						s = -1;
						if ( ((startPos>0)) ) {s = 137;}
						else if ( ((startPos==0)) ) {s = 139;}
						 
						input.seek(index46_138);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 46, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
