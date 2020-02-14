<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 출력</title>
</head>
<body>
	<%
		//request 나 session에 저장된 attribute를 출력하기 위해서는
		//읽어와서 출력
		Object msg = request.getAttribute("msg");
		out.println("<p>" + msg + "</p>");
	%>
	
	<p>${msg}</p>
	<p>초기화 파라미터:${initParam.db}</p>
</body>
</html>






