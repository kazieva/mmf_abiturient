package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.SpecialityDAO;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.exception.DAOException;
import by.epam.training.kazieva.exception.LogicException;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.List;

public class SpecialityLogic {
    private static final Logger logger = Logger.getLogger(SpecialityLogic.class);
    public static List<Speciality> findAllSpeciality(Object local) throws LogicException {
        SpecialityDAO specialityDAO = new SpecialityDAO();
        List<Speciality > resultSpecialityList ;
        try {
            resultSpecialityList=specialityDAO.findAllSpeciality(local);
        } catch (SQLException e) {
            logger.error(e);
            throw new LogicException("Error find all speciality", e);
        }
        return resultSpecialityList;
    }
    public static int getSpecialityId(String specialityName) throws LogicException {
        int specialityId=0;
        SpecialityDAO specialityDAO = new SpecialityDAO();
        try {
            specialityId=specialityDAO.getSpecialityId(specialityName);
        } catch (SQLException e) {
            logger.error(e);
            throw new  LogicException("Error get speciality id", e);
        }
        return specialityId;
    }
    public static void deleteSpecialityById(int id) throws LogicException {
        SpecialityDAO specialityDAO = new SpecialityDAO();
        try {
            specialityDAO.deleteSpeciality(id);
        } catch (DAOException e) {
            logger.error(e);
            throw new  LogicException("Error delete speciality", e);
        }
    }
    public static void addNewSpeciality(int speciality_id, String ru_name, String en_name, int recruitment_plan ) throws LogicException {
        if(Validator.isValidNewSpeciality(speciality_id, ru_name, en_name,recruitment_plan )){
            SpecialityDAO specialityDAO = new SpecialityDAO();
            try {
                specialityDAO.addSpeciality(speciality_id, recruitment_plan);
                specialityDAO.addSpecialityTranslate(speciality_id, "ru", ru_name);
                specialityDAO.addSpecialityTranslate(speciality_id, "en", en_name);
            } catch (DAOException e) {
                logger.error(e);
                throw new  LogicException("Error add new speciality", e);
            }
        }
    }
}
