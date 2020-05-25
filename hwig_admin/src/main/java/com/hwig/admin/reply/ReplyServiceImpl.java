package com.hwig.admin.reply;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDAO dao;
	
	@Override
	public ReplyVO reply_view(int qna_id) throws Exception {
		
		return dao.reply_view(qna_id);
	}

	@Override
	public void reply_write(ReplyVO reply) throws Exception {
		
		dao.reply_write(reply);
	}

	@Override
	public MacroVO macro_view(String qna_category) throws Exception {
		
		return dao.macro_view(qna_category);
	}

	@Override
	public void reply_modify(ReplyVO reply) throws Exception {
		
		dao.reply_modify(reply);
	}

	@Override
	public void reply_delete(ReplyVO reply) throws Exception {
		
		dao.reply_delete(reply);
	}

	@Override
	public List<MacroVO> macro_c_list(String qna_category) throws Exception {
		
		return dao.macro_c_list(qna_category);
	}

	@Override
	public List<MacroVO> macro_list() throws Exception {
		
		return dao.macro_list();
	}

	@Override
	public List<MacroVO> macro_ht_list() throws Exception {
		
		return dao.macro_ht_list();
	}

	@Override
	public int macro_ht_modify(MacroVO macro) throws Exception {
		
		return dao.macro_ht_modify(macro);
	}

	@Override
	public int macro_write(MacroVO macro) throws Exception {
		
		return dao.macro_write(macro);
	}

	@Override
	public int macro_modify(MacroVO macro) throws Exception {
		
		return dao.macro_modify(macro);
	}

	@Override
	public MacroVO macro_c_view(int macro_c_id) throws Exception {
		
		return dao.macro_c_view(macro_c_id);
	}

	@Override
	public int macro_delete(int macro_c_id) throws Exception {
		
		return dao.macro_delete(macro_c_id);
	}

	@Override
	public void macro_id_d(MacroVO macro) throws Exception {
		
		dao.macro_id_d(macro);
	}

	@Override
	public List<ReplyVO> rList(String mem_id) throws Exception {
		
		return dao.rList(mem_id);
	}

}
