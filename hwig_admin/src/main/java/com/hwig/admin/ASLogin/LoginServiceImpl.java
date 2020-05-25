package com.hwig.admin.ASLogin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.hwig.admin.AdminService;
import com.hwig.admin.AdminVO;
import com.hwig.admin.seller.SellerService;
import com.hwig.admin.seller.SellerVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SellerService sellerService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private HttpSession session;

	@Override
	public boolean login(LoginDTO loginDto) {
		if (loginDto.getUser_type().equals("admin")) {
			AdminVO adminVo = adminService.login(loginDto.getUser_id(), loginDto.getUser_pw());
			if (adminVo == null) {
				return false;
			} else {
				session.setAttribute("user", adminVo);
				session.setAttribute("user_type", loginDto.getUser_type());
				session.setAttribute("user_name", adminVo.getAdmin_name());
			}
		} else {
			SellerVO sellerVo = sellerService.findOneById(loginDto.getUser_id());
			if (sellerVo == null || !BCrypt.checkpw(loginDto.getUser_pw(), sellerVo.getSel_pw())) {
				return false;
			} else {
				session.setAttribute("user", sellerVo);
				session.setAttribute("user_type", loginDto.getUser_type());
				session.setAttribute("user_name", sellerVo.getSel_cname());
				session.setAttribute("user_id", sellerVo.getSel_id());
				System.out.println(sellerVo.toString());
			}
		}

		return true;
	}

	@Override
	public void logout() {
		session.invalidate();
	}

}
