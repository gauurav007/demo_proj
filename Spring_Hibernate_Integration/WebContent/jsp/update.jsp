<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
	 <form action="update">
	 
	 	Student Id:<input type="text" name="id" value="${data.id}"><br><br>
	 	
	 	First Name:<input type="text" name="fname" value="${data.fname}"><br><br>
	 	
	 	Last Name:<input type="text" name="lname" value="${data.lname}"><br><br>
	 	
	 	User Name:<input type="text" name="uname" value="${data.uname}"><br><br>
	 	
	 	User Pass:<input type="text" name="upass" value="${data.upass}"><br><br>
	 	
	 	<input type="submit" value="update">
	 
	 </form>
	</center>

</body>
</html>