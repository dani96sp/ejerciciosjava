package com.everis.alicante.becajava.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.domain.Client;
import com.everis.alicante.becajava.domain.Parkingplace;
import com.everis.alicante.becajava.domain.Vehicle;
import com.everis.alicante.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.becajava.garage.controller.ControladorGarajeImpl;
import com.everis.alicante.becajava.garage.GarageMain;

public class DispatcherReservaBorrar extends HttpServlet{
	static int idReserva;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		idReserva=Integer.parseInt(req.getParameter("idReserva"));

		System.out.println("##idReserva"+ idReserva);
		
		ControladorGaraje controlador= new ControladorGarajeImpl();
		
	

		if (idReserva != 0) {
			controlador.eliminarReserva(idReserva);
	
			resp.sendRedirect("listadoReservas.jsp");
		}
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		}
				
}
