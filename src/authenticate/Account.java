package authenticate;
import java.io.Serializable;

public class Account implements IAccount, Serializable {
    private AccountType type;
    private String username;
    private String password;

    public Account(AccountType type, String username, String password) {
        this.type = type;
        this.username = username;
        this.password = password;
    }
    
    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAdmin() {
        return type == AccountType.ADMIN;
    }

    @Override
    public boolean isGuest() {
        return type == AccountType.GUEST;
    }
}
