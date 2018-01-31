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
    public static List<User> getAllUsers() {
        ResultSet result = UserDAO.getAllUsers();
        List<User> resultUserList = new ArrayList<>();
        try {
            if (result.next()) {
                try {
                    do {
                        User user = new User();
                        user.setLogin(result.getString("login"));
                        user.setPassword(result.getString("password"));
                        user.setFname(result.getString("fname"));
                        user.setSname(result.getString("sname"));
                        user.setRole(result.getString("user_role"));
                        user.setKey(result.getString("key"));
                        resultUserList.add(user);
                    }while (result.next());
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUserList;
    }
    public static void registrateUser(String login, String password, String key, String fname, String sname){
        //validation
        UserDAO.registrateUser(login, password, key, fname, sname);

    }
    public static void changeUserRole(String login, String user_role){
        //validation
        UserDAO.updateUserRole(login, user_role);

    }
}
