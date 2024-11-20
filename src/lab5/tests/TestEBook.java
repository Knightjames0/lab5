package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.PaperBook;
import lab5.Member;
import lab5.Book;
import lab5.Ebook;

public class TestEBook {
    @BeforeEach
    void setUp() throws Exception{

    }

    @Test
    void testClassType(){
        Book book = new Ebook("Harry Potter");

        assertEquals(book.getClass().getName(),"lab5.Ebook");
        assertTrue(book instanceof lab5.Ebook);

        assertEquals(book.getTitle(), "Harry Potter");
        assertTrue(book.getIsAvailable());
        book.setIsAvailable(false);
        assertFalse(book.getIsAvailable());
    }
}
