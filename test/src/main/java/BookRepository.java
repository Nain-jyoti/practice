import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {
    HashMap<String, Book> bookdb = new HashMap<>();
    HashMap<String, List<Book>> authordb = new HashMap<String, List<Book>>();

    public boolean addBook(Book book){
        String bookName = book.getBookName();
        if(!bookdb.containsKey(bookName)){
            bookdb.put(bookName, book);
            return true;
        }
        return false;
    }

    public boolean addAuthor(Author author){
        String authorName = author.getAuthorName();
        if(!authordb.containsKey(authorName)){
            List<Book> list = new ArrayList<>();
            authordb.put(authorName, list);
            return  true;
        }
        return false;
    }

    public boolean addAuthorToBook() {
        for (String key : bookdb.keySet()) {
            Book book = bookdb.get(key);
            String authorName = book.getAuthorName();
            List<Book> bookList = authordb.get(authorName);
            bookList.add(book);
            authordb.put(authorName, bookList);

        }
        return true;
    }

    public String updatePages(int page, Book book) {
        String bookName = book.getBookName();
        Book book1 = bookdb.get(bookName);
        book1.setBookPages(page);
        bookdb.put(bookName, book1);
        return "Done";
    }

    public Book getBook() {
        List<Book> bookList = new ArrayList<>();
        for (String key : bookdb.keySet()) {
            bookList.add(bookdb.get(key));
        }
        Collections.sort(bookList, (a, b)->{
            return b.getBookPages() - a.getBookPages();
        });
        return bookList.get(0);
    }

    public String getAuthor() {
        String author = null;
        int maxSize = 0;
        for (String key : authordb.keySet()) {
            if (authordb.get(key).size() > maxSize) {
                author = key;
                maxSize = authordb.get(key).size();
            }
        }
        return author;
    }
}
