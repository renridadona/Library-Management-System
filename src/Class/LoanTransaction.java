package Class;

import java.time.LocalDate;

public class LoanTransaction {
    private int id;
    private Book bookLoan;
    private User borrower;
    private Staff assignedLender;
    private LocalDate dateLoaned;
    private LocalDate dateDue;
    private LocalDate dateReturned;
    private static int autoId = 1;

    public LoanTransaction() {
        this.id = 0;
        this.bookLoan = null;
        this.borrower = null;
        this.assignedLender = null;
        this.dateLoaned = null;
        this.dateDue = null;
        this.dateReturned = null;
    }

    public LoanTransaction(Book bookloan, User borrower, Staff assignedLender) {
            this.id = autoId++;
            this.bookLoan = bookloan;
            this.borrower = borrower;
            this.assignedLender = assignedLender;
            this.dateLoaned = LocalDate.now();
            this.dateDue = LocalDate.now().plus(borrower.getLoanPeriod());
            this.dateReturned = null;
    }

    public LoanTransaction(Book bookloan, User borrower, Staff assignedLender, 
            LocalDate dateLoaned, LocalDate dateDue) {
        this.id = autoId++;
        this.bookLoan = bookloan;
        this.borrower = borrower;
        this.assignedLender = assignedLender;
        this.dateLoaned = dateLoaned;
        this.dateDue = dateDue;
    }

    public int getId() {
        return id;
    }

    public Book getBookLoan() {
        return bookLoan;
    }

    public void setBookLoan(Book bookLoan) {
        this.bookLoan = bookLoan;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Staff getAssignedLender() {
        return assignedLender;
    }

    public void setAssignedLender(Staff assignedLender) {
        this.assignedLender = assignedLender;
    }

    public LocalDate getDateLoaned() {
        return dateLoaned;
    }

    public void setDateLoaned(LocalDate dateLoaned) {
        this.dateLoaned = dateLoaned;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }
}
