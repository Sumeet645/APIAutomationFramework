package com.api.models.response;

public class BookingDatesRes {
	
	private String checkin;
	private String checkout;
	
	public BookingDatesRes(String checkin, String checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public BookingDatesRes()
	{
		
	}
	@Override
	public String toString() {
		return "BookingRequestRes [checkin=" + checkin + ", checkout=" + checkout + "]";
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}
