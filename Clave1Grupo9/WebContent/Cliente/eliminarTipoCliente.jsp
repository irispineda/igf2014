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
	  response.sendRedirect("listaTipoCliente.jsp");
      mensaje = "Ya hay un tipo cliente con ese id";
   }
%>