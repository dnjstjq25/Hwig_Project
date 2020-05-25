<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--main content start-->
<section class="container animated fadeInUp">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="login-wrapper">
                    <header>
                        <div class="brand">
                            <a href="index.html" class="logo">
                                <i class="fa  fa-fw fa-gift"></i>
                                <span>판매자 등록</span></a>
                        </div>
                    </header>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                          <h3 class="panel-title">     
                           
                        </h3>  
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="register" enctype="multipart/form-data" id="registerForm">
                            <div class="form-group">
                            	<div>
                                	<label for="exampleInputEmail1">사업자등록번호</label>
                                </div>
                                <div class="col-md-9" style="padding-left: 0">
                                	<input type="number" class="form-control" id="sel_id" name="sel_id" maxlength="20" placeholder="숫자만 입력하세요">
                                </div>
                                <button type="button" class="btn btn-primary" id="idCheckBtn">중복체크</button>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">비밀번호</label>
                                <input type="password" class="form-control" id="sel_pw" name="sel_pw" maxlength="20" placeholder="기본 설정 비밀번호는 판매자의 사업자등록번호입니다">
                            </div>
                             <div class="form-group">
                                <label for="exampleInputPassword1">상호명</label>
                                <input type="text" class="form-control" id="sel_cname" name="sel_cname" maxlength="200" placeholder="상호명을 입력하세요">
                            </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">대표자명</label>
                                <input type="text" class="form-control" id="sel_name" name="sel_name" maxlength="20" placeholder="대표자명을 입력하세요">
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleInputPassword1">사업장 소재지</label><br>
                                <input type="text" id="sample4_postcode" placeholder="우편번호" class="form-control" readonly="readonly">
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="btn btn-primary" ><br>
								<input type="text" id="sample4_roadAddress" placeholder="도로명주소" class="form-control" readonly="readonly">
								<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" class="form-control">
								<input type="text" id="sample4_detailAddress" placeholder="상세주소" class="form-control" maxlength="400">
								<input type="text" id="sample4_extraAddress" placeholder="참고항목" class="form-control" readonly="readonly">
							</div>
							
                            <div class="form-group">
                                <label for="exampleInputPassword1">전화번호</label>
                                <input type="text" class="form-control" id="sel_tel" name="sel_tel" maxlength="20" placeholder="전화번호를 입력하세요">
                            </div>
                            <div class="form-group">
								<label for="exampleInputFile">사업자등록증 사본</label>
								<img src="${data.sel_img}" id="attach_img" width="300px" height="400px">
								<input type="file" id="sel_img" name="attach_img" accept=".gif, .jpg, .png">
 							</div>
                       
                       		<button type="button" class="btn btn-primary btn-block" id="registerBtn">등록</button>
                       		<input type="hidden" name="origin_img" value="${data.sel_img}">
                       		<input type="hidden" name="sel_addr" value="" id="sel_addr">
                        </form>

                    </div>
                </div>
                </div>
            </div>
        </div>

    </section>
        <!--main content end-->

<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }
            }
        }).open();
    }
    
	$(document).ready(function() {
		$("#attach_img").hide();
		$("#sel_img").change(function() {
			var extend = $("#sel_img").val().substring($("#sel_img").val().lastIndexOf(".")+1);
			
			if(extend != "gif" && extend != "png" && extend != "jpg"){
				 $("#sel_img").val("");
				 $("#attach_img").attr("src", "");
				 $("#attach_img").hide();
				 alert("이미지 파일은 확장자 gif, png, jpg만 가능합니다");
				return false;
			}
			
			if (this.files && this.files[0]) {
				var reader = new FileReader;
				reader.onload = function(data) {
					$("#attach_img").attr("src", data.target.result);
					$("#attach_img").show();
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
		
		$("#registerBtn").click(function(){
			var sel_addr = "(" + $("#sample4_postcode").val() + ") "
										+ $("#sample4_roadAddress").val() + ", "
										+ $("#sample4_detailAddress").val()
										+ $("#sample4_extraAddress").val();
			
			$("#sel_addr").val(sel_addr);
			console.log(sel_addr);
			
			if($.trim($("#sel_id").val()) == ""){
				alert("사업자번호를 입력해주세요");
				return false;
			}
			
			if(isChecked == false){
				alert("사업자등록번호를 중복체크해주세요");
				return false;
			}
			
			if($.trim($("#sel_pw").val()) == ""){
				alert("비밀번호를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_cname").val()) == ""){
				alert("상호명를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_name").val()) == ""){
				alert("대표자명를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_addr").val()) == ""){
				alert("사업장 소재지를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_tel").val()) == ""){
				alert("전화번호를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_img").val()) == ""){
				alert("사업자등록증 사본을 업로드해주세요");
				return false;
			}
			
			$("#registerForm").submit();
		});
		
		var isChecked = false;
		$("#idCheckBtn").click(function(){
			$.ajax({
				url:"/seller/one/" + $("#sel_id").val(),
				dataType:"json",
				contentType:"application/json; charset=utf-8",
				type:"get",
				success:function(result){
					console.log(result);
					if(result.sel_id == ""){
						isChecked = true;
						alert("등록할 수 있는 사업자등록번호입니다");
					} else {
						alert("이미 등록된 사업자등록번호입니다");
					}
				}
			});
		});
		
		$("#sel_id").change(function(){
			isChecked = false;
		})
	});
</script>