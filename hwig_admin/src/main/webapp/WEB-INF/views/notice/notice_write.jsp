<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>공지사항 등록</title>
<script>
function check_upload(){
	upForm = document.n_uploadForm;
	
	if(upForm.notice_subject.value==""){
		alert("제목을 입력해주세요.");
		return upForm.notice_subject.focus();
	} 
	if(upForm.notice_content.value==""){
		alert("본문을 입력해주세요.");
		return upForm.notice_content.focus();
	}

	if(confirm("등록 하시겠습니까?")){
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
                                <h3 class="panel-title">공지사항 등록</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="n_uploadForm" class="form-horizontal form-border">         
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">제목<span class="star">*</span></label>
                                        <div class="col-sm-6">
                                            <input type="text" name="notice_subject" class="form-control" placeholder="제목을 입력하세요. ">
                                        </div>
                                    </div>                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문<span class="star">*</span></label>
                                        <div class="col-sm-6">
                                            <textarea style="height:500px; resize:none;" name="notice_content" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4 pull-right">
                                            <input type="button" value="등록" class="btn btn-info" onclick="check_upload()"/>
                   							<input type="reset" value="초기화" class="btn btn-success"/>
                    						<input type="button" value="목록 " class="btn btn-danger" onclick="javascript:location.href=document.referrer"/>
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