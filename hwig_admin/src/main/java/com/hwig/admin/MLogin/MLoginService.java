package com.hwig.admin.MLogin;

public interface MLoginService {
	public MLoginVO mem_login(MLoginVO member) throws Exception;
	public boolean isRightUesrCheck(String mem_id, String mem_pw) throws Exception; 
}
