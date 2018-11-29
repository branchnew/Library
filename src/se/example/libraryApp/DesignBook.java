package se.example.libraryApp;

public class DesignBook extends Book{
    public DesignBook(String name, String isbn, String author) {
        super(name, isbn, author);
    }

    public String toString(){
        return this.getName() + " [Design]";
    }
}
