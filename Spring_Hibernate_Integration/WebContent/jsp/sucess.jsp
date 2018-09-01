<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

		<script type="text/javascript">
	
		function addData()
		{
			
			document.details.action="register";
			document.details.submit();
			
		}
		
		
		function DeleteData()
		{
			var id = document.getElementById("id");
			
			alert(id);
			
			document.details.action="deleteCurrentData";
			document.details.submit();
		}
		
		function UpdateData()
		{
			
			document.details.action="editCurrentData";
			document.details.submit();
		}
	
	</script>

	

</head>
<body>
<form name="details">
<center>
	<table border="1" height="50%" width="50%">
	
	<tr>
		<th>select</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>User Name</th>
		<th>User Pass</th>
	</tr>


	<c:forEach items="${data}" var="stu">
	<%{ %>
	
		<tr>
			<td><input type="radio" name="id" value="${stu.id}"></td>
			<td><c:out value="${stu.fname}"></c:out></td>
			<td><c:out value="${stu.lname}"></c:out></td>
			<td><c:out value="${stu.uname}"></c:out></td>
			<td><c:out value="${stu.upass}"></c:out></td>
	</tr>
	
	
	<%} %>
		
	</c:forEach>
	</table>
<%-- 	 <a href="getCurrentData/${stu.id}"><input type="button"  value="update"></a>
	 <a href="getCurrentDatasec"><input type="button" value="update 2"></a>
 --%>	
 <input type="button" value="add" onclick="return addData()">
	<input type="button" value="delete" onclick="return DeleteData()">
	 <input type="button" value="update" onclick="return UpdateData()">
	 
	 
</center>
</form>
</body>
</html>