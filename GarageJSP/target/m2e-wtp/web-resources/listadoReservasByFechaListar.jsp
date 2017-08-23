<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.*" %>
<%@page import="com.everis.alicante.becajava.domain.*" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>GARAGE MANAGMENT APP</title>
</head>
<body>

	<h1>LISTA DE RESERVAS FILTRADAS POR FECHA</h1> </br>
	 
	<%	List<Booking> reservas = (List) request.getAttribute("reservasByFecha");
     %>
<div>
	<table border="true">
	<tr id='titulo'>
<td><b>Fecha Reserva</b></td>
<td><b>Cliente</b></td>
<td><b>Plaza</b></td>
<td><b>Veh�culo</b></td>
<td id='editar'><b>Editar</b></td>
	  <% 
		for(Booking reserva: reservas){
		
	    	out.println(reserva.toTable());
	    }
		
		%>
		
	</td></tr>
	</table>
	</div>
</body>
</html>