import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to MyBookStore!");

        ArrayList<Book> inventory = new ArrayList<Book>();
        inventory.add(new Book("Java Intro", "John Doe", 123, 13.99));
        inventory.add(new Book("Java for beginner", "Jane Doe", 456, 14.99));
        inventory.add(new Book("Advanced Java", "Kevin Doe", 789, 11.99));

        System.out.println("Please choose your identity:"
                + "\n - Press (1) if you are an ADMIN"
                + "\n - Press (2) if you are a CUSTOMER");
        int loginOption = scan.nextInt();

        switch (loginOption) {
            case 1 -> loginAsAdmin(new BookStore(inventory));
            case 2 -> loginAsCustomer(new BookStore(inventory), new BookStore());
            default -> System.out.println("Option is not available.");
        }

    }

    private static void loginAsAdmin(BookStore myStore) {
        System.out.println(" ~ You have logged in as an ADMIN ~ ");
        int option = 0;

        do {
            System.out.println("MENU: "
                    + "\n - Press (1) to display available books in store"
                    + "\n - Press (2) to add one book to inventory"
                    + "\n - Press (3) to delete one book from inventory"
                    + "\n - Press (4) to sort books based on their price"
                    + "\n - Press (5) to exit");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1 -> myStore.displayList();
                case 2 -> {
                    System.out.println("Please enter details of the book you'd like to add:");
                    System.out.print(" - Title: ");
                    String title = scan.nextLine();
                    System.out.print(" - Author: ");
                    String author = scan.nextLine();
                    System.out.print(" - ID: ");
                    int id = scan.nextInt();
                    System.out.print(" - Price: ");
                    double price = scan.nextDouble();
                    myStore.addBook(new Book(title, author, id, price));
                }
                case 3 -> {
                    System.out.println("Please enter ID of the book you'd like to delete:");
                    System.out.print(" - ID: ");
                    int id = scan.nextInt();
                    myStore.deleteBook(id);
                }
                case 4 -> myStore.sortOnPrice();
                case 5 -> System.out.println(" ~ You have logged out ~ ");
                default -> System.out.println("Option is not available.");
            }
        } while (option != 5);
    }

    private static void loginAsCustomer(BookStore bookStore, BookStore myCart) {
        System.out.println(" ~ You have logged in as a CUSTOMER ~ ");
        int option = 0;

        do {
            System.out.println("MENU: "
                    + "\n - Press (1) to display available books in store"
                    + "\n - Press (2) to sort available books based on their price"
                    + "\n - Press (3) to display your shopping cart"
                    + "\n - Press (4) to add one book to your shopping cart"
                    + "\n - Press (5) to delete one book from your shopping cart"
                    + "\n - Press (6) to check total payment"
                    + "\n - Press (7) to exit");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1 -> bookStore.displayList();
                case 2 -> bookStore.sortOnPrice();
                case 3 -> myCart.displayList();
                case 4 -> {
                    System.out.println("Please enter ID of the book you'd like to add:");
                    System.out.print(" - ID: ");
                    int id = scan.nextInt();
                    myCart.addBook(bookStore.getMyList(), id);
                }
                case 5 -> {
                    System.out.println("Please enter ID of the book you'd like to delete:");
                    System.out.print(" - ID: ");
                    int id = scan.nextInt();
                    myCart.deleteBook(id);
                }
                case 6 -> System.out.println("Your total is: $" + myCart.checkout());
                case 7 -> System.out.println(" ~ You have logged out ~ "
                        + "\n ~ Thank you for visiting ~ "
                        + "\n ~ See you again soon ~ ");
                default -> System.out.println("Option is not available.");
            }
        } while (option != 7);
    }

}
//IMPROVE ON:
// handle mismatch input
// handle negative integer input
