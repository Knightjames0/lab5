package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    public BorrowingBookResult borrowBookResultSuccess = new BorrowingBookResult(true,"Borrowing was successful");
    public BorrowingBookResult borrowBookResultFail = new BorrowingBookResult(false,"Borrowing failed. Book is Unavailable");
    public BorrowingBookResult returnBookResultSuccess = new BorrowingBookResult(true,"Book was returned succesfully");
    public BorrowingBookResult returnBookResultFail = new BorrowingBookResult(false,"Return Failed, Book does not exist in association with member");
    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {

// Here you can implement logic to check if the book is available to
// borrow and if the member can borrow it
//(e.g., item limit, member status).
        if(book.getIsAvailable()){
            book.setIsAvailable(false);
            member.getBorrowedBooks().add(book);
            return borrowBookResultSuccess;
        } else {
            return borrowBookResultFail;
        }
    }
    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        // Implement logic to handle returning a book
        if (member.getBorrowedBooks().contains(book)) {
            member.getBorrowedBooks().remove(book);
            book.setIsAvailable(true);
            System.out.println("Returning book: " + book);
            return returnBookResultSuccess;
        } else {
            return returnBookResultFail;
        }
    }
}