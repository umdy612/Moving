package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

public interface AdminMovieDao {
	public int movieInsert(Movie vo);
	public List<Movie> movieList();
	public Movie movieDetail(Movie vo);	
	public int movieUpdate(Movie vo);
	public int movieDelete(Movie vo);
}
