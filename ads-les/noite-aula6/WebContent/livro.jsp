<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestão de Livros</title>
	<link href="./resources/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="./resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Gestão de Livros</h1>
		<%
			String msg = (String)session.getAttribute("MENSAGEM");
			if (msg != null) {
		%>
				<div class="alert alert-success" role="alert">
	  				<h4 class="alert-heading">Comando executado</h4>
	  				<p><%=msg%></p>
	  			</div>
		<% 		session.setAttribute("MENSAGEM", null);
			} %>
		<form action="./livroController" method="post">
			<div class="form-group">
				<label>ID: </label>
				<input type="text" name="txtID" class="form-control" readonly/>
			</div>
			<div class="form-group">
				<label>Titulo: </label>
				<input type="text" name="txtTitulo" class="form-control"/>
			</div>			
			<div class="form-group">
				<label>Autor: </label>
				<input type="text" name="txtAutor" class="form-control"/>
			</div>			
			<div class="form-group">
				<label>Paginas: </label>
				<input type="number" name="txtPaginas" class="form-control"/>
			</div>			
			<div class="form-group">
				<label>Gênero: </label>
				<select name="txtGenero" class="form-control">
					<option value="auto-ajuda">Auto ajuda</option>
					<option value="acao">Ação</option>
					<option value="bruxaria">Bruxaria</option>
					<option value="ficcao">Ficção</option>
					<option value="historia">História</option>
					<option value="informatica">Informática</option>
					<option value="policial">Policial</option>
					<option value="psicologia">Psicologia</option>
					<option value="religiao">Religião</option>
					<option value="romance">Romance</option>
				</select>
			</div>
			<div class="form-group">
				<label>Editora: </label>
				<select name="txtEditora" class="form-control">
					<option value="abril">Abril</option>
					<option value="bookman">Bookman</option>
					<option value="cosac-naif">Cosac Naif</option>
					<option value="daskside">Darkside</option>
					<option value="globo">Globo</option>
					<option value="harper-collins">Harper Collins</option>
					<option value="moderna">Moderna</option>
					<option value="oracle-press">Oracle Press</option>
					<option value="record">Record</option>
					<option value="rocoo">Rocco</option>
					<option value="sextante">Sextante</option>
				</select>
			</div>			
			<button type="submit">Adicionar</button>	
		</form>
	</div>
</body>
</html>