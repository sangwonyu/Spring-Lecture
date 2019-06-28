<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<h1 align="center">회원 가입</h1>
	<hr>
	<form name="join" method="post" action="${path}/joinMember.do">
		<table align="center">
			<br>
			<tr>
				<td colspan="2" align="center" style="color:red"><b>< ${message} ></b></td>
			</tr>
			<tr> </tr>
			<tr>
				<td>아이디  : </td>
				<td><input type="text"  name="userid" placeholder="아이디를 입력하세요"/></td>
			</tr>
			<tr><td> </td></tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password"  name="passwd" placeholder="비밀번호를 입력하세요"/></td>
			</tr>
			<tr><td> </td></tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text"  name="name" placeholder="이름을 입력하세요"/></td>
			</tr>
			<tr><td> </td></tr>
			<tr>
				<td>기수 : </td>
				<td><input type="text" name="inception" placeholder="기수를 입력하세요"/></td>
			</tr>
			<tr><td> </td></tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="회원가입"/></td>
			</tr>
		</table>
	</form>
</body>
</html>