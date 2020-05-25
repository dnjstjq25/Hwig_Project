<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>공지사항 조회</title>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>

	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row">
  						<div class="container" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                                <header>
	                                    <h2>공지사항 조회</h2>	                                    
	                                </header>
	                                <div class="row view-mail-header">
	                                    <div class="col-md-6 ">
	                                    	<div class="view-mail-reply">
	                                            제목 ${notice_view.notice_subject}
	                                          
	                                             
	                                        </div>		                  
	                                    </div>
	                                    <div class="col-md-4">
	                                        <div class="view-mail-reply pull-right">
	                                              작성일 ${notice_view.notice_regdate}
	                                        </div>
                                    	</div>
                                    	<div class="col-md-2">
	                                        <div class="view-mail-reply pull-right">
	                                           조회수 ${notice_view.notice_hit}
	                                        </div>
                                    	</div>                                   
	                                </div>
	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                                <p>${notice_view.notice_content}</p>
	                                            </div>            
	                                            <button class="btn btn-danger pull-right" onclick="location.href='/notice/notice_delete?notice_id=${notice_view.notice_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">삭제</button>
	                                            <button class="btn btn-success pull-right" onclick="location.href='/notice/notice_modify?notice_id=${notice_view.notice_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">수정</button>	
	                                            <a href="nlist?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}" class="btn btn-info pull-right">목록</a>	                                                           
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                   </div>
            </section>
     </section>
	<%@ include file="../include/footnav.jsp" %>
</body>
</html>