import java.util.*;

import model.Book;
import model.Library;
import model.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        boolean isrunning = true;
        while(isrunning){
            System.out.println("===== Smart Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register Member");
            System.out.println("4. View Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice:");
            int choice = sc.nextInt();

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

                case 2 : 
                    List<Book> books = library.getBooks();

                    if(books.size() == 0){
                        System.out.println("No books available in the library.");
                    }else{
                        System.out.println("List Of Books In library");
                        for(Book book1 : books){
                            System.out.println(book1);
                        }
                    }

                    break;

                case 3 :
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
                
                case 4 : 
                    List<Member> members = library.getMembers();
                    if(members.size() == 0){
                        System.out.println("Member List is Empty");
                    }else{
                        System.out.println("========== Members ==========");
                        for(Member member1 : members){
                            System.out.println(member1);
                        }
                    }
                    break;
                case 7 :
                    isrunning = false;
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            
        }
    }
}
