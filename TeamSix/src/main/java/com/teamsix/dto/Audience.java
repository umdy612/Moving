package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audience {
	private int audiencesrn;
	private int ticket_type;
	private String seat;
	private int paysrn;

}