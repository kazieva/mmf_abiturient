package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.logic.AbiturientLogic;
import by.epam.training.kazieva.logic.SpecialityLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;


public class ResultComand implements ActionCommand {
    String page = null;
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        List<Abiturient> resultAbiturientsList = AbiturientLogic.findAllAbiturient();
        if (resultAbiturientsList.size()!=0) {
            request.setAttribute("abiturients", resultAbiturientsList);
            System.out.println(resultAbiturientsList);
            page=PATH_PAGE_MAIN;
        } else {
            request.setAttribute("errorLoginPassMessage","Incorrect login or password.");
            page = PATH_PAGE_LOGIN;
        }
        List<Speciality> resultSpecialityList = SpecialityLogic.findAllSpeciality();
        request.setAttribute("specialities", resultSpecialityList);
        return page;
    }
}
