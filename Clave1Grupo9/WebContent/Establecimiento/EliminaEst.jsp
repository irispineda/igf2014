<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.sv.ues.igf.controlador.*" %> 
    <%@ page import="java.util.*" %>
    
    <%
	String nombreest  = request.getParameter("nombre");
	CtrlEstablecimiento est = new CtrlEstablecimiento();
	boolean exito = est.eliminarEstablecimiento(nombreest);
	String mensaje;
	if(exito)
		mensaje = "El establecimiento fue eliminado";
	else
		mensaje = "No se pudo eliminar el establecimiento";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eliminar establecimiento</title>
<%=mensaje%>
</head>
<body>

</body>
</html>