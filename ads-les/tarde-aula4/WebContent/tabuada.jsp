<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabuada</title>
</head>
<body>
	<h1>Programa da Tabuada</h1>
	<% 
		int i = 0; 
		int numero = 7;
	%>

	<%
		for(i=0; i <= 10; i++) {
	%>
		<p><%=numero%> X <%=i%> = <%=(numero*i)%></p>
	<%
		}
	%>
	

</body>
</html>