<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>


<%

String fechan=request.getParameter("fechaant");

String nombre = request.getParameter("nombre") ;
BigDecimal limitecredito = new BigDecimal(request.getParameter("limitecredito")) ;
BigDecimal puntostargeta = new BigDecimal(request.getParameter("puntostargeta")) ;
String fechaS = request.getParameter("fechaingreso") ;
ManejoFechas fecha = new ManejoFechas();
Date fechaE = fecha.ParseFecha(fechaS);
Date fechaa = fecha.ParseFecha(fechan);

CtrlClienteTargeta tar = new CtrlClienteTargeta();
	
boolean exito = tar.modificarClienteTargeta(fechaa, limitecredito, puntostargeta);
String mensaje;
	if(exito)
		mensaje = "la tergeta fue modificada";
	else
		mensaje = "No se pudo modificar la tarjeta";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Tarjeta</title>
<%=mensaje%>
</head>
<body>

</body>
</html>