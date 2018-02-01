<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
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

<H2>ALL USERS</H2>
<table >
    <tr>

        <td>Фамилия</td>
        <td>Имя</td>
        <td>Роль </td>
        <td>  </td>
    </tr>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>${user.sname}</td>
            <td>${user.fname}</td>
            <td>${user.role}</td>
            <td>
                <a href="Controller?command=update_user_role&login=${user.login}&user_role=${user.role}">
                изменить роль
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<c:if test="${sessionScope.user_role==\"admin\"}">
    <a href="Controller?command=go_to_registration">
        Registrate new user
    </a>
</c:if>

</body>
</html>
