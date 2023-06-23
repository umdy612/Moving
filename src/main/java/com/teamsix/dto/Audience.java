package com.teamsix.dto;

public class Audience {
	private int audiencesrn;
	private int ticket_type;
	private String seat;
	private int paysrn;
	
	public Audience() { super(); }
	
	public Audience(int audiencesrn, int ticket_type, String seat, int paysrn) {
		super();
		this.audiencesrn = audiencesrn;
		this.ticket_type = ticket_type;
		this.seat = seat;
		this.paysrn = paysrn;
	}

	@Override
	public String toString() {
		return "Audience [audiencesrn=" + audiencesrn + ", ticket_type=" + ticket_type + ", seat=" + seat + ", paysrn="
				+ paysrn + "]";
	}
	
	public int getTicket_type() { return ticket_type; }
	public void setTicket_type(int ticket_type) { this.ticket_type = ticket_type; }  

	public int getPaysrn() { return paysrn; }
	public void setPaysrn(int paysrn) { this.paysrn = paysrn; }  

	public int getAudiencesrn() { return audiencesrn; }
	public void setAudiencesrn(int audiencesrn) { this.audiencesrn = audiencesrn; }
	
	public String getSeat() { return seat; }
	public void setSeat(String seat) { this.seat = seat; }	
}