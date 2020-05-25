<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>양식 관리</title>
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
			<h1>양식 관리</h1>
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
								머리말 꼬리말 양식 관리
							</h1>

							<div class="actions pull-right">
								<i class="fa fa-expand"></i> <i class="fa fa-chevron-down"></i>
								<i class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<table id="example" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>양식 번호</th>
										<th>카테고리</th>
										<th>관리</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="macro_ht" items="${macro_ht}">
										<tr>
											<td>${macro_ht.macro_id}</td>
											<td>${macro_ht.qna_category}</td>											
											<td>
												<button type="button" onclick="enco('/qna/tem_ht_modify?qna_category=${macro_ht.qna_category}')" class="btn btn-success">수정</button>                            
                                			</td>
										</tr>
																
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1>
								본문 양식 관리 <a href="/qna/tem_write" class="btn btn-info">추가</a>
							</h1>

							<div class="actions pull-right">
								<i class="fa fa-expand"></i> <i class="fa fa-chevron-down"></i>
								<i class="fa fa-times"></i>
							</div>
						</div>
						<div class="panel-body">
							<table id="example2" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>양식 번호</th>
										<th>양식 제목</th>
										<th>카테고리</th>
										<th>관리</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="mList" items="${mList}">
										<tr>
											<td>${mList.macro_c_id}</td>
											<td>${mList.macro_link}</td>
											<td>${mList.qna_category}</td>
											<td>
												<button type="button" class="btn btn-success" 
												onclick="location.href='/qna/tem_modify?macro_c_id=${mList.macro_c_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'" >수정</button>                            
												<button type="button" class="btn btn-danger" 
												onclick="location.href='/qna/tem_delete?macro_c_id=${mList.macro_c_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'" >삭제</button>                            
                                			</td>
										</tr>
																
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</section>

	<%@ include file="../include/footnav.jsp"%>

<script src="../resources/assets/plugins/dataTables/js/jquery.dataTables.js"></script>
<script src="../resources/assets/plugins/dataTables/js/dataTables.bootstrap.js"></script>
<script>
$(document).ready(function() {
    $('#example').dataTable();
    
    $('#example2').dataTable();
	});	
</script>
<script>
function enco(str){
	 window.location.href = encodeURI(str);
}

</script>
</body>
</html>