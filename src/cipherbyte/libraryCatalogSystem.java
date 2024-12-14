package cipherbyte;

import java.util.ArrayList;
import java.util.Scanner;

class Book 
{
    private String title;
    private String author;

    public Book(String title, String author) 
    {
        this.title = title;
        this.author = author;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String toString() 
    {
        return "Title: " + title + ", Author: " + author;
    }
}

class LibraryCatalog 
{
    private ArrayList<Book> books;

    public LibraryCatalog() 
    {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) 
    {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
    }

    public void searchByTitle(String title) 
    {
        boolean found = false;
        for (Book book : books) 
        {
            if (book.getTitle().equalsIgnoreCase(title)) 
            {
                System.out.println("Found: " + book);
                found = true;
            }
        }
        if (!found) 
        {
            System.out.println("No book found with title: " + title);
        }
    }

    public void searchByAuthor(String author) 
    {
        boolean found = false;
        for (Book book : books) 
        {
            if (book.getAuthor().equalsIgnoreCase(author)) 
            {
                System.out.println("Found: " + book);
                found = true;
            }
        }
        if (!found) 
        {
            System.out.println("No book found by author: " + author);
        }
    }

    public void listBooks() 
    {
        if (books.isEmpty()) 
        {
            System.out.println("No books in the catalog.");
        } 
        else 
        {
            System.out.println("Listing all books:");
            for (Book book : books) 
            {
                System.out.println(book);
            }
        }
    }
}

public class libraryCatalogSystem 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();
        int choice;

        do {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;

                case 3:
                    System.out.print("Enter author name to search: ");
                    String searchAuthor = scanner.nextLine();
                    catalog.searchByAuthor(searchAuthor);
                    break;

                case 4:
                    catalog.listBooks();
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
