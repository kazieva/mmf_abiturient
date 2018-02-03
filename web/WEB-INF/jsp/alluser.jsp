<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>MMF</title>
        <style>
            <%@include file='../../jsp/css/style.css' %>
            <%@include file='../../jsp/css/menu.css' %>
         </style>
    </head>
    <body>
        <nav class="menu" tabindex="0">
            <div class="smartphone-menu-trigger"></div>
            <div class="avatar">
                <img src="https://st03.kakprosto.ru//images/article/2011/9/16/1_52552c35c5b0852552c35c5b46.png"/>
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
                <div class="tbl-user-content">
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
                <a href="Controller?command=go_to_registration" class="abutton">
                    Registrate new user
                </a>
            </c:if>
        </main>
    </body>
</html>