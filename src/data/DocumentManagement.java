package data;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import utils.Constants;
import utils.FileDatabase;
import utils.Utils;
import utils.Language;

public class DocumentManagement {

    private LinkedList<Document> documentList = new LinkedList();

    public DocumentManagement() {
    }

    public DocumentManagement(LinkedList<Document> documentList) {
        this.documentList = documentList;
    }

    public void createDocument() throws ParseException {
        String _id, _nameDocument, _author, _publisher, _publicDate, _issueNumber, _releaseMonth;
        int _type, _numberOfPages, _releaseNumber;
        int pos; //vị trí ID

        _type = Utils.getAnInteger(Language.MSG_INPUT_TYPE, Language.ERROR_WRONG_INPUT_INT, 0, 4);

        do {
            _id = Utils.getID(Language.MSG_INPUT_ID, Language.ERROR_WRONG_INPUT_ID, Constants.REGEX_DOC_ID);
            pos = checkIDAvailable(_id);
            if (pos > 0) {
                System.out.println(Language.ERROR_DUPLICATE_ID);
            }
        } while (pos != -1);
        _nameDocument = Utils.getString(Language.MSG_INPUT_NAME, Language.ERROR_WRONG_INPUT_STR);
        _publisher = Utils.getString(Language.MSG_INPUT_PUBLISHER, Language.ERROR_WRONG_INPUT_STR);
        _releaseNumber = Utils.getAnInteger(Language.MSG_INPUT_PUBLISH_NUMBER, Language.ERROR_WRONG_INPUT_INT);

        switch (_type) {
            case 1: //sach
                _author = Utils.getString(Language.MSG_INPUT_AUTHOR, Language.ERROR_WRONG_INPUT_STR);
                _numberOfPages = Utils.getAnInteger(Language.MSG_INPUT_PAGE_NUMBER, Language.ERROR_WRONG_INPUT_INT);

                Book b = new Book(_id, _nameDocument, _publisher, _releaseNumber, _author, _numberOfPages);
                documentList.add(b);

                System.out.println(Language.MSG_ADD_SUCCESSFULLY_INFO + b.toExportedFileFormat());
                break;

            case 2: //tap chi 
                _issueNumber = Utils.getString(Language.MSG_INPUT_ISSUE_NUMBER, Language.ERROR_WRONG_INPUT_STR);
                _releaseMonth = Utils.getString(Language.MSG_INPUT_RELEASE_MONTH, Language.ERROR_WRONG_INPUT_STR);

                Magazine m = new Magazine(_id, _nameDocument, _publisher, _releaseNumber, _issueNumber, _releaseMonth);
                documentList.add(m);

                System.out.println(Language.MSG_ADD_SUCCESSFULLY_INFO + m.toExportedFileFormat());
                break;
            case 3: //bao
                _publicDate = Utils.getString(Language.MSG_INPUT_PUBLIC_DATE, Language.ERROR_WRONG_INPUT_STR);

                Newspaper n = new Newspaper(_id, _nameDocument, _publisher, _releaseNumber, _publicDate);
                documentList.add(n);

                System.out.println(Language.MSG_ADD_SUCCESSFULLY_INFO + n.toExportedFileFormat());
                break;
        }
        System.out.println(Language.MSG_ADD_SUCCESSFULLY);
    }

    public void deleteDocument() {
        String id;

        id = Utils.getID(Language.MSG_INPUT_DOC_ID_TO_DELETE, Language.ERROR_WRONG_INPUT_ID, Constants.REGEX_DOC_ID);
        System.out.println(Constants.UI_DIV);
        if (delete(id)) {
            System.out.println(Language.MSG_DELETE_DOC_SUCCESSFULLY);
        } else {
            System.out.println(Language.ERROR_DOC_NOT_FOUND);
        }
    }

    private boolean delete(String id) {
        return documentList.removeIf(doc -> {
            boolean isMatch = doc.getID().equalsIgnoreCase(id);
            return isMatch;
        });
    }

