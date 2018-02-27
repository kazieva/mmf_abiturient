package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;
import by.epam.training.kazieva.entity.Abiturient;

import by.epam.training.kazieva.exception.ConnectionPoolException;
import by.epam.training.kazieva.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbiturientDAO extends AbstractDAO {

    private static final Logger logger = Logger.getLogger(AbiturientDAO.class);
    private static final String SQL_FIND_ALL_ABITURIENTS = "SELECT * FROM abiturient " +
            "ORDER BY (school_certificate+math_certificate+physics_certificate+language_certificate)  DESC;";
    private static final String SQL_GET_ABITURIENT = "SELECT * FROM abiturient WHERE passport_series=? AND passport_id=?;";
    private static final String SQL_ADD_ABITURIENT = "INSERT INTO abiturient " +
            "(passport_series, passport_id, speciality_id, fname, sname, patronymic, phone, " +
            "school_certificate, math_certificate, physics_certificate, language_certificate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
    private static final String SQL_DELETE_ABITURIENT = "DELETE FROM abiturient WHERE passport_series=? AND passport_id=?;";
    private static final String SQL_UPDATE_ABITURIENT = "UPDATE abiturient SET passport_series=?, passport_id=?, speciality_id=?, fname=?, " +
            "sname=?, patronymic=?, phone=?, school_certificate=?, math_certificate=?, " +
            "physics_certificate=?, language_certificate=? " +
            " WHERE passport_series=? AND passport_id=?;";

    public List<Abiturient> findAllAbituriebt() throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultAbiturient;
        List<Abiturient> resultAbiturientsList = new ArrayList<>();
        try {
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_FIND_ALL_ABITURIENTS);
            resultAbiturient = statement.executeQuery();
            if (resultAbiturient.next()) {
                do {
                    Abiturient res = new Abiturient();
                    res.setSpeciality_id(resultAbiturient.getInt("speciality_id"));
                    res.setPassport_id(resultAbiturient.getInt("passport_id"));
                    res.setPassport_series(resultAbiturient.getString("passport_series"));
                    res.setFname(resultAbiturient.getString("fname"));
                    res.setSname(resultAbiturient.getString("sname"));
                    res.setPatronymic(resultAbiturient.getString("patronymic"));
                    res.setPhone(resultAbiturient.getString("phone"));
                    res.setSchool_certificate(resultAbiturient.getByte("school_certificate"));
                    res.setMath_certificate(resultAbiturient.getByte("math_certificate"));
                    res.setPhysics_certificate(resultAbiturient.getByte("physics_certificate"));
                    res.setLanguage_certificate(resultAbiturient.getByte("language_certificate"));
                    resultAbiturientsList.add(res);
                } while (resultAbiturient.next());
                logger.info(resultAbiturientsList);
            }
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during findAllAbituriebt", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }

        return resultAbiturientsList;
    }

    public Abiturient getAbiturient(String passport_series, int passport_id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultAbiturient;
        Abiturient abiturient = null;
        try {
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_GET_ABITURIENT);
            statement.setString(1, passport_series);
            statement.setInt(2, passport_id);
            resultAbiturient = statement.executeQuery();
            if (resultAbiturient.next()) {
                abiturient = new Abiturient();
                abiturient = new Abiturient();
                abiturient.setSpeciality_id(resultAbiturient.getInt("speciality_id"));
                abiturient.setPassport_id(resultAbiturient.getInt("passport_id"));
                abiturient.setPassport_series(resultAbiturient.getString("passport_series"));
                abiturient.setFname(resultAbiturient.getString("fname"));
                abiturient.setSname(resultAbiturient.getString("sname"));
                abiturient.setPatronymic(resultAbiturient.getString("patronymic"));
                abiturient.setPhone(resultAbiturient.getString("phone"));
                abiturient.setSchool_certificate(resultAbiturient.getByte("school_certificate"));
                abiturient.setMath_certificate(resultAbiturient.getByte("math_certificate"));
                abiturient.setPhysics_certificate(resultAbiturient.getByte("physics_certificate"));
                abiturient.setLanguage_certificate(resultAbiturient.getByte("language_certificate"));
                logger.info(resultAbiturient);
            }
        } catch (SQLException e) {
            throw new DAOException("Error during get abiturient ", e);
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return abiturient;
    }

    public void addAbiturient(Abiturient abiturient) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_ADD_ABITURIENT);
            statement.setString(1, abiturient.getPassport_series());
            statement.setInt(2, abiturient.getPassport_id());
            statement.setInt(3, abiturient.getSpeciality_id());
            statement.setString(4, abiturient.getFname());
            statement.setString(5, abiturient.getSname());
            statement.setString(6, abiturient.getPatronymic());
            statement.setString(7, abiturient.getPhone());
            statement.setByte(8, abiturient.getSchool_certificate());
            statement.setByte(9, abiturient.getMath_certificate());
            statement.setByte(10, abiturient.getPhysics_certificate());
            statement.setByte(11, abiturient.getLanguage_certificate());
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during add abiturient", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }

    public void deleteAbiturient(String passport_series, int passport_id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_DELETE_ABITURIENT);
            statement.setString(1, passport_series);
            statement.setInt(2, passport_id);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during delete abiturient", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }

    public void updateAbiturient(Abiturient abiturient, String old_passport_series, int old_passport_id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_UPDATE_ABITURIENT);
            statement.setString(1, abiturient.getPassport_series());
            statement.setInt(2, abiturient.getPassport_id());
            statement.setInt(3, abiturient.getSpeciality_id());
            statement.setString(4, abiturient.getFname());
            statement.setString(5, abiturient.getSname());
            statement.setString(6, abiturient.getPatronymic());
            statement.setString(7, abiturient.getPhone());
            statement.setByte(8, abiturient.getSchool_certificate());
            statement.setByte(9, abiturient.getMath_certificate());
            statement.setByte(10, abiturient.getPhysics_certificate());
            statement.setByte(11, abiturient.getLanguage_certificate());
            statement.setString(12, old_passport_series);
            statement.setInt(13, old_passport_id);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during updating abiturient ", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
}
