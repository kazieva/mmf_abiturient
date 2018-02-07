<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources.message" var="message"/>
<html>
    <head>
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
                        <input type="hidden" name="old_command" value="Controller?command=go_to_new_speciality"/>
                        <input class="langbuttonLeft" type="submit" name="lang" value="RU">
                        <input class="langbutton" type="submit" name="lang" value="EN">
                    </form>
                </li>
            </ul>
        </nav>
        <main>
            <div class="new_speciality">
                <h2 class="h">
                    <fmt:message key="message.allSpecielitiesButtonNewSpeciality" bundle="${message}"/>
                </h2>
                <div class="inputForm">
                    <form method="POST" action="controller">
                        <input type="hidden" name="command" value="add_speciality"/>
                        <br>
                        <p>
                            <input type="number" name="id" min = "1" required placeholder="<fmt:message key="message.specielitiesSpecialityID" bundle="${message}"/>"/>
                        </p>
                        <p>

                            <input type="text" name="en_speciality_name" required placeholder="<fmt:message key="message.newSpecialityEnglishName" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <input type="text" name="ru_speciality_name" required placeholder="<fmt:message key="message.newSpecialityRussianName" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <input type="number"size="5" min = "1" name="recruitment_plan"  required placeholder="<fmt:message key="message.specielitiesTableRecruitmentPlan" bundle="${message}"/>">
                        </p>
                        <input type="submit" class="button" value="<fmt:message key="message.newSpecialityButton" bundle="${message}"/>" />
                    </form>
                </div>
            </div>
        </main>
    </body>
</html>
