<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, edu.curso.entidade.Incidente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestão de Incidentes</title>
		<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/>
		<script src="./resources/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<h1>Gestão de Incidentes</h1>
			<%
				String msg = (String)session.getAttribute("MENSAGEM");
				List<Incidente> localizados = (List<Incidente>)session.getAttribute("LOCALIZADOS");
				if (msg != null) {
			%>
					<div class="alert alert-success" role="alert">
	  					<h4 class="alert-heading">Informação</h4>
					  <p><%=msg%></p>
					</div>
			<%
					session.setAttribute("MENSAGEM", null);
				}
			%>
			<form action="./incidenteController" method="get">
				<div class="form-group">
					<label>ID</label>
					<input type="text" name="txtID" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Titulo</label>
					<input type="text" name="txtTitulo" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Descrição</label>
					<textarea name="txtDescricao" class="form-control" rows="5"></textarea>
				</div>
				<div class="form-group">
					<label>Data abertura</label>
					<input type="date" name="txtDataAbertura" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Data fechamento</label>
					<input type="date" name="txtDataFechamento" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Status</label>
					<select name="txtStatus" class="form-control">
						<option value="aberto">Aberto</option>
						<option value="cancelado">Cancelado</option>
						<option value="fechado">Fechado</option>
					</select>
				</div>
				<div class="form-group">
					<label>Categoria</label>
					<select name="txtCategoria" class="form-control">
						<option value="desktop">Desktop</option>
						<option value="monitor">Monitor</option>
						<option value="notebook">Notebook</option>
						<option value="periferico">Periféricos</option>
						<option value="rede">Rede</option>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary" name="cmd" value="adicionar">Adicionar</button>
					<button type="submit" class="btn btn-primary" name="cmd" value="pesquisar">Pesquisar</button>
				</div>
			</form>
		</div>
		<div class="container">
			<% if (localizados != null && localizados.size() > 0)  { %>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Titulo</th>
							<th>Abertura</th>
							<th>Fechamento</th>
							<th>Status</th>
							<th>Categoria</th>
						</tr>
					</thead>
					<tbody>
						<% for(Incidente incidente : localizados) { %>
							<tr>
								<td><%=incidente.getId()%></td>
								<td><%=incidente.getTitulo()%></td>
								<td><%=incidente.getAbertura()%></td>
								<td><%=incidente.getFechamento()%></td>
								<td><%=incidente.getStatus()%></td>
								<td><%=incidente.getCategoria()%></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			<% } %>
		</div>
	</body>
</html>