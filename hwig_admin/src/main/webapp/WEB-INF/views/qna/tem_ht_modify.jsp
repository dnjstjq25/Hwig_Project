<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>머리말 꼬리말 수정</title>

<script>
	
	function check_upload(){
		upForm = document.ht_uploadForm;
		
		
		if(upForm.macro_head.value==""){
			alert("제목을 입력해주세요.");
			return upForm.macro_head.focus();
		} 
		if(upForm.macro_tail.value==""){
			alert("본문을 입력해주세요.");
			return upForm.macro_tail.focus();
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
                                <h3 class="panel-title">머리말 꼬리말 수정</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="ht_uploadForm" class="form-horizontal form-border">               						
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">머리말</label>
                                        <div class="col-sm-6">
                                            <textarea style="resize:none; height:300px;" id="macro_head" name="macro_head" class="form-control">${macro.macro_head}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">꼬리말</label>
                                        <div class="col-sm-6">
                                            <textarea style="resize:none; height:300px;" id="macro_tail" name="macro_tail" class="form-control">${macro.macro_tail}</textarea>
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
			var txt_head = $('#macro_head').val();
			
			var result = txt_head.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$('#macro_head').val(result);
			
			var txt_tail = $('#macro_tail').val();
			var result = txt_tail.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$('#macro_tail').val(result); 
		})
	</script>
</body>
</html>