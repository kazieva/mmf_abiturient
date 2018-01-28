package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbiturientDAO extends AbstractDAO{
    public static ResultSet findAllAbituriebt() {
        // с пулом
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT * FROM abiturient ORDER BY (school_certificate+math_certificate+physics_certificate+language__certificate)  DESC;";
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
