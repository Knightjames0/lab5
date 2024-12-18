package lab5;

public class LibrarianController {
	
	private Library library; // Library dependency
	
	private BorrowingService borrowingService; 
	
	public LibrarianController( ) {
		this.library = new Library(); // Constructor injection
		this.borrowingService = BorrowingService.getInstance();
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addPaperBook(String title) {
		library.addBook(new PaperBook(title));  // Book class constructor dependency
	}
	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService)); // Member class constructor dependency
	}
	
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {

Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);

		Book paperBook = library.findBookByTitle(title);
		if (paperBook != null)
			System.out.println(paperBook);

		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		BorrowingService borrower = new BorrowingService();
		Member member = library.findMemberByName(name); // use library for search

		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			borrower.borrowBook(member,book); // member borrows a book, not library

		Book paperBook = library.findBookByTitle(title);  // use library for search
		if (paperBook != null && member != null)
			borrower.borrowBook(member,paperBook); // member borrows a book, not library

		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		BorrowingService borrower = new BorrowingService();
		Member member = library.findMemberByName(name); // use library for search

		Book book = library.findBookByTitle(title); // use library for search 
		if (book != null && member != null)
			borrower.returnBook(member,book); // members returns book.

		Book paperBook = library.findBookByTitle(title); // use library for search 
		if (paperBook != null && member != null)
			borrower.returnBook(member,paperBook); // members returns book.

		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	
	public void addEbook(String title) {
		addBook(new EBookFactory(),title);  // Book class constructor dependency
	}
	
	public void addAudioBook(String title) {
		addBook(new AudioBookFactory(),title);  // Book class constructor dependency
	}
	
	public void addRareBook(String title) {
		addBook(new RareBookFactory(),title);  // Book class constructor dependency
	}
	public void addBook(BookFactory factory, String title) {
		library.addBook(factory.createBook(title)); // Book type depends on
		 // the factory passed in
	}
}
