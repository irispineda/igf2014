<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.*"%>
<%@page import="org.sv.ues.igf.controlador.*"%>
<%
	Tipocliente tipoCliente = new Tipocliente();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	tipoCliente.setIdtipocliente(request
			.getParameter("idtipocliente"));
	tipoCliente.setFechIngres(formatter.parse(request
			.getParameter("fecha_ingreso")));
	tipoCliente.setDTipoCliente(request.getParameter("tipo_cliente"));

	TipoClienteCtrl tipoClienteCtrl = new TipoClienteCtrl();
	boolean existe = tipoClienteCtrl.guardar(tipoCliente);
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
<title>Crear el Tipo de Cliente</title>
</head>

<body>
	<%=mensaje%>
</body>
</html>