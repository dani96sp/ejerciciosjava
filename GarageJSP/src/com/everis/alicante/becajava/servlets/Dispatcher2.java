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

public class Dispatcher2 extends HttpServlet{
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
			
			Booking reserva=controlador.listarReserva(idReserva);
			req.setAttribute("reserva", reserva);			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("editarReserva.jsp");
			dispatcher.forward(req, resp);
		}
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//alta de reservas
		
		String name=req.getParameter("name");
		String surname=req.getParameter("surname");
		String nif=req.getParameter("nif");
		String tlf=req.getParameter("tlf");
		String plate=req.getParameter("plate");
		String vehicleModel=req.getParameter("vehicleModel");
				
		Vehicle vehicle= new Vehicle();
		vehicle.setVehiclemodel(vehicleModel);
		vehicle.setVehicleplate(plate);
		
		Set<Vehicle> vehicles= new HashSet<>();
		vehicles.add(vehicle);
		
		Client client= new Client();
		client.setName(name);
		client.setSurname(surname);
		client.setNif(nif);
		client.setTelephone(tlf);
		client.setVehicles(vehicles);
		
		vehicle.setClient(client);
		
		ControladorGaraje controladorGaraje= new ControladorGarajeImpl();
		controladorGaraje.reservarPlaza(client, vehicle);
		
		resp.sendRedirect("menu.jsp");
		
		
		
		
	}
	
	
	
	

}
