<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- jstl-1.2.jar 파일 필요 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>쌍용교육센터 - 성적 관리 시스템</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<style>
/*----------정렬 관련----------*/
.right {
	text-align: right;
}

.left {
	text-align: left;
}

.center {
	text-align: center;
}

/*-------상단 네비게이션 관련-------*/
.navbar-static-top {
	background-color: #212C30;
	color: #ffffff;
}

/*-------사이드 네비게이션 관련-------*/
.logo {
	color: #000000
}

.navbar-header a {
	vertical-align: text-bottom;
}

.navbar-header span {
	vertical-align: middle;
	font-size: 1.1em;
	font-weight: bold;
}

.logo .avatar {
	text-align: center;
}

.logo .avatar img {
	width: 60%;
	border-radius: 100%;
	/* margin: 0 0 2em 0; */
	/*margin: top and bottom right and left */
	margin: 0.2em auto;
	border: solid 1px rgba(255, 255, 255, 0.25);
	background-color: rgba(255, 255, 255, 0.075);
}

.userInfo {
	text-align: center;
}

.logo .userInfo button {
	width: 80%;
	/*margin: top and bottom, right and left */
	margin: 0.5em auto;
}

/*--------컨텐츠 관련-------*/
.content h2 {
	margin-bottom: 0.5em;
}

/* -------테이블 관련------- */
.table {
	width: 100%;
	margin-top: 20px;
}

/*------배경색 관련---------*/
.bgColor01 {
	background-color: #F5F5F5;
}
.bgColor02 {
   background-color: #edf3fc;
}
.bgColorWhite {
	background-color: #FFFFFF;
}

