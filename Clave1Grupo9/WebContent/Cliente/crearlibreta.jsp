<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sv.edu.ues.igf115.negocio.CtrlTargetacredito" %>
<%@ page import="java.math.BigDecimal" %>
<%
	int idTargetacredito = Integer.parseInt(request.getParameter("idTargetacredito"));
	String Nombre_Targeta = request.getParameter("Nombre_Targeta");
	 BigDecimal limite_credito_min = new BigDecimal(request.getParameter("limite_credito_min")) ;
	    
	BigDecimal limite_credito_max = new BigDecimal(request.getParameter("limite_credito_max"));
	String nombre_emisor = request.getParameter("nombre_emisor");
	
	String fecha_ingreso = request.getParameter("fecha_ingreso");
	BigDecimal tasa_interes = new BigDecimal (request.getParameter("tasa_interes"));
	
	CtrlTargetacredito targeta = new CtrlTargetacredito();
	boolean exito = targeta.crearTargetacredito(idTargetacredito, Nombre_Targeta, limite_credito_min, limite_credito_max, nombre_emisor, fecha_ingreso, tasa_interes);
			String mensaje;
	if(exito)
		mensaje = "El targeta fue ingresado";
	else
		mensaje = "No se pudo ingresar el Proveedor";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>insertar targeta</title>
<%=mensaje%>
</head>
<body>

</body>
</html>