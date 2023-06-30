package com.teamsix.service;

import java.util.List;
import java.util.Map;

import com.teamsix.dto.*;

public interface HyejinService {
	//관리자_영화관등록
	// 영화관 리스트 및 해당 영화관 읽기
	public List<TheaterList> theaterList();
	public Theater theaterCheck(int srn); // 해당 영화관 정보_상영관리스트랑 같이
		
	// 영화관 등록하기
	public int theaterInsert(Theater th);
	// 영화관 수정하기 폼
	public Theater theaterForm(int srn);
	// 영화관 수정하기
	public int theaterUpdate(Theater th);
	// 영화관 삭제하기
	public int theaterDelete(int srn);
		
	// 상영관 리스트
	public List<TheaterRoom> theaterRoomList(int srn); // 영화관srn을 통해 상영관list뽑기 + 해당 영화관 읽기
	// 상영관 등록하기 
	public int theaterRoomInsert(TheaterRoom thr); 
	// 상영관 수정하기 폼
	public TheaterRoom theaterRoomForm(int srn);
	// 상영관 수정하기
	public int theaterRoomUpdate(TheaterRoom thr);
	// 상영관 삭제하기
	public int theaterRoomDelete(int srn);
	
	//마이페이지
	//마이페이지 예매내역 확인
	public List<TicketCheck> ticketCheck(String userid);   
	//예매내역 상세보기 
	public List<TicketCheckDetail> checkDetail(Map<String, Object> para); //##
	//예매내역 취소하기
	public int ticketDelete(int paysrn);
	// 자주가는 무빙
	public List<MyMovingTheater> myMovingList(String userid);
	
	//예매하기
	//영화 리스트 뽑기 + 영화관 + 상영스케줄
	public List<Movie> selectMovie(); 
	//영화관 리스트 뽑기
	public List<Theater> selectTheater();
	//상영스케줄 뽑기
	public List<MovieSchedule> selectMovieSchedule(Map<String, Object> para); //Object로 넣기 
		
	//결제완료 
	public int payInsert(Map<String, String> para);
	//예매DB에 삽입
	public int ticketInsert(Map<String, Object> para);
	//관객DB에 삽입
	public int audienceInsert(Map<String, Object> para);
}
