<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <c:if test="${sessionScope.user_role==\"admin\"}">
      <jsp:forward page="/WEB-INF/jsp/emptypage.jsp"></jsp:forward>
    </c:if>
    <jsp:forward page="/jsp/login.jsp"></jsp:forward>
  </body>
</html>