package com.teamsix.dto;

public class TicketCheck {
	private int paysrn;
	private String title;
	private String roomname;
	private String screeningdate;
	private String screeningtime;
	public TicketCheck() { super(); }
	
	public TicketCheck(int paysrn, String title, String roomname, String screeningdate, String screeningtime) {
		super();
		this.paysrn = paysrn;
		this.title = title;
		this.roomname = roomname;
		this.screeningdate = screeningdate;
		this.screeningtime = screeningtime;
	}

	@Override
	public String toString() {
		return "TicketCheck [paysrn=" + paysrn + ", title=" + title + ", roomname=" + roomname + ", screeningdate="
				+ screeningdate + ", screeningtime=" + screeningtime + "]";
	}

	public int getPaysrn() { return paysrn; }  public void setPaysrn(int paysrn) { this.paysrn = paysrn; }
	public String getTitle() { return title; }  public void setTitle(String title) { this.title = title; }
	public String getRoomname() { return roomname; }  public void setRoomname(String roomname) { this.roomname = roomname; }
	public String getScreeningdate() { return screeningdate; }  public void setScreeningdate(String screeningdate) { this.screeningdate = screeningdate; }
	public String getScreeningtime() { return screeningtime; }  public void setScreeningtime(String screeningtime) { this.screeningtime = screeningtime; }
	
	
}
