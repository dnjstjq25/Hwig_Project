<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>고객후기 조회</title>

</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
	
	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row" id="qna_row">
  						<div class="container" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                                <header>
	                                    <h2>${review_view.review_subject}</h2>
	                                     	작성자 : ${review_view.mem_id}	 
	                                </header>
	                                
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                            	<img src="http://13.209.202.242:8080${review_view.review_img}" class="rev_img">
	                                                <pre style="background-color:white; border:none;">${review_view.review_content}</pre>
	                                            </div>                              
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="col-md-12">
	                                	<button class="btn btn-danger pull-right" onclick="location.href='/review/review_delete?review_id=${review_view.review_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">삭제</button>
	                                    <button class="btn btn-success pull-right" onclick="location.href='/review/review_modify?review_id=${review_view.review_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">수정</button>	
	                                    <a href="reviewList?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}" class="btn btn-info pull-right">목록</a>	                                   
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                   </div>

            </section>
     </section>
	<%@ include file="../include/footnav.jsp" %>
	<script>
		$(function(){
			var img = '${review_view.review_img}';
			if(img == ''){
				$('.rev_img').remove();
			}
		})
	</script>
</body>
</html>