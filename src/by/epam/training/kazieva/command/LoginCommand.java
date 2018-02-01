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
            System.out.println(user+" comand");
            session.setAttribute("user", user);
            page=PATH_PAGE_MAIN;

            List<Abiturient > resultAbiturientsList = AbiturientLogic.findAllAbiturient();
            request.setAttribute("abiturients", resultAbiturientsList);
            System.out.println(resultAbiturientsList);

            List<Speciality> resultSpecialityList = SpecialityLogic.findAllSpeciality();
            request.setAttribute("specialities", resultSpecialityList);

            session.setAttribute("user_role", user.getRole());
        }
        else {

            request.setAttribute("errorLoginPassMessage","Incorrect login or password.");
            page = PATH_PAGE_LOGIN;
        }
        return page;
    }

}