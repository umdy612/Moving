package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterRoom {
	private int roomsrn;
	private int theatersrn;
	private String roomname;
	private String seat_row;
	private String seat_col;
	
}