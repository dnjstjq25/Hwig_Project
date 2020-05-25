package com.hwig.admin.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwig.admin.common.CommonResponse;
import com.hwig.admin.member.ApiMemberController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/orders/*")
public class ApiOrderController {

	private static final Logger logger = LoggerFactory.getLogger(ApiMemberController.class);

	@Autowired
	private OrderService orderService;

	/*
	 * 주문하기
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public OrderRegisterResponse register(@RequestBody OrderRegisterDTO orderRegisterDto) {
		logger.info(orderRegisterDto.toString());

		OrderRegisterResponse response = new OrderRegisterResponse();
		String order_id = orderService.register(orderRegisterDto);

		if (order_id == null) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.CREATED.value());
			response.setMsg("success");
			response.setOrder_id(order_id);
		}

		return response;
	}

	@RequestMapping(value = "/{order_id}", method = RequestMethod.PUT)
	public CommonResponse statusModify(@PathVariable("order_id") String order_id,
			@RequestBody OrderStatusDTO orderStatusDto) {
		logger.info(orderStatusDto.toString());

		CommonResponse response = new CommonResponse();

		OrderVO orderVo = new OrderVO();
		orderVo.setOrder_id(order_id);
		orderVo.setOrder_status(orderStatusDto.getOrder_status());
		int result = orderService.statusModify(orderVo);

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
	 * 주문완료페이지
	 */
	@RequestMapping(value = "/{order_id}/summary", method = RequestMethod.GET)
	public ApiOrderCompletionDTO orderCompletion(@PathVariable("order_id") String order_id) {
		ApiOrderCompletionDTO response = orderService.orderCompletion(order_id);
		return response;
	}

}
