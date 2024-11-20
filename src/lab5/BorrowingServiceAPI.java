package lab5;

public interface BorrowingServiceAPI {
    // Two methods to manage Member's books
    public BorrowingBookResult borrowBook(Member member, Book book);

    public BorrowingBookResult returnBook(Member member, Book book);
}