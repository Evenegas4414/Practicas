<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, cl.exql.crudproductos.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos: Bases de Datos</title>
</head>
<body>
	<div id="contenedor">
		<div id="header">
			<h2>Lista de Productos</h2>
		</div>
	</div>
	<hr>
	<div id="contenido">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>ARTICULO</th>
				<th>MARCA</th>
				<th>DETALLE</th>
				<th>PRECIO</th>
				<th>OPCIONES</th>
			</tr>
			<c:forEach var="p" items="${listaProductos}">
				<c:url var="linkProducto" value="ProductoServletControlador">
					<c:param name="comando" value="LOAD"></c:param>
					<c:param name="idProducto" value="${p.id}"></c:param>
				</c:url>
				<c:url var="borrarProducto" value="ProductoServletControlador">
					<c:param name="comando" value="DELETE"></c:param>
					<c:param name="idProducto" value="${p.id}"></c:param>
				</c:url>
				<tr>
					<td>${p.id}</td>
					<td>${p.articulo}</td>
					<td>${p.marca}</td>
					<td>${p.detalle}</td>
					<td>${p.precio}</td>
					<td><a href="${linkProducto}">ACTUALIZAR</a> | 
					<a href="${borrarProducto}
					onclick="if (!(confirm('¿Quieres borrar el producto?'))) return false">BORRAR</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div id="acciones">
		<input type="button" value="Agregar"
			onclick="window.location.href='agregar-producto-form.jsp'; return false;" />
	</div>
</body>
</html>