<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Lab05_03新增會員資料(錯誤資訊顯示於此頁)</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>

<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<form name="insertMemberFormA" action="member.do" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center">新增會員資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">帳號:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="mId" value="${param.mId}"
						type="text" size="14">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.id}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">密碼:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="pswd" value="${param.pswd}"
						type="password" size="14">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.password}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">姓名:</td>
					<td width="600" height="40" align="left"><input name="mName"
						value="${param.mName}" type="text" size="20">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.name}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">住址:</td>
					<td width="600" height="40" align="left"><input
						name="mAddress" value="${param.mAddress}" type="text" size="54">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.address}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">手機:</td>
					<td width="600" height="40" align="left"><input name="mPhone"
						value="${param.mPhone}" type="text" size="20"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">生日:</td>
					<td width="600" height="40" align="left"><input
						name="mBirthday" value="${param.mBirthday}" type="text" size="14"><font
						color='blue' size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font>
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.bday}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">體重:</td>
					<td width="600" height="40" align="left"><input name="mWeight"
						value="${param.mWeight}" type="text" size="14">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.weight}</div>
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>

			</tbody>
		</table>
		<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.exception}</div>
	</form>

</body>
</html>