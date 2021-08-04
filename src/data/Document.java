package data;
import java.io.Serializable;

public abstract class Document implements Serializable {
    protected String ID;
    protected String nameDocument;
    protected String publisher;
    protected int releaseNumber;
    protected DocumentType type;

    public Document() { }

    public Document(String ID, String nameDocument, String publisher, int releaseNumber) {
        this.ID = ID;
        this.nameDocument = nameDocument;
        this.publisher = publisher;
        this.releaseNumber = releaseNumber;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public abstract void displayDetail();
    public abstract String toExportedFileFormat();
}
