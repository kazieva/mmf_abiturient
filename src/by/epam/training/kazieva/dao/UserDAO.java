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
    public static ResultSet getAllUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT * FROM user;";
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
    public static void registrateUser(String login, String password, String key, String fname, String sname) {
        ConnectionPool pool = ConnectionPool.getInstance();
        ResultSet result = null;
            String query = "INSERT INTO user (login, user.password, user.key, fname, sname) VALUES (\""+
                    login+"\", MD5('"+password+"'), MD5('"+key+"'), \""+fname+"\", \""+sname+"\");";
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
    public static void updateUserRole(String login, String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        ResultSet result = null;
        String query = "UPDATE user SET user_role='"+role+"' WHERE login =\""+login+"\";";
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