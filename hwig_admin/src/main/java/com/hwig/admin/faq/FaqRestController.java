package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/faq")
public class FaqRestController {

	@Inject
	FaqService fService;
	
	@GetMapping("/flist")
	public List<FaqVO> flist(FaqVO faq) throws Exception{
		
		List<FaqVO> nlist = fService.fList_main();
		
		return nlist;
	}
}


