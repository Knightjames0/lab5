package lab5;

import java.util.ArrayList;
import java.util.Iterator;


public class Library {
	 
	private ArrayList<PaperBook> catalog = new ArrayList<>(); // Book dependency
	private ArrayList<Member> members = new ArrayList<>(); // Member dependency
	
	public Member findMemberByName(String name) {
		 for (Member member : members) {
	           if (member.getName().equals(name)) {
	               return member; // Return the found member
	           }
	       }
	       return null; // Return null if not found
	}
	public PaperBook findBookByTitle (String title) {
		 for (PaperBook paperBook : catalog) {
	           if (paperBook.getTitle().equals(title)) {
	               return paperBook; // Return the found book
	           }
	       }
	       return null; // Return null if not found
	}
	public void addMember(Member member) {
		members.add(member);
	}
	public void addBook(PaperBook paperBook) {
		catalog.add(paperBook);
	}
	public void removeMember(String name) {
		Member member = findMemberByName(name);
		removeMember(member);
	}
	public void removeMember(Member member) {
		if(member != null) {
			member.returnAllBooks(); // return all member's books to the library
			members.remove(member);
		}
	}
	public void removeBook(String title) {
		PaperBook paperBook = findBookByTitle(title);
		removeBook(paperBook);
	}
	public void removeBook(PaperBook paperBook) {
		if (paperBook != null)
			catalog.remove(paperBook); // book stays with the member who has it
	}
	public void showMembers() {
		Iterator<Member> memberIterator = members.iterator();
	    while(memberIterator.hasNext()) {
		   	 Member member = memberIterator.next();
		   	 System.out.println(member);
	    }
	}
	public void showBooks() {
		Iterator<PaperBook> bookIterator = catalog.iterator();
	    while(bookIterator.hasNext()) {
		   	 PaperBook paperBook = bookIterator.next();
		   	 System.out.println(paperBook); // book.toString()
	    }
	}
	public int booksCount() {
		return catalog.size();
	}
	public int membersCount() {
		return members.size();
	}
}
