<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!-- JSTL 사용하기 위한 준비 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	background-color: #476e91;
	color: #ffffff;
}

/*-------사이드 네비게이션 관련-------*/
.navbar-header a {
	vertical-align: text-bottom;
}

.navbar-header span {
	vertical-align: middle;
	font-size: 1.1em;
	font-weight: bold;
}

.logo {
	color: #000000;
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

.bgColorWhite {
	background-color: #FFFFFF;
}
</style>


</head>

<body>

	<div id="wrapper">

		<!-- ######## Navigation 네비게이션 시작 ######## -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">

				<!-- ### 쌍용교육센터 로고 : index.jsp ### -->
				<a href="${pageContext.request.contextPath}/instructor/index"><img
					src="${pageContext.request.contextPath}/resources/img/sist_logo.png"></a><span> 성적 관리 시스템 v6.0</span>
				<!-- 성적 관리 시스템 v6.0 -->
			</div>
			
			<!-- /.navbar-header -->
			<div class="navbar-default sidebar" role="navigation">
				<!-- ########### 사이드 바 시작 ########### -->
				<div class="sidebar-nav navbar-collapse">

					<!-- 현재 로그인한 유저 정보 표시부 -->
					<div class="logo">
						<div class="avatar">
							<img src="${pageContext.request.contextPath}/resources/img/person-placeholder.jpg">
						</div>

						<div class="userInfo">
	                     <span class="simple-text logo-normal" id="userId">${instructor.pro_name} 강사님</span>
	                       <button class="btn btn-default" id="btnInfo">개인정보조회</button>
	                     <button class="btn btn-default" id="btnLogout">로그아웃</button>
	                 	</div>
					</div>
					
					<!-- 좌측 메뉴 시작 -->
					<ul class="nav" id="side-menu">
						<!-- 강의 스케쥴 조회 시작 -->
						<li><a href="#"><i class="fa fa-table fa-fw"></i> 강의 스케쥴
								조회<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a
									href="${pageContext.request.contextPath}/instructor/schedule_planned01">강의일정별 조회</a></li>
								<li><a
									href="${pageContext.request.contextPath}/instructor/os_student01">개설과정별 전체 수강생 조회</a></li>
							</ul> <!-- /.nav-second-level --></li>

						<li><a
							href="${pageContext.request.contextPath}/instructor/test_management01">
								<i class="fa fa-table fa-fw"></i> 시험 및 배점관리
						</a></li>

						<li><a
							href="#"><i
								class="fa fa-table fa-fw"></i> 성적관리 <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a
									href="${pageContext.request.contextPath}/instructor/scoreCheck_os01">과목기준</a></li>
								<li><a
									href="${pageContext.request.contextPath}/instructor/scoreCheck_student01">수강생기준</a></li>
							</ul> <!-- /.nav-second-level --></li>
					</ul>
					<!-- 좌측 메뉴 끝 -->
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		
		<!-- ######## Navigation 네비게이션 끝 ######## -->
		
		
		
		
		
		
		
		
		

		<div id="page-wrapper">
			<div class="row">
				<div class="" id="nav">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/instructor/index">Home</a></li>
						<li><a>></a></li>
						<li><a href="#">성적관리</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/scoreCheck_os01">과목기준</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/scoreCheck_os01">개설과정선택</a></li>


					</ul>
				</div>

			</div>



			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">		
					<h2>개설과정선택</h2>
					<div class="panel panel-default">
						<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">


							<!-- <table width="100%" class="table table-striped table-bordered table-hover" id="tableCourse"> -->
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center ">개설과정<br>아이디</th>
										<th class="center ">개설<br>과정명</th>
										<th class="center ">개설과정<br>시작일</th>
										<th class="center ">개설과정<br>종료일</th>
										<th class="center">강의실</th>
										<th class="center ">수강<br>인원</th>
										<th class="center ">보기</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="oc" items="${list}">
										<tr>
											<td class="center ">${oc.open_course_id}</td>
											<td class="center ">${oc.course_name}</td>
											<td class="center ">${oc.course_start_date}</td>
											<td class="center ">${oc.course_end_date}</td>
											<td class="center ">${oc.room_name}</td>
											<td class="center ">${oc.total_student}</td>
											<td class="center ">
												<button type="button" class="btn btn-primary btn-xs btnView" value="${oc.open_course_id}">선택</button>
											</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<!-- /.table-responsive -->



							<!-- 출력버튼, 검색 폼 -->
							<!-- action="" 속성 생략시 자기자신에게 폼 전송 -->
							<form class="form-inline" method="POST" action="${pageContext.request.contextPath}/instructor/scoreCheck_os01">
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
										<option value="open_course_id">개설과정아이디</option>
										<option value="course_name">개설과정명</option>
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

			$("[data-toggle='popover']").popover();
			
	         $("#btnInfo").on("click", function() {
	             window.location.assign("${pageContext.request.contextPath}/instructor/instructor_info");
	          });
	          
	          $("#btnLogout").on("click", function() {
	             window.location.assign("${pageContext.request.contextPath}/login/logout");
	          });
	          
	          $(".btnView").on("click", function() {
	        	  
	        	  var open_course_id = $(this).val();
	        	  
	              window.location.assign("${pageContext.request.contextPath}/instructor/scoreCheck_os02?open_course_id="+open_course_id);
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
					window.location.assign("${pageContext.request.contextPath}/instructor/scoreCheck_os01?pageNum_="+pageNum);
				});

				//Next 버튼 액션
				$("#btnNext").on("click", function() {
					var pageNum = $(this).val();
					window.location.assign("${pageContext.request.contextPath}/instructor/scoreCheck_os01?pageNum_="+pageNum);
				});
		});
	</script>

</body>

</html>
