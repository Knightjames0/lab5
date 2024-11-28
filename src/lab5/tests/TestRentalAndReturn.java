package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Book;
import lab5.BorrowingBookResult;
import lab5.BorrowingService;
import lab5.Ebook;
import lab5.Member;
//Part 4 Tests
public class TestRentalAndReturn {
	@Test
	public void testEBookRentalAndReturn() {
	    BorrowingService service = BorrowingService.getInstance();
	    Member member = new Member("Steve Jobs", service);
	    Book ebook = new Ebook("Test EBook");

	    BorrowingBookResult borrowResult = service.borrowBook(member, ebook);
	    assertTrue(borrowResult.isSuccess());
	    assertFalse(ebook.getIsAvailable());
	    assertTrue(member.getBorrowedBooks().contains(ebook));

	    BorrowingBookResult returnResult = service.returnBook(member, ebook);
	    assertTrue(returnResult.isSuccess());
	    assertTrue(ebook.getIsAvailable());
	    assertFalse(member.getBorrowedBooks().contains(ebook));
	}

	@Test
	public void testAudioBookRentalAndReturn() {
	    BorrowingService service = BorrowingService.getInstance();
	    Member member = new Member("Bill Gates", service);
	    Book audioBook = new AudioBook("Test AudioBook");

	    BorrowingBookResult borrowResult = service.borrowBook(member, audioBook);
	    assertTrue(borrowResult.isSuccess());
	    assertFalse(audioBook.getIsAvailable());
	    assertTrue(member.getBorrowedBooks().contains(audioBook));

	    BorrowingBookResult returnResult = service.returnBook(member, audioBook);
	    assertTrue(returnResult.isSuccess());
	    assertTrue(audioBook.getIsAvailable());
	    assertFalse(member.getBorrowedBooks().contains(audioBook));
	}
}
