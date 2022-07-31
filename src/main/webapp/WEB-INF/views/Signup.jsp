<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Signup</h1>
	<form action="saveuser" method="post">
		username :<input type="text" name="username"></input><br>
		fname:<input type="text" name="fname"></input><br>
		password<input type="text" name="password"></input><br>
		<input type="submit">Submit</input>
		<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"/>
		
	</form>
</body>
</html>