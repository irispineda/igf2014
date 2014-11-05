<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	String mensaje;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
	<script type="text/javascript" src="jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function cargaPagina(href){
			alert("llego aqui 2");
			alert(href);
			$('#content').load(href);
			/*$(document).ready(function(){
				$("a").on("click", function(event){
					event.preventDefault();
					alert(this.href);
					$('#content').load(this.href);
				});
			});*/
		}
    </script>
	<title>UES-IGF115-Clave1-Grupo9-2014</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<p class="hide">
			skip to: <a href="#">content</a> | <a href="#">navigation</a><br />
		</p>
		<h1><a href="#">IGF115-Clave1-Grupo9</a></h1>
		<p id="slogan">UES-2014</p>
	</div><div class="inner_copy"></div>
	<div id="sitemenu">
		<h2 class="hide">Sample menu:</h2>
		<ul>
			<li><a href="#">Inicio</a></li>
			<li>
				<a href="#">Catalogos</a>
				<ul>
					<li><a href="#">Tipo de Cliente</a></li>
					<li><a href="#">Establecimiento</a></li>
					<li><a href="#">Pais</a></li>
					<li><a href="#" class="current">Concepto</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Maestros</a>
				<ul>
					<li><a href="#">Cliente</a></li>
					<li><a href="#">Tarjeta de Credito</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Procesos</a>
				<ul>
					<li><a href="#">Tarjeta-Cliente</a></li>
					<li><a href="#">Transacciones</a></li>
					<li><a href="#">Estado de Cuenta</a></li>
				</ul>
			</li>
			<li class="hide"><a href="#header">Back to top</a></li>
		</ul>
	</div>
	<div id="extras">
	</div>
	<div id="content">
		<table>
			<thead>
				<caption>Conceptos <a href="Edit.jsp"><img src="../images/new.jpg" class="icon" width="20px" height="20px"></a></caption>
				<tr>
					<th>C&oacute;digo</th>
					<th>Descripci&oacute;n</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td>1</td>
				<td>Compra en Centro Comercial La Gran Via</td>
				<td><a href="Edit.jsp?accion=ver&idconcepto="><img src="../images/view.jpg" class="icon" width="20px" height="20px"></a></td>
				<td><a href="Edit.jsp?accion=edit&idconcepto="><img src="../images/edit.jpg" class="icon" width="20px" height="20px"></a></td>
				<td><a href="Edit.jsp?accion=borrar&idconcepto="><img src="../images/del.jpg" class="icon" width="20px" height="20px"></a></td>
			</tr>
			</tbody>
		</table>
	</div>
	<div id="footer">
		<div class="fcenter">
			<div class="fleft"><p>IGF115</p></div>
			<div class="fright"><p>Clave 1</p></div>
			<div class="fcenter"><p>Grupo 9</p></div>
		</div>
	</div>
</div>
</body>
</html>