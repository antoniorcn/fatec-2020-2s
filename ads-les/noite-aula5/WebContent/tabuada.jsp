<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tabuada</title>
	<script>
		function alerta() { 
			alert("Foi clicado");
		}
	</script>
</head>
<body>
	
	<%	int numero = 7;
		try { 
			numero = Integer.parseInt(request.getParameter("NUMERO"));
		} catch (Exception e) { 
			// nada
		}
	%>
	
	<h1>Tabuada do número <%=numero%></h1>
	
	<%		
		for (int i = 0; i <= 10; i++) { 
			int resultado = numero * i;
	%>
			<h3><%=numero%> X <%=i%> = <%=resultado%></h3>
	<%
		}
	%>

	<button type="button" onclick="alerta();">Clique-me</button>
</body>
</html>