package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;
import by.epam.training.kazieva.entity.Abiturient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbiturientDAO extends AbstractDAO{
    public static ResultSet findAllAbituriebt() {
        // с пулом
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT * FROM abiturient ORDER BY (school_certificate+math_certificate+physics_certificate+language_certificate)  DESC;";
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
    public static ResultSet getAbiturient(String passport_series, int passport_id){
        ConnectionPool pool = ConnectionPool.getInstance();
        ResultSet result = null;
        String query="SELECT * FROM abiturient WHERE passport_series=\""+passport_series+"\" AND passport_id="+passport_id+";";
        System.out.println(query);
        try{
            WrapperConnection connection = pool.getConnection();
            PreparedStatement statement = getPreparedStatement(connection, query);
            result = statement.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void addAbiturient(Abiturient abiturient){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query="INSERT INTO abiturient (passport_series, passport_id, speciality_id, fname, sname, patronymic, phone, school_certificate, math_certificate, physics_certificate, language_certificate) VALUES " +
                "(\""+abiturient.getPassport_series()+"\", "+abiturient.getPassport_id()+", "+abiturient.getSpeciality_id()+", \""+ abiturient.getFname()+"\", \""+abiturient.getSname()+"\", \""+abiturient.getPatronymic()+"\", \"" +abiturient.getPhone()+"\", "+abiturient.getSchool_certificate()+ ", "+abiturient.getMath_certificate()+", "+abiturient.getPhysics_certificate()+", "+abiturient.getLanguage_certificate()+");";

        System.out.println(query);
        try{
            WrapperConnection connection = pool.getConnection();
            PreparedStatement statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteAbiturient(String passport_series, int passport_id){
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        String query="DELETE FROM abiturient WHERE passport_series=\""+passport_series+"\" AND passport_id="+passport_id+";";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateAbiturient(Abiturient abiturient, String old_passport_series, int old_passport_id){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query="UPDATE abiturient SET passport_series=\""+abiturient.getPassport_series()+"\", passport_id="+abiturient.getPassport_id()+", speciality_id="+abiturient.getSpeciality_id()+", fname=\""+abiturient.getFname()+"\", " +
                "sname=\""+abiturient.getSname()+"\", patronymic=\""+abiturient.getPatronymic()+"\", phone=\""+abiturient.getPhone()+"\", "+
                "school_certificate="+abiturient.getSchool_certificate()+", math_certificate="+abiturient.getMath_certificate()+", "+
                "physics_certificate="+abiturient.getPhysics_certificate()+", language_certificate="+abiturient.getLanguage_certificate()+
                " WHERE passport_series=\""+old_passport_series+"\" AND passport_id="+old_passport_id+";";

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
