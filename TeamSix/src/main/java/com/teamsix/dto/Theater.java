package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
	private int theatersrn;
	private String theatername;
	private String location;
	private String manager;
	private String contactnum;

}