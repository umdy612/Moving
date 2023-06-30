package com.teamsix.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamsix.dto.*;
import com.teamsix.service.HyejinService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value="/hj/")
@Log4j
public class HyejinController {
	
	@Autowired HyejinService service;
	
	@GetMapping(value="/theaterlist.hj")    //영화관리스트
	public String list(Model model) {
		model.addAttribute("list", service.theaterList());
		return "TheaterList";
	}

	@GetMapping(value="/theaterreg.hj") //영화관등록view
	public String register_view() {
		return "TheaterRegister";
	}
	 
	@PostMapping(value="/theaterreg.hj") //영화관등록기능(영화관 등록)
	public String register(Theater vo, RedirectAttributes rttr) {
		String result = "영화관 등록에 실패하였습니다.";
		if(service.theaterInsert(vo)>0) {result="영화관이 등록되었습니다.";}
		rttr.addFlashAttribute("insert", result);
		return "redirect:/hj/theaterlist.hj";
	}
	
	@GetMapping(value="/theateredit.hj") //영화관수정뷰
	public String edit_view(Theater vo ,Model model) {
		model.addAttribute("theater", service.theaterCheck(vo.getTheatersrn()));
		model.addAttribute("room", service.theaterRoomList(vo.getTheatersrn()));
		return "TheaterEdit";
	}
	
	@PostMapping(value="/theateredit.hj") //영화관수정기능
	public String edit(Theater vo, RedirectAttributes rttr) {
		String result = "정보 수정에 실패하였습니다.";
		if(service.theaterUpdate(vo)>0) {result="정보가 수정되었습니다.";}
		rttr.addFlashAttribute("update", result);
		return "redirect:/hj/theaterlist.hj";     //value값으로 보내야지...jsp가 아니라...
	}
	
	@GetMapping(value="/theaterdelete.hj") //영화관삭제기능
	public String delete(@RequestParam("theatersrn") int theatersrn, RedirectAttributes rttr) { 
		String result = "영화관이 삭제에 실패했습니다.";
		if(service.theaterDelete(theatersrn)>0) {result="영화관이 삭제되었습니다.";}
		rttr.addFlashAttribute("deletem", result);
		return "redirect:/hj/theaterlist.hj";
	}
	
	@GetMapping(value="/roomreg.hj") //상영관등록view
	public String roomregister_view(@RequestParam("theatersrn") int theatersrn, Model model) {
		model.addAttribute("theatersrn", theatersrn);
		return "TheaterRoomRegister";
	}
	
	@PostMapping(value="/roomreg.hj") //상영관등록기능
	public String roomregister(TheaterRoom rvo, Model model, RedirectAttributes rttr) {
		String result = "상영관 추가에 실패하였습니다.";
		if(service.theaterRoomInsert(rvo)>0) {result="상영관이 추가되었습니다.";}
		rttr.addFlashAttribute("roominsert", result);
		return "redirect:/hj/theateredit.hj?theatersrn="+rvo.getTheatersrn();
	}
	
	@GetMapping(value="/roomedit.hj") //상영관수정view
	public String roomedit_view(TheaterRoom rvo, Model model) {
		model.addAttribute("room", service.theaterRoomForm(rvo.getRoomsrn()));
		return "TheaterRoomEdit";
	}
	
	@PostMapping(value="/roomedit.hj") //상영관수정기능
	public String roomedit(TheaterRoom rvo, Model model, RedirectAttributes rttr) {
		String result = "상영관 정보 수정에 실패하였습니다.";
		if(service.theaterRoomUpdate(rvo)>0) {result="상영관 정보가 수정되었습니다.";}
		rttr.addFlashAttribute("roomupdate", result);
		return "redirect:/hj/theateredit.hj?theatersrn="+rvo.getTheatersrn();
	}
	
	@GetMapping(value="/roomdelete.hj") //상영관삭제기능
	public String roomdelete(@RequestParam("roomsrn") int roomsrn, 
							 @RequestParam("theatersrn") int theatersrn,
							RedirectAttributes rttr) {
		String result = "상영관 삭제에 실패하였습니다.";
		if(service.theaterRoomDelete(roomsrn)>0) {result="상영관이 삭제되었습니다.";}
		rttr.addFlashAttribute("roomdelete", result);
		return "redirect:/hj/theateredit.hj?theatersrn="+theatersrn;
	}

}
