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

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="${pageContext.request.contextPath}/vendor/morrisjs/morris.css" rel="stylesheet">

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
   font-weight:bold;
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
   margin-top: 20px;
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
                  <li class="active"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
               </ul>
            </div>
         </div>
         <div class="row">
            <div class="col-md-12" id="dashboard_title">
               <h2>ADMIN DASHBOARD<small id="today"></small></h2>
            </div>
         </div>
         <!-- /.row -->
         <div class="row">
            <div class="col-lg-6">
               <div class="panel panel-default">
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                      <div id="chart_div" style="width: 100%; height: 500px;"></div>
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel -->
            </div>
            <div class="col-lg-6">
               <div class="panel panel-default">
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                      <div id="piechart" style="width: 100%; height: 500px;"></div>
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel -->
            </div>
         </div>
         <!-- /.row -->
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

   <!-- Morris Charts JavaScript -->
   <script src="${pageContext.request.contextPath}/vendor/raphael/raphael.min.js"></script>
   <script src="${pageContext.request.contextPath}/vendor/morrisjs/morris.min.js"></script>
   <script src="${pageContext.request.contextPath}/data/morris-data.js"></script>

   <!-- Custom Theme JavaScript -->
   <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
   <!-- 구글API -->
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

   <script>
      google.charts.load('current', {
         'packages' : [ 'corechart' ]
      });
      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawVisualization);
      $(document).ready(function() {
        

         $(".btnLogout").on("click", function() {
            window.location.assign("${pageContext.request.contextPath}/login/logout");
         });
         $(".btnInfo").on("click", function() {
				window.location.assign("${pageContext.request.contextPath}/admin/info?owner_id="+$(this).val());
			});
         var now = new Date();

         var year= now.getFullYear();
         var mon = (now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
         var day = now.getDate()>9 ? ''+now.getDate() : '0'+now.getDate();
              
         var chan_val = year + '-' + mon + '-' + day;
         $("#today").text("(" + chan_val + " 기준)");
      });

      function drawChart() {

         var data = google.visualization.arrayToDataTable([
               [ 'Task', 'Hours per Day' ], 
               [ '과정중인 학생수(명)', 82 ],
               [ '중도포기 학생수(명)', 3 ] ]);

         var options = {
            title : '총학생 현황\n총학생수 : 85명',
            slices : {
               0 : {
                  color : '#20498c'
               },
               1 : {
                  color : '#7aabf9'
               }
            }
         };

         var chart = new google.visualization.PieChart(document
               .getElementById('piechart'));

         chart.draw(data, options);
      }

      function drawVisualization() {
         // Some raw data (not necessarily accurate)
         var data = google.visualization.arrayToDataTable([
               [ '강의실', '과정진행\n 현황(%)', '전체학생수(명)', '중도포기\n학생수(명)' ],
               [ '1강의실\n자바 전문가 과정\n2019.01.15 ~ 2019.08.23', 76.5, 25, 2 ],
               [ '2강의실\nJava&Python 기반\n웹개발자 과정\n2019.04.22 ~ 2019.11.21', 20, 25, 0 ],
               [ '3강의실\n사물 인터넷\n전문가 과정\n2019.05.11 ~ 2019.12.18', 50, 30, 1 ] ]);

         var options = {
            title : '강의실별 현황',
            vAxis : {
               maxValue : 100
            },
            seriesType : 'bars',
            series : {
               0 : {
                  color : '#7aabf9'
               },
               1 : {
                  color : '#20498c'
               },
               2 : {
                  color : '#8096aa'
               }
            }
         };

         var chart = new google.visualization.ComboChart(document
               .getElementById('chart_div'));
         chart.draw(data, options);
      }
   </script>
</body>

</html>