public class IncorrectAmountException extends RuntimeException{

    public IncorrectAmountException() {
        super();
    }
    public IncorrectAmountException(String s) {
        super(s);
    }
    public IncorrectAmountException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public IncorrectAmountException(Throwable throwable) {
        super(throwable);
    }
}
