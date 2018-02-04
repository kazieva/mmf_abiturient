package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.UserLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AllUsersCommand implements ActionCommand {
    private static final String USERS="users";
    private static final Logger logger = Logger.getLogger(AllUsersCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page=null;
        List<User> users = null;
        try {
            users = UserLogic.getAllUsers();
        } catch (LogicException e) {
            logger.error(e);
        }
        System.out.println();
        if(users.size()!=0){
            request.setAttribute(USERS,users);
            page=PATH_PAGE_ALL_USERS;
        }
        return page;
    }
}
