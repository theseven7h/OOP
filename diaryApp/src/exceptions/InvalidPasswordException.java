package exceptions;

public class InvalidPasswordException extends DiaryApplicationException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
