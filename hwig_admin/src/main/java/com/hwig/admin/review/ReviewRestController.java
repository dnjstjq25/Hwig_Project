package com.hwig.admin.review;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwig.admin.order.OrderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/review")
public class ReviewRestController {

	@Inject
	ReviewService rvService;

	@Inject
	OrderService oService;

	@Resource(name = "savePath")
	private String savePath;

	@Resource(name = "ReviewAttachPath")
	private String attachPath;

	@GetMapping(value = "/review_main")
	public List<ReviewVO> reviewList(@RequestParam("prd_id") int prd_id) throws Exception {

		return rvService.rv_main_list(prd_id);
	}

	@GetMapping(value = "/review_mem")
	public List<ReviewVO> review_mem(@RequestParam("mem_id") String mem_id) throws Exception {

		return rvService.rv_mem_list(mem_id);
	}

	@GetMapping(value = "/review_hit")
	public void review_hit(@RequestParam("review_id") int review_id) throws Exception {

		rvService.review_hit(review_id);
	}

	
	@ResponseBody
	@RequestMapping(value="/review_write", method=RequestMethod.POST, headers = ("content-type=multipart/*"))
	public Map<String, Object> review_write(ReviewVO review, @RequestParam(value="img", required=false) MultipartFile file, RedirectAttributes rttr,
			HttpSession session) throws Exception {

		Map<String, Object> responseRv = new HashMap<String, Object>();

		review.setReview_content(review.getReview_content().replace("\r\n", "<br>"));

		if(file!=null) {
			
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) { 
				
				UUID uid = UUID.randomUUID();
				String fileName = uid.toString() + "_" + file.getOriginalFilename();
			
				FileOutputStream fos = new FileOutputStream(savePath + attachPath + "/" + fileName); 
				InputStream is = file.getInputStream();
			 
				int readCount = 0; byte[] buffer = new byte[1024];
			 
				while ((readCount = is.read(buffer)) != -1) { fos.write(buffer, 0, readCount); } fos.close();
			 
				String path = session.getServletContext().getRealPath("/");
				System.out.println("path:::"+path);
			
				review.setReview_img(attachPath + "/" + fileName); 
				
			} else {
				review.setReview_img(attachPath + "/" + "null"); 
			}
		} else {
			String x = review.getReview_content();

			String[] slang = { "시발", "씨발", "새끼", "병신", "씨1발", "좆", "엠창", "애미", "쓰벌", "ㅗ", "호로", "버러지" };

			for (int i = 0; i < slang.length; i++) {
				if (x.matches(".*" + slang[i] + ".*")) {
					review.setReview_content(x.replace(slang[i], "***"));
					x = review.getReview_content();
				}
			}
		}
		
		int result = rvService.review_write(review);
		oService.orderPrdReview(review.getPrd_id());

		if (result == 1) {
			responseRv.put("isInsert", true);
		} else {
			responseRv.put("isInsert", false);
		}
		return responseRv;
	}
}
