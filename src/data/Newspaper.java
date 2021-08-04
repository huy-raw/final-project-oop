
package data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Document {

    private Date publicDate;

    public Newspaper() {
    }

    public Newspaper(String ID, String nameDocument, String publisher, int releaseNumber, String publicDate) throws ParseException {
        super(ID, nameDocument, publisher, releaseNumber);
        this.publicDate = new SimpleDateFormat("dd/MM/yyyy").parse(publicDate);
        this.type = DocumentType.NEWSPAPER;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-20s|%-20s|%10s", ID, nameDocument,
                publisher, releaseNumber);
    }

    @Override
    public String toExportedFileFormat() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Newspaper{" + "ID=" + ID + ", nameDocument=" + nameDocument + ", publisher="
                + publisher + ", releaseNumber=" + releaseNumber + ", type=" + type
                + ", releaseNumber=" + releaseNumber + ", PublicDate=" + dateFormat.format(publicDate) + '}';
    }

    @Override
    public void displayDetail() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID : " + ID + " | Name : " + nameDocument + " | Publisher : " + publisher
                + " | Release number : " + releaseNumber + " | Public date : " + dateFormat.format(publicDate));
    }
}
