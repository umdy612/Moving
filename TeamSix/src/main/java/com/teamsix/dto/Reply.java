package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	private int replysrn;
	private String userid;
	private int moviesrn;
	private String replycontent;
	private int star;
	private String replydate;
	private String replyip;

}