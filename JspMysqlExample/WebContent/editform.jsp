<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<%@page import="database.connection.com.DBConnection,com.javatpoint.bean.MobileUser"%>

<%
String m_email=request.getParameter("m_email");
MobileUser mu=DBConnection.getRecordById(m_email);
%>

<h1>Edit Form</h1>
<form action="edituser.jsp" method="post">
<input type="text" name="m_email" value="<%=mu.getM_email() %>"/>
<table>

<tr><td>FirstNAme:</td><td><input type="text" name="fname" value="<%=mu.getFname()%>"/></td></tr>
<tr><td>LastName:</td><td><input type="text" name="lname" value="<%= mu.getLname()%>"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="m_email" value="<%= mu.getM_email()%>"/></td></tr>
<tr><td>password:</td><td><input type="email" name="m_pass" value="<%= mu.getM_pass()%>"/></td></tr>
<tr><td>Mobile:</td><td><input type="email" name="mobile" value="<%= mu.getMobile()%>"/></td></tr>
<tr><td>Price:</td><td><input type="email" name="price" value="<%= mu.getPrice()%>"/></td></tr>

<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
</table>
</form>

</body>
</html>