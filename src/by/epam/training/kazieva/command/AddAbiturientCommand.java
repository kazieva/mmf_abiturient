package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static by.epam.training.kazieva.command.URLConstant.PATH_PAGE_MAIN;
import static java.lang.Byte.parseByte;
import static java.lang.Integer.parseInt;

public class AddAbiturientCommand implements ActionCommand {
    private static final String PARAM_NAME_PASSPORT_SERIES = "passport_series";
    private static final String PARAM_NAME_PASSPORT_ID = "passport_id";
    private static final String PARAM_NAME_FNAME = "fname";
    private static final String PARAM_NAME_SNAME = "sname";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_PHONE = "phone";
    private static final String PARAM_NAME_SCHOOL_CERTIFICATE = "school_certificate";
    private static final String PARAM_NAME_MATH_CERTIFICATE = "math_certificate";
    private static final String PARAM_NAME_PHYSICS_CERTIFICATE = "physics_certificate";
    private static final String PARAM_NAME_LANGUAGE_CERTIFICATE = "language_certificate";
    private static final String PARAM_NAME_SPECIALITY = "speciality";
    String page=null;
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        System.out.println("in added");

        Abiturient abiturient=new Abiturient();
        abiturient.setPassport_id(parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID)));
        abiturient.setPassport_series(request.getParameter(PARAM_NAME_PASSPORT_SERIES));
        abiturient.setFname(request.getParameter(PARAM_NAME_FNAME));
        abiturient.setSname(request.getParameter(PARAM_NAME_SNAME));
        abiturient.setPatronymic(request.getParameter(PARAM_NAME_PATRONYMIC));
        abiturient.setPhone(request.getParameter(PARAM_NAME_PHONE));
        abiturient.setSchool_certificate(parseByte(request.getParameter(PARAM_NAME_SCHOOL_CERTIFICATE)));
        abiturient.setMath_certificate(parseByte(request.getParameter(PARAM_NAME_MATH_CERTIFICATE)));
        abiturient.setPhysics_certificate(parseByte(request.getParameter(PARAM_NAME_PHYSICS_CERTIFICATE)));
        abiturient.setLanguage_certificate(parseByte(request.getParameter(PARAM_NAME_LANGUAGE_CERTIFICATE)));
        abiturient.setSpeciality_id(SpecialityLogic.getSpecialityId(request.getParameter(PARAM_NAME_SPECIALITY)));
        System.out.println(abiturient.toString());
        AbiturientLogic.addAbiturient(abiturient);
        //page=PATH_PAGE_MAIN;
        page="/result";
        return page;
    }
}
