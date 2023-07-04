package com.teamsix.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamsix.dto.Movie;
import com.teamsix.service.AdminMovieService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/hi/admin_movie/*")
@Log4j
public class Hi_AdminMovieController {
	@Autowired AdminMovieService service;
	
	@RequestMapping(value="/adminMovie.hi")
	public String adminMain(Model model) { model.addAttribute("list", service.movieList());  return "admin_movie/adminMovieList"; }
	
	
	@GetMapping("/movieInsert")
	public String movieInsert_view() {
		return "admin_movie/movieInsert";
	}

	@PostMapping("/movieInsert")
	public String movieInsert(MultipartFile file, HttpServletRequest request, Movie movie, RedirectAttributes rttr) {
		String result = "등록 실패";
		if (service.movieInsert(file, request, movie) > 0) {
			result = "글쓰기 성공";
		}
		rttr.addFlashAttribute("success", result);
		return "redirect:/hi/admin_movie/adminMovie.hi";
	}

	@GetMapping("/movieUpdate")
	public void update_view(Movie movie, Model model) {
		model.addAttribute(service.movieDetail(movie));
	}

	@PostMapping("/movieUpdate")
	public String movieUpdate(MultipartFile file, HttpServletRequest request, Movie movie, RedirectAttributes rttr) {
		String result = "업데이트 실패";
		if (service.movieUpdate(file, request, movie) > 0) {
			result = "업데이트 성공";
		}
		rttr.addFlashAttribute("success", result);
		return "redirect:/hi/admin_movie/adminMovie.hi";
	}

	@GetMapping("/movieDelete")
	public String movieDelete(Movie movie, RedirectAttributes rttr) {
		log.info("..........................delete");
			String result = "삭제 실패";
			if(service.movieDelete(movie) > 0) { result = "삭제 성공"; }
			rttr.addFlashAttribute("success", result);
		return "redirect:/hi/admin_movie/adminMovie.hi";
	}
	
}
