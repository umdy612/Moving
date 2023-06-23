package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

public interface AdminMovieMapper {
	public int moiveInsert();
	public List<Movie> movieList();
	public int movieUpdate();
	public int movieDelete();
}
