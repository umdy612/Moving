package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	private String totalprice;
	private String paymentmethod;
	private String paydate;
	private String payip;
	private int paysrn;
	
}