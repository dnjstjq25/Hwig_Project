<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>고객후기 수정</title>
<script>
function check_upload(){
	upForm = document.n_uploadForm;
	
	if(upForm.review_subject.value==""){
		alert("제목을 입력해주세요.");
		return upForm.review_subject.focus();
	} 
	if(upForm.review_content.value==""){
		alert("본문을 입력해주세요.");
		return upForm.review_content.focus();
	}

	if(confirm("등록 하시겠습니까?")){
		upForm.submit();
	}else{
		return;
	}
}
</script>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">고객후기 수정</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="n_uploadForm" class="form-horizontal form-border">            
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">제목</label>
                                        <div class="col-sm-6">
                                            <input type="text" name="review_subject" class="form-control" placeholder="제목을 입력하세요. " value="${review_view.review_subject}">
                                        </div>
                                    </div>                             
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문</label>
                                        <div class="col-sm-6">
                                            <textarea styles="height:500px; resize:none;" name="review_content" class="form-control">${review_view.review_content}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4 pull-right">
                                            <input type="button" value="수정" class="btn btn-success" onclick="check_upload()"/>
                    						<input type="button" value="목록 " class="btn btn-danger" onclick="javascript:location.href='/review/review_modify?review_id=${reviewList.review_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'"/>
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
</body>
</html>