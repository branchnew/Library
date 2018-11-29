package se.example.libraryApp;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("--------- Library ---------");
        System.out.println(" Choose between: ");
        System.out.println();
        System.out.println("1. Search");
        System.out.println("2. Withdraw");
        System.out.println("3. Give back");
        System.out.println("4. Add");
        System.out.println("5. Remove");
        System.out.println();
        System.out.println("Insert your choice here, please: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1:
                Library library = new Library();
                System.out.println("Write the name of the book or the name of the author: ");
                String query = sc.nextLine();
                ArrayList<Book> result = library.search(query);
                int index = 1;
                for (Book book : result) {
                    System.out.println(index++ + " " + book);
                }
                System.out.println("\n Which one do you want to withdraw?");





                break;
            case 2:
                System.out.println("Write ");
        }
    }
}
