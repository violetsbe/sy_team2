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
							<span class="simple-text logo-normal" id="userId" >관리자 ${sessionScope.admin.owner_id}</span>

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
						<li class="active"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admim/book/list">기초정보관리</a></li>
						<li><a>></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/book/list">교재관리</a></li>
					</ul>
				</div>

			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12 content">
					<h2>교재 관리</h2>
					<!-- 	<div class="panel panel-default">
						<div class="panel-body">
							<h2>과목 관리</h2>
						</div>
					</div> -->
					<div class="panel panel-default">
						<!-- 	<div class="panel-heading">과목 관리 테이블</div> -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12 right">
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#addCourseModal">신규 교재 등록</button>
								</div>
							</div>

							<table class="table table-bordered table-hover"
								id="tableOpenSubject">
								<thead>
									<tr class="bgColor01">
										<th class="center col-md-3">교재 아이디</th>
										<th class="center col-md-4">교재명</th>
										<th class="center col-md-4">ISBN</th>
										<th class="center col-md-2">삭제</th>
									</tr>
								</thead>
								
								
								
								<tbody>
										<c:forEach var="b" items="${list}">
											<tr>
												<td class="center col-md-3">${b.book_id}</td>
											<td class="center" style="vertical-align: middle;"><a
												href="#" rel="${b.isbn}" data-toggle="popover"
												data-placement="left" data-html="true" class="pop1"
												data-content=''>${b.book_name}</a></td>
											<td class="center col-md-4">${b.isbn}</td>
										<td class="center">
											<button class="btn btn-defualt btn-primary btn-xs btnDelete" ${b.count_ == 0 ? "" : "disabled=\"disabled\""}
												data-toggle="modal" data-target="#deleteBookModal">삭제</button>
										</td>
											</tr>
										</c:forEach>
									</tbody>
								
							</table>
							<!-- /.table-responsive -->



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

	<!-- Modal 모달 관련 -->
	<div id="addCourseModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">신규 교재 등록</h4>
				</div>
				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/book/insert" method="post">
						<!-- 인터파크 -->
						<div class="form-group">
							<div class="panel-group">
								<div class="panel panel-default">
									<div class="panel-heading">도서 검색</div>
									<div class="panel-body">
										<form role="form" class="form-inline">
											<div class="col-md-3">
												<select class="form-control" id="book_key" name="book_key">
													<option value="title">책 제목</option>
													<option value="isbn">ISBN</option>
												</select>
											</div>
											<div class="col-md-7">
												<input type="text" class="form-control" id="book_value"
													name="book_value" required="required">
											</div>
											<!-- 주의) submit 버튼이 아니라, 일반 button으로 작성해야 합니다. -->
											<div class="col-md-2">
												<button type="button" id="btnSubmit" class="btn btn-default">검색</button>
											</div>

										</form>
									</div>
								</div>
							</div>


							<div class="panel panel-default" id="output">
								<div class="panel-heading">도서 검색 결과</div>
								<div class="panel-body">
									<button type="button" class="btn btn-default">
										TotalCount <span class="badge" id="totalcount">0</span>
									</button>
									<button type="button" class="btn btn-default">
										Count <span class="badge" id="count">0</span>
									</button>

									<!-- 인터파크 도서 검색 결과 출력할 위치 -->
									<div id="demo">

										<!-- 빈 화면 출력에 대한 초기 설정 -->
										<%-- <div class="row result">
						<div class="col-md-1">
							<span>1</span>
						</div>
						<div class="col-md-3">
							<img src="<%=path%>/resources/img/no-image.jpg" style="width:100%;">
						</div>
						<div class="col-md-6">
							<ul>
								<li>title : 제목 </li>
								<li>author : 저자</li>
								<li>publisher : 출판사</li>
								<li>description : 소개</li>
								<li>priceStandard : 정가</li>
								<li>pubDate : 출판일</li>
								<li>isbn : ISBN</li>
							</ul>
						</div>
						<div>
							<a
								href="http://book.interpark.com"
								class="btn btn-default btn-xs" target="_blank">인터파크 바로가기</a>
						</div>
					</div>  --%>

									</div>
									<button class="btn btn-default btn-block" id="btnMore">더보기</button>

								</div>
							</div>
						</div>


					</form>

				</div>
				<div class="modal-footer row">
					<div class="col-md-6 left">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
					<div class="col-md-6 right">
						<button type="submit" class="btn btn-default">등록</button>
					</div>
				</div>
			</div>

		</div>
	</div>



	<div id="deleteBookModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4 class="modal-title">교재 삭제</h4>
				</div>

				<div class="modal-body">
					<!-- 내용 -->
					<form action="${pageContext.request.contextPath}/admin/book/delete"  method="post">
						<div class="form-group">
							<label for="book_id">교재 아이디</label> <input type="text"
								class="form-control" id="book_id" name="book_id"
								placeholder="book_id" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="book_name">교재명</label> <input type="text"
								class="form-control" id="book_name" name="book_name"
								placeholder="book_name" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="book_isbn">ISBN</label> <input type="text"
								class="form-control" id="book_isbn" name="book_isbn"
								placeholder="book_isbn" readonly="readonly">
						</div>
						<div></div>
						<div>
							<br>현재 선택한 교재를 삭제하시겠습니까?

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

	<!-- jQuery -->
	<!-- 	<script src="../vendor/jquery/jquery.min.js"></script> -->

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


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
		var page = 1;
		var maxResults = 10;
		var book_key = "";
		var book_value = "";
		var txt = "";
		var index = 0;
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
					$('[data-toggle="popover"]').popover();
					
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

					

					$(".btnDelete")
							.on(
									"click",
									function() {
										var book_id = $(this).parents("tr")
												.find("td:eq(0)").text();
										var book_name = $(this).parents("tr")
												.find("td:eq(1)").text();
										var book_isbn = $(this).parents("tr")
												.find("td:eq(2)").text();
										$("#deleteBookModal #book_id").val(
												book_id);
										$("#deleteBookModal #book_name").val(
												book_name);
										$("#deleteBookModal #book_isbn").val(
												book_isbn);
									});

					//최초 실행서 더보기 버튼에 대한 비활성 처리
					$("#btnMore").attr("disabled", "disabled");

					//검색 버튼에 대한 click 이벤트 등록
					$("#btnSubmit").on(
							"click",
							function() {

								//검색 버튼을 클릭하는 경우 기존 검색 결과 초기화하는 과정
								index = 0;
								txt = "";
								count = 0;
								page = 1;
								$("#btnMore").removeAttr("disabled");

								//Ajax 요청을 위한 함수 호출
								loadDoc(page, $("#book_key").val(), $(
										"#book_value").val());
							});

					//더보기 버튼에 대한 click 이벤트 등록
					$(document).on(
							"click",
							"#btnMore",
							function() {
								//더보기 버튼에 저장할 새로운 페이지 번호 설정
								++page;
								$(this).val(page);
								//Ajax 요청을 위한 함수 호출
								loadDoc($(this).val(), $("#book_key").val(), $(
										"#book_value").val());
							});
				});

		function loadDoc(pageStart, book_key, book_value) {

			//jQuery load() 메소드를 이용한 Ajax 요청 및 응답 처리
			if (book_key != "" && book_value != "") {
				$("#demo")
						.load(
								"interpark_response.jsp",
								{
									pageStart : pageStart,
									maxResults : maxResults,
									book_key : book_key,
									book_value : book_value
								},
								function(a) {
									//서버로부터 응답받은 JSON 포맷 문자열을 콘솔 출력
									console.log(a);

									var doc = JSON.parse(a);
									var totalcount = doc.totalResults;
									var array = doc.item;
									for (var a = 0; a < array.length; ++a) {
										var temp = array[a];
										txt += "<div class='row result'>";
										txt += "<div class='col-md-1'><span>"
												+ (++index) + "</span></div>";
										txt += "<div class='col-md-3'><img src='"
												+ temp.coverLargeUrl
												+ "' style='width:100%;'></div>";
										txt += "<div class='col-md-6'>";
										txt += "<ul><li>title : " + temp.title
												+ " </li>";
										txt += "<li>author : " + temp.author
												+ " </li>";
										txt += "<li>publisher : "
												+ temp.publisher + " </li>";
										txt += "<li>description : "
												+ temp.description + " </li>";
										txt += "<li>priceStandard : "
												+ temp.priceStandard + " </li>";
										txt += "<li>pubDate : " + temp.pubDate
												+ " </li>";
										txt += "<li>isbn : " + temp.isbn
												+ " </li></ul>";
										txt += "</div><div>";
										txt += "<a href='"+temp.link+"'";
							txt += "class='btn btn-default btn-xs' target='_blank'>등록</a></div></div>";
									}
									//결과 문자열을 화면에 누적 출력
									$("#demo").html(txt);
									$("#totalcount").html(totalcount);
									$("#count").html(index);
								});
				
				
			}
		}
	</script>

</body>

</html>
