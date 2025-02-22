parser grammar AndesiteParser;

options {
    tokenVocab = AndesiteLexer;
}

program
    : statements*
    ;

importPackage
    : IMPORT string importFrom importAs?
    ;

importFrom
    : FROM identifier (COMMA identifier)*
    ;

importAs
    : AS identifier (COMMA identifier)*
    ;

statements
    : nativeFunctionDeclaration
    | importPackage SEMI
    | functionDeclaration
    | classDeclaration
    | interfacesDeclaration
    | variableDeclaration SEMI
    | constantDeclaration SEMI
    | expression SEMI
    | returnStatement SEMI
    | ifStatement
    | forStatement
    | whileStatement
    | repeatStatement SEMI
    ;

functionDeclaration
    : accessModifier? functionModifier* FUNCTION identifier LPAREN parameterList? RPAREN COLON types (block | SEMI)
    ;

nativeFunctionDeclaration
    : accessModifier? NATIVE FUNCTION identifier LPAREN parameterList RPAREN COLON types SEMI
    ;

constantDeclaration
    : accessModifier? CONST identifier COLON types ASSIGN expression
    ;

functionModifier
    : OVERRIDE
    | modifier
    ;

modifier
    : FINAL
    | STATIC
    | ABSTRACT
    ;

variableDeclaration
    : accessModifier? modifier* VAR identifier COLON types variableInitializer?
    ;

classDeclaration
    : accessModifier? modifier* CLASS identifier typeParameters? objectiveExtends? objectiveImplements? classBlock
    ;

objectiveExtends
    : EXTENDS types
    ;

objectiveImplements
    : IMPLEMENTS types (COMMA types)*
    ;

interfacesDeclaration
    : accessModifier? modifier* INTERFACE identifier typeParameters? interfaceExtends? classBlock
    ;

interfaceExtends
    : EXTENDS types (COMMA types)*
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
        | functionDeclaration
        | classDeclaration
        | interfacesDeclaration
        | constructorDeclaration
        | nativeFunctionDeclaration
        )*
    RBRACE
    ;

constructorDeclaration
    : accessModifier? CONSTRUCTOR LPAREN parameterList? RPAREN block
    ;

accessModifier
    : PUBLIC
    | PRIVATE
    | PROTECTED
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
    | chainReference ASSIGN expression                # AssignmentExpression
    | SELF DOT chainReference                                  # SelfReferenceExpression
    | SELF DOT chainReference ASSIGN expression                # SelfAssignmentExpression
    //| identifier op=(ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN) expression # CompoundAssignmentExpression
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
    | chainReference                              # ReferenceExpression
    | instantiate                                 # InstantiateExpression
    | instantiate DOT chainReference              # InstanceReferenceExpression
    | LPAREN expression RPAREN                    # ParenthesizedExpression
    ;

chainReference
    : reference (DOT reference)*
    ;

reference
    : identifier
    | methodInvoke
    | arrayAccess
    ;

instantiate
    : NEW identifier LPAREN argumentList? RPAREN
    ;

methodInvoke
    : identifier LPAREN argumentList? RPAREN
    ;

types
    : baseTypes #NormalType
    | baseTypes LBRACKET RBRACKET #ArrayType
    ;

typeBound
    : types (B_AND types)*
    ;

typeParameter
    : identifier SUPER typeBound? #TypeParameterSuper
    | identifier EXTENDS typeBound? #TypeParameterExtends
    | identifier #TypeParameterSingle
    | typeArguments #TypeParameterTypeArgument
    ;

typeParameters
    : LT typeParameter (COMMA typeParameter)* GT
    ;


typeArgument
    : QUESTION SUPER typeBound? #TypeArgumentSuper
    | QUESTION EXTENDS typeBound? #TypeArgumentExtends
    | types #TypeArgumentSingle
    | identifier #TypeArgumentTypeParameter
    ;

typeArguments
    : LT typeArgument (COMMA typeArgument)* GT
    ;

baseTypes
    : primitive #PrimitiveType
    | identifier #CustomType
    | identifier typeArguments #TypeParameterType
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