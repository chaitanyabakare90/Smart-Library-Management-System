package model;

public class Book{
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;
    private Member borrowedBy;

    public Book(int bookId, String title,String author,String category, boolean isAvailable){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable; 
        // Now here we didnot written borrowedmember = null 
        // because if do that always we have to pass null in book contructer 
        // instead of that java automatically write borrowedmember = null this for us;
    }

    // Getters are to access help to access private data fields(Encapsulation)
    public int getBookId(){
        return bookId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getCategory(){
        return category;
    }

    public Member getBorrowedBy(){
        return borrowedBy;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    //Setters to change the data fields 
    public void setAvailability(boolean isAvailable){
        this.isAvailable = isAvailable; 
    }

    public void setBorrowedMember(Member member){
        this.borrowedBy = member;
    }
    /*
    @Override tells the compiler:

    "I am replacing a method that already exists in the parent class."

    Since every Java class automatically extends Object, the Book class already has a toString() method inherited from Object.

    By writing your own version, you're saying:

    "Don't use the default implementation. Use mine instead."
     */

    @Override
    public String toString(){
        return "Book Id : " + bookId +
                "\nTitle :" + title +
                "\nAuthor :" + author +
                "\nCategory :" + category +
                "\nAvailable :" + (isAvailable ? "Yes" : "No");
                
    }
}