<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 삽입화면</title>
</head>
<body>
	<!-- 최근에는 form을 만들 때 무조건 post 방식으로 action을 설정하지 않습니다.
	action을 설정하지 않으면 기존 URL을 그대로 사용 
	작업이 1가지인데 단지 과정이 2가지라서 서로 다른 URL을 2개 사용하지 않도록 하는 것을 권장-->
	<form method="post" id="itemform">
		<label for="num">번호</label>
		<input type="number" name="num" id="num"/><br/>
		
		<label for="name">이름</label>
		<input type="text" name="name" id="name"/><br/>
		
		<label for="price">가격</label>
		<input type="number" name="price" id="price"/><br/>
		
		<label for="manufacture">원산지</label>
		<input type="text" name="manufacture" id="manufacture"/><br/>
		
		<label for="description">보충설명</label>
		<input type="text" name="description" id="description"/><br/>
		
		<input type="submit" value="데이터 삽입"/>
		
	
	</form>
</body>
</html>






