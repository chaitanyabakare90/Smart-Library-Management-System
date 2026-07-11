# 📚 Smart Library Management System (Core Java)

A console-based **Library Management System** developed using **Core Java** to demonstrate object-oriented programming, collections, file handling, serialization, and clean software design principles.

This project allows users to manage books and library members through an interactive menu-driven interface. Data is automatically saved to a file, ensuring persistence across application restarts.

---

## 🚀 Features

### 📖 Book Management
- Add a new book
- View all books
- Search book by title
- Search books by author
- Search books by category
- Update book details
- Delete a book

### 👥 Member Management
- Register a new member
- View all members
- Delete a member

### 🔄 Library Operations
- Borrow a book
- Return a book
- Prevent borrowing of unavailable books
- Prevent deletion of borrowed books
- Prevent deletion of members who have borrowed books

### 💾 Data Persistence
- Automatically saves library data before exiting.
- Automatically loads previously saved data on startup using Java Serialization.

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Collections Framework (ArrayList)
- File Handling
- Java Serialization
- Enums
- Repository Design Pattern
- Exception Handling
- Comparable Interface

---

## 📂 Project Structure

```
Library Management Project-JAVA
│
├── src
│   ├── model
│   │   ├── Book.java
│   │   ├── Member.java
│   │   └── Library.java
│   │
│   ├── repository
│   │   └── LibraryRepository.java
│   │
│   ├── enums
│   │   ├── BorrowStatus.java
│   │   ├── ReturnStatus.java
│   │   ├── DeleteBookStatus.java
│   │   └── DeleteMemberStatus.java
│   │
│   └── Main.java
│
└── library.dat
```

---

## 🧠 Core Java Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Constructors
- Method Overriding
- Interfaces
- Marker Interface (`Serializable`)
- Comparable Interface
- Java Collections
- Enums
- File Handling
- Serialization & Deserialization
- Try-With-Resources
- Repository Pattern
- Single Responsibility Principle (SRP)

---

## ▶️ How to Run

1. Clone the repository.

```bash
git clone <repository-url>
```

2. Open the project in VS Code or IntelliJ IDEA.

3. Compile and run `Main.java`.

4. Use the console menu to perform library operations.

---

## 📸 Sample Menu

```
===== Smart Library Management System =====

1. Add Book
2. View Books
3. Register Member
4. View Members
5. Borrow Book
6. Return Book
7. Search Book By Title
8. Search Book By Author
9. Search Book By Category
10. Update Book Details
11. Delete Book
12. Delete Member
13. Exit
```

---

## 🎯 Future Enhancements

The project will be upgraded into a full-stack application using:

- Spring Boot REST API
- MySQL Database
- React Frontend
- Authentication & Authorization
- Responsive UI
- Cloud Deployment

---

## 📖 What I Learned

While building this project, I gained practical experience with:

- Designing object-oriented applications
- Applying clean coding principles
- Managing collections effectively
- Persisting objects using Java Serialization
- Refactoring code for better maintainability
- Separating business logic from data access using the Repository Pattern

---

## 👨‍💻 Author

**Chaitanya Bakare**

If you found this project helpful, feel free to ⭐ the repository.
