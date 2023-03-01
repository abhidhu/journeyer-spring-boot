package com.journeyer.etour.services;



import com.journeyer.etour.modal.Booking;

import java.util.List;

public interface BookingService {
	
	public void postbooking(Booking booking);

	public void canceltours(int bookingid);
	
	public void deletetour(int bookingid);
	
	public List<Booking> getBookingByCustId(int id);
}
