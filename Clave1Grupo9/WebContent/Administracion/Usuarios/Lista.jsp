<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.ConceptoCtrl" %>
<%@ page import="org.sv.ues.igf.entidades.Concepto" %>
<%@ page import="java.util.*" %>
<%
	ConceptoCtrl ctrl = new ConceptoCtrl();
	Concepto alumno = new Concepto();
	List lst = null;
	
	String accion = request.getParameter("accion");
	if (accion == null)
		lst = ctrl.findByAll();
	/*else{
		lst = ctrl.findByParam(request.getParameter("nombre1"),
											request.getParameter("nombre2"),
											request.getParameter("apellido1"),
											request.getParameter("apellido2"),
											request.getParameter("genero"),
											request.getParameter("grado"));
	}*/
	
	String mensaje = "";
	
	mensaje = "<table>"+
			  	"<thead>"+
					"<caption>Conceptos <a href='Edit.jsp?idconcepto=0&accion=nuevo'><img class='iconnew' ></a></caption>"+
					"<tr>"+
						"<th>C&oacute;digo</th>"+
						"<th>Descripci&oacute;n</th>"+
					"</tr>"+
				"</thead>"+
				"<tbody>";
	if(lst.isEmpty()){
		mensaje += "<tr><td colspan=5>No hay registros</td></tr>";
	}else{
		Concepto concepto;
		for(int i=0;i<lst.size();i++){
			concepto = (Concepto) lst.get(i); 
			mensaje += "<tr>"+
							"<td>"+concepto.getIdconcepto()+"</td>"+
							"<td>"+concepto.getDescripcion()+"</td>"+
							"<td><a href='Edit.jsp?idconcepto="+concepto.getIdconcepto()+"&accion=ver'><img class='iconview' ></a></td>"+
							"<td><a href='Edit.jsp?idconcepto="+concepto.getIdconcepto()+"&accion=edit'><img class='iconedit' ></a></td>"+
							"<td><a href='Edit.jsp?idconcepto="+concepto.getIdconcepto()+"&accion=borrar'><img class='icondel' ></a></td>"+
						"</tr>"; 
		}
	}
	mensaje += "</tbody>"+
			   "</table>";
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
		<%=mensaje %>
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