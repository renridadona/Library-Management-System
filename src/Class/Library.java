package Class;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int id;
    private String name;
    private String location;
    private String contactNumber;
    private int capacity;
    private int yearEst;
    private final List<Book> books = new ArrayList<>();
    private final List<LoanTransaction> transactions = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    
    public Library() {
        this.id = 0;
        this.name = "Unknown";
        this.location = "Unknown";
        this.contactNumber = "N/A";
        this.capacity = 0;
        this.yearEst = 0;
    }
    
    public Library(int id, String name, String location, String contactNumber, int capacity, int yearEst) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
        this.capacity = capacity;
        this.yearEst = yearEst;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getYearEst() {
        return yearEst;
    }

    public void setYearEst(int yearEst) {
        this.yearEst = yearEst;
    }
}
