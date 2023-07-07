package com.teamsix.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamsix.common.TSKakaoPay;
import com.teamsix.dto.*;
import com.teamsix.service.HyejinService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value="/hj/")
@Log4j
public class HyejinController {
	
	@Autowired HyejinService service;
	@Autowired TSKakaoPay kakaopay;
	
	
	@RequestMapping(value="/theaterlist.hj", method=RequestMethod.GET)
	//@GetMapping(value="/theaterlist.hj")    //영화관리스트
	public String list(Model model) {
		model.addAttribute("list", service.theaterList());
		return "TheaterList";
	}

	@RequestMapping(value="/theaterreg.hj", method=RequestMethod.GET)
	//@GetMapping(value="/theaterreg.hj") //영화관등록view
	public String register_view() {
		return "TheaterRegister";
	}
	

	@RequestMapping(value="/theaterreg.hj", method=RequestMethod.POST)
	//@PostMapping(value="/theaterreg.hj") //영화관등록기능(영화관 등록)
	public String register(Theater vo, RedirectAttributes rttr) {
		String result = "영화관 등록에 실패하였습니다.";
		if(service.theaterInsert(vo)>0) {result="영화관이 등록되었습니다.";}
		rttr.addFlashAttribute("insert", result);
		return "redirect:/hj/theaterlist.hj";
	}
	
	@RequestMapping(value="/theateredit.hj", method=RequestMethod.GET)
	//@GetMapping(value="/theateredit.hj") //영화관수정뷰
	public String edit_view(Theater vo ,Model model) {
		model.addAttribute("theater", service.theaterCheck(vo.getTheatersrn()));
		model.addAttribute("room", service.theaterRoomList(vo.getTheatersrn()));
		return "TheaterEdit";
	}
	
	@RequestMapping(value="/theateredit.hj", method=RequestMethod.POST)
	//@PostMapping(value="/theateredit.hj") //영화관수정기능
	public String edit(Theater vo, RedirectAttributes rttr) {
		String result = "정보 수정에 실패하였습니다.";
		if(service.theaterUpdate(vo)>0) {result="정보가 수정되었습니다.";}
		rttr.addFlashAttribute("update", result);
		return "redirect:/hj/theaterlist.hj";     //value값으로 보내야지...jsp가 아니라...
	}
	
	@RequestMapping(value="/theaterdelete.hj", method=RequestMethod.GET)
	//@GetMapping(value="/theaterdelete.hj") //영화관삭제기능
	public String delete(@RequestParam("theatersrn") int theatersrn, RedirectAttributes rttr) { 
		String result = "영화관이 삭제에 실패했습니다.";
		if(service.theaterDelete(theatersrn)>0) {result="영화관이 삭제되었습니다.";}
		rttr.addFlashAttribute("deletem", result);
		return "redirect:/hj/theaterlist.hj";
	}
	
	/*
	 * @GetMapping(value="/roomreg.hj") //상영관등록view public String
	 * roomregister_view(@RequestParam("theatersrn") int theatersrn, Model model) {
	 * model.addAttribute("theatersrn", theatersrn); return "TheaterRoomRegister"; }
	 */
	
	@RequestMapping(value="/roomreg.hj", method=RequestMethod.POST)
	//@PostMapping(value="/roomreg.hj") //상영관등록기능
	public String roomregister(TheaterRoom rvo, Model model, RedirectAttributes rttr) {
		String result = "상영관 추가에 실패하였습니다.";
		if(service.theaterRoomInsert(rvo)>0) {result="상영관이 추가되었습니다.";}
		rttr.addFlashAttribute("roominsert", result);
		return "redirect:/hj/theateredit.hj?theatersrn="+rvo.getTheatersrn();
	}
	
	/*
	 * @GetMapping(value="/roomedit.hj") //상영관수정view public String
	 * roomedit_view(TheaterRoom rvo, Model model) { model.addAttribute("room",
	 * service.theaterRoomForm(rvo.getRoomsrn())); return "TheaterRoomEdit"; }
	 */
	
