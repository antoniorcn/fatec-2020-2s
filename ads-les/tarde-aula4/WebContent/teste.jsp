<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Página Principal</title>
	</head>
	<body>
		<!--  Isto é comentário de HTML -->
		<%--  Isto é comentário de JSP --%>
		<h1>Página home do sistema</h1>
		<%
			LocalDateTime d = LocalDateTime.now();
			// Isto é um comentário em Java
		%>
		<p> Horario Atual: <%= d.toString() %></p>
	</body>
</html>