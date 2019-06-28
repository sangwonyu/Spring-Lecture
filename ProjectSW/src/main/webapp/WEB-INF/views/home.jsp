<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 한글 설정 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<%@ include file="include/header.jsp"%>
<meta http-equiv="Content-type" content="text/html" charset="utf-8">
<script>
	function submitMethod(submit){
		if(submit=="login"){
			document.submitForm.action="/projectSW/login.do";
		} else if(submit=="join") {
			document.submitForm.action="/projectSW/join.do";
		}
		document.submitForm.submit();
		
	}
</script>
</head>
<body>
	<h1>
		<div align="center">로그인을 하세요</div>
	</h1>
	<hr>
	path : ${path}
	<div align="center">${message}</div>
	<form name="submitForm" method="post">
		<table align="center">
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="로그인" onclick="submitMethod('login')" /> 
					<input type="button" value="회원가입" onclick="submitMethod('join')" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
