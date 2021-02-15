<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="database.connection.com.DBConnection,com.javatpoint.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users List</h1>

<%
List<MobileUser> list=DBConnection.getAllRecords();
request.setAttribute("list",list);
%>

<table border="1" width="90%">
<tr><th>FirstName</th><th>LastName</th><th>Email</th><th>password</th><th>Mobile</th><th>Price</th></tr>
<c:forEach items="${list}" var="mu">
	<tr><td>${mu.getFname()}</td><td>${mu.getLname()}</td><td>${mu. getM_email()}</td><td>${mu.getM_pass()}</td><td>${mu.getMobile()}</td><td><a href="editform.jsp?m_email=${mu.getM_email()}">Edit</a></td><td><a href="deleteuser.jsp?m_email=${mu.getM_email()}">Delete</a></td></tr>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>
</body>
</html>