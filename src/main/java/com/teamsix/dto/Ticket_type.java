package com.teamsix.dto;

public class Ticket_type {
	private int ticket_type;
	private String price;
	private String audience_type;
	
	public Ticket_type() { super(); }
	
	public Ticket_type(int ticket_type, String price, String audience_type) {
		super();
		this.ticket_type = ticket_type;
		this.price = price;
		this.audience_type = audience_type;
	}

	@Override
	public String toString() {
		return "Ticket_type [ticket_type=" + ticket_type + ", price=" + price + ", audience_type=" + audience_type
				+ "]";
	}

	public String getAudience_type() { return audience_type; }  
	public void setAudience_type(String audience_type) { this.audience_type = audience_type; }

	public int getTicket_type() { return ticket_type; }
	public void setTicket_type(int ticket_type) { this.ticket_type = ticket_type; }
	
	public String getPrice() { return price; }
	public void setPrice(String price) { this.price = price; }	
}