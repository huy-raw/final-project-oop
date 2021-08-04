package authenticate;

public interface IAuthentication {
    public void saveAuthData();
    public boolean registerAccount();
    public boolean loginAccount(boolean isGuest);
}
