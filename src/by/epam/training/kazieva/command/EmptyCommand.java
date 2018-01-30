package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;

public class    EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return URLConstant.PATH_PAGE_LOGIN;
    }
}