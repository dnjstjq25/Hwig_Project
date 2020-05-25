package com.hwig.admin.MLogin;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class MLoginServiceImpl implements MLoginService {

	@Inject
	MLoginDAO dao;

	// ·Î±×ÀÎ
	@Override
	public MLoginVO mem_login(MLoginVO member) throws Exception {

		return dao.mem_login(member);
	}

	@Override
	public boolean isRightUesrCheck(String mem_id, String mem_pw) throws Exception {
		MLoginVO ml = new MLoginVO();
		ml.setMem_id(mem_id);
		ml = dao.mem_login(ml); 

		if (!BCrypt.checkpw(mem_pw, ml.getMem_pw())) {
			return false;
		} else {
			return true;
		}
	}
}
