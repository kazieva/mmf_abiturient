<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <div class="new_speciality">
            <h2 class="h"> NEW SPECIALITY</h2>
            <div class="inputForm">
                <form method="POST" action="controller">
                    <input type="hidden" name="command" value="add_speciality"/>
                    <br>
                    <p>
                        <input type="number" name="id" min = "1" required placeholder="Speciality id"/>
                    </p>
                    <p>

                        <input type="text" name="en_speciality_name" required placeholder="Name on english"/>
                    </p>
                    <p>
                        <input type="text" name="ru_speciality_name" required placeholder="Name on russial"/>
                    </p>
                    <p>
                        <input type="number"size="5" min = "1" name="recruitment_plan"  required placeholder="recruitment plan">
                    </p>
                    <input type="submit" class="button" value="Add speciality" />
                </form>
            </div>
            </div>
        </main>
    </body>
</html>
