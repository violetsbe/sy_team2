<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="en">

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

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/morrisjs/morris.css"
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

/* -------테이블 관련------- */
.table {
	width: 80%;
	margin-top: 20px;
	word-wrap: break-word;
	word-break: keep-all;
}

th {
	text-align: center;
	vertical-align: center
}

td {
	text-align: center;
	vertical-align: center
}

#instructor_pic {
	width: 150px;
	height: 150px;
	float: left;
	margin-top: 20px
}

#pwChange {
	text-align: center;
}
/*-------상단 네비게이션 관련-------*/
.navbar-static-top {
	background-color: rgba(66, 139, 202, 0.9);
	color: #ffffff;
}

/*--------개인정보 조회 페이지 전용 시작--------*/
#profile_container {
	margin-bottom: 20px;
}

#userPic {
	margin-top: 20px;
	height: 100%;
}

#userPic img {
	max-width: 200px;
}

.details {
	list-style: none;
}

.details .one {
	width: 150px;
}
/*--------개인정보 조회 페이지 전용 끝--------*/
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
				<a href="${pageContext.request.contextPath}/students/studentdashboard"><img
					src="${pageContext.request.contextPath}/resources/img/sist_logo.png"></a><span>성적
					관리 시스템 v6.0</span>
				<!-- 성적 관리 시스템 v6.0 -->
			</div>
			<div class="navbar-default sidebar" role="navigation">
				<!-- ########### 사이드 바 시작 ########### -->
				<div class="sidebar-nav navbar-collapse">
					<!-- 현재 로그인한 유저 정보 표시부 -->
					<div class="logo">
						<div class="avatar">
							<img
								src="${pageContext.request.contextPath}/resources/img/hgd.jpg">
						</div>
						<div class="userInfo">
							<span class="simple-text logo-normal" id="userId">${student.student_name} 수강생</span><br>
							<button class="btn btn-default" id="sinformation">개인정보조회</button>
							<button class="btn btn-default logout" id="btnLogout">로그아웃</button>
						</div>
					</div>
					<ul class="nav" id="side-menu">
						<li><a
							href="${pageContext.request.contextPath}/students/studentOC">
								<i class="fa fa-table fa-fw"></i> 성적조회
						</a></li>
					</ul>

				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- ######## Navigation 네비게이션 끝 ######## -->


		<!--#page-wrapper -->
		<div id="page-wrapper">
			<!-- 페이지 본문 상단 네비게이션  -->
			<div class="row">
				<div class="" id="nav">
					<ul class="nav navbar-nav">
						<li><a
							href="${pageContext.request.contextPath}/students/studentdashboard">Home</a></li>
						<li><a>></a></li>
						<li><a
							href="${pageContext.request.contextPath}/students/studentinformation">개인정보조회</a></li>
					</ul>
				</div>
			</div>

			<div class="row content">
				<div class="col-md-12">
					<h2>개인 정보 조회</h2>
					<div class="panel panel-default">
						<div class="panel-body">

							<div id="profile_container" class="col-md-12">
								<div id="userPic" class="col-md-4">
									<!-- class="img-circle img-responsive" -->
									<img alt="User Pic"
										src="${pageContext.request.contextPath}/resources/img/person-placeholder.jpg"
										id="user_img" class="img-responsive">
								</div>
								<div id="userProfile" class="col-md-8">
									<div class="container">
										<h2>${list.student_name}</h2>
										<p>
											<b>수강생</b>
										</p>
									</div>
									<hr>
									<ul class="container details">
										<li><p>
												<span id="student_id" class="glyphicon glyphicon-user one">
													수강생아이디</span>${list.student_id}
											</p></li>
										<li><p>
												<span id="phone"
													class="glyphicon glyphicon-earphone one">전화번호</span>${list.phone}
											</p></li>
										<li><p>
												<span id="s_reg_date"
													class="glyphicon glyphicon-calendar one">등록일 </span>${list.s_reg_date}
											</p></li>
									</ul>
									<hr>

									<button class="btn btn-default" type="button"
										data-toggle="modal" data-target="#pwModifyModal">비밀번호
										수정</button>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- 비밀번호 변경 Modal 모달 관련 시작 -->
	<div id="pwModifyModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">비밀번호 변경</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/students/pwUpdate" method="post">
						<input type="hidden" id="student_id" name="student_id" value="${list.student_id}">
						<div class="form-group">
							<input type="password" class="form-control" id="student_Pw" name="student_Pw"
								placeholder="현재 비밀번호 입력 " required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="student_newPw"
								name="student_newPw" placeholder="새 비밀번호 입력" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="student_newPw02"
								name="student_newPw02" placeholder="새 비밀번호 확인" required>
						</div>
						<div class="row">
							<div class="col-md-6 left">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
							<div class="col-md-6 right">
								<button type="submit" class="btn btn-default" id="btnModifyPw">등록</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	
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
	<!-- 비밀번호 변경 Modal 모달 관련 끝 -->
	
	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<!-- 
	<script src="../vendor/raphael/raphael.min.js"></script>
	<script src="../vendor/morrisjs/morris.min.js"></script>
	<script src="../data/morris-data.js"></script>
 	-->
	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
	<script>
	$(document).ready(function() {
		
		$("#sinformation").on("click", function(){
			window.location.assign("${pageContext.request.contextPath}/students/studentinformation");
		});
		
        $("#btnLogout").on("click", function() {
      	  window.location.assign("${pageContext.request.contextPath}/login/logout");
        });
		
		/* 결과 모달 관련 */
		$("#btnDismiss").on("click", function() {
		   $("#resultModal").hide();
		});

		if ('${result}'=='success') {
		   $("#resultMessage").text("비밀번호 수정에 성공했습니다.");
		   $("#resultModal").show();
		}
		if ('${result}'=='fail') {
		   $("#resultMessage").text("비밀번호 수정에 실패했습니다.");
		   $("#resultModal").show();
		}
		
	});
	</script>
</body>

</html>
