package by.epam.training.kazieva.command;

import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.SpecialityLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DeleteSpecialityCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(DeleteSpecialityCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page;
        int id = Integer.parseInt(request.getParameter(PARAM_NAME_SPECIALITY_ID));
        try {
            SpecialityLogic.deleteSpecialityById(id);
        } catch (LogicException e) {
            logger.error(e);
        }
        page = PATH_PAGE_SPECIALITY;
        request.setAttribute(PARAM_NAME_REDIRECT, PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT_SPECIALITY);
        return page;
    }
}
