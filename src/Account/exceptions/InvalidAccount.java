package Account.exceptions;

public class InvalidAccount extends RuntimeException {
    public InvalidAccount(String messages) {
        super(messages);
    }
}
