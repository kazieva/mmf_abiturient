<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Информация о пользователе</h2>
    <table >
        <tr>
            <td>Логин</td>
            <td>Пароль</td>
            <td>ключ</td>
            <td>Имя</td>
            <td>Фамилия</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
        <tr>
             <td>${user.login}</td>
             <td>${user.password}</td>
             <td>${user.key}</td>
             <td>${user.fname}</td>
             <td>${user.sname}</td>
        </tr>
        </c:forEach>
    </table>
    <h2 class="h"> Заполнить заявку</h2>
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
    <div>
        <H2>Таблица подавших документы</H2>
        <table >
            <tr>

                <td>Общий балл</td>
                <td>ID специальности</td>
                <td>Фамилия</td>
                <td>Имя</td>
                <td>Серия </td>
                <td>Номер паспорта</td>
                <td>телефон</td>
                   <td>  </td>
                </tr>
                <c:forEach items="${requestScope.abiturients}" var="abiturient">
                    <tr><td>${abiturient.math_certificate+abiturient.physics_certificate+abiturient.language_certificate+abiturient.school_certificate}</td>
                        <td>${abiturient.speciality_id}</td>
                        <td>${abiturient.sname}</td>
                        <td>${abiturient.fname}</td>
                        <td>${abiturient.passport_series}</td>
                        <td>${abiturient.passport_id}</td>
                        <td>${abiturient.phone}</td>

                        <td><a href="Controller?command=delete_abiturient&passport_id=${abiturient.passport_id}&passport_series=${abiturient.passport_series}">
                            X
                        </a> </td>
                    </tr>
                </c:forEach>
            </table>
        <hr>
    </div>

</table>
</body>
</html>
