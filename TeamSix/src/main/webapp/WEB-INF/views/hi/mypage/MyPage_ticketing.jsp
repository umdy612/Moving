<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%>
<%@ include file= "/resources/inc/header.jsp" %>
<script>
	var ticketdelete = '${delete}';
	if(ticketdelete.length != 0){alert(ticketdelete);}
</script>
<div class="container panel" style="margin-top:30px; margin-bottom:100px">
	<div class="row">
		<div class="col-sm-2 panel panel-group panel-default">
			<h4 class="mypagehead panel-heading">My Moving</h4>
			<ul class="nav nav-pills nav-stacked">
				<li><a href="${pageContext.request.contextPath}/hj/mypageticket.hj" class="panel-body">예매내역</a></li>
				<li><a href="${pageContext.request.contextPath}/hj/mymovinglist.hj" class="panel-body">자주가는 Moving</a></li>
				<li><a href="#" class="panel-body">내가 쓴 댓글</a></li>
				<li><a href="#" class="panel-body">회원정보수정</a></li>
			</ul>
		</div>
		
		<div class="col-sm-10">
		<h3>나의 예매내역</h3>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">NO</th>
						<th scope="col">영화제목</th>
						<th scope="col">상영관</th>
						<th scope="col">관람날짜</th>
						<th scope="col">관람시간</th>
						<th scope="col">예매취소</th>
					</tr>
				</thead>
				<c:forEach var="list" items="${list}" varStatus="status" >
				<tbody>
					<tr>
						<td>${status.count}</td><td>${list.title}</td><td>${list.roomname}</td><td>${list.screeningdate}</td>
						<td>${list.screeningtime}</td>
						<td><a
						class="btn btn-default ticketdelete" id="ticketdelete${status.index}" data-role="${list.paysrn}">예매취소</a>
						<input type="hidden" id="paysrn${list.paysrn}" value="${list.paysrn}" >
						<input type="hidden" id="title${list.paysrn}" value="${list.title}" >
						<input type="hidden" id="roomname${list.paysrn}" value="${list.roomname}" >
						<input type="hidden" id="date${list.paysrn}" value="${list.screeningdate}" >
						<input type="hidden" id="time${list.paysrn}" value="${list.screeningtime}" >
						</td>
					</tr>
				</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
	<!-- 예매 취소 모달창 -->
				<div class="modal fade" id="ticketdeleteview" role="dialog">
					<div class="modal-dialog">
						<!-- 모달 콘텐츠  -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>예매 취소</h4>
							</div>
							<div class="modal-body">
								<form action="#" method="post" id="ticketdeleteform">
								<fieldset>
								<input type="hidden" id="mpsrn" name="mpsrn" value="" class="form-control ">
									<div class="form-group">
										<label for="mtitle">영화제목</label>
										<input type="text" id="mtitle" name="mtitle" value="" class="form-control" readonly>
									</div>
									<div class="form-group">
										<label for="mroom">상영관</label>
										<input type="text" id="mroom" name="mroom" value="" class="form-control" readonly>
									</div>
									<div class="form-group">
										<label for="mdate">관람일</label>
										<input type="text" id="mdate" name="mdate" value="" class="form-control" readonly>
									</div>
									<div class="checktable">
										<table class="table table-striped">
											<thead>
												<tr>
													<th scope="col">관객유형</th>
													<th scope="col">좌석</th>
													<th scope="col">관람인원</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</fieldset>
								</form>
							</div>
						<p>
							<a class="btn btn-info text-center" onClick="removeCheck()">예매취소</a>
						</p>
						</div>
					</div>
				</div>
	<!-- 예매 취소 모달창 -->
	<script>
		function removeCheck() {
			 var psrn = $("#mpsrn").val();
	    	 console.log(psrn);
		     if(confirm("예매를 취소하시겠습니까?") == true) {
		         location.href="myticketdelete.hj?paysrn="+psrn;
		      } else {
		         return false;
		      } 
		   } 
		$(function(){
			$(".ticketdelete").click(function(){
				var srn = $(this).attr("data-role");
				$.ajax({
					url:"ticketcheckdetail.hj/"+srn,
					type:"GET",
					dataType:"json",
					contentType:"application/json;charset=UTF-8",
					error:function(xhr, status, msg){alert(status + "/" + msg);},
					success:function ticketdeleteResult(json){
						
						$(".checktable tbody").empty();
						var total = json.result.length;
						
						$("#mpsrn").attr('value', $('#'+"paysrn"+srn).val());
						$("#mtitle").attr('value', $('#'+"title"+srn).val());
						$("#mroom").attr('value', $('#'+"roomname"+srn).val());
						$("#mdate").attr('value', $('#'+"date"+srn).val());
						
						if(total>1){
							for(var i=0; i<total; i++){
								$("<tr>")
								.append($("<td>").html(json.result[i].audience_type))
								.append($("<td>").html(json.result[i].seat))
								.append($("<td>").html(json.result[i].numbers))
								.appendTo(".checktable tbody");
							}
						} else {
							$("<tr>")
							.append($("<td>").html(json.result[0].audience_type))
							.append($("<td>").html(json.result[0].seat))
							.append($("<td>").html(json.result[0].numbers))
							.appendTo(".checktable tbody");
						}
						$("#ticketdeleteview").modal();
					}
				});
			});
		});
		
	</script>
	
<%@ include file= "/resources/inc/footer.jsp" %>