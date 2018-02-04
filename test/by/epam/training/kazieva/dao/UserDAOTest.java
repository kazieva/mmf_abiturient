package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserDAOTest {
    @Test
    public void getAllUsers() throws Exception {
        UserDAO userDAO= new UserDAO();
        List<User> users = userDAO.getAllUsers();
        Assert.assertFalse(users.isEmpty());
    }

}