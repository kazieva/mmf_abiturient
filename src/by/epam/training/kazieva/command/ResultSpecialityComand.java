package by.epam.training.kazieva.command;

import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.logic.SpecialityLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ResultSpecialityComand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
         String page = null;
         List<Speciality> resultSpecialityList = SpecialityLogic.findAllSpeciality();
         if (resultSpecialityList.size()!=0) {
             request.setAttribute("specialities", resultSpecialityList);
             System.out.println(resultSpecialityList);
             page=PATH_PAGE_SPECIALITY;
         } else {
             request.setAttribute("errorSpecialityPageMessage","Specialties not found.");
             page = PATH_PAGE_MAIN;
         }
         return page;
    }
}
