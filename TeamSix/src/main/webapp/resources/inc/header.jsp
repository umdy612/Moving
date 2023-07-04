
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Faster+One&display=swap" rel="stylesheet">

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my.css">

</head>
<body>
	<div id="header">
		<h1 class="myhidden">MyCompany</h1>
		<nav class="navbar mybg_h">
			<h2 class="myhidden">주메뉴</h2>
			<div class="container main row">
				<div class="col-sm-1"></div>
				<div class="col-sm-3 mynav_l">
					<ul class="nav navbar-nav main">
						<li><a href="${pageContext.request.contextPath}/#">무비차트</a></li>
						<li><a href="${pageContext.request.contextPath}/#">영화예매</a></li>
					</ul>
				</div>
			
				<div class="navbar-header col-sm-4  mynav_c">
					<a class="main m1"
						href="${pageContext.request.contextPath}/PATH">MOVING</a>
					<img src="${pageContext.request.contextPath}/resources/images/moving.png" alt="moving" />
				</div>
				
				<div class="col-sm-4  mynav_r">
					<ul class="nav navbar-nav main navbar-right mynav_r">
						<!-- <li><a href="">회원가입</a></li>
						<li><a href="">로그인</a></li> -->
						
						<!--  -->
						
						 <li class="dropdown">
					         <a class="dropdown-toggle" data-toggle="dropdown" href="#">MY MOVING </a>
					         <ul class="dropdown-menu">
					           <li><a href="#">예매 내역</a></li>
					           <li><a href="#">자주가는 moving</a></li>
					           <li><a href="#">내가 쓴 댓글</a></li> 
					           <li><a href="#">회원 정보 수정</a></li> 
					         </ul>
				        </li>
						<li><a href="">로그아웃</a></li>
						
						<!--  -->
						
					</ul>
				</div>
			</div>
		</nav>
	</div>
<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>