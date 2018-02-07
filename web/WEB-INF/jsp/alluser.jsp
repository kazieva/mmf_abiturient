<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources.message" var="message"/>
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
                <user:GetUser/>
            </div>
            <ul>
                <a href="Controller?command=result">
                    <li tabindex="0" class="icon-dashboard">
                            <span>
                                <fmt:message key="message.menuAbiturients" bundle="${message}"/>
                            </span>
                    </li>
                </a>
                <a href="Controller?command=result_speciality" >
                    <li tabindex="0" class="icon-customers" >
                            <span>
                                <fmt:message key="message.menuSpecialities" bundle="${message}"/>
                            </span>
                    </li>
                </a>
                <c:if test="${sessionScope.user_role==\"admin\"}">
                    <a href="Controller?command=all_users">
                        <li tabindex="0" class="icon-users">
                                <span>
                                <fmt:message key="message.menuUsers" bundle="${message}"/>
                            </span>
                        </li>
                    </a>
                    <a href="Controller?command=go_to_registration">
                        <li tabindex="0" class="icon-settings">
                                <span>
                                <fmt:message key="message.menuNewUser" bundle="${message}"/>
                            </span>
                        </li>
                    </a>
                </c:if>
                <a  href="Controller?command=logout">
                    <li tabindex="0" class="icon-logout">
                            <span>
                                <fmt:message key="message.menuLogout" bundle="${message}"/>
                            </span>
                    </li>
                </a>
                <li>
                    <form name="lang" method="post" action="controller">
                        <input type="hidden" name="command" value="locale"/>
                        <input type="hidden" name="old_command" value="Controller?command=all_users"/>
                        <input class="langbuttonLeft" type="submit" name="lang" value="RU">
                        <input class="langbutton" type="submit" name="lang" value="EN">
                    </form>
                </li>
            </ul>
        </nav>
        <main>
            <section>
                <h1>
                    <fmt:message key="message.usersTitle" bundle="${message}"/>
                </h1>
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <td><fmt:message key="message.usersSname" bundle="${message}"/></td>
                            <td><fmt:message key="message.usersFName" bundle="${message}"/></td>
                            <td><fmt:message key="message.usersRole" bundle="${message}"/></td>
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
                                            <fmt:message key="message.usersUpdateRole" bundle="${message}"/>
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
                    <fmt:message key="message.usersRegistateNewUser" bundle="${message}"/>
                </a>
            </c:if>
        </main>
    </body>
</html>