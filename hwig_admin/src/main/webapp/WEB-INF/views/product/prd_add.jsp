<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<section class="main-content-wrapper">
        <div class="pageheader">
              <h1>상품 등록 페이지</h1>
              <p class="description">상품을 등록하는 페이지입니다</p>
              <div class="breadcrumb-wrapper hidden-xs">
                  <span class="label">You are here:</span>
                  <ol class="breadcrumb">
                      <li class="active">상품 등록</li>
                  </ol>
              </div>
        </div>
	<section id="main-content" class="animated fadeInUp">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>상품 등록</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
	                    </div>
					</div>
					<div class="panel-body">
						<form role="form" method="post" class="form-horizontal form-border" encType="multipart/form-data" id="form">
							<div class="form-group">
								<label class="col-sm-3 control-label" for="category_id">카테고리 id</label>
								<div class="col-sm-6">
									<select class="form-control" name="category_select" id="category_select">
										<option value="100">기본채소</option>
										<option value="101">국산 과일</option>
										<option value="102">수입 과일</option>
										<option value="200">소/돼지</option>
										<option value="201">닭/오리</option>
										<option value="202">간편조리/양념육</option>
									</select>
									<input type="hidden" id="category_id" name="category_id" value="100" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="sel_id">판매자 id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sel_id" name="sel_id" value="${sessionScope.user.sel_id}" readonly="readonly"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_ea">판매단위</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_ea" name="prd_ea" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_name">상품명</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_name" name="prd_name" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_thumb">썸네일</label>
								<div class="col-sm-6">
									<input type="file" id="prd_thumb" class="prd_thumb" name="file" required=""/>
									<div class="select_thumb">
										<img src=""/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_comment">한줄설명</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_comment" name="prd_comment" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_img">이미지</label>
								<div class="col-sm-6">
									<input type="file" id="prd_img" class="prd_img" name="file" required=""/>
									<div class="select_img">
										<img src=""/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_stock">재고</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="prd_stock" name="prd_stock" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_price">원가</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="prd_price" name="prd_price" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_kg">중량/용량</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_kg" name="prd_kg" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_from">원산지</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_from" name="prd_from" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_wrap">포장타입</label>
								<div class="col-sm-6">
									<select class="form-control" name="prd_wrap_select" id="prd_wrap_select">
										<option value="0">선택</option>
										<option value="박스(BOX)">박스(BOX)</option>
										<option value="스티로폼">스티로폼</option>
										<option value="비닐">비닐</option>
									</select>
									<input type="hidden" id="prd_wrap" name="prd_wrap" value="100" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_info">안내사항</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_info" name="prd_info" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-6">	
									<button type="submit" id="btn_input" class="btn btn-primary">등록</button>
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
										$("#category_select").click(function(){
											var s_value= $("#category_select option:selected").attr('value');
											var s_int_value = parseInt(s_value);
											$("#category_id").val(s_int_value);
										})
									</script>
									
								<script>
									$('.prd_thumb').change(function(){
										if(this.files && this.files[0]) {
											var reader = new FileReader;
											reader.onload = function(data) {
												$(".select_thumb img").attr("src", data.target.result).width(500);
											}
											reader.readAsDataURL(this.files[0]);
										}
									});
								</script>
								<script>
									$('.prd_img').change(function(){
										if(this.files && this.files[0]) {
											var reader = new FileReader;
											reader.onload = function(data) {
												$(".select_img img").attr("src", data.target.result).width(500);
											}
											reader.readAsDataURL(this.files[0]);
										}
									});
								</script>
									<script>
										$("#prd_wrap_select").click(function(){
											var info_value= $("#prd_wrap_select option:selected").attr('value');
											$("#prd_wrap").val(info_value);
										})
									</script>