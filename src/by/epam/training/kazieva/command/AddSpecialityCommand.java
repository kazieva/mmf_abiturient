package by.epam.training.kazieva.command;

import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.SpecialityLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class AddSpecialityCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(AddSpecialityCommand.class);
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = PATH_PAGE_SPECIALITY;
        int speciality_id=Integer.parseInt(request.getParameter(PARAM_NAME_SPECIALITY_ID));
        String ru_name = request.getParameter(PARAM_NAME_SPECIALITY_RU_NAME);
        String en_name = request.getParameter(PARAM_NAME_SPECIALITY_EN_NAME);
        int recruitment_plan=Integer.parseInt(request.getParameter(PARAM_NAME_SPECIALITY_RECRUTMENT_PLAN));
        try {
            SpecialityLogic.addNewSpeciality(speciality_id, ru_name, en_name, recruitment_plan);
        } catch (LogicException e) {
            logger.error(e);
        }

        request.setAttribute(PARAM_NAME_REDIRECT,PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT_SPECIALITY);
        return page;
    }
}
