package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.UserDAO;
import by.epam.training.kazieva.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLogic {
    public static User findUser(String login, String password, String key) {
        User user = null;
        ResultSet result = UserDAO.findUser(login, password, key);
        try {
            if (result.next()) {
                user = new User();
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                user.setFname(result.getString("fname"));
                user.setSname(result.getString("sname"));
                user.setRole(result.getString("user_role"));
                user.setKey(result.getString("key"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
