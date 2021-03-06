package by.epam.training.kazieva.logic;

public class Validator {
    public static boolean isValidRegistration(String login, String password, String key, String fname, String sname){
        return !(login.isEmpty()||password.isEmpty()||key.isEmpty()||sname.isEmpty()||fname.isEmpty());
    }
    public static boolean isValidLoginationInfo(String login, String password, String key) {
        return !(login.isEmpty() || password.isEmpty() || key.isEmpty());
    }
    public static boolean isValidNewSpeciality(int speciality_id, String ru_name, String en_name, int recruitment_plan ){
        return !(ru_name.isEmpty()||en_name.isEmpty()||recruitment_plan<1||speciality_id<1);
    }
}