	@RequestMapping(value="/roomedit.hj", method=RequestMethod.POST)
	//@PostMapping(value="/roomedit.hj") //상영관수정기능
	public String roomedit(TheaterRoom rvo, Model model, RedirectAttributes rttr) {
		String result = "상영관 정보 수정에 실패하였습니다.";
		if(service.theaterRoomUpdate(rvo)>0) {result="상영관 정보가 수정되었습니다.";}
		rttr.addFlashAttribute("roomupdate", result);
		return "redirect:/hj/theateredit.hj?theatersrn="+rvo.getTheatersrn();
	}
	
	@RequestMapping(value="/roomdelete.hj", method=RequestMethod.GET)
	//@GetMapping(value="/roomdelete.hj") //상영관삭제기능
	public String roomdelete(@RequestParam("roomsrn") int roomsrn, 
							 @RequestParam("theatersrn") int theatersrn,
							RedirectAttributes rttr) {
		String result = "상영관 삭제에 실패하였습니다.";
		if(service.theaterRoomDelete(roomsrn)>0) {result="상영관이 삭제되었습니다.";}
		rttr.addFlashAttribute("roomdelete", result);
		return "redirect:/hj/theateredit.hj?theatersrn="+theatersrn;
	}
	
	@RequestMapping(value="/mypageticket.hj", method=RequestMethod.GET)
	//@GetMapping(value="/mypageticket.hj") //마이페이지 예매내역
	public String mypageticket(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//////////////////////////////////////////////////////////////////
		session.setAttribute("signIn", "haein");
		//////////////////////////////////////////////////////////////////
		String userid = (String)session.getAttribute("signIn");
		
		model.addAttribute("list", service.ticketCheck(userid)); //userid 
		return "MyPage_ticketing";
	}
	
	@RequestMapping(value="/ticketcheckdetail.hj/{srn}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> ticketdetail(@PathVariable int srn, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("signIn");
		
		Map<String, Object> para = new HashMap<>();
		para.put("keyword1", userid);				//userid 
		para.put("keyword2", srn);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", service.checkDetail(para));

		return result;
	}
	
	@RequestMapping(value="/myticketdelete.hj", method=RequestMethod.GET)
	//@GetMapping(value="/myticketdelete.hj")
	public String myticketdelete(@RequestParam("paysrn") int paysrn, RedirectAttributes rttr) {
		String result="예매 취소에 실패하였습니다.";
		if(service.ticketDelete(paysrn)>0) { result="예매가 취소되었습니다."; };
		rttr.addFlashAttribute("delete", result);
		return "redirect:/hj/mypageticket.hj";
	}
	
	@RequestMapping(value="/mymovinglist.hj", method=RequestMethod.GET)
	//@GetMapping(value="/mymovinglist.hj")
	public String mymovinglist(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("signIn");
		
		model.addAttribute("list", service.myMovingList(userid)); //userid
		return "MyPage_movingtheater";
	}
	
	@RequestMapping(value="/ticketing1.hj", method=RequestMethod.GET)
	//@GetMapping(value="/ticketing1.hj")
	public String ticketmovielit(Model model) {
		model.addAttribute("list", service.selectMovie());
		model.addAttribute("theaterlist", service.theaterList());
		return "Ticketing_page1";
	}
	
	@RequestMapping(value="/ticketing2_theaterlist.hj/{moviesrn}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> tickettheaterlist(@PathVariable int moviesrn, HttpServletRequest request) {
		//세션값 저장
		HttpSession session = request.getSession();
		session.setAttribute("tmoviesrn", moviesrn);
		
		//해당 영화 영화관 출력
		Map<String, Object> result = new HashMap<>();
		result.put("result", service.selectCheckTheater(moviesrn));
		return result;
	}
	
