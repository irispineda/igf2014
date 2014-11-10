<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.sv.ues.igf.controlador.*" %> 
    <%@ page import="java.util.*" %>
    <%@ page import="org.sv.ues.igf.utilidades.Conversiones" %>
<%
	String nombre = request.getParameter("nombre");
	String domicilio = request.getParameter("dom");
	//Date fecha = (Date.ValueOf(request.getParameter("fecha")));
	Conversiones c = new Conversiones();
	Date fecha = c.stringToDate(request.getParameter("fechaTransaccion"));
	String activo = request.getParameter("activo");
	CtrlEstablecimiento est = new CtrlEstablecimiento();
	boolean exito = est.crearEstablecimiento(nombre, domicilio, fecha, activo);
	String mensaje;
	if(exito)
		mensaje = "El establecimiento fue ingresado";
	else
		mensaje = "No se pudo ingresar el establecimiento";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar establecimiento</title>
<%=mensaje%>
</head>
<body>

</body>
</html>