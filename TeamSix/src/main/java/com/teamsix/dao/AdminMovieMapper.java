package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

@TeamSixMapper
public interface AdminMovieMapper {
	public int movieInsert(Movie mo);
	public List<Movie> movieList();
	public int movieUpdate(Movie mo);
	public int movieDelete(int no);
}
