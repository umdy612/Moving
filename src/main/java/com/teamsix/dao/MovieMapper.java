package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.*;

public interface MovieMapper {
	public int scheduleCheck();				//상영 중인 영화 확인
	public List<Movie> movieSearch();		//영화 검색
	public int audienceCheck();				//실관람객 확인
	public List<Movie> movieChartResv();	//영화차트 예매순
	public List<Movie> movieChartStar();	//영화차트 별점순
	public List<Reply> moiveReply();		//영화 댓글
	public int replyInsert();				//댓글 등록
	public int replyUpdate();				//댓글 등록
	public int replyDelete();				//댓글 등록
}