</style>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">
	<div id="wrapper">
		<!-- ######## Navigation 네비게이션 시작 ######## -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">


			<div class="navbar-header">
				<!-- ### 쌍용교육센터 로고 : index.jsp ### -->
				<a href="${pageContext.request.contextPath}/views/admin/index.jsp"> <img
					src="${pageContext.request.contextPath}/resources/img/sist_logo.png"></a>
				<span>성적 관리 시스템 v6.0</span>
			</div>





			<div class="navbar-default sidebar" role="navigation">
				<!-- ########### 사이드 바 시작 ########### -->
				<div class="sidebar-nav navbar-collapse">

					<!-- 현재 로그인한 유저 정보 표시부 -->
					<div class="logo">
						<div class="avatar">
							<img src="${pageContext.request.contextPath}/resources/img/jenny.jpg">
						</div>

						<div class="userInfo">
							<span class="simple-text logo-normal" id="userId">관리자 ${sessionScope.admin.owner_id}</span>

							<button class="btn btn-default btnInfo" id="" value="${sessionScope.admin.owner_id}">개인정보조회</button>
							<button class="btn btn-default btnLogout" id="">로그아웃</button>
						</div>

					</div>
					<ul class="nav" id="side-menu">
						<!-- 기초정보관리 시작 -->
						<li><a href="#"><i class="fa fa-table fa-fw"></i> 기초정보관리<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="${pageContext.request.contextPath}/views/admin/tables.jsp">과정관리</a></li>
								<li><a href="${pageContext.request.contextPath}/views/admin/tables02.jsp">과목관리</a></li>
								<li><a href="${pageContext.request.contextPath}/views/admin/tables03.jsp">강의실관리</a></li>
								<li><a href="${pageContext.request.contextPath}/views/admin/tables04.jsp">교재관리</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<!-- 기초정보관리 끝 -->

						<li><a href="${pageContext.request.contextPath}/views/admin/tables05.jsp"><i class="fa fa-table fa-fw"></i>
								강사계정관리</a></li>
						<li><a href="${pageContext.request.contextPath}/views/admin/tables06.jsp"><i class="fa fa-table fa-fw"></i>
								개설과정관리</a></li>
						<li><a href="${pageContext.request.contextPath}/views/admin/tables07.jsp"><i class="fa fa-table fa-fw"></i>
								개설과목관리</a></li>

						<!-- 수강생관리 시작 -->
						<li><a href="${pageContext.request.contextPath}/views/admin/tables08.jsp"><i class="fa fa-table fa-fw"></i>
								수강생관리</a></li>
						<!-- 수강생관리 끝 -->

						<li><a href="${pageContext.request.contextPath}/views/admin/tables09.jsp"><i class="fa fa-table fa-fw"></i>
								성적조회<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="${pageContext.request.contextPath}/views/admin/tables09-1.jsp">과목별 성적조회</a></li>
								<li><a href="${pageContext.request.contextPath}/views/admin/tables09-2.jsp">수강생 성적조회</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
	</div>

		
		<div id="page-wrapper">
			<div class="row">
				<div class="" id="nav">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}/views/admin/index.jsp">Home</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/views/admin/tables08.jsp">수강생관리</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/views/admin/tables08-2.jsp">등록과정취소</a></li>
					</ul>
				</div>

			</div>
			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">
					<h2>등록 과정 취소</h2>
				<!-- <div class="panel panel-default">
						<div class="panel-body">
							<h2>과정 관리</h2>
						</div>
					</div> -->
					<div class="panel panel-default">
					<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
							<table class="table table-bordered table-hover" id="tableStudent">
								<thead>
									<tr class="bgColor01">
										<th class="center">수강생 아이디</th>
										<th class="center">이름</th>
										<th class="center">전화번호</th>
										<th class="center">등록일</th>
										<th class="center">수강횟수</th>
									</tr>
								</thead>
								<tbody>
									<!-- <tr class="odd gradeX">  -->
									<tr>
										<td class="center">S001</td>
										<td class="center"><a href="#" data-toggle="popover" data-placement="left" data-trigger="hover" data-html="true"
															data-content="<img src='${pageContext.request.contextPath}/resources/img/yong_profile.png'>">박형용</a></td>
										<td class="center">010-1234-1234</td>
										<td class="center">2018-05-23</td>
										<td class="center">1</td>
									</tr>
								 </tbody>
							</table>
							</div>
						</div>
					</div>
							
							
								


					<div class="panel panel-default">
					<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
							
							
							<table class="table table-bordered table-hover" id="possibleCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center">개설과정<br>아이디</th>
										<th class="center">개설<br>과정명</th>
										<th class="center">개설과정<br>시작일</th>
										<th class="center">개설과정<br>종료일</th>
										<th class="center">강의실</th>
										<th class="center">비고</th>
									</tr>
								</thead>
								<tbody>
									<!-- <tr class="odd gradeX">  -->
									<tr>
										<td class="center">OC007</td>
										<td class="center">웹기반 빅데이터 응용SW 관리자</td>
										<td class="center">2019-01-12</td>
										<td class="center">2019-07-23</td>
										<td class="center">201호</td>
										<td class="center">
											<button class="btn btn-defualt btn-primary btn-xs btnCourseCansle" data-toggle="modal" data-target="#courseCansle">선택</button>
									</tr>
								 </tbody>
							</table>
							<!-- <table width="100%" class="table table-striped table-bordered table-hover" id="tableCourse"> -->
									<!-- <tr class="even gradeC">  -->
							<!-- /.table-responsive -->



							<!-- 출력버튼, 검색 폼 -->
							<!-- action="" 속성 생략시 자기자신에게 폼 전송 -->
							<form class="form-inline" method="POST">
								<div class="form-group">
									<!-- 한페이지 자료 개수? -->
									<button type="button" class="btn btn-sm">
										Count <span class="badge" id="count">1</span>
									</button>

								</div>
							</form>
							<!-- 검색 단어 입력 폼 끝-->
							<!-- 검색 단어 입력 폼 끝-->

						</div>

						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Modal 모달 관련 -->
	 <div id="courseCansle" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>

					<h4 class="modal-title">등록 과정 취소</h4>
				</div>
				<div class="modal-body">
	
					<form action="" method="post">
						<div class="form-group">
							<label>개설과정아이디</label>
							<input type="text"
								class="form-control" id="openCourseId" name="openCourseId"
								 readonly="readonly" value="openCourseId">
						</div>

						<div class="form-group">
							<label>개설과정명</label>
							<input type="text"
								class="form-control" id="openCourse_name" name="openCourse_name"
								 readonly="readonly" value="openCourse_name">
						</div>

						<div class="form-group">
							<label>과정시작일</label>
							<input type="text"
								class="form-control" id="course_start_day" name="course_start_day"
								 readonly="readonly" value="course_start_day">
						</div>
						
						<div class="form-group">	 
							<label>과정종료일</label>
							<input type="text"
								class="form-control" id="course_end_day" name="course_end_day"
								 readonly="readonly" value="course_end_day">
						</div>
						
						<div class="form-group">		 
							<label>강의실</label>
							<input type="text"
								class="form-control" id="room_name" name="room_name"
								 readonly="readonly" value="room_name">
						</div>
						
							<p>현재 과정을 취소 하시겠습니까?</p>

						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default">확인</button>
							</div>
						</div>

					</form>

				</div>
			</div>

		</div>
	</div> 

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			//아래 속성 없애면 표 위, 아래에 표시되는 부분 제거 가능
			/* $('#dataTables-example').DataTable({
				responsive : true
			}); */
	         $(".btnLogout").on("click", function() {
	             window.location.assign("${pageContext.request.contextPath}/login/logout");
	          });
	          $(".btnInfo").on("click", function() {
	 				window.location.assign("${pageContext.request.contextPath}/admin/info?owner_id="+$(this).val());
	 			});
			
			$(".btnCourseCansle").on("click", function(){
				var siblings = $(this).parents("td").siblings("td");
				
				var oc_id = $(siblings).eq(0).text();
				var oc_name = $(siblings).eq(1).text();
				var course_start = $(siblings).eq(2).text();
				var course_end = $(siblings).eq(3).text();
				var room = $(siblings).eq(4).text();
				
				$("#courseCansle #openCourseId").val(oc_id);
				$("#courseCansle #openCourse_name").val(oc_name);
				$("#courseCansle #course_start_day").val(course_start);
				$("#courseCansle #course_end_day").val(course_end);
				$("#courseCansle #room_name").val(room);
			
			})
			
			$("[data-toggle='popover']").popover();
			
	
			
		});
	</script>

</body>

</html>
