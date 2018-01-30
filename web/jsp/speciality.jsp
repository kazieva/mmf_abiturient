<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table > Специальности
        <tr>

            <td>ID специальности</td>
            <td>Название</td>
            <td>План приема</td>
            <td>  </td>
            <td>  </td>
        </tr>
        <c:forEach items="${requestScope.specialities}" var="speciality">

                <td>${speciality.id}</td>
                <td>${speciality.speciality_name}</td>
                <td>${speciality.recruitment_plan}</td>
                <td>
                    <a href="Controller?command=edit_speciality&id=${speciality.id}">
                        Edit
                    </a>
                </td>
                <td>
                    <a href="Controller?command=delete_speciality&id=${speciality.id}">
                        X
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <hr>

</body>
</html>
