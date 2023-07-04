<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%>
<%@ include file= "/resources/inc/header.jsp" %>

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
						<c:forEach var="list" items="${list}" varStatus="status">
						<p>
							<span class="mrating">${list.rating}</span> <button class="tmovie" style="border:none" data-role="${list.moviesrn}">${list.title}</button>
						</p>
						</c:forEach>
					</div>
				</div>
			</div>
			
			<div class="col-sm-2 section-theater">
				<div class="col-head text-center">
					<p class="theater_title title">영 화 관</p>
				</div>
				<div class="col-body">
					<div class="theater_list list">
						<div class="theaterchecklist">
							<c:forEach var="list" items="${theaterlist}" varStatus="status">
								<p>${list.theatername}</p>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-sm-3 section-date">
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
			$(".tmovie").on("click", function(){
				var moviesrn = $(this).attr("data-role");  //세션
				$.ajax({
					url:"ticketing2_theaterlist.hj/"+moviesrn,
					type:"GET",
					dataType:"json",
					contentType:"application/json;charset=UTF-8",
					error:function(xhr, status, msg){alert(status + "/" + msg);},
					success:function theaterlist(json){
						
						$(".theaterchecklist").empty();
						var total = json.result.length;
						
						 for(var i=0; i<total; i++){
							 $("<p>").html($("<button class='ttheater' style='border:none' data-role='"+json.result[i].theatersrn+"'>").html(json.result[i].theatername))
									 .appendTo(".theaterchecklist");
						} 
					}
				});
			});
			
			$("body").on("click", ".ttheater", function(){
				var theatersrn = $(this).attr("data-role"); //컨트롤러에서 세션에 저장해야되기 때문에 
				$.ajax({
					url:"ticketing3.hj/"+theatersrn,
					type:"GET",
					dataType:"json",
					contentType:"application/json;charset=UTF-8",
					error:function(xhr, status, msg){alert(status + "/" + msg);},
					success:function(json){
						
						$(".date_list").empty();
						var oneweek = json.weekdate.length;
						
						for(var i=0; i<oneweek; i++){
							$("<p>").html($("<button class='tdate' style='border:none' data-role='"+json.inputdate[i]+"'>").html(json.weekdate[i]))
									.appendTo(".date_list");
						}
					}
				}); 
			});
			
			$("body").on("click", ".tdate", function(){
				var inputdate = $(this).attr("data-role");
				$.ajax({
					url:"ticketing4.hj/"+inputdate,
					type:"GET",
					dataType:"json",
					contentType:"application/json;charset=UTF-8",
					error:function(xhr, status, msg){alert(status + "/" + msg);},
					success:function(json){
						
						$(".time_list").empty();
						
					}
				});
			});
		});
	</script>
	
<%@ include file= "/resources/inc/footer.jsp" %>