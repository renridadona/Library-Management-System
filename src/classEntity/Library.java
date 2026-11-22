package classEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    private int nextBookId = 1;
    private int nextLoanTransactionId = 1;
    
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

    public Book findBook(int id) {
        for (Book b : books) if (b.getId() == id) return b;
        return null;
    }

    public User findUser(int id) {
        for (User u : users) if (u.getId() == id) return u;
        return null; 
    }

    public Staff findStaff(int id) {
        User u = findUser(id);
        return (u instanceof Staff s) ? s : null;
    }

    boolean addBooks(Book b) {
        if (findBook(b.getId()) != null) return false;
        books.add(b);
        if (b.getId() >= nextBookId) nextBookId = b.getId() + 1;
        return true;
    }

    boolean addUser(User u) {
        if (findBook(u.getId()) != null) return false;
        users.add(u);
        return true;
    }

    // will add object validation later
    void addLoans(LoanTransaction t) {
        transactions.add(t);
        if (t.getId() >= nextLoanTransactionId) nextLoanTransactionId = t.getId() + 1;
    }

    List<Book> getBooks() { return Collections.unmodifiableList(books); }
    List<User> getUsers() { return Collections.unmodifiableList(users); }
    List<LoanTransaction> getLoans() { return Collections.unmodifiableList(transactions); }

    void load() throws IOException {  }
    void save() throws IOException {  }
}
