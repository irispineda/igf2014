<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.negocio.*" %> 
<%@ page import="java.math.BigDecimal" %>     
<% 
int idcliente = Integer.parseInt(request.getParameter("idcliente"));
	String fecha_emision = request.getParameter("fecha_emision"); 
	 BigDecimal limite_credito = new BigDecimal(request.getParameter("limite_credito")) ;
	 BigDecimal puntos_targeta= new BigDecimal(request.getParameter("puntos_targeta")) ;
	
	System.out.println(fecha_emision);
	CtrlClienteTargeta ctrlcliente = new CtrlClienteTargeta();
	boolean existe = ctrlcliente.crearClienteTargeta(idcliente, fecha_emision, limite_credito, puntos_targeta);
			String mensaje;
	
	if (existe) {
		mensaje = "Se creo la libreta";
	}else {
		mensaje = "Ya hay una libreta con ese numero";
	}
	
		
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= mensaje %>
</body>
</html>