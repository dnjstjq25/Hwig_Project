<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>양식 본문 수정</title>

<script>
	
	function check_upload(){
		upForm = document.c_uploadForm;
		
		
		if(upForm.macro_link.value==""){
			alert("양식명을 입력해주세요.");
			return upForm.macro_link.focus();
		} 
		if(upForm.macro_content.value==""){
			alert("본문을 입력해주세요.");
			return upForm.macro_content.focus();
		}
		
		
		if(confirm("수정 하시겠습니까?")){
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
                                <h3 class="panel-title">양식 본문 수정</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="c_uploadForm" class="form-horizontal form-border">               						
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">양식명</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="macro_link" name="macro_link" class="form-control" value="${macro_c_view.macro_link}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문</label>
                                        <div class="col-sm-6">
                                            <textarea style="resize:none; height:500px;" id="macro_content" name="macro_content" class="form-control">${macro_c_view.macro_content}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4 pull-right">
                                            <input type="button" value="수정" class="btn btn-success" onclick="check_upload()"/>
                    						<input type="button" value="목록" class="btn btn-danger" onclick="javascript:location.href='temlist?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'"/>
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
			var txt_content = $('#macro_content').val();
			var result = txt_content.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$('#macro_content').val(result); 
		})
	</script>
</body>
</html>