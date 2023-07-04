<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<script>
	var roominsert = '${roominsert}';
	if(roominsert.length != 0){alert(roominsert);}
	
	var roomupdate = '${roomupdate}';
	if(roomupdate.length != 0){alert(roomupdate);}
	
	var roomdelete = '${roomdelete}';
	if(roomdelete.length != 0){alert(roomdelete);}
</script>
	<div class="container panel" style="margin-top:30px">
		<h3>영화관 정보 수정</h3>
		<form action="${pageContext.request.contextPath}/hj/theateredit.hj" method="post" id="theaterform">
		<fieldset>
			<!--  srn 숨겨서 넘겨주기  -->	
			<input type="hidden" id="theatersrn"  name="theatersrn" value="${theater.theatersrn}"    class="form-control" /> 
			<div class="form-group">
				<label for="theatername">지 점 명</label>
				<input type="text" id="theatername" name="theatername" class="form-control" value="${theater.theatername}">
			</div>
			<div class="form-group">
				<label for="location">위   치</label>
				<input type="text" id="location" name="location" class="form-control" value="${theater.location}">
			</div>
			<div class="form-group">
				<label for="manager">담 당 자</label>
				<input type="text" id="manager" name="manager" class="form-control" value="${theater.manager}">
			</div>
			<div class="form-group">
				<label for="contactnum">연 락 처</label>
				<input type="text" id="contactnum" name="contactnum" class="form-control" value="${theater.contactnum}">
			</div>
			
			<div class="form-group">
				<table class="table table-striped">
				<caption>상영관 등록</caption>
					<thead>
						<tr>
							<th scope="col">NO</th>
							<th scope="col">이름</th>
							<th scope="col">좌석 행</th>
							<th scope="col">좌석 열</th>
							<th scope="col">수정</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="room" items="${room}" varStatus="status">
						<tr>
							<td>${status.count}</td><td>${room.roomname}</td><td>${room.seat_row}</td><td>${room.seat_col}</td>
							<td><a <%--href="${pageContext.request.contextPath}/hj/roomedit.hj?roomsrn=${room.roomsrn}" --%> 
							class="btn btn-default  editmodal" id="editmodal${status.index}" data-role="${status.index}">수정</a>
							<input type="hidden" id="srn${status.index}" value="${room.roomsrn}">
							<input type="hidden" id="name${status.index}" value="${room.roomname}">
							<input type="hidden" id="row${status.index}" value="${room.seat_row}">
							<input type="hidden" id="col${status.index}" value="${room.seat_col}">
							<input type="hidden" id="tsrn${status.index}" value="${room.theatersrn}">
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<a class="btn btn-info regmodal" >상영관 추가</a>
				</div>
			</div>
			
			<div class="form-group text-right">
				<input type="submit" value="수정" class="btn btn-info" title="영화관을 수정합니다." />
				<input type="button" value="삭제" class="btn btn-danger deletebtn" title="영화관을 삭제합니다." onclick="removeCheck()"/>
				<input type="reset" value="취소" class="btn btn-default" title="등록을 취소합니다." />
				<a href="${pageContext.request.contextPath}/hj/theaterlist.hj" class="btn btn-default">목록보기</a>
			</div> 
		</fieldset>
		</form>
	</div>
	<!-- 상영관 수정 모달창 -->
				<div class="modal fade" id="editview" role="dialog">
					<div class="modal-dialog">
						<!-- 모달 콘텐츠  -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>상영관 수정</h4>
							</div>
							<div class="modal-body">
								<form action="${pageContext.request.contextPath}/hj/roomedit.hj" method="post" id="roomform">
								<fieldset>
									<!--  srn 숨겨서 넘겨주기  -->	
									<input type="hidden" id="rsrn"  name="roomsrn" value=""    class="form-control  rsrn2" /> 
									<input type="hidden" id="thsrn"  name="theatersrn" value=""    class="form-control thsrn2" /> 
									<div class="form-group">
										<label for="roomname">상영관 이름</label>
										<input type="text" id="roomname" name="roomname" class="form-control" value="" >
									</div>
									<div class="form-group">
										<label for="seat_row">좌석 행</label>
										<input type="text" id="seat_row" name="seat_row" class="form-control" value="" >
									</div>
									<div class="form-group">
										<label for="seat_col">좌석 열</label>
										<input type="text" id="seat_col" name="seat_col" class="form-control" value="" >
									</div>
									<div class="form-group text-right">
										<input type="submit" value="수정" class="btn btn-info" title="상영관을 수정합니다." />
										<input type="button" value="삭제" class="btn btn-danger deletebtn" title="상영관을을 삭제합니다." id="roomdelete"/>
									</div>
								</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
		<!-- 상영관 수정 모달창 -->
		
		<!-- 상영관 추가 모달창 -->
		<div class="modal fade" id="regview" role="dialog">
					<div class="modal-dialog">
						<!-- 모달 콘텐츠  -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4>상영관 등록</h4>
							</div>
							<div class="modal-body">
								<form action="${pageContext.request.contextPath}/hj/roomreg.hj" method="post" id="regroomform">
								<!--  srn 숨겨서 넘겨주기  -->	
								<input type="hidden" id="regthsrn"  name="theatersrn" value="${theater.theatersrn}"    class="form-control" /> 
								<fieldset>
									<div class="form-group">
										<label for="regroomname">상영관 이름</label>
										<input type="text" id="regroomname" name="roomname" class="form-control">
									</div>
									<div class="form-group">
										<label for="regseat_row">좌석 행</label>
										<input type="text" id="regseat_row" name="seat_row" class="form-control">
									</div>
									<div class="form-group">
										<label for="regseat_col">좌석 열</label>
										<input type="text" id="regseat_col" name="seat_col" class="form-control">
									</div>
									<div class="form-group text-right">
										<input type="submit" value="등록" class="btn btn-info" title="상영관을 등록합니다." />
										<input type="reset" value="취소" class="btn btn-default" title="등록을 취소합니다." />
									</div>
								</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
		
		<!-- 상영관 추가 모달창 -->
	<script>	
	function removeCheck() {
	     if(confirm("영화관을 삭제하시겠습니까?") == true) {
	         location.href="theaterdelete.hj?theatersrn="+${theater.theatersrn};
	      } else {
	         return false;
	      } 
	   } 
	
	   
	$(function(){
		   $("#roomdelete").on("click", function(){
		       var RoomDelete = confirm("상영관을 삭제하시겠습니까?");

		        if(RoomDelete){
		           location.href="roomdelete.hj?theatersrn="+${theater.theatersrn}+"&roomsrn="+$("#rsrn").val();
		        }else{
		          //취소 버튼 클릭 false
		        	return false;
		        }
		   });
		});
	  
	
	$(function(){
		$("#theaterform").submit(function(){
			if($("#theatername").val() == ""){
				alert("지점명을 입력해주세요.");
				$("#theatername").focus();
				return false;
			}
			if($("#location").val() == ""){
				alert("위치를 입력해주세요.");
				$("#location").focus();
				return false;
			}
			if($("#manager").val() == ""){
				alert("담당자를 입력해주세요.");
				$("#manager").focus();
				return false;
			}
			if($("#contactnum").val() == ""){
				alert("연락처를 입력해주세요.");
				$("#contactnum").focus();
				return false;
			}
		});
		
		$("#roomform").submit(function(){
			if($("#roomname").val() == ""){
				alert("상영관명을 입력해주세요.");
				$("#theatername").focus();
				return false;
			}
			if($("#seat_row").val() == ""){
				alert("상영관 좌석 행을 입력해주세요.");
				$("#seat_row").focus();
				return false;
			}
			if($("#seat_col").val() == ""){
				alert("상영관 좌석 열을 입력해주세요.");
				$("#seat_col").focus();
				return false;
			}
		});
		
		$("#regroomform").submit(function(){
			if($("#regroomname").val() == ""){
				alert("상영관명을 입력해주세요.");
				$("#theatername").focus();
				return false;
			}
			if($("#regseat_row").val() == ""){
				alert("상영관 좌석 행을 입력해주세요.");
				$("#seat_row").focus();
				return false;
			}
			if($("#regseat_col").val() == ""){
				alert("상영관 좌석 열을 입력해주세요.");
				$("#seat_col").focus();
				return false;
			}
		});
	});
	
	$(document).ready(function(){
		
		var length = ${fn:length(room)};

		  $(".editmodal").click(function(){
			  
			var num = $(this).attr("data-role");
			
				 $("#rsrn").attr('value', $('#'+"srn"+num).val());
				 $("#thsrn").attr('value', $('#'+"tsrn"+num).val());
				 $("#roomname").attr('value', $('#'+"name"+num).val()); 
				 $("#seat_row").attr('value', $('#'+"row"+num).val());
				 $("#seat_col").attr('value', $('#'+"col"+num).val());
			    $("#editview").modal();
		  });
		  
		  $(".regmodal").click(function(){
			 $("#regview").modal(); 
		  });
		});
	</script>
</body>
</html>