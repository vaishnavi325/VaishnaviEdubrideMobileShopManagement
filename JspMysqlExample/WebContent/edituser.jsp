<%@page import="database.connection.com.DBConnection"%>
<jsp:useBean id="mu" class="com.javatpoint.bean.MobileUser"></jsp:useBean>
<jsp:setProperty property="*" name="mu"/>

<%
int i=DBConnection.update(mu);
response.sendRedirect("viewusers.jsp");
%>