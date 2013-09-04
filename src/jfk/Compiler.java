package jfk;

import org.antlr.v4.runtime.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Compiler {

    public static List<Statement> stmts = new ArrayList<Statement>();
    public static List<Statement> secondStmts = new ArrayList<Statement>();
    public static ArrayList<String> variableList = new ArrayList<String>();
    public static HashMap<String, String> hashMapChars = new HashMap<String, String>();
    public static String className = "";

    enum typesOfDeclarationValues {

        INT, DOUBLE, STRING, UNKNOWN
    };

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

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

        public void secondAdd(Statement stmt) {
            if (stmt.getClass().equals(Compiler.CallClass.class)) { //jeśli nasz Statement, to funkcja, której celem
                //jest wywolanie innej, w tedy wywołujemy jej block emit
                FunctionBlock block = new FunctionBlock();
                stmt.emit(block);
            } else {
                secondStmts.add(stmt);
            }
        }

//        public void add(ImportFile stmt) {
//            imports.add(stmt);
//        }
        public String emit() {
            FunctionBlock block = new FunctionBlock();
            className = "main";
            block.emitTemp("");
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.CLASS);

            block.emitTemp("define i32 @main() nounwind {");
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
            for (Statement stmt : stmts) {
                stmt.emit(block);
            }
            for (Statement secondStmt : secondStmts) {
                secondStmt.emit(block);
            }
            block.emitTemp("}");
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

            return block.getEmit();
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

        @Override
        public void emit(FunctionBlock block) {
            //rozpoznajemy, która funkcja ma być dodana do listy Statementów i je dodajemy
            Object[] objectElements;
            for (int i = 0; i < list.size(); i++) {
                objectElements = (Object[]) list.get(i);
                switch ((String) objectElements[0]) {
                    case "VariableDeclaration":
                        stmts.add(new Compiler.VariableDeclaration((String) objectElements[1], (Object[]) objectElements[2]));
                        break;
                    case "AssignmentVariable":
                        stmts.add(new Compiler.AssignmentVariable((String) objectElements[1], (Object[]) objectElements[2]));
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
            block.emitTemp("ret i32 0");
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
        }
    }

    public static class Scanf extends Statement {

        private String name;

        public Scanf(String name) {
            this.name = name;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = block.nextRegister();

            if (!block.checkDeclaration("scanf.string", "main", "main")) {
                block.emitTemp("%scanf.string = alloca [1009 x i8], align 1", "scanf.string", FunctionBlock.typesOfDeclarationValues.STRING);
                block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);
            }
            if (!block.checkDeclaration(name + ".type", "main", "main")) {
                block.emitTemp("%" + name + ".type = alloca i32, align 4", name + ".type", FunctionBlock.typesOfDeclarationValues.INT); //trzeba by zrobić na enumach
                block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);
            }
            if (!block.checkDeclaration("scanf_string", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                block.emitDeclareOrDefinition("@.scanf_string = private unnamed_addr constant [3 x i8] c\"%s\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
            };
            if (!block.checkDeclaration("scanf", FunctionBlock.typeDeclareOrDefiniton.DECLARE)) {
                block.emitDeclareOrDefinition("declare i32 @scanf(i8*, ...)", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDECLARE);
            }

            block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0");

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.scanf_string, i32 0, i32 0), i8* %" + (reg - 1) + ")");
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

            if (!block.checkDeclaration("main", "IsDigital")) {
                Compiler.LLVMCreatCodeIsDigital(block);
            }

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0");

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call zeroext i1 @IsDigital(i8* %" + (reg - 1) + ")");
            block.emitTemp("br i1 %" + reg + ", label %" + (reg + 1) + ", label %" + (reg + 8));

            reg = block.nextRegister();
            block.emitTemp("\n; <label>:" + reg);

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call double @atof(i8* %" + (reg - 3) + ")");
            if (!block.checkDeclaration("atof", FunctionBlock.typeDeclareOrDefiniton.DECLARE)) {
                block.emitDeclareOrDefinition("declare double @atof(i8*)", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDECLARE);
            }

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call double @fmod(double %" + (reg - 1) + ", double 1.000000e+00)");

            if (!block.checkDeclaration("fmod", FunctionBlock.typeDeclareOrDefiniton.DECLARE)) {
                block.emitDeclareOrDefinition("declare double @fmod(double, double)", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDECLARE);
            }

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = fcmp oeq double %" + (reg - 1) + ", 0.000000e+00");

            reg = block.nextRegister();
            block.emitTemp("br i1 %" + (reg - 1) + ", label %" + reg + ", label %" + (reg + 2));
            block.emitTemp("\n; <label>:" + reg);

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = fptosi double %" + (reg - 4) + " to i32");
            block.emitTemp("store i32 %" + reg + ", i32* %" + name + ".int, align 4");
            block.emitTemp("store i32 1, i32* %" + name + ".type, align 4");
            block.emitTemp("br label %" + (reg + 5));

            reg = block.nextRegister();
            block.emitTemp("\n; <label>:" + reg);
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
            if (!block.checkDeclaration(name, "main", "main")) {
                block.emitTemp("%" + name + ".double = alloca double, align 8", name, FunctionBlock.typesOfDeclarationValues.DOUBLE);
                block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);
            } else if (!block.checkDeclaration(name, FunctionBlock.typesOfDeclarationValues.DOUBLE, className, "main")) {
                secondStmts.add(new Compiler.VariableDeclaration(name, FunctionBlock.typesOfDeclarationValues.DOUBLE));
            }
            block.emitTemp("store double %" + (reg - 5) + ", double* %" + name + ".double, align 8");
            block.emitTemp("store i32 2, i32* %" + name + ".type, align 4");
            block.emitTemp("br label %" + (reg + 4));

            reg = block.nextRegister();
            block.emitTemp("\n; <label>:" + reg);
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

            reg = block.nextRegister();
            if (!block.checkDeclaration(name, "main", "main")) {
                secondStmts.add(new Compiler.VariableDeclaration(name, FunctionBlock.typesOfDeclarationValues.STRING));
            } else if (!block.checkDeclaration(name, FunctionBlock.typesOfDeclarationValues.STRING, className, "main")) {
                secondStmts.add(new Compiler.VariableDeclaration(name, FunctionBlock.typesOfDeclarationValues.STRING));
            }
            block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %" + name + ".string, i32 0, i32 0");

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call i8* @strcpy(i8* %" + (reg - 1) + ", i8* %" + (reg - 11) + ")");
            if (!block.checkDeclaration("strcpy", FunctionBlock.typeDeclareOrDefiniton.DECLARE)) {
                block.emitDeclareOrDefinition("declare i8* @strcpy(i8*, i8*)", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDECLARE);
            }
            block.emitTemp("store i32 3, i32* %" + name + ".type, align 4");
            block.emitTemp("br label %" + (reg + 1));

            reg = block.nextRegister();
            block.emitTemp("\n; <label>:" + reg);
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
            block.changeTypeOfDeclarationValues(name, className, "main", FunctionBlock.typesOfDeclarationValues.UNKNOWN);
        }
    }

    public static void LLVMCreatCodeIsDigital(FunctionBlock block) {
        int registerId = 1;

        block.emitTemp("define zeroext i1 @IsDigital(i8* %ciagZnakow) nounwind {");
        block.emitTemp("%" + registerId + " = alloca i8*, align 8");
        block.emit(className, "IsDigital", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

        block.emitTemp("%charEnd = alloca i8*, align 8", "charEnd", FunctionBlock.typesOfDeclarationValues.STRING);
        block.emit(className, "IsDigital", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);

        block.emitTemp("store i8* %ciagZnakow, i8** %1, align 8");

        registerId += 1;
        block.emitTemp("%" + registerId + " = load i8** %1, align 8");

        registerId += 1;
        block.emitTemp("%" + registerId + " = call x86_fp80 @strtold(i8* %2, i8** %charEnd)");

        registerId += 1;
        block.emitTemp("%" + registerId + " = load i8** %charEnd, align 8");

        registerId += 1;
        block.emitTemp("%" + registerId + " = load i8* %4, align 1");

        registerId += 1;
        block.emitTemp("%" + registerId + " = sext i8 %5 to i32");

        registerId += 1;
        block.emitTemp("%" + registerId + " = icmp eq i32 %6, 0");
        block.emitTemp("ret i1 %7");
        block.emitTemp("}");
        block.emit(className, "IsDigital", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

        if (!block.checkDeclaration("strtold", FunctionBlock.typeDeclareOrDefiniton.DECLARE)) {
            block.emitDeclareOrDefinition("declare x86_fp80 @strtold(i8*, i8**)", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDECLARE);
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
//            int reg = block.nextRegister();
//            if (!block.checkDeclaration("i32 @printf", FunctionBlock.typesOfDeclarations.DECLARE)) {
//                block.emit("declare i32 @printf(i8*, ...)", FunctionBlock.typesOfStringBuilders.EMITEND);
//            }
//            block.emit("@.str = private unnamed_addr constant [7 x i8] c\"import\\00\", align 1", FunctionBlock.typesOfStringBuilders.EMITSTART);
//            block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @.format_str, i32 0, i32 0))");//funkcje, metody
        }
    }

    public static class innaKlasaPoczatek extends Statement {

        private final Expression expr;

        public innaKlasaPoczatek(Expression expr) {
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
//            if (!block.checkDeclaration("i32 @printf", FunctionBlock.typesOfDeclarations.DECLARE)) {
//                block.emit("declare i32 @printf(i8*, ...)", FunctionBlock.typesOfStringBuilders.EMITEND);
//            }
//            int reg = block.nextRegister();
//            block.emit("@.str = private unnamed_addr constant [7 x i8] c\"poczatek\\00\", align 1", FunctionBlock.typesOfStringBuilders.EMITSTART);
//            block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @.format_str, i32 0, i32 0))");//funkcje, metody
        }
    }

    public static class innaKlasaKoniec extends Statement {

        private final Expression expr;

        public innaKlasaKoniec(Expression expr) {
            this.expr = expr;
        }

        @Override
        public void emit(FunctionBlock block) {
//            if (!block.checkDeclaration("i32 @printf", FunctionBlock.typesOfDeclarations.DECLARE)) {
//                block.emit("declare i32 @printf(i8*, ...)", FunctionBlock.typesOfStringBuilders.EMITEND);
//            }
//            int reg = block.nextRegister();
//            block.emit("@.str = private unnamed_addr constant [7 x i8] c\"koniec\\00\", align 1", FunctionBlock.typesOfStringBuilders.EMITSTART);
//            block.emit("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @.format_str, i32 0, i32 0))");//funkcje, metody
        }
    }

    public static class VariableDeclaration extends Statement {

        private String name;
        private Object[] value;
        private FunctionBlock.typesOfDeclarationValues type;

        public VariableDeclaration(String name, Object[] value) {
            this.name = name;
            this.value = value;
            this.type = FunctionBlock.typesOfDeclarationValues.UNKNOWN;
        }

        public VariableDeclaration(String name, FunctionBlock.typesOfDeclarationValues type) {
            this.name = name;
            this.type = type;
            this.value = null;
        }

        public void emit(FunctionBlock block) {
            if (!block.checkDeclaration(className, name)) {
                jfkgrammarParser.typeValue whatType;
                double valueNumber = 1;
                if (value == null) {
                    if (type.equals(FunctionBlock.typesOfDeclarationValues.INT) || type.equals(FunctionBlock.typesOfDeclarationValues.DOUBLE)) {
                        whatType = jfkgrammarParser.typeValue.NUMBER;
                        if (type.equals(FunctionBlock.typesOfDeclarationValues.INT)) {
                            valueNumber = 1.0;
                        } else {
                            valueNumber = 1.1;
                        }
                    } else {
                        whatType = jfkgrammarParser.typeValue.LITERA;
                    }
                } else {
                    if (value[1].equals(jfkgrammarParser.typeValue.NUMBER)) {
                        whatType = jfkgrammarParser.typeValue.NUMBER;
                        valueNumber = (Double) value[0];
                    } else {
                        whatType = jfkgrammarParser.typeValue.LITERA;
                    }
                }
                if (whatType.equals(jfkgrammarParser.typeValue.NUMBER)) {
                    if ((valueNumber % 1) == 0) {
                        block.emitTemp("%" + name + ".int = alloca i32, align 4", name, FunctionBlock.typesOfDeclarationValues.INT);
                        block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);

                    } else {
                        block.emitTemp("%" + name + ".double = alloca double, align 8", name, FunctionBlock.typesOfDeclarationValues.DOUBLE);
                        block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);
                    }
                } else {
                    block.emitTemp("%" + name + ".string = alloca [1009 x i8], align 1", name, FunctionBlock.typesOfDeclarationValues.STRING);
                    block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.ADDNEWALLOCA);
                }
            }
        }
    }

    public static class AssignmentVariable extends Statement {

        private String where;
        private Object[] value;

        public AssignmentVariable(String where, Object[] value) {
            this.where = where;
            this.value = value;
        }

        @Override
        public void emit(FunctionBlock block) {
            if (value[1].equals(jfkgrammarParser.typeValue.NUMBER)) {
                double valueNumber = (Double) value[0];
                if ((valueNumber % 1) == 0) {
                    if (!block.checkDeclaration(where, FunctionBlock.typesOfDeclarationValues.INT, className, "main")) {
                        secondStmts.add(new Compiler.VariableDeclaration(where, FunctionBlock.typesOfDeclarationValues.INT));
                    }
                    where += ".int";

                    block.emitTemp("store i32 " + (int) valueNumber + ", i32* %" + where + ", align 4");
                    block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
                    // System.out.println("\n\n\nvalueNumber = " + valueNumber+"\n\n\n");
                } else {
                    if (!block.checkDeclaration(where, FunctionBlock.typesOfDeclarationValues.DOUBLE, className, "main")) {
                        secondStmts.add(new Compiler.VariableDeclaration(where, FunctionBlock.typesOfDeclarationValues.DOUBLE));
                    }
                    // System.out.println("\n\n\n value[0] = " + value[0]+"\n\n\n");
                    where += ".double";
                    //block.emit("%" + reg + " = sitofp i32 %" + where + " to double"); //konwersja int do double w LLVM
                    block.emitTemp("store double " + value[0] + ", double* %" + where + ", align 8");
                    block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

                };
            } else {
//                String valueString = (String) value[0];
//                int reg = block.nextRegister();
//
//                hashMapValues.put(where, typesOfDeclarationValues.STRING);
//                where += ".string";
//
//                block.emit("%" + reg + " = getelementptr inbounds [1009 x i8]* %" + where + ", i32 0, i32 0");
//                if (hashMapChars.containsValue(value)) {
//                    reg = block.nextRegister();
//                    block.emit("%" + reg + "= call i8* @strcpy(i8* %" + (reg - 1) + ", i8* getelementptr inbounds ([" + valueString.length() + " x i8]* @" + getKeyByValueFromHashMap(hashMapChars, valueString) + ", i32 0, i32 0))");
//                } else {
//                    block.emit("@.str" + (hashMapChars.size() + 1) + " = private unnamed_addr constant [" + valueString.length() + " x i8] c\"" + valueString + "\\00\", align 1", FunctionBlock.typesOfStringBuilders.EMITSTART);
//                    reg = block.nextRegister();
//                    block.emit("%" + reg + "= call i8* @strcpy(i8* %" + (reg - 1) + ", i8* getelementptr inbounds ([" + valueString.length() + " x i8]* @.str" + hashMapChars.size() + ", i32 0, i32 0))");
//                }
            }
        }
    }

    public static class Invocation extends Statement {

        private List<Expression> params = new ArrayList<Expression>();

        public Invocation() {
        }

        public void add(Expression exp) {
            params.add(exp);
        }

        @Override
        public void emit(FunctionBlock block) {

            for (Expression exp : params) {
                if (!block.checkDeclaration("printf", FunctionBlock.typeDeclareOrDefiniton.DECLARE)) {
                    block.emitDeclareOrDefinition("declare i32 @printf(i8*, ...)", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDECLARE);
                }
                int res = exp.emit(block);
                int reg = block.nextRegister();

                switch (block.checkActualTypeOfDeclaration(exp.name(), className, "main")) {
                    case INT:
                        if (!block.checkDeclaration("printf_int", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_int = private unnamed_addr constant [5 x i8] c\"%i \\0A\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
                        }
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %" + res + ")");
                        break;

                    case DOUBLE:
                        if (!block.checkDeclaration("printf_double", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_double = private unnamed_addr constant [5 x i8] c\"%f \\0A\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
                        }
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %" + res + ")");
                        break;

                    case STRING:
                        if (!block.checkDeclaration("printf_string", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_string = private unnamed_addr constant [5 x i8] c\"%s \\0A\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
                        }
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %" + res + ", i32 0, i32 0");
//??
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.str2, i32 0, i32 0), i8* %" + (reg - 1) + ")");
                        break;

                    case UNKNOWN:
                        //  reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = load i32* %" + exp.name() + ".type, align 4");

                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = icmp eq i32 %" + (reg - 1) + ", 1");
                        block.emitTemp("br i1 %" + reg + ", label %" + (reg + 1) + ", label %" + (reg + 4));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);
                        if (!block.checkDeclaration("printf_int", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_int = private unnamed_addr constant [5 x i8] c\"%i \\0A\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
                        }

                        res = exp.emit(block);
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = load i32* %" + exp.name() + ".int, align 4");
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %" + res + ")");
                        block.emitTemp("br label %" + (reg + 9));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = icmp eq i32 %" + (reg - 6) + ", 2");
                        block.emitTemp("br i1 %" + reg + ", label %" + (reg + 1) + ", label %" + (reg + 4));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);
                        if (!block.checkDeclaration("printf_double", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_double = private unnamed_addr constant [5 x i8] c\"%f \\0A\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
                        }
                        res = exp.emit(block);
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = load double* %" + exp.name() + ".double, align 8");
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %" + res + ")");
                        block.emitTemp("br label %" + (reg + 4));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);

                        if (!block.checkDeclaration("printf_string", FunctionBlock.typeDeclareOrDefiniton.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_string = private unnamed_addr constant [5 x i8] c\"%s \\0A\\00\", align 1", FunctionBlock.typesOfEmitDeclareOrDefinition.EMITDEFINITON);
                        }
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %" + exp.name() + ".string, i32 0, i32 0");

                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %" + (reg - 1) + ")");
                        block.emitTemp("br label %" + (reg + 1));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);
                        break;
                    default:
                        break;
                };
                block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
            }
        }
    }

    public static abstract class Expression {

        public abstract int emit(FunctionBlock block);

        public abstract String name();
    }

    public static class IntExpression extends Expression {

        public final int val;

        public IntExpression(String val) {
            this.val = Integer.parseInt(val);
        }

        @Override
        public int emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emitTemp("%" + reg + " = add i32 0, " + val);
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);

            return reg;
        }

        public String name() {
            return null;
        }
    }

    public static class DoubleExpression extends Expression {

        public final double val;

        public DoubleExpression(String val) {
            this.val = Double.parseDouble(val);
        }

        @Override
        public int emit(FunctionBlock block) {
            int reg = block.nextRegister();
            block.emitTemp("%" + reg + " = fadd double 0.0, " + val);
            block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
            return reg;
        }

        public String name() {
            return null;
        }
    }

    public static class RefExpression extends Expression {

        private final String name;

        public RefExpression(String name) {
            this.name = name;
        }

        @Override
        public int emit(FunctionBlock block) {
            int reg = block.register();
            switch (block.checkActualTypeOfDeclaration(name, className, "main")) {
                case INT:
                    reg = block.nextRegister();
                    block.emitTemp("%" + reg + " = load i32* %" + name + ".int, align 4");
                    block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
                    break;
                case DOUBLE:
                    reg = block.nextRegister();
                    block.emitTemp("%" + reg + " = load double* %" + name + ".double, align 8");
                    block.emit(className, "main", FunctionBlock.typesOfEmitClassAndFunction.FUNCTIONSOFCLASS);
                    break;
            }
            return reg;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public String name() {
            return name;
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
