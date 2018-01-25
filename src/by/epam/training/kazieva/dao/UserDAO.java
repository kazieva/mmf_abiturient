package by.epam.training.kazieva.dao;
import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;

import java.sql.*;

public class UserDAO extends AbstractDAO {
/*    private final static String JDBCDriver = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/mmf";
    private final static String USER = "admin";
    private final static String PASSWORD = "admin";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBCDriver);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }*/
    public static ResultSet findUser(String login, String password, String key) {
        /* без пула соединений*/

   /*     Connection connection;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
        */

   // с пулом
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