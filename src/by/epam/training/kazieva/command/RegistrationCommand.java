package by.epam.training.kazieva.command;

import by.epam.training.kazieva.logic.MailLogic;
import by.epam.training.kazieva.logic.UserLogic;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String key = request.getParameter(PARAM_NAME_KEY);
        String fname= request.getParameter(PARAM_NAME_FNAME);
        String sname = request.getParameter(PARAM_NAME_SNAME);
        UserLogic.registrateUser(login, password, key, fname, sname);
        MailLogic.sendRegistratedEmail(login, password, key, fname);
        request.setAttribute("redirect","true");
        request.setAttribute("redirect_ulr", "Controller?command=all_users");
        page=PATH_PAGE_ALL_USERS;
        return page;
    }

}
