<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>
   
 <%@ page import="java.util.*" %>
<%
String fechaS = request.getParameter("fechaemision") ;
ManejoFechas fecha = new ManejoFechas();
Date fechaE = fecha.ParseFecha(fechaS);
	CtrlClienteTargeta targeta = new CtrlClienteTargeta();
	boolean exito = targeta.eliminarClienteTargeta(fechaE);
	String mensaje;
	if(exito)
		mensaje = "la targeta fue eliminada";
	else
		mensaje = "No se pudo eliminar targeta";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>targeta</title>
<%=mensaje%>
</head>
<body>

</body>
</html>