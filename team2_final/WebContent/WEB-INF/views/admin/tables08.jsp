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
.popover {
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
						<li><a
							href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
						<li><a>></a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/student/list">수강생관리</a></li>
					</ul>
				</div>

			</div>
			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">
					<h2>수강생 관리</h2>
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12 right">
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#addStudentModal">신규 수강생 등록</button>
								</div>
							</div>

							<!-- <table width="100%" class="table table-striped table-bordered table-hover" id="tableCourse"> -->
							<div class="table-responsive">
							<table class="table table-bordered table-hover" id="tableStudent">
								<thead>
									<tr class="bgColor01">
										<th class="center col-md-1">수강생<br>아이디</th>
										<th class="center col-md-1">이름</th>
										<th class="center col-md-2">전화<br>번호</th>
										<th class="center col-md-2">등록일</th>
										<th class="center col-md-1">수강<br>횟수</th>
										<th class="center col-md-1">과정<br>등록</th>
										<th class="center col-md-1">정보</th>
										<th class="center col-md-1">삭제</th>
										<th class="center col-md-1">사진<br>등록</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="s" items="${list}">
						<tr>
							<td class="center">${s.student_id}</td>
							<td class="center"><a href="#" data-toggle="popover"
													data-placement="left" data-trigger="hover" data-html="true"
													class="pop1"
													data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/Fotolia07.png'style='width:60%;'><div>">${s.student_name}</a></td>
							<td class="center">${s.phone}</td>
							<td class="center">${s.s_reg_date}</td>
							<td class="center"><button class="btn btn-defualt btn-primary btn-xs btnCourseCount" value="${s.student_id}">선택</button></td>
										<td class="center">
											<button
												class="btn btn-defualt btn-primary btn-xs btnCourseAdd" value="${s.student_id}">등록</button>
											<button
												class="btn btn-defualt btn-primary btn-xs btnCourseCansle" value="${s.student_id}">취소</button>
										</td>
										<td class="center">
										<button
													class="btn btn-defualt btn-primary btn-xs btnInfoModify"
													data-toggle="modal" data-target="#studentInfoModify">수정</button>
												<button class="btn btn-defualt btn-primary btn-xs btnPwModify"
												data-toggle="modal" data-target="#studentPwInit">PW초기화</button>
																								</td>
										<td class="center">
											<button class="btn btn-defualt btn-primary btn-xs btnDelete"
												data-toggle="modal" data-target="#StudentDelete" ${s.s_courseCount==0 ? "" : "disabled='disabled'" }>삭제</button>
										</td>
										<td class="center">
											<button
												class="btn btn-defualt btn-primary btn-xs btnPictureForm"
												data-toggle="modal" data-target="#pictureForm">사진등록</button>
										</td>
						</tr>
					</c:forEach>
									<%-- <!-- <tr class="odd gradeX">  -->
									<tr>
										<td class="center">S001</td>
										<td class="center"><a href="#" data-toggle="popover"
											data-placement="left" data-trigger="hover" data-html="true"
											class="pop1"
											data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/person-placeholder.jpg' style='width:60%;'><div>">박형용</a></td>

										<td class="center">010-1234-1234</td>
										<td class="center">2018-05-23</td>
										<td class="center"><button class="btn btn-defualt btn-primary btn-xs btnCourseCount">선택</button></td>
										<td class="center">
											<button
												class="btn btn-defualt btn-primary btn-xs btnCourseAdd">등록</button>
											<button
												class="btn btn-defualt btn-primary btn-xs btnCourseCansle">취소</button>
										</td>
										<td class="center">
										<button
													class="btn btn-defualt btn-primary btn-xs btnInfoModify"
													data-toggle="modal" data-target="#studentInfoModify">수정</button>
												<button class="btn btn-defualt btn-primary btn-xs btnPwModify"
												data-toggle="modal" data-target="#studentPwInit">PW초기화</button>
																								</td>
										<td class="center">
											<button class="btn btn-defualt btn-primary btn-xs btnDelete"
												data-toggle="modal" data-target="#StudentDelete">삭제</button>
										</td>
										<td class="center">
											<button
												class="btn btn-defualt btn-primary btn-xs btnPictureForm"
												data-toggle="modal" data-target="#pictureForm">사진등록</button>
										</td>
									</tr>
									<!-- <tr class="even gradeC">  --> --%>
								</tbody>
							</table>
							<!-- /.table-responsive -->



							<!-- 출력버튼, 검색 폼 -->
							<!-- action="" 속성 생략시 자기자신에게 폼 전송 -->
							<form class="form-inline" method="POST">
								<div class="form-group">

									<!-- 전체 자료 개수 -->
									<button type="button" class="btn btn-sm">
										TotalCount <span class="badge" id="totalCount">${totalCount}</span>
									</button>
									<!-- 한페이지 자료 개수? -->
									<button type="button" class="btn btn-sm">
										Count <span class="badge" id="count">${count}</span>
									</button>
									<!-- 이전 - 현재 - 다음 페이지 -->
									<button type="button" id="btnPrevious"
										class="btn btn-default btn-sm" value="${pageNum-1}">
										<span class="glyphicon glyphicon-step-backward"></span>이전
									</button>
									<button type="button" class="btn btn-default btn-sm pageNum_">
										페이지 <span class="badge" id="pageNum_" >${pageNum}</span>
									</button>
									<button type="button" id="btnNext"
										class="btn btn-default btn-sm" value="${pageNum+1}">
										<span class="glyphicon glyphicon-step-forward"></span>다음
									</button>			<!-- 검색 기준 선택 항목 -->
									<select class="form-control input-sm" id="key" name="key">
										<option value="all">전체</option>
										<option value="student_id">수강생아이디</option>
										<option value="student_name">수강생이름</option>
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
	<div id="addStudentModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">신규 수강생 등록</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/student/insert" method="post">
						<div class="form-group">
							<label for="student_name">이름</label> <input type="text"
								class="form-control" id="student_name" name="student_name"
								placeholder="이름" required>
						</div>
						<div class="form-group">
							<label for="phone">전화번호</label> <input type="text"
								class="form-control" id="phone" name="phone" placeholder="전화번호"
								required>
						</div>
						<div class="form-group">
							<label for="student_pw">패스워드</label> <input type="password"
								class="form-control" id="student_Pw" name="student_Pw"
								placeholder="패스워드" required>
						</div>

						<p>신규 수강생을 등록 하시겠습니까?</p>

						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default">등록</button>
							</div>
						</div>

					</form>

				</div>
			</div>

		</div>
	</div>

	<!-- 패스워드 초기화 모달 -->
	<div id="studentPwInit" class="modal fade" role="dialog">
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
					<form action="${pageContext.request.contextPath}/admin/student/pwModify" method="post">
						<div class="form-group">
							<label>수강생 번호</label> <input type="text" class="form-control"
								id="student_id" name="student_id" readonly="readonly"
								value="">
						</div>

						<div class="form-group">
							<label>이름</label> <input type="text" class="form-control"
								id="student_name" name="student_name" readonly="readonly"
								value="">
						</div>

						<div class="form-group">
							<label>전화번호</label> <input type="text" class="form-control"
								id="phone" name="phone" readonly="readonly" value="">
						</div>

						<div class="form-group">
							<input type="password" class="form-control"
								id="student_newPw" name="student_newPw"
								placeholder="새 비밀번호 입력" required>
						</div>
						
						<div class="form-group">
							<input type="password" class="form-control"
								id="student_newPw" name="student_newPw"
								placeholder="새 비밀번호 확인" required>
						</div>

						<p>패스워드를 변경 하시겠습니까?</p>


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

	<!-- 수강색 삭제 모달  -->
	<div id="StudentDelete" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">수강생 삭제</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
				<form action="${pageContext.request.contextPath}/admin/student/delete" method="post">
						<div class="form-group">
								<label for="student_id">수강생 번호</label> <input type="text"
								class="form-control" id="student_id" name="student_id" 
								readonly="readonly" value="">
						</div>

						<div class="form-group">
						<label for="student_name">이름</label> <input type="text"
								class="form-control" id="student_namxe" name="student_name" 
								readonly="readonly" value="">
							
						</div>

						<div class="form-group">
							<label for="phone">전화번호</label> <input type="text"
								class="form-control" id="phone" name="phone" 
								readonly="readonly" value="">
						</div>

						<p>현재 수강생을 삭제 하시겠습니까?</p>

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

	
	<div id="studentInfoModify" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">수강생 수정</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/student/update" method="post">
						<div class="form-group">
								<label for="student_id">수강생 번호</label> <input type="text"
								class="form-control" id="student_id" name="student_id" 
								readonly="readonly" value="">
						</div>

						<div class="form-group">
						<label for="student_name">이름</label> <input type="text"
								class="form-control" id="student_name" name="student_name" 
								value="">
							
						</div>

						<div class="form-group">
							<label for="phone">전화번호</label> <input type="text"
								class="form-control" id="phone" name="phone" 
								value="">
						</div>

						<p>현재 수강생을 수정 하시겠습니까?</p>

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
					<form action="" method="post" enctype="multipart/form-data"
						class="">
						<div class="form-group">
							<input type="hidden" id="pictureCount" name="pictureCount"
								value="">
						</div>
								<div class="form-group">
									<label>수강생 아이디</label><input type="text" class="form-control"
										id="student_id" name="student_id" readonly="readonly"
										value="student_id">
								</div>
								<div class="form-group">
									<label>수강생 이름</label><input type="text" class="form-control"
										id="student_name" name="student_name" readonly="readonly"
										value="student_name">
								</div>

							<div class="form-group">
								<input type="file" class="form-control" name="filename"
									class="form-control">
							</div>
							<span class="help-block">(.jpg or .png, max 5M)</span>

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

			$(".btnCourseAdd").on("click", function() {
				var student_id = $(this).val();
				window.location.assign("${pageContext.request.contextPath}/admin/student/course?student_id="+student_id);
			});

			$(".btnCourseCansle").on("click", function() {
				var student_id = $(this).val();
				window.location.assign("${pageContext.request.contextPath}/admin/student/cansle?student_id="+student_id);
			});
			$(".btnCourseCount").on("click", function(){
				var student_id = $(this).val();
				window.location.assign("${pageContext.request.contextPath}/admin/course/count?student_id="+student_id);
			});

			$("[data-toggle='popover']").popover();

			$(".btnPwModify").on("click", function() {
				var studentId = $(this).parents("tr").find("td:eq(0)").text();
				var student_name = $(this).parents("tr").find("td:eq(1)").text();
				var phone = $(this).parents("tr").find("td:eq(2)").text();

				$("#studentPwInit #student_id").val(studentId);
				$("#studentPwInit #student_name").val(student_name);
				$("#studentPwInit #phone").val(phone);
			});
			
			$(".btnInfoModify").on("click", function() {

				var studentId = $(this).parents("tr").find("td:eq(0)").text();
				var student_name = $(this).parents("tr").find("td:eq(1)").text();
				var phone = $(this).parents("tr").find("td:eq(2)").text();

				$("#studentInfoModify #student_id").val(studentId);
				$("#studentInfoModify #student_name").val(student_name);
				$("#studentInfoModify #phone").val(phone);
			});

			$(".btnDelete").on("click", function() {
				var studentId = $(this).parents("tr").find("td:eq(0)").text();
				var student_name = $(this).parents("tr").find("td:eq(1)").text();
				var phone = $(this).parents("tr").find("td:eq(2)").text();

				$("#StudentDelete #student_id").val(studentId);
				$("#StudentDelete #student_name").val(student_name);
				$("#StudentDelete #phone").val(phone);
			});
			
			$(".btnPictureForm").on("click", function(){
				var siblings = $(this).parents("td").siblings("td");
				
				var studentId = $(siblings).eq(0).text();
				var student_name = $(siblings).eq(1).text();
				
				$("#pictureForm #studentId").val(studentId);
				$("#pictureForm #student_name").val(student_name);
			
			});
			
			//페이징 액션 추가 ------------------
			//주의) 첫 페이지인 경우 Previous 버튼에 대한 비활성 처리 필요
			if (${pageNum}==${firstPage}) {
				$("#btnPrevious").attr("disabled", "disabled");
			}
			 
			//주의) 마지막 페이지인 경우 Next 버튼에 대한 비활성 처리 필요
			if (${pageNum}==${lastPage}) {
				$("#btnNext").attr("disabled", "disabled");
			} 
			
			
			//Previous 버튼 액션
			$("#btnPrevious").on("click", function() {
				var pageNum = $(this).val();
				window.location.assign("${pageContext.request.contextPath}/admin/student/list?pageNum_="+pageNum);
			});

			//Next 버튼 액션
			$("#btnNext").on("click", function() {
				var pageNum = $(this).val();
				window.location.assign("${pageContext.request.contextPath}/admin/student/list?pageNum_="+pageNum);
			});
		});
	</script>

</body>

</html>
