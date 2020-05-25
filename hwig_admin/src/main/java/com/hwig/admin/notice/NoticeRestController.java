package com.hwig.admin.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/notice")
public class NoticeRestController {

	@Inject
	NoticeService nService;
	
	@GetMapping("/nlist")
	public List<NoticeVO> nlist() throws Exception{
		
		List<NoticeVO> nlist = nService.nList_main();
		
		return nlist;
	}
	
	@GetMapping("/notice_view")
	public NoticeVO notice_view(@RequestParam("notice_id") int notice_id) throws Exception{

		nService.notice_hit_up(notice_id);

		return nService.notice_view(notice_id);
	}
}


