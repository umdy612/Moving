package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.MypageReply;

public interface MypageReplyDao {
	public List<MypageReply> myReply(String userid);
}
