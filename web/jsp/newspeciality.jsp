<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="h"> Заполнить заявку</h2>
<div class="inputForm">
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="add_speciality"/>
        <br>
        <p>
            <input type="number" name="id" placeholder="Speciality id"/>
        </p>
        <p>
           Name on english
            <input type="text" name="en_speciality_name" placeholder=""/>
            Name on russial
            <input type="text" name="ru_speciality_name" placeholder=""/>
        </p>
        <p>
            recruitment plan
            <input type="number"size="5" min = "1" name="recruitment_plan" required placeholder="">
        </p>
        <input type="submit" value="Add speciality" />
    </form>
</div>

</body>
</html>
