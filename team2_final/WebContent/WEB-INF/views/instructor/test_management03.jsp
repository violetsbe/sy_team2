<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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
							href="${pageContext.request.contextPath}/instructor/scoreAddAndRemove01"><i
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

			<!-- 콘텐츠 상단 네비게이션 바 시작 -->
			<div class="row">
				<div class="" id="nav">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/views/instructor/index">Home</a></li>
						<li><a>></a></li>
						<li><a href="#">시험 및 배점관리</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/test_management01">개설 과정 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/test_management02?open_course_id=${oc.open_course_id}">개설 과목 선택</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/instructor/test_management03?open_course_id=${oc.open_course_id}&open_sub_id=${os.open_sub_id}">특정 개설과목의 시험 및 배점 관리</a></li>
					</ul>
				</div>
			</div>
			<!-- 콘텐츠 상단 네비게이션 바 끝 -->

			<div class="row content">
				<div class="col-lg-12">
					<h2>특정 개설과목의 시험 및 배점 관리</h2>

					<div class="panel panel-default">
						<!-- <div class="panel-heading">과정 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
						
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center">개설과정<br>아이디</th>
										<th class="center">개설<br>과정명</th>
										<th class="center">개설과정<br>시작일</th>
										<th class="center">개설과정<br>종료일</th>
										<th class="center">강의실</th>
										<th class="center">수강<br>인원</th>
									</tr>
								</thead>
								<tbody>
									<!-- <tr class="odd gradeX">  -->
									<tr>
										<td class="center">${oc.open_course_id}</td>
										<td class="center">${oc.course_name }</td>
										<td class="center">${oc.course_start_date}</td>
										<td class="center">${oc.course_end_date}</td>
										<td class="center">${oc.room_name}</td>
										<td class="center">${oc.total_student}</td>
									</tr>
								</tbody>
							</table>
							<!-- /.table-responsive -->

							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor01">
										<th class="center">개설과목<br>아이디</th>
										<th class="center">개설<br>과목명</th>
										<th class="center">개설과목<br>시작일</th>
										<th class="center">개설과목<br>종료일</th>
										<th class="center">교재명</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="center">${os.open_sub_id}</td>
										<td class="center">${os.subject_name}</td>
										<td class="center">${os.sub_start_date}</td>
										<td class="center">${os.sub_end_date}</td>
										<td class="center" style="vertical-align: middle;"><a
											href="#" rel="${os.isbn}" data-toggle="popover"
											data-placement="left" data-html="true" class="pop1"
											data-content=''>${os.book_name}</a></td>
									</tr>
								</tbody>
							</table>


						</div>
						<!-- /.panel-body -->
					</div>


					<div class="panel panel-default">
						<div class="panel-body">

							<div class="right">
								<button class="btn btn-primary" data-toggle="modal"
									data-target="#addTestModal">시험 및 배점 등록</button>
							</div>
							<!-- /.table-responsive -->
							<table class="table table-bordered table-hover"
								id="tableOpenCourse">
								<thead>
									<tr class="bgColor02">
										<th class="center">시험아이디</th>
										<th class="center">시험날짜</th>
										<th class="center">출결배점</th>
										<th class="center">필기배점</th>
										<th class="center">실기배점</th>
										<th class="center">시험 및 배점수정</th>
										<th class="center">시험관리</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="t" items="${list}">
										<tr>
											<td class="center">${t.test_id}</td>
											<td class="center">${t.test_date}</td>
											<td class="center">${t.attendance_points}</td>
											<td class="center">${t.practice_points}</td>
											<td class="center">${t.written_points}</td>
											<td class="center">
												<button type="button" class="btn btn-primary btn-xs btnModify" value="${t.test_id}" data-toggle="modal" data-target="#scoreModifyModal">수정</button>
											</td>
											<td class="center">
											
												<button type="button" class="btn btn-primary btn-xs btnDown"  title="${t.test_q}" ${t.test_q!=null?"":"disabled='disabled'"} value="${t.test_q}">다운로드</button>
											
												<button type="button" class="btn btn-primary btn-xs btnDelete" value="${t.test_id}" data-toggle="modal" data-target="#testDeleteModal" ${t.count_ == 0 ? "" : "disabled=\"disabled\"" }>삭제</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							<!-- 자료 개수 출력 버튼 시작 -->
							<!-- 전체 자료 개수 -->
							<button type="button" class="btn btn-sm">
								Count <span class="badge" id="count">${count}</span>
							</button>
							<!-- 자료 개수 출력 버튼 끝-->


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
	<!-- 시험 등록 모달 시작 -->
	<div id="addTestModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">시험 및 배점 등록</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/instructor/testInsert" method="POST" enctype="multipart/form-data">
					
						<input type="hidden" id="open_sub_id" name="open_sub_id" value="${os.open_sub_id}">
						
						
						<div class="form-group">
							<label for="test_file">시험문제첨부</label>
							<input type="file" 
								class="form-control" id="test_q_file" name="test_q_file"
								placeholder="최대 20자" required>
							<span class="help-block">확장자 .zip만 허용</span>
						</div>
						<div class="form-group">
							<label for="test_date">시험 날짜</label> <input type="date"
								class="form-control" id="test_date" name="test_date"
								value="" required>
						</div>
						<div class="form-group">
							<label for="attendance_points">출결 배점</label> <input type="number"
								class="form-control" id="attendance_points" name="attendance_points"
								value="" required>
						</div>
						<div class="form-group">
							<label for="written_points">필기 배점</label> <input type="number"
								class="form-control" id="written_points" name="written_points"
								value="" required>
						</div>
						<div class="form-group">
							<label for="practice_points">실기 배점</label> <input type="number"
								class="form-control" id="practice_points" name="practice_points"
								value="" required>
						</div>
						
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default" id="btnAddTest">등록</button>
							</div>
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>
	<!-- 시험 등록 모달 끝 -->
		<!-- 수정 후 결과 Modal 모달 시작      ###20190103 추가 - BR### -->
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

	<!-- 배점 수정 모달 시작 -->
	<div id="scoreModifyModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">시험 및 배점 수정</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/instructor/testUpdate" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label for="test_id">시험아이디</label> <input type="text"
								class="form-control" id="test_id" name="test_id"
								placeholder="test_id" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="test_file">시험문제첨부</label>
							<input type="file" 
								class="form-control" id="test_q_file" name="test_q_file"
								placeholder="최대 20자" required>
						</div>
						<div class="form-group">
							<label for="test_date">시험 날짜</label> <input type="date"
								class="form-control" id="test_date" name="test_date"
								placeholder="">
						</div>
						<div class="form-group">	
							<label for="attendance_points">출결 배점</label> <input type="number"
								class="form-control" id="attendance_points" name="attendance_points"
								placeholder="" required>
						</div>
						<div class="form-group">
							<label for="written_points">필기 배점</label> <input type="number"
								class="form-control" id="written_points" name="written_points"
								placeholder="" required>
						</div>
						<div class="form-group">
							<label for="practice_points">실기 배점</label> <input type="number"
								class="form-control" id="practice_points" name="practice_points"
								placeholder="" required>
						</div>
							
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default" id="btnModifyTest">등록</button>
							</div>
						</div>	
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 배점 수정 모달 끝 -->
	
	
	<!-- 시험 삭제 모달 시작 -->
	<div id="testDeleteModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">시험 삭제</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/instructor/testDelete" method="post">
						<div class="form-group">
							<label for="test_id">시험아이디</label> <input type="text"
								class="form-control" id="test_id" name="test_id"
								value="" readonly="readonly">	
						</div>		
						<div class="form-group">					
							<label for="test_date">시험 날짜</label> <input type="date"
								class="form-control" id="test_date" name="test_date"
								value="" readonly="readonly">
						</div>		
						<div class="form-group">
							<label for="attendance_points">출결 배점</label> <input type="text"
								class="form-control" id="attendance_points" name="attendance_points"
								value="" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="written_points">필기 배점</label> <input type="text"
								class="form-control" id="written_points" name="written_points"
								value="" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="practice_points">실기 배점</label> <input type="text"
								class="form-control" id="practice_points" name="practice_points"
								value="" readonly="readonly">
						</div>
						
						<p>현재 선택한 시험을 삭제하시겠습니까?</p>	
						
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default" id="btnDelete">삭제</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 시험 삭제 모달 끝 -->



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
			//교재 popover
			$("[data-toggle='popover']").popover();
			
			/* 버튼 이벤트 등록 */
			$("#btnInfo").on("click", function() {
			    window.location.assign("${pageContext.request.contextPath}/instructor/instructor_info");
			 });
			 
	        $("#btnLogout").on("click", function() {
	       		window.location.assign("${pageContext.request.contextPath}/login/logout");
	        });
	        
			
	        $(".btnDown").on("click", function() {
	      		window.location.assign("${pageContext.request.contextPath}/resources/test/"+$(this).val());
	        });
	          
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
			

   			//배점 수정 버튼 클릭 시, 해당 라인의 텍스트 데이터를 모달창의 input란에 세팅
			$(".btnModify").on("click", function() {
				var test_id = $(this).parents("tr").find("td:eq(0)").text();
				var test_date = $(this).parents("tr").find("td:eq(1)").text();
				var attendance_points = $(this).parents("tr").find("td:eq(2)").text();
				var written_points = $(this).parents("tr").find("td:eq(3)").text();
				var practice_points = $(this).parents("tr").find("td:eq(4)").text();
				
				$("#scoreModifyModal #test_id").val(test_id);
				$("#scoreModifyModal #test_date").val(test_date);
				$("#scoreModifyModal #attendance_points").val(attendance_points);
				$("#scoreModifyModal #written_points").val(written_points);
				$("#scoreModifyModal #practice_points").val(practice_points);
			});
			
			$(".btnDelete").on("click", function() {
				var test_id = $(this).parents("tr").find("td:eq(0)").text();
				var test_date = $(this).parents("tr").find("td:eq(1)").text();
				var attendance_points = $(this).parents("tr").find("td:eq(2)").text();
				var written_points = $(this).parents("tr").find("td:eq(3)").text();
				var practice_points = $(this).parents("tr").find("td:eq(4)").text();
				
				$("#testDeleteModal #test_id").val(test_id);
				$("#testDeleteModal #test_date").val(test_date);
				$("#testDeleteModal #attendance_points").val(attendance_points);
				$("#testDeleteModal #written_points").val(written_points);
				$("#testDeleteModal #practice_points").val(practice_points);
			}); 
			
			/* 결과 모달 관련 */
			$("#btnDismiss").on("click", function() {
			   $("#resultModal").hide();
			});
			
			if ('${result}'=='success1') {
				$("#resultMessage").text("시험 등록에 성공했습니다.");
				$("#resultModal").show();
			}
			
			if ('${result}'=='fail1') {
			   	$("#resultMessage").text("시험 등록에 실패했습니다.");
			  	$("#resultModal").show();
			}
			if ('${result}'=='success2') {
				$("#resultMessage").text("시험 수정에 성공했습니다.");
				$("#resultModal").show();
			}
			
			if ('${result}'=='fail2') {
				$("#resultMessage").text("시험 수정에 실패했습니다.");
				$("#resultModal").show();
			}
			
			if ('${result}'=='success3') {
				$("#resultMessage").text("시험 삭제에 성공했습니다.");
				$("#resultModal").show();
			}
			
			if ('${result}'=='fail3') {
				$("#resultMessage").text("시험 삭제에 실패했습니다.");
				$("#resultModal").show();
			}
		});
	</script>

</body>

</html>
