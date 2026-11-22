package classEntity;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class FileManager {
    public static void save(Library lib) throws IOException {
        // Save list to books.txt
        try (PrintWriter out = new PrintWriter("../../storage/books.txt")) {
            for (Book b : lib.getBooks()) 
                out.println(b.getId() + "|" + 
                            b.getTitle() + "|" + 
                            b.getAuthor() + "|" + 
                            b.getYear() + "|" + 
                            b.getStatus());
        }
        // Save list to users.txt - contains both Students and Staff
        try (PrintWriter out = new PrintWriter("../../storage/users.txt")) {
            for (User u : lib.getUsers())
                // This is different because it inherits Students and Staff 
                // Since they both have different properties, I find it easier to create a method to call the properties as a List<String>
                // Then join them here
                out.println(String.join("|", u.toFields()));
        }
        // Save list to loans.txt - all loanTransactions will live here
        try (PrintWriter out = new PrintWriter("../../storage/loans.txt")) {
            for (LoanTransaction t : lib.getLoans()){
                String returned = t.isReturned() ? t.getDateReturned().toString() : "";
                out.println(t.getBookLoan().getId() + "|" + 
                            t.getBorrower().getId() + "|" + 
                            t.getAssignedLender().getId() + "|" + 
                            t.getDateLoaned() + "|" + 
                            t.getDateDue() + "|" + 
                            returned);
            }
        }
    }

    public static void load(Library lib) throws IOException {
        Path usersFile = Path.of("../../storage/users.txt");
        if (Files.exists(usersFile)) {
            for (String line : Files.readAllLines(usersFile)) {
                try {
                    // Because both user types have different array length
                    // Student being 8 in length and Staff 9
                    // The -1 here allows both types to store in an array of 9
                    // Preventing any issues if the last one is used for Student
                    String[] p = line.split("\\|", -1);
                    // Need to tidy this whole thing up, You certainly cannot read it properly rn
                    int id = Integer.parseInt(p[1]);
                    int age = Integer.parseInt(p[4]);

                    User u;

                    switch (p[0]) {
                        case "STUDENT":
                            int year = Integer.parseInt(p[7]);
                            u = new Student(id, p[2], p[3], age, p[5], p[6], year);
                            break;
                        case "STAFF":
                            LocalDateTime hiredDate = LocalDateTime.parse(p[6]);
                            double salary = Double.parseDouble(p[8]);
                            u = new Staff(id, p[2], p[3], age, p[5], hiredDate, p[7], salary);
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
    }
}
