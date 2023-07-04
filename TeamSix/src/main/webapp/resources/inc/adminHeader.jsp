<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Faster+One&display=swap" rel="stylesheet">

<!-- css --><%-- 
<link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/views/css/my.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my.css"> 
</head>
<body>
<div class="adminHeader">
	<div class="row">
		<div class="navbar-header col-sm-4  mynav_c">
			<a class="main m1" href="${pageContext.request.contextPath}/hi/adminMovie.hi">MOVING</a>
		</div>
		<div class="col-sm-8 row">
			<div class="col-sm-2"><a class="btn" href="${pageContext.request.contextPath}/hi/adminMovie.hi">영    화</a></div>
			<div class="col-sm-2"><a class="btn" href="${pageContext.request.contextPath}/moving/adminMain">영 화 관</a></div>
			<div class="col-sm-2"><a class="btn" href="${pageContext.request.contextPath}/moving/adminMain">상영스케줄</a></div>
			<div class="col-sm-2"><a class="btn" href="${pageContext.request.contextPath}/moving/adminMain">회원 관리</a></div>
			<div class="col-sm-2"></div>
			<div class="col-sm-2"><a class="btn" href="${pageContext.request.contextPath}/moving/adminMain">로그아웃</a></div>
		</div>
	</div>
</div>
