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
	<%@ include file="../include/menu.jsp"%>
	<h2>회원 목록</h2>
	<input type="button" value="회원 등록" 
		onclick="location.href='${path}/member/write.do'"> <!-- 컨트롤러를 걷혀서 가야됨. 아니면 접근을 못함 따라서 컨트롤러에 작성, 싱글쿼터 주의 -->
	<table border="1" width="700px">
		<tr>
			<td>아이디</td>
			<td>이 름</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.userid}</td>
				<td><a href="${path}/member/view.do?userid=${row.userid}">${row.name}</a></td>
				<td>${row.email}</td>
				<td> <fmt:formatDate value="${row.join_date}" pattern="YYYY-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>