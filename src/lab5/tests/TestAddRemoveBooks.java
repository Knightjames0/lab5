package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import lab5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestAddRemoveBooks {
	
	private Library library;
	private BorrowingService service = BorrowingService.getInstance();

	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}

	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new PaperBook("Moby Dick");
	
	Member member = new Member("Grady Booch",service);
	BorrowingService borrower = new BorrowingService();
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook(book2);
		library.removeBook(book3);
		assertEquals(library.booksCount(), 1, "There should be only one book left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook("Dune");
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		
		borrower.borrowBook(member,book1);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		library.removeBook(book1);
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); // 
		
		Book b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, book1,"The owned book should be the removed book");
	}
	
	//New test for ebooks and audoi books for P4
	@Test
	public void testAddAndRemoveBooks() {
	    Library library = new Library();

	    Book ebook = new Ebook("Test EBook");
	    library.addBook(ebook);
	    assertEquals(1, library.booksCount());
	    assertNotNull(library.findBookByTitle("Test EBook"));

	    Book audioBook = new AudioBook("Test AudioBook");
	    library.addBook(audioBook);
	    assertEquals(2, library.booksCount());
	    assertNotNull(library.findBookByTitle("Test AudioBook"));

	    library.removeBook("Test EBook");
	    assertEquals(1, library.booksCount());
	    assertNull(library.findBookByTitle("Test EBook"));

	    library.removeBook("Test AudioBook");
	    assertEquals(0, library.booksCount());
	    assertNull(library.findBookByTitle("Test AudioBook"));
	}
	
}
