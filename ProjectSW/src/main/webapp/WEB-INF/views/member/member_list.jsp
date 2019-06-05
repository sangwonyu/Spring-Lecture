<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<h2 align="center">회원 목록</h2>
	<table border="1" width="700px" align="center">
		<tr>
			<td>아이디</td>
			<td>이 름</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.userid}</td>
				<td><a href="${path}/member/detail.do?userid=${row.userid}">${row.name}</a></td>
				<td>${row.email}</td>
				<td> <fmt:formatDate value="${row.join_date}" pattern="YYYY-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>