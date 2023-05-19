import java.util.ArrayList;

public interface BookStoreInterface {
    void displayList();

    void sortOnPrice();

    void addBook(Book book);

    void addBook(ArrayList<Book> list, int id);

    void deleteBook(int id);

    double checkout();
}
