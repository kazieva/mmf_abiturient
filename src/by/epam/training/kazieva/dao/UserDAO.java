package by.epam.training.kazieva.dao;
import by.epam.training.kazieva.connect.ConnectionPool;
import by.epam.training.kazieva.connect.WrapperConnection;
import by.epam.training.kazieva.entity.User;
import by.epam.training.kazieva.exception.ConnectionPoolException;
import by.epam.training.kazieva.exception.DAOException;
import org.apache.log4j.Logger;
import sun.dc.pr.PRError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO {
    private static final Logger logger = Logger.getLogger(UserDAO.class);
    private static final String SQL_FIND_USER_LOGINATION= "SELECT * FROM user WHERE login =? AND password=MD5(?) AND user.`key`=MD5(?);";
    private static final String SQL_FIND_USER="SELECT * FROM user WHERE login = ?;";
    private static final String SQL_FIND_ALL_USERS="SELECT * FROM user;";
    private static final String SQL_UPDATE_USER_ROLE= "UPDATE user SET user_role=? WHERE login =?;";
    private static final String SQL_REGISTRATE_USER=  "INSERT INTO user (login, user.password, user.key, fname, sname) "+
            "VALUES (?, MD5(?), MD5(?), ?, ?);";

    public User findUser(String login, String password, String key) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result;
        User user = null;
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_FIND_USER_LOGINATION);
            statement.setString(1,login);
            statement.setString(2,password);
            statement.setString(3,key);
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
                logger.error(e);
            }
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during findUser", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return user;
    }
    public boolean isFindUser(String login) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result;
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_FIND_USER);
            statement.setString(1,login);
            result = statement.executeQuery();
            try {
                if (result.next()) {
                    return false;
                }
                else{
                    return true;
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during findUser", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
        return false;
    }
    public List<User> getAllUsers() throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        ResultSet result;
        List<User> resultUserList = null;
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_FIND_ALL_USERS);
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
                    logger.error(e);
                }
            }
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during getAllUsers", e);
        } catch (Exception e) {
            logger.error(e);
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
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_REGISTRATE_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setString(3, key);
            statement.setString(4,fname);
            statement.setString(5,sname);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during registrateUser", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
    public void updateUserRole(String login, String role) throws DAOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        WrapperConnection connection = null;
        PreparedStatement statement = null;
        try{
            connection = pool.getConnection();
            statement = getPreparedStatement(connection, SQL_UPDATE_USER_ROLE);
            statement.setString(1,role);
            statement.setString(2,login);
            statement.executeUpdate();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        } catch (SQLException e) {
            throw new DAOException("Error during updateUserRole ", e);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(statement);
            pool.releaseConnection(connection);
        }
    }
}