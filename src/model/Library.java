package model;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library(){
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void addMember(Member member){
        members.add(member);
    }
    
    public List<Book> getBooks(){
        return books;
    }

    public List<Member> getMembers(){
        return members;
    }
}
