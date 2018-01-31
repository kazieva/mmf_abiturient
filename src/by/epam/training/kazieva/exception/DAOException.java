package by.epam.training.kazieva.exception;

import java.sql.SQLException;

public class DAOException extends SQLException{
    public DAOException() {
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
