<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.*" %>
<%@ page import="org.sv.ues.igf.entidades.*" %>
<%@ page import="org.sv.ues.igf.utilidades.Conversiones" %>

<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>

<%
	Transaccion transaccion = new Transaccion();
	String tarjetas = "", clientes = "", conceptos = "", paises = "", disable = "";
	TransaccionCtrl ctrl = new TransaccionCtrl();
	Integer ident = 0;
	
	List tLst = ctrl.findAllTarjetas();
	if (tLst != null){
		Tarjetacredito trjt;
		for(int i=0;i<tLst.size();i++){
			trjt = (Tarjetacredito) tLst.get(i);
			tarjetas +="<option value="+trjt.getIdtarjetacredito()+">"+trjt.getNombreTarjeta()+"</option>";
		}
	}
	
	List cLst = ctrl.findAllClientes();
	if (cLst != null){
		Cliente cli;
		for(int i=0;i<cLst.size();i++){
			cli = (Cliente) cLst.get(i);
			clientes +="<option value="+cli.getIdcliente()+">"+cli.getNombClient()+" "+cli.getApellidoClient()+"</option>";
		}
	}
	
	List cLst1 = ctrl.findAllConceptos();
	if (cLst1 != null){
		Concepto con;
		for(int i=0;i<cLst1.size();i++){
			con = (Concepto) cLst1.get(i);
			conceptos +="<option value="+con.getIdconcepto()+">"+con.getDescripcion()+"</option>";
		}
	}
	
	List pLst = ctrl.findAllPaises();
	if (pLst != null){
		Pais pais;
		for(int i=0;i<pLst.size();i++){
			pais = (Pais) pLst.get(i);
			paises +="<option value="+pais.getIdpa()+">"+pais.getNombrePais()+"</option>";
		}
	}
	
	String accion = request.getParameter("accion");
	if (accion == null) accion = "";
	System.out.println(accion);
	if (accion == "guardar"){
		if (request.getParameter("idtransaccion") == null) ident = 0;
		else ident = Integer.parseInt(request.getParameter("idtransaccion"));
		transaccion = new Transaccion();
		if (ident != 0)
			transaccion.setIdtransaccion(ident);

		/*transaccion.setBAbono(request.getParameter("b_abono"));
		transaccion.setBCargo(request.getParameter("b_cargo"));
		
		transaccion.setCliente(ctrl.findCliente(Integer.parseInt(request.getParameter("idcliente"))));
		transaccion.setTarjetacredito(ctrl.findTarjeta(Integer.parseInt(request.getParameter("idtarjetacredito"))));
		transaccion.setConcepto(ctrl.findConcepto(Integer.parseInt(request.getParameter("idconcepto"))));
		transaccion.setPais(ctrl.findPais(Integer.parseInt(request.getParameter("idpais"))));
		
		Conversiones conversion = new Conversiones();
		transaccion.setFechaAplicada(conversion.stringToDate(request.getParameter("fecha_aplicada")));
		transaccion.setFechaTransaccion(conversion.stringToDate(request.getParameter("fecha_transaccion")));
		transaccion.setMontoTransaccion(conversion.stringToBigDecimal(request.getParameter("monto_transaccion")));
		
		transaccion.setClientetarjetaestado(ctrl.findClienteTarjetaEstado(transaccion.getTarjetacredito(),
				transaccion.getCliente(), conversion.stringToDate(request.getParameter("fecha_limite_pago"))));*/ 
		ctrl.guardar(transaccion);
		response.sendRedirect("Lista.jsp");
	}else if (accion.equals("borrar")){
		ctrl.borrar(ident);
		response.sendRedirect("Lista.jsp");
	}else if (accion.equals("ver")) {
		disable = "disabled";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-ui-1.11.2/jquery-ui.css" media="screen,projection" />
	<script src="../js/jquery-ui-1.11.2/external/jquery/jquery.js"></script>
	<script src="../js/jquery-ui-1.11.2/jquery-ui.js"></script>
	<script language="javascript">
		$(function() {
			$( "#datepicker1" ).datepicker();
			$( "#datepicker2" ).datepicker();
			$( "#datepicker3" ).datepicker();
		});
	</script>
	<title>UES-IGF115-Clave1-Grupo9-2014</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<p class="hide">
			skip to: <a href="#">content</a> | <a href="#">navigation</a><br />
		</p>
		<h1><a href="#">IGF115-Clave1-Grupo9</a></h1>
		<p id="slogan">UES-2014</p>
	</div><div class="inner_copy"></div>
	<div id="sitemenu">
		<h2 class="hide">Sample menu:</h2>
		<ul>
			<li><a href="#">Inicio</a></li>
			<li>
				<a href="#">Catalogos</a>
				<ul>
					<li><a href="#">Tipo de Cliente</a></li>
					<li><a href="#">Establecimiento</a></li>
					<li><a href="#">Pais</a></li>
					<li><a href="#">Transaccion</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Maestros</a>
				<ul>
					<li><a href="#">Cliente</a></li>
					<li><a href="#">Tarjeta de Credito</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Procesos</a>
				<ul>
					<li><a href="#">Tarjeta-Cliente</a></li>
					<li><a class="current" href="#">Transacciones</a></li>
					<li><a href="#">Estado de Cuenta</a></li>
				</ul>
			</li>
			<li class="hide"><a href="#header">Back to top</a></li>
		</ul>
	</div>
	<div id="extras">
	</div>
	<div id="content">
		<form action="Edit.jsp" method="post">
			<input type="hidden" name="accion" value="guardar" />
			<input type="hidden" name="idtransaccion" value="<%=transaccion.getIdtransaccion()%>"  />
			<table>
				<thead>
					<caption>Transaccion</caption>
				</thead>
				<tbody>
					<tr>
						<td>C&oacute;digo</td>
						<td colspan=3><input type="text" value="<%=transaccion.getIdtransaccion()%>" disabled size=5 /></td>
					</tr>
					<tr>
						<td>No. de Tarjeta</td>
						<td colspan=3><select name="idtarjetacredito" style="width:213px"><%=tarjetas%></select>
						</td>
					</tr>
					<tr>
						<td>Cliente</td>
						<td colspan=3><select name="idcliente" style="width:213px"><%=clientes%></select>
						</td>
					</tr>
					<tr>
						<td>Fecha</td>
						<td><input type="text" id="datepicker1" name="fecha_transaccion" value="" size=5 /></td>
						<td>Monto</td>
						<td><input type="text" name="monto_transaccion" value="" size=5 /></td>
					</tr>
					<tr>
						<td>Aplicaci&oacute;n</td>
						<td><input type="text" id="datepicker2" name="fecha_aplicada" value="" size=5 /></td>
						<td>Vencimiento</td>
						<td><input type="text" id="datepicker3" name="fecha_limite_pago" value="" size=5 /></td>
					</tr>
					<tr>
						<td>Tipo</td>
						<td><input type="checkbox" name="b_cargo" value="S"  />Cargo</td>
						<td><input type="checkbox" name="b_abono" value="S"  />Abono</td>
					</tr>
					<tr>
						<td>Concepto</td>
						<td colspan=3><select name="idconcepto" style="width:213px"><%=conceptos%></select>
						</td>
					</tr>
					<tr>
						<td>Pais</td>
						<td colspan=3><select name="idpais" style="width:213px"><%=paises%></select></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<input type="submit" value="Guardar" />
							<input type="reset" value="Limpiar" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="footer">
		<div class="fcenter">
			<div class="fleft"><p>IGF115</p></div>
			<div class="fright"><p>Clave 1</p></div>
			<div class="fcenter"><p>Grupo 9</p></div>
		</div>
	</div>
</div>
</body>
</html>