package com.hwig.admin.reply;

import java.util.List;

public interface ReplyService {
	
	public ReplyVO reply_view(int qna_id) throws Exception;
	public void reply_write(ReplyVO reply) throws Exception;
	public MacroVO macro_view(String qna_category) throws Exception;
	public void reply_modify(ReplyVO reply) throws Exception;
	public void reply_delete(ReplyVO reply) throws Exception;
	
	public List<ReplyVO> rList(String mem_id) throws Exception;
	
	public List<MacroVO> macro_c_list(String qna_category) throws Exception;	
	public List<MacroVO> macro_list() throws Exception;
	public List<MacroVO> macro_ht_list() throws Exception;
	public int macro_ht_modify(MacroVO macro) throws Exception;
	
	public int macro_write(MacroVO macro) throws Exception;
	public int macro_modify(MacroVO macro) throws Exception;
	public MacroVO macro_c_view(int macro_c_id) throws Exception;
	public int macro_delete(int macro_c_id) throws Exception;
	public void macro_id_d(MacroVO macro) throws Exception;
}
