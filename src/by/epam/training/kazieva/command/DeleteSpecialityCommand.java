package by.epam.training.kazieva.command;

import by.epam.training.kazieva.logic.SpecialityLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DeleteSpecialityCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page;
        int id = Integer.parseInt(request.getParameter(PARAM_NAME_SPECIALITY_ID));
        SpecialityLogic.deleteSpecialityById(id);
        page=PATH_PAGE_SPECIALITY;
        request.setAttribute(PARAM_NAME_REDIRECT,PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT_SPECIALITY);
        return page;
    }
}
