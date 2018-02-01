package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class GoToRegistrsionCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = PATH_PAGE_GO_TO_REGISTRATION;
        return page;
    }
}
