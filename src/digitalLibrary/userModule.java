package digitalLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class userModule {
    private ArrayList<book> books;

    public userModule(ArrayList<book> books) {
        this.books = books;
    }

    public void viewBooks() {
        System.out.println("Available books:");
        for (book book : books) {
            if (!book.isIssued()) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String isbn) {
        for (book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isIssued()) {
                book.issue();
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not available for issuing.");
    }

    public void returnBook(String isbn) {
        for (book book : books) {
            if (book.getIsbn().equals(isbn) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("This book was not issued.");
    }
}
