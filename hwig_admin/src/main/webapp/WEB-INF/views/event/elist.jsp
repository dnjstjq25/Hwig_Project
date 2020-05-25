<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>이벤트</title>
<script>
	var result = "${msg}";
	if(result == "success"){
		alert("완료되었습니다.");
	}
</script>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
		<section class="main-content-wrapper">
            <div class="pageheader">
                <h1>이벤트 관리</h1>
                <div class="breadcrumb-wrapper hidden-xs">
                    <span class="label">You are here:</span>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Dashboard</a>
                        </li>
                        <li>Tables</li>
                        <li class="active">Data Tables</li> 
                    </ol>
                </div>
            </div>
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1>이벤트 관리 <a href="/event/event_write" class="btn btn-info">추가</a></h1> 
                                
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>글 번호</th>
                                            <th>제목</th>
                                            <th>본문</th>                  
                                        </tr>
                                    </thead>

                                    <tbody>
	                                    <c:forEach var="eList" items="${eList}">
											<tr>
												<td>${eList.event_id}</td>
												<td><a href="event_view?event_id=${eList.event_id}">${eList.event_subject}</a></td>
												<td>${eList.event_content}</td>									
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
	<%@ include file="../include/footnav.jsp" %>
	<script src="../resources/assets/plugins/dataTables/js/jquery.dataTables.js"></script>
    <script src="../resources/assets/plugins/dataTables/js/dataTables.bootstrap.js"></script>
    <script>
    $(document).ready(function() {
        $('#example').dataTable();
    });
    </script>
</body>
</html>