public class Book {

    private String bookName;
    private int bookPages;
    private String authorName;

    public Book() {
    }

    public Book(String bookName, int bookPages, String authorName) {
        this.bookName = bookName;
        this.bookPages = bookPages;
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
