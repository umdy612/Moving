package com.teamsix.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.teamsix.dto.Movie;

public interface AdminMovieService {
	
	public int movieInsert(MultipartFile file, HttpServletRequest request, Movie vo);
	public List<Movie> movieList();
	public Movie movieDetail(Movie vo);	
	public int movieUpdate(MultipartFile file, HttpServletRequest request,Movie vo);
	public int movieDelete(Movie vo);
}
