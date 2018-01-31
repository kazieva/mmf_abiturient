package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SpecialityDAO extends AbstractDAO {
    private static String lang = "ru";
    public static ResultSet findAllSpeciality() {
        // с пулом
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT translation.speciality_name, speciality.id, speciality.recruitment_plan, translation.lang " +
                "FROM speciality_translate  translation INNER JOIN speciality " +
                "ON speciality.id=translation.speciality_id " +
                "WHERE translation.lang = '"+  lang+"';";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            result = statement.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ResultSet getSpecialityId(String specialityName) {
        // с пулом
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT speciality_id FROM speciality_translate WHERE speciality_name = \""+specialityName+"\";";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            result = statement.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void deleteSpeciality(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query="DELETE speciality_translate, speciality FROM speciality_translate LEFT JOIN speciality " +
                "ON speciality.id=speciality_translate.speciality_id " +
                "WHERE speciality.id="+id+";";
        try{
            WrapperConnection connection = pool.getConnection();
            PreparedStatement statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addSpeciality(int id, int recruitment_plan){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query="INSERT INTO speciality " +
                "(id, recruitment_plan) " +
                "VALUES ("+id+", "+recruitment_plan+");";
        try{
            WrapperConnection connection = pool.getConnection();
            PreparedStatement statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addSpecialityTranslate(int id, String lang, String name){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query="INSERT INTO speciality_translate " +
                "(speciality_id, lang, speciality_name) " +
                "VALUES ("+id+", \""+lang+"\", \""+name+"\");";
        try{
            WrapperConnection connection = pool.getConnection();
            PreparedStatement statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
