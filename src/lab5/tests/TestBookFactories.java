package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Book;
import lab5.BookFactory;
import lab5.Ebook;
import lab5.PaperBook;
import lab5.RareBook;


public class TestBookFactories {
    String title = "Find the Fox: The Almost Impossible Word Search";
    BookFactory bookFactory;
    Book book;

    @BeforeEach
    void setUp() throws Exception{
        bookFactory = null;
        book = null;
    }

    @Test
    void AudioBookFactory(){
        bookFactory = new lab5.AudioBookFactory();
        book = bookFactory.createBook(title);
        assertEquals(book.getTitle(), title);
        assertTrue(book instanceof AudioBook);
    }
    @Test
    void EBookFactory(){
        bookFactory = new lab5.EBookFactory();
        book = bookFactory.createBook(title);
        assertEquals(book.getTitle(), title);
        assertTrue(book instanceof Ebook);
    }
    @Test
    void PaperBookFactory(){
        bookFactory = new lab5.PaperBookFactory();
        book = bookFactory.createBook(title);
        assertEquals(book.getTitle(), title);
        assertTrue(book instanceof PaperBook);
    }
    @Test
    void RareBookFactory(){
        bookFactory = new lab5.RareBookFactory();
        book = bookFactory.createBook(title);
        assertEquals(book.getTitle(), title);
        assertTrue(book instanceof RareBook);
    }
}
