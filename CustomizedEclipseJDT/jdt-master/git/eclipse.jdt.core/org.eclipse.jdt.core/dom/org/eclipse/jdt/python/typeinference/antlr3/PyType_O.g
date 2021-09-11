grammar PyType;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
    INT    = 'int' ;
    STRING   = 'str' ;
    ANY    = 'Any' ;
    OPEN_SQ_BR = '[';
    CLOSE_SQ_BR = ']';
    LIST = 'List';
    UNION = 'Union';
    COMMA = ',';
    Nothing = 'nothing';
    HYPHEN = '-' ;
    UNDERSCORE = '_' ;


}

@members {
    public static void main(String[] args) throws Exception {
        python.typeinference.antlr.python.typeinference.antlr.PyTypeLexer lex = new python.typeinference.antlr.python.typeinference.antlr.PyTypeLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        python.typeinference.antlr.python.typeinference.antlr.PyTypeParser parser = new python.typeinference.antlr.python.typeinference.antlr.PyTypeParser(tokens);

        try {
            parser.expr();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
parse
    :  expr
    ;

list_element
    : OPEN_SQ_BR expr CLOSE_SQ_BR -> expr
    ;

union_element
    : OPEN_SQ_BR (expr COMMA)+ CLOSE_SQ_BR -> expr+;

list_expr
    : LIST^ list_element*;

union_expr
    : UNION^ union_element;

DIGIT  : '0'..'9' ;

LETTER : 'a'..'z' |'A'..'Z' ;

NUMBER : DIGIT+ ;

WORD : LETTER+  ;

SimpleType : (WORD | UNDERSCORE) (WORD | NUMBER | UNDERSCORE)*
           ;

QualifiedType : SimpleType | SimpleType'.'SimpleType*;

expr
    : INT
    | STRING
    | ANY
    | Nothing
    | list_expr
    | SimpleType
    | union_expr;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

