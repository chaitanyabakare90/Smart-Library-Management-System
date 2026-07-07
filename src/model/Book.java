
class Book{
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(int bookId, String title,String author,String category, boolean isAvailable){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable; 
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

    public boolean isAvailable(){
        return isAvailable;
    }

    //Setters to change the data fields 
    public void setAvailability(boolean isAvailable){
        this.isAvailable = isAvailable; 
    }
}