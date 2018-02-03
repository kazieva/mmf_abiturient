package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class GoToRegistrsionCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page;
        HttpSession session = request.getSession(false);
        String user_role=(String)session.getAttribute(PARAM_NAME_USER_ROLE);
        if ("admin role".equals(user_role+" role")){
            page=PATH_PAGE_GO_TO_REGISTRATION;
        }
        else{
            page=PATH_REDIRECT_RESULT;
        }
        return page;
    }
}
