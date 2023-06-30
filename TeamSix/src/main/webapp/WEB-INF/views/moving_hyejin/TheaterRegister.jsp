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
	<div class="container panel" style="margin-top:30px">
		<h3>영화관 등록</h3>
		<form action="${pageContext.request.contextPath}/hj/theaterreg.hj" method="post" id="theaterform">
		<fieldset>
			<div class="form-group">
				<label for="theatername">지 점 명</label>
				<input type="text" id="theatername" name="theatername" class="form-control">
			</div>
			<div class="form-group">
				<label for="location">위   치</label>
				<input type="text" id="location" name="location" class="form-control">
			</div>
			<div class="form-group">
				<label for="manager">담 당 자</label>
				<input type="text" id="manager" name="manager" class="form-control">
			</div>
			<div class="form-group">
				<label for="contactnum">연 락 처</label>
				<input type="text" id="contactnum" name="contactnum" class="form-control">
			</div>
			
			<div class="form-group text-right">
				<input type="submit" value="등록" class="btn btn-info" title="영화관을 등록합니다." />
				<input type="reset" value="취소" class="btn btn-default" title="등록을 취소합니다." />
				<a href="${pageContext.request.contextPath}/hj/theaterlist.hj" class="btn btn-default">목록보기</a>
			</div> 
		</fieldset>
		</form>
	</div>
</body>
<script>
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
</html>