<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<title>GARAGE MANAGMENT APP</title>
</head>
<body>

	<label>Elige una opción : </br></label>

	 </br>
	<div id="menu">
		 <ul>
		<li><a href="/GarageJSP/dispatcher?option=1">[1] - Listar Plazas Garaje Libre </br></a></li>
		<li> <a href="/GarageJSP/dispatcher?option=2">[2] - Listar Plazas Garaje Ocupadas </br></a></li>
		<li> <a href="/GarageJSP/dispatcher?option=3">[3] - Reservar Plazas</br></a></li>
		<li> <a href="/GarageJSP/dispatcher?option=4">[4] - Listar Clientes</br></a>	</li>
		<li> <a href="/GarageJSP/dispatcher?option=5">[5] - Listar Reservas</br></a>	</li>
		 <li><a href="/GarageJSP/dispatcher?option=6">[6] - Listar Vehiculos</br></a></li>
		<li> <a href="/GarageJSP/dispatcher?option=7">[7] - Listar por Fecha de Reserva</br></a></li>
		</ul>
	 </div>


</body>
</html>