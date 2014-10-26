<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaccion</title>
</head>
<body>
	<form action="Edit.jsp" method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2">Transacción</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>C&oacute;digo</td>
					<td><input type="text" name="idtransaccion" value="" disabled /></td>
				</tr>
				<tr>
					<td>Fecha de transacci&oacute;n</td>
					<td><input type="text" name="fecha_transaccion" value="" /></td>
					<td>Fecha de aplicaci&oacute;n</td>
					<td><input type="text" name="fecha_aplicada" value="" /></td>
					<td>Monto de transacci&oacute;n</td>
					<td><input type="text" name="monto_transaccion" value="" /></td>
				</tr>
				<tr>
					<td>Concepto</td>
					<td><select name="idconcepto">
						</select>
					</td>
				</tr>
				<tr>
					<td>No. de Tarjeta</td>
					<td><select name="idtarjetacredito">
						</select>
					</td>
				</tr>
				<tr>
					<td>Cliente</td>
					<td><select name="idcliente">
						</select>
					</td>
				</tr>
				<tr>
					<td>Fecha de vencimiento</td>
					<td><input type="text" name="fecha_limite_pago" value="" /></td>
				</tr>
				<tr>
					<td>Pais</td>
					<td><input type="text" name="idpais" value="" /></td>
				</tr>
				<tr>
					<td>Tipo de movimiento</td>
					<td><input type="radio" name="b_cargo" value="S"  />Masculino</td>
					<td><input type="radio" name="b_abono" value="S"  />Femenino</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>