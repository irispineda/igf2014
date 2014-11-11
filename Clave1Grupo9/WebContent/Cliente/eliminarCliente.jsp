<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.*"%>
<%@page import="org.sv.ues.igf.controlador.*"%>
<%
   ClienteCtrl clienteCtrl = new ClienteCtrl();
   boolean existe = clienteCtrl.borrar(Integer.parseInt(request.getParameter("idcliente")));
   String mensaje;

   if (existe) {
      response.sendRedirect("listaCliente.jsp");
      mensaje = "Se creo el tipo cliente";
   } else {
	  response.sendRedirect("listaCliente.jsp");
      mensaje = "Ya hay un tipo cliente con ese id";
   }
%>