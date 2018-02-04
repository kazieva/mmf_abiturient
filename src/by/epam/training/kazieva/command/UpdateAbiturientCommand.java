package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static java.lang.Byte.parseByte;
import static java.lang.Integer.parseInt;

public class  UpdateAbiturientCommand implements ActionCommand{
    private static final Logger logger = Logger.getLogger(UpdateAbiturientCommand.class);
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page;
        Abiturient abiturient=new Abiturient();
        abiturient.setPassport_id(parseInt(request.getParameter(PARAM_NAME_NEW_PASSPORT_ID)));
        abiturient.setPassport_series(request.getParameter(PARAM_NAME_NEW_PASSPORT_SERIES));
        abiturient.setFname(request.getParameter(PARAM_NAME_NEW_FNAME));
        abiturient.setSname(request.getParameter(PARAM_NAME_NEW_SNAME));
        abiturient.setPatronymic(request.getParameter(PARAM_NAME_NEW_PATRONYMIC));
        abiturient.setPhone(request.getParameter(PARAM_NAME_NEW_PHONE));
        abiturient.setSchool_certificate(parseByte(request.getParameter(PARAM_NAME_NEW_SCHOOL_CERTIFICATE)));
        abiturient.setMath_certificate(parseByte(request.getParameter(PARAM_NAME_NEW_MATH_CERTIFICATE)));
        abiturient.setPhysics_certificate(parseByte(request.getParameter(PARAM_NAME_NEW_PHYSICS_CERTIFICATE)));
        abiturient.setLanguage_certificate(parseByte(request.getParameter(PARAM_NAME_NEW_LANGUAGE_CERTIFICATE)));
        String old_passport_series = request.getParameter(PARAM_NAME_PASSPORT_SERIES);
        int old_passport_id= parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID));
        try {
            abiturient.setSpeciality_id(SpecialityLogic.getSpecialityId(request.getParameter(PARAM_NAME_NEW_SPECIALITY)));
            AbiturientLogic.updateAbiturient(abiturient,old_passport_series,old_passport_id);
        } catch (LogicException e) {
            logger.error(e);
        }
        page=PATH_PAGE_MAIN;
        request.setAttribute(PARAM_NAME_REDIRECT,PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT);
        return page;
    }
}
