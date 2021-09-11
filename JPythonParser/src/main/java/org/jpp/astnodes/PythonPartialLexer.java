// $ANTLR 3.5.2 PythonPartial.g 2020-08-11 14:04:16

package org.jpp.astnodes;


import org.antlr.runtime.*;

@SuppressWarnings("all")
public class PythonPartialLexer extends Lexer {
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

	/** Handles context-sensitive lexing of implicit line joining such as
	 *  the case where newline is ignored in cases like this:
	 *  a = [3,
	 *       4]
	 */

	//For use in partial parsing.
	public boolean eofWhileNested = false;
	public boolean partial = false;

	public int implicitLineJoiningLevel = 0;
	int startPos=-1;

	//If you want to use another error recovery mechanism change this
	//and the same one in the parser.
	private ErrorHandler errorHandler;

	    public void setErrorHandler(ErrorHandler eh) {
	        this.errorHandler = eh;
	    }

	    public Token getEOFToken() {
	        Token eof = new CommonToken(input,Token.EOF,
	            Token.DEFAULT_CHANNEL,
	            input.index(),input.index());
	        eof.setLine(getLine());
	        eof.setCharPositionInLine(getCharPositionInLine());
	        return eof;
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
	                errorHandler.reportError(this, nva);
	                errorHandler.recover(this, nva); // throw out current char and try again
	            } catch (FailedPredicateException fp) {
	                //XXX: added this for failed STRINGPART -- the FailedPredicateException
	                //     hides a NoViableAltException.  This should be the only
	                //     FailedPredicateException that gets thrown by the lexer.
	                errorHandler.reportError(this, fp);
	                errorHandler.recover(this, fp); // throw out current char and try again
	            } catch (RecognitionException re) {
	                errorHandler.reportError(this, re);
	                // match() routine has already called recover()
	            }
	        }
	    }


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PythonPartialLexer() {} 
	public PythonPartialLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PythonPartialLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "PythonPartial.g"; }

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:907:11: ( 'as' )
			// PythonPartial.g:907:13: 'as'
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
			// PythonPartial.g:908:11: ( 'assert' )
			// PythonPartial.g:908:13: 'assert'
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
			// PythonPartial.g:909:11: ( 'async' )
			// PythonPartial.g:909:13: 'async'
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
			// PythonPartial.g:910:11: ( 'await' )
			// PythonPartial.g:910:13: 'await'
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
			// PythonPartial.g:911:11: ( 'break' )
			// PythonPartial.g:911:13: 'break'
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
			// PythonPartial.g:912:11: ( 'class' )
			// PythonPartial.g:912:13: 'class'
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
			// PythonPartial.g:913:11: ( 'continue' )
			// PythonPartial.g:913:13: 'continue'
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
			// PythonPartial.g:914:11: ( 'def' )
			// PythonPartial.g:914:13: 'def'
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
			// PythonPartial.g:915:11: ( 'del' )
			// PythonPartial.g:915:13: 'del'
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
			// PythonPartial.g:916:11: ( 'elif' )
			// PythonPartial.g:916:13: 'elif'
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
			// PythonPartial.g:917:11: ( 'except' )
			// PythonPartial.g:917:13: 'except'
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
			// PythonPartial.g:918:11: ( 'exec1' )
			// PythonPartial.g:918:13: 'exec1'
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
			// PythonPartial.g:919:11: ( 'finally' )
			// PythonPartial.g:919:13: 'finally'
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
			// PythonPartial.g:920:11: ( 'from' )
			// PythonPartial.g:920:13: 'from'
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
			// PythonPartial.g:921:11: ( 'for' )
			// PythonPartial.g:921:13: 'for'
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
			// PythonPartial.g:922:11: ( 'global' )
			// PythonPartial.g:922:13: 'global'
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
			// PythonPartial.g:923:11: ( 'if' )
			// PythonPartial.g:923:13: 'if'
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
			// PythonPartial.g:924:11: ( 'import' )
			// PythonPartial.g:924:13: 'import'
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
			// PythonPartial.g:925:11: ( 'in' )
			// PythonPartial.g:925:13: 'in'
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
			// PythonPartial.g:926:11: ( 'is' )
			// PythonPartial.g:926:13: 'is'
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
			// PythonPartial.g:927:11: ( 'lambda' )
			// PythonPartial.g:927:13: 'lambda'
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

	// $ANTLR start "ORELSE"
	public final void mORELSE() throws RecognitionException {
		try {
			int _type = ORELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:928:11: ( 'else' )
			// PythonPartial.g:928:13: 'else'
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
			// PythonPartial.g:929:11: ( 'pass' )
			// PythonPartial.g:929:13: 'pass'
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

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:930:11: ( 'print' )
			// PythonPartial.g:930:13: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "RAISE"
	public final void mRAISE() throws RecognitionException {
		try {
			int _type = RAISE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:931:11: ( 'raise' )
			// PythonPartial.g:931:13: 'raise'
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
			// PythonPartial.g:932:11: ( 'return' )
			// PythonPartial.g:932:13: 'return'
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
			// PythonPartial.g:933:11: ( 'try' )
			// PythonPartial.g:933:13: 'try'
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
			// PythonPartial.g:934:11: ( 'while' )
			// PythonPartial.g:934:13: 'while'
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
			// PythonPartial.g:935:11: ( 'with' )
			// PythonPartial.g:935:13: 'with'
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
			// PythonPartial.g:936:11: ( 'yield' )
			// PythonPartial.g:936:13: 'yield'
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
			// PythonPartial.g:938:11: ( '(' )
			// PythonPartial.g:938:13: '('
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
			// PythonPartial.g:940:11: ( ')' )
			// PythonPartial.g:940:13: ')'
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
			// PythonPartial.g:942:11: ( '[' )
			// PythonPartial.g:942:13: '['
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
			// PythonPartial.g:944:11: ( ']' )
			// PythonPartial.g:944:13: ']'
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
			// PythonPartial.g:946:11: ( ':' )
			// PythonPartial.g:946:13: ':'
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
			// PythonPartial.g:948:10: ( ',' )
			// PythonPartial.g:948:12: ','
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
			// PythonPartial.g:950:9: ( ';' )
			// PythonPartial.g:950:11: ';'
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
			// PythonPartial.g:952:9: ( '+' )
			// PythonPartial.g:952:11: '+'
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
			// PythonPartial.g:954:10: ( '-' )
			// PythonPartial.g:954:12: '-'
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
			// PythonPartial.g:956:9: ( '*' )
			// PythonPartial.g:956:11: '*'
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
			// PythonPartial.g:958:10: ( '/' )
			// PythonPartial.g:958:12: '/'
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
			// PythonPartial.g:960:9: ( '|' )
			// PythonPartial.g:960:11: '|'
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
			// PythonPartial.g:962:10: ( '&' )
			// PythonPartial.g:962:12: '&'
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
			// PythonPartial.g:964:9: ( '<' )
			// PythonPartial.g:964:11: '<'
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
			// PythonPartial.g:966:12: ( '>' )
			// PythonPartial.g:966:14: '>'
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
			// PythonPartial.g:968:11: ( '=' )
			// PythonPartial.g:968:13: '='
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
			// PythonPartial.g:970:12: ( '%' )
			// PythonPartial.g:970:14: '%'
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
			// PythonPartial.g:972:14: ( '`' )
			// PythonPartial.g:972:16: '`'
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
			// PythonPartial.g:974:11: ( '{' )
			// PythonPartial.g:974:13: '{'
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
			// PythonPartial.g:976:11: ( '}' )
			// PythonPartial.g:976:13: '}'
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
			// PythonPartial.g:978:15: ( '^' )
			// PythonPartial.g:978:17: '^'
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
			// PythonPartial.g:980:10: ( '~' )
			// PythonPartial.g:980:12: '~'
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
			// PythonPartial.g:982:10: ( '==' )
			// PythonPartial.g:982:12: '=='
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
			// PythonPartial.g:984:13: ( '!=' )
			// PythonPartial.g:984:15: '!='
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
			// PythonPartial.g:986:13: ( '<>' )
			// PythonPartial.g:986:15: '<>'
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
			// PythonPartial.g:988:14: ( '<=' )
			// PythonPartial.g:988:16: '<='
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
			// PythonPartial.g:990:14: ( '<<' )
			// PythonPartial.g:990:16: '<<'
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
			// PythonPartial.g:992:17: ( '>=' )
			// PythonPartial.g:992:19: '>='
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
			// PythonPartial.g:994:15: ( '>>' )
			// PythonPartial.g:994:17: '>>'
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
			// PythonPartial.g:996:14: ( '+=' )
			// PythonPartial.g:996:16: '+='
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
			// PythonPartial.g:998:15: ( '-=' )
			// PythonPartial.g:998:17: '-='
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
			// PythonPartial.g:1000:15: ( '**' )
			// PythonPartial.g:1000:17: '**'
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
			// PythonPartial.g:1002:14: ( '*=' )
			// PythonPartial.g:1002:16: '*='
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

	// $ANTLR start "DOUBLESLASH"
	public final void mDOUBLESLASH() throws RecognitionException {
		try {
			int _type = DOUBLESLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:1004:16: ( '//' )
			// PythonPartial.g:1004:18: '//'
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
			// PythonPartial.g:1006:15: ( '/=' )
			// PythonPartial.g:1006:17: '/='
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
			// PythonPartial.g:1008:14: ( '|=' )
			// PythonPartial.g:1008:16: '|='
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
			// PythonPartial.g:1010:17: ( '%=' )
			// PythonPartial.g:1010:19: '%='
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
			// PythonPartial.g:1012:15: ( '&=' )
			// PythonPartial.g:1012:17: '&='
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
			// PythonPartial.g:1014:20: ( '^=' )
			// PythonPartial.g:1014:22: '^='
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
			// PythonPartial.g:1016:19: ( '<<=' )
			// PythonPartial.g:1016:21: '<<='
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
			// PythonPartial.g:1018:20: ( '>>=' )
			// PythonPartial.g:1018:22: '>>='
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
			// PythonPartial.g:1020:20: ( '**=' )
			// PythonPartial.g:1020:22: '**='
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
			// PythonPartial.g:1022:21: ( '//=' )
			// PythonPartial.g:1022:23: '//='
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
			// PythonPartial.g:1024:7: ( '->' )
			// PythonPartial.g:1024:9: '->'
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
			// PythonPartial.g:1026:5: ( '.' )
			// PythonPartial.g:1026:7: '.'
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
			// PythonPartial.g:1028:4: ( '@' )
			// PythonPartial.g:1028:6: '@'
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
			// PythonPartial.g:1030:5: ( 'and' )
			// PythonPartial.g:1030:7: 'and'
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
			// PythonPartial.g:1032:4: ( 'or' )
			// PythonPartial.g:1032:6: 'or'
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
			// PythonPartial.g:1034:5: ( 'not' )
			// PythonPartial.g:1034:7: 'not'
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
			// PythonPartial.g:1037:5: ( '.' DIGITS ( Exponent )? | DIGITS '.' Exponent | DIGITS ( '.' ( DIGITS ( Exponent )? )? | Exponent ) )
			int alt5=3;
			alt5 = dfa5.predict(input);
			switch (alt5) {
				case 1 :
					// PythonPartial.g:1037:9: '.' DIGITS ( Exponent )?
					{
					match('.'); 
					mDIGITS(); 

					// PythonPartial.g:1037:20: ( Exponent )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0=='E'||LA1_0=='e') ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// PythonPartial.g:1037:21: Exponent
							{
							mExponent(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// PythonPartial.g:1038:9: DIGITS '.' Exponent
					{
					mDIGITS(); 

					match('.'); 
					mExponent(); 

					}
					break;
				case 3 :
					// PythonPartial.g:1039:9: DIGITS ( '.' ( DIGITS ( Exponent )? )? | Exponent )
					{
					mDIGITS(); 

					// PythonPartial.g:1039:16: ( '.' ( DIGITS ( Exponent )? )? | Exponent )
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
							// PythonPartial.g:1039:17: '.' ( DIGITS ( Exponent )? )?
							{
							match('.'); 
							// PythonPartial.g:1039:21: ( DIGITS ( Exponent )? )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// PythonPartial.g:1039:22: DIGITS ( Exponent )?
									{
									mDIGITS(); 

									// PythonPartial.g:1039:29: ( Exponent )?
									int alt2=2;
									int LA2_0 = input.LA(1);
									if ( (LA2_0=='E'||LA2_0=='e') ) {
										alt2=1;
									}
									switch (alt2) {
										case 1 :
											// PythonPartial.g:1039:30: Exponent
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
							// PythonPartial.g:1039:45: Exponent
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
			// PythonPartial.g:1043:5: ( INT ( 'l' | 'L' ) )
			// PythonPartial.g:1043:9: INT ( 'l' | 'L' )
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
			// PythonPartial.g:1049:5: ( ( 'e' | 'E' ) ( '+' | '-' )? DIGITS )
			// PythonPartial.g:1049:10: ( 'e' | 'E' ) ( '+' | '-' )? DIGITS
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// PythonPartial.g:1049:22: ( '+' | '-' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='+'||LA6_0=='-') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// PythonPartial.g:
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
			// PythonPartial.g:1051:5: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ | '0' ( '0' .. '7' )* | '1' .. '9' ( DIGITS )* )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='0') ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1=='X'||LA10_1=='x') ) {
					alt10=1;
				}

				else {
					alt10=2;
				}

			}
			else if ( ((LA10_0 >= '1' && LA10_0 <= '9')) ) {
				alt10=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// PythonPartial.g:1052:9: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
					// PythonPartial.g:1052:25: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
							// PythonPartial.g:
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
					// PythonPartial.g:1054:9: '0' ( '0' .. '7' )*
					{
					match('0'); 
					// PythonPartial.g:1054:14: ( '0' .. '7' )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '7')) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// PythonPartial.g:
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
					// PythonPartial.g:1055:9: '1' .. '9' ( DIGITS )*
					{
					matchRange('1','9'); 
					// PythonPartial.g:1055:18: ( DIGITS )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// PythonPartial.g:1055:18: DIGITS
							{
							mDIGITS(); 

							}
							break;

						default :
							break loop9;
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
			// PythonPartial.g:1059:5: ( ( DIGITS )+ ( 'j' | 'J' ) | FLOAT ( 'j' | 'J' ) )
			int alt12=2;
			alt12 = dfa12.predict(input);
			switch (alt12) {
				case 1 :
					// PythonPartial.g:1059:9: ( DIGITS )+ ( 'j' | 'J' )
					{
					// PythonPartial.g:1059:9: ( DIGITS )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// PythonPartial.g:1059:9: DIGITS
							{
							mDIGITS(); 

							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
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
					// PythonPartial.g:1060:9: FLOAT ( 'j' | 'J' )
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
			// PythonPartial.g:1065:8: ( ( '0' .. '9' )+ )
			// PythonPartial.g:1065:10: ( '0' .. '9' )+
			{
			// PythonPartial.g:1065:10: ( '0' .. '9' )+
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
					// PythonPartial.g:
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
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
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
			// PythonPartial.g:1068:8: ( 'a' .. 'z' | 'A' .. 'Z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' | '\\u0100' .. '\\uFFFE' | '_' )
			// PythonPartial.g:
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
			// PythonPartial.g:1070:6: ( LETTER ( LETTER | DIGITS )* )
			// PythonPartial.g:1070:8: LETTER ( LETTER | DIGITS )*
			{
			mLETTER(); 

			// PythonPartial.g:1070:15: ( LETTER | DIGITS )*
			loop14:
			while (true) {
				int alt14=3;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= 'A' && LA14_0 <= 'Z')||LA14_0=='_'||(LA14_0 >= 'a' && LA14_0 <= 'z')||(LA14_0 >= '\u00C0' && LA14_0 <= '\u00D6')||(LA14_0 >= '\u00D8' && LA14_0 <= '\u00F6')||(LA14_0 >= '\u00F8' && LA14_0 <= '\uFFFE')) ) {
					alt14=1;
				}
				else if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
					alt14=2;
				}

				switch (alt14) {
				case 1 :
					// PythonPartial.g:1070:17: LETTER
					{
					mLETTER(); 

					}
					break;
				case 2 :
					// PythonPartial.g:1070:26: DIGITS
					{
					mDIGITS(); 

					}
					break;

				default :
					break loop14;
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
			// PythonPartial.g:1080:5: ( ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )? ( '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"' | '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"' | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\'' ) )
			// PythonPartial.g:1080:9: ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )? ( '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"' | '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"' | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\'' )
			{
			// PythonPartial.g:1080:9: ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )?
			int alt15=9;
			switch ( input.LA(1) ) {
				case 'r':
					{
					alt15=1;
					}
					break;
				case 'u':
					{
					switch ( input.LA(2) ) {
						case 'r':
							{
							alt15=3;
							}
							break;
						case 'R':
							{
							alt15=7;
							}
							break;
						case '\"':
						case '\'':
							{
							alt15=2;
							}
							break;
					}
					}
					break;
				case 'R':
					{
					alt15=4;
					}
					break;
				case 'U':
					{
					switch ( input.LA(2) ) {
						case 'R':
							{
							alt15=6;
							}
							break;
						case 'r':
							{
							alt15=8;
							}
							break;
						case '\"':
						case '\'':
							{
							alt15=5;
							}
							break;
					}
					}
					break;
			}
			switch (alt15) {
				case 1 :
					// PythonPartial.g:1080:10: 'r'
					{
					match('r'); 
					}
					break;
				case 2 :
					// PythonPartial.g:1080:14: 'u'
					{
					match('u'); 
					}
					break;
				case 3 :
					// PythonPartial.g:1080:18: 'ur'
					{
					match("ur"); 

					}
					break;
				case 4 :
					// PythonPartial.g:1080:23: 'R'
					{
					match('R'); 
					}
					break;
				case 5 :
					// PythonPartial.g:1080:27: 'U'
					{
					match('U'); 
					}
					break;
				case 6 :
					// PythonPartial.g:1080:31: 'UR'
					{
					match("UR"); 

					}
					break;
				case 7 :
					// PythonPartial.g:1080:36: 'uR'
					{
					match("uR"); 

					}
					break;
				case 8 :
					// PythonPartial.g:1080:41: 'Ur'
					{
					match("Ur"); 

					}
					break;

			}

			// PythonPartial.g:1081:9: ( '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"' | '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"' | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\'' )
			int alt20=4;
			int LA20_0 = input.LA(1);
			if ( (LA20_0=='\'') ) {
				int LA20_1 = input.LA(2);
				if ( (LA20_1=='\'') ) {
					int LA20_3 = input.LA(3);
					if ( (LA20_3=='\'') ) {
						alt20=1;
					}

					else {
						alt20=4;
					}

				}
				else if ( ((LA20_1 >= '\u0000' && LA20_1 <= '\t')||(LA20_1 >= '\u000B' && LA20_1 <= '&')||(LA20_1 >= '(' && LA20_1 <= '\uFFFF')) ) {
					alt20=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA20_0=='\"') ) {
				int LA20_2 = input.LA(2);
				if ( (LA20_2=='\"') ) {
					int LA20_5 = input.LA(3);
					if ( (LA20_5=='\"') ) {
						alt20=2;
					}

					else {
						alt20=3;
					}

				}
				else if ( ((LA20_2 >= '\u0000' && LA20_2 <= '\t')||(LA20_2 >= '\u000B' && LA20_2 <= '!')||(LA20_2 >= '#' && LA20_2 <= '\uFFFF')) ) {
					alt20=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// PythonPartial.g:1081:13: '\\'\\'\\'' ( options {greedy=false; } : TRIAPOS )* '\\'\\'\\''
					{
					match("'''"); 

					// PythonPartial.g:1081:22: ( options {greedy=false; } : TRIAPOS )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0=='\'') ) {
							int LA16_1 = input.LA(2);
							if ( (LA16_1=='\'') ) {
								int LA16_3 = input.LA(3);
								if ( (LA16_3=='\'') ) {
									alt16=2;
								}
								else if ( ((LA16_3 >= '\u0000' && LA16_3 <= '&')||(LA16_3 >= '(' && LA16_3 <= '\uFFFF')) ) {
									alt16=1;
								}

							}
							else if ( ((LA16_1 >= '\u0000' && LA16_1 <= '&')||(LA16_1 >= '(' && LA16_1 <= '\uFFFF')) ) {
								alt16=1;
							}

						}
						else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '&')||(LA16_0 >= '(' && LA16_0 <= '\uFFFF')) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// PythonPartial.g:1081:47: TRIAPOS
							{
							mTRIAPOS(); 

							}
							break;

						default :
							break loop16;
						}
					}

					match("'''"); 

					}
					break;
				case 2 :
					// PythonPartial.g:1082:13: '\"\"\"' ( options {greedy=false; } : TRIQUOTE )* '\"\"\"'
					{
					match("\"\"\""); 

					// PythonPartial.g:1082:19: ( options {greedy=false; } : TRIQUOTE )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0=='\"') ) {
							int LA17_1 = input.LA(2);
							if ( (LA17_1=='\"') ) {
								int LA17_3 = input.LA(3);
								if ( (LA17_3=='\"') ) {
									alt17=2;
								}
								else if ( ((LA17_3 >= '\u0000' && LA17_3 <= '!')||(LA17_3 >= '#' && LA17_3 <= '\uFFFF')) ) {
									alt17=1;
								}

							}
							else if ( ((LA17_1 >= '\u0000' && LA17_1 <= '!')||(LA17_1 >= '#' && LA17_1 <= '\uFFFF')) ) {
								alt17=1;
							}

						}
						else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= '\uFFFF')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// PythonPartial.g:1082:44: TRIQUOTE
							{
							mTRIQUOTE(); 

							}
							break;

						default :
							break loop17;
						}
					}

					match("\"\"\""); 

					}
					break;
				case 3 :
					// PythonPartial.g:1083:13: '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* '\"'
					{
					match('\"'); 
					// PythonPartial.g:1083:17: ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )*
					loop18:
					while (true) {
						int alt18=3;
						int LA18_0 = input.LA(1);
						if ( (LA18_0=='\\') ) {
							alt18=1;
						}
						else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '\t')||(LA18_0 >= '\u000B' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
							alt18=2;
						}

						switch (alt18) {
						case 1 :
							// PythonPartial.g:1083:18: ESC
							{
							mESC(); 

							}
							break;
						case 2 :
							// PythonPartial.g:1083:22: ~ ( '\\\\' | '\\n' | '\"' )
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
							break loop18;
						}
					}

					match('\"'); 
					}
					break;
				case 4 :
					// PythonPartial.g:1084:13: '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* '\\''
					{
					match('\''); 
					// PythonPartial.g:1084:18: ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )*
					loop19:
					while (true) {
						int alt19=3;
						int LA19_0 = input.LA(1);
						if ( (LA19_0=='\\') ) {
							alt19=1;
						}
						else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '\t')||(LA19_0 >= '\u000B' && LA19_0 <= '&')||(LA19_0 >= '(' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
							alt19=2;
						}

						switch (alt19) {
						case 1 :
							// PythonPartial.g:1084:19: ESC
							{
							mESC(); 

							}
							break;
						case 2 :
							// PythonPartial.g:1084:23: ~ ( '\\\\' | '\\n' | '\\'' )
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
							break loop19;
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

	// $ANTLR start "TRISTRINGPART"
	public final void mTRISTRINGPART() throws RecognitionException {
		try {
			int _type = TRISTRINGPART;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:1091:5: ( ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )? ( '\\'\\'\\'' (~ ( '\\'\\'\\'' ) )* | '\"\"\"' (~ ( '\"\"\"' ) )* ) )
			// PythonPartial.g:1091:7: ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )? ( '\\'\\'\\'' (~ ( '\\'\\'\\'' ) )* | '\"\"\"' (~ ( '\"\"\"' ) )* )
			{
			// PythonPartial.g:1091:7: ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )?
			int alt21=9;
			switch ( input.LA(1) ) {
				case 'r':
					{
					alt21=1;
					}
					break;
				case 'u':
					{
					switch ( input.LA(2) ) {
						case 'r':
							{
							alt21=3;
							}
							break;
						case 'R':
							{
							alt21=7;
							}
							break;
						case '\"':
						case '\'':
							{
							alt21=2;
							}
							break;
					}
					}
					break;
				case 'R':
					{
					alt21=4;
					}
					break;
				case 'U':
					{
					switch ( input.LA(2) ) {
						case 'R':
							{
							alt21=6;
							}
							break;
						case 'r':
							{
							alt21=8;
							}
							break;
						case '\"':
						case '\'':
							{
							alt21=5;
							}
							break;
					}
					}
					break;
			}
			switch (alt21) {
				case 1 :
					// PythonPartial.g:1091:8: 'r'
					{
					match('r'); 
					}
					break;
				case 2 :
					// PythonPartial.g:1091:12: 'u'
					{
					match('u'); 
					}
					break;
				case 3 :
					// PythonPartial.g:1091:16: 'ur'
					{
					match("ur"); 

					}
					break;
				case 4 :
					// PythonPartial.g:1091:21: 'R'
					{
					match('R'); 
					}
					break;
				case 5 :
					// PythonPartial.g:1091:25: 'U'
					{
					match('U'); 
					}
					break;
				case 6 :
					// PythonPartial.g:1091:29: 'UR'
					{
					match("UR"); 

					}
					break;
				case 7 :
					// PythonPartial.g:1091:34: 'uR'
					{
					match("uR"); 

					}
					break;
				case 8 :
					// PythonPartial.g:1091:39: 'Ur'
					{
					match("Ur"); 

					}
					break;

			}

			// PythonPartial.g:1092:9: ( '\\'\\'\\'' (~ ( '\\'\\'\\'' ) )* | '\"\"\"' (~ ( '\"\"\"' ) )* )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0=='\'') ) {
				alt24=1;
			}
			else if ( (LA24_0=='\"') ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// PythonPartial.g:1092:13: '\\'\\'\\'' (~ ( '\\'\\'\\'' ) )*
					{
					match("'''"); 

					// PythonPartial.g:1092:22: (~ ( '\\'\\'\\'' ) )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( ((LA22_0 >= '\u0000' && LA22_0 <= '\uFFFF')) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// PythonPartial.g:1092:22: ~ ( '\\'\\'\\'' )
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\uFFFF') ) {
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
							break loop22;
						}
					}

					}
					break;
				case 2 :
					// PythonPartial.g:1093:13: '\"\"\"' (~ ( '\"\"\"' ) )*
					{
					match("\"\"\""); 

					// PythonPartial.g:1093:19: (~ ( '\"\"\"' ) )*
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( ((LA23_0 >= '\u0000' && LA23_0 <= '\uFFFF')) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// PythonPartial.g:1093:19: ~ ( '\"\"\"' )
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\uFFFF') ) {
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
							break loop23;
						}
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
	// $ANTLR end "TRISTRINGPART"

	// $ANTLR start "STRINGPART"
	public final void mSTRINGPART() throws RecognitionException {
		try {
			int _type = STRINGPART;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PythonPartial.g:1098:5: ( ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )? ( '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* CONTINUED_LINE | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* CONTINUED_LINE ) )
			// PythonPartial.g:1098:7: ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )? ( '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* CONTINUED_LINE | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* CONTINUED_LINE )
			{
			// PythonPartial.g:1098:7: ( 'r' | 'u' | 'ur' | 'R' | 'U' | 'UR' | 'uR' | 'Ur' )?
			int alt25=9;
			switch ( input.LA(1) ) {
				case 'r':
					{
					alt25=1;
					}
					break;
				case 'u':
					{
					switch ( input.LA(2) ) {
						case 'r':
							{
							alt25=3;
							}
							break;
						case 'R':
							{
							alt25=7;
							}
							break;
						case '\"':
						case '\'':
							{
							alt25=2;
							}
							break;
					}
					}
					break;
				case 'R':
					{
					alt25=4;
					}
					break;
				case 'U':
					{
					switch ( input.LA(2) ) {
						case 'R':
							{
							alt25=6;
							}
							break;
						case 'r':
							{
							alt25=8;
							}
							break;
						case '\"':
						case '\'':
							{
							alt25=5;
							}
							break;
					}
					}
					break;
			}
			switch (alt25) {
				case 1 :
					// PythonPartial.g:1098:8: 'r'
					{
					match('r'); 
					}
					break;
				case 2 :
					// PythonPartial.g:1098:12: 'u'
					{
					match('u'); 
					}
					break;
				case 3 :
					// PythonPartial.g:1098:16: 'ur'
					{
					match("ur"); 

					}
					break;
				case 4 :
					// PythonPartial.g:1098:21: 'R'
					{
					match('R'); 
					}
					break;
				case 5 :
					// PythonPartial.g:1098:25: 'U'
					{
					match('U'); 
					}
					break;
				case 6 :
					// PythonPartial.g:1098:29: 'UR'
					{
					match("UR"); 

					}
					break;
				case 7 :
					// PythonPartial.g:1098:34: 'uR'
					{
					match("uR"); 

					}
					break;
				case 8 :
					// PythonPartial.g:1098:39: 'Ur'
					{
					match("Ur"); 

					}
					break;

			}

			// PythonPartial.g:1099:9: ( '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* CONTINUED_LINE | '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* CONTINUED_LINE )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0=='\"') ) {
				alt28=1;
			}
			else if ( (LA28_0=='\'') ) {
				alt28=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// PythonPartial.g:1099:13: '\"' ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )* CONTINUED_LINE
					{
					match('\"'); 
					// PythonPartial.g:1099:17: ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )*
					loop26:
					while (true) {
						int alt26=3;
						alt26 = dfa26.predict(input);
						switch (alt26) {
						case 1 :
							// PythonPartial.g:1099:18: ESC
							{
							mESC(); 

							}
							break;
						case 2 :
							// PythonPartial.g:1099:22: ~ ( '\\\\' | '\\n' | '\"' )
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
							break loop26;
						}
					}

					mCONTINUED_LINE(); 

					}
					break;
				case 2 :
					// PythonPartial.g:1100:13: '\\'' ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )* CONTINUED_LINE
					{
					match('\''); 
					// PythonPartial.g:1100:18: ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )*
					loop27:
					while (true) {
						int alt27=3;
						alt27 = dfa27.predict(input);
						switch (alt27) {
						case 1 :
							// PythonPartial.g:1100:19: ESC
							{
							mESC(); 

							}
							break;
						case 2 :
							// PythonPartial.g:1100:23: ~ ( '\\\\' | '\\n' | '\\'' )
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
							break loop27;
						}
					}

					mCONTINUED_LINE(); 

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
	// $ANTLR end "STRINGPART"

	// $ANTLR start "TRIQUOTE"
	public final void mTRIQUOTE() throws RecognitionException {
		try {
			// PythonPartial.g:1110:5: ( ( '\"' )? ( '\"' )? ( ESC |~ ( '\\\\' | '\"' ) )+ )
			// PythonPartial.g:1110:7: ( '\"' )? ( '\"' )? ( ESC |~ ( '\\\\' | '\"' ) )+
			{
			// PythonPartial.g:1110:7: ( '\"' )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0=='\"') ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// PythonPartial.g:1110:7: '\"'
					{
					match('\"'); 
					}
					break;

			}

			// PythonPartial.g:1110:12: ( '\"' )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0=='\"') ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// PythonPartial.g:1110:12: '\"'
					{
					match('\"'); 
					}
					break;

			}

			// PythonPartial.g:1110:17: ( ESC |~ ( '\\\\' | '\"' ) )+
			int cnt31=0;
			loop31:
			while (true) {
				int alt31=3;
				int LA31_0 = input.LA(1);
				if ( (LA31_0=='\\') ) {
					alt31=1;
				}
				else if ( ((LA31_0 >= '\u0000' && LA31_0 <= '!')||(LA31_0 >= '#' && LA31_0 <= '[')||(LA31_0 >= ']' && LA31_0 <= '\uFFFF')) ) {
					alt31=2;
				}

				switch (alt31) {
				case 1 :
					// PythonPartial.g:1110:18: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// PythonPartial.g:1110:22: ~ ( '\\\\' | '\"' )
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
					if ( cnt31 >= 1 ) break loop31;
					EarlyExitException eee = new EarlyExitException(31, input);
					throw eee;
				}
				cnt31++;
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
			// PythonPartial.g:1116:5: ( ( '\\'' )? ( '\\'' )? ( ESC |~ ( '\\\\' | '\\'' ) )+ )
			// PythonPartial.g:1116:7: ( '\\'' )? ( '\\'' )? ( ESC |~ ( '\\\\' | '\\'' ) )+
			{
			// PythonPartial.g:1116:7: ( '\\'' )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0=='\'') ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// PythonPartial.g:1116:7: '\\''
					{
					match('\''); 
					}
					break;

			}

			// PythonPartial.g:1116:13: ( '\\'' )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0=='\'') ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// PythonPartial.g:1116:13: '\\''
					{
					match('\''); 
					}
					break;

			}

			// PythonPartial.g:1116:19: ( ESC |~ ( '\\\\' | '\\'' ) )+
			int cnt34=0;
			loop34:
			while (true) {
				int alt34=3;
				int LA34_0 = input.LA(1);
				if ( (LA34_0=='\\') ) {
					alt34=1;
				}
				else if ( ((LA34_0 >= '\u0000' && LA34_0 <= '&')||(LA34_0 >= '(' && LA34_0 <= '[')||(LA34_0 >= ']' && LA34_0 <= '\uFFFF')) ) {
					alt34=2;
				}

				switch (alt34) {
				case 1 :
					// PythonPartial.g:1116:20: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// PythonPartial.g:1116:24: ~ ( '\\\\' | '\\'' )
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
					if ( cnt34 >= 1 ) break loop34;
					EarlyExitException eee = new EarlyExitException(34, input);
					throw eee;
				}
				cnt34++;
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
			// PythonPartial.g:1120:5: ( '\\\\' . )
			// PythonPartial.g:1120:10: '\\\\' .
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


			    boolean extraNewlines = false;

			// PythonPartial.g:1134:5: ( '\\\\' ( '\\r' )? '\\n' ( ' ' | '\\t' )* ( COMMENT |nl= NEWLINE |) )
			// PythonPartial.g:1134:10: '\\\\' ( '\\r' )? '\\n' ( ' ' | '\\t' )* ( COMMENT |nl= NEWLINE |)
			{
			match('\\'); 
			// PythonPartial.g:1134:15: ( '\\r' )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0=='\r') ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// PythonPartial.g:1134:16: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			// PythonPartial.g:1134:28: ( ' ' | '\\t' )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0=='\t'||LA36_0==' ') ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// PythonPartial.g:
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
					break loop36;
				}
			}

			 _channel=HIDDEN; 
			// PythonPartial.g:1135:10: ( COMMENT |nl= NEWLINE |)
			int alt37=3;
			int LA37_0 = input.LA(1);
			if ( (LA37_0=='\t'||LA37_0==' ') && ((startPos==0))) {
				alt37=1;
			}
			else if ( (LA37_0=='#') ) {
				alt37=1;
			}
			else if ( (LA37_0=='\n'||(LA37_0 >= '\f' && LA37_0 <= '\r')) ) {
				alt37=2;
			}

			else {
				alt37=3;
			}

			switch (alt37) {
				case 1 :
					// PythonPartial.g:1135:12: COMMENT
					{
					mCOMMENT(); 

					}
					break;
				case 2 :
					// PythonPartial.g:1136:12: nl= NEWLINE
					{
					int nlStart1803 = getCharIndex();
					int nlStartLine1803 = getLine();
					int nlStartCharPos1803 = getCharPositionInLine();
					mNEWLINE(); 
					nl = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, nlStart1803, getCharIndex()-1);
					nl.setLine(nlStartLine1803);
					nl.setCharPositionInLine(nlStartCharPos1803);


					               extraNewlines = true;
					           
					}
					break;
				case 3 :
					// PythonPartial.g:1141:10: 
					{
					}
					break;

			}


			               if (input.LA(1) == -1) {
			                   if (extraNewlines) {
			                       throw new ParseException("invalid syntax");
			                   }
			                   emit(new CommonToken(TRAILBACKSLASH,"\\"));
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
			// PythonPartial.g:1160:5: ( ( ( '\\u000C' )? ( '\\r' )? '\\n' )+ )
			// PythonPartial.g:1160:9: ( ( '\\u000C' )? ( '\\r' )? '\\n' )+
			{
			// PythonPartial.g:1160:9: ( ( '\\u000C' )? ( '\\r' )? '\\n' )+
			int cnt40=0;
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0=='\n'||(LA40_0 >= '\f' && LA40_0 <= '\r')) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// PythonPartial.g:1160:10: ( '\\u000C' )? ( '\\r' )? '\\n'
					{
					// PythonPartial.g:1160:10: ( '\\u000C' )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0=='\f') ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// PythonPartial.g:1160:11: '\\u000C'
							{
							match('\f'); 
							}
							break;

					}

					// PythonPartial.g:1160:21: ( '\\r' )?
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0=='\r') ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// PythonPartial.g:1160:22: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;

				default :
					if ( cnt40 >= 1 ) break loop40;
					EarlyExitException eee = new EarlyExitException(40, input);
					throw eee;
				}
				cnt40++;
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
			// PythonPartial.g:1160:5: ({...}? => ( ' ' | '\\t' | '\\u000C' )+ )
			// PythonPartial.g:1160:10: {...}? => ( ' ' | '\\t' | '\\u000C' )+
			{
			if ( !((startPos>0)) ) {
				throw new FailedPredicateException(input, "WS", "startPos>0");
			}
			// PythonPartial.g:1160:26: ( ' ' | '\\t' | '\\u000C' )+
			int cnt41=0;
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0=='\t'||LA41_0=='\f'||LA41_0==' ') ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// PythonPartial.g:
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
					if ( cnt41 >= 1 ) break loop41;
					EarlyExitException eee = new EarlyExitException(41, input);
					throw eee;
				}
				cnt41++;
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

			// PythonPartial.g:1180:5: ({...}? => ({...}? ( ' ' | '\\t' )+ | ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* ) )
			// PythonPartial.g:1180:9: {...}? => ({...}? ( ' ' | '\\t' )+ | ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* )
			{
			if ( !((startPos==0)) ) {
				throw new FailedPredicateException(input, "LEADING_WS", "startPos==0");
			}
			// PythonPartial.g:1181:9: ({...}? ( ' ' | '\\t' )+ | ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==' ') ) {
				int LA46_1 = input.LA(2);
				if ( ((implicitLineJoiningLevel>0)) ) {
					alt46=1;
				}
				else if ( (true) ) {
					alt46=2;
				}

			}
			else if ( (LA46_0=='\t') ) {
				int LA46_2 = input.LA(2);
				if ( ((implicitLineJoiningLevel>0)) ) {
					alt46=1;
				}
				else if ( (true) ) {
					alt46=2;
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// PythonPartial.g:1181:13: {...}? ( ' ' | '\\t' )+
					{
					if ( !((implicitLineJoiningLevel>0)) ) {
						throw new FailedPredicateException(input, "LEADING_WS", "implicitLineJoiningLevel>0");
					}
					// PythonPartial.g:1181:43: ( ' ' | '\\t' )+
					int cnt42=0;
					loop42:
					while (true) {
						int alt42=2;
						int LA42_0 = input.LA(1);
						if ( (LA42_0=='\t'||LA42_0==' ') ) {
							alt42=1;
						}

						switch (alt42) {
						case 1 :
							// PythonPartial.g:
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
							if ( cnt42 >= 1 ) break loop42;
							EarlyExitException eee = new EarlyExitException(42, input);
							throw eee;
						}
						cnt42++;
					}

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// PythonPartial.g:1182:14: ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )*
					{
					// PythonPartial.g:1182:14: ( ' ' | '\\t' )+
					int cnt43=0;
					loop43:
					while (true) {
						int alt43=3;
						int LA43_0 = input.LA(1);
						if ( (LA43_0==' ') ) {
							alt43=1;
						}
						else if ( (LA43_0=='\t') ) {
							alt43=2;
						}

						switch (alt43) {
						case 1 :
							// PythonPartial.g:1182:20: ' '
							{
							match(' '); 
							 spaces++; 
							}
							break;
						case 2 :
							// PythonPartial.g:1183:19: '\\t'
							{
							match('\t'); 
							 spaces += 8; spaces -= (spaces % 8); 
							}
							break;

						default :
							if ( cnt43 >= 1 ) break loop43;
							EarlyExitException eee = new EarlyExitException(43, input);
							throw eee;
						}
						cnt43++;
					}

					// PythonPartial.g:1185:14: ( ( '\\r' )? '\\n' )*
					loop45:
					while (true) {
						int alt45=2;
						int LA45_0 = input.LA(1);
						if ( (LA45_0=='\n'||LA45_0=='\r') ) {
							alt45=1;
						}

						switch (alt45) {
						case 1 :
							// PythonPartial.g:1185:16: ( '\\r' )? '\\n'
							{
							// PythonPartial.g:1185:16: ( '\\r' )?
							int alt44=2;
							int LA44_0 = input.LA(1);
							if ( (LA44_0=='\r') ) {
								alt44=1;
							}
							switch (alt44) {
								case 1 :
									// PythonPartial.g:1185:17: '\\r'
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
							break loop45;
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

			// PythonPartial.g:1256:5: ({...}? => ( ' ' | '\\t' )* '#' (~ '\\n' )* ( '\\n' )+ | '#' (~ '\\n' )* )
			int alt51=2;
			alt51 = dfa51.predict(input);
			switch (alt51) {
				case 1 :
					// PythonPartial.g:1256:10: {...}? => ( ' ' | '\\t' )* '#' (~ '\\n' )* ( '\\n' )+
					{
					if ( !((startPos==0)) ) {
						throw new FailedPredicateException(input, "COMMENT", "startPos==0");
					}
					// PythonPartial.g:1256:27: ( ' ' | '\\t' )*
					loop47:
					while (true) {
						int alt47=2;
						int LA47_0 = input.LA(1);
						if ( (LA47_0=='\t'||LA47_0==' ') ) {
							alt47=1;
						}

						switch (alt47) {
						case 1 :
							// PythonPartial.g:
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
							break loop47;
						}
					}

					match('#'); 
					// PythonPartial.g:1256:43: (~ '\\n' )*
					loop48:
					while (true) {
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( ((LA48_0 >= '\u0000' && LA48_0 <= '\t')||(LA48_0 >= '\u000B' && LA48_0 <= '\uFFFF')) ) {
							alt48=1;
						}

						switch (alt48) {
						case 1 :
							// PythonPartial.g:
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
							break loop48;
						}
					}

					// PythonPartial.g:1256:52: ( '\\n' )+
					int cnt49=0;
					loop49:
					while (true) {
						int alt49=2;
						int LA49_0 = input.LA(1);
						if ( (LA49_0=='\n') ) {
							alt49=1;
						}

						switch (alt49) {
						case 1 :
							// PythonPartial.g:1256:52: '\\n'
							{
							match('\n'); 
							}
							break;

						default :
							if ( cnt49 >= 1 ) break loop49;
							EarlyExitException eee = new EarlyExitException(49, input);
							throw eee;
						}
						cnt49++;
					}

					}
					break;
				case 2 :
					// PythonPartial.g:1257:10: '#' (~ '\\n' )*
					{
					match('#'); 
					// PythonPartial.g:1257:14: (~ '\\n' )*
					loop50:
					while (true) {
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( ((LA50_0 >= '\u0000' && LA50_0 <= '\t')||(LA50_0 >= '\u000B' && LA50_0 <= '\uFFFF')) ) {
							alt50=1;
						}

						switch (alt50) {
						case 1 :
							// PythonPartial.g:
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
							break loop50;
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
		// PythonPartial.g:1:8: ( AS | ASSERT | ASYNC | AWAIT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | ORELSE | PASS | PRINT | RAISE | RETURN | TRY | WHILE | WITH | YIELD | LPAREN | RPAREN | LBRACK | RBRACK | COLON | COMMA | SEMI | PLUS | MINUS | STAR | SLASH | VBAR | AMPER | LESS | GREATER | ASSIGN | PERCENT | BACKQUOTE | LCURLY | RCURLY | CIRCUMFLEX | TILDE | EQUAL | NOTEQUAL | ALT_NOTEQUAL | LESSEQUAL | LEFTSHIFT | GREATEREQUAL | RIGHTSHIFT | PLUSEQUAL | MINUSEQUAL | DOUBLESTAR | STAREQUAL | DOUBLESLASH | SLASHEQUAL | VBAREQUAL | PERCENTEQUAL | AMPEREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL | ARROW | DOT | AT | AND | OR | NOT | FLOAT | LONGINT | INT | COMPLEX | NAME | STRING | TRISTRINGPART | STRINGPART | CONTINUED_LINE | NEWLINE | WS | LEADING_WS | COMMENT )
		int alt52=92;
		alt52 = dfa52.predict(input);
		switch (alt52) {
			case 1 :
				// PythonPartial.g:1:10: AS
				{
				mAS(); 

				}
				break;
			case 2 :
				// PythonPartial.g:1:13: ASSERT
				{
				mASSERT(); 

				}
				break;
			case 3 :
				// PythonPartial.g:1:20: ASYNC
				{
				mASYNC(); 

				}
				break;
			case 4 :
				// PythonPartial.g:1:26: AWAIT
				{
				mAWAIT(); 

				}
				break;
			case 5 :
				// PythonPartial.g:1:32: BREAK
				{
				mBREAK(); 

				}
				break;
			case 6 :
				// PythonPartial.g:1:38: CLASS
				{
				mCLASS(); 

				}
				break;
			case 7 :
				// PythonPartial.g:1:44: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 8 :
				// PythonPartial.g:1:53: DEF
				{
				mDEF(); 

				}
				break;
			case 9 :
				// PythonPartial.g:1:57: DELETE
				{
				mDELETE(); 

				}
				break;
			case 10 :
				// PythonPartial.g:1:64: ELIF
				{
				mELIF(); 

				}
				break;
			case 11 :
				// PythonPartial.g:1:69: EXCEPT
				{
				mEXCEPT(); 

				}
				break;
			case 12 :
				// PythonPartial.g:1:76: EXEC
				{
				mEXEC(); 

				}
				break;
			case 13 :
				// PythonPartial.g:1:81: FINALLY
				{
				mFINALLY(); 

				}
				break;
			case 14 :
				// PythonPartial.g:1:89: FROM
				{
				mFROM(); 

				}
				break;
			case 15 :
				// PythonPartial.g:1:94: FOR
				{
				mFOR(); 

				}
				break;
			case 16 :
				// PythonPartial.g:1:98: GLOBAL
				{
				mGLOBAL(); 

				}
				break;
			case 17 :
				// PythonPartial.g:1:105: IF
				{
				mIF(); 

				}
				break;
			case 18 :
				// PythonPartial.g:1:108: IMPORT
				{
				mIMPORT(); 

				}
				break;
			case 19 :
				// PythonPartial.g:1:115: IN
				{
				mIN(); 

				}
				break;
			case 20 :
				// PythonPartial.g:1:118: IS
				{
				mIS(); 

				}
				break;
			case 21 :
				// PythonPartial.g:1:121: LAMBDA
				{
				mLAMBDA(); 

				}
				break;
			case 22 :
				// PythonPartial.g:1:128: ORELSE
				{
				mORELSE(); 

				}
				break;
			case 23 :
				// PythonPartial.g:1:135: PASS
				{
				mPASS(); 

				}
				break;
			case 24 :
				// PythonPartial.g:1:140: PRINT
				{
				mPRINT(); 

				}
				break;
			case 25 :
				// PythonPartial.g:1:146: RAISE
				{
				mRAISE(); 

				}
				break;
			case 26 :
				// PythonPartial.g:1:152: RETURN
				{
				mRETURN(); 

				}
				break;
			case 27 :
				// PythonPartial.g:1:159: TRY
				{
				mTRY(); 

				}
				break;
			case 28 :
				// PythonPartial.g:1:163: WHILE
				{
				mWHILE(); 

				}
				break;
			case 29 :
				// PythonPartial.g:1:169: WITH
				{
				mWITH(); 

				}
				break;
			case 30 :
				// PythonPartial.g:1:174: YIELD
				{
				mYIELD(); 

				}
				break;
			case 31 :
				// PythonPartial.g:1:180: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 32 :
				// PythonPartial.g:1:187: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 33 :
				// PythonPartial.g:1:194: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 34 :
				// PythonPartial.g:1:201: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 35 :
				// PythonPartial.g:1:208: COLON
				{
				mCOLON(); 

				}
				break;
			case 36 :
				// PythonPartial.g:1:214: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 37 :
				// PythonPartial.g:1:220: SEMI
				{
				mSEMI(); 

				}
				break;
			case 38 :
				// PythonPartial.g:1:225: PLUS
				{
				mPLUS(); 

				}
				break;
			case 39 :
				// PythonPartial.g:1:230: MINUS
				{
				mMINUS(); 

				}
				break;
			case 40 :
				// PythonPartial.g:1:236: STAR
				{
				mSTAR(); 

				}
				break;
			case 41 :
				// PythonPartial.g:1:241: SLASH
				{
				mSLASH(); 

				}
				break;
			case 42 :
				// PythonPartial.g:1:247: VBAR
				{
				mVBAR(); 

				}
				break;
			case 43 :
				// PythonPartial.g:1:252: AMPER
				{
				mAMPER(); 

				}
				break;
			case 44 :
				// PythonPartial.g:1:258: LESS
				{
				mLESS(); 

				}
				break;
			case 45 :
				// PythonPartial.g:1:263: GREATER
				{
				mGREATER(); 

				}
				break;
			case 46 :
				// PythonPartial.g:1:271: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 47 :
				// PythonPartial.g:1:278: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 48 :
				// PythonPartial.g:1:286: BACKQUOTE
				{
				mBACKQUOTE(); 

				}
				break;
			case 49 :
				// PythonPartial.g:1:296: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 50 :
				// PythonPartial.g:1:303: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 51 :
				// PythonPartial.g:1:310: CIRCUMFLEX
				{
				mCIRCUMFLEX(); 

				}
				break;
			case 52 :
				// PythonPartial.g:1:321: TILDE
				{
				mTILDE(); 

				}
				break;
			case 53 :
				// PythonPartial.g:1:327: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 54 :
				// PythonPartial.g:1:333: NOTEQUAL
				{
				mNOTEQUAL(); 

				}
				break;
			case 55 :
				// PythonPartial.g:1:342: ALT_NOTEQUAL
				{
				mALT_NOTEQUAL(); 

				}
				break;
			case 56 :
				// PythonPartial.g:1:355: LESSEQUAL
				{
				mLESSEQUAL(); 

				}
				break;
			case 57 :
				// PythonPartial.g:1:365: LEFTSHIFT
				{
				mLEFTSHIFT(); 

				}
				break;
			case 58 :
				// PythonPartial.g:1:375: GREATEREQUAL
				{
				mGREATEREQUAL(); 

				}
				break;
			case 59 :
				// PythonPartial.g:1:388: RIGHTSHIFT
				{
				mRIGHTSHIFT(); 

				}
				break;
			case 60 :
				// PythonPartial.g:1:399: PLUSEQUAL
				{
				mPLUSEQUAL(); 

				}
				break;
			case 61 :
				// PythonPartial.g:1:409: MINUSEQUAL
				{
				mMINUSEQUAL(); 

				}
				break;
			case 62 :
				// PythonPartial.g:1:420: DOUBLESTAR
				{
				mDOUBLESTAR(); 

				}
				break;
			case 63 :
				// PythonPartial.g:1:431: STAREQUAL
				{
				mSTAREQUAL(); 

				}
				break;
			case 64 :
				// PythonPartial.g:1:441: DOUBLESLASH
				{
				mDOUBLESLASH(); 

				}
				break;
			case 65 :
				// PythonPartial.g:1:453: SLASHEQUAL
				{
				mSLASHEQUAL(); 

				}
				break;
			case 66 :
				// PythonPartial.g:1:464: VBAREQUAL
				{
				mVBAREQUAL(); 

				}
				break;
			case 67 :
				// PythonPartial.g:1:474: PERCENTEQUAL
				{
				mPERCENTEQUAL(); 

				}
				break;
			case 68 :
				// PythonPartial.g:1:487: AMPEREQUAL
				{
				mAMPEREQUAL(); 

				}
				break;
			case 69 :
				// PythonPartial.g:1:498: CIRCUMFLEXEQUAL
				{
				mCIRCUMFLEXEQUAL(); 

				}
				break;
			case 70 :
				// PythonPartial.g:1:514: LEFTSHIFTEQUAL
				{
				mLEFTSHIFTEQUAL(); 

				}
				break;
			case 71 :
				// PythonPartial.g:1:529: RIGHTSHIFTEQUAL
				{
				mRIGHTSHIFTEQUAL(); 

				}
				break;
			case 72 :
				// PythonPartial.g:1:545: DOUBLESTAREQUAL
				{
				mDOUBLESTAREQUAL(); 

				}
				break;
			case 73 :
				// PythonPartial.g:1:561: DOUBLESLASHEQUAL
				{
				mDOUBLESLASHEQUAL(); 

				}
				break;
			case 74 :
				// PythonPartial.g:1:578: ARROW
				{
				mARROW(); 

				}
				break;
			case 75 :
				// PythonPartial.g:1:584: DOT
				{
				mDOT(); 

				}
				break;
			case 76 :
				// PythonPartial.g:1:588: AT
				{
				mAT(); 

				}
				break;
			case 77 :
				// PythonPartial.g:1:591: AND
				{
				mAND(); 

				}
				break;
			case 78 :
				// PythonPartial.g:1:595: OR
				{
				mOR(); 

				}
				break;
			case 79 :
				// PythonPartial.g:1:598: NOT
				{
				mNOT(); 

				}
				break;
			case 80 :
				// PythonPartial.g:1:602: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 81 :
				// PythonPartial.g:1:608: LONGINT
				{
				mLONGINT(); 

				}
				break;
			case 82 :
				// PythonPartial.g:1:616: INT
				{
				mINT(); 

				}
				break;
			case 83 :
				// PythonPartial.g:1:620: COMPLEX
				{
				mCOMPLEX(); 

				}
				break;
			case 84 :
				// PythonPartial.g:1:628: NAME
				{
				mNAME(); 

				}
				break;
			case 85 :
				// PythonPartial.g:1:633: STRING
				{
				mSTRING(); 

				}
				break;
			case 86 :
				// PythonPartial.g:1:640: TRISTRINGPART
				{
				mTRISTRINGPART(); 

				}
				break;
			case 87 :
				// PythonPartial.g:1:654: STRINGPART
				{
				mSTRINGPART(); 

				}
				break;
			case 88 :
				// PythonPartial.g:1:665: CONTINUED_LINE
				{
				mCONTINUED_LINE(); 

				}
				break;
			case 89 :
				// PythonPartial.g:1:680: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 90 :
				// PythonPartial.g:1:688: WS
				{
				mWS(); 

				}
				break;
			case 91 :
				// PythonPartial.g:1:691: LEADING_WS
				{
				mLEADING_WS(); 

				}
				break;
			case 92 :
				// PythonPartial.g:1:702: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	protected DFA12 dfa12 = new DFA12(this);
	protected DFA26 dfa26 = new DFA26(this);
	protected DFA27 dfa27 = new DFA27(this);
	protected DFA51 dfa51 = new DFA51(this);
	protected DFA52 dfa52 = new DFA52(this);
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
			return "1036:1: FLOAT : ( '.' DIGITS ( Exponent )? | DIGITS '.' Exponent | DIGITS ( '.' ( DIGITS ( Exponent )? )? | Exponent ) );";
		}
	}

	static final String DFA12_eotS =
		"\4\uffff";
	static final String DFA12_eofS =
		"\4\uffff";
	static final String DFA12_minS =
		"\2\56\2\uffff";
	static final String DFA12_maxS =
		"\1\71\1\152\2\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA12_specialS =
		"\4\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\2\1\uffff\12\1\13\uffff\1\2\4\uffff\1\3\32\uffff\1\2\4\uffff\1\3",
			"",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1058:1: COMPLEX : ( ( DIGITS )+ ( 'j' | 'J' ) | FLOAT ( 'j' | 'J' ) );";
		}
	}

	static final String DFA26_eotS =
		"\4\uffff\1\6\2\uffff\2\6\2\uffff\3\6\1\uffff\1\6\1\uffff";
	static final String DFA26_eofS =
		"\21\uffff";
	static final String DFA26_minS =
		"\2\0\1\uffff\2\0\2\uffff\7\0\1\uffff\1\0\1\uffff";
	static final String DFA26_maxS =
		"\2\uffff\1\uffff\2\uffff\2\uffff\7\uffff\1\uffff\1\uffff\1\uffff";
	static final String DFA26_acceptS =
		"\2\uffff\1\2\2\uffff\1\1\1\3\7\uffff\1\1\1\uffff\1\1";
	static final String DFA26_specialS =
		"\1\5\1\3\1\uffff\1\10\1\0\2\uffff\1\1\1\13\1\4\1\11\1\2\1\6\1\12\1\uffff"+
		"\1\7\1\uffff}>";
	static final String[] DFA26_transitionS = {
			"\12\2\1\uffff\27\2\1\uffff\71\2\1\1\uffa3\2",
			"\12\5\1\4\2\5\1\3\ufff2\5",
			"",
			"\12\5\1\6\27\5\1\uffff\uffdd\5",
			"\11\5\1\7\1\uffff\1\5\1\11\1\12\22\5\1\7\1\5\1\uffff\1\10\uffdc\5",
			"",
			"",
			"\11\5\1\7\1\uffff\1\5\1\11\1\12\22\5\1\7\1\5\1\uffff\1\10\uffdc\5",
			"\12\14\1\uffff\27\14\1\uffff\71\14\1\13\uffa3\14",
			"\12\5\1\6\2\5\1\12\24\5\1\uffff\uffdd\5",
			"\12\5\1\6\27\5\1\uffff\uffdd\5",
			"\12\17\1\16\2\17\1\15\ufff2\17",
			"\12\14\1\uffff\27\14\1\uffff\71\14\1\13\uffa3\14",
			"\12\14\1\20\27\14\1\uffff\71\14\1\13\uffa3\14",
			"",
			"\12\14\1\uffff\27\14\1\uffff\71\14\1\13\uffa3\14",
			""
	};

	static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
	static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
	static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
	static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
	static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
	static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
	static final short[][] DFA26_transition;

	static {
		int numStates = DFA26_transitionS.length;
		DFA26_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
		}
	}

	protected class DFA26 extends DFA {

		public DFA26(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 26;
			this.eot = DFA26_eot;
			this.eof = DFA26_eof;
			this.min = DFA26_min;
			this.max = DFA26_max;
			this.accept = DFA26_accept;
			this.special = DFA26_special;
			this.transition = DFA26_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 1099:17: ( ESC |~ ( '\\\\' | '\\n' | '\"' ) )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA26_4 = input.LA(1);
						s = -1;
						if ( ((LA26_4 >= '\u0000' && LA26_4 <= '\b')||LA26_4=='\u000B'||(LA26_4 >= '\u000E' && LA26_4 <= '\u001F')||LA26_4=='!'||(LA26_4 >= '$' && LA26_4 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA26_4=='\t'||LA26_4==' ') ) {s = 7;}
						else if ( (LA26_4=='#') ) {s = 8;}
						else if ( (LA26_4=='\f') ) {s = 9;}
						else if ( (LA26_4=='\r') ) {s = 10;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA26_7 = input.LA(1);
						s = -1;
						if ( ((LA26_7 >= '\u0000' && LA26_7 <= '\b')||LA26_7=='\u000B'||(LA26_7 >= '\u000E' && LA26_7 <= '\u001F')||LA26_7=='!'||(LA26_7 >= '$' && LA26_7 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA26_7=='\t'||LA26_7==' ') ) {s = 7;}
						else if ( (LA26_7=='#') ) {s = 8;}
						else if ( (LA26_7=='\f') ) {s = 9;}
						else if ( (LA26_7=='\r') ) {s = 10;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA26_11 = input.LA(1);
						s = -1;
						if ( (LA26_11=='\r') ) {s = 13;}
						else if ( (LA26_11=='\n') ) {s = 14;}
						else if ( ((LA26_11 >= '\u0000' && LA26_11 <= '\t')||(LA26_11 >= '\u000B' && LA26_11 <= '\f')||(LA26_11 >= '\u000E' && LA26_11 <= '\uFFFF')) ) {s = 15;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA26_1 = input.LA(1);
						s = -1;
						if ( (LA26_1=='\r') ) {s = 3;}
						else if ( (LA26_1=='\n') ) {s = 4;}
						else if ( ((LA26_1 >= '\u0000' && LA26_1 <= '\t')||(LA26_1 >= '\u000B' && LA26_1 <= '\f')||(LA26_1 >= '\u000E' && LA26_1 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA26_9 = input.LA(1);
						s = -1;
						if ( ((LA26_9 >= '\u0000' && LA26_9 <= '\t')||(LA26_9 >= '\u000B' && LA26_9 <= '\f')||(LA26_9 >= '\u000E' && LA26_9 <= '!')||(LA26_9 >= '#' && LA26_9 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA26_9=='\r') ) {s = 10;}
						else if ( (LA26_9=='\n') ) {s = 6;}
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA26_0 = input.LA(1);
						s = -1;
						if ( (LA26_0=='\\') ) {s = 1;}
						else if ( ((LA26_0 >= '\u0000' && LA26_0 <= '\t')||(LA26_0 >= '\u000B' && LA26_0 <= '!')||(LA26_0 >= '#' && LA26_0 <= '[')||(LA26_0 >= ']' && LA26_0 <= '\uFFFF')) ) {s = 2;}
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA26_12 = input.LA(1);
						s = -1;
						if ( (LA26_12=='\\') ) {s = 11;}
						else if ( ((LA26_12 >= '\u0000' && LA26_12 <= '\t')||(LA26_12 >= '\u000B' && LA26_12 <= '!')||(LA26_12 >= '#' && LA26_12 <= '[')||(LA26_12 >= ']' && LA26_12 <= '\uFFFF')) ) {s = 12;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA26_15 = input.LA(1);
						s = -1;
						if ( (LA26_15=='\\') ) {s = 11;}
						else if ( ((LA26_15 >= '\u0000' && LA26_15 <= '\t')||(LA26_15 >= '\u000B' && LA26_15 <= '!')||(LA26_15 >= '#' && LA26_15 <= '[')||(LA26_15 >= ']' && LA26_15 <= '\uFFFF')) ) {s = 12;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA26_3 = input.LA(1);
						s = -1;
						if ( ((LA26_3 >= '\u0000' && LA26_3 <= '\t')||(LA26_3 >= '\u000B' && LA26_3 <= '!')||(LA26_3 >= '#' && LA26_3 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA26_3=='\n') ) {s = 6;}
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA26_10 = input.LA(1);
						s = -1;
						if ( ((LA26_10 >= '\u0000' && LA26_10 <= '\t')||(LA26_10 >= '\u000B' && LA26_10 <= '!')||(LA26_10 >= '#' && LA26_10 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA26_10=='\n') ) {s = 6;}
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA26_13 = input.LA(1);
						s = -1;
						if ( (LA26_13=='\\') ) {s = 11;}
						else if ( ((LA26_13 >= '\u0000' && LA26_13 <= '\t')||(LA26_13 >= '\u000B' && LA26_13 <= '!')||(LA26_13 >= '#' && LA26_13 <= '[')||(LA26_13 >= ']' && LA26_13 <= '\uFFFF')) ) {s = 12;}
						else if ( (LA26_13=='\n') ) {s = 16;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA26_8 = input.LA(1);
						s = -1;
						if ( (LA26_8=='\\') ) {s = 11;}
						else if ( ((LA26_8 >= '\u0000' && LA26_8 <= '\t')||(LA26_8 >= '\u000B' && LA26_8 <= '!')||(LA26_8 >= '#' && LA26_8 <= '[')||(LA26_8 >= ']' && LA26_8 <= '\uFFFF')) ) {s = 12;}
						else s = 6;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 26, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA27_eotS =
		"\4\uffff\1\6\2\uffff\2\6\2\uffff\3\6\1\uffff\1\6\1\uffff";
	static final String DFA27_eofS =
		"\21\uffff";
	static final String DFA27_minS =
		"\2\0\1\uffff\2\0\2\uffff\7\0\1\uffff\1\0\1\uffff";
	static final String DFA27_maxS =
		"\2\uffff\1\uffff\2\uffff\2\uffff\7\uffff\1\uffff\1\uffff\1\uffff";
	static final String DFA27_acceptS =
		"\2\uffff\1\2\2\uffff\1\1\1\3\7\uffff\1\1\1\uffff\1\1";
	static final String DFA27_specialS =
		"\1\13\1\4\1\uffff\1\0\1\1\2\uffff\1\2\1\11\1\12\1\3\1\7\1\5\1\10\1\uffff"+
		"\1\6\1\uffff}>";
	static final String[] DFA27_transitionS = {
			"\12\2\1\uffff\34\2\1\uffff\64\2\1\1\uffa3\2",
			"\12\5\1\4\2\5\1\3\ufff2\5",
			"",
			"\12\5\1\6\34\5\1\uffff\uffd8\5",
			"\11\5\1\7\1\uffff\1\5\1\11\1\12\22\5\1\7\2\5\1\10\3\5\1\uffff\uffd8"+
			"\5",
			"",
			"",
			"\11\5\1\7\1\uffff\1\5\1\11\1\12\22\5\1\7\2\5\1\10\3\5\1\uffff\uffd8"+
			"\5",
			"\12\14\1\uffff\34\14\1\uffff\64\14\1\13\uffa3\14",
			"\12\5\1\6\2\5\1\12\31\5\1\uffff\uffd8\5",
			"\12\5\1\6\34\5\1\uffff\uffd8\5",
			"\12\17\1\16\2\17\1\15\ufff2\17",
			"\12\14\1\uffff\34\14\1\uffff\64\14\1\13\uffa3\14",
			"\12\14\1\20\34\14\1\uffff\64\14\1\13\uffa3\14",
			"",
			"\12\14\1\uffff\34\14\1\uffff\64\14\1\13\uffa3\14",
			""
	};

	static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
	static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
	static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
	static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
	static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
	static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
	static final short[][] DFA27_transition;

	static {
		int numStates = DFA27_transitionS.length;
		DFA27_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
		}
	}

	protected class DFA27 extends DFA {

		public DFA27(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 27;
			this.eot = DFA27_eot;
			this.eof = DFA27_eof;
			this.min = DFA27_min;
			this.max = DFA27_max;
			this.accept = DFA27_accept;
			this.special = DFA27_special;
			this.transition = DFA27_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 1100:18: ( ESC |~ ( '\\\\' | '\\n' | '\\'' ) )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA27_3 = input.LA(1);
						s = -1;
						if ( ((LA27_3 >= '\u0000' && LA27_3 <= '\t')||(LA27_3 >= '\u000B' && LA27_3 <= '&')||(LA27_3 >= '(' && LA27_3 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA27_3=='\n') ) {s = 6;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA27_4 = input.LA(1);
						s = -1;
						if ( ((LA27_4 >= '\u0000' && LA27_4 <= '\b')||LA27_4=='\u000B'||(LA27_4 >= '\u000E' && LA27_4 <= '\u001F')||(LA27_4 >= '!' && LA27_4 <= '\"')||(LA27_4 >= '$' && LA27_4 <= '&')||(LA27_4 >= '(' && LA27_4 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA27_4=='\t'||LA27_4==' ') ) {s = 7;}
						else if ( (LA27_4=='#') ) {s = 8;}
						else if ( (LA27_4=='\f') ) {s = 9;}
						else if ( (LA27_4=='\r') ) {s = 10;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA27_7 = input.LA(1);
						s = -1;
						if ( ((LA27_7 >= '\u0000' && LA27_7 <= '\b')||LA27_7=='\u000B'||(LA27_7 >= '\u000E' && LA27_7 <= '\u001F')||(LA27_7 >= '!' && LA27_7 <= '\"')||(LA27_7 >= '$' && LA27_7 <= '&')||(LA27_7 >= '(' && LA27_7 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA27_7=='\t'||LA27_7==' ') ) {s = 7;}
						else if ( (LA27_7=='#') ) {s = 8;}
						else if ( (LA27_7=='\f') ) {s = 9;}
						else if ( (LA27_7=='\r') ) {s = 10;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA27_10 = input.LA(1);
						s = -1;
						if ( ((LA27_10 >= '\u0000' && LA27_10 <= '\t')||(LA27_10 >= '\u000B' && LA27_10 <= '&')||(LA27_10 >= '(' && LA27_10 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA27_10=='\n') ) {s = 6;}
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA27_1 = input.LA(1);
						s = -1;
						if ( (LA27_1=='\r') ) {s = 3;}
						else if ( (LA27_1=='\n') ) {s = 4;}
						else if ( ((LA27_1 >= '\u0000' && LA27_1 <= '\t')||(LA27_1 >= '\u000B' && LA27_1 <= '\f')||(LA27_1 >= '\u000E' && LA27_1 <= '\uFFFF')) ) {s = 5;}
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA27_12 = input.LA(1);
						s = -1;
						if ( (LA27_12=='\\') ) {s = 11;}
						else if ( ((LA27_12 >= '\u0000' && LA27_12 <= '\t')||(LA27_12 >= '\u000B' && LA27_12 <= '&')||(LA27_12 >= '(' && LA27_12 <= '[')||(LA27_12 >= ']' && LA27_12 <= '\uFFFF')) ) {s = 12;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA27_15 = input.LA(1);
						s = -1;
						if ( (LA27_15=='\\') ) {s = 11;}
						else if ( ((LA27_15 >= '\u0000' && LA27_15 <= '\t')||(LA27_15 >= '\u000B' && LA27_15 <= '&')||(LA27_15 >= '(' && LA27_15 <= '[')||(LA27_15 >= ']' && LA27_15 <= '\uFFFF')) ) {s = 12;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA27_11 = input.LA(1);
						s = -1;
						if ( (LA27_11=='\r') ) {s = 13;}
						else if ( (LA27_11=='\n') ) {s = 14;}
						else if ( ((LA27_11 >= '\u0000' && LA27_11 <= '\t')||(LA27_11 >= '\u000B' && LA27_11 <= '\f')||(LA27_11 >= '\u000E' && LA27_11 <= '\uFFFF')) ) {s = 15;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA27_13 = input.LA(1);
						s = -1;
						if ( (LA27_13=='\\') ) {s = 11;}
						else if ( ((LA27_13 >= '\u0000' && LA27_13 <= '\t')||(LA27_13 >= '\u000B' && LA27_13 <= '&')||(LA27_13 >= '(' && LA27_13 <= '[')||(LA27_13 >= ']' && LA27_13 <= '\uFFFF')) ) {s = 12;}
						else if ( (LA27_13=='\n') ) {s = 16;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA27_8 = input.LA(1);
						s = -1;
						if ( (LA27_8=='\\') ) {s = 11;}
						else if ( ((LA27_8 >= '\u0000' && LA27_8 <= '\t')||(LA27_8 >= '\u000B' && LA27_8 <= '&')||(LA27_8 >= '(' && LA27_8 <= '[')||(LA27_8 >= ']' && LA27_8 <= '\uFFFF')) ) {s = 12;}
						else s = 6;
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA27_9 = input.LA(1);
						s = -1;
						if ( ((LA27_9 >= '\u0000' && LA27_9 <= '\t')||(LA27_9 >= '\u000B' && LA27_9 <= '\f')||(LA27_9 >= '\u000E' && LA27_9 <= '&')||(LA27_9 >= '(' && LA27_9 <= '\uFFFF')) ) {s = 5;}
						else if ( (LA27_9=='\r') ) {s = 10;}
						else if ( (LA27_9=='\n') ) {s = 6;}
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA27_0 = input.LA(1);
						s = -1;
						if ( (LA27_0=='\\') ) {s = 1;}
						else if ( ((LA27_0 >= '\u0000' && LA27_0 <= '\t')||(LA27_0 >= '\u000B' && LA27_0 <= '&')||(LA27_0 >= '(' && LA27_0 <= '[')||(LA27_0 >= ']' && LA27_0 <= '\uFFFF')) ) {s = 2;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 27, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA51_eotS =
		"\2\uffff\2\4\1\uffff";
	static final String DFA51_eofS =
		"\5\uffff";
	static final String DFA51_minS =
		"\1\11\1\uffff\2\0\1\uffff";
	static final String DFA51_maxS =
		"\1\43\1\uffff\2\uffff\1\uffff";
	static final String DFA51_acceptS =
		"\1\uffff\1\1\2\uffff\1\2";
	static final String DFA51_specialS =
		"\1\2\1\uffff\1\1\1\0\1\uffff}>";
	static final String[] DFA51_transitionS = {
			"\1\1\26\uffff\1\1\2\uffff\1\2",
			"",
			"\12\3\1\1\ufff5\3",
			"\12\3\1\1\ufff5\3",
			""
	};

	static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
	static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
	static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
	static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
	static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
	static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
	static final short[][] DFA51_transition;

	static {
		int numStates = DFA51_transitionS.length;
		DFA51_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
		}
	}

	protected class DFA51 extends DFA {

		public DFA51(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 51;
			this.eot = DFA51_eot;
			this.eof = DFA51_eof;
			this.min = DFA51_min;
			this.max = DFA51_max;
			this.accept = DFA51_accept;
			this.special = DFA51_special;
			this.transition = DFA51_transition;
		}
		@Override
		public String getDescription() {
			return "1252:1: COMMENT : ({...}? => ( ' ' | '\\t' )* '#' (~ '\\n' )* ( '\\n' )+ | '#' (~ '\\n' )* );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA51_3 = input.LA(1);
						 
						int index51_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA51_3=='\n') && ((startPos==0))) {s = 1;}
						else if ( ((LA51_3 >= '\u0000' && LA51_3 <= '\t')||(LA51_3 >= '\u000B' && LA51_3 <= '\uFFFF')) ) {s = 3;}
						else s = 4;
						 
						input.seek(index51_3);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA51_2 = input.LA(1);
						 
						int index51_2 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA51_2 >= '\u0000' && LA51_2 <= '\t')||(LA51_2 >= '\u000B' && LA51_2 <= '\uFFFF')) ) {s = 3;}
						else if ( (LA51_2=='\n') && ((startPos==0))) {s = 1;}
						else s = 4;
						 
						input.seek(index51_2);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA51_0 = input.LA(1);
						 
						int index51_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA51_0=='\t'||LA51_0==' ') && ((startPos==0))) {s = 1;}
						else if ( (LA51_0=='#') ) {s = 2;}
						 
						input.seek(index51_0);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 51, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA52_eotS =
		"\1\uffff\16\57\7\uffff\1\123\1\126\1\131\1\134\1\136\1\140\1\144\1\147"+
		"\1\151\1\153\3\uffff\1\155\2\uffff\1\156\1\uffff\2\57\2\163\3\57\4\uffff"+
		"\1\u0085\1\uffff\2\u0086\1\uffff\1\u008b\14\57\1\u009b\1\57\1\u009d\1"+
		"\u009e\11\57\5\uffff\1\u00a9\2\uffff\1\u00ab\10\uffff\1\u00ad\2\uffff"+
		"\1\u00af\10\uffff\1\u00b0\1\u00b2\1\57\2\uffff\1\u00b0\1\163\4\uffff\1"+
		"\163\4\57\1\u00ba\2\uffff\1\u00ba\6\uffff\2\57\1\uffff\1\57\1\u00c5\3"+
		"\57\1\u00c9\1\u00ca\6\57\1\u00d1\1\57\1\uffff\1\57\2\uffff\5\57\1\u00d9"+
		"\3\57\13\uffff\1\u00df\1\163\1\uffff\1\u00b0\1\uffff\1\u00b0\1\u00e6\2"+
		"\uffff\1\u00e7\1\uffff\1\u00e6\1\uffff\1\u00e7\1\uffff\3\57\1\uffff\3"+
		"\57\2\uffff\1\u00f9\1\u00fa\3\57\1\u00fe\1\uffff\3\57\1\u0102\3\57\1\uffff"+
		"\1\57\1\u0107\1\57\1\uffff\1\u00b0\2\uffff\1\u00b0\1\uffff\3\u00e6\2\uffff"+
		"\2\u00e7\2\uffff\3\u00e6\2\u00e7\2\uffff\1\57\1\u0116\1\u0117\1\u0118"+
		"\1\u0119\1\57\2\uffff\1\57\1\u011c\1\57\1\uffff\3\57\1\uffff\1\u0121\1"+
		"\u0122\1\57\1\u0124\1\uffff\1\u0125\1\uffff\1\u00b0\2\u00e6\1\u00ba\2"+
		"\u00e7\2\u00e6\1\u00ba\2\u00e7\1\u012e\4\uffff\1\57\1\u0130\1\uffff\1"+
		"\57\1\u0132\1\u0133\1\u0134\2\uffff\1\u0135\2\uffff\1\u00ba\3\u00e7\1"+
		"\u00ba\3\u00e7\1\uffff\1\57\1\uffff\1\u0137\4\uffff\1\u0138\2\uffff";
	static final String DFA52_eofS =
		"\u0139\uffff";
	static final String DFA52_minS =
		"\1\11\1\156\1\162\1\154\1\145\1\154\1\151\1\154\1\146\2\141\1\42\1\162"+
		"\1\150\1\151\7\uffff\2\75\1\52\1\57\2\75\1\74\3\75\3\uffff\1\75\2\uffff"+
		"\1\60\1\uffff\1\162\1\157\2\56\3\42\1\uffff\2\0\1\uffff\1\12\1\uffff\2"+
		"\11\1\uffff\1\60\1\141\1\144\1\145\1\141\1\156\1\146\1\151\1\143\1\156"+
		"\1\157\1\162\1\157\1\60\1\160\2\60\1\155\1\163\2\151\1\164\1\171\1\151"+
		"\1\164\1\145\5\uffff\1\75\2\uffff\1\75\10\uffff\1\75\2\uffff\1\75\10\uffff"+
		"\2\60\1\164\1\60\1\uffff\1\60\1\56\1\53\1\56\2\uffff\1\56\4\42\1\47\2"+
		"\0\1\42\2\0\1\uffff\1\0\2\uffff\1\145\1\156\1\uffff\1\151\1\60\1\141\1"+
		"\163\1\164\2\60\1\146\2\145\1\143\1\141\1\155\1\60\1\142\1\uffff\1\157"+
		"\2\uffff\1\142\1\163\1\156\1\163\1\165\1\60\1\154\1\150\1\154\11\uffff"+
		"\1\53\1\uffff\2\60\1\53\3\60\1\0\1\uffff\7\0\1\162\1\143\1\164\1\uffff"+
		"\1\153\1\163\1\151\2\uffff\2\60\1\160\1\61\1\154\1\60\1\uffff\1\141\1"+
		"\162\1\144\1\60\1\164\1\145\1\162\1\uffff\1\145\1\60\1\144\2\60\1\uffff"+
		"\2\60\1\53\3\0\2\uffff\13\0\1\164\4\60\1\156\2\uffff\1\164\1\60\1\154"+
		"\1\uffff\1\154\1\164\1\141\1\uffff\2\60\1\156\1\60\1\uffff\3\60\12\0\1"+
		"\60\4\uffff\1\165\1\60\1\uffff\1\171\3\60\2\uffff\1\60\2\uffff\10\0\1"+
		"\uffff\1\145\1\uffff\1\60\4\uffff\1\60\2\uffff";
	static final String DFA52_maxS =
		"\1\ufffe\1\167\1\162\1\157\1\145\1\170\1\162\1\154\1\163\1\141\1\162\1"+
		"\145\1\162\2\151\7\uffff\1\75\1\76\4\75\2\76\2\75\3\uffff\1\75\2\uffff"+
		"\1\71\1\uffff\1\162\1\157\1\170\1\154\1\162\1\47\1\162\1\uffff\2\uffff"+
		"\1\uffff\1\15\1\uffff\2\43\1\uffff\1\ufffe\1\141\1\144\1\145\1\141\1\156"+
		"\1\154\1\163\1\145\1\156\1\157\1\162\1\157\1\ufffe\1\160\2\ufffe\1\155"+
		"\1\163\2\151\1\164\1\171\1\151\1\164\1\145\5\uffff\1\75\2\uffff\1\75\10"+
		"\uffff\1\75\2\uffff\1\75\10\uffff\1\152\1\ufffe\1\164\1\146\1\uffff\1"+
		"\152\1\154\1\71\1\152\2\uffff\1\154\5\47\2\uffff\1\42\2\uffff\1\uffff"+
		"\1\0\2\uffff\1\145\1\156\1\uffff\1\151\1\ufffe\1\141\1\163\1\164\2\ufffe"+
		"\1\146\2\145\1\143\1\141\1\155\1\ufffe\1\142\1\uffff\1\157\2\uffff\1\142"+
		"\1\163\1\156\1\163\1\165\1\ufffe\1\154\1\150\1\154\11\uffff\1\71\1\uffff"+
		"\1\ufffe\1\154\1\71\1\152\1\71\1\152\1\uffff\1\uffff\7\uffff\1\162\1\143"+
		"\1\164\1\uffff\1\153\1\163\1\151\2\uffff\2\ufffe\1\160\1\61\1\154\1\ufffe"+
		"\1\uffff\1\141\1\162\1\144\1\ufffe\1\164\1\145\1\162\1\uffff\1\145\1\ufffe"+
		"\1\144\1\71\1\152\1\uffff\1\71\1\152\1\71\3\uffff\2\uffff\13\uffff\1\164"+
		"\4\ufffe\1\156\2\uffff\1\164\1\ufffe\1\154\1\uffff\1\154\1\164\1\141\1"+
		"\uffff\2\ufffe\1\156\1\ufffe\1\uffff\1\ufffe\1\71\1\152\12\uffff\1\ufffe"+
		"\4\uffff\1\165\1\ufffe\1\uffff\1\171\3\ufffe\2\uffff\1\ufffe\2\uffff\10"+
		"\uffff\1\uffff\1\145\1\uffff\1\ufffe\4\uffff\1\ufffe\2\uffff";
	static final String DFA52_acceptS =
		"\17\uffff\1\37\1\40\1\41\1\42\1\43\1\44\1\45\12\uffff\1\60\1\61\1\62\1"+
		"\uffff\1\64\1\66\1\uffff\1\114\7\uffff\1\124\2\uffff\1\130\1\uffff\1\131"+
		"\2\uffff\1\134\32\uffff\1\74\1\46\1\75\1\112\1\47\1\uffff\1\77\1\50\1"+
		"\uffff\1\101\1\51\1\102\1\52\1\104\1\53\1\67\1\70\1\uffff\1\54\1\72\1"+
		"\uffff\1\55\1\65\1\56\1\103\1\57\1\105\1\63\1\113\4\uffff\1\122\4\uffff"+
		"\1\121\1\123\13\uffff\1\132\1\uffff\1\133\1\134\2\uffff\1\1\17\uffff\1"+
		"\21\1\uffff\1\23\1\24\11\uffff\1\110\1\76\1\111\1\100\1\106\1\71\1\107"+
		"\1\73\1\120\1\uffff\1\116\7\uffff\1\125\12\uffff\1\115\3\uffff\1\10\1"+
		"\11\6\uffff\1\17\7\uffff\1\33\5\uffff\1\117\6\uffff\1\126\1\127\21\uffff"+
		"\1\12\1\26\3\uffff\1\16\3\uffff\1\27\4\uffff\1\35\16\uffff\1\3\1\4\1\5"+
		"\1\6\2\uffff\1\14\4\uffff\1\30\1\31\1\uffff\1\34\1\36\10\uffff\1\2\1\uffff"+
		"\1\13\1\uffff\1\20\1\22\1\25\1\32\1\uffff\1\15\1\7";
	static final String DFA52_specialS =
		"\1\12\57\uffff\1\36\1\10\1\uffff\1\15\1\uffff\1\20\1\22\111\uffff\1\30"+
		"\1\35\1\uffff\1\31\1\6\1\uffff\1\13\62\uffff\1\16\1\uffff\1\55\1\62\1"+
		"\50\1\2\1\26\1\32\1\17\41\uffff\1\4\1\33\1\7\2\uffff\1\56\1\1\1\24\1\54"+
		"\1\46\1\37\1\41\1\25\1\34\1\0\1\23\30\uffff\1\61\1\45\1\51\1\44\1\52\1"+
		"\53\1\14\1\43\1\42\1\21\21\uffff\1\57\1\5\1\11\1\60\1\3\1\40\1\47\1\27"+
		"\13\uffff}>";
	static final String[] DFA52_transitionS = {
			"\1\66\1\64\1\uffff\1\63\1\64\22\uffff\1\65\1\45\1\61\1\67\1\uffff\1\37"+
			"\1\33\1\60\1\17\1\20\1\30\1\26\1\24\1\27\1\46\1\31\1\52\11\53\1\23\1"+
			"\25\1\34\1\36\1\35\1\uffff\1\47\21\57\1\55\2\57\1\56\5\57\1\21\1\62\1"+
			"\22\1\43\1\57\1\40\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\57\1\10\2\57\1\11\1"+
			"\57\1\51\1\50\1\12\1\57\1\13\1\57\1\14\1\54\1\57\1\15\1\57\1\16\1\57"+
			"\1\41\1\32\1\42\1\44\101\uffff\27\57\1\uffff\37\57\1\uffff\uff07\57",
			"\1\72\4\uffff\1\70\3\uffff\1\71",
			"\1\73",
			"\1\74\2\uffff\1\75",
			"\1\76",
			"\1\77\13\uffff\1\100",
			"\1\101\5\uffff\1\103\2\uffff\1\102",
			"\1\104",
			"\1\105\6\uffff\1\106\1\107\4\uffff\1\110",
			"\1\111",
			"\1\112\20\uffff\1\113",
			"\1\61\4\uffff\1\60\71\uffff\1\114\3\uffff\1\115",
			"\1\116",
			"\1\117\1\120",
			"\1\121",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\122",
			"\1\124\1\125",
			"\1\127\22\uffff\1\130",
			"\1\132\15\uffff\1\133",
			"\1\135",
			"\1\137",
			"\1\143\1\142\1\141",
			"\1\145\1\146",
			"\1\150",
			"\1\152",
			"",
			"",
			"",
			"\1\154",
			"",
			"",
			"\12\157",
			"",
			"\1\160",
			"\1\161",
			"\1\164\1\uffff\10\165\2\167\13\uffff\1\166\4\uffff\1\171\1\uffff\1\170"+
			"\13\uffff\1\162\14\uffff\1\166\4\uffff\1\171\1\uffff\1\170\13\uffff\1"+
			"\162",
			"\1\164\1\uffff\12\172\13\uffff\1\166\4\uffff\1\171\1\uffff\1\170\30"+
			"\uffff\1\166\4\uffff\1\171\1\uffff\1\170",
			"\1\61\4\uffff\1\60\52\uffff\1\174\37\uffff\1\173",
			"\1\61\4\uffff\1\60",
			"\1\61\4\uffff\1\60\52\uffff\1\175\37\uffff\1\176",
			"",
			"\12\u0081\1\uffff\34\u0081\1\177\64\u0081\1\u0080\uffa3\u0081",
			"\12\u0084\1\uffff\27\u0084\1\u0082\71\u0084\1\u0083\uffa3\u0084",
			"",
			"\1\64\2\uffff\1\64",
			"",
			"\1\66\1\u0087\1\uffff\1\u0085\1\u0087\22\uffff\1\65\2\uffff\1\u0088",
			"\1\66\1\u0087\1\uffff\1\u0085\1\u0087\22\uffff\1\65\2\uffff\1\u0088",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\22\57\1\u0089\5\57\1\u008a"+
			"\1\57\105\uffff\27\57\1\uffff\37\57\1\uffff\uff07\57",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091\5\uffff\1\u0092",
			"\1\u0093\11\uffff\1\u0094",
			"\1\u0095\1\uffff\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u009c",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"",
			"",
			"",
			"",
			"",
			"\1\u00a8",
			"",
			"",
			"\1\u00aa",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00ac",
			"",
			"",
			"\1\u00ae",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\157\13\uffff\1\u00b1\4\uffff\1\171\32\uffff\1\u00b1\4\uffff\1\171",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u00b3",
			"\12\u00b4\7\uffff\6\u00b4\32\uffff\6\u00b4",
			"",
			"\12\u00b6\13\uffff\1\u00b5\4\uffff\1\171\32\uffff\1\u00b5\4\uffff\1"+
			"\171",
			"\1\164\1\uffff\10\165\2\167\13\uffff\1\166\4\uffff\1\171\1\uffff\1\170"+
			"\30\uffff\1\166\4\uffff\1\171\1\uffff\1\170",
			"\1\u00b7\1\uffff\1\u00b7\2\uffff\12\u00b8",
			"\1\164\1\uffff\12\167\13\uffff\1\166\4\uffff\1\171\32\uffff\1\166\4"+
			"\uffff\1\171",
			"",
			"",
			"\1\164\1\uffff\12\172\13\uffff\1\166\4\uffff\1\171\1\uffff\1\170\30"+
			"\uffff\1\166\4\uffff\1\171\1\uffff\1\170",
			"\1\61\4\uffff\1\60",
			"\1\61\4\uffff\1\60",
			"\1\61\4\uffff\1\60",
			"\1\61\4\uffff\1\60",
			"\1\u00b9",
			"\12\u00bd\1\u00bc\2\u00bd\1\u00bb\ufff2\u00bd",
			"\12\u0081\1\uffff\34\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\1\u00be",
			"\12\u00c1\1\u00c0\2\u00c1\1\u00bf\ufff2\u00c1",
			"\12\u0084\1\uffff\27\u0084\1\u00ba\71\u0084\1\u0083\uffa3\u0084",
			"",
			"\1\uffff",
			"",
			"",
			"\1\u00c2",
			"\1\u00c3",
			"",
			"\1\u00c4",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u00c6",
			"\1\u00c7",
			"\1\u00c8",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00cf",
			"\1\u00d0",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u00d2",
			"",
			"\1\u00d3",
			"",
			"",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u00da",
			"\1\u00db",
			"\1\u00dc",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00dd\1\uffff\1\u00dd\2\uffff\12\u00de",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\u00b4\7\uffff\6\u00b4\5\uffff\1\170\24\uffff\6\u00b4\5\uffff\1\170",
			"\1\u00e0\1\uffff\1\u00e0\2\uffff\12\u00e1",
			"\12\u00b6\13\uffff\1\u00e2\4\uffff\1\171\32\uffff\1\u00e2\4\uffff\1"+
			"\171",
			"\12\u00b8",
			"\12\u00b8\20\uffff\1\171\37\uffff\1\171",
			"\47\u00e5\1\u00e3\64\u00e5\1\u00e4\uffa3\u00e5",
			"",
			"\12\u0081\1\u00e7\34\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\11\u0081\1\u00e8\1\uffff\1\u0081\1\u00ea\1\u00eb\22\u0081\1\u00e8\2"+
			"\u0081\1\u00e9\3\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\12\u0081\1\uffff\34\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\42\u00ee\1\u00ec\71\u00ee\1\u00ed\uffa3\u00ee",
			"\12\u0084\1\u00e7\27\u0084\1\u00ba\71\u0084\1\u0083\uffa3\u0084",
			"\11\u0084\1\u00ef\1\uffff\1\u0084\1\u00f1\1\u00f2\22\u0084\1\u00ef\1"+
			"\u0084\1\u00ba\1\u00f0\70\u0084\1\u0083\uffa3\u0084",
			"\12\u0084\1\uffff\27\u0084\1\u00ba\71\u0084\1\u0083\uffa3\u0084",
			"\1\u00f3",
			"\1\u00f4",
			"\1\u00f5",
			"",
			"\1\u00f6",
			"\1\u00f7",
			"\1\u00f8",
			"",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u00fb",
			"\1\u00fc",
			"\1\u00fd",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"",
			"\1\u0106",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u0108",
			"\12\u00de",
			"\12\u00de\20\uffff\1\171\37\uffff\1\171",
			"",
			"\12\u00e1",
			"\12\u00e1\20\uffff\1\171\37\uffff\1\171",
			"\1\u0109\1\uffff\1\u0109\2\uffff\12\u010a",
			"\47\u00e5\1\u010b\64\u00e5\1\u00e4\uffa3\u00e5",
			"\0\u010c",
			"\47\u00e5\1\u00e3\64\u00e5\1\u00e4\uffa3\u00e5",
			"",
			"",
			"\11\u0081\1\u00e8\1\uffff\1\u0081\1\u00ea\1\u00eb\22\u0081\1\u00e8\2"+
			"\u0081\1\u00e9\3\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\12\u010f\1\uffff\34\u010f\1\u010d\64\u010f\1\u010e\uffa3\u010f",
			"\12\u0081\1\u00e7\2\u0081\1\u00eb\31\u0081\1\u00ba\64\u0081\1\u0080"+
			"\uffa3\u0081",
			"\12\u0081\1\u00e7\34\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\42\u00ee\1\u0110\71\u00ee\1\u00ed\uffa3\u00ee",
			"\0\u0111",
			"\42\u00ee\1\u00ec\71\u00ee\1\u00ed\uffa3\u00ee",
			"\11\u0084\1\u00ef\1\uffff\1\u0084\1\u00f1\1\u00f2\22\u0084\1\u00ef\1"+
			"\u0084\1\u00ba\1\u00f0\70\u0084\1\u0083\uffa3\u0084",
			"\12\u0114\1\uffff\27\u0114\1\u0112\71\u0114\1\u0113\uffa3\u0114",
			"\12\u0084\1\u00e7\2\u0084\1\u00f2\24\u0084\1\u00ba\71\u0084\1\u0083"+
			"\uffa3\u0084",
			"\12\u0084\1\u00e7\27\u0084\1\u00ba\71\u0084\1\u0083\uffa3\u0084",
			"\1\u0115",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u011a",
			"",
			"",
			"\1\u011b",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u011d",
			"",
			"\1\u011e",
			"\1\u011f",
			"\1\u0120",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\1\u0123",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\u010a",
			"\12\u010a\20\uffff\1\171\37\uffff\1\171",
			"\47\u00e5\1\u0126\64\u00e5\1\u00e4\uffa3\u00e5",
			"\47\u00e5\1\u00e3\64\u00e5\1\u00e4\uffa3\u00e5",
			"\0\u00e7",
			"\12\u0129\1\u0128\2\u0129\1\u0127\ufff2\u0129",
			"\12\u010f\1\uffff\34\u010f\1\u010d\64\u010f\1\u010e\uffa3\u010f",
			"\42\u00ee\1\u012a\71\u00ee\1\u00ed\uffa3\u00ee",
			"\42\u00ee\1\u00ec\71\u00ee\1\u00ed\uffa3\u00ee",
			"\0\u00e7",
			"\12\u012d\1\u012c\2\u012d\1\u012b\ufff2\u012d",
			"\12\u0114\1\uffff\27\u0114\1\u0112\71\u0114\1\u0113\uffa3\u0114",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"",
			"",
			"",
			"\1\u012f",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"\1\u0131",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"",
			"\0\u00e6",
			"\12\u010f\1\uffff\34\u010f\1\u010d\64\u010f\1\u010e\uffa3\u010f",
			"\11\u0081\1\u00e8\1\uffff\1\u0081\1\u00ea\1\u00eb\22\u0081\1\u00e8\2"+
			"\u0081\1\u00e9\3\u0081\1\u00ba\64\u0081\1\u0080\uffa3\u0081",
			"\12\u010f\1\uffff\34\u010f\1\u010d\64\u010f\1\u010e\uffa3\u010f",
			"\0\u00e6",
			"\12\u0114\1\uffff\27\u0114\1\u0112\71\u0114\1\u0113\uffa3\u0114",
			"\11\u0084\1\u00ef\1\uffff\1\u0084\1\u00f1\1\u00f2\22\u0084\1\u00ef\1"+
			"\u0084\1\u00ba\1\u00f0\70\u0084\1\u0083\uffa3\u0084",
			"\12\u0114\1\uffff\27\u0114\1\u0112\71\u0114\1\u0113\uffa3\u0114",
			"",
			"\1\u0136",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			"",
			"",
			"",
			"\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57\105\uffff\27\57\1\uffff"+
			"\37\57\1\uffff\uff07\57",
			"",
			""
	};

	static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
	static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
	static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
	static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
	static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
	static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
	static final short[][] DFA52_transition;

	static {
		int numStates = DFA52_transitionS.length;
		DFA52_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
		}
	}

	protected class DFA52 extends DFA {

		public DFA52(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 52;
			this.eot = DFA52_eot;
			this.eof = DFA52_eof;
			this.min = DFA52_min;
			this.max = DFA52_max;
			this.accept = DFA52_accept;
			this.special = DFA52_special;
			this.transition = DFA52_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AS | ASSERT | ASYNC | AWAIT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | ORELSE | PASS | PRINT | RAISE | RETURN | TRY | WHILE | WITH | YIELD | LPAREN | RPAREN | LBRACK | RBRACK | COLON | COMMA | SEMI | PLUS | MINUS | STAR | SLASH | VBAR | AMPER | LESS | GREATER | ASSIGN | PERCENT | BACKQUOTE | LCURLY | RCURLY | CIRCUMFLEX | TILDE | EQUAL | NOTEQUAL | ALT_NOTEQUAL | LESSEQUAL | LEFTSHIFT | GREATEREQUAL | RIGHTSHIFT | PLUSEQUAL | MINUSEQUAL | DOUBLESTAR | STAREQUAL | DOUBLESLASH | SLASHEQUAL | VBAREQUAL | PERCENTEQUAL | AMPEREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL | ARROW | DOT | AT | AND | OR | NOT | FLOAT | LONGINT | INT | COMPLEX | NAME | STRING | TRISTRINGPART | STRINGPART | CONTINUED_LINE | NEWLINE | WS | LEADING_WS | COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA52_241 = input.LA(1);
						s = -1;
						if ( (LA52_241=='\"') ) {s = 186;}
						else if ( (LA52_241=='\\') ) {s = 131;}
						else if ( (LA52_241=='\r') ) {s = 242;}
						else if ( ((LA52_241 >= '\u0000' && LA52_241 <= '\t')||(LA52_241 >= '\u000B' && LA52_241 <= '\f')||(LA52_241 >= '\u000E' && LA52_241 <= '!')||(LA52_241 >= '#' && LA52_241 <= '[')||(LA52_241 >= ']' && LA52_241 <= '\uFFFF')) ) {s = 132;}
						else if ( (LA52_241=='\n') ) {s = 231;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA52_233 = input.LA(1);
						s = -1;
						if ( (LA52_233=='\'') ) {s = 269;}
						else if ( (LA52_233=='\\') ) {s = 270;}
						else if ( ((LA52_233 >= '\u0000' && LA52_233 <= '\t')||(LA52_233 >= '\u000B' && LA52_233 <= '&')||(LA52_233 >= '(' && LA52_233 <= '[')||(LA52_233 >= ']' && LA52_233 <= '\uFFFF')) ) {s = 271;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA52_190 = input.LA(1);
						s = -1;
						if ( (LA52_190=='\"') ) {s = 236;}
						else if ( (LA52_190=='\\') ) {s = 237;}
						else if ( ((LA52_190 >= '\u0000' && LA52_190 <= '!')||(LA52_190 >= '#' && LA52_190 <= '[')||(LA52_190 >= ']' && LA52_190 <= '\uFFFF')) ) {s = 238;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA52_298 = input.LA(1);
						s = -1;
						if ( ((LA52_298 >= '\u0000' && LA52_298 <= '\uFFFF')) ) {s = 230;}
						else s = 186;
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA52_227 = input.LA(1);
						s = -1;
						if ( (LA52_227=='\'') ) {s = 267;}
						else if ( (LA52_227=='\\') ) {s = 228;}
						else if ( ((LA52_227 >= '\u0000' && LA52_227 <= '&')||(LA52_227 >= '(' && LA52_227 <= '[')||(LA52_227 >= ']' && LA52_227 <= '\uFFFF')) ) {s = 229;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA52_295 = input.LA(1);
						s = -1;
						if ( (LA52_295=='\'') ) {s = 269;}
						else if ( (LA52_295=='\\') ) {s = 270;}
						else if ( ((LA52_295 >= '\u0000' && LA52_295 <= '\t')||(LA52_295 >= '\u000B' && LA52_295 <= '&')||(LA52_295 >= '(' && LA52_295 <= '[')||(LA52_295 >= ']' && LA52_295 <= '\uFFFF')) ) {s = 271;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA52_132 = input.LA(1);
						s = -1;
						if ( (LA52_132=='\"') ) {s = 186;}
						else if ( (LA52_132=='\\') ) {s = 131;}
						else if ( ((LA52_132 >= '\u0000' && LA52_132 <= '\t')||(LA52_132 >= '\u000B' && LA52_132 <= '!')||(LA52_132 >= '#' && LA52_132 <= '[')||(LA52_132 >= ']' && LA52_132 <= '\uFFFF')) ) {s = 132;}
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA52_229 = input.LA(1);
						s = -1;
						if ( (LA52_229=='\'') ) {s = 227;}
						else if ( (LA52_229=='\\') ) {s = 228;}
						else if ( ((LA52_229 >= '\u0000' && LA52_229 <= '&')||(LA52_229 >= '(' && LA52_229 <= '[')||(LA52_229 >= ']' && LA52_229 <= '\uFFFF')) ) {s = 229;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA52_49 = input.LA(1);
						s = -1;
						if ( (LA52_49=='\"') ) {s = 130;}
						else if ( (LA52_49=='\\') ) {s = 131;}
						else if ( ((LA52_49 >= '\u0000' && LA52_49 <= '\t')||(LA52_49 >= '\u000B' && LA52_49 <= '!')||(LA52_49 >= '#' && LA52_49 <= '[')||(LA52_49 >= ']' && LA52_49 <= '\uFFFF')) ) {s = 132;}
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA52_296 = input.LA(1);
						s = -1;
						if ( (LA52_296=='\'') ) {s = 186;}
						else if ( (LA52_296=='\\') ) {s = 128;}
						else if ( (LA52_296=='\t'||LA52_296==' ') ) {s = 232;}
						else if ( (LA52_296=='#') ) {s = 233;}
						else if ( (LA52_296=='\f') ) {s = 234;}
						else if ( (LA52_296=='\r') ) {s = 235;}
						else if ( ((LA52_296 >= '\u0000' && LA52_296 <= '\b')||LA52_296=='\u000B'||(LA52_296 >= '\u000E' && LA52_296 <= '\u001F')||(LA52_296 >= '!' && LA52_296 <= '\"')||(LA52_296 >= '$' && LA52_296 <= '&')||(LA52_296 >= '(' && LA52_296 <= '[')||(LA52_296 >= ']' && LA52_296 <= '\uFFFF')) ) {s = 129;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA52_0 = input.LA(1);
						 
						int index52_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA52_0=='a') ) {s = 1;}
						else if ( (LA52_0=='b') ) {s = 2;}
						else if ( (LA52_0=='c') ) {s = 3;}
						else if ( (LA52_0=='d') ) {s = 4;}
						else if ( (LA52_0=='e') ) {s = 5;}
						else if ( (LA52_0=='f') ) {s = 6;}
						else if ( (LA52_0=='g') ) {s = 7;}
						else if ( (LA52_0=='i') ) {s = 8;}
						else if ( (LA52_0=='l') ) {s = 9;}
						else if ( (LA52_0=='p') ) {s = 10;}
						else if ( (LA52_0=='r') ) {s = 11;}
						else if ( (LA52_0=='t') ) {s = 12;}
						else if ( (LA52_0=='w') ) {s = 13;}
						else if ( (LA52_0=='y') ) {s = 14;}
						else if ( (LA52_0=='(') ) {s = 15;}
						else if ( (LA52_0==')') ) {s = 16;}
						else if ( (LA52_0=='[') ) {s = 17;}
						else if ( (LA52_0==']') ) {s = 18;}
						else if ( (LA52_0==':') ) {s = 19;}
						else if ( (LA52_0==',') ) {s = 20;}
						else if ( (LA52_0==';') ) {s = 21;}
						else if ( (LA52_0=='+') ) {s = 22;}
						else if ( (LA52_0=='-') ) {s = 23;}
						else if ( (LA52_0=='*') ) {s = 24;}
						else if ( (LA52_0=='/') ) {s = 25;}
						else if ( (LA52_0=='|') ) {s = 26;}
						else if ( (LA52_0=='&') ) {s = 27;}
						else if ( (LA52_0=='<') ) {s = 28;}
						else if ( (LA52_0=='>') ) {s = 29;}
						else if ( (LA52_0=='=') ) {s = 30;}
						else if ( (LA52_0=='%') ) {s = 31;}
						else if ( (LA52_0=='`') ) {s = 32;}
						else if ( (LA52_0=='{') ) {s = 33;}
						else if ( (LA52_0=='}') ) {s = 34;}
						else if ( (LA52_0=='^') ) {s = 35;}
						else if ( (LA52_0=='~') ) {s = 36;}
						else if ( (LA52_0=='!') ) {s = 37;}
						else if ( (LA52_0=='.') ) {s = 38;}
						else if ( (LA52_0=='@') ) {s = 39;}
						else if ( (LA52_0=='o') ) {s = 40;}
						else if ( (LA52_0=='n') ) {s = 41;}
						else if ( (LA52_0=='0') ) {s = 42;}
						else if ( ((LA52_0 >= '1' && LA52_0 <= '9')) ) {s = 43;}
						else if ( (LA52_0=='u') ) {s = 44;}
						else if ( (LA52_0=='R') ) {s = 45;}
						else if ( (LA52_0=='U') ) {s = 46;}
						else if ( ((LA52_0 >= 'A' && LA52_0 <= 'Q')||(LA52_0 >= 'S' && LA52_0 <= 'T')||(LA52_0 >= 'V' && LA52_0 <= 'Z')||LA52_0=='_'||LA52_0=='h'||(LA52_0 >= 'j' && LA52_0 <= 'k')||LA52_0=='m'||LA52_0=='q'||LA52_0=='s'||LA52_0=='v'||LA52_0=='x'||LA52_0=='z'||(LA52_0 >= '\u00C0' && LA52_0 <= '\u00D6')||(LA52_0 >= '\u00D8' && LA52_0 <= '\u00F6')||(LA52_0 >= '\u00F8' && LA52_0 <= '\uFFFE')) ) {s = 47;}
						else if ( (LA52_0=='\'') ) {s = 48;}
						else if ( (LA52_0=='\"') ) {s = 49;}
						else if ( (LA52_0=='\\') ) {s = 50;}
						else if ( (LA52_0=='\f') ) {s = 51;}
						else if ( (LA52_0=='\n'||LA52_0=='\r') ) {s = 52;}
						else if ( (LA52_0==' ') && (((startPos==0)||(startPos>0)))) {s = 53;}
						else if ( (LA52_0=='\t') && (((startPos==0)||(startPos>0)))) {s = 54;}
						else if ( (LA52_0=='#') ) {s = 55;}
						 
						input.seek(index52_0);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA52_134 = input.LA(1);
						 
						int index52_134 = input.index();
						input.rewind();
						s = -1;
						if ( ((startPos>0)) ) {s = 133;}
						else if ( ((startPos==0)) ) {s = 135;}
						 
						input.seek(index52_134);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA52_273 = input.LA(1);
						s = -1;
						if ( (LA52_273=='\"') ) {s = 236;}
						else if ( (LA52_273=='\\') ) {s = 237;}
						else if ( ((LA52_273 >= '\u0000' && LA52_273 <= '!')||(LA52_273 >= '#' && LA52_273 <= '[')||(LA52_273 >= ']' && LA52_273 <= '\uFFFF')) ) {s = 238;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA52_51 = input.LA(1);
						 
						int index52_51 = input.index();
						input.rewind();
						s = -1;
						if ( (LA52_51=='\n'||LA52_51=='\r') ) {s = 52;}
						else s = 133;
						 
						input.seek(index52_51);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA52_185 = input.LA(1);
						s = -1;
						if ( (LA52_185=='\'') ) {s = 227;}
						else if ( (LA52_185=='\\') ) {s = 228;}
						else if ( ((LA52_185 >= '\u0000' && LA52_185 <= '&')||(LA52_185 >= '(' && LA52_185 <= '[')||(LA52_185 >= ']' && LA52_185 <= '\uFFFF')) ) {s = 229;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA52_193 = input.LA(1);
						s = -1;
						if ( (LA52_193=='\"') ) {s = 186;}
						else if ( (LA52_193=='\\') ) {s = 131;}
						else if ( ((LA52_193 >= '\u0000' && LA52_193 <= '\t')||(LA52_193 >= '\u000B' && LA52_193 <= '!')||(LA52_193 >= '#' && LA52_193 <= '[')||(LA52_193 >= ']' && LA52_193 <= '\uFFFF')) ) {s = 132;}
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA52_53 = input.LA(1);
						 
						int index52_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA52_53==' ') && (((startPos==0)||(startPos>0)))) {s = 53;}
						else if ( (LA52_53=='\f') && ((startPos>0))) {s = 133;}
						else if ( (LA52_53=='\n'||LA52_53=='\r') && ((startPos==0))) {s = 135;}
						else if ( (LA52_53=='\t') && (((startPos==0)||(startPos>0)))) {s = 54;}
						else if ( (LA52_53=='#') && ((startPos==0))) {s = 136;}
						else s = 134;
						 
						input.seek(index52_53);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA52_276 = input.LA(1);
						s = -1;
						if ( (LA52_276=='\"') ) {s = 274;}
						else if ( (LA52_276=='\\') ) {s = 275;}
						else if ( ((LA52_276 >= '\u0000' && LA52_276 <= '\t')||(LA52_276 >= '\u000B' && LA52_276 <= '!')||(LA52_276 >= '#' && LA52_276 <= '[')||(LA52_276 >= ']' && LA52_276 <= '\uFFFF')) ) {s = 276;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA52_54 = input.LA(1);
						 
						int index52_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA52_54==' ') && (((startPos==0)||(startPos>0)))) {s = 53;}
						else if ( (LA52_54=='\f') && ((startPos>0))) {s = 133;}
						else if ( (LA52_54=='\n'||LA52_54=='\r') && ((startPos==0))) {s = 135;}
						else if ( (LA52_54=='\t') && (((startPos==0)||(startPos>0)))) {s = 54;}
						else if ( (LA52_54=='#') && ((startPos==0))) {s = 136;}
						else s = 134;
						 
						input.seek(index52_54);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA52_242 = input.LA(1);
						s = -1;
						if ( (LA52_242=='\"') ) {s = 186;}
						else if ( (LA52_242=='\\') ) {s = 131;}
						else if ( ((LA52_242 >= '\u0000' && LA52_242 <= '\t')||(LA52_242 >= '\u000B' && LA52_242 <= '!')||(LA52_242 >= '#' && LA52_242 <= '[')||(LA52_242 >= ']' && LA52_242 <= '\uFFFF')) ) {s = 132;}
						else if ( (LA52_242=='\n') ) {s = 231;}
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA52_234 = input.LA(1);
						s = -1;
						if ( (LA52_234=='\'') ) {s = 186;}
						else if ( (LA52_234=='\\') ) {s = 128;}
						else if ( (LA52_234=='\r') ) {s = 235;}
						else if ( ((LA52_234 >= '\u0000' && LA52_234 <= '\t')||(LA52_234 >= '\u000B' && LA52_234 <= '\f')||(LA52_234 >= '\u000E' && LA52_234 <= '&')||(LA52_234 >= '(' && LA52_234 <= '[')||(LA52_234 >= ']' && LA52_234 <= '\uFFFF')) ) {s = 129;}
						else if ( (LA52_234=='\n') ) {s = 231;}
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA52_239 = input.LA(1);
						s = -1;
						if ( (LA52_239=='\"') ) {s = 186;}
						else if ( (LA52_239=='\\') ) {s = 131;}
						else if ( (LA52_239=='\t'||LA52_239==' ') ) {s = 239;}
						else if ( (LA52_239=='#') ) {s = 240;}
						else if ( (LA52_239=='\f') ) {s = 241;}
						else if ( (LA52_239=='\r') ) {s = 242;}
						else if ( ((LA52_239 >= '\u0000' && LA52_239 <= '\b')||LA52_239=='\u000B'||(LA52_239 >= '\u000E' && LA52_239 <= '\u001F')||LA52_239=='!'||(LA52_239 >= '$' && LA52_239 <= '[')||(LA52_239 >= ']' && LA52_239 <= '\uFFFF')) ) {s = 132;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA52_191 = input.LA(1);
						s = -1;
						if ( (LA52_191=='\"') ) {s = 186;}
						else if ( (LA52_191=='\\') ) {s = 131;}
						else if ( ((LA52_191 >= '\u0000' && LA52_191 <= '\t')||(LA52_191 >= '\u000B' && LA52_191 <= '!')||(LA52_191 >= '#' && LA52_191 <= '[')||(LA52_191 >= ']' && LA52_191 <= '\uFFFF')) ) {s = 132;}
						else if ( (LA52_191=='\n') ) {s = 231;}
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA52_301 = input.LA(1);
						s = -1;
						if ( (LA52_301=='\"') ) {s = 274;}
						else if ( (LA52_301=='\\') ) {s = 275;}
						else if ( ((LA52_301 >= '\u0000' && LA52_301 <= '\t')||(LA52_301 >= '\u000B' && LA52_301 <= '!')||(LA52_301 >= '#' && LA52_301 <= '[')||(LA52_301 >= ']' && LA52_301 <= '\uFFFF')) ) {s = 276;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA52_128 = input.LA(1);
						s = -1;
						if ( (LA52_128=='\r') ) {s = 187;}
						else if ( (LA52_128=='\n') ) {s = 188;}
						else if ( ((LA52_128 >= '\u0000' && LA52_128 <= '\t')||(LA52_128 >= '\u000B' && LA52_128 <= '\f')||(LA52_128 >= '\u000E' && LA52_128 <= '\uFFFF')) ) {s = 189;}
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA52_131 = input.LA(1);
						s = -1;
						if ( (LA52_131=='\r') ) {s = 191;}
						else if ( (LA52_131=='\n') ) {s = 192;}
						else if ( ((LA52_131 >= '\u0000' && LA52_131 <= '\t')||(LA52_131 >= '\u000B' && LA52_131 <= '\f')||(LA52_131 >= '\u000E' && LA52_131 <= '\uFFFF')) ) {s = 193;}
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA52_192 = input.LA(1);
						s = -1;
						if ( (LA52_192=='\"') ) {s = 186;}
						else if ( (LA52_192=='\\') ) {s = 131;}
						else if ( (LA52_192=='\t'||LA52_192==' ') ) {s = 239;}
						else if ( (LA52_192=='#') ) {s = 240;}
						else if ( (LA52_192=='\f') ) {s = 241;}
						else if ( (LA52_192=='\r') ) {s = 242;}
						else if ( ((LA52_192 >= '\u0000' && LA52_192 <= '\b')||LA52_192=='\u000B'||(LA52_192 >= '\u000E' && LA52_192 <= '\u001F')||LA52_192=='!'||(LA52_192 >= '$' && LA52_192 <= '[')||(LA52_192 >= ']' && LA52_192 <= '\uFFFF')) ) {s = 132;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA52_228 = input.LA(1);
						s = -1;
						if ( ((LA52_228 >= '\u0000' && LA52_228 <= '\uFFFF')) ) {s = 268;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA52_240 = input.LA(1);
						s = -1;
						if ( (LA52_240=='\"') ) {s = 274;}
						else if ( (LA52_240=='\\') ) {s = 275;}
						else if ( ((LA52_240 >= '\u0000' && LA52_240 <= '\t')||(LA52_240 >= '\u000B' && LA52_240 <= '!')||(LA52_240 >= '#' && LA52_240 <= '[')||(LA52_240 >= ']' && LA52_240 <= '\uFFFF')) ) {s = 276;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA52_129 = input.LA(1);
						s = -1;
						if ( (LA52_129=='\'') ) {s = 186;}
						else if ( (LA52_129=='\\') ) {s = 128;}
						else if ( ((LA52_129 >= '\u0000' && LA52_129 <= '\t')||(LA52_129 >= '\u000B' && LA52_129 <= '&')||(LA52_129 >= '(' && LA52_129 <= '[')||(LA52_129 >= ']' && LA52_129 <= '\uFFFF')) ) {s = 129;}
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA52_48 = input.LA(1);
						s = -1;
						if ( (LA52_48=='\'') ) {s = 127;}
						else if ( (LA52_48=='\\') ) {s = 128;}
						else if ( ((LA52_48 >= '\u0000' && LA52_48 <= '\t')||(LA52_48 >= '\u000B' && LA52_48 <= '&')||(LA52_48 >= '(' && LA52_48 <= '[')||(LA52_48 >= ']' && LA52_48 <= '\uFFFF')) ) {s = 129;}
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA52_237 = input.LA(1);
						s = -1;
						if ( ((LA52_237 >= '\u0000' && LA52_237 <= '\uFFFF')) ) {s = 273;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA52_299 = input.LA(1);
						s = -1;
						if ( (LA52_299=='\"') ) {s = 274;}
						else if ( (LA52_299=='\\') ) {s = 275;}
						else if ( ((LA52_299 >= '\u0000' && LA52_299 <= '\t')||(LA52_299 >= '\u000B' && LA52_299 <= '!')||(LA52_299 >= '#' && LA52_299 <= '[')||(LA52_299 >= ']' && LA52_299 <= '\uFFFF')) ) {s = 276;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA52_238 = input.LA(1);
						s = -1;
						if ( (LA52_238=='\"') ) {s = 236;}
						else if ( (LA52_238=='\\') ) {s = 237;}
						else if ( ((LA52_238 >= '\u0000' && LA52_238 <= '!')||(LA52_238 >= '#' && LA52_238 <= '[')||(LA52_238 >= ']' && LA52_238 <= '\uFFFF')) ) {s = 238;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA52_275 = input.LA(1);
						s = -1;
						if ( (LA52_275=='\r') ) {s = 299;}
						else if ( (LA52_275=='\n') ) {s = 300;}
						else if ( ((LA52_275 >= '\u0000' && LA52_275 <= '\t')||(LA52_275 >= '\u000B' && LA52_275 <= '\f')||(LA52_275 >= '\u000E' && LA52_275 <= '\uFFFF')) ) {s = 301;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA52_274 = input.LA(1);
						s = -1;
						if ( ((LA52_274 >= '\u0000' && LA52_274 <= '\uFFFF')) ) {s = 231;}
						else s = 186;
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA52_270 = input.LA(1);
						s = -1;
						if ( (LA52_270=='\r') ) {s = 295;}
						else if ( (LA52_270=='\n') ) {s = 296;}
						else if ( ((LA52_270 >= '\u0000' && LA52_270 <= '\t')||(LA52_270 >= '\u000B' && LA52_270 <= '\f')||(LA52_270 >= '\u000E' && LA52_270 <= '\uFFFF')) ) {s = 297;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA52_268 = input.LA(1);
						s = -1;
						if ( (LA52_268=='\'') ) {s = 227;}
						else if ( (LA52_268=='\\') ) {s = 228;}
						else if ( ((LA52_268 >= '\u0000' && LA52_268 <= '&')||(LA52_268 >= '(' && LA52_268 <= '[')||(LA52_268 >= ']' && LA52_268 <= '\uFFFF')) ) {s = 229;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA52_236 = input.LA(1);
						s = -1;
						if ( (LA52_236=='\"') ) {s = 272;}
						else if ( (LA52_236=='\\') ) {s = 237;}
						else if ( ((LA52_236 >= '\u0000' && LA52_236 <= '!')||(LA52_236 >= '#' && LA52_236 <= '[')||(LA52_236 >= ']' && LA52_236 <= '\uFFFF')) ) {s = 238;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA52_300 = input.LA(1);
						s = -1;
						if ( (LA52_300=='\"') ) {s = 186;}
						else if ( (LA52_300=='\\') ) {s = 131;}
						else if ( (LA52_300=='\t'||LA52_300==' ') ) {s = 239;}
						else if ( (LA52_300=='#') ) {s = 240;}
						else if ( (LA52_300=='\f') ) {s = 241;}
						else if ( (LA52_300=='\r') ) {s = 242;}
						else if ( ((LA52_300 >= '\u0000' && LA52_300 <= '\b')||LA52_300=='\u000B'||(LA52_300 >= '\u000E' && LA52_300 <= '\u001F')||LA52_300=='!'||(LA52_300 >= '$' && LA52_300 <= '[')||(LA52_300 >= ']' && LA52_300 <= '\uFFFF')) ) {s = 132;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA52_189 = input.LA(1);
						s = -1;
						if ( (LA52_189=='\'') ) {s = 186;}
						else if ( (LA52_189=='\\') ) {s = 128;}
						else if ( ((LA52_189 >= '\u0000' && LA52_189 <= '\t')||(LA52_189 >= '\u000B' && LA52_189 <= '&')||(LA52_189 >= '(' && LA52_189 <= '[')||(LA52_189 >= ']' && LA52_189 <= '\uFFFF')) ) {s = 129;}
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA52_269 = input.LA(1);
						s = -1;
						if ( ((LA52_269 >= '\u0000' && LA52_269 <= '\uFFFF')) ) {s = 231;}
						else s = 186;
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA52_271 = input.LA(1);
						s = -1;
						if ( (LA52_271=='\'') ) {s = 269;}
						else if ( (LA52_271=='\\') ) {s = 270;}
						else if ( ((LA52_271 >= '\u0000' && LA52_271 <= '\t')||(LA52_271 >= '\u000B' && LA52_271 <= '&')||(LA52_271 >= '(' && LA52_271 <= '[')||(LA52_271 >= ']' && LA52_271 <= '\uFFFF')) ) {s = 271;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA52_272 = input.LA(1);
						s = -1;
						if ( (LA52_272=='\"') ) {s = 298;}
						else if ( (LA52_272=='\\') ) {s = 237;}
						else if ( ((LA52_272 >= '\u0000' && LA52_272 <= '!')||(LA52_272 >= '#' && LA52_272 <= '[')||(LA52_272 >= ']' && LA52_272 <= '\uFFFF')) ) {s = 238;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA52_235 = input.LA(1);
						s = -1;
						if ( (LA52_235=='\'') ) {s = 186;}
						else if ( (LA52_235=='\\') ) {s = 128;}
						else if ( ((LA52_235 >= '\u0000' && LA52_235 <= '\t')||(LA52_235 >= '\u000B' && LA52_235 <= '&')||(LA52_235 >= '(' && LA52_235 <= '[')||(LA52_235 >= ']' && LA52_235 <= '\uFFFF')) ) {s = 129;}
						else if ( (LA52_235=='\n') ) {s = 231;}
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA52_187 = input.LA(1);
						s = -1;
						if ( (LA52_187=='\'') ) {s = 186;}
						else if ( (LA52_187=='\\') ) {s = 128;}
						else if ( ((LA52_187 >= '\u0000' && LA52_187 <= '\t')||(LA52_187 >= '\u000B' && LA52_187 <= '&')||(LA52_187 >= '(' && LA52_187 <= '[')||(LA52_187 >= ']' && LA52_187 <= '\uFFFF')) ) {s = 129;}
						else if ( (LA52_187=='\n') ) {s = 231;}
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA52_232 = input.LA(1);
						s = -1;
						if ( (LA52_232=='\'') ) {s = 186;}
						else if ( (LA52_232=='\\') ) {s = 128;}
						else if ( (LA52_232=='\t'||LA52_232==' ') ) {s = 232;}
						else if ( (LA52_232=='#') ) {s = 233;}
						else if ( (LA52_232=='\f') ) {s = 234;}
						else if ( (LA52_232=='\r') ) {s = 235;}
						else if ( ((LA52_232 >= '\u0000' && LA52_232 <= '\b')||LA52_232=='\u000B'||(LA52_232 >= '\u000E' && LA52_232 <= '\u001F')||(LA52_232 >= '!' && LA52_232 <= '\"')||(LA52_232 >= '$' && LA52_232 <= '&')||(LA52_232 >= '(' && LA52_232 <= '[')||(LA52_232 >= ']' && LA52_232 <= '\uFFFF')) ) {s = 129;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA52_294 = input.LA(1);
						s = -1;
						if ( ((LA52_294 >= '\u0000' && LA52_294 <= '\uFFFF')) ) {s = 230;}
						else s = 186;
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA52_297 = input.LA(1);
						s = -1;
						if ( (LA52_297=='\'') ) {s = 269;}
						else if ( (LA52_297=='\\') ) {s = 270;}
						else if ( ((LA52_297 >= '\u0000' && LA52_297 <= '\t')||(LA52_297 >= '\u000B' && LA52_297 <= '&')||(LA52_297 >= '(' && LA52_297 <= '[')||(LA52_297 >= ']' && LA52_297 <= '\uFFFF')) ) {s = 271;}
						else s = 231;
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA52_267 = input.LA(1);
						s = -1;
						if ( (LA52_267=='\'') ) {s = 294;}
						else if ( (LA52_267=='\\') ) {s = 228;}
						else if ( ((LA52_267 >= '\u0000' && LA52_267 <= '&')||(LA52_267 >= '(' && LA52_267 <= '[')||(LA52_267 >= ']' && LA52_267 <= '\uFFFF')) ) {s = 229;}
						else s = 230;
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA52_188 = input.LA(1);
						s = -1;
						if ( (LA52_188=='\'') ) {s = 186;}
						else if ( (LA52_188=='\\') ) {s = 128;}
						else if ( (LA52_188=='\t'||LA52_188==' ') ) {s = 232;}
						else if ( (LA52_188=='#') ) {s = 233;}
						else if ( (LA52_188=='\f') ) {s = 234;}
						else if ( (LA52_188=='\r') ) {s = 235;}
						else if ( ((LA52_188 >= '\u0000' && LA52_188 <= '\b')||LA52_188=='\u000B'||(LA52_188 >= '\u000E' && LA52_188 <= '\u001F')||(LA52_188 >= '!' && LA52_188 <= '\"')||(LA52_188 >= '$' && LA52_188 <= '&')||(LA52_188 >= '(' && LA52_188 <= '[')||(LA52_188 >= ']' && LA52_188 <= '\uFFFF')) ) {s = 129;}
						else s = 231;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 52, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
