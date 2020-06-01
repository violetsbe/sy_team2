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
						<li><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
						<li><a>></a></li>
						<li><a href="#">성적조회</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/score/subject">과목별 성적조회</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/score/subject">개설과정 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/score/subject2">개설과목 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/score/subject3">시험 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/score/subject4">수강생 성적 조회</a></li>
					</ul>
				</div>

			</div>
			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">
					<h2>수강생 성적 조회</h2>
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
							<!-- <table width="100%" class="table table-striped table-bordered table-hover" id="tableCourse"> -->
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center">개설과정<br>아이디</th>
										<th class="center">개설<br>과정명</th>
										<th class="center">개설과정<br>시작일</th>
										<th class="center">개설과정<br>종료일</th>
										<th class="center">강의실</th>
										<th class="center">수강인원</th>
									</tr>
								</thead>
								<tbody>
										<tr class="open_course_id">
											<td class="center">${oc.open_course_id}</td>
											<td class="center">${oc.course_name}</td>
											<td class="center">${oc.course_start_date}</td>
											<td class="center">${oc.course_end_date}</td>
											<td class="center">${oc.room_name}</td>
											<td class="center">${oc.total_student}명</td>
										</tr>
									</tbody>
							</table>


							<table class="table table-bordered table-hover" id="tableTest">
								<thead>
									<tr class="bgColor01">
									<th class="center" >개설과목<br>아이디</th>
										<th class="center" >개설<br>과목명</th>
										<th class="center" >개설과목<br>시작일</th>
										<th class="center" >개설과목<br>종료일</th>
										<th class="center" >교재명</th>
										<th class="center" >강사명</th>
									</tr>
								</thead>
							<tbody>
									<!-- <tr class="odd gradeX">  -->
									<tr class="open_sub_id">
										<td class="center">${os.open_sub_id}</td>
												<td class="center">${os.subject_name}</td>
												<td class="center">${os.sub_start_date}</td>
												<td class="center">${os.sub_end_date}</td>
												<td class="center" style="vertical-align: middle;"><a
												href="#" rel="${os.isbn}" data-toggle="popover"
												data-placement="left" data-html="true" class="pop1"
												data-content=''>${os.book_name}</a></td>
													<td class="center">
                                    <a href="#" data-toggle="popover" data-placement="left" data-trigger="hover" data-html="true" class="pop1" 
                                    data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/pictures/instructor/${os.i_file_name==null?"person-placeholder.jpg":os.i_file_name}' style='width:60%;'><div>">${os.pro_name}</a>
                                 </td>


									</tr>
									<!-- <tr class="even gradeC">  -->
								</tbody>
							</table>
							
							
							<table class="table table-bordered table-hover" id="tableTest">
								<thead>
									<tr class="bgColor01">
										<th class="center">시험<br>아이디</th>
										<th class="center">시험날짜</th>
										<th class="center">출결배점</th>
										<th class="center">필기배점</th>
										<th class="center">실기배점</th>
										<th class="center">시험문제</th>
									</tr>
								</thead>

									<tbody>
										<tr>
											<td class="center">${t.test_id}</td>
											<td class="center">${t.test_date}</td>
											<td class="center">${t.attendance_points}</td>
											<td class="center">${t.written_points}</td>
											<td class="center">${t.practice_points}</td>
											<td class="center">
												<button class="btn btn-default btn-primary btn-xs"
													title="${t.test_q}">다운로드</button>
											</td>
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
							
							<table class="table table-bordered table-hover" id="tableGrade">
								<thead>
									<tr class="bgColor02">
										<th class="center">수강생<br>아이디</th>
										<th class="center">수강생명</th>
										<th class="center">전화번호</th>
										<th class="center">수료상태</th>
										<th class="center">수료상태날짜</th>
										<th class="center">출결점수</th>
										<th class="center">필기점수</th>
										<th class="center">실기점수</th>
										<th class="center">총점</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="st" items="${list}">
											<tr>
												<td
													class="center">${st.student_id}</td>
												<td class="center">
										<a href="#" data-toggle="popover"
											data-placement="left" data-trigger="hover" data-html="true"
											class="pop1"
											data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/person-placeholder.jpg' style='width:60%;'><div>">${st.student_name}</a>
										</td>
												<td class="center">${st.phone}</td>
												<td class="center">${st.s_status}</td>
												<td class="center">${st.s_course_end_date}</td>
												<td class="center">${st.attendance_score}</td>
												<td class="center">${st.written_score}</td>
												<td class="center">${st.practice_score}</td>
												<td class="center">${st.total_score}</td>
											</tr>
										</c:forEach>
								</tbody>
							</table>
							

							<!-- 출력버튼, 검색 폼 -->
							<!-- action="" 속성 생략시 자기자신에게 폼 전송 -->
							<form action="${pageContext.request.contextPath}/admin/score/subject4" class="form-inline" method="POST">
								<div class="form-group">
									<input type="hidden" id="open_course_id" name="open_course_id" value="${param.open_course_id}"></input>
									<input type="hidden" id="open_sub_id" name="open_sub_id" value="${param.open_sub_id}"></input>
									<input type="hidden" id="test_id" name="test_id" value="${param.test_id}"></input>
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
									<button type="button" class="btn btn-default btn-sm">
										페이지 <span class="badge" id="pageNum_">${pageNum}</span>
									</button>
									<button type="button" id="btnNext"
										class="btn btn-default btn-sm" value="${pageNum+1}">
										<span class="glyphicon glyphicon-step-forward"></span>다음
									</button>
									<!-- 검색 기준 선택 항목 -->
									<select class="form-control input-sm" id="key" name="key">
										<option value="all">전체</option>
										<option value="student_id">수강생아이디</option>
										<option value="student_name">수강생명</option>
									</select>
									<!-- 검색 단어 입력 폼 -->
									<div class="input-group">
										<!-- 전체 출력(all)일 때는 입력하지 않아도 되므로 input에 required 속성 추가하지 않음. -->
										<input type="text" class="form-control input-sm" id="value"
											name="value" placeholder="Search">
										<div class="input-group-btn">
											<!-- 검색 진행 버튼 -->
											<button type="submit" class="btn btn-default btn-sm" id="btnSearch">
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
			
	         $(".btnLogout").on("click", function() {
	             window.location.assign("${pageContext.request.contextPath}/login/logout");
	          });
	          $(".btnInfo").on("click", function() {
	 				window.location.assign("${pageContext.request.contextPath}/admin/info?owner_id="+$(this).val());
	 			});
			
			$(".btnTest").on("click", function() {
				window.location.assign("${pageContext.request.contextPath}/views/admin/tables09-1-socre.jsp");
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


			if (${pageNum}==${firstPage}) {
				$("#btnPrevious").attr("disabled", "disabled");
			};
			 
			if (${pageNum}==${lastPage}) {
				$("#btnNext").attr("disabled", "disabled");
			};

			$("#btnPrevious").on("click", function() {
				var pageNum = $(this).val();
				var open_course_id = $("#open_course_id").val();
				var open_sub_id = $("#open_sub_id").val();
				var test_id = $("#test_id").val();
				window.location.assign("${pageContext.request.contextPath}/admin/score/subject4?pageNum_="+pageNum
						+"&open_course_id="+open_course_id+"&open_sub_id="+open_sub_id+"&test_id="+test_id);
			});

			$("#btnNext").on("click", function() {
				var pageNum = $(this).val();
				var open_course_id = $("#open_course_id").val();
				var open_sub_id = $("#open_sub_id").val();
				var test_id = $("#test_id").val();
				window.location.assign("${pageContext.request.contextPath}/admin/score/subject4?pageNum_="+pageNum
						+"&open_course_id="+open_course_id+"&open_sub_id="+open_sub_id+"&test_id="+test_id);
			});
		});
	</script>

</body>

</html>
