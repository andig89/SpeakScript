package jfk;

import org.antlr.v4.runtime.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Compiler {

    public static List<Statement> stmts = new ArrayList<Statement>();
    public static ArrayList<String> variableList = new ArrayList<String>();

    public static class Program {

        public Program() {
        }

        public void add(Statement stmt) {
            if (stmt.getClass().equals(Compiler.CallClass.class)) { //jeśli nasz Statement, to funkcja, której celem
                //jest wywolanie innej, w tedy wywołujemy jej block emit
                FunctionBlock block = new FunctionBlock();
                stmt.emit(block);
            } else {
                stmts.add(stmt);
            }
        }

        ;

//        public void add(ImportFile stmt) {
//            imports.add(stmt);
//        }
        public String emit() {
            FunctionBlock block = new FunctionBlock();
            block.emit("define i32 @main() nounwind {");
            for (Statement stmt : stmts) {
                stmt.emit(block);
            }
            block.emit("}");
            block.emitEnd("declare i32 @printf(i8*, ...)");
            block.emitEnd("declare i32 @scanf(i8*, ...)");
            return block.getString();
        }
    }

    public static abstract class Statement {

        public abstract void emit(FunctionBlock block);
    }

    public static class CallClass extends Statement {

        private final ArrayList list;

        public CallClass(ArrayList list) {
            this.list = list;
        }

        ;

        @Override
        public void emit(FunctionBlock block) {
            //rozpoznajemy, która funkcja ma być dodana do listy Statementów i je dodajemy
            Object[] objectElements;
            for (int i = 0; i < list.size(); i++) {
                objectElements = (Object[]) list.get(i);
                switch ((String) objectElements[0]) {
                    case "Assignment":
                        stmts.add(new Compiler.Assignment((String) objectElements[1], (Expression) objectElements[2]));
                        break;
                    case "VariableDeclaration":
                        stmts.add(new Compiler.VariableDeclaration((String) objectElements[1]));
                        break;
                    case "AssignmentVariable":
                        stmts.add(new Compiler.AssignmentVariable((String) objectElements[1], (Integer) objectElements[2]));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static class Return extends Statement {

        private final Expression expr;

        public Return(Expression expr) {
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
            block.emit("ret i32 0");
        }
    }

    public static class Scanf extends Statement {

        private final String name;

        public Scanf(String name) {
            this.name = name;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = block.nextRegister();
            if (!variableList.contains("format_str1")) {
                block.emitStr("@.format_str = private unnamed_addr constant [3 x i8] c\"%i\\00\", align 1");
                variableList.add("format_str1");
            };
            block.emit("%" + reg + " = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3x i8]* @.format_str, i32 0, i32 0), i32* %" + name + ")");
        }
    }

    //    public static abstract class ImportFile {
//
//        public abstract void emit(FunctionBlock block);
//    }
    public static class ImportFile extends Statement {

        private final Expression expr;

        public ImportFile(Expression expr) {
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emitStr("@.str = private unnamed_addr constant [7 x i8] c\"import\\00\", align 1");
            block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @.format_str, i32 0, i32 0))");//funkcje, metody
        }
    }

    public static class innaKlasaPoczatek extends Statement {

        private final Expression expr;

        public innaKlasaPoczatek(Expression expr) {
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emitStr("@.str = private unnamed_addr constant [7 x i8] c\"poczatek\\00\", align 1");
            block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @.format_str, i32 0, i32 0))");//funkcje, metody
        }
    }

    public static class innaKlasaKoniec extends Statement {

        private final Expression expr;

        public innaKlasaKoniec(Expression expr) {
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emitStr("@.str = private unnamed_addr constant [7 x i8] c\"koniec\\00\", align 1");
            block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @.format_str, i32 0, i32 0))");//funkcje, metody
        }
    }

    public static class VariableDeclaration extends Statement {

        private final String name;

        public VariableDeclaration(String name) {
            this.name = name;
        }

        @Override
        public void emit(FunctionBlock block) {
            block.emit("%" + name + " = alloca i32, align 4");
        }
    }

    public static class Assignment extends Statement {

        private final String where;
        private final Expression expr;

        public Assignment(String where, Expression expr) {
            this.where = where;
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = expr.emit(block);
            //System.out.println(((IntExpression)expr).val );
            block.emit("store i32 %" + reg + ", i32* %" + where + ", align 4");
        }
    }

    public static class AssignmentVariable extends Statement {

        private final String where;
        private final int value;

        public AssignmentVariable(String where, int value) {
            this.where = where;
            this.value = value;
        }

        @Override
        public void emit(FunctionBlock block) {
            //System.out.println(((IntExpression)expr).val );
            block.emit("store i32 " + value + ", i32* %" + where + ", align 4");
        }
    }

    public static class Invocation extends Statement {

        private final String name;
        private List<Expression> params = new ArrayList<Expression>();

        public Invocation(String name) {
            this.name = name;
        }

        public void add(Expression exp) {
            params.add(exp);
        }

        @Override
        public void emit(FunctionBlock block) {

            for (Expression exp : params) {
                int res = exp.emit(block);
                int reg = block.nextRegister();
                if (!variableList.contains("format_str")) {
                    block.emitStr("@.format_str1 = private unnamed_addr constant [5 x i8] c\"%i \\0A\\00\", align 1");
                    variableList.add("format_str");
                };
                block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.format_str1, i32 0, i32 0), i32 %" + res + ")");
            }
        }
    }

    public static abstract class Expression {

        public abstract int emit(FunctionBlock block);
    }

    public static class IntExpression extends Expression {

        public final int val;

        public IntExpression(String val) {
            this.val = Integer.parseInt(val);
        }

        @Override
        public int emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emit("%" + reg + " = add i32 0, " + val);
            return reg;
        }
    }

    public static class RefExpression extends Expression {

        private final String name;

        public RefExpression(String name) {
            this.name = name;
        }

        @Override
        public int emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emit("%" + reg + " = load i32* %" + name + ", align 4");
            return reg;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar jfk2013.jar INPUT_FILE [OUTPUT_FILE]");
            System.out.println("Defaulting to: test.txt");
            args = new String[]{"test.txt"};
        }

        try {
            jfkgrammarLexer lexer = new jfkgrammarLexer(new org.antlr.v4.runtime.ANTLRInputStream(new FileReader(args[0])));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            jfkgrammarParser parser = new jfkgrammarParser(tokens);
            Program prog = parser.program().ret;
            String str = prog.emit();
            if (args.length <= 1) {
                System.out.println(str);
            } else {
                String outputFilename = args[1];
                FileWriter writer = new FileWriter(outputFilename);
                writer.write(str);
                writer.close();
            }
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
