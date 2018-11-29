package se.example.libraryApp;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {


    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        menu:
        while(true) {
            int choice = getChoice(sc);

            switch (choice){
                case 1:
                    search(library, sc);
                    break;

                case 2:
                    withdraw(library, sc);
                    break;

                case 3:
                    giveBack(library, sc);
                    break;

                case 4:
                    add(library, sc);

                case 5:
                    remove(library, sc);
                    break;

                case 6:
                    System.out.println("Thank you for participating in this project!");
                    break menu;

                default:
                    System.out.println("Sorry! Something went wrong!");

            }
        }
    }

    private static void remove(Library library, Scanner sc) {
        String isbn;
        System.out.println("Please write your ISBN");
        isbn = sc.nextLine();
        if(library.remove(isbn)) {
            System.out.println("Thank you! your book is removed.");
        } else {
            System.out.println("Sorry! This book is not in the catalogue.");
        }
    }

    private static void add(Library library, Scanner sc) {
        String isbn;
        Book book;
        System.out.println("Please choose which category: ");
        System.out.println("(1) Science, (2) Music, (3) Design, (4) Other");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.println("Write the title, please:");
        String title = sc.nextLine();
        System.out.println("Write the author, please:");
        String author = sc.nextLine();
        System.out.println("Write the ISBN, please:");
        isbn = sc.nextLine();


        switch (category){
            case 1:
                System.out.println("Write some tags, comma separated:");
                String tags = sc.nextLine();
                book = new ScienceBook(title, isbn, author, tags);
                break;
            case 2:
                book = new MusicBook(title, isbn, author);
                break;

            case 3:
                book = new DesignBook(title, isbn, author);
                break;

            default:
                book = new Book(title, isbn, author);
        }

        library.add(book);
        System.out.println("Thanks, your book is inserted!");
        System.out.println(book);
    }

    private static void giveBack(Library library, Scanner sc) {
        String isbn;
        System.out.println("Please write your ISBN");
        isbn = sc.nextLine();
        if(library.giveBack(isbn)) {
            System.out.println("Thank you! your book is returned.");
        } else {
            System.out.println("Sorry! This book is not in the catalogue.");
        }
    }

    private static void withdraw(Library library, Scanner sc) {
        System.out.println("Please write your ISBN");
        String isbn = sc.nextLine();
        if(library.withdraw(isbn)) {
            System.out.println("Thank you! Please return the book within 2 weeks!");
        } else {
            System.out.println("Sorry! The book is not available.");
        }
    }

    private static void search(Library library, Scanner sc) {
        System.out.println("Write the name of the book or the name of the author: ");
        String query = sc.nextLine();
        ArrayList<Book> result = library.search(query);
        int index = 1;
        for (Book book : result) {
            System.out.println(index++ + " " + book);
        }
        System.out.println("\n Which one do you want to withdraw?");
        index = sc.nextInt() - 1;
        Book book = result.get(index); //TODO: handle IndexOutOfBound exception
        if(library.withdraw(book)) {
            System.out.println("Thank you! Please return the book within 2 weeks!");
        } else {
            System.out.println("Sorry! The book is not available.");
        }
    }

    private static int getChoice(Scanner sc) {
        System.out.println("--------- Library ---------");
        System.out.println(" Choose between: ");
        System.out.println();
        System.out.println("1. Search");
        System.out.println("2. Withdraw with ISBN");
        System.out.println("3. Return with ISBN");
        System.out.println("4. Add");
        System.out.println("5. Remove");
        System.out.println("6. Exit");
        System.out.println();
        System.out.println("Insert your choice here, please: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
}
