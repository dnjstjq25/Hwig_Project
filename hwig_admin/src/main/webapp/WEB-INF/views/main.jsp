<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--main content start-->
<section class="main-content-wrapper">
	<c:if test="${sessionScope.user_type eq 'admin'}">
		<div class="pageheader">
			<h1>HWIG ADMIN</h1>
		</div>
	</c:if>
	<c:if test="${sessionScope.user_type eq 'seller'}">
		<div class="pageheader">
			<h1>HWIG SELLER</h1>
		</div>
	</c:if>

	<c:if test="${sessionScope.user_type eq 'admin'}">
		<section id="main-content" class="animated fadeInUp">
			<div class="row">
				<div class="col-md-12 col-lg-6">
					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-solid-info widget-mini">
								<div class="panel-body">
									<i class="icon-user"></i> <span class="total text-center">${member_count}</span>
									<span class="title text-center">회원 수</span>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-solid-success widget-mini">
								<div class="panel-body">
									<i class="icon-bar-chart"></i>
									<span class="total text-center" id="order_paymoney">￦ ${order_paymoney}</span>
									<span class="title text-center">총 매출</span>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-solid-warning widget-mini">
								<div class="panel-body">
									<i class="icon-support"></i>
									<span class="total text-center">${reply_count}</span>
									<span class="title text-center">문의답변</span>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-solid-warning widget-mini">
								<div class="panel-body">
									<i class="icon-envelope-open"></i>
									<span class="total text-center">${qna_count}</span>
									<span class="title text-center">고객문의</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
					<div class="panel panel-default browser-chart">
						<div class="panel-heading">
							<h3 class="panel-title">카테고리별 판매액</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<ul>
										<li><i class="fa fa-circle success-color"></i> 기본채소</li>
										<li><i class="fa fa-circle primary-color"></i> 국산과일</li>
										<li><i class="fa fa-circle warning-color"></i> 수입과일</li>
										<li><i class="fa fa-circle info-color"></i> 소·돼지</li>
										<li><i class="fa fa-circle default-color"></i> 닭·오리</li>
										<li><i class="fa fa-circle default-color" style="color: red"></i> 간편조리·양념육</li>
									</ul>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div id="doughnut-canvas-holder">
										<canvas id="doughnut-chart-area" width="137" height="137"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Monthly Goal</h3>
							<div class="actions pull-right">
								<i class="fa fa-expand"></i>
							</div>
						</div>
						<div class="panel-body widget-gauge">
							<canvas width="160" height="100" id="gauge" class=""></canvas>
							<div class="goal-wrapper">
								<span class="gauge-value pull-left"></span>
								<span id="gauge-text" class="gauge-value pull-left">￦${order_paymoney}</span>
								<span id="goal-text" class="goal-value pull-right">￦10,000,000</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">문의 목록</h3>
							<div class="actions pull-right">
								<i class="fa fa-expand"></i>
								<i class="fa fa-chevron-down"></i>
								<i class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<table class="table text-center">
								<thead>
									<tr class="warning">
										<th style="text-align: center">글 번호</th>
										<th style="text-align: center">카테고리</th>
										<th style="text-align: center">제목</th>
										<th style="text-align: center">작성일</th>
										<th style="text-align: center">작성자</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="qna_list" items="${qna_list}">
										<tr>
											<td>${qna_list.qna_id}</td>
											<td>${qna_list.qna_category}</td>
											<td>${qna_list.qna_subject}</td>
											<td>${qna_list.qna_regdate}</td>
											<td>${qna_list.mem_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">주문 목록</h3>
							<div class="actions pull-right">
								<i class="fa fa-expand"></i>
								<i class="fa fa-chevron-down"></i>
								<i class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<table class="table text-center">
								<thead>
									<tr class="success">
										<th style="text-align: center">주문번호</th>
										<th style="text-align: center">회원아이디</th>
										<th style="text-align: center">주문가격</th>
										<th style="text-align: center">주문상태</th>
										<th style="text-align: center">요청사항</th>
										<th style="text-align: center">주문날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="order_list" items="${order_list}">
										<tr>
											<td>${order_list.order_id}</td>
											<td>${order_list.mem_id}</td>
											<td>${order_list.order_paymoney}</td>
											<td>${order_list.order_status}</td>
											<td>${order_list.order_request}</td>
											<td>${order_list.order_paydate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">승인 요청 상품 목록</h3>
							<div class="actions pull-right">
								<i class="fa fa-expand"></i>
								<i class="fa fa-chevron-down"></i>
								<i class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<table class="table text-center">
								<thead>
									<tr class="info">
										<th style="text-align: center">상품번호</th>
										<th style="text-align: center">카테고리</th>
										<th style="text-align: center">판매자</th>
										<th style="text-align: center">상품명</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="prd_list" items="${prd_list}">
										<tr>
											<td>${prd_list.prd_id}</td>
											<td>${prd_list.category_id}</td>
											<td>${prd_list.sel_id}</td>
											<td>${prd_list.prd_name}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:if>
	<c:if test="${sessionScope.user_type eq 'seller'}">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">후기 목록</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
						</div>
					</div>
				</div>
				<c:forEach var="review_list" items="${review_list}" varStatus="img_index">
					<div class="panel col-md-12" id="review_1">
						<ul class="row panel-body col-md-12" style="list-style: none;" id="accordion_ul">
							<li class="col-md-12" id="accordion_li">
								<a href="#" class="col-md-12">[${review_list.prd_name}]&nbsp;&nbsp;${review_list.review_subject}<span style="float: right;">${review_list.review_regdate}</span></a>
                                 <div class="col-md-12 view-mail-body" style="border-top: 1px solid #d3d3d3; margin-top: 10px;">
                                     <img src="${review_list.review_img}" class="review_img${img_index.count}" width="550" height="450" style="float:left; margin-top:10px;"/>
                                     <pre style="background-color: white; border: none; float:left;">
                                     <br>${review_list.review_content}</pre>
                                 </div>
                            </li>
						</ul>
					</div>
				</c:forEach>
				<div class="panel" style="display: flex;" id="review_2">
					<hr style="border: 0.5px solid #d3d3d3;">
					<div class="row col-md-12">
						<div class="col-md-12">
							<div class="panel view-mail-body">
								<div class="panel-body" style="height: 200px; text-align: center;">
									<strong>작성된 후기가 없습니다.</strong>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">재고 부족 상품입니다(관리자와 상의해주세요)</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
						</div>
					</div>
					<div class="panel-body">
						<table class="table text-center">
							<thead>
								<tr class="success">
									<th style="text-align: center">이름</th>
									<th style="text-align: center">재고</th>
									<th style="text-align: center">가격</th>
									<th style="text-align: center">원산지</th>
									<th style="text-align: center">등록날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${fn:length(data) > 0}">
									<c:forEach var="data" items="${data}">
										<tr>
											<td>${data.prd_name}</td>
											<td>${data.prd_stock}</td>
											<td>${data.prd_price}</td>
											<td>${data.prd_from}</td>
											<td>${data.prd_date}</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${fn:length(data) < 1}">
									<tr>
										<td colspan="5">재고 부족 상품이 없습니다</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</section>
<!--main content end-->
<%@ include file="/WEB-INF/views/include/footnav.jsp"%>
<script>
	$(function() {

		for(var i=1; i<4; i++){
			if($('.review_img'+i).attr('src')==''){
				   $('.review_img'+i).remove();
			   }
		} 
		
		$("p").hide();
		$("#accordion_ul > #accordion_li:first-child a").next().children()
				.show();
		$("#accordion_ul #accordion_li a").click(
				function() {
					$(this).next().children().slideToggle(300);
					// $(this).next().slideDown(300);
					$("#accordion_ul #accordion_li a").not(this).next()
							.children().slideUp(300);
					return false;
				});
		$("#accordion_ul #accordion_li a").eq(0).trigger("click");

		if ($('#review_1').val() != null) {
			$('#review_2').hide();
		} else {
			$('#review_2').show();
		}

		var value = new Array();
		var i = 0;
		<c:forEach var="chart_circle" items="${chart_circle}">
		value[i] = <c:out value='${chart_circle.order_paymoney}'/>
		i++;
		</c:forEach>

		var data1, data2, data3, data4, data5, data6;
		var doughnutData = [ data1 = {
			value : 0,
			color : "#1ABC9C",
			highlight : "#1ABC9C",
			label : "기본채소"
		}, data2 = {
			value : 0,
			color : "#556B8D",
			highlight : "#556B8D",
			label : "국산과일"
		}, data3 = {
			value : 0,
			color : "#EDCE8C",
			highlight : "#EDCE8C",
			label : "수입과일"
		}, data4 = {
			value : 0,
			color : "#1F7BB6",
			highlight : "#1F7BB6",
			label : "소·돼지"
		}, data5 = {
			value : 0,
			color : "#CED1D3",
			highlight : "#CED1D3",
			label : "닭·오리"
		}, data6 = {
			value : 0,
			color : "red",
			highlight : "red",
			label : "간편조리·양념육"
		} ];
		if (value[0] != null)
			data1["value"] = value[0];
		if (value[1] != null)
			data2["value"] = value[1];
		if (value[2] != null)
			data3["value"] = value[2];
		if (value[3] != null)
			data4["value"] = value[3];
		if (value[4] != null)
			data5["value"] = value[4];
		if (value[5] != null)
			data6["value"] = value[5];

		window.onload = function() {
			var ctx3 = document.getElementById("doughnut-chart-area")
					.getContext("2d");
			window.myDoughnut = new Chart(ctx3).Doughnut(doughnutData, {
				responsive : true
			});
		};

		var opts = {
			lines : 12, // The number of lines to draw
			angle : 0, // The length of each line
			lineWidth : 0.4, // The line thickness
			pointer : {
				length : 0.75, // The radius of the inner circle
				strokeWidth : 0.042, // The rotation offset
				color : '#1D212A' // Fill color
			},
			limitMax : 'false', // If true, the pointer will not go past the end of the gauge
			colorStart : '#1ABC9C', // Colors
			colorStop : '#1ABC9C', // just experiment with them
			strokeColor : '#F0F3F3', // to see which ones work best for you
			generateGradient : true
		};
		var target = document.getElementById('gauge'); // your canvas element
		var gauge = new Gauge(target).setOptions(opts); // create sexy gauge!
		gauge.maxValue = 10000000; // set max gauge value
		gauge.animationSpeed = 32; // set animation speed (32 is default value)
		gauge.set(<c:out value='${order_paymoney}'/>); // set actual value
		gauge.setTextField(document.getElementById("gauge-text"));

	});
</script>