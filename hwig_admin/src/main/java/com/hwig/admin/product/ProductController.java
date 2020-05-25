package com.hwig.admin.product;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.common.SearchCriteria;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	ProductService service;
	
	@Resource(name = "savePath")
	private String savePath;

	@Resource(name = "productAttachPath")
	private String productAttachPath;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	//상품 등록 - get
	@RequestMapping(value = "/prd_add", method=RequestMethod.GET)
	public void getAdd() throws Exception {
		
	}
	
	//상품 등록 - post
	@RequestMapping(value = "/prd_add", method=RequestMethod.POST)
	public String postAdd(ProductVO vo, RedirectAttributes rttr, MultipartFile[] file) throws Exception {
		
		int count = 0;
		//이미지 저장 
		for(MultipartFile files : file) {
			System.out.println("for문 진입 성공");
			if (files.getOriginalFilename() != null && !files.getOriginalFilename().equals("")) {
				// 파일명 생성
				UUID uid = UUID.randomUUID();
				String fileName = uid.toString() + "_" + files.getOriginalFilename();
				logger.info("path = " + savePath + vo.getPrd_thumb());
	
				// 파일을 서버에 저장
					FileOutputStream fos = new FileOutputStream(savePath + productAttachPath + "/" + fileName);
					logger.info("파일 서버에 저장하는 부분 => " + savePath + productAttachPath + "/" + fileName);
					InputStream is = files.getInputStream();
	
					int readCount = 0;
					byte[] buffer = new byte[1024];
	
					while ((readCount = is.read(buffer)) != -1) {
						fos.write(buffer, 0, readCount);
					}
					fos.close();
					
					if(count == 0) {
						vo.setPrd_thumb(productAttachPath + "/" + fileName);
						System.out.println("썸네일 등록 : " + vo.getPrd_thumb());
					}
					else if(count == 1) {
						vo.setPrd_img(productAttachPath + "/" + fileName);
						System.out.println("설명 이미지 등록 : " + vo.getPrd_img());
					}
					count++;
			}
		}
		
		int result = service.add(vo);
		if(result == 1) { //등록 완료 메세지
			rttr.addFlashAttribute("msg", "success");
		}
		else {
			rttr.addFlashAttribute("msg", "fail");
		}
		String selid = vo.getSel_id();
		String url = "redirect:/product/prd_waitlist_seller?sel_id=" + selid;
		return url;
	}
	
	//상품 등록 예정 목록
	@RequestMapping(value = "/prd_waitlist", method=RequestMethod.GET)
	public List<ProductDTO> getWaitList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		List<ProductDTO> waitList = service.waitList(cri);
		model.addAttribute("waitList", waitList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listAllCountb(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return waitList;
	}
	
	//판매자용 상품 등록 예정 목록
	@RequestMapping(value = "/prd_waitlist_seller", method=RequestMethod.GET)
	public List<ProductDTO> getWaitListSeller(@RequestParam("sel_id") String sel_id, @ModelAttribute("cri") ProductCriteria cri, Model model) throws Exception {
		
		cri.setSel_id(sel_id);
		
		List<ProductDTO> waitList = service.waitSelList(cri);
		model.addAttribute("waitList", waitList);
		
		ProductPageMaker pageMaker = new ProductPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listAllSelCountb(cri));
		 
		model.addAttribute("pageMaker", pageMaker);
		
		return waitList;
	}
	
	//상품 등록 완료 목록
		@RequestMapping(value = "/prd_list", method=RequestMethod.GET)
		public List<ProductDTO> getList(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
			
			List<ProductDTO> list = service.list(cri);
			model.addAttribute("list", list);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.listAllCount(cri));
			
			model.addAttribute("pageMaker", pageMaker);
			
			return list;
		}
		
	//판매자용 상품 등록 완료 목록
		@RequestMapping(value = "/prd_list_seller", method=RequestMethod.GET)
		public List<ProductDTO> getListSeller(@RequestParam("sel_id") String sel_id, @ModelAttribute("cri") ProductCriteria cri, Model model) throws Exception {
			
			cri.setSel_id(sel_id);
			
			List<ProductDTO> list = service.sellist(cri);
			model.addAttribute("list", list);
			
			ProductPageMaker pageMaker = new ProductPageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.listAllSelCount(cri));
			
			model.addAttribute("pageMaker", pageMaker);
			
			return list;
		}
	
	//등록 예정 목록 상품 삭제 - get
	@RequestMapping(value="/prd_delete", method=RequestMethod.GET)
	public String getDelete(@RequestParam("prd_id") int prd_id,RedirectAttributes rttr, HttpSession session) throws Exception {
		
		int result = service.delete(prd_id);
		if(result == 1) { //삭제 완료 메세지
			rttr.addFlashAttribute("msg", "success");
		}
		else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		if(session.getAttribute("user_type").equals("seller")) {
			String url = "redirect:/product/prd_waitlist_seller?sel_id=" + session.getAttribute("user_id");
			return url;
		}
		else
			return "redirect:/product/prd_waitlist";
			
	}
	
	//등록 완료 상품 삭제 - get
	@RequestMapping(value="/prd_deletelist", method=RequestMethod.GET)
	public String getDeleteList(@RequestParam("prd_id") int prd_id,RedirectAttributes rttr) throws Exception {
			
		int result = service.deletelist(prd_id);
		if(result == 1) { //삭제 완료 메세지
			rttr.addFlashAttribute("msg", "success");
		}
		else {
			rttr.addFlashAttribute("msg", "fail");
		}
			
		return "redirect:/product/prd_list";
	}
	
	//등록
	@RequestMapping(value="/prd_add_list", method=RequestMethod.GET)
	public String getListAdd(@RequestParam("prd_id") int prd_id, RedirectAttributes rttr) throws Exception {
		
		int result = service.addList(prd_id);
		service.delete(prd_id);//등록 후 tbl_prd_b에서 삭제
		if(result == 1) { //삭제 완료 메세지
			rttr.addFlashAttribute("msg", "success");
		}
		else {
			rttr.addFlashAttribute("msg", "fail");
		}
		return "redirect:/product/prd_waitlist";
	}
	
	//글 수정 - get
	@RequestMapping(value="/prd_modify", method=RequestMethod.GET)
	public void getModify(@RequestParam("prd_id") int prd_id, Model model) throws Exception {
		ProductVO vo = service.read(prd_id);
		model.addAttribute("modify", vo);
	}
	
	//글 수정 - post
	@RequestMapping(value="/prd_modify", method=RequestMethod.POST)
	public String postModify(ProductVO vo, RedirectAttributes rttr, MultipartFile[] file, HttpServletRequest req) throws Exception {
		
		int count = 0;
		//이미지 저장 
		for(MultipartFile files : file) {
			System.out.println("for문 진입 성공");
			//이미지 없는 경우
			if (files.getOriginalFilename() != null && !files.getOriginalFilename().equals("")) {
				// 파일명 생성
				UUID uid = UUID.randomUUID();
				String fileName = uid.toString() + "_" + files.getOriginalFilename();
				logger.info("path = " + savePath + vo.getPrd_thumb());
	
				// 파일을 서버에 저장
					FileOutputStream fos = new FileOutputStream(savePath + productAttachPath + "/" + fileName);
					logger.info("파일 서버에 저장하는 부분 => " + savePath + productAttachPath + "/" + fileName);
					InputStream is = files.getInputStream();
	
					int readCount = 0;
					byte[] buffer = new byte[1024];
	
					while ((readCount = is.read(buffer)) != -1) {
						fos.write(buffer, 0, readCount);
					}
					fos.close();
					
					if(count == 0) {
						vo.setPrd_thumb(productAttachPath + "/" + fileName);
						System.out.println("썸네일 등록 : " + vo.getPrd_thumb());
					}
					else if(count == 1) {
						vo.setPrd_img(productAttachPath + "/" + fileName);
						System.out.println("설명 이미지 등록 : " + vo.getPrd_img());
					}
					count++;
			}
			else { //기존 이미지 사용
				if(count == 0) {
					vo.setPrd_thumb(req.getParameter("prd_thumb"));
					System.out.println("썸네일 등록 : " + req.getParameter("prd_thumb"));
				}
				else if(count == 1) {
					vo.setPrd_img(req.getParameter("prd_img"));
					System.out.println("설명 이미지 등록 : " + req.getParameter("prd_img"));
				}
				count++;
			}
		}
		
		service.update(vo);
		
		return "redirect:/product/prd_list";
	}
	
	//글 조회 - get
	@RequestMapping(value="/prd_read", method=RequestMethod.GET)
	public void getRead(@RequestParam("prd_id") int prd_id, Model model) throws Exception {
		ProductVO vo = service.read(prd_id);
		String cateName = service.readCategory(prd_id);
		model.addAttribute("product", vo);
		model.addAttribute("cateName", cateName);
	}
	
	//글 조회 - get
		@RequestMapping(value="/prd_read_seller", method=RequestMethod.GET)
		public void getReadSeller(@RequestParam("prd_id") int prd_id, Model model) throws Exception {
			ProductVO vo = service.read(prd_id);
			String cateName = service.readCategory(prd_id);
			model.addAttribute("product", vo);
			model.addAttribute("cateName", cateName);
		}
	
}
