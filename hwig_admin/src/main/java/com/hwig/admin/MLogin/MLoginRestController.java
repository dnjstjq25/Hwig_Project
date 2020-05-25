package com.hwig.admin.MLogin;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/mlogin")
public class MLoginRestController {
	@Inject
	MLoginService mService;
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody MLoginVO member, HttpServletRequest req) throws Exception{
		System.out.println(member.getMem_id() + " " + member.getMem_pw());
		boolean check = mService.isRightUesrCheck(member.getMem_id(), member.getMem_pw());
		HttpSession ss = req.getSession();
		
		System.out.println(ss);
		
		
		Map<String, Object> responseData = new HashMap<String, Object>();

		if(check == false)
		{
			responseData.put("isLogged?", false);
		}
		else {
			ss.setAttribute("mem", mService.mem_login(member));
			responseData.put("mem", mService.mem_login(member));
			responseData.put("isLogged", true);
		}
			
		return responseData;
	}
	
	@GetMapping("/logout")
	public Map<String, Object> p_logout(HttpSession ss) throws Exception{
		
		Map<String, Object> responseData = new HashMap<String, Object>();

		ss.invalidate();
		
		responseData.put("isLogged", false);
		
		return responseData;
	}
	
	@GetMapping("/session") 
	public Map<String, Object> session(MLoginVO member, HttpSession ss) throws Exception{
	  
		MLoginVO mem = (MLoginVO) ss.getAttribute("mem");
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		if(mem == null)
		{
			responseData.put("isLogged", false);
		} else {
			responseData.put("mem", mem);
			responseData.put("isLogged", true);
		}
		return responseData;
	}
}


