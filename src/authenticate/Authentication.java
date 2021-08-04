package authenticate;

import java.io.IOException;
import java.util.ArrayList;
import utils.Constants;
import utils.FileDatabase;
import utils.Language;
import utils.Utils;

public class Authentication implements IAuthentication {
    private Account currentLoggedAccount;
    public Account getCurrentLoggedAccount() {
        return currentLoggedAccount;
    }

    private ArrayList<Account> accountList;

    public Authentication() {
        try {
            accountList = FileDatabase.readAuthInfo(Constants.AUTH_FILE_PATH); //load auth data first
            System.out.println(Language.MSG_AUTH_LOADED);
        } catch (IOException ex) {
            System.out.println(Language.MSG_AUTH_NO_FILE);
            accountList = new ArrayList();
        } catch (ClassNotFoundException ex) {
            System.out.println(Language.MSG_AUTH_LOAD_FAILED);
            System.out.println(Language.MSG_ADDITIONAL_INFO + ex.getMessage());

            accountList = new ArrayList();
        }
    }

    @Override
    public void saveAuthData() {
        try {
            FileDatabase.writeAuthInfo(Constants.AUTH_FILE_PATH, accountList);
        } catch (IOException ex) {
            System.out.println(Language.MSG_AUTH_SAVE_FAILED);
            System.out.println(Language.MSG_ADDITIONAL_INFO + ex.toString());
        }
    }

    @Override
    public boolean registerAccount() {
        System.out.println(Language.MSG_REG_PROCESS);

        String _username, _password;
        _username = Utils.getString(Language.INPUT_USERNAME, Language.ERROR_WRONG_INPUT_STR);
        _password = Utils.getString(Language.INPUT_PASSWORD, Language.ERROR_WRONG_INPUT_STR);
        String hashedPwd = Utils.hashPassword(_password);

        Account newAccount = new Account(AccountType.ADMIN, _username, hashedPwd);
        accountList.add(newAccount);

        currentLoggedAccount = newAccount;
        return true;
    }

    @Override
    public boolean loginAccount(boolean isGuest) {
        if (accountList.size() <= 0) {
            System.out.println(Language.NO_ACCOUNTS);
            return false;
        } 
        if (isGuest) {
            System.out.println(Language.INFO_LOGGED_GUEST);

            Account guestAccount = new Account(AccountType.GUEST, "", "");
            currentLoggedAccount = guestAccount;
            return true;
        } else {
            System.out.println(Language.MSG_LOGIN_PROCESS);

            String _username, _password;
            _username = Utils.getString(Language.INPUT_USERNAME, Language.ERROR_WRONG_INPUT_STR);
            _password = Utils.getString(Language.INPUT_PASSWORD, Language.ERROR_WRONG_INPUT_STR);
            String hashedPwd = Utils.hashPassword(_password);

            for (Account acc : accountList) {
                if (acc.getUsername().equals(_username) && acc.getPassword().equals(hashedPwd)) {
                    currentLoggedAccount = acc;
                    return true;
                }
            }

            System.out.println(Language.WARN_WRONG_CREDENTIAL);
            return false;
        }
    }
}
