<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
        <head>

        </head>
    <body>

<a  href="Controller?command=result">
    Abiturients
</a>
<a href="Controller?command=result_speciality">
    Specialities
</a>
<hr>
<c:if test="${sessionScope.user_role==\"admin\"}">
    <a href="Controller?command=go_to_registration">
        registration new user
    </a>

    <a href="Controller?command=all_users">
        all users
    </a>
</c:if>
<a href="Controller?command=logout">
    logout
</a>

<form method="POST" action="controller">
    <input type="hidden" name="command" value="registration"/>
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>
    Pass:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    Key:<br/>
    <input type="password" name="key" value="" />
    <br/>
    Name:<br/>
    <input type="text" name="fname" value=""/>
    <br/>
    Surname:<br/>
    <input type="text" name="sname" value=""/>
    <br/>
    <input type="submit" value="Registrate"/>
</form>

</body>
</html>
