<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources.message" var="message"/>
<html>
<html class=''>
    <head>
         <style>
                <%@include file='../../jsp/css/login.css' %>
                <%@include file='../../jsp/css/menu.css' %>
         </style>
    </head>
    <body>
        <div class="login">
            <div class="wrap">
                <div class="user">
                    <div class="form-wrap">
                        <div class="tabs">
                            <h3 class="login-tab">
                                <a class="log-in active" href="/    ">
                                    <span>
                                        <fmt:message key="message.registration" bundle="${message}"/>
                                    </span>
                                </a>
                            </h3>
                        </div>
                        <div class="tabs-content">
                            <div id="login-tab-content" class="active">
                                <form class="login-form" method="POST" action="controller">
                                    <input type="hidden" name="command" value="registration"/>
                                    <input type="text" class="input" id="user_login" autocomplete="off" name="login" required placeholder="<fmt:message key="message.registrationLogin" bundle="${message}"/>">
                                    <input type="password" class="input" id="user_pass" autocomplete="off" name="password" required placeholder="<fmt:message key="message.passwordPlaceholder" bundle="${message}"/>">
                                    <input type="password" class="input" id="user_key" autocomplete="off" name="key" required placeholder="<fmt:message key="message.keyPlaceholder" bundle="${message}"/>">
                                    <input type="text" class="input" id="user_fname" name="fname" required placeholder="<fmt:message key="message.usersFName" bundle="${message}"/>"/>
                                    <input type="text" class="input" id="user_sname" name="sname" required placeholder="<fmt:message key="message.usersSname" bundle="${message}"/>"/>
                                    <input type="submit" class="button" onclick="return validateRegistrationForm()" value="<fmt:message key="message.registrate" bundle="${message}"/>">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            <%@include file='../../jsp/js/index.js' %>
        </script>
    </body>
</html>
