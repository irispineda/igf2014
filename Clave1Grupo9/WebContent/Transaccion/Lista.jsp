<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.TransaccionCtrl" %>
<%@ page import="org.sv.ues.igf.entidades.Transaccion" %>
<%@ page import="java.util.*" %>
<%
	TransaccionCtrl ctrl = new TransaccionCtrl();
	Transaccion alumno = new Transaccion();
	List lst = null;
	String mensaje = "";
	String accion = request.getParameter("accion");
	if (accion == null){
		lst = ctrl.findByAll();
	}
	mensaje = "<table>"+
			  	"<thead>"+
					"<caption>Transacciones <a href='Edit.jsp?idtransaccion=0&accion=nuevo'><img class='iconnew' ></a></caption>"+
					"<tr>"+
						"<th>Fecha</th>"+
						"<th>Cliente</th>"+
						"<th>No. Tarjeta</th>"+
						"<th>Monto</th>"+
						"<th>Concepto</th>"+
					"</tr>"+
				"</thead>"+
				"<tbody>";
	if(lst.isEmpty()){
		mensaje += "<tr><td colspan=5>No hay registros</td></tr>";
	}else{
		Transaccion transaccion;
		for(int i=0;i<lst.size();i++){
			transaccion = (Transaccion) lst.get(i); 
			mensaje += "<tr>"+
							"<td>"+transaccion.getFechaTransaccion()+"</td>"+
							"<td>"+transaccion.getCliente().getNombClient()+" "+transaccion.getCliente().getApellidoClient()+"</td>"+
							"<td>"+transaccion.getTarjetacredito().getNombreTarjeta()+"</td>"+
							"<td>"+transaccion.getMontoTransaccion()+"</td>"+
							"<td>"+transaccion.getConcepto().getDescripcion()+"</td>"+
							"<td><a href='Edit.jsp?idtransaccion="+transaccion.getIdtransaccion()+"&accion=ver'><img class='iconview' ></a></td>"+
							"<td><a href='Edit.jsp?idtransaccion="+transaccion.getIdtransaccion()+"&accion=edit'><img class='iconedit' ></a></td>"+
							"<td><a href='Edit.jsp?idtransaccion="+transaccion.getIdtransaccion()+"&accion=borrar'><img class='icondel' ></a></td>"+
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
			<li><a class="current" href="#" onclick="javascript:anchodiv();">Inicio</a></li>
			<li>
				<a href="#">Catalogos</a>
				<ul>
					<li><a href="/Clave1Grupo9/Cliente/listaTipoCliente.jsp">Tipo de Cliente</a></li>
					<li><a href="/Clave1Grupo9/Establecimiento/CreaEst.html">Establecimiento</a></li>
					<li><a href="/Clave1Grupo9/Pais/Creapais.html">Pais</a></li>
					<li><a href="/Clave1Grupo9/Concepto/Lista.jsp">Concepto</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Maestros</a>
				<ul>
					<li><a href="/Clave1Grupo9/Cliente/listaCliente.jsp">Cliente</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/creartarjeta.html">Tarjeta de Credito</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/consultartarjeta.html">consultar</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/eliminartarjeta.html">eliminar</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/modificatargeta.html">modificar</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Procesos</a>
				<ul>
					<li><a href="#">Tarjeta-Cliente</a></li>
					<li><a href="/Clave1Grupo9/Transaccion/Lista.jsp">Transaccion</a></li>
					<li><a href="#">Estado de Cuenta</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Administracion</a>
				<ul>
					<li><a href="/Clave1Grupo9/Administracion/Usuarios/Lista.jsp">Usuarios</a></li>
				</ul>
			</li>
			<li><a href="j_spring_security_logout">Cerrar sesión</a></li>
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