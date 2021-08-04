package data;

public class Magazine extends Document {

    private String issueNumber;
    private String releaseMonth;

    public Magazine() { }

    public Magazine(String ID, String nameDocument, String publisher, int releaseNumber, String issueNumber, String releaseMonth) {
        super(ID, nameDocument, publisher, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
        this.type = DocumentType.MAGAZINE;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(String releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-20s|%-20s|%10s", ID, nameDocument,
                publisher, releaseNumber);
    }

    @Override
    public String toExportedFileFormat() {
        return "Magazine{" + "ID=" + ID + ", nameDocument=" + nameDocument + ", publisher="
                + publisher + ", releaseNumber=" + releaseNumber + ", type=" + type
                + ", issueNumber=" + issueNumber + ", releaseMonth=" + releaseMonth + '}';
    }

    @Override
    public void displayDetail() {
        System.out.println("ID : " + ID + " | Name : " + nameDocument + " | Issue number : " + issueNumber
                + " | Publisher : " + publisher + " | Release month : " + releaseMonth + " | Release number : " + releaseNumber);
    }
}
