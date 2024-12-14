package digitalLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class libraryManagementSystem {
    private static ArrayList<book> books = new ArrayList<>();
    private static adminModule adminModule = new adminModule();
    private static userModule userModule = new userModule(books);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    userMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void adminMenu(Scanner scanner) {
        int adminChoice;
        do {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (adminChoice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    adminModule.addBook(title, author, isbn);
                    break;
                case 2:
                    System.out.print("Enter book ISBN to remove: ");
                    String removeIsbn = scanner.nextLine();
                    adminModule.removeBook(removeIsbn);
                    break;
                case 3:
                    adminModule.viewBooks();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (adminChoice != 4);
    }

    private static void userMenu(Scanner scanner) {
        int userChoice;
        do {
            System.out.println("\nUser  Menu");
            System.out.println("1. View Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    userModule.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter book ISBN to issue: ");
                    String issueIsbn = scanner.nextLine();
                    userModule.issueBook(issueIsbn);
                    break;
                case 3:
                    System.out.print("Enter book ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    userModule.returnBook(returnIsbn);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != 4);
    }
}
