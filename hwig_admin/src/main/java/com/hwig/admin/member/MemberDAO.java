package com.hwig.admin.member;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface MemberDAO {

	public int insert(MemberVO memberVo);

	public List<MemberVO> selectAll(SearchCriteria cri);

	public int selectAllCount(SearchCriteria cri);

	public MemberVO select(MemberVO memberVo);

	public int emailCheck(EmailCheckVO emailCheckVo);

	public int idCheck(IdCheckVO idCheckVo);

	public int update(UpdateMemberVO updateMemberVo);

	public List<ApiOrderListVO> memberOrderSelectAll(ApiOrderListVO apiOrderListVo);

	public int memberOrderAllCount(ApiOrderListVO apiOrderListVo);

	public List<ApiOrderDetailVO> memberOrderDetailSelectAll(ApiOrderDetailVO ApiOrderDetailVo);

	public int changeReverse(MemberVO memberVo);

	public int changePrice(MemberVO memberVo);

	public int changeGrade(MemberVO memberVo);

	public int idNameEmailCheck(MemberVO memberVo);

	public int resetPw(MemberVO memberVo);
	
	public List<MemberOrderPrdVO> memberOrderPrdSelect(MemberCriteria cri);
	
	public int memberOrderPrdCount(MemberCriteria cri);
	
	public List<ApiMemberReviewPrdVO> memberReviewPrdSelect(ApiMemberReviewPrdVO apiMemberReviewPrdVo);
	
	public int delete(String mem_id);
	
	public List<MemberDeleteVO> memberOrders(String mem_id);
	
	public int adminMemberUpdate(MemberVO memberVo);

}