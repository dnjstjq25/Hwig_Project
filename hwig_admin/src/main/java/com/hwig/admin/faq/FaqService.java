package com.hwig.admin.faq;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface FaqService {
	public List<FaqVO> fList(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	public int faq_write(FaqVO faq) throws Exception;
	public FaqVO faq_view(int faq_id) throws Exception;
	public int faq_modify(FaqVO faq) throws Exception;
	public int faq_delete(int faq_id) throws Exception;
	public void faq_id_d(FaqVO faq) throws Exception;
	
	public List<FaqVO> fList_main() throws Exception;
}
