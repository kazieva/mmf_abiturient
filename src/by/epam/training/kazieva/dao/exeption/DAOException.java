package by.epam.training.kazieva.dao.exeption;

public class DAOException extends Throwable {
    private static final long serialVersionUID = 1L;

    public DAOException(String message, Exception e){
        super(message, e);
    }
    public DAOException(String message){
        super(message);
    }
    public DAOException(Exception e){
        super(e);
    }
    public DAOException(){

    }
}