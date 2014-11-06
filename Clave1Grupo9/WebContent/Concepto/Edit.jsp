<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.ConceptoCtrl" %>
<%@ page import="org.sv.ues.igf.entidades.Concepto" %>

<%
	Concepto concepto = new Concepto();
	String disable = "";
	ConceptoCtrl ctrl = new ConceptoCtrl();
	
	String accion = request.getParameter("accion");
	if (accion == null) accion = "";
	
	Integer ident = 0;
	if (request.getParameter("idconcepto") == null) ident = 0;
	else ident = Integer.parseInt(request.getParameter("idconcepto"));
	
	if (ident == 0) {
		concepto = new Concepto();
	} else {
		concepto = ctrl.findById(ident);
	}
	
	if (accion.equals("guardar")){
		concepto.setDescripcion(request.getParameter("descripcion"));
		if (ident != 0) concepto.setIdconcepto(ident);
		ctrl.guardar(concepto);
		response.sendRedirect("Lista.jsp");
	}else if (accion.equals("borrar")) {
		concepto = ctrl.findById(ident);
		ctrl.borrar(ident);
		response.sendRedirect("Lista.jsp");
	} else if (accion.equals("ver")) {
		disable = "disabled";
	}
	System.out.println("aqui");
	System.out.println(concepto.getIdconcepto());
	
	System.out.println(concepto.getIdconcepto());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
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
					<li><a  class="current" href="#">Concepto</a></li>
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
		<form action="Edit.jsp" method="post">
			<input type="hidden" name="accion" value="guardar"  />
			<input type="hidden" name="idconcepto" value="<%=concepto.getIdconcepto()%>"  />
			<table>
				<thead>
					<caption>Concepto</caption>
				</thead>
				<tbody>
					<tr>
						<td>C&oacute;digo</td>
						<td><input type="text" value="<%=concepto.getIdconcepto()%>" disabled /></td>
					</tr>
					<tr>
						<td>Descripci&oacute;n</td>
						<td><input type="text" name="descripcion" value="<%=concepto.getDescripcion()%>" <%=disable%> /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Guardar" />
							<input type="reset" value="Limpiar" />
						</td>
					</tr>
				</tbody>
			</table>
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