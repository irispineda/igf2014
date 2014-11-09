<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>
 
<%
	int id  = Integer.parseInt(request.getParameter("id")) ;
	BigDecimal limitecredito = new BigDecimal(request.getParameter("limitecredito")) ;
	BigDecimal puntostargeta = new BigDecimal(request.getParameter("puntostargeta")) ;
	String fechaS = request.getParameter("fechaemision") ;
	ManejoFechas fecha = new ManejoFechas();
	Date fechaE = fecha.ParseFecha(fechaS);
	
	CtrlClienteTargeta tar = new CtrlClienteTargeta();
	boolean exito = tar.crearClienteTargeta(id, fechaE, limitecredito, puntostargeta);
	
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