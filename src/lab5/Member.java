package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<PaperBook> borrowedBooks; // Book class dependency
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<PaperBook> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(PaperBook paperBook) {
		if (paperBook != null && paperBook.getIsAvailable() == true) {
			borrowedBooks.add(paperBook);
			paperBook.setIsAvailable(false);
		}
	}
	public void returnBook(PaperBook paperBook) {
		if (paperBook != null) {
			borrowedBooks.remove(paperBook);
			paperBook.setIsAvailable(true);
		}
	}
	public void listBorrowedBooks() {
		for (PaperBook paperBook : borrowedBooks)
			System.out.println(paperBook); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<PaperBook> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 PaperBook paperBook = bookIterator.next();
		   	 paperBook.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
}
