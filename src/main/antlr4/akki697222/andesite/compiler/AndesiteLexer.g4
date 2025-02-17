lexer grammar AndesiteLexer;

// 演算子
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';

// 論理演算子
L_AND: '&&';
L_OR: '||';
L_NOT: '!';
L_XOR: '^^';

// 比較演算子
EQ: '==';
NE: '!=';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';

// ビット演算子
B_AND: '&';
B_OR: '|';
B_XOR: '^';
B_NOT: '~';
B_LSHIFT: '<<';
B_RSHIFT: '>>';

// 単項演算子
INCL: '++';
DECL: '--';

// 基本構文
IF: 'if';
ELSE: 'else';
FOR: 'for';
IN: 'in';
IS: 'is';
NOT: 'not';
RETURN: 'return';
WHILE: 'while';
REPEAT: 'repeat';
UNTIL: 'until';
TRY: 'try';
CATCH: 'catch';
FINALLY: 'finally';
BREAK: 'break';
SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';
CAST: 'cast';
CLASS: 'class';
INTERFACE: 'interface';
ABSTRACT: 'abstract';
IMPLEMENTS: 'impl';
EXTENDS: 'extend';
FINAL: 'final';
CONST: 'const';
VAR: 'var';
FUNCTION: 'fn';
SKIPS: 'skip';
NEW: 'new';
STATIC: 'static';

//代入演算子
ASSIGN: '=';
ADD_ASSIGN: '+=';
SUB_ASSIGN: '-=';
MUL_ASSIGN: '*=';
DIV_ASSIGN: '/=';
MOD_ASSIGN: '%=';

//アクセス修飾子
PUBLIC: 'public';
PRIVATE: 'private';
PROTECTED: 'protected';

//プリミティブ型
STRING: 'string';
INTEGER: 'int';
LONG: 'long';
FLOAT: 'float';
DOUBLE: 'double';
CHAR: 'char';
VOID: 'void';
BOOLEAN: 'bool';
OBJECT: 'object';
NULL: 'null' | 'undef';

//記号？
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
DOT: '.';
COMMA: ',';
SEMI: ';';
COLON: ':';
VARARGS: '...';
LAMBDA: '=>';
QUESTION: '?';

//その他
INT: Digit+;
FLOATS: Digit+ '.' Digit+;
HEX: '0'[Xx] HexDigit+;
BIN: '0'[Bb] BinaryDigit+;
TRUE: 'true';
FALSE: 'false';
STRINGS: '"' (~["\\] | '\\' . | '\n')* '"';
CHARS: '\'' (~['\\] | '\\' .)* '\'';
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]+ | [a-zA-Z];
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' .*? '\n'; 
COMMENT_LONG: '/*' .*? '*/';

fragment Digit: [0-9];
fragment HexDigit: [0-9a-fA-F];
fragment BinaryDigit: [01];