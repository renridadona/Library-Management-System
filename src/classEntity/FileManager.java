package classEntity;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class FileManager {
    private static final Path STORAGE = Path.of("storage");
    private static final Path BOOKS_FILE = STORAGE.resolve("books.txt");
    private static final Path USERS_FILE = STORAGE.resolve("users.txt");
    private static final Path LOANS_FILE = STORAGE.resolve("loans.txt");

    public static void save(Library lib) throws IOException {
        Files.createDirectories(STORAGE);
        // Save list to books.txt
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(BOOKS_FILE))) {
            for (Book b : lib.getBooks()) 
                out.println(b.getId() + "|" + 
                            b.getTitle() + "|" + 
                            b.getAuthor() + "|" + 
                            b.getYear() + "|" + 
                            b.getStatus());
        }
        // Save list to users.txt - contains both Students and Staff
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(USERS_FILE))) {
            for (User u : lib.getUsers())
                // This is different because it inherits Students and Staff 
                // Since they both have different properties, I find it easier to create a method to call the properties as a List<String>
                // Then join them here
                out.println(String.join("|", u.toFields()));
        }
        // Save list to loans.txt - all loanTransactions will live here
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(LOANS_FILE))) {
            for (LoanTransaction t : lib.getLoans()){
                String returned = t.isReturned() ? t.getDateReturned().toString() : "";
                out.println(t.getId() + "|" +
                            t.getBookLoan().getId() + "|" + 
                            t.getBorrower().getId() + "|" + 
                            t.getAssignedLender().getId() + "|" + 
                            t.getDateLoaned() + "|" + 
                            t.getDateDue() + "|" + 
                            returned);
            }
        }
    }

    public static void load(Library lib) throws IOException {
        // Load Books
        if (Files.exists(BOOKS_FILE)) {
            for (String line : Files.readAllLines(BOOKS_FILE)) {
                try {
                    String[] p = line.split("\\|");
                    int id = Integer.parseInt(p[0]);
                    String title = p[1];
                    String author = p[2];
                    int year = Integer.parseInt(p[3]);
                    boolean status = p[4].equals("Available") ? true : false;

                    Book b;
                    b = new Book(id, title, author, year, status);

                    if (!lib.addBooks(b))
                        System.out.print("Duplicate ID, skipping: " + line);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping bad line: " + line);
                }
            }
        }

        // Load Users
        if (Files.exists(USERS_FILE)) {
            for (String line : Files.readAllLines(USERS_FILE)) {
                try {
                    // Because both user types have different array length
                    // Student being 8 in length and Staff 9
                    // The -1 here allows both types to store in an array of 9
                    // Preventing any issues if the last one is used for Student
                    String[] p = line.split("\\|", -1);
                    // Variables of the shared properties
                    int id = Integer.parseInt(p[1]);
                    String name = p[2];
                    String gender = p[3];
                    int age = Integer.parseInt(p[4]);
                    String phone = p[5];

                    User u;

                    switch (p[0]) {
                        case "STUDENT":
                            String course = p[6];
                            int year = Integer.parseInt(p[7]);
                            u = new Student(id, name, gender, age, phone, course, year);
                            break;
                        case "STAFF":
                            LocalDate hiredDate = LocalDate.parse(p[6]);
                            String position = p[7];
                            double salary = Double.parseDouble(p[8]);
                            u = new Staff(id, name, gender, age, phone, hiredDate, position, salary);
                            break;
                        default :
                            System.out.println("Unknown type, skipping: " + line);
                            continue;
                    }
                    if (!lib.addUser(u)) 
                        System.out.println("Duplicate ID, skipping: " + line);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping bad line: " + line);
                }
            }
        }

        // Load Loans
        if (Files.exists(LOANS_FILE)) {
            for (String line : Files.readAllLines(LOANS_FILE)) {
                try {
                    String[] p = line.split("\\|", -1);
                    int id = Integer.parseInt(p[0]);
                    Book bookLoan = lib.findBook(Integer.parseInt(p[1]));
                    User borrower = lib.findUser(Integer.parseInt(p[2]));
                    Staff assignedLender = lib.findStaff(Integer.parseInt(p[3]));
                    LocalDate dateLoaned = LocalDate.parse(p[4]);
                    LocalDate dateDue = LocalDate.parse(p[5]);
                    
                    if (bookLoan == null || borrower == null || assignedLender == null) {
                        System.out.print("Loan refers to a missing record, skipping: " + line);
                        continue;
                    }
                    
                    LoanTransaction t;
                    t = new LoanTransaction(id, bookLoan, borrower, assignedLender, dateLoaned, dateDue);

                    if (!p[6].isEmpty()) {
                        t.setDateReturned(LocalDate.parse(p[6]));
                    }

                    lib.addLoans(t);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping bad line: " + line);
                }
            }
        }
    }
}
