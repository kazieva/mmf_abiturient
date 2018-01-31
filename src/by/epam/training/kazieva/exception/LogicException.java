package by.epam.training.kazieva.exception;

public class LogicException extends Exception {
    public LogicException() {
    }

    public LogicException(Throwable cause) {
        super(cause);
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
