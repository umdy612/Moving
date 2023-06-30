package com.teamsix.dao;

import java.util.*;

import com.teamsix.dto.*;

public interface MypageHyejinDao {
	//마이페이지 예매내역 확인
	public List<TicketCheck> ticketCheck(String userid);   
	//예매내역 상세보기 
	public List<TicketCheckDetail> checkDetail(Map<String, Object> para); //##
	//예매내역 취소하기
	public int ticketDelete(int paysrn);
	// 자주가는 무빙
	public List<MyMovingTheater> myMovingList(String userid);
}
