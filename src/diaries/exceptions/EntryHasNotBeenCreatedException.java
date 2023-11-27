package diaries.exceptions;

public class EntryHasNotBeenCreatedException extends RuntimeException {
    public EntryHasNotBeenCreatedException(String message) {
        super(message);
    }
}
