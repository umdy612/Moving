package com.teamsix.dao;

import java.util.*;

import com.teamsix.dto.*;

public interface MypageHyejinDao {
	public List<TicketCheck> ticketCheck(String userid);   
	public List<TicketCheckDetail> checkDetail(Map<String, Object> para); //##
	public int ticketDelete(int paysrn);
	public List<MyMovingTheater> myMovingList(String userid);
}
