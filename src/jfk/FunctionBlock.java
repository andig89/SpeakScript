package jfk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FunctionBlock {

    public FunctionBlock() {
    }

    private class ObjectOfBuildersInFunction {

        StringBuilder builderMain = new StringBuilder();
        StringBuilder builderDefine = new StringBuilder();
        StringBuilder builderAllocaString = new StringBuilder();
        StringBuilder builderAllocaAnother = new StringBuilder();

        public ObjectOfBuildersInFunction() {
        }

        public ObjectOfBuildersInFunction(StringBuilder builderMain, StringBuilder builderAlloca) {
            this.builderDefine = builderDefine;
            this.builderMain = builderMain;
            this.builderAllocaString = builderAlloca;
            this.builderAllocaAnother = builderAlloca;
        }
    }

    private class ObjectsOfAllocaValue {

        declarationValuesTypes actualTypeOfDeclarationValue;
        ArrayList<declarationValuesTypes> allocaTypesOfValue = new ArrayList<declarationValuesTypes>();

        public ObjectsOfAllocaValue() {
        }

        public ObjectsOfAllocaValue(declarationValuesTypes actualTypeOfDeclarationValue) {
            this.actualTypeOfDeclarationValue = actualTypeOfDeclarationValue;
            allocaTypesOfValue.add(actualTypeOfDeclarationValue);
        }
    }

    private class ObjectsOfFunction {

        ObjectOfBuildersInFunction objectOfBuildersInFunction = new ObjectOfBuildersInFunction();
        HashMap<String, ObjectsOfAllocaValue> hashMapFunctionValues = new HashMap<String, ObjectsOfAllocaValue>();
        functionTypes functionType;

        public ObjectsOfFunction() {
        }
    }

    private class ObjectOfObjectsClass {

        HashMap<String, ObjectsOfFunction> hashMapFunction = new HashMap<String, ObjectsOfFunction>();
        StringBuilder builderClasses = new StringBuilder();

        public ObjectOfObjectsClass() {
        }

        public ObjectOfObjectsClass(HashMap<String, ObjectsOfFunction> hashMapFunction, StringBuilder builderClasses) {
            this.hashMapFunction = hashMapFunction;
            this.builderClasses = builderClasses;
        }
    }
    private StringBuilder builderTemp = new StringBuilder(), builderDefinition = new StringBuilder(), builderDeclare = new StringBuilder();
    private HashMap<String, ObjectOfObjectsClass> hashMapClasses = new HashMap<String, ObjectOfObjectsClass>();
    private ObjectsOfAllocaValue objectOfAllocaValue;
    private HashMap<String, String> hashMapDefinition = new HashMap<String, String>();
    private ArrayList<String> declaresArrayList = new ArrayList<String>();
    private ArrayList<Object[]> registerId = new ArrayList<Object[]>();
    String nameOfAllocaValue;

    enum functionTypes {

        INT, DOUBLE, STRING, VOID
    }

    /**
     * Enum zaiwerający symbole odnoszące się do dwóch części kodu LLVM.
     *
     * @param DECLARE - jest symbolem odnoszącym się do deklaracji funkcji (np. <code>declare i32
     * @scanf(i8*, ...)</code>) znajdujących się w zmiennej
     * {@link  jfk.FunctionBlock#builderDeclare}, użytych w programie LLVM.
     * @param DEFINITION - jest symbolem odnoszącym się do definicji * * * * * *
     * * * * * *
     * (np. <code>@.scanf_string = private unnamed_addr constant [3 x i8] c"%s\00", align 1</code>)
     * znajdujących się w zmiennej {@link  jfk.FunctionBlock#builderDefinition},
     * użytych w programie LLVM.
     */
    enum declareOrDefinitonType {

        /**
         * @param DECLARE - jest symbolem odnoszącym się do deklaracji funkcji
         * (np. <code>declare i32
         * @scanf(i8*, ...)</code>) znajdujących się w zmiennej
         * {@link  jfk.FunctionBlock#builderDeclare}, użytych w programie LLVM.
         */
        DECLARE,
        /**
         * @param DEFINITION - jest symbolem odnoszącym się do definicji * * * *
         * * * * * * * *
         * (np. <code>@.scanf_string = private unnamed_addr constant [3 x i8] c"%s\00", align 1</code>)
         * znajdujących się w zmiennej
         * {@link  jfk.FunctionBlock#builderDefinition}, użytych w programie
         * LLVM.
         */
        DEFINITION;
    };

    /**
     * Enum zaiwerający obsługiwane typy deklaracji zmiennych w języku
     * SpeakScript.
     *
     * @param INT typ typu {@link Integer},
     * @param DOUBLE typ typu {@link Double},
     * @param STRING typ typu {@link String},
     * @param UNKNOWN typ nieznany, użyty w przypadku użycia funkcji
     * {@link jfk.Compiler.Scanf}.
     */
    enum declarationValuesTypes {

        /**
         * @param INT typ typu {@link Integer},
         */
        INT,
        /**
         * @param DOUBLE typ typu {@link Double},
         */
        DOUBLE,
        /**
         * @param STRING typ typu {@link String},
         */
        STRING,
        /**
         * @param UNKNOWN typ nieznany, użyty w przypadku użycia funkcji
         * {@link jfk.Compiler.Scanf}.
         */
        UNKNOWN
    };

    /**
     * Enum zaiwerający symbole oznaczające sposób i miejsce dodania kodu LLVM
     * oraz informacji o tym fragmęcie kodu do konkretnych zmiennych poprzez
     * funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes).
     *
     * @param FUNCTIONSOFCLASS symbol onaczający dodania kodu LLVM danej funkcji danej klasy programu LLVM oraz informacji o tym fragmęcie kodu do konkretnych zmiennych poprzez funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes);
     * @param ADDNEWALLOCA symbol onaczający dodania kodu LLVM alokacji
     * zmiennych danej funckji danej klasy programu LLVM oraz informacji o tym
     * fragmęcie kodu do konkretnych zmiennych poprzez funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes);
     * @param CLASS symbol onaczający dodania kodu LLVM danej klasy programu
     * LLVM oraz informacji o tym fragmęcie kodu do konkretnych zmiennych
     * poprzez funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes).
     */
    enum emitTypes {

        /**
         * @param FUNCTIONSOFCLASS symbol onaczający dodania kodu LLVM danej
         * funkcji danej klasy programu LLVM oraz informacji o tym fragmęcie
         * kodu do konkretnych zmiennych poprzez funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes);
         */
        FUNCTIONSOFCLASS,
        /**
         * @param ADDNEWALLOCA symbol onaczający dodania kodu LLVM alokacji
         * zmiennych danej funckji danej klasy programu LLVM oraz informacji o
         * tym fragmęcie kodu do konkretnych zmiennych poprzez funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes);
         */
        FUNCTIONSOFCLASSDEFINE,
        ADDNEWALLOCA,
        /**
         * @param CLASS symbol onaczający dodania kodu LLVM danej klasy programu
         * LLVM oraz informacji o tym fragmęcie kodu do konkretnych zmiennych
         * poprzez funkcję {@link  jfk.FunctionBlock#emit(java.lang.String, java.lang.String, jfk.FunctionBlock.emitTypes).
         */
        CLASS
    };

    /**
     * Funkcja zwracająca klucz rekordu w mapie o podanej wartość.
     *
     * @param map zmienna zawierająca elemnt typu {@link Map}.
     * @param value poszukiwana wartość w zmiennej {
     * @param map}.
     *
     * @return {
     * @param map.K} - klucz wyszukanego rekordu.
     */
    private static <K, E> K getKeyByValueFromHashMap(Map<K, E> map, E value) {
        for (Map.Entry<K, E> entryOfIteratorOfObjectsClass : map.entrySet()) {
            if (value.equals(entryOfIteratorOfObjectsClass.getValue())) {
                return entryOfIteratorOfObjectsClass.getKey();
            }
        }
        return null;
    }

    /**
     * Funkcja zmienia główny rejest ID LLVM o +1.
     *
     * @return <code>int registerId</code>
     */
    public int nextRegister() {
        if ((boolean) registerId.get(registerId.size() - 1)[1]) {
            registerId.get(registerId.size() - 1)[1] = false;
        } else {
            registerId.set(registerId.size() - 1, new Object[]{(int) registerId.get(registerId.size() - 1)[0] + 1, registerId.get(registerId.size() - 1)[1]});
        }
        return (int) registerId.get(registerId.size() - 1)[0];
    }

    /**
     * Funkcja zwraca aktualny rejest ID LLVM.
     *
     * @return <code>int registerId</code>
     */
    public int register() {
        return (int) registerId.get(registerId.size() - 1)[0];
    }

    /**
     * Funkcja dodaje nowy registerId do ArrayList.
     *
     */
    public void newRegister() {
        registerId.add(new Object[]{1, true});
    }

    /**
     * Funkcja usuwa ostatni registerId z ArrayList.
     *
     */
    public void removeLastRegister() {
        registerId.remove(registerId.size() - 1);
    }

    /**
     * Funkcja dodaje tekst do
     * <code>StringBuilder builder</code>, który jest zbiorem poleceń programu
     * głównego LLVM.
     *
     * @param str ciąg znaków który chcemy dodać.
     * @param type jeden z typów
     * {@link jfk.FunctionBlock.typesOfStringBuilders}, tj. <code>EMIT</code>
     * lub <code>EMITSTART</code> lub <code>EMITEND</code>.
     * @return
     */
    public String emitDeclareOrDefinition(String str, declareOrDefinitonType type) {
        switch (type) {
            case DEFINITION:
                if (!hashMapDefinition.containsValue(str)) {
                    hashMapDefinition.put(".str" + (hashMapDefinition.size() + 1), str);
                    builderDefinition.append(str).append("\n");
                    return ".str" + hashMapDefinition.size();
                } else {
                    return getKeyByValueFromHashMap(hashMapDefinition, str);
                }
            case DECLARE:
                if (!declaresArrayList.contains(str.substring(str.indexOf("@") + 1, str.indexOf("(")))) {
                    declaresArrayList.add(str.substring(str.indexOf("@") + 1, str.indexOf("(")));
                    builderDeclare.append(str).append("\n");
                }
                return null;
            default:
                return "False";
        }
    }

    public void setFunctionType(String className, String functionName, functionTypes type) {
        hashMapClasses.get(className).hashMapFunction.get(functionName).functionType = type;
    }

    public functionTypes checkFunctionType(String className, String functionName) {
        return hashMapClasses.get(className).hashMapFunction.get(functionName).functionType;
    }

    /**
     * Funkcja dodaje tekst do
     * <code>StringBuilder builder</code>, który jest zbiorem poleceń programu
     * głównego LLVM.
     *
     * @param str - ciąg znaków który chcemy dodać.
     */
    public void emitTemp(String str) {
        builderTemp.append(str).append("\n");
    }

    public void emitTemp(String str, String valueName, declarationValuesTypes typeDeclaration) {
        objectOfAllocaValue = new ObjectsOfAllocaValue(typeDeclaration);
        nameOfAllocaValue = valueName;
        builderTemp.append(str).append("\n");
    }

    public void emit(String className, String functionName, emitTypes type) {
        switch (type) {
            case FUNCTIONSOFCLASS:
                //System.out.println(hashMapClasses.get(className).hashMapFunction.get(functionName).objectOfBuildersInFunction.builderMain);
                hashMapClasses.get(className).hashMapFunction.get(functionName).objectOfBuildersInFunction.builderMain.append(builderTemp);
                builderTemp = new StringBuilder();
                break;
            case FUNCTIONSOFCLASSDEFINE:
                if (!hashMapClasses.get(className).hashMapFunction.containsKey(functionName)) {
                    ObjectsOfFunction objectsOfFunctions = new ObjectsOfFunction();
                    objectsOfFunctions.objectOfBuildersInFunction.builderDefine = builderTemp;
                    hashMapClasses.get(className).hashMapFunction.put(functionName, objectsOfFunctions);

                } else {
                    //System.out.println(hashMapClasses.get(className).hashMapFunction.get(functionName).objectOfBuildersInFunction.builderMain);
                    hashMapClasses.get(className).hashMapFunction.get(functionName).objectOfBuildersInFunction.builderDefine = builderTemp;
                }

                builderTemp = new StringBuilder();
                break;
            case ADDNEWALLOCA:
                try {
                    HashMap<String, ObjectsOfAllocaValue> hashMapFunctionValues = hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues;
                    if (!hashMapFunctionValues.containsKey(nameOfAllocaValue)) {
                        ObjectsOfFunction objectsOfFunction = hashMapClasses.get(className).hashMapFunction.get(functionName);

                        if (objectOfAllocaValue.actualTypeOfDeclarationValue.equals(declarationValuesTypes.STRING)) {
                            objectsOfFunction.objectOfBuildersInFunction.builderAllocaString.append(builderTemp);
                        } else {
                            objectsOfFunction.objectOfBuildersInFunction.builderAllocaAnother.append(builderTemp);
                        }
                        objectsOfFunction.hashMapFunctionValues.put(nameOfAllocaValue, objectOfAllocaValue);
                        hashMapClasses.get(className).hashMapFunction.put(functionName, objectsOfFunction);
                    } else {
                        if (!hashMapFunctionValues.get(nameOfAllocaValue).allocaTypesOfValue.contains(objectOfAllocaValue.actualTypeOfDeclarationValue)) {
                            ObjectsOfFunction objectsOfFunction = hashMapClasses.get(className).hashMapFunction.get(functionName);

                            objectsOfFunction.hashMapFunctionValues.get(nameOfAllocaValue).actualTypeOfDeclarationValue = objectOfAllocaValue.actualTypeOfDeclarationValue;
                            objectsOfFunction.hashMapFunctionValues.get(nameOfAllocaValue).allocaTypesOfValue.add(objectOfAllocaValue.actualTypeOfDeclarationValue);
                            if (objectOfAllocaValue.actualTypeOfDeclarationValue.equals(declarationValuesTypes.STRING)) {
                                objectsOfFunction.objectOfBuildersInFunction.builderAllocaString.append(builderTemp);
                            } else {
                                objectsOfFunction.objectOfBuildersInFunction.builderAllocaAnother.append(builderTemp);
                            }
                            hashMapClasses.get(className).hashMapFunction.put(functionName, objectsOfFunction);
                            hashMapClasses.get(className).hashMapFunction.get(functionName);
                        }
                    }
                    builderTemp = new StringBuilder();
                } catch (NullPointerException e) {
                    System.out.println("Podana funkcja nie istnieje w danej klasie.");
                    System.exit(1);
                }
                break;
            case CLASS:
                ObjectOfObjectsClass objectOfObjectsClass = new ObjectOfObjectsClass();
                objectOfObjectsClass.builderClasses = builderTemp;
                hashMapClasses.put(className, objectOfObjectsClass);
                builderTemp = new StringBuilder();
        }
    }

    /**
     * Funkcja dodaje do objektu {@link StringBuilder}
     * <code>builderClasses</code> ciąg znaków str.
     *
     * @param str ciąg znaków który zostanie wpisany do objektu
     * {@link StringBuilder} <code>builderClasses</code.
     */
    public void emitClass(String str) {
        // builderClasses.append(str + "\n");
    }

    /**
     * Funkcja sprawdza czy dana zmienna została zalokowana w pamięci.
     *
     * @param name nazwa zmiennej, którą chcemy sprawdzić.
     * @param type typ sprawdzanej deklaracji (<code>ALLOCA</code> * * * * * *
     * lub <code>METHODS</code>).
     * @return <code>true</code>, jeślie zmienna jest zalokowana w pamięci;<br
     * />
     * <code>false</code>, jeśli zmienna nie jest zalokowana w pamięci.
     */
    public boolean checkDeclaration(String valueName, String className, String functionName) {

        if (hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues.containsKey(valueName)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Funkcja sprawdza czy dana zmienna została zalokowana w pamięci.
     *
     * @param name nazwa zmiennej, którą chcemy sprawdzić.
     * @param type typ sprawdzanej deklaracji (<code>ALLOCA</code> * * * * * *
     * lub <code>METHODS</code>).
     * @return <code>true</code>, jeślie zmienna jest zalokowana w pamięci;<br
     * />
     * <code>false</code>, jeśli zmienna nie jest zalokowana w pamięci.
     */
    public boolean checkDeclaration(String className, String functionName) {

        if (hashMapClasses.get(className).hashMapFunction.containsKey(functionName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDeclaration(String valueName, declarationValuesTypes declarationValuesType, String className, String functionName) {

        return hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues.get(valueName).allocaTypesOfValue.contains(declarationValuesType);
    }

    /**
     * Funkcja sprawdza czy dana zmienna została zalokowana w pamięci.
     *
     * @param name nazwa zmiennej, którą chcemy sprawdzić.
     * @param type typ sprawdzanej deklaracji (<code>ALLOCA</code> * * * * * *
     * lub <code>METHODS</code>).
     * @return <code>true</code>, jeślie zmienna jest zalokowana w pamięci;<br
     * />
     * <code>false</code>, jeśli zmienna nie jest zalokowana w pamięci.
     */
    public boolean checkDeclaration(String declareOrDefinitionName, declareOrDefinitonType type) {
        switch (type) {
            case DECLARE:
                if (builderDeclare.indexOf(declareOrDefinitionName) >= 0) {
                    return true;

                } else {
                    return false;
                }

            case DEFINITION:
                if (builderDefinition.indexOf(declareOrDefinitionName) >= 0) {
                    return true;

                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    /**
     * Funkcja sprawdza jakiego typu jest zalokowana w pamięci zmienna.<br />
     * Funkcja ta sprawdza również, czy dana zmienna ma swój odpowiednik double:
     * <code>name.double</code>. Jeśli jest zwraca
     * <code>DOUBLE</code>.
     *
     * @param name nazwa zmiennej, którą chcemy sprawdzić.
     *
     * @return <code>INT</code>, jeślie zmienna jest typu int;<br />
     * <code>DOUBLE</code>, jeślie zmienna jest typu double lub posiada swój
     * odpowiednik <code>name.double</code>.
     */
    public declarationValuesTypes checkActualTypeOfDeclaration(String valueName, String className, String functionName) {
        return hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues.get(valueName).actualTypeOfDeclarationValue;
    }

    public void changeTypeOfDeclarationValues(String valueName, String className, String functionName, declarationValuesTypes type) {
        hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues.get(valueName).actualTypeOfDeclarationValue = type;
    }

    public String getEmit() {
        StringBuilder builderFinish = new StringBuilder();
        builderFinish.append(builderDefinition);
        if (!builderDefinition.toString().equals("")) {
            builderFinish.append("\n");
        }

        Iterator<Map.Entry<String, ObjectOfObjectsClass>> iteratorOfObjectsClass = hashMapClasses.entrySet().iterator();
        ArrayList<ArrayList> arrayListOfArrayListOfFinalStringBuildersOfClass = new ArrayList<ArrayList>();

        while (iteratorOfObjectsClass.hasNext()) {
            Map.Entry<String, ObjectOfObjectsClass> entryOfIteratorOfObjectsClass = iteratorOfObjectsClass.next();
            Iterator<Map.Entry<String, ObjectsOfFunction>> iteratorOfObjectsOfFunction = entryOfIteratorOfObjectsClass.getValue().hashMapFunction.entrySet().iterator();
            ArrayList<StringBuilder> arrayListOfFinalStringBuildersOfClass = new ArrayList<StringBuilder>();

            builderFinish.append(entryOfIteratorOfObjectsClass.getValue().builderClasses);
            if (!entryOfIteratorOfObjectsClass.getValue().builderClasses.toString().equals("")) {
                builderFinish.append("\n");
            }
            while (iteratorOfObjectsOfFunction.hasNext()) {
                StringBuilder builderFunction = new StringBuilder();
                ObjectOfBuildersInFunction objectOfBuildersInFunction = iteratorOfObjectsOfFunction.next().getValue().objectOfBuildersInFunction;

                builderFunction.append(objectOfBuildersInFunction.builderDefine);
                builderFunction.append(objectOfBuildersInFunction.builderAllocaString.append(objectOfBuildersInFunction.builderAllocaAnother));
                builderFunction.append(objectOfBuildersInFunction.builderMain);
                arrayListOfFinalStringBuildersOfClass.add(builderFunction);
            }
            arrayListOfArrayListOfFinalStringBuildersOfClass.add(arrayListOfFinalStringBuildersOfClass);
        }
        while (!arrayListOfArrayListOfFinalStringBuildersOfClass.isEmpty()) {
            while (!arrayListOfArrayListOfFinalStringBuildersOfClass.get(arrayListOfArrayListOfFinalStringBuildersOfClass.size() - 1).isEmpty()) {
                builderFinish.append(arrayListOfArrayListOfFinalStringBuildersOfClass.get(0).get(arrayListOfArrayListOfFinalStringBuildersOfClass.get(0).size() - 1)).append("\n");
                arrayListOfArrayListOfFinalStringBuildersOfClass.get(0).remove(arrayListOfArrayListOfFinalStringBuildersOfClass.get(0).size() - 1);
            }
            arrayListOfArrayListOfFinalStringBuildersOfClass.remove(arrayListOfArrayListOfFinalStringBuildersOfClass.size() - 1);
        }

        builderFinish.append(builderDeclare);

        return builderFinish.toString();
    }
}
