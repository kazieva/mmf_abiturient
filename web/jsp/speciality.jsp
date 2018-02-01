<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MMF</title>
    <style>
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
    <h1>Table of all abiturients</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>

                <td>ID специальности</td>
                <td>Название</td>
                <td>План приема</td>
                <c:if test="${sessionScope.user_role==\"admin\"}">
                    <td>  </td>
                    <td>  </td>
                </c:if>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>

            <c:forEach items="${requestScope.specialities}" var="speciality">
                <tr>
                    <td>${speciality.id}</td>
                    <td>${speciality.speciality_name}</td>
                    <td>${speciality.recruitment_plan}</td>
                    <c:if test="${sessionScope.user_role==\"admin\"}">
                        <td>
                            <a href="Controller?command=edit_speciality&id=${speciality.id}">
                                Edit
                            </a>
                        </td>
                        <td>
                            <a href="Controller?command=delete_speciality&id=${speciality.id}">
                                X
                            </a>
                        </td>
                    </c:if>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
    <c:if test="${sessionScope.user_role==\"admin\"}">
        <hr>
        <a href="newspeciality.jsp">NEW SPECIALITY</a>
    </c:if>
</body>
</html>
