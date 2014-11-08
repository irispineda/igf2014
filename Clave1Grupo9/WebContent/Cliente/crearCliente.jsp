<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.*"%>
<%@page import="org.sv.ues.igf.controlador.*"%>
<%
	Cliente cliente = new Cliente();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Tipocliente tipoCliente = new Tipocliente();
	tipoCliente.setIdtipocliente(request.getParameter("idtipocliente"));

	cliente.setIdtipocliente(Integer.parseInt(request
			.getParameter("idcliente")));
	cliente.setNombClient(request.getParameter("nombClient"));
	cliente.setApellidoClient(request.getParameter("apellidoClient"));
	cliente.setDireccion(request.getParameter("direccion"));
	cliente.setTelefono(request.getParameter("telefono"));
	cliente.setFechaNacimiento(formatter.parse(request
			.getParameter("fechaNacimiento")));
	cliente.setEmail(request.getParameter("email"));

	cliente.setTipocliente(tipoCliente);

	ClienteCtrl clienteCtrl = new ClienteCtrl();
	boolean existe = clienteCtrl.guardar(cliente);
	String mensaje;

	if (!existe) {
		mensaje = "Se creo el  cliente";
	} else {
		mensaje = "Ya hay un cliente con ese id";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Clientee</title>
</head>
<body>
	<%=mensaje%>
</body>
</html>