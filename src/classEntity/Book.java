package classEntity;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private boolean status;

    public Book() {
        this.id = 0;
        this.title = "Unknown";
        this.author = "Unknown";
        this.year = 0;
        this.status = false;
    }

    public Book(int id, String title, String author, int year, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = status;
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
        if (status == true) {
            return "Available";
        }
        else {
            return "Borrowed";
        }
    }

    public boolean getStatusBool() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override public String toString(){
        return getId() + " | " + getTitle() + " | " + getAuthor() + " | " + getYear() + " | " + getStatus();
    }
}
