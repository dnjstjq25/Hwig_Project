package com.hwig.admin.review;

import javax.annotation.Resource;
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
@RequestMapping("/review")
public class ReviewController {
	
	@Inject
	ReviewService rvService;
	
	@Resource(name="savePath")
	private String savePath;
			
	@Resource(name="ReviewAttachPath")
	private String attachPath;
	
	@RequestMapping(value = "/reviewList")
	public void reviewList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("reviewList", rvService.reviewList(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(rvService.listCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/review_view")
	public void qna_view(@RequestParam("review_id") int review_id, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		ReviewVO review = rvService.review_view(review_id);
		
		model.addAttribute("review_view", review);
		model.addAttribute("cri", cri);
		 
	}
	
	@RequestMapping(value = "/review_modify")
	public void getReview_modify(@RequestParam("review_id") int review_id,
								 @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		ReviewVO review = rvService.review_view(review_id);
		
		model.addAttribute("review_view", review);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value = "/review_modify", method = RequestMethod.POST)
	public String postreview_modify(ReviewVO review, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{

		int result = rvService.review_modify(review);
		
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
		
		return "redirect:/review/reviewList";
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/review_delete")
	public String review_delete(ReviewVO review, int review_id, RedirectAttributes rttr, @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		int result = rvService.review_delete(review_id);
		rvService.review_id_d(review);
		
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
		
		return "redirect:/review/reviewList";
	}
	
}

