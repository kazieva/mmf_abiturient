package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.logic.UserLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AllUsersCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page=null;
        System.out.println("in comand all");
        List<User> users = UserLogic.getAllUsers();
        System.out.println();
        if(users.size()!=0){
            request.setAttribute("users",users);
            page=PATH_PAGE_ALL_USERS;
        }
        return page;
    }
}
