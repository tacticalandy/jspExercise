<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>即將跳轉頁面</title>
</head>
<body>

<%
	int s = 5;
	response.setHeader("Refresh", s +";URL=http://localhost:8080/jspExercise/ch06_01/login.jsp");
%>

尚未登入，您的瀏覽器將在<%= s %>秒後自動前往登入畫面<br>

</body>
</html>