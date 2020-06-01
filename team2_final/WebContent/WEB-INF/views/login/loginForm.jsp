<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>쌍용교육센터</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading"><img
					src="${pageContext.request.contextPath}/resources/img/sist_logo_black.png">
                    </div>
                    <div class="panel-body">
                   
                    <form action="${pageContext.request.contextPath}/login/login" method="post">

 					<div>
                    	<div class="radio">
                    	<label><input type="radio" name="optradio" value="admin" checked>관리자</label>
                    	<label><input type="radio" name="optradio" value="instructor">강사</label>
                    	<label><input type="radio" name="optradio" value="student">수강생</label>
                    	</div>
                    </div>
						<div class="form-group">
							<input type="text" class="form-control" id="id_" name="id_"
								placeholder="ID(max:20)" required>
						</div>

						<div class="form-group">
							<input type="password" class="form-control" id="pw" name="pw"
								placeholder="PASSWORD(max:20)" required>
						</div>

						<button type="submit" class="btn btn-lg btn-success btn-block btnLogin">Login</button>

					</form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>

	<script>
		$(document).ready(function() {
	
		});
	</script>

</html>
