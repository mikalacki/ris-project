<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<form action="/Projekat/user/registerUser" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name_user"></td>
			</tr>
			<tr>
				<td>Lastname:</td>
				<td><input type="text" name="lastname_user"></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username_user"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password_user"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Sacuvaj"></td>
			</tr>
		</table>
	</form>

</body>
</html>