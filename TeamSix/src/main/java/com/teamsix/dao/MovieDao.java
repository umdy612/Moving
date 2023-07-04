package com.teamsix.dao;

import java.util.List;
import java.util.Map;

import com.teamsix.dto.*;

public interface MovieDao {
	public int scheduleCheck(int no);					//�� ���� ��ȭ Ȯ��
	public List<Movie> movieSearch(String str);			//��ȭ �˻�
	public int audienceCheck(Map<String, Object> map);	//�ǰ����� Ȯ��
	public List<Movie> movieChartResv();				//��ȭ��Ʈ ���ż�
	public List<Movie> movieChartStar();				//��ȭ��Ʈ ������
	public List<Reply> moiveReply(int no);				//��ȭ ���
	public int replyInsert(Reply vo);				//��� ���
	public int replyUpdate(Reply vo);				//��� ����
	public int replyDelete(int no);						//��� ����						
}
