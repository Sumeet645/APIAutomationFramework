package com.api.models.request;

public class CreateBookingRequest {
	
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingRequest bookingdates;
	private String additionalneeds;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public BookingRequest getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(BookingRequest bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	
	
	public CreateBookingRequest(String firstname, String lastname, int totalprice, boolean depositpaid,
			BookingRequest bookingdates, String additionalneeds) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}
	
	@Override
	public String toString() {
		return "CreateBookingRequest [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositPaid=" + depositpaid + ", bookingRequests=" + bookingdates + ", additionalNeeds="
				+ additionalneeds + "]";
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public static class Builder
	{
		private String firstname;
		private String lastname;
		private int totalprice;
		private boolean depositpaid;
		private BookingRequest bookingdates;
		private String additionalneeds;
		
		public Builder firstname(String firstname)
		{
			this.firstname=firstname;
			return this;
		}
		
		public Builder lastname(String lastname)
		{
			this.lastname=lastname;
			return this;
		}
		
		public Builder totalprice(int totalprice)
		{
			this.totalprice=totalprice;
			return this;
		}
		
		public Builder depositpaid(boolean depositpaid)
		{
			this.depositpaid=depositpaid;
			return this;
		}
		
		public Builder bookingdates(BookingRequest bookingdates)
		{
			this.bookingdates=bookingdates;
			return this;
		}
		
		public Builder additionalneeds(String additionalneeds)
		{
			this.additionalneeds=additionalneeds;
			return this;
		}
		
		public CreateBookingRequest build()
		{
			CreateBookingRequest createBookingRequest=new CreateBookingRequest(firstname,lastname,totalprice,depositpaid,bookingdates,additionalneeds);
			return createBookingRequest;
		}
	}

}
