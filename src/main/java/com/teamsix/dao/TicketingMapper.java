package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

public interface TicketingMapper {
	//영화 리스트 뽑기
	public List<Movie> selectMovie(); 
	//영화관 리스트 뽑기
	public List<Theater> selectTheater();
	//상영스케줄 뽑기
	public List<MovieSchedule> selectMovieSchedule(Movie m, Theater th);
	//티켓등급 선택
	public int ticketType(); 
	//좌석 선택
	public int seatInsert();
	//결제완료 
	public int payInsert();
}
