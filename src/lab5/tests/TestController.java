package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import lab5.Member;
import lab5.Library;
import lab5.LibrarianController;

class TestController {
	
	LibrarianController librarian;
	Library library;
	String memberName = "Alice";
	String bookTitle1 = "Dune";
	String bookTitle2 = "1984";
	String bookTitle3 = "Moby Dick";

	@BeforeEach
	void setUp() throws Exception {
		this.librarian = new LibrarianController(); // Fresh library: one member, three books
		this.library = librarian.getLibrary(); 
		librarian.addMember(memberName);
		librarian.addAudioBook(bookTitle1);
		librarian.addRareBook(bookTitle2);
		librarian.addEbook(bookTitle3);
	}

	@Test
	void borrowBooksByController() {
		
		assertAll("Check inital library state", 
			() -> assertEquals(library.membersCount(),1),
			() -> assertEquals(library.booksCount(),3),
			() -> assertEquals(library.membersCount(),1),
			() -> assertEquals(library.findMemberByName(memberName).borrowedBooksCount(),0)
		);
		
		librarian.borrowBookByMember(bookTitle1, memberName);
		librarian.borrowBookByMember(bookTitle2, memberName);
		librarian.borrowBookByMember(bookTitle3, memberName);
		
		assertEquals(library.findMemberByName(memberName).borrowedBooksCount(),3);
		assertFalse(library.findBookByTitle(bookTitle1).getIsAvailable());
		assertFalse(library.findBookByTitle(bookTitle2).getIsAvailable());
		assertFalse(library.findBookByTitle(bookTitle3).getIsAvailable());
		
		librarian.returnBookByMember(bookTitle1, memberName);
		assertTrue(library.findBookByTitle(bookTitle1).getIsAvailable());
		assertEquals(library.findMemberByName(memberName).borrowedBooksCount(),2);
		librarian.returnBookByMember(bookTitle2, memberName);
		librarian.returnBookByMember(bookTitle3, memberName);
		assertTrue(library.findBookByTitle(bookTitle2).getIsAvailable());
		assertTrue(library.findBookByTitle(bookTitle3).getIsAvailable());
		assertEquals(library.findMemberByName(memberName).borrowedBooksCount(),0);
	}

	
	@Test
	void removeBooksByController() {
		assertEquals(library.booksCount(),3);
		librarian.removeBook(bookTitle1);
		assertEquals(library.booksCount(),2);
		librarian.removeBook(bookTitle2);
		librarian.removeBook(bookTitle3);
		assertEquals(library.booksCount(),0);
		
	}
	
	@Test
	void removeMemberByController() {
		assertEquals(library.membersCount(),1);
		librarian.removeMember(memberName);
		assertEquals(library.membersCount(),0);
	}
	
	@Test
	void removeMemberWithBooksByController() {
		assertAll("Check inital library state", 
				() -> assertEquals(library.membersCount(),1),
				() -> assertEquals(library.booksCount(),3),
				() -> assertEquals(library.membersCount(),1),
				() -> assertEquals(library.findMemberByName(memberName).borrowedBooksCount(),0)
			);
		librarian.borrowBookByMember(bookTitle1, memberName);
		librarian.borrowBookByMember(bookTitle2, memberName);
		librarian.borrowBookByMember(bookTitle3, memberName);
		assertEquals(library.findMemberByName(memberName).borrowedBooksCount(),3);
		
		Member member  = library.findMemberByName(memberName);
		librarian.removeMember(memberName);
		
		assertEquals(member.borrowedBooksCount(),0);
		assertEquals(library.membersCount(),0);
		assertEquals(library.booksCount(),3);
		assertTrue(library.findBookByTitle(bookTitle1).getIsAvailable());
		assertTrue(library.findBookByTitle(bookTitle2).getIsAvailable());
		assertTrue(library.findBookByTitle(bookTitle3).getIsAvailable());
		
	}
	@Test
	void showBook() {
		System.out.println("----- Should be " + bookTitle1 + " ----");
		librarian.showBook(bookTitle1);
		System.out.println("----- All books ----");
		librarian.showBooks();
	} 
	@Test
	void showMember() {
		System.out.println("----- Should be " + memberName + " ----");
		librarian.showMember(memberName);
		System.out.println("----- All members ----");
		librarian.showMembers();
	} 

	
}
