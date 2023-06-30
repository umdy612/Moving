package com.teamsix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamsix.dao.AdminMovieMapper;
import com.teamsix.dto.Movie;

@Controller
public class AdminController {
	
	@Autowired AdminMovieMapper dao;

	@RequestMapping("/admin")
	public String home(){ return "admin"; }
	
	@RequestMapping( value="/movieList", method=RequestMethod.GET )
	@ResponseBody
	public List<Movie> getUserList() {
		return dao.movieList();
	}
	
}
