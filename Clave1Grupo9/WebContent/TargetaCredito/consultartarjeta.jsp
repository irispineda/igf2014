<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>
    
    
    <%
        	int idTarjeta =Integer.parseInt( request.getParameter("idTarjeta"));
            CtrlTarjeta consulta = new CtrlTarjeta();
            Tarjeta buscado = consulta.daTarjetaById(idTarjeta);
            
            String mensaje="";
            
            if(buscado != null){
            			mensaje += "Codigo: " + buscado.getIdTarjeta()
        				+ "<br> Nombre de la tarjeta: " + buscado.getNombreTarjeta()
        				+ "<br>Limite Maximo:" + buscado.getLimiteMaximo()
        				+ "<br>Limite Minimo:" + buscado.getLimiteMinimo()
        				+ "<br>Nombre Emisor:" + buscado.getNombre_emisor()
        				+ "<br>Fecha Ingreso:" + buscado.getFechaIngreso()
        				+ "<br>Tasa de Interes:" + buscado.getTasaInteres();
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
