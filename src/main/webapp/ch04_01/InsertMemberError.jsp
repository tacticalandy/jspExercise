<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab04_01</title>
</head>
<body>
	<h1>會員資料新增失敗</h1>
	<!-- 如果識別字串ErrorMsg所對應的屬性物件不是空的 -->
	<c:if test="${not empty ErrorMsg}">
		<font color="red">請修改下列錯誤:
			<ul>
				<!-- 將識別字串ErrorMsg所對應的屬性物件之內的物件「依序取出」，放入變數aMsg中 -->
				<c:forEach var="aMsg" items="${ErrorMsg}">
					<!-- 將變數aMsg的內含值顯示出來 -->
					<li>${aMsg}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>
	<br><a href="../index.jsp">回首頁</a>
</body>
</html>