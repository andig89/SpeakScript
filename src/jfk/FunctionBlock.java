package jfk;

public class FunctionBlock {
    private StringBuilder builder = new StringBuilder();
    private int registerId = 1;

    public FunctionBlock() {

    }
    
    public int getRegister(String nameVariable){
        char charIndex = builder.charAt(builder.lastIndexOf(nameVariable)-1);
        return Character.getNumericValue(charIndex);
    }
    
    public int nextRegister() {
        return registerId++;
    }

    public void emit(String str) {
        //System.out.println(builder.toString());
        builder.append(str).append("\n");
    }
    
     public void emitEnd(String str) {
        builder.insert(builder.length(),str + "\n");
    }
    
    public void emitStr(String str) {
        builder.insert(0,str + "\n");
    }

    public String getString() {
        return builder.toString();
    }
}