    public void updateDocument() throws ParseException {
        String _id;

        _id = Utils.getID(Language.MSG_INPUT_DOC_ID_TO_UPDATE, Language.ERROR_WRONG_INPUT_ID, Constants.REGEX_DOC_ID);

        for (Document doc : documentList) {
            if (doc.getID().equalsIgnoreCase(_id)) {
                switch (doc.getType()) {
                    case BOOK: {
                        Book temp = (Book) doc;
                        if (!doc.getID().isEmpty()) {
                            //update nameDocument
                            
                            String strName = Utils.getString(Language.MSG_INPUT_NAME, Language.ERROR_WRONG_INPUT_STR);
                            if (!strName.isEmpty()) {
                                temp.setNameDocument(strName);
                            }
                            //update publisher

                            String strPublisher = Utils.getString(Language.MSG_INPUT_PUBLISHER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strPublisher.isEmpty()) {
                                temp.setPublisher(strPublisher);
                            }
                            //update releaseNumber

                            String strReleaseNumber = Utils.getString(Language.MSG_INPUT_PUBLISH_NUMBER, Language.ERROR_WRONG_INPUT_INT);
                            if (!strReleaseNumber.isEmpty()) {
                                int realeaseNumber = Integer.parseInt(strReleaseNumber);
                                temp.setReleaseNumber(realeaseNumber);
                            }
                            //update author

                            String strAuthor = Utils.getString(Language.MSG_INPUT_AUTHOR, Language.ERROR_WRONG_INPUT_STR);
                            if (!strAuthor.isEmpty()) {
                                temp.setAuthor(strAuthor);
                            }
                            //update numberOfPages

                            String strNOPage = Utils.getString(Language.MSG_INPUT_PAGE_NUMBER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strNOPage.isEmpty()) {
                                int numberOfPages = Integer.parseInt(strNOPage);
                                temp.setNumberOfPages(numberOfPages);
                            }

                            if (delete(_id)) {
                                documentList.add(temp);
                                System.out.println(Language.MSG_UPDATE_DOC_SUCCESSFULLY);
                            } else {
                                System.out.println(Language.MSG_UPDATE_DOC_FAILED);
                            };
                        }
                        break;
                    }
                    case MAGAZINE: {
                        Magazine temp = (Magazine) doc;
                        if (!doc.getID().isEmpty()) {
                            //update nameDocument

                            String strName = Utils.getString(Language.MSG_INPUT_NAME, Language.ERROR_WRONG_INPUT_STR);
                            if (!strName.isEmpty()) {
                                temp.setNameDocument(strName);
                            }
                            //update publisher

                            String strPublisher = Utils.getString(Language.MSG_INPUT_PUBLISHER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strPublisher.isEmpty()) {
                                temp.setPublisher(strPublisher);
                            }
                            //update realeaseNumber

                            String strReleaseNumber = Utils.getString(Language.MSG_INPUT_PUBLISH_NUMBER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strReleaseNumber.isEmpty()) {
                                int realeaseNumber = Integer.parseInt(strReleaseNumber);
                                temp.setReleaseNumber(realeaseNumber);
                            }

                            //update issueNumber
                            String strIssueNumber = Utils.getString(Language.MSG_INPUT_ISSUE_NUMBER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strIssueNumber.isEmpty()) {
                                temp.setIssueNumber(strIssueNumber);
                            }
                            //update realeaseMonth 

                            String strRealeaseMonth = Utils.getString(Language.MSG_INPUT_RELEASE_MONTH, Language.ERROR_WRONG_INPUT_STR);
                            if (!strRealeaseMonth.isEmpty()) {
                                temp.setReleaseMonth(strRealeaseMonth);
                            }

                            if (delete(_id)) {
                                documentList.add(temp);
                                System.out.println(Language.MSG_UPDATE_DOC_SUCCESSFULLY);
                            } else {
                                System.out.println(Language.MSG_UPDATE_DOC_FAILED);
                            };
                        }
                        break;
                    }
                    case NEWSPAPER: {
                        Newspaper temp = (Newspaper) doc;

                        if (!doc.getID().isEmpty()) {
                            //update nameDocument
                            String strName = Utils.getString(Language.MSG_INPUT_NAME, Language.ERROR_WRONG_INPUT_STR);
                            if (!strName.isEmpty()) {
                                temp.setNameDocument(strName);
                            }
                            //update publisher
                            String strPublisher = Utils.getString(Language.MSG_INPUT_PUBLISHER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strPublisher.isEmpty()) {
                                temp.setPublisher(strPublisher);
                            }
                            //update realeaseNumber
                            String strReleaseNumber = Utils.getString(Language.MSG_INPUT_PUBLISH_NUMBER, Language.ERROR_WRONG_INPUT_STR);
                            if (!strReleaseNumber.isEmpty()) {
                                int realeaseNumber = Integer.parseInt(strReleaseNumber);
                                temp.setReleaseNumber(realeaseNumber);
                            }
                            //update dateReleasePerson
                            String strPublicDate = Utils.getString(Language.MSG_INPUT_PUBLIC_DATE, Language.ERROR_WRONG_INPUT_STR);
                            if (!strPublicDate.isEmpty()) {
                                DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
                                Date publicDate = dateFormat.parse(strPublicDate);
                                temp.setPublicDate(publicDate);
                            }

                            if (delete(_id)) {
                                documentList.add(temp);
                                System.out.println(Language.MSG_UPDATE_DOC_SUCCESSFULLY);
                            } else {
                                System.out.println(Language.MSG_UPDATE_DOC_FAILED);
                            };
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
        }

    }

    public void display() {
        for (Document document : documentList) {
            System.out.println(String.format("|%-15s|%-20s|%-20s|%10s", " ID ", " NAME ", " PUBLISHER ", " RELEASE NUMBER "));
            System.out.println(document.toString());
        }
    }

    //xác định khi nhập ID nếu trùng báo lỗi
    private int checkIDAvailable(String ID) {
        if (documentList == null) {
            return -1;
        } else {
            for (Document document : documentList) {
                if (document.getID().equalsIgnoreCase(ID)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public void exportToFile() {
        String fileName = Utils.getString(Language.MSG_INPUT_FILE_NAME, Language.ERROR_WRONG_INPUT_STR);
        try {
            FileDatabase.exportToFile(fileName, documentList);
            System.out.println(Language.MSG_DATA_EXPORTED);
        } catch (IOException ex) {
            System.out.println(Language.MSG_DATA_EXPORT_FAILED + ex.toString());
        }
    }

    public void listDocumentByID() {
        String id = Utils.getID(Language.MSG_INPUT_ID, Language.ERROR_WRONG_INPUT_ID, Constants.REGEX_DOC_ID);
        for (Document document : documentList) {
            if (document.getID().equalsIgnoreCase(id)) {
                document.displayDetail();
            }
        }
    }

    public void listDocumentByName() {
        String strName = Utils.getString(Language.MSG_INPUT_NAME, Language.ERROR_WRONG_INPUT_STR);
        for (Document document : documentList) {
            if (document.getNameDocument().equalsIgnoreCase(strName)) {
                document.displayDetail();
            }
        }
    }

    public void listDocumentByPublisher() {
        String strPublisher = Utils.getString(Language.MSG_INPUT_PUBLISHER, Language.ERROR_WRONG_INPUT_STR);
        for (Document document : documentList) {
            if (document.getPublisher().equalsIgnoreCase(strPublisher)) {
                document.displayDetail();
            }
        }
    }

    public void listDocumentByType() {
        int type = Utils.getAnInteger(Language.MSG_INPUT_TYPE, Language.ERROR_WRONG_INPUT_INT, 0, 4);
        for (Document document : documentList) {
            if (document.getType().getValue() == type) {
                document.displayDetail();
            }
        }
    }

    public void saveDocumentDatabase() {
        try {
            FileDatabase.writeDatabaseInfo(Constants.DB_FILE_PATH, documentList);
        } catch (IOException ex) {
            System.out.println(Language.MSG_AUTH_SAVE_FAILED);
            System.out.println(Language.MSG_ADDITIONAL_INFO + ex.toString());
        }
    }

    public void sortThenList() {
        int type = Utils.getAnInteger(Language.MSG_INPUT_SORT_FIELD, Language.ERROR_WRONG_INPUT_INT, 0, 4);
        switch (type) {
            case 1:
                sortByID();
                break;
            case 2:
                sortByPublisher();
                break;
            case 3:
                sortByReleaseNumber();
                break;
        }
    }

    private void printAfterSort() {
        System.out.println(Language.MSG_DATA_AFTER_SORT);
        display();
    }

    private void sortByID() {
        Collections.sort(documentList, new Comparison.sortByID());
        printAfterSort();
    }

    private void sortByPublisher() {
        Collections.sort(documentList, new Comparison.sortByID());
        printAfterSort();
    }

    private void sortByReleaseNumber() {
        Collections.sort(documentList, new Comparison.sortByID());
        printAfterSort();
    }
}
