package com.teamsix.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamsix.service.MypageReplyService;

@Controller
@RequestMapping("/hi/mypage/*")
public class Hi_MypageController {

	@Autowired MypageReplyService service;
	
	@GetMapping("/MyPage_reply")
	public String movieInsert_view(HttpServletRequest request, Model model) {
		//model.addAttribute("reply", service.myReply(request.getSession().getId()));
		model.addAttribute("reply", service.myReply("mhj9149"));
		return "mypage/MyPage_reply";
	}

}
