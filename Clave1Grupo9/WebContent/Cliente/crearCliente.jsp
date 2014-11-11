<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sv.ues.igf.entidades.Cliente"%>
<%@page import="org.sv.ues.igf.entidades.Tipocliente"%>
<%@page import="org.sv.ues.igf.controlador.ClienteCtrl"%>
<%@page import="org.sv.ues.igf.controlador.TipoClienteCtrl"%>
<%
	Cliente cliente = new Cliente();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	TipoClienteCtrl tcCtrl = new TipoClienteCtrl();
	Tipocliente tipoCliente = tcCtrl.findById(request.getParameter("idtipocliente"));

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

	if (existe) {
		response.sendRedirect("listaCliente.jsp");
		mensaje = "Se creo el  cliente";
	} else {
		response.sendRedirect("crearcliente.html");
		mensaje = "Error al guardar el cliente";
	}
%>