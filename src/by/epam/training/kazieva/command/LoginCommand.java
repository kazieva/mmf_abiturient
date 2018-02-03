package by.epam.training.kazieva.command;
import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;
import by.epam.training.kazieva.logic.UserLogic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements ActionCommand{

    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String key = request.getParameter(PARAM_NAME_KEY);

        User user = UserLogic.findUser(login, password, key);
        if(user!=null){
            HttpSession session = request.getSession(true);
            session.setAttribute(PARAM_NAME_ROLE, user);
            page=PATH_PAGE_MAIN;
            session.setAttribute(PARAM_NAME_USER_ROLE, user.getRole());
            request.setAttribute(PARAM_NAME_REDIRECT,PARAM_NAME_TRUE);
            request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT);
        }
        else {
            request.setAttribute("errorLoginPassMessage","Incorrect login or password.");
            page = PATH_PAGE_LOGIN;
        }
        return page;
    }

}