package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSchedule {
	private int schedulesrn;
	private String screeningdate;
	private String screeningtime;
	private int moviesrn;
	private int roomsrn;
	private String roomname;
	
}