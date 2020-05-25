package com.hwig.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwig.admin.cart.CartService;
import com.hwig.admin.common.SearchCriteria;
import com.hwig.admin.order.OrderService;
import com.hwig.admin.review.ReviewService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ReviewService reviewService;

	@Override
	public int register(MemberVO memberVo) {
		return memberDao.insert(memberVo);
	}

	@Override
	public List<MemberVO> listAll(SearchCriteria cri) {
		return memberDao.selectAll(cri);
	}

	@Override
	public int listAllCount(SearchCriteria cri) {
		return memberDao.selectAllCount(cri);
	}

	@Override
	public MemberVO findOne(String mem_id) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(mem_id);
		return memberDao.select(memberVo);
	}

	@Override
	public MemberVO login(String mem_id, String mem_pw) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(mem_id);
		memberVo.setMem_pw(mem_pw);
		return memberDao.select(memberVo);
	}

	@Override
	public int emailCheck(EmailCheckVO emailCheckVo) {
		return memberDao.emailCheck(emailCheckVo);
	}

	@Override
	public int idCheck(IdCheckVO idCheckVo) {
		return memberDao.idCheck(idCheckVo);
	}

	/**
	 * 리턴값이 ture면 해당회원, false면 회원정보 일치 실패
	 */
	@Override
	public boolean isRightUesrCheck(String mem_id, String mem_pw) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(mem_id);
		memberVo = memberDao.select(memberVo);

		if (!BCrypt.checkpw(mem_pw, memberVo.getMem_pw())) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int modify(UpdateMemberVO updateMemberVo) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(updateMemberVo.getMem_id());
		memberVo = memberDao.select(memberVo);
		if (!BCrypt.checkpw(updateMemberVo.getMem_pw(), memberVo.getMem_pw())) {
			return 0;
		}

		if (updateMemberVo.getMem_newpw() != null || updateMemberVo.getMem_newpw() != "") {
			String inputPass = updateMemberVo.getMem_newpw();
			PasswordEncoder passEncoder = new BCryptPasswordEncoder();
			String pass = passEncoder.encode(inputPass);
			updateMemberVo.setMem_newpw(pass);
		}

		memberDao.update(updateMemberVo);

		return 1;
	}

	@Override
	public List<ApiOrderListVO> memberOrderListAll(ApiOrderListVO apiOrderListVo) {
		return memberDao.memberOrderSelectAll(apiOrderListVo);
	}

	@Override
	public int memberOrderListAllCount(ApiOrderListVO apiOrderListVo) {
		return memberDao.memberOrderAllCount(apiOrderListVo);
	}

	@Override
	public List<ApiOrderDetailVO> memberOrderDetailAll(ApiOrderDetailVO apiOrderDetailVo) {
		return memberDao.memberOrderDetailSelectAll(apiOrderDetailVo);
	}

	@Override
	public int changeReverse(MemberVO memberVo) {
		return memberDao.changeReverse(memberVo);
	}

	@Override
	public int changePrice(MemberVO memberVo) {
		return memberDao.changePrice(memberVo);
	}

	@Override
	public int changeGrade(MemberVO memberVo) {
		return memberDao.changeGrade(memberVo);
	}

	@Transactional
	@Override
	public int idNameEmailCheck(IdNameEmailCheckVO idNameEmailCheckVo) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(idNameEmailCheckVo.getMem_id());
		memberVo.setMem_name(idNameEmailCheckVo.getMem_name());
		memberVo.setMem_email(idNameEmailCheckVo.getMem_email());

		int result = memberDao.idNameEmailCheck(memberVo);

		if (result < 1) {
			return 0;
		} else {
			String mem_pw = "0000000";
			PasswordEncoder passEncoder = new BCryptPasswordEncoder();
			String pass = passEncoder.encode(mem_pw);

			memberVo.setMem_id(idNameEmailCheckVo.getMem_id());
			memberVo.setMem_pw(pass);
			memberDao.resetPw(memberVo);
		}

		return 1;
	}

	@Override
	public List<MemberOrderPrdVO> memberOrderPrd(MemberCriteria cri) {
		return memberDao.memberOrderPrdSelect(cri);
	}

	@Override
	public int memberOrderPrdCount(MemberCriteria cri) {
		return memberDao.memberOrderPrdCount(cri);
	}

	@Override
	public List<ApiMemberReviewPrdVO> memberReviewPrd(ApiMemberReviewPrdVO apiMemberReviewPrdVo) {
		return memberDao.memberReviewPrdSelect(apiMemberReviewPrdVo);
	}

	@Transactional
	@Override
	public int remove(String mem_id) {
		List<MemberDeleteVO> selectMemberOrders = memberDao.memberOrders(mem_id);
		System.out.println(selectMemberOrders.size());

		if (selectMemberOrders.size() < 1) {
			return 1;
		} else {
			for (MemberDeleteVO dto : selectMemberOrders) {
				if (!(dto.getOrder_status().equals("배송 중") || dto.getOrder_status().equals("상품 준비 중"))) {
					orderService.addrRemove(dto.getOrder_id());
					orderService.orderBRemove(dto.getOrder_id());
					orderService.orderRemove(dto.getOrder_id());
				} else {
					return 0;
				}
			}

			cartService.cartPrdRemove(mem_id);
			reviewService.reviewRemove(mem_id);

			memberDao.delete(mem_id);
		}

		return 1;
	}

	@Override
	public List<MemberDeleteVO> memberOrders(String mem_id) {
		return memberDao.memberOrders(mem_id);
	}

	@Override
	public int adminMemberModify(MemberUpdateVO memberUpdateVo) {
		MemberVO memberVo = new MemberVO();
		if (!"true".equals(memberUpdateVo.getIsNewAddr())) {
			memberVo.setMem_name(memberUpdateVo.getMem_name());
			memberVo.setMem_email(memberUpdateVo.getMem_email());
			memberVo.setMem_tel(memberUpdateVo.getMem_tel());
			memberVo.setMem_id(memberUpdateVo.getMem_id());
		} else {
			memberVo.setMem_name(memberUpdateVo.getMem_name());
			memberVo.setMem_email(memberUpdateVo.getMem_email());
			memberVo.setMem_tel(memberUpdateVo.getMem_tel());
			memberVo.setMem_addr(memberUpdateVo.getMem_addr());
			memberVo.setMem_id(memberUpdateVo.getMem_id());
		}

		return memberDao.adminMemberUpdate(memberVo);
	}

}
