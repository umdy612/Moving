package com.teamsix.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class TSKakaoPay {
	public String kakaoPayRead(int totalprice) {
		String result = "";   //default 경로 설정해도 됨 
		
		try {
			// 보내기
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");  //#1
			HttpURLConnection conn = (HttpURLConnection)address.openConnection();
			conn.setRequestMethod("POST");  //#2
			conn.setRequestProperty("Authorization", "KakaoAK c0f095848c136267be48829600cdbf9b");
			conn.setRequestProperty("Content-type" , "application/x-www-form-urlencoded;charset=utf-8");
			
			conn.setDoOutput(true); // 서버한테 전달
			String parameter = "cid=TC0ONETIME"         //가맹점 코드
		               + "&partner_order_id=partner_order_id"  //가맹점 주문번호 
		               + "&partner_user_id=partner_user_id"    //가맹점 회원 id
		               + "&item_name=MOVING Ticket"            //상품명
		               + "&quantity=1"                         //상품 수량
		               + "&total_amount="+totalprice           //상품 총액
		               + "&vat_amount=0"                      //상품 부가세 금액
		               + "&tax_free_amount=0"                  //상품 비과세 금액
		               + "&approval_url=http://localhost:8080/teamsix_legacy/hj/kakaoPaySuccess.hj"  //결제 성공 시 -> 프로젝트 이름 
		               + "&fail_url=http://localhost:8080/teamsix_legacy/hj/kakaoPayFail.hj"         //결제 실패 시
		               + "&cancel_url=http://localhost:8080/teamsix_legacy/hj/kakaoPayCancel.hj";     //결제 취소 시
			DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
			dataOut.writeBytes(parameter);
			dataOut.close();
			
			// 읽기
			BufferedReader br = null;
			String line="";  
			StringBuffer buffer = new StringBuffer();
			
			if(conn.getResponseCode() == 200) {
				    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else { br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
			
			while( (line = br.readLine()) != null) { buffer.append(line); }
			result = buffer.toString();

			System.out.println( "RESULT................" + result );
			
			JsonParser parser = new JsonParser();
			JsonObject robj   = (JsonObject)parser.parse(result);
 			result = robj.get("next_redirect_pc_url").getAsString();
			
 			System.out.println( "ROBJ................" + robj );
 			return result;
 			
		}catch(Exception e) { e.printStackTrace();}
		return result;
	}
}
/*
 #com.company.common - UserKakaoPay @Component
  1. https://kapi.kakao.com/v1/payment/ready 
  2. POST
  3. para
     #헤더 
      = 서비스 앱 어드민 키 
      key : Authorization
      value: Authorization: KakaoAK c0f095848c136267be48829600cdbf9b 
      = 인증방식
      key : Content-type
      value : application/x-www-form-urlencoded;charset=utf-8
--------------------------------------------------------------------------
#com.company.controller - KakaoController 
kakaoPay - UserKakaoPay 결제처리
kakaoPaySuccess - 결제 성공 화면
kakaoPayFail - 결제 실패 화면
kakaoPayCancel - 결제 취소 화면
 */
