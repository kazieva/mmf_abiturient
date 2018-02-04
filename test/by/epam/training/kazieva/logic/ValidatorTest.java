package by.epam.training.kazieva.logic;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    @Test
    public void registrationValidation() throws Exception {
        String login="";
        String pass="";
        String key="";
        String fname="";
        String sname="";
        boolean result = Validator.registrationValidation(login,pass,key,fname,sname);
        Assert.assertFalse(result);
    }
    @Test
    public void registrationValidation2() throws Exception {
        String login="kazieva@bsu.by";
        String pass="kazieva";
        String key="kazieva";
        String fname="Yulia";
        String sname="Kazieva";
        boolean result = Validator.registrationValidation(login,pass,key,fname,sname);
        Assert.assertTrue(result);
    }

    @Test
    public void loginationValidation() throws Exception {
        String login="kazieva@bsu.by";
        String pass="kazieva";
        String key="kazieva";
        boolean result = Validator.loginationValidation(login,pass,key);
        Assert.assertTrue(result);
    }
    @Test
    public void loginationValidation2() throws Exception {
        String login="kazieva@bsu.by";
        String pass="";
        String key="kazieva";
        boolean result = Validator.loginationValidation(login,pass,key);
        Assert.assertFalse(result);
    }

    @Test
    public void newSpecialityValidation() throws Exception {
        int speciality_id=125;
        String ru_name="веб-программирование";
        String en_name="web-progremming";
        int recruitment_plan = 25;
        boolean result = Validator.newSpecialityValidation(speciality_id,ru_name,en_name,recruitment_plan);
        Assert.assertTrue(result);
    }
    @Test
    public void newSpecialityValidation2() throws Exception {
        int speciality_id=125;
        String ru_name="";
        String en_name="web-progremming";
        int recruitment_plan = 25;
        boolean result = Validator.newSpecialityValidation(speciality_id,ru_name,en_name,recruitment_plan);
        Assert.assertFalse(result);
    }

}