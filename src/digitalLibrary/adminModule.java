package digitalLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class adminModule {
    private ArrayList<book> books;

    public adminModule() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn) {
        books.add(new book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book removed successfully.");
    }

    public void viewBooks() {
        System.out.println("Books in the library:");
        for (book book : books) {
            System.out.println(book);
        }
    }
}
