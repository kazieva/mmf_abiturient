package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;


public class ResultComand implements ActionCommand {
    String page = null;
    private static final Logger logger = Logger.getLogger(ResultComand.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        List<Abiturient> resultAbiturientsList = null;
        try {
            resultAbiturientsList = AbiturientLogic.findAllAbiturient();
        } catch (LogicException e) {
            logger.error(e);
        }
        if (resultAbiturientsList.size() != 0) {
            request.setAttribute("abiturients", resultAbiturientsList);
            System.out.println(resultAbiturientsList);
            page = PATH_PAGE_MAIN;
        } else {
            request.setAttribute("errorLoginPassMessage", "Incorrect login or password.");
            page = PATH_PAGE_LOGIN;
        }
        List<Speciality> resultSpecialityList = null;
        try {
            Object locate = request.getSession().getAttribute(PARAM_NAME_LOCALE);
            resultSpecialityList = SpecialityLogic.findAllSpeciality(locate);
        } catch (LogicException e) {
            logger.error(e);
        }
        request.setAttribute("specialities", resultSpecialityList);
        return page;
    }
}
