package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.dao.AbiturientDAO;
import by.epam.training.kazieva.dao.AbstractDAO;
import by.epam.training.kazieva.entity.Abiturient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbiturientLogic {
    public static List <Abiturient> findAllAbiturient(){
        ResultSet resultAbiturient= AbiturientDAO.findAllAbituriebt();
        List<Abiturient> resultAbiturientsList = new ArrayList<>();
        try {
            if (resultAbiturient.next()) {
                try {
                    do {
                        Abiturient res=new Abiturient();
                        res.setSpeciality_id(resultAbiturient.getInt("speciality_id"));
                        res.setPassport_id(resultAbiturient.getInt("passport_id"));
                        res.setPassport_series(resultAbiturient.getString("passport_series"));
                        res.setFname(resultAbiturient.getString("fname"));
                        res.setSname(resultAbiturient.getString("sname"));
                        res.setPatronymic(resultAbiturient.getString("patronymic"));
                        res.setPhone(resultAbiturient.getString("phone"));
                        res.setSchool_certificate(resultAbiturient.getByte("school_certificate"));
                        res.setMath_certificate(resultAbiturient.getByte("math_certificate"));
                        res.setPhysics_certificate(resultAbiturient.getByte("physics_certificate"));
                        res.setLanguage_certificate(resultAbiturient.getByte("language_certificate"));

                        resultAbiturientsList.add(res);
                    }while (resultAbiturient.next());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(resultAbiturientsList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultAbiturientsList;
    }
    public static void addAbiturient(Abiturient abiturient){

        AbiturientDAO.addAbiturient(abiturient);
    }
    public  static void  deleteAbiturient(String passport_series, int passport_id){
        System.out.println(passport_series+" "+ passport_id);
        AbiturientDAO.deleteAbiturient(passport_series, passport_id);

    }
    public  static Abiturient getAfituruent(String passport_series, int passport_id){
        ResultSet resultAbiturient = AbiturientDAO.getAbiturient(passport_series,  passport_id);
        Abiturient abiturient=null;

        try {
            if (resultAbiturient.next()) {
                abiturient = new Abiturient();
                abiturient.setSpeciality_id(resultAbiturient.getInt("speciality_id"));
                abiturient.setPassport_id(resultAbiturient.getInt("passport_id"));
                abiturient.setPassport_series(resultAbiturient.getString("passport_series"));
                abiturient.setFname(resultAbiturient.getString("fname"));
                abiturient.setSname(resultAbiturient.getString("sname"));
                abiturient.setPatronymic(resultAbiturient.getString("patronymic"));
                abiturient.setPhone(resultAbiturient.getString("phone"));
                abiturient.setSchool_certificate(resultAbiturient.getByte("school_certificate"));
                abiturient.setMath_certificate(resultAbiturient.getByte("math_certificate"));
                abiturient.setPhysics_certificate(resultAbiturient.getByte("physics_certificate"));
                abiturient.setLanguage_certificate(resultAbiturient.getByte("language_certificate"));
                System.out.println(resultAbiturient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abiturient;
    }
    public static void updateAbiturient(Abiturient abiturient, String old_passport_series, int old_passport_id){
        AbiturientDAO.updateAbiturient(abiturient, old_passport_series, old_passport_id);
    }
}
