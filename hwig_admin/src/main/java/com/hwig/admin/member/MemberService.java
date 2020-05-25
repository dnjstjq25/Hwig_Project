package com.hwig.admin.member;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface MemberService {

	public int register(MemberVO memberVo);

	public List<MemberVO> listAll(SearchCriteria cri);

	public int listAllCount(SearchCriteria cri);

	public MemberVO findOne(String mem_id);

	public MemberVO login(String mem_id, String mem_pw);

	public int emailCheck(EmailCheckVO emailCheckVo);

	public int idCheck(IdCheckVO idCheckVo);

	public boolean isRightUesrCheck(String mem_id, String mem_pw);

	public int modify(UpdateMemberVO updateMemberVo);

	public List<ApiOrderListVO> memberOrderListAll(ApiOrderListVO apiOrderListVo);

	public int memberOrderListAllCount(ApiOrderListVO apiOrderListVo);

	public List<ApiOrderDetailVO> memberOrderDetailAll(ApiOrderDetailVO apiOrderDetailVo);
	
	public int changeReverse(MemberVO memberVo);

	public int changePrice(MemberVO memberVo);

	public int changeGrade(MemberVO memberVo);
	
	public int idNameEmailCheck(IdNameEmailCheckVO idNameEmailCheckVo);
	
	public List<MemberOrderPrdVO> memberOrderPrd(MemberCriteria cri);
	
	public int memberOrderPrdCount(MemberCriteria cri);
	
	public List<ApiMemberReviewPrdVO> memberReviewPrd(ApiMemberReviewPrdVO apiMemberReviewPrdVo);
	
	public int remove (String mem_id);
	
	public List<MemberDeleteVO> memberOrders(String mem_id);
	
	public int adminMemberModify(MemberUpdateVO memberUpdateVo);

}