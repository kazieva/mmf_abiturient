package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;
import by.epam.training.kazieva.entity.Speciality;
import by.epam.training.kazieva.exception.ConnectionPoolException;
import by.epam.training.kazieva.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDAO extends AbstractDAO {
    private static String lang = "ru";
    private static final Logger LOGGER = Logger.getLogger(SpecialityDAO.class);

    public List<Speciality > findAllSpeciality() throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSpeciality;
        List<Speciality > resultSpecialityList = new ArrayList<>();
        String query = "SELECT translation.speciality_name, speciality.id, speciality.recruitment_plan, translation.lang " +
                "FROM speciality_translate  translation INNER JOIN speciality " +
                "ON speciality.id=translation.speciality_id " +
                "WHERE translation.lang = '"+  lang+"';";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            resultSpeciality = statement.executeQuery();
            if (resultSpeciality.next()) {
                do {
                    Speciality res=new Speciality();
                    res.setId(resultSpeciality.getInt("id"));
                    res.setRecruitment_plan(resultSpeciality.getInt("recruitment_plan"));
                    res.setSpeciality_name(resultSpeciality.getString("speciality_name"));
                    res.setLang(resultSpeciality.getString("lang"));
                    resultSpecialityList.add(res);
                }while (resultSpeciality.next());
            }
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during findAllSpeciality ", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return resultSpecialityList;
    }
    public int getSpecialityId(String specialityName) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result;
        int specialityId=0;
        String query = "SELECT speciality_id FROM speciality_translate WHERE speciality_name = \""+specialityName+"\";";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            result = statement.executeQuery();
            if (result.next()) {
                specialityId= result.getInt("speciality_id");
            }
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during getSpecialityId ", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return specialityId;
    }

    public void deleteSpeciality(int id) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        String query="DELETE speciality_translate, speciality FROM speciality_translate LEFT JOIN speciality " +
                "ON speciality.id=speciality_translate.speciality_id " +
                "WHERE speciality.id="+id+";";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during deleteSpeciality ", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
    public void addSpeciality(int id, int recruitment_plan) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        String query="INSERT INTO speciality " +
                "(id, recruitment_plan) " +
                "VALUES ("+id+", "+recruitment_plan+");";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during addSpeciality ", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
    public void addSpecialityTranslate(int id, String lang, String name) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        String query="INSERT INTO speciality_translate " +
                "(speciality_id, lang, speciality_name) " +
                "VALUES ("+id+", \""+lang+"\", \""+name+"\");";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during addSpecialityTranslate ", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
}