	@RequestMapping(value="/ticketing3.hj/{theatersrn}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ticketdatelist(@PathVariable int theatersrn, HttpServletRequest request) {
		//세션값 저장
		HttpSession session = request.getSession();
		session.setAttribute("ttheatersrn", theatersrn);
		
		Map<String, Object> result = new HashMap<>();
		//오늘을 기준으로 7일 날짜 뽑기
		List<String> date = new ArrayList<>();
		List<String> inputdate = new ArrayList<>();
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String datenow ="";
		for(int i=0; i<7; i++) { 
			LocalDate currentDate = today.plusDays(i);
            String formattedDate = currentDate.format(formatter);
            String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            datenow = (formattedDate + "(" + dayOfWeek + ")");
            
            date.add(datenow);
            inputdate.add(formattedDate);
			}
		result.put("weekdate", date);
		result.put("inputdate", inputdate);
		return result;
	}
	
	
	@RequestMapping(value="/ticketing4.hj/{inputdate}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> tickettimelist(@PathVariable String inputdate, HttpServletRequest request) {
		//세션값 저장
		HttpSession session = request.getSession();
		session.setAttribute("tdate", inputdate);
		
		Map<String, Object> para = new HashMap<>();
		para.put("keyword1", session.getAttribute("ttheatersrn"));
		para.put("keyword2", session.getAttribute("tmoviesrn"));
		para.put("keyword3", session.getAttribute("tdate"));
		
		Map<String, Object> result = new HashMap<>();
		result.put("time", service.selectMovieSchedule(para));
		
		return result;
	}
	
	@RequestMapping(value="/ticketing5.hj/{schedulesrn}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ticketnextpage1(@PathVariable int schedulesrn, HttpServletRequest request){
		//세션값 저장
		HttpSession session = request.getSession();
		
		session.setAttribute("tschedulesrn", schedulesrn);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	@RequestMapping(value="/ticketing6.hj", method=RequestMethod.GET)
	public String tikcetseatpage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		model.addAttribute("movie", service.selectUmovie((int)(session.getAttribute("tmoviesrn"))));        //영화정보
		model.addAttribute("schedule", service.selectUschedule((int)(session.getAttribute("tschedulesrn")))); //스케줄정보
		model.addAttribute("room", service.selectUroom((int)(session.getAttribute("tschedulesrn"))));  //상영관정보
		
		return "Ticketing_page2";
	}
	
	@RequestMapping(value="/ticketing7.hj/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ticketatype(@PathVariable String id, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		int tickettype = service.selectUatype(id);  //티켓타입 (성인=1, 청소년=2, 경로=3)
		int typesum = service.selectUasum(id);      //해당타입 수 (타입당 최대 4장까지)
		int tschedulesrn = (int)session.getAttribute("tschedulesrn");
		
		// null이라면 세션에 0으로 저장
		if((session.getAttribute("tickettype_1_sum")) == null) {
				 session.setAttribute("tickettype_1_sum", 0);
				 session.setAttribute("tickettype_1_price", 0);  
			 }
		if((session.getAttribute("tickettype_2_sum")) == null) {
			 session.setAttribute("tickettype_2_sum", 0);
			 session.setAttribute("tickettype_2_price", 0);  
		 }
		if((session.getAttribute("tickettype_3_sum")) == null) {
			 session.setAttribute("tickettype_3_sum", 0);
			 session.setAttribute("tickettype_3_price", 0);  
		 }
		
		//티켓타입의 갯수와 총가격을 세션에 저장 
		if(tickettype == 1) {
			session.setAttribute("tickettype_1_sum", typesum);
			session.setAttribute("tickettype_1_price", service.selectUprice(id));
		}else if(tickettype == 2) {
			session.setAttribute("tickettype_2_sum", typesum);
			session.setAttribute("tickettype_2_price", service.selectUprice(id));
		}else if(tickettype == 3) {
			session.setAttribute("tickettype_3_sum", typesum);
			session.setAttribute("tickettype_3_price", service.selectUprice(id));
		}
		
		int totalsum = ((int)(session.getAttribute("tickettype_1_sum")) + (int)(session.getAttribute("tickettype_2_sum")) + (int)(session.getAttribute("tickettype_3_sum")));
		session.setAttribute("totalnum", totalsum);
		//totalsum이 남은좌석보다 많다면 alert message
		String seatalert = "";
		TheaterRoom room = service.selectUroom((int)(session.getAttribute("tschedulesrn")));
		int seatsum = Integer.parseInt(room.getSeat_col())*Integer.parseInt(room.getSeat_row());
		if(totalsum > seatsum- service.selectPayedsum(tschedulesrn)) { seatalert="선택한 좌석의 수가 잔여좌석 수보다 많습니다."; }  // 경고 알림창
		
		// 결제된 좌석 뽑기
		List<String> payedseat = service.selectPayedseat(tschedulesrn);
		List<Integer> row = new ArrayList<Integer>(); List<Integer> col = new ArrayList<>(); 
		
		for(int i=0; i<payedseat.size(); i++) {
			String temp = payedseat.get(i);
			String[] arr = temp.split("-");
			row.add(Integer.parseInt(arr[0])); col.add(Integer.parseInt(arr[1]));
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("seatalert", seatalert);
		result.put("row", row);
		result.put("col", col); 
		result.put("totalsum", totalsum);
		return result; 
	}
	
	@RequestMapping(value="/ticketing8.hj/{seatlist}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> seatchoice(@PathVariable List<String> seatlist, HttpServletRequest request){
		//totalsum 만큼 seatnum을 session에 저장 
		HttpSession session = request.getSession();
		session.setAttribute("seatlist", seatlist);
		Map<String, Object> result = new HashMap<>();
		result.put("list", seatlist);
		return result;
	}
	
	@RequestMapping(value="/ticketing9.hj", method=RequestMethod.GET)
	public String tikcetpaypage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int totalprice = ((int)session.getAttribute("tickettype_3_price") + (int)session.getAttribute("tickettype_2_price") + (int)session.getAttribute("tickettype_1_price"));
		session.setAttribute("totalprice", totalprice);
		
		// 결제 페이지에 보낼 거 체크 
		model.addAttribute("movie", service.selectUmovie((int)(session.getAttribute("tmoviesrn"))));        //영화정보
		model.addAttribute("schedule", service.selectUschedule((int)(session.getAttribute("tschedulesrn")))); //스케줄정보
		model.addAttribute("room", service.selectUroom((int)(session.getAttribute("tschedulesrn"))));  //상영관정보
		model.addAttribute("totalprice", totalprice);
		model.addAttribute("seatlist", session.getAttribute("seatlist"));
		
		return "Ticketing_page3";
	}
	
