package by.epam.training.kazieva.dao;
import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;

import java.sql.*;

public class UserDAO extends AbstractDAO {

    public static ResultSet findUser(String login, String password, String key) {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT * FROM user WHERE login = \"" +login+"\" AND password=MD5('" + password + "') AND user.`key`=MD5(\""+key+"\");";
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