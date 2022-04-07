<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
<form action = "/login" method="post" > 
<label>EMAIL</label><br>
<input type = "email" name="email" required><br><br>
<label>PASSWORD</label><br>
<input type = "password" name="password" required><br><br>
<button type="submit"> Login</button>
</form>
</body>
</html>