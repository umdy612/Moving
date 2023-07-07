package com.teamsix.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor		//default 생성자
@AllArgsConstructor		
public class PagingDto {
	private int listtotal;		//1. 전체글 768
	private int onepagelist;	//2. 한 페이지에 보여줄 게시물의 수 10
	private int pagetotal;		//3. 총 페이지 계산 768/10 -> 77개
	private int bottomlist;		//4. 하단에 페이지 나누기 수 -> 10개
	private int pstartno;		//5. 페이지의 스타트 번호
	

	private int current;		//6. 하단 현재 번호
	private int start;			//7. 하단 시작
	private int end;			//8. 하단 끝
	
	public PagingDto(int pstartno, int listtotal) {
		super();
		this.listtotal 	 = listtotal;
		this.onepagelist = 10;
 		
		this.pagetotal  = (int)Math.ceil((double)listtotal/onepagelist);		//나누기 + 반올림 -> 소수점 없애기
 		this.bottomlist = 10;

		this.pstartno = pstartno;
		
		//이전  1  2  3  4  5  6  7  8  9 10 다음		( 1-1=0		||	#10-1=9 	=> 0)
		//이전 11 12 13 14 15 16 17 18 19 20 다음		(11-1=10	||	#20-1=19	=> 1)
		//이전 21 22 23 24 25 26 27 28 29 20 다음		(21-1=20	||	#30-1=29	=> 2)
 		this.current = (int) Math.ceil((pstartno+1)/(double)onepagelist);		// 0/10 안되니까 +1 --> 나누기 + 반올림 -> 소수점 없애기
 		this.start 	 = (int) Math.floor((current-1)/bottomlist)*bottomlist+1;	//결과물 15 -> 11	 -->  15->1 (앞자리)
 		
 		this.end = start+bottomlist-1;
 		if(pagetotal < end) {end = pagetotal;}
		//이전 21 22 23 24 25 26 		(21-1=20	||	#30-1=29	=> 2)
		 
	}
	
}
