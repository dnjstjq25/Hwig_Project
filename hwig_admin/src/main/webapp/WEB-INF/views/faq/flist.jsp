<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>자주묻는질문</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script>
    var result = "${msg}";
    if(result == "success"){
        alert("완료되었습니다.");
    }
</script>

<style>
#keyword{
	margin-right:10px;
	height:37px;
}
#searchType{
	width:100px;	
}
</style>
</head>
<body>
	<%@ include file="../include/headnav.jsp"%>
	<section class="main-content-wrapper">
		<div class="pageheader">
			<h1>자주묻는질문 관리</h1>
			<div class="breadcrumb-wrapper hidden-xs">
				<span class="label">You are here:</span>
				<ol class="breadcrumb">
					<li><a href="index.html">Dashboard</a></li>
					<li>Tables</li>
					<li class="active">Data Tables</li>
				</ol>
			</div>
		</div>
		<section id="main-content" class="animated fadeInUp">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1>
								자주묻는질문 관리 <a href="/faq/faq_write" class="btn btn-info">추가</a>
							</h1>

							<div class="actions pull-right">
								<i class="fa fa-expand"></i> <i class="fa fa-chevron-down"></i>
								<i class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-7">
									<div class="dataTables_length" id="example_length">
										<div class="form-group">
											<label>검색 
												<select name="searchType" id="searchType">
													<option value=""
													<c:out value="${cri.searchType == null ? 'selected' : ' '}" />>----</option>
													<option value="subject"
													<c:out value="${cri.searchType eq 'subject' ? 'selected' : ' ' }" />>제목</option>
													<option value="category"
													<c:out value="${cri.searchType eq 'category' ? 'selected' : ' ' }" />>카테고리</option>
													<option value="content"
													<c:out value="${cri.searchType eq 'content' ? 'selected' : ' ' }" />>내용</option>							
												</select>
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-5">
									<div id="example_filter" class="dataTables_filter">
										<button type="button" class="btn btn-success pull-right" id="searchBtn">검색</button>
										<label id="listLabel"><input type="search" class="form-control input-sm" aria-controls="example" id="keyword" value="${cri.keyword}"></label>
										
									</div>
								</div>
							</div>
							<table id="example" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th class="col-md-2 text-center"">글 번호</th>
										<th class="col-md-3 text-center"">카테고리</th>
										<th class="col-md-7 text-center">제목</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="fList" varStatus="status" items="${fList}">
										<tr>
											<td>${pageMaker.totalCount - ((pageMaker.cri.page - 1) * pageMaker.cri.perPageNum + status.index)}</td>
											<td>${fList.faq_category}</td>
											<td><a href="faq_view?faq_id=${fList.faq_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}">${fList.faq_subject}</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="col-xs-12">
								<div class="dataTables_paginate paging_simple_numbers"
									id="example_paginate">
									<ul class="pagination">
										<c:if test="${pageMaker.prev}">
											<li class="paginate_button previous" tabindex="0"><a
												href="flist${pageMaker.makeSearch(pageMaker.startPage-1)}">Previous</a></li>
										</c:if>

										<c:forEach begin="${pageMaker.startPage}"
											end="${pageMaker.endPage}" var="idx">
											<li <c:out value="${pageMaker.cri.page == idx?'class=active':''}"/> class="paginate_button">
												<a href="flist${pageMaker.makeSearch(idx)}">${idx}</a>
											</li>
										</c:forEach>

										<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
											<li class="paginate_button next"><a
												href="flist${pageMaker.makeSearch(pageMaker.endPage+1)}">Next</a></li>
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
	<%@ include file="../include/footnav.jsp"%>
	<script>
	 $(function(){
	  $('#searchBtn').click(function() {
	   self.location = "flist"
	     + '${pageMaker.makeQuery(1)}'
	     + "&searchType="
	     + $("#searchType option:selected").val()
	     + "&keyword="
	     + encodeURIComponent($('#keyword').val());
	    });
	 });   
</script>
</body>
</html>