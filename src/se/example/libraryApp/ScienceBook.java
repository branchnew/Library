package se.example.libraryApp;

public class ScienceBook extends Book{
    private String tags;
    public ScienceBook(String name, String isbn, String author) {
        super(name, isbn, author);
    }
    public ScienceBook(String name, String isbn, String author, String tags) {
        this(name, isbn, author);
        this.tags = tags;
    }

    public String toString(){
        if (tags != null && !tags.equals("")){
            return this.getName() + " [Science] " + this.tags;
        }
        return this.getName() + " [Science]";
    }
}
