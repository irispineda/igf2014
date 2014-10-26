<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	String mensaje;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conceptos registrados</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th colspan="2">Conceptos Registrados</th>
			</tr>
			<tr>
				<th>C&oacute;digo</th>
				<th>Descripci&oacute;n</th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td></td>
			<td><a href="Edit.jsp?accion=ver&idconcepto=">Ver</a></td>
			<td><a href="Edit.jsp?accion=edit&idconcepto=">Edit</a></td>
			<td><a href="Edit.jsp?accion=borrar&idconcepto=">Del</a></td>
		</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2"><a href="Edit.jsp">Nuevo Concepto</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>