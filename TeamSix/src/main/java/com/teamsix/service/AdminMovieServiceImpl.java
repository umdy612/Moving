package com.teamsix.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.teamsix.dao.AdminMovieDao;
import com.teamsix.dto.Movie;

@Service
public class AdminMovieServiceImpl implements AdminMovieService{


	@Autowired AdminMovieDao dao;
	
	@Override
	public int movieInsert(MultipartFile file, HttpServletRequest request, Movie vo) {
		vo.setPoster( fileUpload(file, request) );
		return dao.movieInsert(vo);
	}

	@Override
	public List<Movie> movieList() {
		return dao.movieList();
	}

	@Override
	public Movie movieDetail(Movie vo) {
		return dao.movieDetail(vo);
	}

	@Transactional
	@Override
	public int movieUpdate(MultipartFile file, HttpServletRequest request, Movie vo) {

		vo.setPoster( dao.movieDetail(vo).getPoster() );
		
		String saved = "";
		if(file.getOriginalFilename().length() != 0) {
			saved = fileUpload(file, request);
			vo.setPoster(saved);
		}
		
		return dao.movieUpdate(vo);
	}

	@Override
	public int movieDelete(Movie vo) {
		return dao.movieDelete(vo);
	}
	
	private String fileUpload(MultipartFile file, HttpServletRequest request) {
		//파일 이름 중복 안되게 고유값 설정
		UUID uid = UUID.randomUUID();
		String saved = uid.toString()+"_"+file.getOriginalFilename();
		//파일 업로드
		String uploadPath = "C:\\TeamSix_poster";
		
		File target = new File(uploadPath, saved);
		try {
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) { e.printStackTrace(); }
	
		return saved;
	}
	
}
