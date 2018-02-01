package by.epam.training.kazieva.dao;
import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;
import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.exception.ConnectionPoolException;
import by.epam.training.kazieva.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
    public User findUser(String login, String password, String key) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        User user = null;
        String query = "SELECT * FROM user WHERE login = \"" +login+"\" AND password=MD5('" + password + "') AND user.`key`=MD5(\""+key+"\");";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            result = statement.executeQuery();
            try {
                if (result.next()) {
                    user= new User();
                    user.setLogin(result.getString("login"));
                    user.setPassword(result.getString("password"));
                    user.setFname(result.getString("fname"));
                    user.setSname(result.getString("sname"));
                    user.setRole(result.getString("user_role"));
                    user.setKey(result.getString("key"));
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during findUser", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return user;
    }
    public List<User> getAllUsers() throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result;
        List<User> resultUserList = null;
        String query = "SELECT * FROM user;";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            result = statement.executeQuery();
            if (result.next()) {
                resultUserList= new ArrayList<>();
                try {
                    do {
                        User user = new User();
                        user.setLogin(result.getString("login"));
                        user.setPassword(result.getString("password"));
                        user.setFname(result.getString("fname"));
                        user.setSname(result.getString("sname"));
                        user.setRole(result.getString("user_role"));
                        user.setKey(result.getString("key"));
                        resultUserList.add(user);
                    }while (result.next());
                }
                catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during getAllUsers", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return resultUserList;
    }
    public void registrateUser(String login, String password, String key, String fname, String sname) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "INSERT INTO user (login, user.password, user.key, fname, sname) VALUES (\""+
                    login+"\", MD5('"+password+"'), MD5('"+key+"'), \""+fname+"\", \""+sname+"\");";
        LOGGER.info(query);
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during registrateUser", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
    public void updateUserRole(String login, String role) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result;
        String query = "UPDATE user SET user_role='"+role+"' WHERE login =\""+login+"\";";
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, query);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during updateUserRole ", e);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
}