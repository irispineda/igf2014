<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="org.sv.ues.igf.dao.*" %>
    <%@ page import="org.sv.ues.igf.controlador.*" %>
    <%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="java.math.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.sv.ues.igf.utilidades.*" %>

<%
			String mensaje="";
        	short idPa =Short.parseShort( request.getParameter("idPais"));
            CtrlPais consulta = new CtrlPais();
            Pais buscado = consulta.daPaisByIdPa(idPa);
            
            
            
            if(buscado != null){
            			mensaje += "Codigo Pais: " + buscado.getIdpa()
        				+ "<br> Nombre Pais: " + buscado.getNombrePais();
            			} else {
        		mensaje ="Pais no encontrado";
        	}
        %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Pais</title>
</head>
<body>
<form action="ConsultarPais.jsp" method="post">
Id Pais: <input type="text" name="idPais"><br><br>
<input type="submit" value="Consultar">

</form>

</body>
</html>