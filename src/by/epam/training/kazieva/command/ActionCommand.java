package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException;
}