package com.hwig.admin.faq;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.common.SearchCriteria;

@Controller
@RequestMapping("/faq")
public class FaqController {
	
	@Inject
	FaqService fService;
	
	//자주묻는질문 리스트
	@RequestMapping(value = "/flist")
	public void getFaq(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("fList", fService.fList(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(fService.listCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//자주묻는질문 등록폼
	@RequestMapping(value = "/faq_write")
	public void getFaq_write() throws Exception{
		
	}
	
	//자주묻는질문 등록
	@RequestMapping(value = "/faq_write", method = RequestMethod.POST)
	public String postQna_write(FaqVO faq, RedirectAttributes rttr) throws Exception{
		
		/* faq.setFaq_content(faq.getFaq_content().replace("\r\n", "<br>")); */
		
		int result = fService.faq_write(faq);
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		return "redirect:/faq/flist";
	}
	
	//자주묻는질문 상세보기
	@RequestMapping(value = "/faq_view")
	public void faq_view(@RequestParam("faq_id") int faq_id,
						 @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		FaqVO faq = fService.faq_view(faq_id);
		
		model.addAttribute("faq_view", faq);
		model.addAttribute("cri", cri);
	}
	
	//자주묻는질문 수정폼
	@RequestMapping(value = "/faq_modify")
	public void getFaq_modify(@RequestParam("faq_id") int faq_id,
							  @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		FaqVO faq = fService.faq_view(faq_id);
		
		model.addAttribute("faq_view", faq);
		model.addAttribute("cri", cri);
	}
	
	//자주묻는질문 수정
	@RequestMapping(value = "/faq_modify", method = RequestMethod.POST)
	public String postFaq_modify(FaqVO faq, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		faq.setFaq_content(faq.getFaq_content().replace("\r\n", "<br>"));
		
		int result = fService.faq_modify(faq);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		return "redirect:/faq/flist";
	}
	
	//자주묻는질문 삭제
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/faq_delete")
	public String faq_delete(FaqVO faq, int faq_id, RedirectAttributes rttr,
							 @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		
		int result = fService.faq_delete(faq_id);
		fService.faq_id_d(faq);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/faq/flist";
	}
}
