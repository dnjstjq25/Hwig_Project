<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>자주묻는질문 수정</title>

<script>
	function select_category(frm){
		
		var selec = frm.category.selectedIndex;
		
		switch(selec){
		case 0:
			frm.faq_category.value = '선택';
		break;
		case 1:
			frm.faq_category.value = '회원문의';
		break;
		case 2:
			frm.faq_category.value = '주문/결제';
		break;
		case 3:
			frm.faq_category.value = '취소/교환/반품';
		break;
		case 4:
			frm.faq_category.value = '배송문의';
		break;
		case 5:
			frm.faq_category.value = '적립금';
		break;
		case 6:
			frm.faq_category.value = '서비스 이용 및 기타';
		break;
		}
		return true;
	}
	
	function check_upload(){
		upForm = document.f_uploadForm;
		var selec = upForm.category.selectedIndex;
		
		if(upForm.faq_subject.value==""){
			alert("제목을 입력해주세요.");
			return upForm.faq_subject.focus();
		} 
		if(upForm.faq_content.value==""){
			alert("본문을 입력해주세요.");
			return upForm.faq_content.focus();
		}
		if(selec==0){
			alert("카테고리를 설정해주세요.")
			return upForm.faq_category.focus();
		}
		
		
		if(confirm("수정 하시겠습니까?")){
			upForm.submit();
		}else{
			return;
		}
	}
	
</script>
<style>
	.star{
		color:red;
	}
</style>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">자주묻는질문 등록</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="f_uploadForm" class="form-horizontal form-border">
               						<input type="hidden" name="faq_category" value="${faq_view.faq_category}">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">제목<span class="star">*</span></label>
                                        <div class="col-sm-6">
                                            <input type="text" name="faq_subject" class="form-control" placeholder="제목을 입력하세요. " value="${faq_view.faq_subject}">
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-3 control-label">카테고리<span class="star">*</span></label>
	                                    <div class="col-sm-6">
		                                    <select class="form-control" name="category" onchange="select_category(this.form)">
		                                        <option selected value=0>선택</option>
		                                        <option value=1>회원문의</option>
		                                        <option value=2>주문/결제</option>
		                                        <option value=3>취소/교환/반품</option>
		                                        <option value=4>배송문의</option>
		                                        <option value=5>적립금</option>
		                                        <option value=6>서비스 이용 및 기타</option>
		                                    </select>
	                                	</div>
       								</div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문<span class="star">*</span></label>
                                        <div class="col-sm-6">
                                            <textarea style="resize:none; height:500px;" id="faq_content" name="faq_content" class="form-control">${faq_view.faq_content}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 pull-right">
                                            <input type="button" value="수정" class="btn btn-success" onclick="check_upload()"/>
                    						<input type="button" value="목록" class="btn btn-danger" onclick="javascript:location.href='/faq/faq_modify?faq_id=${fList.faq_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'"/>
                                        </div>
                                    </div>                                        
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
          </section>
	<%@ include file="../include/footnav.jsp" %>
	<script>
		$(function(){
			var txt_content = $('#faq_content').val();
			var result = txt_content.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$('#faq_content').val(result); 
		})
	</script>
</body>
</html>