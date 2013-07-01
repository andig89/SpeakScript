grammar jfkgrammar;

@header {
package jfk;
import jfk.Compiler;
}

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
    'ustaw' a = ID { $ret = new Compiler.VariableDeclaration($a.text); }  ('=' e = expression { $ret = new Compiler.Assignment($a.text, $e.ret); })* |
    a = ID '=' e = expression { $ret = new Compiler.Assignment($a.text, $e.ret); } |
    'zwroc' e = expression { $ret = new Compiler.Return($e.ret); } |
    invocation { $ret = $invocation.ret; }
    ;

invocation returns [Compiler.Invocation ret] :
    ID { $ret = new Compiler.Invocation($ID.text); }
    '('
        (a = expression { $ret.add($a.ret); }
            (',' a = expression { $ret.add($a.ret); } )*
        )?
    ')'
    ;

expression returns [Compiler.Expression ret] :
    INT { $ret = new Compiler.IntExpression($INT.text); } |
    ID { $ret = new Compiler.RefExpression($ID.text); }
    ;

COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip
    ;

INT : '0'..'9'+ ;
ID  : 'a'..'z'+ ;
WS : (' '|'\r'|'\n') -> skip;


