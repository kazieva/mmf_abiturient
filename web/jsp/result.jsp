<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MMF</title>
    <style>
    <%@include file='css/style.css' %>
</style>

</head>

<body>

<a  href="Controller?command=result">
    Abiturients
</a>
<a href="Controller?command=result_speciality">
    Specialities
</a>
<hr>
<c:if test="${sessionScope.user_role==\"admin\"}">
    <a href="Controller?command=go_to_registration">
        registration new user
    </a>

    <a href="Controller?command=all_users">
        all users
    </a>
</c:if>
<a href="Controller?command=logout">
    logout
</a>


<h1> New Abiturient</h1>
<div class="inputForm">
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="add_abiturient"/>
        <br>
        <p>
            <input type="text" name="passport_series" placeholder="Серия паспорта"/>
            <input type="number" name="passport_id" placeholder="Номер паспорта"/>
        </p>
        <p>
            <input type="text" name="fname" placeholder="Имя"/>
            <input type="text" name="sname" placeholder="Фамилия"/>
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
            <input type="number" min = "15" max="100" size="5" name="math_certificate" required placeholder="балл по математике">
            <input type="number" min = "15" max="100" size="5" name="physics_certificate" required placeholder="балл по физике">
            <input type="number" min = "20" max="100" size="5" name="language_certificate" required placeholder="балл по языку">
            <input type="number" min = "0" max="100" size="5" name="school_certificate" required placeholder="балл аттестата">
        </p>
        <input type="submit" value="Оформить" />
    </form>
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
                            X
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

</body>

</html>

