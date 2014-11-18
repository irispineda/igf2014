<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.*"%>
<%@ page import="java.math.BigDecimal" %>
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
	BigDecimal tasa_interes= new BigDecimal(request.getParameter("tasa_interes")) ;
	
	CtrlTarjeta tar = new CtrlTarjeta();
	boolean exito = tar.crearTarjeta(nombre, limiteminimo, limitemaximo, Nombre_emisor, fechaE, tasa_interes);
	
	String mensaje;	
	
	if(exito)
		mensaje = "Tarjeta creada";
	else 
		mensaje = "no se pudo crear";
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