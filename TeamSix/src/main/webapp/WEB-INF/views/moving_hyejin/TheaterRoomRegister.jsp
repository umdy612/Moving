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
		<h3>상영관 등록</h3>
		<form action="${pageContext.request.contextPath}/hj/roomreg.hj" method="post" id="roomform">
		<!--  srn 숨겨서 넘겨주기  -->	
		<input type="hidden" id="theatersrn"  name="theatersrn" value="${param.theatersrn}"    class="form-control" /> 
		<fieldset>
			<div class="form-group">
				<label for="roomname">상영관 이름</label>
				<input type="text" id="roomname" name="roomname" class="form-control">
			</div>
			<div class="form-group">
				<label for="seat_row">좌석 행</label>
				<input type="text" id="seat_row" name="seat_row" class="form-control">
			</div>
			<div class="form-group">
				<label for="seat_col">좌석 열</label>
				<input type="text" id="seat_col" name="seat_col" class="form-control">
			</div>
			<div class="form-group text-right">
				<input type="submit" value="등록" class="btn btn-info" title="상영관을 등록합니다." />
				<input type="reset" value="취소" class="btn btn-default" title="등록을 취소합니다." />
				<a href="javascript:history.go(-1)" class="btn btn-default">이전</a>
			</div>
		</fieldset>
		</form>
	</div>
</body>
<script>
	$(function(){
		$("#roomform").submit(function(){
			if($("#roomname").val() == ""){
				alert("상영관 이름을 입력해주세요.");
				$("#roomname").focus();
				return false;
			}
			if($("#seat_row").val() == ""){
				alert("좌석 행을 입력해주세요.");
				$("#seat_row").focus();
				return false;
			}
			if($("#seat_col").val() == ""){
				alert("좌석 열을 입력해주세요.");
				$("#seat_col").focus();
				return false;
			}
		});
	});
</script>
</html>