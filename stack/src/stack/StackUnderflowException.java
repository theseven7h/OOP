package stack;

public class StackUnderflowException extends RuntimeException {

    public StackUnderflowException(String stackIsFull) {
        super(stackIsFull);
    }
}
