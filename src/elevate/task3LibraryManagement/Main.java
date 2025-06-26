package elevate.task3LibraryManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books
        library.addBook(new Book("B1", "Java Basics"));
        library.addBook(new Book("B2", "OOP Concepts"));
        library.addBook(new Book("B3", "Data Structures"));

        // Adding sample users
        library.addUser(new User("Alice"));
        library.addUser(new User("Bob"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Issue Book\n2. Return Book\n3. View Available Books\n4. View Issued Books\n5. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    library.issueBook(userName, bookId);
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    library.returnBook(userName);
                    break;

                case 3:
                    library.showAvailableBooks();
                    break;

                case 4:
                    library.showIssuedBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
