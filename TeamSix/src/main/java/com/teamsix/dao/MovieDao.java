package com.teamsix.dao;

import java.util.List;
import java.util.Map;

import com.teamsix.dto.*;

public interface MovieDao {
	public int scheduleCheck(int no);					//상영 중인 영화 확인
	public List<Movie> movieSearch(String str);			//영화 검색
	public int audienceCheck(Map<String, Object> map);	//실관람객 확인
	public List<Movie> movieChartResv();				//영화차트 예매순
	public List<Movie> movieChartStar();				//영화차트 별점순
	public List<Reply> moiveReply(int no);				//영화 댓글
	public int replyInsert(Reply vo);				//댓글 등록
	public int replyUpdate(Reply vo);				//댓글 수정
	public int replyDelete(int no);						//댓글 삭제						
}
