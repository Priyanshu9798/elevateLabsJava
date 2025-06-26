package elevate.task3LibraryManagement;

public class Book {
    private String id;
    private String title;
    private boolean isIssued;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returned() { isIssued = false; }

    @Override
    public String toString() {
        return id + ": " + title + (isIssued ? " [Issued]" : " [Available]");
    }
}

