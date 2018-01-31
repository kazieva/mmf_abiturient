package by.epam.training.kazieva.command;

import by.epam.training.kazieva.logic.SpecialityLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class AddSpecialityCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page = PATH_PAGE_SPECIALITY;
        int speciality_id=Integer.parseInt(request.getParameter(PARAM_NAME_SPECIALITY_ID));
        String ru_name = request.getParameter(PARAM_NAME_SPECIALITY_RU_NAME);
        String en_name = request.getParameter(PARAM_NAME_SPECIALITY_EN_NAME);
        int recruitment_plan=Integer.parseInt(request.getParameter(PARAM_NAME_SPECIALITY_RECRUTMENT_PLAN));
        SpecialityLogic.addNewSpeciality(speciality_id, ru_name, en_name, recruitment_plan);

        return page;
    }
}
