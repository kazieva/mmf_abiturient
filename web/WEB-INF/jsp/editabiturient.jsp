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
                        <input type="hidden" name="old_command" value="Controller?command=edit_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}"/>
                        <input class="langbuttonLeft" type="submit" name="lang" value="RU">
                        <input class="langbutton" type="submit" name="lang" value="EN">
                    </form>
                </li>
            </ul>
        </nav>
        <main>
            <div class="new_entity">
                <h1>
                    <fmt:message key="message.editAbiturientTitle" bundle="${message}"/>
                </h1>
                <div class="inputForm">
                    <form method="POST" action="controller">
                        <input type="hidden" name="command" value="update_abiturient"/>
                        <br>
                        <input type="hidden" name="passport_id" required value="${abiturient.passport_id}"/>
                        <input type="hidden" name="passport_series" required value="${abiturient.passport_series}"/>
                        <p>
                            <input type="text" name="new_passport_series" value="${abiturient.passport_series}" required placeholder="Серия паспорта"placeholder="<fmt:message key="message.abiturientPassportSeries" bundle="${message}"/>"/>
                            <input type="number" name="new_passport_id" value="${abiturient.passport_id}" required placeholder="<fmt:message key="message.abiturientPassportId" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <input type="text" name="new_fname" value="${abiturient.fname}" required placeholder="<fmt:message key="message.abiturientFname" bundle="${message}"/>"/>
                            <input type="text" name="new_sname" value="${abiturient.sname}" required placeholder="<fmt:message key="message.abiturientSname" bundle="${message}"/>"/>
                            <input type="text" name="new_patronymic" value="${abiturient.patronymic}" placeholder="<fmt:message key="message.abiturientPartonymic" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <input type="text" name="new_phone" required name="new_phone" value="${abiturient.phone}" placeholder="<fmt:message key="message.abiturientPhone" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <select  name="new_speciality">
                                <c:forEach items="${requestScope.specialities}" var="speciality">
                                    <option>${speciality.speciality_name}</option>
                                </c:forEach>
                            </select>
                        </p>
                        <p>
                            <input type="number" min = "15" max="100" size="5" name="new_math_certificate" value="${abiturient.math_certificate}" required placeholder="<fmt:message key="message.abiturientMath" bundle="${message}"/>">
                            <input type="number" min = "15" max="100" size="5" name="new_physics_certificate" value="${abiturient.physics_certificate}" required placeholder="<fmt:message key="message.abiturientPhysics" bundle="${message}"/>">
                            <input type="number" min = "20" max="100" size="5" name="new_language_certificate" value="${abiturient.language_certificate}" required placeholder="<fmt:message key="message.abiturientLang" bundle="${message}"/>">
                            <input type="number" min = "0" max="100" size="5" name="new_school_certificate" value="${abiturient.school_certificate}" required placeholder="<fmt:message key="message.abiturientSchoolCertificate" bundle="${message}"/>">
                        </p>
                        <p>
                            <a href="Controller?command=delete_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}" class="abutton">
                            <fmt:message key="message.editAbiturientButtonDelete" bundle="${message}"/>
                            </a>
                        </p>
                        <input type="submit" class="button" value="<fmt:message key="message.editAbiturientButtonUpdate" bundle="${message}"/>" />
                    </form>
                </div>
            </div>
            <hr>

        </main>
    </body>
</html>
