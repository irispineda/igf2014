<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.UsuariosCtrl" %>
<%@ page import="org.sv.ues.igf.entidades.Usuarios" %>
<%
	//evaluar q esta haciendo
	
    String divLogin="";
    if (session.getAttribute("usuario")==null||session.getAttribute("usuario")==""){
    	String usuario = request.getParameter("usuario");    
        String pwd = request.getParameter("password");
        if(usuario==null){
        	divLogin =  "<div id='login'>"+
	        			"	<div id='login_outer'>"+
	        			"		<div id='login_inner'>"+
	        			"			<h2><img class='iconlock'></span>    Entrar</h2>"+
	        			"			<form action='index.jsp' method='post'>"+
	        			"				<fieldset>"+
	        			"					<p><label for='email'>Usuario</label></p>"+
	        			"					<p><input type='email' id='email' value='mail@address.com' name='usuario'></p>"+
	        			"					<p><label for='password'>Password</label></p>"+
	        			"					<p><input type='password' id='password' value='password' name='password'></p>"+
	        			"					<p><input type='submit' value='Entrar'></p>"+
	        			"				</fieldset>"+
	        			"			</form>"+
	        			"		</div>"+
	        			"	</div>"+
	        			"</div>";
        }else{
        	//validar que sea un usuario y password valido
        	UsuariosCtrl ctrl = new UsuariosCtrl();
        	if(ctrl.validaUsuario(usuario,pwd)){
        		session.setAttribute("usuario",usuario);
        	}else{
        		divLogin =  "<div id='login'>"+
		        			"	<div id='login_outer'>"+
		        			"		<div id='login_inner'>"+
		        			"			<h2><img class='iconlock'></span>    Entrar</h2>"+
		        			"			<form action='index.jsp' method='post'>"+
		        			"				<fieldset>"+
		        			"					<p><label for='email'>Usuario</label></p>"+
		        			"					<p><input type='email' id='email' value='mail@address.com' name='usuario'></p>"+
		        			"					<p><label for='password'>Password</label></p>"+
		        			"					<p><input type='password' id='password' value='password' name='password'></p>"+
		        			"					<p><input type='submit' value='Entrar'></p>"+
		        			"				</fieldset>"+
		        			"			</form>"+
		        			"		</div>"+
		        			"	</div>"+
		        			"</div>";
        	}
        }
    }	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="style.css" media="screen,projection" />
	<script type="text/javascript" src="jquery-1.7.2.js"></script>
	<script type="text/javascript">
		
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
			<li><a class="current" href="#" onclick="javascript:anchodiv();">Inicio</a></li>
			<li>
				<a href="#">Catalogos</a>
				<ul>
					<li><a href="#">Tipo de Cliente</a></li>
					<li><a href="#">Establecimiento</a></li>
					<li><a href="#" onclick="cargaPagina();">Pais</a></li>
					<li><a href="./Concepto/Lista.jsp">Concepto</a></li>
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
	<div id="content">
	</div>
	<div id="footer">
		<div class="fcenter">
			<div class="fleft"><p>IGF115</p></div>
			<div class="fright"><p>Clave 1</p></div>
			<div class="fcenter"><p>Grupo 9</p></div>
		</div>
	</div>
	<%=divLogin%>
</div>
</body>
</html>