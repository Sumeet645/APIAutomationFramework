package com.api.models.request;

public class BookingRequest {
	
	private String checkin;
	private String checkout;
	
	@Override
	public String toString() {
		return "BookingRequest [checkin=" + checkin + ", checkout=" + checkout + "]";
	}
	public BookingRequest(String checkin, String checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
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
	
	public static class Builder
	{
		private String checkin;
		private String checkout;
		
		public Builder checkin(String checkin)
		{
			this.checkin=checkin;
			return this;
		}
		
		public Builder checkout(String checkout)
		{
			this.checkout=checkout;
			return this;
		}
		
		public BookingRequest build()
		{
			BookingRequest bookingRequest=new BookingRequest(checkin,checkout);
			return bookingRequest;
			
		}
	}

}
