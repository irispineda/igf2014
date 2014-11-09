<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="org.sv.ues.igf.controlador.*" %> 
    <%
String nombreant=request.getParameter("idantiguo");
String nombre = request.getParameter("nombre");
CtrlPais pais = new CtrlPais();
	
boolean exito = pais.modificarPais(nombreant, nombre);
String mensaje;
	if(exito)
		mensaje = "El pais fue modificado";
	else
		mensaje = "No se pudo modificar el Pais";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Pais</title>
<%=mensaje%>
</head>
<body>

</body>
</html>