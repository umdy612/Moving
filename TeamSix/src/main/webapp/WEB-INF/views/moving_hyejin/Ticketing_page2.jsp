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
		<div id="sidevar_num1">영화선택</div>   <!-- style="background-color:red;" -->
		<div id="sidevar_num2" style="background-color:rgb(150, 3, 0); color:white;">좌석선택</div>
		<div id="sidevar_num3">좌석결제</div>
	</div>
	<div class="col-sm-11">
	<h3>좌석 선택</h3>
		<div class="row cont2">
			<div class="col-sm-12 section-seat">
				<div class="col-head text-center">
					<p class="movie_title title">좌석 선택하기</p>
				</div>
				<div class="col-body myminfo">
					<div class="col-sm-3 myselect" >
						<p>영화 : ${movie.title}</p>
						<p>상영관 : ${room.roomname}</p>
						<p>관람일시 : ${schedule.screeningdate} / ${schedule.screeningtime}</p>
					</div>
					<div class="col-sm-2 btnline">
						<a class="btn btn-danger rechoice" href="${pageContext.request.contextPath}/hj/movierechoose.hj">영화 재선택</a>
					</div>
					<div class="col-sm-5 seattype">
						<p><span class="type1">성인</span> 
						<a class="btn btn-default typebtn" id="a_1">1명</a>
						<a class="btn btn-default typebtn" id="a_2">2명</a>
						<a class="btn btn-default typebtn" id="a_3">3명</a>
						<a class="btn btn-default typebtn" id="a_4">4명</a></p>
						
						<p><span class="type2">청소년</span> 
						<a class="btn btn-default typebtn" id="y_1">1명</a>
						<a class="btn btn-default typebtn" id="y_2">2명</a>
						<a class="btn btn-default typebtn" id="y_3">3명</a>
						<a class="btn btn-default typebtn" id="y_4">4명</a></p>
						
						<p><span class="type3">경로</span>
						<a class="btn btn-default typebtn" id="o_1">1명</a>
						<a class="btn btn-default typebtn" id="o_2">2명</a>
						<a class="btn btn-default typebtn" id="o_3">3명</a>
						<a class="btn btn-default typebtn" id="o_4">4명</a></p>
					</div>
					<div class="col-sm-2 btnline">
						<a class="btn btn-danger rechoice" href="${pageContext.request.contextPath}/hj/seatrechoose.hj">좌석 재선택</a>
					</div>
				</div>	
			</div>
		</div>
		<div class="row cont3">
			<div class="col-sm-11 section-graph">
				<div class="seatgraph">
					<div class="screen text-center">SCREEN</div>
					<div class="seatingchart">
						<c:forEach begin="1" end="${room.seat_row}" var="row" varStatus="status2">
							<div class="row" id="row${status2.count}">
								<c:forEach begin="1" end="${room.seat_col}" var="col" varStatus="status">
									<a class="btn btn-info seatbtn" id="${status2.count}-${status.count}"></a>
								</c:forEach>
							</div>
						</c:forEach>
					</div>
				</div>	
			</div>
				
			<div class="col-sm-1 status">
				<div class="seatstatus">
				
				</div>
				<div class="btnarea">
					<div class="nextbtn"></div>
				</div>
			</div>
			
		</div>
	</div>
</div>
</div>
<script>
	$(function(){
		var totalsum;
		var seatlist = [];
		
		$(".typebtn").on("click", function(){
			var id = $(this).attr("id");
			$(this).attr("class", "btn btn-warning");
			$(this).siblings('a').attr("class", "btn btn-default disabled");
			var seatalert; 
			//$(".seatbtn").attr("class", "btn btn-info");                      // type을 눌러야 활성화 
			
			$.ajax({
				url:"ticketing7.hj/"+id,
				type:"GET",
				dataType:"json",
				contentType:"application/json;charset=UTF-8",
				error:function(xhr, status, msg){alert(status + "/" + msg);},
				success:function(json){
					seatalert = json.seatalert;
					var collength = json.col.length;        //예매된 좌석의 갯수 
					totalsum = json.totalsum;               //현재 선택한 좌석의 수 
					if(seatalert != "") {                   //선택좌석>남은좌석일 경우, 경고문구 
						alert(seatalert);
						//다시 선택하도록//
					}  
					
					var col = []; var row = [];
					if(collength > 0){  // 이미 결제된 좌석이 있다면 해당좌석 비활성화
						for(var i=0; i<collength; i++) {
							col[i] = json.col[i];
							row[i] = json.row[i];
							$('#'+row[i]+'-'+col[i]).attr("class", "btn btn-default disabled seatbtn");
						}
					}
				}
			});
		})

		  $("body").on("click",".seatbtn", function(){
			var seatnum = $(this).attr("id");
			$(this).attr("class", "btn btn-danger seatbtnchoiced");
			
			seatlist.push(seatnum);
			totalsum -= 1; 
			
			if(totalsum == 0) {
				seatChoice(seatlist);			
			}
			
		});
	});
	
	function seatChoice(seatlist){
		$.ajax({
			url:"ticketing8.hj/"+seatlist,
			type:"GET",
			dataType:"json",
			contentType:"application/json;charset=UTF-8",
			error:function(xhr, status, msg){alert(status + "/" + msg);},
			success:function(json){
				$(".seatbtnchoiced").attr("class", "btn btn-danger disabled seatbtnchoiced");
				$(".seatbtn").attr("class", "btn btn-default disabled seatbtn");
				$("<p>").html($("<a class='btn btn-info nextpage' href='ticketing9.hj'>좌석결제</a>"))
				        .appendTo(".nextbtn");
			}
		});
	}
	
</script>


<%@ include file= "/resources/inc/footer.jsp" %>