<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Hwig</title>
    <meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<style>
		#select_label{
			margin-left:20px;
		}
		#admin{
			margin-left:50px;
		}
		#seller{
			margin-left:30px;
		}
	</style>
	<!-- Favicon -->
    <link rel="shortcut icon" href="../resources/assets/img/favicon.ico" type="image/x-icon">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../resources/assets/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Fonts  -->
    <link rel="stylesheet" href="../resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="../resources/assets/css/simple-line-icons.css">
    <!-- Switchery -->
    <link rel="stylesheet" href="../resources/assets/plugins/switchery/switchery.min.css">
    <!-- CSS Animate -->
    <link rel="stylesheet" href="../resources/assets/css/animate.css">
    <!-- DataTables-->
    <link rel="stylesheet" href="../resources/assets/plugins/dataTables/css/dataTables.css">
    <!-- Daterange Picker -->
    <link rel="stylesheet" href="../resources/assets/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- Calendar demo -->
    <link rel="stylesheet" href="../resources/assets/css/clndr.css">
    <!-- Switchery -->
    <link rel="stylesheet" href="../resources/assets/plugins/switchery/switchery.min.css">
    <!-- Custom styles for this theme -->
    <link rel="stylesheet" href="../resources/assets/css/main.css">
    <!-- Feature detection -->
    <script src="../resources/assets/js/vendor/modernizr-2.6.2.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/vendor/html5shiv.js"></script>
    <script src="assets/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!--main content start-->
        <section class="container animated fadeInUp">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="login-wrapper">
                    <header>
                        <div class="brand">
                            <div class="logo">
                                <i class="icon-layers"></i>
                                <span>HWIG 로그인</span>
                            </div>
                        </div>
                    </header>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">로그인</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="login" method="post" id="loginForm">
                            <div class="form-group">
                                <div class="control-label" style="padding-left:0px; text-align: left">
                                    <label class="control-label" id="select_label">로그인 계정 선택</label>
                                    <input type="radio" name="loginType" id="admin" value="admin" >
                                    <label style="text-align: left;">관리자</label>
                                    <input type="radio" name="loginType" id="seller" value="seller">
                                    <label style="text-align: left;">판매자</label>
                                    <input type="hidden" value="" id="user_type" name="user_type" />
                                </div>
                            </div>
                            	<hr />
                                <div class="form-group">
                                    <div class="col-md-12">
                                    	<label id="admin_id"></label>
                                    	<label id="sel_id"></label>
                                        <input type="text" class="form-control" id="user_id" name="user_id" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                    	<label for="exampleInputPassword1">비밀번호</label>
                                        <input type="password" class="form-control" id="user_pw" name="user_pw" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <button type="button" class="btn btn-primary btn-block" id="loginBtn">로그인</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </section>
        <!--main content end-->

<!--Global JS-->
<script src="../resources/assets/js/vendor/jquery-1.11.1.min.js"></script>
<script src="../resources/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../resources/assets/plugins/navgoco/jquery.navgoco.min.js"></script>
<script src="../resources/assets/plugins/icheck/js/icheck.min.js"></script>
<script src="../resources/assets/plugins/switchery/switchery.min.js"></script>
<script src="../resources/assets/plugins/pace/pace.min.js"></script>
<script src="../resources/assets/plugins/fullscreen/jquery.fullscreen-min.js"></script>
<script src="../resources/assets/js/src/app.js"></script>
<!--Page Level JS-->
<script src="../resources/assets/plugins/countTo/jquery.countTo.js"></script>
<script src="../resources/assets/plugins/weather/js/skycons.js"></script>
<script src="../resources/assets/plugins/daterangepicker/moment.min.js"></script>
<script src="../resources/assets/plugins/daterangepicker/daterangepicker.js"></script>
<!-- ChartJS  -->
<script src="../resources/assets/plugins/chartjs/Chart.min.js"></script>
<!-- Morris  -->
<script src="../resources/assets/plugins/morris/js/morris.min.js"></script>
<script src="../resources/assets/plugins/morris/js/raphael.2.1.0.min.js"></script>
<!-- Vector Map  -->
<script src="../resources/assets/plugins/jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../resources/assets/plugins/jvectormap/js/jquery-jvectormap-world-mill-en.js"></script>
<!-- Calendar  -->
<script src="../resources/assets/plugins/calendar/clndr.js"></script>
<script src="../resources/assets/plugins/calendar/clndr-demo.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
<!-- Switch -->
<script src="../resources/assets/plugins/switchery/switchery.min.js"></script>
<!--Load these page level functions-->
</body>

</html>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
		$("input:radio[name='loginType']").on("click", function(){
			if($("input:radio[name='loginType']:checked").val() == "admin"){
				$("#sel_id").empty();
				$("#admin_id").text("관리자아이디");
				$("#user_type").val("admin");
				console.log($("#user_type").val());
			} else {
				$("#admin_id").empty();
				$("#sel_id").text("사업자등록번호");
				$("#user_type").val("seller");
				console.log($("#user_type").val());
			}
		});
		
		$("#loginBtn").click(function(){
			console.log($("#loginForm"));
			$("#loginForm").submit();
		});
	
		$("#admin").attr('checked', true);
		$("#sel_id").empty();
		$("#admin_id").text("관리자아이디");
		$("#user_type").val("admin");
		
		var result = '${msg}';
		
		if(result == 'fail') {
			alert("로그인이 실패되었습니다");
		}
		
		var loginResult = '${loginMsg}';
		
		if(loginResult == 'fail') {
			alert("로그인 후 사용하세요");
			self.location = "/"
		}
	});
</script>