package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

public interface AdminTheaterDao {
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
	public List<TheaterRoom> theaterRoomList(int srn); // 영화관srn을 통해 상영관list뽑기 
	// 상영관 등록하기 
	public int theaterRoomInsert(TheaterRoom thr);
	// 상영관 수정하기 폼
	public TheaterRoom theaterRoomForm(int srn);
	// 상영관 수정하기
	public int theaterRoomUpdate(TheaterRoom thr);
	// 상영관 삭제하기
	public int theaterRoomDelete(int srn);
	
	// 상영스케줄 만들기
	// 영화관 지점명 검색 후 상영관 리스트 띄우기 
	public List<TheaterRoom> searchroomlist(String search);
	
}
