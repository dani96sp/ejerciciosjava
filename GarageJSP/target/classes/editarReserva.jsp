<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="com.everis.alicante.becajava.domain.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>GARAGE MANAGMENT APP</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<%@include file="menu.jsp" %>

	
	<%	Booking reserva = (Booking) request.getAttribute("reserva");	
%>
	<form method="post" action="/GarageJSP/dispatcherReserva"> 
	<input type="hidden" name="vehicleModel" value="${reserva.getVehicle().getVehiclemodel()}"/>
	<input type="hidden" name="idReserva" value="${reserva.getIdbooking()}"/>	
	
	<h4>Nombre del Cliente:</h1>
		
	<input type="text" name="name" value="${reserva.getClient().getName()}"/>
	
	<h4>Apellidos del Cliente</h1>
		
	<input type="text" name="surname" value="${reserva.getClient().getSurname()}" />

	<br/>
	
	<h4>Nif del Cliente</h1>
		
	<input type="text" name="nif" value="${reserva.getClient().getNif()}"/>

	<br/>
	<h4>Telefono del cliente</h1>
		
	<input type="text" name="tlf" value="${reserva.getClient().getTelephone()}" />

	<br/>
	<h4>Matricula de vehiculo </h1>
		
	<input type="text" name="plate" value="${reserva.getVehicle().getVehicleplate()}" />
		

	<br/>	
	
	
	<br/>
	<br/>
	<input type="submit" value="Modificar" />
	
	
	</form>

</body>
</html>