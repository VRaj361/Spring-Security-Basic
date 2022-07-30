<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="verify" method="post">
		<h3>Email id : </h3>
		<input type="text" name="email" />
		
		<h3>Password : </h3>
		<input type="text" name="password" />
		
		<input type="submit" value="submit here"  />
		<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"/>
	</form>
</body>
</html>