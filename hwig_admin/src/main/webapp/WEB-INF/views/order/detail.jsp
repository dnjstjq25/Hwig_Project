<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>주문 상세정보</h1>
    </div>
    <section id="main-content" class="animated fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">${data.order_id}</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal form-border" id="form">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주문번호</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="input1" id="input1" readonly="readonly" value="${data.order_id}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주문자</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="input2" id="input2" readonly="readonly" value="${data.mem_name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주문자 아이디</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="input3" id="input3" readonly="readonly" value="${data.mem_id}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주문 상태</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="order_status" name="input4" id="input4" readonly="readonly" value="${data.order_status}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주문날짜</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="input5" id="input5" readonly="readonly" value="${data.order_paydate}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">전화번호</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " name="input6" id="input6" readonly="readonly" value="${data.mem_tel}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">지급된 적립금</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " name="input10" id="input10" readonly="readonly" value="${data.order_reverse}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">결제금액</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " name="input11" id="input11" readonly="readonly" value="${data.order_paymoney}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">배송지 주소</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="input13" id="input13" readonly="readonly" value="${data.order_receiver_addr}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">배송요청사항</label>
                                <div class="col-sm-6">
                                    <textarea class="form-control" name="input14" id="input14" readonly="readonly">${data.order_request}</textarea>
                                </div>
							</div>
							
							<div class="form-group">
                                <label class="col-sm-3 control-label">상품리스트</label>
                                <div class="col-sm-6">
                                    <div class="table-responsive">
										<table class="table table-bordered table-striped text-center">
											<thead>
												<tr>
													<th class="text-center">아이디</th>
													<th class="text-center">이름</th>
													<th class="text-center">가격</th>
													<th class="text-center">갯수</th>
													<th class="text-center">판매자</th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${fn:length(data.order_prds) > 0}">
												<c:forEach items="${data.order_prds}" var="prdVo">
													<tr>
														<td>${prdVo.prd_id}</td>
														<td>${prdVo.prd_name}</td>
														<td>${prdVo.prd_price}</td>
														<td>${prdVo.order_count}</td>
														<td>${prdVo.sel_cname}</td>
													</tr>
												</c:forEach>
												</c:if>
											</tbody>
										</table>
									</div>
                                </div>
							</div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6" align="right">
                                    <button type="button" class="btn btn-danger" id="listBtn">목록</button>
                                    
                                    <c:if test="${sessionScope.user_type eq 'admin'}">
                                    
                                    <button type="button" class="btn btn-success" id="hwigBtn" <c:if test="${data.order_status  eq '배송 중'}">disabled="disabled"</c:if>>제품 발송</button>
                                    
                                    </c:if>
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->

<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script>
	$(document).ready(function() {
		$("#listBtn").click(function(){
			self.location = "list?page=${page}&perPageNum=${perPageNum}&searchType=${searchType}&keyword=${keyword}";
		});
		
		$("#hwigBtn").click(function(){
			var jsondata = {
					"order_status":"배송 중"
			}
			
			console.log("/api/order/${data.order_id}", jsondata);
			
			$.ajax({
				url:"/api/orders/${data.order_id}",
				data:JSON.stringify(jsondata),
				dataType:"json",
				contentType:"application/json; charset=utf-8",
				type:"put",
				success:function(result){
					if(result.code == 200){
						alert("수정이 완료되었습니다.");
						$("#hwigBtn").attr("disabled","disabled");
						$("#order_status").val("배송 중");
						self.location = "list?page=${page}&perPageNum=${perPageNum}&searchType=${searchType}&keyword=${keyword}";
					} else {
						alert("수정이 실패되었습니다.");
					}
				} 
			});
		});
	});
	
</script>