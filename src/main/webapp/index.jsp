<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#column1 {
position:absolute;
left:50px;
top:80px;
}
#column2 {
position:absolute;
left:450px;
top:80px;
}
</style>
<title>第一個Servlet程式</title>
</head>
<body>

<h1 style="color:red"><!-- <a href="FirstSimpleProgram"> -->Hello Java!<!-- </a> --></h1><hr>
<div id="column1">
<a href="ch01/queryLottery.jsp">問明牌</a><br>
<a href="ch01/queryLottery2.jsp">問明牌2</a><br>
<a href="ch02/refreshTest.jsp">網頁般家了</a><br>
<a href="ch02/insertMemberForm.jsp">新增會員資料</a><br>
<a href="ch04_01/insertMemberForm.jsp">新增會員資料(MVC File IO)</a><br>
<a href="ch04_02/insertMemberForm.jsp">新增會員資料(MVC Dao)</a><br>
<a href="ch05_01/ProduceDataServlet">顯示ch05_01.ProduceDataServlet所產生的資料</a><br>
<a href="ch05_02/InputData.jsp">在JSP網頁中，使用EL可以讀取表單資料</a><br>
<a href="ch05_03/insertMemberForm.jsp">新增會員資料(錯誤訊息顯示)</a><br>
<a href="ch05_04/queryLottery.jsp">問明牌(由jsp設定bean)</a><br>
<a href="ch05_05/queryLottery.jsp">問明牌(由jstl設定bean)</a><br>
</div>
<div id="column2">
<a href="ch06_01/login.jsp">會員登入</a><br>
<a href="ch06_01/ShowMember.jsp">會員資料查詢</a><br>
<a href="ch06_01/logout.jsp">會員登出</a><br>
</div>
</body>
</html>