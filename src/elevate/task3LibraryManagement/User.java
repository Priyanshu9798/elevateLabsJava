package elevate.task3LibraryManagement;

public class User {
    private String name;
    private Book borrowedBook;

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public boolean hasBook() {
        return borrowedBook != null;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void borrowBook(Book book) {
        this.borrowedBook = book;
        book.issue();
    }

    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returned();
            borrowedBook = null;
        }
    }
}

