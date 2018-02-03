package by.epam.training.kazieva.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class GoToNewSpecialityCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String page;
        HttpSession session = request.getSession(false);
        String user_role=(String)session.getAttribute("user_role");
        if ("admin role".equals(user_role+" role")){
            page=PATH_PAGE_NEW_SPECIALITY;
        }
        else{
            page="/Controller?command=result";
        }
        return page;
    }
}
