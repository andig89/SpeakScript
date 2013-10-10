package jfk;

import org.antlr.v4.runtime.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import static jfk.FunctionBlock.declarationValuesTypes.INT;
import static jfk.FunctionBlock.declarationValuesTypes.STRING;
import static jfk.FunctionBlock.functionTypes.DOUBLE;

public class Compiler {

    public static ArrayList<Statement> stmts = new ArrayList<Statement>();
    public static ArrayList<Statement> secondStmts = new ArrayList<Statement>();
    public static String className = "";
    public static String functionName = "";

    enum declarationValuesTypes {

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

        public void add(ArrayList<Statement> stmt) {
            for (int i = 0; stmt.size() > i; i++) {
                stmts.add(stmt.get(i));
            }
        }

        public String emit() {
            FunctionBlock block = new FunctionBlock();
            block.newRegister();
            className = "main";
            functionName = "main";

            block.emitTemp("");
            block.emit(className, functionName, FunctionBlock.emitTypes.CLASS);

            block.emitTemp("define i32 @main() nounwind {");
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
            for (Statement stmt : stmts) {
                stmt.emit(block);
            }
            for (Statement secondStmt : secondStmts) {
                secondStmt.emit(block);
            }
            block.emitTemp("ret i32 0");
            block.emitTemp("}");
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

            return block.getEmit();
        }
    }

    public static abstract class Statement {

        public abstract void emit(FunctionBlock block);
    }

    public static class Return extends Statement {

        private Object[] returnVariable;

        public Return(Object[] returnVariable) {
            this.returnVariable = returnVariable;
        }

