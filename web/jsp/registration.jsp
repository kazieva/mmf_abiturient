<%--
  Created by IntelliJ IDEA.
  User: YiaKrevetko
  Date: 31.01.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="registration"/>
        Login:<br/>
        <input type="text" name="login" value=""/>
        <br/>
        Pass:<br/>
        <input type="password" name="password" value=""/>
        <br/>
        Key:<br/>
        <input type="password" name="key" value="" />
        <br/>
        Name:<br/>
        <input type="text" name="fname" value=""/>
        <br/>
        Surname:<br/>
        <input type="text" name="sname" value=""/>
        <br/>
        <input type="submit" value="Registrate"/>
    </form>
</head>
<body>

</body>
</html>
