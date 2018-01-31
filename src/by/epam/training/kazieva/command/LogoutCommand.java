package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PATH_PAGE_LOGIN;
        return page;
    }
}
