<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
	<%-- jstl-1.2.jar 파일 필요 --%>
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
						<li class="active"><a
							href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
						<li><a>></a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/openSubject/list">개설
								과정 선택</a></li>
						<li><a>></a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/openSubject/list2">개설
								과목 선택</a></li>
					</ul>
				</div>

			</div>

			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">
					<h2>개설과목선택</h2>
					<!-- <div class="panel panel-default">
						<div class="panel-body">
							<h2>과정 관리</h2>
						</div>
					</div> -->
					<div class="panel panel-default">
						<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center col-md-1">개설과정<br>아이디</th>
										<th class="center col-md-3">개설<br>과정명</th>
										<th class="center col-md-2">개설과정<br>시작일</th>
										<th class="center col-md-2">개설과정<br>종료일</th>
										<th class="center col-md-1">강의실</th>
										<th class="center col-md-1">수강<br>인원</th>
									</tr>
								</thead>
								<tbody>
									<!-- <tr class="odd gradeX">  -->
									<!-- <tr>
										<td class="center">OC001</td>
										<td class="center">C/C++ 와 JAVA 프로그래밍 응용과정</td>
										<td class="center">2018-06-25</td>
										<td class="center">2019-01-17</td>
										<td class="center">201호</td>
										<td class="center">20명</td>

									</tr> -->
								<c:forEach var="oc" items="${courseList}">
								<tr>
									<td class="center">${oc.open_course_id}</td>
									<td class="center">${oc.course_name}</td>
									<td class="center">${oc.course_start_date}</td>
									<td class="center">${oc.course_end_date}</td>
									<td class="center">${oc.room_name}</td>
									<td class="center">${oc.total_student}</td>
								</tr>
								</c:forEach>	 
								</tbody>
							</table>

						</div>
					</div>

					<div class="row">
						<div class="col-md-12 right">
							<div class="panel panel-default">
								<div class="panel-body">

									<button class="btn btn-primary" data-toggle="modal"
										data-target="#addCourseModal">개설 과목 등록</button>

									<!-- <table width="100%" class="table table-striped table-bordered table-hover" id="tableCourse"> -->
									<table class="table table-bordered table-hover"
										id="tableOpenCourse">
										<thead>
											<tr class="bgColor02">
												<th class="center col-md-2">개설과목<br>아이디</th>
												<th class="center col-md-1">개설<br>과목명</th>
												<th class="center col-md-2">개설과목<br>시작일</th>
												<th class="center col-md-2">개설과목<br>종료일</th>
												<th class="center col-md-2">교재명</th>
												<th class="center col-md-1">강사명</th>
												<th class="center col-md-1">수정</th>
												<th class="center col-md-1">삭제</th>
											</tr>
										</thead>
										<tbody>
											<!-- <tr class="odd gradeX">  -->
										<c:forEach var="os" items="${subList}">
											<tr>
												<td class="center">${os.open_sub_id}</td>
												<td class="center">${os.subject_name}</td>
												<td class="center">${os.sub_start_date}</td>
												<td class="center">${os.sub_end_date}</td>
												<td class="center" style="vertical-align: middle;"><a
												href="#" rel="${os.isbn}" data-toggle="popover"
												data-placement="left" data-html="true" class="pop1"
												data-content=''>${os.book_name}</a></td>
												<td class="center"><a href="#" data-toggle="popover"
													data-placement="left" data-trigger="hover" data-html="true"
													class="pop1"
													data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/Fotolia07.png'style='width:60%;'><div>">${os.pro_name}</a></td>


												<td class="center">
													<button
														class="btn btn-defualt btn-primary btn-xs btnModify" 
														data-toggle="modal" data-target="#modifyOpenSubModal">수정</button>
												</td>
												<td class="center">
													<button
														class="btn btn-defualt btn-primary btn-xs btnDelete"
														data-toggle="modal" data-target="#deleteOpenSubModal">삭제</button>
												</td>
											</tr>
										</c:forEach>

										</tbody>
									</table>
									<!-- /.table-responsive -->

									<!-- 출력버튼, 검색 폼 -->
									<!-- action="" 속성 생략시 자기자신에게 폼 전송 -->
									<div class="form-group row">
										<form class="form-inline" method="POST">

											<div class="col-md-12 left">
												<!-- 한페이지 자료 개수? -->
												<button type="button" class="btn btn-sm">
													Count <span class="badge" id="count">${count}</span>
												</button>
											</div>

										</form>
										</div>
										</div>
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
	<div id="addCourseModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">개설 과목 등록</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/openSubject/insert" method="post">
						<div class="form-group">
				
							<input type="hidden" name="open_course_id" value="${param.open_course_id}">
					
							<label for="course_name">과목</label> <select class="form-control"
								id="subject_id" name="subject_id">
								<c:forEach var="s" items="${subject}">
									<option value="${s.subject_id}">${s.subject_id} | ${s.subject_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="course_name">과목시작일</label> <input type="Date"
								class="form-control" id="sub_start_date" name="sub_start_date"
								placeholder="YYYY-MM-DD" required>
						</div>
						<div class="form-group">
							<label for="course_name">과목종료일</label> <input type="Date"
								class="form-control" id="sub_end_date" name="sub_end_date"
								placeholder="YYYY-MM-DD" required>
						</div>
						<div class="form-group">
							<label for="course_name">교재정보</label> <select
								class="form-control" id="book_id" name="book_id">
								<c:forEach var="b" items="${book}">
									<option value="${b.book_id}">${b.book_id} | ${b.book_name} | ${b.isbn}</option>
								</c:forEach>
									<option value="">없음</option>
							</select>
						</div>
						<div class="form-group">
							<label for="course_name">강사</label> <select class="form-control"
								id="pro_id" name="pro_id">
								<c:forEach var="i" items="${instructor}">
									<option value="${i.pro_id}">${i.pro_id} | ${i.pro_name} | ${i.pro_phone}</option>
								</c:forEach>
							</select>
						</div>
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default" id="btnAddCourse">등록</button>
							</div>
						</div>
							</form>
				</div>
			

			</div>

		</div>
	</div>

	<div id="modifyOpenSubModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">개설과목 수정</h4>
				</div>

				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/openSubject/update" method="post">
						<div class="form-group">
							
							<input type="hidden" name="open_course_id" value="${param.open_course_id}">
							
							<label for="open_sub_id">개설과목 아이디</label> <input type="text"
								class="form-control" id="open_sub_id" name="open_sub_id"
								placeholder="open_sub_id" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="subject_name">개설과목명</label> <input type="text"
								class="form-control" id="subject_name" name="subject_name"
								placeholder="subject_name" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="sub_start_date">개설과목 시작일</label> <input
								type="date" class="form-control" id="sub_start_date"
								name="sub_start_date" value="">
						</div>
						<div class="form-group">
							<label for="sub_end_date">개설과목 종료일</label> <input type="date"
								class="form-control" id="sub_end_date" name="sub_end_date"
								value="">
						</div>

						<div>

							<p>현재 선택한 개설과목을 수정하시겠습니까?</p>

						</div>
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
								>취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default"
								>수정</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- 삭제 모달  -->
	<div id="deleteOpenSubModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">개설과목 삭제</h4>
				</div>

				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/openSubject/delete" method="post">
						<div class="form-group">
						
						<input type="hidden" name="open_course_id" value="${param.open_course_id}">
						
							<label for="open_sub_id">개설과목 아이디</label> <input type="text"
								class="form-control" id="open_sub_id" name="open_sub_id"
								placeholder="open_sub_id" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="subject_name">개설과목명</label> <input type="text"
								class="form-control" id="subject_name" name="subject_name"
								placeholder="subject_name" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="sub_start_date">개설과목 시작일</label> <input
								type="text" class="form-control" id="sub_start_date"
								name="sub_start_date" placeholder="sub_start_date"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="sub_end_date">개설과목 종료일</label> <input type="text"
								class="form-control" id="sub_end_date" name="sub_end_date"
								placeholder="sub_end_date" readonly="readonly">
						</div>

						<div>

							<p>현재 선택한 개설과목을 삭제하시겠습니까?</p>

						</div>
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
								>취소</button>
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
	
	<!-- 입력 결과 메시지 출력할 Modal -->
	<div id="resultModal" class="modal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<!-- 내용 -->
					<h4 id="resultMessage">resultMessage</h4>
					<div class="row">
						<div class="col-md-12 right">
							<button id="btnDismiss" type="button" class="btn btn-default">확인</button>
						</div>
					</div>
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
		$(document).ready(
				function() {
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

					$("[data-toggle='popover']").popover();

					$("a[rel]").on("mouseover", function(){
				          var b_isbn = $(this).attr("rel");
				          var s="a[rel="+b_isbn+"]";
				   
				              $.ajax({
				             url: "${pageContext.request.contextPath}/ajax/bookinfo"
				             ,data: {isbn:b_isbn}
				             ,async: false
				             ,success: function(data_) {
				                
				                console.log(data_);
				                
				                var array = data_.item;
				                for (var i = 0; i < array.length; ++i) {
				                       var item = array[i];
				                       var isbn = item.isbn;
				                       var title = item.title;
				                       var publisher = item.publisher;
				                       var author = item.author;
				                       var priceStandard = item.priceStandard;
				                       var coverLargeUrl = item.coverLargeUrl;
				                   }
				                var dataContent =  "<div style='text-align:center;'><img src='"+coverLargeUrl+"' style='width:60%;'><div>"
				                   +"<table><tr><td style='width:60px;'>제목</td><td>" + item.title + "</td></tr>"
				               + "<tr><td>저자</td><td>" + author + "</td></tr>"
				               + "<tr><td>가격</td><td>"+ priceStandard +"</td></tr>"
				               + "<tr><td>출판사</td><td>"+ publisher +"</td></tr>"
				               + "<tr><td>ISBN</td><td>" + isbn +"</td></tr></table>";
				                $(s).attr("data-content", dataContent);
				          }});
				         });
					
					$(".btnDelete").on("click", function(){
						var open_sub_id = $(this).parent("td").siblings("td").eq(0).text();
						var subject_name = $(this).parent("td").siblings("td").eq(1).text();
						var sub_start_date = $(this).parent("td").siblings("td").eq(2).text();
						var sub_end_date = $(this).parent("td").siblings("td").eq(3).text();
						
						$("#deleteOpenSubModal #open_sub_id").val(open_sub_id);
						$("#deleteOpenSubModal #subject_name").val(subject_name);
						$("#deleteOpenSubModal #sub_start_date").val(sub_start_date);
						$("#deleteOpenSubModal #sub_end_date").val(sub_end_date);
					});
					
					$(".btnModify").on("click", function(){
						var open_sub_id = $(this).parent("td").siblings("td").eq(0).text();
						var subject_name = $(this).parent("td").siblings("td").eq(1).text();

						$("#modifyOpenSubModal #open_sub_id").val(open_sub_id);
						$("#modifyOpenSubModal #subject_name").val(subject_name);

					});
					
					
					/* $("#btnDismiss").on("click", function() {
						   $("#resultModal").hide();
						});

						if ('${result}'=='success') {
						   $("#resultMessage").text("개설과목 등록에 성공했습니다.");
						   $("#resultModal").show();
						}
						if ('${result}'=='fail') {
						   $("#resultMessage").text("개설과목 등록에 실패했습니다.");
						   $("#resultModal").show();
						} */
					
					
				});
	</script>

</body>

</html>
