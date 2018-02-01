<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MMF</title><style>
    <%@include file='css/style.css' %>
</style>

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
<section>
    <h1>ALL USERS</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>

                <td>Фамилия</td>
                <td>Имя</td>
                <td>Роль </td>
                <td>  </td>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>

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
            </tbody>
        </table>
    </div>
</section>
<c:if test="${sessionScope.user_role==\"admin\"}">
    <a href="Controller?command=go_to_registration">
        Registrate new user
    </a>
</c:if>

</body>
</html>
