package by.epam.training.kazieva.command;

import by.epam.training.kazieva.logic.AbiturientLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class DeleteAbiturientCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page=null;
        String passport_series = request.getParameter(PARAM_NAME_PASSPORT_SERIES);
        int passport_id=parseInt(request.getParameter(PARAM_NAME_PASSPORT_ID));
        AbiturientLogic.deleteAbiturient(passport_series, passport_id);
        System.out.println("удалили");
        page=PATH_PAGE_MAIN;
        return page;
    }
}