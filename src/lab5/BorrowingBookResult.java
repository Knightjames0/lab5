package lab5;

public class BorrowingBookResult {
    private boolean isSuccess;
    private String borrowingMessage;

    public BorrowingBookResult(boolean isSuccess,
                               String borrowingMessage) { this.isSuccess = isSuccess;
        this.borrowingMessage = borrowingMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getBorrowingMessage() {
        return borrowingMessage;
    }

    public void setBorrowingMessage(String borrowingMessage) {
        this.borrowingMessage = borrowingMessage;
    }
}
