package com.teamsix.service;

import java.util.List;

import com.teamsix.dto.MypageReply;

public interface MypageReplyService {
	public List<MypageReply> myReply(String userid);
}
