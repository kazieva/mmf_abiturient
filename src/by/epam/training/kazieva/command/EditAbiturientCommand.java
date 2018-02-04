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

public class EditAbiturientCommand implements ActionCommand{
    private static final Logger logger = Logger.getLogger(EditAbiturientCommand.class);
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = null;
        String passport_series = request.getParameter(PARAM_NAME_PASSPORT_SERIES);
        int passport_id=Integer.parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID));
        Abiturient abiturient = null;
        try {
            abiturient = AbiturientLogic.getAfituruent(passport_series, passport_id);
        } catch (LogicException e) {
            logger.error(e);
        }
        if (abiturient!=null){
            page=PATH_EDIT_ABITURIENT_PAGE;
        }
        request.setAttribute(PARAM_NAME_ABITURIENT, abiturient);
        List<Speciality> resultSpecialityList = null;
        try {
            resultSpecialityList = SpecialityLogic.findAllSpeciality();
        } catch (LogicException e) {
            logger.error(e);
        }
        request.setAttribute(PARAM_NAME_SPECIALITIES, resultSpecialityList);
        return page;
    }
}
