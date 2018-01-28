package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.SpecialityDAO;
import by.epam.training.kazieva.entity.Speciality;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YiaKrevetko on 28.01.2018.
 */
public class SpecialityLogic {
    public static List<Speciality> findAllSpeciality(){
        ResultSet resultSpeciality= SpecialityDAO.findAllSpeciality();
        List<Speciality > resultSpecialityList = new ArrayList<>();
        try {
            if (resultSpeciality.next()) {
                try {
                    do {
                        Speciality res=new Speciality();
                        res.setId(resultSpeciality.getInt("id"));
                        res.setRecruitment_plan(resultSpeciality.getInt("recruitment_plan"));
                        res.setSpeciality_name(resultSpeciality.getString("speciality_name"));
                        res.setLang(resultSpeciality.getString("lang"));
                        resultSpecialityList.add(res);
                    }while (resultSpeciality.next());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(resultSpecialityList);
            }
        } catch (SQLException e) {
            System.out.println("empty");
            e.printStackTrace();
        }
        return resultSpecialityList;
    }
}