package com.hwig.admin.ASLogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping("/loginForm")
	public void loginForm() {

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPagePOST(LoginDTO loginDto, RedirectAttributes rttr) {
		logger.info(loginDto.toString());
		boolean result = loginService.login(loginDto);

		if (result) {
			return "redirect:/main";
		} else {
			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/loginForm";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		loginService.logout();

		return "redirect:/loginForm";
	}

}
