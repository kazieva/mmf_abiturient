package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.exception.LogicException;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static java.lang.Byte.parseByte;

public class AddAbiturientCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(AddAbiturientCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = null;
        Abiturient abiturient = new Abiturient();
        abiturient.setPassport_id(Integer.parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID)));
        abiturient.setPassport_series(request.getParameter(PARAM_NAME_PASSPORT_SERIES));
        abiturient.setFname(request.getParameter(PARAM_NAME_FNAME));
        abiturient.setSname(request.getParameter(PARAM_NAME_SNAME));
        abiturient.setPatronymic(request.getParameter(PARAM_NAME_PATRONYMIC));
        abiturient.setPhone(request.getParameter(PARAM_NAME_PHONE));
        abiturient.setSchool_certificate(parseByte(request.getParameter(PARAM_NAME_SCHOOL_CERTIFICATE)));
        abiturient.setMath_certificate(parseByte(request.getParameter(PARAM_NAME_MATH_CERTIFICATE)));
        abiturient.setPhysics_certificate(parseByte(request.getParameter(PARAM_NAME_PHYSICS_CERTIFICATE)));
        abiturient.setLanguage_certificate(parseByte(request.getParameter(PARAM_NAME_LANGUAGE_CERTIFICATE)));
        try {
            abiturient.setSpeciality_id(SpecialityLogic.getSpecialityId(request.getParameter(PARAM_NAME_SPECIALITY)));
            Abiturient testAbiturient = AbiturientLogic.getAfituruent(abiturient.getPassport_series(), abiturient.getPassport_id());
            if (testAbiturient == null) {
                AbiturientLogic.addAbiturient(abiturient);
            }
            page = PATH_PAGE_MAIN;
        } catch (LogicException e) {
            logger.error(e);
        }
        request.setAttribute(PARAM_NAME_REDIRECT, PARAM_NAME_TRUE);
        request.setAttribute(PARAM_NAME_REDIRECT_URL, PATH_REDIRECT_RESULT);
        return page;
    }
}
