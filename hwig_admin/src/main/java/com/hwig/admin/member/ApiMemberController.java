package com.hwig.admin.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwig.admin.common.CommonResponse;
import com.hwig.admin.common.DuplicatedResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/members/*")
public class ApiMemberController {

	private static final Logger logger = LoggerFactory.getLogger(ApiMemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public CommonResponse register(@RequestBody MemberVO memberVo) {
		logger.info(memberVo.toString());

		CommonResponse response = new CommonResponse();

		String inputPass = memberVo.getMem_pw();
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String pass = passEncoder.encode(inputPass);
		memberVo.setMem_pw(pass);

		int result = memberService.register(memberVo);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.CREATED.value());
			response.setMsg("success");
		}

		return response;
	}

	/**
	 * 회원정보조회(데이터 값이 ""이면 없는걸로 처리해라)
	 * 
	 * @param mem_id
	 * @return
	 */
	@RequestMapping(value = "/{mem_id}", method = RequestMethod.GET) // 값 받아서 select해야 하니 get
	public MemberVO one(@PathVariable("mem_id") String mem_id) {
		MemberVO memberVo = memberService.findOne(mem_id);

		if (memberVo == null) {
			MemberVO emptyVo = new MemberVO();
			emptyVo.empty();
			return emptyVo;
		}

		return memberVo;
	}

	/**
	 * 구체적인 객체 형태로 이메일 체크
	 * 
	 * @param emailCheckVo
	 * @return
	 */
	@RequestMapping(value = "/check/email", method = RequestMethod.POST) // 액션을 연상시키게 하는 url이면 POST
	public DuplicatedResponse emailCheck(@RequestBody EmailCheckVO emailCheckVo) {
		logger.info(emailCheckVo.toString());

		int result = memberService.emailCheck(emailCheckVo);

		DuplicatedResponse response = new DuplicatedResponse();
		response.setDuplicated((result < 1) ? false : true);

		return response;
	}

	/**
	 * 구체적인 객체 형태로 아이디 체크
	 * 
	 * @param idCheckVo
	 * @return
	 */
	@RequestMapping(value = "/check/id", method = RequestMethod.POST)
	public DuplicatedResponse idCheck(@RequestBody IdCheckVO idCheckVo) {
		logger.info(idCheckVo.toString());

		int result = memberService.idCheck(idCheckVo);

		DuplicatedResponse response = new DuplicatedResponse();
		response.setDuplicated((result < 1) ? false : true);

		return response;
	}

	/**
	 * 회원정보수정 전 아이디와 비밀번호 Map형태로 체크
	 * 
	 * @param memberVo
	 * @return
	 */
	@RequestMapping(value = "/check/user", method = RequestMethod.POST)
	public Map<String, Boolean> isRightUserCheck(@RequestBody Map<String, String> memberVo) {
		logger.info("mem_id -> " + memberVo.get("mem_id"), "mem_pw -> " + memberVo.get("mem_pw"));

		Map<String, Boolean> map = new HashMap<>();
		map.put("isRightUser", memberService.isRightUesrCheck(memberVo.get("mem_id"), memberVo.get("mem_pw")));

		return map;
	}

	@RequestMapping(value = "/{mem_id}", method = RequestMethod.PUT)
	public CommonResponse modify(@PathVariable("mem_id") String mem_id, @RequestBody UpdateMemberVO updateMemberVo) {
		updateMemberVo.setMem_id(mem_id);
		logger.info(updateMemberVo.toString());

		CommonResponse response = new CommonResponse();

		int result = memberService.modify(updateMemberVo);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.OK.value());
			response.setMsg("success");
		}

		return response;
	}

	/*
	 * data키값의 size가 0이면 데이터값이 없는걸로 처리해라
	 */
	@RequestMapping(value = "/{mem_id}/orders", method = RequestMethod.GET)
	public ApiOrderListDTO orderList(@PathVariable("mem_id") String mem_id) {
		ApiOrderListVO apiOrderListVo = new ApiOrderListVO();
		apiOrderListVo.setMem_id(mem_id);

		List<ApiOrderListVO> result = memberService.memberOrderListAll(apiOrderListVo);

		ApiOrderListDTO response = new ApiOrderListDTO();
		List<ApiOrderDTO> apiMemberOrderDtos = new ArrayList<ApiOrderDTO>();

		for (ApiOrderListVO dto : result) {
			ApiOrderDTO orderDto = new ApiOrderDTO();
			orderDto.setOrder_count(dto.getOrder_count());
			orderDto.setOrder_id(dto.getOrder_id());
			orderDto.setOrder_paydate(dto.getOrder_paydate());
			orderDto.setPrd_thumb(dto.getPrd_thumb());
			orderDto.setOrder_paymoney(dto.getOrder_paymoney());
			orderDto.setOrder_status(dto.getOrder_status());
			orderDto.setPrd_name(dto.getPrd_name());
			apiMemberOrderDtos.add(orderDto);
		}

		response.setData(apiMemberOrderDtos);

		return response;
	}

	@RequestMapping(value = "/{mem_id}/orders/{order_id}", method = RequestMethod.GET)
	public ApiOrderDetailDTO orderDetail(@PathVariable("mem_id") String mem_id,
			@PathVariable("order_id") String order_id) {
		ApiOrderDetailVO apiOrderDetailVo = new ApiOrderDetailVO();
		apiOrderDetailVo.setMem_id(mem_id);
		apiOrderDetailVo.setOrder_id(order_id);

		List<ApiOrderDetailVO> result = memberService.memberOrderDetailAll(apiOrderDetailVo);

		ApiOrderDetailDTO response = new ApiOrderDetailDTO();
		List<ApiOrderPrdDetailDTO> apiOrderPrdDetailDtos = new ArrayList<ApiOrderPrdDetailDTO>();
		ApiOrderMemDetailDTO apiOrderMemdetailDto = new ApiOrderMemDetailDTO();

		if (result.size() > 0) {
			for (ApiOrderDetailVO dto : result) {
				ApiOrderPrdDetailDTO detailDto = new ApiOrderPrdDetailDTO();
				detailDto.setOrder_count(dto.getOrder_count());
				detailDto.setPrd_id(dto.getPrd_id());
				detailDto.setPrd_name(dto.getPrd_name());
				detailDto.setPrd_price(dto.getPrd_price());
				detailDto.setPrd_thumb(dto.getPrd_thumb());
				apiOrderPrdDetailDtos.add(detailDto);
			}

			apiOrderMemdetailDto.setOrder_id(result.get(0).getOrder_id());
			apiOrderMemdetailDto.setOrder_paymoney(result.get(0).getOrder_paymoney());
			apiOrderMemdetailDto.setPrd_sale(result.get(0).getPrd_sale());
			apiOrderMemdetailDto.setOrder_used_reverse(result.get(0).getOrder_used_reverse());
			apiOrderMemdetailDto.setOrder_payway(result.get(0).getOrder_payway());
			apiOrderMemdetailDto.setOrder_sender(result.get(0).getOrder_sender());
			apiOrderMemdetailDto.setOrder_paydate(result.get(0).getOrder_paydate());
			apiOrderMemdetailDto.setOrder_status(result.get(0).getOrder_status());
			apiOrderMemdetailDto.setOrder_receiver(result.get(0).getOrder_receiver());
			apiOrderMemdetailDto.setOrder_receiver_tel(result.get(0).getOrder_receiver_tel());
			apiOrderMemdetailDto.setOrder_receiver_addr(result.get(0).getOrder_receiver_addr());
			apiOrderMemdetailDto.setOrder_request(result.get(0).getOrder_request());
		}

		response.setPrdList(apiOrderPrdDetailDtos);
		response.setMemData(apiOrderMemdetailDto);

		return response;
	}

	@RequestMapping(value = "/check/info", method = RequestMethod.POST)
	public CommonResponse idNameEmailCheck(@RequestBody IdNameEmailCheckVO idNameEmailCheckVo) {
		logger.info(idNameEmailCheckVo.toString());

		int result = memberService.idNameEmailCheck(idNameEmailCheckVo);

		CommonResponse response = new CommonResponse();

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.OK.value());
			response.setMsg("success");
		}

		return response;
	}

	@RequestMapping(value = "{mem_id}/prds", method = RequestMethod.GET)
	public List<ApiMemberReviewPrdDTO> reviewPrdList(@PathVariable("mem_id") String mem_id) {
		ApiMemberReviewPrdVO apiMemberReviewPrdVo = new ApiMemberReviewPrdVO();
		apiMemberReviewPrdVo.setMem_id(mem_id);
		List<ApiMemberReviewPrdVO> result = memberService.memberReviewPrd(apiMemberReviewPrdVo);

		List<ApiMemberReviewPrdDTO> reviewPrds = new ArrayList<ApiMemberReviewPrdDTO>();
		for (ApiMemberReviewPrdVO dto : result) {
			ApiMemberReviewPrdDTO prdDto = new ApiMemberReviewPrdDTO();
			prdDto.setOrder_count(dto.getOrder_count());
			prdDto.setOrder_paydate(dto.getOrder_paydate());
			prdDto.setPrd_id(dto.getPrd_id());
			prdDto.setPrd_name(dto.getPrd_name());
			prdDto.setPrd_thumb(dto.getPrd_thumb());
			reviewPrds.add(prdDto);
		}

		return reviewPrds;
	}

	@RequestMapping(value = "/{mem_id}", method = RequestMethod.DELETE)
	public CommonResponse remove(@PathVariable("mem_id") String mem_id) {
		CommonResponse response = new CommonResponse();

		int result = memberService.remove(mem_id);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.OK.value());
			response.setMsg("success");
		}

		return response;
	}

}
