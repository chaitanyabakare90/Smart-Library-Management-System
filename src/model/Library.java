package model;

import enums.BorrowBookStatus;
import enums.DeleteBookStatus;
import enums.DeleteMemberStatus;
import enums.ReturnBookStatus;

import java.io.Serializable;

import java.util.*;


public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public Book getBookByBookId(int bookId) {
        for (Book book : books) {
            // book.getBookId() because bookid is private can't be accessed directly in
            // Library class
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Member getMemberByMemberId(int memberId) {
        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public BorrowBookStatus borrowBook(int memberId, int bookId) {
        // Passed member and book
        Member member = getMemberByMemberId(memberId);

        // First checking the member is registered or not
        if (member == null) {
            return BorrowBookStatus.MEMBER_NOT_FOUND;
        }

        Book book = getBookByBookId(bookId);

        // Now check weather book is present or not
        if (book == null) {
            return BorrowBookStatus.BOOK_NOT_FOUND;
        }

        // Now if book is present check its availability
        if (book.isAvailable() == false) {
            return BorrowBookStatus.BOOK_ALREADY_BORROWED;
        }
        book.setAvailability(false);
        book.setBorrowedMember(member);

        return BorrowBookStatus.SUCCESS;

    }

    public ReturnBookStatus returnBook(int bookId) {
        // Check Book is present or not in our library
        // ex. if user tried to return bookId = 999
        // which never existed in our library hence we are checking
        Book book = getBookByBookId(bookId);
        if (book == null) {
            return ReturnBookStatus.BOOK_NOT_FOUND;
        }

        //// A book can only be returned if it is currently borrowed.
        if (book.isAvailable() == true) {
            return ReturnBookStatus.BOOK_NOT_BORROWED;
        }

        book.setAvailability(true);
        book.setBorrowedMember(null);

        return ReturnBookStatus.SUCCESS;
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            // User might enter in any case so we should ignore case
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBooksByAuthor(String Author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(Author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public List<Book> searchBooksByCategory(String category) {
        List<Book> categoryBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                categoryBooks.add(book);
            }
        }
        return categoryBooks;
    }

    public void updateBookDetails(int bookId, String title, String author, String category) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setAuthor(author);
                book.setCategory(category);
                book.setTitle(title);
            }
        }
    }

    public DeleteBookStatus deleteBook(int bookId) {
        int i = 0;
        int idx = -1;
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                idx = i;
                break;
            }
            i++;
        }
        if (idx == -1) {
            return DeleteBookStatus.BOOK_NOT_FOUND;
        }

        // Checking book is already borrowed or not
        // If borrowed then we can not able to delete the book
        if (books.get(idx).isAvailable() == false) {
            return DeleteBookStatus.BOOK_IS_BORROWED;
        }

        books.remove(idx);
        return DeleteBookStatus.SUCCESS;
    }

    public DeleteMemberStatus deleteMember(int memberId) {
        int i = 0;
        int idx = -1;

        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                idx = i;
                break;
            }
            i++;
        }
        if (idx == -1) {
            return DeleteMemberStatus.MEMBER_NOT_FOUND;
        }

        // Checking if a member has borrowed a book if yes we can not able to delete him
        for (Book book : books) {
            Member member = book.getBorrowedBy();
            if (member != null && member.getMemberId() == memberId) {
                return DeleteMemberStatus.MEMBER_HAS_BORROWED_BOOKS;
            }
        }

        members.remove(idx);
        return DeleteMemberStatus.SUCCESS;
    }

    
}
