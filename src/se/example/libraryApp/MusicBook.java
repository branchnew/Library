package se.example.libraryApp;

public class MusicBook extends Book{
    public MusicBook(String name, String isbn, String author) {
        super(name, isbn, author);
    }

    public String toString(){
        return this.getName() + " [Music]";
    }
}
