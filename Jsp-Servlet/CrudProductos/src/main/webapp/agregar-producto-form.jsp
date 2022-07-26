<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos: Agregar</title>
</head>
<body>
	<div id="contenedor">
		<div id="header">
			<h2>Agregar Producto</h2>
		</div>
	</div>
	<hr>
	<form id="contenido" action="ProductoServletControlador" method="get">
	<input type="hidden" name="comando" value="INSERT" />
	
		<table>
			<tr>
				<td><label for="articulo">Articulo: </label></td>
				<td><input type="text" id="articulo" name="articulo"></td>
			</tr>
			<tr>
				<td><label for="marca">Marca: </label></td>
				<td><input type="text" id="marca" name="marca"></td>
			</tr>
			<tr>
				<td><label for="detalle">Detalle: </label></td>
				<td><input type="text" id="detalle" name="detalle"></td>
			</tr>
			<tr>
				<td><label for="precio">Precio: </label></td>
				<td><input type="text" id="precio" name="precio"></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Agregar" /></td>
			</tr>
		</table>
	</form>
	<hr>
	<div id="acciones">
		
		<br> 
		<br>
		<a href="ProductoServletControlador">Regresar a Lista Productos</a>
	</div>

</body>
</html>