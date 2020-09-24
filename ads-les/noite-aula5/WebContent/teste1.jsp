<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Teste de JSP</h1>
	<h3>Data e hora atual</h3>
	
	<%
	
		LocalDateTime dt = LocalDateTime.now();
		
	%>
	
	<h5><%=dt.toString()%></h5>

</body>
</html>