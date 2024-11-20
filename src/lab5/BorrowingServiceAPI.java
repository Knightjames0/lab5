package lab5;

public interface BorrowingServiceAPI {
    public boolean borrowBook(Member member, Book book);
    public boolean returnBook(Member member, Book book);
}
