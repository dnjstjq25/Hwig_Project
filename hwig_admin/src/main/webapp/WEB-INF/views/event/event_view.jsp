<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>이벤트 조회</title>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>

	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row">
  						<div class="col-md-12 col-sm-12" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                                <header>
	                                    <h2>이벤트 조회</h2>	                                    
	                                </header>
	                                <div class="row view-mail-header">
	                                    <div class="col-md-12 ">
	                                    	<div class="view-mail-reply">
	                                            ${event_view.event_subject}
	                                        </div>		                  
	                                    </div>	                                                      
	                                </div>
	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                                <p>${event_view.event_content}</p>	                                        
	                                            </div>
	                                            <div class="panel-body">
	                                                <p>본문 이미지</p>
	                                                <img src="${event_view.event_content_img}"/>
	                                                <p>배너 이미지</p>
	                                                <img src="${event_view.event_banner_img}"/>
	                                            </div>
	                                            
	                                            <div class="panel-body">
	                                                <p>사각 이미지</p>
	                                                <img src="${event_view.event_square_img}"/>
	                                            </div>
	                                            <div class="panel-body">
	                                                <p>목록 이미지</p>
	                                                <img src="${event_view.event_list_img}"/>
	                                            </div>            
	                                            <button class="btn btn-danger pull-right" onclick="location.href='/event/event_delete?event_id=${event_view.event_id}'">삭제</button>
	                                            <button class="btn btn-success pull-right" onclick="location.href='/event/event_modify?event_id=${event_view.event_id}'">수정</button>	
	                                            <a href="javascript:location.href=document.referrer" class="btn btn-info pull-right">목록</a>	                                                           
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