	//영화 재선택
	@RequestMapping(value="/movierechoose.hj", method=RequestMethod.GET)
	public String movierechoose(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//세션값 삭제 - session.removeAttribute(""); -> 영화, 좌석 정보 전부
		session.removeAttribute("tmoviesrn");
		session.removeAttribute("ttheatersrn");
		session.removeAttribute("tdate");
		session.removeAttribute("tschedulesrn");
		session.removeAttribute("tickettype_1_sum"); session.removeAttribute("tickettype_1_price");
		session.removeAttribute("tickettype_2_sum"); session.removeAttribute("tickettype_2_price");
		session.removeAttribute("tickettype_3_sum"); session.removeAttribute("tickettype_3_price"); 
		session.removeAttribute("totalnum");
		session.removeAttribute("seatlist");
		return "redirect:/hj/ticketing1.hj";
	}
	
	//좌석 재선택 
	@RequestMapping(value="/seatrechoose.hj", method=RequestMethod.GET)
	public String seatrechoose(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//세션값 삭제 - session.removeAttribute(""); -> 좌석정보 
		session.removeAttribute("tickettype_1_sum"); session.removeAttribute("tickettype_1_price");
		session.removeAttribute("tickettype_2_sum"); session.removeAttribute("tickettype_2_price");
		session.removeAttribute("tickettype_3_sum"); session.removeAttribute("tickettype_3_price"); 
		session.removeAttribute("totalnum");
		session.removeAttribute("seatlist");
		return "redirect:/hj/ticketing6.hj";
	}
	
	//결제수단 선택
	@RequestMapping(value="/compayment.hj", method=RequestMethod.POST)
	public String compayment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String payment = request.getParameter("paymentmethod");
		session.setAttribute("paymentmethod", payment);
		
