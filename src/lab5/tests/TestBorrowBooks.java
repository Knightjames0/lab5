package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.BorrowingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Member;
import lab5.PaperBook;

class TestBorrowBooks {

	Member member1;
	Member member2;
	
	PaperBook book1 = new PaperBook("Dune");
	PaperBook book2 = new PaperBook("1984");
	private BorrowingService service = BorrowingService.getInstance();

	@BeforeEach
	void setUp() throws Exception {

		member1 = new Member("Alice",service); // flush borrowedBook array 
		member2 = new Member("Bob",service);   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
	}
	@Test
	void borrowBookBook() {
		BorrowingService borrower = new BorrowingService();
		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		borrower.borrowBook(member1,book1);
		assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(book2.getIsAvailable(),"Book must be available");
		borrower.borrowBook(member1,book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book coubnt shoud be 2");
	}
	
	@Test
	void returnBookBook() {
		BorrowingService borrower = new BorrowingService();
		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
		borrower.borrowBook(member1,book1);
		borrower.borrowBook(member1,book2);
		assertEquals(member1.borrowedBooksCount(),2, "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
		
		// return first book
		borrower.returnBook(member1,book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
		// return second book
		borrower.returnBook(member1,book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		
	}

	@Test
	void checkPart6() {
		BorrowingService borrower = new BorrowingService();
		assertTrue(borrower.borrowBook(member1,book1).isSuccess(),"Borrowing First Book");
		assertFalse(borrower.borrowBook(member1,book1).isSuccess(), "Attempt to borrow first book again should fail");
		assertTrue(borrower.returnBook(member1,book1).isSuccess(), "Returning First Book");
		assertFalse(borrower.returnBook(member1,book1).isSuccess(), "Attempt tot return first book again should fail");
	}
}
