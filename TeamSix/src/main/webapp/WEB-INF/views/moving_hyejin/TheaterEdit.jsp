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
							<td>${status.index + 1}</td><td>${room.roomname}</td><td>${room.seat_row}</td><td>${room.seat_col}</td>
							<td><a href="${pageContext.request.contextPath}/hj/roomedit.hj?roomsrn=${room.roomsrn}" class="btn btn-default">수정</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<a href="${pageContext.request.contextPath}/hj/roomreg.hj?theatersrn=${theater.theatersrn}" class="btn btn-info" >상영관 추가</a>
				</div>
			</div>
			
			<div class="form-group text-right">
				<input type="submit" value="수정" class="btn btn-info" title="영화관을 수정합니다." />
				<input type="button" value="삭제" class="btn btn-danger deletebtn" title="영화관을 삭제합니다." onclick="removeCheck()" />
				<input type="reset" value="취소" class="btn btn-default" title="등록을 취소합니다." />
				<a href="${pageContext.request.contextPath}/hj/theaterlist.hj" class="btn btn-default">목록보기</a>
			</div> 
		</fieldset>
		</form>
	</div>
	<script>
	function removeCheck() {
	      if(confirm("영화관을 삭제하시겠습니까?") == true) {
	         location.href="theaterdelete.hj?theatersrn="+${theater.theatersrn};
	      } else {
	         return false;
	      }
	   }
	
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
	});
	</script>
</body>
</html>