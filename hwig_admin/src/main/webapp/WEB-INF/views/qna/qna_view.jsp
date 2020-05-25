<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>1대1 문의 조회</title>

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
	                                    <h2>${qna_view.qna_subject}</h2>
	                                     	작성자 : ${qna_view.mem_id} /	 
	                                      	${qna_view.qna_category}                                   
	                                </header>
	                                
	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                                <pre style="background-color:white; border:none;">${qna_view.qna_content}</pre>
	                                            </div>                              
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="col-md-12">
	                                	<button class="btn btn-danger pull-right" onclick="location.href='/qna/qna_delete?qna_id=${qna_view.qna_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">삭제</button>
	                                    <a href="qlist?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}" class="btn btn-info pull-right">목록</a>	                                   
	                                </div>
	                            </div>
	                        </div>
	                        
	                    </div>
	                   
	                                	
	                              
                   </div>
                   
                   <div class="row" id="reply_row">
  						<div class="container" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                                <header>
	                                    <h2>re:${qna_view.qna_subject}</h2>
	                                    	작성자 : Hwig /	 
	                                      	${qna_view.qna_category}	                                    
	                                </header>

	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                            	<p>${rList.reply_content}</p>	   
	                                            </div>
	                                            
	                                            <div class="col-md-12">
			                                		<button class="btn btn-danger pull-right" onclick="location.href='/qna/reply_delete?reply_id=${rList.reply_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">삭제</button>
			                                        <button class="btn btn-success pull-right" id="reply_modify_bt">수정</button>                                   
			                                	</div>                                                                
	                                        </div>
	                                    </div>
	                                </div>
	                                
	                                
	                            </div>
	                        </div>
	                    </div>
                   </div>
                   <div class="row" id="reply_upload_row">
  						<div class="container" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                            <form role="form" method="post" autocomplete="off" id="reply_form">
	                            	<input type="hidden" id="qna_id" name="qna_id" value="${qna_view.qna_id}"/>
	                            	<input type="hidden" id="reply_id" name="reply_id" value="${rList.reply_id}"/>
	                            	<input type="hidden" id="page" name="page" value="${cri.page}"/>
	                            	<input type="hidden" id="perPageNum" name="perPageNum" value="${cri.perPageNum}"/>
	                            	<input type="hidden" id="searchType" name="searchType" value="${cri.searchType}"/>
	                            	<input type="hidden" id="keyword" name="keyword" value="${cri.keyword}"/>

	                                <header>
	                                    <h2>re:${qna_view.qna_subject}</h2>
	                                    	작성자 : Hwig /	 
	                                      	${qna_view.qna_category}	                                    
	                                </header>

	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                            	<div class="col-sm-8">
			                                            <textarea style="resize:none; height:580px;" id="reply_content" name="reply_content" class="form-control"></textarea>
			                                        </div>
			                                        <div class="col-sm-4 pull-right">
			                                        	 
			                                        	  <textarea id="hdt" style="resize:none; width:300px; height:80px;" class="form-control" readonly="readonly"></textarea> 
			                                        	  <button type="button" class="btn btn-primary" id="hd" style="margin-top:10px; width:300px;">머리말</button><p>
														  
														  <textarea id="bdt" style="resize:none; width:300px; height:80px; margin-top:10px;" class="form-control" readonly="readonly"></textarea>	
														  <c:forEach var="macro_c" items="${macro_c}">
														  	<button type="button" class="btn btn-primary" id="bd" style="width:300px;">${macro_c.macro_link}</button>
														  </c:forEach> 	
														  
														  <button type="button" class="btn btn-primary" id="tem" style="margin-top:10px; width:300px;" 
														  onclick="location.href='temlist?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">양식관리</button><p>
													      
													      <textarea id="tit" style="resize:none; width:300px; height:80px; margin-top:10px;" class="form-control" readonly="readonly"></textarea>  
														  <button type="button" class="btn btn-primary" id="ti" style="margin-top:10px; width:300px;">꼬리말</button><p>
													
														  <button type="button" class="btn btn-info" id="mix" style="width:145px;">템플릿 합치기</button>
														  <button type="button" class="btn btn-danger" id="reset" style="width:145px; margin-left:8px;">초기화</button>
			                                        </div>
	                                            </div>                                                                
	                                        </div>
	                                    </div>
	                                </div>
	                            
	                            
	                                <div class="row">
	                                	<div class="col-md-12">
	                                		<button type="button" id="reply_write_bt" class="btn btn-info pull-right" >등록</button>
	                                		<button type="button" id="reply_mod_bt" class="btn btn-success pull-right">수정</button>                                        	
	     	                                   
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
	<script> //답글 유무에 따라 나오는 메뉴 달라지게 하기
		var r_data = "${rList.reply_content}";
			console.log(r_data);
		if(r_data==""){
			$("#reply_row").hide();
			$("#reply_mod_bt").hide();
			$("#reply_id").remove();
		} else {
			$("#reply_upload_row").hide();
		}
	</script>
	
	<script> //답글 등록 Post
		$("#reply_write_bt").unbind('click').bind('click', function(){
			$("#reply_form").attr("action", "reply_write");
			$("#reply_form").submit();
		});
	</script>
	
	<script> //수정 Post
	$("#reply_mod_bt").unbind('click').bind('click',function(){
		$("#reply_form").attr("action", "reply_modify");
		$("#reply_form").submit(); 
	});
	</script>
	
	<script> //수정폼 나오는 버튼
		$("#reply_modify_bt").unbind('click').bind('click', function(){
			$("#reply_upload_row").show();
			$("#reply_write_bt").hide();
		});
	</script>
	
	<script> //버튼 매크로
	$(function(){
	var txt = "";
	var hdtx = "";
	var bdtx = "";
	var titx = "";
	var data = new Array();
	data[0] = "${macro.macro_head}";
	data[1] = "${macro.macro_tail}";
	
	var data2 = new Array();
	var i = 0;
	<c:forEach var="macro_c" items="${macro_c}">
		data2[i] = "${macro_c.macro_content}";
		$("#bd").attr("id", "bd"+i);
		console.log('#bd'+i);
		i++;
	</c:forEach>
	console.log(data2[0]);
	
		$('#hd').unbind('click').bind('click',function(){
			$('#hdt').val(data[0]+"<br>");
			hdtx = $('#hdt').val();
		})
		
		$('#bd0').unbind('click').bind('click',function(){ 
			$('#bdt').val(data2[0]+"<br>");
			bdtx = $('#bdt').val();
		})
		$('#bd1').unbind('click').bind('click',function(){ 
			$('#bdt').val(data2[1]+"<br>");
			bdtx = $('#bdt').val();
		})
		$('#bd2').unbind('click').bind('click',function(){ 
			$('#bdt').val(data2[2]+"<br>");
			bdtx = $('#bdt').val();
		})

		$('#ti').unbind('click').bind('click',function(){ 
			$('#tit').val(data[1]+"<br>");
			titx = $('#tit').val();

		}) 

		$('#mix').unbind('click').bind('click',function(){ 
			txt = hdtx + bdtx + titx;
			result = txt.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$('#reply_content').val(result);
		})
		
		
		$('#reset').unbind('click').bind('click',function(){ 
			$('#hdt').val("");
			$('#bdt').val("");
			$('#tit').val("");
			$('#reply_content').val("");
			titx = ""; bdtx = ""; hdtx = "";
		})
	})
</script>  
</body>
</html>