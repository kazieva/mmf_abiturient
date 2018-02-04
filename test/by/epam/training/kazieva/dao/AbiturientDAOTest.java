package by.epam.training.kazieva.dao;

import by.epam.training.kazieva.entity.Abiturient;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AbiturientDAOTest {
    @Test
    public void findAllAbituriebt() throws Exception {
        AbiturientDAO abiturientDAO=new AbiturientDAO();
        List<Abiturient> abiturients=abiturientDAO.findAllAbituriebt();
        Assert.assertFalse(abiturients.isEmpty());
    }

}