grammar jfkgrammar;

@header {
package jfk;
import jfk.Compiler;
}
@members {    
    enum typeValue {
        NUMER, LITERA
    };
	enum typeReturn {
        TEXT, ANOTHER
    };
	enum typeIf {
        MNIEJSZE, WIEKSZE, MNIEJSZE_ROWNE,WIEKSZE_ROWNE, ROWNE, NIE_ROWNE
    };}


program returns [Compiler.Program ret] :
    { $ret = new Compiler.Program(); }
	(k = innaKlasa {$ret.add($k.ret);})*
    (s = statement { $ret.add($s.ret); } |
     i = imports {$ret.add($i.ret);}
    )*
    ;

imports returns [ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>()] :        
    'importuj plik' e = expression { $ret.add(new Compiler.ImportFile($e.ret)); }
    ;
funkcjaJezeli returns [ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>()] :   
	'jezeli' w = warunek 'to' s1 = statements 'koniec jezeli'{
		$ret.add(new Compiler.FunkcjaJezeli($w.ret,$s1.ret));
	}|
	'jezeli' w = warunek 'to' s1 = statements 'w przecwinym wypadku' s2 = statements 'koniec jezeli'{
		$ret.add(new Compiler.FunkcjaJezeli($w.ret,$s1.ret, $s2.ret));
	}
;

warunek returns[Object[] ret=new Object[]{}]:
	e1 = expression '<' e2 = expression {$ret = new Object[]{$e1.text,typeIf.MNIEJSZE};}|
	e1 = expression '>' e2 = expression {$ret = new Object[]{$e1.text,typeIf.WIEKSZE};}|
	e1 = expression '<=' e2 = expression {$ret = new Object[]{$e1.text,typeIf.MNIEJSZE_ROWNE};}|
	e1 = expression '=<' e2 = expression {$ret = new Object[]{$e1.text,typeIf.MNIEJSZE_ROWNE};}|
	e1 = expression '>=' e2 = expression {$ret = new Object[]{$e1.text,typeIf.WIEKSZE_ROWNE};}|
	e1 = expression '=>' e2 = expression {$ret = new Object[]{$e1.text,typeIf.WIEKSZE_ROWNE};}|
	e1 = expression '=' e2 = expression {$ret = new Object[]{$e1.text,typeIf.ROWNE};}|
	e1 = expression '!=' e2 = expression {$ret = new Object[]{$e1.text,typeIf.NIE_ROWNE};}|
	e1 = expression '=!' e2 = expression {$ret = new Object[]{$e1.text,typeIf.NIE_ROWNE};}
;
innaKlasa returns [ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>()] :
    'poczatek funkcji' e = expression s = statements (rt = returnFunction)? 'koniec funkcji' k = expression {
        $ret.add(new Compiler.InnaFunkcjaPoczatek($e.text, $k.text));
		for (int i = 0; i < $s.ret.size(); i++){
			ArrayList<Compiler.Statement> statement = $s.ret.get(i);
			for (int j = 0; j < statement.size(); j++){
				$ret.add(statement.get(j));
			}
		}
        $ret.add(new Compiler.Return($rt.ret));
        $ret.add(new Compiler.InnaFunkcjaKoniec($e.text, $rt.ret));
    }
    ;
returnFunction returns[Object[] ret=new Object[]{}]:
	'zwroc' z = expression {$ret=new Object[]{$z.text,typeReturn.ANOTHER};} |
	'zwroc "' z = expression '"' {$ret=new Object[]{$z.text,typeReturn.TEXT};}
;
	
statements returns [ArrayList<ArrayList<Compiler.Statement>> ret = new ArrayList<ArrayList<Compiler.Statement>>()] :
	(s = statement{
                $ret.add($s.ret);
        })+;

statement returns [ArrayList<Compiler.Statement> ret = new ArrayList<Compiler.Statement>()] :
    'deklaruj'
        a = ID {
            $ret.add(new Compiler.VariableDeclaration($a.text,new Object[]{0.0,typeValue.NUMER}));
        } (',' a = ID {
            $ret.add(new Compiler.VariableDeclaration($a.text,new Object[]{0.0,typeValue.NUMER}));
        })*
        ('=' ar = addExpr {
            $ret.add(new Compiler.AssignmentVariable($a.text,new Object[]{$ar.value,typeValue.NUMER}));
        })? (
            (',' a = ID {
                $ret.add(new Compiler.VariableDeclaration($a.text,new Object[]{0.0,typeValue.NUMER}));
            })+ ('=' ar = addExpr {
                $ret.add(new Compiler.AssignmentVariable($a.text,new Object[]{$ar.value,typeValue.NUMER}));
            })?
        )* |
    a = ID ('=' ar = addExpr {
        $ret.add(new Compiler.AssignmentVariable($a.text,new Object[]{$ar.value,typeValue.NUMER}));
    })? |
	(a = ID '=')? 'wywolaj funkcje' e = expression {$ret.add(new Compiler.CallFunction($a.text, $e.text));} |
    'wczytaj wartosc z klawiatury do zmiennej' a = ID {$ret.add(new Compiler.Scanf($a.text));} |
    invocation { $ret.add($invocation.ret); }
    ;

invocation returns [Compiler.Invocation ret] :
    'drukuj' { $ret = new Compiler.Invocation(); }
    '('
        (a = expression { $ret.add($a.ret); }
            (',' a = expression { $ret.add($a.ret); } )*
        )?
    ')'
    ;
atom returns[double value]:
    INT {$value = Integer.parseInt($INT.text);} |
    DOUBLE {$value = Double.parseDouble($DOUBLE.text);} |
    '('addExpr')' {$value = $addExpr.value;};

multExpr returns[double value]:
    a=atom {$value = $a.value;} (
        '*' b=atom {$value*=$b.value;} |
        '/' b=atom{$value/=$b.value;}
    )*;
addExpr returns[double value]:
    a=multExpr {$value = $a.value;} (
        '+' b=multExpr {$value+=$b.value;} |
        '-' b=multExpr{$value-=$b.value;}
)* ;

expression returns [Compiler.Expression ret] :
    INT { $ret = new Compiler.IntExpression($INT.text); } |
    DOUBLE { $ret = new Compiler.DoubleExpression($DOUBLE.text); } |
    ID { $ret = new Compiler.RefExpression($ID.text); }
    ;

COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip
    ;

INT : '0'..'9'+ ;
DOUBLE: '0'..'9'+'.''0'..'9'+;
ID  : 'a'..'z'+ ;
WS : (' '|'\r'|'\n') -> skip;


