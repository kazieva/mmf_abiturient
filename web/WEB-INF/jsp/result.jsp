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
                        <input type="hidden" name="old_command" value="Controller?command=result"/>
                        <input class="langbuttonLeft" type="submit" name="lang" value="RU">
                        <input class="langbutton" type="submit" name="lang" value="EN">
                    </form>
                </li>
            </ul>
        </nav>
        <main>
            <div class="new_entity">
                <h1>
                    <fmt:message key="message.abiturientNewAbiturientTitle" bundle="${message}"/>
                </h1>
                <div class="inputForm">
                    <form method="POST" action="controller">
                        <input type="hidden" name="command"  value="add_abiturient"/>
                        <br>
                        <p>
                            <input type="text" name="passport_series" id="passport_series" required placeholder="<fmt:message key="message.abiturientPassportSeries" bundle="${message}"/>"/>
                            <input type="number" min = "1000000" name="passport_id" id="passport_id" required placeholder="<fmt:message key="message.abiturientPassportId" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <input type="text" name="sname" id="sname" required placeholder="<fmt:message key="message.abiturientSname" bundle="${message}"/>"/>
                            <input type="text" name="fname" id="fname" required placeholder="<fmt:message key="message.abiturientFname" bundle="${message}"/>"/>
                            <input type="text" name="patronymic" id="patronymic" placeholder="<fmt:message key="message.abiturientPartonymic" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <input name="phone" name="phone" id="phone" type="text" placeholder="<fmt:message key="message.abiturientPhone" bundle="${message}"/>"/>
                        </p>
                        <p>
                            <select  name="speciality">
                                <c:forEach items="${requestScope.specialities}" var="speciality">
                                    <option>${speciality.speciality_name}</option>
                                </c:forEach>
                            </select>
                        </p>
                        <p>
                            <input type="number" min = "15" max="100" size="5" name="math_certificate" id="math_certificate" required placeholder="<fmt:message key="message.abiturientMath" bundle="${message}"/>">
                            <input type="number" min = "15" max="100" size="5" name="physics_certificate" id="physics_certificate" required placeholder="<fmt:message key="message.abiturientPhysics" bundle="${message}"/>">
                            <input type="number" min = "20" max="100" size="5" name="language_certificate" id="language_certificate" required placeholder="<fmt:message key="message.abiturientLang" bundle="${message}"/>">
                            <input type="number" min = "0" max="100" size="5" name="school_certificate" id="school_certificate" required placeholder="<fmt:message key="message.abiturientSchoolCertificate" bundle="${message}"/>">
                        </p>
                        <input type="submit" class="button" onclick="return validateAbiturient()"  value="<fmt:message key="message.abiturientButtonAddAbiturient" bundle="${message}"/>" />
                    </form>
                    ${abiturientError}
                </div>
            </div>
            <hr>
            <section>
                <h1>
                    <fmt:message key="message.abiturientTableTitle" bundle="${message}"/>
                </h1>
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <td><fmt:message key="message.abiturientTableTotalScore" bundle="${message}"/></td>
                            <td><fmt:message key="message.abiturientTableSpecialityId" bundle="${message}"/></td>
                            <td><fmt:message key="message.abiturientTableSname" bundle="${message}"/></td>
                            <td><fmt:message key="message.abiturientTablrFname" bundle="${message}"/></td>
                            <td><fmt:message key="message.abiturientTableSeries" bundle="${message}"/></td>
                            <td><fmt:message key="message.abiturientPassportId" bundle="${message}"/></td>
                            <td><fmt:message key="message.abiturientPhone" bundle="${message}"/></td>
                            <td>  </td>
                            <td>  </td>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <c:forEach items="${requestScope.abiturients}" var="abiturient">
                                <tr><td>${abiturient.math_certificate+abiturient.physics_certificate+abiturient.language_certificate+abiturient.school_certificate}</td>
                                    <td>${abiturient.speciality_id}</td>
                                    <td>${abiturient.sname}</td>
                                    <td>${abiturient.fname}</td>
                                    <td>${abiturient.passport_series}</td>
                                    <td>${abiturient.passport_id}</td>
                                    <td>${abiturient.phone}</td>
                                    <td>
                                        <a href="Controller?command=edit_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}">
                                            <fmt:message key="message.editButton" bundle="${message}"/>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="Controller?command=delete_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}">
                                            x
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
        </main>
        <script type="text/javascript">
            <%@include file='../../jsp/js/index.js' %>
        </script>
    </body>
</html>

