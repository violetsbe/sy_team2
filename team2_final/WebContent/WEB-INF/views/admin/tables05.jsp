<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- jstl-1.2.jar 파일 필요 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
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
/*---------popover------------*/
.popover{
    width: 200px;
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
				<a href="${pageContext.request.contextPath}/admin/dashboard"> <img
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
								<li><a href="${pageContext.request.contextPath}/admin/course/list">과정관리</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/subject/list">과목관리</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/classroom/list">강의실관리</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/book/list">교재관리</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<!-- 기초정보관리 끝 -->

						<li><a href="${pageContext.request.contextPath}/admin/instructor_/list"><i class="fa fa-table fa-fw"></i>
								강사계정관리</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/openCourse/list"><i class="fa fa-table fa-fw"></i>
								개설과정관리</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/openSubject/list"><i class="fa fa-table fa-fw"></i>
								개설과목관리</a></li>

						<!-- 수강생관리 시작 -->
						<li><a href="${pageContext.request.contextPath}/admin/student/list"><i class="fa fa-table fa-fw"></i>
								수강생관리</a></li>
						<!-- 수강생관리 끝 -->

						<li><a href="${pageContext.request.contextPath}/admin/score/subject"><i class="fa fa-table fa-fw"></i>
								성적조회<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="${pageContext.request.contextPath}/admin/score/subject">과목별 성적조회</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/score/student">수강생 성적조회</a></li>
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
						<li class="active"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li><li><a>></a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/instructor/list">강사계정관리</a></li>
					</ul>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">
					<h2>강사계정관리</h2>
					<div class="panel panel-default">
						<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">

								<div class="col-md-12 right">
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#addInstructorModal">신규 강사 등록</button>
								</div>
							</div>

							<!-- <table width="100%" class="table table-striped table-bordered table-hover" id="tableCourse"> -->
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center col-md-1">강사<br>아이디</th>
										<th class="center col-md-1">강사명</th>
										<th class="center col-md-4">강의가능과목</th>
										<th class="center col-md-2">전화번호</th>
										<th class="center col-md-1">삭제</th>
										<th class="center col-md-1">정보</th>
										<th class="center col-md-1">사진등록</th>
									</tr>
								</thead>
								<tbody>
										<c:forEach var="i" items="${list}">
											<tr>
											<td class="center">${i.pro_id}</td>
										<td class="center"><a href="#" data-toggle="popover"
											data-placement="left" data-trigger="hover" data-html="true"
											class="pop1"
											data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/person-placeholder.jpg' style='width:60%;'><div>">${i.pro_name}</a>
										</td>
										<td class="center">${i.possible_sub}</td>
										<td class="center">${i.pro_phone}</td>
										<td class="center">
											<button class="btn btn-defualt btn-primary btn-xs btnDelete" ${i.count_ == 0 ? "" : "disabled=\"disabled\""}
												data-toggle="modal" data-target="#Instructor_Delete">삭제</button>
																								</td>
										<td class="center">
											<button class="btn btn-defualt btn-primary btn-xs btnModify"
												data-toggle="modal" data-target="#Instructor_infoModify">수정</button>
											<button class="btn btn-defualt btn-primary btn-xs btnPwInit"
												data-toggle="modal" data-target="#Instructor_PwInit">PW초기화</button>
																								</td>
										<td class="center">
								
											<button class="btn btn-defualt btn-primary btn-xs btnPictureForm" data-toggle="modal" data-target="#pictureForm">사진등록</button>
											
												
										</td>
											</tr>
										</c:forEach>
									</tbody>
								
							</table>
							<!-- /.table-responsive -->



							<!-- 출력버튼, 검색 폼 -->
							<!-- action="" 속성 생략시 자기자신에게 폼 전송 -->
							<form class="form-inline" method="POST">
								<div class="form-group">

									<!-- 전체 자료 개수 -->
									<button type="button" class="btn btn-sm">
										TotalCount <span class="badge" id="totalCount">1</span>
									</button>
									<!-- 한페이지 자료 개수? -->
									<button type="button" class="btn btn-sm">
										Count <span class="badge" id="count">${count}</span>
									</button>
									<!-- 이전 - 현재 - 다음 페이지 -->
									<button type="button" id="btnPre"
										class="btn btn-default btn-sm" value="">
										<span class="glyphicon glyphicon-step-backward"></span>이전
									</button>
									<button type="button" class="btn btn-default btn-sm">
										페이지 <span class="badge" id="pageNum">1</span>
									</button>
									<button type="button" id="btnNext"
										class="btn btn-default btn-sm" value="">
										<span class="glyphicon glyphicon-step-forward"></span>다음
									</button>
									<!-- 검색 기준 선택 항목 -->
									<select class="form-control input-sm" id="key" name="key">
										<option value="all">전체</option>
										<option value="openCourseId">강사아이디</option>
										<option value="openCourseName">강사명</option>
									</select>
									<!-- 검색 단어 입력 폼 -->
									<div class="input-group">
										<!-- 전체 출력(all)일 때는 입력하지 않아도 되므로 input에 required 속성 추가하지 않음. -->
										<input type="text" class="form-control input-sm" id="value"
											name="value" placeholder="Search">
										<div class="input-group-btn">
											<!-- 검색 진행 버튼 -->
											<button type="submit" class="btn btn-default btn-sm"
												id="btnSearch">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</div>
									</div>
								</div>
							</form>

							<!-- 검색 단어 입력 폼 끝-->




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
	<div id="addInstructorModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">신규 강사 등록</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/instructor_/insert" method="post">
						<div class="form-group">
							<label for="pro_name">강사명</label> <input type="text"
								value="" class="form-control" id="pro_name"
								name="pro_name" placeholder="최대 20자" required>
						</div>
						<div class="form-group">
							<label for="pro_phone">전화번호</label> <input type="text"
								class="form-control" id="pro_phone"
								name="pro_phone" placeholder="최대 20자" required>
						</div>

						<div class="form-group">
							<label for="p_reg_date">등록일</label> <input type="Date"
								value="" class="form-control" id="p_reg_date"
								name="p_reg_date"  required>
						</div>

						<label for="possible_sub">강의가능과목</label>

						<div class="checkbox">
							<c:forEach var="sub" items="${SubList}">
							<label class="checkbox-inline"> 
							<input type="checkbox"
								name="sub" value="${sub.subject_id}">${sub.subject_name}
							</label> 
						
							</c:forEach>

						</div>

						<div class="row">

							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default"
									>등록</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div id="Instructor_PwInit" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">패스워드 변경</h4>
				</div>
				<div class="modal-body">

					<!-- 내용 -->
					<form action="" method="post">
						<div class="form-group">
							<label for="instructor_id">강사 아이디</label> <input type="text"
								class="form-control" id="instructor_id" name="instructor_id"
								placeholder="instructor_id" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="instructor_name">강사명</label> <input type="text"
								class="form-control" id="instructor_name" name="instructor_name"
								placeholder="instructor_name" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="possible_sub">강의가능과목</label> <input type="text"
								class="form-control" id="possible_sub" name="possible_sub"
								placeholder="possible_sub" readonly="readonly">
						</div>


						<div class="form-group">
							<input type="text" class="form-control" id="password"
								name="password" placeholder="새 비밀번호 입력">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" id="password"
								name="password" placeholder="새 비밀번호 확인">

						</div>

						<div>

							<br>현재 선택한 강사의 비밀번호를 변경하시겠습니까?

						</div>
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="button" class="btn btn-default"
									id="Instructor_PwInit">확인</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div id="Instructor_infoModify" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">정보 수정</h4>
				</div>
				<div class="modal-body">

					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/instructor_/update" method="post">
						<div class="form-group">
							<label for="pro_id">강사 아이디</label> <input type="text"
								class="form-control" id="pro_id" name="pro_id"
								readonly="readonly" value="">
						</div>
						<div class="form-group">
							<label for="pro_name">강사명</label> <input type="text"
								class="form-control" id="pro_name" name="pro_name"
								value="">
						</div>
						<div class="form-group">
							<label for="pro_phone">전화번호</label> <input type="text"
								class="form-control" id="pro_phone"
								name="pro_phone"
								value="">
						</div>
						
						<div class="form-group">
							<label for="possible_sub">강의가능과목</label> 
							<div class="checkbox">
							<c:forEach var="sub" items="${SubList}">
							<label class="checkbox-inline"> 
							<input type="checkbox"
								name="sub" value="${sub.subject_id}">${sub.subject_name}
							</label> 
							</c:forEach>

						</div>
						</div>
						
						<div>

							<br>현재 선택한 강사를 수정하시겠습니까?

						</div>

						<div class="row">

							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default"
									>등록</button>
							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
	</div>



	<div id="Instructor_Delete" class="modal fade" role="dialog">
		
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">강사 정보 삭제</h4>
				</div>

				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/instructor_/delete" method="post">
						<div class="form-group">
							<label for="pro_id">강사 아이디</label> <input type="text"
								class="form-control" id="pro_id" name="pro_id"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="pro_name">강사명</label> <input type="text"
								class="form-control" id="pro_name" name="pro_name"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="possible_sub">강의가능과목</label> <input type="text"
								class="form-control" id="possible_sub" name="possible_sub"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="pro_phone">전화번호</label> <input type="text"
								class="form-control" id="pro_phone"
								readonly="readonly">
						</div>
						<div>

							<br>현재 선택한 강사를 삭제하시겠습니까?

						</div>
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default"
									>삭제</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<!-- 사진 업로드 전용 모달 -->
	<div id="pictureForm" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">사진 등록</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="" 
							method="post" enctype="multipart/form-data" class="">
						<div class="form-group">
							<input type="hidden"
								id="pictureCount" name="pictureCount" value="">
						</div>
						
						<div class="form-group">
							<label>강사아이디</label><input type="text"
								class="form-control" id="instructor_id" name="instructor_id" value ="instructor_id"
								 readonly="readonly" >
						</div>

						<div class="form-group">
						<label>강사명</label>	<input type="text"
								class="form-control" id="instructor_name" name="instructor_name" value ="instructor_name"
								 readonly="readonly">
						</div>
							 
						<div class="form-group">
								<input type="file" class="form-control" name="filename" class="form-control">
						</div> <span class="help-block">(.jpg
							or .png, max 5M)</span>

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
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document)
				.ready(
						function() {
							//아래 속성 없애면 표 위, 아래에 표시되는 부분 제거 가능
							/* $('#dataTables-example').DataTable({
							   responsive : true
							}); */
							$('[data-toggle="popover"]').popover();
						
					         $(".btnLogout").on("click", function() {
					             window.location.assign("${pageContext.request.contextPath}/login/logout");
					          });
					          $(".btnInfo").on("click", function() {
					 				window.location.assign("${pageContext.request.contextPath}/admin/info?owner_id="+$(this).val());
					 			});

							$(".btnDelete")
									.on(
											"click",
											function() {
												var instructor_id = $(this)
														.parents("tr").find(
																"td:eq(0)")
														.text();
												var instructor_name = $(this)
														.parents("tr").find(
																"td:eq(1)")
														.text();
												var possible_sub = $(this)
														.parents("tr").find(
																"td:eq(2)")
														.text();
												var instructor_phone = $(this)
														.parents("tr").find(
																"td:eq(3)")
														.text();

												$(
														"#Instructor_Delete #pro_id")
														.val(instructor_id);
												$(
														"#Instructor_Delete #pro_name")
														.val(instructor_name);
												$(
														"#Instructor_Delete #possible_sub")
														.val(possible_sub);
												$(
														"#Instructor_Delete #pro_phone")
														.val(instructor_phone);

											});

							$(".btnModify")
									.on(
											"click",
											function() {
												var instructor_id = $(this)
												.parents("tr").find(
														"td:eq(0)")
												.text();
										var instructor_name = $(this)
												.parents("tr").find(
														"td:eq(1)")
												.text();
										var possible_sub = $(this)
												.parents("tr").find(
														"td:eq(2)")
												.text();
										var instructor_phone = $(this)
												.parents("tr").find(
														"td:eq(3)")
												.text();

										$(
												"#Instructor_infoModify #pro_id")
												.val(instructor_id);
										$(
												"#Instructor_infoModify #pro_name")
												.val(instructor_name);
										$(
												"#Instructor_infoModify #possible_sub")
												.val(possible_sub);
										$(
												"#Instructor_infoModify #pro_phone")
												.val(instructor_phone);
											

											});

							$(".btnPwInit")
									.on(
											"click",
											function() {
												var instructor_id = $(this)
														.parents("tr").find(
																"td:eq(0)")
														.text();
												var instructor_name = $(this)
														.parents("tr").find(
																"td:eq(1)")
														.text();
												var possible_sub = $(this)
														.parents("tr").find(
																"td:eq(2)")
														.text();

												$(
														"#Instructor_PwInit #instructor_id")
														.val(instructor_id);
												$(
														"#Instructor_PwInit #instructor_name")
														.val(instructor_name);
												$(
														"#Instructor_PwInit #possible_sub")
														.val(possible_sub);

												txt += "</div><div class='form-group'>";
												txt += " 변경할 패스워드  <input type='text' class='form-control' id='Instructor_PwInit' name='Instructor_PwInit'required></div><div>패스워드를 변경 하시겠습니까?</div>";
												$("#demo").html(txt);
											});

							
							
					         $(".btnPictureForm").on("click", function(){
					             var siblings = $(this).parents("td").siblings("td");
					             
					             var instructor_id = $(siblings).eq(0).text();
					             var instructor_name = $(siblings).eq(1).text();
					             
					             $("#pictureForm #instructor_id").val(instructor_id);
					             $("#pictureForm #instructor_name").val(instructor_name);
					          
					          });
							
						});
	</script>

</body>

</html>