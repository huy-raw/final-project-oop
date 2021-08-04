package data;

public enum DocumentType {
    BOOK(1), MAGAZINE(2), NEWSPAPER(3);
    public final int value;
    
    private DocumentType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
