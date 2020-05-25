package com.hwig.admin.qna;

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
import com.hwig.admin.reply.MacroVO;
import com.hwig.admin.reply.ReplyService;
import com.hwig.admin.reply.ReplyVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@Inject
	QnaService qService;
	@Inject
	ReplyService rService;
	
	//문의 목록
	@RequestMapping(value = "/qlist")
	public void getQna(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("qList", qService.qList(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(qService.listCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//문의 조회
	@RequestMapping(value = "/qna_view")
	public void qna_view(@RequestParam("qna_id") int qna_id, @RequestParam("qna_category") String qna_category,
						 @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		QnaVO qna = qService.qna_view(qna_id);
		
		model.addAttribute("qna_view", qna);
		model.addAttribute("cri", cri);
		
		ReplyVO reply = rService.reply_view(qna_id);
		model.addAttribute("rList", reply);
		
		
		 MacroVO macro = rService.macro_view(qna_category);
		 model.addAttribute("macro", macro);
		 
		 model.addAttribute("macro_c", rService.macro_c_list(qna_category));
		 
	}
	
	
	//문의 삭제
	@RequestMapping(value = "/qna_delete")
	public String qna_delete(QnaVO qna, int qna_id, RedirectAttributes rttr,
							 @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		
		int result = qService.qna_delete(qna_id);
		
		
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
		
		return "redirect:/qna/qlist";
	}
	
	//답글 작성
	@RequestMapping(value = "/reply_write", method = RequestMethod.POST)
	public String reply_write(QnaVO qna, ReplyVO reply, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		reply.setReply_content(reply.getReply_content().replace("\r\n", "<br>"));
		
		rService.reply_write(reply);
		
		rttr.addAttribute("qna_id", reply.getQna_id());
		rttr.addAttribute("qna_category", qna.getQna_category());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/qna/qlist";
	}
	
	//답글 수정
	@RequestMapping(value = "/reply_modify", method = RequestMethod.POST)
	public String reply_modify(QnaVO qna, ReplyVO reply, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		reply.setReply_content(reply.getReply_content().replace("\r\n", "<br>"));
		
		rService.reply_modify(reply);

		rttr.addAttribute("qna_id", reply.getQna_id());		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/qna/qlist";
	}
	
	//답글 삭제
	@RequestMapping(value = "/reply_delete")
	public String reply_delete(ReplyVO reply, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		rService.reply_delete(reply);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/qna/qlist";
	}
	
	//양식 관리  목록
	@RequestMapping(value = "/temlist")
	public String temlist(MacroVO macro, QnaVO qna, 
						  @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr, Model model) throws Exception{
		
		
		model.addAttribute("mList", rService.macro_list());
		model.addAttribute("macro_ht", rService.macro_ht_list());
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "/qna/temlist";
	}
	
	//양식 머리,꼬리 수정폼
	@RequestMapping(value = "/tem_ht_modify")
	public void	getTem_ht_modify(@RequestParam("qna_category") String qna_category, MacroVO macro,
			  					 @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("macro", rService.macro_view(qna_category));
		model.addAttribute("cri", cri);
		
		
	}
	
	//양식 머리,꼬리 수정
	@RequestMapping(value = "/tem_ht_modify", method = RequestMethod.POST)
	public String postTem_ht_modify(MacroVO macro, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{

		macro.setMacro_head(macro.getMacro_head().replace("\r\n", "<br>"));
		macro.setMacro_tail(macro.getMacro_tail().replace("\r\n", "<br>"));
		int result = rService.macro_ht_modify(macro);
		
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
		
		return "redirect:/qna/temlist";
	}
	
	//본문 양식 추가폼
	@RequestMapping(value = "/tem_write")
	public void getTem_write(Model model) throws Exception{
		
		model.addAttribute("macro_list",rService.macro_list()); 

	}
	
	//본문 양식 추가
	@RequestMapping(value = "/tem_write", method = RequestMethod.POST)
	public String postTem_write(MacroVO macro, RedirectAttributes rttr) throws Exception{
		
		macro.setMacro_content(macro.getMacro_content().replace("\r\n", "<br>"));
		
		int result = rService.macro_write(macro);
			
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
			return "redirect:/qna/temlist";
	}
	
	//본문 양식 수정
	@RequestMapping(value = "/tem_modify")
	public void	getTem_modify(@RequestParam("macro_c_id") int macro_c_id, MacroVO macro,
				 @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{

			model.addAttribute("macro_c_view", rService.macro_c_view(macro_c_id));
			model.addAttribute("cri", cri);
	}
	
	//양식 본문 수정
	@RequestMapping(value = "/tem_modify", method = RequestMethod.POST)
	public String postTem_modify(MacroVO macro, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{

		macro.setMacro_content(macro.getMacro_content().replace("\r\n", "<br>"));
		
		int result = rService.macro_modify(macro);
		
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
		
		return "redirect:/qna/temlist";
	}
	
	//양식 본문 삭제
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/tem_delete")
	public String faq_delete(MacroVO macro, int macro_c_id, RedirectAttributes rttr,
							 @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		
		int result = rService.macro_delete(macro_c_id);
		rService.macro_id_d(macro);
		
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
		
		return "redirect:/qna/temlist";
	}
}