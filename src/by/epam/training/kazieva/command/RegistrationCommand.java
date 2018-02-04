package by.epam.training.kazieva.command;

import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.MailLogic;
import by.epam.training.kazieva.logic.UserLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(RegistrationCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String key = request.getParameter(PARAM_NAME_KEY);
        String fname= request.getParameter(PARAM_NAME_FNAME);
        String sname = request.getParameter(PARAM_NAME_SNAME);
        try {
            UserLogic.registrateUser(login, password, key, fname, sname);
            MailLogic.sendRegistratedEmail(login, password, key, fname);
        } catch (LogicException e) {
            logger.error(e);
        }
        request.setAttribute("redirect","true");
        request.setAttribute("redirect_ulr", "Controller?command=all_users");
        page=PATH_PAGE_ALL_USERS;
        return page;
    }

}
