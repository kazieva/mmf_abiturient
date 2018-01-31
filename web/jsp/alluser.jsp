<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

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

</body>
</html>
