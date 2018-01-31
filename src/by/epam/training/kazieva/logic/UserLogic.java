package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.UserDAO;
import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.exception.DAOException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class UserLogic {
    private static final Logger LOGGER = Logger.getLogger(UserLogic.class);
    public static User findUser(String login, String password, String key) {
        User user = null;
        UserDAO userDAO = new UserDAO();
        try {
            user = userDAO.findUser(login, password, key);
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        return user;
    }
    public static List<User> getAllUsers() {
        UserDAO userDAO = new UserDAO();
        List<User> resultUserList = new ArrayList<>();
        try {
        resultUserList =userDAO.getAllUsers();
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        return resultUserList;
    }
    public static void registrateUser(String login, String password, String key, String fname, String sname){
        //validation

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.registrateUser(login, password, key, fname, sname);
        } catch (DAOException e) {
            LOGGER.error(e);
        }

    }
    public static void changeUserRole(String login, String user_role){
        //validation

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.updateUserRole(login, user_role);
        } catch (DAOException e) {
            LOGGER.error(e);
        }
    }
}
