package by.epam.training.kazieva.command;

import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.AbiturientLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class DeleteAbiturientCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(DeleteAbiturientCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page;
        String passport_series = request.getParameter(PARAM_NAME_PASSPORT_SERIES);
        int passport_id = parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID));
        try {
            AbiturientLogic.deleteAbiturient(passport_series, passport_id);
        } catch (LogicException e) {
            logger.error(e);
        }
        page = PATH_PAGE_MAIN;
        request.setAttribute(PARAM_NAME_REDIRECT, PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT);
        return page;
    }
}
