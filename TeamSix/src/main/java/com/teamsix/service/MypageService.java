package com.teamsix.service;

import java.util.List;

import com.teamsix.dto.MypageReply;

public interface MypageService {

	public List<MypageReply> myReply(String userid);
}
