package Class;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String status;
    private static int autoId = 1;

    public Book() {
        this.id = 0;
        this.title = "Unknown";
        this.author = "Unknown";
        this.year = 0;
        this.status = "Not set";
    }

    public Book(String title, String author, int year) {
        this.id = autoId++;
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = "Available";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
