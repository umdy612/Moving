package com.teamsix.dto;

public class Ticketing {
	private int schedulesrn;
	private String ticketingdate;
	private int paysrn;
	private String userid;
	
	public Ticketing() { super(); }
	
	public Ticketing(int schedulesrn, String ticketingdate, int paysrn, String userid) {
		super();
		this.schedulesrn = schedulesrn;
		this.ticketingdate = ticketingdate;
		this.paysrn = paysrn;
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Ticketing [schedulesrn=" + schedulesrn + ", ticketingdate=" + ticketingdate + ", paysrn=" + paysrn
				+ ", userid=" + userid + "]";
	}

	public int getSchedulesrn() { return schedulesrn; }
	public void setSchedulesrn(int schedulesrn) { this.schedulesrn = schedulesrn; }

	public int getPaysrn() { return paysrn; }
	public void setPaysrn(int paysrn) { this.paysrn = paysrn; }

	public String getUserid() { return userid; }
	public void setUserid(String userid) { this.userid = userid; }

	public String getTicketingdate() { return ticketingdate; }
	public void setTicketingdate(String ticketingdate) { this.ticketingdate = ticketingdate; }	
}