package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userid;
	private String userpass;
	private String username;
	private String userbirth;
	private String userphone;
	private String useremail;
	private String userip;
	private String userregdate;
	
}