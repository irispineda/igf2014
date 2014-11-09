<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"
%>

<%@ page import="java.util.*"%>
<%@ page import="org.sv.ues.igf.entidades.Cliente"%>
<%@ page import="org.sv.ues.igf.entidades.Tipocliente"%>
<%@ page import="org.sv.ues.igf.controlador.ClienteCtrl"%>
<%@ page import="org.sv.ues.igf.controlador.TipoClienteCtrl"%>
<%
	ClienteCtrl cControl = new ClienteCtrl();
	List<Cliente> listaCliente = cControl.findByAll();

	String lista = "";
	for (Cliente c : listaCliente) {
		lista = lista + "<tr>" 
                      + "<td>" + c.getIdcliente() + "</td>"
                      + "<td>" + c.getNombClient() + " " + c.getApellidoClient() + "</td>"
                      + "<td>" + c.getDireccion() + "</td>" 
                      + "<td>" + c.getFechaNacimiento() + "</td>" 
                      + "<td>" + c.getEmail() + "</td>"
                      + "<td>" + c.getTelefono() + "</td>"
                      + "<td>"
                      + "<input type=button onClick=\"location.href='#'\" value='Editar'>&nbsp;"
                      + "<input type=button onClick=\"location.href='#'\" value='Eliminar'>&nbsp;"
                      + "</td>"
                      + "</tr>";
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
               <li><a href="#">Tipo de Cliente</a></li>
               <li><a href="#">Establecimiento</a></li>
               <li><a href="#">Pais</a></li>
               <li><a onclick="cargaPagina('./Concepto/Lista.jsp');">Concepto</a></li>
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
      <p><strong>Lista de Clentes</strong></p>
      <table>
         <thead>
            <tr>
               <th>Id</th>
               <th>Nombre</th>
               <th>Dirección</th>
               <th>Fecha de Nacimiento</th>
               <th>E-Mail</th>
               <th>Telefono</th>
               <th>Acciones</th>
            </tr>
         </thead>
         <tbody>
            <%=lista%>
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
   