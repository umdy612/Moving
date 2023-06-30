<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../inc/header.jsp" %>

<div class="container">
<div class="row cont1">
	<div class="container col-sm-1  sidebar1">
		<div class="row sidevar_num1" style="background-color:red;" ></div>   <!-- style="background-color:red;" -->
		<div class="row sidevar_num2"></div>
		<div class="row sidevar_num3"></div>
	</div>
	<div class="col-sm-11">
	<h3>영화 예매</h3>
	<div class="row cont2">
			<div class="col-sm-3 section-movie">
				<div class="col-head text-center">
					<p class="movie_title title">영 화</p>
				</div>
				<div class="col-body">
					<div class="movie_list list">
					영화리스트
					</div>
				</div>
			</div>
			
			<div class="col-sm-3 section-theater">
				<div class="col-head text-center">
					<p class="theater_title title">영 화 관</p>
				</div>
				<div class="col-body">
					<div class="theater_list list">
					</div>
				</div>
			</div>
			
			<div class="col-sm-2 section-date">
				<div class="col-head text-center">
					<p class="date_title title">날 짜</p>
				</div>
				<div class="col-body">
					<div class="date_list list">
					</div>
				</div>
			</div>
			
			<div class="col-sm-4 section-time">
				<div class="col-head text-center">
					<p class="time_title title">상영 시간표</p>
				</div>
				<div class="col-body">
					<div class="time_list list"></div>
				</div>
			</div>
	</div>
	</div>
</div>
</div>
	<script>
		$(function(){
			
		});
	</script>
	
<%@ include file= "../inc/footer.jsp" %>