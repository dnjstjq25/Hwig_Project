package com.hwig.admin.member;

import java.util.List;

public class MemberOrderPrdDTO {

	private List<MemberOrderPrdVO> memberOrderPrdVo;
	private MemberPageMaker memberPageMaker;

	public List<MemberOrderPrdVO> getMemberOrderPrdVo() {
		return memberOrderPrdVo;
	}

	public void setMemberOrderPrdVo(List<MemberOrderPrdVO> memberOrderPrdVo) {
		this.memberOrderPrdVo = memberOrderPrdVo;
	}

	public MemberPageMaker getMemberPageMaker() {
		return memberPageMaker;
	}

	public void setMemberPageMaker(MemberPageMaker memberPageMaker) {
		this.memberPageMaker = memberPageMaker;
	}

	@Override
	public String toString() {
		return "MemberOrderPrdDTO [memberOrderPrdVo=" + memberOrderPrdVo + ", memberPageMaker=" + memberPageMaker + "]";
	}

}
