<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Menu</title>
</head>
<body>

	<form action="/Projekat/foodMenu/showFoodMenu" method="get">
		<c:forEach var = "menu">
			<c:out value = "${menu.mealName}"></c:out>
		</c:forEach>
		<input type="submit" value="prikazi">
	</form>

</body>
</html>