package ui;

import authenticate.Authentication;
import data.DocumentManagement;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import utils.Constants;
import utils.FileDatabase;
import utils.Language;
import utils.Utils;

public class App {

    private static Scanner sc;
    private static int userChoice;
    private static DocumentManagement doc;

    public static void main(String[] args) {
        Authentication auth = new Authentication();
        boolean isLoggedIn = false;
        boolean isExit = false;

        boolean shouldExitAuth = false;

        sc = new Scanner(System.in);
        do {
            Utils.printAuthMenu();
            try {
                userChoice = Integer.parseInt(sc.nextLine());
                switch (userChoice) {
                    case 1:
                        isLoggedIn = auth.loginAccount(false);
                        break;
                    case 2:
                        isLoggedIn = auth.registerAccount();
                        break;
                    case 3:
                        isLoggedIn = auth.loginAccount(true);
                        break;
                    case 4:
                        isExit = true;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println(Language.ERROR_WRONG_INPUT_INT);
            }

            shouldExitAuth = !(isLoggedIn || isExit);
        } while (shouldExitAuth);

        auth.saveAuthData(); //should save auth data

        if (isExit) {
            return; //exit if isExit = true
        }
        if (isLoggedIn) {
            System.out.println(Language.INFO_LOGGED_IN);
        }

        final boolean isAdmin = auth.getCurrentLoggedAccount().isAdmin();

        //after logged in, run app menu stack
        boolean shouldExit = true;

        try {
            doc = new DocumentManagement(FileDatabase.readDatabaseInfo(Constants.DB_FILE_PATH));
            System.out.println(Language.MSG_DB_LOADED);
        } catch (IOException ex) {
            System.out.println(Language.MSG_DB_NO_FILE);
            doc = new DocumentManagement();
        } catch (ClassNotFoundException ex) {
            System.out.println(Language.MSG_DB_LOAD_FAILED);
            System.out.println(Language.MSG_ADDITIONAL_INFO + ex.getMessage());
            doc = new DocumentManagement();
        }

        sc = new Scanner(System.in);
        do {
            try {
                shouldExit = appMenu(isAdmin);
            } catch (ParseException ex) {
                System.out.println(Language.ERROR_WRONG_INPUT_INT);
            }
        } while (!shouldExit);

        doc.saveDocumentDatabase();
    }

    public static boolean appMenu(boolean isAdmin) throws ParseException {
        if (isAdmin) {
            Utils.printAdminManageMenu();

            try {
                userChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(Language.ERROR_WRONG_INPUT_INT);
                return false;
            }

            switch (userChoice) {
                case 1:
                    doc.createDocument();
                    break;
                case 2:
                    doc.display();
                    break;
                case 3:
                    doc.deleteDocument();
                    break;
                case 4:
                    doc.updateDocument();
                    break;
                case 5:
                    doc.listDocumentByID();
                    break;
                case 6:
                    doc.listDocumentByName();
                    break;
                case 7:
                    doc.listDocumentByPublisher();
                    break;
                case 8:
                    doc.listDocumentByType();
                    break;
                case 9:
                    doc.sortThenList();
                    break;
                case 10:
                    doc.exportToFile();
                    break;
                case 11:
                    return true;
            }
        } else {
            Utils.printGuestManageMenu();

            try {
                userChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(Language.ERROR_WRONG_INPUT_INT);
                return false;
            }

            switch (userChoice) {
                case 1:
                    doc.display();
                    break;
                case 2:
                    doc.listDocumentByID();
                    break;
                case 3:
                    doc.listDocumentByName();
                    break;
                case 4:
                    doc.listDocumentByPublisher();
                    break;
                case 5:
                    doc.listDocumentByType();
                    break;
                case 6:
                    doc.sortThenList();
                    break;
                case 7:
                    doc.exportToFile();
                    break;
                case 8:
                    return true;
            }
        }
        return false;
    }
}
