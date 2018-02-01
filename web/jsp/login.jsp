<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="login" />
        Login:<br/>
        <input type="text" name="login" value=""/>
        <br/>
        Pass:<br/>
        <input type="password" name="password" value=""/>
        <br/>
        Key:<br/>
        <input type="password" name="key" value="" />
        <br/>
        <input type="submit" value="Log in"/>
    </form>
</body>
</html>
