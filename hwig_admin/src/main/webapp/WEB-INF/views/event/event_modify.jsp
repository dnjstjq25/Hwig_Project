<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>이벤트 수정</title>
<script>
function check_upload(){
	upForm = document.e_uploadForm;
	var content = document.getElementById("event_content_img").value;
	var banner = document.getElementById("event_banner_img").value;
	var square = document.getElementById("event_square_img").value;
	var list = document.getElementById("event_list_img").value;
	
	if(upForm.event_subject.value==""){
		alert("제목을 입력해주세요.");
		return upForm.event_subject.focus();
	} 
	if(upForm.event_content.value==""){
		alert("본문을 입력해주세요.");
		return upForm.event_content.focus();
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
                                <h3 class="panel-title">이벤트 수정</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="e_uploadForm" encType="multipart/form-data" role="form" class="form-horizontal form-border">         
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">제목</label>
                                        <div class="col-sm-6">
                                            <input type="text" name="event_subject" class="form-control" placeholder="제목을 입력하세요. " value="${event_view.event_subject}">
                                        </div>
                                    </div>                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문</label>
                                        <div class="col-sm-6">
                                            <textarea styles="height:500px; resize:none;" name="event_content" class="form-control">${event_view.event_content}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문 이미지</label>
                                        <div class="col-sm-6">
                                        	<input type="file" id="event_content_img" name="file">                                        
	                                        <div class="select_img1">
	                                        	<img src="${event_view.event_content_img}" />
					  							<input type="hidden" name="event_content_img" value="${event_view.event_content_img}" />
					  						</div>
	                                        <script>
						            			$("#event_content_img").change(function(){
						            				if(this.files && this.files[0]){
						            					var reader = new FileReader;
						            					reader.onload = function(data){
						            						$(".select_img1 img").attr("src", data.target.result).width(500);
						            					}
						            					reader.readAsDataURL(this.files[0]);
						            				}
						            			});
						            		</script>
					            		</div>                                    
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">배너 이미지</label>
                                        <div class="col-sm-6">
                                        	<input type="file" id="event_banner_img" name="file">                                        
	                                        <div class="select_img2">
												<img src="${event_view.event_banner_img}" />
					  							<input type="hidden" name="event_banner_img" value="${event_view.event_banner_img}" />
											</div>
	                                        <script>
						            			$("#event_banner_img").change(function(){
						            				if(this.files && this.files[0]){
						            					var reader = new FileReader;
						            					reader.onload = function(data){
						            						$(".select_img2 img").attr("src", data.target.result).width(500);
						            					}
						            					reader.readAsDataURL(this.files[0]);
						            				}
						            			});
						            		</script>  
					            		</div>                                  
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">사각 이미지</label>
                                        <div class="col-sm-6">
	                                        <input type="file" id="event_square_img" name="file">
	                                        <div class="select_img3">
	                                        	<img src="${event_view.event_square_img}" />
					  							<input type="hidden" name="event_square_img" value="${event_view.event_square_img}" />
	                                        </div> 
	                                        <script>
						            			$("#event_square_img").change(function(){
						            				if(this.files && this.files[0]){
						            					var reader = new FileReader;
						            					reader.onload = function(data){
						            						$(".select_img3 img").attr("src", data.target.result).width(500);
						            					}
						            					reader.readAsDataURL(this.files[0]);
						            				}
						            			});
						            		</script>
					            		</div>                                    
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">목록 이미지</label>
                                        <div class="col-sm-6">
	                                        <input type="file" id="event_list_img" name="file">
	                                        <div class="select_img4">
	                                        	<img src="${event_view.event_list_img}" />
					  							<input type="hidden" name="event_list_img" value="${event_view.event_list_img}" />
	                                        </div>
	                                        <script>
						            			$("#event_list_img").change(function(){
						            				if(this.files && this.files[0]){
						            					var reader = new FileReader;
						            					reader.onload = function(data){
						            						$(".select_img4 img").attr("src", data.target.result).width(500);
						            					}
						            					reader.readAsDataURL(this.files[0]);
						            				}
						            			});
						            		</script> 
					            		</div>                                   
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4 pull-right">
                                            <input type="button" value="수정" class="btn btn-info" onclick="check_upload()"/>
                   							<input type="reset" value="초기화" class="btn btn-success"/>
                    						<input type="button" value="목록 " class="btn btn-danger" onclick="javascript:history.back()"/>
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