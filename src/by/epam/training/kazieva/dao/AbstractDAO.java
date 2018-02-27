package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.WrapperConnection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

    private static final Logger logger = Logger.getLogger(AbstractDAO.class);

    public static PreparedStatement getPreparedStatement(WrapperConnection connection, String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
        } catch (SQLException exc) {
            logger.error(exc);
        }
        return statement;
    }

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error("Impossible close statement\n" + e);
        }
    }

}
