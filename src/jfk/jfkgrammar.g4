grammar jfkgrammar;

@header {
package jfk;
import jfk.Compiler;
}
@members {    
    enum typeValue {
        NUMBER, LITERA
    };}

program returns [Compiler.Program ret] :
    { $ret = new Compiler.Program(); }
    (s = statement { $ret.add($s.ret); }    |
     i = imports {$ret.add($i.ret);}  |
     k = innaKlasa {$ret.add($k.ret);}
    )*
    ;

imports returns [Compiler.Statement ret] :
    'importuj plik' e = expression { $ret = new Compiler.ImportFile($e.ret); }
    ;

innaKlasa returns [Compiler.Statement ret] :
    'poczatek klasy' e = expression { $ret = new Compiler.innaKlasaPoczatek($e.ret); } (statement)+ 'koniec klasy' e = expression { $ret = new Compiler.innaKlasaKoniec($e.ret); }
    ;

statement returns [Compiler.Statement ret] :
    'ustaw' a = ID { $ret = new Compiler.VariableDeclaration($a.text,new Object[]{"0",typeValue.NUMBER});} ('=' ar = addExpr {
        //objekt, który przechowuje parametry: nazwa funkcji, która ma być wywołana, oraz jej prametry
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new String("VariableDeclaration"), new String($a.text), new Object[]{$addExpr.value,typeValue.NUMBER}});
        list.add(new Object[]{new String("AssignmentVariable"), new String($a.text), new Object[]{$addExpr.value,typeValue.NUMBER}});

        $ret = new Compiler.CallClass(list);
    })* |
    'wczytaj wartosc z klawiatury do zmiennej' a = ID {$ret = new Compiler.Scanf($a.text);} |
    'zwroc' e = expression { $ret = new Compiler.Return($e.ret); } |
invocation { $ret = $invocation.ret; }
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


