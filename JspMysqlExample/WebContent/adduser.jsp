<%@page import="database.connection.com.DBConnection"%>
<jsp:useBean id="mu" class="com.javatpoint.bean.MobileUser"></jsp:useBean>
<jsp:setProperty property="*" name="mu"/>

<%
int i=DBConnection.save(mu);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
%>