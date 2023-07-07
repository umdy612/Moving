package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCheckDetail {
	private String audience_type;
	private int numbers;
	private String seat;
}
