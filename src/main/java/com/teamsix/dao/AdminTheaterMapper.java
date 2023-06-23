package com.teamsix.dao;

import java.util.List;

import com.teamsix.dto.Theater;

public interface AdminTheaterMapper {
	// 영화관 리스트 및 해당 영화관 읽기
	public List<Theater> theaterList();
	public Theater read(int srn);
	// 영화관 등록하기
	public int theaterInsert(Theater th);
	// 영화관 수정하기
	public int theaterUpdate(Theater th);
	// 영화관 삭제하기
	public int theaterDelete(Theater th);
	
}