        @Override
        public void emit(FunctionBlock block) {
            if (returnVariable == null) {
                block.emitTemp("ret void");
                block.setFunctionType(className, functionName, FunctionBlock.functionTypes.VOID);
            } else {
                if (returnVariable[1].equals(jfkgrammarParser.typeReturn.ANOTHER)) {
                    if (isNumeric((String) returnVariable[0])) {
                        if ((Double.parseDouble((String) returnVariable[0]) % 1) == 0) {
                            block.emitTemp("ret i32 " + (String) returnVariable[0]);
                            block.setFunctionType(className, functionName, FunctionBlock.functionTypes.INT);
                        } else {
                            block.emitTemp("ret double " + (String) returnVariable[0]);
                            block.setFunctionType(className, functionName, FunctionBlock.functionTypes.DOUBLE);
                        }
                    } else {
                        if (!block.checkDeclaration((String) returnVariable[0], className, functionName)) {
                            throw new IllegalArgumentException("Zmienna nie została zadeklarowana.");
                        } else {
                            new Compiler.RefExpression((String) returnVariable[0]).emit(block);
                            switch (block.checkActualTypeOfDeclaration((String) returnVariable[0], className, functionName)) {
                                case INT:
                                    block.setFunctionType(className, functionName, FunctionBlock.functionTypes.INT);
                                    block.emitTemp("ret i32 %" + block.register());
                                    break;
                                case DOUBLE:
                                    block.setFunctionType(className, functionName, FunctionBlock.functionTypes.DOUBLE);
                                    block.emitTemp("ret double %" + block.register());
                                    break;
                                case STRING:
                                    block.setFunctionType(className, functionName, FunctionBlock.functionTypes.STRING);
                                    block.emitTemp("ret i8 %" + block.register());
                                    break;
                                case UNKNOWN:
                                    break;
                            }
                            //block.emitTemp("ret i8 " + block.register());
                        }
                    }
                } else {
                    block.emitTemp("define i8* @" + functionName + "() nounwind {");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
                    block.emitDeclareOrDefinition("@." + functionName + ".return = private unnamed_addr constant [" + (returnVariable[0].toString().length() + 2) + " x i8] c\"" + returnVariable[0].toString() + " \\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                    block.emitTemp("ret i8* getelementptr inbounds ([" + (returnVariable[0].toString().length() + 2) + " x i8]* " + "@." + functionName + ".return, i32 0, i32 0)");
                    block.setFunctionType(className, functionName, FunctionBlock.functionTypes.STRING);
                }
            }
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
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
                block.emitTemp("%scanf.string = alloca [1009 x i8], align 1", "scanf.string", FunctionBlock.declarationValuesTypes.STRING);
                block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
            }
            if (!block.checkDeclaration(name + ".type", "main", "main")) {
                block.emitTemp("%" + name + ".type = alloca i32, align 4", name + ".type", FunctionBlock.declarationValuesTypes.INT); //trzeba by zrobić na enumach
                block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
            }
            if (!block.checkDeclaration("scanf_string", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                block.emitDeclareOrDefinition("@.scanf_string = private unnamed_addr constant [3 x i8] c\"%s\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
            };
            if (!block.checkDeclaration("scanf", FunctionBlock.declareOrDefinitonType.DECLARE)) {
                block.emitDeclareOrDefinition("declare i32 @scanf(i8*, ...)", FunctionBlock.declareOrDefinitonType.DECLARE);
            }

            block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0");

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.scanf_string, i32 0, i32 0), i8* %" + (reg - 1) + ")");
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

            if (!block.checkDeclaration("main", "IsDigital")) {
                Compiler.LLVMCreatCodeIsDigital(block, className);
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
            if (!block.checkDeclaration("atof", FunctionBlock.declareOrDefinitonType.DECLARE)) {
                block.emitDeclareOrDefinition("declare double @atof(i8*)", FunctionBlock.declareOrDefinitonType.DECLARE);
            }

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call double @fmod(double %" + (reg - 1) + ", double 1.000000e+00)");

            if (!block.checkDeclaration("fmod", FunctionBlock.declareOrDefinitonType.DECLARE)) {
                block.emitDeclareOrDefinition("declare double @fmod(double, double)", FunctionBlock.declareOrDefinitonType.DECLARE);
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
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
            if (!block.checkDeclaration(name, "main", "main")) {
                block.emitTemp("%" + name + ".double = alloca double, align 8", name, FunctionBlock.declarationValuesTypes.DOUBLE);
                block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
            } else if (!block.checkDeclaration(name, FunctionBlock.declarationValuesTypes.DOUBLE, className, functionName)) {
                secondStmts.add(new Compiler.VariableDeclaration(name, FunctionBlock.declarationValuesTypes.DOUBLE));
            }
            block.emitTemp("store double %" + (reg - 5) + ", double* %" + name + ".double, align 8");
            block.emitTemp("store i32 2, i32* %" + name + ".type, align 4");
            block.emitTemp("br label %" + (reg + 4));

            reg = block.nextRegister();
            block.emitTemp("\n; <label>:" + reg);
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

            reg = block.nextRegister();
            if (!block.checkDeclaration(name, "main", "main")) {
                secondStmts.add(new Compiler.VariableDeclaration(name, FunctionBlock.declarationValuesTypes.STRING));
            } else if (!block.checkDeclaration(name, FunctionBlock.declarationValuesTypes.STRING, className, functionName)) {
                secondStmts.add(new Compiler.VariableDeclaration(name, FunctionBlock.declarationValuesTypes.STRING));
            }
            block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %" + name + ".string, i32 0, i32 0");

            reg = block.nextRegister();
            block.emitTemp("%" + reg + " = call i8* @strcpy(i8* %" + (reg - 1) + ", i8* %" + (reg - 11) + ")");
            if (!block.checkDeclaration("strcpy", FunctionBlock.declareOrDefinitonType.DECLARE)) {
                block.emitDeclareOrDefinition("declare i8* @strcpy(i8*, i8*)", FunctionBlock.declareOrDefinitonType.DECLARE);
            }
            block.emitTemp("store i32 3, i32* %" + name + ".type, align 4");
            block.emitTemp("br label %" + (reg + 1));

            reg = block.nextRegister();
            block.emitTemp("\n; <label>:" + reg);
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
            block.changeTypeOfDeclarationValues(name, className, functionName, FunctionBlock.declarationValuesTypes.UNKNOWN);
        }
    }

    public static void LLVMCreatCodeIsDigital(FunctionBlock block, String className) {
        int registerId = 1;

        block.emitTemp("define zeroext i1 @IsDigital(i8* %ciagZnakow) nounwind {");
        block.emit(className, "IsDigital", FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
        block.emitTemp("%" + registerId + " = alloca i8*, align 8");
        block.emit(className, "IsDigital", FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

        block.emitTemp("%charEnd = alloca i8*, align 8", "charEnd", FunctionBlock.declarationValuesTypes.STRING);
        block.emit(className, "IsDigital", FunctionBlock.emitTypes.ADDNEWALLOCA);

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
        block.emit(className, "IsDigital", FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

        if (!block.checkDeclaration("strtold", FunctionBlock.declareOrDefinitonType.DECLARE)) {
            block.emitDeclareOrDefinition("declare x86_fp80 @strtold(i8*, i8**)", FunctionBlock.declareOrDefinitonType.DECLARE);
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

    //        public void add(ImportFile stmt) {
//            imports.add(stmt);
//        }
    public static class CallFunction extends Statement {

        private String callFunctionName;
        private String variableToSaveReturn;

        public CallFunction(String variableToSaveReturn, String callFunctionName) {
            this.callFunctionName = callFunctionName;
            this.variableToSaveReturn = variableToSaveReturn;
        }

        @Override
        public void emit(FunctionBlock block) {
            int reg = block.nextRegister();
            switch (block.checkFunctionType(className, callFunctionName)) {
                case VOID:
                    block.emitTemp("%" + reg + " = call void @" + callFunctionName + "()");
                    break;
                case INT:
                    block.emitTemp("%" + reg + " = call i32 @" + callFunctionName + "()");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
                    if (!block.checkDeclaration(variableToSaveReturn, className, functionName) || !block.checkDeclaration(variableToSaveReturn, FunctionBlock.declarationValuesTypes.INT, className, functionName)) {
                        block.emitTemp("%" + variableToSaveReturn + ".int = alloca i32, align 4", variableToSaveReturn, FunctionBlock.declarationValuesTypes.INT);
                        block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
                    }
                    block.emitTemp("store i32 %" + reg + ", i32* %" + variableToSaveReturn + ".int, align 4");
                    break;
                case DOUBLE:
                    block.emitTemp("%" + reg + " = call double @" + callFunctionName + "()");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
                    if (!block.checkDeclaration(variableToSaveReturn, className, functionName) || !block.checkDeclaration(variableToSaveReturn, FunctionBlock.declarationValuesTypes.DOUBLE, className, functionName)) {
                        block.emitTemp("%" + variableToSaveReturn + ".double = alloca double, align 8", variableToSaveReturn, FunctionBlock.declarationValuesTypes.DOUBLE);
                        block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
                    }
                    block.emitTemp("store double %" + reg + ", double* %" + variableToSaveReturn + ".double, align 8");
                    break;
                case STRING:
                    block.emitTemp("%" + reg + " = call i8* @" + callFunctionName + "()");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
                    if (!block.checkDeclaration(variableToSaveReturn, className, functionName) || !block.checkDeclaration(variableToSaveReturn, FunctionBlock.declarationValuesTypes.STRING, className, functionName)) {
                        block.emitTemp("%" + variableToSaveReturn + ".string = alloca i8*, align 8", variableToSaveReturn, FunctionBlock.declarationValuesTypes.STRING);

                        block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
                    }
                    block.emitTemp("store i8* %" + reg + ", i8** %" + variableToSaveReturn + ".string, align 1");
                    break;
            }
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
        }
    }

    public static class InnaFunkcjaPoczatek extends Statement {

        private String newFnctionNameStart;
        private String newFnctionNameEnd;

        public InnaFunkcjaPoczatek(String newFnctionNameStart, String newFnctionNameEnd) {
            this.newFnctionNameStart = newFnctionNameStart;
            this.newFnctionNameEnd = newFnctionNameEnd;
        }

        @Override
        public void emit(FunctionBlock block) {
            if (!newFnctionNameStart.equals(newFnctionNameEnd)) {
                throw new IllegalArgumentException("Niezgodność nazw na początku i końcu klasy.");
            }
            functionName = newFnctionNameStart;
            block.emitTemp("define void @" + functionName + "() nounwind {");
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
            block.setFunctionType(className, newFnctionNameStart, FunctionBlock.functionTypes.VOID);
            block.newRegister();
        }
    }

    public static class InnaFunkcjaKoniec extends Statement {

        private String newFunctionName;
        private Object[] returnVariable;

        public InnaFunkcjaKoniec(String newFunctionName, Object[] returnVariable) {
            this.newFunctionName = newFunctionName;
            this.returnVariable = returnVariable;
        }

        @Override
        public void emit(FunctionBlock block) {
            if (returnVariable == null) {
                block.emitTemp("define void @" + functionName + "() nounwind {");
                block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
                block.setFunctionType(className, newFunctionName, FunctionBlock.functionTypes.VOID);
            } else {
                if (returnVariable[1].equals(jfkgrammarParser.typeReturn.ANOTHER)) {
                    if (isNumeric((String) returnVariable[0])) {
                        if ((Double.parseDouble((String) returnVariable[0]) % 1) == 0) {
                            block.emitTemp("define i32 @" + functionName + "() nounwind {");
                            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
                            block.setFunctionType(className, newFunctionName, FunctionBlock.functionTypes.INT);
                        } else {
                            block.emitTemp("define double @" + functionName + "() nounwind {");
                            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
                            block.setFunctionType(className, newFunctionName, FunctionBlock.functionTypes.DOUBLE);
                        }
                    } else {
                        switch (block.checkActualTypeOfDeclaration((String) returnVariable[0], className, functionName)) {
                            case INT:
                                block.setFunctionType(className, functionName, FunctionBlock.functionTypes.INT);
                                block.emitTemp("define i32 @" + functionName + "() nounwind {");
                                break;
                            case DOUBLE:
                                block.setFunctionType(className, functionName, FunctionBlock.functionTypes.DOUBLE);
                                block.emitTemp("define double @" + functionName + "() nounwind {");
                                break;
                            case STRING:
                                block.setFunctionType(className, functionName, FunctionBlock.functionTypes.STRING);
                                block.emitTemp("define signext i8 @" + functionName + "() nounwind {");
                                break;
                            case UNKNOWN:
                                break;
                        }
                        block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASSDEFINE);
                    }
                }
            }

            block.removeLastRegister();
            block.emitTemp("}");
            block.emit(className, newFunctionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
            Compiler.functionName = "main";
        }
    }

    public static class VariableDeclaration extends Statement {

        private String name;
        private Object[] value;
        private FunctionBlock.declarationValuesTypes type;

        public VariableDeclaration(String name, Object[] value) {
            this.name = name;
            this.value = value;
            this.type = FunctionBlock.declarationValuesTypes.UNKNOWN;
        }

        public VariableDeclaration(String name, FunctionBlock.declarationValuesTypes type) {
            this.name = name;
            this.type = type;
            this.value = null;
        }

        public void emit(FunctionBlock block) {
            if (!block.checkDeclaration(className, name)) {
                jfkgrammarParser.typeValue whatType;
                double valueNumber = 1;
                if (value == null) {
                    if (type.equals(FunctionBlock.declarationValuesTypes.INT) || type.equals(FunctionBlock.declarationValuesTypes.DOUBLE)) {
                        whatType = jfkgrammarParser.typeValue.NUMER;
                        if (type.equals(FunctionBlock.declarationValuesTypes.INT)) {
                            valueNumber = 1.0;
                        } else {
                            valueNumber = 1.1;
                        }
                    } else {
                        whatType = jfkgrammarParser.typeValue.LITERA;
                    }
                } else {
                    if (value[1].equals(jfkgrammarParser.typeValue.NUMER)) {
                        whatType = jfkgrammarParser.typeValue.NUMER;
                        valueNumber = (Double) value[0];
                    } else {
                        whatType = jfkgrammarParser.typeValue.LITERA;
                    }
                }
                if (whatType.equals(jfkgrammarParser.typeValue.NUMER)) {
                    if ((valueNumber % 1) == 0) {
                        block.emitTemp("%" + name + ".int = alloca i32, align 4", name, FunctionBlock.declarationValuesTypes.INT);
                        block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);

                    } else {
                        block.emitTemp("%" + name + ".double = alloca double, align 8", name, FunctionBlock.declarationValuesTypes.DOUBLE);
                        block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
                    }
                } else {
                    block.emitTemp("%" + name + ".string = alloca [1009 x i8], align 1", name, FunctionBlock.declarationValuesTypes.STRING);
                    block.emit(className, functionName, FunctionBlock.emitTypes.ADDNEWALLOCA);
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
            if (value[1].equals(jfkgrammarParser.typeValue.NUMER)) {
                double valueNumber = (Double) value[0];
                if ((valueNumber % 1) == 0) {
                    if (!block.checkDeclaration(where, FunctionBlock.declarationValuesTypes.INT, className, functionName)) {
                        secondStmts.add(new Compiler.VariableDeclaration(where, FunctionBlock.declarationValuesTypes.INT));
                    }
                    where += ".int";

                    block.emitTemp("store i32 " + (int) valueNumber + ", i32* %" + where + ", align 4");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
                    // System.out.println("\n\n\nvalueNumber = " + valueNumber+"\n\n\n");
                } else {
                    if (!block.checkDeclaration(where, FunctionBlock.declarationValuesTypes.DOUBLE, className, functionName)) {
                        secondStmts.add(new Compiler.VariableDeclaration(where, FunctionBlock.declarationValuesTypes.DOUBLE));
                    }
                    // System.out.println("\n\n\n value[0] = " + value[0]+"\n\n\n");
                    where += ".double";
                    //block.emit("%" + reg + " = sitofp i32 %" + where + " to double"); //konwersja int do double w LLVM
                    block.emitTemp("store double " + value[0] + ", double* %" + where + ", align 8");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

                };
            } else {
//                String valueString = (String) value[0];
//                int reg = block.nextRegister();
//
//                hashMapValues.put(where, declarationValuesTypes.STRING);
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

        private ArrayList<Expression> params = new ArrayList<Expression>();

        public Invocation() {
        }

        public void add(Expression exp) {
            params.add(exp);
        }

        @Override
        public void emit(FunctionBlock block) {

            for (Expression exp : params) {
                if (!block.checkDeclaration("printf", FunctionBlock.declareOrDefinitonType.DECLARE)) {
                    block.emitDeclareOrDefinition("declare i32 @printf(i8*, ...)", FunctionBlock.declareOrDefinitonType.DECLARE);
                }
                int res = exp.emit(block);
                int reg = block.nextRegister();

                switch (block.checkActualTypeOfDeclaration(exp.name(), className, functionName)) {
                    case INT:
                        if (!block.checkDeclaration("printf_int", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_int = private unnamed_addr constant [5 x i8] c\"%i \\0A\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                        }
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %" + res + ")");
                        break;

                    case DOUBLE:
                        if (!block.checkDeclaration("printf_double", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_double = private unnamed_addr constant [5 x i8] c\"%f \\0A\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                        }
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %" + res + ")");
                        break;

                    case STRING:
                        if (!block.checkDeclaration("printf_string", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_string = private unnamed_addr constant [5 x i8] c\"%s \\0A\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                        }

                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %" + (reg - 1) + ")");
                        break;

                    case UNKNOWN:
                        block.emitTemp("%" + reg + " = load i32* %" + exp.name() + ".type, align 4");

                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = icmp eq i32 %" + (reg - 1) + ", 1");
                        block.emitTemp("br i1 %" + reg + ", label %" + (reg + 1) + ", label %" + (reg + 4));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);
                        if (!block.checkDeclaration("printf_int", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_int = private unnamed_addr constant [5 x i8] c\"%i \\0A\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                        }

                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = load i32* %" + exp.name() + ".int, align 4");
                        res = exp.emit(block);
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
                        if (!block.checkDeclaration("printf_double", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_double = private unnamed_addr constant [5 x i8] c\"%f \\0A\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                        }
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = load double* %" + exp.name() + ".double, align 8");
                        res = exp.emit(block);
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %" + res + ")");
                        block.emitTemp("br label %" + (reg + 4));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);

                        if (!block.checkDeclaration("printf_string", FunctionBlock.declareOrDefinitonType.DEFINITION)) {
                            block.emitDeclareOrDefinition("@.printf_string = private unnamed_addr constant [5 x i8] c\"%s \\0A\\00\", align 1", FunctionBlock.declareOrDefinitonType.DEFINITION);
                        }
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = getelementptr inbounds [1009 x i8]* %" + exp.name() + ".string, i32 0, i32 0");

                        res = exp.emit(block);
                        reg = block.nextRegister();
                        block.emitTemp("%" + reg + " = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %" + res + ")");
                        block.emitTemp("br label %" + (reg + 1));

                        reg = block.nextRegister();
                        block.emitTemp("\n; <label>:" + reg);
                        break;
                    default:
                        break;
                };
                block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
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
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);

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
            block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
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
            switch (block.checkActualTypeOfDeclaration(name, className, functionName)) {
                case INT:
                    reg = block.nextRegister();
                    block.emitTemp("%" + reg + " = load i32* %" + name + ".int, align 4");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
                    break;
                case DOUBLE:
                    reg = block.nextRegister();
                    block.emitTemp("%" + reg + " = load double* %" + name + ".double, align 8");
                    block.emit(className, functionName, FunctionBlock.emitTypes.FUNCTIONSOFCLASS);
                    break;
                case STRING:
                    reg = block.nextRegister();
                    block.emitTemp("%" + reg + " = load i8** %" + name + ".string, align 8");
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
