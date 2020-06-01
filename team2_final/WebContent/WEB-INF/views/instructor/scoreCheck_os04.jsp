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
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/scoreCheck_os02?open_course_id=${choiceInsList.open_course_id}">개설과목 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/scoreCheck_os03?open_sub_id=${choiceInsList02.open_sub_id}">시험 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/scoreCheck_os04">전체 수강생 성적 관리</a></li>
					</ul>
				</div>

			</div>



			<!-- /.row -->
			<div class="row content">
				<div class="col-lg-12">		
					<h2>전체 수강생 성적 관리</h2>
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

									</tr>
								</thead>
								<tbody>
									<!-- <tr class="odd gradeX">  -->
									<tr>
											<td class="center ">${choiceInsList.open_course_id}</td>
											<td class="center ">${choiceInsList.course_name}</td>
											<td class="center ">${choiceInsList.course_start_date}</td>
											<td class="center ">${choiceInsList.course_end_date}</td>
											<td class="center ">${choiceInsList.room_name}</td>
											<td class="center ">${choiceInsList.total_student}</td>

									</tr>
									<!-- <tr class="even gradeC">  -->

								</tbody>
							</table>
							<!-- /.table-responsive -->
						<!-- /.table-responsive -->
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center ">개설과목<br>아이디</th>
										<th class="center ">개설<br>과목명</th>
										<th class="center ">개설과목<br>시작일</th>
										<th class="center ">개설과목<br>종료일</th>
										<th class="center">교재명</th>



									</tr>
								</thead>
								<tbody>
<%-- 									<tr>
										<td class="center ">OS001</td>
										<td class="center ">Java</td>
										<td class="center ">2018-06-25</td>
										<td class="center ">2018-07-25</td>
										<td class="center">
										   <a href="#" data-toggle="popover" data-placement="left" data-trigger="hover" data-html="true" class="pop1" 
										   title="<div style='text-align:center;'><img src='http://shop1.phinf.naver.net/20171129_203/gosigosi2007_1511948441858Wt7YH_JPEG/43659565059784274_1381253878.jpg' style='width:60%;'><div>"
										   data-content='<table>
										         <tr><td style="width:60px;">제목</td><td>알기 쉽게 해설한 JAVA</td></tr>
										         <tr><td>저자</td><td>홍길동</td></tr>
										         <tr><td>가격</td><td>10000</td></tr>
										         <tr><td>출판사</td><td>한빛</td></tr>
										         <tr><td>ISBN</td><td>2012219055</td></tr>
										            </table>'>알기 쉽게 해설한 JAVA</a>
										</td>



									</tr> --%>


									<!-- <tr class="odd gradeX">  -->
									<tr>
											<td class="center ">${choiceInsList02.open_sub_id}</td>
											<td class="center ">${choiceInsList02.subject_name}</td>
											<td class="center ">${choiceInsList02.sub_start_date}</td>
											<td class="center ">${choiceInsList02.sub_end_date}</td>
											<td class="center" style="vertical-align: middle;"><a href="#" rel="${choiceInsList02.isbn}" 
											   data-toggle="popover" data-placement="left" 
											   data-html="true" class="pop1" 
											   data-content=''>${choiceInsList02.book_name}</a>
											</td>


									</tr>
									<!-- <tr class="even gradeC">  -->
								</tbody>
							</table>
							
							
													<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center">시험아이디</th>
										<th class="center">시험날짜</th>
										<th class="center">출결배점</th>
										<th class="center">필기배점</th>
										<th class="center">실기배점</th>
										<th class="center">시험문제</th>

									</tr>
								</thead>
								<tbody>
