package by.epam.training.kazieva.command;

import by.epam.training.kazieva.dao.UserDAO;
import by.epam.training.kazieva.entity.User;
import static by.epam.training.kazieva.command.URLConstant.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_KEY = "key";

    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String key = request.getParameter(PARAM_NAME_KEY);
        ResultSet result= UserDAO.findUser(login, password, key);
        try {
            if (result.next()) {
                List<User> resList = new ArrayList<>();
                try {
                    do {
                        User res=new User();
                        res.setLogin(result.getString("login"));
                        res.setPassword(result.getString("password"));
                        res.setFname(result.getString("fname"));
                        res.setSname(result.getString("sname"));
                        res.setRole(result.getString("user_role"));
                        res.setKey(result.getString("key"));
                        resList.add(res);

                    }while (result.next());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("users", resList);
                System.out.println(resList);
                page=PATH_PAGE_MAIN;
            } else {

                request.setAttribute("errorLoginPassMessage","Incorrect login or password.");
                page = PATH_PAGE_LOGIN;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

}