<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class=''>
    <head>
        <style>
            <%@include file='css/login.css' %>
        </style>
    </head>
    <body>
        <div class="login">
            <div class="wrap">
                <div class="content">
                    <div id="slideshow">
                        <div class="one">
                            <h2>
                                <span>MMM BSU</span>
                            </h2>
                            <p>Log in to get started</p>
                        </div>
                    </div>
                </div>
                <div class="user">
                    <div class="form-wrap">
                        <div class="tabs">
                            <h3 class="login-tab">
                                <a class="log-in active" href="login.jsp">
                                    <span>Login</span>
                                </a>
                            </h3>
                        </div>
                        <div class="tabs-content">
                            <div id="login-tab-content" class="active">
                                <form class="login-form" method="POST" action="controller">
                                    <input type="hidden" name="command" value="login" />
                                    <input type="text" class="input" id="user_login" autocomplete="off" name="login" placeholder="Email or Username">
                                    <input type="password" class="input" id="user_pass" autocomplete="off" name="password" placeholder="Password">
                                    <input type="password" class="input" id="user_key" autocomplete="off" name="key" placeholder="Key">
                                    <input type="submit" class="button" value="Login">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>