		if(payment.equals("kakao")) {return "redirect:/hj/kakaoPayment.hj"; }
		return "redirect:/hj/kakaoPayment.hj"; 
	}
	
	//결제하기 -> 카카오페이
	@RequestMapping(value="/kakaoPayment.hj", method=RequestMethod.GET)
	public String kakaopay(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int totalprice = (int)session.getAttribute("totalprice");
		System.out.println("kakaoPay....................");
		return "redirect:"+kakaopay.kakaoPayRead(totalprice); 
	}
	
	//카카오페이 -> 결제성공 
	@RequestMapping(value="/kakaoPaySuccess.hj", method=RequestMethod.GET)
	public String completepay(HttpServletRequest request, RedirectAttributes rttr) throws UnknownHostException {
		HttpSession session = request.getSession();
		//결제DB삽입
		int totalprice = (int)session.getAttribute("totalprice");
		String paymentmethod = (String)session.getAttribute("paymentmethod");
		String payip = InetAddress.getLocalHost().getHostName();
		Map<String, Object> para = new HashMap<>();
		para.put("keyword1", totalprice); para.put("keyword2", paymentmethod); para.put("keyword3", payip);
		service.payInsert(para);
		
		//예매DB에 삽입 
		int paysrn = service.selectPaysrn(); String userid = (String)session.getAttribute("signIn"); int tschedulesrn= (int)session.getAttribute("tschedulesrn");
		Map<String, Object> para2 = new HashMap<>();
		para2.put("keyword1", paysrn); para2.put("keyword2", userid); para2.put("keyword3", tschedulesrn);
		service.ticketInsert(para2);
		
		//관객DB에 삽입 //////////////////////////////////////////////////////
		int typeA=0, typeY=0, typeO = 0;
		@SuppressWarnings("unchecked")
		List<String> payedSeat = (List<String>)session.getAttribute("seatlist");
		
		if((session.getAttribute("tickettype_1_sum")) != null) {
			 typeA = (int)session.getAttribute("tickettype_1_sum");
		 }
		if((session.getAttribute("tickettype_2_sum")) != null) {
			typeY = (int)session.getAttribute("tickettype_2_sum");
		 }
		if((session.getAttribute("tickettype_3_sum")) != null) {
			 typeO = (int)session.getAttribute("tickettype_3_sum");
		 }
		
		for(int i=0; i<typeA; i++) {
			Map<String, Object> tpara = new HashMap<>();
			tpara.put("keyword1", 1);
			tpara.put("keyword2", payedSeat.get(i));
			tpara.put("keyword3", paysrn);
			service.audienceInsert(tpara);
		}
		
		for(int i=typeA; i<typeA+typeY; i++) {
			Map<String, Object> tpara = new HashMap<>();
			tpara.put("keyword1", 2);
			tpara.put("keyword2", payedSeat.get(i));
			tpara.put("keyword3", paysrn);
			service.audienceInsert(tpara);
		}
		
		for(int i=typeA+typeY; i<typeA+typeY+typeO; i++) {
			Map<String, Object> tpara = new HashMap<>();
			tpara.put("keyword1", 3);
			tpara.put("keyword2", payedSeat.get(i));
			tpara.put("keyword3", paysrn);
			service.audienceInsert(tpara);
		}

		//세션 삭제
		session.removeAttribute("tmoviesrn");
		session.removeAttribute("ttheatersrn");
		session.removeAttribute("tdate");
		session.removeAttribute("tschedulesrn");
		session.removeAttribute("tickettype_1_sum"); session.removeAttribute("tickettype_1_price");
		session.removeAttribute("tickettype_2_sum"); session.removeAttribute("tickettype_2_price");
		session.removeAttribute("tickettype_3_sum"); session.removeAttribute("tickettype_3_price"); 
		session.removeAttribute("totalnum");
		session.removeAttribute("seatlist");
		
		rttr.addFlashAttribute("paysuccess", "결제가 완료되었습니다.");
		return "redirect:/hj/mypageticket.hj"; //alert + 나의 예매내역으로
	}
	
	//결제실패
	@RequestMapping(value="/kakaoPayFail.hj", method = RequestMethod.GET)
	public String kakaoPayFail() { return "redirect:/hj/ticketing9.hj"; }
	
	//결제취소
	@RequestMapping(value="/kakaoPayCancel.hj", method = RequestMethod.GET)
	public String kakaoPayCancel() { return "redirect:/hj/ticketing9.hj"; }

	
	
}
