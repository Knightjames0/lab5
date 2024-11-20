package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.PaperBook;
import lab5.Member;
import lab5.Book;

public class TestPaperBook {
    @BeforeEach
    void setUp() throws Exception{

    }

    @Test
    void testClassType(){
        Book book = new PaperBook("Harry Potter");

        assertEquals(book.getClass().getName(),"lab5.PaperBook");
        assertTrue(book instanceof lab5.Book);

        assertEquals(book.getTitle(), "Harry Potter");
        assertTrue(book.getIsAvailable());
        book.setIsAvailable(false);
        assertFalse(book.getIsAvailable());
    }
}