<!-- 									<tr>
										<td class="center">T001</td>
										<td class="center">2018-10-21</td>
										<td class="center">20</td>
										<td class="center">40</td>
										<td class="center">40</td>
										<td class="center">
											<button type="button" class="btn btn-primary btn-xs">다운로드</button>
										</td>

									</tr> -->
									<tr>
										<td class="center ">${choiceInsList03.test_id}</td>
										<td class="center ">${choiceInsList03.test_date}</td>
										<td class="center ">${choiceInsList03.attendance_points}</td>
										<td class="center ">${choiceInsList03.written_points}</td>
										<td class="center ">${choiceInsList03.practice_points}</td>
										<td class="center">
											<button type="button" class="btn btn-primary btn-xs btnDown"  title="${choiceInsList03.test_q}" ${choiceInsList03.test_q!=null?"":"disabled='disabled'"} value="${choiceInsList03.test_q}">다운로드</button>
										</td>


									</tr>
								</tbody>
							</table>

						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->


					<div class="panel panel-default">
						<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							

							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor02">
										<th class="center ">수강생아이디</th>
										<th class="center ">이름</th>
										<th class="center ">전화번호</th>
										<th class="center">수료상태</th>
										<th class="center">수료상태날짜</th>
										<th class="center">출결점수</th>
										<th class="center">필기점수</th>
										<th class="center">실기점수</th>
										<th class="center">총점</th>
										<th class="center">등록/삭제</th>		
									


									</tr>
								</thead>
