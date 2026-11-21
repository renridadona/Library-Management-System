## Library-Management-System

The very start of this 5 man midterm project begins today (Tomorrow).

## Current Plans

- Week1: List Class and class attributes, analyze classes relationships, implement the initial skeleton of the classes [X]
- Week2: Implement the core features, menu, and apply the required OOP concepts. Plus Validation, error handling and Extra features if there's time.
- Week3: Extra features and testing. Then we start documentation and presentation slides.
- Week4: Continue with documentation and polishing plus presentation practice.

## Core Features

- Add a book (title, author, year)
- List all books, showing availability status
- Check out a book (mark as borrowed)
- Return a book (mark as available)

## Extra Features

- Search by title or author
- due dates and late fees
- track who borrowed which book

## File Structure

Still figuring it out.

## Class Relationships

```mermaid
classDiagram
    class Library {
        -private int id
        -String name
        -String location
        -String contactNumber
        -int capacity
        -int yearEst
        -List~Book~ books
        -List~LoanTransaction~ transactions
        -List~User~ users
        +addBook(String title, String auathor, int year)
        +lendBook(Book bookloan, User borrower, Staff assignedLender)
        +lendBook(Book bookloan, User borrower, Staff assignedLender, LocalDate dateLoaned, LocalDate dateDue)
        +returnBook(int bookId)
        +hireStaff(int id, String name, String gender, int age, String phone, LocalDateTime hiredDate, String position, double salary)
        +registerStudent(int id, String name, String gender, int age, String phone, String course, int year)
        +listBooks()
    }
    class Book {
        -int id
        -String title
        -String year
        -int year
        -boolean isAvailable
        -static int autoId
    }
    class User {
        -int id
        -String name
        -String gender
        -int age
        -String phone
        -List~LoanTransaction~ loans
        +getLoanperiod() Duration
        +getMaxBooks() int
        +getLoanHistory()
    }
    class Staff {
        -LocalDateTime hiredDate
        -String position
        -double salary
        +getLoanperiod() Duration
        +getMaxBooks() int
    }
    class Student {
        -String course
        -int year
        +getLoanperiod() Duration
        +getMaxBooks() int
    }
    class LoanTransaction {
        -int id
        -Book bookLoan
        -User borrower
        -Staff assignedLender
        -LocalDate dateLoaned
        -LocalDate dateDue
        -LocalDate dateReturned
        -static int autoId
    }
    Library *-- Book
    Library *-- LoanTransaction
    Library *-- Staff
    Library o-- Student
    User <|-- Staff
    User <|-- Student
    LoanTransaction --> Book
    LoanTransaction --> Staff
    LoanTransaction --> User
```