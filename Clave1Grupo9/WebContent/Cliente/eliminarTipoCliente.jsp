<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.*"%>
<%@page import="org.sv.ues.igf.controlador.*"%>
<%
   TipoClienteCtrl tipoClienteCtrl = new TipoClienteCtrl();
   boolean existe = tipoClienteCtrl.borrar(request.getParameter("idtipocliente"));
   String mensaje;

   if (existe) {
      response.sendRedirect("listaTipoCliente.jsp");
      mensaje = "Se creo el tipo cliente";
   } else {
      mensaje = "Ya hay un tipo cliente con ese id";
   }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar el Tipo de Cliente</title>
</head>

<body>
   <%=mensaje%>
</body>
</html>