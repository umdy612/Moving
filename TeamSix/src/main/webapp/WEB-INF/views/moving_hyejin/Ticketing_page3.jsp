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
		<div id="sidevar_num2">좌석선택</div>
		<div id="sidevar_num3" style="background-color: rgb(150, 3, 0); color:white;" >좌석결제</div>
	</div>
	<div class="col-sm-11">
	<h3>좌석 결제</h3>
		<div class="row cont2">
			<div class="col-sm-12 section-pay">
				<div class="col-head text-center">
					<p class="pay_title title">결제하기</p>
				</div>
				<div class="col-body mypinfo">
					<div class="col-sm-2 selecposter">
						<p><img src="" alt="" /></p>
					</div>
					<div class="col-sm-3 mypselect" >
						<p>영화 : ${movie.title}</p>
						<p>상영관 : ${room.roomname}</p>
						<p>관람일시 : ${schedule.screeningdate} / ${schedule.screeningtime}</p>
						<p>선택좌석 : <c:forEach var="seat" items="${seatlist}" varStatus="status">[${seat}]   </c:forEach></p>
					</div>
					<div class="col-sm-2 btnline">
						<p><a class="btn btn-danger rechoice" href="${pageContext.request.contextPath}/hj/movierechoose.hj">영화 재선택</a></p>
						<p><a class="btn btn-danger rechoice" href="${pageContext.request.contextPath}/hj/seatrechoose.hj">좌석 재선택</a></p>
					</div>
					<div class="col-sm-5 comprice">
						<p class="tprice_name">최종 결제금액</p>
						<p class="totalprice">${totalprice} 원</p>
					</div>
				</div>	
			</div>
		</div>
		<div class="row cont3">
			<div class="col-sm-12 section-paymethod">
				<div class="col-head text-center">
					<p class="paymethod_title title">결제수단</p>
				</div>
				<div class="col-body selecmethod">
					<form action="${pageContext.request.contextPath}/hj/compayment.hj" method="post" id="paymentmethod">
					<div class="form-group">
						<label><input type="radio" name="paymentmethod" value="credit">신용카드</label>
						<label><input type="radio" name="paymentmethod" value="cash">무통장입금</label>
						<label><input type="radio" name="paymentmethod" value="kakao">카카오페이</label>
						<label><input type="radio" name="paymentmethod" value="naver">네이버페이</label>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-info" value="결제하기" >
					</div>
					</form>
				</div>	
			</div>
			
		</div>
	</div>
</div>
</div>

<script>
</script>


<%@ include file= "/resources/inc/footer.jsp" %>