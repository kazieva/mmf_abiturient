package by.epam.training.kazieva.command;

interface URLConstant {
    String PATH_PAGE_MAIN = "/WEB-INF/jsp/result.jsp";
    String PATH_PAGE_LOGIN = "/jsp/login.jsp";
    String PATH_PAGE_GO_TO_REGISTRATION = "/WEB-INF/jsp/registration.jsp";
    String PATH_EDIT_ABITURIENT_PAGE = "/WEB-INF/jsp/editabiturient.jsp";
    String PATH_PAGE_SPECIALITY = "/WEB-INF/jsp/speciality.jsp";
    String PATH_PAGE_NEW_SPECIALITY = "/WEB-INF/jsp/newspeciality.jsp";
    String PATH_PAGE_ALL_USERS= "/WEB-INF/jsp/alluser.jsp";
    String PATH_EMPTY_PAGE ="/WEB-INF/jsp/emptypage.jsp";
    String PATH_REDIRECT_RESULT="Controller?command=result";
    String PATH_REDIRECT_ALL_USERS="Controller?command=all_users";
    String PATH_REDIRECT_RESULT_SPECIALITY= "Controller?command=result_speciality";
}