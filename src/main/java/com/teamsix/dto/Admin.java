package com.teamsix.dto;

public class Admin {
	private String adminid;
	private String adminpass;
	private String adminname;
	
	public Admin() { super(); }
	
	public Admin(String adminid, String adminpass, String adminname) {
		super();
		this.adminid = adminid;
		this.adminpass = adminpass;
		this.adminname = adminname;
	}
	
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminpass=" + adminpass + ", adminname=" + adminname + "]";
	}
	
	public String getAdminid() { return adminid; }
	public void setAdminid(String adminid) { this.adminid = adminid; }
	
	public String getAdminpass() { return adminpass; }
	public void setAdminpass(String adminpass) { this.adminpass = adminpass; }
	
	public String getAdminname() { return adminname; }
	public void setAdminname(String adminname) { this.adminname = adminname; }	
}