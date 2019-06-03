<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜덤 박스</title>
</head>
<body>
	<h2>랜덤 박스</h2>
	<h5>${message}</h5>
	<hr>
	<c:set var="path" value="${pageContext.request.contextPath }" />
		<form action="${path}/randomFood">
				나는 무엇을 먹어야 하오 &nbsp;<b><button type="submit">랜덤 푸드</button></b>
		</form>
		<br>	
		<form action="${path}/randomTravel">
				나는 어디로 가야하오 &nbsp;<b><button type="submit">랜덤 여행지</button></b>
		</form>
</body>
</html>