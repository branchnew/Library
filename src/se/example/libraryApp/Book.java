package se.example.libraryApp;

public class Book {
    private String name;
    private String isbn;
    private String author;
    private boolean available;

    public Book(String name, String isbn, String author){
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString(){
        return this.name;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }
}
