<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.*"%>
<%@page import="org.sv.ues.igf.controlador.*"%>
<%

    String crear = request.getParameter("crear");
    System.out.println (crear);
    if(crear != null && "on".equals(crear)){
		Tipocliente tipoCliente = new Tipocliente();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
		tipoCliente.setIdtipocliente(request
				.getParameter("idtipocliente"));
		tipoCliente.setFechIngres(formatter.parse(request
				.getParameter("fecha_ingreso")));
		tipoCliente.setDTipoCliente(request.getParameter("tipo_cliente"));
	
		TipoClienteCtrl tipoClienteCtrl = new TipoClienteCtrl();
		boolean existe = tipoClienteCtrl.guardar(tipoCliente);
		String mensaje;
	
		if (existe) {
			response.sendRedirect("listaTipoCliente.jsp");
			mensaje = "Se creo el tipo cliente";
		} else {
			response.sendRedirect("creartipotliente.jsp");
			mensaje = "Ya hay un tipo cliente con ese id";
		}
    }
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
    
    <script src="../js/jquery-ui-1.11.2/external/jquery/jquery.js"></script>
	<script src="../js/jquery-ui-1.11.2/jquery-ui.js"></script>
	<script language="javascript">
	$(function() {
		$( "#datepicker1" ).datepicker();
		$( "#datepicker2" ).datepicker();
		$( "#datepicker3" ).datepicker();
	});
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
			<li><a class="current" href="#">Inicio</a></li>
			<li>
				<a href="#">Catalogos</a>
				<ul>
					<li><a href="listaCliente.jsp">Tipo de Cliente</a></li>
					<li><a href="#">Establecimiento</a></li>
					<li><a href="#">Pais</a></li>
					<li><a onclick="cargaPagina('./Concepto/Lista.jsp');">Concepto</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Maestros</a>
				<ul>
					<li><a href="listaCliente.jsp">Cliente</a></li>
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
		<form action="creartipocliente.jsp" method="post">
			Introduzca el id del tipo cliente: <input type="text" name="idtipocliente" value = ""/><br><br>
			Introduzca la fecha de ingreso: <input type="text" id="datepicker1" name="fecha_ingreso" value="" size=8/><br><br>
			Introduzca el tipo cliente: <input type="text" name="tipo_cliente"/><br><br>
			<input type = "hidden" name = "crear" value ="on"/>
			<input type="submit" value="Crear"/>
		</form>	
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