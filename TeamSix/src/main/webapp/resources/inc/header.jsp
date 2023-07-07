<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- 추후 삽입 -->
<%-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel ="shortcuticon" href="${pageContext.request.contextPath}/images/pavicon.png" type="image/x-icon">
  <link rel ="icon"         href="${pageContext.request.contextPath}/images/pavicon.png" type="image/x-icon">  <!-- 사파리  --> --%>
<title>MOVING</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Faster+One&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my.css">
</head>
<body>
<c:set var="userid" value="${userid}"/>
<c:set var="admin" value="${admin}"/>
	<div id="header">	
		<h1 class="myhidden">MyCompany</h1>
		<nav class="navbar mybg_h">
			<h2 class="myhidden">주메뉴</h2>
			<div class="container main row">
				<div class="col-sm-1"></div>
				<div class="col-sm-3 mynav_l">
					<ul class="nav navbar-nav main">
						<li><a href="${pageContext.request.contextPath}/#">무비차트</a></li>
						<li><a href="${pageContext.request.contextPath}/hj/ticketing1.hj">영화예매</a></li>
					</ul>
				</div>
			
				<div class="navbar-header col-sm-4  mynav_c">
					<a class="main m1"
						href="${pageContext.request.contextPath}/PATH">MOVING</a>
					<img src="${pageContext.request.contextPath}/resources/images/moving.png" alt="moving" />
				</div>			  
				
				<div class="col-sm-4  mynav_r">
					<ul class="nav navbar-nav main navbar-right mynav_r">
					<c:if test="${signIn.userid == null}"> <!-- sessionParam. -->					
						 <li><a href="${pageContext.request.contextPath}/insert">회원가입</a></li>
						<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
					</c:if>					
						
					<c:if test="${signIn.userid != 'admin' && signIn.userid != null}">	<!-- sessionParam. -->					
						 <li class="dropdown">
					         <a class="dropdown-toggle" data-toggle="dropdown" href="#">MY MOVING </a>
					         <ul class="dropdown-menu">
					           <li><a href="${pageContext.request.contextPath}/hj/mypageticket.hj">예매 내역</a></li>
					           <li><a href="${pageContext.request.contextPath}/hj/mymovinglist.hj">자주가는 moving</a></li>
					           <li><a href="#">내가 쓴 댓글</a></li> 
					           <li><a href="${pageContext.request.contextPath}/update">회원 정보 수정</a></li>					            
					         </ul>
				        </li>         				
						<li><a href="${pageContext.request.contextPath}/logout">${signIn.userid}님 로그아웃</a></li>
					</c:if>
					
					<c:if test="${signIn.userid == 'admin'}">					
						 <li><a href="${pageContext.request.contextPath}/admin">회원관리</a></li>
						 <li><a href="${pageContext.request.contextPath}/logout">admin님 로그아웃</a></li>
					</c:if>												
					</ul>
				</div>
			</div>
		</nav>
	</div>