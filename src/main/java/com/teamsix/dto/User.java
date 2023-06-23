package com.teamsix.dto;

public class User {
	private String userid;
	private String userpass;
	private String username;
	private String userbirth;
	private String userphone;
	private String useremail;
	private String userip;
	private String userregdate;
	
	public User() { super(); }
	
	public User(String userid, String userpass, String username, String userbirth, String userphone, String useremail,
			String userip, String userregdate) {
		super();
		this.userid = userid;
		this.userpass = userpass;
		this.username = username;
		this.userbirth = userbirth;
		this.userphone = userphone;
		this.useremail = useremail;
		this.userip = userip;
		this.userregdate = userregdate;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userpass=" + userpass + ", username=" + username + ", userbirth="
				+ userbirth + ", userphone=" + userphone + ", useremail=" + useremail + ", userip=" + userip
				+ ", userregdate=" + userregdate + "]";
	}
	
	public String getuserid() { return userid;	}
	public void setuserid(String userid) {	this.userid = userid; }
	
	public String getUserpass() { return userpass; }
	public void setUserpass(String userpass) { this.userpass = userpass; }
	
	public String getUsername() { return username;	}
	public void setUsername(String username) { this.username = username; }
	
	public String getUserbirth() { return userbirth; }
	public void setUserbirth(String userbirth) { this.userbirth = userbirth; }
	
	public String getUserphone() { return userphone; }
	public void setUserphone(String userphone) { this.userphone = userphone; }
	
	public String getUseremail() { return useremail; }
	public void setUseremail(String useremail) { this.useremail = useremail; }
	
	public String getUserip() { return userip; }
	public void setUserip(String userip) { this.userip = userip; }
	
	public String getUserregdate() { return userregdate; }
	public void setUserregdate(String userregdate) { this.userregdate = userregdate; }
	
}