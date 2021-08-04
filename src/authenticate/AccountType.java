package authenticate;

public enum AccountType {
    GUEST(1), ADMIN(2);
    public final int value;
    
    private AccountType(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}
