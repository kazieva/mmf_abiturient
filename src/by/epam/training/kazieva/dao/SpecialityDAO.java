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
}
