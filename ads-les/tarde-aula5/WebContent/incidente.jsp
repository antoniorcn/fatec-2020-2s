<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<form>
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
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</form>
			
		</div>
	</body>
</html>