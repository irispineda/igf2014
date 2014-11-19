<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
    <%@ page import="org.sv.ues.igf.dao.*" %>
   
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>
    
    <%
        	int idCliente =Integer.parseInt( request.getParameter("idTarjeta"));
                    CtrlClienteTargeta consulta = new CtrlClienteTargeta();
                   Clientetarjeta buscado = consulta.daClienteTargetaById(idCliente);
                    
                    String mensaje="";
                    
                    if(buscado != null){
                    			mensaje += "Codigo: " + buscado.getIdCliente()
                				+ "<br> fecha de emision: " + buscado.getFecha_Emision()
                				+ "<br>Limite de credito:" + buscado.getLimite_credito()
                				+ "<br>puntos targeta:" + buscado.getPuntos_credito();
                    			} else {
                		mensaje ="Tarjeta no encontrado";
                	}
        %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Tarjeta</title>
</head>
<body>
<%=mensaje %>
</body>
</html>	
