package com.journeyer.etour.services;



import com.journeyer.etour.modal.Booking;

public interface BookingService {
	
	public void postbooking(Booking booking);

	public void canceltours(int bookingid);
	
	public void deletetour(int bookingid);
}
