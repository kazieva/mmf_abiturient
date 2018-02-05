package by.epam.training.kazieva.command;

import by.epam.training.kazieva.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String lang = request.getParameter(PARAM_NAME_LOCALE);
        MessageManager.setResourceBundle(lang);
        if ("RU".equals(lang)) {
            request.getSession().setAttribute(PARAM_NAME_LOCALE, "ru-Ru");
        } else if ("EN".equals(lang)) {
            request.getSession().setAttribute(PARAM_NAME_LOCALE, "en-En");
        } else {
            request.getSession().setAttribute(PARAM_NAME_LOCALE, "en-En");
        }
        String page=request.getParameter(PARAM_NAME_OLD_COMMAND);
        request.setAttribute(PARAM_NAME_REDIRECT,PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, page);
        return page;
    }
}
