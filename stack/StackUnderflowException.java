package stack;

/**
 * Created by Jane on 13-12-8.
 */
public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}
