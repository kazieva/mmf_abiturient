package by.epam.training.kazieva.command;

import by.epam.training.kazieva.logic.UserLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UpdateUserRoleCommand implements ActionCommand {
    private static final String  PARAM_USER_ROLE_ADMIN="user";
    private static final String  PARAM_USER_ROLE_USER ="admin";
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String user_role=request.getParameter(PARAM_NAME_USER_ROLE);
        if("admin".equals(user_role)){
            UserLogic.changeUserRole(login, PARAM_USER_ROLE_ADMIN);
        }else {
            if("user".equals(user_role)){
                UserLogic.changeUserRole(login, PARAM_USER_ROLE_USER);
            }
        }
        request.setAttribute(PARAM_NAME_REDIRECT,PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_ALL_USERS);
        return PATH_PAGE_ALL_USERS;
    }
}
