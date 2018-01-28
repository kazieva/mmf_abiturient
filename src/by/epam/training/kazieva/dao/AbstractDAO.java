package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.connect.WrapperConnection;
import by.epam.training.kazieva.entity.Abiturient;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO  {
    public static PreparedStatement getPreparedStatement(WrapperConnection connection, String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
        } catch (SQLException exc) {
    //        LOGGER.error(exc);
        }
        return statement;
    }

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
       //     LOGGER.error("Impossible close statement\n" + e);
        }
    }

}
