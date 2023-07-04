package com.teamsix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsix.dao.MypageReplyDao;
import com.teamsix.dto.MypageReply;

@Service
public class MypageReplyServiceImpl implements MypageReplyService{
	@Autowired MypageReplyDao dao;
	@Override
	public List<MypageReply> myReply(String userid) {
		return dao.myReply(userid);
	}
}
