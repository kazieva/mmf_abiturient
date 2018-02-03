package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.SpecialityDAO;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.exception.DAOException;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityLogic {
    private static final Logger logger = Logger.getLogger(SpecialityLogic.class);
    public static List<Speciality> findAllSpeciality(){
        SpecialityDAO specialityDAO = new SpecialityDAO();
        List<Speciality > resultSpecialityList = new ArrayList<>();
        try {
            resultSpecialityList=specialityDAO.findAllSpeciality();
        } catch (SQLException e) {
            logger.error(e);
        }
        return resultSpecialityList;
    }
    public static int getSpecialityId(String specialityName){
        int specialityId=0;
        SpecialityDAO specialityDAO = new SpecialityDAO();
        try {
            specialityId=specialityDAO.getSpecialityId(specialityName);
        } catch (SQLException e) {
            logger.error(e);
        }
        return specialityId;
    }
    public static void deleteSpecialityById(int id){
        SpecialityDAO specialityDAO = new SpecialityDAO();
        try {
            specialityDAO.deleteSpeciality(id);
        } catch (DAOException e) {
            logger.error(e);
        }
    }
    public static void addNewSpeciality(int speciality_id, String ru_name, String en_name, int recruitment_plan ){
        if(Validator.newSpecialityValidation(speciality_id, ru_name, en_name,recruitment_plan )){
            SpecialityDAO specialityDAO = new SpecialityDAO();
            try {
                specialityDAO.addSpeciality(speciality_id, recruitment_plan);
                specialityDAO.addSpecialityTranslate(speciality_id, "ru", ru_name);
                specialityDAO.addSpecialityTranslate(speciality_id, "en", en_name);
            } catch (DAOException e) {
                logger.error(e);
            }
        }
    }
}
