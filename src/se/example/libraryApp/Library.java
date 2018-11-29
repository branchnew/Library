package se.example.libraryApp;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        this.books = new ArrayList<>();

        books.add(new DesignBook("The great design", "3TT5467749S", "Amina Bella"));
        books.add(new MusicBook("Sounds", "88Y56472H9S", "Idris Roll"));
        books.add(new ScienceBook("Atoms", "89546F54E9S", "Jibril Drop"));
    }

    public void add(Book book){
        books.add(book);
    }

    public void remove(Book book){
        books.remove(book);
    }


    public ArrayList<Book> search(String query) {
        ArrayList<Book> found = new ArrayList<>();
        query = query.toLowerCase();
        for (Book book: books) {
            String name = book.getName().toLowerCase();
            String author = book.getAuthor().toLowerCase();
            if (name.contains(query) || author.contains(query)){
                 found.add(book);
            }
        }
        return found;
    }

    public boolean withdraw(Book book){
        if(books.contains(book) && book.isAvailable()){
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean withdraw(String isbn){       //overload
        for(Book book: books){
            if(book.getIsbn().equals(isbn)){
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public boolean giveBack(String isbn){
        for(Book book: books){
            if(book.getIsbn().equals(isbn)){
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}
