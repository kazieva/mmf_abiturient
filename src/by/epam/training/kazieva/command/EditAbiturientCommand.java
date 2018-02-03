package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class EditAbiturientCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = null;
        String passport_series = request.getParameter(PARAM_NAME_PASSPORT_SERIES);
        int passport_id=Integer.parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID));
        Abiturient abiturient = AbiturientLogic.getAfituruent(passport_series, passport_id);
        if (abiturient!=null){
            page=PATH_EDIT_ABITURIENT_PAGE;
        }
        request.setAttribute(PARAM_NAME_ABITURIENT, abiturient);
        List<Speciality> resultSpecialityList = SpecialityLogic.findAllSpeciality();
        request.setAttribute(PARAM_NAME_SPECIALITIES, resultSpecialityList);
        return page;
    }
}
