package com.hwig.admin.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwig.admin.MLogin.MLoginVO;
import com.hwig.admin.reply.ReplyService;
import com.hwig.admin.reply.ReplyVO;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/qna")
public class QnaRestController {

	 @Inject 
	 QnaService qService;
	 
	 @Inject
	 ReplyService rService;
	 
	 @GetMapping("/qlist") 
	 public Map<String,Object> qlist(HttpSession ss, ReplyVO reply) throws Exception{
		MLoginVO mem = (MLoginVO) ss.getAttribute("mem");
		String mem_id = mem.getMem_id();
		Map<String, Object> resQRlist = new HashMap<String, Object>();
		List<ReplyVO> rlist = rService.rList(mem_id);
		
		resQRlist.put("rlist", rlist);
		
	 	return resQRlist;
	 
	 } 
	 
	 @PostMapping("/qna_write")
	 public Map<String,Object> qna_write(@RequestBody QnaVO qna) throws Exception{
		 
		 Map<String, Object> resQna_write = new HashMap<String, Object>();
		 
		 qna.setQna_content(qna.getQna_content().replace("\r\n", "<br>"));
		 
		 int result = qService.qna_write(qna);
		 
		 if(result==1)
		 {
			 resQna_write.put("isInsert", true);
		 } else {
			 resQna_write.put("isInsert", false);
		 }

		 return resQna_write;
	 }
}


