<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>MMF</title>
        <style>
            <%@include file='css/style.css' %>
            <%@include file='css/menu.css' %>
        </style>
    </head>
    <body>
        <nav class="menu" tabindex="0">
            <div class="smartphone-menu-trigger"></div>
            <div class="avatar">
                <img src="https://st03.kakprosto.ru//images/article/2011/9/16/1_52552c35c5b0852552c35c5b46.png" />
                <h2>${sessionScope.user.fname}</h2>
                <h>${sessionScope.user.role}</h>
            </div>
            <ul>
                <a href="Controller?command=result">
                    <li tabindex="0" class="icon-dashboard">
                        <span>Abiturients</span>
                    </li>
                </a>
                <a href="Controller?command=result_speciality" >
                    <li tabindex="0" class="icon-customers" >
                        <span>Specialities</span>
                    </li>
                </a>
                <c:if test="${sessionScope.user_role==\"admin\"}">
                    <a href="Controller?command=all_users">
                        <li tabindex="0" class="icon-users">
                            <span>Users</span>
                        </li>
                    </a>
                    <a href="Controller?command=go_to_registration">
                        <li tabindex="0" class="icon-settings">
                            <span>New user</span>
                        </li>
                    </a>
                </c:if>
                <a  href="Controller?command=logout">
                    <li tabindex="0" class="icon-logout">
                        <span>logout</span>
                    </li>
                </a>
            </ul>
        </nav>
        <main>
            <section>
                <h1>All Specialities</h1>
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
                                                x
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
                <a href="/jsp/newspeciality.jsp">NEW SPECIALITY</a>
            </c:if>
        </main>
    </body>
</html>
