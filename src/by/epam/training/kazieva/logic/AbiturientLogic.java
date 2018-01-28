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
}
