<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
,kf,kf
<table >
    <tr>
        <td>Общий балл</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Имя</td>
        <td>Фамилия</td>

    </tr>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.key}</td>
            <td>${user.fname}</td>
            <td>${user.sname}</td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
