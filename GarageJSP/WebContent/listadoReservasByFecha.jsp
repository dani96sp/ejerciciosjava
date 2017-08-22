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
		<form method="post" action="/GarageJSP/dispatcher"> 
	<input type="hidden" name="tipo" value="listar"/>
	
	<h4>Fecha Inicio: (FORMATO DD/MM/YYYY)</h1>
		
	<input type="text" name="fechaInicio" />
	
	<h4>Fecha Fin: (FORMATO DD/MM/YYYY)</h1>
		
	<input type="text" name="fechaFin" />
	

	<br/>
	<br/>
	<input type="submit" value="Listar" />
	
	
	</form>
	
</body>
</html>