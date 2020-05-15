<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="myBean" class="ch05_04.LotteryBean" scope="page">
	<jsp:setProperty name="myBean" property="lowerBound" value="1" />
	<jsp:setProperty name="myBean" property="upperBound" value="49" />
	<jsp:setProperty name="myBean" property="ballNumber" value="6" />
</jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>發明牌Lab05_04</title>
</head>
<body>
	<h2>求籤</h2>
	${param.visitor}，您好，<br>
	 您的明牌為： <jsp:getProperty property="luckyNumbers" name="myBean"/><br>
</body>
</html>