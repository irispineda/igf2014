<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>
 
<%
	String nombre = request.getParameter("nombre") ;
	BigDecimal limiteminimo = new BigDecimal(request.getParameter("limiteminimo")) ;
	BigDecimal limitemaximo = new BigDecimal(request.getParameter("limitemaximo")) ;
	String Nombre_emisor=request.getParameter("Nombre_emisor");
	String fechaS = request.getParameter("fechaingreso") ;
	ManejoFechas fecha = new ManejoFechas();
	Date fechaE = fecha.ParseFecha(fechaS);
	BigDecimal tasas = new BigDecimal(request.getParameter("tasa")) ;
	
	CtrlTarjeta tar = new CtrlTarjeta();
	boolean exito = tar.crearTarjeta(nombre, limiteminimo, limiteminimo, Nombre_emisor, fechaE, tasas);
	
	String mensaje;	
	
	if(exito)
		mensaje = "vergon";
	else 
		mensaje = "malo";
	System.out.println("salida:"+fechaE);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%=mensaje %>
</body>
</html>