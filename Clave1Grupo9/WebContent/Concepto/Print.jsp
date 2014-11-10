<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.sv.ues.igf.controlador.ConceptoCtrl" %>
<%@ page import="java.io.OutputStream" %>
<%
	ConceptoCtrl ctrl = new ConceptoCtrl();
	byte[] bytes = ctrl.reporte();
	if(bytes!=null){
		System.out.println("imprime aqui if");
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", "attachment; filename=informe.pdf" );
		response.setContentLength(bytes.length);
		OutputStream ouputStream = response.getOutputStream();
		ouputStream.write(bytes, 0, bytes.length);
		ouputStream.flush();
		ouputStream.close();
	}else{
		System.out.println("imprime aqui else");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
	
	<title>UES-IGF115-Clave1-Grupo9-2014</title>
</head>
<body>
<div id="wrap">
	Absolute Path is:
</div>
</body>
</html>