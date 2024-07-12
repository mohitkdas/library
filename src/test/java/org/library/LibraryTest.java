package org.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", "ISBN1", "Genre1", 2022, "Department1", true);
        book2 = new Book("Title2", "Author2", "ISBN2", "Genre2", 2023, "Department2", false);
        book3 = new Book("Title1", "Author3", "ISBN3", "Genre3", 2024, "Department3", true);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBook() {
        assertEquals(2, library.listAllBooks().size());
        library.addBook(book3);
        assertEquals(3, library.listAllBooks().size());
        library.addBook(book1); // Duplicate ISBN
        assertEquals(3, library.listAllBooks().size()); // Should still be 3
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("ISBN1");
        assertEquals(1, library.listAllBooks().size());
        library.removeBook("ISBN1"); // Removing non-existing book
        assertEquals(1, library.listAllBooks().size()); // Should still be 1
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Title1");
        assertEquals(1, books.size());
        assertEquals("ISBN1", books.get(0).getISBN());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Author1");
        assertEquals(1, books.size());
        assertEquals("ISBN1", books.get(0).getISBN());
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        assertEquals(1, books.size());
        assertEquals("ISBN1", books.get(0).getISBN());
    }
}