<%-- 								<tbody>
									<tr>
										<td class="center ">S001</td>
										<td class="center">
										   <a href="#" data-toggle="popover" data-placement="left" data-trigger="hover" data-html="true" class="pop1" 
										   data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/person-placeholder.jpg' style='width:60%;'><div>">아무개</a>
										</td>
										<td class="center ">010-4066-0000</td>
										<td class="center ">수료예정</td>
										<td class="center ">2018-01-17</td>
										<td class="center ">35</td>
										<td class="center ">20</td>
										<td class="center ">40</td>
										<td class="center ">95</td>
										<td class="center ">
											<button type="button" class="btn btn-primary btn-xs btnScoreAdd" data-toggle="modal" data-target="#addScoreModal" disabled="disabled">점수등록</button>
											<button type="button" class="btn btn-primary btn-xs btnScoreRemove" data-toggle="modal" data-target="#removeScoreModal">점수삭제</button>
										</td>

									</tr>
									
									
									
									<tr>
										<td class="center ">S002</td>
										<td class="center">
										   <a href="#" data-toggle="popover" data-placement="left" data-trigger="hover" data-html="true" class="pop1" 
										   data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/img/person-placeholder.jpg' style='width:60%;'><div>">옥보라</a>
										</td>
										<td class="center ">010-4066-0000</td>
										<td class="center ">수료예정</td>
										<td class="center ">2018-01-17</td>
										<td class="center ">-</td>
										<td class="center ">-</td>
										<td class="center ">-</td>
										<td class="center ">-</td>
										<td class="center ">
											<button type="button" class="btn btn-primary btn-xs btnScoreAdd" data-toggle="modal" data-target="#addScoreModal" >점수등록</button>
											<button type="button" class="btn btn-primary btn-xs btnScoreRemove" data-toggle="modal" data-target="#removeScoreModal" disabled="disabled">점수삭제</button>
										</td>

									</tr>

								</tbody> --%>

								<tbody>
									<c:forEach var="score" items="${list}">
										<tr>
											<td class="center ">${score.student_id}</td>
											<td class="center">
											   <a href="#" data-toggle="popover" data-placement="left" data-trigger="hover" data-html="true" class="pop1" 
											   data-content="<div style='text-align:center;'><img src='${pageContext.request.contextPath}/resources/pictures/student/${score.s_file_name==null?"person-placeholder.jpg":score.s_file_name}' style='width:60%;'><div>">${score.student_name}</a>
											</td>
											<td class="center ">${score.phone}</td>
											<td class="center ">${score.s_status}</td>
											<td class="center ">${score.s_course_end_date}</td>

											<td class="center ">${score.attendance_score}</td>
											<td class="center ">${score.written_score}</td>
											<td class="center ">${score.practice_score}</td>
											<td class="center ">${score.total_score}</td>
											<td class="center ">
											  <button type="button" class="btn btn-primary btn-xs btnScoreAdd" data-toggle="modal" data-target="#addScoreModal" ${score.attendance_score=="--"?"":"disabled='disabled'"}>점수등록</button>
											  <button type="button" class="btn btn-primary btn-xs btnScoreRemove" data-toggle="modal" data-target="#removeScoreModal" ${score.attendance_score!="--"?"":"disabled='disabled'"}>점수삭제</button>
										    </td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

							<!-- 한페이지 자료 개수? -->
							<button type="button" class="btn btn-sm">
								Count <span class="badge" id="count">${count}</span>
							</button>


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



	<!-- 수강생 점수 등록 모달 관련 -->
	<div id="addScoreModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">수강생 점수 등록</h4>
				</div>
				<div class="modal-body">

					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/instructor/addScore" method="post">

						<div class="form-group">

							<label for="student_id">수강생아이디</label><input type="text"
								class="form-control" id="student_id" name="student_id" value=""
								readonly="readonly">
						</div>

						<div class="form-group">
							<label for="student_name">이름</label><input type="text"
								class="form-control" id="student_name" name="student_name"
								value="" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="phone">전화번호</label><input type="text"
								class="form-control" id="phone" name="phone" value=""
								readonly="readonly">
						</div>


						<div class="form-group">
							<label for="attendance_score">출결점수</label> <input type="text"
								class="form-control" id="attendance_score"
								name="attendance_score" placeholder="최대 20자" required >
						</div>

						<div class="form-group">
							<label for="written_score">필기점수</label> <input type="text"
								class="form-control" id="written_score" name="written_score"
								placeholder="최대 20자" required>
						</div>

						<div class="form-group">
							<label for="practice_score">실기점수</label> <input type="text"
								class="form-control" id="practice_score" name="practice_score"
								placeholder="최대 20자" required>
						</div>

						<p>수강생 점수를 등록하시겠습니까?</p>

						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default" id="btnAdd">등록</button>
							</div>
						</div>

					</form>
				</div>

			</div>

		</div>
	</div>
	<!-- 수강생 점수 등록 모달 끝 -->	


   <!-- 시험 삭제 모달 시작 -->
   <div id="removeScoreModal" class="modal fade" role="dialog">
      <div class="modal-dialog">
         <!-- Modal content-->
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">&times;</button>
               <!-- 제목 -->
               <h4 class="modal-title">수강생 점수 삭제</h4>
            </div>
            <div class="modal-body">
               <!-- 내용 -->
               <form action="${pageContext.request.contextPath}/instructor/removeScore" method="post">
						<div class="form-group">

							<label for="student_id">수강생아이디</label><input type="text"
								class="form-control" id="student_id" name="student_id" value=""
								readonly="readonly">
						</div>

						<div class="form-group">
							<label for="student_name">이름</label><input type="text"
								class="form-control" id="student_name" name="student_name"
								value="" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="phone">전화번호</label><input type="text"
								class="form-control" id="phone" name="phone" value=""
								readonly="readonly">
						</div>


    
 						<div class="form-group">
							<label for="attendance_score">출결점수</label> <input type="text"
								class="form-control" id="attendance_score"
								name="attendance_score" placeholder="최대 20자" readonly="readonly" required>
						</div>

						<div class="form-group">
							<label for="written_score">필기점수</label> <input type="text"
								class="form-control" id="written_score" name="written_score"
								placeholder="최대 20자" readonly="readonly" required>
						</div>

						<div class="form-group">
							<label for="practice_score">실기점수</label> <input type="text"
								class="form-control" id="practice_score" name="practice_score"
								placeholder="최대 20자" readonly="readonly" required>
						</div>
                  
                  <p>현재 선택한 수강생의 점수를 삭제하시겠습니까?</p>   
                  
	               <div class="row">
	                  <div class="col-md-6 left">
	                     <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	                  </div>
	                  <div class="col-md-6 right">
	                     <button type="submit" class="btn btn-default" id="btnRemove">삭제</button>
	                  </div>
	               </div>
               </form>
               
          
               
            </div>
         </div>
      </div>
   </div>
   <!-- 시험 삭제 모달 끝 -->
   
