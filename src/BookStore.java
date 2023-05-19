import java.util.ArrayList;
import java.util.Comparator;

public class BookStore implements BookStoreInterface {
    private ArrayList<Book> myList;

    public BookStore() {
        this.myList = new ArrayList<Book>();
    }

    public BookStore(ArrayList<Book> list) {
        this.myList = list;
    }

    public ArrayList<Book> getMyList() {
        return myList;
    }

    @Override
    public void displayList() {
        System.out.println("List consists of " + myList.size() + " book");
        myList.forEach(System.out::println);
    }

    @Override
    public void sortOnPrice() {
        myList.sort(Comparator.naturalOrder()); // in ascending order
//        myList.sort(Comparator.reverseOrder()); // in descending order
        myList.forEach(System.out::println);
    }

    @Override
    public void addBook(Book myBook) {
//        VERSION 1: (OLD)
//        boolean duplicateID = false;
//        for (Book book : myList) {
//            if (book.getId() == myBook.getId()) {
//                System.out.println("Book ID already exists.");
//                duplicateID = true;
//            }
//        }
//        if (!duplicateID) {
//            myList.add(myBook);
//            System.out.println("You have added " + myBook);
//        }

//        VERSION 2: (IMPROVED)
        if (myList.contains(myBook)) {
            System.out.println("Book already exists.");
        } else {
            myList.add(myBook);
            System.out.println("You have added " + myBook);
        }
    } // for bookstore admin to add inventory

    @Override
    public void addBook(ArrayList<Book> inventoryList, int id) {
//        VERSION 1: (OLD)
//        boolean duplicateID = false;
//        for (Book book : myList) {
//            if (book.getId() == id) {
//                System.out.println("Book ID already exists.");
//                duplicateID = true;
//            }
//        }
//        if (!duplicateID) {
//            boolean bookFound = false;
//            for (Book book : inventoryList) {
//                if (book.getId() == id) {
//                    myList.add(book);
//                    System.out.println("You have added " + book);
//                    bookFound = true;
//                    break;
//                }
//            }
//            if (!bookFound) {
//                System.out.println("Book #" + id + " can't be found.");
//            }
//        }

//        VERSION 2: (IMPROVED)
        boolean bookFound = false;
        for (Book book : inventoryList) {
            if (book.getId() == id) {
                if (myList.contains(book)) {
                    System.out.println("Book already exists.");
                } else {
                    myList.add(book);
                    System.out.println("You have added " + book);
                }
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book #" + id + " can't be found.");
        }
    } // for customer to add book to cart

    @Override
    public void deleteBook(int id) {
        if (myList.isEmpty()) {
            System.out.println("Your list is empty.");
        } else {
            Book myBook = new Book("", "", 0, 0);
            boolean bookFound = false;
            for (Book book : myList) {
                if (book.getId() == id) {
                    myBook = book;
                    bookFound = true;
                }
            }
            if (bookFound) {
                myList.remove(myBook);
                System.out.println("You have deleted " + myBook);
            } else {
                System.out.println("Book #" + id + " can't be found.");
            }
        }
    }

    @Override
    public double checkout() {
        double total = 0;
        for (Book book : myList) {
            total += book.getPrice();
        }
        return total;
    }
}
