package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.UserDAO;
import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.exception.DAOException;
import by.epam.training.kazieva.exception.LogicException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class UserLogic {
    private static final Logger logger = Logger.getLogger(UserLogic.class);
    public static User findUser(String login, String password, String key) throws LogicException {
        User user = null;
        if(Validator.loginationValidation(login, password, key)){
            UserDAO userDAO = new UserDAO();
            try {
                user = userDAO.findUser(login, password, key);
            } catch (DAOException e) {
                logger.error(e);
                throw new  LogicException("Error find user");
            }
        }
        return user;
    }
    public static List<User> getAllUsers() throws LogicException {
        UserDAO userDAO = new UserDAO();
        List<User> resultUserList = new ArrayList<>();
        try {
        resultUserList =userDAO.getAllUsers();
        } catch (DAOException e) {
            logger.error(e);
            throw new  LogicException("Error get all users");
        }
        return resultUserList;
    }
    public static void registrateUser(String login, String password, String key, String fname, String sname) throws LogicException {
        boolean flag = Validator.registrationValidation(login, password, key, fname, sname);
        if(flag) {
            UserDAO userDAO = new UserDAO();
            try {
                userDAO.registrateUser(login, password, key, fname, sname);
            } catch (DAOException e) {
                logger.error(e);
                throw new LogicException("Error registation");
            }
        }
    }
    public static void changeUserRole(String login, String user_role) throws LogicException {
        //validation

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.updateUserRole(login, user_role);
        } catch (DAOException e) {
            logger.error(e);
            throw new  LogicException("Error change user role");
        }
    }
}
