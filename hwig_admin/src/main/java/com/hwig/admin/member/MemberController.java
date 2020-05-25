package com.hwig.admin.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.common.SearchCriteria;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("list", memberService.listAll(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberService.listAllCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/detailForm", method = RequestMethod.GET)
	public void detailPage(String mem_id, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("data", memberService.findOne(mem_id));
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
	}

	@ResponseBody
	@RequestMapping(value = "/prds", method = RequestMethod.GET)
	public MemberOrderPrdDTO detailPaging(@RequestParam("prdPage") int prdPage,
			@RequestParam("prdPerPageNum") int prdPerPageNum, @RequestParam("mem_id") String mem_id) {
		MemberCriteria memberCriteria = new MemberCriteria();
		memberCriteria.setPrdPage(prdPage);
		memberCriteria.setPrdPerPageNum(prdPerPageNum);
		memberCriteria.setMem_id(mem_id);
		logger.info(memberCriteria.toString());

		MemberOrderPrdDTO memberOrderPrdDto = new MemberOrderPrdDTO();
		memberOrderPrdDto.setMemberOrderPrdVo(memberService.memberOrderPrd(memberCriteria));
		System.out.println(memberService.memberOrderPrd(memberCriteria));

		MemberPageMaker memberPageMaker = new MemberPageMaker();
		memberPageMaker.setCri(memberCriteria);
		memberPageMaker.setPrdTotalCount(memberService.memberOrderPrdCount(memberCriteria));
		logger.info(memberPageMaker.toString());

		memberOrderPrdDto.setMemberPageMaker(memberPageMaker);
		logger.info(memberOrderPrdDto.toString());

		return memberOrderPrdDto;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(MemberUpdateVO memberUpdateVo, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr) {
		int result = memberService.adminMemberModify(memberUpdateVo);

//		rttr.addAttribute("page", cri.getPage());
//		rttr.addAttribute("perPageNum", cri.getPerPageNum());
//		rttr.addAttribute("searchType", cri.getSearchType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		if (result == 1) {
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		logger.info(rttr.toString());

		return "redirect:/member/list";
	}

}
