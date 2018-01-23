package by.epam.training.kazieva.command;

import by.epam.training.kazieva.dao.UserDAO;
import by.epam.training.kazieva.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.training.kazieva.command.URLConstant.*;

public class RegistrationCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_KEY = "key";
    private static final String PARAM_NAME_FNAME = "fname";
    private static final String PARAM_NAME_SNAME = "sname";
    private static final String PARAM_NAME_ROLE = "user";
    @Override
    public String execute(HttpServletRequest request) {

        return null;
    }

}
