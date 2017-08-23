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

public class Dispatcher extends HttpServlet{
	static int option;
	static int idVehicle;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Date fechaInicio = null;
	
	static Date fechaFin=null;
	
	static String fechaIn="";
	static String fechaFi="";
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControladorGaraje controlador= new ControladorGarajeImpl();

		if(req.getParameter("option") != null) {
			option=Integer.parseInt(req.getParameter("option"));
	
			System.out.println("##option"+ option);
			
			
			switch (option) {
			case 1:	
				List<Parkingplace> plazas = controlador.listarPlazasLibres();		
				req.setAttribute("plazas", plazas);	
				RequestDispatcher dispatcher = req.getRequestDispatcher("listadoPlazas.jsp");
				dispatcher.forward(req, resp);
				break;
			case 2:	
				List<Parkingplace> plazasOcup = controlador.listarPlazasOcupadas();		
				req.setAttribute("plazasOcup", plazasOcup);	
				RequestDispatcher dispatcher2 = req.getRequestDispatcher("listadoPlazasOcup.jsp");
				dispatcher2.forward(req, resp);
				break;
			
			case 3 :
				List<Parkingplace> plazasLibres = controlador.listarPlazasLibres();		
				
				List<String> coches= new ArrayList<>();
				coches.add("Abarth");
				coches.add("Alfa Romeo");		
				
				req.setAttribute("plazas", plazasLibres);	
				req.setAttribute("coches", coches);
				
				RequestDispatcher dispatcher3 = req.getRequestDispatcher("altaReserva.jsp");
				dispatcher3.forward(req, resp);
	
			case 4:
				List<Client> clients = controlador.listarClientes();
				req.setAttribute("clientes", clients);
				RequestDispatcher dispatcher4 = req.getRequestDispatcher("listadoClientes.jsp");
				dispatcher4.forward(req, resp);
				break;
				
			case 5 :
				List<Booking> reservas=controlador.listarReservas();
				req.setAttribute("reservas", reservas);			
				RequestDispatcher dispatcher5 = req.getRequestDispatcher("listadoReservas.jsp");
				dispatcher5.forward(req, resp);
				
				break;
	
			case 6:
				List<Vehicle> vehicles = controlador.listarVehiculos();
				req.setAttribute("vehiculos", vehicles);
				RequestDispatcher dispatcher6 = req.getRequestDispatcher("listadoVehiculos.jsp");
				dispatcher6.forward(req, resp);
				break;
				
			case 7:		
				RequestDispatcher dispatcher7 = req.getRequestDispatcher("listadoReservasByFecha.jsp");
				dispatcher7.forward(req, resp);
				break;
				
			default:
				break;
			}
	}
		
		if(req.getParameter("idVehicle") != null) {
			idVehicle=Integer.parseInt(req.getParameter("idVehicle"));

			//alta de reservas
			String tipo=req.getParameter("tipo");
			String model=req.getParameter("model");
			String plate=req.getParameter("plate");
			String nif=req.getParameter("client");
			
			if(false) {
				req.setAttribute("message", "Ha ocurrido un error");
				RequestDispatcher disp = req.getRequestDispatcher("altaReserva.jsp");
				disp.forward(req, resp);
				
			}else {			
				Vehicle vehicle= new Vehicle();
				vehicle.setVehiclemodel(model);
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
		
				controlador.modificarCliente(idClient);
				
			
				resp.sendRedirect("menu.jsp");
			}
		}
		
		
//		if (idReserva != 0) {
//			
//			Booking reserva=controlador.listarReserva(idReserva);
//			req.setAttribute("reserva", reserva);			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("editarReserva.jsp");
//			dispatcher.forward(req, resp);
//		}
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (option==3) {
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
		
		if (option==7) {
			//listado de reservas por fecha
			ControladorGaraje controlador= new ControladorGarajeImpl();

			fechaIn=req.getParameter("fechaInicio");
			fechaFi=req.getParameter("fechaFin");
			fechaInicio = GarageMain.validarFecha(fechaIn);
			fechaFin = GarageMain.validarFecha(fechaFi);

			List<Booking> reservasByFecha=controlador.listarReservasByFecha(fechaInicio, fechaFin);			
			req.setAttribute("reservasByFecha", reservasByFecha);	
			
			RequestDispatcher dispatcher7 = req.getRequestDispatcher("listadoReservasByFechaListar.jsp");

			dispatcher7.forward(req, resp);
			
		}
		
		
	}
	
	
	
	

}
