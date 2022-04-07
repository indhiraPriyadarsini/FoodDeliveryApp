<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNIN</title>
</head>
<body>
<h2>Welcome!</h2>
<form action="/signin">
<label>FULL NAME</label>
<input type = "text" name="username" required><br><br>
<label>E-MAIL ID</label>
<input type = "text" name="email" required><br><br>
<label>PASSWORD</label>
<input type = "password" name="password" required><br><br>
<button type="submit">signIn</button>
</form>
</body>
</html>