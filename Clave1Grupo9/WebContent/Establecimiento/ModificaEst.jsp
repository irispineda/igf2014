<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="org.sv.ues.igf.controlador.*" %> 
    <%@ page import="java.util.*" %>
    
    <%
String nombreant=request.getParameter("idantiguo");
String nombre = request.getParameter("nombre");
String domicilio = request.getParameter("dom");
Date fecha = (Date.ValueOf(request.getParameter("fecha")));
String activo = request.getParameter("activo");
	
CtrlEstablecimiento est = new CtrlEstablecimiento();
	
boolean exito = est.modificarEstablecimiento(nombreant, nombre, domicilio, fecha, activo);
String mensaje;
	if(exito)
		mensaje = "El establecimiento fue modificado";
	else
		mensaje = "No se pudo modificar el establecimiento";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar establecimiento</title>
<%=mensaje%>
</head>
<body>

</body>
</html>