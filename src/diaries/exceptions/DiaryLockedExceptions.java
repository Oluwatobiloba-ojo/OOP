package diaries.exceptions;

public class DiaryLockedExceptions extends RuntimeException {

    public DiaryLockedExceptions(String message) {
        super(message);
    }
}
