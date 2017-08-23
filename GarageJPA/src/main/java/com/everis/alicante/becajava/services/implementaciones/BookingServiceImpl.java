package com.everis.alicante.becajava.services.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Collection;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.interfaces.BookingDAO;
import com.everis.alicante.becajava.services.BookingService;



public class BookingServiceImpl implements BookingService {

	
	BookingDAO bookingDao;	
	
	@Override
	public void create(Booking booking) {	
		
		bookingDao.create(booking);		

	}

	@Override
	public List<Booking> list() {
	
		return  bookingDao.findAll();
	}

	@Override
	public Booking findBookingById(int idBooking) {
		return bookingDao.readById(idBooking);
	}

	public BookingDAO getBookingDao() {
		return bookingDao;
	}

	public void setBookingDao(BookingDAO bookingDao) {
		this.bookingDao = bookingDao;
	}

	public BookingServiceImpl(BookingDAO bookingDao) {
		super();
		this.bookingDao = bookingDao;
	}

	@Override
	public List<Booking> findByDate(Date fechaInicio, Date fechaFin) {
		List<Booking> listado = bookingDao.findAll();
		List<Booking> reservas = new ArrayList<>();
		for (Booking booking : listado) {
			if(booking.getBookingdate().before(fechaFin)&&booking.getBookingdate().after(fechaInicio)){
				reservas.add(booking);
				System.out.println(booking);
			}
		}
		return reservas;

	}
	
	

	

	

}
