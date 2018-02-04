package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.AbiturientDAO;
import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.exception.DAOException;
import by.epam.training.kazieva.exception.LogicException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class AbiturientLogic{

    private static final Logger logger = Logger.getLogger(AbiturientLogic.class);
    public static List <Abiturient> findAllAbiturient() throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        List<Abiturient> resultAbiturientsList = new ArrayList<>();
        try {
            resultAbiturientsList = abiturientDAO.findAllAbituriebt();
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error find all abiturients");
        }
        return resultAbiturientsList;
    }
    public static void addAbiturient(Abiturient abiturient) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        try {
            abiturientDAO.addAbiturient(abiturient);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error add abiturient");
        }
    }
    public  static void  deleteAbiturient(String passport_series, int passport_id) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        try {
            abiturientDAO.deleteAbiturient(passport_series, passport_id);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error delete abiturient");
        }

    }
    public  static Abiturient getAfituruent(String passport_series, int passport_id) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        Abiturient abiturient=null;
        try {
            abiturient = abiturientDAO.getAbiturient(passport_series,  passport_id);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error get abiturient");
        }
        return abiturient;
    }
    public static void updateAbiturient(Abiturient abiturient, String old_passport_series, int old_passport_id) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        try {
            abiturientDAO.updateAbiturient(abiturient, old_passport_series, old_passport_id);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error update abiturient");
        }
    }/*
    public static int getCountOfAbitirients(){
        int count=0;
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        ResultSet resultSet= null;
        try {
            resultSet = abiturientDAO.getCountOfAbitirients();
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        try {
            if(resultSet.next()){
                count=Integer.parseInt(resultSet.getString("count"));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return count;
    }*/
}
