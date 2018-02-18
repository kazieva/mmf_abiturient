package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.AbiturientDAO;
import by.epam.training.kazieva.entity.Abiturient;
import by.epam.training.kazieva.exception.DAOException;
import by.epam.training.kazieva.exception.LogicException;
import org.apache.log4j.Logger;
import java.util.List;

public class AbiturientLogic{

    private static final Logger logger = Logger.getLogger(AbiturientLogic.class);
    public static List <Abiturient> findAllAbiturient() throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        List<Abiturient> resultAbiturientsList;
        try {
            resultAbiturientsList = abiturientDAO.findAllAbituriebt();
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error find all abiturients", e);
        }
        return resultAbiturientsList;
    }
    public static void addAbiturient(Abiturient abiturient) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        try {
            abiturientDAO.addAbiturient(abiturient);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error add abiturient", e);
        }
    }
    public  static void  deleteAbiturient(String passport_series, int passport_id) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        try {
            abiturientDAO.deleteAbiturient(passport_series, passport_id);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error delete abiturient", e);
        }

    }
    public  static Abiturient getAfituruent(String passport_series, int passport_id) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        Abiturient abiturient=null;
        try {
            abiturient = abiturientDAO.getAbiturient(passport_series,  passport_id);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error get abiturient", e);
        }
        return abiturient;
    }
    public static void updateAbiturient(Abiturient abiturient, String old_passport_series, int old_passport_id) throws LogicException {
        AbiturientDAO abiturientDAO = new AbiturientDAO();
        try {
            abiturientDAO.updateAbiturient(abiturient, old_passport_series, old_passport_id);
        } catch (DAOException e) {
            logger.error(e);
            throw new LogicException("Error update abiturient", e);
        }
    }
}
