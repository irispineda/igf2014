<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.sv.ues.igf.controlador.*" %> 
    <%@ page import="org.sv.ues.igf.utilidades.*" %>
    
    <%! String mensaje = "" ; %>
    <%
    	String nombrePais =request.getParameter("nombrePais").trim() ;
        CtrlPais pai = new CtrlPais(); //error indicado en esta linea
        boolean a = pai.crearPais(nombrePais);
        if(a)
    		mensaje = "El proveedor fue ingresado";
    	else
    		mensaje = "No se pudo ingresar el Proveedor";
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%= a %>
</head>
<body>

</body>
</html>