package org.library;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // consume the newline
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Is the book available (true/false): ");
                    boolean availability = scanner.nextBoolean();
                    Book book = new Book(title, author, ISBN, genre, year, department, availability);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    ISBN = scanner.nextLine();
                    library.removeBook(ISBN);
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    List<Book> booksByTitle = library.findBookByTitle(title);
                    booksByTitle.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    List<Book> booksByAuthor = library.findBookByAuthor(author);
                    booksByAuthor.forEach(System.out::println);
                    break;

                case 5:
                    List<Book> allBooks = library.listAllBooks();
                    allBooks.forEach(System.out::println);
                    break;

                case 6:
                    List<Book> availableBooks = library.listAvailableBooks();
                    availableBooks.forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}