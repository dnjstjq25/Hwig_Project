<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Hwig</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/vendor/html5shiv.js"></script>
    <script src="assets/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <section id="main-wrapper" class="theme-default">
        <header id="header">
            <!--logo start-->
            <div class="brand">
                <a href="/main" class="logo">
                    <i class="icon-layers"></i>
                    Hwig</a>
            </div>
            <!--logo end-->
            <ul class="nav navbar-nav navbar-left">
                <li class="toggle-navigation toggle-left">
                    <button class="sidebar-toggle" id="toggle-left">
                        <i class="fa fa-bars"></i>
                    </button>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown profile hidden-xs">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="meta">
                            <span class="avatar">
                                <img src="../resources/assets/img/KakaoTalk_20200312_101505181.png" class="img-circle" alt="">
                            </span>
                        <span class="text">${sessionScope.user_name}</span>
                        <span class="caret"></span>
                        </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight" role="menu">
                        <c:if test="${sessionScope.user_type eq 'seller'}">
                        <li>
                            <a href="#" id="sellerAccountBtn1">
                                <span class="icon"><i class="fa fa-user"></i>
                                </span>판매자 정보</a>
                        </li>
                        </c:if>
                        <li>
                            <a href="#" id="logoutBtn">
                                <span class="icon"><i class="fa fa-sign-out"></i>
                                </span>로그아웃</a>
                        </li>
                    </ul>
                </li>
                 <li class="toggle-fullscreen hidden-xs">
                    <button type="button" class="btn btn-default expand" id="toggle-fullscreen">
                        <i class="fa fa-expand"></i>
                    </button>
                </li>
                <li class="toggle-navigation toggle-right">
                    <button class="sidebar-toggle" id="toggle-right">
                        <i class="fa fa-indent"></i>
                    </button>
                </li>
            </ul>
        </header>
        <!--sidebar left start-->
        <aside class="sidebar sidebar-left">
            <div class="sidebar-profile">
                <div class="avatar">
                    <img class="img-circle profile-image" src="../resources/assets/img/KakaoTalk_20200312_101505181.png" alt="profile">
                    <i class="on border-dark animated bounceIn"></i>
                </div>
                <div class="profile-body dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><h4>${sessionScope.user_name}<span class="caret"></span></h4></a>
                    <ul class="dropdown-menu animated fadeInRight" role="menu">
                        <c:if test="${sessionScope.user_type eq 'seller'}">
                        <li>
                            <a href="#" id="sellerAccountBtn2">
                                <span class="icon"><i class="fa fa-user"></i>
                                </span>판매자 정보</a>
                        </li>
                        </c:if>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-sign-out"></i>
                                </span>Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
            <nav>
                <h5 class="sidebar-header">Navigation</h5>
                <ul class="nav nav-pills nav-stacked">
                    <li class="nav-dropdown">
                        <a href="#" title="Tables">
                            <i class="fa  fa-fw fa-gift"></i> 상품관리
                        </a>
                        <ul class="nav-sub">
                        <c:if test="${sessionScope.user_type eq 'seller'}">
                            <li>
                                <a href="/product/prd_add" title="Data Tables">상품 등록</a>
                            </li>
                            <li>
                                <a href="/product/prd_waitlist_seller?sel_id=${sessionScope.user.sel_id}" title="Data Tables">승인 예정</a>
                            </li>
                            <li>
                                <a href="/product/prd_list_seller?sel_id=${sessionScope.user.sel_id}" title="Data Tables">승인 완료</a>
                            </li>
						</c:if>
						<c:if test="${sessionScope.user_type eq 'admin'}">
                            <li>
                                <a href="/product/prd_waitlist" title="Data Tables">승인 예정</a>
                            </li>
                            <li>
                                <a href="/product/prd_list" title="Data Tables">승인 완료</a>
                            </li>
						</c:if>
                        </ul>
                    </li>
                    <c:if test="${sessionScope.user_type eq 'admin'}">
	                    <li class="nav-dropdown">
	                        <a href="#" title="Tables">
	                            <i class="fa  fa-fw fa-shopping-cart"></i> 주문관리
	                        </a>
	                        <ul class="nav-sub">
	                            <li>
	                                <a href="/order/list" title="Data Tables">주문 내역</a>
	                            </li>
	                        </ul>
	                    </li>
                    </c:if>
                    <c:if test="${sessionScope.user_type eq 'seller'}">
	                    <li class="nav-dropdown">
	                        <a href="#" title="Tables">
	                            <i class="fa  fa-fw fa-shopping-cart"></i> 재고관리
	                        </a>
	                        <ul class="nav-sub">
	                            <li>
	                                <a href="/seller/prdList" title="Data Tables">재고 내역</a>
	                            </li>
	                        </ul>
	                    </li>
                    </c:if>
                    <c:if test="${sessionScope.user_type eq 'admin'}">
                    <li class="nav-dropdown">
                        <a href="#" title="Tables">
                            <i class="fa  fa-fw fa-user"></i> 고객관리
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="/member/list" title="Data Tables">회원 관리</a>
                            </li>
                            <li>
                                <a href="/seller/list" title="Data Tables">판매자 관리</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-dropdown">
                        <a href="#" title="Tables">
                            <i class="fa  fa-fw fa-list"></i> 게시판관리
                        </a>
                        <ul class="nav-sub">
                            <li>
                                <a href="/notice/nlist" title="Data Tables">공지사항</a>
                            </li>
                            <li>
                                <a href="/event/elist" title="Data Tables">이벤트</a>
                            </li>
                            <li>
                                <a href="/faq/flist" title="Data Tables">자주묻는질문</a>
                            </li>
                            <li>
                                <a href="/qna/qlist" title="Data Tables">Q&A</a>
                            </li>
                            <li>
                                <a href="/review/reviewList" title="Data Tables">고객후기</a>
                            </li>
                        </ul>
                    </li>
                    </c:if>
                </ul>
            </nav>
        </aside>
        <!--sidebar left end-->
        <!--main content start-->

        <!--main content end-->