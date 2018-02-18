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
                    <input type="hidden" name="old_command" value="Controller?command=result_speciality"/>
                    <input class="langbuttonLeft" type="submit" name="lang" value="RU">
                    <input class="langbutton" type="submit" name="lang" value="EN">
                </form>
            </li>
        </ul>
    </nav>
        <main>
            <section>
                <h1>
                    <fmt:message key="message.allSpecielitiesTitle" bundle="${message}"/>
                </h1>
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <td><fmt:message key="message.specielitiesTableSpecialityID" bundle="${message}"/></td>
                                <td><fmt:message key="message.specielitiesTableSpecialityName" bundle="${message}"/></td>
                                <td><fmt:message key="message.specielitiesTableRecruitmentPlan" bundle="${message}"/></td>
                                <c:if test="${sessionScope.user_role==\"admin\"}">
                                    <td>  </td>
                                </c:if>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="tbl-spec-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <c:forEach items="${requestScope.specialities}" var="speciality">
                                <tr>
                                    <td>${speciality.id}</td>
                                    <td>${speciality.speciality_name}</td>
                                    <td>${speciality.recruitment_plan}</td>
                                    <c:if test="${sessionScope.user_role==\"admin\"}">
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
                    <a href="Controller?command=go_to_new_speciality" class="abutton"><fmt:message key="message.allSpecielitiesButtonNewSpeciality" bundle="${message}"/></a>
                </c:if>
        </main>
    </body>
</html>
