
package data;

public class Book extends Document {

    private String author;
    private int numberOfPages;

    public Book() {
    }

    public Book(String ID, String nameDocument, String publisher, int releaseNumber, String author, int numberOfPages) {
        super(ID, nameDocument, publisher, releaseNumber);
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.type = DocumentType.BOOK;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-20s|%-20s|%10s", ID, nameDocument,
               publisher, releaseNumber);
    }

    public String toExportedFileFormat() {
        return "Book{" + "ID=" + ID + ", nameDocument=" + nameDocument + ", publisher="
                + publisher + ", releaseNumber=" + releaseNumber + ", type=" + type
                + ", author=" + author + ", numberOfPages=" + numberOfPages + '}';
    }

    @Override
    public void displayDetail() {
        System.out.println("ID : " + ID + " | Name : " + nameDocument + " | Author : " + author +
                " | Publisher : " + publisher + " | Page number : " + numberOfPages + " | Release number : " + releaseNumber);
    }
}
