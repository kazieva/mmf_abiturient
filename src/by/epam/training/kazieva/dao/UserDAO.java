package by.epam.training.kazieva.dao;
import java.sql.*;

public class UserDAO {
    private final static String JDBCDriver = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/mmf";
    private final static String USER = "admin";
    private final static String PASSWORD = "admin";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBCDriver);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static ResultSet findUser(String login, String password, String key) {
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE login = \"" +login+"\" AND password=MD5('" + password + "') AND user.`key`=MD5(\""+key+"\");";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}