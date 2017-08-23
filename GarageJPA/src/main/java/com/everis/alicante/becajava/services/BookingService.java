package com.everis.alicante.becajava.services;

import java.util.Date;
import java.util.List;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.domain.Client;
import com.everis.alicante.becajava.domain.Parkingplace;
import com.everis.alicante.becajava.domain.Vehicle;

public interface BookingService {
	
	List<Booking> findByDate(Date fechaInicio, Date fechaFin);
	
	List<Booking>list();
	
	void create(Booking booking);

	Booking findBookingById(int idBooking);

	void updateBooking(Booking booking);
	
	void deleteBooking(Booking booking);

	
}
