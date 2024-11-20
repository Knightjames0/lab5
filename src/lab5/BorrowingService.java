package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    @Override
    public boolean borrowBook(Member member, Book book) {
// Here you can implement logic to check if the book is available to
// borrow and if the member can borrow it
//(e.g., item limit, member status).
        if(book.getIsAvailable()){
            System.out.println("Borrowing book: " + book);
            book.setIsAvailable(false);
            member.getBorrowedBooks().add(book);
            return true; // Return true for success
        } else {
            System.out.println("Borrow Failed");
            return false;
        }
    }
    @Override
    public boolean returnBook(Member member, Book book) {
        // Implement logic to handle returning a book
        member.getBorrowedBooks().remove(book);
        book.setIsAvailable(true);
        System.out.println("Returning book: " + book);
        return true; // Return true for success
    }
}