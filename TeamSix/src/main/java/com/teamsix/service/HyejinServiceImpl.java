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
	public int payInsert(Map<String, String> para) {
		return tdao.payInsert(para);
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
	
	
}
