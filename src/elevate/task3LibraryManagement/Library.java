package elevate.task3LibraryManagement;

import java.util.*;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public void issueBook(String userName, String bookId) {
        User user = users.get(userName);
        Book book = books.get(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book.");
            return;
        }

        if (user.hasBook()) {
            System.out.println(userName + " already borrowed a book.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        user.borrowBook(book);
        System.out.println("Book issued to " + userName);
    }

    public void returnBook(String userName) {
        User user = users.get(userName);

        if (user == null || !user.hasBook()) {
            System.out.println("No book to return.");
            return;
        }

        user.returnBook();
        System.out.println(userName + " returned the book.");
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (!book.isIssued()) {
                System.out.println(book);
            }
        }
    }

    public void showIssuedBooks() {
        System.out.println("Issued Books:");
        for (Book book : books.values()) {
            if (book.isIssued()) {
                System.out.println(book);
            }
        }
    }
}

