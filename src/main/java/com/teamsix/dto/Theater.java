package com.teamsix.dto;

public class Theater {
	private int theatersrn;
	private String theatername;
	private String location;
	private String manager;
	private String contactnum;
	
	public Theater() { super(); }
	
	public Theater(int theatersrn, String theatername, String location, String manager, String contactnum) {
		super();
		this.theatersrn = theatersrn;
		this.theatername = theatername;
		this.location = location;
		this.manager = manager;
		this.contactnum = contactnum;
	}
	
	@Override
	public String toString() {
		return "Theater [theatersrn=" + theatersrn + ", theatername=" + theatername + ", location=" + location
				+ ", manager=" + manager + ", contactnum=" + contactnum + "]";
	}
	
	public int getTheatersrn() { return theatersrn; }
	public void setTheatersrn(int theatersrn) { this.theatersrn = theatersrn; }
	
	public String getTheatername() { return theatername; }
	public void setTheatername(String theatername) { this.theatername = theatername; }
	
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
	
	public String getManager() { return manager; }
	public void setManager(String manager) { this.manager = manager; }
	
	public String getContactnum() { return contactnum; }
	public void setContactnum(String contactnum) { this.contactnum = contactnum; }	
}