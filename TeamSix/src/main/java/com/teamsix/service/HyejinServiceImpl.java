package com.teamsix.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamsix.dao.*;
import com.teamsix.dto.Movie;
import com.teamsix.dto.MovieSchedule;
import com.teamsix.dto.MyMovingTheater;
import com.teamsix.dto.Theater;
import com.teamsix.dto.TheaterList;
import com.teamsix.dto.TheaterRoom;
import com.teamsix.dto.TicketCheck;
import com.teamsix.dto.TicketCheckDetail;

@Service  
public class HyejinServiceImpl implements HyejinService {
	
	@Autowired AdminTheaterDao atdao;
	@Autowired MypageHyejinDao mhdao;
	@Autowired TicketingDao tdao;
	
	@Override
	public List<TheaterList> theaterList() {
		return atdao.theaterList();
	}
	
	@Override
	public Theater theaterCheck(int srn) {
		return atdao.theaterCheck(srn);
	}
	
	@Override
	public int theaterInsert(Theater th) {
		return atdao.theaterInsert(th);
	}
	
	@Override
	public Theater theaterForm(int srn) {
		return atdao.theaterForm(srn);
	}
	@Override
	public int theaterUpdate(Theater th) {
		return atdao.theaterUpdate(th);
	}
	@Override
	public int theaterDelete(int srn) {
		return atdao.theaterDelete(srn);
	}

	
	 @Override public int theaterRoomInsert(TheaterRoom thr) 
	 { return atdao.theaterRoomInsert(thr); }
	 
	
	@Override
	public TheaterRoom theaterRoomForm(int srn) {
		return atdao.theaterRoomForm(srn);
	}
	@Override
	public int theaterRoomUpdate(TheaterRoom thr) {
		return atdao.theaterRoomUpdate(thr);
	}
	@Override
	public int theaterRoomDelete(int srn) {
		return atdao.theaterRoomDelete(srn);
	}
	@Override
	public List<TicketCheck> ticketCheck(String userid) {
		return mhdao.ticketCheck(userid);
	}
	@Override
	public List<TicketCheckDetail> checkDetail(Map<String, Object> para) {
		return mhdao.checkDetail(para);
	}
	@Override
	public int ticketDelete(int paysrn) {
		return mhdao.ticketDelete(paysrn);
	}
	@Override
	public List<MyMovingTheater> myMovingList(String userid) {
		return mhdao.myMovingList(userid);
	}
	@Override
	public List<Movie> selectMovie() {
		return tdao.selectMovie();
	}
	@Override
	public int payInsert(Map<String, Object> para) {
		return tdao.payInsert(para);
	}
	@Override
	public int selectPaysrn() {
		return tdao.selectPaysrn();
	}
	@Override
	public int ticketInsert(Map<String, Object> para) {
		return tdao.ticketInsert(para);
	}
	@Override
	public int audienceInsert(Map<String, Object> para) {
		return tdao.audienceInsert(para);
	}

	@Override
	public List<TheaterRoom> theaterRoomList(int srn) {
		return atdao.theaterRoomList(srn);
	}

	@Override
	public List<Theater> selectTheater() {
		return tdao.selectTheater();
	}

	@Override
	public List<MovieSchedule> selectMovieSchedule(Map<String, Object> para) {
		return tdao.selectMovieSchedule(para);
	}

	@Override
	public List<Theater> selectCheckTheater(int moviesrn) {
		return tdao.selectCheckTheater(moviesrn);
	}

	@Override
	public Movie selectUmovie(int moviesrn) {
		return tdao.selectTmovie(moviesrn);
	}

	@Override
	public TheaterRoom selectUroom(int schedulesrn) {
		return tdao.selectTroom(schedulesrn);
	}

	@Override
	public MovieSchedule selectUschedule(int schedulesrn) {
		return tdao.selectTschedule(schedulesrn);
	}

	//관객타입 반환 (성인-1, 청소년-2, 경로-3)
	@Override
	public int selectUatype(String id) {
		int tickettype=0;
		if(id.contains("a")) { tickettype=1;
		}else if(id.contains("y")) { tickettype=2; 
		}else if(id.contains("o")){ tickettype=3; }
		return tickettype;
	}
	
	//관객타입의 갯수 반환 (몇장인지)
	@Override
	public int selectUasum(String id) {
		String[] arr = id.split("_");
		int typesum = Integer.parseInt(arr[1]);
		return typesum;
	}

	//선택한 타입의 총가격 반환 
	@Override
	public int selectUprice(String id) {
		int price=0;
		String[] arr = id.split("_");
		int num = Integer.parseInt(arr[1]);
		
		if(arr[0].equals("a")) {
			price = num*10000;
		}else if(arr[0].equals("y")) {
			price = num*8000;
		}else if(arr[0].equals("o")){
			price = num*6000;
		}
		return price;
	}
	
	@Override
	public List<String> selectPayedseat(int schedulesrn) {
		return tdao.selectPayedseat(schedulesrn);
	}

	@Override
	public int selectPayedsum(int schedulesrn) { 
		return tdao.selectPayedsum(schedulesrn);
	}

	// 스케줄 등록
	// 상영관 리스트 
	@Override
	public List<TheaterRoom> searchroomlist(String search) {
		return atdao.searchroomlist(search);
	}
	
}
