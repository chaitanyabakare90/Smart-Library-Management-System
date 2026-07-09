import java.util.*;

import model.Book;
import model.Library;
import model.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        boolean isrunning = true;
        while (isrunning) {
            System.out.println("===== Smart Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register Member");
            System.out.println("4. View Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book By Title");
            System.out.println("8. Search Book By Author");
            System.out.println("9. Search Book By Category");
            System.out.println("10. Update Book Details");
            System.out.println("11. Delete Book");
            System.out.println("12. Delete Member");
            System.out.println("13. Exit");
            System.out.print("Enter Your Choice:");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter BookId :");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title :");
                    String title = sc.nextLine();

                    System.out.print("Enter Book Author :");
                    String author = sc.nextLine();

                    System.out.print("Enter Book Category :");
                    String category = sc.nextLine();

                    Book book = new Book(bookId, title, author, category, true);
                    library.addBook(book);

                    System.out.println("Book Added Successfully");
                    break;

                case 2:
                    List<Book> books = library.getBooks();

                    if (books.size() == 0) {
                        System.out.println("No books available in the library.");
                    } else {
                        System.out.println("List Of Books In library");
                        for (Book book1 : books) {
                            System.out.println(book1);
                        }
                    }

                    break;

                case 3:
                    System.out.print("Enter MemberId :");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member Name :");
                    String name = sc.nextLine();

                    System.out.print("Enter Member Email :");
                    String email = sc.nextLine();

                    System.out.print("Enter Member PhoneNumber :");
                    String phoneNumber = sc.nextLine();

                    Member member = new Member(memberId, name, email, phoneNumber);
                    library.addMember(member);

                    System.out.println("Member registered successfully!");
                    break;

                case 4:
                    List<Member> members = library.getMembers();
                    if (members.size() == 0) {
                        System.out.println("Member List is Empty");
                    } else {
                        System.out.println("========== Members ==========");
                        for (Member member1 : members) {
                            System.out.println(member1);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Member_Id : ");
                    int member_Id = sc.nextInt();
                    System.out.print("Enter Book_Id : ");
                    int book_Id = sc.nextInt();
                    String status = library.borrowBook(member_Id, book_Id);
                    if (status.equals("SUCCESS")) {
                        System.out.println("Book Borrowed Successfully");
                    } else if (status.equals("BOOK_NOT_FOUND")) {
                        System.out.println("Book Not Found");
                    } else if (status.equals("MEMBER_NOT_FOUND")) {
                        System.out.println("Member Not Found Please Register Your Self");
                    } else {
                        System.out.println("Book Is Already Borrowed");
                    }
                    break;
                case 6:
                    System.out.print("Enter Book_Id : ");
                    int book_id = sc.nextInt();
                    String answer = library.returnBook(book_id);
                    if (answer.equals("BOOK_NOT_FOUND")) {
                        System.out.println("Book Not Found");
                    } else if (answer.equals("BOOK_NOT_BORROWED")) {
                        System.out.println("Book is not borrowed");
                    } else {
                        System.out.println("Book returned successfully");
                    }
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String Book_title = sc.nextLine();
                    Book book2 = library.searchBookByTitle(Book_title);
                    if (book2 == null) {
                        System.out.println("Book Not Found");
                    } else {
                        System.out.println(book2);
                    }
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorName = sc.nextLine();
                    List<Book> authorsBooks = library.searchBooksByAuthor(authorName);
                    if (authorsBooks.isEmpty()) {
                        System.out.println("Book Not Found");
                    } else {
                        System.out.println("===== Authors Books Are ===== ");
                        for (Book book3 : authorsBooks) {
                            System.out.println(book3);
                        }
                    }
                    break;

                case 9:
                    sc.nextLine();
                    System.out.print("Enter Category Name: ");
                    String categoryName = sc.nextLine();
                    List<Book> categoryBooks = library.searchBooksByCategory(categoryName);
                    if (categoryBooks.isEmpty()) {
                        System.out.println("Book Not Found");
                    } else {
                        System.out.println("===== Category Books Are ===== ");
                        for (Book book4 : categoryBooks) {
                            System.out.println(book4);
                        }
                    }
                    break;

                case 10:
                    System.out.print("Enter BookId: ");
                    int updationId = sc.nextInt();
                    sc.nextLine();
                    if (library.getBookByBookId(updationId) == null) {
                        System.out.println("Book Not Found");
                    } else {
                        System.out.println("===== Book Found Successfully Now Enter Updated Values =====");
                        System.out.print("Enter New Title: ");
                        String newTitle = sc.nextLine();
                        System.out.print("Enter New Category: ");
                        String newCategory = sc.nextLine();
                        System.out.print("Enter New Author: ");
                        String newAuthor = sc.nextLine();
                        library.updateBookDetails(updationId, newTitle, newAuthor, newCategory);
                        System.out.println("==== Updated Book Details =====");
                        System.out.println(library.getBookByBookId(updationId));
                    }
                    break;

                case 11 : 
                    System.out.print("Enter BookId: ");
                    int bookId1 = sc.nextInt();
                    String bookstatus = library.deleteBook(bookId1);
                    if(bookstatus.equals("BOOK_NOT_FOUND")){
                        System.out.println("Book Not Found");
                    }else if(bookstatus.equals("BOOK_IS_BORROWED")){
                        System.out.println("Book Is Already Borrowed");
                    }else{
                        System.out.println("Book Deleted Successfully");
                    }
                    break;
                case 12 : 
                    System.out.print("Enter MemberId: ");
                    int memberId1 = sc.nextInt();
                    String memberstatus = library.deleteMember(memberId1);
                    if(memberstatus.equals("MEMBER_NOT_FOUND")){
                        System.out.println("Member Not Found");
                    }else if(memberstatus.equals("MEMBER_HAS_BORROWED_BOOKS")){
                        System.out.println("Member has already borrowed books");
                    }else{
                        System.out.println("Member Deleted Successfully");
                    }
                    break;
                case 13:
                    isrunning = false;
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            System.out.println();
        }
    }
}
