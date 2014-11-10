<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.UsuariosCtrl" %>
<%@ page import="org.sv.ues.igf.entidades.Usuarios" %>
<%@ page import="org.sv.ues.igf.utilidades.Conversiones" %>
<%@ page import="java.util.Date" %>
<%
	Usuarios usuario = new Usuarios();
	String disable = "";
	UsuariosCtrl ctrl = new UsuariosCtrl();
	
	String accion = request.getParameter("accion");
	if (accion == null) accion = "";
	
	Integer ident = 0;
	if (request.getParameter("id") == null) ident = 0;
	else ident = Integer.parseInt(request.getParameter("id"));
	
	if (ident == 0) {
		usuario = new Usuarios();
	} else {
		usuario = ctrl.findById(ident);
	}
	
	String admin, user;
	admin = user = "";
	
	if (accion.equals("guardar")){
		Conversiones c = new Conversiones();
		usuario.setUser(c.getUsuario());
		usuario.setDatareg(new Date());
		usuario.setUsuario(request.getParameter("usuario"));
		if (ident != 0) usuario.setId(ident);
		ctrl.guardar(usuario);
		response.sendRedirect("Lista.jsp");
	}else if (accion.equals("borrar")) {
		usuario = ctrl.findById(ident);
		ctrl.borrar(ident);
		response.sendRedirect("Lista.jsp");
	} else if (accion.equals("ver")) {
		disable = "disabled";
		if (usuario.getRole().equals("ROLE_USER")) user = "selected";
		else admin = "selected";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="/Clave1Grupo9/style.css" media="screen,projection" />
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
					<li><a  class="current" href="#">Usuarios</a></li>
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
			<input type="hidden" name="id" value="<%=usuario.getId()%>"  />
			<table>
				<thead>
					<caption>Usuarios</caption>
				</thead>
				<tbody>
					<tr>
						<td>Usuario</td>
						<td><input type="text" name="usuario" value="<%=usuario.getUsuario()%>" <%=disable%> /></td>
						<td>Contrase&ntilde;a</td>
						<td><input type="text" name="password" value="<%=usuario.getPassword()%>" <%=disable%> /></td>
					</tr>
					<tr>
						<td>Nombre</td>
						<td><input type="text" name="name" value="<%=usuario.getName()%>" <%=disable%> /></td>
						<td>Rol</td>
						<td><select name="ultgrado" <%=disable%>>
								<option value="ROLE_USER" <%=user%>>Usuario</option>
								<option value="ROLE_ADMIN" <%=admin%>>Administrador</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
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