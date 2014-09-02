package queue;

/**
 * Created by Jane on 13-12-9.
 */
public class QueueOverflowException extends RuntimeException {
    public QueueOverflowException() {
        super();
    }

    public QueueOverflowException(String message) {
        super(message);
    }
}
