package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.PaperBook;
import lab5.Library;
import lab5.Member;


class TestFindClassString {

	
private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	
	Member member1 = new Member("Dude");
	Member member2 = new Member("Gal");
	PaperBook book1 = new PaperBook("Dune");
	PaperBook book2 = new PaperBook("1984");

	@Test
	void FindMember() {
		library.addMember(member1);
		library.addMember(member2);
		Member member = library.findMemberByName(member1.getName());
		assertEquals(member, member1, "Found member doesn't match");
		assertEquals(library.membersCount(), 2, "There should be two members");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "There should be only one member remain");
		member = library.findMemberByName(member2.getName());
		assertNull(member, "The mmber should not hav ben found after removal from the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(),  1, "Removal of a non-existent member should not affect library");
		library.removeMember(member1);
		assertEquals(library.membersCount(), 0, "All members should have been removed");
	}

	@Test
	void FindBook() {
		library.addBook(book1);
		library.addBook(book2);
		PaperBook paperBook = library.findBookByTitle(book1.getTitle());
		assert(paperBook == book1);
		assert(library.booksCount() == 2);
		library.removeBook(book2);
		assert(library.booksCount() == 1);
		paperBook = library.findBookByTitle(book2.getTitle());
		assert(paperBook == null);
		library.removeBook(book2);
		assert(library.booksCount() == 1);
		library.removeBook(book1);
		assert(library.booksCount() == 0);
	}
}
