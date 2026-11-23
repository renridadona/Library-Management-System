// import java.time.LocalDate;

// import classEntity.Book;
import classEntity.Library;
// import classEntity.Staff;
// import classEntity.Student;

public class Main {
    public static void main(String[] args) throws Exception {
        // Perminent storage testing - works btw
        Library bigL = new Library(1, "Big Boy Library", "PP", "0997342341", 2006);

        // bigL.addUser(new Staff(1, "Son", "Male", 100, "0962833234", LocalDate.of(2025, 12, 1), "Librarian", 1300));
        // bigL.addUser(new  Student(2, "Kon", "Female", 21, "09129981723", "IT", 2) );

        // bigL.addBooks(new Book(bigL.getNextBookId(), "How to basic", "Author man", 2019, true));
        // bigL.addBooks(new Book(bigL.getNextBookId(), "How to basic 2", "Author man", 2021, true));

        // bigL.lendBook(bigL.findBook(1), bigL.findUser(2), bigL.findStaff(1));
        // bigL.lendBook(bigL.findBook(2), bigL.findUser(1), bigL.findStaff(1));

        // bigL.returnBook(2);

        bigL.load();

        IO.println(bigL.getBooks());
        IO.println(bigL.getUsers());
        IO.println(bigL.getLoans());

        // bigL.save();
    }
}
