<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
<!-- 비동기방식 -->
<script>
function doF(){
	$.ajax({
			type : "post",
			url : "${path}/test/doF",
			success : function(result){
				$("#result").html("상품명 : " + result.name + "가격 : " + result.price);
				}
		})
}
</script>

</head>
<body>
<%@ include file="include/Menu.jsp" %>
<hr>
<!-- test를 클릭하고 controller에 갔다 test.jsp로 옴. 그리고 다시 do*를 클릭하면 다시 클릭에 맞는 주소로 controller로 들어가고 해당 페이지로 넘어감. -->
<h1> 링크 테스트</h1> 
<a href="${path}/test/doA"}>doA</a> <!-- (WEB-INF)직접접근이 불가능하기 때문에 컨트롤러를 통해서 접근해야된다.->MainController로  -->
<a href="${path}/test/doB"}>doB</a>
<a href="${path}/test/doC"}>doC</a>
<a href="${path}/test/doD"}>doD</a>
<a href="javascript:doF()">doF</a>
<div id="result">

</div>
</body>
</html>