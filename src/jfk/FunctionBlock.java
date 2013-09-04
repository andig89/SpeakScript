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
        StringBuilder builderAllocaString = new StringBuilder();
        StringBuilder builderAllocaAnother = new StringBuilder();

        public ObjectOfBuildersInFunction() {
        }

        public ObjectOfBuildersInFunction(StringBuilder builderMain, StringBuilder builderAlloca) {
            this.builderMain = builderMain;
            this.builderAllocaString = builderAlloca;
            this.builderAllocaAnother = builderAlloca;
        }
    }

    private class ObjectsOfAllocaValue {

        typesOfDeclarationValues actualTypeOfDeclarationValue;
        ArrayList<typesOfDeclarationValues> allocaTypesOfValue = new ArrayList<typesOfDeclarationValues>();

        public ObjectsOfAllocaValue() {
        }

        public ObjectsOfAllocaValue(typesOfDeclarationValues actualTypeOfDeclarationValue) {
            this.actualTypeOfDeclarationValue = actualTypeOfDeclarationValue;
            allocaTypesOfValue.add(actualTypeOfDeclarationValue);
        }
    }

    private class ObjectsOfFunction {

        ObjectOfBuildersInFunction objectOfBuildersInFunction = new ObjectOfBuildersInFunction();
        HashMap<String, ObjectsOfAllocaValue> hashMapFunctionValues = new HashMap<String, ObjectsOfAllocaValue>();

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
    private int registerId = 1;
    String nameOfAllocaValue;

    /**
     * Enum zaiwerający obsługiwane typy deklaracji.
     *
     * @param ALLOCA alokacja zmiennej w pamięci.
     * @param METHODS funkcja zapisana w LLVM.
     * @param DECLARE deklaracja zapisana w LLVM.
     */
    enum typeDeclareOrDefiniton {

        DECLARE, DEFINITION;
    };

    enum typesOfDeclarationValues {

        INT, DOUBLE, STRING, UNKNOWN
    };

    /**
     * Enum zaiwerający obsługiwane typy deklaracji.
     *
     * @param EMIT oznacza odwołanie do * * * * * * * * * *
     * {@link StringBuilder} <code>builder</code>, który zawiera polecania LLVM
     * dotycząc programu main LLVM
     * @param EMITSTART oznacza odwołanie do * * * * * * * *
     * {@link StringBuilder} <code>builderStart</code>, w którym zdefiniowane są
     * zmienne cofinguracyjne LLVM.
     * @param EMITEND oznacza odwołanie do * * * * * * * * *
     * {@link StringBuilder} <code>builderEnd</code>, który zawiera polecania
     * LLVM dotycząc klas i metod.
     */
    enum typesOfEmitDeclareOrDefinition {

        EMITDEFINITON, EMITDECLARE
    };

    enum typesOfEmitClassAndFunction {

        FUNCTIONSOFCLASS, ADDNEWALLOCA, CLASS
    };

    enum typesOfCheckTypeOfDeclaration {

        ACTUAL, ALL
    };

    private static <T, E> T getKeyByValueFromHashMap(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entryOfIteratorOfObjectsClass : map.entrySet()) {
            if (value.equals(entryOfIteratorOfObjectsClass.getValue())) {
                return entryOfIteratorOfObjectsClass.getKey();
            }
        }
        return null;
    }

    /**
     * Metoda zmienia główny rejest ID LLVM o +1. .
     *
     * @return <code>int registerId</code>
     */
    public int nextRegister() {
        return registerId++;
    }

    public int register() {
        return registerId;
    }

    /**
     * Metoda dodaje tekst do
     * <code>StringBuilder builder</code>, który jest zbiorem poleceń programu
     * głównego LLVM.
     *
     * @param str ciąg znaków który chcemy dodać.
     * @param type jeden z typów
     * {@link jfk.FunctionBlock.typesOfStringBuilders}, tj. <code>EMIT</code>
     * lub <code>EMITSTART</code> lub <code>EMITEND</code>.
     * @return
     */
    public String emitDeclareOrDefinition(String str, typesOfEmitDeclareOrDefinition type) {
        switch (type) {
            case EMITDEFINITON:
                if (!hashMapDefinition.containsValue(str)) {
                    hashMapDefinition.put(".str" + (hashMapDefinition.size() + 1), str);
                    builderDefinition.append(str).append("\n");
                    return ".str" + hashMapDefinition.size();
                } else {
                    return getKeyByValueFromHashMap(hashMapDefinition, str);
                }
            case EMITDECLARE:
                if (!declaresArrayList.contains(str.substring(str.indexOf("@") + 1, str.indexOf("(")))) {
                    declaresArrayList.add(str.substring(str.indexOf("@") + 1, str.indexOf("(")));
                    builderDeclare.append(str).append("\n");
                }
                return null;
            default:
                return "False";
        }
    }

    /**
     * Metoda dodaje tekst do
     * <code>StringBuilder builder</code>, który jest zbiorem poleceń programu
     * głównego LLVM.
     *
     * @param str - ciąg znaków który chcemy dodać.
     */
    public void emitTemp(String str) {
        builderTemp.append(str).append("\n");
    }

    public void emitTemp(String str, String valueName, typesOfDeclarationValues typeDeclaration) {
        objectOfAllocaValue = new ObjectsOfAllocaValue(typeDeclaration);
        nameOfAllocaValue = valueName;
        builderTemp.append(str).append("\n");
    }

    public void emit(String className, String functionName, typesOfEmitClassAndFunction type) {
        switch (type) {
            case FUNCTIONSOFCLASS:
                if (!hashMapClasses.get(className).hashMapFunction.containsKey(functionName)) {
                    ObjectsOfFunction objectsOfFunction = new ObjectsOfFunction();
                    objectsOfFunction.objectOfBuildersInFunction.builderMain = builderTemp;
                    hashMapClasses.get(className).hashMapFunction.put(functionName, objectsOfFunction);

                } else {
                    hashMapClasses.get(className).hashMapFunction.get(functionName).objectOfBuildersInFunction.builderMain.append(builderTemp);
                }
                builderTemp = new StringBuilder();
                break;
            case ADDNEWALLOCA:
                try {
                    HashMap<String, ObjectsOfAllocaValue> hashMapFunctionValues = hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues;
                    if (!hashMapFunctionValues.containsKey(nameOfAllocaValue)) {
                        ObjectsOfFunction objectsOfFunction = hashMapClasses.get(className).hashMapFunction.get(functionName);

                        if (objectOfAllocaValue.actualTypeOfDeclarationValue.equals(typesOfDeclarationValues.STRING)) {
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
                            if (objectOfAllocaValue.actualTypeOfDeclarationValue.equals(typesOfDeclarationValues.STRING)) {
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
     * Metoda dodaje do objektu {@link StringBuilder}
     * <code>builderClasses</code> ciąg znaków str.
     *
     * @param str ciąg znaków który zostanie wpisany do objektu
     * {@link StringBuilder} <code>builderClasses</code.
     */
    public void emitClass(String str) {
        // builderClasses.append(str + "\n");
    }

    /**
     * Metoda sprawdza czy dana zmienna została zalokowana w pamięci.
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

    public boolean checkDeclaration(String className, String functionName) {

        if (hashMapClasses.get(className).hashMapFunction.containsKey(functionName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDeclaration(String valueName, typesOfDeclarationValues typesOfDeclarationValues, String className, String functionName) {

        return hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues.get(valueName).allocaTypesOfValue.contains(typesOfDeclarationValues);
    }

    public boolean checkDeclaration(String declareOrDefinitionName, typeDeclareOrDefiniton type) {
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
     * Metoda sprawdza jakiego typu jest zalokowana w pamięci zmienna.<br />
     * Metoda ta sprawdza również, czy dana zmienna ma swój odpowiednik double:
     * <code>name.double</code>. Jeśli jest zwraca
     * <code>DOUBLE</code>.
     *
     * @param name nazwa zmiennej, którą chcemy sprawdzić.
     *
     * @return <code>INT</code>, jeślie zmienna jest typu int;<br />
     * <code>DOUBLE</code>, jeślie zmienna jest typu double lub posiada swój
     * odpowiednik <code>name.double</code>.
     */
    public typesOfDeclarationValues checkActualTypeOfDeclaration(String valueName, String className, String functionName) {
        return hashMapClasses.get(className).hashMapFunction.get(functionName).hashMapFunctionValues.get(valueName).actualTypeOfDeclarationValue;
    }

    public void changeTypeOfDeclarationValues(String valueName, String className, String functionName, typesOfDeclarationValues type) {
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

                builderFunction.append(objectOfBuildersInFunction.builderMain);

                builderFunction.insert(builderFunction.indexOf("{") + 2, (objectOfBuildersInFunction.builderAllocaString.append(objectOfBuildersInFunction.builderAllocaAnother)));
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
