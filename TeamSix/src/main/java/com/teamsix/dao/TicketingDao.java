package com.teamsix.dao;

import java.util.*;

import com.teamsix.dto.*;

public interface TicketingDao {
	//영화 리스트 뽑기
	public List<Movie> selectMovie(); 
	//영화관 리스트 뽑기, 첫화면
	public List<Theater> selectTheater();
	//영화관 뽑기 (영화 선택 후)
	public List<Theater> selectCheckTheater(int moviesrn);
	//상영스케줄 뽑기
	public List<MovieSchedule> selectMovieSchedule(Map<String, Object> para); //Object로 넣기 
	
	//결제완료 
	public int payInsert(Map<String, String> para);
	//예매DB에 삽입
	public int ticketInsert(Map<String, Object> para);
	//관객DB에 삽입
	public int audienceInsert(Map<String, Object> para);
	
}
