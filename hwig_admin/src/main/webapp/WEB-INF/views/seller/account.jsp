<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>판매자 정보</h1>
    </div>
    <section id="main-content" class="animated fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">${sessionScope.user.sel_id}</h3>
                    </div>
                    <div class="panel-body">
                        <div class="form-horizontal form-border">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">사업자등록번호</label>
                                <div class="col-sm-6">
                                    <input type="number" class="form-control" id="sel_id" name="sel_id" readonly="readonly" value="${sessionScope.user.sel_id}" maxlength="20">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label class="col-sm-3 control-label"></label>
                            	<div class="col-sm-6">
                            		<button class="btn btn-primary" id="pwChangeBtn">비밀번호변경</button>
                            	</div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">상호명</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="sel_cname" name="sel_cname" readonly="readonly" value="${sessionScope.user.sel_cname}" maxlength="200">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">대표자명</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="sel_name" name="sel_name" value="${sessionScope.user.sel_name}" maxlength="20" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">사업장 소재지</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${sessionScope.user.sel_addr}" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">전화번호</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " id="sel_tel" name="sel_tel" value="${sessionScope.user.sel_tel}" maxlength="20" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">사업자등록증 사본</label>
                                <div class="col-sm-6">
                                    <img src="${sessionScope.user.sel_img}" id="attach_img" width="300px" height="400px">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6" align="right">
                                    <button type="button" class="btn btn-danger" id="mainBtn">메인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->

<!-- Form Modal -->
    <div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">비밀번호변경</h4>
                </div>
                <form class="form-horizontal" role="form" method="post" action="changePw" id="changePwForm">
                <div class="modal-body">
                	<div class="form-group">
                         <label for="inputPassword3" class="col-sm-2 control-label">번호</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control" id="sel_id" name="sel_id" value="${sessionScope.user.sel_id}" readonly="readonly">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="inputPassword3" class="col-sm-2 control-label">비밀변호</label>
                         <div class="col-sm-10">
                             <input type="password" class="form-control" id="sel_pw" name="sel_pw" placeholder="변경할 비밀번호를 입력하세요">
                         </div>
                     </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" id="changeBtn">변경</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <!-- End Form Modal -->
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
        $("#pwChangeBtn").click(function(){
        	$("div.modal").modal();
        });
        
        $("#changeBtn").click(function(){
        	$("#changePwForm").submit();
        });
        
        $("#mainBtn").click(function(){
        	self.location = "../main";
        });
        
        var result = '${msg}';
    	
    	if(result == 'success') {
    		alert("처리가 완료되었습니다.");
    	}
	});
</script>