<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL의 core 기능을 사용하기 위한 태그 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!-- 변수 만들기 -->
<c:set var="num" value="200" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${num}</p>
	<c:if test="${num > 100}">
		<p>크다</p>
	</c:if>
	<c:if test="${num <= 100}">
		<p>작다</p>
	</c:if>
	
	<!-- num이 100이면 실패 200이면 성공 -->
	<c:choose>
		<c:when test="${num==100}">
			<p>성공</p>
		</c:when>
		<c:when test="${num==200}">
			<p>실패</p>
		</c:when>
	</c:choose>	
	
	<div>수량<select name="cnt">
		<c:forEach var="cnt" begin="1" end="100" step="1">
			<option value="${cnt}">${cnt}</option>
		</c:forEach>
	</select></div>	
	<div>수량<select name="cnt">
		<c:forEach var="cnt" begin="1" end="100" step="1">
			<option value="${100-cnt}">${100-cnt}</option>
		</c:forEach>
	</select></div>	
</body>
</html>










