<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags" %>
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
            <div class="new_entity">
            <h1> New Abiturient</h1>
            <div class="inputForm">
                <form method="POST" action="controller">
                    <input type="hidden" name="command"  value="add_abiturient"/>
                    <br>
                    <p>
                        <input type="text" name="passport_series" required placeholder="Серия паспорта"/>
                        <input type="number" name="passport_id" required placeholder="Номер паспорта"/>
                    </p>
                    <p>
                        <input type="text" name="fname" required placeholder="Имя"/>
                        <input type="text" name="sname" required placeholder="Фамилия"/>
                        <input type="text" name="patronymic" placeholder="Отчество"/>
                    </p>
                    <p>
                        <input name="phone" name="phone" type="text" placeholder="Телефон"/>
                    </p>
                    <p>
                        <select  name="speciality">
                            <c:forEach items="${requestScope.specialities}" var="speciality">
                                <option>${speciality.speciality_name}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <input type="number" min = "15" max="100" size="5" name="math_certificate" required placeholder="math">
                        <input type="number" min = "15" max="100" size="5" name="physics_certificate" required placeholder="physics">
                        <input type="number" min = "20" max="100" size="5" name="language_certificate" required placeholder="language">
                        <input type="number" min = "0" max="100" size="5" name="school_certificate" required placeholder="school">
                    </p>
                    <input type="submit" class="button" value="Оформить" />
                </form>
            </div>
            </div>
            <hr>
            <section>
                <h1>All Abiturients</h1>
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <td>Total score</td>
                            <td>speciality ID</td>
                            <td>Sname</td>
                            <td>Fname</td>
                            <td>Siries</td>
                            <td>Passport</td>
                            <td>Phome</td>
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
                                            Edit
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
    </body>
</html>

