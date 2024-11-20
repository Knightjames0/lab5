package lab5;

public interface BorrowingServiceAPI {
    // Two methods to manage Member's books
    public boolean borrowBook(Member member, Book book);

    public boolean returnBook(Member member, Book book);
}