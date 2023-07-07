package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticketing {
	private int schedulesrn;
	private String ticketingdate;
	private int paysrn;
	private String userid;

}