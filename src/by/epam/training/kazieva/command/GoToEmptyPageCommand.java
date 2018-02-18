package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class GoToEmptyPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = PATH_EMPTY_PAGE;
        return page;
    }
}
