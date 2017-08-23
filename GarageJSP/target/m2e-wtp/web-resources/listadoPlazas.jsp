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
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<%@include file="menu.jsp" %>
<div>

	<h1>LISTA DE PLAZAS DISPONIBLES</h1>
	 
	<%	List<Parkingplace> plazas = (List) request.getAttribute("plazas");
	
	 	out.println("<br/>");
		for(Parkingplace plaza: plazas){
	    	out.println(plaza + "<br/>");
	    }
    
     %>
	
	</div>
</body>
</html>