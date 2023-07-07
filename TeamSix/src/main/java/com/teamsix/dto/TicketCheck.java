package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCheck {
	private int paysrn;
	private String title;
	private String roomname;
	private String screeningdate;
	private String screeningtime;
	
}
