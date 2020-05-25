<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<section class="main-content-wrapper">
        <div class="pageheader">
              <h1>상품 조회 페이지</h1>
              <p class="description">상품을 조회하는 페이지입니다</p>
              <div class="breadcrumb-wrapper hidden-xs">
                  <span class="label">You are here:</span>
                  <ol class="breadcrumb">
                      <li class="active">상품 조회</li>
                  </ol>
              </div>
        </div>
	<section id="main-content" class="animated fadeInUp">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>상품 조회</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
	                    </div>
					</div>
					<div class="panel-body" id="readdiv">
						<form role="form" method="post" class="form-horizontal form-border" encType="multipart/form-data" id="form">
							<input type="hidden" value="${product.prd_id}" class="prdid">
							<div class="form-group">
								<label class="col-sm-3 control-label" for="category_id">카테고리</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="category_id" name="category_id" readonly="readonly" value ="${cateName}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="sel_id">판매자 id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sel_id" name="sel_id" readonly="readonly" value ="${product.sel_id}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_ea">판매단위</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_ea" name="prd_ea" readonly="readonly" value ="${product.prd_ea}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_name">상품명</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_name" name="prd_name" readonly="readonly" value ="${product.prd_name}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_thumb">썸네일</label>
								<div class="col-sm-6">
									<input type="hidden" name="prd_thumb"  value="${product.prd_thumb}" />
									<div class="select_thumb">
										<img src="${product.prd_thumb}"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_comment">한줄설명</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_comment" name="prd_comment" readonly="readonly" value ="${product.prd_comment}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_img">이미지</label>
								<div class="col-sm-6">
									<input type="hidden" name="prd_img"  value="${product.prd_img}" />
									<div class="select_img">
										<img src="${product.prd_img}"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_stock">재고</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_stock" name="prd_stock" readonly="readonly" value ="${product.prd_stock}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_price">원가</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_price" name="prd_price" readonly="readonly" value ="${product.prd_price}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_sale">할인율</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_sale" name="prd_sale" readonly="readonly" value ="${product.prd_sale}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_kg">중량/용량</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_kg" name="prd_kg" readonly="readonly" value ="${product.prd_kg}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_from">원산지</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_from" name="prd_from" readonly="readonly" value ="${product.prd_from}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_wrap">포장타입</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_wrap" name="prd_wrap" readonly="readonly" value ="${product.prd_wrap}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_info">안내사항</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_info" name="prd_info" readonly="readonly" value ="${product.prd_info}" maxlength="200">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-6">	
									<button type="button" id="btn_input" onclick="history.back()" class="btn btn-primary">뒤로가기</button>
									<button type="button" class="btn btn-danger btn_del">삭제</button>
								</div>
	                        </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script>
	$('.btn_del').click(function(){
		var ids = $('.prdid').val(); //prd_id를 얻어온다
		var url = '/product/prd_deletelist?prd_id='+ids;
	
		var result = confirm(ids + "번 상품을 삭제하시겠습니까?"); //상품 삭제 확인 알림
		
		if(result){ //확인을 눌렀을 경우
			$(location).attr('href', url); //삭제를 해 준다
		}
	});
	
	var result = "${msg}";
	if(result == "success") { //완료 사실을 알려준다
		alert("완료되었습니다.")
	}
</script>