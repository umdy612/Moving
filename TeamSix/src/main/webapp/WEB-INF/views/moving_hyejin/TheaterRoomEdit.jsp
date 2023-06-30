<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="container panel" style="margin-top:30px">
		<h3>상영관 정보 수정</h3>
		<form action="${pageContext.request.contextPath}/hj/roomedit.hj" method="post" id="roomform">
		<fieldset>
			<!--  srn 숨겨서 넘겨주기  -->	
			<input type="hidden" id="roomsrn"  name="roomsrn" value="${room.roomsrn}"    class="form-control" /> 
			<input type="hidden" id="theatersrn"  name="theatersrn" value="${room.theatersrn}"    class="form-control" /> 
			<div class="form-group">
				<label for="roomname">상영관 이름</label>
				<input type="text" id="roomname" name="roomname" class="form-control" value="${room.roomname}" >
			</div>
			<div class="form-group">
				<label for="seat_row">좌석 행</label>
				<input type="text" id="seat_row" name="seat_row" class="form-control" value="${room.seat_row}" >
			</div>
			<div class="form-group">
				<label for="seat_col">좌석 열</label>
				<input type="text" id="seat_col" name="seat_col" class="form-control" value="${room.seat_col}" >
			</div>
			<div class="form-group text-right">
				<input type="submit" value="수정" class="btn btn-info" title="상영관을 수정합니다." />
				<input type="button" value="삭제" class="btn btn-danger deletebtn" title="상영관을을 삭제합니다." onclick="removeCheck()" />
				<a href="javascript:history.go(-1)" class="btn btn-default">이전</a>
			</div>
		</fieldset>
		</form>
	</div>
	<script>
	function removeCheck() {
	      if(confirm("상영관을 삭제하시겠습니까?") == true) {
	         location.href="roomdelete.hj?roomsrn="+${room.roomsrn}+"&theatersrn="+${room.theatersrn};
	      } else {
	         return false;
	      }
	   }
	</script>
</body>
</html>