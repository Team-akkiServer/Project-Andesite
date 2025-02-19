parser grammar AndesiteParser;

options {
    tokenVocab = AndesiteLexer;
}

program
    : statements*
    ;

statements
    : functionDeclaration
    | classDeclaration
    | interfacesDeclaration
    | variableDeclaration SEMI
    | expression SEMI
    | returnStatement SEMI
    | ifStatement
    | forStatement
    | whileStatement
    ;

functionDeclaration
    : accessModifier? functionModifier? FUNCTION identifier LPAREN parameterList? RPAREN COLON types block
    | accessModifier? functionModifier? FUNCTION identifier LPAREN parameterList? RPAREN COLON types SEMI
    ;

functionModifier
    : ABSTRACT
    | OVERRIDE
    | STATIC
    | FINAL
    ;

variableDeclaration
    : accessModifier? STATIC? FINAL? VAR identifier COLON types variableInitializer?
    ;

classDeclaration
    : accessModifier? STATIC? ABSTRACT? CLASS identifier objectiveExtends? objectiveImplements? classBlock
    ;

objectiveExtends
    : EXTENDS identifier
    ;

objectiveImplements
    : IMPLEMENTS identifier (COMMA identifier)*
    ;

interfacesDeclaration
    : accessModifier? STATIC? INTERFACE identifier objectiveExtends? classBlock
    ;

returnStatement
    : RETURN expression
    ;

ifStatement
    : IF LPAREN expression RPAREN block elseIfStatement* elseStatement?
    ;

repeatStatement
    : REPEAT block UNTIL LPAREN expression RPAREN
    ;

whileStatement
    : WHILE LPAREN expression RPAREN block
    ;

forStatement
    : FOR LPAREN identifier IN forInitializer RPAREN block
    ;

forInitializer
    : expression forUntil?
    ;

forUntil
    : UNTIL expression
    ;

elseIfStatement
    : ELSE IF LPAREN expression RPAREN block
    ;

elseStatement
    : ELSE block
    ;

block
    : LBRACE statements* RBRACE
    ;

classBlock
    : LBRACE
        ( variableDeclaration SEMI
        | constructorDeclaration
        | functionDeclaration
        | classDeclaration
        | interfacesDeclaration
        )*
    RBRACE
    ;

constructorDeclaration
    : CONSTRUCTOR LPAREN parameterList? RPAREN block
    ;

accessModifier
    : PUBLIC
    | PRIVATE
    ;

parameterList
    : parameter (COMMA parameter)*
    ;

parameter
    : identifier COLON types
    ;

argumentList
    : argument (COMMA argument)*
    ;

argument
    : expression
    ;

variableInitializer
    : ASSIGN expression
    ;

rightExpression
    : expression
    ;

expression
    : primary                                      # PrimaryExpression
    | expression op=(INCL | DECL)                 # PostfixExpression
    | op=(INCL | DECL) expression                 # PrefixExpression
    | op=SUB expression                           # NegationExpression
    | op=L_NOT expression                         # LogicalNegationExpression
    | expression op=(MUL | DIV | MOD) rightExpression  # MultiplicativeExpression
    | expression op=(ADD | SUB) rightExpression        # AdditiveExpression
    | expression op=(B_LSHIFT | B_RSHIFT) rightExpression # BitwiseShiftExpression
    | expression op=(LT | LTE | GT | GTE) rightExpression  # RelationalExpression
    | expression op=(EQ | NE) rightExpression         # EqualityExpression
    | expression op=B_AND rightExpression             # BitwiseAndExpression
    | expression op=B_XOR rightExpression             # BitwiseXorExpression
    | expression op=B_OR rightExpression              # BitwiseOrExpression
    | expression op=L_AND rightExpression             # LogicalAndExpression
    | expression op=L_OR rightExpression              # LogicalOrExpression
    | expression op=L_XOR rightExpression             # LogicalXorExpression
    | identifier ASSIGN expression                    # AssignmentExpression
    | arrayAccess ASSIGN expression                   # ArrayAssignmentExpression
    | identifier op=(ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN) expression # CompoundAssignmentExpression
    | arrayAccess                                     #ArrayAccessExpression
    | arrayInitializer                                #ArrayInitializerExpression
    ;

arrayInitializer
    : LBRACKET arrayItems? RBRACKET
    ;

arrayItems
    : expression (COMMA expression)*
    ;

arrayAccess
    : identifier LBRACKET expression RBRACKET
    ;

primary
    : literal                                     # LiteralExpression
    | identifier                                  # IdentifierExpression
    | SELF DOT defaultIdentifierChain                      # SelfAccessExpression
    | SELF DOT (methodInvoke | methodChain)           # SelfInvokeExpression
    | SELF DOT identifier ASSIGN expression       # SelfAssignmentExpression
    | SELF DOT identifierChain ASSIGN expression  # SelfChainedAssignmentExpression
    | methodInvoke                                # MethodInvokeExpression
    | methodChain                                 # MethodChainInvokeExpression
    | LPAREN expression RPAREN                    # ParenthesizedExpression
    | NEW identifier LPAREN argumentList? RPAREN  # InstantiateExpression
    ;

methodChain
    : identifierChain DOT methodInvoke
    ;

identifierChain
    : identifier (DOT identifier)+
    ;

defaultIdentifierChain
    : identifier (DOT identifier)*
    ;

methodInvoke
    : identifier LPAREN argumentList? RPAREN
    ;

types
    : baseTypes #NormalType
    | baseTypes LBRACKET RBRACKET #ArrayType
    ;

baseTypes
    : primitive
    | identifier
    ;
primitive
    : STRING
    | INTEGER
    | LONG
    | FLOAT
    | DOUBLE
    | CHAR
    | VOID
    | BOOLEAN
    | OBJECT
    ;

identifier
    : IDENTIFIER
    ;

literal
    : number #NumberLiteral
    | string #StringLiteral
    | boolean #BooleanLiteral
    | NULL #NullLiteral
    ;

string
    : STRINGS
    | CHARS
    ;

boolean
    : TRUE
    | FALSE
    ;

number
    : INT
    | HEX
    | FLOATS
    | BIN
    ;