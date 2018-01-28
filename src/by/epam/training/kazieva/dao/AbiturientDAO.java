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
    public static void addAbiturient(Abiturient abiturient){
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
//        ResultSet result = null;
        String query="INSERT INTO abiturient (passport_series, passport_id, speciality_id, fname, sname, patronymic, phone, school_certificate, math_certificate, physics_certificate, language_certificate) VALUES " +
                "(\""+abiturient.getPassport_series()+"\", "+abiturient.getPassport_id()+", "+abiturient.getSpeciality_id()+", \""+ abiturient.getFname()+"\", \""+abiturient.getSname()+"\", \""+abiturient.getPatronymic()+"\", \"" +abiturient.getPhone()+"\", "+abiturient.getSchool_certificate()+ ", "+abiturient.getMath_certificate()+", "+abiturient.getPhysics_certificate()+", "+abiturient.getLanguage_certificate()+");";

        System.out.println(query);
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
     //       result = statement.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
