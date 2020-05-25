<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<section class="main-content-wrapper">
        <div class="pageheader">
              <h1>승인 완료</h1>
              <p class="description">상품 목록 페이지 입니다.</p>
              <div class="breadcrumb-wrapper hidden-xs">
                  <span class="label">You are here:</span>
                  <ol class="breadcrumb">
                      <li class="active">Dashboard</li>
                  </ol>
              </div>
        </div>
	<section id="main-content" class="animated fadeInUp">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">상품 목록</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
	                    </div>
					</div>
					<div class="panel-body">
					<div class="row">
							<div class="col-xs-8">
								<div class="dataTables_length" id="example_length">
									<label>검색 <select name="searchType" id="searchType">
											<option value="id"
												<c:out value="${cri.searchType eq 'id' ? 'selected' : ' ' }" />>
												상품번호</option>
											<option value="pname"
												<c:out value="${cri.searchType eq 'pname' ? 'selected' : ' ' }" />>
												상품명</option>
									</select>
									</label>
								</div>
							</div>
							<div class="col-xs-4">
								<div id="example_filter" class="dataTables_filter">
									<label id="listLabel">
										<input type="search" class="form-control input-sm" aria-controls="example" id="keyword" value="${cri.keyword}">
									</label>
									<button type="button" class="btn btn-success" id="searchBtn">검색</button>
								</div>
							</div>
						</div>
						<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th id="th1">상품번호</th>
									<th id="th2">카테고리</th>
									<th id="th3">판매자</th>
									<th id="th4">상품명</th>
									<th id="th5">원가</th>
									<th id="th6">한줄설명</th>
								</tr>
							</thead>
							
							<tbody>
							<!-- 목록 -->
								<c:forEach items="${list}" var="list" varStatus="status">
									<tr class="lists">
										<td>${list.prd_id}</td>
										<td>${list.category_name}</td>
										<td>${list.sel_cname}</td>
										<td>${list.prd_name}</td>
										<td>${list.prd_price}</td>
										<td>${list.prd_comment}</td>
									</tr>
								</c:forEach>
							<!-- 목록 -->
							</tbody>
						</table>
						<div class="col-xs-12">
							<div class="dataTables_paginate paging_simple_numbers" id="example_paginate">
								<ul class="pagination">
									<c:if test="${pageMaker.prev}">
										<li><a href="prd_list${pageMaker.makeSearch(pageMaker.startPage-1)}">&laquo;</a></li>
									</c:if>
	
									<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
										<li
											<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
											<a href="prd_list${pageMaker.makeSearch(idx)}">${idx}</a>
										</li>
									</c:forEach>
	
									<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
										<li><a href="prd_list${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
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
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script>
$(document).ready(function() {
	function search(){
		self.location = "prd_list_seller"
			+ '${pageMaker.makeQuery(1)}'
			+ "&searchType="
			+ $("#searchType option:selected").val()
			+"&sel_id=${cri.sel_id}"
			+ "&keyword=" + encodeURIComponent($('#keyword').val());
	}
	
	$("#searchBtn").on("click", search);
	
	$("#keyword").keydown(function(key) {
        if (key.keyCode == 13) {
			search();
        }
    });
});

	$('.lists').bind({
		click: function() {
			var ids = $(this).children().eq(0).text();
			var url="/product/prd_read_seller?prd_id=" + ids;
			$(location).attr('href', url); //조회 페이지로 이동
		},
		mouseover: function(){
			$(this).css('background-color', 'lightgray').css('cursor', 'pointer');
		},
		mouseout: function(){
			$(this).css('background-color', '');
		}
	});
</script>