<!-- 성적등록 후 결과 Modal 모달 시작      -->
<div id="addResultModal" class="modal" role="dialog">
   <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
         <div class="modal-body">
            <!-- 내용 -->
            <h4 id="addResultMessage">resultMessage</h4>
            <div class="row">
               <div class="col-md-12 right">
                  <button id="addBtnDismiss" type="button" class="btn btn-default">확인</button>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
<!-- 성적등록 Modal 모달 관련 끝 -->

<!-- 성적삭제 후 결과 Modal 모달 시작      -->
<div id="removeResultModal" class="modal" role="dialog">
   <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
         <div class="modal-body">
            <!-- 내용 -->
            <h4 id="removeResultMessage">resultMessage</h4>
            <div class="row">
               <div class="col-md-12 right">
                  <button id="removeBtnDismiss" type="button" class="btn btn-default">확인</button>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
<!-- 성적삭제 Modal 모달 관련 끝 -->
   

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
			
			/* 교재 Ajax 관련 */
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
			
			
	         $("#btnInfo").on("click", function() {
	             window.location.assign("${pageContext.request.contextPath}/instructor/instructor_info");
	          });
	          
	          $("#btnLogout").on("click", function() {
	        	  window.location.assign("${pageContext.request.contextPath}/login/logout");
	          });
		        $(".btnDown").on("click", function() {
		      		window.location.assign("${pageContext.request.contextPath}/resources/test/"+$(this).val());
		        });
	          

	
	 
     
				//점수 등록 모달
	 			$(".btnScoreAdd").on("click", function(){
					
	 	        	var student_id = $(this).parents("tr").find("td:eq(0)").text();
	 	        	$("#addScoreModal #student_id").val(student_id);
	 	        	
	 	        	var student_name = $(this).parents("tr").find("td:eq(1)").find("a").text();
	 	        	$("#addScoreModal #student_name").val(student_name);
	 	        	
	 	        	var phone = $(this).parents("tr").find("td:eq(2)").text();
	 	        	$("#addScoreModal #phone").val(phone);
				}); 
				
				
				//점수 삭제 모달
	 			$(".btnScoreRemove").on("click", function(){
					
	 	        	var student_id = $(this).parents("tr").find("td:eq(0)").text();
	 	        	$("#removeScoreModal #student_id").val(student_id);
	 	        	
	 	        	var student_name = $(this).parents("tr").find("td:eq(1)").find("a").text();
	 	        	$("#removeScoreModal #student_name").val(student_name);
	 	        	
	 	        	var phone = $(this).parents("tr").find("td:eq(2)").text();
	 	        	$("#removeScoreModal #phone").val(phone);
	 	        	
	 	        	var attendance_score = $(this).parents("tr").find("td:eq(5)").text();
	 	        	$("#removeScoreModal #attendance_score").val(attendance_score);
	 	        	
	 	        	var written_score = $(this).parents("tr").find("td:eq(6)").text();
	 	        	$("#removeScoreModal #written_score").val(written_score);
	 	        	
	 	        	var practice_score = $(this).parents("tr").find("td:eq(7)").text();
	 	        	$("#removeScoreModal #practice_score").val(practice_score);
				}); 
	          
				
	 			/* 성적등록 결과 모달 관련 */
	 			$("#addBtnDismiss").on("click", function() {
	 			   $("#addResultModal").hide();
	 			});

	 			if ('${addResult}'=='success') {
	 			   $("#addResultMessage").text("성적 등록 성공!");
	 			   $("#addResultModal").show();
	 			}
	 			if ('${addResult}'=='fail') {
	 			   $("#addResultMessage").text("성적 등록 실패");
	 			   $("#addResultModal").show();
	 			}
	 			
	 			
	 			/* 성적삭제 결과 모달 관련 */
	 			$("#removeBtnDismiss").on("click", function() {
	 			   $("#removeResultModal").hide();
	 			});

	 			if ('${removeResult}'=='success') {
	 			   $("#removeResultMessage").text("성적 삭제 성공!");
	 			   $("#removeResultModal").show();
	 			}
	 			if ('${removeResult}'=='fail') {
	 			   $("#removeResultMessage").text("성적 삭제 실패");
	 			   $("#removeResultModal").show();
	 			}
		});

	</script>

</body>

</html>
