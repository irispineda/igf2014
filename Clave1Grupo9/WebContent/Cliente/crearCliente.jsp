<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.Cliente"%>
<%@page import="org.sv.ues.igf.entidades.Tipocliente"%>
<%@page import="org.sv.ues.igf.controlador.ClienteCtrl"%>
<%@page import="org.sv.ues.igf.controlador.TipoClienteCtrl"%>
<%
   String crear = request.getParameter("crear");
   System.out.println (crear);
   if(crear != null && "on".equals(crear)) {
        Cliente cliente = new Cliente();
      	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      	TipoClienteCtrl tcCtrl = new TipoClienteCtrl();
      	Tipocliente tipoCliente = tcCtrl.findById(request.getParameter("idtipocliente"));
      
      	cliente.setNombClient(request.getParameter("nombClient"));
      	cliente.setApellidoClient(request.getParameter("apellidoClient"));
      	cliente.setDireccion(request.getParameter("direccion"));
      	cliente.setTelefono(request.getParameter("telefono"));
      	cliente.setFechaNacimiento(formatter.parse(request
      			.getParameter("fechaNacimiento")));
      	cliente.setEmail(request.getParameter("email"));
      
      	cliente.setTipocliente(tipoCliente);
      
      	ClienteCtrl clienteCtrl = new ClienteCtrl();
      	boolean existe = clienteCtrl.guardar(cliente);
      	String mensaje;
      
      	if (existe) {
      		response.sendRedirect("listaCliente.jsp");
      		mensaje = "Se creo el  cliente";
      	} else {
      		response.sendRedirect("crearcliente.html");
      		mensaje = "Error al guardar el cliente";
      	}
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
 <link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
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
               <li><a href="listaTipoCliente.jsp">Tipo de Cliente</a></li>
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
      <form action="crearCliente.jsp" method="post">
         Introduza el nombre del  cliente: <input type="text" name="nombClient"/><br><br>
         Introduza el apellido del  cliente: <input type="text" name="apellidoClient"/><br><br>
         Introduza la direcci�n del  cliente: <input type="text" name="direccion"/><br><br>
         Introduza el tel�fono del  cliente: <input type="text" name="telefono"/><br><br>
         Introduza la fecha de nacimiento del cliente: <input type="text" id="datepicker1" name="fechaNacimiento" value="" size=8/><br><br>
         Introduza el email del cliente: <input type="text" name="email"/><br><br>
         Introduza el id del tipo cliente: <input type="text" name="idtipocliente"/><br><br>
         <input type="hidden" name="crear" value="on"/>
         <input type="submit" value="Crear">
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