package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

public interface MypageMapper_hyejin {
	//마이페이지 예매내역 확인
	public List<TicketCheck> ticketCheck();   
	//예매내역 상세보기 
	public List<TicketCheckDetail> checkDetail();
	//예매내역 취소하기
	public int ticketDelete();
	// 자주가는 무빙
	public List<MyMovingTheater> myMovingList();
}
