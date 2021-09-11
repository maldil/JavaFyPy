// $ANTLR 3.5.2 Python.g 2020-08-11 10:31:53

package org.jpp.astnodes;

import org.jpp.astnodes.ast.alias;
import org.jpp.astnodes.ast.arg;
import org.jpp.astnodes.ast.arguments;
import org.jpp.astnodes.ast.Assert;
import org.jpp.astnodes.ast.Assign;
import org.jpp.astnodes.ast.AsyncFunctionDef;
import org.jpp.astnodes.ast.Attribute;
import org.jpp.astnodes.ast.AugAssign;
import org.jpp.astnodes.ast.Await;
import org.jpp.astnodes.ast.boolopType;
import org.jpp.astnodes.ast.Break;
import org.jpp.astnodes.ast.Bytes;
import org.jpp.astnodes.ast.Call;
import org.jpp.astnodes.ast.ClassDef;
import org.jpp.astnodes.ast.cmpopType;
import org.jpp.astnodes.ast.Compare;
import org.jpp.astnodes.ast.comprehension;
import org.jpp.astnodes.ast.Context;
import org.jpp.astnodes.ast.Continue;
import org.jpp.astnodes.ast.Delete;
import org.jpp.astnodes.ast.Dict;
import org.jpp.astnodes.ast.DictComp;
import org.jpp.astnodes.ast.Ellipsis;
import org.jpp.astnodes.ast.ErrorMod;
import org.jpp.astnodes.ast.ExceptHandler;
import org.jpp.astnodes.ast.Expr;
import org.jpp.astnodes.ast.Expression;
import org.jpp.astnodes.ast.expr_contextType;
import org.jpp.astnodes.ast.FunctionDef;
import org.jpp.astnodes.ast.GeneratorExp;
import org.jpp.astnodes.ast.Global;
import org.jpp.astnodes.ast.If;
import org.jpp.astnodes.ast.IfExp;
import org.jpp.astnodes.ast.Import;
import org.jpp.astnodes.ast.ImportFrom;
import org.jpp.astnodes.ast.Index;
import org.jpp.astnodes.ast.Interactive;
import org.jpp.astnodes.ast.keyword;
import org.jpp.astnodes.ast.ListComp;
import org.jpp.astnodes.ast.Lambda;
import org.jpp.astnodes.ast.Module;
import org.jpp.astnodes.ast.Name;
import org.jpp.astnodes.ast.Nonlocal;
import org.jpp.astnodes.ast.Num;
import org.jpp.astnodes.ast.operatorType;
import org.jpp.astnodes.ast.Pass;
import org.jpp.astnodes.ast.Raise;
import org.jpp.astnodes.ast.Return;
import org.jpp.astnodes.ast.Set;
import org.jpp.astnodes.ast.SetComp;
import org.jpp.astnodes.ast.Starred;
import org.jpp.astnodes.ast.Str;
import org.jpp.astnodes.ast.Subscript;
import org.jpp.astnodes.ast.Tuple;
import org.jpp.astnodes.ast.unaryopType;
import org.jpp.astnodes.ast.UnaryOp;
import org.jpp.astnodes.ast.withitem;
import org.jpp.astnodes.ast.Yield;
import org.jpp.astnodes.ast.YieldFrom;
import org.jpp.astnodes.base.excepthandler;
import org.jpp.astnodes.base.expr;
import org.jpp.astnodes.base.mod;
import org.jpp.astnodes.base.slice;
import org.jpp.astnodes.base.stmt;
import org.jpp.heart.PyObject;

import java.util.Collections;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;

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
 *
 *  Updated the original parser for Python 2.5 features. The parser has been
 *  altered to produce an AST - the AST work started from tne newcompiler
 *  grammar from Jim Baker.  The current parsing and compiling strategy looks
 *  like this:
 *
 *  Python source->Python.g->AST (org/python/parser/ast/*)->CodeCompiler(ASM)->.class
 *  May 2016 Modified by Isaiah Peng to match Python 3.5.1 syntax
 *  export CLASSPATH=$CLASSPATH:~/Documents/JARS/org.antlr-3.5.2-complete.jar
 *  java org.org.antlr.Tool Python.g
 */
@SuppressWarnings("all")
public class PythonParser extends Parser {
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
		"VBAREQUAL", "WHILE", "WITH", "WS", "YIELD"
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PythonParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PythonParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return PythonParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Python.g"; }


	    private ErrorHandler errorHandler;

	    private GrammarActions actions = new GrammarActions();

	    private String encoding;

	    //Use to switch between python2 and python3 semantics.
	    //true is python3, false is python2.
	    private boolean python3 = true;

	    private boolean printFunction = python3;
	    private boolean unicodeLiterals = python3;

	    public void setErrorHandler(ErrorHandler eh) {
	        this.errorHandler = eh;
	        actions.setErrorHandler(eh);
	    }

	    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
	        throws RecognitionException {

	        Object o = errorHandler.recoverFromMismatchedToken(this, input, ttype, follow);
	        if (o != null) {
	            return o;
	        }
	        return super.recoverFromMismatchedToken(input, ttype, follow);
	    }

	    public PythonParser(TokenStream input, String encoding) {
	        this(input);
	        this.encoding = encoding;
	    }

	    @Override
	    public void reportError(RecognitionException e) {
	      // Update syntax error count and output error.
	      super.reportError(e);
	      errorHandler.reportError(this, e);
	    }

	    @Override
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	        //Do nothing. We will handle error display elsewhere.
	    }


	public static class single_input_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "single_input"
	// Python.g:320:1: single_input : ( ( NEWLINE )* EOF | simple_stmt ( NEWLINE )* EOF | compound_stmt ( NEWLINE )+ EOF );
	public final PythonParser.single_input_return single_input() throws RecognitionException {
		PythonParser.single_input_return retval = new PythonParser.single_input_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NEWLINE1=null;
		Token EOF2=null;
		Token NEWLINE4=null;
		Token EOF5=null;
		Token NEWLINE7=null;
		Token EOF8=null;
		ParserRuleReturnScope simple_stmt3 =null;
		ParserRuleReturnScope compound_stmt6 =null;

		PythonTree NEWLINE1_tree=null;
		PythonTree EOF2_tree=null;
		PythonTree NEWLINE4_tree=null;
		PythonTree EOF5_tree=null;
		PythonTree NEWLINE7_tree=null;
		PythonTree EOF8_tree=null;


		    mod mtype = null;

		try {
			// Python.g:327:5: ( ( NEWLINE )* EOF | simple_stmt ( NEWLINE )* EOF | compound_stmt ( NEWLINE )+ EOF )
			int alt4=3;
			switch ( input.LA(1) ) {
			case EOF:
			case NEWLINE:
				{
				alt4=1;
				}
				break;
			case ASSERT:
			case AWAIT:
			case BREAK:
			case COMPLEX:
			case CONTINUE:
			case DELETE:
			case DOT:
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
			case NONLOCAL:
			case NOT:
			case PASS:
			case PLUS:
			case RAISE:
			case RETURN:
			case STAR:
			case STRING:
			case TILDE:
			case YIELD:
				{
				alt4=2;
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
				alt4=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// Python.g:327:7: ( NEWLINE )* EOF
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:327:7: ( NEWLINE )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==NEWLINE) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// Python.g:327:7: NEWLINE
							{
							NEWLINE1=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input118); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NEWLINE1_tree = (PythonTree)adaptor.create(NEWLINE1);
							adaptor.addChild(root_0, NEWLINE1_tree);
							}

							}
							break;

						default :
							break loop1;
						}
					}

					EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_single_input121); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EOF2_tree = (PythonTree)adaptor.create(EOF2);
					adaptor.addChild(root_0, EOF2_tree);
					}

					if ( state.backtracking==0 ) {
					        mtype = new Interactive((retval.start), new ArrayList<stmt>());
					      }
					}
					break;
				case 2 :
					// Python.g:331:7: simple_stmt ( NEWLINE )* EOF
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_simple_stmt_in_single_input137);
					simple_stmt3=simple_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_stmt3.getTree());

					// Python.g:331:19: ( NEWLINE )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==NEWLINE) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// Python.g:331:19: NEWLINE
							{
							NEWLINE4=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input139); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NEWLINE4_tree = (PythonTree)adaptor.create(NEWLINE4);
							adaptor.addChild(root_0, NEWLINE4_tree);
							}

							}
							break;

						default :
							break loop2;
						}
					}

					EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_single_input142); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EOF5_tree = (PythonTree)adaptor.create(EOF5);
					adaptor.addChild(root_0, EOF5_tree);
					}

					if ( state.backtracking==0 ) {
					        mtype = new Interactive((retval.start), actions.castStmts((simple_stmt3!=null?((PythonParser.simple_stmt_return)simple_stmt3).stypes:null)));
					      }
					}
					break;
				case 3 :
					// Python.g:335:7: compound_stmt ( NEWLINE )+ EOF
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_compound_stmt_in_single_input158);
					compound_stmt6=compound_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_stmt6.getTree());

					// Python.g:335:21: ( NEWLINE )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==NEWLINE) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Python.g:335:21: NEWLINE
							{
							NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input160); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NEWLINE7_tree = (PythonTree)adaptor.create(NEWLINE7);
							adaptor.addChild(root_0, NEWLINE7_tree);
							}

							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_single_input163); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EOF8_tree = (PythonTree)adaptor.create(EOF8);
					adaptor.addChild(root_0, EOF8_tree);
					}

					if ( state.backtracking==0 ) {
					        mtype = new Interactive((retval.start), actions.castStmts((compound_stmt6!=null?((PythonTree)compound_stmt6.getTree()):null)));
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = mtype;
			}
		}
		catch (RecognitionException re) {

			        reportError(re);
			        errorHandler.recover(this, input,re);
			        PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
			        retval.tree = new ErrorMod(badNode);
			    
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "single_input"


	public static class file_input_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "file_input"
	// Python.g:349:1: file_input : ( NEWLINE | stmt )* EOF ;
	public final PythonParser.file_input_return file_input() throws RecognitionException {
		PythonParser.file_input_return retval = new PythonParser.file_input_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NEWLINE9=null;
		Token EOF11=null;
		ParserRuleReturnScope stmt10 =null;

		PythonTree NEWLINE9_tree=null;
		PythonTree EOF11_tree=null;


		    mod mtype = null;
		    List stypes = new ArrayList();

		try {
			// Python.g:367:5: ( ( NEWLINE | stmt )* EOF )
			// Python.g:367:7: ( NEWLINE | stmt )* EOF
			{
			root_0 = (PythonTree)adaptor.nil();


			// Python.g:367:7: ( NEWLINE | stmt )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==NEWLINE) ) {
					alt5=1;
				}
				else if ( (LA5_0==ASSERT||(LA5_0 >= ASYNC && LA5_0 <= AT)||LA5_0==AWAIT||LA5_0==BREAK||LA5_0==CLASS||(LA5_0 >= COMPLEX && LA5_0 <= CONTINUE)||(LA5_0 >= DEF && LA5_0 <= DELETE)||LA5_0==DOT||(LA5_0 >= FLOAT && LA5_0 <= GLOBAL)||(LA5_0 >= IF && LA5_0 <= IMPORT)||LA5_0==INT||(LA5_0 >= LAMBDA && LA5_0 <= LCURLY)||(LA5_0 >= LONGINT && LA5_0 <= MINUS)||LA5_0==NAME||(LA5_0 >= NONLOCAL && LA5_0 <= NOT)||LA5_0==PASS||LA5_0==PLUS||LA5_0==RAISE||LA5_0==RETURN||LA5_0==STAR||(LA5_0 >= STRING && LA5_0 <= TILDE)||LA5_0==TRY||(LA5_0 >= WHILE && LA5_0 <= WITH)||LA5_0==YIELD) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// Python.g:367:8: NEWLINE
					{
					NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_file_input215); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEWLINE9_tree = (PythonTree)adaptor.create(NEWLINE9);
					adaptor.addChild(root_0, NEWLINE9_tree);
					}

					}
					break;
				case 2 :
					// Python.g:368:9: stmt
					{
					pushFollow(FOLLOW_stmt_in_file_input225);
					stmt10=stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt10.getTree());

					if ( state.backtracking==0 ) {
					          if ((stmt10!=null?((PythonParser.stmt_return)stmt10).stypes:null) != null) {
					              stypes.addAll((stmt10!=null?((PythonParser.stmt_return)stmt10).stypes:null));
					          }
					      }
					}
					break;

				default :
					break loop5;
				}
			}

			EOF11=(Token)match(input,EOF,FOLLOW_EOF_in_file_input244); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EOF11_tree = (PythonTree)adaptor.create(EOF11);
			adaptor.addChild(root_0, EOF11_tree);
			}

			if ( state.backtracking==0 ) {
			             mtype = new Module((retval.start), actions.castStmts(stypes));
			         }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (!stypes.isEmpty()) {
			        //The EOF token messes up the end offsets, so set them manually.
			        //XXX: this may no longer be true now that PythonTokenSource is
			        //     adjusting EOF offsets -- but needs testing before I remove
			        //     this.
			        PythonTree stop = (PythonTree)stypes.get(stypes.size() -1);
			        mtype.setCharStopIndex(stop.getCharStopIndex());
			        mtype.setTokenStopIndex(stop.getTokenStopIndex());
			    }

			    retval.tree = mtype;
			}
		}
		catch (RecognitionException re) {

			        reportError(re);
			        errorHandler.recover(this, input,re);
			        PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
			        retval.tree = new ErrorMod(badNode);
			    
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "file_input"


	public static class eval_input_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "eval_input"
	// Python.g:388:1: eval_input : ( LEADING_WS )? ( NEWLINE )* testlist[expr_contextType.Load] ( NEWLINE )* EOF ;
	public final PythonParser.eval_input_return eval_input() throws RecognitionException {
		PythonParser.eval_input_return retval = new PythonParser.eval_input_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LEADING_WS12=null;
		Token NEWLINE13=null;
		Token NEWLINE15=null;
		Token EOF16=null;
		ParserRuleReturnScope testlist14 =null;

		PythonTree LEADING_WS12_tree=null;
		PythonTree NEWLINE13_tree=null;
		PythonTree NEWLINE15_tree=null;
		PythonTree EOF16_tree=null;


		    mod mtype = null;

		try {
			// Python.g:395:5: ( ( LEADING_WS )? ( NEWLINE )* testlist[expr_contextType.Load] ( NEWLINE )* EOF )
			// Python.g:395:7: ( LEADING_WS )? ( NEWLINE )* testlist[expr_contextType.Load] ( NEWLINE )* EOF
			{
			root_0 = (PythonTree)adaptor.nil();


			// Python.g:395:7: ( LEADING_WS )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==LEADING_WS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// Python.g:395:7: LEADING_WS
					{
					LEADING_WS12=(Token)match(input,LEADING_WS,FOLLOW_LEADING_WS_in_eval_input298); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEADING_WS12_tree = (PythonTree)adaptor.create(LEADING_WS12);
					adaptor.addChild(root_0, LEADING_WS12_tree);
					}

					}
					break;

			}

			// Python.g:395:19: ( NEWLINE )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==NEWLINE) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Python.g:395:20: NEWLINE
					{
					NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_eval_input302); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEWLINE13_tree = (PythonTree)adaptor.create(NEWLINE13);
					adaptor.addChild(root_0, NEWLINE13_tree);
					}

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_testlist_in_eval_input306);
			testlist14=testlist(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist14.getTree());

			// Python.g:395:62: ( NEWLINE )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==NEWLINE) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Python.g:395:63: NEWLINE
					{
					NEWLINE15=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_eval_input310); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEWLINE15_tree = (PythonTree)adaptor.create(NEWLINE15);
					adaptor.addChild(root_0, NEWLINE15_tree);
					}

					}
					break;

				default :
					break loop8;
				}
			}

			EOF16=(Token)match(input,EOF,FOLLOW_EOF_in_eval_input314); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EOF16_tree = (PythonTree)adaptor.create(EOF16);
			adaptor.addChild(root_0, EOF16_tree);
			}

			if ( state.backtracking==0 ) {
			        mtype = new Expression((retval.start), actions.castExpr((testlist14!=null?((PythonTree)testlist14.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = mtype;
			}
		}
		catch (RecognitionException re) {

			        reportError(re);
			        errorHandler.recover(this, input,re);
			        PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
			        retval.tree = new ErrorMod(badNode);
			    
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "eval_input"


	public static class dotted_attr_return extends ParserRuleReturnScope {
		public expr etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "dotted_attr"
	// Python.g:410:1: dotted_attr returns [expr etype] : n1= NAME ( ( DOT n2+= NAME )+ |) ;
	public final PythonParser.dotted_attr_return dotted_attr() throws RecognitionException {
		PythonParser.dotted_attr_return retval = new PythonParser.dotted_attr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token n1=null;
		Token DOT17=null;
		Token n2=null;
		List<Object> list_n2=null;

		PythonTree n1_tree=null;
		PythonTree DOT17_tree=null;
		PythonTree n2_tree=null;

		try {
			// Python.g:412:5: (n1= NAME ( ( DOT n2+= NAME )+ |) )
			// Python.g:412:7: n1= NAME ( ( DOT n2+= NAME )+ |)
			{
			root_0 = (PythonTree)adaptor.nil();


			n1=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_attr366); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			n1_tree = (PythonTree)adaptor.create(n1);
			adaptor.addChild(root_0, n1_tree);
			}

			// Python.g:413:7: ( ( DOT n2+= NAME )+ |)
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==DOT) ) {
				alt10=1;
			}
			else if ( (LA10_0==LPAREN||LA10_0==NEWLINE) ) {
				alt10=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// Python.g:413:9: ( DOT n2+= NAME )+
					{
					// Python.g:413:9: ( DOT n2+= NAME )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==DOT) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// Python.g:413:10: DOT n2+= NAME
							{
							DOT17=(Token)match(input,DOT,FOLLOW_DOT_in_dotted_attr377); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DOT17_tree = (PythonTree)adaptor.create(DOT17);
							adaptor.addChild(root_0, DOT17_tree);
							}

							n2=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_attr381); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							n2_tree = (PythonTree)adaptor.create(n2);
							adaptor.addChild(root_0, n2_tree);
							}

							if (list_n2==null) list_n2=new ArrayList<Object>();
							list_n2.add(n2);
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

					if ( state.backtracking==0 ) {
					            retval.etype = actions.makeDottedAttr(n1, list_n2);
					        }
					}
					break;
				case 2 :
					// Python.g:418:9: 
					{
					if ( state.backtracking==0 ) {
					            retval.etype = actions.makeNameNode(n1);
					        }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dotted_attr"


	public static class name_or_print_return extends ParserRuleReturnScope {
		public Token tok;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "name_or_print"
	// Python.g:425:1: name_or_print returns [Token tok] : ( NAME | ASYNC | AWAIT );
	public final PythonParser.name_or_print_return name_or_print() throws RecognitionException {
		PythonParser.name_or_print_return retval = new PythonParser.name_or_print_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NAME18=null;
		Token ASYNC19=null;
		Token AWAIT20=null;

		PythonTree NAME18_tree=null;
		PythonTree ASYNC19_tree=null;
		PythonTree AWAIT20_tree=null;

		try {
			// Python.g:427:5: ( NAME | ASYNC | AWAIT )
			int alt11=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt11=1;
				}
				break;
			case ASYNC:
				{
				alt11=2;
				}
				break;
			case AWAIT:
				{
				alt11=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// Python.g:427:7: NAME
					{
					root_0 = (PythonTree)adaptor.nil();


					NAME18=(Token)match(input,NAME,FOLLOW_NAME_in_name_or_print445); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME18_tree = (PythonTree)adaptor.create(NAME18);
					adaptor.addChild(root_0, NAME18_tree);
					}

					if ( state.backtracking==0 ) {
					        retval.tok = (retval.start);
					    }
					}
					break;
				case 2 :
					// Python.g:430:7: ASYNC
					{
					root_0 = (PythonTree)adaptor.nil();


					ASYNC19=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_name_or_print455); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASYNC19_tree = (PythonTree)adaptor.create(ASYNC19);
					adaptor.addChild(root_0, ASYNC19_tree);
					}

					if ( state.backtracking==0 ) {
					        retval.tok = (retval.start);
					    }
					}
					break;
				case 3 :
					// Python.g:433:7: AWAIT
					{
					root_0 = (PythonTree)adaptor.nil();


					AWAIT20=(Token)match(input,AWAIT,FOLLOW_AWAIT_in_name_or_print465); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AWAIT20_tree = (PythonTree)adaptor.create(AWAIT20);
					adaptor.addChild(root_0, AWAIT20_tree);
					}

					if ( state.backtracking==0 ) {
					        retval.tok = (retval.start);
					    }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "name_or_print"


	public static class attr_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "attr"
	// Python.g:442:1: attr : ( NAME | AND | AS | ASSERT | ASYNC | AWAIT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NONLOCAL | NOT | OR | ORELSE | PASS | RAISE | RETURN | TRY | WHILE | WITH | YIELD );
	public final PythonParser.attr_return attr() throws RecognitionException {
		PythonParser.attr_return retval = new PythonParser.attr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token set21=null;

		PythonTree set21_tree=null;

		try {
			// Python.g:443:5: ( NAME | AND | AS | ASSERT | ASYNC | AWAIT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NONLOCAL | NOT | OR | ORELSE | PASS | RAISE | RETURN | TRY | WHILE | WITH | YIELD )
			// Python.g:
			{
			root_0 = (PythonTree)adaptor.nil();


			set21=input.LT(1);
			if ( input.LA(1)==AND||(input.LA(1) >= AS && input.LA(1) <= ASSERT)||input.LA(1)==ASYNC||input.LA(1)==AWAIT||input.LA(1)==BREAK||input.LA(1)==CLASS||input.LA(1)==CONTINUE||(input.LA(1) >= DEF && input.LA(1) <= DELETE)||input.LA(1)==ELIF||(input.LA(1) >= EXCEPT && input.LA(1) <= EXEC)||input.LA(1)==FINALLY||(input.LA(1) >= FOR && input.LA(1) <= GLOBAL)||(input.LA(1) >= IF && input.LA(1) <= IN)||(input.LA(1) >= IS && input.LA(1) <= LAMBDA)||input.LA(1)==NAME||(input.LA(1) >= NONLOCAL && input.LA(1) <= NOT)||(input.LA(1) >= OR && input.LA(1) <= PASS)||input.LA(1)==RAISE||input.LA(1)==RETURN||input.LA(1)==TRY||(input.LA(1) >= WHILE && input.LA(1) <= WITH)||input.LA(1)==YIELD ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (PythonTree)adaptor.create(set21));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "attr"


	public static class decorator_return extends ParserRuleReturnScope {
		public expr etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "decorator"
	// Python.g:480:1: decorator returns [expr etype] : AT dotted_attr ( LPAREN ( arglist |) RPAREN |) NEWLINE ;
	public final PythonParser.decorator_return decorator() throws RecognitionException {
		PythonParser.decorator_return retval = new PythonParser.decorator_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token AT22=null;
		Token LPAREN24=null;
		Token RPAREN26=null;
		Token NEWLINE27=null;
		ParserRuleReturnScope dotted_attr23 =null;
		ParserRuleReturnScope arglist25 =null;

		PythonTree AT22_tree=null;
		PythonTree LPAREN24_tree=null;
		PythonTree RPAREN26_tree=null;
		PythonTree NEWLINE27_tree=null;

		try {
			// Python.g:485:5: ( AT dotted_attr ( LPAREN ( arglist |) RPAREN |) NEWLINE )
			// Python.g:485:7: AT dotted_attr ( LPAREN ( arglist |) RPAREN |) NEWLINE
			{
			root_0 = (PythonTree)adaptor.nil();


			AT22=(Token)match(input,AT,FOLLOW_AT_in_decorator783); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			AT22_tree = (PythonTree)adaptor.create(AT22);
			adaptor.addChild(root_0, AT22_tree);
			}

			pushFollow(FOLLOW_dotted_attr_in_decorator785);
			dotted_attr23=dotted_attr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dotted_attr23.getTree());

			// Python.g:486:5: ( LPAREN ( arglist |) RPAREN |)
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==LPAREN) ) {
				alt13=1;
			}
			else if ( (LA13_0==NEWLINE) ) {
				alt13=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// Python.g:486:7: LPAREN ( arglist |) RPAREN
					{
					LPAREN24=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_decorator793); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LPAREN24_tree = (PythonTree)adaptor.create(LPAREN24);
					adaptor.addChild(root_0, LPAREN24_tree);
					}

					// Python.g:487:7: ( arglist |)
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==AWAIT||LA12_0==COMPLEX||LA12_0==DOT||LA12_0==DOUBLESTAR||LA12_0==FLOAT||LA12_0==INT||(LA12_0 >= LAMBDA && LA12_0 <= LCURLY)||(LA12_0 >= LONGINT && LA12_0 <= MINUS)||LA12_0==NAME||LA12_0==NOT||LA12_0==PLUS||LA12_0==STAR||(LA12_0 >= STRING && LA12_0 <= TILDE)) ) {
						alt12=1;
					}
					else if ( (LA12_0==RPAREN) ) {
						alt12=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}

					switch (alt12) {
						case 1 :
							// Python.g:487:9: arglist
							{
							pushFollow(FOLLOW_arglist_in_decorator803);
							arglist25=arglist();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, arglist25.getTree());

							if ( state.backtracking==0 ) {
							            retval.etype = actions.makeCall(LPAREN24, (dotted_attr23!=null?((PythonParser.dotted_attr_return)dotted_attr23).etype:null), (arglist25!=null?((PythonParser.arglist_return)arglist25).args:null), (arglist25!=null?((PythonParser.arglist_return)arglist25).keywords:null));
							        }
							}
							break;
						case 2 :
							// Python.g:492:9: 
							{
							if ( state.backtracking==0 ) {
							            retval.etype = actions.makeCall(LPAREN24, (dotted_attr23!=null?((PythonParser.dotted_attr_return)dotted_attr23).etype:null));
							        }
							}
							break;

					}

					RPAREN26=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_decorator847); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RPAREN26_tree = (PythonTree)adaptor.create(RPAREN26);
					adaptor.addChild(root_0, RPAREN26_tree);
					}

					}
					break;
				case 2 :
					// Python.g:498:7: 
					{
					if ( state.backtracking==0 ) {
					          retval.etype = (dotted_attr23!=null?((PythonParser.dotted_attr_return)dotted_attr23).etype:null);
					      }
					}
					break;

			}

			NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_decorator869); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NEWLINE27_tree = (PythonTree)adaptor.create(NEWLINE27);
			adaptor.addChild(root_0, NEWLINE27_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decorator"


	public static class decorators_return extends ParserRuleReturnScope {
		public List etypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "decorators"
	// Python.g:505:1: decorators returns [List etypes] : (d+= decorator )+ ;
	public final PythonParser.decorators_return decorators() throws RecognitionException {
		PythonParser.decorators_return retval = new PythonParser.decorators_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		List<Object> list_d=null;
		RuleReturnScope d = null;

		try {
			// Python.g:507:5: ( (d+= decorator )+ )
			// Python.g:507:7: (d+= decorator )+
			{
			root_0 = (PythonTree)adaptor.nil();


			// Python.g:507:8: (d+= decorator )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==AT) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// Python.g:507:8: d+= decorator
					{
					pushFollow(FOLLOW_decorator_in_decorators897);
					d=decorator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

					if (list_d==null) list_d=new ArrayList<Object>();
					list_d.add(d.getTree());
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			if ( state.backtracking==0 ) {
			          retval.etypes = list_d;
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decorators"


	public static class async_funcdef_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "async_funcdef"
	// Python.g:514:1: async_funcdef : ASYNC funcdef ;
	public final PythonParser.async_funcdef_return async_funcdef() throws RecognitionException {
		PythonParser.async_funcdef_return retval = new PythonParser.async_funcdef_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ASYNC28=null;
		ParserRuleReturnScope funcdef29 =null;

		PythonTree ASYNC28_tree=null;


		    stmt stype = null;

		try {
			// Python.g:522:5: ( ASYNC funcdef )
			// Python.g:522:7: ASYNC funcdef
			{
			root_0 = (PythonTree)adaptor.nil();


			ASYNC28=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_async_funcdef935); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASYNC28_tree = (PythonTree)adaptor.create(ASYNC28);
			adaptor.addChild(root_0, ASYNC28_tree);
			}

			pushFollow(FOLLOW_funcdef_in_async_funcdef937);
			funcdef29=funcdef();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, funcdef29.getTree());

			if ( state.backtracking==0 ) {
			        stype = actions.makeAsyncFuncdef(ASYNC28, (funcdef29!=null?((PythonTree)funcdef29.getTree()):null));
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "async_funcdef"


	public static class decorated_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "decorated"
	// Python.g:529:1: decorated : decorators ( classdef | funcdef | async_funcdef ) ;
	public final PythonParser.decorated_return decorated() throws RecognitionException {
		PythonParser.decorated_return retval = new PythonParser.decorated_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope decorators30 =null;
		ParserRuleReturnScope classdef31 =null;
		ParserRuleReturnScope funcdef32 =null;
		ParserRuleReturnScope async_funcdef33 =null;



		    stmt stype = null;

		try {
			// Python.g:537:5: ( decorators ( classdef | funcdef | async_funcdef ) )
			// Python.g:537:7: decorators ( classdef | funcdef | async_funcdef )
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_decorators_in_decorated972);
			decorators30=decorators();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, decorators30.getTree());

			// Python.g:538:9: ( classdef | funcdef | async_funcdef )
			int alt15=3;
			switch ( input.LA(1) ) {
			case CLASS:
				{
				alt15=1;
				}
				break;
			case DEF:
				{
				alt15=2;
				}
				break;
			case ASYNC:
				{
				alt15=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// Python.g:538:11: classdef
					{
					pushFollow(FOLLOW_classdef_in_decorated984);
					classdef31=classdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, classdef31.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.castStmt((classdef31!=null?((PythonTree)classdef31.getTree()):null));
					            ((ClassDef) stype).setDecorator_list(actions.castExprs((decorators30!=null?((PythonParser.decorators_return)decorators30).etypes:null)));
					        }
					}
					break;
				case 2 :
					// Python.g:543:11: funcdef
					{
					pushFollow(FOLLOW_funcdef_in_decorated1006);
					funcdef32=funcdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, funcdef32.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.castStmt((funcdef32!=null?((PythonTree)funcdef32.getTree()):null));
					            ((FunctionDef) stype).setDecorator_list(actions.castExprs((decorators30!=null?((PythonParser.decorators_return)decorators30).etypes:null)));
					        }
					}
					break;
				case 3 :
					// Python.g:548:11: async_funcdef
					{
					pushFollow(FOLLOW_async_funcdef_in_decorated1028);
					async_funcdef33=async_funcdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, async_funcdef33.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.castStmt((async_funcdef33!=null?((PythonTree)async_funcdef33.getTree()):null));
					            ((AsyncFunctionDef) stype).setDecorator_list(actions.castExprs((decorators30!=null?((PythonParser.decorators_return)decorators30).etypes:null)));
					        }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decorated"


	public static class funcdef_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "funcdef"
	// Python.g:557:1: funcdef : DEF name_or_print parameters ( ARROW test[expr_contextType.Load] )? COLON suite[false] ;
	public final PythonParser.funcdef_return funcdef() throws RecognitionException {
		PythonParser.funcdef_return retval = new PythonParser.funcdef_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token DEF34=null;
		Token ARROW37=null;
		Token COLON39=null;
		ParserRuleReturnScope name_or_print35 =null;
		ParserRuleReturnScope parameters36 =null;
		ParserRuleReturnScope test38 =null;
		ParserRuleReturnScope suite40 =null;

		PythonTree DEF34_tree=null;
		PythonTree ARROW37_tree=null;
		PythonTree COLON39_tree=null;


		    stmt stype = null;

		try {
			// Python.g:565:5: ( DEF name_or_print parameters ( ARROW test[expr_contextType.Load] )? COLON suite[false] )
			// Python.g:565:7: DEF name_or_print parameters ( ARROW test[expr_contextType.Load] )? COLON suite[false]
			{
			root_0 = (PythonTree)adaptor.nil();


			DEF34=(Token)match(input,DEF,FOLLOW_DEF_in_funcdef1077); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DEF34_tree = (PythonTree)adaptor.create(DEF34);
			adaptor.addChild(root_0, DEF34_tree);
			}

			pushFollow(FOLLOW_name_or_print_in_funcdef1079);
			name_or_print35=name_or_print();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, name_or_print35.getTree());

			pushFollow(FOLLOW_parameters_in_funcdef1081);
			parameters36=parameters();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, parameters36.getTree());

			// Python.g:565:36: ( ARROW test[expr_contextType.Load] )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==ARROW) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// Python.g:565:37: ARROW test[expr_contextType.Load]
					{
					ARROW37=(Token)match(input,ARROW,FOLLOW_ARROW_in_funcdef1084); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ARROW37_tree = (PythonTree)adaptor.create(ARROW37);
					adaptor.addChild(root_0, ARROW37_tree);
					}

					pushFollow(FOLLOW_test_in_funcdef1086);
					test38=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test38.getTree());

					}
					break;

			}

			COLON39=(Token)match(input,COLON,FOLLOW_COLON_in_funcdef1091); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON39_tree = (PythonTree)adaptor.create(COLON39);
			adaptor.addChild(root_0, COLON39_tree);
			}

			pushFollow(FOLLOW_suite_in_funcdef1093);
			suite40=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, suite40.getTree());

			if ( state.backtracking==0 ) {
			        stype = actions.makeFuncdef(DEF34, (name_or_print35!=null?(name_or_print35.start):null), (parameters36!=null?((PythonParser.parameters_return)parameters36).args:null), (suite40!=null?((PythonParser.suite_return)suite40).stypes:null), actions.castExpr((test38!=null?((PythonTree)test38.getTree()):null)));
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "funcdef"


	public static class parameters_return extends ParserRuleReturnScope {
		public arguments args;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "parameters"
	// Python.g:572:1: parameters returns [arguments args] : LPAREN ( typedargslist |) RPAREN ;
	public final PythonParser.parameters_return parameters() throws RecognitionException {
		PythonParser.parameters_return retval = new PythonParser.parameters_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LPAREN41=null;
		Token RPAREN43=null;
		ParserRuleReturnScope typedargslist42 =null;

		PythonTree LPAREN41_tree=null;
		PythonTree RPAREN43_tree=null;

		try {
			// Python.g:574:5: ( LPAREN ( typedargslist |) RPAREN )
			// Python.g:574:7: LPAREN ( typedargslist |) RPAREN
			{
			root_0 = (PythonTree)adaptor.nil();


			LPAREN41=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_parameters1126); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN41_tree = (PythonTree)adaptor.create(LPAREN41);
			adaptor.addChild(root_0, LPAREN41_tree);
			}

			// Python.g:575:7: ( typedargslist |)
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==ASYNC||LA17_0==AWAIT||LA17_0==DOUBLESTAR||LA17_0==NAME||LA17_0==STAR) ) {
				alt17=1;
			}
			else if ( (LA17_0==RPAREN) ) {
				alt17=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// Python.g:575:8: typedargslist
					{
					pushFollow(FOLLOW_typedargslist_in_parameters1135);
					typedargslist42=typedargslist();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedargslist42.getTree());

					if ( state.backtracking==0 ) {
					              retval.args = (typedargslist42!=null?((PythonParser.typedargslist_return)typedargslist42).args:null);
					        }
					}
					break;
				case 2 :
					// Python.g:580:9: 
					{
					if ( state.backtracking==0 ) {
					            retval.args = new arguments((retval.start), new ArrayList<arg>(), (arg)null,
					            new ArrayList<arg>(), new ArrayList<expr>(), (arg) null, new ArrayList<expr>());
					        }
					}
					break;

			}

			RPAREN43=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_parameters1179); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN43_tree = (PythonTree)adaptor.create(RPAREN43);
			adaptor.addChild(root_0, RPAREN43_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parameters"


	public static class tdefparameter_return extends ParserRuleReturnScope {
		public arg etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "tdefparameter"
	// Python.g:589:1: tdefparameter[List defaults] returns [arg etype] : tfpdef ( ASSIGN test[expr_contextType.Load] )? ;
	public final PythonParser.tdefparameter_return tdefparameter(List defaults) throws RecognitionException {
		PythonParser.tdefparameter_return retval = new PythonParser.tdefparameter_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ASSIGN45=null;
		ParserRuleReturnScope tfpdef44 =null;
		ParserRuleReturnScope test46 =null;

		PythonTree ASSIGN45_tree=null;

		try {
			// Python.g:594:5: ( tfpdef ( ASSIGN test[expr_contextType.Load] )? )
			// Python.g:594:7: tfpdef ( ASSIGN test[expr_contextType.Load] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_tfpdef_in_tdefparameter1212);
			tfpdef44=tfpdef();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tfpdef44.getTree());

			// Python.g:594:14: ( ASSIGN test[expr_contextType.Load] )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==ASSIGN) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// Python.g:594:15: ASSIGN test[expr_contextType.Load]
					{
					ASSIGN45=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_tdefparameter1215); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN45_tree = (PythonTree)adaptor.create(ASSIGN45);
					adaptor.addChild(root_0, ASSIGN45_tree);
					}

					pushFollow(FOLLOW_test_in_tdefparameter1217);
					test46=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test46.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          retval.etype = actions.castArg((tfpdef44!=null?((PythonTree)tfpdef44.getTree()):null));
			          if (ASSIGN45 != null) {
			              defaults.add((test46!=null?((PythonTree)test46.getTree()):null));
			          } else {
			              defaults.add(null);
			          }
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tdefparameter"


	public static class vdefparameter_return extends ParserRuleReturnScope {
		public expr etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "vdefparameter"
	// Python.g:606:1: vdefparameter[List defaults] returns [expr etype] : vfpdef[expr_contextType.Param] ( ASSIGN test[expr_contextType.Load] )? ;
	public final PythonParser.vdefparameter_return vdefparameter(List defaults) throws RecognitionException {
		PythonParser.vdefparameter_return retval = new PythonParser.vdefparameter_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ASSIGN48=null;
		ParserRuleReturnScope vfpdef47 =null;
		ParserRuleReturnScope test49 =null;

		PythonTree ASSIGN48_tree=null;

		try {
			// Python.g:611:5: ( vfpdef[expr_contextType.Param] ( ASSIGN test[expr_contextType.Load] )? )
			// Python.g:611:7: vfpdef[expr_contextType.Param] ( ASSIGN test[expr_contextType.Load] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_vfpdef_in_vdefparameter1261);
			vfpdef47=vfpdef(expr_contextType.Param);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, vfpdef47.getTree());

			// Python.g:611:38: ( ASSIGN test[expr_contextType.Load] )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==ASSIGN) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// Python.g:611:39: ASSIGN test[expr_contextType.Load]
					{
					ASSIGN48=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_vdefparameter1265); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN48_tree = (PythonTree)adaptor.create(ASSIGN48);
					adaptor.addChild(root_0, ASSIGN48_tree);
					}

					pushFollow(FOLLOW_test_in_vdefparameter1267);
					test49=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test49.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          retval.etype = actions.castExpr((vfpdef47!=null?((PythonTree)vfpdef47.getTree()):null));
			          if (ASSIGN48 != null) {
			              defaults.add((test49!=null?((PythonTree)test49.getTree()):null));
			          } else {
			              defaults.add(null);
			          }
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vdefparameter"


	public static class typedargslist_return extends ParserRuleReturnScope {
		public arguments args;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "typedargslist"
	// Python.g:627:1: typedargslist returns [arguments args] : (d+= tdefparameter[defaults] ( options {greedy=true; } : COMMA d+= tdefparameter[defaults] )* ( COMMA ( STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )? )? | STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef );
	public final PythonParser.typedargslist_return typedargslist() throws RecognitionException {
		PythonParser.typedargslist_return retval = new PythonParser.typedargslist_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA50=null;
		Token COMMA51=null;
		Token STAR52=null;
		Token COMMA53=null;
		Token COMMA54=null;
		Token COMMA55=null;
		Token DOUBLESTAR56=null;
		Token DOUBLESTAR57=null;
		Token STAR58=null;
		Token COMMA59=null;
		Token COMMA60=null;
		Token COMMA61=null;
		Token DOUBLESTAR62=null;
		Token DOUBLESTAR63=null;
		List<Object> list_d=null;
		List<Object> list_kw=null;
		ParserRuleReturnScope vararg =null;
		ParserRuleReturnScope kwarg =null;
		RuleReturnScope d = null;
		RuleReturnScope kw = null;
		PythonTree COMMA50_tree=null;
		PythonTree COMMA51_tree=null;
		PythonTree STAR52_tree=null;
		PythonTree COMMA53_tree=null;
		PythonTree COMMA54_tree=null;
		PythonTree COMMA55_tree=null;
		PythonTree DOUBLESTAR56_tree=null;
		PythonTree DOUBLESTAR57_tree=null;
		PythonTree STAR58_tree=null;
		PythonTree COMMA59_tree=null;
		PythonTree COMMA60_tree=null;
		PythonTree COMMA61_tree=null;
		PythonTree DOUBLESTAR62_tree=null;
		PythonTree DOUBLESTAR63_tree=null;


		    List defaults = new ArrayList();
		    List kw_defaults = new ArrayList();

		try {
			// Python.g:633:5: (d+= tdefparameter[defaults] ( options {greedy=true; } : COMMA d+= tdefparameter[defaults] )* ( COMMA ( STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )? )? | STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )
			int alt31=3;
			switch ( input.LA(1) ) {
			case ASYNC:
			case AWAIT:
			case NAME:
				{
				alt31=1;
				}
				break;
			case STAR:
				{
				alt31=2;
				}
				break;
			case DOUBLESTAR:
				{
				alt31=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// Python.g:633:7: d+= tdefparameter[defaults] ( options {greedy=true; } : COMMA d+= tdefparameter[defaults] )* ( COMMA ( STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )? )?
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_tdefparameter_in_typedargslist1315);
					d=tdefparameter(defaults);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

					if (list_d==null) list_d=new ArrayList<Object>();
					list_d.add(d.getTree());
					// Python.g:633:34: ( options {greedy=true; } : COMMA d+= tdefparameter[defaults] )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==COMMA) ) {
							int LA20_1 = input.LA(2);
							if ( (LA20_1==ASYNC||LA20_1==AWAIT||LA20_1==NAME) ) {
								alt20=1;
							}

						}

						switch (alt20) {
						case 1 :
							// Python.g:633:58: COMMA d+= tdefparameter[defaults]
							{
							COMMA50=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1326); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA50_tree = (PythonTree)adaptor.create(COMMA50);
							adaptor.addChild(root_0, COMMA50_tree);
							}

							pushFollow(FOLLOW_tdefparameter_in_typedargslist1330);
							d=tdefparameter(defaults);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

							if (list_d==null) list_d=new ArrayList<Object>();
							list_d.add(d.getTree());
							}
							break;

						default :
							break loop20;
						}
					}

					// Python.g:634:7: ( COMMA ( STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )? )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==COMMA) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// Python.g:634:8: COMMA ( STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )?
							{
							COMMA51=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1342); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA51_tree = (PythonTree)adaptor.create(COMMA51);
							adaptor.addChild(root_0, COMMA51_tree);
							}

							// Python.g:635:11: ( STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )? | DOUBLESTAR kwarg= tfpdef )?
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
									// Python.g:635:12: STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )?
									{
									STAR52=(Token)match(input,STAR,FOLLOW_STAR_in_typedargslist1355); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									STAR52_tree = (PythonTree)adaptor.create(STAR52);
									adaptor.addChild(root_0, STAR52_tree);
									}

									// Python.g:635:17: (vararg= tfpdef )?
									int alt21=2;
									int LA21_0 = input.LA(1);
									if ( (LA21_0==ASYNC||LA21_0==AWAIT||LA21_0==NAME) ) {
										alt21=1;
									}
									switch (alt21) {
										case 1 :
											// Python.g:635:18: vararg= tfpdef
											{
											pushFollow(FOLLOW_tfpdef_in_typedargslist1360);
											vararg=tfpdef();
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, vararg.getTree());

											}
											break;

									}

									// Python.g:635:34: ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )?
									int alt23=2;
									int LA23_0 = input.LA(1);
									if ( (LA23_0==COMMA) ) {
										int LA23_1 = input.LA(2);
										if ( (LA23_1==ASYNC||LA23_1==AWAIT||LA23_1==NAME) ) {
											alt23=1;
										}
									}
									switch (alt23) {
										case 1 :
											// Python.g:635:35: COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )*
											{
											COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1365); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											COMMA53_tree = (PythonTree)adaptor.create(COMMA53);
											adaptor.addChild(root_0, COMMA53_tree);
											}

											pushFollow(FOLLOW_tdefparameter_in_typedargslist1369);
											kw=tdefparameter(kw_defaults);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

											if (list_kw==null) list_kw=new ArrayList<Object>();
											list_kw.add(kw.getTree());
											// Python.g:635:72: ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )*
											loop22:
											while (true) {
												int alt22=2;
												int LA22_0 = input.LA(1);
												if ( (LA22_0==COMMA) ) {
													int LA22_1 = input.LA(2);
													if ( (LA22_1==ASYNC||LA22_1==AWAIT||LA22_1==NAME) ) {
														alt22=1;
													}

												}

												switch (alt22) {
												case 1 :
													// Python.g:635:96: COMMA kw+= tdefparameter[kw_defaults]
													{
													COMMA54=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1380); if (state.failed) return retval;
													if ( state.backtracking==0 ) {
													COMMA54_tree = (PythonTree)adaptor.create(COMMA54);
													adaptor.addChild(root_0, COMMA54_tree);
													}

													pushFollow(FOLLOW_tdefparameter_in_typedargslist1384);
													kw=tdefparameter(kw_defaults);
													state._fsp--;
													if (state.failed) return retval;
													if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

													if (list_kw==null) list_kw=new ArrayList<Object>();
													list_kw.add(kw.getTree());
													}
													break;

												default :
													break loop22;
												}
											}

											}
											break;

									}

									// Python.g:635:137: ( COMMA DOUBLESTAR kwarg= tfpdef )?
									int alt24=2;
									int LA24_0 = input.LA(1);
									if ( (LA24_0==COMMA) ) {
										alt24=1;
									}
									switch (alt24) {
										case 1 :
											// Python.g:635:138: COMMA DOUBLESTAR kwarg= tfpdef
											{
											COMMA55=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1392); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											COMMA55_tree = (PythonTree)adaptor.create(COMMA55);
											adaptor.addChild(root_0, COMMA55_tree);
											}

											DOUBLESTAR56=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist1394); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											DOUBLESTAR56_tree = (PythonTree)adaptor.create(DOUBLESTAR56);
											adaptor.addChild(root_0, DOUBLESTAR56_tree);
											}

											pushFollow(FOLLOW_tfpdef_in_typedargslist1398);
											kwarg=tfpdef();
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

											}
											break;

									}

									}
									break;
								case 2 :
									// Python.g:636:13: DOUBLESTAR kwarg= tfpdef
									{
									DOUBLESTAR57=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist1414); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									DOUBLESTAR57_tree = (PythonTree)adaptor.create(DOUBLESTAR57);
									adaptor.addChild(root_0, DOUBLESTAR57_tree);
									}

									pushFollow(FOLLOW_tfpdef_in_typedargslist1418);
									kwarg=tfpdef();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

									}
									break;

							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          //if (STAR52_tree != null && (vararg!=null?((PythonTree)vararg.getTree()):null) == null && list_kw.isEmpty()) {
					          //    actions.errorNoNamedArguments(STAR52_tree);
					          //}

					          retval.args = new arguments((retval.start), actions.castArgs(list_d),
					          actions.castArg((vararg!=null?((PythonTree)vararg.getTree()):null)), actions.castArgs(list_kw),
					          kw_defaults, actions.castArg((kwarg!=null?((PythonTree)kwarg.getTree()):null)), defaults);
					      }
					}
					break;
				case 2 :
					// Python.g:648:7: STAR (vararg= tfpdef )? ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= tfpdef )?
					{
					root_0 = (PythonTree)adaptor.nil();


					STAR58=(Token)match(input,STAR,FOLLOW_STAR_in_typedargslist1456); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR58_tree = (PythonTree)adaptor.create(STAR58);
					adaptor.addChild(root_0, STAR58_tree);
					}

					// Python.g:648:12: (vararg= tfpdef )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==ASYNC||LA27_0==AWAIT||LA27_0==NAME) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// Python.g:648:13: vararg= tfpdef
							{
							pushFollow(FOLLOW_tfpdef_in_typedargslist1461);
							vararg=tfpdef();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, vararg.getTree());

							}
							break;

					}

					// Python.g:648:29: ( COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )* )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==COMMA) ) {
						int LA29_1 = input.LA(2);
						if ( (LA29_1==ASYNC||LA29_1==AWAIT||LA29_1==NAME) ) {
							alt29=1;
						}
					}
					switch (alt29) {
						case 1 :
							// Python.g:648:30: COMMA kw+= tdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )*
							{
							COMMA59=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1466); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA59_tree = (PythonTree)adaptor.create(COMMA59);
							adaptor.addChild(root_0, COMMA59_tree);
							}

							pushFollow(FOLLOW_tdefparameter_in_typedargslist1470);
							kw=tdefparameter(kw_defaults);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

							if (list_kw==null) list_kw=new ArrayList<Object>();
							list_kw.add(kw.getTree());
							// Python.g:648:67: ( options {greedy=true; } : COMMA kw+= tdefparameter[kw_defaults] )*
							loop28:
							while (true) {
								int alt28=2;
								int LA28_0 = input.LA(1);
								if ( (LA28_0==COMMA) ) {
									int LA28_1 = input.LA(2);
									if ( (LA28_1==ASYNC||LA28_1==AWAIT||LA28_1==NAME) ) {
										alt28=1;
									}

								}

								switch (alt28) {
								case 1 :
									// Python.g:648:91: COMMA kw+= tdefparameter[kw_defaults]
									{
									COMMA60=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1481); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									COMMA60_tree = (PythonTree)adaptor.create(COMMA60);
									adaptor.addChild(root_0, COMMA60_tree);
									}

									pushFollow(FOLLOW_tdefparameter_in_typedargslist1485);
									kw=tdefparameter(kw_defaults);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

									if (list_kw==null) list_kw=new ArrayList<Object>();
									list_kw.add(kw.getTree());
									}
									break;

								default :
									break loop28;
								}
							}

							}
							break;

					}

					// Python.g:648:132: ( COMMA DOUBLESTAR kwarg= tfpdef )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==COMMA) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// Python.g:648:133: COMMA DOUBLESTAR kwarg= tfpdef
							{
							COMMA61=(Token)match(input,COMMA,FOLLOW_COMMA_in_typedargslist1493); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA61_tree = (PythonTree)adaptor.create(COMMA61);
							adaptor.addChild(root_0, COMMA61_tree);
							}

							DOUBLESTAR62=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist1495); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DOUBLESTAR62_tree = (PythonTree)adaptor.create(DOUBLESTAR62);
							adaptor.addChild(root_0, DOUBLESTAR62_tree);
							}

							pushFollow(FOLLOW_tfpdef_in_typedargslist1499);
							kwarg=tfpdef();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          retval.args = new arguments((retval.start), actions.castArgs(list_d),
					          actions.castArg((vararg!=null?((PythonTree)vararg.getTree()):null)), actions.castArgs(list_kw),
					          kw_defaults, actions.castArg((kwarg!=null?((PythonTree)kwarg.getTree()):null)), defaults);
					      }
					}
					break;
				case 3 :
					// Python.g:654:7: DOUBLESTAR kwarg= tfpdef
					{
					root_0 = (PythonTree)adaptor.nil();


					DOUBLESTAR63=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_typedargslist1517); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLESTAR63_tree = (PythonTree)adaptor.create(DOUBLESTAR63);
					adaptor.addChild(root_0, DOUBLESTAR63_tree);
					}

					pushFollow(FOLLOW_tfpdef_in_typedargslist1521);
					kwarg=tfpdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

					if ( state.backtracking==0 ) {
					          retval.args = new arguments((retval.start), actions.castArgs(list_d), null,
					          actions.castArgs(list_kw), kw_defaults, actions.castArg((kwarg!=null?((PythonTree)kwarg.getTree()):null)), defaults);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "typedargslist"


	public static class tfpdef_return extends ParserRuleReturnScope {
		public arg etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "tfpdef"
	// Python.g:662:1: tfpdef returns [arg etype] : name_or_print ( COLON test[expr_contextType.Load] )? ;
	public final PythonParser.tfpdef_return tfpdef() throws RecognitionException {
		PythonParser.tfpdef_return retval = new PythonParser.tfpdef_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COLON65=null;
		ParserRuleReturnScope name_or_print64 =null;
		ParserRuleReturnScope test66 =null;

		PythonTree COLON65_tree=null;


		  arg etype = null;

		try {
			// Python.g:671:5: ( name_or_print ( COLON test[expr_contextType.Load] )? )
			// Python.g:671:7: name_or_print ( COLON test[expr_contextType.Load] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_name_or_print_in_tfpdef1561);
			name_or_print64=name_or_print();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, name_or_print64.getTree());

			// Python.g:671:21: ( COLON test[expr_contextType.Load] )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==COLON) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// Python.g:671:22: COLON test[expr_contextType.Load]
					{
					COLON65=(Token)match(input,COLON,FOLLOW_COLON_in_tfpdef1564); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COLON65_tree = (PythonTree)adaptor.create(COLON65);
					adaptor.addChild(root_0, COLON65_tree);
					}

					pushFollow(FOLLOW_test_in_tfpdef1566);
					test66=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test66.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          retval.etype = new arg((name_or_print64!=null?((PythonTree)name_or_print64.getTree()):null), (name_or_print64!=null?input.toString(name_or_print64.start,name_or_print64.stop):null), actions.castExpr((test66!=null?((PythonTree)test66.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (retval.etype != null) {
			        retval.tree = retval.etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tfpdef"


	public static class varargslist_return extends ParserRuleReturnScope {
		public arguments args;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "varargslist"
	// Python.g:683:1: varargslist returns [arguments args] : (d+= vdefparameter[defaults] ( options {greedy=true; } : COMMA d+= vdefparameter[defaults] )* ( COMMA ( STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? )? | STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] );
	public final PythonParser.varargslist_return varargslist() throws RecognitionException {
		PythonParser.varargslist_return retval = new PythonParser.varargslist_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA67=null;
		Token COMMA68=null;
		Token STAR69=null;
		Token COMMA70=null;
		Token COMMA71=null;
		Token COMMA72=null;
		Token DOUBLESTAR73=null;
		Token DOUBLESTAR74=null;
		Token STAR75=null;
		Token COMMA76=null;
		Token COMMA77=null;
		Token COMMA78=null;
		Token DOUBLESTAR79=null;
		Token DOUBLESTAR80=null;
		List<Object> list_d=null;
		List<Object> list_kw=null;
		ParserRuleReturnScope vararg =null;
		ParserRuleReturnScope kwarg =null;
		RuleReturnScope d = null;
		RuleReturnScope kw = null;
		PythonTree COMMA67_tree=null;
		PythonTree COMMA68_tree=null;
		PythonTree STAR69_tree=null;
		PythonTree COMMA70_tree=null;
		PythonTree COMMA71_tree=null;
		PythonTree COMMA72_tree=null;
		PythonTree DOUBLESTAR73_tree=null;
		PythonTree DOUBLESTAR74_tree=null;
		PythonTree STAR75_tree=null;
		PythonTree COMMA76_tree=null;
		PythonTree COMMA77_tree=null;
		PythonTree COMMA78_tree=null;
		PythonTree DOUBLESTAR79_tree=null;
		PythonTree DOUBLESTAR80_tree=null;


		    List defaults = new ArrayList();
		    List kw_defaults = new ArrayList();

		try {
			// Python.g:689:5: (d+= vdefparameter[defaults] ( options {greedy=true; } : COMMA d+= vdefparameter[defaults] )* ( COMMA ( STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? )? | STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )
			int alt44=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt44=1;
				}
				break;
			case STAR:
				{
				alt44=2;
				}
				break;
			case DOUBLESTAR:
				{
				alt44=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// Python.g:689:7: d+= vdefparameter[defaults] ( options {greedy=true; } : COMMA d+= vdefparameter[defaults] )* ( COMMA ( STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? )?
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_vdefparameter_in_varargslist1615);
					d=vdefparameter(defaults);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

					if (list_d==null) list_d=new ArrayList<Object>();
					list_d.add(d.getTree());
					// Python.g:689:34: ( options {greedy=true; } : COMMA d+= vdefparameter[defaults] )*
					loop33:
					while (true) {
						int alt33=2;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==COMMA) ) {
							int LA33_1 = input.LA(2);
							if ( (LA33_1==NAME) ) {
								alt33=1;
							}

						}

						switch (alt33) {
						case 1 :
							// Python.g:689:58: COMMA d+= vdefparameter[defaults]
							{
							COMMA67=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1626); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA67_tree = (PythonTree)adaptor.create(COMMA67);
							adaptor.addChild(root_0, COMMA67_tree);
							}

							pushFollow(FOLLOW_vdefparameter_in_varargslist1630);
							d=vdefparameter(defaults);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

							if (list_d==null) list_d=new ArrayList<Object>();
							list_d.add(d.getTree());
							}
							break;

						default :
							break loop33;
						}
					}

					// Python.g:690:7: ( COMMA ( STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? )?
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==COMMA) ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// Python.g:690:8: COMMA ( STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )?
							{
							COMMA68=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1642); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA68_tree = (PythonTree)adaptor.create(COMMA68);
							adaptor.addChild(root_0, COMMA68_tree);
							}

							// Python.g:691:11: ( STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )? | DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )?
							int alt38=3;
							int LA38_0 = input.LA(1);
							if ( (LA38_0==STAR) ) {
								alt38=1;
							}
							else if ( (LA38_0==DOUBLESTAR) ) {
								alt38=2;
							}
							switch (alt38) {
								case 1 :
									// Python.g:691:12: STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )?
									{
									STAR69=(Token)match(input,STAR,FOLLOW_STAR_in_varargslist1655); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									STAR69_tree = (PythonTree)adaptor.create(STAR69);
									adaptor.addChild(root_0, STAR69_tree);
									}

									// Python.g:691:17: (vararg= vfpdef[expr_contextType.Param] )?
									int alt34=2;
									int LA34_0 = input.LA(1);
									if ( (LA34_0==NAME) ) {
										alt34=1;
									}
									switch (alt34) {
										case 1 :
											// Python.g:691:18: vararg= vfpdef[expr_contextType.Param]
											{
											pushFollow(FOLLOW_vfpdef_in_varargslist1660);
											vararg=vfpdef(expr_contextType.Param);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, vararg.getTree());

											}
											break;

									}

									// Python.g:691:58: ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )?
									int alt36=2;
									int LA36_0 = input.LA(1);
									if ( (LA36_0==COMMA) ) {
										int LA36_1 = input.LA(2);
										if ( (LA36_1==NAME) ) {
											alt36=1;
										}
									}
									switch (alt36) {
										case 1 :
											// Python.g:691:59: COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )*
											{
											COMMA70=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1666); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											COMMA70_tree = (PythonTree)adaptor.create(COMMA70);
											adaptor.addChild(root_0, COMMA70_tree);
											}

											pushFollow(FOLLOW_vdefparameter_in_varargslist1670);
											kw=vdefparameter(kw_defaults);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

											if (list_kw==null) list_kw=new ArrayList<Object>();
											list_kw.add(kw.getTree());
											// Python.g:691:96: ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )*
											loop35:
											while (true) {
												int alt35=2;
												int LA35_0 = input.LA(1);
												if ( (LA35_0==COMMA) ) {
													int LA35_1 = input.LA(2);
													if ( (LA35_1==NAME) ) {
														alt35=1;
													}

												}

												switch (alt35) {
												case 1 :
													// Python.g:691:120: COMMA kw+= vdefparameter[kw_defaults]
													{
													COMMA71=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1681); if (state.failed) return retval;
													if ( state.backtracking==0 ) {
													COMMA71_tree = (PythonTree)adaptor.create(COMMA71);
													adaptor.addChild(root_0, COMMA71_tree);
													}

													pushFollow(FOLLOW_vdefparameter_in_varargslist1685);
													kw=vdefparameter(kw_defaults);
													state._fsp--;
													if (state.failed) return retval;
													if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

													if (list_kw==null) list_kw=new ArrayList<Object>();
													list_kw.add(kw.getTree());
													}
													break;

												default :
													break loop35;
												}
											}

											}
											break;

									}

									// Python.g:691:161: ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )?
									int alt37=2;
									int LA37_0 = input.LA(1);
									if ( (LA37_0==COMMA) ) {
										alt37=1;
									}
									switch (alt37) {
										case 1 :
											// Python.g:691:162: COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param]
											{
											COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1693); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											COMMA72_tree = (PythonTree)adaptor.create(COMMA72);
											adaptor.addChild(root_0, COMMA72_tree);
											}

											DOUBLESTAR73=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1695); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											DOUBLESTAR73_tree = (PythonTree)adaptor.create(DOUBLESTAR73);
											adaptor.addChild(root_0, DOUBLESTAR73_tree);
											}

											pushFollow(FOLLOW_vfpdef_in_varargslist1699);
											kwarg=vfpdef(expr_contextType.Param);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

											}
											break;

									}

									}
									break;
								case 2 :
									// Python.g:692:13: DOUBLESTAR kwarg= vfpdef[expr_contextType.Param]
									{
									DOUBLESTAR74=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1716); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									DOUBLESTAR74_tree = (PythonTree)adaptor.create(DOUBLESTAR74);
									adaptor.addChild(root_0, DOUBLESTAR74_tree);
									}

									pushFollow(FOLLOW_vfpdef_in_varargslist1720);
									kwarg=vfpdef(expr_contextType.Param);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

									}
									break;

							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          retval.args = new arguments((retval.start), actions.castArgs(list_d),
					          actions.castArg((vararg!=null?((PythonTree)vararg.getTree()):null)), actions.castArgs(list_kw),
					          kw_defaults, actions.castArg((kwarg!=null?((PythonTree)kwarg.getTree()):null)), defaults);
					      }
					}
					break;
				case 2 :
					// Python.g:700:7: STAR (vararg= vfpdef[expr_contextType.Param] )? ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )? ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )?
					{
					root_0 = (PythonTree)adaptor.nil();


					STAR75=(Token)match(input,STAR,FOLLOW_STAR_in_varargslist1759); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR75_tree = (PythonTree)adaptor.create(STAR75);
					adaptor.addChild(root_0, STAR75_tree);
					}

					// Python.g:700:12: (vararg= vfpdef[expr_contextType.Param] )?
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==NAME) ) {
						alt40=1;
					}
					switch (alt40) {
						case 1 :
							// Python.g:700:13: vararg= vfpdef[expr_contextType.Param]
							{
							pushFollow(FOLLOW_vfpdef_in_varargslist1764);
							vararg=vfpdef(expr_contextType.Param);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, vararg.getTree());

							}
							break;

					}

					// Python.g:700:53: ( COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )* )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==COMMA) ) {
						int LA42_1 = input.LA(2);
						if ( (LA42_1==NAME) ) {
							alt42=1;
						}
					}
					switch (alt42) {
						case 1 :
							// Python.g:700:54: COMMA kw+= vdefparameter[kw_defaults] ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )*
							{
							COMMA76=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1770); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA76_tree = (PythonTree)adaptor.create(COMMA76);
							adaptor.addChild(root_0, COMMA76_tree);
							}

							pushFollow(FOLLOW_vdefparameter_in_varargslist1774);
							kw=vdefparameter(kw_defaults);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

							if (list_kw==null) list_kw=new ArrayList<Object>();
							list_kw.add(kw.getTree());
							// Python.g:700:91: ( options {greedy=true; } : COMMA kw+= vdefparameter[kw_defaults] )*
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
									// Python.g:700:115: COMMA kw+= vdefparameter[kw_defaults]
									{
									COMMA77=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1785); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									COMMA77_tree = (PythonTree)adaptor.create(COMMA77);
									adaptor.addChild(root_0, COMMA77_tree);
									}

									pushFollow(FOLLOW_vdefparameter_in_varargslist1789);
									kw=vdefparameter(kw_defaults);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, kw.getTree());

									if (list_kw==null) list_kw=new ArrayList<Object>();
									list_kw.add(kw.getTree());
									}
									break;

								default :
									break loop41;
								}
							}

							}
							break;

					}

					// Python.g:700:156: ( COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param] )?
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==COMMA) ) {
						alt43=1;
					}
					switch (alt43) {
						case 1 :
							// Python.g:700:157: COMMA DOUBLESTAR kwarg= vfpdef[expr_contextType.Param]
							{
							COMMA78=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1797); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA78_tree = (PythonTree)adaptor.create(COMMA78);
							adaptor.addChild(root_0, COMMA78_tree);
							}

							DOUBLESTAR79=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1799); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DOUBLESTAR79_tree = (PythonTree)adaptor.create(DOUBLESTAR79);
							adaptor.addChild(root_0, DOUBLESTAR79_tree);
							}

							pushFollow(FOLLOW_vfpdef_in_varargslist1803);
							kwarg=vfpdef(expr_contextType.Param);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          retval.args = new arguments((retval.start), actions.castArgs(list_d),
					          actions.castArg((vararg!=null?((PythonTree)vararg.getTree()):null)),
					          actions.castArgs(list_kw), kw_defaults, actions.castArg((kwarg!=null?((PythonTree)kwarg.getTree()):null)), defaults);
					      }
					}
					break;
				case 3 :
					// Python.g:706:7: DOUBLESTAR kwarg= vfpdef[expr_contextType.Param]
					{
					root_0 = (PythonTree)adaptor.nil();


					DOUBLESTAR80=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1822); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLESTAR80_tree = (PythonTree)adaptor.create(DOUBLESTAR80);
					adaptor.addChild(root_0, DOUBLESTAR80_tree);
					}

					pushFollow(FOLLOW_vfpdef_in_varargslist1826);
					kwarg=vfpdef(expr_contextType.Param);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, kwarg.getTree());

					if ( state.backtracking==0 ) {
					          retval.args = new arguments((retval.start), actions.castArgs(list_d), null,
					          actions.castArgs(list_kw), kw_defaults,
					          actions.castArg((kwarg!=null?((PythonTree)kwarg.getTree()):null)), defaults);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "varargslist"


	public static class vfpdef_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "vfpdef"
	// Python.g:715:1: vfpdef[expr_contextType ctype] : NAME ;
	public final PythonParser.vfpdef_return vfpdef(expr_contextType ctype) throws RecognitionException {
		PythonParser.vfpdef_return retval = new PythonParser.vfpdef_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NAME81=null;

		PythonTree NAME81_tree=null;


		    expr etype = null;

		try {
			// Python.g:724:5: ( NAME )
			// Python.g:724:7: NAME
			{
			root_0 = (PythonTree)adaptor.nil();


			NAME81=(Token)match(input,NAME,FOLLOW_NAME_in_vfpdef1864); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME81_tree = (PythonTree)adaptor.create(NAME81);
			adaptor.addChild(root_0, NAME81_tree);
			}

			if ( state.backtracking==0 ) {
			          etype = new Name(NAME81, (NAME81!=null?NAME81.getText():null), ctype);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vfpdef"


	public static class stmt_return extends ParserRuleReturnScope {
		public List stypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "stmt"
	// Python.g:731:1: stmt returns [List stypes] : ( simple_stmt | compound_stmt );
	public final PythonParser.stmt_return stmt() throws RecognitionException {
		PythonParser.stmt_return retval = new PythonParser.stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope simple_stmt82 =null;
		ParserRuleReturnScope compound_stmt83 =null;


		try {
			// Python.g:733:5: ( simple_stmt | compound_stmt )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==ASSERT||LA45_0==AWAIT||LA45_0==BREAK||(LA45_0 >= COMPLEX && LA45_0 <= CONTINUE)||LA45_0==DELETE||LA45_0==DOT||LA45_0==FLOAT||(LA45_0 >= FROM && LA45_0 <= GLOBAL)||LA45_0==IMPORT||LA45_0==INT||(LA45_0 >= LAMBDA && LA45_0 <= LCURLY)||(LA45_0 >= LONGINT && LA45_0 <= MINUS)||LA45_0==NAME||(LA45_0 >= NONLOCAL && LA45_0 <= NOT)||LA45_0==PASS||LA45_0==PLUS||LA45_0==RAISE||LA45_0==RETURN||LA45_0==STAR||(LA45_0 >= STRING && LA45_0 <= TILDE)||LA45_0==YIELD) ) {
				alt45=1;
			}
			else if ( ((LA45_0 >= ASYNC && LA45_0 <= AT)||LA45_0==CLASS||LA45_0==DEF||LA45_0==FOR||LA45_0==IF||LA45_0==TRY||(LA45_0 >= WHILE && LA45_0 <= WITH)) ) {
				alt45=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// Python.g:733:7: simple_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_simple_stmt_in_stmt1898);
					simple_stmt82=simple_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_stmt82.getTree());

					if ( state.backtracking==0 ) {
					          retval.stypes = (simple_stmt82!=null?((PythonParser.simple_stmt_return)simple_stmt82).stypes:null);
					      }
					}
					break;
				case 2 :
					// Python.g:737:7: compound_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_compound_stmt_in_stmt1914);
					compound_stmt83=compound_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_stmt83.getTree());

					if ( state.backtracking==0 ) {
					          retval.stypes = new ArrayList();
					          retval.stypes.add((compound_stmt83!=null?((PythonTree)compound_stmt83.getTree()):null));
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stmt"


	public static class simple_stmt_return extends ParserRuleReturnScope {
		public List stypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "simple_stmt"
	// Python.g:745:1: simple_stmt returns [List stypes] :s+= small_stmt ( options {greedy=true; } : SEMI s+= small_stmt )* ( SEMI )? NEWLINE ;
	public final PythonParser.simple_stmt_return simple_stmt() throws RecognitionException {
		PythonParser.simple_stmt_return retval = new PythonParser.simple_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token SEMI84=null;
		Token SEMI85=null;
		Token NEWLINE86=null;
		List<Object> list_s=null;
		RuleReturnScope s = null;
		PythonTree SEMI84_tree=null;
		PythonTree SEMI85_tree=null;
		PythonTree NEWLINE86_tree=null;

		try {
			// Python.g:747:5: (s+= small_stmt ( options {greedy=true; } : SEMI s+= small_stmt )* ( SEMI )? NEWLINE )
			// Python.g:747:7: s+= small_stmt ( options {greedy=true; } : SEMI s+= small_stmt )* ( SEMI )? NEWLINE
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_small_stmt_in_simple_stmt1950);
			s=small_stmt();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

			if (list_s==null) list_s=new ArrayList<Object>();
			list_s.add(s.getTree());
			// Python.g:747:21: ( options {greedy=true; } : SEMI s+= small_stmt )*
			loop46:
			while (true) {
				int alt46=2;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==SEMI) ) {
					int LA46_1 = input.LA(2);
					if ( (LA46_1==ASSERT||LA46_1==AWAIT||LA46_1==BREAK||(LA46_1 >= COMPLEX && LA46_1 <= CONTINUE)||LA46_1==DELETE||LA46_1==DOT||LA46_1==FLOAT||(LA46_1 >= FROM && LA46_1 <= GLOBAL)||LA46_1==IMPORT||LA46_1==INT||(LA46_1 >= LAMBDA && LA46_1 <= LCURLY)||(LA46_1 >= LONGINT && LA46_1 <= MINUS)||LA46_1==NAME||(LA46_1 >= NONLOCAL && LA46_1 <= NOT)||LA46_1==PASS||LA46_1==PLUS||LA46_1==RAISE||LA46_1==RETURN||LA46_1==STAR||(LA46_1 >= STRING && LA46_1 <= TILDE)||LA46_1==YIELD) ) {
						alt46=1;
					}

				}

				switch (alt46) {
				case 1 :
					// Python.g:747:45: SEMI s+= small_stmt
					{
					SEMI84=(Token)match(input,SEMI,FOLLOW_SEMI_in_simple_stmt1960); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMI84_tree = (PythonTree)adaptor.create(SEMI84);
					adaptor.addChild(root_0, SEMI84_tree);
					}

					pushFollow(FOLLOW_small_stmt_in_simple_stmt1964);
					s=small_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

					if (list_s==null) list_s=new ArrayList<Object>();
					list_s.add(s.getTree());
					}
					break;

				default :
					break loop46;
				}
			}

			// Python.g:747:66: ( SEMI )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==SEMI) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// Python.g:747:67: SEMI
					{
					SEMI85=(Token)match(input,SEMI,FOLLOW_SEMI_in_simple_stmt1969); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMI85_tree = (PythonTree)adaptor.create(SEMI85);
					adaptor.addChild(root_0, SEMI85_tree);
					}

					}
					break;

			}

			NEWLINE86=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_simple_stmt1973); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NEWLINE86_tree = (PythonTree)adaptor.create(NEWLINE86);
			adaptor.addChild(root_0, NEWLINE86_tree);
			}

			if ( state.backtracking==0 ) {
			          retval.stypes = list_s;
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "simple_stmt"


	public static class small_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "small_stmt"
	// Python.g:755:1: small_stmt : ( expr_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | nonlocal_stmt | assert_stmt );
	public final PythonParser.small_stmt_return small_stmt() throws RecognitionException {
		PythonParser.small_stmt_return retval = new PythonParser.small_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope expr_stmt87 =null;
		ParserRuleReturnScope del_stmt88 =null;
		ParserRuleReturnScope pass_stmt89 =null;
		ParserRuleReturnScope flow_stmt90 =null;
		ParserRuleReturnScope import_stmt91 =null;
		ParserRuleReturnScope global_stmt92 =null;
		ParserRuleReturnScope nonlocal_stmt93 =null;
		ParserRuleReturnScope assert_stmt94 =null;


		try {
			// Python.g:755:12: ( expr_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | nonlocal_stmt | assert_stmt )
			int alt48=8;
			switch ( input.LA(1) ) {
			case AWAIT:
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
				{
				alt48=1;
				}
				break;
			case DELETE:
				{
				alt48=2;
				}
				break;
			case PASS:
				{
				alt48=3;
				}
				break;
			case BREAK:
			case CONTINUE:
			case RAISE:
			case RETURN:
			case YIELD:
				{
				alt48=4;
				}
				break;
			case FROM:
			case IMPORT:
				{
				alt48=5;
				}
				break;
			case GLOBAL:
				{
				alt48=6;
				}
				break;
			case NONLOCAL:
				{
				alt48=7;
				}
				break;
			case ASSERT:
				{
				alt48=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// Python.g:755:14: expr_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_expr_stmt_in_small_stmt1996);
					expr_stmt87=expr_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_stmt87.getTree());

					}
					break;
				case 2 :
					// Python.g:756:14: del_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_del_stmt_in_small_stmt2011);
					del_stmt88=del_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, del_stmt88.getTree());

					}
					break;
				case 3 :
					// Python.g:757:14: pass_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_pass_stmt_in_small_stmt2026);
					pass_stmt89=pass_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pass_stmt89.getTree());

					}
					break;
				case 4 :
					// Python.g:758:14: flow_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_flow_stmt_in_small_stmt2041);
					flow_stmt90=flow_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, flow_stmt90.getTree());

					}
					break;
				case 5 :
					// Python.g:759:14: import_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_import_stmt_in_small_stmt2056);
					import_stmt91=import_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, import_stmt91.getTree());

					}
					break;
				case 6 :
					// Python.g:760:14: global_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_global_stmt_in_small_stmt2071);
					global_stmt92=global_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, global_stmt92.getTree());

					}
					break;
				case 7 :
					// Python.g:761:14: nonlocal_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_nonlocal_stmt_in_small_stmt2086);
					nonlocal_stmt93=nonlocal_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nonlocal_stmt93.getTree());

					}
					break;
				case 8 :
					// Python.g:762:14: assert_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_assert_stmt_in_small_stmt2101);
					assert_stmt94=assert_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assert_stmt94.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "small_stmt"


	public static class star_expr_return extends ParserRuleReturnScope {
		public expr etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "star_expr"
	// Python.g:766:1: star_expr[expr_contextType ctype] returns [expr etype] : STAR expr[ctype] ;
	public final PythonParser.star_expr_return star_expr(expr_contextType ctype) throws RecognitionException {
		PythonParser.star_expr_return retval = new PythonParser.star_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token STAR95=null;
		ParserRuleReturnScope expr96 =null;

		PythonTree STAR95_tree=null;

		try {
			// Python.g:771:5: ( STAR expr[ctype] )
			// Python.g:771:7: STAR expr[ctype]
			{
			root_0 = (PythonTree)adaptor.nil();


			STAR95=(Token)match(input,STAR,FOLLOW_STAR_in_star_expr2141); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STAR95_tree = (PythonTree)adaptor.create(STAR95);
			adaptor.addChild(root_0, STAR95_tree);
			}

			pushFollow(FOLLOW_expr_in_star_expr2143);
			expr96=expr(ctype);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr96.getTree());

			if ( state.backtracking==0 ) {
			        retval.etype = new Starred(STAR95, actions.castExpr((expr96!=null?((PythonTree)expr96.getTree()):null)), ctype);
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "star_expr"


	public static class expr_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_stmt"
	// Python.g:778:1: expr_stmt : ( ( testlist_star_expr[null] augassign )=>lhs= testlist_star_expr[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] ) ) | ( testlist_star_expr[null] ASSIGN )=>lhs= testlist_star_expr[expr_contextType.Store] (| ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ ) | ( (ay= ASSIGN y2+= yield_expr )+ ) ) |lhs= testlist_star_expr[expr_contextType.Load] ) ;
	public final PythonParser.expr_stmt_return expr_stmt() throws RecognitionException {
		PythonParser.expr_stmt_return retval = new PythonParser.expr_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token at=null;
		Token ay=null;
		List<Object> list_t=null;
		List<Object> list_y2=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope aay =null;
		ParserRuleReturnScope y1 =null;
		ParserRuleReturnScope aat =null;
		ParserRuleReturnScope rhs =null;
		RuleReturnScope t = null;
		RuleReturnScope y2 = null;
		PythonTree at_tree=null;
		PythonTree ay_tree=null;


		    stmt stype = null;

		try {
			// Python.g:787:5: ( ( ( testlist_star_expr[null] augassign )=>lhs= testlist_star_expr[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] ) ) | ( testlist_star_expr[null] ASSIGN )=>lhs= testlist_star_expr[expr_contextType.Store] (| ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ ) | ( (ay= ASSIGN y2+= yield_expr )+ ) ) |lhs= testlist_star_expr[expr_contextType.Load] ) )
			// Python.g:787:7: ( ( testlist_star_expr[null] augassign )=>lhs= testlist_star_expr[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] ) ) | ( testlist_star_expr[null] ASSIGN )=>lhs= testlist_star_expr[expr_contextType.Store] (| ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ ) | ( (ay= ASSIGN y2+= yield_expr )+ ) ) |lhs= testlist_star_expr[expr_contextType.Load] )
			{
			root_0 = (PythonTree)adaptor.nil();


			// Python.g:787:7: ( ( testlist_star_expr[null] augassign )=>lhs= testlist_star_expr[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] ) ) | ( testlist_star_expr[null] ASSIGN )=>lhs= testlist_star_expr[expr_contextType.Store] (| ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ ) | ( (ay= ASSIGN y2+= yield_expr )+ ) ) |lhs= testlist_star_expr[expr_contextType.Load] )
			int alt53=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA53_1 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case PLUS:
				{
				int LA53_2 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case MINUS:
				{
				int LA53_3 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case TILDE:
				{
				int LA53_4 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case AWAIT:
				{
				int LA53_5 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case LPAREN:
				{
				int LA53_6 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case LBRACK:
				{
				int LA53_7 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case LCURLY:
				{
				int LA53_8 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case NAME:
				{
				int LA53_9 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case INT:
				{
				int LA53_10 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case LONGINT:
				{
				int LA53_11 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case FLOAT:
				{
				int LA53_12 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case COMPLEX:
				{
				int LA53_13 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case DOT:
				{
				int LA53_14 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case STRING:
				{
				int LA53_15 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case LAMBDA:
				{
				int LA53_16 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			case STAR:
				{
				int LA53_17 = input.LA(2);
				if ( (synpred1_Python()) ) {
					alt53=1;
				}
				else if ( (synpred2_Python()) ) {
					alt53=2;
				}
				else if ( (true) ) {
					alt53=3;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 53, 0, input);
				throw nvae;
			}
			switch (alt53) {
				case 1 :
					// Python.g:787:8: ( testlist_star_expr[null] augassign )=>lhs= testlist_star_expr[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] ) )
					{
					pushFollow(FOLLOW_testlist_star_expr_in_expr_stmt2187);
					lhs=testlist_star_expr(expr_contextType.AugStore);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

					// Python.g:788:9: ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] ) )
					int alt49=2;
					switch ( input.LA(1) ) {
					case PLUSEQUAL:
						{
						int LA49_1 = input.LA(2);
						if ( (LA49_1==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_1==AWAIT||LA49_1==COMPLEX||LA49_1==DOT||LA49_1==FLOAT||LA49_1==INT||(LA49_1 >= LAMBDA && LA49_1 <= LCURLY)||(LA49_1 >= LONGINT && LA49_1 <= MINUS)||LA49_1==NAME||LA49_1==NOT||LA49_1==PLUS||LA49_1==STAR||(LA49_1 >= STRING && LA49_1 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MINUSEQUAL:
						{
						int LA49_2 = input.LA(2);
						if ( (LA49_2==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_2==AWAIT||LA49_2==COMPLEX||LA49_2==DOT||LA49_2==FLOAT||LA49_2==INT||(LA49_2 >= LAMBDA && LA49_2 <= LCURLY)||(LA49_2 >= LONGINT && LA49_2 <= MINUS)||LA49_2==NAME||LA49_2==NOT||LA49_2==PLUS||LA49_2==STAR||(LA49_2 >= STRING && LA49_2 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case STAREQUAL:
						{
						int LA49_3 = input.LA(2);
						if ( (LA49_3==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_3==AWAIT||LA49_3==COMPLEX||LA49_3==DOT||LA49_3==FLOAT||LA49_3==INT||(LA49_3 >= LAMBDA && LA49_3 <= LCURLY)||(LA49_3 >= LONGINT && LA49_3 <= MINUS)||LA49_3==NAME||LA49_3==NOT||LA49_3==PLUS||LA49_3==STAR||(LA49_3 >= STRING && LA49_3 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ATEQUAL:
						{
						int LA49_4 = input.LA(2);
						if ( (LA49_4==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_4==AWAIT||LA49_4==COMPLEX||LA49_4==DOT||LA49_4==FLOAT||LA49_4==INT||(LA49_4 >= LAMBDA && LA49_4 <= LCURLY)||(LA49_4 >= LONGINT && LA49_4 <= MINUS)||LA49_4==NAME||LA49_4==NOT||LA49_4==PLUS||LA49_4==STAR||(LA49_4 >= STRING && LA49_4 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case SLASHEQUAL:
						{
						int LA49_5 = input.LA(2);
						if ( (LA49_5==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_5==AWAIT||LA49_5==COMPLEX||LA49_5==DOT||LA49_5==FLOAT||LA49_5==INT||(LA49_5 >= LAMBDA && LA49_5 <= LCURLY)||(LA49_5 >= LONGINT && LA49_5 <= MINUS)||LA49_5==NAME||LA49_5==NOT||LA49_5==PLUS||LA49_5==STAR||(LA49_5 >= STRING && LA49_5 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case PERCENTEQUAL:
						{
						int LA49_6 = input.LA(2);
						if ( (LA49_6==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_6==AWAIT||LA49_6==COMPLEX||LA49_6==DOT||LA49_6==FLOAT||LA49_6==INT||(LA49_6 >= LAMBDA && LA49_6 <= LCURLY)||(LA49_6 >= LONGINT && LA49_6 <= MINUS)||LA49_6==NAME||LA49_6==NOT||LA49_6==PLUS||LA49_6==STAR||(LA49_6 >= STRING && LA49_6 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case AMPEREQUAL:
						{
						int LA49_7 = input.LA(2);
						if ( (LA49_7==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_7==AWAIT||LA49_7==COMPLEX||LA49_7==DOT||LA49_7==FLOAT||LA49_7==INT||(LA49_7 >= LAMBDA && LA49_7 <= LCURLY)||(LA49_7 >= LONGINT && LA49_7 <= MINUS)||LA49_7==NAME||LA49_7==NOT||LA49_7==PLUS||LA49_7==STAR||(LA49_7 >= STRING && LA49_7 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case VBAREQUAL:
						{
						int LA49_8 = input.LA(2);
						if ( (LA49_8==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_8==AWAIT||LA49_8==COMPLEX||LA49_8==DOT||LA49_8==FLOAT||LA49_8==INT||(LA49_8 >= LAMBDA && LA49_8 <= LCURLY)||(LA49_8 >= LONGINT && LA49_8 <= MINUS)||LA49_8==NAME||LA49_8==NOT||LA49_8==PLUS||LA49_8==STAR||(LA49_8 >= STRING && LA49_8 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case CIRCUMFLEXEQUAL:
						{
						int LA49_9 = input.LA(2);
						if ( (LA49_9==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_9==AWAIT||LA49_9==COMPLEX||LA49_9==DOT||LA49_9==FLOAT||LA49_9==INT||(LA49_9 >= LAMBDA && LA49_9 <= LCURLY)||(LA49_9 >= LONGINT && LA49_9 <= MINUS)||LA49_9==NAME||LA49_9==NOT||LA49_9==PLUS||LA49_9==STAR||(LA49_9 >= STRING && LA49_9 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case LEFTSHIFTEQUAL:
						{
						int LA49_10 = input.LA(2);
						if ( (LA49_10==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_10==AWAIT||LA49_10==COMPLEX||LA49_10==DOT||LA49_10==FLOAT||LA49_10==INT||(LA49_10 >= LAMBDA && LA49_10 <= LCURLY)||(LA49_10 >= LONGINT && LA49_10 <= MINUS)||LA49_10==NAME||LA49_10==NOT||LA49_10==PLUS||LA49_10==STAR||(LA49_10 >= STRING && LA49_10 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 10, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case RIGHTSHIFTEQUAL:
						{
						int LA49_11 = input.LA(2);
						if ( (LA49_11==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_11==AWAIT||LA49_11==COMPLEX||LA49_11==DOT||LA49_11==FLOAT||LA49_11==INT||(LA49_11 >= LAMBDA && LA49_11 <= LCURLY)||(LA49_11 >= LONGINT && LA49_11 <= MINUS)||LA49_11==NAME||LA49_11==NOT||LA49_11==PLUS||LA49_11==STAR||(LA49_11 >= STRING && LA49_11 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DOUBLESTAREQUAL:
						{
						int LA49_12 = input.LA(2);
						if ( (LA49_12==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_12==AWAIT||LA49_12==COMPLEX||LA49_12==DOT||LA49_12==FLOAT||LA49_12==INT||(LA49_12 >= LAMBDA && LA49_12 <= LCURLY)||(LA49_12 >= LONGINT && LA49_12 <= MINUS)||LA49_12==NAME||LA49_12==NOT||LA49_12==PLUS||LA49_12==STAR||(LA49_12 >= STRING && LA49_12 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 12, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DOUBLESLASHEQUAL:
						{
						int LA49_13 = input.LA(2);
						if ( (LA49_13==YIELD) ) {
							alt49=1;
						}
						else if ( (LA49_13==AWAIT||LA49_13==COMPLEX||LA49_13==DOT||LA49_13==FLOAT||LA49_13==INT||(LA49_13 >= LAMBDA && LA49_13 <= LCURLY)||(LA49_13 >= LONGINT && LA49_13 <= MINUS)||LA49_13==NAME||LA49_13==NOT||LA49_13==PLUS||LA49_13==STAR||(LA49_13 >= STRING && LA49_13 <= TILDE)) ) {
							alt49=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 49, 13, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 49, 0, input);
						throw nvae;
					}
					switch (alt49) {
						case 1 :
							// Python.g:788:11: (aay= augassign y1= yield_expr )
							{
							// Python.g:788:11: (aay= augassign y1= yield_expr )
							// Python.g:788:12: aay= augassign y1= yield_expr
							{
							pushFollow(FOLLOW_augassign_in_expr_stmt2203);
							aay=augassign();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, aay.getTree());

							pushFollow(FOLLOW_yield_expr_in_expr_stmt2207);
							y1=yield_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, y1.getTree());

							if ( state.backtracking==0 ) {
							               actions.checkAugAssign(actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)));
							               stype = new AugAssign((lhs!=null?((PythonTree)lhs.getTree()):null), actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)), (aay!=null?((PythonParser.augassign_return)aay).op:null), actions.castExpr((y1!=null?((PythonParser.yield_expr_return)y1).etype:null)));
							           }
							}

							}
							break;
						case 2 :
							// Python.g:794:11: (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] )
							{
							// Python.g:794:11: (aat= augassign rhs= testlist_star_expr[expr_contextType.Load] )
							// Python.g:794:12: aat= augassign rhs= testlist_star_expr[expr_contextType.Load]
							{
							pushFollow(FOLLOW_augassign_in_expr_stmt2247);
							aat=augassign();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, aat.getTree());

							pushFollow(FOLLOW_testlist_star_expr_in_expr_stmt2251);
							rhs=testlist_star_expr(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

							if ( state.backtracking==0 ) {
							               actions.checkAugAssign(actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)));
							               stype = new AugAssign((lhs!=null?((PythonTree)lhs.getTree()):null), actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)), (aat!=null?((PythonParser.augassign_return)aat).op:null), actions.castExpr((rhs!=null?((PythonTree)rhs.getTree()):null)));
							           }
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// Python.g:801:7: ( testlist_star_expr[null] ASSIGN )=>lhs= testlist_star_expr[expr_contextType.Store] (| ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ ) | ( (ay= ASSIGN y2+= yield_expr )+ ) )
					{
					pushFollow(FOLLOW_testlist_star_expr_in_expr_stmt2306);
					lhs=testlist_star_expr(expr_contextType.Store);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

					// Python.g:802:9: (| ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ ) | ( (ay= ASSIGN y2+= yield_expr )+ ) )
					int alt52=3;
					int LA52_0 = input.LA(1);
					if ( (LA52_0==NEWLINE||LA52_0==SEMI) ) {
						alt52=1;
					}
					else if ( (LA52_0==ASSIGN) ) {
						int LA52_2 = input.LA(2);
						if ( (LA52_2==AWAIT||LA52_2==COMPLEX||LA52_2==DOT||LA52_2==FLOAT||LA52_2==INT||(LA52_2 >= LAMBDA && LA52_2 <= LCURLY)||(LA52_2 >= LONGINT && LA52_2 <= MINUS)||LA52_2==NAME||LA52_2==NOT||LA52_2==PLUS||LA52_2==STAR||(LA52_2 >= STRING && LA52_2 <= TILDE)) ) {
							alt52=2;
						}
						else if ( (LA52_2==YIELD) ) {
							alt52=3;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 52, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 52, 0, input);
						throw nvae;
					}

					switch (alt52) {
						case 1 :
							// Python.g:803:9: 
							{
							}
							break;
						case 2 :
							// Python.g:803:11: ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ )
							{
							// Python.g:803:11: ( (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+ )
							// Python.g:803:12: (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+
							{
							// Python.g:803:12: (at= ASSIGN t+= testlist_star_expr[expr_contextType.Store] )+
							int cnt50=0;
							loop50:
							while (true) {
								int alt50=2;
								int LA50_0 = input.LA(1);
								if ( (LA50_0==ASSIGN) ) {
									alt50=1;
								}

								switch (alt50) {
								case 1 :
									// Python.g:803:13: at= ASSIGN t+= testlist_star_expr[expr_contextType.Store]
									{
									at=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_expr_stmt2333); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									at_tree = (PythonTree)adaptor.create(at);
									adaptor.addChild(root_0, at_tree);
									}

									pushFollow(FOLLOW_testlist_star_expr_in_expr_stmt2337);
									t=testlist_star_expr(expr_contextType.Store);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

									if (list_t==null) list_t=new ArrayList<Object>();
									list_t.add(t.getTree());
									}
									break;

								default :
									if ( cnt50 >= 1 ) break loop50;
									if (state.backtracking>0) {state.failed=true; return retval;}
									EarlyExitException eee = new EarlyExitException(50, input);
									throw eee;
								}
								cnt50++;
							}

							if ( state.backtracking==0 ) {
							                stype = new Assign((lhs!=null?((PythonTree)lhs.getTree()):null), actions.makeAssignTargets(
							                    actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)), list_t), actions.makeAssignValue(list_t));
							            }
							}

							}
							break;
						case 3 :
							// Python.g:809:11: ( (ay= ASSIGN y2+= yield_expr )+ )
							{
							// Python.g:809:11: ( (ay= ASSIGN y2+= yield_expr )+ )
							// Python.g:809:12: (ay= ASSIGN y2+= yield_expr )+
							{
							// Python.g:809:12: (ay= ASSIGN y2+= yield_expr )+
							int cnt51=0;
							loop51:
							while (true) {
								int alt51=2;
								int LA51_0 = input.LA(1);
								if ( (LA51_0==ASSIGN) ) {
									alt51=1;
								}

								switch (alt51) {
								case 1 :
									// Python.g:809:13: ay= ASSIGN y2+= yield_expr
									{
									ay=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_expr_stmt2382); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									ay_tree = (PythonTree)adaptor.create(ay);
									adaptor.addChild(root_0, ay_tree);
									}

									pushFollow(FOLLOW_yield_expr_in_expr_stmt2386);
									y2=yield_expr();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, y2.getTree());

									if (list_y2==null) list_y2=new ArrayList<Object>();
									list_y2.add(y2.getTree());
									}
									break;

								default :
									if ( cnt51 >= 1 ) break loop51;
									if (state.backtracking>0) {state.failed=true; return retval;}
									EarlyExitException eee = new EarlyExitException(51, input);
									throw eee;
								}
								cnt51++;
							}

							if ( state.backtracking==0 ) {
							                stype = new Assign((lhs!=null?(lhs.start):null), actions.makeAssignTargets(
							                    actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)), list_y2), actions.makeAssignValue(list_y2));
							            }
							}

							}
							break;

					}

					}
					break;
				case 3 :
					// Python.g:816:7: lhs= testlist_star_expr[expr_contextType.Load]
					{
					pushFollow(FOLLOW_testlist_star_expr_in_expr_stmt2434);
					lhs=testlist_star_expr(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

					if ( state.backtracking==0 ) {
					          stype = new Expr((lhs!=null?(lhs.start):null), actions.castExpr((lhs!=null?((PythonTree)lhs.getTree()):null)));
					      }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (stype != null) {
			        retval.tree = stype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr_stmt"


	public static class testlist_star_expr_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "testlist_star_expr"
	// Python.g:824:1: testlist_star_expr[expr_contextType ctype] : ( ( ( test[null] | star_expr[null] ) COMMA )=> (t+= test_or_star_expr[ctype] ) ( options {greedy=true; } : COMMA (t+= test_or_star_expr[ctype] ) )* ( COMMA )? | ( test[ctype] | star_expr[ctype] ) );
	public final PythonParser.testlist_star_expr_return testlist_star_expr(expr_contextType ctype) throws RecognitionException {
		PythonParser.testlist_star_expr_return retval = new PythonParser.testlist_star_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA97=null;
		Token COMMA98=null;
		List<Object> list_t=null;
		ParserRuleReturnScope test99 =null;
		ParserRuleReturnScope star_expr100 =null;
		RuleReturnScope t = null;
		PythonTree COMMA97_tree=null;
		PythonTree COMMA98_tree=null;


		    expr etype = null;

		try {
			// Python.g:834:5: ( ( ( test[null] | star_expr[null] ) COMMA )=> (t+= test_or_star_expr[ctype] ) ( options {greedy=true; } : COMMA (t+= test_or_star_expr[ctype] ) )* ( COMMA )? | ( test[ctype] | star_expr[ctype] ) )
			int alt57=2;
			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA57_1 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case PLUS:
				{
				int LA57_2 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case MINUS:
				{
				int LA57_3 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case TILDE:
				{
				int LA57_4 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case AWAIT:
				{
				int LA57_5 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA57_6 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case LBRACK:
				{
				int LA57_7 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case LCURLY:
				{
				int LA57_8 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case NAME:
				{
				int LA57_9 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case INT:
				{
				int LA57_10 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case LONGINT:
				{
				int LA57_11 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA57_12 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case COMPLEX:
				{
				int LA57_13 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case DOT:
				{
				int LA57_14 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case STRING:
				{
				int LA57_15 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case LAMBDA:
				{
				int LA57_16 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case STAR:
				{
				int LA57_17 = input.LA(2);
				if ( (synpred3_Python()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}
			switch (alt57) {
				case 1 :
					// Python.g:834:7: ( ( test[null] | star_expr[null] ) COMMA )=> (t+= test_or_star_expr[ctype] ) ( options {greedy=true; } : COMMA (t+= test_or_star_expr[ctype] ) )* ( COMMA )?
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:836:6: (t+= test_or_star_expr[ctype] )
					// Python.g:836:7: t+= test_or_star_expr[ctype]
					{
					pushFollow(FOLLOW_test_or_star_expr_in_testlist_star_expr2508);
					t=test_or_star_expr(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					if (list_t==null) list_t=new ArrayList<Object>();
					list_t.add(t.getTree());
					}

					// Python.g:836:36: ( options {greedy=true; } : COMMA (t+= test_or_star_expr[ctype] ) )*
					loop54:
					while (true) {
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==COMMA) ) {
							int LA54_1 = input.LA(2);
							if ( (LA54_1==AWAIT||LA54_1==COMPLEX||LA54_1==DOT||LA54_1==FLOAT||LA54_1==INT||(LA54_1 >= LAMBDA && LA54_1 <= LCURLY)||(LA54_1 >= LONGINT && LA54_1 <= MINUS)||LA54_1==NAME||LA54_1==NOT||LA54_1==PLUS||LA54_1==STAR||(LA54_1 >= STRING && LA54_1 <= TILDE)) ) {
								alt54=1;
							}

						}

						switch (alt54) {
						case 1 :
							// Python.g:836:60: COMMA (t+= test_or_star_expr[ctype] )
							{
							COMMA97=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist_star_expr2520); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA97_tree = (PythonTree)adaptor.create(COMMA97);
							adaptor.addChild(root_0, COMMA97_tree);
							}

							// Python.g:836:66: (t+= test_or_star_expr[ctype] )
							// Python.g:836:67: t+= test_or_star_expr[ctype]
							{
							pushFollow(FOLLOW_test_or_star_expr_in_testlist_star_expr2525);
							t=test_or_star_expr(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

							if (list_t==null) list_t=new ArrayList<Object>();
							list_t.add(t.getTree());
							}

							}
							break;

						default :
							break loop54;
						}
					}

					// Python.g:836:98: ( COMMA )?
					int alt55=2;
					int LA55_0 = input.LA(1);
					if ( (LA55_0==COMMA) ) {
						alt55=1;
					}
					switch (alt55) {
						case 1 :
							// Python.g:836:99: COMMA
							{
							COMMA98=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist_star_expr2532); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA98_tree = (PythonTree)adaptor.create(COMMA98);
							adaptor.addChild(root_0, COMMA98_tree);
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          etype = new Tuple((retval.start), actions.castExprs(list_t), ctype);
					      }
					}
					break;
				case 2 :
					// Python.g:840:7: ( test[ctype] | star_expr[ctype] )
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:840:7: ( test[ctype] | star_expr[ctype] )
					int alt56=2;
					int LA56_0 = input.LA(1);
					if ( (LA56_0==AWAIT||LA56_0==COMPLEX||LA56_0==DOT||LA56_0==FLOAT||LA56_0==INT||(LA56_0 >= LAMBDA && LA56_0 <= LCURLY)||(LA56_0 >= LONGINT && LA56_0 <= MINUS)||LA56_0==NAME||LA56_0==NOT||LA56_0==PLUS||(LA56_0 >= STRING && LA56_0 <= TILDE)) ) {
						alt56=1;
					}
					else if ( (LA56_0==STAR) ) {
						alt56=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 56, 0, input);
						throw nvae;
					}

					switch (alt56) {
						case 1 :
							// Python.g:840:8: test[ctype]
							{
							pushFollow(FOLLOW_test_in_testlist_star_expr2551);
							test99=test(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, test99.getTree());

							}
							break;
						case 2 :
							// Python.g:841:7: star_expr[ctype]
							{
							pushFollow(FOLLOW_star_expr_in_testlist_star_expr2560);
							star_expr100=star_expr(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, star_expr100.getTree());

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "testlist_star_expr"


	public static class test_or_star_expr_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "test_or_star_expr"
	// Python.g:845:1: test_or_star_expr[expr_contextType ctype] : ( test[ctype] | star_expr[ctype] );
	public final PythonParser.test_or_star_expr_return test_or_star_expr(expr_contextType ctype) throws RecognitionException {
		PythonParser.test_or_star_expr_return retval = new PythonParser.test_or_star_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope test101 =null;
		ParserRuleReturnScope star_expr102 =null;


		try {
			// Python.g:846:5: ( test[ctype] | star_expr[ctype] )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==AWAIT||LA58_0==COMPLEX||LA58_0==DOT||LA58_0==FLOAT||LA58_0==INT||(LA58_0 >= LAMBDA && LA58_0 <= LCURLY)||(LA58_0 >= LONGINT && LA58_0 <= MINUS)||LA58_0==NAME||LA58_0==NOT||LA58_0==PLUS||(LA58_0 >= STRING && LA58_0 <= TILDE)) ) {
				alt58=1;
			}
			else if ( (LA58_0==STAR) ) {
				alt58=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// Python.g:846:7: test[ctype]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_test_in_test_or_star_expr2581);
					test101=test(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test101.getTree());

					}
					break;
				case 2 :
					// Python.g:847:7: star_expr[ctype]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_star_expr_in_test_or_star_expr2590);
					star_expr102=star_expr(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, star_expr102.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "test_or_star_expr"


	public static class augassign_return extends ParserRuleReturnScope {
		public operatorType op;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "augassign"
	// Python.g:852:1: augassign returns [operatorType op] : ( PLUSEQUAL | MINUSEQUAL | STAREQUAL | ATEQUAL | SLASHEQUAL | PERCENTEQUAL | AMPEREQUAL | VBAREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL );
	public final PythonParser.augassign_return augassign() throws RecognitionException {
		PythonParser.augassign_return retval = new PythonParser.augassign_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token PLUSEQUAL103=null;
		Token MINUSEQUAL104=null;
		Token STAREQUAL105=null;
		Token ATEQUAL106=null;
		Token SLASHEQUAL107=null;
		Token PERCENTEQUAL108=null;
		Token AMPEREQUAL109=null;
		Token VBAREQUAL110=null;
		Token CIRCUMFLEXEQUAL111=null;
		Token LEFTSHIFTEQUAL112=null;
		Token RIGHTSHIFTEQUAL113=null;
		Token DOUBLESTAREQUAL114=null;
		Token DOUBLESLASHEQUAL115=null;

		PythonTree PLUSEQUAL103_tree=null;
		PythonTree MINUSEQUAL104_tree=null;
		PythonTree STAREQUAL105_tree=null;
		PythonTree ATEQUAL106_tree=null;
		PythonTree SLASHEQUAL107_tree=null;
		PythonTree PERCENTEQUAL108_tree=null;
		PythonTree AMPEREQUAL109_tree=null;
		PythonTree VBAREQUAL110_tree=null;
		PythonTree CIRCUMFLEXEQUAL111_tree=null;
		PythonTree LEFTSHIFTEQUAL112_tree=null;
		PythonTree RIGHTSHIFTEQUAL113_tree=null;
		PythonTree DOUBLESTAREQUAL114_tree=null;
		PythonTree DOUBLESLASHEQUAL115_tree=null;

		try {
			// Python.g:854:5: ( PLUSEQUAL | MINUSEQUAL | STAREQUAL | ATEQUAL | SLASHEQUAL | PERCENTEQUAL | AMPEREQUAL | VBAREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL )
			int alt59=13;
			switch ( input.LA(1) ) {
			case PLUSEQUAL:
				{
				alt59=1;
				}
				break;
			case MINUSEQUAL:
				{
				alt59=2;
				}
				break;
			case STAREQUAL:
				{
				alt59=3;
				}
				break;
			case ATEQUAL:
				{
				alt59=4;
				}
				break;
			case SLASHEQUAL:
				{
				alt59=5;
				}
				break;
			case PERCENTEQUAL:
				{
				alt59=6;
				}
				break;
			case AMPEREQUAL:
				{
				alt59=7;
				}
				break;
			case VBAREQUAL:
				{
				alt59=8;
				}
				break;
			case CIRCUMFLEXEQUAL:
				{
				alt59=9;
				}
				break;
			case LEFTSHIFTEQUAL:
				{
				alt59=10;
				}
				break;
			case RIGHTSHIFTEQUAL:
				{
				alt59=11;
				}
				break;
			case DOUBLESTAREQUAL:
				{
				alt59=12;
				}
				break;
			case DOUBLESLASHEQUAL:
				{
				alt59=13;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}
			switch (alt59) {
				case 1 :
					// Python.g:854:7: PLUSEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					PLUSEQUAL103=(Token)match(input,PLUSEQUAL,FOLLOW_PLUSEQUAL_in_augassign2618); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUSEQUAL103_tree = (PythonTree)adaptor.create(PLUSEQUAL103);
					adaptor.addChild(root_0, PLUSEQUAL103_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.Add;
					        }
					}
					break;
				case 2 :
					// Python.g:858:7: MINUSEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					MINUSEQUAL104=(Token)match(input,MINUSEQUAL,FOLLOW_MINUSEQUAL_in_augassign2636); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUSEQUAL104_tree = (PythonTree)adaptor.create(MINUSEQUAL104);
					adaptor.addChild(root_0, MINUSEQUAL104_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.Sub;
					        }
					}
					break;
				case 3 :
					// Python.g:862:7: STAREQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					STAREQUAL105=(Token)match(input,STAREQUAL,FOLLOW_STAREQUAL_in_augassign2654); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAREQUAL105_tree = (PythonTree)adaptor.create(STAREQUAL105);
					adaptor.addChild(root_0, STAREQUAL105_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.Mult;
					        }
					}
					break;
				case 4 :
					// Python.g:866:7: ATEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					ATEQUAL106=(Token)match(input,ATEQUAL,FOLLOW_ATEQUAL_in_augassign2672); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ATEQUAL106_tree = (PythonTree)adaptor.create(ATEQUAL106);
					adaptor.addChild(root_0, ATEQUAL106_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.MatMult;
					        }
					}
					break;
				case 5 :
					// Python.g:870:7: SLASHEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					SLASHEQUAL107=(Token)match(input,SLASHEQUAL,FOLLOW_SLASHEQUAL_in_augassign2690); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SLASHEQUAL107_tree = (PythonTree)adaptor.create(SLASHEQUAL107);
					adaptor.addChild(root_0, SLASHEQUAL107_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.Div;
					        }
					}
					break;
				case 6 :
					// Python.g:874:7: PERCENTEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					PERCENTEQUAL108=(Token)match(input,PERCENTEQUAL,FOLLOW_PERCENTEQUAL_in_augassign2708); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PERCENTEQUAL108_tree = (PythonTree)adaptor.create(PERCENTEQUAL108);
					adaptor.addChild(root_0, PERCENTEQUAL108_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.Mod;
					        }
					}
					break;
				case 7 :
					// Python.g:878:7: AMPEREQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					AMPEREQUAL109=(Token)match(input,AMPEREQUAL,FOLLOW_AMPEREQUAL_in_augassign2726); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AMPEREQUAL109_tree = (PythonTree)adaptor.create(AMPEREQUAL109);
					adaptor.addChild(root_0, AMPEREQUAL109_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.BitAnd;
					        }
					}
					break;
				case 8 :
					// Python.g:882:7: VBAREQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					VBAREQUAL110=(Token)match(input,VBAREQUAL,FOLLOW_VBAREQUAL_in_augassign2744); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VBAREQUAL110_tree = (PythonTree)adaptor.create(VBAREQUAL110);
					adaptor.addChild(root_0, VBAREQUAL110_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.BitOr;
					        }
					}
					break;
				case 9 :
					// Python.g:886:7: CIRCUMFLEXEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					CIRCUMFLEXEQUAL111=(Token)match(input,CIRCUMFLEXEQUAL,FOLLOW_CIRCUMFLEXEQUAL_in_augassign2762); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CIRCUMFLEXEQUAL111_tree = (PythonTree)adaptor.create(CIRCUMFLEXEQUAL111);
					adaptor.addChild(root_0, CIRCUMFLEXEQUAL111_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.BitXor;
					        }
					}
					break;
				case 10 :
					// Python.g:890:7: LEFTSHIFTEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					LEFTSHIFTEQUAL112=(Token)match(input,LEFTSHIFTEQUAL,FOLLOW_LEFTSHIFTEQUAL_in_augassign2780); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSHIFTEQUAL112_tree = (PythonTree)adaptor.create(LEFTSHIFTEQUAL112);
					adaptor.addChild(root_0, LEFTSHIFTEQUAL112_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.LShift;
					        }
					}
					break;
				case 11 :
					// Python.g:894:7: RIGHTSHIFTEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					RIGHTSHIFTEQUAL113=(Token)match(input,RIGHTSHIFTEQUAL,FOLLOW_RIGHTSHIFTEQUAL_in_augassign2798); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSHIFTEQUAL113_tree = (PythonTree)adaptor.create(RIGHTSHIFTEQUAL113);
					adaptor.addChild(root_0, RIGHTSHIFTEQUAL113_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.RShift;
					        }
					}
					break;
				case 12 :
					// Python.g:898:7: DOUBLESTAREQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					DOUBLESTAREQUAL114=(Token)match(input,DOUBLESTAREQUAL,FOLLOW_DOUBLESTAREQUAL_in_augassign2816); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLESTAREQUAL114_tree = (PythonTree)adaptor.create(DOUBLESTAREQUAL114);
					adaptor.addChild(root_0, DOUBLESTAREQUAL114_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.Pow;
					        }
					}
					break;
				case 13 :
					// Python.g:902:7: DOUBLESLASHEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					DOUBLESLASHEQUAL115=(Token)match(input,DOUBLESLASHEQUAL,FOLLOW_DOUBLESLASHEQUAL_in_augassign2834); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLESLASHEQUAL115_tree = (PythonTree)adaptor.create(DOUBLESLASHEQUAL115);
					adaptor.addChild(root_0, DOUBLESLASHEQUAL115_tree);
					}

					if ( state.backtracking==0 ) {
					            retval.op = operatorType.FloorDiv;
					        }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "augassign"


	public static class del_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "del_stmt"
	// Python.g:909:1: del_stmt : DELETE del_list ;
	public final PythonParser.del_stmt_return del_stmt() throws RecognitionException {
		PythonParser.del_stmt_return retval = new PythonParser.del_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token DELETE116=null;
		ParserRuleReturnScope del_list117 =null;

		PythonTree DELETE116_tree=null;


		    stmt stype = null;

		try {
			// Python.g:916:5: ( DELETE del_list )
			// Python.g:916:7: DELETE del_list
			{
			root_0 = (PythonTree)adaptor.nil();


			DELETE116=(Token)match(input,DELETE,FOLLOW_DELETE_in_del_stmt2872); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DELETE116_tree = (PythonTree)adaptor.create(DELETE116);
			adaptor.addChild(root_0, DELETE116_tree);
			}

			pushFollow(FOLLOW_del_list_in_del_stmt2874);
			del_list117=del_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, del_list117.getTree());

			if ( state.backtracking==0 ) {
			          stype = new Delete(DELETE116, (del_list117!=null?((PythonParser.del_list_return)del_list117).etypes:null));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "del_stmt"


	public static class pass_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "pass_stmt"
	// Python.g:923:1: pass_stmt : PASS ;
	public final PythonParser.pass_stmt_return pass_stmt() throws RecognitionException {
		PythonParser.pass_stmt_return retval = new PythonParser.pass_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token PASS118=null;

		PythonTree PASS118_tree=null;


		    stmt stype = null;

		try {
			// Python.g:930:5: ( PASS )
			// Python.g:930:7: PASS
			{
			root_0 = (PythonTree)adaptor.nil();


			PASS118=(Token)match(input,PASS,FOLLOW_PASS_in_pass_stmt2910); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PASS118_tree = (PythonTree)adaptor.create(PASS118);
			adaptor.addChild(root_0, PASS118_tree);
			}

			if ( state.backtracking==0 ) {
			          stype = new Pass(PASS118);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pass_stmt"


	public static class flow_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "flow_stmt"
	// Python.g:937:1: flow_stmt : ( break_stmt | continue_stmt | return_stmt | raise_stmt | yield_stmt );
	public final PythonParser.flow_stmt_return flow_stmt() throws RecognitionException {
		PythonParser.flow_stmt_return retval = new PythonParser.flow_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope break_stmt119 =null;
		ParserRuleReturnScope continue_stmt120 =null;
		ParserRuleReturnScope return_stmt121 =null;
		ParserRuleReturnScope raise_stmt122 =null;
		ParserRuleReturnScope yield_stmt123 =null;


		try {
			// Python.g:938:5: ( break_stmt | continue_stmt | return_stmt | raise_stmt | yield_stmt )
			int alt60=5;
			switch ( input.LA(1) ) {
			case BREAK:
				{
				alt60=1;
				}
				break;
			case CONTINUE:
				{
				alt60=2;
				}
				break;
			case RETURN:
				{
				alt60=3;
				}
				break;
			case RAISE:
				{
				alt60=4;
				}
				break;
			case YIELD:
				{
				alt60=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}
			switch (alt60) {
				case 1 :
					// Python.g:938:7: break_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_break_stmt_in_flow_stmt2936);
					break_stmt119=break_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, break_stmt119.getTree());

					}
					break;
				case 2 :
					// Python.g:939:7: continue_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_continue_stmt_in_flow_stmt2944);
					continue_stmt120=continue_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, continue_stmt120.getTree());

					}
					break;
				case 3 :
					// Python.g:940:7: return_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_return_stmt_in_flow_stmt2952);
					return_stmt121=return_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, return_stmt121.getTree());

					}
					break;
				case 4 :
					// Python.g:941:7: raise_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_raise_stmt_in_flow_stmt2960);
					raise_stmt122=raise_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, raise_stmt122.getTree());

					}
					break;
				case 5 :
					// Python.g:942:7: yield_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_yield_stmt_in_flow_stmt2968);
					yield_stmt123=yield_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, yield_stmt123.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "flow_stmt"


	public static class break_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "break_stmt"
	// Python.g:946:1: break_stmt : BREAK ;
	public final PythonParser.break_stmt_return break_stmt() throws RecognitionException {
		PythonParser.break_stmt_return retval = new PythonParser.break_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token BREAK124=null;

		PythonTree BREAK124_tree=null;


		    stmt stype = null;

		try {
			// Python.g:953:5: ( BREAK )
			// Python.g:953:7: BREAK
			{
			root_0 = (PythonTree)adaptor.nil();


			BREAK124=(Token)match(input,BREAK,FOLLOW_BREAK_in_break_stmt2996); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BREAK124_tree = (PythonTree)adaptor.create(BREAK124);
			adaptor.addChild(root_0, BREAK124_tree);
			}

			if ( state.backtracking==0 ) {
			          stype = new Break(BREAK124);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "break_stmt"


	public static class continue_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "continue_stmt"
	// Python.g:960:1: continue_stmt : CONTINUE ;
	public final PythonParser.continue_stmt_return continue_stmt() throws RecognitionException {
		PythonParser.continue_stmt_return retval = new PythonParser.continue_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token CONTINUE125=null;

		PythonTree CONTINUE125_tree=null;


		    stmt stype = null;

		try {
			// Python.g:967:5: ( CONTINUE )
			// Python.g:967:7: CONTINUE
			{
			root_0 = (PythonTree)adaptor.nil();


			CONTINUE125=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_continue_stmt3032); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CONTINUE125_tree = (PythonTree)adaptor.create(CONTINUE125);
			adaptor.addChild(root_0, CONTINUE125_tree);
			}

			if ( state.backtracking==0 ) {
			          if (!suite_stack.isEmpty() && suite_stack.peek().continueIllegal) {
			              errorHandler.error("'continue' not supported inside 'finally' clause", new PythonTree((retval.start)));
			          }
			          stype = new Continue(CONTINUE125);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "continue_stmt"


	public static class return_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "return_stmt"
	// Python.g:977:1: return_stmt : RETURN ( testlist[expr_contextType.Load] |) ;
	public final PythonParser.return_stmt_return return_stmt() throws RecognitionException {
		PythonParser.return_stmt_return retval = new PythonParser.return_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token RETURN126=null;
		ParserRuleReturnScope testlist127 =null;

		PythonTree RETURN126_tree=null;


		    stmt stype = null;

		try {
			// Python.g:984:5: ( RETURN ( testlist[expr_contextType.Load] |) )
			// Python.g:984:7: RETURN ( testlist[expr_contextType.Load] |)
			{
			root_0 = (PythonTree)adaptor.nil();


			RETURN126=(Token)match(input,RETURN,FOLLOW_RETURN_in_return_stmt3068); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RETURN126_tree = (PythonTree)adaptor.create(RETURN126);
			adaptor.addChild(root_0, RETURN126_tree);
			}

			// Python.g:985:7: ( testlist[expr_contextType.Load] |)
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==AWAIT||LA61_0==COMPLEX||LA61_0==DOT||LA61_0==FLOAT||LA61_0==INT||(LA61_0 >= LAMBDA && LA61_0 <= LCURLY)||(LA61_0 >= LONGINT && LA61_0 <= MINUS)||LA61_0==NAME||LA61_0==NOT||LA61_0==PLUS||(LA61_0 >= STRING && LA61_0 <= TILDE)) ) {
				alt61=1;
			}
			else if ( (LA61_0==NEWLINE||LA61_0==SEMI) ) {
				alt61=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}

			switch (alt61) {
				case 1 :
					// Python.g:985:8: testlist[expr_contextType.Load]
					{
					pushFollow(FOLLOW_testlist_in_return_stmt3077);
					testlist127=testlist(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist127.getTree());

					if ( state.backtracking==0 ) {
					           stype = new Return(RETURN126, actions.castExpr((testlist127!=null?((PythonTree)testlist127.getTree()):null)));
					       }
					}
					break;
				case 2 :
					// Python.g:990:8: 
					{
					if ( state.backtracking==0 ) {
					           stype = new Return(RETURN126, null);
					       }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "return_stmt"


	public static class yield_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "yield_stmt"
	// Python.g:997:1: yield_stmt : yield_expr ;
	public final PythonParser.yield_stmt_return yield_stmt() throws RecognitionException {
		PythonParser.yield_stmt_return retval = new PythonParser.yield_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope yield_expr128 =null;



		    stmt stype = null;

		try {
			// Python.g:1004:5: ( yield_expr )
			// Python.g:1004:7: yield_expr
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_yield_expr_in_yield_stmt3142);
			yield_expr128=yield_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, yield_expr128.getTree());

			if ( state.backtracking==0 ) {
			        stype = new Expr((yield_expr128!=null?(yield_expr128.start):null), actions.castExpr((yield_expr128!=null?((PythonParser.yield_expr_return)yield_expr128).etype:null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "yield_stmt"


	public static class raise_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "raise_stmt"
	// Python.g:1011:1: raise_stmt : RAISE (t1= test[expr_contextType.Load] ( FROM t2= test[expr_contextType.Load] )? )? ;
	public final PythonParser.raise_stmt_return raise_stmt() throws RecognitionException {
		PythonParser.raise_stmt_return retval = new PythonParser.raise_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token RAISE129=null;
		Token FROM130=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		PythonTree RAISE129_tree=null;
		PythonTree FROM130_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1018:5: ( RAISE (t1= test[expr_contextType.Load] ( FROM t2= test[expr_contextType.Load] )? )? )
			// Python.g:1018:7: RAISE (t1= test[expr_contextType.Load] ( FROM t2= test[expr_contextType.Load] )? )?
			{
			root_0 = (PythonTree)adaptor.nil();


			RAISE129=(Token)match(input,RAISE,FOLLOW_RAISE_in_raise_stmt3178); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RAISE129_tree = (PythonTree)adaptor.create(RAISE129);
			adaptor.addChild(root_0, RAISE129_tree);
			}

			// Python.g:1018:13: (t1= test[expr_contextType.Load] ( FROM t2= test[expr_contextType.Load] )? )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==AWAIT||LA63_0==COMPLEX||LA63_0==DOT||LA63_0==FLOAT||LA63_0==INT||(LA63_0 >= LAMBDA && LA63_0 <= LCURLY)||(LA63_0 >= LONGINT && LA63_0 <= MINUS)||LA63_0==NAME||LA63_0==NOT||LA63_0==PLUS||(LA63_0 >= STRING && LA63_0 <= TILDE)) ) {
				alt63=1;
			}
			switch (alt63) {
				case 1 :
					// Python.g:1018:14: t1= test[expr_contextType.Load] ( FROM t2= test[expr_contextType.Load] )?
					{
					pushFollow(FOLLOW_test_in_raise_stmt3183);
					t1=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());

					// Python.g:1018:45: ( FROM t2= test[expr_contextType.Load] )?
					int alt62=2;
					int LA62_0 = input.LA(1);
					if ( (LA62_0==FROM) ) {
						alt62=1;
					}
					switch (alt62) {
						case 1 :
							// Python.g:1018:46: FROM t2= test[expr_contextType.Load]
							{
							FROM130=(Token)match(input,FROM,FOLLOW_FROM_in_raise_stmt3187); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							FROM130_tree = (PythonTree)adaptor.create(FROM130);
							adaptor.addChild(root_0, FROM130_tree);
							}

							pushFollow(FOLLOW_test_in_raise_stmt3191);
							t2=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, t2.getTree());

							}
							break;

					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			        stype = new Raise(RAISE129, actions.castExpr((t1!=null?((PythonTree)t1.getTree()):null)), actions.castExpr((t2!=null?((PythonTree)t2.getTree()):null)));
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "raise_stmt"


	public static class import_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "import_stmt"
	// Python.g:1025:1: import_stmt : ( import_name | import_from );
	public final PythonParser.import_stmt_return import_stmt() throws RecognitionException {
		PythonParser.import_stmt_return retval = new PythonParser.import_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope import_name131 =null;
		ParserRuleReturnScope import_from132 =null;


		try {
			// Python.g:1026:5: ( import_name | import_from )
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==IMPORT) ) {
				alt64=1;
			}
			else if ( (LA64_0==FROM) ) {
				alt64=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}

			switch (alt64) {
				case 1 :
					// Python.g:1026:7: import_name
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_import_name_in_import_stmt3220);
					import_name131=import_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, import_name131.getTree());

					}
					break;
				case 2 :
					// Python.g:1027:7: import_from
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_import_from_in_import_stmt3228);
					import_from132=import_from();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, import_from132.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_stmt"


	public static class import_name_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "import_name"
	// Python.g:1031:1: import_name : IMPORT dotted_as_names ;
	public final PythonParser.import_name_return import_name() throws RecognitionException {
		PythonParser.import_name_return retval = new PythonParser.import_name_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token IMPORT133=null;
		ParserRuleReturnScope dotted_as_names134 =null;

		PythonTree IMPORT133_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1038:5: ( IMPORT dotted_as_names )
			// Python.g:1038:7: IMPORT dotted_as_names
			{
			root_0 = (PythonTree)adaptor.nil();


			IMPORT133=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_import_name3256); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IMPORT133_tree = (PythonTree)adaptor.create(IMPORT133);
			adaptor.addChild(root_0, IMPORT133_tree);
			}

			pushFollow(FOLLOW_dotted_as_names_in_import_name3258);
			dotted_as_names134=dotted_as_names();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dotted_as_names134.getTree());

			if ( state.backtracking==0 ) {
			          stype = new Import(IMPORT133, (dotted_as_names134!=null?((PythonParser.dotted_as_names_return)dotted_as_names134).atypes:null));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_name"


	public static class import_from_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "import_from"
	// Python.g:1046:1: import_from : FROM ( (d+= DOT )* dotted_name | (d+= DOT )+ ) IMPORT ( STAR |i1= import_as_names | LPAREN i2= import_as_names ( COMMA )? RPAREN ) ;
	public final PythonParser.import_from_return import_from() throws RecognitionException {
		PythonParser.import_from_return retval = new PythonParser.import_from_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token FROM135=null;
		Token IMPORT137=null;
		Token STAR138=null;
		Token LPAREN139=null;
		Token COMMA140=null;
		Token RPAREN141=null;
		Token d=null;
		List<Object> list_d=null;
		ParserRuleReturnScope i1 =null;
		ParserRuleReturnScope i2 =null;
		ParserRuleReturnScope dotted_name136 =null;

		PythonTree FROM135_tree=null;
		PythonTree IMPORT137_tree=null;
		PythonTree STAR138_tree=null;
		PythonTree LPAREN139_tree=null;
		PythonTree COMMA140_tree=null;
		PythonTree RPAREN141_tree=null;
		PythonTree d_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1053:5: ( FROM ( (d+= DOT )* dotted_name | (d+= DOT )+ ) IMPORT ( STAR |i1= import_as_names | LPAREN i2= import_as_names ( COMMA )? RPAREN ) )
			// Python.g:1053:7: FROM ( (d+= DOT )* dotted_name | (d+= DOT )+ ) IMPORT ( STAR |i1= import_as_names | LPAREN i2= import_as_names ( COMMA )? RPAREN )
			{
			root_0 = (PythonTree)adaptor.nil();


			FROM135=(Token)match(input,FROM,FOLLOW_FROM_in_import_from3295); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FROM135_tree = (PythonTree)adaptor.create(FROM135);
			adaptor.addChild(root_0, FROM135_tree);
			}

			// Python.g:1053:12: ( (d+= DOT )* dotted_name | (d+= DOT )+ )
			int alt67=2;
			alt67 = dfa67.predict(input);
			switch (alt67) {
				case 1 :
					// Python.g:1053:13: (d+= DOT )* dotted_name
					{
					// Python.g:1053:14: (d+= DOT )*
					loop65:
					while (true) {
						int alt65=2;
						int LA65_0 = input.LA(1);
						if ( (LA65_0==DOT) ) {
							alt65=1;
						}

						switch (alt65) {
						case 1 :
							// Python.g:1053:14: d+= DOT
							{
							d=(Token)match(input,DOT,FOLLOW_DOT_in_import_from3300); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							d_tree = (PythonTree)adaptor.create(d);
							adaptor.addChild(root_0, d_tree);
							}

							if (list_d==null) list_d=new ArrayList<Object>();
							list_d.add(d);
							}
							break;

						default :
							break loop65;
						}
					}

					pushFollow(FOLLOW_dotted_name_in_import_from3303);
					dotted_name136=dotted_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dotted_name136.getTree());

					}
					break;
				case 2 :
					// Python.g:1053:35: (d+= DOT )+
					{
					// Python.g:1053:36: (d+= DOT )+
					int cnt66=0;
					loop66:
					while (true) {
						int alt66=2;
						int LA66_0 = input.LA(1);
						if ( (LA66_0==DOT) ) {
							alt66=1;
						}

						switch (alt66) {
						case 1 :
							// Python.g:1053:36: d+= DOT
							{
							d=(Token)match(input,DOT,FOLLOW_DOT_in_import_from3309); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							d_tree = (PythonTree)adaptor.create(d);
							adaptor.addChild(root_0, d_tree);
							}

							if (list_d==null) list_d=new ArrayList<Object>();
							list_d.add(d);
							}
							break;

						default :
							if ( cnt66 >= 1 ) break loop66;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(66, input);
							throw eee;
						}
						cnt66++;
					}

					}
					break;

			}

			IMPORT137=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_import_from3313); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IMPORT137_tree = (PythonTree)adaptor.create(IMPORT137);
			adaptor.addChild(root_0, IMPORT137_tree);
			}

			// Python.g:1054:9: ( STAR |i1= import_as_names | LPAREN i2= import_as_names ( COMMA )? RPAREN )
			int alt69=3;
			switch ( input.LA(1) ) {
			case STAR:
				{
				alt69=1;
				}
				break;
			case NAME:
				{
				alt69=2;
				}
				break;
			case LPAREN:
				{
				alt69=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}
			switch (alt69) {
				case 1 :
					// Python.g:1054:10: STAR
					{
					STAR138=(Token)match(input,STAR,FOLLOW_STAR_in_import_from3324); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR138_tree = (PythonTree)adaptor.create(STAR138);
					adaptor.addChild(root_0, STAR138_tree);
					}

					if ( state.backtracking==0 ) {
					             stype = new ImportFrom(FROM135, actions.makeFromText(list_d, (dotted_name136!=null?((PythonParser.dotted_name_return)dotted_name136).names:null)),
					                 actions.makeModuleNameNode(list_d, (dotted_name136!=null?((PythonParser.dotted_name_return)dotted_name136).names:null)),
					                 actions.makeStarAlias(STAR138), actions.makeLevel(list_d));
					         }
					}
					break;
				case 2 :
					// Python.g:1060:11: i1= import_as_names
					{
					pushFollow(FOLLOW_import_as_names_in_import_from3349);
					i1=import_as_names();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, i1.getTree());

					if ( state.backtracking==0 ) {
					             String dottedText = (dotted_name136!=null?input.toString(dotted_name136.start,dotted_name136.stop):null);
					             if (dottedText != null && dottedText.equals("__future__")) {
					                 List<alias> aliases = (i1!=null?((PythonParser.import_as_names_return)i1).atypes:null);
					                 for(alias a: aliases) {
					                     if (a != null) {
					                         if (a.getInternalName().equals("print_function")) {
					                             printFunction = true;
					                         } else if (a.getInternalName().equals("unicode_literals")) {
					                             unicodeLiterals = true;
					                         }
					                     }
					                 }
					             }
					             stype = new ImportFrom(FROM135, actions.makeFromText(list_d, (dotted_name136!=null?((PythonParser.dotted_name_return)dotted_name136).names:null)),
					                 actions.makeModuleNameNode(list_d, (dotted_name136!=null?((PythonParser.dotted_name_return)dotted_name136).names:null)),
					                 actions.makeAliases((i1!=null?((PythonParser.import_as_names_return)i1).atypes:null)), actions.makeLevel(list_d));
					         }
					}
					break;
				case 3 :
					// Python.g:1079:11: LPAREN i2= import_as_names ( COMMA )? RPAREN
					{
					LPAREN139=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_import_from3372); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LPAREN139_tree = (PythonTree)adaptor.create(LPAREN139);
					adaptor.addChild(root_0, LPAREN139_tree);
					}

					pushFollow(FOLLOW_import_as_names_in_import_from3376);
					i2=import_as_names();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, i2.getTree());

					// Python.g:1079:37: ( COMMA )?
					int alt68=2;
					int LA68_0 = input.LA(1);
					if ( (LA68_0==COMMA) ) {
						alt68=1;
					}
					switch (alt68) {
						case 1 :
							// Python.g:1079:37: COMMA
							{
							COMMA140=(Token)match(input,COMMA,FOLLOW_COMMA_in_import_from3378); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA140_tree = (PythonTree)adaptor.create(COMMA140);
							adaptor.addChild(root_0, COMMA140_tree);
							}

							}
							break;

					}

					RPAREN141=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_import_from3381); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RPAREN141_tree = (PythonTree)adaptor.create(RPAREN141);
					adaptor.addChild(root_0, RPAREN141_tree);
					}

					if ( state.backtracking==0 ) {
					             //XXX: this is almost a complete C&P of the code above - is there some way
					             //     to factor it out?
					             String dottedText = (dotted_name136!=null?input.toString(dotted_name136.start,dotted_name136.stop):null);
					             if (dottedText != null && dottedText.equals("__future__")) {
					                 List<alias> aliases = (i2!=null?((PythonParser.import_as_names_return)i2).atypes:null);
					                 for(alias a: aliases) {
					                     if (a != null) {
					                         if (a.getInternalName().equals("print_function")) {
					                             printFunction = true;
					                         } else if (a.getInternalName().equals("unicode_literals")) {
					                             unicodeLiterals = true;
					                         }
					                     }
					                 }
					             }
					             stype = new ImportFrom(FROM135, actions.makeFromText(list_d, (dotted_name136!=null?((PythonParser.dotted_name_return)dotted_name136).names:null)),
					                 actions.makeModuleNameNode(list_d, (dotted_name136!=null?((PythonParser.dotted_name_return)dotted_name136).names:null)),
					                 actions.makeAliases((i2!=null?((PythonParser.import_as_names_return)i2).atypes:null)), actions.makeLevel(list_d));
					         }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_from"


	public static class import_as_names_return extends ParserRuleReturnScope {
		public List<alias> atypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "import_as_names"
	// Python.g:1104:1: import_as_names returns [List<alias> atypes] :n+= import_as_name ( COMMA !n+= import_as_name )* ;
	public final PythonParser.import_as_names_return import_as_names() throws RecognitionException {
		PythonParser.import_as_names_return retval = new PythonParser.import_as_names_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA142=null;
		List<Object> list_n=null;
		RuleReturnScope n = null;
		PythonTree COMMA142_tree=null;

		try {
			// Python.g:1106:5: (n+= import_as_name ( COMMA !n+= import_as_name )* )
			// Python.g:1106:7: n+= import_as_name ( COMMA !n+= import_as_name )*
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_import_as_name_in_import_as_names3430);
			n=import_as_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, n.getTree());

			if (list_n==null) list_n=new ArrayList<Object>();
			list_n.add(n.getTree());
			// Python.g:1106:25: ( COMMA !n+= import_as_name )*
			loop70:
			while (true) {
				int alt70=2;
				int LA70_0 = input.LA(1);
				if ( (LA70_0==COMMA) ) {
					int LA70_2 = input.LA(2);
					if ( (LA70_2==NAME) ) {
						alt70=1;
					}

				}

				switch (alt70) {
				case 1 :
					// Python.g:1106:26: COMMA !n+= import_as_name
					{
					COMMA142=(Token)match(input,COMMA,FOLLOW_COMMA_in_import_as_names3433); if (state.failed) return retval;
					pushFollow(FOLLOW_import_as_name_in_import_as_names3438);
					n=import_as_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, n.getTree());

					if (list_n==null) list_n=new ArrayList<Object>();
					list_n.add(n.getTree());
					}
					break;

				default :
					break loop70;
				}
			}

			if ( state.backtracking==0 ) {
			        retval.atypes =  (List<alias>)(List<?>)list_n;
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_as_names"


	public static class import_as_name_return extends ParserRuleReturnScope {
		public alias atype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "import_as_name"
	// Python.g:1113:1: import_as_name returns [alias atype] : name= NAME ( AS asname= NAME )? ;
	public final PythonParser.import_as_name_return import_as_name() throws RecognitionException {
		PythonParser.import_as_name_return retval = new PythonParser.import_as_name_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token name=null;
		Token asname=null;
		Token AS143=null;

		PythonTree name_tree=null;
		PythonTree asname_tree=null;
		PythonTree AS143_tree=null;

		try {
			// Python.g:1118:5: (name= NAME ( AS asname= NAME )? )
			// Python.g:1118:7: name= NAME ( AS asname= NAME )?
			{
			root_0 = (PythonTree)adaptor.nil();


			name=(Token)match(input,NAME,FOLLOW_NAME_in_import_as_name3479); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			name_tree = (PythonTree)adaptor.create(name);
			adaptor.addChild(root_0, name_tree);
			}

			// Python.g:1118:17: ( AS asname= NAME )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==AS) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// Python.g:1118:18: AS asname= NAME
					{
					AS143=(Token)match(input,AS,FOLLOW_AS_in_import_as_name3482); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS143_tree = (PythonTree)adaptor.create(AS143);
					adaptor.addChild(root_0, AS143_tree);
					}

					asname=(Token)match(input,NAME,FOLLOW_NAME_in_import_as_name3486); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					asname_tree = (PythonTree)adaptor.create(asname);
					adaptor.addChild(root_0, asname_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			        retval.atype = new alias(actions.makeNameNode(name), actions.makeNameNode(asname));
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.atype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_as_name"


	public static class dotted_as_name_return extends ParserRuleReturnScope {
		public alias atype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "dotted_as_name"
	// Python.g:1126:1: dotted_as_name returns [alias atype] : dotted_name ( AS asname= NAME )? ;
	public final PythonParser.dotted_as_name_return dotted_as_name() throws RecognitionException {
		PythonParser.dotted_as_name_return retval = new PythonParser.dotted_as_name_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token asname=null;
		Token AS145=null;
		ParserRuleReturnScope dotted_name144 =null;

		PythonTree asname_tree=null;
		PythonTree AS145_tree=null;

		try {
			// Python.g:1131:5: ( dotted_name ( AS asname= NAME )? )
			// Python.g:1131:7: dotted_name ( AS asname= NAME )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_dotted_name_in_dotted_as_name3526);
			dotted_name144=dotted_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dotted_name144.getTree());

			// Python.g:1131:19: ( AS asname= NAME )?
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==AS) ) {
				alt72=1;
			}
			switch (alt72) {
				case 1 :
					// Python.g:1131:20: AS asname= NAME
					{
					AS145=(Token)match(input,AS,FOLLOW_AS_in_dotted_as_name3529); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS145_tree = (PythonTree)adaptor.create(AS145);
					adaptor.addChild(root_0, AS145_tree);
					}

					asname=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_as_name3533); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					asname_tree = (PythonTree)adaptor.create(asname);
					adaptor.addChild(root_0, asname_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			        retval.atype = new alias((dotted_name144!=null?((PythonParser.dotted_name_return)dotted_name144).names:null), actions.makeNameNode(asname));
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.atype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dotted_as_name"


	public static class dotted_as_names_return extends ParserRuleReturnScope {
		public List<alias> atypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "dotted_as_names"
	// Python.g:1138:1: dotted_as_names returns [List<alias> atypes] :d+= dotted_as_name ( COMMA !d+= dotted_as_name )* ;
	public final PythonParser.dotted_as_names_return dotted_as_names() throws RecognitionException {
		PythonParser.dotted_as_names_return retval = new PythonParser.dotted_as_names_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA146=null;
		List<Object> list_d=null;
		RuleReturnScope d = null;
		PythonTree COMMA146_tree=null;

		try {
			// Python.g:1140:5: (d+= dotted_as_name ( COMMA !d+= dotted_as_name )* )
			// Python.g:1140:7: d+= dotted_as_name ( COMMA !d+= dotted_as_name )*
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_dotted_as_name_in_dotted_as_names3569);
			d=dotted_as_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

			if (list_d==null) list_d=new ArrayList<Object>();
			list_d.add(d.getTree());
			// Python.g:1140:25: ( COMMA !d+= dotted_as_name )*
			loop73:
			while (true) {
				int alt73=2;
				int LA73_0 = input.LA(1);
				if ( (LA73_0==COMMA) ) {
					alt73=1;
				}

				switch (alt73) {
				case 1 :
					// Python.g:1140:26: COMMA !d+= dotted_as_name
					{
					COMMA146=(Token)match(input,COMMA,FOLLOW_COMMA_in_dotted_as_names3572); if (state.failed) return retval;
					pushFollow(FOLLOW_dotted_as_name_in_dotted_as_names3577);
					d=dotted_as_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

					if (list_d==null) list_d=new ArrayList<Object>();
					list_d.add(d.getTree());
					}
					break;

				default :
					break loop73;
				}
			}

			if ( state.backtracking==0 ) {
			        retval.atypes = (List<alias>)(List<?>)list_d;
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dotted_as_names"


	public static class dotted_name_return extends ParserRuleReturnScope {
		public List<Name> names;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "dotted_name"
	// Python.g:1147:1: dotted_name returns [List<Name> names] : NAME ( DOT dn+= attr )* ;
	public final PythonParser.dotted_name_return dotted_name() throws RecognitionException {
		PythonParser.dotted_name_return retval = new PythonParser.dotted_name_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NAME147=null;
		Token DOT148=null;
		List<Object> list_dn=null;
		RuleReturnScope dn = null;
		PythonTree NAME147_tree=null;
		PythonTree DOT148_tree=null;

		try {
			// Python.g:1149:5: ( NAME ( DOT dn+= attr )* )
			// Python.g:1149:7: NAME ( DOT dn+= attr )*
			{
			root_0 = (PythonTree)adaptor.nil();


			NAME147=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_name3611); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME147_tree = (PythonTree)adaptor.create(NAME147);
			adaptor.addChild(root_0, NAME147_tree);
			}

			// Python.g:1149:12: ( DOT dn+= attr )*
			loop74:
			while (true) {
				int alt74=2;
				int LA74_0 = input.LA(1);
				if ( (LA74_0==DOT) ) {
					alt74=1;
				}

				switch (alt74) {
				case 1 :
					// Python.g:1149:13: DOT dn+= attr
					{
					DOT148=(Token)match(input,DOT,FOLLOW_DOT_in_dotted_name3614); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOT148_tree = (PythonTree)adaptor.create(DOT148);
					adaptor.addChild(root_0, DOT148_tree);
					}

					pushFollow(FOLLOW_attr_in_dotted_name3618);
					dn=attr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dn.getTree());

					if (list_dn==null) list_dn=new ArrayList<Object>();
					list_dn.add(dn.getTree());
					}
					break;

				default :
					break loop74;
				}
			}

			if ( state.backtracking==0 ) {
			        retval.names = actions.makeDottedName(NAME147,  (List<PythonTree>)(List<?>)list_dn);
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dotted_name"


	public static class global_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "global_stmt"
	// Python.g:1156:1: global_stmt : GLOBAL n+= NAME ( COMMA n+= NAME )* ;
	public final PythonParser.global_stmt_return global_stmt() throws RecognitionException {
		PythonParser.global_stmt_return retval = new PythonParser.global_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token GLOBAL149=null;
		Token COMMA150=null;
		Token n=null;
		List<Object> list_n=null;

		PythonTree GLOBAL149_tree=null;
		PythonTree COMMA150_tree=null;
		PythonTree n_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1163:5: ( GLOBAL n+= NAME ( COMMA n+= NAME )* )
			// Python.g:1163:7: GLOBAL n+= NAME ( COMMA n+= NAME )*
			{
			root_0 = (PythonTree)adaptor.nil();


			GLOBAL149=(Token)match(input,GLOBAL,FOLLOW_GLOBAL_in_global_stmt3654); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			GLOBAL149_tree = (PythonTree)adaptor.create(GLOBAL149);
			adaptor.addChild(root_0, GLOBAL149_tree);
			}

			n=(Token)match(input,NAME,FOLLOW_NAME_in_global_stmt3658); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			n_tree = (PythonTree)adaptor.create(n);
			adaptor.addChild(root_0, n_tree);
			}

			if (list_n==null) list_n=new ArrayList<Object>();
			list_n.add(n);
			// Python.g:1163:22: ( COMMA n+= NAME )*
			loop75:
			while (true) {
				int alt75=2;
				int LA75_0 = input.LA(1);
				if ( (LA75_0==COMMA) ) {
					alt75=1;
				}

				switch (alt75) {
				case 1 :
					// Python.g:1163:23: COMMA n+= NAME
					{
					COMMA150=(Token)match(input,COMMA,FOLLOW_COMMA_in_global_stmt3661); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA150_tree = (PythonTree)adaptor.create(COMMA150);
					adaptor.addChild(root_0, COMMA150_tree);
					}

					n=(Token)match(input,NAME,FOLLOW_NAME_in_global_stmt3665); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					n_tree = (PythonTree)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
					}

					if (list_n==null) list_n=new ArrayList<Object>();
					list_n.add(n);
					}
					break;

				default :
					break loop75;
				}
			}

			if ( state.backtracking==0 ) {
			          stype = new Global(GLOBAL149, actions.makeNames(list_n), actions.makeNameNodes( (List<Token>)(List<?>)list_n));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "global_stmt"


	public static class nonlocal_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "nonlocal_stmt"
	// Python.g:1170:1: nonlocal_stmt : NONLOCAL n+= NAME ( COMMA n+= NAME )* ;
	public final PythonParser.nonlocal_stmt_return nonlocal_stmt() throws RecognitionException {
		PythonParser.nonlocal_stmt_return retval = new PythonParser.nonlocal_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NONLOCAL151=null;
		Token COMMA152=null;
		Token n=null;
		List<Object> list_n=null;

		PythonTree NONLOCAL151_tree=null;
		PythonTree COMMA152_tree=null;
		PythonTree n_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1177:5: ( NONLOCAL n+= NAME ( COMMA n+= NAME )* )
			// Python.g:1177:7: NONLOCAL n+= NAME ( COMMA n+= NAME )*
			{
			root_0 = (PythonTree)adaptor.nil();


			NONLOCAL151=(Token)match(input,NONLOCAL,FOLLOW_NONLOCAL_in_nonlocal_stmt3703); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NONLOCAL151_tree = (PythonTree)adaptor.create(NONLOCAL151);
			adaptor.addChild(root_0, NONLOCAL151_tree);
			}

			n=(Token)match(input,NAME,FOLLOW_NAME_in_nonlocal_stmt3707); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			n_tree = (PythonTree)adaptor.create(n);
			adaptor.addChild(root_0, n_tree);
			}

			if (list_n==null) list_n=new ArrayList<Object>();
			list_n.add(n);
			// Python.g:1177:24: ( COMMA n+= NAME )*
			loop76:
			while (true) {
				int alt76=2;
				int LA76_0 = input.LA(1);
				if ( (LA76_0==COMMA) ) {
					alt76=1;
				}

				switch (alt76) {
				case 1 :
					// Python.g:1177:25: COMMA n+= NAME
					{
					COMMA152=(Token)match(input,COMMA,FOLLOW_COMMA_in_nonlocal_stmt3710); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA152_tree = (PythonTree)adaptor.create(COMMA152);
					adaptor.addChild(root_0, COMMA152_tree);
					}

					n=(Token)match(input,NAME,FOLLOW_NAME_in_nonlocal_stmt3714); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					n_tree = (PythonTree)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
					}

					if (list_n==null) list_n=new ArrayList<Object>();
					list_n.add(n);
					}
					break;

				default :
					break loop76;
				}
			}

			if ( state.backtracking==0 ) {
			          stype = new Nonlocal(NONLOCAL151, actions.makeNames(list_n), actions.makeNameNodes( (List<Token>)(List<?>)list_n));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nonlocal_stmt"


	public static class assert_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "assert_stmt"
	// Python.g:1184:1: assert_stmt : ASSERT t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? ;
	public final PythonParser.assert_stmt_return assert_stmt() throws RecognitionException {
		PythonParser.assert_stmt_return retval = new PythonParser.assert_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ASSERT153=null;
		Token COMMA154=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		PythonTree ASSERT153_tree=null;
		PythonTree COMMA154_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1191:5: ( ASSERT t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? )
			// Python.g:1191:7: ASSERT t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			ASSERT153=(Token)match(input,ASSERT,FOLLOW_ASSERT_in_assert_stmt3752); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSERT153_tree = (PythonTree)adaptor.create(ASSERT153);
			adaptor.addChild(root_0, ASSERT153_tree);
			}

			pushFollow(FOLLOW_test_in_assert_stmt3756);
			t1=test(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());

			// Python.g:1191:45: ( COMMA t2= test[expr_contextType.Load] )?
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==COMMA) ) {
				alt77=1;
			}
			switch (alt77) {
				case 1 :
					// Python.g:1191:46: COMMA t2= test[expr_contextType.Load]
					{
					COMMA154=(Token)match(input,COMMA,FOLLOW_COMMA_in_assert_stmt3760); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA154_tree = (PythonTree)adaptor.create(COMMA154);
					adaptor.addChild(root_0, COMMA154_tree);
					}

					pushFollow(FOLLOW_test_in_assert_stmt3764);
					t2=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t2.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          stype = new Assert(ASSERT153, actions.castExpr((t1!=null?((PythonTree)t1.getTree()):null)), actions.castExpr((t2!=null?((PythonTree)t2.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assert_stmt"


	public static class compound_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "compound_stmt"
	// Python.g:1198:1: compound_stmt : ( if_stmt | while_stmt | for_stmt | try_stmt | with_stmt | funcdef | classdef | decorated | async_stmt );
	public final PythonParser.compound_stmt_return compound_stmt() throws RecognitionException {
		PythonParser.compound_stmt_return retval = new PythonParser.compound_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope if_stmt155 =null;
		ParserRuleReturnScope while_stmt156 =null;
		ParserRuleReturnScope for_stmt157 =null;
		ParserRuleReturnScope try_stmt158 =null;
		ParserRuleReturnScope with_stmt159 =null;
		ParserRuleReturnScope funcdef160 =null;
		ParserRuleReturnScope classdef161 =null;
		ParserRuleReturnScope decorated162 =null;
		ParserRuleReturnScope async_stmt163 =null;


		try {
			// Python.g:1199:5: ( if_stmt | while_stmt | for_stmt | try_stmt | with_stmt | funcdef | classdef | decorated | async_stmt )
			int alt78=9;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt78=1;
				}
				break;
			case WHILE:
				{
				alt78=2;
				}
				break;
			case FOR:
				{
				alt78=3;
				}
				break;
			case TRY:
				{
				alt78=4;
				}
				break;
			case WITH:
				{
				alt78=5;
				}
				break;
			case DEF:
				{
				alt78=6;
				}
				break;
			case CLASS:
				{
				alt78=7;
				}
				break;
			case AT:
				{
				alt78=8;
				}
				break;
			case ASYNC:
				{
				alt78=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}
			switch (alt78) {
				case 1 :
					// Python.g:1199:7: if_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_if_stmt_in_compound_stmt3793);
					if_stmt155=if_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stmt155.getTree());

					}
					break;
				case 2 :
					// Python.g:1200:7: while_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_while_stmt_in_compound_stmt3801);
					while_stmt156=while_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stmt156.getTree());

					}
					break;
				case 3 :
					// Python.g:1201:7: for_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_for_stmt_in_compound_stmt3809);
					for_stmt157=for_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stmt157.getTree());

					}
					break;
				case 4 :
					// Python.g:1202:7: try_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_try_stmt_in_compound_stmt3817);
					try_stmt158=try_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, try_stmt158.getTree());

					}
					break;
				case 5 :
					// Python.g:1203:7: with_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_with_stmt_in_compound_stmt3825);
					with_stmt159=with_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, with_stmt159.getTree());

					}
					break;
				case 6 :
					// Python.g:1204:7: funcdef
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_funcdef_in_compound_stmt3833);
					funcdef160=funcdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, funcdef160.getTree());

					}
					break;
				case 7 :
					// Python.g:1205:7: classdef
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_classdef_in_compound_stmt3841);
					classdef161=classdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, classdef161.getTree());

					}
					break;
				case 8 :
					// Python.g:1206:7: decorated
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_decorated_in_compound_stmt3849);
					decorated162=decorated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, decorated162.getTree());

					}
					break;
				case 9 :
					// Python.g:1207:7: async_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_async_stmt_in_compound_stmt3857);
					async_stmt163=async_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, async_stmt163.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compound_stmt"


	public static class async_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "async_stmt"
	// Python.g:1211:1: async_stmt : ASYNC ( funcdef | with_stmt | for_stmt ) ;
	public final PythonParser.async_stmt_return async_stmt() throws RecognitionException {
		PythonParser.async_stmt_return retval = new PythonParser.async_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ASYNC164=null;
		ParserRuleReturnScope funcdef165 =null;
		ParserRuleReturnScope with_stmt166 =null;
		ParserRuleReturnScope for_stmt167 =null;

		PythonTree ASYNC164_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1218:5: ( ASYNC ( funcdef | with_stmt | for_stmt ) )
			// Python.g:1218:7: ASYNC ( funcdef | with_stmt | for_stmt )
			{
			root_0 = (PythonTree)adaptor.nil();


			ASYNC164=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_async_stmt3885); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASYNC164_tree = (PythonTree)adaptor.create(ASYNC164);
			adaptor.addChild(root_0, ASYNC164_tree);
			}

			// Python.g:1219:9: ( funcdef | with_stmt | for_stmt )
			int alt79=3;
			switch ( input.LA(1) ) {
			case DEF:
				{
				alt79=1;
				}
				break;
			case WITH:
				{
				alt79=2;
				}
				break;
			case FOR:
				{
				alt79=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 79, 0, input);
				throw nvae;
			}
			switch (alt79) {
				case 1 :
					// Python.g:1219:11: funcdef
					{
					pushFollow(FOLLOW_funcdef_in_async_stmt3897);
					funcdef165=funcdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, funcdef165.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.makeAsyncFuncdef(ASYNC164, (funcdef165!=null?((PythonTree)funcdef165.getTree()):null));
					        }
					}
					break;
				case 2 :
					// Python.g:1223:11: with_stmt
					{
					pushFollow(FOLLOW_with_stmt_in_async_stmt3919);
					with_stmt166=with_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, with_stmt166.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.makeAsyncWith(ASYNC164, (with_stmt166!=null?((PythonParser.with_stmt_return)with_stmt166).items:null), (with_stmt166!=null?((PythonParser.with_stmt_return)with_stmt166).stypes:null));
					        }
					}
					break;
				case 3 :
					// Python.g:1227:11: for_stmt
					{
					pushFollow(FOLLOW_for_stmt_in_async_stmt3941);
					for_stmt167=for_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stmt167.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.makeAsyncFor(ASYNC164, (for_stmt167!=null?((PythonTree)for_stmt167.getTree()):null));
					        }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "async_stmt"


	public static class if_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "if_stmt"
	// Python.g:1235:1: if_stmt : IF test[expr_contextType.Load] COLON ifsuite= suite[false] ( elif_clause )? ;
	public final PythonParser.if_stmt_return if_stmt() throws RecognitionException {
		PythonParser.if_stmt_return retval = new PythonParser.if_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token IF168=null;
		Token COLON170=null;
		ParserRuleReturnScope ifsuite =null;
		ParserRuleReturnScope test169 =null;
		ParserRuleReturnScope elif_clause171 =null;

		PythonTree IF168_tree=null;
		PythonTree COLON170_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1242:5: ( IF test[expr_contextType.Load] COLON ifsuite= suite[false] ( elif_clause )? )
			// Python.g:1242:7: IF test[expr_contextType.Load] COLON ifsuite= suite[false] ( elif_clause )?
			{
			root_0 = (PythonTree)adaptor.nil();


			IF168=(Token)match(input,IF,FOLLOW_IF_in_if_stmt3989); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IF168_tree = (PythonTree)adaptor.create(IF168);
			adaptor.addChild(root_0, IF168_tree);
			}

			pushFollow(FOLLOW_test_in_if_stmt3991);
			test169=test(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, test169.getTree());

			COLON170=(Token)match(input,COLON,FOLLOW_COLON_in_if_stmt3994); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON170_tree = (PythonTree)adaptor.create(COLON170);
			adaptor.addChild(root_0, COLON170_tree);
			}

			pushFollow(FOLLOW_suite_in_if_stmt3998);
			ifsuite=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ifsuite.getTree());

			// Python.g:1242:65: ( elif_clause )?
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==ELIF||LA80_0==ORELSE) ) {
				alt80=1;
			}
			switch (alt80) {
				case 1 :
					// Python.g:1242:65: elif_clause
					{
					pushFollow(FOLLOW_elif_clause_in_if_stmt4001);
					elif_clause171=elif_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, elif_clause171.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          stype = new If(IF168, actions.castExpr((test169!=null?((PythonTree)test169.getTree()):null)), actions.castStmts((ifsuite!=null?((PythonParser.suite_return)ifsuite).stypes:null)),
			              actions.makeElse((elif_clause171!=null?((PythonParser.elif_clause_return)elif_clause171).stypes:null), (elif_clause171!=null?((PythonTree)elif_clause171.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_stmt"


	public static class elif_clause_return extends ParserRuleReturnScope {
		public List stypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "elif_clause"
	// Python.g:1250:1: elif_clause returns [List stypes] : ( else_clause | ELIF test[expr_contextType.Load] COLON suite[false] (e2= elif_clause |) );
	public final PythonParser.elif_clause_return elif_clause() throws RecognitionException {
		PythonParser.elif_clause_return retval = new PythonParser.elif_clause_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ELIF173=null;
		Token COLON175=null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope else_clause172 =null;
		ParserRuleReturnScope test174 =null;
		ParserRuleReturnScope suite176 =null;

		PythonTree ELIF173_tree=null;
		PythonTree COLON175_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1260:5: ( else_clause | ELIF test[expr_contextType.Load] COLON suite[false] (e2= elif_clause |) )
			int alt82=2;
			int LA82_0 = input.LA(1);
			if ( (LA82_0==ORELSE) ) {
				alt82=1;
			}
			else if ( (LA82_0==ELIF) ) {
				alt82=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 82, 0, input);
				throw nvae;
			}

			switch (alt82) {
				case 1 :
					// Python.g:1260:7: else_clause
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_else_clause_in_elif_clause4046);
					else_clause172=else_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, else_clause172.getTree());

					if ( state.backtracking==0 ) {
					          retval.stypes = (else_clause172!=null?((PythonParser.else_clause_return)else_clause172).stypes:null);
					      }
					}
					break;
				case 2 :
					// Python.g:1264:7: ELIF test[expr_contextType.Load] COLON suite[false] (e2= elif_clause |)
					{
					root_0 = (PythonTree)adaptor.nil();


					ELIF173=(Token)match(input,ELIF,FOLLOW_ELIF_in_elif_clause4062); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ELIF173_tree = (PythonTree)adaptor.create(ELIF173);
					adaptor.addChild(root_0, ELIF173_tree);
					}

					pushFollow(FOLLOW_test_in_elif_clause4064);
					test174=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test174.getTree());

					COLON175=(Token)match(input,COLON,FOLLOW_COLON_in_elif_clause4067); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COLON175_tree = (PythonTree)adaptor.create(COLON175);
					adaptor.addChild(root_0, COLON175_tree);
					}

					pushFollow(FOLLOW_suite_in_elif_clause4069);
					suite176=suite(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, suite176.getTree());

					// Python.g:1265:7: (e2= elif_clause |)
					int alt81=2;
					int LA81_0 = input.LA(1);
					if ( (LA81_0==ELIF||LA81_0==ORELSE) ) {
						alt81=1;
					}
					else if ( (LA81_0==EOF||LA81_0==ASSERT||(LA81_0 >= ASYNC && LA81_0 <= AT)||LA81_0==AWAIT||LA81_0==BREAK||LA81_0==CLASS||(LA81_0 >= COMPLEX && LA81_0 <= CONTINUE)||(LA81_0 >= DEDENT && LA81_0 <= DELETE)||LA81_0==DOT||(LA81_0 >= FLOAT && LA81_0 <= GLOBAL)||(LA81_0 >= IF && LA81_0 <= IMPORT)||LA81_0==INT||(LA81_0 >= LAMBDA && LA81_0 <= LCURLY)||(LA81_0 >= LONGINT && LA81_0 <= MINUS)||(LA81_0 >= NAME && LA81_0 <= NOT)||LA81_0==PASS||LA81_0==PLUS||LA81_0==RAISE||LA81_0==RETURN||LA81_0==STAR||(LA81_0 >= STRING && LA81_0 <= TILDE)||LA81_0==TRY||(LA81_0 >= WHILE && LA81_0 <= WITH)||LA81_0==YIELD) ) {
						alt81=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 81, 0, input);
						throw nvae;
					}

					switch (alt81) {
						case 1 :
							// Python.g:1265:8: e2= elif_clause
							{
							pushFollow(FOLLOW_elif_clause_in_elif_clause4081);
							e2=elif_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, e2.getTree());

							if ( state.backtracking==0 ) {
							           stype = new If((test174!=null?(test174.start):null), actions.castExpr((test174!=null?((PythonTree)test174.getTree()):null)), actions.castStmts((suite176!=null?((PythonParser.suite_return)suite176).stypes:null)), actions.makeElse((e2!=null?((PythonParser.elif_clause_return)e2).stypes:null), (e2!=null?((PythonTree)e2.getTree()):null)));
							       }
							}
							break;
						case 2 :
							// Python.g:1270:8: 
							{
							if ( state.backtracking==0 ) {
							           stype = new If((test174!=null?(test174.start):null), actions.castExpr((test174!=null?((PythonTree)test174.getTree()):null)), actions.castStmts((suite176!=null?((PythonParser.suite_return)suite176).stypes:null)), new ArrayList<stmt>());
							       }
							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   if (stype != null) {
			       retval.tree = stype;
			   }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elif_clause"


	public static class else_clause_return extends ParserRuleReturnScope {
		public List stypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "else_clause"
	// Python.g:1277:1: else_clause returns [List stypes] : ORELSE COLON elsesuite= suite[false] ;
	public final PythonParser.else_clause_return else_clause() throws RecognitionException {
		PythonParser.else_clause_return retval = new PythonParser.else_clause_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ORELSE177=null;
		Token COLON178=null;
		ParserRuleReturnScope elsesuite =null;

		PythonTree ORELSE177_tree=null;
		PythonTree COLON178_tree=null;

		try {
			// Python.g:1279:5: ( ORELSE COLON elsesuite= suite[false] )
			// Python.g:1279:7: ORELSE COLON elsesuite= suite[false]
			{
			root_0 = (PythonTree)adaptor.nil();


			ORELSE177=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_else_clause4141); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ORELSE177_tree = (PythonTree)adaptor.create(ORELSE177);
			adaptor.addChild(root_0, ORELSE177_tree);
			}

			COLON178=(Token)match(input,COLON,FOLLOW_COLON_in_else_clause4143); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON178_tree = (PythonTree)adaptor.create(COLON178);
			adaptor.addChild(root_0, COLON178_tree);
			}

			pushFollow(FOLLOW_suite_in_else_clause4147);
			elsesuite=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, elsesuite.getTree());

			if ( state.backtracking==0 ) {
			          retval.stypes = (elsesuite!=null?((PythonParser.suite_return)elsesuite).stypes:null);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "else_clause"


	public static class while_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "while_stmt"
	// Python.g:1286:1: while_stmt : WHILE test[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? ;
	public final PythonParser.while_stmt_return while_stmt() throws RecognitionException {
		PythonParser.while_stmt_return retval = new PythonParser.while_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token WHILE179=null;
		Token COLON181=null;
		Token ORELSE182=null;
		Token COLON183=null;
		ParserRuleReturnScope s1 =null;
		ParserRuleReturnScope s2 =null;
		ParserRuleReturnScope test180 =null;

		PythonTree WHILE179_tree=null;
		PythonTree COLON181_tree=null;
		PythonTree ORELSE182_tree=null;
		PythonTree COLON183_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1293:5: ( WHILE test[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? )
			// Python.g:1293:7: WHILE test[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			WHILE179=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_stmt4184); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WHILE179_tree = (PythonTree)adaptor.create(WHILE179);
			adaptor.addChild(root_0, WHILE179_tree);
			}

			pushFollow(FOLLOW_test_in_while_stmt4186);
			test180=test(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, test180.getTree());

			COLON181=(Token)match(input,COLON,FOLLOW_COLON_in_while_stmt4189); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON181_tree = (PythonTree)adaptor.create(COLON181);
			adaptor.addChild(root_0, COLON181_tree);
			}

			pushFollow(FOLLOW_suite_in_while_stmt4193);
			s1=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, s1.getTree());

			// Python.g:1293:63: ( ORELSE COLON s2= suite[false] )?
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( (LA83_0==ORELSE) ) {
				alt83=1;
			}
			switch (alt83) {
				case 1 :
					// Python.g:1293:64: ORELSE COLON s2= suite[false]
					{
					ORELSE182=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_while_stmt4197); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ORELSE182_tree = (PythonTree)adaptor.create(ORELSE182);
					adaptor.addChild(root_0, ORELSE182_tree);
					}

					COLON183=(Token)match(input,COLON,FOLLOW_COLON_in_while_stmt4199); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COLON183_tree = (PythonTree)adaptor.create(COLON183);
					adaptor.addChild(root_0, COLON183_tree);
					}

					pushFollow(FOLLOW_suite_in_while_stmt4203);
					s2=suite(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s2.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          stype = actions.makeWhile(WHILE179, actions.castExpr((test180!=null?((PythonTree)test180.getTree()):null)), (s1!=null?((PythonParser.suite_return)s1).stypes:null), (s2!=null?((PythonParser.suite_return)s2).stypes:null));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "while_stmt"


	public static class for_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "for_stmt"
	// Python.g:1300:1: for_stmt : FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? ;
	public final PythonParser.for_stmt_return for_stmt() throws RecognitionException {
		PythonParser.for_stmt_return retval = new PythonParser.for_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token FOR184=null;
		Token IN186=null;
		Token COLON188=null;
		Token ORELSE189=null;
		Token COLON190=null;
		ParserRuleReturnScope s1 =null;
		ParserRuleReturnScope s2 =null;
		ParserRuleReturnScope exprlist185 =null;
		ParserRuleReturnScope testlist187 =null;

		PythonTree FOR184_tree=null;
		PythonTree IN186_tree=null;
		PythonTree COLON188_tree=null;
		PythonTree ORELSE189_tree=null;
		PythonTree COLON190_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1307:5: ( FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? )
			// Python.g:1307:7: FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			FOR184=(Token)match(input,FOR,FOLLOW_FOR_in_for_stmt4242); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FOR184_tree = (PythonTree)adaptor.create(FOR184);
			adaptor.addChild(root_0, FOR184_tree);
			}

			pushFollow(FOLLOW_exprlist_in_for_stmt4244);
			exprlist185=exprlist(expr_contextType.Store);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, exprlist185.getTree());

			IN186=(Token)match(input,IN,FOLLOW_IN_in_for_stmt4247); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IN186_tree = (PythonTree)adaptor.create(IN186);
			adaptor.addChild(root_0, IN186_tree);
			}

			pushFollow(FOLLOW_testlist_in_for_stmt4249);
			testlist187=testlist(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist187.getTree());

			COLON188=(Token)match(input,COLON,FOLLOW_COLON_in_for_stmt4252); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON188_tree = (PythonTree)adaptor.create(COLON188);
			adaptor.addChild(root_0, COLON188_tree);
			}

			pushFollow(FOLLOW_suite_in_for_stmt4256);
			s1=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, s1.getTree());

			// Python.g:1308:9: ( ORELSE COLON s2= suite[false] )?
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==ORELSE) ) {
				alt84=1;
			}
			switch (alt84) {
				case 1 :
					// Python.g:1308:10: ORELSE COLON s2= suite[false]
					{
					ORELSE189=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_for_stmt4268); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ORELSE189_tree = (PythonTree)adaptor.create(ORELSE189);
					adaptor.addChild(root_0, ORELSE189_tree);
					}

					COLON190=(Token)match(input,COLON,FOLLOW_COLON_in_for_stmt4270); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COLON190_tree = (PythonTree)adaptor.create(COLON190);
					adaptor.addChild(root_0, COLON190_tree);
					}

					pushFollow(FOLLOW_suite_in_for_stmt4274);
					s2=suite(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s2.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          stype = actions.makeFor(FOR184, (exprlist185!=null?((PythonParser.exprlist_return)exprlist185).etype:null), actions.castExpr((testlist187!=null?((PythonTree)testlist187.getTree()):null)), (s1!=null?((PythonParser.suite_return)s1).stypes:null), (s2!=null?((PythonParser.suite_return)s2).stypes:null));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_stmt"


	public static class try_stmt_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "try_stmt"
	// Python.g:1319:1: try_stmt : TRY COLON trysuite= suite[!$suite.isEmpty() && $suite::continueIllegal] ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] ) ;
	public final PythonParser.try_stmt_return try_stmt() throws RecognitionException {
		PythonParser.try_stmt_return retval = new PythonParser.try_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token TRY191=null;
		Token COLON192=null;
		Token ORELSE193=null;
		Token COLON194=null;
		Token FINALLY195=null;
		Token COLON196=null;
		Token FINALLY197=null;
		Token COLON198=null;
		List<Object> list_e=null;
		ParserRuleReturnScope trysuite =null;
		ParserRuleReturnScope elsesuite =null;
		ParserRuleReturnScope finalsuite =null;
		RuleReturnScope e = null;
		PythonTree TRY191_tree=null;
		PythonTree COLON192_tree=null;
		PythonTree ORELSE193_tree=null;
		PythonTree COLON194_tree=null;
		PythonTree FINALLY195_tree=null;
		PythonTree COLON196_tree=null;
		PythonTree FINALLY197_tree=null;
		PythonTree COLON198_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1326:5: ( TRY COLON trysuite= suite[!$suite.isEmpty() && $suite::continueIllegal] ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] ) )
			// Python.g:1326:7: TRY COLON trysuite= suite[!$suite.isEmpty() && $suite::continueIllegal] ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] )
			{
			root_0 = (PythonTree)adaptor.nil();


			TRY191=(Token)match(input,TRY,FOLLOW_TRY_in_try_stmt4317); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TRY191_tree = (PythonTree)adaptor.create(TRY191);
			adaptor.addChild(root_0, TRY191_tree);
			}

			COLON192=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt4319); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON192_tree = (PythonTree)adaptor.create(COLON192);
			adaptor.addChild(root_0, COLON192_tree);
			}

			pushFollow(FOLLOW_suite_in_try_stmt4323);
			trysuite=suite(!suite_stack.isEmpty() && suite_stack.peek().continueIllegal);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, trysuite.getTree());

			// Python.g:1327:7: ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] )
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==EXCEPT) ) {
				alt88=1;
			}
			else if ( (LA88_0==FINALLY) ) {
				alt88=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 88, 0, input);
				throw nvae;
			}

			switch (alt88) {
				case 1 :
					// Python.g:1327:9: (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )?
					{
					// Python.g:1327:10: (e+= except_clause )+
					int cnt85=0;
					loop85:
					while (true) {
						int alt85=2;
						int LA85_0 = input.LA(1);
						if ( (LA85_0==EXCEPT) ) {
							alt85=1;
						}

						switch (alt85) {
						case 1 :
							// Python.g:1327:10: e+= except_clause
							{
							pushFollow(FOLLOW_except_clause_in_try_stmt4336);
							e=except_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

							if (list_e==null) list_e=new ArrayList<Object>();
							list_e.add(e.getTree());
							}
							break;

						default :
							if ( cnt85 >= 1 ) break loop85;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(85, input);
							throw eee;
						}
						cnt85++;
					}

					// Python.g:1327:27: ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )?
					int alt86=2;
					int LA86_0 = input.LA(1);
					if ( (LA86_0==ORELSE) ) {
						alt86=1;
					}
					switch (alt86) {
						case 1 :
							// Python.g:1327:28: ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal]
							{
							ORELSE193=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_try_stmt4340); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ORELSE193_tree = (PythonTree)adaptor.create(ORELSE193);
							adaptor.addChild(root_0, ORELSE193_tree);
							}

							COLON194=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt4342); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COLON194_tree = (PythonTree)adaptor.create(COLON194);
							adaptor.addChild(root_0, COLON194_tree);
							}

							pushFollow(FOLLOW_suite_in_try_stmt4346);
							elsesuite=suite(!suite_stack.isEmpty() && suite_stack.peek().continueIllegal);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, elsesuite.getTree());

							}
							break;

					}

					// Python.g:1327:105: ( FINALLY COLON finalsuite= suite[true] )?
					int alt87=2;
					int LA87_0 = input.LA(1);
					if ( (LA87_0==FINALLY) ) {
						alt87=1;
					}
					switch (alt87) {
						case 1 :
							// Python.g:1327:106: FINALLY COLON finalsuite= suite[true]
							{
							FINALLY195=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_try_stmt4352); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							FINALLY195_tree = (PythonTree)adaptor.create(FINALLY195);
							adaptor.addChild(root_0, FINALLY195_tree);
							}

							COLON196=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt4354); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COLON196_tree = (PythonTree)adaptor.create(COLON196);
							adaptor.addChild(root_0, COLON196_tree);
							}

							pushFollow(FOLLOW_suite_in_try_stmt4358);
							finalsuite=suite(true);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, finalsuite.getTree());

							}
							break;

					}

					if ( state.backtracking==0 ) {
					            stype = actions.makeTryExcept(TRY191, (trysuite!=null?((PythonParser.suite_return)trysuite).stypes:null), (List<excepthandler>)(List<?>)list_e, (elsesuite!=null?((PythonParser.suite_return)elsesuite).stypes:null), (finalsuite!=null?((PythonParser.suite_return)finalsuite).stypes:null));
					        }
					}
					break;
				case 2 :
					// Python.g:1331:9: FINALLY COLON finalsuite= suite[true]
					{
					FINALLY197=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_try_stmt4381); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FINALLY197_tree = (PythonTree)adaptor.create(FINALLY197);
					adaptor.addChild(root_0, FINALLY197_tree);
					}

					COLON198=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt4383); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COLON198_tree = (PythonTree)adaptor.create(COLON198);
					adaptor.addChild(root_0, COLON198_tree);
					}

					pushFollow(FOLLOW_suite_in_try_stmt4387);
					finalsuite=suite(true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, finalsuite.getTree());

					if ( state.backtracking==0 ) {
					            stype = actions.makeTryFinally(TRY191, (trysuite!=null?((PythonParser.suite_return)trysuite).stypes:null), (finalsuite!=null?((PythonParser.suite_return)finalsuite).stypes:null));
					        }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "try_stmt"


	public static class with_stmt_return extends ParserRuleReturnScope {
		public List items;
		public List stypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "with_stmt"
	// Python.g:1339:1: with_stmt returns [List items, List stypes] : WITH w+= with_item ( options {greedy=true; } : COMMA w+= with_item )* COLON suite[false] ;
	public final PythonParser.with_stmt_return with_stmt() throws RecognitionException {
		PythonParser.with_stmt_return retval = new PythonParser.with_stmt_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token WITH199=null;
		Token COMMA200=null;
		Token COLON201=null;
		List<Object> list_w=null;
		ParserRuleReturnScope suite202 =null;
		RuleReturnScope w = null;
		PythonTree WITH199_tree=null;
		PythonTree COMMA200_tree=null;
		PythonTree COLON201_tree=null;


		    stmt stype = null;

		try {
			// Python.g:1346:5: ( WITH w+= with_item ( options {greedy=true; } : COMMA w+= with_item )* COLON suite[false] )
			// Python.g:1346:7: WITH w+= with_item ( options {greedy=true; } : COMMA w+= with_item )* COLON suite[false]
			{
			root_0 = (PythonTree)adaptor.nil();


			WITH199=(Token)match(input,WITH,FOLLOW_WITH_in_with_stmt4440); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WITH199_tree = (PythonTree)adaptor.create(WITH199);
			adaptor.addChild(root_0, WITH199_tree);
			}

			pushFollow(FOLLOW_with_item_in_with_stmt4444);
			w=with_item();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, w.getTree());

			if (list_w==null) list_w=new ArrayList<Object>();
			list_w.add(w.getTree());
			// Python.g:1346:25: ( options {greedy=true; } : COMMA w+= with_item )*
			loop89:
			while (true) {
				int alt89=2;
				int LA89_0 = input.LA(1);
				if ( (LA89_0==COMMA) ) {
					alt89=1;
				}

				switch (alt89) {
				case 1 :
					// Python.g:1346:49: COMMA w+= with_item
					{
					COMMA200=(Token)match(input,COMMA,FOLLOW_COMMA_in_with_stmt4454); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA200_tree = (PythonTree)adaptor.create(COMMA200);
					adaptor.addChild(root_0, COMMA200_tree);
					}

					pushFollow(FOLLOW_with_item_in_with_stmt4458);
					w=with_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, w.getTree());

					if (list_w==null) list_w=new ArrayList<Object>();
					list_w.add(w.getTree());
					}
					break;

				default :
					break loop89;
				}
			}

			COLON201=(Token)match(input,COLON,FOLLOW_COLON_in_with_stmt4462); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON201_tree = (PythonTree)adaptor.create(COLON201);
			adaptor.addChild(root_0, COLON201_tree);
			}

			pushFollow(FOLLOW_suite_in_with_stmt4464);
			suite202=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, suite202.getTree());

			if ( state.backtracking==0 ) {
			        retval.items = list_w;
			        retval.stypes = (suite202!=null?((PythonParser.suite_return)suite202).stypes:null);
			        stype = actions.makeWith(WITH199, (List<withitem>)(List<?>)list_w, (suite202!=null?((PythonParser.suite_return)suite202).stypes:null));
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "with_stmt"


	public static class with_item_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "with_item"
	// Python.g:1355:1: with_item : test[expr_contextType.Load] ( AS expr[expr_contextType.Store] )? ;
	public final PythonParser.with_item_return with_item() throws RecognitionException {
		PythonParser.with_item_return retval = new PythonParser.with_item_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token AS204=null;
		ParserRuleReturnScope test203 =null;
		ParserRuleReturnScope expr205 =null;

		PythonTree AS204_tree=null;


		    withitem stype = null;

		try {
			// Python.g:1362:5: ( test[expr_contextType.Load] ( AS expr[expr_contextType.Store] )? )
			// Python.g:1362:7: test[expr_contextType.Load] ( AS expr[expr_contextType.Store] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_test_in_with_item4499);
			test203=test(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, test203.getTree());

			// Python.g:1362:35: ( AS expr[expr_contextType.Store] )?
			int alt90=2;
			int LA90_0 = input.LA(1);
			if ( (LA90_0==AS) ) {
				alt90=1;
			}
			switch (alt90) {
				case 1 :
					// Python.g:1362:36: AS expr[expr_contextType.Store]
					{
					AS204=(Token)match(input,AS,FOLLOW_AS_in_with_item4503); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS204_tree = (PythonTree)adaptor.create(AS204);
					adaptor.addChild(root_0, AS204_tree);
					}

					pushFollow(FOLLOW_expr_in_with_item4505);
					expr205=expr(expr_contextType.Store);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr205.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          expr item = actions.castExpr((test203!=null?((PythonTree)test203.getTree()):null));
			          expr var = null;
			          if ((expr205!=null?(expr205.start):null) != null) {
			              var = actions.castExpr((expr205!=null?((PythonTree)expr205.getTree()):null));
			              actions.checkAssign(var);
			          }
			          stype = new withitem((test203!=null?(test203.start):null), item, var);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "with_item"


	public static class except_clause_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "except_clause"
	// Python.g:1375:1: except_clause : EXCEPT (t1= test[expr_contextType.Load] ( AS NAME )? )? COLON suite[!$suite.isEmpty() && $suite::continueIllegal] ;
	public final PythonParser.except_clause_return except_clause() throws RecognitionException {
		PythonParser.except_clause_return retval = new PythonParser.except_clause_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token EXCEPT206=null;
		Token AS207=null;
		Token NAME208=null;
		Token COLON209=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope suite210 =null;

		PythonTree EXCEPT206_tree=null;
		PythonTree AS207_tree=null;
		PythonTree NAME208_tree=null;
		PythonTree COLON209_tree=null;


		    excepthandler extype = null;

		try {
			// Python.g:1382:5: ( EXCEPT (t1= test[expr_contextType.Load] ( AS NAME )? )? COLON suite[!$suite.isEmpty() && $suite::continueIllegal] )
			// Python.g:1382:7: EXCEPT (t1= test[expr_contextType.Load] ( AS NAME )? )? COLON suite[!$suite.isEmpty() && $suite::continueIllegal]
			{
			root_0 = (PythonTree)adaptor.nil();


			EXCEPT206=(Token)match(input,EXCEPT,FOLLOW_EXCEPT_in_except_clause4544); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EXCEPT206_tree = (PythonTree)adaptor.create(EXCEPT206);
			adaptor.addChild(root_0, EXCEPT206_tree);
			}

			// Python.g:1382:14: (t1= test[expr_contextType.Load] ( AS NAME )? )?
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( (LA92_0==AWAIT||LA92_0==COMPLEX||LA92_0==DOT||LA92_0==FLOAT||LA92_0==INT||(LA92_0 >= LAMBDA && LA92_0 <= LCURLY)||(LA92_0 >= LONGINT && LA92_0 <= MINUS)||LA92_0==NAME||LA92_0==NOT||LA92_0==PLUS||(LA92_0 >= STRING && LA92_0 <= TILDE)) ) {
				alt92=1;
			}
			switch (alt92) {
				case 1 :
					// Python.g:1382:15: t1= test[expr_contextType.Load] ( AS NAME )?
					{
					pushFollow(FOLLOW_test_in_except_clause4549);
					t1=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());

					// Python.g:1382:46: ( AS NAME )?
					int alt91=2;
					int LA91_0 = input.LA(1);
					if ( (LA91_0==AS) ) {
						alt91=1;
					}
					switch (alt91) {
						case 1 :
							// Python.g:1382:47: AS NAME
							{
							AS207=(Token)match(input,AS,FOLLOW_AS_in_except_clause4553); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							AS207_tree = (PythonTree)adaptor.create(AS207);
							adaptor.addChild(root_0, AS207_tree);
							}

							NAME208=(Token)match(input,NAME,FOLLOW_NAME_in_except_clause4555); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME208_tree = (PythonTree)adaptor.create(NAME208);
							adaptor.addChild(root_0, NAME208_tree);
							}

							}
							break;

					}

					}
					break;

			}

			COLON209=(Token)match(input,COLON,FOLLOW_COLON_in_except_clause4561); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON209_tree = (PythonTree)adaptor.create(COLON209);
			adaptor.addChild(root_0, COLON209_tree);
			}

			pushFollow(FOLLOW_suite_in_except_clause4563);
			suite210=suite(!suite_stack.isEmpty() && suite_stack.peek().continueIllegal);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, suite210.getTree());

			if ( state.backtracking==0 ) {
			          String name = null;
			          if (NAME208 != null) {
			              name = NAME208.getText();
			          }
			          extype = new ExceptHandler(EXCEPT206, actions.castExpr((t1!=null?((PythonTree)t1.getTree()):null)), name,
			              actions.castStmts((suite210!=null?((PythonParser.suite_return)suite210).stypes:null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = extype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "except_clause"


	protected static class suite_scope {
		boolean continueIllegal;
	}
	protected Stack<suite_scope> suite_stack = new Stack<suite_scope>();

	public static class suite_return extends ParserRuleReturnScope {
		public List stypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "suite"
	// Python.g:1394:1: suite[boolean fromFinally] returns [List stypes] : ( simple_stmt | NEWLINE INDENT ( stmt )+ DEDENT );
	public final PythonParser.suite_return suite(boolean fromFinally) throws RecognitionException {
		suite_stack.push(new suite_scope());
		PythonParser.suite_return retval = new PythonParser.suite_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NEWLINE212=null;
		Token INDENT213=null;
		Token DEDENT215=null;
		ParserRuleReturnScope simple_stmt211 =null;
		ParserRuleReturnScope stmt214 =null;

		PythonTree NEWLINE212_tree=null;
		PythonTree INDENT213_tree=null;
		PythonTree DEDENT215_tree=null;


		    if (suite_stack.peek().continueIllegal || fromFinally) {
		        suite_stack.peek().continueIllegal = true;
		    } else {
		        suite_stack.peek().continueIllegal = false;
		    }
		    retval.stypes = new ArrayList();

		try {
			// Python.g:1407:5: ( simple_stmt | NEWLINE INDENT ( stmt )+ DEDENT )
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==ASSERT||LA94_0==AWAIT||LA94_0==BREAK||(LA94_0 >= COMPLEX && LA94_0 <= CONTINUE)||LA94_0==DELETE||LA94_0==DOT||LA94_0==FLOAT||(LA94_0 >= FROM && LA94_0 <= GLOBAL)||LA94_0==IMPORT||LA94_0==INT||(LA94_0 >= LAMBDA && LA94_0 <= LCURLY)||(LA94_0 >= LONGINT && LA94_0 <= MINUS)||LA94_0==NAME||(LA94_0 >= NONLOCAL && LA94_0 <= NOT)||LA94_0==PASS||LA94_0==PLUS||LA94_0==RAISE||LA94_0==RETURN||LA94_0==STAR||(LA94_0 >= STRING && LA94_0 <= TILDE)||LA94_0==YIELD) ) {
				alt94=1;
			}
			else if ( (LA94_0==NEWLINE) ) {
				alt94=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}

			switch (alt94) {
				case 1 :
					// Python.g:1407:7: simple_stmt
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_simple_stmt_in_suite4609);
					simple_stmt211=simple_stmt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_stmt211.getTree());

					if ( state.backtracking==0 ) {
					          retval.stypes = (simple_stmt211!=null?((PythonParser.simple_stmt_return)simple_stmt211).stypes:null);
					      }
					}
					break;
				case 2 :
					// Python.g:1411:7: NEWLINE INDENT ( stmt )+ DEDENT
					{
					root_0 = (PythonTree)adaptor.nil();


					NEWLINE212=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_suite4625); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEWLINE212_tree = (PythonTree)adaptor.create(NEWLINE212);
					adaptor.addChild(root_0, NEWLINE212_tree);
					}

					INDENT213=(Token)match(input,INDENT,FOLLOW_INDENT_in_suite4627); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INDENT213_tree = (PythonTree)adaptor.create(INDENT213);
					adaptor.addChild(root_0, INDENT213_tree);
					}

					// Python.g:1412:7: ( stmt )+
					int cnt93=0;
					loop93:
					while (true) {
						int alt93=2;
						int LA93_0 = input.LA(1);
						if ( (LA93_0==ASSERT||(LA93_0 >= ASYNC && LA93_0 <= AT)||LA93_0==AWAIT||LA93_0==BREAK||LA93_0==CLASS||(LA93_0 >= COMPLEX && LA93_0 <= CONTINUE)||(LA93_0 >= DEF && LA93_0 <= DELETE)||LA93_0==DOT||(LA93_0 >= FLOAT && LA93_0 <= GLOBAL)||(LA93_0 >= IF && LA93_0 <= IMPORT)||LA93_0==INT||(LA93_0 >= LAMBDA && LA93_0 <= LCURLY)||(LA93_0 >= LONGINT && LA93_0 <= MINUS)||LA93_0==NAME||(LA93_0 >= NONLOCAL && LA93_0 <= NOT)||LA93_0==PASS||LA93_0==PLUS||LA93_0==RAISE||LA93_0==RETURN||LA93_0==STAR||(LA93_0 >= STRING && LA93_0 <= TILDE)||LA93_0==TRY||(LA93_0 >= WHILE && LA93_0 <= WITH)||LA93_0==YIELD) ) {
							alt93=1;
						}

						switch (alt93) {
						case 1 :
							// Python.g:1412:8: stmt
							{
							pushFollow(FOLLOW_stmt_in_suite4636);
							stmt214=stmt();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt214.getTree());

							if ( state.backtracking==0 ) {
							           if ((stmt214!=null?((PythonParser.stmt_return)stmt214).stypes:null) != null) {
							               retval.stypes.addAll((stmt214!=null?((PythonParser.stmt_return)stmt214).stypes:null));
							           }
							       }
							}
							break;

						default :
							if ( cnt93 >= 1 ) break loop93;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(93, input);
							throw eee;
						}
						cnt93++;
					}

					DEDENT215=(Token)match(input,DEDENT,FOLLOW_DEDENT_in_suite4656); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DEDENT215_tree = (PythonTree)adaptor.create(DEDENT215);
					adaptor.addChild(root_0, DEDENT215_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
			suite_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "suite"


	public static class test_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "test"
	// Python.g:1422:1: test[expr_contextType ctype] : (o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test ) | lambdef );
	public final PythonParser.test_return test(expr_contextType ctype) throws RecognitionException {
		PythonParser.test_return retval = new PythonParser.test_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token IF216=null;
		Token ORELSE217=null;
		ParserRuleReturnScope o1 =null;
		ParserRuleReturnScope o2 =null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope lambdef218 =null;

		PythonTree IF216_tree=null;
		PythonTree ORELSE217_tree=null;
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleTokenStream stream_ORELSE=new RewriteRuleTokenStream(adaptor,"token ORELSE");
		RewriteRuleSubtreeStream stream_or_test=new RewriteRuleSubtreeStream(adaptor,"rule or_test");
		RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");


		    expr etype = null;

		try {
			// Python.g:1431:5: (o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test ) | lambdef )
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==AWAIT||LA96_0==COMPLEX||LA96_0==DOT||LA96_0==FLOAT||LA96_0==INT||(LA96_0 >= LBRACK && LA96_0 <= LCURLY)||(LA96_0 >= LONGINT && LA96_0 <= MINUS)||LA96_0==NAME||LA96_0==NOT||LA96_0==PLUS||(LA96_0 >= STRING && LA96_0 <= TILDE)) ) {
				alt96=1;
			}
			else if ( (LA96_0==LAMBDA) ) {
				alt96=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 96, 0, input);
				throw nvae;
			}

			switch (alt96) {
				case 1 :
					// Python.g:1431:6: o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test )
					{
					pushFollow(FOLLOW_or_test_in_test4686);
					o1=or_test(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_or_test.add(o1.getTree());
					// Python.g:1432:7: ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test )
					int alt95=2;
					int LA95_0 = input.LA(1);
					if ( (LA95_0==IF) ) {
						int LA95_1 = input.LA(2);
						if ( (synpred4_Python()) ) {
							alt95=1;
						}
						else if ( (true) ) {
							alt95=2;
						}

					}
					else if ( (LA95_0==EOF||LA95_0==AMPEREQUAL||LA95_0==AS||LA95_0==ASSIGN||LA95_0==ATEQUAL||LA95_0==CIRCUMFLEXEQUAL||(LA95_0 >= COLON && LA95_0 <= COMMA)||LA95_0==DOUBLESLASHEQUAL||LA95_0==DOUBLESTAREQUAL||(LA95_0 >= FOR && LA95_0 <= FROM)||LA95_0==LEFTSHIFTEQUAL||LA95_0==MINUSEQUAL||LA95_0==NEWLINE||LA95_0==PERCENTEQUAL||LA95_0==PLUSEQUAL||(LA95_0 >= RBRACK && LA95_0 <= RCURLY)||(LA95_0 >= RIGHTSHIFTEQUAL && LA95_0 <= SEMI)||LA95_0==SLASHEQUAL||LA95_0==STAREQUAL||LA95_0==VBAREQUAL) ) {
						alt95=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 95, 0, input);
						throw nvae;
					}

					switch (alt95) {
						case 1 :
							// Python.g:1432:9: ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load]
							{
							IF216=(Token)match(input,IF,FOLLOW_IF_in_test4708); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_IF.add(IF216);

							pushFollow(FOLLOW_or_test_in_test4712);
							o2=or_test(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_or_test.add(o2.getTree());
							ORELSE217=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_test4715); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ORELSE.add(ORELSE217);

							pushFollow(FOLLOW_test_in_test4719);
							e=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_test.add(e.getTree());
							if ( state.backtracking==0 ) {
							             etype = new IfExp((o1!=null?(o1.start):null), actions.castExpr((o2!=null?((PythonTree)o2.getTree()):null)), actions.castExpr((o1!=null?((PythonTree)o1.getTree()):null)), actions.castExpr((e!=null?((PythonTree)e.getTree()):null)));
							         }
							}
							break;
						case 2 :
							// Python.g:1437:6: 
							{
							// AST REWRITE
							// elements: or_test
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (PythonTree)adaptor.nil();
							// 1437:6: -> or_test
							{
								adaptor.addChild(root_0, stream_or_test.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// Python.g:1439:7: lambdef
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_lambdef_in_test4764);
					lambdef218=lambdef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdef218.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   if (etype != null) {
			       retval.tree = etype;
			   }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "test"


	public static class test_nocond_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "test_nocond"
	// Python.g:1443:1: test_nocond[expr_contextType ctype] : (o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test ) | lambdef_nocond );
	public final PythonParser.test_nocond_return test_nocond(expr_contextType ctype) throws RecognitionException {
		PythonParser.test_nocond_return retval = new PythonParser.test_nocond_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token IF219=null;
		Token ORELSE220=null;
		ParserRuleReturnScope o1 =null;
		ParserRuleReturnScope o2 =null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope lambdef_nocond221 =null;

		PythonTree IF219_tree=null;
		PythonTree ORELSE220_tree=null;
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleTokenStream stream_ORELSE=new RewriteRuleTokenStream(adaptor,"token ORELSE");
		RewriteRuleSubtreeStream stream_or_test=new RewriteRuleSubtreeStream(adaptor,"rule or_test");
		RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");


		    expr etype = null;

		try {
			// Python.g:1452:5: (o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test ) | lambdef_nocond )
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==AWAIT||LA98_0==COMPLEX||LA98_0==DOT||LA98_0==FLOAT||LA98_0==INT||(LA98_0 >= LBRACK && LA98_0 <= LCURLY)||(LA98_0 >= LONGINT && LA98_0 <= MINUS)||LA98_0==NAME||LA98_0==NOT||LA98_0==PLUS||(LA98_0 >= STRING && LA98_0 <= TILDE)) ) {
				alt98=1;
			}
			else if ( (LA98_0==LAMBDA) ) {
				alt98=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 98, 0, input);
				throw nvae;
			}

			switch (alt98) {
				case 1 :
					// Python.g:1452:7: o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test )
					{
					pushFollow(FOLLOW_or_test_in_test_nocond4795);
					o1=or_test(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_or_test.add(o1.getTree());
					// Python.g:1453:7: ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] | -> or_test )
					int alt97=2;
					int LA97_0 = input.LA(1);
					if ( (LA97_0==IF) ) {
						int LA97_1 = input.LA(2);
						if ( (synpred5_Python()) ) {
							alt97=1;
						}
						else if ( (true) ) {
							alt97=2;
						}

					}
					else if ( (LA97_0==COMMA||LA97_0==FOR||(LA97_0 >= RBRACK && LA97_0 <= RCURLY)||LA97_0==RPAREN) ) {
						alt97=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 97, 0, input);
						throw nvae;
					}

					switch (alt97) {
						case 1 :
							// Python.g:1453:9: ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load]
							{
							IF219=(Token)match(input,IF,FOLLOW_IF_in_test_nocond4817); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_IF.add(IF219);

							pushFollow(FOLLOW_or_test_in_test_nocond4821);
							o2=or_test(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_or_test.add(o2.getTree());
							ORELSE220=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_test_nocond4824); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ORELSE.add(ORELSE220);

							pushFollow(FOLLOW_test_in_test_nocond4828);
							e=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_test.add(e.getTree());
							if ( state.backtracking==0 ) {
							             etype = new IfExp((o1!=null?(o1.start):null), actions.castExpr((o2!=null?((PythonTree)o2.getTree()):null)), actions.castExpr((o1!=null?((PythonTree)o1.getTree()):null)), actions.castExpr((e!=null?((PythonTree)e.getTree()):null)));
							         }
							}
							break;
						case 2 :
							// Python.g:1458:6: 
							{
							// AST REWRITE
							// elements: or_test
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (PythonTree)adaptor.nil();
							// 1458:6: -> or_test
							{
								adaptor.addChild(root_0, stream_or_test.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// Python.g:1460:7: lambdef_nocond
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_lambdef_nocond_in_test_nocond4873);
					lambdef_nocond221=lambdef_nocond();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdef_nocond221.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   if (etype != null) {
			       retval.tree = etype;
			   }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "test_nocond"


	public static class or_test_return extends ParserRuleReturnScope {
		public Token leftTok;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "or_test"
	// Python.g:1465:1: or_test[expr_contextType ctype] returns [Token leftTok] : left= and_test[ctype] ( (or= OR right+= and_test[ctype] )+ | -> $left) ;
	public final PythonParser.or_test_return or_test(expr_contextType ctype) throws RecognitionException {
		PythonParser.or_test_return retval = new PythonParser.or_test_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token or=null;
		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		RuleReturnScope right = null;
		PythonTree or_tree=null;
		RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
		RewriteRuleSubtreeStream stream_and_test=new RewriteRuleSubtreeStream(adaptor,"rule and_test");

		try {
			// Python.g:1476:5: (left= and_test[ctype] ( (or= OR right+= and_test[ctype] )+ | -> $left) )
			// Python.g:1476:7: left= and_test[ctype] ( (or= OR right+= and_test[ctype] )+ | -> $left)
			{
			pushFollow(FOLLOW_and_test_in_or_test4909);
			left=and_test(ctype);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_and_test.add(left.getTree());
			// Python.g:1477:9: ( (or= OR right+= and_test[ctype] )+ | -> $left)
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( (LA100_0==OR) ) {
				alt100=1;
			}
			else if ( (LA100_0==EOF||LA100_0==AMPEREQUAL||LA100_0==AS||LA100_0==ASSIGN||LA100_0==ATEQUAL||LA100_0==CIRCUMFLEXEQUAL||(LA100_0 >= COLON && LA100_0 <= COMMA)||LA100_0==DOUBLESLASHEQUAL||LA100_0==DOUBLESTAREQUAL||(LA100_0 >= FOR && LA100_0 <= FROM)||LA100_0==IF||LA100_0==LEFTSHIFTEQUAL||LA100_0==MINUSEQUAL||LA100_0==NEWLINE||LA100_0==ORELSE||LA100_0==PERCENTEQUAL||LA100_0==PLUSEQUAL||(LA100_0 >= RBRACK && LA100_0 <= RCURLY)||(LA100_0 >= RIGHTSHIFTEQUAL && LA100_0 <= SEMI)||LA100_0==SLASHEQUAL||LA100_0==STAREQUAL||LA100_0==VBAREQUAL) ) {
				alt100=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 100, 0, input);
				throw nvae;
			}

			switch (alt100) {
				case 1 :
					// Python.g:1477:11: (or= OR right+= and_test[ctype] )+
					{
					// Python.g:1477:11: (or= OR right+= and_test[ctype] )+
					int cnt99=0;
					loop99:
					while (true) {
						int alt99=2;
						int LA99_0 = input.LA(1);
						if ( (LA99_0==OR) ) {
							alt99=1;
						}

						switch (alt99) {
						case 1 :
							// Python.g:1477:12: or= OR right+= and_test[ctype]
							{
							or=(Token)match(input,OR,FOLLOW_OR_in_or_test4925); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_OR.add(or);

							pushFollow(FOLLOW_and_test_in_or_test4929);
							right=and_test(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_and_test.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							}
							break;

						default :
							if ( cnt99 >= 1 ) break loop99;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(99, input);
							throw eee;
						}
						cnt99++;
					}

					}
					break;
				case 2 :
					// Python.g:1480:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1480:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (or != null) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.and_test_return)left).leftTok:null) != null) {
			            tok = (left!=null?((PythonParser.and_test_return)left).leftTok:null);
			        }
			        retval.tree = actions.makeBoolOp(tok, (left!=null?((PythonTree)left.getTree()):null), boolopType.Or, list_right);
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "or_test"


	public static class and_test_return extends ParserRuleReturnScope {
		public Token leftTok;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "and_test"
	// Python.g:1485:1: and_test[expr_contextType ctype] returns [Token leftTok] : left= not_test[ctype] ( (and= AND right+= not_test[ctype] )+ | -> $left) ;
	public final PythonParser.and_test_return and_test(expr_contextType ctype) throws RecognitionException {
		PythonParser.and_test_return retval = new PythonParser.and_test_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token and=null;
		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		RuleReturnScope right = null;
		PythonTree and_tree=null;
		RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
		RewriteRuleSubtreeStream stream_not_test=new RewriteRuleSubtreeStream(adaptor,"rule not_test");

		try {
			// Python.g:1496:5: (left= not_test[ctype] ( (and= AND right+= not_test[ctype] )+ | -> $left) )
			// Python.g:1496:7: left= not_test[ctype] ( (and= AND right+= not_test[ctype] )+ | -> $left)
			{
			pushFollow(FOLLOW_not_test_in_and_test5010);
			left=not_test(ctype);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_not_test.add(left.getTree());
			// Python.g:1497:9: ( (and= AND right+= not_test[ctype] )+ | -> $left)
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( (LA102_0==AND) ) {
				alt102=1;
			}
			else if ( (LA102_0==EOF||LA102_0==AMPEREQUAL||LA102_0==AS||LA102_0==ASSIGN||LA102_0==ATEQUAL||LA102_0==CIRCUMFLEXEQUAL||(LA102_0 >= COLON && LA102_0 <= COMMA)||LA102_0==DOUBLESLASHEQUAL||LA102_0==DOUBLESTAREQUAL||(LA102_0 >= FOR && LA102_0 <= FROM)||LA102_0==IF||LA102_0==LEFTSHIFTEQUAL||LA102_0==MINUSEQUAL||LA102_0==NEWLINE||(LA102_0 >= OR && LA102_0 <= ORELSE)||LA102_0==PERCENTEQUAL||LA102_0==PLUSEQUAL||(LA102_0 >= RBRACK && LA102_0 <= RCURLY)||(LA102_0 >= RIGHTSHIFTEQUAL && LA102_0 <= SEMI)||LA102_0==SLASHEQUAL||LA102_0==STAREQUAL||LA102_0==VBAREQUAL) ) {
				alt102=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 102, 0, input);
				throw nvae;
			}

			switch (alt102) {
				case 1 :
					// Python.g:1497:11: (and= AND right+= not_test[ctype] )+
					{
					// Python.g:1497:11: (and= AND right+= not_test[ctype] )+
					int cnt101=0;
					loop101:
					while (true) {
						int alt101=2;
						int LA101_0 = input.LA(1);
						if ( (LA101_0==AND) ) {
							alt101=1;
						}

						switch (alt101) {
						case 1 :
							// Python.g:1497:12: and= AND right+= not_test[ctype]
							{
							and=(Token)match(input,AND,FOLLOW_AND_in_and_test5026); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_AND.add(and);

							pushFollow(FOLLOW_not_test_in_and_test5030);
							right=not_test(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_not_test.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							}
							break;

						default :
							if ( cnt101 >= 1 ) break loop101;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(101, input);
							throw eee;
						}
						cnt101++;
					}

					}
					break;
				case 2 :
					// Python.g:1500:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1500:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (and != null) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.not_test_return)left).leftTok:null) != null) {
			            tok = (left!=null?((PythonParser.not_test_return)left).leftTok:null);
			        }
			        retval.tree = actions.makeBoolOp(tok, (left!=null?((PythonTree)left.getTree()):null), boolopType.And, list_right);
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "and_test"


	public static class not_test_return extends ParserRuleReturnScope {
		public Token leftTok;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "not_test"
	// Python.g:1505:1: not_test[expr_contextType ctype] returns [Token leftTok] : ( NOT nt= not_test[ctype] | comparison[ctype] );
	public final PythonParser.not_test_return not_test(expr_contextType ctype) throws RecognitionException {
		PythonParser.not_test_return retval = new PythonParser.not_test_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token NOT222=null;
		ParserRuleReturnScope nt =null;
		ParserRuleReturnScope comparison223 =null;

		PythonTree NOT222_tree=null;


		    expr etype = null;

		try {
			// Python.g:1515:5: ( NOT nt= not_test[ctype] | comparison[ctype] )
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==NOT) ) {
				alt103=1;
			}
			else if ( (LA103_0==AWAIT||LA103_0==COMPLEX||LA103_0==DOT||LA103_0==FLOAT||LA103_0==INT||(LA103_0 >= LBRACK && LA103_0 <= LCURLY)||(LA103_0 >= LONGINT && LA103_0 <= MINUS)||LA103_0==NAME||LA103_0==PLUS||(LA103_0 >= STRING && LA103_0 <= TILDE)) ) {
				alt103=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 103, 0, input);
				throw nvae;
			}

			switch (alt103) {
				case 1 :
					// Python.g:1515:7: NOT nt= not_test[ctype]
					{
					root_0 = (PythonTree)adaptor.nil();


					NOT222=(Token)match(input,NOT,FOLLOW_NOT_in_not_test5114); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT222_tree = (PythonTree)adaptor.create(NOT222);
					adaptor.addChild(root_0, NOT222_tree);
					}

					pushFollow(FOLLOW_not_test_in_not_test5118);
					nt=not_test(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nt.getTree());

					if ( state.backtracking==0 ) {
					          etype = new UnaryOp(NOT222, unaryopType.Not, actions.castExpr((nt!=null?((PythonTree)nt.getTree()):null)));
					      }
					}
					break;
				case 2 :
					// Python.g:1519:7: comparison[ctype]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_comparison_in_not_test5135);
					comparison223=comparison(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comparison223.getTree());

					if ( state.backtracking==0 ) {
					          retval.leftTok = (comparison223!=null?((PythonParser.comparison_return)comparison223).leftTok:null);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   if (etype != null) {
			       retval.tree = etype;
			   }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "not_test"


	public static class comparison_return extends ParserRuleReturnScope {
		public Token leftTok;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "comparison"
	// Python.g:1526:1: comparison[expr_contextType ctype] returns [Token leftTok] : left= expr[ctype] ( ( comp_op right+= expr[ctype] )+ | -> $left) ;
	public final PythonParser.comparison_return comparison(expr_contextType ctype) throws RecognitionException {
		PythonParser.comparison_return retval = new PythonParser.comparison_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope comp_op224 =null;
		RuleReturnScope right = null;
		RewriteRuleSubtreeStream stream_comp_op=new RewriteRuleSubtreeStream(adaptor,"rule comp_op");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");


		    List cmps = new ArrayList();

		try {
			// Python.g:1538:5: (left= expr[ctype] ( ( comp_op right+= expr[ctype] )+ | -> $left) )
			// Python.g:1538:7: left= expr[ctype] ( ( comp_op right+= expr[ctype] )+ | -> $left)
			{
			pushFollow(FOLLOW_expr_in_comparison5184);
			left=expr(ctype);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(left.getTree());
			// Python.g:1539:8: ( ( comp_op right+= expr[ctype] )+ | -> $left)
			int alt105=2;
			int LA105_0 = input.LA(1);
			if ( (LA105_0==ALT_NOTEQUAL||LA105_0==EQUAL||(LA105_0 >= GREATER && LA105_0 <= GREATEREQUAL)||LA105_0==IN||LA105_0==IS||(LA105_0 >= LESS && LA105_0 <= LESSEQUAL)||(LA105_0 >= NOT && LA105_0 <= NOTEQUAL)) ) {
				alt105=1;
			}
			else if ( (LA105_0==EOF||(LA105_0 >= AMPEREQUAL && LA105_0 <= AND)||LA105_0==AS||LA105_0==ASSIGN||LA105_0==ATEQUAL||LA105_0==CIRCUMFLEXEQUAL||(LA105_0 >= COLON && LA105_0 <= COMMA)||LA105_0==DOUBLESLASHEQUAL||LA105_0==DOUBLESTAREQUAL||(LA105_0 >= FOR && LA105_0 <= FROM)||LA105_0==IF||LA105_0==LEFTSHIFTEQUAL||LA105_0==MINUSEQUAL||LA105_0==NEWLINE||(LA105_0 >= OR && LA105_0 <= ORELSE)||LA105_0==PERCENTEQUAL||LA105_0==PLUSEQUAL||(LA105_0 >= RBRACK && LA105_0 <= RCURLY)||(LA105_0 >= RIGHTSHIFTEQUAL && LA105_0 <= SEMI)||LA105_0==SLASHEQUAL||LA105_0==STAREQUAL||LA105_0==VBAREQUAL) ) {
				alt105=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 105, 0, input);
				throw nvae;
			}

			switch (alt105) {
				case 1 :
					// Python.g:1539:10: ( comp_op right+= expr[ctype] )+
					{
					// Python.g:1539:10: ( comp_op right+= expr[ctype] )+
					int cnt104=0;
					loop104:
					while (true) {
						int alt104=2;
						int LA104_0 = input.LA(1);
						if ( (LA104_0==ALT_NOTEQUAL||LA104_0==EQUAL||(LA104_0 >= GREATER && LA104_0 <= GREATEREQUAL)||LA104_0==IN||LA104_0==IS||(LA104_0 >= LESS && LA104_0 <= LESSEQUAL)||(LA104_0 >= NOT && LA104_0 <= NOTEQUAL)) ) {
							alt104=1;
						}

						switch (alt104) {
						case 1 :
							// Python.g:1539:12: comp_op right+= expr[ctype]
							{
							pushFollow(FOLLOW_comp_op_in_comparison5198);
							comp_op224=comp_op();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_comp_op.add(comp_op224.getTree());
							pushFollow(FOLLOW_expr_in_comparison5202);
							right=expr(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							if ( state.backtracking==0 ) {
							               cmps.add((comp_op224!=null?((PythonParser.comp_op_return)comp_op224).op:null));
							           }
							}
							break;

						default :
							if ( cnt104 >= 1 ) break loop104;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(104, input);
							throw eee;
						}
						cnt104++;
					}

					}
					break;
				case 2 :
					// Python.g:1545:7: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1545:7: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.leftTok = (left!=null?((PythonParser.expr_return)left).leftTok:null);
			    if (!cmps.isEmpty()) {
			        retval.tree = new Compare((left!=null?(left.start):null), actions.castExpr((left!=null?((PythonTree)left.getTree()):null)), actions.makeCmpOps(cmps),
			            actions.castExprs(list_right));
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comparison"


	public static class comp_op_return extends ParserRuleReturnScope {
		public cmpopType op;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "comp_op"
	// Python.g:1550:1: comp_op returns [cmpopType op] : ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT );
	public final PythonParser.comp_op_return comp_op() throws RecognitionException {
		PythonParser.comp_op_return retval = new PythonParser.comp_op_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LESS225=null;
		Token GREATER226=null;
		Token EQUAL227=null;
		Token GREATEREQUAL228=null;
		Token LESSEQUAL229=null;
		Token ALT_NOTEQUAL230=null;
		Token NOTEQUAL231=null;
		Token IN232=null;
		Token NOT233=null;
		Token IN234=null;
		Token IS235=null;
		Token IS236=null;
		Token NOT237=null;

		PythonTree LESS225_tree=null;
		PythonTree GREATER226_tree=null;
		PythonTree EQUAL227_tree=null;
		PythonTree GREATEREQUAL228_tree=null;
		PythonTree LESSEQUAL229_tree=null;
		PythonTree ALT_NOTEQUAL230_tree=null;
		PythonTree NOTEQUAL231_tree=null;
		PythonTree IN232_tree=null;
		PythonTree NOT233_tree=null;
		PythonTree IN234_tree=null;
		PythonTree IS235_tree=null;
		PythonTree IS236_tree=null;
		PythonTree NOT237_tree=null;

		try {
			// Python.g:1552:5: ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT )
			int alt106=11;
			switch ( input.LA(1) ) {
			case LESS:
				{
				alt106=1;
				}
				break;
			case GREATER:
				{
				alt106=2;
				}
				break;
			case EQUAL:
				{
				alt106=3;
				}
				break;
			case GREATEREQUAL:
				{
				alt106=4;
				}
				break;
			case LESSEQUAL:
				{
				alt106=5;
				}
				break;
			case ALT_NOTEQUAL:
				{
				alt106=6;
				}
				break;
			case NOTEQUAL:
				{
				alt106=7;
				}
				break;
			case IN:
				{
				alt106=8;
				}
				break;
			case NOT:
				{
				alt106=9;
				}
				break;
			case IS:
				{
				int LA106_10 = input.LA(2);
				if ( (LA106_10==NOT) ) {
					alt106=11;
				}
				else if ( (LA106_10==AWAIT||LA106_10==COMPLEX||LA106_10==DOT||LA106_10==FLOAT||LA106_10==INT||(LA106_10 >= LBRACK && LA106_10 <= LCURLY)||(LA106_10 >= LONGINT && LA106_10 <= MINUS)||LA106_10==NAME||LA106_10==PLUS||(LA106_10 >= STRING && LA106_10 <= TILDE)) ) {
					alt106=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 106, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 106, 0, input);
				throw nvae;
			}
			switch (alt106) {
				case 1 :
					// Python.g:1552:7: LESS
					{
					root_0 = (PythonTree)adaptor.nil();


					LESS225=(Token)match(input,LESS,FOLLOW_LESS_in_comp_op5283); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESS225_tree = (PythonTree)adaptor.create(LESS225);
					adaptor.addChild(root_0, LESS225_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.Lt;
					      }
					}
					break;
				case 2 :
					// Python.g:1556:7: GREATER
					{
					root_0 = (PythonTree)adaptor.nil();


					GREATER226=(Token)match(input,GREATER,FOLLOW_GREATER_in_comp_op5299); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATER226_tree = (PythonTree)adaptor.create(GREATER226);
					adaptor.addChild(root_0, GREATER226_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.Gt;
					      }
					}
					break;
				case 3 :
					// Python.g:1560:7: EQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					EQUAL227=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_comp_op5315); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQUAL227_tree = (PythonTree)adaptor.create(EQUAL227);
					adaptor.addChild(root_0, EQUAL227_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.Eq;
					      }
					}
					break;
				case 4 :
					// Python.g:1564:7: GREATEREQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					GREATEREQUAL228=(Token)match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_comp_op5331); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATEREQUAL228_tree = (PythonTree)adaptor.create(GREATEREQUAL228);
					adaptor.addChild(root_0, GREATEREQUAL228_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.GtE;
					      }
					}
					break;
				case 5 :
					// Python.g:1568:7: LESSEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					LESSEQUAL229=(Token)match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_comp_op5347); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSEQUAL229_tree = (PythonTree)adaptor.create(LESSEQUAL229);
					adaptor.addChild(root_0, LESSEQUAL229_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.LtE;
					      }
					}
					break;
				case 6 :
					// Python.g:1572:7: ALT_NOTEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					ALT_NOTEQUAL230=(Token)match(input,ALT_NOTEQUAL,FOLLOW_ALT_NOTEQUAL_in_comp_op5363); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALT_NOTEQUAL230_tree = (PythonTree)adaptor.create(ALT_NOTEQUAL230);
					adaptor.addChild(root_0, ALT_NOTEQUAL230_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.NotEq;
					      }
					}
					break;
				case 7 :
					// Python.g:1576:7: NOTEQUAL
					{
					root_0 = (PythonTree)adaptor.nil();


					NOTEQUAL231=(Token)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_comp_op5379); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOTEQUAL231_tree = (PythonTree)adaptor.create(NOTEQUAL231);
					adaptor.addChild(root_0, NOTEQUAL231_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.NotEq;
					      }
					}
					break;
				case 8 :
					// Python.g:1580:7: IN
					{
					root_0 = (PythonTree)adaptor.nil();


					IN232=(Token)match(input,IN,FOLLOW_IN_in_comp_op5395); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IN232_tree = (PythonTree)adaptor.create(IN232);
					adaptor.addChild(root_0, IN232_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.In;
					      }
					}
					break;
				case 9 :
					// Python.g:1584:7: NOT IN
					{
					root_0 = (PythonTree)adaptor.nil();


					NOT233=(Token)match(input,NOT,FOLLOW_NOT_in_comp_op5411); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT233_tree = (PythonTree)adaptor.create(NOT233);
					adaptor.addChild(root_0, NOT233_tree);
					}

					IN234=(Token)match(input,IN,FOLLOW_IN_in_comp_op5413); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IN234_tree = (PythonTree)adaptor.create(IN234);
					adaptor.addChild(root_0, IN234_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.NotIn;
					      }
					}
					break;
				case 10 :
					// Python.g:1588:7: IS
					{
					root_0 = (PythonTree)adaptor.nil();


					IS235=(Token)match(input,IS,FOLLOW_IS_in_comp_op5429); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IS235_tree = (PythonTree)adaptor.create(IS235);
					adaptor.addChild(root_0, IS235_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.Is;
					      }
					}
					break;
				case 11 :
					// Python.g:1592:7: IS NOT
					{
					root_0 = (PythonTree)adaptor.nil();


					IS236=(Token)match(input,IS,FOLLOW_IS_in_comp_op5445); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IS236_tree = (PythonTree)adaptor.create(IS236);
					adaptor.addChild(root_0, IS236_tree);
					}

					NOT237=(Token)match(input,NOT,FOLLOW_NOT_in_comp_op5447); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT237_tree = (PythonTree)adaptor.create(NOT237);
					adaptor.addChild(root_0, NOT237_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = cmpopType.IsNot;
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comp_op"


	protected static class expr_scope {
		expr_contextType ctype;
	}
	protected Stack<expr_scope> expr_stack = new Stack<expr_scope>();

	public static class expr_return extends ParserRuleReturnScope {
		public Token leftTok;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Python.g:1599:1: expr[expr_contextType ect] returns [Token leftTok] : left= xor_expr ( (op= VBAR right+= xor_expr )+ | -> $left) ;
	public final PythonParser.expr_return expr(expr_contextType ect) throws RecognitionException {
		expr_stack.push(new expr_scope());
		PythonParser.expr_return retval = new PythonParser.expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token op=null;
		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		RuleReturnScope right = null;
		PythonTree op_tree=null;
		RewriteRuleTokenStream stream_VBAR=new RewriteRuleTokenStream(adaptor,"token VBAR");
		RewriteRuleSubtreeStream stream_xor_expr=new RewriteRuleSubtreeStream(adaptor,"rule xor_expr");


		    expr_stack.peek().ctype = ect;

		try {
			// Python.g:1617:5: (left= xor_expr ( (op= VBAR right+= xor_expr )+ | -> $left) )
			// Python.g:1617:7: left= xor_expr ( (op= VBAR right+= xor_expr )+ | -> $left)
			{
			pushFollow(FOLLOW_xor_expr_in_expr5499);
			left=xor_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_xor_expr.add(left.getTree());
			// Python.g:1618:9: ( (op= VBAR right+= xor_expr )+ | -> $left)
			int alt108=2;
			int LA108_0 = input.LA(1);
			if ( (LA108_0==VBAR) ) {
				alt108=1;
			}
			else if ( (LA108_0==EOF||LA108_0==ALT_NOTEQUAL||(LA108_0 >= AMPEREQUAL && LA108_0 <= AND)||LA108_0==AS||LA108_0==ASSIGN||LA108_0==ATEQUAL||LA108_0==CIRCUMFLEXEQUAL||(LA108_0 >= COLON && LA108_0 <= COMMA)||LA108_0==DOUBLESLASHEQUAL||LA108_0==DOUBLESTAREQUAL||LA108_0==EQUAL||(LA108_0 >= FOR && LA108_0 <= FROM)||(LA108_0 >= GREATER && LA108_0 <= IF)||LA108_0==IN||LA108_0==IS||(LA108_0 >= LEFTSHIFTEQUAL && LA108_0 <= LESSEQUAL)||LA108_0==MINUSEQUAL||LA108_0==NEWLINE||(LA108_0 >= NOT && LA108_0 <= ORELSE)||LA108_0==PERCENTEQUAL||LA108_0==PLUSEQUAL||(LA108_0 >= RBRACK && LA108_0 <= RCURLY)||(LA108_0 >= RIGHTSHIFTEQUAL && LA108_0 <= SEMI)||LA108_0==SLASHEQUAL||LA108_0==STAREQUAL||LA108_0==VBAREQUAL) ) {
				alt108=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 108, 0, input);
				throw nvae;
			}

			switch (alt108) {
				case 1 :
					// Python.g:1618:11: (op= VBAR right+= xor_expr )+
					{
					// Python.g:1618:11: (op= VBAR right+= xor_expr )+
					int cnt107=0;
					loop107:
					while (true) {
						int alt107=2;
						int LA107_0 = input.LA(1);
						if ( (LA107_0==VBAR) ) {
							alt107=1;
						}

						switch (alt107) {
						case 1 :
							// Python.g:1618:12: op= VBAR right+= xor_expr
							{
							op=(Token)match(input,VBAR,FOLLOW_VBAR_in_expr5514); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_VBAR.add(op);

							pushFollow(FOLLOW_xor_expr_in_expr5518);
							right=xor_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_xor_expr.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							}
							break;

						default :
							if ( cnt107 >= 1 ) break loop107;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(107, input);
							throw eee;
						}
						cnt107++;
					}

					}
					break;
				case 2 :
					// Python.g:1621:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1621:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.leftTok = (left!=null?((PythonParser.xor_expr_return)left).lparen:null);
			    if (op != null) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.xor_expr_return)left).lparen:null) != null) {
			            tok = (left!=null?((PythonParser.xor_expr_return)left).lparen:null);
			        }
			        retval.tree = actions.makeBinOp(tok, (left!=null?((PythonTree)left.getTree()):null), operatorType.BitOr, list_right);
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
			expr_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class xor_expr_return extends ParserRuleReturnScope {
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "xor_expr"
	// Python.g:1627:1: xor_expr returns [Token lparen = null] : left= and_expr ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left) ;
	public final PythonParser.xor_expr_return xor_expr() throws RecognitionException {
		PythonParser.xor_expr_return retval = new PythonParser.xor_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token op=null;
		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		RuleReturnScope right = null;
		PythonTree op_tree=null;
		RewriteRuleTokenStream stream_CIRCUMFLEX=new RewriteRuleTokenStream(adaptor,"token CIRCUMFLEX");
		RewriteRuleSubtreeStream stream_and_expr=new RewriteRuleSubtreeStream(adaptor,"rule and_expr");

		try {
			// Python.g:1639:5: (left= and_expr ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left) )
			// Python.g:1639:7: left= and_expr ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left)
			{
			pushFollow(FOLLOW_and_expr_in_xor_expr5597);
			left=and_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_and_expr.add(left.getTree());
			// Python.g:1640:9: ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left)
			int alt110=2;
			int LA110_0 = input.LA(1);
			if ( (LA110_0==CIRCUMFLEX) ) {
				alt110=1;
			}
			else if ( (LA110_0==EOF||LA110_0==ALT_NOTEQUAL||(LA110_0 >= AMPEREQUAL && LA110_0 <= AND)||LA110_0==AS||LA110_0==ASSIGN||LA110_0==ATEQUAL||LA110_0==CIRCUMFLEXEQUAL||(LA110_0 >= COLON && LA110_0 <= COMMA)||LA110_0==DOUBLESLASHEQUAL||LA110_0==DOUBLESTAREQUAL||LA110_0==EQUAL||(LA110_0 >= FOR && LA110_0 <= FROM)||(LA110_0 >= GREATER && LA110_0 <= IF)||LA110_0==IN||LA110_0==IS||(LA110_0 >= LEFTSHIFTEQUAL && LA110_0 <= LESSEQUAL)||LA110_0==MINUSEQUAL||LA110_0==NEWLINE||(LA110_0 >= NOT && LA110_0 <= ORELSE)||LA110_0==PERCENTEQUAL||LA110_0==PLUSEQUAL||(LA110_0 >= RBRACK && LA110_0 <= RCURLY)||(LA110_0 >= RIGHTSHIFTEQUAL && LA110_0 <= SEMI)||LA110_0==SLASHEQUAL||LA110_0==STAREQUAL||(LA110_0 >= VBAR && LA110_0 <= VBAREQUAL)) ) {
				alt110=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 110, 0, input);
				throw nvae;
			}

			switch (alt110) {
				case 1 :
					// Python.g:1640:11: (op= CIRCUMFLEX right+= and_expr )+
					{
					// Python.g:1640:11: (op= CIRCUMFLEX right+= and_expr )+
					int cnt109=0;
					loop109:
					while (true) {
						int alt109=2;
						int LA109_0 = input.LA(1);
						if ( (LA109_0==CIRCUMFLEX) ) {
							alt109=1;
						}

						switch (alt109) {
						case 1 :
							// Python.g:1640:12: op= CIRCUMFLEX right+= and_expr
							{
							op=(Token)match(input,CIRCUMFLEX,FOLLOW_CIRCUMFLEX_in_xor_expr5612); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_CIRCUMFLEX.add(op);

							pushFollow(FOLLOW_and_expr_in_xor_expr5616);
							right=and_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_and_expr.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							}
							break;

						default :
							if ( cnt109 >= 1 ) break loop109;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(109, input);
							throw eee;
						}
						cnt109++;
					}

					}
					break;
				case 2 :
					// Python.g:1643:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1643:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (op != null) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.and_expr_return)left).lparen:null) != null) {
			            tok = (left!=null?((PythonParser.and_expr_return)left).lparen:null);
			        }
			        retval.tree = actions.makeBinOp(tok, (left!=null?((PythonTree)left.getTree()):null), operatorType.BitXor, list_right);
			    }
			    retval.lparen = (left!=null?((PythonParser.and_expr_return)left).lparen:null);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "xor_expr"


	public static class and_expr_return extends ParserRuleReturnScope {
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "and_expr"
	// Python.g:1648:1: and_expr returns [Token lparen = null] : left= shift_expr ( (op= AMPER right+= shift_expr )+ | -> $left) ;
	public final PythonParser.and_expr_return and_expr() throws RecognitionException {
		PythonParser.and_expr_return retval = new PythonParser.and_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token op=null;
		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		RuleReturnScope right = null;
		PythonTree op_tree=null;
		RewriteRuleTokenStream stream_AMPER=new RewriteRuleTokenStream(adaptor,"token AMPER");
		RewriteRuleSubtreeStream stream_shift_expr=new RewriteRuleSubtreeStream(adaptor,"rule shift_expr");

		try {
			// Python.g:1660:5: (left= shift_expr ( (op= AMPER right+= shift_expr )+ | -> $left) )
			// Python.g:1660:7: left= shift_expr ( (op= AMPER right+= shift_expr )+ | -> $left)
			{
			pushFollow(FOLLOW_shift_expr_in_and_expr5694);
			left=shift_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_shift_expr.add(left.getTree());
			// Python.g:1661:9: ( (op= AMPER right+= shift_expr )+ | -> $left)
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==AMPER) ) {
				alt112=1;
			}
			else if ( (LA112_0==EOF||LA112_0==ALT_NOTEQUAL||(LA112_0 >= AMPEREQUAL && LA112_0 <= AND)||LA112_0==AS||LA112_0==ASSIGN||LA112_0==ATEQUAL||(LA112_0 >= CIRCUMFLEX && LA112_0 <= CIRCUMFLEXEQUAL)||(LA112_0 >= COLON && LA112_0 <= COMMA)||LA112_0==DOUBLESLASHEQUAL||LA112_0==DOUBLESTAREQUAL||LA112_0==EQUAL||(LA112_0 >= FOR && LA112_0 <= FROM)||(LA112_0 >= GREATER && LA112_0 <= IF)||LA112_0==IN||LA112_0==IS||(LA112_0 >= LEFTSHIFTEQUAL && LA112_0 <= LESSEQUAL)||LA112_0==MINUSEQUAL||LA112_0==NEWLINE||(LA112_0 >= NOT && LA112_0 <= ORELSE)||LA112_0==PERCENTEQUAL||LA112_0==PLUSEQUAL||(LA112_0 >= RBRACK && LA112_0 <= RCURLY)||(LA112_0 >= RIGHTSHIFTEQUAL && LA112_0 <= SEMI)||LA112_0==SLASHEQUAL||LA112_0==STAREQUAL||(LA112_0 >= VBAR && LA112_0 <= VBAREQUAL)) ) {
				alt112=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 112, 0, input);
				throw nvae;
			}

			switch (alt112) {
				case 1 :
					// Python.g:1661:11: (op= AMPER right+= shift_expr )+
					{
					// Python.g:1661:11: (op= AMPER right+= shift_expr )+
					int cnt111=0;
					loop111:
					while (true) {
						int alt111=2;
						int LA111_0 = input.LA(1);
						if ( (LA111_0==AMPER) ) {
							alt111=1;
						}

						switch (alt111) {
						case 1 :
							// Python.g:1661:12: op= AMPER right+= shift_expr
							{
							op=(Token)match(input,AMPER,FOLLOW_AMPER_in_and_expr5709); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_AMPER.add(op);

							pushFollow(FOLLOW_shift_expr_in_and_expr5713);
							right=shift_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_shift_expr.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							}
							break;

						default :
							if ( cnt111 >= 1 ) break loop111;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(111, input);
							throw eee;
						}
						cnt111++;
					}

					}
					break;
				case 2 :
					// Python.g:1664:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1664:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (op != null) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.shift_expr_return)left).lparen:null) != null) {
			            tok = (left!=null?((PythonParser.shift_expr_return)left).lparen:null);
			        }
			        retval.tree = actions.makeBinOp(tok, (left!=null?((PythonTree)left.getTree()):null), operatorType.BitAnd, list_right);
			    }
			    retval.lparen = (left!=null?((PythonParser.shift_expr_return)left).lparen:null);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "and_expr"


	public static class shift_expr_return extends ParserRuleReturnScope {
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "shift_expr"
	// Python.g:1669:1: shift_expr returns [Token lparen = null] : left= arith_expr ( ( shift_op right+= arith_expr )+ | -> $left) ;
	public final PythonParser.shift_expr_return shift_expr() throws RecognitionException {
		PythonParser.shift_expr_return retval = new PythonParser.shift_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope shift_op238 =null;
		RuleReturnScope right = null;
		RewriteRuleSubtreeStream stream_shift_op=new RewriteRuleSubtreeStream(adaptor,"rule shift_op");
		RewriteRuleSubtreeStream stream_arith_expr=new RewriteRuleSubtreeStream(adaptor,"rule arith_expr");


		    List ops = new ArrayList();
		    List toks = new ArrayList();

		try {
			// Python.g:1685:5: (left= arith_expr ( ( shift_op right+= arith_expr )+ | -> $left) )
			// Python.g:1685:7: left= arith_expr ( ( shift_op right+= arith_expr )+ | -> $left)
			{
			pushFollow(FOLLOW_arith_expr_in_shift_expr5796);
			left=arith_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_arith_expr.add(left.getTree());
			// Python.g:1686:9: ( ( shift_op right+= arith_expr )+ | -> $left)
			int alt114=2;
			int LA114_0 = input.LA(1);
			if ( (LA114_0==LEFTSHIFT||LA114_0==RIGHTSHIFT) ) {
				alt114=1;
			}
			else if ( (LA114_0==EOF||(LA114_0 >= ALT_NOTEQUAL && LA114_0 <= AND)||LA114_0==AS||LA114_0==ASSIGN||LA114_0==ATEQUAL||(LA114_0 >= CIRCUMFLEX && LA114_0 <= CIRCUMFLEXEQUAL)||(LA114_0 >= COLON && LA114_0 <= COMMA)||LA114_0==DOUBLESLASHEQUAL||LA114_0==DOUBLESTAREQUAL||LA114_0==EQUAL||(LA114_0 >= FOR && LA114_0 <= FROM)||(LA114_0 >= GREATER && LA114_0 <= IF)||LA114_0==IN||LA114_0==IS||(LA114_0 >= LEFTSHIFTEQUAL && LA114_0 <= LESSEQUAL)||LA114_0==MINUSEQUAL||LA114_0==NEWLINE||(LA114_0 >= NOT && LA114_0 <= ORELSE)||LA114_0==PERCENTEQUAL||LA114_0==PLUSEQUAL||(LA114_0 >= RBRACK && LA114_0 <= RCURLY)||(LA114_0 >= RIGHTSHIFTEQUAL && LA114_0 <= SEMI)||LA114_0==SLASHEQUAL||LA114_0==STAREQUAL||(LA114_0 >= VBAR && LA114_0 <= VBAREQUAL)) ) {
				alt114=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 114, 0, input);
				throw nvae;
			}

			switch (alt114) {
				case 1 :
					// Python.g:1686:11: ( shift_op right+= arith_expr )+
					{
					// Python.g:1686:11: ( shift_op right+= arith_expr )+
					int cnt113=0;
					loop113:
					while (true) {
						int alt113=2;
						int LA113_0 = input.LA(1);
						if ( (LA113_0==LEFTSHIFT||LA113_0==RIGHTSHIFT) ) {
							alt113=1;
						}

						switch (alt113) {
						case 1 :
							// Python.g:1686:13: shift_op right+= arith_expr
							{
							pushFollow(FOLLOW_shift_op_in_shift_expr5810);
							shift_op238=shift_op();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_shift_op.add(shift_op238.getTree());
							pushFollow(FOLLOW_arith_expr_in_shift_expr5814);
							right=arith_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_arith_expr.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							if ( state.backtracking==0 ) {
							                ops.add((shift_op238!=null?((PythonParser.shift_op_return)shift_op238).op:null));
							                toks.add((shift_op238!=null?(shift_op238.start):null));
							            }
							}
							break;

						default :
							if ( cnt113 >= 1 ) break loop113;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(113, input);
							throw eee;
						}
						cnt113++;
					}

					}
					break;
				case 2 :
					// Python.g:1693:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1693:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (!ops.isEmpty()) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.arith_expr_return)left).lparen:null) != null) {
			            tok = (left!=null?((PythonParser.arith_expr_return)left).lparen:null);
			        }
			        retval.tree = actions.makeBinOp(tok, (left!=null?((PythonTree)left.getTree()):null), ops, list_right, toks);
			    }
			    retval.lparen = (left!=null?((PythonParser.arith_expr_return)left).lparen:null);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "shift_expr"


	public static class shift_op_return extends ParserRuleReturnScope {
		public operatorType op;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "shift_op"
	// Python.g:1697:1: shift_op returns [operatorType op] : ( LEFTSHIFT | RIGHTSHIFT );
	public final PythonParser.shift_op_return shift_op() throws RecognitionException {
		PythonParser.shift_op_return retval = new PythonParser.shift_op_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LEFTSHIFT239=null;
		Token RIGHTSHIFT240=null;

		PythonTree LEFTSHIFT239_tree=null;
		PythonTree RIGHTSHIFT240_tree=null;

		try {
			// Python.g:1699:5: ( LEFTSHIFT | RIGHTSHIFT )
			int alt115=2;
			int LA115_0 = input.LA(1);
			if ( (LA115_0==LEFTSHIFT) ) {
				alt115=1;
			}
			else if ( (LA115_0==RIGHTSHIFT) ) {
				alt115=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 115, 0, input);
				throw nvae;
			}

			switch (alt115) {
				case 1 :
					// Python.g:1699:7: LEFTSHIFT
					{
					root_0 = (PythonTree)adaptor.nil();


					LEFTSHIFT239=(Token)match(input,LEFTSHIFT,FOLLOW_LEFTSHIFT_in_shift_op5898); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSHIFT239_tree = (PythonTree)adaptor.create(LEFTSHIFT239);
					adaptor.addChild(root_0, LEFTSHIFT239_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.LShift;
					      }
					}
					break;
				case 2 :
					// Python.g:1703:7: RIGHTSHIFT
					{
					root_0 = (PythonTree)adaptor.nil();


					RIGHTSHIFT240=(Token)match(input,RIGHTSHIFT,FOLLOW_RIGHTSHIFT_in_shift_op5914); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSHIFT240_tree = (PythonTree)adaptor.create(RIGHTSHIFT240);
					adaptor.addChild(root_0, RIGHTSHIFT240_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.RShift;
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "shift_op"


	public static class arith_expr_return extends ParserRuleReturnScope {
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "arith_expr"
	// Python.g:1710:1: arith_expr returns [Token lparen = null] : left= term ( ( arith_op right+= term )+ | -> $left) ;
	public final PythonParser.arith_expr_return arith_expr() throws RecognitionException {
		PythonParser.arith_expr_return retval = new PythonParser.arith_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope arith_op241 =null;
		RuleReturnScope right = null;
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_arith_op=new RewriteRuleSubtreeStream(adaptor,"rule arith_op");


		    List ops = new ArrayList();
		    List toks = new ArrayList();

		try {
			// Python.g:1726:5: (left= term ( ( arith_op right+= term )+ | -> $left) )
			// Python.g:1726:7: left= term ( ( arith_op right+= term )+ | -> $left)
			{
			pushFollow(FOLLOW_term_in_arith_expr5960);
			left=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_term.add(left.getTree());
			// Python.g:1727:9: ( ( arith_op right+= term )+ | -> $left)
			int alt117=2;
			int LA117_0 = input.LA(1);
			if ( (LA117_0==MINUS||LA117_0==PLUS) ) {
				alt117=1;
			}
			else if ( (LA117_0==EOF||(LA117_0 >= ALT_NOTEQUAL && LA117_0 <= AND)||LA117_0==AS||LA117_0==ASSIGN||LA117_0==ATEQUAL||(LA117_0 >= CIRCUMFLEX && LA117_0 <= CIRCUMFLEXEQUAL)||(LA117_0 >= COLON && LA117_0 <= COMMA)||LA117_0==DOUBLESLASHEQUAL||LA117_0==DOUBLESTAREQUAL||LA117_0==EQUAL||(LA117_0 >= FOR && LA117_0 <= FROM)||(LA117_0 >= GREATER && LA117_0 <= IF)||LA117_0==IN||LA117_0==IS||(LA117_0 >= LEFTSHIFT && LA117_0 <= LESSEQUAL)||LA117_0==MINUSEQUAL||LA117_0==NEWLINE||(LA117_0 >= NOT && LA117_0 <= ORELSE)||LA117_0==PERCENTEQUAL||LA117_0==PLUSEQUAL||(LA117_0 >= RBRACK && LA117_0 <= RCURLY)||(LA117_0 >= RIGHTSHIFT && LA117_0 <= SEMI)||LA117_0==SLASHEQUAL||LA117_0==STAREQUAL||(LA117_0 >= VBAR && LA117_0 <= VBAREQUAL)) ) {
				alt117=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 117, 0, input);
				throw nvae;
			}

			switch (alt117) {
				case 1 :
					// Python.g:1727:11: ( arith_op right+= term )+
					{
					// Python.g:1727:11: ( arith_op right+= term )+
					int cnt116=0;
					loop116:
					while (true) {
						int alt116=2;
						int LA116_0 = input.LA(1);
						if ( (LA116_0==MINUS||LA116_0==PLUS) ) {
							alt116=1;
						}

						switch (alt116) {
						case 1 :
							// Python.g:1727:12: arith_op right+= term
							{
							pushFollow(FOLLOW_arith_op_in_arith_expr5973);
							arith_op241=arith_op();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_arith_op.add(arith_op241.getTree());
							pushFollow(FOLLOW_term_in_arith_expr5977);
							right=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							if ( state.backtracking==0 ) {
							               ops.add((arith_op241!=null?((PythonParser.arith_op_return)arith_op241).op:null));
							               toks.add((arith_op241!=null?(arith_op241.start):null));
							           }
							}
							break;

						default :
							if ( cnt116 >= 1 ) break loop116;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(116, input);
							throw eee;
						}
						cnt116++;
					}

					}
					break;
				case 2 :
					// Python.g:1734:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1734:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (!ops.isEmpty()) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.term_return)left).lparen:null) != null) {
			            tok = (left!=null?((PythonParser.term_return)left).lparen:null);
			        }
			        retval.tree = actions.makeBinOp(tok, (left!=null?((PythonTree)left.getTree()):null), ops, list_right, toks);
			    }
			    retval.lparen = (left!=null?((PythonParser.term_return)left).lparen:null);
			}
		}
		catch (RewriteCardinalityException rce) {

			        PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), null);
			        retval.tree = badNode;
			        errorHandler.error("Internal Parser Error", badNode);
			    
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arith_expr"


	public static class arith_op_return extends ParserRuleReturnScope {
		public operatorType op;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "arith_op"
	// Python.g:1746:1: arith_op returns [operatorType op] : ( PLUS | MINUS );
	public final PythonParser.arith_op_return arith_op() throws RecognitionException {
		PythonParser.arith_op_return retval = new PythonParser.arith_op_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token PLUS242=null;
		Token MINUS243=null;

		PythonTree PLUS242_tree=null;
		PythonTree MINUS243_tree=null;

		try {
			// Python.g:1748:5: ( PLUS | MINUS )
			int alt118=2;
			int LA118_0 = input.LA(1);
			if ( (LA118_0==PLUS) ) {
				alt118=1;
			}
			else if ( (LA118_0==MINUS) ) {
				alt118=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 118, 0, input);
				throw nvae;
			}

			switch (alt118) {
				case 1 :
					// Python.g:1748:7: PLUS
					{
					root_0 = (PythonTree)adaptor.nil();


					PLUS242=(Token)match(input,PLUS,FOLLOW_PLUS_in_arith_op6085); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS242_tree = (PythonTree)adaptor.create(PLUS242);
					adaptor.addChild(root_0, PLUS242_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.Add;
					      }
					}
					break;
				case 2 :
					// Python.g:1752:7: MINUS
					{
					root_0 = (PythonTree)adaptor.nil();


					MINUS243=(Token)match(input,MINUS,FOLLOW_MINUS_in_arith_op6101); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS243_tree = (PythonTree)adaptor.create(MINUS243);
					adaptor.addChild(root_0, MINUS243_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.Sub;
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arith_op"


	public static class term_return extends ParserRuleReturnScope {
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// Python.g:1759:1: term returns [Token lparen = null] : left= factor ( ( term_op right+= factor )+ | -> $left) ;
	public final PythonParser.term_return term() throws RecognitionException {
		PythonParser.term_return retval = new PythonParser.term_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		List<Object> list_right=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope term_op244 =null;
		RuleReturnScope right = null;
		RewriteRuleSubtreeStream stream_term_op=new RewriteRuleSubtreeStream(adaptor,"rule term_op");
		RewriteRuleSubtreeStream stream_factor=new RewriteRuleSubtreeStream(adaptor,"rule factor");


		    List ops = new ArrayList();
		    List toks = new ArrayList();

		try {
			// Python.g:1775:5: (left= factor ( ( term_op right+= factor )+ | -> $left) )
			// Python.g:1775:7: left= factor ( ( term_op right+= factor )+ | -> $left)
			{
			pushFollow(FOLLOW_factor_in_term6147);
			left=factor();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_factor.add(left.getTree());
			// Python.g:1776:9: ( ( term_op right+= factor )+ | -> $left)
			int alt120=2;
			int LA120_0 = input.LA(1);
			if ( (LA120_0==AT||LA120_0==DOUBLESLASH||LA120_0==PERCENT||LA120_0==SLASH||LA120_0==STAR) ) {
				alt120=1;
			}
			else if ( (LA120_0==EOF||(LA120_0 >= ALT_NOTEQUAL && LA120_0 <= AND)||LA120_0==AS||LA120_0==ASSIGN||LA120_0==ATEQUAL||(LA120_0 >= CIRCUMFLEX && LA120_0 <= CIRCUMFLEXEQUAL)||(LA120_0 >= COLON && LA120_0 <= COMMA)||LA120_0==DOUBLESLASHEQUAL||LA120_0==DOUBLESTAREQUAL||LA120_0==EQUAL||(LA120_0 >= FOR && LA120_0 <= FROM)||(LA120_0 >= GREATER && LA120_0 <= IF)||LA120_0==IN||LA120_0==IS||(LA120_0 >= LEFTSHIFT && LA120_0 <= LESSEQUAL)||(LA120_0 >= MINUS && LA120_0 <= MINUSEQUAL)||LA120_0==NEWLINE||(LA120_0 >= NOT && LA120_0 <= ORELSE)||(LA120_0 >= PERCENTEQUAL && LA120_0 <= PLUSEQUAL)||(LA120_0 >= RBRACK && LA120_0 <= RCURLY)||(LA120_0 >= RIGHTSHIFT && LA120_0 <= SEMI)||LA120_0==SLASHEQUAL||LA120_0==STAREQUAL||(LA120_0 >= VBAR && LA120_0 <= VBAREQUAL)) ) {
				alt120=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 120, 0, input);
				throw nvae;
			}

			switch (alt120) {
				case 1 :
					// Python.g:1776:11: ( term_op right+= factor )+
					{
					// Python.g:1776:11: ( term_op right+= factor )+
					int cnt119=0;
					loop119:
					while (true) {
						int alt119=2;
						int LA119_0 = input.LA(1);
						if ( (LA119_0==AT||LA119_0==DOUBLESLASH||LA119_0==PERCENT||LA119_0==SLASH||LA119_0==STAR) ) {
							alt119=1;
						}

						switch (alt119) {
						case 1 :
							// Python.g:1776:12: term_op right+= factor
							{
							pushFollow(FOLLOW_term_op_in_term6160);
							term_op244=term_op();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term_op.add(term_op244.getTree());
							pushFollow(FOLLOW_factor_in_term6164);
							right=factor();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_factor.add(right.getTree());
							if (list_right==null) list_right=new ArrayList<Object>();
							list_right.add(right.getTree());
							if ( state.backtracking==0 ) {
							              ops.add((term_op244!=null?((PythonParser.term_op_return)term_op244).op:null));
							              toks.add((term_op244!=null?(term_op244.start):null));
							          }
							}
							break;

						default :
							if ( cnt119 >= 1 ) break loop119;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(119, input);
							throw eee;
						}
						cnt119++;
					}

					}
					break;
				case 2 :
					// Python.g:1783:8: 
					{
					// AST REWRITE
					// elements: left
					// token labels: 
					// rule labels: left, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 1783:8: -> $left
					{
						adaptor.addChild(root_0, stream_left.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.lparen = (left!=null?((PythonParser.factor_return)left).lparen:null);
			    if (!ops.isEmpty()) {
			        Token tok = (left!=null?(left.start):null);
			        if ((left!=null?((PythonParser.factor_return)left).lparen:null) != null) {
			            tok = (left!=null?((PythonParser.factor_return)left).lparen:null);
			        }
			        retval.tree = actions.makeBinOp(tok, (left!=null?((PythonTree)left.getTree()):null), ops, list_right, toks);
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class term_op_return extends ParserRuleReturnScope {
		public operatorType op;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "term_op"
	// Python.g:1787:1: term_op returns [operatorType op] : ( STAR | AT | SLASH | PERCENT | DOUBLESLASH );
	public final PythonParser.term_op_return term_op() throws RecognitionException {
		PythonParser.term_op_return retval = new PythonParser.term_op_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token STAR245=null;
		Token AT246=null;
		Token SLASH247=null;
		Token PERCENT248=null;
		Token DOUBLESLASH249=null;

		PythonTree STAR245_tree=null;
		PythonTree AT246_tree=null;
		PythonTree SLASH247_tree=null;
		PythonTree PERCENT248_tree=null;
		PythonTree DOUBLESLASH249_tree=null;

		try {
			// Python.g:1789:5: ( STAR | AT | SLASH | PERCENT | DOUBLESLASH )
			int alt121=5;
			switch ( input.LA(1) ) {
			case STAR:
				{
				alt121=1;
				}
				break;
			case AT:
				{
				alt121=2;
				}
				break;
			case SLASH:
				{
				alt121=3;
				}
				break;
			case PERCENT:
				{
				alt121=4;
				}
				break;
			case DOUBLESLASH:
				{
				alt121=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 121, 0, input);
				throw nvae;
			}
			switch (alt121) {
				case 1 :
					// Python.g:1789:7: STAR
					{
					root_0 = (PythonTree)adaptor.nil();


					STAR245=(Token)match(input,STAR,FOLLOW_STAR_in_term_op6246); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR245_tree = (PythonTree)adaptor.create(STAR245);
					adaptor.addChild(root_0, STAR245_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.Mult;
					      }
					}
					break;
				case 2 :
					// Python.g:1793:7: AT
					{
					root_0 = (PythonTree)adaptor.nil();


					AT246=(Token)match(input,AT,FOLLOW_AT_in_term_op6262); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AT246_tree = (PythonTree)adaptor.create(AT246);
					adaptor.addChild(root_0, AT246_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.MatMult;
					      }
					}
					break;
				case 3 :
					// Python.g:1797:7: SLASH
					{
					root_0 = (PythonTree)adaptor.nil();


					SLASH247=(Token)match(input,SLASH,FOLLOW_SLASH_in_term_op6278); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SLASH247_tree = (PythonTree)adaptor.create(SLASH247);
					adaptor.addChild(root_0, SLASH247_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.Div;
					      }
					}
					break;
				case 4 :
					// Python.g:1801:7: PERCENT
					{
					root_0 = (PythonTree)adaptor.nil();


					PERCENT248=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_term_op6294); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PERCENT248_tree = (PythonTree)adaptor.create(PERCENT248);
					adaptor.addChild(root_0, PERCENT248_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.Mod;
					      }
					}
					break;
				case 5 :
					// Python.g:1805:7: DOUBLESLASH
					{
					root_0 = (PythonTree)adaptor.nil();


					DOUBLESLASH249=(Token)match(input,DOUBLESLASH,FOLLOW_DOUBLESLASH_in_term_op6310); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLESLASH249_tree = (PythonTree)adaptor.create(DOUBLESLASH249);
					adaptor.addChild(root_0, DOUBLESLASH249_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.op = operatorType.FloorDiv;
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term_op"


	public static class factor_return extends ParserRuleReturnScope {
		public expr etype;
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// Python.g:1812:1: factor returns [expr etype, Token lparen = null] : ( PLUS p= factor | MINUS m= factor | TILDE t= factor | power );
	public final PythonParser.factor_return factor() throws RecognitionException {
		PythonParser.factor_return retval = new PythonParser.factor_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token PLUS250=null;
		Token MINUS251=null;
		Token TILDE252=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope m =null;
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope power253 =null;

		PythonTree PLUS250_tree=null;
		PythonTree MINUS251_tree=null;
		PythonTree TILDE252_tree=null;

		try {
			// Python.g:1817:5: ( PLUS p= factor | MINUS m= factor | TILDE t= factor | power )
			int alt122=4;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt122=1;
				}
				break;
			case MINUS:
				{
				alt122=2;
				}
				break;
			case TILDE:
				{
				alt122=3;
				}
				break;
			case AWAIT:
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
				{
				alt122=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 122, 0, input);
				throw nvae;
			}
			switch (alt122) {
				case 1 :
					// Python.g:1817:7: PLUS p= factor
					{
					root_0 = (PythonTree)adaptor.nil();


					PLUS250=(Token)match(input,PLUS,FOLLOW_PLUS_in_factor6349); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS250_tree = (PythonTree)adaptor.create(PLUS250);
					adaptor.addChild(root_0, PLUS250_tree);
					}

					pushFollow(FOLLOW_factor_in_factor6353);
					p=factor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

					if ( state.backtracking==0 ) {
					          retval.etype = new UnaryOp(PLUS250, unaryopType.UAdd, (p!=null?((PythonParser.factor_return)p).etype:null));
					      }
					}
					break;
				case 2 :
					// Python.g:1821:7: MINUS m= factor
					{
					root_0 = (PythonTree)adaptor.nil();


					MINUS251=(Token)match(input,MINUS,FOLLOW_MINUS_in_factor6369); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS251_tree = (PythonTree)adaptor.create(MINUS251);
					adaptor.addChild(root_0, MINUS251_tree);
					}

					pushFollow(FOLLOW_factor_in_factor6373);
					m=factor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());

					if ( state.backtracking==0 ) {
					          retval.etype = actions.negate(MINUS251, (m!=null?((PythonParser.factor_return)m).etype:null));
					      }
					}
					break;
				case 3 :
					// Python.g:1825:7: TILDE t= factor
					{
					root_0 = (PythonTree)adaptor.nil();


					TILDE252=(Token)match(input,TILDE,FOLLOW_TILDE_in_factor6389); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TILDE252_tree = (PythonTree)adaptor.create(TILDE252);
					adaptor.addChild(root_0, TILDE252_tree);
					}

					pushFollow(FOLLOW_factor_in_factor6393);
					t=factor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					if ( state.backtracking==0 ) {
					          retval.etype = new UnaryOp(TILDE252, unaryopType.Invert, (t!=null?((PythonParser.factor_return)t).etype:null));
					      }
					}
					break;
				case 4 :
					// Python.g:1829:7: power
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_power_in_factor6409);
					power253=power();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, power253.getTree());

					if ( state.backtracking==0 ) {
					          retval.etype = actions.castExpr((power253!=null?((PythonTree)power253.getTree()):null));
					          retval.lparen = (power253!=null?((PythonParser.power_return)power253).lparen:null);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "factor"


	public static class power_return extends ParserRuleReturnScope {
		public expr etype;
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "power"
	// Python.g:1837:1: power returns [expr etype, Token lparen = null] : atom_expr ( options {greedy=true; } :d= DOUBLESTAR factor )? ;
	public final PythonParser.power_return power() throws RecognitionException {
		PythonParser.power_return retval = new PythonParser.power_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token d=null;
		ParserRuleReturnScope atom_expr254 =null;
		ParserRuleReturnScope factor255 =null;

		PythonTree d_tree=null;

		try {
			// Python.g:1842:5: ( atom_expr ( options {greedy=true; } :d= DOUBLESTAR factor )? )
			// Python.g:1842:7: atom_expr ( options {greedy=true; } :d= DOUBLESTAR factor )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_atom_expr_in_power6448);
			atom_expr254=atom_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, atom_expr254.getTree());

			// Python.g:1842:17: ( options {greedy=true; } :d= DOUBLESTAR factor )?
			int alt123=2;
			int LA123_0 = input.LA(1);
			if ( (LA123_0==DOUBLESTAR) ) {
				alt123=1;
			}
			switch (alt123) {
				case 1 :
					// Python.g:1842:41: d= DOUBLESTAR factor
					{
					d=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_power6460); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					d_tree = (PythonTree)adaptor.create(d);
					adaptor.addChild(root_0, d_tree);
					}

					pushFollow(FOLLOW_factor_in_power6462);
					factor255=factor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, factor255.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          retval.lparen = (atom_expr254!=null?((PythonParser.atom_expr_return)atom_expr254).lparen:null);
			          retval.etype = actions.castExpr((atom_expr254!=null?((PythonTree)atom_expr254.getTree()):null));
			          if (d != null) {
			              List right = new ArrayList();
			              right.add((factor255!=null?((PythonTree)factor255.getTree()):null));
			              retval.etype = actions.makeBinOp((atom_expr254!=null?(atom_expr254.start):null), retval.etype, operatorType.Pow, right);
			          }
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "power"


	public static class atom_expr_return extends ParserRuleReturnScope {
		public expr etype;
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "atom_expr"
	// Python.g:1855:1: atom_expr returns [expr etype, Token lparen = null] : ( ( ( AWAIT )? atom )=> ( AWAIT )? atom (t+= trailer[$atom.start, $atom.tree] )* | AWAIT );
	public final PythonParser.atom_expr_return atom_expr() throws RecognitionException {
		PythonParser.atom_expr_return retval = new PythonParser.atom_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token AWAIT256=null;
		Token AWAIT258=null;
		List<Object> list_t=null;
		ParserRuleReturnScope atom257 =null;
		RuleReturnScope t = null;
		PythonTree AWAIT256_tree=null;
		PythonTree AWAIT258_tree=null;

		try {
			// Python.g:1860:5: ( ( ( AWAIT )? atom )=> ( AWAIT )? atom (t+= trailer[$atom.start, $atom.tree] )* | AWAIT )
			int alt126=2;
			int LA126_0 = input.LA(1);
			if ( (LA126_0==AWAIT) ) {
				int LA126_1 = input.LA(2);
				if ( (LA126_1==LPAREN) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==LBRACK) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==LCURLY) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==NAME) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==INT) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==LONGINT) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==FLOAT) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==COMPLEX) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==DOT) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==STRING) && (synpred6_Python())) {
					alt126=1;
				}
				else if ( (LA126_1==EOF||(LA126_1 >= ALT_NOTEQUAL && LA126_1 <= AND)||LA126_1==AS||LA126_1==ASSIGN||(LA126_1 >= AT && LA126_1 <= ATEQUAL)||(LA126_1 >= CIRCUMFLEX && LA126_1 <= CIRCUMFLEXEQUAL)||(LA126_1 >= COLON && LA126_1 <= COMMA)||(LA126_1 >= DOUBLESLASH && LA126_1 <= DOUBLESTAREQUAL)||LA126_1==EQUAL||(LA126_1 >= FOR && LA126_1 <= FROM)||(LA126_1 >= GREATER && LA126_1 <= IF)||LA126_1==IN||LA126_1==IS||(LA126_1 >= LEFTSHIFT && LA126_1 <= LESSEQUAL)||(LA126_1 >= MINUS && LA126_1 <= MINUSEQUAL)||LA126_1==NEWLINE||(LA126_1 >= NOT && LA126_1 <= ORELSE)||(LA126_1 >= PERCENT && LA126_1 <= PLUSEQUAL)||(LA126_1 >= RBRACK && LA126_1 <= RCURLY)||(LA126_1 >= RIGHTSHIFT && LA126_1 <= STAREQUAL)||(LA126_1 >= VBAR && LA126_1 <= VBAREQUAL)) ) {
					alt126=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 126, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA126_0==LPAREN) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==LBRACK) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==LCURLY) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==NAME) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==INT) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==LONGINT) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==FLOAT) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==COMPLEX) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==DOT) && (synpred6_Python())) {
				alt126=1;
			}
			else if ( (LA126_0==STRING) && (synpred6_Python())) {
				alt126=1;
			}

			switch (alt126) {
				case 1 :
					// Python.g:1860:7: ( ( AWAIT )? atom )=> ( AWAIT )? atom (t+= trailer[$atom.start, $atom.tree] )*
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:1860:24: ( AWAIT )?
					int alt124=2;
					int LA124_0 = input.LA(1);
					if ( (LA124_0==AWAIT) ) {
						alt124=1;
					}
					switch (alt124) {
						case 1 :
							// Python.g:1860:24: AWAIT
							{
							AWAIT256=(Token)match(input,AWAIT,FOLLOW_AWAIT_in_atom_expr6512); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							AWAIT256_tree = (PythonTree)adaptor.create(AWAIT256);
							adaptor.addChild(root_0, AWAIT256_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_atom_in_atom_expr6515);
					atom257=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atom257.getTree());

					// Python.g:1860:36: (t+= trailer[$atom.start, $atom.tree] )*
					loop125:
					while (true) {
						int alt125=2;
						int LA125_0 = input.LA(1);
						if ( (LA125_0==DOT||LA125_0==LBRACK||LA125_0==LPAREN) ) {
							alt125=1;
						}

						switch (alt125) {
						case 1 :
							// Python.g:1860:37: t+= trailer[$atom.start, $atom.tree]
							{
							pushFollow(FOLLOW_trailer_in_atom_expr6520);
							t=trailer((atom257!=null?(atom257.start):null), (atom257!=null?((PythonTree)atom257.getTree()):null));
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

							if (list_t==null) list_t=new ArrayList<Object>();
							list_t.add(t.getTree());
							}
							break;

						default :
							break loop125;
						}
					}

					if ( state.backtracking==0 ) {
					          retval.lparen = (atom257!=null?((PythonParser.atom_return)atom257).lparen:null);
					          //XXX: This could be better.
					          retval.etype = actions.castExpr((atom257!=null?((PythonTree)atom257.getTree()):null));
					          if (list_t != null) {
					              for(Object o : list_t) {
					                  actions.recurseSetContext(retval.etype, expr_contextType.Load);
					                  if (o instanceof Call) {
					                      Call c = (Call)o;
					                      c.setFunc((PyObject)retval.etype);
					                      retval.etype = c;
					                  } else if (o instanceof Subscript) {
					                      Subscript c = (Subscript)o;
					                      c.setValue((PyObject)retval.etype);
					                      retval.etype = c;
					                  } else if (o instanceof Attribute) {
					                      Attribute c = (Attribute)o;
					                      c.setCharStartIndex(retval.etype.getCharStartIndex());
					                      c.setValue((PyObject)retval.etype);
					                      retval.etype = c;
					                  }
					              }
					          }
					          if (AWAIT256 != null) {
					              retval.etype = new Await(AWAIT256, retval.etype);
					          }
					      }
					}
					break;
				case 2 :
					// Python.g:1889:7: AWAIT
					{
					root_0 = (PythonTree)adaptor.nil();


					AWAIT258=(Token)match(input,AWAIT,FOLLOW_AWAIT_in_atom_expr6544); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AWAIT258_tree = (PythonTree)adaptor.create(AWAIT258);
					adaptor.addChild(root_0, AWAIT258_tree);
					}

					if ( state.backtracking==0 ) {
					          retval.etype = new Name(AWAIT258, (AWAIT258!=null?AWAIT258.getText():null), expr_contextType.Load);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom_expr"


	public static class atom_return extends ParserRuleReturnScope {
		public Token lparen = null;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// Python.g:1900:1: atom returns [Token lparen = null] : ( LPAREN ( yield_expr | testlist_comp[$LPAREN] -> testlist_comp |) RPAREN | LBRACK ( testlist_comp[$LBRACK] -> testlist_comp |) RBRACK | LCURLY ( dictorsetmaker[$LCURLY] -> dictorsetmaker |) RCURLY | NAME | INT | LONGINT | FLOAT | COMPLEX |d= DOT DOT DOT | (S+= STRING )+ );
	public final PythonParser.atom_return atom() throws RecognitionException {
		PythonParser.atom_return retval = new PythonParser.atom_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token d=null;
		Token LPAREN259=null;
		Token RPAREN262=null;
		Token LBRACK263=null;
		Token RBRACK265=null;
		Token LCURLY266=null;
		Token RCURLY268=null;
		Token NAME269=null;
		Token INT270=null;
		Token LONGINT271=null;
		Token FLOAT272=null;
		Token COMPLEX273=null;
		Token DOT274=null;
		Token DOT275=null;
		Token S=null;
		List<Object> list_S=null;
		ParserRuleReturnScope yield_expr260 =null;
		ParserRuleReturnScope testlist_comp261 =null;
		ParserRuleReturnScope testlist_comp264 =null;
		ParserRuleReturnScope dictorsetmaker267 =null;

		PythonTree d_tree=null;
		PythonTree LPAREN259_tree=null;
		PythonTree RPAREN262_tree=null;
		PythonTree LBRACK263_tree=null;
		PythonTree RBRACK265_tree=null;
		PythonTree LCURLY266_tree=null;
		PythonTree RCURLY268_tree=null;
		PythonTree NAME269_tree=null;
		PythonTree INT270_tree=null;
		PythonTree LONGINT271_tree=null;
		PythonTree FLOAT272_tree=null;
		PythonTree COMPLEX273_tree=null;
		PythonTree DOT274_tree=null;
		PythonTree DOT275_tree=null;
		PythonTree S_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
		RewriteRuleSubtreeStream stream_testlist_comp=new RewriteRuleSubtreeStream(adaptor,"rule testlist_comp");
		RewriteRuleSubtreeStream stream_yield_expr=new RewriteRuleSubtreeStream(adaptor,"rule yield_expr");
		RewriteRuleSubtreeStream stream_dictorsetmaker=new RewriteRuleSubtreeStream(adaptor,"rule dictorsetmaker");


		    expr etype = null;

		try {
			// Python.g:1910:5: ( LPAREN ( yield_expr | testlist_comp[$LPAREN] -> testlist_comp |) RPAREN | LBRACK ( testlist_comp[$LBRACK] -> testlist_comp |) RBRACK | LCURLY ( dictorsetmaker[$LCURLY] -> dictorsetmaker |) RCURLY | NAME | INT | LONGINT | FLOAT | COMPLEX |d= DOT DOT DOT | (S+= STRING )+ )
			int alt131=10;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt131=1;
				}
				break;
			case LBRACK:
				{
				alt131=2;
				}
				break;
			case LCURLY:
				{
				alt131=3;
				}
				break;
			case NAME:
				{
				alt131=4;
				}
				break;
			case INT:
				{
				alt131=5;
				}
				break;
			case LONGINT:
				{
				alt131=6;
				}
				break;
			case FLOAT:
				{
				alt131=7;
				}
				break;
			case COMPLEX:
				{
				alt131=8;
				}
				break;
			case DOT:
				{
				alt131=9;
				}
				break;
			case STRING:
				{
				alt131=10;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 131, 0, input);
				throw nvae;
			}
			switch (alt131) {
				case 1 :
					// Python.g:1910:7: LPAREN ( yield_expr | testlist_comp[$LPAREN] -> testlist_comp |) RPAREN
					{
					LPAREN259=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom6592); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN259);

					if ( state.backtracking==0 ) {
					          retval.lparen = LPAREN259;
					      }
					// Python.g:1914:7: ( yield_expr | testlist_comp[$LPAREN] -> testlist_comp |)
					int alt127=3;
					switch ( input.LA(1) ) {
					case YIELD:
						{
						alt127=1;
						}
						break;
					case AWAIT:
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
						{
						alt127=2;
						}
						break;
					case RPAREN:
						{
						alt127=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 127, 0, input);
						throw nvae;
					}
					switch (alt127) {
						case 1 :
							// Python.g:1914:9: yield_expr
							{
							pushFollow(FOLLOW_yield_expr_in_atom6610);
							yield_expr260=yield_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_yield_expr.add(yield_expr260.getTree());
							if ( state.backtracking==0 ) {
							            etype = (yield_expr260!=null?((PythonParser.yield_expr_return)yield_expr260).etype:null);
							        }
							}
							break;
						case 2 :
							// Python.g:1918:9: testlist_comp[$LPAREN]
							{
							pushFollow(FOLLOW_testlist_comp_in_atom6630);
							testlist_comp261=testlist_comp(LPAREN259);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_testlist_comp.add(testlist_comp261.getTree());
							// AST REWRITE
							// elements: testlist_comp
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (PythonTree)adaptor.nil();
							// 1919:6: -> testlist_comp
							{
								adaptor.addChild(root_0, stream_testlist_comp.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;
						case 3 :
							// Python.g:1921:9: 
							{
							if ( state.backtracking==0 ) {
							            etype = new Tuple(LPAREN259, new ArrayList<expr>(), expr_stack.peek().ctype);
							        }
							}
							break;

					}

					RPAREN262=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom6674); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN262);

					}
					break;
				case 2 :
					// Python.g:1926:7: LBRACK ( testlist_comp[$LBRACK] -> testlist_comp |) RBRACK
					{
					LBRACK263=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_atom6682); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK263);

					// Python.g:1927:7: ( testlist_comp[$LBRACK] -> testlist_comp |)
					int alt128=2;
					int LA128_0 = input.LA(1);
					if ( (LA128_0==AWAIT||LA128_0==COMPLEX||LA128_0==DOT||LA128_0==FLOAT||LA128_0==INT||(LA128_0 >= LAMBDA && LA128_0 <= LCURLY)||(LA128_0 >= LONGINT && LA128_0 <= MINUS)||LA128_0==NAME||LA128_0==NOT||LA128_0==PLUS||LA128_0==STAR||(LA128_0 >= STRING && LA128_0 <= TILDE)) ) {
						alt128=1;
					}
					else if ( (LA128_0==RBRACK) ) {
						alt128=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 128, 0, input);
						throw nvae;
					}

					switch (alt128) {
						case 1 :
							// Python.g:1927:8: testlist_comp[$LBRACK]
							{
							pushFollow(FOLLOW_testlist_comp_in_atom6691);
							testlist_comp264=testlist_comp(LBRACK263);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_testlist_comp.add(testlist_comp264.getTree());
							// AST REWRITE
							// elements: testlist_comp
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (PythonTree)adaptor.nil();
							// 1928:6: -> testlist_comp
							{
								adaptor.addChild(root_0, stream_testlist_comp.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// Python.g:1930:8: 
							{
							if ( state.backtracking==0 ) {
							           etype = new org.jpp.astnodes.ast.List(LBRACK263, new ArrayList<expr>(), expr_stack.peek().ctype);
							       }
							}
							break;

					}

					RBRACK265=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_atom6734); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK265);

					}
					break;
				case 3 :
					// Python.g:1935:7: LCURLY ( dictorsetmaker[$LCURLY] -> dictorsetmaker |) RCURLY
					{
					LCURLY266=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_atom6742); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY266);

					// Python.g:1936:8: ( dictorsetmaker[$LCURLY] -> dictorsetmaker |)
					int alt129=2;
					int LA129_0 = input.LA(1);
					if ( (LA129_0==AWAIT||LA129_0==COMPLEX||LA129_0==DOT||LA129_0==DOUBLESTAR||LA129_0==FLOAT||LA129_0==INT||(LA129_0 >= LAMBDA && LA129_0 <= LCURLY)||(LA129_0 >= LONGINT && LA129_0 <= MINUS)||LA129_0==NAME||LA129_0==NOT||LA129_0==PLUS||LA129_0==STAR||(LA129_0 >= STRING && LA129_0 <= TILDE)) ) {
						alt129=1;
					}
					else if ( (LA129_0==RCURLY) ) {
						alt129=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 129, 0, input);
						throw nvae;
					}

					switch (alt129) {
						case 1 :
							// Python.g:1936:9: dictorsetmaker[$LCURLY]
							{
							pushFollow(FOLLOW_dictorsetmaker_in_atom6752);
							dictorsetmaker267=dictorsetmaker(LCURLY266);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_dictorsetmaker.add(dictorsetmaker267.getTree());
							// AST REWRITE
							// elements: dictorsetmaker
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (PythonTree)adaptor.nil();
							// 1937:7: -> dictorsetmaker
							{
								adaptor.addChild(root_0, stream_dictorsetmaker.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// Python.g:1939:9: 
							{
							if ( state.backtracking==0 ) {
							            etype = new Dict(LCURLY266, new ArrayList<expr>(), new ArrayList<expr>());
							        }
							}
							break;

					}

					RCURLY268=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_atom6800); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY268);

					}
					break;
				case 4 :
					// Python.g:1944:8: NAME
					{
					root_0 = (PythonTree)adaptor.nil();


					NAME269=(Token)match(input,NAME,FOLLOW_NAME_in_atom6809); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME269_tree = (PythonTree)adaptor.create(NAME269);
					adaptor.addChild(root_0, NAME269_tree);
					}

					if ( state.backtracking==0 ) {
					            etype = new Name(NAME269, (NAME269!=null?NAME269.getText():null), expr_stack.peek().ctype);
					       }
					}
					break;
				case 5 :
					// Python.g:1948:8: INT
					{
					root_0 = (PythonTree)adaptor.nil();


					INT270=(Token)match(input,INT,FOLLOW_INT_in_atom6827); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT270_tree = (PythonTree)adaptor.create(INT270);
					adaptor.addChild(root_0, INT270_tree);
					}

					if ( state.backtracking==0 ) {
					           etype = new Num(INT270, actions.makeInt(INT270));
					       }
					}
					break;
				case 6 :
					// Python.g:1952:8: LONGINT
					{
					root_0 = (PythonTree)adaptor.nil();


					LONGINT271=(Token)match(input,LONGINT,FOLLOW_LONGINT_in_atom6845); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LONGINT271_tree = (PythonTree)adaptor.create(LONGINT271);
					adaptor.addChild(root_0, LONGINT271_tree);
					}

					if ( state.backtracking==0 ) {
					           etype = new Num(LONGINT271, actions.makeInt(LONGINT271));
					       }
					}
					break;
				case 7 :
					// Python.g:1956:8: FLOAT
					{
					root_0 = (PythonTree)adaptor.nil();


					FLOAT272=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atom6863); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT272_tree = (PythonTree)adaptor.create(FLOAT272);
					adaptor.addChild(root_0, FLOAT272_tree);
					}

					if ( state.backtracking==0 ) {
					           etype = new Num(FLOAT272, actions.makeFloat(FLOAT272));
					       }
					}
					break;
				case 8 :
					// Python.g:1960:8: COMPLEX
					{
					root_0 = (PythonTree)adaptor.nil();


					COMPLEX273=(Token)match(input,COMPLEX,FOLLOW_COMPLEX_in_atom6881); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMPLEX273_tree = (PythonTree)adaptor.create(COMPLEX273);
					adaptor.addChild(root_0, COMPLEX273_tree);
					}

					if ( state.backtracking==0 ) {
					           etype = new Num(COMPLEX273, actions.makeComplex(COMPLEX273));
					       }
					}
					break;
				case 9 :
					// Python.g:1964:8: d= DOT DOT DOT
					{
					root_0 = (PythonTree)adaptor.nil();


					d=(Token)match(input,DOT,FOLLOW_DOT_in_atom6901); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					d_tree = (PythonTree)adaptor.create(d);
					adaptor.addChild(root_0, d_tree);
					}

					DOT274=(Token)match(input,DOT,FOLLOW_DOT_in_atom6903); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOT274_tree = (PythonTree)adaptor.create(DOT274);
					adaptor.addChild(root_0, DOT274_tree);
					}

					DOT275=(Token)match(input,DOT,FOLLOW_DOT_in_atom6905); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOT275_tree = (PythonTree)adaptor.create(DOT275);
					adaptor.addChild(root_0, DOT275_tree);
					}

					if ( state.backtracking==0 ) {
					          etype = new Ellipsis(d);
					       }
					}
					break;
				case 10 :
					// Python.g:1968:8: (S+= STRING )+
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:1968:8: (S+= STRING )+
					int cnt130=0;
					loop130:
					while (true) {
						int alt130=2;
						int LA130_0 = input.LA(1);
						if ( (LA130_0==STRING) ) {
							alt130=1;
						}

						switch (alt130) {
						case 1 :
							// Python.g:1968:9: S+= STRING
							{
							S=(Token)match(input,STRING,FOLLOW_STRING_in_atom6926); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							S_tree = (PythonTree)adaptor.create(S);
							adaptor.addChild(root_0, S_tree);
							}

							if (list_S==null) list_S=new ArrayList<Object>();
							list_S.add(S);
							}
							break;

						default :
							if ( cnt130 >= 1 ) break loop130;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(130, input);
							throw eee;
						}
						cnt130++;
					}

					if ( state.backtracking==0 ) {
					           Object str = actions.extractStrings(list_S, encoding, unicodeLiterals);
					           if (str instanceof String) {
					               etype = new Bytes(actions.extractStringToken(list_S), (String) str);
					           } else {
					               etype = new Str(actions.extractStringToken(list_S), str);
					           }
					       }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   if (etype != null) {
			       retval.tree = etype;
			   }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class testlist_comp_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "testlist_comp"
	// Python.g:1980:1: testlist_comp[Token lpar] :t+= test_or_star_expr[$expr::ctype] ( ( options {k=2; } :c1= COMMA t+= test_or_star_expr[$expr::ctype] )* (c2= COMMA )? {...}?|| ( comp_for[gens] ) ) ;
	public final PythonParser.testlist_comp_return testlist_comp(Token lpar) throws RecognitionException {
		PythonParser.testlist_comp_return retval = new PythonParser.testlist_comp_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token c1=null;
		Token c2=null;
		List<Object> list_t=null;
		ParserRuleReturnScope comp_for276 =null;
		RuleReturnScope t = null;
		PythonTree c1_tree=null;
		PythonTree c2_tree=null;


		    expr etype = null;
		    List gens = new ArrayList();

		try {
			// Python.g:1990:5: (t+= test_or_star_expr[$expr::ctype] ( ( options {k=2; } :c1= COMMA t+= test_or_star_expr[$expr::ctype] )* (c2= COMMA )? {...}?|| ( comp_for[gens] ) ) )
			// Python.g:1990:7: t+= test_or_star_expr[$expr::ctype] ( ( options {k=2; } :c1= COMMA t+= test_or_star_expr[$expr::ctype] )* (c2= COMMA )? {...}?|| ( comp_for[gens] ) )
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_test_or_star_expr_in_testlist_comp6969);
			t=test_or_star_expr(expr_stack.peek().ctype);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

			if (list_t==null) list_t=new ArrayList<Object>();
			list_t.add(t.getTree());
			// Python.g:1991:9: ( ( options {k=2; } :c1= COMMA t+= test_or_star_expr[$expr::ctype] )* (c2= COMMA )? {...}?|| ( comp_for[gens] ) )
			int alt134=3;
			switch ( input.LA(1) ) {
			case COMMA:
				{
				alt134=1;
				}
				break;
			case RPAREN:
				{
				int LA134_2 = input.LA(2);
				if ( (( c1 != null || c2 != null )) ) {
					alt134=1;
				}
				else if ( (true) ) {
					alt134=2;
				}

				}
				break;
			case RBRACK:
				{
				int LA134_3 = input.LA(2);
				if ( (( c1 != null || c2 != null )) ) {
					alt134=1;
				}
				else if ( (true) ) {
					alt134=2;
				}

				}
				break;
			case FOR:
				{
				alt134=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 134, 0, input);
				throw nvae;
			}
			switch (alt134) {
				case 1 :
					// Python.g:1991:11: ( options {k=2; } :c1= COMMA t+= test_or_star_expr[$expr::ctype] )* (c2= COMMA )? {...}?
					{
					// Python.g:1991:11: ( options {k=2; } :c1= COMMA t+= test_or_star_expr[$expr::ctype] )*
					loop132:
					while (true) {
						int alt132=2;
						int LA132_0 = input.LA(1);
						if ( (LA132_0==COMMA) ) {
							int LA132_1 = input.LA(2);
							if ( (LA132_1==AWAIT||LA132_1==COMPLEX||LA132_1==DOT||LA132_1==FLOAT||LA132_1==INT||(LA132_1 >= LAMBDA && LA132_1 <= LCURLY)||(LA132_1 >= LONGINT && LA132_1 <= MINUS)||LA132_1==NAME||LA132_1==NOT||LA132_1==PLUS||LA132_1==STAR||(LA132_1 >= STRING && LA132_1 <= TILDE)) ) {
								alt132=1;
							}

						}

						switch (alt132) {
						case 1 :
							// Python.g:1991:28: c1= COMMA t+= test_or_star_expr[$expr::ctype]
							{
							c1=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist_comp6993); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							c1_tree = (PythonTree)adaptor.create(c1);
							adaptor.addChild(root_0, c1_tree);
							}

							pushFollow(FOLLOW_test_or_star_expr_in_testlist_comp6997);
							t=test_or_star_expr(expr_stack.peek().ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

							if (list_t==null) list_t=new ArrayList<Object>();
							list_t.add(t.getTree());
							}
							break;

						default :
							break loop132;
						}
					}

					// Python.g:1991:74: (c2= COMMA )?
					int alt133=2;
					int LA133_0 = input.LA(1);
					if ( (LA133_0==COMMA) ) {
						alt133=1;
					}
					switch (alt133) {
						case 1 :
							// Python.g:1991:75: c2= COMMA
							{
							c2=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist_comp7005); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							c2_tree = (PythonTree)adaptor.create(c2);
							adaptor.addChild(root_0, c2_tree);
							}

							}
							break;

					}

					if ( !(( c1 != null || c2 != null )) ) {
						if (state.backtracking>0) {state.failed=true; return retval;}
						throw new FailedPredicateException(input, "testlist_comp", " $c1 != null || $c2 != null ");
					}
					if ( state.backtracking==0 ) {
					               if (lpar.getText().equals("(")) {
					                  etype = new Tuple(lpar, actions.castExprs(list_t), expr_stack.peek().ctype);
					               } else {
					                  etype = new org.jpp.astnodes.ast.List(lpar, actions.castExprs(list_t), expr_stack.peek().ctype);
					               }
					           }
					}
					break;
				case 2 :
					// Python.g:2001:12: 
					{
					if ( state.backtracking==0 ) {
					               if (lpar.getText().equals("[")) {
					                  etype = new org.jpp.astnodes.ast.List(lpar, actions.castExprs(list_t), expr_stack.peek().ctype);
					               }
					           }
					}
					break;
				case 3 :
					// Python.g:2006:11: ( comp_for[gens] )
					{
					// Python.g:2006:11: ( comp_for[gens] )
					// Python.g:2006:12: comp_for[gens]
					{
					pushFollow(FOLLOW_comp_for_in_testlist_comp7067);
					comp_for276=comp_for(gens);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_for276.getTree());

					if ( state.backtracking==0 ) {
					               Collections.reverse(gens);
					               List<comprehension> c = gens;
					               expr e = actions.castExpr(list_t.get(0));
					               if (e instanceof Context) {
					                   ((Context)e).setContext(expr_contextType.Load);
					               }

					               if (lpar.getText().equals("(")) {
					                  etype = new GeneratorExp((retval.start), e, c);
					               } else {
					                  etype = new ListComp((retval.start), e, c);
					               }
					           }
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "testlist_comp"


	public static class lambdef_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "lambdef"
	// Python.g:2026:1: lambdef : LAMBDA ( varargslist )? COLON test[expr_contextType.Load] ;
	public final PythonParser.lambdef_return lambdef() throws RecognitionException {
		PythonParser.lambdef_return retval = new PythonParser.lambdef_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LAMBDA277=null;
		Token COLON279=null;
		ParserRuleReturnScope varargslist278 =null;
		ParserRuleReturnScope test280 =null;

		PythonTree LAMBDA277_tree=null;
		PythonTree COLON279_tree=null;


		    expr etype = null;

		try {
			// Python.g:2033:5: ( LAMBDA ( varargslist )? COLON test[expr_contextType.Load] )
			// Python.g:2033:7: LAMBDA ( varargslist )? COLON test[expr_contextType.Load]
			{
			root_0 = (PythonTree)adaptor.nil();


			LAMBDA277=(Token)match(input,LAMBDA,FOLLOW_LAMBDA_in_lambdef7131); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LAMBDA277_tree = (PythonTree)adaptor.create(LAMBDA277);
			adaptor.addChild(root_0, LAMBDA277_tree);
			}

			// Python.g:2033:14: ( varargslist )?
			int alt135=2;
			int LA135_0 = input.LA(1);
			if ( (LA135_0==DOUBLESTAR||LA135_0==NAME||LA135_0==STAR) ) {
				alt135=1;
			}
			switch (alt135) {
				case 1 :
					// Python.g:2033:15: varargslist
					{
					pushFollow(FOLLOW_varargslist_in_lambdef7134);
					varargslist278=varargslist();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, varargslist278.getTree());

					}
					break;

			}

			COLON279=(Token)match(input,COLON,FOLLOW_COLON_in_lambdef7138); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON279_tree = (PythonTree)adaptor.create(COLON279);
			adaptor.addChild(root_0, COLON279_tree);
			}

			pushFollow(FOLLOW_test_in_lambdef7140);
			test280=test(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, test280.getTree());

			if ( state.backtracking==0 ) {
			          arguments a = (varargslist278!=null?((PythonParser.varargslist_return)varargslist278).args:null);
			          if (a == null) {
			              a = new arguments(LAMBDA277, new ArrayList<arg>(), (arg)null,
			              new ArrayList<arg>(), new ArrayList<expr>(), (arg)null, new ArrayList<expr>());
			          }
			          etype = new Lambda(LAMBDA277, a, actions.castExpr((test280!=null?((PythonTree)test280.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lambdef"


	public static class lambdef_nocond_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "lambdef_nocond"
	// Python.g:2045:1: lambdef_nocond : LAMBDA ( varargslist )? COLON test_nocond[expr_contextType.Load] ;
	public final PythonParser.lambdef_nocond_return lambdef_nocond() throws RecognitionException {
		PythonParser.lambdef_nocond_return retval = new PythonParser.lambdef_nocond_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LAMBDA281=null;
		Token COLON283=null;
		ParserRuleReturnScope varargslist282 =null;
		ParserRuleReturnScope test_nocond284 =null;

		PythonTree LAMBDA281_tree=null;
		PythonTree COLON283_tree=null;


		    expr etype = null;

		try {
			// Python.g:2052:5: ( LAMBDA ( varargslist )? COLON test_nocond[expr_contextType.Load] )
			// Python.g:2052:7: LAMBDA ( varargslist )? COLON test_nocond[expr_contextType.Load]
			{
			root_0 = (PythonTree)adaptor.nil();


			LAMBDA281=(Token)match(input,LAMBDA,FOLLOW_LAMBDA_in_lambdef_nocond7177); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LAMBDA281_tree = (PythonTree)adaptor.create(LAMBDA281);
			adaptor.addChild(root_0, LAMBDA281_tree);
			}

			// Python.g:2052:14: ( varargslist )?
			int alt136=2;
			int LA136_0 = input.LA(1);
			if ( (LA136_0==DOUBLESTAR||LA136_0==NAME||LA136_0==STAR) ) {
				alt136=1;
			}
			switch (alt136) {
				case 1 :
					// Python.g:2052:15: varargslist
					{
					pushFollow(FOLLOW_varargslist_in_lambdef_nocond7180);
					varargslist282=varargslist();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, varargslist282.getTree());

					}
					break;

			}

			COLON283=(Token)match(input,COLON,FOLLOW_COLON_in_lambdef_nocond7184); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON283_tree = (PythonTree)adaptor.create(COLON283);
			adaptor.addChild(root_0, COLON283_tree);
			}

			pushFollow(FOLLOW_test_nocond_in_lambdef_nocond7186);
			test_nocond284=test_nocond(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, test_nocond284.getTree());

			if ( state.backtracking==0 ) {
			          arguments a = (varargslist282!=null?((PythonParser.varargslist_return)varargslist282).args:null);
			          if (a == null) {
			              a = new arguments(LAMBDA281, new ArrayList<arg>(), (arg)null, new ArrayList<arg>(), new ArrayList<expr>(), (arg) null, new ArrayList<expr>());
			          }
			          etype = new Lambda(LAMBDA281, a, actions.castExpr((test_nocond284!=null?((PythonTree)test_nocond284.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lambdef_nocond"


	public static class trailer_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "trailer"
	// Python.g:2064:1: trailer[Token begin, PythonTree ptree] : ( LPAREN ( arglist |) RPAREN | LBRACK subscriptlist[$begin] RBRACK | DOT attr );
	public final PythonParser.trailer_return trailer(Token begin, PythonTree ptree) throws RecognitionException {
		PythonParser.trailer_return retval = new PythonParser.trailer_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token LPAREN285=null;
		Token RPAREN287=null;
		Token LBRACK288=null;
		Token RBRACK290=null;
		Token DOT291=null;
		ParserRuleReturnScope arglist286 =null;
		ParserRuleReturnScope subscriptlist289 =null;
		ParserRuleReturnScope attr292 =null;

		PythonTree LPAREN285_tree=null;
		PythonTree RPAREN287_tree=null;
		PythonTree LBRACK288_tree=null;
		PythonTree RBRACK290_tree=null;
		PythonTree DOT291_tree=null;


		    expr etype = null;

		try {
			// Python.g:2073:5: ( LPAREN ( arglist |) RPAREN | LBRACK subscriptlist[$begin] RBRACK | DOT attr )
			int alt138=3;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt138=1;
				}
				break;
			case LBRACK:
				{
				alt138=2;
				}
				break;
			case DOT:
				{
				alt138=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 138, 0, input);
				throw nvae;
			}
			switch (alt138) {
				case 1 :
					// Python.g:2073:7: LPAREN ( arglist |) RPAREN
					{
					root_0 = (PythonTree)adaptor.nil();


					LPAREN285=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_trailer7226); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LPAREN285_tree = (PythonTree)adaptor.create(LPAREN285);
					adaptor.addChild(root_0, LPAREN285_tree);
					}

					// Python.g:2074:7: ( arglist |)
					int alt137=2;
					int LA137_0 = input.LA(1);
					if ( (LA137_0==AWAIT||LA137_0==COMPLEX||LA137_0==DOT||LA137_0==DOUBLESTAR||LA137_0==FLOAT||LA137_0==INT||(LA137_0 >= LAMBDA && LA137_0 <= LCURLY)||(LA137_0 >= LONGINT && LA137_0 <= MINUS)||LA137_0==NAME||LA137_0==NOT||LA137_0==PLUS||LA137_0==STAR||(LA137_0 >= STRING && LA137_0 <= TILDE)) ) {
						alt137=1;
					}
					else if ( (LA137_0==RPAREN) ) {
						alt137=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 137, 0, input);
						throw nvae;
					}

					switch (alt137) {
						case 1 :
							// Python.g:2074:8: arglist
							{
							pushFollow(FOLLOW_arglist_in_trailer7235);
							arglist286=arglist();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, arglist286.getTree());

							if ( state.backtracking==0 ) {
							           etype = new Call(begin, actions.castExpr(ptree), actions.castExprs((arglist286!=null?((PythonParser.arglist_return)arglist286).args:null)),
							             actions.makeKeywords((arglist286!=null?((PythonParser.arglist_return)arglist286).keywords:null)));
							       }
							}
							break;
						case 2 :
							// Python.g:2080:8: 
							{
							if ( state.backtracking==0 ) {
							           etype = new Call(begin, actions.castExpr(ptree), new ArrayList<expr>(), new ArrayList<keyword>());
							       }
							}
							break;

					}

					RPAREN287=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_trailer7277); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RPAREN287_tree = (PythonTree)adaptor.create(RPAREN287);
					adaptor.addChild(root_0, RPAREN287_tree);
					}

					}
					break;
				case 2 :
					// Python.g:2085:7: LBRACK subscriptlist[$begin] RBRACK
					{
					root_0 = (PythonTree)adaptor.nil();


					LBRACK288=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_trailer7285); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK288_tree = (PythonTree)adaptor.create(LBRACK288);
					adaptor.addChild(root_0, LBRACK288_tree);
					}

					pushFollow(FOLLOW_subscriptlist_in_trailer7287);
					subscriptlist289=subscriptlist(begin);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, subscriptlist289.getTree());

					RBRACK290=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_trailer7290); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK290_tree = (PythonTree)adaptor.create(RBRACK290);
					adaptor.addChild(root_0, RBRACK290_tree);
					}

					if ( state.backtracking==0 ) {
					          etype = new Subscript(begin, actions.castExpr(ptree), actions.castSlice((subscriptlist289!=null?((PythonTree)subscriptlist289.getTree()):null)), expr_stack.peek().ctype);
					      }
					}
					break;
				case 3 :
					// Python.g:2089:7: DOT attr
					{
					root_0 = (PythonTree)adaptor.nil();


					DOT291=(Token)match(input,DOT,FOLLOW_DOT_in_trailer7306); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOT291_tree = (PythonTree)adaptor.create(DOT291);
					adaptor.addChild(root_0, DOT291_tree);
					}

					pushFollow(FOLLOW_attr_in_trailer7308);
					attr292=attr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, attr292.getTree());

					if ( state.backtracking==0 ) {
					          etype = new Attribute(begin, actions.castExpr(ptree), new Name((attr292!=null?((PythonTree)attr292.getTree()):null), (attr292!=null?input.toString(attr292.start,attr292.stop):null), expr_contextType.Load), expr_stack.peek().ctype);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "trailer"


	public static class subscriptlist_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "subscriptlist"
	// Python.g:2096:1: subscriptlist[Token begin] :sub+= subscript ( options {greedy=true; } :c1= COMMA sub+= subscript )* (c2= COMMA )? ;
	public final PythonParser.subscriptlist_return subscriptlist(Token begin) throws RecognitionException {
		PythonParser.subscriptlist_return retval = new PythonParser.subscriptlist_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token c1=null;
		Token c2=null;
		List<Object> list_sub=null;
		RuleReturnScope sub = null;
		PythonTree c1_tree=null;
		PythonTree c2_tree=null;


		    slice sltype = null;

		try {
			// Python.g:2103:5: (sub+= subscript ( options {greedy=true; } :c1= COMMA sub+= subscript )* (c2= COMMA )? )
			// Python.g:2103:7: sub+= subscript ( options {greedy=true; } :c1= COMMA sub+= subscript )* (c2= COMMA )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_subscript_in_subscriptlist7347);
			sub=subscript();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, sub.getTree());

			if (list_sub==null) list_sub=new ArrayList<Object>();
			list_sub.add(sub.getTree());
			// Python.g:2103:22: ( options {greedy=true; } :c1= COMMA sub+= subscript )*
			loop139:
			while (true) {
				int alt139=2;
				int LA139_0 = input.LA(1);
				if ( (LA139_0==COMMA) ) {
					int LA139_1 = input.LA(2);
					if ( (LA139_1==AWAIT||LA139_1==COLON||LA139_1==COMPLEX||LA139_1==DOT||LA139_1==FLOAT||LA139_1==INT||(LA139_1 >= LAMBDA && LA139_1 <= LCURLY)||(LA139_1 >= LONGINT && LA139_1 <= MINUS)||LA139_1==NAME||LA139_1==NOT||LA139_1==PLUS||(LA139_1 >= STRING && LA139_1 <= TILDE)) ) {
						alt139=1;
					}

				}

				switch (alt139) {
				case 1 :
					// Python.g:2103:46: c1= COMMA sub+= subscript
					{
					c1=(Token)match(input,COMMA,FOLLOW_COMMA_in_subscriptlist7359); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					c1_tree = (PythonTree)adaptor.create(c1);
					adaptor.addChild(root_0, c1_tree);
					}

					pushFollow(FOLLOW_subscript_in_subscriptlist7363);
					sub=subscript();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, sub.getTree());

					if (list_sub==null) list_sub=new ArrayList<Object>();
					list_sub.add(sub.getTree());
					}
					break;

				default :
					break loop139;
				}
			}

			// Python.g:2103:72: (c2= COMMA )?
			int alt140=2;
			int LA140_0 = input.LA(1);
			if ( (LA140_0==COMMA) ) {
				alt140=1;
			}
			switch (alt140) {
				case 1 :
					// Python.g:2103:73: c2= COMMA
					{
					c2=(Token)match(input,COMMA,FOLLOW_COMMA_in_subscriptlist7370); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					c2_tree = (PythonTree)adaptor.create(c2);
					adaptor.addChild(root_0, c2_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          sltype = actions.makeSliceType(begin, c1, c2, list_sub);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = sltype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "subscriptlist"


	public static class subscript_return extends ParserRuleReturnScope {
		public slice sltype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "subscript"
	// Python.g:2110:1: subscript returns [slice sltype] : ( ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )? | ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )? | test[expr_contextType.Load] );
	public final PythonParser.subscript_return subscript() throws RecognitionException {
		PythonParser.subscript_return retval = new PythonParser.subscript_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token c1=null;
		Token c2=null;
		ParserRuleReturnScope lower =null;
		ParserRuleReturnScope upper1 =null;
		ParserRuleReturnScope upper2 =null;
		ParserRuleReturnScope sliceop293 =null;
		ParserRuleReturnScope sliceop294 =null;
		ParserRuleReturnScope test295 =null;

		PythonTree c1_tree=null;
		PythonTree c2_tree=null;

		try {
			// Python.g:2115:5: ( ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )? | ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )? | test[expr_contextType.Load] )
			int alt146=3;
			int LA146_0 = input.LA(1);
			if ( (LA146_0==NOT) ) {
				int LA146_1 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==PLUS) ) {
				int LA146_2 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==MINUS) ) {
				int LA146_3 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==TILDE) ) {
				int LA146_4 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==AWAIT) ) {
				int LA146_5 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==LPAREN) ) {
				int LA146_6 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==LBRACK) ) {
				int LA146_7 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==LCURLY) ) {
				int LA146_8 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==NAME) ) {
				int LA146_9 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==INT) ) {
				int LA146_10 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==LONGINT) ) {
				int LA146_11 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==FLOAT) ) {
				int LA146_12 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==COMPLEX) ) {
				int LA146_13 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==DOT) ) {
				int LA146_14 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==STRING) ) {
				int LA146_15 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==LAMBDA) ) {
				int LA146_16 = input.LA(2);
				if ( (synpred7_Python()) ) {
					alt146=1;
				}
				else if ( (true) ) {
					alt146=3;
				}

			}
			else if ( (LA146_0==COLON) && (synpred8_Python())) {
				alt146=2;
			}

			switch (alt146) {
				case 1 :
					// Python.g:2115:7: ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )?
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_test_in_subscript7425);
					lower=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lower.getTree());

					// Python.g:2116:41: (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )?
					int alt143=2;
					int LA143_0 = input.LA(1);
					if ( (LA143_0==COLON) ) {
						alt143=1;
					}
					switch (alt143) {
						case 1 :
							// Python.g:2116:42: c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )?
							{
							c1=(Token)match(input,COLON,FOLLOW_COLON_in_subscript7431); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							c1_tree = (PythonTree)adaptor.create(c1);
							adaptor.addChild(root_0, c1_tree);
							}

							// Python.g:2116:51: (upper1= test[expr_contextType.Load] )?
							int alt141=2;
							int LA141_0 = input.LA(1);
							if ( (LA141_0==AWAIT||LA141_0==COMPLEX||LA141_0==DOT||LA141_0==FLOAT||LA141_0==INT||(LA141_0 >= LAMBDA && LA141_0 <= LCURLY)||(LA141_0 >= LONGINT && LA141_0 <= MINUS)||LA141_0==NAME||LA141_0==NOT||LA141_0==PLUS||(LA141_0 >= STRING && LA141_0 <= TILDE)) ) {
								alt141=1;
							}
							switch (alt141) {
								case 1 :
									// Python.g:2116:52: upper1= test[expr_contextType.Load]
									{
									pushFollow(FOLLOW_test_in_subscript7436);
									upper1=test(expr_contextType.Load);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, upper1.getTree());

									}
									break;

							}

							// Python.g:2116:89: ( sliceop )?
							int alt142=2;
							int LA142_0 = input.LA(1);
							if ( (LA142_0==COLON) ) {
								alt142=1;
							}
							switch (alt142) {
								case 1 :
									// Python.g:2116:90: sliceop
									{
									pushFollow(FOLLOW_sliceop_in_subscript7442);
									sliceop293=sliceop();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, sliceop293.getTree());

									}
									break;

							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          retval.sltype = actions.makeSubscript((lower!=null?((PythonTree)lower.getTree()):null), c1, (upper1!=null?((PythonTree)upper1.getTree()):null), (sliceop293!=null?((PythonTree)sliceop293.getTree()):null));
					      }
					}
					break;
				case 2 :
					// Python.g:2120:7: ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )?
					{
					root_0 = (PythonTree)adaptor.nil();


					c2=(Token)match(input,COLON,FOLLOW_COLON_in_subscript7473); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					c2_tree = (PythonTree)adaptor.create(c2);
					adaptor.addChild(root_0, c2_tree);
					}

					// Python.g:2121:16: (upper2= test[expr_contextType.Load] )?
					int alt144=2;
					int LA144_0 = input.LA(1);
					if ( (LA144_0==AWAIT||LA144_0==COMPLEX||LA144_0==DOT||LA144_0==FLOAT||LA144_0==INT||(LA144_0 >= LAMBDA && LA144_0 <= LCURLY)||(LA144_0 >= LONGINT && LA144_0 <= MINUS)||LA144_0==NAME||LA144_0==NOT||LA144_0==PLUS||(LA144_0 >= STRING && LA144_0 <= TILDE)) ) {
						alt144=1;
					}
					switch (alt144) {
						case 1 :
							// Python.g:2121:17: upper2= test[expr_contextType.Load]
							{
							pushFollow(FOLLOW_test_in_subscript7478);
							upper2=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, upper2.getTree());

							}
							break;

					}

					// Python.g:2121:54: ( sliceop )?
					int alt145=2;
					int LA145_0 = input.LA(1);
					if ( (LA145_0==COLON) ) {
						alt145=1;
					}
					switch (alt145) {
						case 1 :
							// Python.g:2121:55: sliceop
							{
							pushFollow(FOLLOW_sliceop_in_subscript7484);
							sliceop294=sliceop();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, sliceop294.getTree());

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          retval.sltype = actions.makeSubscript(null, c2, (upper2!=null?((PythonTree)upper2.getTree()):null), (sliceop294!=null?((PythonTree)sliceop294.getTree()):null));
					      }
					}
					break;
				case 3 :
					// Python.g:2125:7: test[expr_contextType.Load]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_test_in_subscript7502);
					test295=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test295.getTree());

					if ( state.backtracking==0 ) {
					          retval.sltype = new Index((test295!=null?(test295.start):null), actions.castExpr((test295!=null?((PythonTree)test295.getTree()):null)));
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    retval.tree = retval.sltype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "subscript"


	public static class sliceop_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "sliceop"
	// Python.g:2132:1: sliceop : COLON ( test[expr_contextType.Load] -> test |) ;
	public final PythonParser.sliceop_return sliceop() throws RecognitionException {
		PythonParser.sliceop_return retval = new PythonParser.sliceop_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COLON296=null;
		ParserRuleReturnScope test297 =null;

		PythonTree COLON296_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");


		    expr etype = null;

		try {
			// Python.g:2141:5: ( COLON ( test[expr_contextType.Load] -> test |) )
			// Python.g:2141:7: COLON ( test[expr_contextType.Load] -> test |)
			{
			COLON296=(Token)match(input,COLON,FOLLOW_COLON_in_sliceop7539); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON296);

			// Python.g:2142:6: ( test[expr_contextType.Load] -> test |)
			int alt147=2;
			int LA147_0 = input.LA(1);
			if ( (LA147_0==AWAIT||LA147_0==COMPLEX||LA147_0==DOT||LA147_0==FLOAT||LA147_0==INT||(LA147_0 >= LAMBDA && LA147_0 <= LCURLY)||(LA147_0 >= LONGINT && LA147_0 <= MINUS)||LA147_0==NAME||LA147_0==NOT||LA147_0==PLUS||(LA147_0 >= STRING && LA147_0 <= TILDE)) ) {
				alt147=1;
			}
			else if ( (LA147_0==COMMA||LA147_0==RBRACK) ) {
				alt147=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 147, 0, input);
				throw nvae;
			}

			switch (alt147) {
				case 1 :
					// Python.g:2142:7: test[expr_contextType.Load]
					{
					pushFollow(FOLLOW_test_in_sliceop7547);
					test297=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_test.add(test297.getTree());
					// AST REWRITE
					// elements: test
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (PythonTree)adaptor.nil();
					// 2143:5: -> test
					{
						adaptor.addChild(root_0, stream_test.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// Python.g:2145:8: 
					{
					if ( state.backtracking==0 ) {
					           etype = new Name(COLON296, "None", expr_contextType.Load);
					       }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sliceop"


	public static class exprlist_return extends ParserRuleReturnScope {
		public expr etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "exprlist"
	// Python.g:2152:1: exprlist[expr_contextType ctype] returns [expr etype] : ( ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )? | expr[ctype] );
	public final PythonParser.exprlist_return exprlist(expr_contextType ctype) throws RecognitionException {
		PythonParser.exprlist_return retval = new PythonParser.exprlist_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA298=null;
		Token COMMA299=null;
		List<Object> list_e=null;
		ParserRuleReturnScope expr300 =null;
		RuleReturnScope e = null;
		PythonTree COMMA298_tree=null;
		PythonTree COMMA299_tree=null;

		try {
			// Python.g:2154:5: ( ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )? | expr[ctype] )
			int alt150=2;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				int LA150_1 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case MINUS:
				{
				int LA150_2 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case TILDE:
				{
				int LA150_3 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case AWAIT:
				{
				int LA150_4 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA150_5 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case LBRACK:
				{
				int LA150_6 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case LCURLY:
				{
				int LA150_7 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case NAME:
				{
				int LA150_8 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case INT:
				{
				int LA150_9 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case LONGINT:
				{
				int LA150_10 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA150_11 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case COMPLEX:
				{
				int LA150_12 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case DOT:
				{
				int LA150_13 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			case STRING:
				{
				int LA150_14 = input.LA(2);
				if ( (synpred9_Python()) ) {
					alt150=1;
				}
				else if ( (true) ) {
					alt150=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 150, 0, input);
				throw nvae;
			}
			switch (alt150) {
				case 1 :
					// Python.g:2154:7: ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )?
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_expr_in_exprlist7618);
					e=expr(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if (list_e==null) list_e=new ArrayList<Object>();
					list_e.add(e.getTree());
					// Python.g:2154:44: ( options {k=2; } : COMMA e+= expr[ctype] )*
					loop148:
					while (true) {
						int alt148=2;
						int LA148_0 = input.LA(1);
						if ( (LA148_0==COMMA) ) {
							int LA148_1 = input.LA(2);
							if ( (LA148_1==AWAIT||LA148_1==COMPLEX||LA148_1==DOT||LA148_1==FLOAT||LA148_1==INT||(LA148_1 >= LBRACK && LA148_1 <= LCURLY)||(LA148_1 >= LONGINT && LA148_1 <= MINUS)||LA148_1==NAME||LA148_1==PLUS||(LA148_1 >= STRING && LA148_1 <= TILDE)) ) {
								alt148=1;
							}

						}

						switch (alt148) {
						case 1 :
							// Python.g:2154:61: COMMA e+= expr[ctype]
							{
							COMMA298=(Token)match(input,COMMA,FOLLOW_COMMA_in_exprlist7630); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA298_tree = (PythonTree)adaptor.create(COMMA298);
							adaptor.addChild(root_0, COMMA298_tree);
							}

							pushFollow(FOLLOW_expr_in_exprlist7634);
							e=expr(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

							if (list_e==null) list_e=new ArrayList<Object>();
							list_e.add(e.getTree());
							}
							break;

						default :
							break loop148;
						}
					}

					// Python.g:2154:84: ( COMMA )?
					int alt149=2;
					int LA149_0 = input.LA(1);
					if ( (LA149_0==COMMA) ) {
						alt149=1;
					}
					switch (alt149) {
						case 1 :
							// Python.g:2154:85: COMMA
							{
							COMMA299=(Token)match(input,COMMA,FOLLOW_COMMA_in_exprlist7640); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA299_tree = (PythonTree)adaptor.create(COMMA299);
							adaptor.addChild(root_0, COMMA299_tree);
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					           retval.etype = new Tuple((retval.start), actions.castExprs(list_e), ctype);
					       }
					}
					break;
				case 2 :
					// Python.g:2158:7: expr[ctype]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_expr_in_exprlist7659);
					expr300=expr(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr300.getTree());

					if ( state.backtracking==0 ) {
					        retval.etype = actions.castExpr((expr300!=null?((PythonTree)expr300.getTree()):null));
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprlist"


	public static class del_list_return extends ParserRuleReturnScope {
		public List<expr> etypes;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "del_list"
	// Python.g:2166:1: del_list returns [List<expr> etypes] :e+= expr[expr_contextType.Del] ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )* ( COMMA )? ;
	public final PythonParser.del_list_return del_list() throws RecognitionException {
		PythonParser.del_list_return retval = new PythonParser.del_list_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA301=null;
		Token COMMA302=null;
		List<Object> list_e=null;
		RuleReturnScope e = null;
		PythonTree COMMA301_tree=null;
		PythonTree COMMA302_tree=null;

		try {
			// Python.g:2168:5: (e+= expr[expr_contextType.Del] ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )* ( COMMA )? )
			// Python.g:2168:7: e+= expr[expr_contextType.Del] ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )* ( COMMA )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_del_list7697);
			e=expr(expr_contextType.Del);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if (list_e==null) list_e=new ArrayList<Object>();
			list_e.add(e.getTree());
			// Python.g:2168:37: ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )*
			loop151:
			while (true) {
				int alt151=2;
				int LA151_0 = input.LA(1);
				if ( (LA151_0==COMMA) ) {
					int LA151_1 = input.LA(2);
					if ( (LA151_1==AWAIT||LA151_1==COMPLEX||LA151_1==DOT||LA151_1==FLOAT||LA151_1==INT||(LA151_1 >= LBRACK && LA151_1 <= LCURLY)||(LA151_1 >= LONGINT && LA151_1 <= MINUS)||LA151_1==NAME||LA151_1==PLUS||(LA151_1 >= STRING && LA151_1 <= TILDE)) ) {
						alt151=1;
					}

				}

				switch (alt151) {
				case 1 :
					// Python.g:2168:54: COMMA e+= expr[expr_contextType.Del]
					{
					COMMA301=(Token)match(input,COMMA,FOLLOW_COMMA_in_del_list7709); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA301_tree = (PythonTree)adaptor.create(COMMA301);
					adaptor.addChild(root_0, COMMA301_tree);
					}

					pushFollow(FOLLOW_expr_in_del_list7713);
					e=expr(expr_contextType.Del);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if (list_e==null) list_e=new ArrayList<Object>();
					list_e.add(e.getTree());
					}
					break;

				default :
					break loop151;
				}
			}

			// Python.g:2168:92: ( COMMA )?
			int alt152=2;
			int LA152_0 = input.LA(1);
			if ( (LA152_0==COMMA) ) {
				alt152=1;
			}
			switch (alt152) {
				case 1 :
					// Python.g:2168:93: COMMA
					{
					COMMA302=(Token)match(input,COMMA,FOLLOW_COMMA_in_del_list7719); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA302_tree = (PythonTree)adaptor.create(COMMA302);
					adaptor.addChild(root_0, COMMA302_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          retval.etypes = actions.makeDeleteList(list_e);
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "del_list"


	public static class testlist_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "testlist"
	// Python.g:2175:1: testlist[expr_contextType ctype] : ( ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )? | test[ctype] );
	public final PythonParser.testlist_return testlist(expr_contextType ctype) throws RecognitionException {
		PythonParser.testlist_return retval = new PythonParser.testlist_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA303=null;
		Token COMMA304=null;
		List<Object> list_t=null;
		ParserRuleReturnScope test305 =null;
		RuleReturnScope t = null;
		PythonTree COMMA303_tree=null;
		PythonTree COMMA304_tree=null;


		    expr etype = null;

		try {
			// Python.g:2184:5: ( ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )? | test[ctype] )
			int alt155=2;
			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA155_1 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case PLUS:
				{
				int LA155_2 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case MINUS:
				{
				int LA155_3 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case TILDE:
				{
				int LA155_4 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case AWAIT:
				{
				int LA155_5 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA155_6 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case LBRACK:
				{
				int LA155_7 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case LCURLY:
				{
				int LA155_8 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case NAME:
				{
				int LA155_9 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case INT:
				{
				int LA155_10 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case LONGINT:
				{
				int LA155_11 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA155_12 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case COMPLEX:
				{
				int LA155_13 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case DOT:
				{
				int LA155_14 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case STRING:
				{
				int LA155_15 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			case LAMBDA:
				{
				int LA155_16 = input.LA(2);
				if ( (synpred10_Python()) ) {
					alt155=1;
				}
				else if ( (true) ) {
					alt155=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 155, 0, input);
				throw nvae;
			}
			switch (alt155) {
				case 1 :
					// Python.g:2184:7: ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )?
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_test_in_testlist7772);
					t=test(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					if (list_t==null) list_t=new ArrayList<Object>();
					list_t.add(t.getTree());
					// Python.g:2185:22: ( options {k=2; } : COMMA t+= test[ctype] )*
					loop153:
					while (true) {
						int alt153=2;
						int LA153_0 = input.LA(1);
						if ( (LA153_0==COMMA) ) {
							int LA153_1 = input.LA(2);
							if ( (LA153_1==AWAIT||LA153_1==COMPLEX||LA153_1==DOT||LA153_1==FLOAT||LA153_1==INT||(LA153_1 >= LAMBDA && LA153_1 <= LCURLY)||(LA153_1 >= LONGINT && LA153_1 <= MINUS)||LA153_1==NAME||LA153_1==NOT||LA153_1==PLUS||(LA153_1 >= STRING && LA153_1 <= TILDE)) ) {
								alt153=1;
							}

						}

						switch (alt153) {
						case 1 :
							// Python.g:2185:39: COMMA t+= test[ctype]
							{
							COMMA303=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist7784); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA303_tree = (PythonTree)adaptor.create(COMMA303);
							adaptor.addChild(root_0, COMMA303_tree);
							}

							pushFollow(FOLLOW_test_in_testlist7788);
							t=test(ctype);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

							if (list_t==null) list_t=new ArrayList<Object>();
							list_t.add(t.getTree());
							}
							break;

						default :
							break loop153;
						}
					}

					// Python.g:2185:62: ( COMMA )?
					int alt154=2;
					int LA154_0 = input.LA(1);
					if ( (LA154_0==COMMA) ) {
						alt154=1;
					}
					switch (alt154) {
						case 1 :
							// Python.g:2185:63: COMMA
							{
							COMMA304=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist7794); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA304_tree = (PythonTree)adaptor.create(COMMA304);
							adaptor.addChild(root_0, COMMA304_tree);
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					          etype = new Tuple((retval.start), actions.castExprs(list_t), ctype);
					      }
					}
					break;
				case 2 :
					// Python.g:2189:7: test[ctype]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_test_in_testlist7812);
					test305=test(ctype);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test305.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "testlist"


	public static class dictorsetmaker_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "dictorsetmaker"
	// Python.g:2196:1: dictorsetmaker[Token lcurly] : ( ( test[expr_contextType.Load] COLON | DOUBLESTAR )=> (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) ( comp_for[gens] | ( options {k=2; } : COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) )* ( COMMA )? ) | (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) ( comp_for[gens] | ( COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) )* ( COMMA )? ) );
	public final PythonParser.dictorsetmaker_return dictorsetmaker(Token lcurly) throws RecognitionException {
		PythonParser.dictorsetmaker_return retval = new PythonParser.dictorsetmaker_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COLON306=null;
		Token DOUBLESTAR307=null;
		Token COMMA309=null;
		Token COLON310=null;
		Token DOUBLESTAR311=null;
		Token COMMA312=null;
		Token COMMA314=null;
		Token COMMA315=null;
		List<Object> list_k=null;
		List<Object> list_v=null;
		List<Object> list_uv=null;
		List<Object> list_s=null;
		ParserRuleReturnScope comp_for308 =null;
		ParserRuleReturnScope comp_for313 =null;
		RuleReturnScope k = null;
		RuleReturnScope v = null;
		RuleReturnScope uv = null;
		RuleReturnScope s = null;
		PythonTree COLON306_tree=null;
		PythonTree DOUBLESTAR307_tree=null;
		PythonTree COMMA309_tree=null;
		PythonTree COLON310_tree=null;
		PythonTree DOUBLESTAR311_tree=null;
		PythonTree COMMA312_tree=null;
		PythonTree COMMA314_tree=null;
		PythonTree COMMA315_tree=null;


		    List gens = new ArrayList();
		    expr etype = null;

		try {
			// Python.g:2206:5: ( ( test[expr_contextType.Load] COLON | DOUBLESTAR )=> (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) ( comp_for[gens] | ( options {k=2; } : COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) )* ( COMMA )? ) | (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) ( comp_for[gens] | ( COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) )* ( COMMA )? ) )
			int alt166=2;
			int LA166_0 = input.LA(1);
			if ( (LA166_0==NOT) ) {
				int LA166_1 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==PLUS) ) {
				int LA166_2 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==MINUS) ) {
				int LA166_3 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==TILDE) ) {
				int LA166_4 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==AWAIT) ) {
				int LA166_5 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==LPAREN) ) {
				int LA166_6 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==LBRACK) ) {
				int LA166_7 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==LCURLY) ) {
				int LA166_8 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==NAME) ) {
				int LA166_9 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==INT) ) {
				int LA166_10 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==LONGINT) ) {
				int LA166_11 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==FLOAT) ) {
				int LA166_12 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==COMPLEX) ) {
				int LA166_13 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==DOT) ) {
				int LA166_14 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==STRING) ) {
				int LA166_15 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==LAMBDA) ) {
				int LA166_16 = input.LA(2);
				if ( (synpred11_Python()) ) {
					alt166=1;
				}
				else if ( (true) ) {
					alt166=2;
				}

			}
			else if ( (LA166_0==DOUBLESTAR) && (synpred11_Python())) {
				alt166=1;
			}
			else if ( (LA166_0==STAR) ) {
				alt166=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 166, 0, input);
				throw nvae;
			}

			switch (alt166) {
				case 1 :
					// Python.g:2206:7: ( test[expr_contextType.Load] COLON | DOUBLESTAR )=> (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) ( comp_for[gens] | ( options {k=2; } : COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) )* ( COMMA )? )
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:2206:59: (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] )
					int alt156=2;
					int LA156_0 = input.LA(1);
					if ( (LA156_0==AWAIT||LA156_0==COMPLEX||LA156_0==DOT||LA156_0==FLOAT||LA156_0==INT||(LA156_0 >= LAMBDA && LA156_0 <= LCURLY)||(LA156_0 >= LONGINT && LA156_0 <= MINUS)||LA156_0==NAME||LA156_0==NOT||LA156_0==PLUS||(LA156_0 >= STRING && LA156_0 <= TILDE)) ) {
						alt156=1;
					}
					else if ( (LA156_0==DOUBLESTAR) ) {
						alt156=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 156, 0, input);
						throw nvae;
					}

					switch (alt156) {
						case 1 :
							// Python.g:2206:60: k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load]
							{
							pushFollow(FOLLOW_test_in_dictorsetmaker7861);
							k=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

							if (list_k==null) list_k=new ArrayList<Object>();
							list_k.add(k.getTree());
							COLON306=(Token)match(input,COLON,FOLLOW_COLON_in_dictorsetmaker7864); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COLON306_tree = (PythonTree)adaptor.create(COLON306);
							adaptor.addChild(root_0, COLON306_tree);
							}

							pushFollow(FOLLOW_test_in_dictorsetmaker7868);
							v=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

							if (list_v==null) list_v=new ArrayList<Object>();
							list_v.add(v.getTree());
							}
							break;
						case 2 :
							// Python.g:2206:130: DOUBLESTAR uv+= expr[expr_contextType.Load]
							{
							DOUBLESTAR307=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_dictorsetmaker7873); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DOUBLESTAR307_tree = (PythonTree)adaptor.create(DOUBLESTAR307);
							adaptor.addChild(root_0, DOUBLESTAR307_tree);
							}

							pushFollow(FOLLOW_expr_in_dictorsetmaker7877);
							uv=expr(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, uv.getTree());

							if (list_uv==null) list_uv=new ArrayList<Object>();
							list_uv.add(uv.getTree());
							}
							break;

					}

					// Python.g:2207:10: ( comp_for[gens] | ( options {k=2; } : COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) )* ( COMMA )? )
					int alt160=2;
					int LA160_0 = input.LA(1);
					if ( (LA160_0==FOR) ) {
						alt160=1;
					}
					else if ( (LA160_0==COMMA||LA160_0==RCURLY) ) {
						alt160=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 160, 0, input);
						throw nvae;
					}

					switch (alt160) {
						case 1 :
							// Python.g:2207:12: comp_for[gens]
							{
							pushFollow(FOLLOW_comp_for_in_dictorsetmaker7892);
							comp_for308=comp_for(gens);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_for308.getTree());

							if ( state.backtracking==0 ) {
							              Collections.reverse(gens);
							              List<comprehension> c = gens;
							              etype = new DictComp((retval.start), actions.castExpr(list_k.get(0)), actions.castExpr(list_v.get(0)), c);
							           }
							}
							break;
						case 2 :
							// Python.g:2213:12: ( options {k=2; } : COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) )* ( COMMA )?
							{
							// Python.g:2213:12: ( options {k=2; } : COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] ) )*
							loop158:
							while (true) {
								int alt158=2;
								int LA158_0 = input.LA(1);
								if ( (LA158_0==COMMA) ) {
									int LA158_1 = input.LA(2);
									if ( (LA158_1==AWAIT||LA158_1==COMPLEX||LA158_1==DOT||LA158_1==DOUBLESTAR||LA158_1==FLOAT||LA158_1==INT||(LA158_1 >= LAMBDA && LA158_1 <= LCURLY)||(LA158_1 >= LONGINT && LA158_1 <= MINUS)||LA158_1==NAME||LA158_1==NOT||LA158_1==PLUS||(LA158_1 >= STRING && LA158_1 <= TILDE)) ) {
										alt158=1;
									}

								}

								switch (alt158) {
								case 1 :
									// Python.g:2213:28: COMMA (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] )
									{
									COMMA309=(Token)match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker7927); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									COMMA309_tree = (PythonTree)adaptor.create(COMMA309);
									adaptor.addChild(root_0, COMMA309_tree);
									}

									// Python.g:2213:34: (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] | DOUBLESTAR uv+= expr[expr_contextType.Load] )
									int alt157=2;
									int LA157_0 = input.LA(1);
									if ( (LA157_0==AWAIT||LA157_0==COMPLEX||LA157_0==DOT||LA157_0==FLOAT||LA157_0==INT||(LA157_0 >= LAMBDA && LA157_0 <= LCURLY)||(LA157_0 >= LONGINT && LA157_0 <= MINUS)||LA157_0==NAME||LA157_0==NOT||LA157_0==PLUS||(LA157_0 >= STRING && LA157_0 <= TILDE)) ) {
										alt157=1;
									}
									else if ( (LA157_0==DOUBLESTAR) ) {
										alt157=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										NoViableAltException nvae =
											new NoViableAltException("", 157, 0, input);
										throw nvae;
									}

									switch (alt157) {
										case 1 :
											// Python.g:2213:35: k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load]
											{
											pushFollow(FOLLOW_test_in_dictorsetmaker7932);
											k=test(expr_contextType.Load);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

											if (list_k==null) list_k=new ArrayList<Object>();
											list_k.add(k.getTree());
											COLON310=(Token)match(input,COLON,FOLLOW_COLON_in_dictorsetmaker7935); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											COLON310_tree = (PythonTree)adaptor.create(COLON310);
											adaptor.addChild(root_0, COLON310_tree);
											}

											pushFollow(FOLLOW_test_in_dictorsetmaker7939);
											v=test(expr_contextType.Load);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

											if (list_v==null) list_v=new ArrayList<Object>();
											list_v.add(v.getTree());
											}
											break;
										case 2 :
											// Python.g:2213:105: DOUBLESTAR uv+= expr[expr_contextType.Load]
											{
											DOUBLESTAR311=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_dictorsetmaker7944); if (state.failed) return retval;
											if ( state.backtracking==0 ) {
											DOUBLESTAR311_tree = (PythonTree)adaptor.create(DOUBLESTAR311);
											adaptor.addChild(root_0, DOUBLESTAR311_tree);
											}

											pushFollow(FOLLOW_expr_in_dictorsetmaker7948);
											uv=expr(expr_contextType.Load);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, uv.getTree());

											if (list_uv==null) list_uv=new ArrayList<Object>();
											list_uv.add(uv.getTree());
											}
											break;

									}

									}
									break;

								default :
									break loop158;
								}
							}

							if ( state.backtracking==0 ) {
							              etype = new Dict(lcurly, actions.castExprs(list_k), actions.castExprs(list_v, list_uv));
							           }
							// Python.g:2217:10: ( COMMA )?
							int alt159=2;
							int LA159_0 = input.LA(1);
							if ( (LA159_0==COMMA) ) {
								alt159=1;
							}
							switch (alt159) {
								case 1 :
									// Python.g:2217:11: COMMA
									{
									COMMA312=(Token)match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker7977); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									COMMA312_tree = (PythonTree)adaptor.create(COMMA312);
									adaptor.addChild(root_0, COMMA312_tree);
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
					// Python.g:2218:7: (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) ( comp_for[gens] | ( COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) )* ( COMMA )? )
					{
					root_0 = (PythonTree)adaptor.nil();


					// Python.g:2218:7: (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] )
					int alt161=2;
					int LA161_0 = input.LA(1);
					if ( (LA161_0==AWAIT||LA161_0==COMPLEX||LA161_0==DOT||LA161_0==FLOAT||LA161_0==INT||(LA161_0 >= LAMBDA && LA161_0 <= LCURLY)||(LA161_0 >= LONGINT && LA161_0 <= MINUS)||LA161_0==NAME||LA161_0==NOT||LA161_0==PLUS||(LA161_0 >= STRING && LA161_0 <= TILDE)) ) {
						alt161=1;
					}
					else if ( (LA161_0==STAR) ) {
						alt161=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 161, 0, input);
						throw nvae;
					}

					switch (alt161) {
						case 1 :
							// Python.g:2218:8: k+= test[expr_contextType.Load]
							{
							pushFollow(FOLLOW_test_in_dictorsetmaker7991);
							k=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

							if (list_k==null) list_k=new ArrayList<Object>();
							list_k.add(k.getTree());
							}
							break;
						case 2 :
							// Python.g:2218:41: s+= star_expr[expr_contextType.Load]
							{
							pushFollow(FOLLOW_star_expr_in_dictorsetmaker7998);
							s=star_expr(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

							if (list_s==null) list_s=new ArrayList<Object>();
							list_s.add(s.getTree());
							}
							break;

					}

					// Python.g:2219:10: ( comp_for[gens] | ( COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) )* ( COMMA )? )
					int alt165=2;
					int LA165_0 = input.LA(1);
					if ( (LA165_0==FOR) ) {
						alt165=1;
					}
					else if ( (LA165_0==COMMA||LA165_0==RCURLY) ) {
						alt165=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 165, 0, input);
						throw nvae;
					}

					switch (alt165) {
						case 1 :
							// Python.g:2219:12: comp_for[gens]
							{
							pushFollow(FOLLOW_comp_for_in_dictorsetmaker8013);
							comp_for313=comp_for(gens);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_for313.getTree());

							if ( state.backtracking==0 ) {
							               Collections.reverse(gens);
							               List<comprehension> c = gens;
							               expr e = actions.castExpr(list_k.get(0));
							               if (e instanceof Context) {
							                   ((Context)e).setContext(expr_contextType.Load);
							               }
							               etype = new SetComp(lcurly, actions.castExpr(list_k.get(0)), c);
							           }
							}
							break;
						case 2 :
							// Python.g:2229:12: ( COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) )* ( COMMA )?
							{
							// Python.g:2229:12: ( COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] ) )*
							loop163:
							while (true) {
								int alt163=2;
								int LA163_0 = input.LA(1);
								if ( (LA163_0==COMMA) ) {
									int LA163_1 = input.LA(2);
									if ( (LA163_1==AWAIT||LA163_1==COMPLEX||LA163_1==DOT||LA163_1==FLOAT||LA163_1==INT||(LA163_1 >= LAMBDA && LA163_1 <= LCURLY)||(LA163_1 >= LONGINT && LA163_1 <= MINUS)||LA163_1==NAME||LA163_1==NOT||LA163_1==PLUS||LA163_1==STAR||(LA163_1 >= STRING && LA163_1 <= TILDE)) ) {
										alt163=1;
									}

								}

								switch (alt163) {
								case 1 :
									// Python.g:2229:13: COMMA (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] )
									{
									COMMA314=(Token)match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker8041); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									COMMA314_tree = (PythonTree)adaptor.create(COMMA314);
									adaptor.addChild(root_0, COMMA314_tree);
									}

									// Python.g:2229:19: (k+= test[expr_contextType.Load] |s+= star_expr[expr_contextType.Load] )
									int alt162=2;
									int LA162_0 = input.LA(1);
									if ( (LA162_0==AWAIT||LA162_0==COMPLEX||LA162_0==DOT||LA162_0==FLOAT||LA162_0==INT||(LA162_0 >= LAMBDA && LA162_0 <= LCURLY)||(LA162_0 >= LONGINT && LA162_0 <= MINUS)||LA162_0==NAME||LA162_0==NOT||LA162_0==PLUS||(LA162_0 >= STRING && LA162_0 <= TILDE)) ) {
										alt162=1;
									}
									else if ( (LA162_0==STAR) ) {
										alt162=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										NoViableAltException nvae =
											new NoViableAltException("", 162, 0, input);
										throw nvae;
									}

									switch (alt162) {
										case 1 :
											// Python.g:2229:20: k+= test[expr_contextType.Load]
											{
											pushFollow(FOLLOW_test_in_dictorsetmaker8046);
											k=test(expr_contextType.Load);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

											if (list_k==null) list_k=new ArrayList<Object>();
											list_k.add(k.getTree());
											}
											break;
										case 2 :
											// Python.g:2229:53: s+= star_expr[expr_contextType.Load]
											{
											pushFollow(FOLLOW_star_expr_in_dictorsetmaker8053);
											s=star_expr(expr_contextType.Load);
											state._fsp--;
											if (state.failed) return retval;
											if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

											if (list_s==null) list_s=new ArrayList<Object>();
											list_s.add(s.getTree());
											}
											break;

									}

									}
									break;

								default :
									break loop163;
								}
							}

							if ( state.backtracking==0 ) {
							               etype = new Set(lcurly, actions.castExprs(list_k, list_s));
							           }
							// Python.g:2233:10: ( COMMA )?
							int alt164=2;
							int LA164_0 = input.LA(1);
							if ( (LA164_0==COMMA) ) {
								alt164=1;
							}
							switch (alt164) {
								case 1 :
									// Python.g:2233:11: COMMA
									{
									COMMA315=(Token)match(input,COMMA,FOLLOW_COMMA_in_dictorsetmaker8082); if (state.failed) return retval;
									if ( state.backtracking==0 ) {
									COMMA315_tree = (PythonTree)adaptor.create(COMMA315);
									adaptor.addChild(root_0, COMMA315_tree);
									}

									}
									break;

							}

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dictorsetmaker"


	public static class classdef_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "classdef"
	// Python.g:2237:1: classdef : CLASS NAME ( LPAREN ( arglist )? RPAREN )? COLON suite[false] ;
	public final PythonParser.classdef_return classdef() throws RecognitionException {
		PythonParser.classdef_return retval = new PythonParser.classdef_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token CLASS316=null;
		Token NAME317=null;
		Token LPAREN318=null;
		Token RPAREN320=null;
		Token COLON321=null;
		ParserRuleReturnScope arglist319 =null;
		ParserRuleReturnScope suite322 =null;

		PythonTree CLASS316_tree=null;
		PythonTree NAME317_tree=null;
		PythonTree LPAREN318_tree=null;
		PythonTree RPAREN320_tree=null;
		PythonTree COLON321_tree=null;


		    stmt stype = null;

		try {
			// Python.g:2244:5: ( CLASS NAME ( LPAREN ( arglist )? RPAREN )? COLON suite[false] )
			// Python.g:2244:7: CLASS NAME ( LPAREN ( arglist )? RPAREN )? COLON suite[false]
			{
			root_0 = (PythonTree)adaptor.nil();


			CLASS316=(Token)match(input,CLASS,FOLLOW_CLASS_in_classdef8113); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CLASS316_tree = (PythonTree)adaptor.create(CLASS316);
			adaptor.addChild(root_0, CLASS316_tree);
			}

			NAME317=(Token)match(input,NAME,FOLLOW_NAME_in_classdef8115); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME317_tree = (PythonTree)adaptor.create(NAME317);
			adaptor.addChild(root_0, NAME317_tree);
			}

			// Python.g:2244:18: ( LPAREN ( arglist )? RPAREN )?
			int alt168=2;
			int LA168_0 = input.LA(1);
			if ( (LA168_0==LPAREN) ) {
				alt168=1;
			}
			switch (alt168) {
				case 1 :
					// Python.g:2244:19: LPAREN ( arglist )? RPAREN
					{
					LPAREN318=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_classdef8118); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LPAREN318_tree = (PythonTree)adaptor.create(LPAREN318);
					adaptor.addChild(root_0, LPAREN318_tree);
					}

					// Python.g:2244:26: ( arglist )?
					int alt167=2;
					int LA167_0 = input.LA(1);
					if ( (LA167_0==AWAIT||LA167_0==COMPLEX||LA167_0==DOT||LA167_0==DOUBLESTAR||LA167_0==FLOAT||LA167_0==INT||(LA167_0 >= LAMBDA && LA167_0 <= LCURLY)||(LA167_0 >= LONGINT && LA167_0 <= MINUS)||LA167_0==NAME||LA167_0==NOT||LA167_0==PLUS||LA167_0==STAR||(LA167_0 >= STRING && LA167_0 <= TILDE)) ) {
						alt167=1;
					}
					switch (alt167) {
						case 1 :
							// Python.g:2244:26: arglist
							{
							pushFollow(FOLLOW_arglist_in_classdef8120);
							arglist319=arglist();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, arglist319.getTree());

							}
							break;

					}

					RPAREN320=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_classdef8123); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RPAREN320_tree = (PythonTree)adaptor.create(RPAREN320);
					adaptor.addChild(root_0, RPAREN320_tree);
					}

					}
					break;

			}

			COLON321=(Token)match(input,COLON,FOLLOW_COLON_in_classdef8127); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON321_tree = (PythonTree)adaptor.create(COLON321);
			adaptor.addChild(root_0, COLON321_tree);
			}

			pushFollow(FOLLOW_suite_in_classdef8129);
			suite322=suite(false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, suite322.getTree());

			if ( state.backtracking==0 ) {
			          stype = actions.makeClass(CLASS316, NAME317,
			                                    (arglist319!=null?((PythonParser.arglist_return)arglist319).args:null),
			                                    (arglist319!=null?((PythonParser.arglist_return)arglist319).keywords:null),
			                                    (suite322!=null?((PythonParser.suite_return)suite322).stypes:null));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			   retval.tree = stype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "classdef"


	public static class arglist_return extends ParserRuleReturnScope {
		public List args;
		public List keywords;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "arglist"
	// Python.g:2254:1: arglist returns [List args, List keywords] : argument[args, keywords, gens, first] ( COMMA argument[args, keywords, gens, first] )* ( COMMA )? ;
	public final PythonParser.arglist_return arglist() throws RecognitionException {
		PythonParser.arglist_return retval = new PythonParser.arglist_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token COMMA324=null;
		Token COMMA326=null;
		ParserRuleReturnScope argument323 =null;
		ParserRuleReturnScope argument325 =null;

		PythonTree COMMA324_tree=null;
		PythonTree COMMA326_tree=null;


		    List args = new ArrayList();
		    List keywords = new ArrayList();
		    List gens = new ArrayList();
		    boolean first = true;

		try {
			// Python.g:2262:5: ( argument[args, keywords, gens, first] ( COMMA argument[args, keywords, gens, first] )* ( COMMA )? )
			// Python.g:2262:7: argument[args, keywords, gens, first] ( COMMA argument[args, keywords, gens, first] )* ( COMMA )?
			{
			root_0 = (PythonTree)adaptor.nil();


			pushFollow(FOLLOW_argument_in_arglist8169);
			argument323=argument(args, keywords, gens, first);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, argument323.getTree());

			// Python.g:2262:45: ( COMMA argument[args, keywords, gens, first] )*
			loop169:
			while (true) {
				int alt169=2;
				int LA169_0 = input.LA(1);
				if ( (LA169_0==COMMA) ) {
					int LA169_1 = input.LA(2);
					if ( (LA169_1==AWAIT||LA169_1==COMPLEX||LA169_1==DOT||LA169_1==DOUBLESTAR||LA169_1==FLOAT||LA169_1==INT||(LA169_1 >= LAMBDA && LA169_1 <= LCURLY)||(LA169_1 >= LONGINT && LA169_1 <= MINUS)||LA169_1==NAME||LA169_1==NOT||LA169_1==PLUS||LA169_1==STAR||(LA169_1 >= STRING && LA169_1 <= TILDE)) ) {
						alt169=1;
					}

				}

				switch (alt169) {
				case 1 :
					// Python.g:2262:46: COMMA argument[args, keywords, gens, first]
					{
					COMMA324=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist8173); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA324_tree = (PythonTree)adaptor.create(COMMA324);
					adaptor.addChild(root_0, COMMA324_tree);
					}

					pushFollow(FOLLOW_argument_in_arglist8175);
					argument325=argument(args, keywords, gens, first);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, argument325.getTree());

					}
					break;

				default :
					break loop169;
				}
			}

			// Python.g:2262:92: ( COMMA )?
			int alt170=2;
			int LA170_0 = input.LA(1);
			if ( (LA170_0==COMMA) ) {
				alt170=1;
			}
			switch (alt170) {
				case 1 :
					// Python.g:2262:92: COMMA
					{
					COMMA326=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist8180); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA326_tree = (PythonTree)adaptor.create(COMMA326);
					adaptor.addChild(root_0, COMMA326_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			        retval.args = args;
			        retval.keywords = keywords;
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arglist"


	public static class argument_return extends ParserRuleReturnScope {
		public boolean genarg;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "argument"
	// Python.g:2273:1: argument[List args, List keywords, List gens, boolean first] returns [boolean genarg] : (t1= test[expr_contextType.Load] ( comp_for[$gens] | ASSIGN t2= test[expr_contextType.Load] |) | STAR s= test[expr_contextType.Load] | DOUBLESTAR k= test[expr_contextType.Load] );
	public final PythonParser.argument_return argument(List args, List keywords, List gens, boolean first) throws RecognitionException {
		PythonParser.argument_return retval = new PythonParser.argument_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token ASSIGN328=null;
		Token STAR329=null;
		Token DOUBLESTAR330=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope s =null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope comp_for327 =null;

		PythonTree ASSIGN328_tree=null;
		PythonTree STAR329_tree=null;
		PythonTree DOUBLESTAR330_tree=null;

		try {
			// Python.g:2275:5: (t1= test[expr_contextType.Load] ( comp_for[$gens] | ASSIGN t2= test[expr_contextType.Load] |) | STAR s= test[expr_contextType.Load] | DOUBLESTAR k= test[expr_contextType.Load] )
			int alt172=3;
			switch ( input.LA(1) ) {
			case AWAIT:
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
				{
				alt172=1;
				}
				break;
			case STAR:
				{
				alt172=2;
				}
				break;
			case DOUBLESTAR:
				{
				alt172=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 172, 0, input);
				throw nvae;
			}
			switch (alt172) {
				case 1 :
					// Python.g:2275:7: t1= test[expr_contextType.Load] ( comp_for[$gens] | ASSIGN t2= test[expr_contextType.Load] |)
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_test_in_argument8222);
					t1=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());

					// Python.g:2276:7: ( comp_for[$gens] | ASSIGN t2= test[expr_contextType.Load] |)
					int alt171=3;
					switch ( input.LA(1) ) {
					case FOR:
						{
						alt171=1;
						}
						break;
					case ASSIGN:
						{
						alt171=2;
						}
						break;
					case COMMA:
					case RPAREN:
						{
						alt171=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 171, 0, input);
						throw nvae;
					}
					switch (alt171) {
						case 1 :
							// Python.g:2276:9: comp_for[$gens]
							{
							pushFollow(FOLLOW_comp_for_in_argument8233);
							comp_for327=comp_for(gens);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_for327.getTree());

							if ( state.backtracking==0 ) {
							            if (!first) {
							                actions.errorGenExpNotSoleArg((comp_for327!=null?((PythonTree)comp_for327.getTree()):null));
							            }
							            first = false;
							            retval.genarg = true;
							            Collections.reverse(gens);
							            List<comprehension> c = gens;
							            args.add(new GeneratorExp((t1!=null?(t1.start):null), actions.castExpr((t1!=null?((PythonTree)t1.getTree()):null)), c));
							        }
							}
							break;
						case 2 :
							// Python.g:2287:9: ASSIGN t2= test[expr_contextType.Load]
							{
							ASSIGN328=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_argument8254); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASSIGN328_tree = (PythonTree)adaptor.create(ASSIGN328);
							adaptor.addChild(root_0, ASSIGN328_tree);
							}

							pushFollow(FOLLOW_test_in_argument8258);
							t2=test(expr_contextType.Load);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, t2.getTree());

							if ( state.backtracking==0 ) {
							            expr newkey = actions.castExpr((t1!=null?((PythonTree)t1.getTree()):null));
							            //Loop through all current keys and fail on duplicate.
							            for(Object o: keywords) {
							                List list = (List)o;
							                Object oldkey = list.get(0);
							                if (oldkey instanceof Name && newkey instanceof Name) {
							                    if (((Name)oldkey).getId().equals(((Name)newkey).getId())) {
							                        errorHandler.error("keyword arguments repeated", (t1!=null?((PythonTree)t1.getTree()):null));
							                    }
							                }
							            }
							            List<expr> exprs = new ArrayList<expr>();
							            exprs.add(newkey);
							            exprs.add(actions.castExpr((t2!=null?((PythonTree)t2.getTree()):null)));
							            keywords.add(exprs);

							        }
							}
							break;
						case 3 :
							// Python.g:2307:9: 
							{
							if ( state.backtracking==0 ) {
							            if (!keywords.isEmpty()) {
							              actions.errorPositionalArgFollowsKeywordArg((t1!=null?((PythonTree)t1.getTree()):null));
							            }
							            args.add((t1!=null?((PythonTree)t1.getTree()):null));
							        }
							}
							break;

					}

					}
					break;
				case 2 :
					// Python.g:2314:7: STAR s= test[expr_contextType.Load]
					{
					root_0 = (PythonTree)adaptor.nil();


					STAR329=(Token)match(input,STAR,FOLLOW_STAR_in_argument8303); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR329_tree = (PythonTree)adaptor.create(STAR329);
					adaptor.addChild(root_0, STAR329_tree);
					}

					pushFollow(FOLLOW_test_in_argument8307);
					s=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

					if ( state.backtracking==0 ) {
					            expr etype = new Starred(STAR329, actions.castExpr((s!=null?((PythonTree)s.getTree()):null)), expr_contextType.Load);
					            args.add(etype);
					        }
					}
					break;
				case 3 :
					// Python.g:2320:7: DOUBLESTAR k= test[expr_contextType.Load]
					{
					root_0 = (PythonTree)adaptor.nil();


					DOUBLESTAR330=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_argument8327); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLESTAR330_tree = (PythonTree)adaptor.create(DOUBLESTAR330);
					adaptor.addChild(root_0, DOUBLESTAR330_tree);
					}

					pushFollow(FOLLOW_test_in_argument8331);
					k=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

					if ( state.backtracking==0 ) {
					          List<expr> exprs = new ArrayList<>();
					          exprs.add(null);
					          exprs.add(actions.castExpr((k!=null?((PythonTree)k.getTree()):null)));
					          keywords.add(exprs);
					      }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argument"


	public static class comp_iter_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "comp_iter"
	// Python.g:2330:1: comp_iter[List gens, List ifs] : ( comp_for[gens] | comp_if[gens, ifs] );
	public final PythonParser.comp_iter_return comp_iter(List gens, List ifs) throws RecognitionException {
		PythonParser.comp_iter_return retval = new PythonParser.comp_iter_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		ParserRuleReturnScope comp_for331 =null;
		ParserRuleReturnScope comp_if332 =null;


		try {
			// Python.g:2331:5: ( comp_for[gens] | comp_if[gens, ifs] )
			int alt173=2;
			int LA173_0 = input.LA(1);
			if ( (LA173_0==FOR) ) {
				alt173=1;
			}
			else if ( (LA173_0==IF) ) {
				alt173=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 173, 0, input);
				throw nvae;
			}

			switch (alt173) {
				case 1 :
					// Python.g:2331:7: comp_for[gens]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_comp_for_in_comp_iter8360);
					comp_for331=comp_for(gens);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_for331.getTree());

					}
					break;
				case 2 :
					// Python.g:2332:7: comp_if[gens, ifs]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_comp_if_in_comp_iter8369);
					comp_if332=comp_if(gens, ifs);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_if332.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comp_iter"


	public static class comp_for_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "comp_for"
	// Python.g:2336:1: comp_for[List gens] : FOR exprlist[expr_contextType.Store] IN or_test[expr_contextType.Load] ( comp_iter[gens, ifs] )? ;
	public final PythonParser.comp_for_return comp_for(List gens) throws RecognitionException {
		PythonParser.comp_for_return retval = new PythonParser.comp_for_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token FOR333=null;
		Token IN335=null;
		ParserRuleReturnScope exprlist334 =null;
		ParserRuleReturnScope or_test336 =null;
		ParserRuleReturnScope comp_iter337 =null;

		PythonTree FOR333_tree=null;
		PythonTree IN335_tree=null;


		    List ifs = new ArrayList();

		try {
			// Python.g:2340:5: ( FOR exprlist[expr_contextType.Store] IN or_test[expr_contextType.Load] ( comp_iter[gens, ifs] )? )
			// Python.g:2340:7: FOR exprlist[expr_contextType.Store] IN or_test[expr_contextType.Load] ( comp_iter[gens, ifs] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			FOR333=(Token)match(input,FOR,FOLLOW_FOR_in_comp_for8395); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FOR333_tree = (PythonTree)adaptor.create(FOR333);
			adaptor.addChild(root_0, FOR333_tree);
			}

			pushFollow(FOLLOW_exprlist_in_comp_for8397);
			exprlist334=exprlist(expr_contextType.Store);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, exprlist334.getTree());

			IN335=(Token)match(input,IN,FOLLOW_IN_in_comp_for8400); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IN335_tree = (PythonTree)adaptor.create(IN335);
			adaptor.addChild(root_0, IN335_tree);
			}

			pushFollow(FOLLOW_or_test_in_comp_for8402);
			or_test336=or_test(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, or_test336.getTree());

			// Python.g:2340:78: ( comp_iter[gens, ifs] )?
			int alt174=2;
			int LA174_0 = input.LA(1);
			if ( (LA174_0==FOR||LA174_0==IF) ) {
				alt174=1;
			}
			switch (alt174) {
				case 1 :
					// Python.g:2340:78: comp_iter[gens, ifs]
					{
					pushFollow(FOLLOW_comp_iter_in_comp_for8405);
					comp_iter337=comp_iter(gens, ifs);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_iter337.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          Collections.reverse(ifs);
			          gens.add(new comprehension(FOR333, (exprlist334!=null?((PythonParser.exprlist_return)exprlist334).etype:null), actions.castExpr((or_test336!=null?((PythonTree)or_test336.getTree()):null)), ifs));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comp_for"


	public static class comp_if_return extends ParserRuleReturnScope {
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "comp_if"
	// Python.g:2348:1: comp_if[List gens, List ifs] : IF test_nocond[expr_contextType.Load] ( comp_iter[gens, ifs] )? ;
	public final PythonParser.comp_if_return comp_if(List gens, List ifs) throws RecognitionException {
		PythonParser.comp_if_return retval = new PythonParser.comp_if_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token IF338=null;
		ParserRuleReturnScope test_nocond339 =null;
		ParserRuleReturnScope comp_iter340 =null;

		PythonTree IF338_tree=null;

		try {
			// Python.g:2349:5: ( IF test_nocond[expr_contextType.Load] ( comp_iter[gens, ifs] )? )
			// Python.g:2349:7: IF test_nocond[expr_contextType.Load] ( comp_iter[gens, ifs] )?
			{
			root_0 = (PythonTree)adaptor.nil();


			IF338=(Token)match(input,IF,FOLLOW_IF_in_comp_if8434); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IF338_tree = (PythonTree)adaptor.create(IF338);
			adaptor.addChild(root_0, IF338_tree);
			}

			pushFollow(FOLLOW_test_nocond_in_comp_if8436);
			test_nocond339=test_nocond(expr_contextType.Load);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, test_nocond339.getTree());

			// Python.g:2349:45: ( comp_iter[gens, ifs] )?
			int alt175=2;
			int LA175_0 = input.LA(1);
			if ( (LA175_0==FOR||LA175_0==IF) ) {
				alt175=1;
			}
			switch (alt175) {
				case 1 :
					// Python.g:2349:45: comp_iter[gens, ifs]
					{
					pushFollow(FOLLOW_comp_iter_in_comp_if8439);
					comp_iter340=comp_iter(gens, ifs);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_iter340.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			        ifs.add(actions.castExpr((test_nocond339!=null?((PythonTree)test_nocond339.getTree()):null)));
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comp_if"


	public static class yield_expr_return extends ParserRuleReturnScope {
		public expr etype;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "yield_expr"
	// Python.g:2356:1: yield_expr returns [expr etype] : YIELD ( yield_arg )? ;
	public final PythonParser.yield_expr_return yield_expr() throws RecognitionException {
		PythonParser.yield_expr_return retval = new PythonParser.yield_expr_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token YIELD341=null;
		ParserRuleReturnScope yield_arg342 =null;

		PythonTree YIELD341_tree=null;

		try {
			// Python.g:2362:5: ( YIELD ( yield_arg )? )
			// Python.g:2362:7: YIELD ( yield_arg )?
			{
			root_0 = (PythonTree)adaptor.nil();


			YIELD341=(Token)match(input,YIELD,FOLLOW_YIELD_in_yield_expr8480); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			YIELD341_tree = (PythonTree)adaptor.create(YIELD341);
			adaptor.addChild(root_0, YIELD341_tree);
			}

			// Python.g:2362:13: ( yield_arg )?
			int alt176=2;
			int LA176_0 = input.LA(1);
			if ( (LA176_0==AWAIT||LA176_0==COMPLEX||LA176_0==DOT||LA176_0==FLOAT||LA176_0==FROM||LA176_0==INT||(LA176_0 >= LAMBDA && LA176_0 <= LCURLY)||(LA176_0 >= LONGINT && LA176_0 <= MINUS)||LA176_0==NAME||LA176_0==NOT||LA176_0==PLUS||(LA176_0 >= STRING && LA176_0 <= TILDE)) ) {
				alt176=1;
			}
			switch (alt176) {
				case 1 :
					// Python.g:2362:13: yield_arg
					{
					pushFollow(FOLLOW_yield_arg_in_yield_expr8482);
					yield_arg342=yield_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, yield_arg342.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			          if (!(yield_arg342!=null?((PythonParser.yield_arg_return)yield_arg342).isYieldFrom:false)) {
			              retval.etype = new Yield(YIELD341, actions.castExpr((yield_arg342!=null?((PythonTree)yield_arg342.getTree()):null)));
			          } else {
			              retval.etype = new YieldFrom(YIELD341, actions.castExpr((yield_arg342!=null?((PythonTree)yield_arg342.getTree()):null)));
			          }
			      }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    //needed for y2+=yield_expr
			    retval.tree = retval.etype;
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "yield_expr"


	public static class yield_arg_return extends ParserRuleReturnScope {
		public expr etype;
		public boolean isYieldFrom;
		PythonTree tree;
		@Override
		public PythonTree getTree() { return tree; }
	};


	// $ANTLR start "yield_arg"
	// Python.g:2373:1: yield_arg returns [expr etype, boolean isYieldFrom] : ( FROM test[expr_contextType.Load] | testlist[expr_contextType.Load] );
	public final PythonParser.yield_arg_return yield_arg() throws RecognitionException {
		PythonParser.yield_arg_return retval = new PythonParser.yield_arg_return();
		retval.start = input.LT(1);

		PythonTree root_0 = null;

		Token FROM343=null;
		ParserRuleReturnScope test344 =null;
		ParserRuleReturnScope testlist345 =null;

		PythonTree FROM343_tree=null;


		    expr etype = null;

		try {
			// Python.g:2383:5: ( FROM test[expr_contextType.Load] | testlist[expr_contextType.Load] )
			int alt177=2;
			int LA177_0 = input.LA(1);
			if ( (LA177_0==FROM) ) {
				alt177=1;
			}
			else if ( (LA177_0==AWAIT||LA177_0==COMPLEX||LA177_0==DOT||LA177_0==FLOAT||LA177_0==INT||(LA177_0 >= LAMBDA && LA177_0 <= LCURLY)||(LA177_0 >= LONGINT && LA177_0 <= MINUS)||LA177_0==NAME||LA177_0==NOT||LA177_0==PLUS||(LA177_0 >= STRING && LA177_0 <= TILDE)) ) {
				alt177=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 177, 0, input);
				throw nvae;
			}

			switch (alt177) {
				case 1 :
					// Python.g:2383:7: FROM test[expr_contextType.Load]
					{
					root_0 = (PythonTree)adaptor.nil();


					FROM343=(Token)match(input,FROM,FOLLOW_FROM_in_yield_arg8527); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FROM343_tree = (PythonTree)adaptor.create(FROM343);
					adaptor.addChild(root_0, FROM343_tree);
					}

					pushFollow(FOLLOW_test_in_yield_arg8529);
					test344=test(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, test344.getTree());

					if ( state.backtracking==0 ) {
					        etype = actions.castExpr((test344!=null?((PythonTree)test344.getTree()):null));
					        retval.isYieldFrom = true;
					    }
					}
					break;
				case 2 :
					// Python.g:2387:7: testlist[expr_contextType.Load]
					{
					root_0 = (PythonTree)adaptor.nil();


					pushFollow(FOLLOW_testlist_in_yield_arg8540);
					testlist345=testlist(expr_contextType.Load);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist345.getTree());

					if ( state.backtracking==0 ) {
					        etype = actions.castExpr((testlist345!=null?((PythonTree)testlist345.getTree()):null));
					        retval.isYieldFrom = false;
					    }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			    if (etype != null) {
			        retval.tree = etype;
			    }
			}
		}

		catch (RecognitionException re) {
		    reportError(re);
		    errorHandler.recover(this, input,re);
		    retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "yield_arg"

	// $ANTLR start synpred1_Python
	public final void synpred1_Python_fragment() throws RecognitionException {
		// Python.g:787:8: ( testlist_star_expr[null] augassign )
		// Python.g:787:9: testlist_star_expr[null] augassign
		{
		pushFollow(FOLLOW_testlist_star_expr_in_synpred1_Python2177);
		testlist_star_expr(null);
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_augassign_in_synpred1_Python2180);
		augassign();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Python

	// $ANTLR start synpred2_Python
	public final void synpred2_Python_fragment() throws RecognitionException {
		// Python.g:801:7: ( testlist_star_expr[null] ASSIGN )
		// Python.g:801:8: testlist_star_expr[null] ASSIGN
		{
		pushFollow(FOLLOW_testlist_star_expr_in_synpred2_Python2296);
		testlist_star_expr(null);
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred2_Python2299); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_Python

	// $ANTLR start synpred3_Python
	public final void synpred3_Python_fragment() throws RecognitionException {
		// Python.g:834:7: ( ( test[null] | star_expr[null] ) COMMA )
		// Python.g:834:8: ( test[null] | star_expr[null] ) COMMA
		{
		// Python.g:834:8: ( test[null] | star_expr[null] )
		int alt178=2;
		int LA178_0 = input.LA(1);
		if ( (LA178_0==AWAIT||LA178_0==COMPLEX||LA178_0==DOT||LA178_0==FLOAT||LA178_0==INT||(LA178_0 >= LAMBDA && LA178_0 <= LCURLY)||(LA178_0 >= LONGINT && LA178_0 <= MINUS)||LA178_0==NAME||LA178_0==NOT||LA178_0==PLUS||(LA178_0 >= STRING && LA178_0 <= TILDE)) ) {
			alt178=1;
		}
		else if ( (LA178_0==STAR) ) {
			alt178=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 178, 0, input);
			throw nvae;
		}

		switch (alt178) {
			case 1 :
				// Python.g:834:9: test[null]
				{
				pushFollow(FOLLOW_test_in_synpred3_Python2481);
				test(null);
				state._fsp--;
				if (state.failed) return;

				}
				break;
			case 2 :
				// Python.g:834:22: star_expr[null]
				{
				pushFollow(FOLLOW_star_expr_in_synpred3_Python2486);
				star_expr(null);
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,COMMA,FOLLOW_COMMA_in_synpred3_Python2490); if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_Python

	// $ANTLR start synpred4_Python
	public final void synpred4_Python_fragment() throws RecognitionException {
		// Python.g:1432:9: ( IF or_test[null] ORELSE )
		// Python.g:1432:10: IF or_test[null] ORELSE
		{
		match(input,IF,FOLLOW_IF_in_synpred4_Python4698); if (state.failed) return;

		pushFollow(FOLLOW_or_test_in_synpred4_Python4700);
		or_test(null);
		state._fsp--;
		if (state.failed) return;

		match(input,ORELSE,FOLLOW_ORELSE_in_synpred4_Python4703); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_Python

	// $ANTLR start synpred5_Python
	public final void synpred5_Python_fragment() throws RecognitionException {
		// Python.g:1453:9: ( IF or_test[null] ORELSE )
		// Python.g:1453:10: IF or_test[null] ORELSE
		{
		match(input,IF,FOLLOW_IF_in_synpred5_Python4807); if (state.failed) return;

		pushFollow(FOLLOW_or_test_in_synpred5_Python4809);
		or_test(null);
		state._fsp--;
		if (state.failed) return;

		match(input,ORELSE,FOLLOW_ORELSE_in_synpred5_Python4812); if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_Python

	// $ANTLR start synpred6_Python
	public final void synpred6_Python_fragment() throws RecognitionException {
		// Python.g:1860:7: ( ( AWAIT )? atom )
		// Python.g:1860:8: ( AWAIT )? atom
		{
		// Python.g:1860:8: ( AWAIT )?
		int alt179=2;
		int LA179_0 = input.LA(1);
		if ( (LA179_0==AWAIT) ) {
			alt179=1;
		}
		switch (alt179) {
			case 1 :
				// Python.g:1860:8: AWAIT
				{
				match(input,AWAIT,FOLLOW_AWAIT_in_synpred6_Python6504); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_atom_in_synpred6_Python6507);
		atom();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_Python

	// $ANTLR start synpred7_Python
	public final void synpred7_Python_fragment() throws RecognitionException {
		// Python.g:2115:7: ( test[null] COLON )
		// Python.g:2115:8: test[null] COLON
		{
		pushFollow(FOLLOW_test_in_synpred7_Python7412);
		test(null);
		state._fsp--;
		if (state.failed) return;

		match(input,COLON,FOLLOW_COLON_in_synpred7_Python7415); if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_Python

	// $ANTLR start synpred8_Python
	public final void synpred8_Python_fragment() throws RecognitionException {
		// Python.g:2120:7: ( COLON )
		// Python.g:2120:8: COLON
		{
		match(input,COLON,FOLLOW_COLON_in_synpred8_Python7463); if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_Python

	// $ANTLR start synpred9_Python
	public final void synpred9_Python_fragment() throws RecognitionException {
		// Python.g:2154:7: ( expr[null] COMMA )
		// Python.g:2154:8: expr[null] COMMA
		{
		pushFollow(FOLLOW_expr_in_synpred9_Python7608);
		expr(null);
		state._fsp--;
		if (state.failed) return;

		match(input,COMMA,FOLLOW_COMMA_in_synpred9_Python7611); if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_Python

	// $ANTLR start synpred10_Python
	public final void synpred10_Python_fragment() throws RecognitionException {
		// Python.g:2184:7: ( test[null] COMMA )
		// Python.g:2184:8: test[null] COMMA
		{
		pushFollow(FOLLOW_test_in_synpred10_Python7759);
		test(null);
		state._fsp--;
		if (state.failed) return;

		match(input,COMMA,FOLLOW_COMMA_in_synpred10_Python7762); if (state.failed) return;

		}

	}
	// $ANTLR end synpred10_Python

	// $ANTLR start synpred11_Python
	public final void synpred11_Python_fragment() throws RecognitionException {
		// Python.g:2206:7: ( test[expr_contextType.Load] COLON | DOUBLESTAR )
		int alt180=2;
		int LA180_0 = input.LA(1);
		if ( (LA180_0==AWAIT||LA180_0==COMPLEX||LA180_0==DOT||LA180_0==FLOAT||LA180_0==INT||(LA180_0 >= LAMBDA && LA180_0 <= LCURLY)||(LA180_0 >= LONGINT && LA180_0 <= MINUS)||LA180_0==NAME||LA180_0==NOT||LA180_0==PLUS||(LA180_0 >= STRING && LA180_0 <= TILDE)) ) {
			alt180=1;
		}
		else if ( (LA180_0==DOUBLESTAR) ) {
			alt180=2;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 180, 0, input);
			throw nvae;
		}

		switch (alt180) {
			case 1 :
				// Python.g:2206:8: test[expr_contextType.Load] COLON
				{
				pushFollow(FOLLOW_test_in_synpred11_Python7846);
				test(expr_contextType.Load);
				state._fsp--;
				if (state.failed) return;

				match(input,COLON,FOLLOW_COLON_in_synpred11_Python7849); if (state.failed) return;

				}
				break;
			case 2 :
				// Python.g:2206:44: DOUBLESTAR
				{
				match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_synpred11_Python7853); if (state.failed) return;

				}
				break;

		}
	}
	// $ANTLR end synpred11_Python

	// Delegated rules

	public final boolean synpred1_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred10_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred10_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred11_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_Python() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_Python_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA67 dfa67 = new DFA67(this);
	static final String DFA67_eotS =
		"\4\uffff";
	static final String DFA67_eofS =
		"\4\uffff";
	static final String DFA67_minS =
		"\2\37\2\uffff";
	static final String DFA67_maxS =
		"\2\104\2\uffff";
	static final String DFA67_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA67_specialS =
		"\4\uffff}>";
	static final String[] DFA67_transitionS = {
			"\1\1\44\uffff\1\2",
			"\1\1\22\uffff\1\3\21\uffff\1\2",
			"",
			""
	};

	static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
	static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
	static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
	static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
	static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
	static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
	static final short[][] DFA67_transition;

	static {
		int numStates = DFA67_transitionS.length;
		DFA67_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
		}
	}

	protected class DFA67 extends DFA {

		public DFA67(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 67;
			this.eot = DFA67_eot;
			this.eof = DFA67_eof;
			this.min = DFA67_min;
			this.max = DFA67_max;
			this.accept = DFA67_accept;
			this.special = DFA67_special;
			this.transition = DFA67_transition;
		}
		@Override
		public String getDescription() {
			return "1053:12: ( (d+= DOT )* dotted_name | (d+= DOT )+ )";
		}
	}

	public static final BitSet FOLLOW_NEWLINE_in_single_input118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_EOF_in_single_input121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_stmt_in_single_input137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_single_input139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_EOF_in_single_input142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_stmt_in_single_input158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_single_input160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_EOF_in_single_input163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_file_input215 = new BitSet(new long[]{0x03A67800B312B400L,0x000000B2340948F7L});
	public static final BitSet FOLLOW_stmt_in_file_input225 = new BitSet(new long[]{0x03A67800B312B400L,0x000000B2340948F7L});
	public static final BitSet FOLLOW_EOF_in_file_input244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEADING_WS_in_eval_input298 = new BitSet(new long[]{0x03A0080081008000L,0x00000000300040B7L});
	public static final BitSet FOLLOW_NEWLINE_in_eval_input302 = new BitSet(new long[]{0x03A0080081008000L,0x00000000300040B7L});
	public static final BitSet FOLLOW_testlist_in_eval_input306 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_eval_input310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_EOF_in_eval_input314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_dotted_attr366 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_DOT_in_dotted_attr377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_dotted_attr381 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_NAME_in_name_or_print445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASYNC_in_name_or_print455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AWAIT_in_name_or_print465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AT_in_decorator783 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_attr_in_decorator785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_LPAREN_in_decorator793 = new BitSet(new long[]{0x03A0080481008000L,0x0000000034404097L});
	public static final BitSet FOLLOW_arglist_in_decorator803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_decorator847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_decorator869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decorator_in_decorators897 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_ASYNC_in_async_funcdef935 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_funcdef_in_async_funcdef937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decorators_in_decorated972 = new BitSet(new long[]{0x0000000010101000L});
	public static final BitSet FOLLOW_classdef_in_decorated984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcdef_in_decorated1006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_async_funcdef_in_decorated1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEF_in_funcdef1077 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_name_or_print_in_funcdef1079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_parameters_in_funcdef1081 = new BitSet(new long[]{0x0000000000200100L});
	public static final BitSet FOLLOW_ARROW_in_funcdef1084 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_funcdef1086 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_funcdef1091 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_funcdef1093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_parameters1126 = new BitSet(new long[]{0x0000000400009000L,0x0000000004400010L});
	public static final BitSet FOLLOW_typedargslist_in_parameters1135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_parameters1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tfpdef_in_tdefparameter1212 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASSIGN_in_tdefparameter1215 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_tdefparameter1217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vfpdef_in_vdefparameter1261 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASSIGN_in_vdefparameter1265 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_vdefparameter1267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tdefparameter_in_typedargslist1315 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1326 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tdefparameter_in_typedargslist1330 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1342 = new BitSet(new long[]{0x0000000400000002L,0x0000000004000000L});
	public static final BitSet FOLLOW_STAR_in_typedargslist1355 = new BitSet(new long[]{0x0000000000409002L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist1360 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1365 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tdefparameter_in_typedargslist1369 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1380 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tdefparameter_in_typedargslist1384 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1392 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist1394 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist1398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist1414 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist1418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_typedargslist1456 = new BitSet(new long[]{0x0000000000409002L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist1461 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1466 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tdefparameter_in_typedargslist1470 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1481 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tdefparameter_in_typedargslist1485 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_typedargslist1493 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist1495 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist1499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_typedargslist1517 = new BitSet(new long[]{0x0000000000009000L,0x0000000000000010L});
	public static final BitSet FOLLOW_tfpdef_in_typedargslist1521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_name_or_print_in_tfpdef1561 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_COLON_in_tfpdef1564 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_tfpdef1566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vdefparameter_in_varargslist1615 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vdefparameter_in_varargslist1630 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1642 = new BitSet(new long[]{0x0000000400000002L,0x0000000004000000L});
	public static final BitSet FOLLOW_STAR_in_varargslist1655 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1660 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vdefparameter_in_varargslist1670 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vdefparameter_in_varargslist1685 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1693 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_varargslist1759 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1764 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vdefparameter_in_varargslist1774 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vdefparameter_in_varargslist1789 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_varargslist1797 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_vfpdef_in_varargslist1826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_vfpdef1864 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_stmt_in_stmt1898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_stmt_in_stmt1914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_small_stmt_in_simple_stmt1950 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800020L});
	public static final BitSet FOLLOW_SEMI_in_simple_stmt1960 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948D7L});
	public static final BitSet FOLLOW_small_stmt_in_simple_stmt1964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800020L});
	public static final BitSet FOLLOW_SEMI_in_simple_stmt1969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NEWLINE_in_simple_stmt1973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_stmt_in_small_stmt1996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_del_stmt_in_small_stmt2011 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pass_stmt_in_small_stmt2026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_flow_stmt_in_small_stmt2041 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_stmt_in_small_stmt2056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_global_stmt_in_small_stmt2071 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nonlocal_stmt_in_small_stmt2086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assert_stmt_in_small_stmt2101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_star_expr2141 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_star_expr2143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_star_expr_in_expr_stmt2187 = new BitSet(new long[]{0x1000000A00084040L,0x000000080A20A008L});
	public static final BitSet FOLLOW_augassign_in_expr_stmt2203 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_yield_expr_in_expr_stmt2207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_augassign_in_expr_stmt2247 = new BitSet(new long[]{0x03A0080081008000L,0x0000000034004097L});
	public static final BitSet FOLLOW_testlist_star_expr_in_expr_stmt2251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_star_expr_in_expr_stmt2306 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASSIGN_in_expr_stmt2333 = new BitSet(new long[]{0x03A0080081008000L,0x0000000034004097L});
	public static final BitSet FOLLOW_testlist_star_expr_in_expr_stmt2337 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASSIGN_in_expr_stmt2382 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_yield_expr_in_expr_stmt2386 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_testlist_star_expr_in_expr_stmt2434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_or_star_expr_in_testlist_star_expr2508 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_star_expr2520 = new BitSet(new long[]{0x03A0080081008000L,0x0000000034004097L});
	public static final BitSet FOLLOW_test_or_star_expr_in_testlist_star_expr2525 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_star_expr2532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_testlist_star_expr2551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_star_expr_in_testlist_star_expr2560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_test_or_star_expr2581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_star_expr_in_test_or_star_expr2590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUSEQUAL_in_augassign2618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUSEQUAL_in_augassign2636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAREQUAL_in_augassign2654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATEQUAL_in_augassign2672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLASHEQUAL_in_augassign2690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERCENTEQUAL_in_augassign2708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AMPEREQUAL_in_augassign2726 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VBAREQUAL_in_augassign2744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CIRCUMFLEXEQUAL_in_augassign2762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSHIFTEQUAL_in_augassign2780 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHTSHIFTEQUAL_in_augassign2798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAREQUAL_in_augassign2816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESLASHEQUAL_in_augassign2834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_del_stmt2872 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_del_list_in_del_stmt2874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PASS_in_pass_stmt2910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_break_stmt_in_flow_stmt2936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_continue_stmt_in_flow_stmt2944 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_return_stmt_in_flow_stmt2952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_raise_stmt_in_flow_stmt2960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_yield_stmt_in_flow_stmt2968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_break_stmt2996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONTINUE_in_continue_stmt3032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_return_stmt3068 = new BitSet(new long[]{0x03A0080081008002L,0x0000000030004097L});
	public static final BitSet FOLLOW_testlist_in_return_stmt3077 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_yield_expr_in_yield_stmt3142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RAISE_in_raise_stmt3178 = new BitSet(new long[]{0x03A0080081008002L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_raise_stmt3183 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_FROM_in_raise_stmt3187 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_raise_stmt3191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_name_in_import_stmt3220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_from_in_import_stmt3228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_import_name3256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_as_names_in_import_name3258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_import_from3295 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_DOT_in_import_from3300 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_name_in_import_from3303 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_import_from3309 = new BitSet(new long[]{0x0004000080000000L});
	public static final BitSet FOLLOW_IMPORT_in_import_from3313 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000012L});
	public static final BitSet FOLLOW_STAR_in_import_from3324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_as_names_in_import_from3349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_import_from3372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_import_as_names_in_import_from3376 = new BitSet(new long[]{0x0000000000400000L,0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_import_from3378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_import_from3381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_as_name_in_import_as_names3430 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_import_as_names3433 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_import_as_name_in_import_as_names3438 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_NAME_in_import_as_name3479 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AS_in_import_as_name3482 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_import_as_name3486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dotted_name_in_dotted_as_name3526 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AS_in_dotted_as_name3529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_dotted_as_name3533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dotted_as_name_in_dotted_as_names3569 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_dotted_as_names3572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_dotted_as_name_in_dotted_as_names3577 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_NAME_in_dotted_name3611 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_DOT_in_dotted_name3614 = new BitSet(new long[]{0x00CE759032129680L,0x000000B200090ED0L});
	public static final BitSet FOLLOW_attr_in_dotted_name3618 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_GLOBAL_in_global_stmt3654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_global_stmt3658 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_global_stmt3661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_global_stmt3665 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_NONLOCAL_in_nonlocal_stmt3703 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_nonlocal_stmt3707 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_nonlocal_stmt3710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_nonlocal_stmt3714 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_ASSERT_in_assert_stmt3752 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_assert_stmt3756 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_assert_stmt3760 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_assert_stmt3764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stmt_in_compound_stmt3793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stmt_in_compound_stmt3801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stmt_in_compound_stmt3809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_try_stmt_in_compound_stmt3817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_with_stmt_in_compound_stmt3825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcdef_in_compound_stmt3833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_classdef_in_compound_stmt3841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decorated_in_compound_stmt3849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_async_stmt_in_compound_stmt3857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASYNC_in_async_stmt3885 = new BitSet(new long[]{0x0000100010000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_funcdef_in_async_stmt3897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_with_stmt_in_async_stmt3919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stmt_in_async_stmt3941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_stmt3989 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_if_stmt3991 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_if_stmt3994 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_if_stmt3998 = new BitSet(new long[]{0x0000001000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_elif_clause_in_if_stmt4001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_else_clause_in_elif_clause4046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELIF_in_elif_clause4062 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_elif_clause4064 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_elif_clause4067 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_elif_clause4069 = new BitSet(new long[]{0x0000001000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_elif_clause_in_elif_clause4081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORELSE_in_else_clause4141 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_else_clause4143 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_else_clause4147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_stmt4184 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_while_stmt4186 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_while_stmt4189 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_while_stmt4193 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_while_stmt4197 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_while_stmt4199 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_while_stmt4203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_stmt4242 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_exprlist_in_for_stmt4244 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_IN_in_for_stmt4247 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_testlist_in_for_stmt4249 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_for_stmt4252 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_for_stmt4256 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_for_stmt4268 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_for_stmt4270 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_for_stmt4274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRY_in_try_stmt4317 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt4319 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_try_stmt4323 = new BitSet(new long[]{0x0000048000000000L});
	public static final BitSet FOLLOW_except_clause_in_try_stmt4336 = new BitSet(new long[]{0x0000048000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_try_stmt4340 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt4342 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_try_stmt4346 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_FINALLY_in_try_stmt4352 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt4354 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_try_stmt4358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FINALLY_in_try_stmt4381 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_try_stmt4383 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_try_stmt4387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WITH_in_with_stmt4440 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_with_item_in_with_stmt4444 = new BitSet(new long[]{0x0000000000600000L});
	public static final BitSet FOLLOW_COMMA_in_with_stmt4454 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_with_item_in_with_stmt4458 = new BitSet(new long[]{0x0000000000600000L});
	public static final BitSet FOLLOW_COLON_in_with_stmt4462 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_with_stmt4464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_with_item4499 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AS_in_with_item4503 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_with_item4505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEPT_in_except_clause4544 = new BitSet(new long[]{0x03A0080081208000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_except_clause4549 = new BitSet(new long[]{0x0000000000200200L});
	public static final BitSet FOLLOW_AS_in_except_clause4553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_except_clause4555 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_except_clause4561 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_except_clause4563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_stmt_in_suite4609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_suite4625 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_INDENT_in_suite4627 = new BitSet(new long[]{0x03A67800B312B400L,0x000000B2340948D7L});
	public static final BitSet FOLLOW_stmt_in_suite4636 = new BitSet(new long[]{0x03A67800BB12B400L,0x000000B2340948D7L});
	public static final BitSet FOLLOW_DEDENT_in_suite4656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_test_in_test4686 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_IF_in_test4708 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_or_test_in_test4712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_test4715 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_test4719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lambdef_in_test4764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_test_in_test_nocond4795 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_IF_in_test_nocond4817 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_or_test_in_test_nocond4821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_test_nocond4824 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_test_nocond4828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lambdef_nocond_in_test_nocond4873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_test_in_or_test4909 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_OR_in_or_test4925 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_and_test_in_or_test4929 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_not_test_in_and_test5010 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_AND_in_and_test5026 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_not_test_in_and_test5030 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_NOT_in_not_test5114 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_not_test_in_not_test5118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comparison_in_not_test5135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_comparison5184 = new BitSet(new long[]{0x6049802000000012L,0x0000000000000180L});
	public static final BitSet FOLLOW_comp_op_in_comparison5198 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_comparison5202 = new BitSet(new long[]{0x6049802000000012L,0x0000000000000180L});
	public static final BitSet FOLLOW_LESS_in_comp_op5283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_comp_op5299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUAL_in_comp_op5315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQUAL_in_comp_op5331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEQUAL_in_comp_op5347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALT_NOTEQUAL_in_comp_op5363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTEQUAL_in_comp_op5379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IN_in_comp_op5395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_comp_op5411 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_IN_in_comp_op5413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_comp_op5429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_comp_op5445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_NOT_in_comp_op5447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_xor_expr_in_expr5499 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_VBAR_in_expr5514 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_xor_expr_in_expr5518 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_and_expr_in_xor_expr5597 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_CIRCUMFLEX_in_xor_expr5612 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_and_expr_in_xor_expr5616 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_shift_expr_in_and_expr5694 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_AMPER_in_and_expr5709 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_shift_expr_in_and_expr5713 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_arith_expr_in_shift_expr5796 = new BitSet(new long[]{0x0800000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_shift_op_in_shift_expr5810 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_arith_expr_in_shift_expr5814 = new BitSet(new long[]{0x0800000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_LEFTSHIFT_in_shift_op5898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHTSHIFT_in_shift_op5914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_arith_expr5960 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004004L});
	public static final BitSet FOLLOW_arith_op_in_arith_expr5973 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_term_in_arith_expr5977 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004004L});
	public static final BitSet FOLLOW_PLUS_in_arith_op6085 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_arith_op6101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_factor_in_term6147 = new BitSet(new long[]{0x0000000100002002L,0x0000000005001000L});
	public static final BitSet FOLLOW_term_op_in_term6160 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_factor_in_term6164 = new BitSet(new long[]{0x0000000100002002L,0x0000000005001000L});
	public static final BitSet FOLLOW_STAR_in_term_op6246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AT_in_term_op6262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLASH_in_term_op6278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERCENT_in_term_op6294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESLASH_in_term_op6310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_factor6349 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_factor_in_factor6353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_factor6369 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_factor_in_factor6373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TILDE_in_factor6389 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_factor_in_factor6393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_power_in_factor6409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_expr_in_power6448 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_power6460 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_factor_in_power6462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AWAIT_in_atom_expr6512 = new BitSet(new long[]{0x0320080081000000L,0x0000000010000013L});
	public static final BitSet FOLLOW_atom_in_atom_expr6515 = new BitSet(new long[]{0x0100000080000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_trailer_in_atom_expr6520 = new BitSet(new long[]{0x0100000080000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_AWAIT_in_atom_expr6544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_atom6592 = new BitSet(new long[]{0x03A0080081008000L,0x0000008034404097L});
	public static final BitSet FOLLOW_yield_expr_in_atom6610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_testlist_comp_in_atom6630 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_atom6674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_atom6682 = new BitSet(new long[]{0x03A0080081008000L,0x0000000034024097L});
	public static final BitSet FOLLOW_testlist_comp_in_atom6691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_atom6734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LCURLY_in_atom6742 = new BitSet(new long[]{0x03A0080481008000L,0x0000000034044097L});
	public static final BitSet FOLLOW_dictorsetmaker_in_atom6752 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_RCURLY_in_atom6800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_atom6809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom6827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONGINT_in_atom6845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_atom6863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMPLEX_in_atom6881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_atom6901 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_DOT_in_atom6903 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_DOT_in_atom6905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_atom6926 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
	public static final BitSet FOLLOW_test_or_star_expr_in_testlist_comp6969 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_comp6993 = new BitSet(new long[]{0x03A0080081008000L,0x0000000034004097L});
	public static final BitSet FOLLOW_test_or_star_expr_in_testlist_comp6997 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist_comp7005 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_for_in_testlist_comp7067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LAMBDA_in_lambdef7131 = new BitSet(new long[]{0x0000000400200000L,0x0000000004000010L});
	public static final BitSet FOLLOW_varargslist_in_lambdef7134 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_lambdef7138 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_lambdef7140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LAMBDA_in_lambdef_nocond7177 = new BitSet(new long[]{0x0000000400200000L,0x0000000004000010L});
	public static final BitSet FOLLOW_varargslist_in_lambdef_nocond7180 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_lambdef_nocond7184 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_nocond_in_lambdef_nocond7186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_trailer7226 = new BitSet(new long[]{0x03A0080481008000L,0x0000000034404097L});
	public static final BitSet FOLLOW_arglist_in_trailer7235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_trailer7277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_trailer7285 = new BitSet(new long[]{0x03A0080081208000L,0x0000000030004097L});
	public static final BitSet FOLLOW_subscriptlist_in_trailer7287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_trailer7290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_trailer7306 = new BitSet(new long[]{0x00CE759032129680L,0x000000B200090ED0L});
	public static final BitSet FOLLOW_attr_in_trailer7308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subscript_in_subscriptlist7347 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_subscriptlist7359 = new BitSet(new long[]{0x03A0080081208000L,0x0000000030004097L});
	public static final BitSet FOLLOW_subscript_in_subscriptlist7363 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_subscriptlist7370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_subscript7425 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_COLON_in_subscript7431 = new BitSet(new long[]{0x03A0080081208002L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_subscript7436 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_sliceop_in_subscript7442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_subscript7473 = new BitSet(new long[]{0x03A0080081208002L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_subscript7478 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_sliceop_in_subscript7484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_subscript7502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_sliceop7539 = new BitSet(new long[]{0x03A0080081008002L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_sliceop7547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_exprlist7618 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_exprlist7630 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_exprlist7634 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_exprlist7640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_exprlist7659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_del_list7697 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_del_list7709 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_del_list7713 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_del_list7719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_testlist7772 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist7784 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_testlist7788 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_testlist7794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_testlist7812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker7861 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_dictorsetmaker7864 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker7868 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_dictorsetmaker7873 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_dictorsetmaker7877 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_comp_for_in_dictorsetmaker7892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker7927 = new BitSet(new long[]{0x03A0080481008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker7932 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_dictorsetmaker7935 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker7939 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_dictorsetmaker7944 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_expr_in_dictorsetmaker7948 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker7977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker7991 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_star_expr_in_dictorsetmaker7998 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_comp_for_in_dictorsetmaker8013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker8041 = new BitSet(new long[]{0x03A0080081008000L,0x0000000034004097L});
	public static final BitSet FOLLOW_test_in_dictorsetmaker8046 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_star_expr_in_dictorsetmaker8053 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_dictorsetmaker8082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_classdef8113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_NAME_in_classdef8115 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_classdef8118 = new BitSet(new long[]{0x03A0080481008000L,0x0000000034404097L});
	public static final BitSet FOLLOW_arglist_in_classdef8120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_RPAREN_in_classdef8123 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_classdef8127 = new BitSet(new long[]{0x03A46800A3028400L,0x00000080340948F7L});
	public static final BitSet FOLLOW_suite_in_classdef8129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argument_in_arglist8169 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_arglist8173 = new BitSet(new long[]{0x03A0080481008000L,0x0000000034004097L});
	public static final BitSet FOLLOW_argument_in_arglist8175 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_COMMA_in_arglist8180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_argument8222 = new BitSet(new long[]{0x0000100000000802L});
	public static final BitSet FOLLOW_comp_for_in_argument8233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_argument8254 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_argument8258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_argument8303 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_argument8307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_argument8327 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_argument8331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_for_in_comp_iter8360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comp_if_in_comp_iter8369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_comp_for8395 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004017L});
	public static final BitSet FOLLOW_exprlist_in_comp_for8397 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_IN_in_comp_for8400 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_or_test_in_comp_for8402 = new BitSet(new long[]{0x0002100000000002L});
	public static final BitSet FOLLOW_comp_iter_in_comp_for8405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_comp_if8434 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_nocond_in_comp_if8436 = new BitSet(new long[]{0x0002100000000002L});
	public static final BitSet FOLLOW_comp_iter_in_comp_if8439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YIELD_in_yield_expr8480 = new BitSet(new long[]{0x03A0280081008002L,0x0000000030004097L});
	public static final BitSet FOLLOW_yield_arg_in_yield_expr8482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_yield_arg8527 = new BitSet(new long[]{0x03A0080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_test_in_yield_arg8529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_in_yield_arg8540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_star_expr_in_synpred1_Python2177 = new BitSet(new long[]{0x1000000A00084040L,0x000000080A20A008L});
	public static final BitSet FOLLOW_augassign_in_synpred1_Python2180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_testlist_star_expr_in_synpred2_Python2296 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred2_Python2299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred3_Python2481 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_star_expr_in_synpred3_Python2486 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_synpred3_Python2490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred4_Python4698 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_or_test_in_synpred4_Python4700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_synpred4_Python4703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred5_Python4807 = new BitSet(new long[]{0x0320080081008000L,0x0000000030004097L});
	public static final BitSet FOLLOW_or_test_in_synpred5_Python4809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ORELSE_in_synpred5_Python4812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AWAIT_in_synpred6_Python6504 = new BitSet(new long[]{0x0320080081000000L,0x0000000010000013L});
	public static final BitSet FOLLOW_atom_in_synpred6_Python6507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred7_Python7412 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_synpred7_Python7415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_synpred8_Python7463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_synpred9_Python7608 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_synpred9_Python7611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred10_Python7759 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_COMMA_in_synpred10_Python7762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_synpred11_Python7846 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_COLON_in_synpred11_Python7849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLESTAR_in_synpred11_Python7853 = new BitSet(new long[]{0x0000000000000002L});
}
