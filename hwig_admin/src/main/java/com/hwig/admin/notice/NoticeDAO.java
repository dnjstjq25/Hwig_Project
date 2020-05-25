package com.hwig.admin.notice;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface NoticeDAO {
	public List<NoticeVO> nList(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	public int notice_write(NoticeVO notice) throws Exception;
	public NoticeVO notice_view(int notice_id) throws Exception;
	public int notice_hit_up(int notice_id) throws Exception;
	public int notice_modify(NoticeVO notice) throws Exception;
	public int notice_delete(int notice_id) throws Exception;
	public void notice_id_d(NoticeVO notice) throws Exception;
	
	public List<NoticeVO> nList_main() throws Exception;
}
