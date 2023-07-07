package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	private int moviesrn;
	private String title;
	private String director;
	private String genre;
	private String rating;
	private String detail;
	private String poster;
	private String runningtime;
	private String link;
	private String releasedate;
	private String closedate;
	private float star;
	private int isRelease;
	
}