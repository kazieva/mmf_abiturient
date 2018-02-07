package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.SpecialityLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ResultSpecialityComand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(ResultSpecialityComand.class);
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
         String page;
        List<Speciality> resultSpecialityList = null;
        try {
            Object locate=  request.getSession().getAttribute(PARAM_NAME_LOCALE);
            resultSpecialityList = SpecialityLogic.findAllSpeciality(locate);
        } catch (LogicException e) {
            logger.error(e);
        }
        if (resultSpecialityList.size()!=0) {
             request.setAttribute("specialities", resultSpecialityList);
             page=PATH_PAGE_SPECIALITY;
         } else {
             request.setAttribute("errorSpecialityPageMessage","Specialties not found.");
             page = PATH_PAGE_MAIN;
         }
         return page;
    }
}
