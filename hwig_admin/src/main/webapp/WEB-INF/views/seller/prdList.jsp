<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#keyword{
	margin-right:10px;
	height:37px;
}
#searchType{
	width:100px;	
}
</style>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--main content start-->
	<section class="main-content-wrapper">
		<div class="pageheader">
			<h1>재고 관리</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
			<div class="row">
				<div class="col-md-12">
	
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">재고 내역</h3>
							<div class="actions pull-right">
								<i class="fa fa-expand"></i> <i class="fa fa-chevron-down"></i> <i
									class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-7">
									<div class="dataTables_length" id="example_length">
										<div class="form-group">
											<label>검색 
											<select name="searchType" id="searchType">
												<option value="" <c:out value="${cri.searchType == null ? 'selected' : ' '}" />>----</option>
												<option value="prdid" <c:out value="${cri.searchType eq 'prdid' ? 'selected' : ' ' }" />>상품아이디</option>
												<option value="prdname" <c:out value="${cri.searchType eq 'prdname' ? 'selected' : ' ' }" />>상품명</option>
											</select>
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-5">
									<div id="example_filter" class="dataTables_filter">
										<button type="button" class="btn btn-success" id="searchBtn">검색</button>
										<label id="listLabel"><input type="search" class="form-control input-sm" aria-controls="example" id="keyword" value="${cri.keyword}"></label>
									</div>
								</div>
							</div>
							<div class="table-responsive">
								<table class="table table-bordered table-striped text-center">
									<thead>
										<tr>
											<th style="text-align: center">아이디</th>
											<th style="text-align: center">상품명</th>
											<th style="text-align: center">재고수량</th>
											<th style="text-align: center">가격</th>
											<th style="text-align: center">원산지</th>
											<th style="text-align: center">안내사항</th>
											<th style="text-align: center">등록날짜</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${fn:length(list) > 0}">
											<c:forEach var="list" items="${list}">
												<tr>
													<td>${list.prd_id}</td>
													<td>${list.prd_name}</td>
													<td>${list.prd_stock}</td>
													<td>${list.prd_price}</td>
													<td>${list.prd_from}</td>
													<td>${list.prd_info}</td>
													<td>${list.prd_date}</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${fn:length(list) < 1}">
											<tr>
												<td colspan="7">관리할 상품이 없습니다</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<div class="col-xs-12">
								<div class="dataTables_paginate paging_simple_numbers" id="example_paginate">
									<ul class="pagination">
										<c:if test="${pageMaker.prev}">
											<li><a href="list${pageMaker.makeSearch(pageMaker.startPage-1)}">&laquo;</a></li>
										</c:if>
		
										<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
											<li
												<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
												<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
											</li>
										</c:forEach>
		
										<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
											<li><a href="list${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
										</c:if>
									</ul>
								</div>
							</div>
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
		function search(){
			self.location = "prdList"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("#searchType option:selected").val()
				+ "&keyword=" + encodeURIComponent($('#keyword').val());
		}
		
		$("#searchBtn").on("click", search);
		
		$("#keyword").keydown(function(key) {
            if (key.keyCode == 13) {
				search();
            }
        });
		
		$("#registerBtn").on("click", function(){
			self.location = "registerForm";
		});
	});
	
	var result = '${msg}';
	
	if(result == 'success') {
		alert("처리가 완료되었습니다.");
	} /* else {
		alert("처리가 실패되었습니다.");
	} */
	
	
</script>