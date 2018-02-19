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
    private static String lang;
    private static final Logger logger = Logger.getLogger(SpecialityDAO.class);
    private static final String SQL_ADD_SPECIALITY="INSERT INTO speciality " +
            "(id, recruitment_plan) " +
            "VALUES (?, ?);";
    private static final String SQL_ADD_SPECIALITY_TRANSLATE="INSERT INTO speciality_translate " +
            "(speciality_id, lang, speciality_name) " +
            "VALUES (?, ?,?);";
    private static final String SQL_DELETE_SPECIALITY="DELETE speciality_translate, speciality "+
            "FROM speciality_translate LEFT JOIN speciality " +
            "ON speciality.id=speciality_translate.speciality_id " +
            "WHERE speciality.id=?;";
    private static final String SQL_GET_SPECIALITY_ID= "SELECT speciality_id "+
            "FROM speciality_translate "+
            "WHERE speciality_name = ?;";
    private static final String SQL_GET_ALL_SPECIALITIES="SELECT translation.speciality_name, speciality.id, speciality.recruitment_plan, translation.lang " +
            "FROM speciality_translate  translation INNER JOIN speciality " +
            "ON speciality.id=translation.speciality_id " +
            "WHERE translation.lang = ?;";


    public List<Speciality > findAllSpeciality(Object local) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSpeciality;
        if(("ru-Ru").equals(local)){lang ="ru";
            System.out.println("ru");}
        else {lang= "en";}

        List<Speciality > resultSpecialityList = new ArrayList<>();
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_GET_ALL_SPECIALITIES);
            statement.setString(1,lang);
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
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during findAllSpeciality ", e);
        } catch (Exception e) {
            logger.error(e);
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
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_GET_SPECIALITY_ID);
            statement.setString(1,specialityName);
            result = statement.executeQuery();
            if (result.next()) {
                specialityId= result.getInt("speciality_id");
            }
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during getSpecialityId ", e);
        } catch (Exception e) {
            logger.error(e);
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
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_DELETE_SPECIALITY);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during deleteSpeciality ", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
    public void addSpeciality(int id, int recruitment_plan) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_ADD_SPECIALITY);
            statement.setInt(1,id);
            statement.setInt(2,recruitment_plan);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during addSpeciality ", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
    public void addSpecialityTranslate(int id, String lang, String name) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_ADD_SPECIALITY_TRANSLATE);
            statement.setInt(1,id);
            statement.setString(2,lang);
            statement.setString(3,name);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during addSpecialityTranslate ", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
}
