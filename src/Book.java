import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int id;
    private double price;

    public Book(String title, String author, int id, double price) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", price=$" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Double.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, id, price);
    }

    // sort based on title
//    @Override
//    public int compareTo(Book o) {
//        return this.getTitle().compareToIgnoreCase(o.getTitle());
//    }

    // sort based on author
//    @Override
//    public int compareTo(Book o) {
//        return this.getAuthor().compareToIgnoreCase(o.getAuthor());
//    }

    // sort based on id
//    @Override
//    public int compareTo(Book o) {
//        return this.getId() - o.getId();
//    }

    // sort based on price
    @Override
    public int compareTo(Book o) {
        return Double.compare(price, o.price);
    }
}
