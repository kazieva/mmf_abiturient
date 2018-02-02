<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
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
            <h2 class="h"> Редактировать заявку</h2>
                <div class="inputForm">
                    <form method="POST" action="controller">
                        <input type="hidden" name="command" value="update_abiturient"/>
                        <br>
                        <input type="hidden" name="passport_id" value="${abiturient.passport_id}"/>
                        <input type="hidden" name="passport_series" value="${abiturient.passport_series}"/>
                        <p>
                            <input type="text" name="new_passport_series" value="${abiturient.passport_series}" placeholder="Серия паспорта"/>
                            <input type="number" name="new_passport_id" value="${abiturient.passport_id}" placeholder="Номер паспорта"/>
                        </p>
                        <p>
                            <input type="text" name="new_fname" value="${abiturient.fname}" placeholder="Имя"/>
                            <input type="text" name="new_sname" value="${abiturient.sname}" placeholder="Фамилия"/>
                            <input type="text" name="new_patronymic" value="${abiturient.patronymic}" placeholder="Отчество"/>
                        </p>
                        <p>
                            <input type="text" name="new_phone" name="new_phone" value="${abiturient.phone}" placeholder="Телефон"/>
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
                            <a href="Controller?command=delete_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}">
                               Удалить
                            </a>
                        </p>
                        <input type="submit" value="Изменить" />
                    </form>
                </div>
            </div>
            <hr>
        </main>
    </body>
</html>
