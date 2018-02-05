<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags" %>
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
                <li>
                    <form name="lang" method="post" action="controller">
                        <input type="hidden" name="command" value="locale"/>
                        <input type="hidden" name="old_command" value="Controller?command=result"/>
                        <input type="submit" name="lang" value="RU">
                        <input type="submit" name="lang" value="EN">
                    </form>
                </li>
            </ul>
        </nav>
        <main>
            <div class="new_entity">
            <h1> Edit abiturient</h1>
                <div class="inputForm">
                    <form method="POST" action="controller">
                        <input type="hidden" name="command" value="update_abiturient"/>
                        <br>
                        <input type="hidden" name="passport_id" required value="${abiturient.passport_id}"/>
                        <input type="hidden" name="passport_series" required value="${abiturient.passport_series}"/>
                        <p>
                            <input type="text" name="new_passport_series" value="${abiturient.passport_series}" required placeholder="Серия паспорта"/>
                            <input type="number" name="new_passport_id" value="${abiturient.passport_id}" required placeholder="Номер паспорта"/>
                        </p>
                        <p>
                            <input type="text" name="new_fname" value="${abiturient.fname}" required placeholder="Имя"/>
                            <input type="text" name="new_sname" value="${abiturient.sname}" required placeholder="Фамилия"/>
                            <input type="text" name="new_patronymic" value="${abiturient.patronymic}" placeholder="Отчество"/>
                        </p>
                        <p>
                            <input type="text" name="new_phone" required name="new_phone" value="${abiturient.phone}" placeholder="Телефон"/>
                        </p>
                        <p>
                            <select  name="new_speciality">
                                <c:forEach items="${requestScope.specialities}" var="speciality">
                                    <option>${speciality.speciality_name}</option>
                                </c:forEach>
                            </select>
                        </p>
                        <p>
                            <input type="number" min = "15" max="100" size="5" name="new_math_certificate" value="${abiturient.math_certificate}" required placeholder="балл по математике">
                            <input type="number" min = "15" max="100" size="5" name="new_physics_certificate" value="${abiturient.physics_certificate}" required placeholder="балл по физике">
                            <input type="number" min = "20" max="100" size="5" name="new_language_certificate" value="${abiturient.language_certificate}" required placeholder="балл по языку">
                            <input type="number" min = "0" max="100" size="5" name="new_school_certificate" value="${abiturient.school_certificate}" required placeholder="балл аттестата">
                        </p>
                        <p>
                            <a href="Controller?command=delete_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}" class="abutton">
                               Удалить
                            </a>
                        </p>
                        <input type="submit" class="button" value="Изменить" />
                    </form>
                </div>
            </div>
            <hr>

        </main>
    </body>
</html>
